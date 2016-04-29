package com.citi.ets.dashboard.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.citi.ets.dashboard.bean.Bean;
import com.citi.ets.dashboard.bean.ColumnDetails;
import com.citi.ets.dashboard.bean.Component;
import com.citi.ets.dashboard.constant.DashboardConstant;
import com.citi.ets.dashboard.entity.AppArea;
import com.citi.ets.dashboard.entity.Apps;
import com.citi.ets.dashboard.entity.Contacts;
import com.citi.ets.dashboard.entity.Events;
import com.citi.ets.dashboard.entity.Org;
import com.citi.ets.dashboard.service.impl.ETSDashboardServiceImpl;

public class ETSDashboardUtil {

    private static ETSDashboardServiceImpl dashboardService;
    private static final Logger logger=Logger.getLogger(ETSDashboardUtil.class); 
    private List<Bean> sectorBeanList = new ArrayList<Bean>();;
    private Bean sector, subSector, dynamicApp;
    	
    public void setDashboardService(ETSDashboardServiceImpl dashboardService) {
	ETSDashboardUtil.dashboardService = dashboardService;
    }

	public List<Bean> populateJsonBean(Org org) {
		sectorBeanList.clear();
		// for areas
		List<AppArea> appAreasSet = new ArrayList<AppArea>(org.getAppAreas());
		Collections.sort(appAreasSet);
		for (AppArea area : appAreasSet) {
			String overAllStatus = dashboardService.getAppAreaOverallStatus(area.getApp_area_id());
			if (null != overAllStatus) {
				sector = new Bean();
				sector.setAppname(area.getApp_area_name());
				sector.setOverall(overAllStatus);
				sector.setInfra(dashboardService.getAppAreaStatus(area.getApp_area_id(), "INFRASTRUCTURE"));
				sector.setFeedsIn(dashboardService.getAppAreaStatus(area.getApp_area_id(), "FEEDS IN"));
				sector.setFeedsOut(dashboardService.getAppAreaStatus(area.getApp_area_id(), "FEEDS OUT"));

				List<Bean> appListChildren = new ArrayList<Bean>();

				// for apps
				List<Apps> appSet = new ArrayList<Apps>(area.getApps());
				Collections.sort(appSet);
				List<String> distinctApps = dashboardService.getDistinctAppsId();

				for (Apps app : appSet) {
					if (distinctApps.contains(app.getApps_id())) {
						// this is to avoid unnecessary hib call, where no app
						// status presents for any app
						subSector = new Bean();
						subSector.setAppname(app.getApp_name());
						subSector.setOverall(dashboardService.getAppOverallStatus(app.getApps_id()));
						subSector.setInfra(dashboardService.getAppStatus(app.getApps_id(), "INFRASTRUCTURE"));
						subSector.setFeedsIn(dashboardService.getAppStatus(app.getApps_id(), "FEEDS IN"));
						subSector.setFeedsOut(dashboardService.getAppStatus(app.getApps_id(), "FEEDS OUT"));

						List<Bean> dynamicAppListChildren = new ArrayList<Bean>();

						// for events
						List<String> distinctKpiForThisApp = dashboardService.getDistinctKPIbyAppCSI(app.getApp_csid());
						Collections.sort(distinctKpiForThisApp);
						for (String kpi : distinctKpiForThisApp) {
							dynamicApp = new Bean();
							String desc;
							dynamicApp.setAppname(kpi);

							Events event = dashboardService.getLatestEvent(app.getApp_name(), kpi, "INFRASTRUCTURE");
							dynamicApp.setInfra(event.getApp_event_category_status()); // set color first
							desc = event.getEvent_message();
							if (null != dynamicApp.getInfra() && !DashboardConstant.COLOR_CODE_GREEN.equals(dynamicApp.getInfra())) { // not green
								if (null != desc) {
									desc += ". Please click on more for further details.";
								}
								dynamicApp.setInfra(dynamicApp.getInfra() + DashboardConstant.JSON_DELIMETER + getCustomValue(event.getKpi_value(), kpi) + DashboardConstant.JSON_DELIMETER + desc);
							}

							event = dashboardService.getLatestEvent(app.getApp_name(), kpi, "FEEDS IN");
							dynamicApp.setFeedsIn(event.getApp_event_category_status()); // set color first
							desc = event.getEvent_message();
							if (null != dynamicApp.getFeedsIn() && !DashboardConstant.COLOR_CODE_GREEN.equals(dynamicApp.getFeedsIn())) { // not green
								if (null != desc) {
									desc += ". Please click on more for further details.";
								}
								dynamicApp.setFeedsIn(dynamicApp.getFeedsIn() + DashboardConstant.JSON_DELIMETER + getCustomValue(event.getKpi_value(), kpi) + DashboardConstant.JSON_DELIMETER + desc);
							}

							event = dashboardService.getLatestEvent(app.getApp_name(), kpi, "FEEDS OUT");
							dynamicApp.setFeedsOut(event.getApp_event_category_status());
							desc = event.getEvent_message();
							if (null != dynamicApp.getFeedsOut() && !DashboardConstant.COLOR_CODE_GREEN.equals(dynamicApp.getFeedsOut())) { // not green
								if (null != desc) {
									desc += ". Please click on more for further details.";
								}
								dynamicApp.setFeedsOut(dynamicApp.getFeedsOut() + DashboardConstant.JSON_DELIMETER + getCustomValue(event.getKpi_value(), kpi) + DashboardConstant.JSON_DELIMETER + desc);
							}
							dynamicAppListChildren.add(dynamicApp);
						}
						subSector.setChildren(dynamicAppListChildren);
						appListChildren.add(subSector);
					}

				}
				sector.setChildren(appListChildren);
				sectorBeanList.add(sector);
			}
		}
		return sectorBeanList;
	}
    
