<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="com.ctb.pilot.stat.dao.jdbc.JdbcVisitLogDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일별 방문 통계</title>
</head>
<body>
<h3>일별 방문 통계</h3>
<table border="1">
	<tr>
		<th>IP</th>
		<th>COUNT</th>
	</tr>
	<%
		JdbcVisitLogDao jvld = new JdbcVisitLogDao();
		Map<String, Long> m = jvld.getVisitTodayStatByIP();
		Iterator<String> it = m.keySet().iterator();
		while(it.hasNext()) {
			String ip = it.next();
			%>
		<tr>
			<td>
				<%= ip %>
			</td>
			<td>
				<%=m.get(ip)%>
			</td>
		</tr>
			<%
		}
	%>
</table>
</body>
</html>