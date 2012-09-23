package com.ctb.pilot.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctb.pilot.sample.service.SampleService;

@Controller
public class SampleController {
	private Log log = LogFactory.getLog(getClass());

	@Resource(name="sampleService")
	private SampleService sampleService;
	
	
    @RequestMapping(value = "/sample1.do")
    public String search1(HttpServletRequest request) {
	    
    	//request attribute
    	
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	
    	
    	//Transaction 
    	
    	Map<String,Object> resultMap = sampleService.processSampleData(paramMap);

    	
    	request.setAttribute("resultMap", resultMap);
    	
	    //call jsp page
	    return "sample/test1";
    }

    @RequestMapping(value = "/sample2.do")
    public String search2(HttpServletRequest request) {
	    
    	//request attribute
    	
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	
    	
    	//Transaction 
    	Map<String,Object> resultMap = sampleService.processSampleData(paramMap);

    	
    	request.setAttribute("resultMap", resultMap);
    	
	    //call jsp page
	    return "sample/test2";
    }

    @RequestMapping(value = "/sample3.do")
    public String putMessage(HttpServletRequest request) {
	    
    	//request attribute
    	
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	
    	paramMap.put("seq", System.currentTimeMillis()%10000);
    	paramMap.put("userSeq", 1);
    	paramMap.put("message", "message test, time= " + System.currentTimeMillis());
    	
    	//Transaction 
    	int resultCount = sampleService.insertMessage(paramMap);

    	
    	request.setAttribute("resultCount", resultCount);
    	
	    //call jsp page
	    return "sample/test3";
    }
    
}