    /**
     * populate json for application listing
     * @param org
     * @return
     */
    public String populateAppCsiJson(Org org){    	
    	List<AppArea> appAreasSet = new ArrayList<AppArea>(org.getAppAreas());	
    	List<String> appCsiList = new ArrayList<String>();    	
    	for (AppArea area : appAreasSet) {
    		List<Apps> appSet = new ArrayList<Apps>(area.getApps());
    		for (Apps app : appSet) {
    			if(!appCsiList.contains(app.getApp_csid())){ // avoid duplicate
    				appCsiList.add(app.getApp_csid());	
    			}    			 
    		}
    	}    	
    	try {
    		Collections.sort(appCsiList);
    		List<LinkedHashMap<String, String>> appCsiMapList = new ArrayList<LinkedHashMap<String, String>>();    	
    		for(String csi : appCsiList){
    			LinkedHashMap<String, String> csiMap = new LinkedHashMap<String, String>();
    			csiMap.put("text", csi);
    			appCsiMapList.add(csiMap);
    		}   		
			return new ObjectMapper().writeValueAsString(appCsiMapList);
		} catch (Exception ex) {		
			logger.info("Error during app Json population ", ex);
			 return "";
		} 
    }
    
    /**
     * get application name list
     * @param org
     * @return
     */
    public static String getApplicationNameList(Org org, String appCsi){    	
    	List<AppArea> appAreasSet = new ArrayList<AppArea>(org.getAppAreas());	
    	List<String> appNameList = new ArrayList<String>();    	
    	for (AppArea area : appAreasSet) {
    		List<Apps> appSet = new ArrayList<Apps>(area.getApps());
    		for (Apps app : appSet) {
    			if(appCsi.equalsIgnoreCase(app.getApp_csid())){
    				appNameList.add(app.getApp_name());	
    			}    			 
    		}
    	}    	
    	try {
    		Collections.sort(appNameList);
    		List<LinkedHashMap<String, String>> appNameMapList = new ArrayList<LinkedHashMap<String, String>>();    	
    		for(String name : appNameList){
    			LinkedHashMap<String, String> nameMap = new LinkedHashMap<String, String>();
    			nameMap.put("text", name);
    			appNameMapList.add(nameMap);
    		}
			return new ObjectMapper().writeValueAsString(appNameMapList);
		} catch (Exception ex) {		
			logger.info("Error during app name list Json population ", ex);
			 return "";
		} 
    }
    
