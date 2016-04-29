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

import com.citi.risk.dashboard.dao.AppAreaDao;
import com.citi.risk.dashboard.dao.OrganisationDao;
import com.citi.risk.dashboard.entity.AppArea;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppAreaDaoImplTest {
	
	private Logger log = Logger.getLogger(AppAreaDaoImplTest.class);
	@Autowired
	private AppAreaDao appAreaDao;
	@Autowired
	private OrganisationDao organisationDao;
	
	@Test
	@Ignore
	public void getAppAreaDetailsTest() throws Exception{
		long tmpId = 2;
		List<AppArea> tmpList =  appAreaDao.getAppAreaDetails(tmpId);
		log.info("A. Result = "+ tmpList);
		for (AppArea appArea : tmpList) {
			log.info("Area ID =" + appArea.getAppAreaId() +", Area Name = "+ appArea.getAppAreaName() +
							",Org Id ="+ appArea.getOrg().getOrgId() + ",Org Name="+ appArea.getOrg().getOrgName()+".");
		}
		Assert.assertNotNull("A. For Area id = "+ tmpId+" list shouldnot be empty." ,  tmpList);
		Assert.assertEquals(1, tmpList.size());
		
	}	
	/*
	@Test
	public void findAllAreaForOrgTest() throws Exception {
		long tempOrgId= 1;
		List<?> tmpList = appAreaDao.findAllAreaForOrg(tempOrgId);
		Iterator<?> itr = tmpList.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			long areaId =  (Long) obj[0];
			String areaName = (String) obj[1];
			log.info(areaId+" , "+areaName);			
		}		
	}
	*/
	
	

	public AppAreaDao getAppAreaDao() {
		return appAreaDao;
	}
	public void setAppAreaDao(AppAreaDao appAreaDao) {
		this.appAreaDao = appAreaDao;
	}
	
}
