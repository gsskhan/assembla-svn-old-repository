package com.citi.risk.dashboard.test.dao.impl;

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

import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.Apps;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppsDaoImplTest {
	
	private Logger log = Logger.getLogger(AppsDaoImplTest.class);
	@Autowired
	private AppsDao appsDao;
	@Test
	@Ignore
	public void getAppsDetailTest() throws Exception{
		String csiId = "161602";
		String appName = "OPTIMA";
		List<Apps> tmpList = appsDao.getAppsDetail(csiId, appName);
		log.info("A. Result List = " + tmpList);
		for (Apps apps : tmpList) {
			log.info("App Id="+ apps.getAppsId()+",App CSI Id="+apps.getAppCsid()+",appName="+apps.getAppName()
					+",App Area Id="+apps.getAppArea().getAppAreaId()+",App Area Name="+apps.getAppArea().getAppAreaName()
					+",Org Id="+apps.getAppArea().getOrg().getOrgId()+",Org Name="+apps.getAppArea().getOrg().getOrgName());
		}
		Assert.assertNotNull("list result should not be null", tmpList);
		Assert.assertEquals(1, tmpList.size());
	}
	
	@Test
	@Ignore
	public void getAppsTest() throws Exception{
		String csiId = "161602";
		String appName = "OPTIMA";
		Apps app = appsDao.getApps(csiId, appName);
		Assert.assertNotNull(app);
		log.info("App data returned = " + app);
		
		appName = "XYZ";
		app = appsDao.getApps(csiId, appName);
		Assert.assertNull(app);
		log.info("App data returned = " + app);		
		
	}
	
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}
	
	

}
