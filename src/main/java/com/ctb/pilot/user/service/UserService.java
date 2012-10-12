package com.ctb.pilot.user.service;

import java.util.List;

import com.ctb.pilot.user.model.User;

public interface UserService {

	List<User> getAllUsers();
	List<User> getAllStaff();

}
