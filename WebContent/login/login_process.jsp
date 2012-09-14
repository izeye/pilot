<%@page contentType="text/html; charset=utf8"%>
<%@page import="com.ctb.pilot.chat.model.*,com.ctb.pilot.chat.dao.*,com.ctb.pilot.chat.dao.jdbc.*"%>
<%
	String userId = request.getParameter("user_id");
	String password = request.getParameter("password");
	
	UserDao userDao = new JdbcUserDao();
	User user = userDao.login(userId, password);
	int sequence = user.getSequence();
	String nickname = user.getNickname();

	session.setAttribute("seq", sequence);
	session.setAttribute("nickname", nickname);
	Cookie cookie = new Cookie("seq", String.valueOf(sequence));
	cookie.setMaxAge(60 * 60 * 24 * 365);
	cookie.setPath("/");
	response.addCookie(cookie);
	
	response.sendRedirect("../chat");
%>