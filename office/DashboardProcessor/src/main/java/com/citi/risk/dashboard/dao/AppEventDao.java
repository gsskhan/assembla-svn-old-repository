package com.citi.risk.dashboard.dao;

import java.util.List;
import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.AppEvent;

/**
 * *
 * 
 * @author gk85985
 * 
 */
public interface AppEventDao {

    void saveAppEvents(AppEvent appEvent) throws HibernateException;

    List<?> listMaxIdByKpiCatName(long appsId, String kpiCatName)
            throws HibernateException;

    List<?> listOfColorCodes(String csvlist) throws HibernateException;
}
