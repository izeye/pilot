package com.ctb.pilot.sample.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.sample.dao.SampleDao;

@Repository("sampleDao")
public class SampleDaoImpl extends SqlSessionDaoSupport implements SampleDao{

	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> paramMap) {
		return getSqlSession().selectList("sql.sample.selectSampleUserList");
	}

	@Override
	public List<Map<String, Object>> selectCommonList(String queryId, Map<String, Object> paramMap) {
		return getSqlSession().selectList(queryId, paramMap);
	}

	@Override
	public int insertSampleMessage(String queryId, Map<String, Object> paramMap) {
		return getSqlSession().insert(queryId, paramMap);
	}

	
	
}
