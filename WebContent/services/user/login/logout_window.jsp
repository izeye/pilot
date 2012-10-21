<%@page contentType="text/html; charset=utf8"%>
<form action="/services/user/logout.do" method="get"
	onsubmit="current_url.value=window.location.href">
	Hello, ${sessionScope.user.nickname}.<br> <input type="hidden"
		name="current_url"> <input type="submit" value="Logout">
	<a
		href="/common/web_template.jsp?body_path=/services/user/profile/edit_profile_form.jsp">Edit
		Profile</a>
</form>