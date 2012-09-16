<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<script src="/services/user/login/login.js"></script>
</head>
<body>
<form id="login" action="/services/user/login/login.jsp" method="post" onSubmit="return checkValidation()">
	User ID (Email): <input type="text" id="user_id" name="user_id"/><br>
	Password: <input type="password" id="password" name="password"/>
	<input type="submit" value="Login" />
</form>
</body>
</html>