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

import com.citi.risk.dashboard.bo.AppComStatusManager;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.util.ConstantsUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppComStatusManagerImplTest {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private AppsDao appsDao;
	@Autowired
	private AppComStatusManager appComStatusManager;
	
	@Test
	@Ignore
	public void testAddRecordToAppComStatus() throws Exception {
		Apps app = appsDao.getApps("8831",  "CREDIT ENGINE");
		String kpiCategoryName = ConstantsUtil.KPI_CAT_FEEDS_IN.getConstants();
		
		Assert.assertNotNull(app);
		
		log.info("Testing for "+kpiCategoryName);
		boolean status = appComStatusManager.addRecordToAppComStatus(app, kpiCategoryName, new Date());
		Assert.assertTrue(status);
		
		kpiCategoryName = ConstantsUtil.KPI_CAT_INFRA.getConstants();
		log.info("Testing for "+kpiCategoryName);
		status = appComStatusManager.addRecordToAppComStatus(app, kpiCategoryName, new Date());
		Assert.assertTrue(status);		
		
	}

	// getter-setter methods
	public AppComStatusManager getAppComStatusManager() {
		return appComStatusManager;
	}
	public void setAppComStatusManager(AppComStatusManager appComStatusManager) {
		this.appComStatusManager = appComStatusManager;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}

}
