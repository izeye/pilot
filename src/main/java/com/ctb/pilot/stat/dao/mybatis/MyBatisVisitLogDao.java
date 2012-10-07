package com.ctb.pilot.stat.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.model.DailyVisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.DailyVisitUriLog;
import com.ctb.pilot.stat.model.VisitLog;

@Repository("visitLogDao")
public class MyBatisVisitLogDao implements VisitLogDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public void insertVisitLog(VisitLog visitLog) {
		VisitLogMapper visitLogMapper = sessionTemplate
				.getMapper(VisitLogMapper.class);
		visitLogMapper.insertVisitLog(visitLog);
	}

	@Override
	public List<DailyVisitLog> getDailyVisitLogs() {
		VisitLogMapper visitLogMapper = sessionTemplate
				.getMapper(VisitLogMapper.class);
		return visitLogMapper.getDailyVisitLogs();
	}

	@Override
	public List<DailyVisitIpLog> getDailyVisitIpLogs(String day) {
		VisitLogMapper visitLogMapper = sessionTemplate
				.getMapper(VisitLogMapper.class);
		return visitLogMapper.getDailyVisitIpLogs(day);
	}

	@Override
	public List<DailyVisitUriLog> getDailyVisitUriLogs(String day) {
		VisitLogMapper visitLogMapper = sessionTemplate
				.getMapper(VisitLogMapper.class);
		return visitLogMapper.getDailyVisitUriLogs(day);
	}

	@Override
	public Map<String, Long> getVisitIpLogs() {
		// TODO Auto-generated method stub
		return null;
	}

}
