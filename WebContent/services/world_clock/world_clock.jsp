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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("table#world_clock tr:even").css("background-color", "#F4F4F8");
		$("table#world_clock tr:odd").css("background-color", "#FFFFFF");
	});
</script>
</head>
<body>
	<h3>World Clock</h3>
	<c:set var="now" value="<%=new Date()%>" />
	<c:set var="timeZoneIds" value="<%=TimeZone.getAvailableIDs()%>" />
	<table class="data" border="1" id="world_clock">
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