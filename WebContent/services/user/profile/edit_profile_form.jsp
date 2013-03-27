<%@page import="com.ctb.pilot.common.util.CountryUtils" %>
<%@page import="java.util.List" %>
<%@page import="com.ctb.pilot.common.model.Country" %>
<%@page import="com.ctb.pilot.user.model.User" %>
<html>
<head>
<title>Edit Profile</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script src="/services/user/profile/edit_profile.js"></script>

</head>
<body>
	<h3>Edit Profile</h3>
	<form id="edit_profile" method="post" name="edit_profile" action="/services/user/edit_profile.do">
		<table>
			<tr>
				<td>User ID (Email) :</td>
				<td><input type="text" id="user_id" name="user_id"
					readonly="readonly" value="${sessionScope.user.userId}"/></td>
			</tr>
			<tr>
				<td>Current password :</td>
				<td><input type="password" id="current_password"
					name="current_password"/></td>
			</tr>
			<tr>
				<td>New password :</td>
				<td><input type="password" id="new_password"
					name="new_password" /></td>
			</tr>
			<tr>
				<td>Confirm new password :</td>
				<td><input type="password" id="confirm_new_password"
					name="confirm_new_password" /></td>
			</tr>
			<tr>
				<td>Nickname :</td>
				<td><input type="text" id="nickname" name="nickname" value="${sessionScope.user.nickname}"/></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td>
					<select id="country_code" name="country_code">
						<option value="">Select</option>
<%
	User user = (User) session.getAttribute("user");
	List<Country> countries = CountryUtils.getCountries();
	for (Country country : countries) {
		out.print("<option value='" + country.getCode() + "'" +
				(user.getCountryCode().equals(country.getCode()) ? " selected" : "") +
				">" + country.getName() + "</option>");
	}
%>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="button" value="Edit"
					onClick="checkValidation()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>