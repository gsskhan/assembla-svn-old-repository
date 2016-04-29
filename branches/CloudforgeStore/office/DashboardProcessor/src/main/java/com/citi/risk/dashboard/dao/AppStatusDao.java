package com.citi.risk.dashboard.dao;

import java.util.List;
import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.AppStatus;

/**
 * 
 * @author gk85985 Methods to access/use AppStatus entity
 */
public interface AppStatusDao {

    void saveAppStatus(AppStatus appStatus) throws HibernateException;

    List<?> listMaxIdByKpiCatName(long appsId) throws HibernateException;

    List<?> listOfColorCodes(String csvlist) throws HibernateException;

    List<?> listMaxIdByArea(long appAreaId, String kpiCategoryName)
            throws HibernateException;
}