    private String getCustomValue(String value, String kpi){
	String message = value;
	if(null != kpi){	    
	    if(kpi.toLowerCase().contains("late") || kpi.toLowerCase().contains("delayed")){
		message += " Delayed";		
	    }else if(kpi.toLowerCase().contains("missed")){
		message += " Missed";
	    }   
	}
	 return message;
    }

    /**
     * determine which type of component and set accordingly
     * 
     * @param columnDetails
     * @param component
     * @param columnType
     */
   /* private void addComponentToColumnDetails(ColumnDetails columnDetails, Component component, String columnType) {
	if ("INFRASTRUCTURE".equalsIgnoreCase(columnType)) {
	    columnDetails.setInfrastructure(component);
	} else if ("BATCH".equalsIgnoreCase(columnType)) {
	    columnDetails.setBatch(component);
	} else if ("FEEDS IN".equalsIgnoreCase(columnType)) {
	    columnDetails.setFeedsIn(component);
	} else if ("FEEDS OUT".equalsIgnoreCase(columnType)) {
	    columnDetails.setFeedsOut(component);
	} else if ("DAILY PROCESSING".equalsIgnoreCase(columnType)) {
	    columnDetails.setDailyProcessing(component);
	} else if ("MONTHLY PROCESSING".equalsIgnoreCase(columnType)) {
	    columnDetails.setMonthlyProcessing(component);
	}
    }*/
    
    /**
     * create the json string as per ui format
     * @param jsonBeanList
     * @return String
     * @throws Exception 
     */
    /*public static String populateJsonString(List<SectorBean> sectorBeanList) throws Exception {
	List<String> jsonList = new ArrayList<String>();
	for (SectorBean sectorBean : sectorBeanList) {
	    LinkedHashMap<String, Object> sector = new LinkedHashMap<String, Object>();
	    sector.put("sectorName", sectorBean.getSectorName());
	    sector.put("subSectorName", sectorBean.getSubSectorName());
	    sector.put("dynamicAppName", sectorBean.getDynamicAppName());
	    sector.put("subDynamicAppName", sectorBean.getSubDynamicAppName());
	    LinkedHashMap<String, Object> columnDetails = new LinkedHashMap<String, Object>();
	    for (int i = 0; i < DashboardConstant.JSON_CATEGORY_NAME.length; i++) {
		LinkedHashMap<String, Object> component = new LinkedHashMap<String, Object>();
		Field f = sectorBean.getColumnDetails().getClass().getDeclaredField(DashboardConstant.JSON_CATEGORY_NAME[i]);
		f.setAccessible(true);
		Component object = (Component) f.get(sectorBean.getColumnDetails());
		component.put("value", object.getValue());
		component.put("description", object.getDescription());
		component.put("colorCode", object.getColorCode());
		columnDetails.put(DashboardConstant.JSON_CATEGORY_NAME[i], component);
	    }
	    sector.put("columnDetails", columnDetails);
	    jsonList.add(new ObjectMapper().writeValueAsString(sector));
	}
	return jsonList.toString();
    }*/
       
