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
<!--
<script src="/services/chat/chat.js"></script>
-->
<link rel="stylesheet" type="text/css" href="/common/css/common.css" />
</head>
<body>
	<h3>Chat</h3>
	<form method="post" action="/services/chat/send-message" name="chat" id="chat"
		onsubmit="return emptyChk()">
		<table>
			<tr>
				<td>${message}:</td>
				<td><input type="text" name="message" id="message" size=100 /></td>
				<td><input type="submit" value="Send" /></td>
			</tr>
		</table>
	</form>
	<br>
	<table id="chat" class="table table-striped table-bordered table-hover table-condensed">
		<tr>
			<th width="200">${time}</th>
			<th width="100">${nickname}</th>
			<th width="700">${message}</th>
		</tr>
		<c:set var="messages" value="${messages}"></c:set>
		<c:forEach var="message" items="${messages}">
			<tr>
				<td><fmt:formatDate value="${message.createdTime}" type="both"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${message.nickname}</td>
				<td>${message.message}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pageNo != 1 }">
		<a href="/common/web_template.jsp?body_path=/services/chat/history.do?page_no=${pageNo - 1}">Prev</a>
	</c:if>
	<c:forEach var="page" begin="1" end="${pageCount}">
		<a href="/common/web_template.jsp?body_path=/services/chat/history.do?page_no=${page}"> <c:choose>
				<c:when test="${page == pageNo}">
					<b>${page}</b>
				</c:when>
				<c:otherwise>
					${page}
				</c:otherwise>
			</c:choose>
		</a>
	</c:forEach>
	<c:if test="${pageNo != pageCount}">
		<a href="/common/web_template.jsp?body_path=/services/chat/history.do?page_no=${pageNo + 1}">Next</a>
	</c:if>
	<!--
	<br> ${maxRowCount}:
	<input type="text" name="row_count" id="row_count" value="${requestScope.maxRowCount}"/>
	-->
</body>
</html>