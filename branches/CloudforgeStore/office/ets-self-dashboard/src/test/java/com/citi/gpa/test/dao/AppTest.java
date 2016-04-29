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

import com.citi.gpa.dao.GenericDao;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class AppTest {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private GenericDao genericDao;
	
	@Test
	@Ignore
	public void testGetAllAppMapping(){
		List<Object[]> list = genericDao.getList(" select a.appId, "
				+ " a.appCsiId , "
				+ " a.appName ,"
				+ " (select d.appName from App d where d.appId = ah.dependentApp_id ),"
				+ " (select d.appCsiId from App d where d.appId = ah.dependentApp_id ),"
				+ " ah.streamFlag "
				+ " from App a , AppHierarchy ah "
				+ " where a.appId = ah.app", null, 10000000);
		for (Object[] obj : list) {
			log.info(obj[0] +"," + obj[1] + "," + obj[2] + "," + obj[3]+ "," + obj[4] + ","  + obj[5] );
		}		
		log.info("end ...");
	}
	
	@Test
	@Ignore
	public void testGetAllAppNoMapping(){
		List<String> list = genericDao.getList(" select distinct a.appName from App a "
				+ " where a.appId not in (select distinct ah.app.appId from AppHierarchy ah) "
				+ " and a.appId not in (select distinct dependentApp_id from AppHierarchy) " , null, 10000000);
		for (String appname : list) {
			log.info(appname);
		}		
		log.info("end ...");
		
	}

}
