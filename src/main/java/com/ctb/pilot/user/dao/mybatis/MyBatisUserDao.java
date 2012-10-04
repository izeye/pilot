package com.ctb.pilot.user.dao.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;

public class MyBatisUserDao implements UserDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public User login(String userId, String password) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		return userMapper.login(userId, password);
	}

	@Override
	public User getUserBySequence(int sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signUp(String userId, String password, String nickname,
			InputStream image) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
