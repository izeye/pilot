<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>
<%@page import="com.ctb.pilot.user.model.*,com.ctb.pilot.user.dao.*,com.ctb.pilot.user.dao.jdbc.*"%>
<%
	UserDao userDao = new JdbcUserDao();
	List<User> users = userDao.getAllUsers();
	request.setAttribute("users", users);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/common/web_template.jsp?body_path=/services/admin/user/list_users_view.jsp");
	dispatcher.forward(request, response);
%>
