package org.dms.web.test.rest;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

public class UserManageRestClient {
	private static final String SERVER_URI = "http://localhost:8080/DMSmvc";
	private static Logger log = Logger.getLogger(UserManageRestClient.class);
	
	public static void main(String[] args) {
		log.info("program started ...");
		RestTemplate restTemplate = new RestTemplate();
		
		String allusernameslist = restTemplate.getForObject(SERVER_URI+"/usermanage/usernamelist", String.class);
		log.info("Response = "+ allusernameslist);	
		
	}
	 
}
