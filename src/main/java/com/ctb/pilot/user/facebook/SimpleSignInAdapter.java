package com.ctb.pilot.user.facebook;

import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class SimpleSignInAdapter implements SignInAdapter {

	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();

	@Override
	public String signIn(String userId, Connection<?> connection,
			NativeWebRequest request) {
		SecurityContext.setCurrentUser(new User(userId));
		userCookieGenerator.addCookie(userId,
				request.getNativeResponse(HttpServletResponse.class));
		return null;
	}

}
