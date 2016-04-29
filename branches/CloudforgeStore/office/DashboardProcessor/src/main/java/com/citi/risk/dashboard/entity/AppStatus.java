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
 * @author gk85985 Mapping for - "CLOUDAPP"."ETS_DSHBD_APP_STATUS"
 */
@Entity
@Table(name = "ETS_DSHBD_APP_STATUS", schema = "CLOUDAPP")
public class AppStatus implements Serializable {

    private static final long serialVersionUID = -2494963016338125824L;
    private long appStatusId;
    private Apps apps;
    private String kpiCategoryName;
    private String appCompStatus;
    private Date lastUpdate;
    private String lastUpdateBy;

    public AppStatus(Apps apps, String kpiCategoryName, String appCompStatus,
            Date lastUpdate, String lastUpdateBy) {
        super();
        this.apps = apps;
        this.kpiCategoryName = kpiCategoryName;
        this.appCompStatus = appCompStatus;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    @Id
    @Column(name = "APP_STATUS_ID", unique = true)
    @GeneratedValue(generator = "app_status_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "app_status_seq", sequenceName = "ETS_DSHBD_APP_STATUS_SEQ", initialValue = 1, allocationSize = 1)
    public long getAppStatusId() {
        return appStatusId;
    }

    public void setAppStatusId(long appStatusId) {
        this.appStatusId = appStatusId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "APPS_ID", nullable = false)
    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    @Column(name = "KPI_CATEGORY_NAME")
    public String getKpiCategoryName() {
        return kpiCategoryName;
    }

    public void setKpiCategoryName(String kpiCategoryName) {
        this.kpiCategoryName = kpiCategoryName;
    }

    @Column(name = "APP_COMPSTATUS")
    public String getAppCompStatus() {
        return appCompStatus;
    }

    public void setAppCompStatus(String appCompStatus) {
        this.appCompStatus = appCompStatus;
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
        return "AppStatus [appStatusId=" + appStatusId + ", appsId="
                + apps.getAppsId() + ", kpiCategoryName=" + kpiCategoryName
                + ", appCompStatus=" + appCompStatus + ", lastUpdate="
                + lastUpdate + ", lastUpdateBy=" + lastUpdateBy + "]";
    }
}
