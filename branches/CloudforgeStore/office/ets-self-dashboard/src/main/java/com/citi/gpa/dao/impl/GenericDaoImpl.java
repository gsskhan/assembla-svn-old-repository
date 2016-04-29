package com.citi.gpa.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.citi.gpa.dao.GenericDao;

/**
 * 
 * @author gk85985 Common dao functions for db access with java objects.
 */

public class GenericDaoImpl implements GenericDao {

    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * (non-Javadoc)
     * 
     * @see com.citi.ets.dasbboard.web.dao.GenericDao#getEntityWhereEq(java.lang.Class,
     *      java.util.Map)
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public <T> T getEntityWhereEq(Class<T> entityClass,
            Map<String, Object> paramMap) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass);
        if (paramMap != null && !paramMap.isEmpty()) {
            criteria.add(Restrictions.allEq(paramMap));
        }
        criteria.setMaxResults(10);
        List<T> tmpList = criteria.list();
        session.flush();
        log.debug(tmpList.size() + " Row(s) returned.");
        return (!tmpList.isEmpty() && tmpList != null) ? tmpList.get(0) : null;
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.citi.ets.dasbboard.web.dao.GenericDao#getEntity(java.lang.String,
     *      java.util.Map)
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public <T> T getEntity(String hql, Map<String, Object> paramMap)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        if (paramMap != null && !paramMap.isEmpty()) {
            query.setProperties(paramMap);
        }
        query.setMaxResults(10);
        List<T> tmpList = query.list();
        session.flush();
        log.debug(tmpList.size() + " Row(s) returned.");
        return (!tmpList.isEmpty() && tmpList != null) ? tmpList.get(0) : null;
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.citi.ets.dasbboard.web.dao.GenericDao#listEntityWhereEq(java.lang.Class,
     *      java.util.Map, int)
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public <T> List<T> listEntityWhereEq(Class<T> entityClass,
            Map<String, Object> paramMap, int maxrows)
            throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass);
        if (paramMap != null && !paramMap.isEmpty()) {
            criteria.add(Restrictions.allEq(paramMap));
        }
        criteria.setMaxResults(maxrows);
        List<T> tmpList = criteria.list();
        session.flush();
        log.debug(tmpList.size() + " Row(s) returned.");
        return tmpList;
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.citi.ets.dasbboard.web.dao.GenericDao#getList(java.lang.String,
     *      java.util.Map, int)
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public <T> List<T> getList(String hql, Map<String, Object> paramMap,
            int maxrows) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        if (paramMap != null && !paramMap.isEmpty()) {
            query.setProperties(paramMap);
        }
        query.setMaxResults(maxrows);
        List<T> tmpList = query.list();
        session.flush();
        log.debug(tmpList.size() + " Row(s) returned.");
        return tmpList;
    }

    /**
     * Saves the entity class object
     * 
     * @param entity
     *            - entity class instance to save
     * @return {@link Serializable}
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Serializable saveEntity(Object entity) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        return session.save(entity);
    }

    /**
     * Updates the entity class object
     * 
     * @param entity
     *            - entity class instance to update
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEntity(Object entity) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        session.update(entity);
        session.flush();
    }

    /**
     * insert or Update the entity class object
     * 
     * @param entity
     *            - entity class instance to insert or update
     */
    public void saveOrUpdateEntity(Object entity) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(entity);
        session.flush();
    }

    // getter-setter methods
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
