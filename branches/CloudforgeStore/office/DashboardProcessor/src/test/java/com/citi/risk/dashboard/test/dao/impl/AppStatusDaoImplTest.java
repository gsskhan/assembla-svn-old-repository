package com.citi.risk.dashboard.test.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.risk.dashboard.dao.AppStatusDao;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.AppStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.util.ConstantsUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppStatusDaoImplTest {
	
	private Logger log = Logger.getLogger(AppStatusDaoImplTest.class);

	@Autowired
	private AppStatusDao appStatusDao;	
	@Autowired
	private AppsDao appsDao;


	@Test
	@Ignore
	public void saveAppStatusTest() throws Exception{
		String csiId = "8831";
		String appName = "CREDIT ENGINE";
		String kpiCategoryName ="INFRASTRUCTURE";
		String appCompStatus = ConstantsUtil.COL_AMBER.getConstants();
		Date lastUpdate = new Date();
		String lastUpdateBy = ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants();
		
		List<Apps> appList = appsDao.getAppsDetail(csiId, appName);
		Apps app = null;
		for (Apps apps : appList) {
			app = apps;
			break;
		}		
		AppStatus appStatus = new AppStatus(app, kpiCategoryName, appCompStatus, lastUpdate, lastUpdateBy);
		appStatusDao.saveAppStatus(appStatus);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Ignore
	public void listMaxIdByKpiCatNameTest() throws Exception{
		String csiId = "8831";
		String appName = "CREDIT ENGINE";
		Apps apps = appsDao.getApps(csiId, appName);
		Assert.assertNotNull(apps);
		log.info("App id = "+ apps.getAppsId());
		
		List<Object> tmplist = (List<Object>) appStatusDao.listMaxIdByKpiCatName(apps.getAppsId());
		Assert.assertNotNull(tmplist);
		Iterator<Object> itr = tmplist.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			log.info(obj[0]+" , "+ obj[1]);
			
		}		
		
	}
	@SuppressWarnings("unchecked")
	@Test @Ignore
	public void listOfColorCodes() throws Exception{
		List<Object> tmpList = (List<Object>) appStatusDao.listOfColorCodes("1,11,2");
		Assert.assertNotNull(tmpList);
		Iterator<Object> itr = tmpList.iterator();
		while (itr.hasNext()) {
			String colr = (String) itr.next();
			log.info("color code - " + colr);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Ignore
	public void listMaxIdByArea() throws Exception {
		List<Object> tmpList = (List<Object>) appStatusDao.listMaxIdByArea(2, "INFRASTRUCTURE");
		Assert.assertNotNull(tmpList);
		Iterator<Object> itr = tmpList.iterator();
		log.info("APP_ID , APP_STATUS_ID ");
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			log.info(obj[0]+" , "+obj[1]);
		}
		
	}
	
	
	
	public AppStatusDao getAppStatusDao() {
		return appStatusDao;
	}
	public void setAppStatusDao(AppStatusDao appStatusDao) {
		this.appStatusDao = appStatusDao;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}
	
	
	
}
