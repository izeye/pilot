<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>CTB</title>
		<script src="/common/js/common.js"></script>
		<script src="/services/user/login/login.js"></script>
	</head>
	<body>
		<h1>CTB</h1>
		<table border="1" cellpadding="10">
			<tr>
				<td width="150" valign="top">
					<c:choose>
						<c:when test="${sessionScope.user == null}">
							<jsp:include page="/services/user/login/login_window.jsp" />
						</c:when>
						<c:otherwise>
							<jsp:include page="/services/user/login/logout_window.jsp" />
						</c:otherwise>
					</c:choose>
					<a href="/common/web_template.jsp?body_path=/home.jsp">Home</a><br>
					<a href="/common/web_template.jsp?body_path=/pilot.jsp">Pilot Services</a><br>
					<a href="/common/web_template.jsp?body_path=/about_us.jsp">About Us</a><br>
					<a href="/common/web_template.jsp?body_path=/admin.jsp">Admin</a><br>
				</td>
				<td valign="top" width="850">
					<jsp:include page="${param.body_path}" />
				</td>
			</tr>
		</table>
		<h5>Copyright@ 2012 CTB</h5>
	</body>
</html>