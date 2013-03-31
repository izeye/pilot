package com.ctb.pilot.user.dao.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctb.pilot.user.model.User;
import com.ctb.pilot.util.image.model.Image;

public interface UserMapper {

	User login(@Param("userId") String userId,
			@Param("password") String password);

	User getUserBySequence(int sequence);

	User getUserByFacebookUsername(String facebookUsername);

	void signUp(@Param("userId") String userId,
			@Param("password") String password,
			@Param("nickname") String nickname,
			@Param("countryCode") String countryCode,
			@Param("image") InputStream image);

	void signUpByFacebook(@Param("userId") String userId,
			@Param("nickname") String nickname,
			@Param("facebookUsername") String facebookUsername);

	void update(@Param("sequence") int sequence,
			@Param("password") String password,
			@Param("nickname") String nickname,
			@Param("countryCode") String countryCode);

	List<User> getAllUsers();

	List<User> getAllStaff();

	List<Image> getImage(String userSeq);

}
