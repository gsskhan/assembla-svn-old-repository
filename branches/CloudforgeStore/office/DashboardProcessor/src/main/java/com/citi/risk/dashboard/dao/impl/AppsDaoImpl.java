package com.citi.risk.dashboard.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.Apps;

@Repository("appsDao")
public class AppsDaoImpl implements AppsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Apps> getAppsDetail(String appCsid, String appName)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" from Apps a where a.appCsid = :vappCsid and a.appName = :vappName ");
        query.setString("vappCsid", appCsid);
        query.setString("vappName", appName);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public Apps getApps(String appCsid, String appName)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" from Apps a where a.appCsid = :vappCsid and a.appName = :vappName ");
        query.setString("vappCsid", appCsid);
        query.setString("vappName", appName);
        List<Apps> tmpList = query.list();
        session.flush();
        if (tmpList != null && tmpList.size() > 0) {
            return tmpList.get(0);
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
