package com.citi.risk.dashboard.test.bo.impl;


import java.util.Date;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.risk.dashboard.bo.impl.AppEventsManagerImpl;
import com.citi.risk.dashboard.dao.AppEventDao;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.Apps;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppEventsManagerImplTest {
	
	
	@Autowired
	private AppEventDao appEventDAO;	
	@Autowired
	private AppsDao appsDao;	
	@Autowired
	private AppEventsManagerImpl dsbdmgr;	
	

	@Test
	@Ignore
	public void valInParamsTest(){
		boolean status = dsbdmgr.valInParams("8831", "CREDIT ENGINE", "APPLICATION CPU", "INFRASTRUCTURE", "65%");
		Assert.assertTrue("step1: status should be true.", status );
		status = dsbdmgr.valInParams("", "CREDIT ENGINE", "APPLICATION CPU", "INFRASTRUCTURE", "65%");
		Assert.assertFalse("step2: status should be false.", status);
		status = dsbdmgr.valInParams(null, "CREDIT ENGINE", "APPLICATION CPU", "INFRASTRUCTURE", "65%");
		Assert.assertFalse("step3: status should be false.", status);
	}
	
	@Test
	@Ignore
	public void addRecordToAppEventsTest() throws Exception{
		Apps app = appsDao.getApps("8831",  "CREDIT ENGINE");
		Assert.assertNotNull(app);
		boolean status = dsbdmgr.addRecordToAppEvents(app, "WEBSPHERE", "INFRASTRUCTURE", "78%", "above normal server utilization", "DISKUSAGE", new Date(), "0568452157",new Date());
		Assert.assertTrue("step4: status should be true", status);
	}
	
	// getter-setters
	
	public AppEventDao getAppEventDAO() {
		return appEventDAO;
	}
	public void setAppEventDAO(AppEventDao appEventDAO) {
		this.appEventDAO = appEventDAO;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}	
	public AppEventsManagerImpl getDsbdmgr() {
		return dsbdmgr;
	}
	public void setDsbdmgr(AppEventsManagerImpl dsbdmgr) {
		this.dsbdmgr = dsbdmgr;
	}

}
