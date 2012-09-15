<%@page import="com.ctb.pilot.chat.model.*,com.ctb.pilot.chat.dao.*,com.ctb.pilot.chat.dao.jdbc.*"%>
<%
	String userId = request.getParameter("user_id");
	String password = request.getParameter("password");
	String nickname = request.getParameter("nickname");
	
	if (userId == null || password == null || nickname == null
			|| userId.isEmpty() || password.isEmpty() || nickname.isEmpty()) {
		throw new Exception("Some field is null or empty.");
	}
	
	UserDao userDao = new JdbcUserDao();
	userDao.join(userId, password, nickname);
	
	response.sendRedirect("join_result.jsp");
%>
Completed!