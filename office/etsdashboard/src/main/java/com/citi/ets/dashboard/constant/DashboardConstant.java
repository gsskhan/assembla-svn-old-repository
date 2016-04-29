/**
 * 
 */
package com.citi.ets.dashboard.constant;


/**
 * @author ak64503
 * Contains constants for Dashboard
 */
public class DashboardConstant {	     
             
public static String EVENT_TYPE_DASHBOARD = "dashboardEvent";
public static String EVENT_TYPE_HISTORY = "historyEvent";
public static String EVENT_TYPE_REPORT = "reportEvent";

public static final String DISTINCT_APP_ID = "select distinct(a.app_id) from AppStatus a";

public static final String DISTINCT_KPI_BY_CSID = "select distinct(e.app_kpi_name) from com.citi.ets.dashboard.entity.Events e where app_csid = '";

public static String[] KPI_CATEGORY_NAME = {"INFRASTRUCTURE", "FEEDS IN", "FEEDS OUT"};

public static String[] JSON_CATEGORY_NAME = {"overall", "infrastructure", "feedsIn", "feedsOut"};

public static String COLOR_CODE_GREEN = "#33CC00";

public static String COLOR_CODE_AMBER = "#FC8200";

public static String COLOR_CODE_RED = "#FF0000";
	
public static String JSON_DELIMETER = "||";

}
