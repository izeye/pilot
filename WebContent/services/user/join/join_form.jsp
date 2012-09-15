<html>
	<head>
		<title>Join</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
		<script src="join.js"></script>
	</head>
	<body>
		<form id="join" name="join" action="join.jsp">
			<table>
				<tr>
					<td>User ID (Email) :</td><td> <input type="text" id="user_id" name="user_id"/></td>
				</tr>
				<tr>
				    <td>Password :</td><td> <input type="password" id="password" name="password"/></td>
				</tr>
				<tr>
					<td>Confirm password :</td><td> <input type="password" id="confirm_password" name="confirm_password"/></td>
				</tr>
				<tr>
					<td>Nickname :</td><td> <input type="text" id="nickname" name="nickname"/></td>
				</tr>
				<tr><td><input type="reset" value="Clear"/></td><td><input type="button"  value="Join" onClick="checkValidation()"/></td></tr>
			</table>
		</form>
	</body>
</html>