<%@page contentType="text/html; charset=utf8"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>World Clock</title>
		<style type="text/css">
			table {
				border-spacing: 0;
				border-collapse: collapse;
			}
			
			table td,table th {
				padding: 2px;
			}
		</style>
	</head>
	<body>
		<c:set var="now" value="<%= new Date() %>" />
		<c:set var="timeZoneIds" value="<%= TimeZone.getAvailableIDs() %>" />
		<table border="1">
			<tr><th>Time Zone ID</th><th>Time</th>
		<c:forEach var="timeZoneId" items="${timeZoneIds}">
			<tr>
			<fmt:timeZone value="${timeZoneId}">
				<td>${timeZoneId}</td>
				<td><fmt:formatDate value="${now}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</fmt:timeZone>
			</tr>
		</c:forEach>
		</table>
	</body>
</html>