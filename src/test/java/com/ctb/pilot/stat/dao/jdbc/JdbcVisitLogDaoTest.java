package com.ctb.pilot.stat.dao.jdbc;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.model.VisitLog;

public class JdbcVisitLogDaoTest {

	private VisitLogDao visitLogDao;

	@Before
	public void setUp() {
		visitLogDao = new JdbcVisitLogDao();
	}

	@Test
	public void testInsertVisitLog() {
		VisitLog visitLog = new VisitLog();
		visitLog.setIp("1.2.3.4");
		visitLog.setReferer("referer");
		visitLog.setUri("/");
		visitLog.setUserAgent("userAgent");

		visitLogDao.insertVisitLog(visitLog);
	}

	@Test
	public void testGetDailyVisitIpLog() {
		Map<String, Long> dailyVisitIpLog = visitLogDao.getDailyVisitIpLogs();
		System.out.println(dailyVisitIpLog);
	}

}
