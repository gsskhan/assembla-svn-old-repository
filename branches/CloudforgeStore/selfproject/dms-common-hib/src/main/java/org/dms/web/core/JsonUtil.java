package org.dms.web.core;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	private static Logger log = Logger.getLogger(JsonUtil.class);
	
	public static String getJsonAsString(Object jsonobject){
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			//result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonobject);	
			result = mapper.writeValueAsString(jsonobject);	
		} catch (Exception e) {
			log.error("error in creating json string.", e);
		}
		log.debug("Json string - " +result);
		return result;		
	}
}
