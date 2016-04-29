package com.citi.risk.dashboard.test.dao.impl;

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

import com.citi.risk.dashboard.dao.AcronymLookupDao;
import com.citi.risk.dashboard.entity.AcronymLookup;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AcronymLookupDaoImplTest {
	
	private Logger log = Logger.getLogger(AcronymLookupDaoImplTest.class);
	@Autowired
	private AcronymLookupDao acronymLookupDao;
	
	@Test
	@Ignore
	public void getRecordTest() throws Exception{
		String csi = "6684";
		String appName = "RAPID";
		AcronymLookup acronymLookup = acronymLookupDao.getRecord(csi, appName);
		log.info("Record = "+ acronymLookup );
		Assert.assertNotNull(acronymLookup);
		Assert.assertEquals(csi, acronymLookup.getLookupAppCsid());
		Assert.assertEquals(appName, acronymLookup.getLookupAppName());
	}

	public AcronymLookupDao getAcronymLookupDao() {
		return acronymLookupDao;
	}
	public void setAcronymLookupDao(AcronymLookupDao acronymLookupDao) {
		this.acronymLookupDao = acronymLookupDao;
	}
	
	

}
