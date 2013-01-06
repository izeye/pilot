package com.ctb.pilot.user.facebook;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;

public class SimpleConnectionSignUp implements ConnectionSignUp {

	private final AtomicLong userIdSequence = new AtomicLong();

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public String execute(Connection<?> connection) {
		Facebook facebook = (Facebook) connection.getApi();
		FacebookProfile facebookProfile = facebook.userOperations()
				.getUserProfile();
		String username = facebookProfile.getUsername();
		String email = facebookProfile.getEmail();
		String name = facebookProfile.getName();

		log.debug("username: " + username);

		return Long.toString(userIdSequence.incrementAndGet());
	}

}
