package com.ctb.pilot.user.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String currentUrl = req.getParameter("current_url");
		HttpSession session = req.getSession();
		session.removeAttribute("user");

		Cookie cookie = new Cookie("seq", "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		resp.addCookie(cookie);

		resp.sendRedirect(currentUrl);
	}

}
