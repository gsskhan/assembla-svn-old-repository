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

import com.citi.risk.dashboard.dao.OrganisationDao;
import com.citi.risk.dashboard.entity.Organisation;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class OrganisationDaoImplTest {
	
	private Logger log = Logger.getLogger(OrganisationDaoImplTest.class);
	
	@Autowired
	private OrganisationDao organisationDao;
	
	@Test
	@Ignore
	public void getOrgDetailsTest() throws Exception{
		long tempId = 1;
		List<Organisation>  tempList = organisationDao.getOrgDetails(tempId);
		log.info("A. Result returned = " + tempList);
		Assert.assertNotNull("Organisation with org_id = "+ tempId + "should be present.", tempList);
		Assert.assertEquals(1, tempList.size());
		tempList.clear();
		
		tempId = 100;
		tempList = organisationDao.getOrgDetails(tempId);
		log.info("B. Result returned = " + tempList);
		Assert.assertNotNull("Organisation with org_id = "+ tempId + "shouldnot be present.", tempList);
		Assert.assertEquals(0, tempList.size());
		
		
	}
	
	

	public OrganisationDao getOrganisationDao() {
		return organisationDao;
	}
	public void setOrganisationDao(OrganisationDao organisationDao) {
		this.organisationDao = organisationDao;
	}
	
	

}
