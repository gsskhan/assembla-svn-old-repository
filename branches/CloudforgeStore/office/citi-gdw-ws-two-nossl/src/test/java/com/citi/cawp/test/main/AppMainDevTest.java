package com.citi.cawp.test.main;

import java.util.HashMap;
import java.util.logging.Logger;

import com.citi.cawp.common.CitiUsersProfile;

public class AppMainDevTest {

private static Logger log = Logger.getLogger(AppMainDevTest.class.getName());
	
	public static void main(String[] args) {
		log.info("started program ...");
		
		CitiUsersProfile citiUsersProfile = new CitiUsersProfile(); 
		HashMap<String, String>[] resultMap = 
				citiUsersProfile.getUserProfile(
						"https://vm-40f2-d339.nam.nsroot.net:42301/domainservices/services/GetWFPProfileInfoService" //DEV						
						,"http://service.citigroup.com/provider/domainservices/profile/x2004/"						
						,"http://service.citigroup.com/provider/domainservices/profile/x2004/" 
						, null//"gk85985"
						, "g" //"gulam"
						, "kh"  //"khan"
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
