<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Daily Visit Statistics</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("table#daily_visit_log_list tr:even").css("background-color", "#F4F4F8");
		$("table#daily_visit_log_list tr:odd").css("background-color", "#FFFFFF");
	});
</script>
</head>
<body>
	<h3>Daily Visit Statistics</h3>
	<table>
	<tr>
	<td width="35%">
	<table border=1 id="daily_visit_log_list">
		<tr>
			<th>Day</th><th>Count</th><th>&nbsp;</th><th>&nbsp;</th>
		</tr>
		<c:forEach var="dailyVisitLog" items="${requestScope.dailyVisitLogs}">
			<tr>
				<td>${dailyVisitLog.day}</td>
				<td>${dailyVisitLog.count}</td>
				<td>
					<a href="/services/admin/stat/list_daily_visit_ip_logs.do?day=${dailyVisitLog.day}"
							target="detail">IP Rank</a>
				</td>
				<td>
					<a href="/services/admin/stat/list_daily_visit_uri_logs.do?day=${dailyVisitLog.day}"
							target="detail">URI Rank</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</td>
	<td width="65%" height="100%"><iframe id="detail" width="100%" height="100%"></iframe></td>
	</tr>
	</table>
</body>
</html>