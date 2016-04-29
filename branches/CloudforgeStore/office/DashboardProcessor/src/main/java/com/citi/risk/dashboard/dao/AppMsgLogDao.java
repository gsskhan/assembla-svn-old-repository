package com.citi.risk.dashboard.dao;

import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.AppMsgLog;

/**
 * @author gk85985
 * 
 */
public interface AppMsgLogDao {

    void saveAppMsgXml(AppMsgLog appMsgLog) throws HibernateException;
}
