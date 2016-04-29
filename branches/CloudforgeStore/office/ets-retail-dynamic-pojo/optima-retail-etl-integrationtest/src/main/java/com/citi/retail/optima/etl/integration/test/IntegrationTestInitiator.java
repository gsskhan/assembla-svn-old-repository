package com.citi.retail.optima.etl.integration.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class IntegrationTestInitiator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationTestInitiator.class);
	
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		IntegrationTestInitiator moduleInitiator = new IntegrationTestInitiator();
		moduleInitiator.launchBatchModule();
	}

	public void launchBatchModule() {
			try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
						"/retail.optima.etl.integration.test.xml");	
			context.start();
		} catch (BeansException e) {
			LOGGER.error(e.toString());
		}
	}


}
