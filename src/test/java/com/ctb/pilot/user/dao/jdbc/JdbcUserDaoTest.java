package com.ctb.pilot.user.dao.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ctb.pilot.user.model.User;

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
	public void testSignUp() throws FileNotFoundException {
		String userId = "jsp@naver.com";
		String password = "1234";
		String nickname = "jsp";
		String countryCode = "KR";
		InputStream image = new FileInputStream(
				"src/test/resources/samples/images/cushion_1.gif");
		userDao.signUp(userId, password, nickname, countryCode, image);
	}

	@Test
	public void update() {
		// int sequence = 1;
		int sequence = 2;
		String password = "12345";
		String nickname = "Johnny";
		String countryCode = "FR";

		User user = new User();
		user.setSequence(sequence);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setCountryCode(countryCode);

		userDao.update(user);
	}

	@Test
	public void testGetAllUsers() {
		List<User> allUsers = userDao.getAllUsers();
		System.out.println(allUsers);
	}

}
