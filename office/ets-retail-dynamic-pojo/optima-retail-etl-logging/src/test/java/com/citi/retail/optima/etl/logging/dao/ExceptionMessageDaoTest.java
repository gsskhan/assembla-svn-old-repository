package com.citi.retail.optima.etl.logging.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.logging.dao.impl.ExceptionMessageDaoImpl;

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
public class ExceptionMessageDaoTest {

	@Autowired
	private ExceptionMessageDaoImpl exceptionMessageDao;
		
	@Autowired
	private OptimaRetailApplicationException optimaRetailApplicationExceptionTestData;


	@Test
	public void testSaveApplicationException() throws Exception {

		Boolean result = this.exceptionMessageDao
				.saveException(optimaRetailApplicationExceptionTestData,optimaRetailApplicationExceptionTestData.toString());
		Assert.isTrue(result);
		
	}

	
/*	@Test(expected = Exception.class)
	public void testSaveJobMessageDetailsException() throws Exception {
		Boolean result = this.exceptionMessageDao.saveException(null);
		Assert.isTrue(!result);
	}*/
}