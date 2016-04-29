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
import com.citi.risk.dashboard.dao.OrganisationDao;
import com.citi.risk.dashboard.entity.Organisation;

@Repository("organisationDao")
public class OrganisationDaoImpl implements OrganisationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Organisation> getOrgDetails(long orgId)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" from Organisation where orgId = :vorgId ");
        query.setLong("vorgId", orgId);
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
