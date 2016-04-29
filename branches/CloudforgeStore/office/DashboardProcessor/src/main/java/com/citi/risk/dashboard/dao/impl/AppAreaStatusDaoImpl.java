package com.citi.risk.dashboard.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.citi.risk.dashboard.dao.AppAreaStatusDao;
import com.citi.risk.dashboard.entity.AppAreaStatus;

/**
 * 
 * @author gk85985
 * 
 */
@Repository("appAreaStatusDao")
public class AppAreaStatusDaoImpl implements AppAreaStatusDao {

    private Logger log = Logger.getLogger(AppAreaStatusDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAppAreaStatus(AppAreaStatus appAreaStatus)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        session.save(appAreaStatus);
        session.flush();
        log.info("Saved. " + appAreaStatus);
    }

    // getter-setter methods
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
