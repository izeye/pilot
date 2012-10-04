package com.ctb.pilot.user.dao.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.user.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class MyBatisUserDaoTest {

	@Autowired
	private MyBatisUserDao userDao;

	@Test
	public void testLogin() {
		String userId = "izeye@naver.com";
		String password = "1234";
		User user = userDao.login(userId, password);
		System.out.println(user);
	}

}
