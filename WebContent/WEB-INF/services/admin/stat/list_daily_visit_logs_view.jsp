<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Daily Visit Statistics</title>
</head>
<body>
	<h3>Daily Visit Statistics</h3>
	<table width="100%">
	<tr>
	<td width="40%">
	<table class="table table-striped table-bordered table-hover table-condensed" id="daily_visit_log_list">
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
	<td width="65%" height="100%"><iframe id="detail" name="detail" width="100%" height="100%"></iframe></td>
	</tr>
	</table>
</body>
</html>