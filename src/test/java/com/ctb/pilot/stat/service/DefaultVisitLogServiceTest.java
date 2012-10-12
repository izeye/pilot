package com.ctb.pilot.stat.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.stat.model.VisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.VisitUriLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class DefaultVisitLogServiceTest {

	@Autowired
	private VisitLogService visitLogService;

	@Test
	public void testGetDailyVisitLogs() {
		List<DailyVisitLog> dailyVisitLogs = visitLogService
				.getDailyVisitLogs();
		System.out.println(dailyVisitLogs);
	}

	@Test
	public void testGetDailyVisitIpLogs() {
		String day = "2012-10-06";
		List<VisitIpLog> dailyVisitIpLogs = visitLogService
				.getDailyVisitIpLogs(day);
		System.out.println(dailyVisitIpLogs);
	}

	@Test
	public void testGetDailyVisitUriLogs() {
		String day = "2012-10-06";
		List<VisitUriLog> dailyVisitUriLogs = visitLogService
				.getDailyVisitUriLogs(day);
		System.out.println(dailyVisitUriLogs);
	}
	
	@Test
	public void testGetDailyVisitIpLogsWithDayAndUri() {
		String day = "2012-10-12";
		String uri = "/";
		List<VisitIpLog> dailyVisitIpLogs = visitLogService.getDailyVisitIpLogs(
				day, uri);
		System.out.println(dailyVisitIpLogs);
	}

	@Test
	public void testGetDailyVisitUriLogsWithDayAndIpAddress() {
		String day = "2012-10-12";
		String ipAddress = "127.0.0.1";
		List<VisitUriLog> dailyVisitUriLogs = visitLogService.getDailyVisitUriLogs(
				day, ipAddress);
		System.out.println(dailyVisitUriLogs);
	}
}
