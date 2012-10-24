package com.ctb.pilot.common.util;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtils {

	public static String toJson(Object object) throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectWriter objectWriter = objectMapper.writer();
		return objectWriter.writeValueAsString(object);
	}
	
	public static String getProperty(String key, String jsonString)
			throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,String> map = objectMapper.readValue(jsonString,
				new TypeReference<Map<String, String>>(){});
		return map.get(key);
	}
}
