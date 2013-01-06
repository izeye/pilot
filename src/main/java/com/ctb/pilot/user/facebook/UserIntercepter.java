package com.ctb.pilot.user.facebook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

public class UserIntercepter extends HandlerInterceptorAdapter {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final UsersConnectionRepository connectionRepository;

	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();

	public UserIntercepter(UsersConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.debug("preHandle()");

		rememberUser(request, response);
		handleSignOut(request, response);
		if (SecurityContext.userSignedIn() || requestForSignIn(request)) {
			return true;
		} else {
			return requireSignIn(request, response);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.debug("afterCompletion()");

		SecurityContext.remove();
	}

	private void rememberUser(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = userCookieGenerator.readCookieValue(request);
		if (userId == null) {
			return;
		}
		if (!userNotFound(userId)) {
			userCookieGenerator.removeCookie(response);
			return;
		}
		SecurityContext.setCurrentUser(new User(userId));
	}

	private void handleSignOut(HttpServletRequest request,
			HttpServletResponse response) {
		if (SecurityContext.userSignedIn()
				&& request.getServletPath().startsWith("/signout")) {
			connectionRepository.createConnectionRepository(
					SecurityContext.getCurrentUser().getId())
					.removeConnections("facebook");
			userCookieGenerator.removeCookie(response);
			SecurityContext.remove();
		}
	}

	private boolean requestForSignIn(HttpServletRequest request) {
		return request.getServletPath().startsWith("/signin");
	}

	private boolean requireSignIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.debug("requireSignIn()");

		new RedirectView("/signin", true).render(null, request, response);
		return false;
	}

	private boolean userNotFound(String userId) {
		return connectionRepository.createConnectionRepository(userId)
				.findPrimaryConnection(Facebook.class) != null;
	}

}
