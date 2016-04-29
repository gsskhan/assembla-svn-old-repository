package com.citi.cawp.test.main;

import java.util.HashMap;
import java.util.logging.Logger;

import com.citi.cawp.common.CitiUsersProfile;


public class AppMainSIT {
	
	
	private static Logger log = Logger.getLogger(AppMainSIT.class.getName());
	
	public static void main(String[] args) {	
		
		System.setProperty("javax.net.ssl.keyStore","C:/Users/gk85985/testclientcertsit.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "SoaomainServicesQA");
		System.setProperty("javax.net.ssl.keyStoreType", "JKS");
		
		
		log.info("started ssl program ...");
		CitiUsersProfile citiUsersProfile = new CitiUsersProfile(); 
		HashMap<String, String>[] resultMap = 
				citiUsersProfile.getUserProfile(
						"https://citigroupsoasit.citigroup.net/soaservices/services/soaservices"
						,"http://service.citigroup.com/provider/SOAServices/x2014/request"
						,"/soaservices/services/profile"
						, "gk85985"
						,null//"shridhar"
						,null//"jetty"
						);
		log.info("Response array:-");
		if (resultMap != null) {
			for (HashMap<String, String> result : resultMap) {
				log.info(result.toString());
				/*for (String key : result.keySet()) {
					log.info(key +":"+result.get(key));
				}*/
			}
		} else {
			log.info("No result returned from calling citiUsersProfile.");
		}		
		log.info("end of program ...");
	}
	
}
