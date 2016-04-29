package com.citi.risk.dashboard.vo;

import java.util.Date;

/**
 * @author gc63735 This class shall hold all the kpi details from incoming xml.
 */
public class DashboardKPIBean {

    private String kpiName;
    private String kpiStatusCode;
    private String kpiDescription;
    private String kpiValue;
    private String kpiParameter;
    private Date eventTimestamp;

    public String getKpiParameter() {
        return kpiParameter;
    }

    public void setKpiParameter(String kpiParameter) {
        this.kpiParameter = kpiParameter;
    }

    public Date getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Date eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getKpiStatusCode() {
        return kpiStatusCode;
    }

    public void setKpiStatusCode(String kpiStatusCode) {
        this.kpiStatusCode = kpiStatusCode;
    }

    public String getKpiDescription() {
        return kpiDescription;
    }

    public void setKpiDescription(String kpiDescription) {
        this.kpiDescription = kpiDescription;
    }

    public String getKpivalue() {
        return kpiValue;
    }

    public void setKpiValue(String kpiValue) {
        this.kpiValue = kpiValue;
    }

    @Override
    public String toString() {
        return "DashboardKPIBean [kpiName=" + kpiName + ", kpiStatusCode="
                + kpiStatusCode + ", kpiDescription=" + kpiDescription
                + ", kpiValue=" + kpiValue + ", kpiParameter=" + kpiParameter
                + "," + " eventTimestamp=" + eventTimestamp + "]";
    }
}
