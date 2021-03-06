package com.ctb.pilot.user.dao.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;
import com.ctb.pilot.util.image.model.Image;

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
	public User getUserByFacebookUsername(String facebookUsername) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		return userMapper.getUserByFacebookUsername(facebookUsername);
	}

	@Override
	public void signUp(String userId, String password, String nickname,
			String countryCode, InputStream image) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		userMapper.signUp(userId, password, nickname, countryCode, image);
	}

	@Override
	public void update(User user) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		int sequence = user.getSequence();
		String password = user.getPassword();
		String nickname = user.getNickname();
		String countryCode = user.getCountryCode();
		userMapper.update(sequence, password, nickname, countryCode);
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

	@Override
	public List<Image> getImage(String userSeq) {
		UserMapper mapper = sessionTemplate.getMapper(UserMapper.class);
		return mapper.getImage(userSeq);
	}

}
