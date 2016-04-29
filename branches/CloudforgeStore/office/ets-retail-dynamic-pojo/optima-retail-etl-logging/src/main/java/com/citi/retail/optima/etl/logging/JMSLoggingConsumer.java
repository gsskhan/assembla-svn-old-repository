package com.citi.retail.optima.etl.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hs73849
 * 
 */
public final class JMSLoggingConsumer {

	private JMSLoggingConsumer() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(JMSLoggingConsumer.class);

	public static void main(String[] args) {
		try {
			MDC.put("LogFileName", "ExceptionHandler");

			@SuppressWarnings("resource")
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"/retail.optima.etl.logging.jms.xml",
					"/retail.optima.etl.logging.exception.xml",
					"/retail.optima.etl.logging.exception.receiver.xml",
					"/retail.optima.etl.logging.exception.dao.xml");
			context.start();
		} catch (Exception exception) {
			LOGGER.error(" Error while starting the exception loggin module "+exception);
		}
	}
}
