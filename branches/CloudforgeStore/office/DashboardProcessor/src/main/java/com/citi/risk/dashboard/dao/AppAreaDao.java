package com.citi.risk.dashboard.dao;

import java.util.List;
import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.AppArea;

/**
 * @author gk85985
 * 
 */
public interface AppAreaDao {

    List<AppArea> getAppAreaDetails(long areaId) throws HibernateException;
}
