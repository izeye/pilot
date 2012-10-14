package com.ctb.pilot.common.filter.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class SessionFromCookieFilterTest {

	@Autowired
	SessionFromCookieFilter filter;

	@Test
	public void doFilter() throws IOException, ServletException {
		Filter filter = new SessionFromCookieFilter();

		MockHttpServletRequest request = new MockHttpServletRequest();

		HttpSession session = new MockHttpSession();
		request.setSession(session);

		Cookie cookie = new Cookie("seq", "1");
		request.setCookies(cookie);

		ServletResponse response = new MockHttpServletResponse();

		FilterChain chain = new MockFilterChain();

		filter.doFilter(request, response, chain);
	}

}
