<%@page import="com.ctb.pilot.chat.model.*,com.ctb.pilot.chat.dao.*,com.ctb.pilot.chat.dao.jdbc.*"%>
<%
	Integer userSequence = (Integer) session.getAttribute("seq");
	String message = request.getParameter("message");
	
	if (userSequence == null || message == null || message.isEmpty()) {
		throw new Exception("Some field is null or empty.");
	}

	MessageDao messageDao = new JdbcMessageDao();
	messageDao.insertMessage(userSequence, message);
	
	response.sendRedirect("chat.jsp");
%>