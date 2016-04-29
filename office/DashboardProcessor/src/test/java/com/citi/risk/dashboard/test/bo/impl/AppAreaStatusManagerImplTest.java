package com.citi.risk.dashboard.test.bo.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.risk.dashboard.bo.AppAreaStatusManager;
import com.citi.risk.dashboard.dao.AppsDao;
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
public class AppAreaStatusManagerImplTest {
	
	private Logger log = Logger.getLogger(AppAreaStatusManagerImplTest.class);
	@Autowired
	private AppAreaStatusManager appAreaStatusManager;
	@Autowired
	private AppsDao appsDao;
	
	@Test
	@Ignore
	public void addRecordToAppAreasStatusTest() throws Exception {
		Apps app = appsDao.getApps("8831",  "CREDIT ENGINE");
		Assert.assertNotNull(app);
		boolean status = appAreaStatusManager.addRecordToAppAreasStatus(app, "INFRASTRUCTURE", new Date());
		Assert.assertTrue(status);
		log.info("status = "+ status);
	}

	public AppAreaStatusManager getAppAreaStatusManager() {
		return appAreaStatusManager;
	}
	public void setAppAreaStatusManager(AppAreaStatusManager appAreaStatusManager) {
		this.appAreaStatusManager = appAreaStatusManager;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}

	

}
