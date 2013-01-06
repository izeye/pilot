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

import com.ctb.pilot.config.MainConfig;
import com.ctb.pilot.config.SocialConfig;
import com.ctb.pilot.config.WebMvcConfig;
import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = "/applicationContext.xml")
@ContextConfiguration(classes = { MainConfig.class, WebMvcConfig.class,
		SocialConfig.class })
public class MyBatisUserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void login() {
		String userId = "izeye@naver.com";
		String password = "1234";
		User user = userDao.login(userId, password);
		System.out.println(user);
	}

	@Test
	public void getUserBySequence() {
		int sequence = 1;
		User user = userDao.getUserBySequence(sequence);
		System.out.println(user);
	}

	@Test
	public void signUp() throws FileNotFoundException {
		String userId = "jsp@naver.com";
		String password = "1234";
		String nickname = "jsp";
		InputStream iamge = new FileInputStream(
				"src/test/resources/samples/images/cushion_1.gif");
		userDao.signUp(userId, password, nickname, iamge);
	}

	@Test
	public void update() {
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
	public void getAllUsers() {
		List<User> allUsers = userDao.getAllUsers();
		System.out.println(allUsers);
	}

	@Test
	public void getAllStaff() {
		List<User> allStaff = userDao.getAllStaff();
		System.out.println(allStaff);
	}

	@Test
	public void signUpByFacebook() {
		String userId = "userId";
		String nickname = "nickname";
		String facebookUsername = "facebookUsername";
		userDao.signUpByFacebook(userId, nickname, facebookUsername);
	}

}
