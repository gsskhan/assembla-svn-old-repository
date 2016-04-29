package com.citi.risk.dashboard.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author gk85985 Mapping for "CLOUDAPP"."ETS_DSHBD_ORGANISATION"
 * 
 */
@Entity
@Table(name = "ETS_DSHBD_ORGANISATION", schema = "CLOUDAPP")
public class Organisation implements Serializable {

    private static final long serialVersionUID = -7893614215711603631L;
    private long orgId;
    private String orgName;
    private Date lastUpdate;
    private String lastUpdateBy;

    @Id
    @Column(name = "ORG_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    @Column(name = "ORG_NAME")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
        return "Organisation [orgId=" + orgId + ", orgName=" + orgName
                + ", lastUpdate=" + lastUpdate + ", lastUpdateBy="
                + lastUpdateBy + "]";
    }
}
