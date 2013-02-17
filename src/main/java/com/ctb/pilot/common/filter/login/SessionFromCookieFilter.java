package com.ctb.pilot.common.filter.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ctb.pilot.common.util.HttpUtils;
import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.dao.jdbc.JdbcUserDao;
import com.ctb.pilot.user.model.User;

public class SessionFromCookieFilter implements Filter {

	private UserDao userDao = new JdbcUserDao();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			String sequenceInCookie = HttpUtils.getCookie(httpRequest, "seq");
			if (sequenceInCookie != null && !sequenceInCookie.isEmpty()) {
				Integer userSequence = Integer.valueOf(sequenceInCookie);
				user = userDao.getUserBySequence(userSequence);
				session.setAttribute("user", user);
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
