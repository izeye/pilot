package com.ctb.pilot.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.chat.dao.MessageDao;
import com.ctb.pilot.chat.model.Message;

@Service("chatService")
public class DefaultChatService implements ChatService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public List<Message> getMessages(int pageSize, int pageNo) {
		return messageDao.getMessages(pageSize, pageNo);
	}

	@Override
	public void insertMessage(int userSequence, String message) {
		messageDao.insertMessage(userSequence, message);
	}

	@Override
	public long getAllMessageCount() {
		return messageDao.getAllMessageCount();
	}

}
