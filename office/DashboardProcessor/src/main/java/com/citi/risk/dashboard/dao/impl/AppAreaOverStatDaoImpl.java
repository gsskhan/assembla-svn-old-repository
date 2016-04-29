package com.citi.risk.dashboard.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.citi.risk.dashboard.dao.AppAreaOverStatDao;
import com.citi.risk.dashboard.entity.AppAreaOverStatus;

/**
 * @author gk85985
 * 
 */
@Repository("appAreaOverStatDao")
public class AppAreaOverStatDaoImpl implements AppAreaOverStatDao {

    private Logger log = Logger.getLogger(AppAreaOverStatDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveAppAreaOverStatus(AppAreaOverStatus appAreaOverStatus)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        session.save(appAreaOverStatus);
        session.flush();
        log.info("Saved. " + appAreaOverStatus);
    }

    // getter-setter methods
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
