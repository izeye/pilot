package com.ctb.pilot.util.image.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.util.image.dao.ImageDao;
import com.ctb.pilot.util.image.model.Image;

@Repository("imageDao")
public class MyBatisImageDao implements ImageDao {
	@Autowired
	private SqlSession sessionTemplate;
	
	@Override
	public List<Image> getImage(String userSeq) {
		
		ImageMapper mapper = sessionTemplate.getMapper(ImageMapper.class);

		return mapper.getImage(userSeq);
	}

}
