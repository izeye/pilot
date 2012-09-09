package com.ctb.pilot.chat.dao.jdbc;

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

}
