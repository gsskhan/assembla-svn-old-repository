package com.citi.ets.publisher;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author gk85985
 * @usage Class with main function to launch RTVIEW Publisher.
 */
public class RtviewPublisherApp {
	
	private static Logger log = Logger.getLogger(RtviewPublisherApp.class);
	
	@SuppressWarnings("unused")
	private static ApplicationContext ctx;
	
	private static String[] configFilesLocation = { 
												 	"/spring/applicationContext-tibco.xml"
												 ,  "/spring/applicationContext-integration.xml"
												 ,  "/spring/applicationContext-jdbc.xml"
												 ,  "/spring/applicationContext-common.xml"
												};
	
	
	public static void main(String[] args) {
		
		log.info("******************** RTVIEW PUBLISHER STARTED ******************");
		
		ctx = new ClassPathXmlApplicationContext(configFilesLocation);
		
	}

}
