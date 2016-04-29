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

import com.citi.risk.dashboard.dao.AppOverallStatusDao;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.AppOverallStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * 
 * @author gk85985
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppOverallStatusDaoImplTest {
	
	private Logger log = Logger.getLogger(AppOverallStatusDaoImplTest.class);
	@Autowired
	private AppOverallStatusDao appOverallStatusDao;
	@Autowired
	private AppsDao appsDao;
	
	@Test
	@Ignore
	public void saveAppOverallStatusTest() throws Exception{
		Apps apps = appsDao.getApps("8831", "CREDIT ENGINE");
		Assert.assertNotNull(apps);
		log.info("App Id = "+ apps.getAppsId()+", CSI id = "+ apps.getAppCsid()+",App Name="+ apps.getAppName());
		String appOverallStatus = ConstantsUtil.COL_AMBER.getConstants();
		Date lastUpdate = new Date();
		String lastUpdateBy = ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants();		
		if (apps != null) {
			appOverallStatusDao.saveAppOverallStatus(new AppOverallStatus(apps, appOverallStatus, lastUpdate, lastUpdateBy));
			
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	@Ignore
	public void listMaxIdByAppTest() throws Exception {
		List<Object> tmpList = (List<Object>) appOverallStatusDao.listMaxIdByApp(2);
		Assert.assertNotNull(tmpList);
		log.info("app id, latest_status_id");
		Iterator<Object> itr = tmpList.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			log.info(obj[0]+" , "+ obj[1]);
		}		
	}
	
	public AppOverallStatusDao getAppOverallStatusDao() {
		return appOverallStatusDao;
	}
	public void setAppOverallStatusDao(AppOverallStatusDao appOverallStatusDao) {
		this.appOverallStatusDao = appOverallStatusDao;
	}
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}
	
	

}
