<%@page contentType="text/html; charset=utf8"%>
<form id="login" action="/services/user/login" method="post"
	onSubmit="return checkValidation()"
	onsubmit="current_url.value=window.location.href">
	User ID (Email): <input type="text" id="user_id" name="user_id" /><br>
	Password: <input type="password" id="password" name="password" /> <input
		type="hidden" name="current_url"> <input type="submit"
		value="Login" />
</form>