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
import javax.persistence.Table;

/**
 * 
 * @author gk85985 Mapping for "CLOUDAPP"."ETS_DSHBD_APPS"
 */
@Entity
@Table(name = "ETS_DSHBD_APPS", schema = "CLOUDAPP")
public class Apps implements Serializable {

    private static final long serialVersionUID = 32425708287778889L;
    private long appsId;
    private String appCsid;
    private String appName;
    private AppArea appArea;
    private Date lastUpdate;
    private String lastUpdateBy;

    @Id
    @Column(name = "APPS_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getAppsId() {
        return appsId;
    }

    public void setAppsId(long appsId) {
        this.appsId = appsId;
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

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "APP_AREA_ID")
    public AppArea getAppArea() {
        return appArea;
    }

    public void setAppArea(AppArea appArea) {
        this.appArea = appArea;
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
        return "Apps [appsId=" + appsId + ", appCsid=" + appCsid + ", appName="
                + appName + ", appArea=" + appArea + ", lastUpdate="
                + lastUpdate + ", lastUpdateBy=" + lastUpdateBy + "]";
    }
}
