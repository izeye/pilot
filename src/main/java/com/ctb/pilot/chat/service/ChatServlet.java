package com.ctb.pilot.chat.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctb.pilot.chat.dao.MessageDao;
import com.ctb.pilot.chat.dao.jdbc.JdbcMessageDao;
import com.ctb.pilot.chat.model.Message;
import com.ctb.pilot.common.util.JsonUtils;
import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.dao.jdbc.JdbcUserDao;
import com.ctb.pilot.user.model.User;

import eliza.ElizaMain;

public class ChatServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int PAGE_SIZE = 20;

	private MessageDao messageDao = new JdbcMessageDao();
	private UserDao userDao = new JdbcUserDao();

	private Map<Integer, ElizaMain> elizaMap = new HashMap<Integer, ElizaMain>();
	private int elizaSequence;

	public ChatServlet() {
		UserDao userDao = new JdbcUserDao();
		User elizaUser = userDao.login("eliza@eliza.com", "1234");
		elizaSequence = elizaUser.getSequence();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		System.out.println("In doGet(), requestURI: " + requestURI);

		List<Message> messages = messageDao.getMessages(PAGE_SIZE, 1);
		resp.setCharacterEncoding("utf8");
		PrintWriter out = resp.getWriter();
		String json = JsonUtils.toJson(messages);
		System.out.println(json);
		out.print(json);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		System.out.println("In doPost(), requestURI: " + requestURI);

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int userSequence = user.getSequence();

		req.setCharacterEncoding("utf8");
		String message = req.getParameter("message");
		System.out.println("message: " + message);
		if (message == null || message.isEmpty()) {
			throw new ServletException("Message is null or empty.");
		}

		messageDao.insertMessage(userSequence, message);

		if (message.startsWith("@Eliza ")) {
			ElizaMain eliza = elizaMap.get(userSequence);
			if (eliza == null) {
				eliza = new ElizaMain();

				String script = "/WEB-INF/eliza/script";
				ServletContext servletContext = getServletContext();
				InputStream is = servletContext.getResourceAsStream(script);
				eliza.readScript(is);

				elizaMap.put(userSequence, eliza);
			}

			String nickname = user.getNickname();
			message = message.substring("@Eliza ".length());
			String reply = "@" + nickname + " " + eliza.processInput(message);
			messageDao.insertMessage(elizaSequence, reply);
		}
	}

}
