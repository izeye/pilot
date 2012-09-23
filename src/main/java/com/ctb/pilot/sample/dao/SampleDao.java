package com.ctb.pilot.sample.dao;

import java.util.List;
import java.util.Map;

public interface SampleDao {

	public List<Map<String, Object>> selectList(Map<String, Object> paramMap);
	
	public List<Map<String, Object>> selectCommonList(String queryId, Map<String, Object> paramMap);
	
	public int insertSampleMessage(String queryId, Map<String, Object> paramMap);
}
