package com.citi.retail.optima.etl.common.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.log.LoggingPublisher;

/**
 * @author hs73849 This Junit Class is to test Publishing the Exception Object
 */
// @Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"/retail.optima.etl.logging.exception.publisher.test.xml",
		"/data/optima.logger.exception.test.data.xml" })
public class ExceptioMessagePublisherTest {

	@Autowired
	private LoggingPublisher<Exception> jmsExceptionPublisher;

	@Autowired
	private OptimaRetailApplicationException optimaRetailApplicationExceptionTestData;

	@Test
	public void testExceptionPublishing() throws Exception {

		System.out.println(" Start Time " + System.currentTimeMillis());

		// for(int i=0; i <100000; i++)
		jmsExceptionPublisher.publish(optimaRetailApplicationExceptionTestData);

		System.out.println(" End Time " + System.currentTimeMillis());
	}
}
