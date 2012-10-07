package com.ctb.pilot.stat.service;

import java.util.List;

import com.ctb.pilot.stat.model.DailyVisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.DailyVisitUriLog;

public interface VisitLogService {

	List<DailyVisitLog> getDailyVisitLogs();

	List<DailyVisitIpLog> getDailyVisitIpLogs(String day);

	List<DailyVisitUriLog> getDailyVisitUriLogs(String day);

}
