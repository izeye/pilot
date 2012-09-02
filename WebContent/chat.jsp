<%@page contentType="text/html; charset=utf8"%>
<%@page import="java.sql.*"%>
<%@include file="database.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!--
<meta http-equiv="refresh" content="10">
-->
<title>Chat</title>
<script>
	var emptyChk = function() {
		if (message.value == "") {
			alert("Empty field!");
		}
	};
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<style type="text/css">
table {
	border-spacing: 0;
	border-collapse: collapse;
}

table td,table th {
	padding: 2px;
}
</style>
</head>
<body>
	<%
		Class.forName("org.gjt.mm.mysql.Driver");

		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		con = DriverManager.getConnection(url);
		stmt = con.createStatement();

		request.setCharacterEncoding("utf8");

		Integer userSequence = (Integer) session.getAttribute("seq");
		String nickname = (String) session.getAttribute("nickname");

		if (userSequence == null) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();
					if (cookieName.equals("seq")) {
						String cookieValue = cookie.getValue();
						userSequence = Integer.valueOf(cookieValue);
						rs = stmt
								.executeQuery("select * from tb_user where seq = "
										+ userSequence);
						rs.next();
						nickname = rs.getString("nickname");
						// TODO:
						session.setAttribute("seq", userSequence);
						session.setAttribute("nickname", nickname);
					}
				}
			}
		}
		//out.println("userSequence: " + userSequence);
		//out.println("nickname: " + nickname);

		if (userSequence == null) {
			response.sendRedirect("login.html");
			return;
		}

		String rowCount = request.getParameter("row_count");
		if (rowCount == null || rowCount.isEmpty()) {
			rowCount = "100";
		}
		String message = request.getParameter("message");
		//out.println("message: " + message);
	%>
	<form method="post" action="chat.jsp">
		<table>
			<tr>
				<td>Nickname:</td>
				<%
					out.println("<td>" + nickname + "</td>");
				%>
				<td></td>
			</tr>
			<tr>
				<td>Message:</td>
				<td><input type="text" name="message" id="message" size=100 /></td>
				<td><input type="submit" value="Send" onClick="emptyChk()" /></td>
			</tr>
		</table>
	</form>
	<br>
	<%
		if (message != null && !message.isEmpty()) {
			stmt.executeUpdate("insert into tb_chat_message (created_time, user_seq, message) values (now(), '"
					+ userSequence + "', '" + message + "')");
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
					.executeQuery("select * from tb_chat_message cm, tb_user u where cm.user_seq = u.seq order by cm.seq desc limit "
							+ rowCount);
			while (rs.next()) {
				Timestamp createdTime = rs.getTimestamp("created_time");
				String nicknameInHistory = rs.getString("nickname");
				String messageInHistory = rs.getString("message");

				out.print("<tr><td>");
				out.print(String.format("%TF %TT", createdTime, createdTime));
				out.print("</td><td>" + nicknameInHistory + "</td><td>"
						+ messageInHistory + "</td></tr>");
			}
			stmt.close();
			con.close();
		%>
	</table><br>
	Row Count:
	<%
		out.println("<input type=\"text\" name=\"row_count\" id=\"row_count\" value=\""
				+ rowCount + "\"/>");
	%>
</body>
</html>