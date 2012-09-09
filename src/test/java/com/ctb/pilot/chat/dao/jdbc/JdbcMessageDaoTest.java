package com.ctb.pilot.chat.dao.jdbc;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ctb.pilot.chat.model.Message;

public class JdbcMessageDaoTest {

	private JdbcMessageDao messageDao;

	@Before
	public void setUp() {
		messageDao = new JdbcMessageDao();
	}

	@Test
	public void testGetMessagesWithRowCount() {
		int rowCount = 100;
		List<Message> messageList = messageDao
				.getMessagesWithRowCount(rowCount);
		System.out.println(messageList);
	}

	@Test
	public void testInsertMessage() {
		int userSequence = 1;
		String message = "This is a test.";
		messageDao.insertMessage(userSequence, message);
	}
}
