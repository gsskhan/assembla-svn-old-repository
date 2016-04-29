package com.citi.risk.dashboard.gk;

import java.util.ArrayList;
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

import com.citi.risk.dashboard.util.ColorPicker;


/*
 * 
 * Trying with different logic to calculate colors, if any. Please ignore these classes in this package.
 * 
 * Rule 1: - Find all "app_kpi_name" that belongs under "kpi_category_name"  
  	select distinct app_kpi_name from ets_dshbd_app_events
	where app_csid = '8831'
	and app_name = 'CREDIT ENGINE'
	and kpi_category_name = 'FEEDS IN';
	
   Rule 2: For each "app_kpi_name" from above, find latest color code from db and add to a list of colors
    select app_event_category_status from ets_dshbd_app_events
	where app_csid = '8831'
	and app_name = 'CREDIT ENGINE'
	and kpi_category_name = 'FEEDS IN'
	and app_kpi_name = 'FEEDS-LATE'
	and last_update = (
    	select max(last_update) from ets_dshbd_app_events
  		where app_csid = '8831'
  		and app_name = 'CREDIT ENGINE'
  		and kpi_category_name = 'FEEDS IN'
  		and app_kpi_name = 'FEEDS-LATE'
  	);
  	
  	Rule3 : choose a final color from the list of colors obtained
  
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-common.xml"})
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class NewAppStatusCalc {
	
	private Logger log = Logger.getLogger(NewAppStatusCalc.class);	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	@Ignore
	public void fillRecordAppStatus(){		
		String csiId = "8831";
		String appName = "CREDIT ENGINE";
		String kpiCategory = "FEEDS IN";
		ArrayList<String> colorList = new ArrayList<String>();		
		log.info("Calculating new logic for AppStatus table.");	
		
		List<String> latestRecordList = getAppKpiNameList(csiId, appName, kpiCategory);
		log.info("List of APP KPI NAMES = " + latestRecordList);	
		for (String tmpKpiName : latestRecordList) {
			colorList.add(getAppKpiNameColor(csiId, appName, kpiCategory, tmpKpiName ));
		}
		log.info("List of colors found =" + colorList);		
		log.info("Final color = "+ new ColorPicker().getMaxColor(colorList));	
		
		log.info("Finished calculating new logic for AppStatus table.");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getAppKpiNameList(String csiId, String appName, String kpiCategoryName) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select distinct appKpiName from AppEvent "
				+ "	where appCsid = :vappCsid"
				+ " and appName = :vappName"
				+ " and kpiCatName = :vkpiCatName" );
		query.setString("vappCsid", csiId);
		query.setString("vappName", appName);
		query.setString("vkpiCatName", kpiCategoryName);
		return query.list();		
	}
	
	@SuppressWarnings("unchecked")
	public String getAppKpiNameColor(String csiId, String appName, String kpiCategoryName, String appKpiName ){
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" select appEventCatStatus from AppEvent "
				+ "	where appCsid = :vappCsid "
				+ " and appName = :vappName "
				+ " and kpiCatName = :vkpiCatName "
				+ " and appKpiName = :vappKpiName "
				+ " and lastUpdate =  ( select max(ae.lastUpdate) from AppEvent ae "
									+ "	where ae.appCsid = :vappCsid "
									+ " and ae.appName = :vappName "
									+ " and ae.kpiCatName = :vkpiCatName "
									+ " and ae.appKpiName = :vappKpiName "
				+ " ) " );
		query.setString("vappCsid", csiId);
		query.setString("vappName", appName);
		query.setString("vkpiCatName", kpiCategoryName);
		query.setString("vappKpiName", appKpiName);
		List<String> tmpList = query.list();
		session.flush();
		if (tmpList != null && tmpList.size() > 0 ){
			return (String) tmpList.get(0);
		}
		return null;	
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	

}
