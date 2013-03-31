package com.ctb.pilot.game.memory.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.game.memory.dao.ImageDao;
import com.ctb.pilot.game.memory.model.Image;

@Repository("imageDao")
public class ImageDaoMyBatis implements ImageDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public List<Image> getAllImages() {
		ImageMapper mapper = sessionTemplate.getMapper(ImageMapper.class);
		return mapper.getAllImages();
	}

}
