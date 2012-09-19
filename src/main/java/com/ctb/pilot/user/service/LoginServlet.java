package com.ctb.pilot.user.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.dao.jdbc.JdbcUserDao;
import com.ctb.pilot.user.model.User;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("user_id");
		String password = req.getParameter("password");
		String currentUrl = req.getParameter("current_url");
		System.out.println("currentUrl: " + currentUrl);

		UserDao userDao = new JdbcUserDao();
		User user = userDao.login(userId, password);
		System.out.println("user: " + user);
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			int sequence = user.getSequence();
			Cookie cookie = new Cookie("seq", String.valueOf(sequence));
			cookie.setMaxAge(60 * 60 * 24 * 365);
			cookie.setPath("/");
			resp.addCookie(cookie);
		}

		// FIXME:
		// Remove this code if possible.
		if (currentUrl.isEmpty()) {
			currentUrl = "/";
		}
		resp.sendRedirect(currentUrl);
	}

}
