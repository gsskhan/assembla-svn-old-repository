package com.citi.ets.dashboard.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.citi.ets.dashboard.constant.DashboardConstant;
import com.citi.ets.dashboard.dao.ETSDashboardDaoI;
import com.citi.ets.dashboard.entity.*;

//@Transactional(propagation=Propagation.REQUIRED)
/**
 * @author ak64503
 * 
 */
public class ETSDashboardDaoImpl implements ETSDashboardDaoI {
    
    private static final Logger logger=Logger.getLogger(ETSDashboardDaoImpl.class);    
    private static SessionFactory sessionFactory;
   
    public void setSessionFactory(SessionFactory factory) {	
	sessionFactory = factory;
    }

    @Override
    public List<Org> getOrgRefDetails() {
	Session session = sessionFactory.openSession();
	Query query = session.createQuery("FROM com.citi.ets.dashboard.entity.Org");
	List<Org> orgList = query.list();
	session.close();
	//logger.info("ETS Org details retrieved.");
	return orgList;
    }

    /**
     * get list of distinct list of kpi for an app
     */
    @Override
    public List<String> getDistinctKPIbyAppCSI(String csi) {
	Session session = sessionFactory.openSession();
	Query query = session.createQuery(DashboardConstant.DISTINCT_KPI_BY_CSID.concat(csi).concat("'"));
	List<String> kpiListByApp = query.list();
	session.close();
	return kpiListByApp;
    }
    /**
     * get list of distinct list of apps id for an app present in app status table to avoid unnecessary hibernate call
     */
    @Override
    public List<String> getDistinctAppsId() {
	Session session = sessionFactory.openSession();
	Query query = session.createQuery(DashboardConstant.DISTINCT_APP_ID);
	List<String> result = query.list();
	session.close();
	return result;
    }
    /**
     * get the latest app area overall color code
     * @param areaId
     * @return
     */
    @Override
    public String getAppAreaOverallStatus(String areaId){	
	Session session = sessionFactory.openSession();		
	Criteria criteria = session.createCriteria(AppAreaOverallStatus.class, "t")
		.add(Restrictions.eq("t.app_area_id", areaId))
                .addOrder(Order.desc("t.status_id"))
                .setMaxResults(1);               	
	List<?> result = criteria.list();
	session.close();
	return !result.isEmpty() ? (String)(((AppAreaOverallStatus)result.get(0)).getApp_area_overall_status()) : null;	
    }
    /**
     * get the latest kpi category status by app area
     * @param areaId
     * @param categoryName
     * @return
     */
    @Override
    public String getAppAreaStatus(String areaId, String categoryName){		
	Session session = sessionFactory.openSession();		
	Criteria criteria = session.createCriteria(AppAreaStatus.class, "t")
		.add(Restrictions.eq("t.app_area_id", areaId))
		.add(Restrictions.eq("t.kpi_category_name",categoryName))
                .addOrder(Order.desc("t.app_area_status_id"))
                .setMaxResults(1);               	
	List<?> result = criteria.list();
	session.close();
	return !result.isEmpty() ? ((AppAreaStatus)result.get(0)).getApp_compstatus() : null;			
    }
    
    /**
     * get the latest app overall color code
     * @param areaId
     * @return
     */
    @Override
    public String getAppOverallStatus(String appId){	
	Session session = sessionFactory.openSession();		
	Criteria criteria = session.createCriteria(AppOverallStatus.class, "t")
		.add(Restrictions.eq("t.apps_id", appId))
                .addOrder(Order.desc("t.app_overall_status_id"))
                .setMaxResults(1);               	
	List<?> result = criteria.list();
	session.close();
	return !result.isEmpty() ?((AppOverallStatus)result.get(0)).getApp_overall_status() : null;	
    }
    /**
     * get the latest kpi category status by app
     * @param areaId
     * @param categoryName
     * @return
     */
    @Override
    public String getAppStatus(String appId, String kpiCategoryName){	
	Session session = sessionFactory.openSession();		
	Criteria criteria = session.createCriteria(AppStatus.class, "t")
		.add(Restrictions.eq("t.app_id", appId))
                .add(Restrictions.eq("t.kpi_category_name",kpiCategoryName))
                .addOrder(Order.desc("t.app_status_id"))
                .setMaxResults(1);               	
	List<?> result = criteria.list();
	session.close();
	return !result.isEmpty() ? ((AppStatus)result.get(0)).getApp_compstatus() : null;	
    }
  
