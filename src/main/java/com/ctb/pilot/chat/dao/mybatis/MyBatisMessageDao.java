package com.ctb.pilot.chat.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.chat.dao.MessageDao;
import com.ctb.pilot.chat.model.Message;

@Repository("messageDao")
public class MyBatisMessageDao implements MessageDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public List<Message> getMessages(int pageSize, int pageNo) {
		MessageMapper mapper = sessionTemplate.getMapper(MessageMapper.class);
		int offset = (pageNo - 1) * pageSize;
		return mapper.getMessages(pageSize, offset);
	}

	@Override
	public void insertMessage(int userSequence, String message, String language) {
		MessageMapper mapper = sessionTemplate.getMapper(MessageMapper.class);
		mapper.insertMessage(userSequence, message, language);
	}

	@Override
	public long getAllMessageCount() {
		MessageMapper mapper = sessionTemplate.getMapper(MessageMapper.class);
		return mapper.getAllMessageCount();
	}

}
