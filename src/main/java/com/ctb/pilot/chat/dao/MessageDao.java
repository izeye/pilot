package com.ctb.pilot.chat.dao;

import java.util.List;

import com.ctb.pilot.chat.model.Message;

public interface MessageDao {

	List<Message> getMessages(int pageSize, int pageNo);

	void insertMessage(int userSequence, String message);

	long getAllMessageCount();

}
