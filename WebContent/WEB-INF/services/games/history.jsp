<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>History (${requestScope.nickname})</title>
	</head>
	<body>
		<h3>History (${requestScope.nickname})</h3>
		<table border="1">
			<thead>
				<tr>
					<th>Play Time</th><th>Score</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${requestScope.entries}">
					<tr>
						<td><fmt:formatDate value="${entry.playTime}" type="both"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${entry.score}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>