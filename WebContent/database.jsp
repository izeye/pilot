<%@page contentType="text/html; charset=utf8"%>
<%
	String host = "127.0.0.1";
	String username = "ctb";
	String password = "cTb0409";
	String database = "db_ctb";

	String url = "jdbc:mysql://" + host + "/" + database + "?user="
			+ username + "&password=" + password
			+ "&useUnicode=yes&characterEncoding=UTF-8";
	//out.println(url);
%>