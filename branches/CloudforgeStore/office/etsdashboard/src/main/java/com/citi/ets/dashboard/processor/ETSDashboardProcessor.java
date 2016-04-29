package com.citi.ets.dashboard.processor;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.citi.ets.dashboard.bean.Bean;
import com.citi.ets.dashboard.entity.Events;
import com.citi.ets.dashboard.entity.Org;
import com.citi.ets.dashboard.service.impl.ETSDashboardServiceImpl;
import com.citi.ets.dashboard.utility.ETSDashboardUtil;

/**
 * @author ak64503
 * 
 */
public class ETSDashboardProcessor {
    
    private static ETSDashboardServiceImpl dashboardService;   
    private static String dashboardResponse;
    private static String applicationList;
    private static Org org;
    private static final Logger logger=Logger.getLogger(ETSDashboardProcessor.class);
     
    /**
     * @return the dashboardResponse
     * @throws Exception 
     */
    public static String getDashboardResponse() {        
	    return ETSDashboardProcessor.dashboardResponse;	
    }
    
    public static void setApplicationList(String appList){
    	ETSDashboardProcessor.applicationList = appList;
    }
    
    public static String getApplicationList(){
    	return ETSDashboardProcessor.applicationList;
    }
    /**
     * get application name list
     * @return
     */
    public static String getApplicationNameList(String appCsi){
    	return ETSDashboardUtil.getApplicationNameList(org, appCsi);
    }
    
    /**
     * @param dashboardResponse the dashboardResponse to set
     */
    public void setDashboardResponse(List<Bean> dashboardResponse) {
	try {
		ETSDashboardProcessor.dashboardResponse = ETSDashboardUtil.populateJSONString(dashboardResponse);
		//System.out.println("Dashboard Response JSON: " +ETSDashboardProcessor.dashboardResponse);
	} catch (Exception ex) {
		logger.info("ERROR DURING DASHBOARD JSON CREATION", ex);
		ETSDashboardProcessor.dashboardResponse = ""; // some message to ui
	}
    }
    public void setDashboardService(ETSDashboardServiceImpl dashboardService) {	
        ETSDashboardProcessor.dashboardService = dashboardService;  
        logger.info("Please wait for ETS Dashboard Response first refresh...");
        startScheduler();
    }
    public void processDashboardResponse() {
    	   logger.info("ETS Dashboard ORG refresh started @ " + new Date());
	       List<Org> orgList = dashboardService.getOrgRefDetails();
	       org = orgList.get(0); // ets	       
	       ETSDashboardUtil util = new ETSDashboardUtil();
	       setApplicationList(util.populateAppCsiJson(org));
	       setDashboardResponse(util.populateJsonBean(org));	       
	       logger.info("ETS Dashboard ORG response refreshed @ " + new Date());
    	}
    
    public void startScheduler(){	
	Timer dbTimer = new Timer();	
	dbTimer.schedule(new TimerTask(){	    
	    @Override
	    public void run() {		
		//long start = new Date().getTime();
		processDashboardResponse();
		//long end = new Date().getTime();		
	    }	    	    
	},0, 150000);
    }
    
    /**
     * populate json history
     * @param appName
     * @param kpiCategoryName
     * @param kpiCategory
     * @return
     */
	public static String getHistoryDetails(String appName, String kpiCategoryName, String kpiCategory) {
		logger.info("Hitory details requestd for " + appName + ", " + kpiCategoryName + ", and " + kpiCategory);
		kpiCategoryName = ("infra".equalsIgnoreCase(kpiCategoryName)) ? "INFRASTRUCTURE" : ("feedsin".equalsIgnoreCase(kpiCategoryName)) ? "FEEDS IN" : "FEEDS OUT";
		
		Events historyEvent = dashboardService.getHistoryDetails(appName.toUpperCase(), kpiCategoryName, kpiCategory.toUpperCase());
		LinkedHashMap<String, Object> historyDetails = new LinkedHashMap<String, Object>();

		historyDetails.put("historyContactDetails", ETSDashboardUtil.getContactDetails(historyEvent)); // ok...
		historyDetails.put("historyTableHeader", ETSDashboardUtil.determineHistoryHeader(appName, kpiCategoryName, kpiCategory));
		try {
			// considering this 2 from rt
			if (kpiCategoryName.equalsIgnoreCase("INFRASTRUCTURE") || kpiCategoryName.equalsIgnoreCase("BATCH")) {
				historyDetails.put("columns", ETSDashboardUtil.populateRTViewColumnDetails());
				historyDetails.put("items", ETSDashboardUtil.populateRViewHistory(historyEvent));
			} else {
				historyDetails.put("columns", ETSDashboardUtil.populateOSMColumnDetails(historyEvent));
				historyDetails.put("items", ETSDashboardUtil.populateOSMHistory(historyEvent));
			}			
			return (new ObjectMapper().writeValueAsString(historyDetails));
		} catch (Exception e) {
			logger.info("ERROR DURING HISTORY JSON PROCESS for " + appName + ", " + kpiCategoryName + ", and " + kpiCategory, e);
			return ""; // some message to ui
		}
	}
    /**
     * populate report json by date range
     * @param appCsi
     * @param startDate
     * @param endDate
     * @return
     */
	public static String getReport(String appCsi, String startDate, String endDate) {
		try {
			logger.info("Report details requested for csid = " + appCsi + ", start date = " + startDate + ", and end date = " + endDate);
			List<Events> reportEventList = dashboardService.getReportEvents(appCsi, startDate, endDate);		
			return (new ObjectMapper().writeValueAsString(ETSDashboardUtil.populateReportDetails(reportEventList)));
		} catch (Exception e) {
			logger.info("ERROR DURING REPORT JSON PROCESS for " + appCsi + ", " + startDate + ", and " + endDate, e);
			return ""; // some message to ui
		}
	}
	
	public static String getReport(String appCsi, String month) {
		try {
			logger.info("Report details requested for csid = " + appCsi + " for month = " + month ); 
			List<Events> reportEventList = dashboardService.getReportEvents(appCsi, month);
			return (new ObjectMapper().writeValueAsString(ETSDashboardUtil.populateReportDetails(reportEventList)));
		} catch (Exception e) {
			logger.info("ERROR DURING REPORT JSON PROCESS for " + appCsi + ", and " + month, e);
			return ""; // some message to ui
		}
	}
    
    
}
