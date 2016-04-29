package com.citi.risk.dashboard.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.citi.risk.dashboard.dao.AppMsgLogDao;
import com.citi.risk.dashboard.entity.AppMsgLog;

/**
 * 
 * @author gk85985
 * 
 */
@Repository("appMsgLogDao")
public class AppMsgLogDaoImpl implements AppMsgLogDao {

    private Logger log = Logger.getLogger(AppMsgLogDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAppMsgXml(AppMsgLog appMsgLog) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        session.save(appMsgLog);
        session.flush();
        log.debug("Saved. " + appMsgLog);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
