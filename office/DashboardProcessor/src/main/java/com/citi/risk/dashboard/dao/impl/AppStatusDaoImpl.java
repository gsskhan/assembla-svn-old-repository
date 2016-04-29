package com.citi.risk.dashboard.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.citi.risk.dashboard.dao.AppStatusDao;
import com.citi.risk.dashboard.entity.AppStatus;

@Repository("appStatusDao")
public class AppStatusDaoImpl implements AppStatusDao {

    private Logger log = Logger.getLogger(AppStatusDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAppStatus(AppStatus appStatus) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        session.save(appStatus);
        session.flush();
        log.info("Saved. " + appStatus);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object> listMaxIdByKpiCatName(long appsId)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" select a.kpiCategoryName, max(a.appStatusId) from AppStatus a "
                        + " where a.apps.appsId = :vappsId "
                        + " group by a.kpiCategoryName ");
        query.setLong("vappsId", appsId);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object> listOfColorCodes(String csvlist)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" select distinct appCompStatus from AppStatus "
                        + " where appStatusId in ( " + csvlist + " )");
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object> listMaxIdByArea(long appAreaId, String kpiCategoryName)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" select a.apps.appsId , max(a.appStatusId) from AppStatus a "
                        + " where a.kpiCategoryName = :vkpiCategoryName "
                        + " and a.apps.appsId in "
                        + " ( select distinct ap.appsId from Apps ap "
                        + " where ap.appArea.appAreaId = :vappAreaId ) "
                        + " group by a.apps.appsId ");
        query.setString("vkpiCategoryName", kpiCategoryName);
        query.setLong("vappAreaId", appAreaId);
        return query.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
