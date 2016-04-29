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

import com.citi.risk.dashboard.bo.AppOverStatManager;
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
public class AppOverStatManagerImplTest {
	
	private Logger log = Logger.getLogger(AppOverStatManagerImplTest.class);
	@Autowired
	private AppOverStatManager appOverStatManager;
	@Autowired
	private AppsDao appsDao;
	
	@Test
	@Ignore
	public void addToAppOverStatTest() throws Exception{
		Apps app = appsDao.getApps("8831",  "CREDIT ENGINE");
		Assert.assertNotNull(app);
		boolean status = appOverStatManager.addToAppOverStat(app, new Date());
		//boolean status = appOverStatManager.addToAppOverStat("33343", "CREDIT ANALYTICS WORKSTATION");
		log.info("status = "+ status);
		Assert.assertTrue(status);
	}
	
	
	public AppOverStatManager getAppOverStatManager() {
		return appOverStatManager;
	}
	public void setAppOverStatManager(AppOverStatManager appOverStatManager) {
		this.appOverStatManager = appOverStatManager;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}	
	

}
