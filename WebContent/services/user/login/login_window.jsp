<%@page contentType="text/html; charset=utf8"%>
<form id="login" action="/services/user/login.do" method="post" onsubmit="return login()">
	<label class="control-label" for="user_id">Email</label><input type="text" class="input-medium" id="user_id" name="user_id" placeholder="Email" />
	<label class="control-label" for="password">Password</label>
	<input type="password" class="input-medium" id="password" name="password" placeholder="Password" />
	<label class="checkbox">
		<input type="checkbox"> Remember me
	</label>
	<button type="submit" class="btn">Sign in</button>
	<input type="hidden" name="current_url">
	<a href="/common/web_template.jsp?body_path=/services/user/sign_up/sign_up_form.jsp">Sign up</a>
</form>
