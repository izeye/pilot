package com.ctb.pilot.user.dao;

import java.io.InputStream;
import java.util.List;

import com.ctb.pilot.user.model.User;

public interface UserDao {

	User login(String userId, String password);

	User getUserBySequence(int sequence);

	User getUserByFacebookUsername(String facebookUsername);

	void signUp(String userId, String password, String nickname,
			InputStream image);

	void signUpByFacebook(String userId, String nickname,
			String facebookUsername);

	void update(User user);

	List<User> getAllUsers();

	List<User> getAllStaff();

}
