package com.ctb.pilot.sample.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ctb.pilot.sample.dao.SampleDao;
import com.ctb.pilot.sample.service.SampleService;


@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	private Log log = LogFactory.getLog(getClass());
	
	@Resource(name="sampleDao")
	private SampleDao sampleDao;
	
	@Override
	public Map<String, Object> processSampleData(Map<String,Object> paramMap) {
		
		//set query condition value 
		paramMap.put("nick","ni");
		paramMap.put("seq", 2);
		
		//Making data
		List<Map<String,Object>> result1 = sampleDao.selectList(paramMap);
		
		List<Map<String,Object>> result2 = sampleDao.selectCommonList("sql.sample.selectSampleMessageList", paramMap);
		
		log.debug("데이터 조회가 끝났음~");
		
		for(Map rowMap:result1){ log.info(rowMap); }
		
		for(Map rowMap:result2){ log.info(rowMap); }
		
		//Making Result Data
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result1", result1);
		resultMap.put("result2", result2);
		
		//Return result
		return resultMap;
	}

	@Override
	public int insertMessage(Map<String, Object> paramMap) {

		int resultCount = sampleDao.insertSampleMessage("sql.sample.insertMessage", paramMap);
		
		return resultCount;
	}

}
