package com.ctb.pilot.chat.dao.jdbc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.chat.dao.MessageDao;
import com.ctb.pilot.chat.model.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class MyBatisMessageDaoTest {

	@Autowired
	private MessageDao messageDao;

	@Test
	public void getMessages() {
		int pageSize = 20;
		int pageNo = 1;
		List<Message> messageList = messageDao.getMessages(pageSize, pageNo);
		System.out.println(messageList);

		pageNo = 2;
		messageList = messageDao.getMessages(pageSize, pageNo);
		System.out.println(messageList);
	}

	@Test
	public void insertMessage() {
		int userSequence = 1;
		String message = "This is a test.";
		String language = "ko";
		messageDao.insertMessage(userSequence, message, language);
	}

	@Test
	public void getAllMessageCount() {
		long allMessageCount = messageDao.getAllMessageCount();
		System.out.println(allMessageCount);
	}

}
