<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>User List</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
</head>
<body>
	<h3>User List</h3>
	<table class="table table-striped table-bordered table-hover table-condensed" id="user_list">
		<tr>
			<th>User ID</th><th>Join Date</th>
		</tr>
		<c:forEach var="user" items="${requestScope.users}">
			<tr>
				<td>${user.nickname}</td>
				<td><fmt:formatDate value="${user.joinDate}" type="both"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>