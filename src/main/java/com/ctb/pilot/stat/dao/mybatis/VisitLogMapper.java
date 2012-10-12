package com.ctb.pilot.stat.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ctb.pilot.stat.model.VisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.VisitUriLog;
import com.ctb.pilot.stat.model.VisitLog;

public interface VisitLogMapper {

	void insertVisitLog(VisitLog visitLog);

	List<DailyVisitLog> getDailyVisitLogs();

	List<VisitIpLog> getDailyVisitIpLogs(String day);

	List<VisitIpLog> getDailyVisitIpLogsWithDayAndUri(@Param("day") String day,
			@Param("uri") String uri);

	List<VisitUriLog> getDailyVisitUriLogs(String day);

	List<VisitUriLog> getDailyVisitUriLogsWithDayAndIpAddress(
			@Param("day") String day, @Param("ipAddress") String ipAddress);

	// TODO: Remove me later.
	Map<String, Long> getVisitIpLogs();

}
