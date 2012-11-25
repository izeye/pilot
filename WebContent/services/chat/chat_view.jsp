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
<script src="/services/chat/chat.js"></script>
<link rel="stylesheet" type="text/css" href="/common/css/common.css" />
</head>
<body>
	<h3>Chat</h3>
	<form method="post"  action="/services/chat/send-message.do" name="chat" id="chat"
		onsubmit="return emptyChk()">
				<span class="span1">
					<label class="label"><h6>${message}:</h6></label>
				</span>
				<span class="span5">
					<input class="input-block-level" type="text" name="message" id="message" size=100 x-webkit-speech />
			    </span>
				<span class="span"></span>
				<input type="submit" class="btn" value="Send" />
	</form>
	<br>
	<table id="output" class="table table-striped table-bordered table-hover table-condensed">
		<tr>
			<th width="200">${time}</th>
			<th width="100">${nickname}</th>
			<th width="700">${message}</th>
		</tr>
	</table>
</body>
</html>