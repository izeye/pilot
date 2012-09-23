package com.ctb.pilot.stat.dao.jdbc;

import java.util.Map;

import javax.swing.JViewport;

import org.junit.Before;
import org.junit.Test;

import com.ctb.pilot.stat.model.VisitLog;

public class JdbcVisitLogDaoTest {
	private JdbcVisitLogDao jdbcVisitLogDao;

	@Before
	public void setUp() {
		jdbcVisitLogDao = new JdbcVisitLogDao();
	}

	@Test
	public void testInsertVisitLog() {
		VisitLog visitLog = new VisitLog();
		visitLog.setIp("1.2.3.4");
		visitLog.setReferer("referer");
		visitLog.setUri("http://localhost");
		visitLog.setUserAgent("agent");
		jdbcVisitLogDao.insertVisitLog(visitLog);
	}
	
	@Test
	public void testGetVisitTodayStatByIP() {
		Map<String, Long> visitTodayStatByIP = jdbcVisitLogDao.getVisitTodayStatByIP();
		System.out.println(visitTodayStatByIP);
	}
}
