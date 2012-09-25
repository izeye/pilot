package com.ctb.pilot.common.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class JsonUtils {

	public static String toJson(Object object) throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectWriter objectWriter = objectMapper.writer();
		return objectWriter.writeValueAsString(object);
	}

}
