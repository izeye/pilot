package com.ctb.pilot.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ctb.pilot.chat.model.Message;

public class JsonUtilsTest {

	@Test
	public void testToJson() throws IOException {
		Message message = new Message();
		message.setCreatedTime(new Date());
		message.setNickname("izeye");
		message.setMessage("Hello, world!");

		List<Message> messages = new ArrayList<Message>();
		messages.add(message);

		String json = JsonUtils.toJson(messages);
		System.out.println(json);
	}

}
