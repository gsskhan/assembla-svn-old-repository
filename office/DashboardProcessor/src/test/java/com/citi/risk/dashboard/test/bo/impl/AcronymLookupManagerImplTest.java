package com.citi.risk.dashboard.test.bo.impl;

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

import com.citi.risk.dashboard.bo.AcronymLookupManager;
import com.citi.risk.dashboard.entity.Apps;

/**
 * 
 * @author gk85985
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AcronymLookupManagerImplTest {
	
	private Logger log = Logger.getLogger(AcronymLookupManagerImplTest.class);
	
	@Autowired
	private AcronymLookupManager acronymLookupManager;
	
	@Test
	@Ignore
	public void getAppsDataTest() throws Exception {
		
		String csi = "6684";
		String appRandomName = "RAPID";
		Apps app = acronymLookupManager.getAppsData(csi, appRandomName);
		log.info("Returned = "+ app);
		Assert.assertNotNull(app);
		
		csi = "123";
		app = acronymLookupManager.getAppsData(csi, appRandomName);
		log.info("Returned = "+ app);
		Assert.assertNull(app);
		
	}


	// getter-setter methods
	public AcronymLookupManager getAcronymLookupManager() {
		return acronymLookupManager;
	}
	public void setAcronymLookupManager(AcronymLookupManager acronymLookupManager) {
		this.acronymLookupManager = acronymLookupManager;
	}
	

}
