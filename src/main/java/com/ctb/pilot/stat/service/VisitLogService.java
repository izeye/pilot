package com.ctb.pilot.stat.service;

import java.util.List;

import com.ctb.pilot.stat.model.VisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.VisitUriLog;

public interface VisitLogService {

	List<DailyVisitLog> getDailyVisitLogs();

	List<VisitIpLog> getDailyVisitIpLogs(String day);

	List<VisitIpLog> getDailyVisitIpLogs(String day, String uri);

	List<VisitUriLog> getDailyVisitUriLogs(String day);

	List<VisitUriLog> getDailyVisitUriLogs(String day, String ipAddress);

}
