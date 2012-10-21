package com.ctb.pilot.stat.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.model.VisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.VisitUriLog;
import com.ctb.pilot.stat.model.VisitLog;

@Repository("visitLogDao")
public class MyBatisVisitLogDao implements VisitLogDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public void insertVisitLog(VisitLog visitLog) {
		VisitLogMapper mapper = sessionTemplate.getMapper(VisitLogMapper.class);
		mapper.insertVisitLog(visitLog);
	}

	@Override
	public List<DailyVisitLog> getDailyVisitLogs() {
		VisitLogMapper mapper = sessionTemplate.getMapper(VisitLogMapper.class);
		return mapper.getDailyVisitLogs();
	}

	@Override
	public List<VisitIpLog> getDailyVisitIpLogs(String day) {
		VisitLogMapper mapper = sessionTemplate.getMapper(VisitLogMapper.class);
		return mapper.getDailyVisitIpLogs(day);
	}

	@Override
	public List<VisitUriLog> getDailyVisitUriLogs(String day) {
		VisitLogMapper mapper = sessionTemplate.getMapper(VisitLogMapper.class);
		return mapper.getDailyVisitUriLogs(day);
	}

	@Override
	public Map<String, Long> getVisitIpLogs() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<VisitIpLog> getDailyVisitIpLogs(String day, String uri) {
		VisitLogMapper mapper = sessionTemplate.getMapper(VisitLogMapper.class);
		return mapper.getDailyVisitIpLogsWithDayAndUri(day, uri);
	}

	@Override
	public List<VisitUriLog> getDailyVisitUriLogs(String day, String ipAddress) {
		VisitLogMapper mapper = sessionTemplate.getMapper(VisitLogMapper.class);
		return mapper.getDailyVisitUriLogsWithDayAndIpAddress(day, ipAddress);
	}

}
