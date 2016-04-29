package com.citi.cawp.test.main;

import java.util.HashMap;
import java.util.logging.Logger;

import com.citi.cawp.common.CitiUsersProfile;

public class AppMainProdTest {

private static Logger log = Logger.getLogger(AppMainUatTest.class.getName());
	
	public static void main(String[] args) {	
		//System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		//System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		//System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		//System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
				
		System.setProperty("javax.net.ssl.keyStore","C:/opt/gdwcert/CAWP_167925_PROD/CAWP_167925_PROD.p12");
		System.setProperty("javax.net.ssl.keyStorePassword", "CAWP_167925_PROD");
		System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
	
				
		log.info("started program ...");
		
		CitiUsersProfile citiUsersProfile = new CitiUsersProfile(); 
		HashMap<String, String>[] resultMap = 
				citiUsersProfile.getUserProfile(
						"https://citigroupsoa.citigroup.net/domainservices/services/GetWFPProfileInfoService" //PROD				
						,"http://service.citigroup.com/provider/domainservices/profile/x2004/"						
						,"http://service.citigroup.com/provider/domainservices/profile/x2004/" 
						, "gk85985"
						, "g"
						, "khan"
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