    public static String populateJSONString(List<Bean> sectorBeanList) throws Exception {  // with not showing any Green dynamicAppBean   	
    	LinkedHashMap<String, Object> mainMap = new LinkedHashMap<String, Object>();
    	mainMap.put("text", ".");
    	List<LinkedHashMap<String, Object>> sectorList = new ArrayList<LinkedHashMap<String, Object>>();
    	for (Bean sectorBean : sectorBeanList) {
    	    LinkedHashMap<String, Object> sector = new LinkedHashMap<String, Object>();
    	    sector.put("appname", formatName(sectorBean.getAppname()));
    	    sector.put("overall", checkNull(sectorBean.getOverall()));
    	    sector.put("infra", checkNull(sectorBean.getInfra()));
    	    sector.put("feedsin", checkNull(sectorBean.getFeedsIn()));
    	    sector.put("feedsout", checkNull(sectorBean.getFeedsOut()));
    	    List<LinkedHashMap<String, Object>> appList = new ArrayList<LinkedHashMap<String, Object>>();
    	    for(Bean subSectorBean : sectorBean.getChildren()){
    	    	LinkedHashMap<String, Object> subSector = new LinkedHashMap<String, Object>();
    	    	subSector.put("appname", formatName(subSectorBean.getAppname()));
    	    	subSector.put("overall", checkNull(subSectorBean.getOverall()));
    	    	subSector.put("infra", checkNullOrGreen(subSectorBean.getInfra()));
    	    	subSector.put("feedsin", checkNullOrGreen(subSectorBean.getFeedsIn()));
    	    	subSector.put("feedsout", checkNullOrGreen(subSectorBean.getFeedsOut()));
    	    	List<LinkedHashMap<String, Object>> dynamicAppList = new ArrayList<LinkedHashMap<String, Object>>();
    	    	List<LinkedHashMap<String, Object>> dynamicAppFeedsList = new ArrayList<LinkedHashMap<String, Object>>();
    	    	for(Bean dynamicAppBean : subSectorBean.getChildren()){    	    		
    	    		LinkedHashMap<String, Object> dynamicApp = new LinkedHashMap<String, Object>();
    	    		if(dynamicAppBean.getAppname().contains("FEEDS") &&
    	    				((null != dynamicAppBean.getFeedsIn() && !dynamicAppBean.getFeedsIn().contains(DashboardConstant.COLOR_CODE_GREEN)) || 
    	    				(null != dynamicAppBean.getFeedsOut() && !dynamicAppBean.getFeedsOut().contains(DashboardConstant.COLOR_CODE_GREEN)))){    	    			
    	    			LinkedHashMap<String, Object> feedAppMap = new LinkedHashMap<String, Object>();
    	    			feedAppMap.put("appname", formatName(dynamicAppBean.getAppname()));
    	    			feedAppMap.put("overall", checkNull(dynamicAppBean.getOverall()));
    	    			feedAppMap.put("infra", checkNull(dynamicAppBean.getInfra()));
    	    			feedAppMap.put("feedsin", checkNullOrGreen(dynamicAppBean.getFeedsIn()));
    	    			feedAppMap.put("feedsout", checkNullOrGreen(dynamicAppBean.getFeedsOut()));
    	    			feedAppMap.put("leaf", "true");
    	    			dynamicAppFeedsList.add(feedAppMap);   	    			      	    		
    	    		}else if(!dynamicAppBean.getAppname().contains("FEEDS") && null != dynamicAppBean.getInfra() && !dynamicAppBean.getInfra().contains(DashboardConstant.COLOR_CODE_GREEN)){
    	    		dynamicApp.put("appname", formatName(dynamicAppBean.getAppname()));
    	    		dynamicApp.put("overall", checkNull(dynamicAppBean.getOverall()));
    	    		dynamicApp.put("infra", checkNullOrGreen(dynamicAppBean.getInfra()));
    	    		dynamicApp.put("feedsin", checkNull(dynamicAppBean.getFeedsIn()));
    	    		dynamicApp.put("feedsout", checkNull(dynamicAppBean.getFeedsOut()));
    	    		dynamicApp.put("leaf", "true");
    	    		dynamicAppList.add(dynamicApp);
    	    		}    	    		
    	    	}
    	    	if(!dynamicAppFeedsList.isEmpty()){
    	    	LinkedHashMap<String, Object> feedsAppMap = new LinkedHashMap<String, Object>();
    	    	feedsAppMap.put("appname", "Feeds");
    	    	feedsAppMap.put("overall", "");
    	    	feedsAppMap.put("infra", "");
    	    	feedsAppMap.put("feedsin", checkNull(subSectorBean.getFeedsIn()));
    	    	feedsAppMap.put("feedsout", checkNull(subSectorBean.getFeedsOut()));
    	    	feedsAppMap.put("children", dynamicAppFeedsList);
    	    	dynamicAppList.add(feedsAppMap);     	    	
    	    	}
    	    	subSector.put("children", dynamicAppList);
    	    	appList.add(subSector);
    	    }
    	    sector.put("children", appList);
    	    sectorList.add(sector); 
    	}
    	mainMap.put("children", sectorList);
    	return new ObjectMapper().writeValueAsString(mainMap);
    }
    
    
    private static String checkNull(String input){
    	return (null == input) ? "" : input;
    }
    private static String checkNullOrGreen(String input){
    	return (null == input || DashboardConstant.COLOR_CODE_GREEN.equals(input)) ? "" : input;    			
    }
      
