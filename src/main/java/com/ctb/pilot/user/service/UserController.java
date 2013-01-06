package com.ctb.pilot.user.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ctb.pilot.common.model.Multipart;
import com.ctb.pilot.user.model.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/services/user/login.do")
	public void login(@RequestParam("user_id") String userId,
			@RequestParam("password") String password,
			@RequestParam("current_url") String currentUrl,
			HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		User user = userService.login(userId, password);
		System.out.println("user: " + user);
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			int sequence = user.getSequence();
			Cookie cookie = new Cookie("seq", String.valueOf(sequence));
			cookie.setMaxAge(60 * 60 * 24 * 365);
			cookie.setPath("/");
			resp.addCookie(cookie);
		}

		// FIXME:
		// Remove this code if possible.
		if (currentUrl.isEmpty()) {
			currentUrl = "/";
		}
		resp.sendRedirect(currentUrl);
	}

	@RequestMapping("/services/user/logout.do")
	public void logout(@RequestParam("current_url") String currentUrl,
			HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("user");

		Cookie cookie = new Cookie("seq", "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		resp.addCookie(cookie);

		resp.sendRedirect(currentUrl);
	}

	@RequestMapping("/services/user/sign-up.do")
	public void signUp(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Multipart multipart = new Multipart(req);
			String userId = multipart.getParameter("user_id");
			String password = multipart.getParameter("password");
			String nickname = multipart.getParameter("nickname");

			if (userId == null || password == null || nickname == null
					|| userId.isEmpty() || password.isEmpty()
					|| nickname.isEmpty()) {
				throw new ServletException("Some field is null or empty.");
			}

			// ServletContext application = req.getServletContext();
			// String realPath = application.getRealPath("/images/" + nickname
			// + ".jpg");
			// multipart.saveFile("imageFile", realPath);

			InputStream image = multipart.getInputStream("imageFile");

			userService.signUp(userId, password, nickname, image);
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		resp.sendRedirect("/common/web_template.jsp?body_path=/services/user/sign_up/sign_up_result.jsp");
	}

	@RequestMapping("/services/admin/user/list_users_view.do")
	public String listUsers(HttpServletRequest request) {
		List<User> allUsers = userService.getAllUsers();
		request.setAttribute("users", allUsers);

		return "/services/admin/user/list_users_view";
	}

	@RequestMapping("/about_us.do")
	public String listStaff(Model model) {
		List<User> allStaff = userService.getAllStaff();
		model.addAttribute("staff", allStaff);
		return "/view/jsp/about_us_view";
	}
	
	@RequestMapping(value="/services/user/sign-up-new.do",method=RequestMethod.POST)
	public String signUp(
			@RequestParam("user_id") String userId,
			@RequestParam("password") String password,
			@RequestParam("nickname") String nickName,
			@RequestParam("imageFile") MultipartFile multipartFile,
			Model model) throws IOException{
		System.out.println("multipartFileSize :: "+multipartFile.getSize());
		model.addAttribute("userId", userId);
		
		InputStream image = multipartFile.getInputStream();
		userService.signUp(userId, password, nickName, image);
		image.close();
		return "redirect:/common/web_template.jsp?body_path=/services/user/sign_up/sign_up_result.jsp";
	}
	
	@RequestMapping(value="/services/user/edit_profile.do", method=RequestMethod.POST)
	public String editProfile(
			@ModelAttribute User user 
			){
//			@RequestParam("user_id") String userId,
//			@RequestParam("current_password") String currentPassword,
//			@RequestParam("new_password") String newPassword,
//			@RequestParam("confirm_new_password") String confirmNewPassword,
//			@RequestParam("nickname") String nickname
//			){
//	    System.out.println("이리로 들어오니?");
//	    System.out.println("userId : " + userId);
//	    System.out.println("currentPassword : " + currentPassword);
//	    System.out.println("newPassword : " + newPassword);
//	    System.out.println("confirmNewPassword" + confirmNewPassword);
//	    System.out.println("nickname : " + nickname);
		
		System.out.println("여기로");
		System.out.println("user.getUserId() :: "+user.getUserId());
		return "redirect:/common/web_template.jsp?body_path=/services/user/profile/edit_profile_result.jsp";
	}

}
