package com.citi.ets.publisher.test.dao.impl;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.ets.publisher.dao.RtviewEtsAlertsDao;

/**
 * 
 * @author gk85985
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-jdbc.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "jdbcTransactionManager")
@Transactional
public class RtviewEtsAlertsDaoImplTest {
	
	private Logger log = Logger.getLogger(RtviewEtsAlertsDaoImplTest.class);
	@Autowired
	private RtviewEtsAlertsDao rtviewAlertsDao;
	
	
	@Test
	@Ignore
	public void getMinTimeOfAllTest(){
		Timestamp minTime = rtviewAlertsDao.getMinTimeOfAll();
		log.info("Returned Min time = " + minTime);
		
	}

}
