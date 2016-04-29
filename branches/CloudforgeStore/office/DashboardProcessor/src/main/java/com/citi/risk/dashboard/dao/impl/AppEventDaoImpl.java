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
import com.citi.risk.dashboard.dao.AppEventDao;
import com.citi.risk.dashboard.entity.AppEvent;

@Repository("appEventDao")
public class AppEventDaoImpl implements AppEventDao {

    private Logger log = Logger.getLogger(AppEventDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAppEvents(AppEvent appEvent) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        session.save(appEvent);
        session.flush();
        log.info("Saved. " + appEvent);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.citi.risk.dashboard.dao.AppEventDao#listMaxIdByKpiCatName(java.lang
     * .String, java.lang.String, java.lang.String) To get maximum appKpiName
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object> listMaxIdByKpiCatName(long appsId, String kpiCatName)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" select ae.appKpiName, max(ae.appEventId) from AppEvent ae "
                        + " where ae.apps.appsId = :vappsId "
                        + " and ae.kpiCatName = :vkpiCatName "
                        + " group by ae.appKpiName ");
        query.setLong("vappsId", appsId);
        query.setString("vkpiCatName", kpiCatName);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object> listOfColorCodes(String csvlist)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" select distinct appEventCatStatus from AppEvent "
                        + " where appEventId in ( " + csvlist + " )");
        return query.list();
    }

    // getter - setter methods
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
