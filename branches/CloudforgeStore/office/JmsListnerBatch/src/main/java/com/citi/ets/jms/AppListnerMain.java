package com.citi.ets.jms;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppListnerMain {
	
	private static Logger log = Logger.getLogger(AppListnerMain.class);
	
	private static 	String[] configFilesLocation = {
													//	"/spring/applicationContext-amq.xml"
														"/spring/applicationContext-tibco.xml"
													,   "/spring/applicationContext-integration.xml"
													,	"/spring/applicationContext-common.xml"
													};
	
	@SuppressWarnings("unused")
	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		
		log.info("********* STARTING Message Listner*********");
		ctx = new ClassPathXmlApplicationContext(configFilesLocation);
		
	}

}
