package com.citi.risk.dashboard.dao;

import java.util.List;
import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.ThresholdMaster;

/**
 * @author gk85985
 * 
 */
public interface ThresholdMasterDao {

    /*
     * To get all rows of Threshold Master table for an Application. Created
     * basically for testing dao + entity. No business use for now.
     */
    List<ThresholdMaster> getAllRecordsForApplication(String appCsiId,
            String appName) throws HibernateException;

    /*
     * Generic method to get color code from threshold table. if "component" is
     * passed as null, it will ignore this column while calculating color code.
     */
    String getColorCode(String csiId, String appName, String kpiCatName,
            String kpiName, String component, double kpiValue)
            throws HibernateException;
}
