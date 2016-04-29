package com.citi.risk.dashboard.test.bo.impl;



import java.util.Date;
import java.util.List;

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

import com.citi.risk.dashboard.bo.AppStatusManager;
import com.citi.risk.dashboard.bo.impl.AppEventsManagerImpl;
import com.citi.risk.dashboard.bo.impl.AppStatusManagerImpl;
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
public class AppStatusManagerImplTest {
	
	private Logger log = Logger.getLogger(AppEventsManagerImpl.class);
	@Autowired
	private AppStatusManagerImpl appStatusManager;
	@Autowired
	private AppsDao appsDao;
	
	@Test
	@Ignore
	public void csvlistOfLatestIdTest() throws Exception{
		Apps app = appsDao.getApps("8831", "CREDIT ENGINE");
		Assert.assertNotNull(app);
		String csvStr = appStatusManager.csvlistOfLatestId(app.getAppsId(), "FEEDS IN");
		Assert.assertNotNull(csvStr);
		log.info("csv list = " + csvStr);
		
		app = appsDao.getApps("8831", "WRONG APP NAME");
		Assert.assertNull(app);
		long appsId = (app == null)? 0:app.getAppsId();
		csvStr = appStatusManager.csvlistOfLatestId(appsId, "FEEDS IN");
		Assert.assertNull(csvStr);
		log.info("csv list = " + csvStr);
		
	}
	
	@Test
	@Ignore
	public void getListColorCodeTest() throws Exception {
		List<String> retList = appStatusManager.getListColorCode("4,7");
		Assert.assertNotNull(retList);
		log.info(retList);
		
		retList = appStatusManager.getListColorCode(null);
		Assert.assertNull(retList);
		log.info(retList);
		
		retList = appStatusManager.getListColorCode("");
		Assert.assertNull(retList);
		log.info(retList);		
		
	}

	@Test
	@Ignore
	public void addRecordToAppStatusTest() throws Exception{
		Apps app = appsDao.getApps("8831",  "CREDIT ENGINE");
		Assert.assertNotNull(app);
		boolean status = appStatusManager.addRecordToAppStatus(app, "INFRASTRUCTURE", new Date() );
		Assert.assertEquals("Should return true.", true, status );
	}
	
	// getter-setter methods
	public AppStatusManager getAppStatusManager() {
		return appStatusManager;
	}
	public void setAppStatusManager(AppStatusManagerImpl appStatusManager) {
		this.appStatusManager = appStatusManager;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}
	
		

}
