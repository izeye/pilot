<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<h3>This is test page2 </h3>
<%
	Map resultMap = (Map)request.getAttribute("resultMap");

	List<Map<String,Object>> result1 = (List<Map<String,Object>>)resultMap.get("result1");
	List<Map<String,Object>> result2 = (List<Map<String,Object>>)resultMap.get("result2");

	for(Map row:result1){
		out.println(row);
		out.println("<br>");
	}
%>
*************************************************<br>
<%
for(Map row:result2){
	out.println(row);
	out.println("<br>");
}
%>

