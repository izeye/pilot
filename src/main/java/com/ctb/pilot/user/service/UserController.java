package com.ctb.pilot.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctb.pilot.user.model.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/services/admin/user/list_users_view.do")
	public String listUsers(HttpServletRequest request) {
		List<User> allUsers = userService.getAllUsers();
		request.setAttribute("users", allUsers);

		return "/services/admin/user/list_users_view";
	}
	
	@RequestMapping("/about_us.do")
	public String listStaff(Model model){
		List<User> allStaff = userService.getAllStaff();
		model.addAttribute("staff", allStaff);
		return "/view/jsp/about_us_view";
	}

}
