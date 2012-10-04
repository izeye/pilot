package com.ctb.pilot.user.dao;

import java.io.InputStream;
import java.util.List;

import com.ctb.pilot.user.model.User;

public interface UserDao {

	User login(String userId, String password);

	User getUserBySequence(int sequence);

	void signUp(String userId, String password, String nickname,
			InputStream image);

	void update(User user);

	List<User> getAllUsers();

}
