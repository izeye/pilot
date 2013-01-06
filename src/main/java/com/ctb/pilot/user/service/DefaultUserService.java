package com.ctb.pilot.user.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;

@Service("userService")
public class DefaultUserService implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(String userId, String password) {
		return userDao.login(userId, password);
	}

	@Override
	public User getUserBySequence(int sequence) {
		return userDao.getUserBySequence(sequence);
	}
	
	@Override
	public void signUp(String userId, String password, String nickname,
			InputStream image) {
		userDao.signUp(userId, password, nickname, image);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<User> getAllStaff() {
		return userDao.getAllStaff();
	}

	@Override
	public User getUserByFacebookUsername(String facebookUsername) {
		// TODO Auto-generated method stub
		return null;
	}

}
