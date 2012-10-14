<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>CTB Research Group</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="/common/js/common.js"></script>
		<script src="/services/user/login/login.js"></script>
		<script type="text/javascript">
		
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-35404210-1']);
		  _gaq.push(['_trackPageview']);
		
		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();
		
		</script>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
		<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1>CTB Research Group</h1>
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
					<a href="/common/web_template.jsp?body_path=/about_us.do">About Us</a><br>
					<c:if test="${sessionScope.user.role == 'staff'}">
						<a href="/common/web_template.jsp?body_path=/admin.jsp">Admin</a><br>
					</c:if>
				</td>
				<td valign="top" width="850">
					<jsp:include page="${param.body_path}" />
				</td>
			</tr>
		</table>
		<h5>Copyright@ 2012 CTB Research Group</h5>
	</body>
</html>