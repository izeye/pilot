package com.ctb.pilot.stat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.model.DailyVisitLog;

@Service("visitLogService")
public class DefaultVisitLogService implements VisitLogService {

	@Autowired
	private VisitLogDao visitLogDao;

	@Override
	public List<DailyVisitLog> getDailyVisitLogs() {
		return visitLogDao.getDailyVisitLogs();
	}

}
