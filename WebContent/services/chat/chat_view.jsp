<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:bundle basename="chat">
	<fmt:message var="title" key="TITLE" />
	<fmt:message var="message" key="MESSAGE" />
	<fmt:message var="time" key="TIME" />
	<fmt:message var="maxRowCount" key="MAX_ROW_COUNT" />
</fmt:bundle>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!--
<meta http-equiv="refresh" content="10">
-->
<title>${title}</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script src="/services/chat/chat.js"></script>
<link rel="stylesheet" type="text/css" href="/common/css/common.css" />
</head>
<body>
	<h3>Chat</h3>
	<form method="post" action="/services/chat" name="chat" id="chat"
		onsubmit="return emptyChk()">
		<p>
			<label>
				${message}:
				<input type="text" name="message" id="message" size=100 x-webkit-speech />
				<input type="submit" value="Send" />
			</label>
		</p>
	</form>
	<br>
	<table id="output" class="data" border="1" id="chat">
		<tr>
			<th width="200">${time}</th>
			<th width="100">${nickname}</th>
			<th width="700">${message}</th>
		</tr>
		
	</table>
	
</body>
</html>