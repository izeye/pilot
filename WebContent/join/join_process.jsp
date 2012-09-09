<%@page import="com.ctb.pilot.chat.model.*,com.ctb.pilot.chat.dao.*,com.ctb.pilot.chat.dao.jdbc.*"%>
<%
	String userId = request.getParameter("user_id");
	String password = request.getParameter("password");
	String nickname = request.getParameter("nickname");
	
	UserDao userDao = new JdbcUserDao();
	userDao.join(userId, password, nickname);
%>
Completed!