    /**
     * get the latest event by id
     * @param areaId
     * @param categoryName
     * @return
     */
    @Override
    public Events getLatestEvent(String appName, String appKpiName, String kpiCategoryName) {	
	Session session = sessionFactory.openSession();  	
	Criteria criteria = session.createCriteria(Events.class, "t")
		.add(Restrictions.eq("t.app_name", appName))
                .add(Restrictions.eq("t.app_kpi_name",appKpiName))
                .add(Restrictions.eq("t.kpi_category_name",kpiCategoryName))
                .addOrder(Order.desc("t.app_events_id"))
                .setMaxResults(1);               	
	List<?> historyList = criteria.list();
	session.close();
	return !historyList.isEmpty() ? (Events)historyList.get(0) : new Events();
    }
    
    /**
     * populate the history details // same as get latest event
     */
    @Override
    public Events getHistoryDetails(String appName, String kpiCategoryName, String kpiCategory){
	Session session = sessionFactory.openSession();  	
	Criteria criteria = session.createCriteria(Events.class, "t")
		.add(Restrictions.eq("t.app_name", appName))
				.add(Restrictions.eq("t.app_kpi_name",kpiCategory))
                .add(Restrictions.eq("t.kpi_category_name",kpiCategoryName))                
                .addOrder(Order.desc("t.app_events_id"))
                .setMaxResults(1);               	
	Events historyEvent = (Events)criteria.uniqueResult();
	session.close();
	return (null != historyEvent) ? historyEvent : new Events();
    }
    
    /**
     * get contact details
     * @param appId
     * @return
     */
    @Override
	public Contacts getContactDetails(String appId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Contacts.class, "t").add(Restrictions.eq("t.apps_id", appId)).setMaxResults(1); // if multiple contacts !
		Contacts contact = (Contacts) criteria.uniqueResult();
		session.close();
		return (null != contact) ? contact : new Contacts();
	}
    
	/**
	 * get acronym details of an app
	 * @param appId
	 * @return
	 */
    @Override
	public Acronym getAcronymDetails(String appId){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Acronym.class, "t").add(Restrictions.eq("t.apps_id", appId)).setMaxResults(1); // if multiple res found
		Acronym acronym = (Acronym) criteria.uniqueResult();
		session.close();
		return (null != acronym) ? acronym : new Acronym();		
	}
    
    /**
     * get event by date range
     */
    
    public List<Events> getReportEvents(String appCsi, String startDte, String endDte) throws Exception{
    	Session session = sessionFactory.openSession();
    	Criteria criteria = session.createCriteria(Events.class, "t");    	
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Date startDate = format.parse(startDte);
    	Date endDate = format.parse(endDte);
    	criteria.add(Restrictions.eq("t.app_csid", appCsi));
    	criteria.add(Expression.between("t.event_timestamp", new Date(startDate.getTime()),	new Date(endDate.getTime())));
    	List<Events> reportEvents = criteria.list();
    	session.close();
    	return reportEvents;
    }
    /**
     * get report event by month 2014-02
     */
    public List<Events> getReportEvents(String appCsi, String month) throws Exception{
    	Session session = sessionFactory.openSession();
    	String hql = "FROM com.citi.ets.dashboard.entity.Events t where t.app_csid = '" + appCsi + "' and to_char(t.event_timestamp, 'yyyy-MM') = ";    	
    	Query query = session.createQuery(hql.concat("'" +month +"'"));
    	List<Events> reportEvents = query.list();
    	session.close();
    	return reportEvents;
    }
    
}
