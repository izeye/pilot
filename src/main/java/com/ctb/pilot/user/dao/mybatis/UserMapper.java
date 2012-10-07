package com.ctb.pilot.user.dao.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctb.pilot.user.model.User;

public interface UserMapper {

	User login(@Param("userId") String userId,
			@Param("password") String password);

	User getUserBySequence(int sequence);

	void signUp(@Param("userId") String userId,
			@Param("password") String password,
			@Param("nickname") String nickname,
			@Param("image") InputStream image);

	void update(@Param("sequence") int sequence,
			@Param("password") String password,
			@Param("nickname") String nickname);

	List<User> getAllUsers();

}