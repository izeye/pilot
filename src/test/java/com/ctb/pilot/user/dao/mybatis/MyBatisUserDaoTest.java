package com.ctb.pilot.user.dao.mybatis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class MyBatisUserDaoTest {

	@Autowired
	private UserDao userDao;

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
		InputStream iamge = new FileInputStream(
				"src/test/resources/samples/images/cushion_1.gif");
		userDao.signUp(userId, password, nickname, iamge);
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
