package com.ctb.pilot.user.facebook;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class PilotSignInAdapter implements SignInAdapter {

	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public String signIn(String userId, Connection<?> connection,
			NativeWebRequest request) {
		log.debug("userId: " + userId);

		SecurityContext.setCurrentUser(new User(userId));
		userCookieGenerator.addCookie(userId,
				request.getNativeResponse(HttpServletResponse.class));
		return null;
	}

}
