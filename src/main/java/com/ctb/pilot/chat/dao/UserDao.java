package com.ctb.pilot.chat.dao;

import java.util.List;

import com.ctb.pilot.chat.model.User;

public interface UserDao {

	User login(String userId, String password);

	User getUserBySequence(int sequence);

	void join(String userId, String password, String nickname);
	
	void update(User user);
	
	List<User> getAllUsers();

}
