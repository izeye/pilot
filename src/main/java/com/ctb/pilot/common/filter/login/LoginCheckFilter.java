package com.ctb.pilot.common.filter.login;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctb.pilot.user.model.User;

public class LoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			String encodedMessage = URLEncoder.encode(
					"You need to login first.", "utf8");
			httpResponse
					.sendRedirect("/common/web_template.jsp?body_path=/common/notice.jsp?message="
							+ encodedMessage);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
