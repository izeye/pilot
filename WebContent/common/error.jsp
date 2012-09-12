<%@page contentType="text/html; charset=utf8" isErrorPage="true"%>
<% response.setStatus(200); %>
<html>
	<head>
		<title>에러</title>
	</head>
	<body>
		<h3>에러</h3>
		에러 메시지: <%= exception.getMessage() %>
	</body>
</html>