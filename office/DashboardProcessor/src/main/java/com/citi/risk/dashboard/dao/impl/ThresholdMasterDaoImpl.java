package com.citi.risk.dashboard.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.citi.risk.dashboard.dao.ThresholdMasterDao;
import com.citi.risk.dashboard.entity.ThresholdMaster;

@Repository("thresholdMasterDao")
public class ThresholdMasterDaoImpl implements ThresholdMasterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ThresholdMaster> getAllRecordsForApplication(String appCsiId,
            String appName) throws HibernateException {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session
                .createQuery(" from ThresholdMaster th where th.apps.appCsid = :vappCsid and th.apps.appName = :vappName ");
        query.setString("vappCsid", appCsiId);
        query.setString("vappName", appName);
        return query.list();
    }

    /*
     * Generic method to get color code from threshold table. If "component" is
     * passed as null, it will ignore this column while calculating color code.
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED)
    public String getColorCode(String csiId, String appName, String kpiCatName,
            String kpiName, String component, double kpiValue) {
        Session session = getSessionFactory().getCurrentSession();
        if (component == null) {
            Query query = session
                    .createQuery(" select th.thresholdColor from ThresholdMaster th "
                            + " where th.apps.appCsid = :vappCsid and th.apps.appName = :vappName "
                            + " and th.kpiName = :vkpiName and th.kpiCatName = :vkpiCatName and th.thresholdValue in "
                            + "("
                            + " select max(t.thresholdValue) from ThresholdMaster t"
                            + " where t.apps.appCsid = :vappCsid and t.apps.appName = :vappName "
                            + " and t.kpiName = :vkpiName and t.kpiCatName = :vkpiCatName and t.thresholdValue <= :vkpiValue "
                            + " ) ");
            query.setString("vappCsid", csiId);
            query.setString("vappName", appName);
            query.setString("vkpiName", kpiName);
            query.setString("vkpiCatName", kpiCatName);
            query.setDouble("vkpiValue", kpiValue);
            List<String> tmpList = query.list();
            session.flush();
            if (tmpList != null && tmpList.size() > 0) {
                return tmpList.get(0);
            }
        } else {
            Query query = session
                    .createQuery(" select th.thresholdColor from ThresholdMaster th "
                            + " where th.apps.appCsid = :vappCsid and th.apps.appName = :vappName and th.component = :vcomponent "
                            + " and th.kpiName = :vkpiName and th.kpiCatName = :vkpiCatName and th.thresholdValue in "
                            + "("
                            + " select max(t.thresholdValue) from ThresholdMaster t"
                            + " where t.apps.appCsid = :vappCsid and t.apps.appName = :vappName and t.component = :vcomponent "
                            + " and t.kpiName = :vkpiName and t.kpiCatName = :vkpiCatName and t.thresholdValue <= :vkpiValue "
                            + " ) ");
            query.setString("vappCsid", csiId);
            query.setString("vappName", appName);
            query.setString("vkpiName", kpiName);
            query.setString("vkpiCatName", kpiCatName);
            query.setString("vcomponent", component);
            query.setDouble("vkpiValue", kpiValue);
            List<String> tmpList = query.list();
            session.flush();
            if (tmpList != null && tmpList.size() > 0) {
                return tmpList.get(0);
            }
        }
        return null;
    }

    // getter-setter methods
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
