package com.citi.risk.dashboard.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;

/**
 * 
 * @author gk85985 Common dao functions for db access with java objects.
 */
public interface GenericDao {

    <T> T getEntityWhereEq(Class<T> entityClass, Map<String, Object> paramMap)throws HibernateException;

    <T> T getEntity(String hql, Map<String, Object> paramMap) throws HibernateException;

    <T> List<T> listEntityWhereEq(Class<T> entityClass, Map<String, Object> paramMap, int maxrows) throws HibernateException;

    <T> List<T> getList(String hql, Map<String, Object> paramMap, int maxrows) throws HibernateException;

    Serializable saveEntity(Object entity) throws HibernateException;

    void updateEntity(Object entity) throws HibernateException;

    void saveOrUpdateEntity(Object entity) throws HibernateException;
}
