package com.ctb.pilot.game.memory.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("gameImageController")
public class ImageController {

	@Resource(name = "gameImageService")
	private ImageService imageService;

	@RequestMapping("/services/game/memory/images.do")
	public String getAllImages() {
		return "";
	}

}
