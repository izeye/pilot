<%@page contentType="text/html; charset=utf8"%>
<html>
	<head>
		<title>CTB</title>
		<script src="/common/js/common.js"></script>
	</head>
	<body>
		<h1>CTB</h1>
		<table border="1" cellpadding="10">
			<tr>
				<td width="150" valign="top">
					<a href="/common/web_template.jsp?body_path=/home.jsp">Home</a><br>
					<a href="/common/web_template.jsp?body_path=/pilot.jsp">Pilot Services</a><br>
					<a href="/common/web_template.jsp?body_path=/about_us.jsp">About Us</a><br>
				</td>
				<td valign="top" width="650">
					<jsp:include page="${param.body_path}" />
				</td>
			</tr>
		</table>
		<h5>Copyright@ 2012 CTB</h5>
	</body>
</html>