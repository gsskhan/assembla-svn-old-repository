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
 * @author gk85985 Mapping for - "CLOUDAPP"."ETS_DSHBD_KPI_THRESHOLD_MASTER"
 * 
 */
@Entity
@Table(name = "ETS_DSHBD_KPI_THRESHOLD_MASTER", schema = "CLOUDAPP")
public class ThresholdMaster implements Serializable {

    private static final long serialVersionUID = -5478064689501960562L;
    private long threshMasterId;
    private Apps apps;
    private String component;
    private String kpiName;
    private String kpiCatName;
    private double thresholdValue;
    private String thresholdColor;
    private Date lastUpdate;
    private String lastUpdateBy;

    @Id
    @Column(name = "THRESHOLD_MASTER_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getThreshMasterId() {
        return threshMasterId;
    }

    public void setThreshMasterId(long threshMasterId) {
        this.threshMasterId = threshMasterId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "APPS_ID")
    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    @Column(name = "COMPONENT")
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Column(name = "KPI_NAME")
    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    @Column(name = "KPI_CATEGORY_NAME")
    public String getKpiCatName() {
        return kpiCatName;
    }

    public void setKpiCatName(String kpiCatName) {
        this.kpiCatName = kpiCatName;
    }

    @Column(name = "KPI_THREASHOLD_VALUE")
    public double getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(double thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    @Column(name = "KPI_THREADHOLD_COLOR_CODE")
    public String getThresholdColor() {
        return thresholdColor;
    }

    public void setThresholdColor(String thresholdColor) {
        this.thresholdColor = thresholdColor;
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
        return "ThresholdMaster [threshMasterId=" + threshMasterId
                + ", appsId=" + apps.getAppsId() + ", component=" + component
                + ", kpiName=" + kpiName + ", kpiCatName=" + kpiCatName
                + ", thresholdValue=" + thresholdValue + ", thresholdColor="
                + thresholdColor + ", lastUpdate=" + lastUpdate
                + ", lastUpdateBy=" + lastUpdateBy + "]";
    }
}
