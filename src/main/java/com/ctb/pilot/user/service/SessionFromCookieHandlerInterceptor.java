package com.ctb.pilot.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ctb.pilot.common.util.HttpUtils;
import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;

public class SessionFromCookieHandlerInterceptor implements HandlerInterceptor {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.debug("SessionFromCookieHandlerInterceptor.preHandle() called.");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			String sequenceInCookie = HttpUtils.getCookie(httpRequest, "seq");
			if (sequenceInCookie != null) {
				Integer userSequence = Integer.valueOf(sequenceInCookie);
				user = userDao.getUserBySequence(userSequence);
				session.setAttribute("user", user);
			}
		}
		return true;
	}

}
