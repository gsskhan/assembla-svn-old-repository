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
import com.citi.risk.dashboard.dao.AcronymLookupDao;
import com.citi.risk.dashboard.entity.AcronymLookup;

@Repository("acronymLookupDao")
public class AcronymLookupDaoImpl implements AcronymLookupDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public AcronymLookup getRecord(String lookupCsid, String lookupAppName)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" from AcronymLookup where lookupAppName = :vlookupAppName and lookupAppCsid = :vlookupAppCsid ");
        query.setString("vlookupAppName", lookupAppName);
        query.setString("vlookupAppCsid", lookupCsid);
        List<AcronymLookup> tmpList = query.list();
        session.flush();
        return (tmpList != null && !tmpList.isEmpty()) ? tmpList.get(0) : null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
