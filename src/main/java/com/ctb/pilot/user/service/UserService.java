package com.ctb.pilot.user.service;

import java.io.InputStream;
import java.util.List;

import com.ctb.pilot.user.model.User;

public interface UserService {

	User login(String userId, String password);

	User getUserBySequence(int sequence);

	User getUserByFacebookUsername(String facebookUsername);

	void signUp(String userId, String password, String nickname,
			InputStream image);

	void update(User user);

	List<User> getAllUsers();

	List<User> getAllStaff();

}
