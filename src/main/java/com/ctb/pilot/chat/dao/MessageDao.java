package com.ctb.pilot.chat.dao;

import java.util.List;

import com.ctb.pilot.chat.model.Message;

public interface MessageDao {

	List<Message> getMessagesWithRowCount(int rowCount);
	
	void insertMessage(int userSequence, String message);

}
