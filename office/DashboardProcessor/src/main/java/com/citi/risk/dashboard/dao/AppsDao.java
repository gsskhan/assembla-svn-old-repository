package com.citi.risk.dashboard.dao;

import java.util.List;
import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.Apps;

public interface AppsDao {

    List<Apps> getAppsDetail(String appCsid, String appName)
            throws HibernateException;

    Apps getApps(String appCsid, String appName) throws HibernateException;
}
