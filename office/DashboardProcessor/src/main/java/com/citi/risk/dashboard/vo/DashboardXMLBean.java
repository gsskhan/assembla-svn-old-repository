package com.citi.risk.dashboard.vo;

import java.util.List;

/**
 * @author gc63735 This class shall contain all the xml data.
 */
public class DashboardXMLBean {

    private String applicationCsi;
    private String applicationFullName;
    private List<DashboardKPIBean> kpiList;

    public List<DashboardKPIBean> getKpiList() {
        return kpiList;
    }

    public void setKpiList(List<DashboardKPIBean> kpiList) {
        this.kpiList = kpiList;
    }

    public String getApplicationCsi() {
        return applicationCsi;
    }

    public void setApplicationCsi(String applicationCsi) {
        this.applicationCsi = applicationCsi;
    }

    public String getApplicationFullName() {
        return applicationFullName;
    }

    public void setApplicationFullName(String applicationFullName) {
        this.applicationFullName = applicationFullName;
    }

    @Override
    public String toString() {
        return "DashboardXMLBean [applicationCsi=" + applicationCsi
                + ", applicationFullName=" + applicationFullName + ", kpiList="
                + kpiList + "]";
    }
}
