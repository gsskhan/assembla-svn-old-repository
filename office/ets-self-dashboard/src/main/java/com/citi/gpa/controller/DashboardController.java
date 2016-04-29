package com.citi.gpa.controller;



import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citi.gpa.service.AppMappingService;
import com.citi.gpa.service.DataInterfaceService;
import com.citi.gpa.service.InfrastructureService;
import com.citi.gpa.util.JsonCreator;

@Controller
public class DashboardController {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private AppMappingService appMappingService;
	@Autowired
	private DataInterfaceService dataInterfaceService;
	@Autowired
	private InfrastructureService infrastructureService;
	
	
	@ResponseBody
	@RequestMapping("/appdependency")
	public String getAppDependency(){
		String result = "";
		try {
			result = JsonCreator.getJson(appMappingService.getAllAppDependency());
		} catch (HibernateException e) {
			log.error("Hibernate Exception in getting application dependency json string.", e);
		} catch (Exception e) {
			log.error("Exception in getting application dependency json string.", e);
		} finally {
			if(result.length() ==0)
				log.info("Empty string returned.");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/appdependency/{id}")
	public String getAppDependencyForApp(@PathVariable("id") Long applicationId){
		String result = "";
		try {
			result = JsonCreator.getJson(appMappingService.getAppDependencyForApp(applicationId));
		} catch (HibernateException e) {
			log.error("Hibernate Exception in getting application dependency json string for app = "+applicationId, e);
		} catch (Exception e) {
			log.error("Exception in getting application dependency json string for app = "+applicationId, e);
		} finally {
			if(result.length() ==0)
				log.info("Empty string returned.");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/internalapplist")
	public String getAppList(){
		String result = "";
		try {
			result=  JsonCreator.getJson(appMappingService.getListOfAllInternalApps());
		} catch (HibernateException e) {
			log.error("Hibernate Exception in creating internal application json string.", e);
		} catch (JsonProcessingException e) {
			log.error("Jackson Processing Exception in creating internal application json string.", e);
		} catch (Exception e) {
			log.error("Exception in getting internal application json string.", e);
		} finally {
			if(result.length() ==0)
				log.info("Empty string returned.");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/datainterface/{id}")
	public String getAppDataInterfaceRecords(@PathVariable("id") Long applicationId){
		String result = "";
		try {
			result=  JsonCreator.getJson(dataInterfaceService.getDataInterfaceForApp(applicationId));
		} catch (HibernateException e) {
			log.error("Hibernate Exception in creating data interface json string.", e);
		} catch (JsonProcessingException e) {
			log.error("Jackson Processing Exception in creating data interface json string.", e);
		} catch (Exception e) {
			log.error("Exception in getting data interface json string.", e);
		} finally {
			if(result.length() ==0)
				log.info("Empty string returned.");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/infrastructure/{id}")
	public String getAppInfrastructureRecords(@PathVariable("id") Long applicationId){
		String result = "";
		try {
			result=  JsonCreator.getJson(infrastructureService.getInfrastructureForApp(applicationId));
		} catch (HibernateException e) {
			log.error("Hibernate Exception in creating infrastructure json string.", e);
		} catch (JsonProcessingException e) {
			log.error("Jackson Processing Exception in creating infrastructure json string.", e);
		} catch (Exception e) {
			log.error("Exception in getting infrastructure json string.", e);
		} finally {
			if(result.length() ==0)
				log.info("Empty string returned.");
		}
		return result;
	}

}
