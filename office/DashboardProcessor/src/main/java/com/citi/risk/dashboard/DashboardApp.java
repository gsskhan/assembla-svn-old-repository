package com.citi.risk.dashboard;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gk85985   Main class for Dashboard Processor program to begin.
 * 
 */

public final class DashboardApp {
     private static Logger log = Logger.getLogger(DashboardApp.class);

     private DashboardApp() {
          super();
     }

     @SuppressWarnings("unused")
     private static ApplicationContext ctx;

     private static String[] configFilesLocation = {
            // "/spring/applicationContext-amq.xml"
               "/spring/applicationContext-tibco.xml",
               "/spring/applicationContext-integration.xml",
               "/spring/applicationContext-hibernate.xml",
               "/spring/applicationContext-common.xml" };

     public static void main(String[] args) {
          log.info("******************** PROGRAM STARTED ******************");
          log.info("Running with java version - " + System.getProperty("java.version"));
          ctx = new ClassPathXmlApplicationContext(configFilesLocation);
     }
}
