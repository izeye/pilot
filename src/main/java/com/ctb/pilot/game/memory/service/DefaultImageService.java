package com.ctb.pilot.game.memory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.game.memory.dao.ImageDao;
import com.ctb.pilot.game.memory.model.Image;

@Service("gameImageService")
public class DefaultImageService implements ImageService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public List<Image> getAllImages() {
		return imageDao.getAllImages();
	}

}
