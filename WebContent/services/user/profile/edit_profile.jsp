<%@page contentType="text/html; charset=utf8" errorPage="../common/error.jsp"%>
<%@page import="com.ctb.pilot.chat.model.*,com.ctb.pilot.chat.dao.*,com.ctb.pilot.chat.dao.jdbc.*"%>
<%
	User user = (User) session.getAttribute("user");

	request.setCharacterEncoding("utf8");
	String password = user.getPassword();
	String currentPassword = request.getParameter("current_password");
	if (!password.equals(currentPassword)) {
		throw new Exception("Current password is incorrect.");
	}
	String newPassword = request.getParameter("new_password");
	if (newPassword != null && !newPassword.isEmpty()) {
		user.setPassword(newPassword);
	}
	String nickname = request.getParameter("nickname");
	user.setNickname(nickname);
	
	UserDao userDao = new JdbcUserDao();
	userDao.update(user);
	response.sendRedirect("edit_profile_result.jsp");
%>