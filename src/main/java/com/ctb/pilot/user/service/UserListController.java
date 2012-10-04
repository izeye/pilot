package com.ctb.pilot.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserListController {

	@Autowired
	private UserService userService;

}
