package com.ctb.pilot.stat.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.stat.model.DailyVisitLog;

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

}
