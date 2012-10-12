package com.ctb.pilot.stat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.common.util.whois.WhoisService;
import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.model.VisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.VisitUriLog;

@Service("visitLogService")
public class DefaultVisitLogService implements VisitLogService {

	@Autowired
	private VisitLogDao visitLogDao;

	@Autowired
	private WhoisService whoisService;

	@Override
	public List<DailyVisitLog> getDailyVisitLogs() {
		return visitLogDao.getDailyVisitLogs();
	}

	@Override
	public List<VisitIpLog> getDailyVisitIpLogs(String day) {
		List<VisitIpLog> dailyVisitIpLogs = visitLogDao
				.getDailyVisitIpLogs(day);
		for (VisitIpLog dailyVisitIpLog : dailyVisitIpLogs) {
			dailyVisitIpLog.setWhois(whoisService.getWhois(dailyVisitIpLog
					.getIp()));
		}
		return dailyVisitIpLogs;
	}

	@Override
	public List<VisitIpLog> getDailyVisitIpLogs(String day, String uri) {
		return visitLogDao.getDailyVisitIpLogs(day, uri);
	}

	@Override
	public List<VisitUriLog> getDailyVisitUriLogs(String day) {
		return visitLogDao.getDailyVisitUriLogs(day);
	}

	@Override
	public List<VisitUriLog> getDailyVisitUriLogs(String day, String ipAddress) {
		return visitLogDao.getDailyVisitUriLogs(day, ipAddress);
	}

}
