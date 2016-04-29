package com.citi.ets.jms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.citi.ets.jms.producer.MessageSender;

public class AppProducerMain {
	
	
	private static Logger log = Logger.getLogger(AppProducerMain.class);
	
	private static 	String[] configFilesLocation = {
													//	"/spring/applicationContext-amq.xml"
														"/spring/applicationContext-tibco.xml"
													,   "/spring/applicationContext-common.xml"
													};
	
	private static ClassPathXmlApplicationContext ctx;
	
	public static void main(String[] args) {
		
		log.info("********* STARTING Message Producer *********");
		ctx = new ClassPathXmlApplicationContext(configFilesLocation);
		
		MessageSender sender = ctx.getBean("messageSender",MessageSender.class);
		
			
		try {
			boolean status = sender.sendXML(getXmlAsString());
			//boolean status = sender.sendXML("TEST MESSAGE FROM GULAM @ " + new Date());
			if (status) 
				log.info("Message send successfully");
			else
				log.warn("Problem sending message  ");
		} catch (JMSException e) {
			log.error("error in sending message", e);
		}
		
		/* AMQ doesn't shout down hook at end, hence forcing shut down here. Can be ignored for Tibco. */
		ctx.destroy();
		log.info("********* Finished Message Producer *********");
	}
	
	private static String getXmlAsString(){
		String xmlString = "";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("src/main/resources/sample/Response.xml");
			br  = new BufferedReader(fr);
			StringBuilder strbuilder = new StringBuilder();
			String line ="";
			while ((line = br.readLine()) != null) {
				strbuilder.append(line);
			}
			xmlString = strbuilder.toString();
			
			
		} catch (Exception e) {
			System.err.println("Error in reading file.");
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}				
			} catch (IOException e) {
				log.error("could't close buffer reader.", e);
			}
			try {
				if (fr != null) {
					fr.close();
				}				
			} catch (IOException e) {
				log.error("could't close file reader.", e);
			}
		}
		return xmlString;
	}

}
