<%@page contentType="text/html; charset=utf8"%>
<%@page import="java.sql.*"%>
<%@include file="database.jsp"%>
<%
	String userId = request.getParameter("user_id");
	String userPassword = request.getParameter("password");
	//out.println(userId);
	//out.println(userPassword);

	Class.forName("org.gjt.mm.mysql.Driver");

	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;

	con = DriverManager.getConnection(url);
	stmt = con.createStatement();
	
	rs = stmt.executeQuery("select * from tb_user where user_id='" + userId + "' and password='" + userPassword + "'");
	if (!rs.next()) {
		//out.println("Login fail.");
		response.sendRedirect("login.html");
		return;
	}
	//out.println("Login success.");
	int userSequence = rs.getInt("seq");
	String nickname = rs.getString("nickname");
	session.setAttribute("seq", userSequence);
	session.setAttribute("nickname", nickname);
	RequestDispatcher dispatcher = request.getRequestDispatcher("chat.jsp");
	Cookie cookie = new Cookie("seq", String.valueOf(userSequence));
	cookie.setMaxAge(60 * 60 * 24 * 365);
	response.addCookie(cookie);
	dispatcher.forward(request, response);
%>