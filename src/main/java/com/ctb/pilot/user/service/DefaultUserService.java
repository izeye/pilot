package com.ctb.pilot.user.service;

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
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<User> getAllStaff() {
		return userDao.getAllStaff();
	}

}
