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
 * @author gk85985 Mapping for - "CLOUDAPP"."ETS_DSHBD_APP_AREA"
 */
@Entity
@Table(name = "ETS_DSHBD_APP_AREA", schema = "CLOUDAPP")
public class AppArea implements Serializable {

    private static final long serialVersionUID = -6619080235497379656L;
    private long appAreaId;
    private String appAreaName;
    private Date lastUpdate;
    private String lastUpdateBy;
    private Organisation org;

    @Id
    @Column(name = "APP_AREA_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getAppAreaId() {
        return appAreaId;
    }

    public void setAppAreaId(long appAreaId) {
        this.appAreaId = appAreaId;
    }

    @Column(name = "APP_AREA_NAME")
    public String getAppAreaName() {
        return appAreaName;
    }

    public void setAppAreaName(String appAreaName) {
        this.appAreaName = appAreaName;
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

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ORG_ID")
    public Organisation getOrg() {
        return org;
    }

    public void setOrg(Organisation org) {
        this.org = org;
    }

    @Override
    public String toString() {
        return "AppArea [appAreaId=" + appAreaId + ", appAreaName="
                + appAreaName + ", lastUpdate=" + lastUpdate
                + ", lastUpdateBy=" + lastUpdateBy + ", org=" + org + "]";
    }
}
