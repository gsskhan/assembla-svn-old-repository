package org.dms.web.test.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

public class TestJson {
	
	@Test
	@Ignore
	public void testJson() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jmap = new HashMap<String,Object>();
		jmap.put("uname", "gulam");
		jmap.put("passwd", "pass");
		jmap.put("email", "gs2k@dms.org");
		System.out.println(mapper.writeValueAsString(jmap));		
	}

}
