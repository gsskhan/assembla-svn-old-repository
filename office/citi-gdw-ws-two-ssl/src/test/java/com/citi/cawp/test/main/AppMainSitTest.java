package com.citi.cawp.test.main;

import java.util.HashMap;
import java.util.logging.Logger;

import com.citi.cawp.common.CitiUsersProfile;

public class AppMainSitTest {

private static Logger log = Logger.getLogger(AppMainSit2Test.class.getName());
	
	public static void main(String[] args) {	
		
		//System.setProperty("javax.net.debug", "ssl:handshake:verbose");		
		
		/*System.setProperty("javax.net.ssl.keyStore","C:/opt/gdwcert/CAWP_167925_DEV/CAWP_167925_DEV.p12");
		System.setProperty("javax.net.ssl.keyStorePassword", "CAWP_167925_DEV");
		System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");*/
		
		System.setProperty("javax.net.ssl.keyStore","C:/opt/gdwcert/CAWP_167925_DEV/CAWP_167925_DEV.p12");
		System.setProperty("javax.net.ssl.keyStorePassword", "CAWP_167925_DEV");
		System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
				
		log.info("started program ...");
		
		CitiUsersProfile citiUsersProfile = new CitiUsersProfile(); 
		HashMap<String, String>[] resultMap = 
				citiUsersProfile.getUserProfile(
						"https://citigroupsoasit.citigroup.net/domainservices/services/GetWFPProfileInfoService" //DEV						
						,"http://service.citigroup.com/provider/domainservices/profile/x2004/"						
						,"http://service.citigroup.com/provider/domainservices/profile/x2004/" 
						, "gk85985"
						, "g" //"shridhar"
						, "khan" //"jetty"
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
