<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>
<%@page import="com.ctb.pilot.chat.model.*,com.ctb.pilot.chat.dao.*,com.ctb.pilot.chat.dao.jdbc.*"%>
<%
	UserDao userDao = new JdbcUserDao();
	List<User> users = userDao.getAllUsers();
	request.setAttribute("users", users);
	RequestDispatcher dispatcher = request.getRequestDispatcher("list_users_view.jsp");
	dispatcher.forward(request, response);
%>
