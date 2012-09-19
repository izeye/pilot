<%@page contentType="text/html; charset=utf8"%>
<form action="/services/user/logout" method="get" onsubmit="current_url.value=window.location.href">
	Hello, ${sessionScope.user.nickname}.<br>
	<input type="hidden" name="current_url">
	<input type="submit" value="Logout">
</form>