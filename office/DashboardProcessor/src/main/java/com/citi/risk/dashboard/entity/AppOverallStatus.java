/**
 * 
 */
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
 * @author gc63735
 * 
 */
@Entity
@Table(name = "ETS_DSHBD_APP_OVERALL_STATUS", schema = "CLOUDAPP")
public class AppOverallStatus implements Serializable {

    private static final long serialVersionUID = -2494963016338125824L;
    private long appOverallStatusId;
    private Apps apps;
    private String appOverallStatus;
    private Date lastUpdate;
    private String lastUpdateBy;

    public AppOverallStatus(Apps apps, String appOverallStatus,
            Date lastUpdate, String lastUpdateBy) {
        super();
        this.apps = apps;
        this.appOverallStatus = appOverallStatus;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    @Id
    @Column(name = "APP_OVERALL_STATUS_ID", unique = true)
    @GeneratedValue(generator = "app_overall_status_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "app_overall_status_seq", sequenceName = "ETS_DSHBD_APP_OVERALL_SEQ", initialValue = 1, allocationSize = 1)
    public long getAppOverallStatusId() {
        return appOverallStatusId;
    }

    public void setAppOverallStatusId(long appOverallStatusId) {
        this.appOverallStatusId = appOverallStatusId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "APPS_ID", nullable = false)
    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    @Column(name = "APP_OVERALL_STATUS")
    public String getAppOverallStatus() {
        return appOverallStatus;
    }

    public void setAppOverallStatus(String appOverallStatus) {
        this.appOverallStatus = appOverallStatus;
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
        return "AppOverallStatus [appOverallStatusId=" + appOverallStatusId
                + ", appsId=" + apps.getAppsId() + ", appOverallStatus="
                + appOverallStatus + ", lastUpdate=" + lastUpdate
                + ", lastUpdateBy=" + lastUpdateBy + "]";
    }
}
