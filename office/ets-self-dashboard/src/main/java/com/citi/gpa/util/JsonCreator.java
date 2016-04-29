package com.citi.gpa.util;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public final class JsonCreator {
	
	private static Logger log = Logger.getLogger(JsonCreator.class);
	
	public static String getJson(Object obj) throws JsonProcessingException, IOException {		
		ObjectMapper mapper = new ObjectMapper();
		log.info("Returning Json string.");
		return mapper.writeValueAsString(obj);
	}

}
