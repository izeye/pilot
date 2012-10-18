<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Daily Visit URI Statistics</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
		<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h3>${requestScope.day} Visit URI Statistics</h3>
	<table class="table table-striped table-bordered table-hover table-condensed" id="daily_visit_uri_log_list">
		<tr>
			<th>Rank</th><th>URI</th><th>Count</th>
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