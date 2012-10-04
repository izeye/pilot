package com.ctb.pilot.user.dao.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.model.User;

public class MyBatisUserDao implements UserDao {

	// private ThreadLocal<SqlSession> sqlSession = new
	// ThreadLocal<SqlSession>() {
	// @Override
	// protected SqlSession initialValue() {
	// try {
	// String resource = "mybatis-config.xml";
	// Reader reader = Resources.getResourceAsReader(resource);
	// SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
	// .build(reader);
	// // FIXME: Call sqlSession.close()?
	// return sqlSessionFactory.openSession();
	// } catch (IOException e) {
	// e.printStackTrace();
	// throw new RuntimeException(e);
	// }
	// }
	// };

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public User login(String userId, String password) {
		// UserMapper userMapper = sqlSession.get().getMapper(UserMapper.class);
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
