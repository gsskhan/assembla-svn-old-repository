package com.citi.gpa.test.service;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.gpa.dao.GenericDao;
import com.citi.gpa.domain.AppData;
import com.citi.gpa.domain.AppDependency;
import com.citi.gpa.service.AppMappingService;
import com.citi.gpa.util.JsonCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppMappingServiceTest {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private AppMappingService appMappingService;
	@Autowired
	private GenericDao genericDao;
	
	@Test
	@Ignore
	public void testGetAllAppDependencyMap() throws JsonProcessingException, IOException{
		List<AppDependency> list = appMappingService.getAllAppDependency();
		Assert.assertNotNull(list);
		log.info(JsonCreator.getJson(list));
		for (AppDependency appDependencyMap : list) {
			log.info(appDependencyMap);
		}
		log.info("end ...");
	}
	
	@Test
	@Ignore
	public void testGetListOfAllInternalApps(){
		List<AppData> list = appMappingService.getListOfAllInternalApps();
		Assert.assertNotNull(list);
		for (AppData appData : list) {
			log.info(appData);
		}
		log.info("end ...");
	}
	

}