    /**
     * format application name
     * @param appName
     * @return
     */
    private static String formatName(String appName){    	
    	appName = appName.toLowerCase();
    	String[] eachName = appName.split(" ");
    	appName = "";
    	for(String partName : eachName){
    		partName = partName.substring(0, 1).toUpperCase() + partName.substring(1);
    		appName = appName + partName + " ";
    	}
    	if("GCBC".equalsIgnoreCase(appName.trim())) return appName.toUpperCase();
    	else return appName.trim();
    }
    
    /**
     * add all sector bean to a complete list
     * 
     * @param bean
     */

   /* private void addBeanToJson(List<SectorBean> jsonBean, SectorBean bean) {
    	if(!(DashboardConstant.COLOR_CODE_GREEN.equals(bean.getColumnDetails().getFeedsIn().getColorCode()) && 
    			DashboardConstant.COLOR_CODE_GREEN.equals(bean.getColumnDetails().getFeedsOut().getColorCode()))){
    		
    		if(null != bean.getSubDynamicAppName()){ // for feeds change/ patch
    			SectorBean feedBean = new SectorBean();
    			feedBean.setSectorName(bean.getSectorName());
    			feedBean.setSubSectorName(bean.getSubSectorName());
    			feedBean.setDynamicAppName("FEEDS");
    			
    			Component comIn = new Component();
    			comIn.setColorCode(bean.getColumnDetails().getFeedsIn().getColorCode());
    			Component comOut = new Component();
    			comOut.setColorCode(bean.getColumnDetails().getFeedsOut().getColorCode());
    			ColumnDetails col = new ColumnDetails();
    			col.setFeedsIn(comIn);
    			col.setFeedsOut(comOut);
    			col.setInfrastructure(new Component());
    			col.setOverall(new Component());
    			
    			feedBean.setColumnDetails(col);
    			
    			jsonBean.add(feedBean);	
    			
    			bean.setDynamicAppName("FEEDS");
    		}    		
    		jsonBean.add(bean);	
    	}	
    }*/
    
