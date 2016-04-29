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
import com.citi.risk.dashboard.dao.AppOverallStatusDao;
import com.citi.risk.dashboard.entity.AppOverallStatus;

@Repository("appOverallStatusDao")
public class AppOverallStatusDaoImpl implements AppOverallStatusDao {

    private Logger log = Logger.getLogger(AppAreaOverStatDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAppOverallStatus(AppOverallStatus appOverallStatus)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        session.save(appOverallStatus);
        session.flush();
        log.info("Saved. " + appOverallStatus);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object> listMaxIdByApp(long appAreaId)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" select aos.apps.appsId , max(aos.appOverallStatusId) from AppOverallStatus aos "
                        + " where aos.apps.appsId in "
                        + " ( select distinct ap.appsId from Apps ap "
                        + " where ap.appArea.appAreaId = :vappAreaId ) "
                        + " group by aos.apps.appsId ");
        query.setLong("vappAreaId", appAreaId);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object> listOfColorCodes(String csvlist)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" select distinct appOverallStatus from AppOverallStatus "
                        + " where appOverallStatusId in ( " + csvlist + " )");
        return query.list();
    }

    // getter-setter methods
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
