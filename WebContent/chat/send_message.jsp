<%@page import="com.ctb.pilot.chat.model.*,com.ctb.pilot.chat.dao.*,com.ctb.pilot.chat.dao.jdbc.*"%>
<%
	User user = (User) session.getAttribute("user");

	int userSequence = user.getSequence();
	String message = request.getParameter("message");
	
	if (message == null || message.isEmpty()) {
		throw new Exception("Message is null or empty.");
	}

	MessageDao messageDao = new JdbcMessageDao();
	messageDao.insertMessage(userSequence, message);
	
	response.sendRedirect("chat.jsp");
%>