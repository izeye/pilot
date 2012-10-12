package com.ctb.pilot.stat.dao;

import java.util.List;
import java.util.Map;

import com.ctb.pilot.stat.model.VisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.VisitUriLog;
import com.ctb.pilot.stat.model.VisitLog;

public interface VisitLogDao {

	void insertVisitLog(VisitLog visitLog);

	List<DailyVisitLog> getDailyVisitLogs();

	List<VisitIpLog> getDailyVisitIpLogs(String day);

	List<VisitIpLog> getDailyVisitIpLogs(String day, String uri);

	List<VisitUriLog> getDailyVisitUriLogs(String day);

	List<VisitUriLog> getDailyVisitUriLogs(String day, String ipAddress);

	// TODO: Remove me later.
	Map<String, Long> getVisitIpLogs();

}
