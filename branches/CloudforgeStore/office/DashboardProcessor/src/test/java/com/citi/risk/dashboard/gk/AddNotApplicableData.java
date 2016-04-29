package com.citi.risk.dashboard.gk;

import java.util.ArrayList;
import java.util.Date;
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

import com.citi.risk.dashboard.dao.AppAreaStatusDao;
import com.citi.risk.dashboard.dao.AppStatusDao;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.AppArea;
import com.citi.risk.dashboard.entity.AppAreaStatus;
import com.citi.risk.dashboard.entity.AppStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * 
 * @author gk85985
 * To add not-Applicable record for NON-OSM feeds, check with Debasish for details.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback=true)
@Transactional
public class AddNotApplicableData {
	
	private Logger log = Logger.getLogger(AddNotApplicableData.class);	
	private static String COLOR_NA = "#aeaeae".toUpperCase();
	private static String FEEDS_IN = "FEEDS IN".toUpperCase();
	private static String FEEDS_OUT = "FEEDS OUT".toUpperCase();
	
	@Autowired
	private AppsDao appsDao;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private AppStatusDao appStatusDao;
	@Autowired
	private AppAreaStatusDao appAreaStatusDao;
	
	@Test
	@Ignore 
	public void addNARecord() throws Exception {
		
		ArrayList<Apps> list = (ArrayList<Apps>) getAllAppsForEvent();
		log.info("No of distinct apps found in AppEvent table = " + list.size());
		
		for (Apps app : list) {
			log.info("Begin for APP NAME = "+ app.getAppName() +" , CSI = "+ app.getAppCsid());
			
			// check is FEEDs record exist in AppStatus table
			if ( isFeedAppStatusPresent(app) ) {
				log.warn("This app has FEEDS record in AppStatus. No records to add.");
				continue;
			}
			log.info("Proceed to adding NA record to AppStatus.");
			// Add FEEDS IN record to App status
			appStatusDao.saveAppStatus(new AppStatus(app, FEEDS_IN, COLOR_NA, new Date(), ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
			// Add FEEDS OUT record to App status
			appStatusDao.saveAppStatus(new AppStatus(app, FEEDS_OUT, COLOR_NA, new Date(), ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));

			// check is FEEDS record exist in AppAreaStatus table
			if ( isFeedAppAreaStatusPresent(app.getAppArea()) ) {
				log.warn("This app has FEEDS record in AppAreaStatus. No records to add.");
				continue;
			}
			log.info("Proceed to adding NA record to AppAreaStatus.");
			// Add FEEDS IN record to AppAreaStatus status
			appAreaStatusDao.saveAppAreaStatus(new AppAreaStatus(app.getAppArea(), app.getAppArea().getAppAreaName(), FEEDS_IN, COLOR_NA, new Date(), ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
			// Add FEEDS OUT record to AppAreaStatus status
			appAreaStatusDao.saveAppAreaStatus(new AppAreaStatus(app.getAppArea(), app.getAppArea().getAppAreaName(), FEEDS_OUT, COLOR_NA, new Date(), ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
			
		}		
				
		log.info("end..");	
		
	}
	
	@SuppressWarnings("unchecked")
	private boolean isFeedAppStatusPresent(Apps app){
		long appId = app.getAppsId();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select count(*) from AppStatus where kpiCategoryName like 'FEEDS%' "
				+ " and apps.appsId = :vappId ");
		query.setLong("vappId", appId);
		List<Object> count = query.list();
		if (!count.isEmpty() && count !=null) {
			long cnt = (Long) count.get(0);
			log.info("Returned count = "+ cnt);
			return cnt > 0 ? true : false;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private boolean isFeedAppAreaStatusPresent(AppArea appArea){
		long areaId = appArea.getAppAreaId();
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select count(*) from AppAreaStatus where kpiCategoryName like 'FEEDS%' "
				+ " and appArea.appAreaId = :vappAreaId ");
		query.setLong("vappAreaId", areaId);
		List<Object> count = query.list();
		if (!count.isEmpty() && count !=null) {
			long cnt = (Long) count.get(0);
			log.info("Returned count = "+ cnt);
			return cnt > 0 ? true : false;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private List<Apps> getAllAppsForEvent(){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select distinct apps from AppEvent ");
		List<Apps> tmpList = query.list();
		if (!tmpList.isEmpty() && tmpList !=null) {
			return tmpList;
		}
		return null;
	}
	
	// getter-setter methods
	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public AppStatusDao getAppStatusDao() {
		return appStatusDao;
	}
	public void setAppStatusDao(AppStatusDao appStatusDao) {
		this.appStatusDao = appStatusDao;
	}
	public AppAreaStatusDao getAppAreaStatusDao() {
		return appAreaStatusDao;
	}
	public void setAppAreaStatusDao(AppAreaStatusDao appAreaStatusDao) {
		this.appAreaStatusDao = appAreaStatusDao;
	}

}
