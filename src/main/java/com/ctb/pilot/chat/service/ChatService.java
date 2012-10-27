package com.ctb.pilot.chat.service;

import java.util.List;

import com.ctb.pilot.chat.model.Message;

public interface ChatService {

	List<Message> getMessages(int pageSize, int pageNo);

	void insertMessage(int userSequence, String message, String language);

	long getAllMessageCount();

}
