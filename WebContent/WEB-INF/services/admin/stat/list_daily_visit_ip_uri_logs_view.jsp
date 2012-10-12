<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Daily Visit IP Statistics</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("table#daily_visit_ip_log_list tr:even").css("background-color", "#F4F4F8");
		$("table#daily_visit_ip_log_list tr:odd").css("background-color", "#FFFFFF");
	});
</script>
</head>
<body>
	<h3>${requestScope.day} ${uri} Visit IP Statistics</h3>
	<table border=1 id="daily_visit_ip_log_list">
		<tr>
			<th>Rank</th><th>IP</th><th>Count</th><th>Location</th>
		</tr>
		<c:forEach var="dailyVisitIpLog" varStatus="status" items="${requestScope.dailyVisitIpLogs}">
			<tr>
				<td>${status.count}</td>
				<td>${dailyVisitIpLog.ip}</td>
				<td>${dailyVisitIpLog.count}</td>
				<td>
					${dailyVisitIpLog.whois.countryCode}/
					<c:choose>
					<c:when test="${dailyVisitIpLog.whois.koreanUserAddr != null}">
						${dailyVisitIpLog.whois.koreanUserAddr}/${dailyVisitIpLog.whois.koreanUserOrgName}
					</c:when>
					<c:otherwise>
						${dailyVisitIpLog.whois.koreanIspAddr}/${dailyVisitIpLog.whois.koreanIspOrgName}
					</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>