package com.ctb.pilot.user.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.user.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class DefaultUserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testGetAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
	}
	
	@Test
	public void testGetAllStaff(){
		List<User> allStaff = userService.getAllStaff();
		System.out.println(allStaff);
	}

}
