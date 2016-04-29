package com.citi.cawp.test.main;

import java.util.HashMap;
import java.util.logging.Logger;

import com.citi.cawp.common.CitiUsersProfile;


public class AppMainDev {
	
	
	private static Logger log = Logger.getLogger(AppMainDev.class.getName());
	
	public static void main(String[] args) {		
		log.info("started program ...");
		CitiUsersProfile citiUsersProfile = new CitiUsersProfile(); 
		HashMap<String, String>[] resultMap = 
				citiUsersProfile.getUserProfile(
						"https://ccgfbwm10i:33547/soaservices/services/soaservices.serviceagent" 	//DEV
						//"http://ccgfbwm10i:33647/soaservices/services/soaservices.serviceagent"  //DEV
						,"http://service.citigroup.com/provider/SOAServices/x2014/request"
						,"/soaservices/services/profile"
						, "SU64420"
						,"g"//"shridhar"
						,"k"//"jetty"
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
