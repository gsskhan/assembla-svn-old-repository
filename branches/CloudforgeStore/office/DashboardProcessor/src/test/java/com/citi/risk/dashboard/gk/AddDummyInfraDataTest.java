package com.citi.risk.dashboard.gk;

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

import com.citi.risk.dashboard.bo.AppAreaOverStatManager;
import com.citi.risk.dashboard.bo.AppAreaStatusManager;
import com.citi.risk.dashboard.bo.AppOverStatManager;
import com.citi.risk.dashboard.dao.AppStatusDao;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.AppStatus;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.util.ConstantsUtil;

/**
 * 
 * 
 * @author gk85985
 *
 * To add dummy records for infrastructure in db.(Test requirement for POC - check with Debasish for details)
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback=true)
@Transactional
public class AddDummyInfraDataTest {
	
	private Logger log = Logger.getLogger(AddDummyInfraDataTest.class);
	
	@Autowired
	private AppsDao appsDao;
	@Autowired
	private AppStatusDao appStatusDao;
	@Autowired
	private AppOverStatManager appOverStatManager;
	@Autowired
	private AppAreaOverStatManager appAreaOverStatManager;
	@Autowired
	private AppAreaStatusManager appAreaStatusManager;
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String INFRA = "INFRASTRUCTURE";
	
	@Test
	@Ignore
	public void testAddDummyInfra() throws Exception{
		
		String appName = "OPTIMA".toUpperCase();
		String csi = "161602".toUpperCase();
		Date today = new Date();
		
		// get Apps detail
		Apps apps = appsDao.getApps(csi, appName);
		
		if(! isEventDataPresent(csi, appName, INFRA)){
			// Add record to App Status Table.
			appStatusDao.saveAppStatus(new AppStatus(apps, this.INFRA, ConstantsUtil.COL_GREEN.getConstants(), today, ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants()));
			// Re-calculate data for App OverAll Status Table.
			appOverStatManager.addToAppOverStat(apps, today);
			// Re-calculate data for App Area Over all status Table.
			appAreaOverStatManager.addRecordToAppAreaOverStat(apps, today);
			// Re-calculate data for App Area Status Table.
			appAreaStatusManager.addRecordToAppAreasStatus(apps, this.INFRA, today);			
		} else {
			log.warn("Events table has atleast one record existing. No insertion done.");
		}		
		log.info("Finished");		
		
	}
	

	@SuppressWarnings("unchecked")
	public boolean isEventDataPresent(String csiId, String appName, String kpiCatName) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select count(*) from AppEvent"
										+ " where appCsid = :vappCsiD "
										+ " and appName = :vappName "
										+ " and kpiCatName =:vkpiCatName "); 
		query.setString("vappCsiD", csiId);
		query.setString("vappName", appName);
		query.setString("vkpiCatName", kpiCatName);
		List<Object> count = query.list();
		if (!count.isEmpty() && count !=null) {
			long cnt = (Long) count.get(0);
			log.info("Returned count = "+ cnt);
			return cnt > 0 ? true : false;
		}
		return false;
	}


	public AppsDao getAppsDao() {
		return appsDao;
	}
	public void setAppsDao(AppsDao appsDao) {
		this.appsDao = appsDao;
	}	
	public AppStatusDao getAppStatusDao() {
		return appStatusDao;
	}
	public void setAppStatusDao(AppStatusDao appStatusDao) {
		this.appStatusDao = appStatusDao;
	}	
	public AppOverStatManager getAppOverStatManager() {
		return appOverStatManager;
	}
	public void setAppOverStatManager(AppOverStatManager appOverStatManager) {
		this.appOverStatManager = appOverStatManager;
	}
	public AppAreaOverStatManager getAppAreaOverStatManager() {
		return appAreaOverStatManager;
	}
	public void setAppAreaOverStatManager(
			AppAreaOverStatManager appAreaOverStatManager) {
		this.appAreaOverStatManager = appAreaOverStatManager;
	}
	public AppAreaStatusManager getAppAreaStatusManager() {
		return appAreaStatusManager;
	}
	public void setAppAreaStatusManager(AppAreaStatusManager appAreaStatusManager) {
		this.appAreaStatusManager = appAreaStatusManager;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
