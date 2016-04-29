package com.citi.risk.dashboard.test.bo.impl;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.risk.dashboard.bo.NoDataManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback=true)
@Transactional
public class NoDataManagerImplTest {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	NoDataManager noDataManager;
	
	@Test
	@Ignore
	public void testAddNotApplicableRecords() throws Exception{
		log.info("Begin test for addNotApplicableRecords() .. ");
		noDataManager.addNotApplicableRecords();		
	}

	// getter-setter methods
	public NoDataManager getNoDataManager() {
		return noDataManager;
	}
	public void setNoDataManager(NoDataManager noDataManager) {
		this.noDataManager = noDataManager;
	}

}
