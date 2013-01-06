package com.ctb.pilot.user.dao.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;

@Repository("userDao")
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
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		return userMapper.getUserBySequence(sequence);
	}

	@Override
	public void signUp(String userId, String password, String nickname,
			InputStream image) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		userMapper.signUp(userId, password, nickname, image);
	}

	@Override
	public void update(User user) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		int sequence = user.getSequence();
		String password = user.getPassword();
		String nickname = user.getNickname();
		userMapper.update(sequence, password, nickname);
	}

	@Override
	public List<User> getAllUsers() {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		return userMapper.getAllUsers();
	}

	@Override
	public List<User> getAllStaff() {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		return userMapper.getAllStaff();
	}

	@Override
	public void signUpByFacebook(String userId, String nickname,
			String facebookUsername) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		userMapper.signUpByFacebook(userId, nickname, facebookUsername);
	}

}
