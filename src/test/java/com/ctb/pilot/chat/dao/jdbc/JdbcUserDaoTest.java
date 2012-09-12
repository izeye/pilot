package com.ctb.pilot.chat.dao.jdbc;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ctb.pilot.chat.model.User;

public class JdbcUserDaoTest {

	private JdbcUserDao userDao;

	@Before
	public void setUp() {
		userDao = new JdbcUserDao();
	}

	@Test
	public void testLogin() {
		String userId = "izeye@naver.com";
		String password = "1234";
		User user = userDao.login(userId, password);
		System.out.println(user);
	}

	@Test
	public void testGetUserBySequence() {
		int sequence = 1;
		User user = userDao.getUserBySequence(sequence);
		System.out.println(user);
	}

	@Test
	public void testJoin() {
		String userId = "jsp@naver.com";
		String password = "1234";
		String nickname = "jsp";
		userDao.join(userId, password, nickname);
	}

	@Test
	public void testUpdate() {
		int sequence = 1;
		String password = "12345";
		String nickname = "Johnny";

		User user = new User();
		user.setSequence(sequence);
		user.setPassword(password);
		user.setNickname(nickname);

		userDao.update(user);
	}

	@Test
	public void testGetAllUsers() {
		List<User> allUsers = userDao.getAllUsers();
		System.out.println(allUsers);
	}

}
