package com.citi.risk.dashboard.dao;

import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.AppAreaStatus;

/**
 * 
 * @author gk85985
 * 
 */
public interface AppAreaStatusDao {

    void saveAppAreaStatus(AppAreaStatus appAreaStatus)
            throws HibernateException;
}
