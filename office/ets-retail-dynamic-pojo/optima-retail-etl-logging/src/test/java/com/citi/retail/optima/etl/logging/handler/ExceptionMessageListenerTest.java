package com.citi.retail.optima.etl.logging.handler;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.logging.dao.ExceptionMessageDao;

/**
 * @author hs73849 Unit Test for Checking DAO Layer for Exception Message Object
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"/retail.optima.etl.logging.exception.dao.xml",
		"/data/optima.logger.exception.test.data.xml",
		"/retail.optima.etl.logging.jms.xml",
		"/retail.optima.etl.logging.exception.xml",
		"/retail.optima.etl.logging.exception.receiver.xml" })
public class ExceptionMessageListenerTest {

	@Autowired
	private ExceptionMessageListener exceptionMessageListener;

	@Autowired
	private ExceptionMessageDao exceptionMessageDao;

	@Autowired
	private OptimaRetailApplicationException optimaRetailApplicationExceptionTestData;
	
	@Test
	public void testExceptionMessageDao() {
		Assert.assertEquals(exceptionMessageDao,
				exceptionMessageListener.getExceptionMessageDao());
	}

	@Test
	public void testSaveException() {

//		Assert.assertEquals(optimaControllerExceptionTestData
//				.getExceptionType().name(), "ERROR");
//		Assert.assertEquals(this.exceptionMessageListener
//				.exceptionHandler(optimaRetailApplicationExceptionTestData,optimaRetailApplicationExceptionTestData.toString()), true);
//
//		optimaControllerExceptionTestData.setExceptionType(ExceptionType.ERROR);
//		Assert.assertEquals(optimaControllerExceptionTestData
//				.getExceptionType().name(), "ERROR");
//		Assert.assertEquals(this.exceptionMessageListener
//				.exceptionHandler(optimaRetailApplicationExceptionTestData,optimaRetailApplicationExceptionTestData.toString()), true);
//
//		optimaControllerExceptionTestData
//				.setExceptionType(ExceptionType.NONSKIPPABLE);
//		Assert.assertEquals(optimaControllerExceptionTestData
//				.getExceptionType().name(), "NONSKIPPABLE");
//		Assert.assertEquals(this.exceptionMessageListener
//				.exceptionHandler(optimaRetailApplicationExceptionTestData,optimaRetailApplicationExceptionTestData.toString()), true);
//
//		optimaControllerExceptionTestData
//				.setExceptionType(ExceptionType.SKIPPABLE);
//		Assert.assertEquals(optimaControllerExceptionTestData
//				.getExceptionType().name(), "SKIPPABLE");
//		Assert.assertEquals(this.exceptionMessageListener
//				.exceptionHandler(optimaRetailApplicationExceptionTestData,optimaRetailApplicationExceptionTestData.toString()), true);
//
//		optimaControllerExceptionTestData
//				.setExceptionType(ExceptionType.WARNING);
//		Assert.assertEquals(optimaControllerExceptionTestData
//				.getExceptionType().name(), "WARNING");
		Assert.assertEquals(this.exceptionMessageListener
				.exceptionHandler(optimaRetailApplicationExceptionTestData,optimaRetailApplicationExceptionTestData.toString()), true);

		//Assert.assertEquals(
				//this.exceptionMessageListener.exceptionHandler(null), false);
	}
}