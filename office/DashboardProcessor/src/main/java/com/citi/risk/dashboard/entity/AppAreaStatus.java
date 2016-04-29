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
 * @author gk85985 Mapping for TABLE "CLOUDAPP"."ETS_DSHBD_APP_AREA_STATUS" .
 */
@Entity
@Table(name = "ETS_DSHBD_APP_AREA_STATUS", schema = "CLOUDAPP")
public class AppAreaStatus implements Serializable {

    private static final long serialVersionUID = 6745040396202211382L;
    private long appAreaStatusId;
    private AppArea appArea;
    private String appAreaName;
    private String kpiCategoryName;
    private String appCompStatus;
    private Date lastUpdate;
    private String lastUpdatedBy;

    public AppAreaStatus(AppArea appArea, String appAreaName,
            String kpiCategoryName, String appCompStatus, Date lastUpdate,
            String lastUpdatedBy) {
        super();
        this.appArea = appArea;
        this.appAreaName = appAreaName;
        this.kpiCategoryName = kpiCategoryName;
        this.appCompStatus = appCompStatus;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Id
    @Column(name = "APP_AREA_STATUS_ID", unique = true)
    @GeneratedValue(generator = "app_area_status_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "app_area_status_seq", sequenceName = "ETS_DSHBD_APP_AREA_STATUS_SEQ", initialValue = 1, allocationSize = 1)
    public long getAppAreaStatusId() {
        return appAreaStatusId;
    }

    public void setAppAreaStatusId(long appAreaStatusId) {
        this.appAreaStatusId = appAreaStatusId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "APP_AREA_ID", nullable = false)
    public AppArea getAppArea() {
        return appArea;
    }

    public void setAppArea(AppArea appArea) {
        this.appArea = appArea;
    }

    @Column(name = "APP_AREA_NAME")
    public String getAppAreaName() {
        return appAreaName;
    }

    public void setAppAreaName(String appAreaName) {
        this.appAreaName = appAreaName;
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
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public String toString() {
        return "AppAreaStatus [appAreaStatusId=" + appAreaStatusId
                + ", appAreaId=" + appArea.getAppAreaId() + ", appAreaName="
                + appAreaName + ", kpiCategoryName=" + kpiCategoryName
                + ", appCompStatus=" + appCompStatus + ", lastUpdate="
                + lastUpdate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
    }
}
