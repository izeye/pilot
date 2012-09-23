<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<h3>This is test page2 </h3>
<%
	int resultCount = (Integer)request.getAttribute("resultCount");
%>
*************************************************<br>
Insert data count is <%=resultCount%> .

