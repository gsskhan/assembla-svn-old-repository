package com.citi.risk.dashboard.gk;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author gk85985
 * 
 * Test methods - not to be considered
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class NewAppStatusCalcX {
	
	private Logger log = Logger.getLogger(NewAppStatusCalcX.class);
	@Autowired
	private SessionFactory sessionFactory;	
	
	@Test
	@Ignore
	public void calculate() throws Exception{
		log.info("start.");
		String csiId = "8831";
		String appName = "CREDIT ENGINE";
		String kpiCategoryName = "FEEDS IN";
		String appKpiName = "FEEDS-LATE";
		//SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
		Timestamp latestTime = getLatestEventTimestamp(csiId, appName, kpiCategoryName, appKpiName);
		log.info("Latest Time = "+ latestTime);		
		log.info("Latest Id = " + getLatestEventId(csiId, appName, kpiCategoryName, appKpiName, latestTime));
		log.info("end.");
		
	}
	
	public List<?> getLatestTimestamp(String csiId, String appName, String kpiCategoryName){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select appKpiName , max(lastUpdate) from AppEvent "
				+ " where appCsid = :vappCsid "
				+ " and appName = :vappName "
				+ " and kpiCatName = :vkpiCatName "
				+ " group by appKpiName " );
		query.setString("vappCsid", csiId);
		query.setString("vappName", appName);
		query.setString("vkpiCatName", kpiCategoryName);		
		return query.list();
	}
	
	public Timestamp getLatestEventTimestamp(String csiId, String appName, String kpiCategoryName, String appKpiName){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select max(eventTimeStamp) from AppEvent "
				+ " where appCsid = :vappCsid "
				+ " and appName = :vappName "
				+ " and kpiCatName = :vkpiCatName "
				+ " and appKpiName = :vappKpiName " );
		query.setString("vappCsid", csiId);
		query.setString("vappName", appName);
		query.setString("vkpiCatName", kpiCategoryName);	
		query.setString("vappKpiName", appKpiName);
		return (query.list().isEmpty() ? null:  (Timestamp)query.list().get(0));
	}
	
	public List<?> getLatestEventId(String csiId, String appName, String kpiCategoryName, String appKpiName, Timestamp latestTime){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select appEventId from AppEvent "
				+ " where appCsid = :vappCsid "
				+ " and appName = :vappName "
				+ " and kpiCatName = :vkpiCatName "
				+ " and appKpiName = :vappKpiName "
				+ " and eventTimeStamp = :veventTimeStamp " );
		query.setString("vappCsid", csiId);
		query.setString("vappName", appName);
		query.setString("vkpiCatName", kpiCategoryName);	
		query.setString("vappKpiName", appKpiName);
		query.setTimestamp("veventTimeStamp", latestTime);
		return query.list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
