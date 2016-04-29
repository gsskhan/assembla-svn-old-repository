package com.citi.risk.dashboard.service;

import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import com.citi.risk.dashboard.bo.AcronymLookupManager;
import com.citi.risk.dashboard.bo.AppAreaOverStatManager;
import com.citi.risk.dashboard.bo.AppAreaStatusManager;
import com.citi.risk.dashboard.bo.AppComStatusManager;
import com.citi.risk.dashboard.bo.AppEventsManager;
import com.citi.risk.dashboard.bo.AppOverStatManager;
import com.citi.risk.dashboard.bo.AppStatusManager;
import com.citi.risk.dashboard.entity.Apps;
import com.citi.risk.dashboard.exception.DashboardException;
import com.citi.risk.dashboard.util.XMLParserUtility;
import com.citi.risk.dashboard.vo.DashboardKPIBean;
import com.citi.risk.dashboard.vo.DashboardXMLBean;
import com.citi.risk.dashboard.vo.TibcoMessageDataHolder;

/**
 * 
 * @author gk85985 This class shall parse xml and save data to diff. tables,
 *         applying business logic.
 */
public class MessageProcessingService {

    private Logger log = Logger.getLogger(MessageProcessingService.class);
    @Autowired
    private XMLParserUtility xmlParserUtility;
    @Autowired
    private AcronymLookupManager acronymLookupManager;
    @Autowired
    private AppEventsManager appEventsManager;
    @Autowired
    private AppStatusManager appStatusManager;
    @Autowired
    private AppComStatusManager appComStatusManager;
    @Autowired
    private AppOverStatManager appOverStatManager;
    @Autowired
    private AppAreaOverStatManager appAreaOverStatManager;
    @Autowired
    private AppAreaStatusManager appAreaStatusManager;

    public void parseAndProcessMessage(TibcoMessageDataHolder messageDataHolder) {
        try {
            log.info("Begin to parse and process message having Correlation Id = "
                    + messageDataHolder.getCorrelationID() + " .");
            // Call to XMLParserUtility
            DashboardXMLBean dashboardXMLBean = xmlParserUtility
                    .parsedXML(messageDataHolder.getXmlString());
            log.debug("DashboardXMLBean details= " + dashboardXMLBean);
            // Validate the parsed XML Bean class for null or empty fields
            if (!xmlParserUtility.validateParsedXml(dashboardXMLBean)) {
                log.error("One/more required fields in xml was null or empty, skipped message processing service for this XML. Please check log.");
                return;
            }
            String appCsiId = dashboardXMLBean.getApplicationCsi()
                    .toUpperCase().trim();
            String appName = dashboardXMLBean.getApplicationFullName()
                    .toUpperCase().trim();
            String correlationID = messageDataHolder.getCorrelationID().trim();
            Date msgDateTime = messageDataHolder.getMsgDateTime();
            // Lookup app name and csi combination from lookup table.
            Apps app = acronymLookupManager.getAppsData(appCsiId, appName);
            if (app == null) {
                log.error("Skipped message processing service of this record. Please check logs.");
                return;
            }
            synchronized (this) {
                boolean status = false;
                // Call business logic manager classes and insert/update data.
                for (DashboardKPIBean kpiBean : dashboardXMLBean.getKpiList()) {
                    status = appEventsManager.addRecordToAppEvents(app, kpiBean
                            .getKpiName().toUpperCase().trim(), kpiBean
                            .getKpiStatusCode().toUpperCase().trim(),
                            kpiBean.getKpivalue(), kpiBean.getKpiDescription(),
                            kpiBean.getKpiParameter().toUpperCase().trim(),
                            kpiBean.getEventTimestamp(), correlationID.trim(),
                            msgDateTime);
                    // If status returned is true, move to next manager class, else continue with next bean.
                    if (!status) {
                        continue;
                    }
                    status = appStatusManager.addRecordToAppStatus(app, kpiBean
                            .getKpiStatusCode().toUpperCase().trim(),
                            msgDateTime);
                    status = appComStatusManager.addRecordToAppComStatus(app,
                            kpiBean.getKpiStatusCode().toUpperCase().trim(),
                            msgDateTime);
                    status = appAreaStatusManager.addRecordToAppAreasStatus(
                            app, kpiBean.getKpiStatusCode().toUpperCase()
                                    .trim(), msgDateTime);
                    status = true;
                }
                if (status) {
                    status = appOverStatManager.addToAppOverStat(app,
                            msgDateTime);
                    status = appAreaOverStatManager.addRecordToAppAreaOverStat(
                            app, msgDateTime);
                }
            }
            log.info("Finished parsing and processing message having Correlation Id = "
                    + messageDataHolder.getCorrelationID() + " .");
        } catch (HibernateException e) {
            log.error("Error in ParseAndProcessMessage.", e);
        } catch (DashboardException e) {
            log.error("Error in ParseAndProcessMessage.", e);
        } catch (Exception e) {
            log.error("Error in ParseAndProcessMessage.", e);
        }
    }

    // getter-setter methods
    public XMLParserUtility getXmlParserUtility() {
        return xmlParserUtility;
    }

    public void setXmlParserUtility(XMLParserUtility xmlParserUtility) {
        this.xmlParserUtility = xmlParserUtility;
    }

    public AcronymLookupManager getAcronymLookupManager() {
        return acronymLookupManager;
    }

    public void setAcronymLookupManager(
            AcronymLookupManager acronymLookupManager) {
        this.acronymLookupManager = acronymLookupManager;
    }

    public AppEventsManager getAppEventsManager() {
        return appEventsManager;
    }

    public void setAppEventsManager(AppEventsManager appEventsManager) {
        this.appEventsManager = appEventsManager;
    }

    public AppStatusManager getAppStatusManager() {
        return appStatusManager;
    }

    public void setAppStatusManager(AppStatusManager appStatusManager) {
        this.appStatusManager = appStatusManager;
    }

    public AppComStatusManager getAppComStatusManager() {
        return appComStatusManager;
    }

    public void setAppComStatusManager(AppComStatusManager appComStatusManager) {
        this.appComStatusManager = appComStatusManager;
    }

    public AppOverStatManager getAppOverStatManager() {
        return appOverStatManager;
    }

    public void setAppOverStatManager(AppOverStatManager appOverStatManager) {
        this.appOverStatManager = appOverStatManager;
    }

    public AppAreaOverStatManager getAppAreaOverStatManager() {
        return appAreaOverStatManager;
    }

    public void setAppAreaOverStatManager(
            AppAreaOverStatManager appAreaOverStatManager) {
        this.appAreaOverStatManager = appAreaOverStatManager;
    }

    public AppAreaStatusManager getAppAreaStatusManager() {
        return appAreaStatusManager;
    }

    public void setAppAreaStatusManager(
            AppAreaStatusManager appAreaStatusManager) {
        this.appAreaStatusManager = appAreaStatusManager;
    }
}
