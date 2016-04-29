package com.citi.ets.dashboard.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.citi.ets.dashboard.constant.DashboardConstant;
import com.citi.ets.dashboard.processor.ETSDashboardProcessor;
import com.citi.ets.dashboard.utility.ETSDashboardUtil;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboardServlet")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger= Logger.getLogger(DashboardServlet.class);
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    String eventType = request.getParameter("eventType");
	PrintWriter out = response.getWriter();
	if (DashboardConstant.EVENT_TYPE_DASHBOARD.equalsIgnoreCase(eventType)) {
	    out.print(ETSDashboardProcessor.getDashboardResponse());	    
	} else if (DashboardConstant.EVENT_TYPE_HISTORY.equalsIgnoreCase(eventType)) {
	    String appName =  request.getParameter("applicationName");
	    String columnName =  request.getParameter("kpiCategoryName");
	    String dynamicAppName =  request.getParameter("kpiCategory");
	    out.print(ETSDashboardProcessor.getHistoryDetails(appName, columnName, dynamicAppName));
	  }else if (DashboardConstant.EVENT_TYPE_REPORT.equalsIgnoreCase(eventType)){
		  String appCsi = request.getParameter("appcsi");		
		  String frequency = request.getParameter("frequency");
		  if(null == appCsi){ 
			  out.print(ETSDashboardProcessor.getApplicationList());
			} else if (null != appCsi && null != frequency) {
				if (frequency.equals("DAILY")) {
					String startDate = request.getParameter("startDate");
					String endDate = request.getParameter("endDate");
					out.print(ETSDashboardProcessor.getReport(appCsi, startDate, endDate));
				} else if (frequency.equals("WEEKLY")) {
					String weekString = request.getParameter("date");					
					out.print(ETSDashboardProcessor.getReport(appCsi, ETSDashboardUtil.getDateOfWeek(weekString, "START"),
							ETSDashboardUtil.getDateOfWeek(weekString, "END")));
				} else if (frequency.equals("MONTHLY")) {
					String month = request.getParameter("date");
					out.print(ETSDashboardProcessor.getReport(appCsi,month));
				}
			}else{				
			  out.print(ETSDashboardProcessor.getApplicationNameList(appCsi));
		  }
		  
	  }
    }
    
    @Override
    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
       	doPost(arg0, arg1);
    }
}
