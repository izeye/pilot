<%@page contentType="text/html; charset=utf8" %>
<%@page import="java.util.Date" import="java.sql.*"%>
<%@include file="database.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chat</title>
<script>
	var emptyChk = function() {
		if (user_id.value == "" || message.value == "") {
			alert("Empty field!");
		}
	};
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<style type="text/css">
table {
	border-spacing:0;
	border-collapse:collapse;
}

table td, table th {
	padding:2px;
}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf8");
		String userId = request.getParameter("user_id");
		String rowCount = request.getParameter("row_count");
		if (rowCount == null || rowCount.isEmpty()) {
			rowCount = "10";
		}
		String message = request.getParameter("message");
		//out.println("message: " + message);
	%>
	<form method="post">
		<table>
			<tr>
				<td>ID:</td>
				<%
					out.println("<td><input type=\"text\" name=\"user_id\" id=\"user_id\" value=\""
							+ (userId == null ? "" : userId) + "\"/></td>");
				%>
				<td></td>
			</tr>
			<tr>
				<td>Row Count</td>
				<%
					out.println("<td><input type=\"text\" name=\"row_count\" id=\"row_count\" value=\""
							+ rowCount + "\"/></td>");
				%>
				<td></td>
			</tr>
			<tr>
				<td>Message:</td>
				<td><input type="text" name="message" id="message" /></td>
				<td><input type="submit" value="Send" onClick="emptyChk()" /></td>
			</tr>
		</table>
	</form>
	<%
		Class.forName("org.gjt.mm.mysql.Driver");

		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		con = DriverManager.getConnection(url);
		stmt = con.createStatement();

		if (userId != null && !userId.isEmpty() && message != null
				&& !message.isEmpty()) {
			stmt.executeUpdate("insert into tb_chat_message (created_time, user_id, message) values (now(), '"
					+ userId + "', '" + message + "')");
		}
	%>

	<table border="1">
		<tr>
			<th width="200">Time</th>
			<th width="100">User ID</th>
			<th width="700">Message</th>
		</tr>
		<%
			rs = stmt
					.executeQuery("select * from tb_chat_message order by id desc limit "
							+ rowCount);
			while (rs.next()) {
				Timestamp createdTime = rs.getTimestamp("created_time");
				userId = rs.getString("user_id");
				message = rs.getString("message");

				out.print("<tr><td>");
				out.print(String.format("%TF %TT", createdTime, createdTime));
				out.print("</td><td>" + userId
						+ "</td><td>" + message + "</td></tr>");
			}
			stmt.close();
			con.close();
		%>
	</table>
</body>
</html>