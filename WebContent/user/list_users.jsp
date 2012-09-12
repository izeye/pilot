<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.*"%>
<%@page import="com.ctb.pilot.chat.model.*,com.ctb.pilot.chat.dao.*,com.ctb.pilot.chat.dao.jdbc.*"%>
<%
	UserDao userDao = new JdbcUserDao();
	List<User> users = userDao.getAllUsers();
%>
<html>
	<head>
		<title>User List</title>
	</head>
	<body>
		<h1>User List</h1>
		<c:set var="users" value="<%= users %>"></c:set>
		<table border=1>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.nickname}</td>
					<td><fmt:formatDate value="${user.joinDate}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>