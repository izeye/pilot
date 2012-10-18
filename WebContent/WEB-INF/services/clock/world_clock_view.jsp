<%@page contentType="text/html; charset=utf8"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>World Clock</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
</head>
<body>
	<h3>World Clock</h3>
	<table class="table table-striped table-bordered table-hover table-condensed" id="world_clock">
		<tr>
			<th>Time Zone ID</th>
			<th>Time</th>
			<c:forEach var="timeZoneId" items="${timeZoneIds}">
				<tr>
					<fmt:timeZone value="${timeZoneId}">
						<td>${timeZoneId}</td>
						<td><fmt:formatDate value="${now}" type="both"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</fmt:timeZone>
				</tr>
			</c:forEach>
	</table>
</body>
</html>