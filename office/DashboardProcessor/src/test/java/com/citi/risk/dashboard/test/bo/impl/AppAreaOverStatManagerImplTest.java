package com.citi.risk.dashboard.test.bo.impl;

import java.util.Date;

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

import com.citi.risk.dashboard.bo.AppAreaOverStatManager;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.Apps;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppAreaOverStatManagerImplTest {
	
	private Logger log = Logger.getLogger(AppAreaOverStatManagerImplTest.class);
	@Autowired
	private AppsDao appsDao;
	@Autowired
	private AppAreaOverStatManager appAreaOverStatManager;
	
	@Test
	@Ignore
	public void addRecordToAppAreaOverStat() throws Exception{
		Apps app = appsDao.getApps("8831",  "CREDIT ENGINE");
		Assert.assertNotNull(app);
		boolean status = appAreaOverStatManager.addRecordToAppAreaOverStat(app, new Date());
		log.info("Status =" + status);
		Assert.assertTrue(status);
		
		
	}
	
	
	// getter-setter methods
	public AppAreaOverStatManager getAppAreaOverStatManager() {
		return appAreaOverStatManager;
	}
	public void setAppAreaOverStatManager(
			AppAreaOverStatManager appAreaOverStatManager) {
		this.appAreaOverStatManager = appAreaOverStatManager;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}

}
