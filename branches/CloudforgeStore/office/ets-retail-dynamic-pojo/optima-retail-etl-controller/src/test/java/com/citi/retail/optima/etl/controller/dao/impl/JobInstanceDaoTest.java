package com.citi.retail.optima.etl.controller.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.ETLBatchStatus;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.MessageLog;

/**
 * @author hs73849 Unit Test for Checking DAO Layer for Job Instance Object
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.dao.test.xml" })
public class JobInstanceDaoTest {

	@Autowired
	private JobInstanceDaoImpl jobInstanceDao;

	@Autowired
	private MessageLog messageLog;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Mock
	SimpleJdbcCall  jdbcCall;
	
	@Mock
	SqlParameterSource in;

	private HashMap<String,Object> map = null;
	
	@Before
	public void setup(){
		// MockitoAnnotations.initMocks(this);
		// map=new HashMap<String, Object>(1);
		// map.put("JOB_PROCESS_STATUS", "TRUE");
		// Mockito.when(jdbcCall.execute(in)).thenReturn(map);
	}

	@Test
	public void testUpdateJobCompletionStatus()
			throws OptimaRetailApplicationException {
		boolean isSuccess = jobInstanceDao.updateJobCompletionStatus(100000L);
		Assert.assertFalse(isSuccess);
	}

	@Test
	public void testUpdateJobRunningStatus()
			throws OptimaRetailApplicationException {
		int updateCount = jobInstanceDao.updateJobRunningStatus(0L, 0L,
				ETLBatchStatus.BTH_COMP);
		Assert.assertTrue(updateCount == 0);
	}

	@Test(expected = OptimaRetailApplicationException.class)
	public void testUpdateJobRunningStatusException()
			throws OptimaRetailApplicationException {
		int updateCount = jobInstanceDao.updateJobRunningStatus(0L, 0L, null);
		Assert.assertTrue(updateCount == 0);
	}

	@Test
	public void testGetJdbcTemplate() {
		Assert.assertEquals(jdbcTemplate, jobInstanceDao.getJdbcTemplate());
	}

	@Test
	public void testCreateUserSubmissionJobInstance()
			throws OptimaRetailApplicationException {
		MessageLog messageLog = new MessageLog();
		List<String> prdList = new ArrayList<String>();
		prdList.add("CRD");		
		messageLog.setEventType("DATA_ACQUISITION");
		messageLog.setMessageId(100L);
		messageLog.setCountryCode("TW");
		messageLog.setFileName("OR_CRD_TW_RSK_20130930_HIST_TW_20140131_Control_V10.cnt");
		messageLog.setFileType("cnt");
		messageLog.setReptPeriod("201402");
		messageLog.setProductList(prdList);		
		messageLog.setPriority(new BigInteger("20"));
		Map<String, Object> jobInstance = jobInstanceDao
				.createDataAcquisitionJobInstance(messageLog);
		Assert.assertNotNull(jobInstance);		
	}
	
	@Test
	public void testCreateUserSubmissionJobInstanceExceptionForWrongReportPeriod()
			throws OptimaRetailApplicationException {
		MessageLog messageLog = new MessageLog();
		List<String> prdList = new ArrayList<String>();
		prdList.add("CRD");		
		messageLog.setEventType("DATA_ACQUISITION");
		messageLog.setMessageId(100L);
		messageLog.setCountryCode("TW");
		messageLog.setFileName("OR_CRD_TW_RSK_20130930_HIST_TW_20140131_Control_V10.cnt");
		messageLog.setFileType("cnt");
		messageLog.setReptPeriod("20140209");  //wrong report period
		messageLog.setProductList(prdList);		
		messageLog.setPriority(new BigInteger("20"));
		Map<String, Object> jobInstance = jobInstanceDao
				.createDataAcquisitionJobInstance(messageLog);
		Assert.assertNotNull(jobInstance);		
	}	
	
}