<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>QR Code Generation History</title>
</head>
<body>
	<h3>QR Code Generation History</h3>
	<table class="table table-striped table-bordered table-hover table-condensed" id="qrcode_generation_log_list">
		<tr>
			<th>Generated Time</th><th>Text</th><th>Width</th><th>Height</th><th>IP Address</th>
		</tr>
		<c:forEach var="qrCodeGenerationLog" items="${qrCodeGenerationLogs}">
			<tr>
				<td>${qrCodeGenerationLog.createdTime}</td>
				<td>${qrCodeGenerationLog.text}</td>
				<td>${qrCodeGenerationLog.width}</td>
				<td>${qrCodeGenerationLog.height}</td>
				<td>${qrCodeGenerationLog.ip}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>