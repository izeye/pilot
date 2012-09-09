<%@page contentType="text/html; charset=utf8"%>
<%@page import="java.sql.*"%>
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
	Cookie cookie = new Cookie("seq", String.valueOf(userDao));
	cookie.setMaxAge(60 * 60 * 24 * 365);
	response.addCookie(cookie);
	
	response.sendRedirect("../chat/chat.jsp");
%>