package com.citi.retail.optima.etl.common.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.common.log.LoggingMarker;

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/retail.optima.etl.logging.exception.publisher.test.xml" })
public class LoggerTest {

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(LoggerTest.class);

	@Test
	public void testConsoleLogger() throws Exception {
		LOGGER.error(LoggingMarker.CONSOLE.getMarker(),
				"This is the testing for console logging");
	}

	@Test
	public void testSiftigLogger() throws Exception {
		MDC.put("LogFileName", "File1");
		LOGGER.error("This is the testing for Sifting logging. This content should be logged to File1");
		MDC.put("LogFileName", "File2");
		LOGGER.error("This is the testing for Sifting logging. This content should be logged to File2");
	}
	
	@Test
   public void testSMTPLogger() throws Exception {
         LOGGER.error(LoggingMarker.SMTP.getMarker(), 
        		 "This is the testing for SMTP logging - ERROR. This should be logged");
	   }
}