    public static List<LinkedHashMap<String, String>> populateRTViewColumnDetails(){
    	List<LinkedHashMap<String, String>> columnList = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> aname = new LinkedHashMap<String, String>();
		aname.put("header", "App Name");
		aname.put("dataIndex", "appName");
		aname.put("width", "20%");
		columnList.add(aname);
		LinkedHashMap<String, String> comp = new LinkedHashMap<String, String>();
		comp.put("header", "Component");
		comp.put("dataIndex", "component");
		comp.put("width", "20%");
		columnList.add(comp);
		LinkedHashMap<String, String> cat = new LinkedHashMap<String, String>();
		cat.put("header", "Category");
		cat.put("dataIndex", "category");
		cat.put("width", "20%");
		columnList.add(cat);
		LinkedHashMap<String, String> kpi = new LinkedHashMap<String, String>();
		kpi.put("header", "KPI Value");
		kpi.put("dataIndex", "kpi");
		kpi.put("width", "20%");
		columnList.add(kpi);
		LinkedHashMap<String, String> update = new LinkedHashMap<String, String>();
		update.put("header", "Last Update");
		update.put("dataIndex", "lastUpdate");
		update.put("width", "20%");
		columnList.add(update);    	
    	return columnList; 
    }
    /**
     *populate the rtview json list
     * @param historyEventsRT
     * @return List<RTViewHistory> 
     * @throws Exception 
     * @throws JsonMappingException 
     * @throws JsonGenerationException 
     */
	public static List<LinkedHashMap<String, Object>> populateRViewHistory(Events historyEventRT) throws Exception {
		List<LinkedHashMap<String, Object>> RTViewHistoryList = new ArrayList<LinkedHashMap<String, Object>>();

		LinkedHashMap<String, Object> history = new LinkedHashMap<String, Object>();
		// RTViewHistory history = new RTViewHistory();
		history.put("appName", historyEventRT.getApp_name());
		history.put("component", historyEventRT.getKpi_category_name());
		history.put("category", historyEventRT.getApp_kpi_name());
		history.put("kpi", historyEventRT.getKpi_value());
		history.put("lastUpdate", (null != historyEventRT.getLast_update()) ? historyEventRT.getLast_update().toString() : "");
		RTViewHistoryList.add(history);
		return RTViewHistoryList;
	}
	
	public static List<LinkedHashMap<String, String>> populateOSMColumnDetails(Events historyEventOSM){		
		List<LinkedHashMap<String, String>> columnList = new ArrayList<LinkedHashMap<String, String>>();
		
		if(historyEventOSM.getKpi_parameter().contains("CUTOFF TIME")){
			LinkedHashMap<String, String> fname = new LinkedHashMap<String, String>();
			fname.put("header", "File Name");
			fname.put("dataIndex", "fname");
			fname.put("width", "50%");
			columnList.add(fname);
			LinkedHashMap<String, String> ctime = new LinkedHashMap<String, String>();
			ctime.put("header", "CutOff Time");
			ctime.put("dataIndex", "ctime");
			ctime.put("width", "50%");
			columnList.add(ctime);
		}else{
			LinkedHashMap<String, String> fname = new LinkedHashMap<String, String>();
			fname.put("header", "File Name");
			fname.put("dataIndex", "fname");
			fname.put("width", "33.33%");
			columnList.add(fname);
			LinkedHashMap<String, String> etime = new LinkedHashMap<String, String>();
			etime.put("header", "Expected Arrival Time");
			etime.put("dataIndex", "etime");
			etime.put("width", "33.33%");
			LinkedHashMap<String, String> atime = new LinkedHashMap<String, String>();
			atime.put("header", "Actual Arrival Time");
			atime.put("dataIndex", "atime");
			atime.put("width", "33.33%");
			columnList.add(etime);
			columnList.add(atime);
		}		
		return columnList;
	}
    
