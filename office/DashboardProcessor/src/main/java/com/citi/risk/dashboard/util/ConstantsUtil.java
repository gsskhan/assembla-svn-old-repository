package com.citi.risk.dashboard.util;

/**
 * 
 * @author gc63735 All system constants for standalone job.
 */
public enum ConstantsUtil {
    UPDATE_USER_NAME_DEV("DSBDProcessor_DEV"),
    
    COL_RED("#FF0000"),
    COL_AMBER("#FC8200"),
    COL_YELLOW("#FFFF00"),
    COL_GREEN("#33CC00"),
    COL_GREY("#AEAEAE"),
    
    KPI_FEEDS("FEEDS"),
    KPI_CAT_INFRA("INFRASTRUCTURE"),
    KPI_CAT_FEEDS_IN("FEEDS IN"),
    KPI_CAT_FEEDS_OUT("FEEDS OUT");

    private String constants;

    private ConstantsUtil(String value) {
        constants = value;
    }

    public String getConstants() {
        return constants;
    }
}
