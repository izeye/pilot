package com.ctb.pilot.stat.dao;

import java.util.Map;

import com.ctb.pilot.stat.model.VisitLog;

public interface VisitLogDao {
	void insertVisitLog(VisitLog visitLog);
	
	Map<String, Long> getVisitTodayStatByIP();
	
}
