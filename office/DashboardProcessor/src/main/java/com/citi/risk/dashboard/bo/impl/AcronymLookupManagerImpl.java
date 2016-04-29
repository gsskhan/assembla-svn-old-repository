package com.citi.risk.dashboard.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.risk.dashboard.bo.AcronymLookupManager;
import com.citi.risk.dashboard.dao.AcronymLookupDao;
import com.citi.risk.dashboard.dao.AppsDao;
import com.citi.risk.dashboard.entity.AcronymLookup;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;

/**
 * 
 * @author gk85985 This class contain method to implement business logic based
 *         on data with table - "CLOUDAPP"."ETS_DSHBD_ACRONYM_LOOKUP".
 */

@Service("acronymLookupManager")
public class AcronymLookupManagerImpl implements AcronymLookupManager {

    private Logger log = Logger.getLogger(AcronymLookupManagerImpl.class);

    @Autowired
    private AcronymLookupDao acronymLookupDao;
    @Autowired
    private AppsDao appsDao;

    public Apps getAppsData(String csiId, String appName)
            throws DashboardException {
        AcronymLookup acronymLookup = acronymLookupDao
                .getRecord(csiId, appName);
        if (acronymLookup == null) {
            log.error("No match found in lookup table 'ETS_DSHBD_ACRONYM_LOOKUP' for CSI ID = "
                    + csiId
                    + " , APPLICATION NAME = "
                    + appName
                    + " . Please add an entry to lookup table for this combination.");
        } else {
            return acronymLookup.getApps();
        }
        // Search for combination in main table too (ETS_DSHBD_APPS).
        Apps app = appsDao.getApps(csiId, appName);
        if (app == null) {
            log.error("Unable to find relevant record for CSI ID = " + csiId
                    + " , APPLICATION NAME = " + appName
                    + "  also in main table 'ETS_DSHBD_APPS'.");
        }
        return (app != null) ? app : null;
    }

    // getter-setter methods
    public AcronymLookupDao getAcronymLookupDao() {
        return acronymLookupDao;
    }

    public void setAcronymLookupDao(AcronymLookupDao acronymLookupDao) {
        this.acronymLookupDao = acronymLookupDao;
    }

    public AppsDao getAppsDao() {
        return appsDao;
    }

    public void setAppsDao(AppsDao appsDao) {
        this.appsDao = appsDao;
    }
}
