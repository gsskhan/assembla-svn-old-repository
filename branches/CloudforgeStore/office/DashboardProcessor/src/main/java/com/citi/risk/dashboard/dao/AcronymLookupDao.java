package com.citi.risk.dashboard.dao;

import org.hibernate.HibernateException;

import com.citi.risk.dashboard.entity.AcronymLookup;

/**
 * 
 * @author gk85985
 * 
 */
public interface AcronymLookupDao {

    AcronymLookup getRecord(String lookupCsid, String lookupAppName)
            throws HibernateException;

}
