package com.ctb.pilot.user.dao.mybatis;

import org.apache.ibatis.annotations.Param;

import com.ctb.pilot.user.model.User;

public interface UserMapper {

	User login(@Param("userId") String userId,
			@Param("password") String password);

}
