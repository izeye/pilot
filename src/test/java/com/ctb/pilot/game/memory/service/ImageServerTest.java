package com.ctb.pilot.game.memory.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.config.MainConfig;
import com.ctb.pilot.config.SocialConfig;
import com.ctb.pilot.game.memory.model.Image;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainConfig.class, SocialConfig.class })
public class ImageServerTest {

	@Resource(name = "gameImageService")
	private ImageService imageService;

	@Test
	public void getAllImages() {
		List<Image> allImages = imageService.getAllImages();
		for (Image image : allImages) {
			System.out.println(image);
			System.out.println(image.getPath());
		}
	}

}
