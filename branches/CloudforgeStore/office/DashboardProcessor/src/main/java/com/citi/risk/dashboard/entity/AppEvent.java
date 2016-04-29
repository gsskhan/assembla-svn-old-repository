package com.citi.risk.dashboard.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author gk85985 Mapping for table - "CLOUDAPP"."ETS_DSHBD_APP_EVENTS"
 */
@Entity
@Table(name = "ETS_DSHBD_APP_EVENTS", schema = "CLOUDAPP")
public class AppEvent implements Serializable {

    private static final long serialVersionUID = -4642655168395970827L;
    private long appEventId;
    private Apps apps;
    private String appCsid;
    private String appName;
    private String appKpiName;
    private String kpiCatName;
    private String kpiValue;
    private String eventMessage;
    private String kpiParameter;
    private String appEventCatStatus;
    private Date eventTimeStamp;
    private String correlationId;
    private Date lastUpdate;
    private String lastUpdateBy;

    public AppEvent(Apps apps, String appCsid, String appName,
            String appKpiName, String kpiCatName, String kpiValue,
            String eventMessage, String kpiParameter, String appEventCatStatus,
            Date eventTimeStamp, String correlationId, Date lastUpdate,
            String lastUpdateBy) {
        super();
        this.apps = apps;
        this.appCsid = appCsid;
        this.appName = appName;
        this.appKpiName = appKpiName;
        this.kpiCatName = kpiCatName;
        this.kpiValue = kpiValue;
        this.eventMessage = eventMessage;
        this.kpiParameter = kpiParameter;
        this.appEventCatStatus = appEventCatStatus;
        this.eventTimeStamp = eventTimeStamp;
        this.correlationId = correlationId;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    @Id
    @Column(name = "APP_EVENTS_ID", unique = true)
    @GeneratedValue(generator = "app_events_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "app_events_seq", sequenceName = "ETS_DASHBOARD_EVENTS_SEQ", initialValue = 1, allocationSize = 1)
    public long getAppEventId() {
        return appEventId;
    }

    public void setAppEventId(long appEventId) {
        this.appEventId = appEventId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "APPS_ID", nullable = false)
    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    @Column(name = "APP_CSID")
    public String getAppCsid() {
        return appCsid;
    }

    public void setAppCsid(String appCsid) {
        this.appCsid = appCsid;
    }

    @Column(name = "APP_NAME")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Column(name = "APP_KPI_NAME")
    public String getAppKpiName() {
        return appKpiName;
    }

    public void setAppKpiName(String appKpiName) {
        this.appKpiName = appKpiName;
    }

    @Column(name = "KPI_CATEGORY_NAME")
    public String getKpiCatName() {
        return kpiCatName;
    }

    public void setKpiCatName(String kpiCatName) {
        this.kpiCatName = kpiCatName;
    }

    @Column(name = "KPI_VALUE")
    public String getKpiValue() {
        return kpiValue;
    }

    public void setKpiValue(String kpiValue) {
        this.kpiValue = kpiValue;
    }

    @Column(name = "EVENT_MESSAGE")
    public String getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }

    @Column(name = "KPI_PARAMETER")
    public String getKpiParameter() {
        return kpiParameter;
    }

    public void setKpiParameter(String kpiParameter) {
        this.kpiParameter = kpiParameter;
    }

    @Column(name = "APP_EVENT_CATEGORY_STATUS")
    public String getAppEventCatStatus() {
        return appEventCatStatus;
    }

    public void setAppEventCatStatus(String appEventCatStatus) {
        this.appEventCatStatus = appEventCatStatus;
    }

    @Column(name = "EVENT_TIMESTAMP")
    public Date getEventTimeStamp() {
        return eventTimeStamp;
    }

    public void setEventTimeStamp(Date eventTimeStamp) {
        this.eventTimeStamp = eventTimeStamp;
    }

    @Column(name = "CORRELATION_ID")
    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @Column(name = "LAST_UPDATE")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "LAST_UPDATEDBY")
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Override
    public String toString() {
        return "AppEvent [appEventId=" + appEventId + ", appsId="
                + apps.getAppsId() + ", appCsid=" + appCsid + ", appName="
                + appName + ", appKpiName=" + appKpiName + ", kpiCatName="
                + kpiCatName + ", kpiValue=" + kpiValue + ", eventMessage="
                + eventMessage + ", kpiParameter=" + kpiParameter
                + ", appEventCatStatus=" + appEventCatStatus
                + ", eventTimeStamp=" + eventTimeStamp + ", correlationId="
                + correlationId + ", lastUpdate=" + lastUpdate
                + ", lastUpdateBy=" + lastUpdateBy + "]";
    }
}
