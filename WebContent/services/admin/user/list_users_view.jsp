<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>User List</title>
	</head>
	<body>
		<h3>User List</h3>
		<table border=1>
			<c:forEach var="user" items="${requestScope.users}">
				<tr>
					<td>${user.nickname}</td>
					<td><fmt:formatDate value="${user.joinDate}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>