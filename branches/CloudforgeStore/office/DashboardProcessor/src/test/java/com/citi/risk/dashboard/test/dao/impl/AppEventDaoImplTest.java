package com.citi.risk.dashboard.test.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import com.citi.risk.dashboard.dao.AppEventDao;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.AppEvent;
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
public class AppEventDaoImplTest {
	
	private Logger log = Logger.getLogger(AppEventDaoImplTest.class);
	
	@Autowired
	private AppEventDao appEventDao;
	@Autowired
	private AppsDao appsDao;
	
	@Test
	@Ignore
	public void saveAppEventsTest() throws Exception{
		
		String appCsid = "8831";
		String appName = "CREDIT ENGINE";
		String appKpiName ="WEBSPHERE";
		String kpiCatName = "INFRASTRUCTURE";
		String kpiValue ="70%";
		String eventMessage="this is test message";
		String kpiParameter="DISKUSAGE";
		String appEventCatStatus = "#FF0000"; //need to calculate first then save.
		Date eventTimeStamp = new Date(); // need to parse xml tag and then fill here
		String correlationId = null ; //need to come from message processing class
		Date lastUpdate = new Date();
		String lastUpdateBy = "GK85985";
		
		List<Apps> applist = appsDao.getAppsDetail("8831", "CREDIT ENGINE");
		log.info("Result list = "+ applist);
		if (applist != null && applist.size() >0 ) {
			for (Apps apps : applist) {			
				
				appEventDao.saveAppEvents(new AppEvent(apps, appCsid, appName, appKpiName , kpiCatName 
						, kpiValue, eventMessage, kpiParameter, appEventCatStatus, eventTimeStamp
						, correlationId, lastUpdate, lastUpdateBy));
			}
			
		}
		Assert.assertNotNull(applist);		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Ignore
	public void listMaxIdByKpiCatNameTest() throws Exception{
		String appCsid = "8831";
		String appName = "CREDIT ENGINE";
		String kpiCatName = "FEEDS IN";
		Apps app = appsDao.getApps(appCsid, appName);
		Assert.assertNotNull(app);
		log.info(app);
		List<Object> tmpList = (List<Object>) appEventDao.listMaxIdByKpiCatName(app.getAppsId(), kpiCatName);
		Assert.assertNotNull(tmpList);
		Iterator<Object> itr = (Iterator<Object>) tmpList.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			log.info(obj[0] + " | "+ obj[1]);			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Ignore
	public void listOfColorCodesTest() throws Exception {		
		List<Object> tmpList = (List<Object>) appEventDao.listOfColorCodes("4,7");
		Assert.assertNotNull(tmpList);
		Iterator<Object> itr = (Iterator<Object>) tmpList.iterator();
		while (itr.hasNext()) {
			String col = (String) itr.next();
			log.info(col);			
		}
		
	}

	public AppEventDao getAppEventDao() {
		return appEventDao;
	}
	public void setAppEventDao(AppEventDao appEventDao) {
		this.appEventDao = appEventDao;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}
	
	

}
