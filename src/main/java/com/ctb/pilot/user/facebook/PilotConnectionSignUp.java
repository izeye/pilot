package com.ctb.pilot.user.facebook;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Component;

import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;

@Component("connectionSignUp")
public class PilotConnectionSignUp implements ConnectionSignUp {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private UserDao userDao;

	@Override
	public String execute(Connection<?> connection) {
		Facebook facebook = (Facebook) connection.getApi();
		FacebookProfile facebookProfile = facebook.userOperations()
				.getUserProfile();
		String username = facebookProfile.getUsername();
		String email = facebookProfile.getEmail();
		String name = facebookProfile.getName();

		log.debug("username: " + username);

		userDao.signUpByFacebook(email, name, username);
		User user = userDao.getUserByFacebookUsername(username);

		return Long.toString(user.getSequence());
	}

}
