<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Daily Visit URI Statistics</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("table#daily_visit_uri_log_list tr:even").css("background-color", "#F4F4F8");
		$("table#daily_visit_uri_log_list tr:odd").css("background-color", "#FFFFFF");
	});
</script>
</head>
<body>
	<h3>${requestScope.day} Visit URI Statistics</h3>
	<table border=1 id="daily_visit_uri_log_list">
		<tr>
			<th>Rank</th><th>IP</th><th>Count</th>
		</tr>
		<c:forEach var="dailyVisitUriLog" varStatus="status" items="${requestScope.dailyVisitUriLogs}">
			<tr>
				<td>${status.count}</td>
				<td>${dailyVisitUriLog.uri}</td>
				<td>${dailyVisitUriLog.count}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>