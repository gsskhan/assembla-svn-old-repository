package com.citi.risk.dashboard.dao;

import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.AppComStatus;

/**
 * 
 * @author gk85985
 */
public interface AppComStatusDao {

    void saveAppComStatus(AppComStatus appComStatus) throws HibernateException;
}
