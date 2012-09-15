package com.ctb.pilot.chat.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctb.pilot.chat.dao.MessageDao;
import com.ctb.pilot.chat.dao.jdbc.JdbcMessageDao;
import com.ctb.pilot.chat.model.Message;
import com.ctb.pilot.chat.model.User;

public class ChatServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int PAGE_SIZE = 20;

	private MessageDao messageDao = new JdbcMessageDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		System.out.println("In doGet(), requestURI: " + requestURI);

		String pageNoAsString = req.getParameter("page_no");
		int pageNo;
		if (pageNoAsString == null) {
			pageNo = 1;
		} else {
			pageNo = Integer.parseInt(pageNoAsString);
		}

		long total = messageDao.getAllMessageCount();
		long pageCount = total / PAGE_SIZE + (total % PAGE_SIZE != 0 ? 1 : 0);

		List<Message> messages = messageDao.getMessages(PAGE_SIZE, pageNo);
		req.setAttribute("messages", messages);
		req.setAttribute("pageNo", pageNo);
		req.setAttribute("pageCount", pageCount);

		String viewUri = "/common/web_template.jsp?body_path=/services/chat/chat_view.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewUri);
		dispatcher.forward(req, resp);
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
		if (message == null || message.isEmpty()) {
			throw new ServletException("Message is null or empty.");
		}

		messageDao.insertMessage(userSequence, message);

		resp.sendRedirect("/services/chat");
	}

}
