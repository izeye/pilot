<%@page import="com.ctb.pilot.user.model.*,com.ctb.pilot.user.dao.*,com.ctb.pilot.user.dao.jdbc.*"%>
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
	
	response.sendRedirect("/common/web_template.jsp?body_path=/services/user/sign_up/sign_up_result.jsp");
%>
Completed!