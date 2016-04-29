package com.citi.risk.dashboard.dao;

import java.util.List;
import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.AppOverallStatus;

/**
 * @author gk85985
 * 
 */
public interface AppOverallStatusDao {

    void saveAppOverallStatus(AppOverallStatus appOverallStatus)
            throws HibernateException;

    List<?> listMaxIdByApp(long appAreaId) throws HibernateException;

    List<?> listOfColorCodes(String csvlist) throws HibernateException;
}
