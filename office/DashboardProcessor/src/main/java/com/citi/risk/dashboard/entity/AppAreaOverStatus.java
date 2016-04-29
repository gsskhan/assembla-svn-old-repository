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
 * @author gk85985 Mapping for TABLE "CLOUDAPP"."ETS_DSHBD_APP_OVERALL_STATUS"
 */
@Entity
@Table(name = "ETS_DSHBD_APP_AREA_OVERALL_STS", schema = "CLOUDAPP")
public class AppAreaOverStatus implements Serializable {

    private static final long serialVersionUID = -6323731618544740884L;
    private long statusId;
    private AppArea appArea;
    private String AppAreaName;
    private String AppAreaOverallStatus;
    private Date lastUpdate;
    private String lastUpdatedBy;

    public AppAreaOverStatus(AppArea appArea, String appAreaName,
            String appAreaOverallStatus, Date lastUpdate, String lastUpdatedBy) {
        super();
        this.appArea = appArea;
        AppAreaName = appAreaName;
        AppAreaOverallStatus = appAreaOverallStatus;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Id
    @Column(name = "STATUS_ID", unique = true)
    @GeneratedValue(generator = "app_area_overall_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "app_area_overall_seq", sequenceName = "ETS_DSHBD_APP_AREA_OVERALL_SEQ", initialValue = 1, allocationSize = 1)
    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
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
        return AppAreaName;
    }

    public void setAppAreaName(String appAreaName) {
        AppAreaName = appAreaName;
    }

    @Column(name = "APP_AREA_OVERALL_STATUS")
    public String getAppAreaOverallStatus() {
        return AppAreaOverallStatus;
    }

    public void setAppAreaOverallStatus(String appAreaOverallStatus) {
        AppAreaOverallStatus = appAreaOverallStatus;
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
        return "AppAreaOverStatus [statusId=" + statusId + ", appAreaId="
                + appArea.getAppAreaId() + ", AppAreaName=" + AppAreaName
                + ", AppAreaOverallStatus=" + AppAreaOverallStatus
                + ", lastUpdate=" + lastUpdate + ", lastUpdatedBy="
                + lastUpdatedBy + "]";
    }
}
