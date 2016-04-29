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
 * @author gk85985 Mapping for table - "CLOUDAPP"."ETS_DSHBD_APP_COM_STATUS"
 */
@Entity()
@Table(name = "ETS_DSHBD_APP_COM_STATUS", schema = "CLOUDAPP")
public class AppComStatus implements Serializable {

    private static final long serialVersionUID = 2688476566044335935L;
    private long appComStatusId;
    private Apps apps;
    private String appKpiComName;
    private String kpiCategoryName;
    private String appComStatus;
    private Date lastUpdate;
    private String lastUpdateBy;

    public AppComStatus() {
        super();
    }

    public AppComStatus(Apps apps, String appKpiComName,
            String kpiCategoryName, String appComStatus, Date lastUpdate,
            String lastUpdateBy) {
        super();
        this.apps = apps;
        this.appKpiComName = appKpiComName;
        this.kpiCategoryName = kpiCategoryName;
        this.appComStatus = appComStatus;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    @Id
    @Column(name = "APP_COM_STATUS_ID", nullable = false, unique = true)
    @GeneratedValue(generator = "app_com_status_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "app_com_status_seq", sequenceName = "ETS_DSHBD_APP_COM_STATUS_SEQ", initialValue = 1, allocationSize = 1)
    public long getAppComStatusId() {
        return appComStatusId;
    }

    public void setAppComStatusId(long appComStatusId) {
        this.appComStatusId = appComStatusId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "APPS_ID", nullable = false)
    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    @Column(name = "APP_KPI_COM_NAME")
    public String getAppKpiComName() {
        return appKpiComName;
    }

    public void setAppKpiComName(String appKpiComName) {
        this.appKpiComName = appKpiComName;
    }

    @Column(name = "KPI_CATEGORY_NAME")
    public String getKpiCategoryName() {
        return kpiCategoryName;
    }

    public void setKpiCategoryName(String kpiCategoryName) {
        this.kpiCategoryName = kpiCategoryName;
    }

    @Column(name = "APP_COM_STATUS")
    public String getAppComStatus() {
        return appComStatus;
    }

    public void setAppComStatus(String appComStatus) {
        this.appComStatus = appComStatus;
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
        return "AppComStatus [appComStatusId=" + appComStatusId + ", apps="
                + apps + ", appKpiComName=" + appKpiComName
                + ", kpiCategoryName=" + kpiCategoryName + ", appComStatus="
                + appComStatus + ", lastUpdate=" + lastUpdate
                + ", lastUpdateBy=" + lastUpdateBy + "]";
    }
}
