package com.ctb.pilot.game.memory.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.config.MainConfig;
import com.ctb.pilot.config.SocialConfig;
import com.ctb.pilot.game.memory.model.Image;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainConfig.class, SocialConfig.class })
public class ImageDaoTest {

	@Autowired
	private ImageDao imageDao;

	@Test
	public void getAllImages() {
		List<Image> allImages = imageDao.getAllImages();
		for (Image image : allImages) {
			System.out.println(image);
			System.out.println(image.getPath());
		}
	}

}
