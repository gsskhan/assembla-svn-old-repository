package com.citi.risk.dashboard.test.dao.impl;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.risk.dashboard.dao.ThresholdMasterDao;
import com.citi.risk.dashboard.entity.ThresholdMaster;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class ThresholdMasterDaoImplTest {
	
	private Logger log = Logger.getLogger(ThresholdMasterDaoImplTest.class);
	@Autowired
	private ThresholdMasterDao thresholdMasterDao;
	
	@Test
	@Ignore
	public void getAllRecordsForApplicationTest() throws Exception{
		String csiId = "8831";
		String appName = "CREDIT ENGINE";
		List<ThresholdMaster> tmpList = thresholdMasterDao.getAllRecordsForApplication(csiId, appName);
		log.info(tmpList);
		Assert.assertNotNull(tmpList);		
		
	}
	@Test
	@Ignore
	public void getColorCodeTest() throws Exception {
		// to get color without component
		String tmpColor = thresholdMasterDao.getColorCode("8831", "CREDIT ENGINE", "INFRASTRUCTURE", "ORACLEDB", "SPAT", 64.5);
		log.info("Found color ="+ tmpColor);
		Assert.assertNotNull("A. Colour for this case can't be null", tmpColor);
		
		tmpColor = thresholdMasterDao.getColorCode("161602", "OPTIMA", "FEEDS IN", "FEEDS-ARRIVED LATE", null, 10);
		log.info("Found color ="+ tmpColor);
		Assert.assertNotNull("B. Colour for this case can't be null", tmpColor);
		
		tmpColor = thresholdMasterDao.getColorCode("1234", "GO CRAZY", "INFRASTRUCTURE", "WEBSPHERE", null, 70);
		log.info("Found color ="+ tmpColor);
		Assert.assertNull("C. Colour for this case should be null", tmpColor);
	}
	
	
	public ThresholdMasterDao getThresholdMasterDao() {
		return thresholdMasterDao;
	}
	public void setThresholdMasterDao(ThresholdMasterDao thresholdMasterDao) {
		this.thresholdMasterDao = thresholdMasterDao;
	}		

}
