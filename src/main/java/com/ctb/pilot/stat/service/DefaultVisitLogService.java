package com.ctb.pilot.stat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.model.DailyVisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.DailyVisitUriLog;

@Service("visitLogService")
public class DefaultVisitLogService implements VisitLogService {

	@Autowired
	private VisitLogDao visitLogDao;

	@Override
	public List<DailyVisitLog> getDailyVisitLogs() {
		return visitLogDao.getDailyVisitLogs();
	}

	@Override
	public List<DailyVisitIpLog> getDailyVisitIpLogs(String day) {
		return visitLogDao.getDailyVisitIpLogs(day);
	}

	@Override
	public List<DailyVisitUriLog> getDailyVisitUriLogs(String day) {
		return visitLogDao.getDailyVisitUriLogs(day);
	}

}
