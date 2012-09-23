<%@page contentType="text/html; charset=utf8"%>
<form id="login" action="/services/user/login" method="post"
	onsubmit="return login()">
	User ID (Email): <input type="text" id="user_id" name="user_id" /><br>
	Password: <input type="password" id="password" name="password" /> <input
		type="hidden" name="current_url"> <input type="submit"
		value="Login" /><a
		href="/common/web_template.jsp?body_path=/services/user/sign_up/sign_up_form.jsp">Sign
		Up</a>
</form>
