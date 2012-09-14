<%@page contentType="text/html; charset=utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:bundle basename="chat">
	<fmt:message var="title" key="TITLE" />
	<fmt:message var="nickname" key="NICKNAME" />
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
<script src="/pilot/chat/chat.js"></script>
<link rel="stylesheet" type="text/css" href="/pilot/common/css/common.css" />
</head>
<body>
	<form method="post" action="/pilot/chat" name="chat" id="chat">
		<table>
			<tr>
				<td>${nickname}:</td>
				<td>${sessionScope.user.nickname}</td>
				<td></td>
			</tr>
			<tr>
				<td>${message}:</td>
				<td><input type="text" name="message" id="message" size=100 /></td>
				<td><input type="button" value="Send" onClick="emptyChk()" /></td>
			</tr>
		</table>
	</form>
	<br>
	<table border="1">
		<tr>
			<th width="200">${time}</th>
			<th width="100">${nickname}</th>
			<th width="700">${message}</th>
		</tr>
		<c:set var="messages" value="${requestScope.messages}"></c:set>
		<c:forEach var="message" items="${messages}">
			<tr>
				<td><fmt:formatDate value="${message.createdTime}" type="both"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${message.nickname}</td>
				<td>${message.message}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${requestScope.pageNo != 1 }">
		<a href="chat?page_no=${requestScope.pageNo - 1}">Prev</a>
	</c:if>
	<c:forEach var="page" begin="1" end="${requestScope.pageCount}">
		<a href="chat?page_no=${page}">
			<c:if test="${page == requestScope.pageNo}">
				<b>${page}</b>
			</c:if>
			<c:if test="${page != requestScope.pageNo}">
				${page}
			</c:if>
		</a>
	</c:forEach>
	<c:if test="${requestScope.pageNo != requestScope.pageCount}">
		<a href="chat?page_no=${requestScope.pageNo + 1}">Next</a>
	</c:if>
	<!--
	<br> ${maxRowCount}:
	<input type="text" name="row_count" id="row_count" value="${requestScope.maxRowCount}"/>
	-->
</body>
</html>