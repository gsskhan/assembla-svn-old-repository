package com.citi.retail.optima.etl.controller.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.EventFileMapVO;
import com.citi.retail.optima.etl.controller.model.MessageLog;

/**
 * @author hs73849
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/retail.optima.etl.controller.dao.test.xml" })
public class JobMessageDaoTest {

	@Autowired
	private JobMessageDaoImpl jobMessageDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static MessageLog messageLog;
	private static MessageLog internalMessageLog;
	
	private static final String GENESIS_MESSAGE_FILE = "Genesis_Feed_Request.xml";

	private static final String INTERNAL_MESSAGE_FILE = "Internal_Feed_Request.xml";
	
	private Connection connection;

	@Before
	public void setupTest() {
		messageLog = new MessageLog();
		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Exception in Init " + "Method while Loading");
		}		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder = new StringBuilder();
	}

	@Test
	public void testJdbcTemplate() {
		Assert.assertEquals(jdbcTemplate, jobMessageDao.getJdbcTemplate());
	}

	@Test
	@Ignore
	public void testSaveInternalMessageDetails() throws Exception {
		jobMessageDao.saveUserSubmissionMessageDetails(messageLog);
	}
	
	@Test
	public void testSaveDataAcquisitionMessageDetails() throws OptimaRetailApplicationException{
		List<String> prdList = new ArrayList<String>();
		prdList.add("CRD");
		messageLog.setEventType("DATA_ACQUISITION");
		messageLog.setMessageId(jobMessageDao.getRequestLogId());
		messageLog.setCountryCode("TW");
		messageLog.setFileName("OR_CRD_TW_RSK_20130930_HIST_TW_20140131_Control_V10.cnt");
		messageLog.setFileType("cnt");
		messageLog.setReptPeriod("201402");
		messageLog.setProductList(prdList);
		jobMessageDao.saveDataAcquisitionMessageDetails(messageLog);
	}
	
	@Test
	public void testInsertIntoFileLog()throws OptimaRetailApplicationException{
		Long log_id = 21667L;
		List<String> fileNameList = new ArrayList<String>();
		fileNameList.add("Ord_TW_CRD_tw_ecs_epp1309_20140219_105102_V2.dat");
		fileNameList.add("Ord_TW_CRD_tw_rnbw1309_20140219_104703_V2.dat");
		fileNameList.add("Ord_TW_CRD_tw_ecs_fico1309_20140219_105105_V2.dat");
		fileNameList.add("Ord_TW_CRD_tw_ecs_ntb1309_20140219_105113_V2.dat");
		fileNameList.add("Ord_TW_CRD_tw_ecs_rec1309_20140219_105114_V2.dat");
		fileNameList.add("Ord_TW_CRD_tw_ecs_tdr1309_20140219_105115_V2.dat");
		int iCnt  =  jobMessageDao.insertIntoFileLog(log_id, fileNameList);
		Assert.assertEquals(iCnt > 0, true);
	}
	
	@Test
	public void testGetSupportingFilesInfo() throws OptimaRetailApplicationException{
		Long req_event_id = 10L;
		List<EventFileMapVO> eventFileMapVo = new ArrayList<EventFileMapVO>();
		eventFileMapVo = jobMessageDao.getSupportingFilesInfo(req_event_id);
		Assert.assertNotNull(eventFileMapVo);
		Assert.assertEquals(eventFileMapVo.size() >= 0, true);
	}
	
	
	@Test
	public void testUpdateReqLogStatus() throws OptimaRetailApplicationException{
		List<String> prdList = new ArrayList<String>();
		prdList.add("CRD");
		messageLog.setEventType("DATA_ACQUISITION");
		Long requestLogId=jobMessageDao.getRequestLogId();
		messageLog.setMessageId(requestLogId);
		messageLog.setCountryCode("TW");
		messageLog.setFileName("OR_CRD_TW_RSK_20130930_HIST_TW_20140131_Control_V10.cnt");
		messageLog.setFileType("cnt");
		messageLog.setReptPeriod("201402");
		messageLog.setProductList(prdList);
		jobMessageDao.saveDataAcquisitionMessageDetails(messageLog);
		
		int cnt = jobMessageDao.updateReqLogStatus(requestLogId, "FAILED");
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testGetAllFilesByReqLog() throws OptimaRetailApplicationException{
		Long bthInstId = 5536L;
		try {
		
			List<String> fileNameList = jobMessageDao.getAllFilesByReqLog(bthInstId);
			Assert.assertNotNull(fileNameList);
			Assert.assertEquals(fileNameList.size() >= 0, true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}

