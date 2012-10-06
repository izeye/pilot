<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Daily Visit List</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("table#daily_visit_log_list tr:even").css("background-color", "#F4F4F8");
		$("table#user_daily_visit_log_listlist tr:odd").css("background-color", "#FFFFFF");
	});
</script>
</head>
<body>
	<h3>Daily Visit List</h3>
	<table border=1 id="daily_visit_log_list">
		<tr>
			<th>Day</th><th>Count</th>
		</tr>
		<c:forEach var="dailyVisitLog" items="${requestScope.dailyVisitLogs}">
			<tr>
				<td>${dailyVisitLog.day}</td>
				<td>${dailyVisitLog.count}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>