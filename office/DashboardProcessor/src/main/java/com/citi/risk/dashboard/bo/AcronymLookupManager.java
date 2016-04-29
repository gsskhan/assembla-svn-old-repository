package com.citi.risk.dashboard.bo;

import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;

/**
 * @author gk85985 This interface contain method to implement business logic
 *         based on data with table - "CLOUDAPP"."ETS_DSHBD_ACRONYM_LOOKUP".
 */

public interface AcronymLookupManager {

     Apps getAppsData(String csiId, String appName) throws DashboardException;

}
