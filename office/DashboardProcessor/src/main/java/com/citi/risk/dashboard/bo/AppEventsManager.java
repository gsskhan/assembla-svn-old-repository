package com.citi.risk.dashboard.bo;

import java.util.Date;

import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;

/**
 * @author gk85985 This interface contain method to implement business logic,
 *         for maintaining data in table - "CLOUDAPP"."ETS_DSHBD_APP_EVENTS".
 */

public interface AppEventsManager {

    boolean addRecordToAppEvents(Apps apps, String kpiName,
            String kpiCategoryName, String kpiValue, String eventMsg,
            String kpiParameter, Date eventTimestamp, String correlationId,
            Date msgDateTime) throws DashboardException;

}
