<html>
<head>
<title>Sign Up</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script src="/services/user/sign_up/sign_up.js"></script>
</head>
<body>
	<h3>Sign Up</h3>
	<form id="sign_up" name="sign_up" action="/services/user/sign-up.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>User ID (Email) :</td>
				<td><input type="text" id="sign_up_user_id" name="user_id" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" id="sign_up_password" name="password" /></td>
			</tr>
			<tr>
				<td>Confirm password :</td>
				<td><input type="password" id="confirm_password"
					name="confirm_password" /></td>
			</tr>
			<tr>
				<td>Nickname :</td>
				<td><input type="text" id="nickname" name="nickname" /></td>
			</tr>
			<tr>
				<td>Image :</td>
				<td><input type="file" id="imageFile" name="imageFile"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Clear" /></td>
				<td><input type="button" value="Sign Up"
					onClick="checkValidation()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>