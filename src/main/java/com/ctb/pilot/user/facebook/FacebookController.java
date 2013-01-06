package com.ctb.pilot.user.facebook;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacebookController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final Facebook facebook;

	@Inject
	public FacebookController(Facebook facebook) {
		this.facebook = facebook;
	}

	@RequestMapping(value = "/services/facebook/friend_list.do", method = RequestMethod.GET)
	public String listFriends(Model model) {
		List<Reference> friends = facebook.friendOperations().getFriends();
		log.debug("friends: " + friends);
		model.addAttribute("friends", friends);

		return "view/jsp/facebook/friend_list";
	}

}
