package com.ctb.pilot.chat.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

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

	private ElizaMain eliza = new ElizaMain();
	private int elizaSequence;

	private boolean elizaInitialized = false;

	public ChatServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (!elizaInitialized) {
			String script = "/WEB-INF/script";
			ServletContext servletContext = getServletContext();
			InputStream is = servletContext.getResourceAsStream(script);
			eliza.readScript(is);

			UserDao userDao = new JdbcUserDao();
			User user = userDao.login("eliza@eliza.com", "1234");
			elizaSequence = user.getSequence();

			elizaInitialized = true;
		}

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
		String reply = eliza.processInput(message);
		messageDao.insertMessage(elizaSequence, reply);
	}

}
