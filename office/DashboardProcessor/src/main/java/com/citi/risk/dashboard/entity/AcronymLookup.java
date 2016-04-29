package com.citi.risk.dashboard.entity;

import java.io.Serializable;
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
 * @author gk85985 Mapping for table - "CLOUDAPP"."ETS_DSHBD_ACRONYM_LOOKUP"
 */
@Entity
@Table(name = "ETS_DSHBD_ACRONYM_LOOKUP", schema = "CLOUDAPP")
public class AcronymLookup implements Serializable {

    private static final long serialVersionUID = 7304995882113540838L;
    private long acronymId;
    private Apps apps;
    private String lookupAppName;
    private String lookupAppCsid;
    private String acronym;

    @Id
    @Column(name = "ACRONYM_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getAcronymId() {
        return acronymId;
    }

    public void setAcronymId(long acronymId) {
        this.acronymId = acronymId;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "APPS_ID", nullable = false)
    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    @Column(name = "LOOKUP_APP_NAME")
    public String getLookupAppName() {
        return lookupAppName;
    }

    public void setLookupAppName(String lookupAppName) {
        this.lookupAppName = lookupAppName;
    }

    @Column(name = "LOOKUP_APP_CSID")
    public String getLookupAppCsid() {
        return lookupAppCsid;
    }

    public void setLookupAppCsid(String lookupAppCsid) {
        this.lookupAppCsid = lookupAppCsid;
    }

    @Column(name = "ACRONYM")
    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public String toString() {
        return "AcronymLookup [acronymId=" + acronymId + ", apps=" + apps
                + ", lookupAppName=" + lookupAppName + ", lookupAppCsid="
                + lookupAppCsid + ", acronym=" + acronym + "]";
    }
}
