package com.ctb.pilot.sample.service;

import java.util.Map;

public interface SampleService {

	public Map<String,Object> processSampleData(Map<String, Object> paramMap);
	
	public int insertMessage(Map<String, Object> paramMap);
	
}
