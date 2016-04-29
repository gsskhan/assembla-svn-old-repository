package com.citi.risk.dashboard.dao;

import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.AppAreaOverStatus;

/**
 * @author gk85985
 * 
 */
public interface AppAreaOverStatDao {

    void saveAppAreaOverStatus(AppAreaOverStatus appAreaOverStatus)
            throws HibernateException;
}