    /**
     *populate the osm json list
     * @param historyEventsRT
     * @return List<RTViewHistory> 
     */
	public static List<LinkedHashMap<String, Object>> populateOSMHistory(Events historyEventOSM) {
		List<LinkedHashMap<String, Object>> OSMHistoryList = new ArrayList<LinkedHashMap<String, Object>>();
		
		String[] feedRecords = historyEventOSM.getKpi_parameter().split(","); 
		for (String feedRecord : feedRecords) {
			LinkedHashMap<String, Object> history = new LinkedHashMap<String, Object>();
			try{
			String[] singleRecord = feedRecord.split("\\|");
			history.put("fname", singleRecord[0]);
			if (singleRecord[1].contains("CUTOFF TIME")) {
				history.put("ctime", formatDate(singleRecord[1].replace("CUTOFF TIME-", "")));
			} else { // compare with key word
				history.put("etime", formatDate(singleRecord[1].replace("EXPECTED_TIME-", "")));
				history.put("atime", formatDate(singleRecord[2].replace("ACTUAL ARRIVAL TIME-", "")));
			}}catch(Exception e){
				logger.info("Error at osm history data population"+e);
			}
			OSMHistoryList.add(history);
		}
		return OSMHistoryList;
	}
        /**
         * populate contact info
         * @param event
         * @return
         */
    public static LinkedHashMap<String, String> getContactDetails(Events event){
	    Contacts contact = dashboardService.getContactDetails(event.getApps_id());
	    LinkedHashMap<String, String> contactMap = new LinkedHashMap<String, String>();
	    
	    contactMap.put("ApplicationName", event.getApp_name());
	    contactMap.put("CSI_ID", event.getApp_csid());
	    contactMap.put("acronym", dashboardService.getAcronymDetails(event.getApps_id()).getAcronym());  
	    contactMap.put("sector", contact.getSector());
	    contactMap.put("appMgr", contact.getApp_mgr());
	    contactMap.put("suppMgr", contact.getSupp_mgr());
	    contactMap.put("level3Org", contact.getLevel3Org());
	    contactMap.put("level5Org", contact.getLevel5Org());	
	    return contactMap;    
	    
    }
    
    
    /**
     * Format date for history UI 
     * @param inputFormat
     * @return
     */    
    public static String formatDate(String inputFormat){
	SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	SimpleDateFormat sdfOutput = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
	try {
	    return sdfOutput.format(sdfInput.parse(inputFormat));
	} catch (ParseException e) {
	   logger.info("invalid date format ", e);
	   return "";
	}
    }
    /**
     * Determine the dynamic header for history
     * @param appName
     * @param kpiCategoryName
     * @param kpiCategory
     * @return
     */
    
    public static String determineHistoryHeader(String appName, String kpiCategoryName, String kpiCategory){
	StringBuffer header = new StringBuffer();
	if(kpiCategory.toLowerCase().contains("late") || kpiCategory.toLowerCase().contains("delayed")){ // Str.matches("(.*)Tutorials(.*)") ?
	    header.append("Delayed ");
	}else if(kpiCategory.toLowerCase().contains("missed")){
	    header.append("Missed ");
	}
	if(DashboardConstant.KPI_CATEGORY_NAME[0].equalsIgnoreCase(kpiCategoryName)){
	    header.append("RTView Data for ");
	}else if(DashboardConstant.KPI_CATEGORY_NAME[1].equalsIgnoreCase(kpiCategoryName)){
	    header.append("Incoming Feeds from ");
	}else if(DashboardConstant.KPI_CATEGORY_NAME[2].equalsIgnoreCase(kpiCategoryName)){
	    header.append("Outgoing Feeds from ");
	}
	return header.append(appName).toString();	
    }    
    /**
     * populate report details
     * @param reportEventList
     * @return
     */
    
    public static List<LinkedHashMap<String, String>> populateReportDetails(List<Events> reportEventList){
    	List<LinkedHashMap<String, String>> reportList = new ArrayList<LinkedHashMap<String, String>>();
    	SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
    	for(Events event : reportEventList){
    		LinkedHashMap<String, String> reportMap = new LinkedHashMap<String, String>();
    		reportMap.put("component", event.getApp_kpi_name());
    		reportMap.put("timestamp", formatter.format(event.getEvent_timestamp()));
    		reportMap.put("status", event.getApp_event_category_status());	
    		reportList.add(reportMap);			
		}
    	return reportList;
    }
    /**
     * get start and end date of a week
     * @param weekString
     * @param flag
     * @return
     */
    
    public static String getDateOfWeek(String weekString, String flag){
    	int year =  Integer.parseInt(weekString.substring(0, 4));
		int week = Integer.parseInt(weekString.substring(5));
		
		Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.WEEK_OF_YEAR, week);
        calendar.set(Calendar.YEAR, year);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if(flag.equals("START"))
        	return formatter.format(date);
        else 
        	calendar.add(Calendar.DATE, 6);
        	date = calendar.getTime();
        	return formatter.format(date);
    }
}
