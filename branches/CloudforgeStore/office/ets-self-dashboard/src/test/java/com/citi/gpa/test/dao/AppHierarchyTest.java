package com.citi.gpa.test.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.gpa.dao.GenericDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppHierarchyTest {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private GenericDao genericDao;
	
	@Test
	@Ignore
	public void testGetAllAppHierarchy(){
		List<Object[]> list = genericDao.getList("select appHierarchyId, app.appName, app.appCsiId, dependentApp_id, streamFlag "
				+ " from AppHierarchy ", null, 1000000);
		for (Object[] obj : list) {
			log.info(obj[0] +"," + obj[1] + "," + obj[2]);
		}	
		log.info("end ...");			
		
	}

}
