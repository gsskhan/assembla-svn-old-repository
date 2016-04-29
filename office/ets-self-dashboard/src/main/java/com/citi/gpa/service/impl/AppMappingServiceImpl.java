package com.citi.gpa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.citi.gpa.constants.HqlQueryOne;
import com.citi.gpa.constants.SystemConstants;
import com.citi.gpa.dao.GenericDao;
import com.citi.gpa.document.EtsApp;
import com.citi.gpa.document.EtsAppStatus;
import com.citi.gpa.domain.AppData;
import com.citi.gpa.domain.AppDependency;
import com.citi.gpa.service.AppMappingService;


@Service("appMappingService")
public class AppMappingServiceImpl implements AppMappingService {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private GenericDao genericDao;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<AppDependency> getAllAppDependency() {
		Map<String, AppDependency> depmap = new LinkedHashMap<String, AppDependency>();
		List<AppDependency> finalList = new ArrayList<AppDependency>();
		List<Object[]> listofDependency = getAllAppHeirarchy();			
		for (Object[] obj : listofDependency ) {
			AppDependency appdepObj;								
			String appone = (String) obj[0];
			long apponeId = (Long) obj[1];
			String apptwo = (String) obj[2];
			long apptwoId = (Long) obj[3];
			String StreamFlag = (String) obj[4];
			if (appone == null || apptwo == null || StreamFlag ==null) {
				continue;
			}
			if (SystemConstants.DOWN_STREAM.equalsIgnoreCase(StreamFlag)) {		
				appdepObj = new AppDependency(apponeId, apptwoId);
				depmap.put(appone+apptwo,appdepObj);
			} else {
				appdepObj = new AppDependency(apptwoId, apponeId);
				depmap.put(apptwo+appone,appdepObj);
			}			
		}
		finalList.addAll(depmap.values());
		/*List<Long> appWithNoMappingList = getAllAppWithNoHeirarchy();
		for (Long appId : appWithNoMappingList) {
			finalList.add(new AppDependency(appId, 0));
		}*/		 
		log.info("found " + finalList.size()+" application dependency mappings ...");
		return finalList;
	}	
	

	@Override
	public List<LinkedHashMap<String, Object>> getAppDependencyForApp(long applicationId) {
		List<LinkedHashMap<String, Object>> finalList = new ArrayList<LinkedHashMap<String,Object>>();
		List<Object[]> dependencylist = getAppHeirarchyForApp(applicationId);
		for (Object[] obj : dependencylist) {
			LinkedHashMap<String, Object> jsonobj = new LinkedHashMap<String, Object>();
			String StreamFlag = (String) obj[4];
			if (SystemConstants.DOWN_STREAM.equalsIgnoreCase(StreamFlag)) {		
				jsonobj.put("fromAppId", (Long) obj[1]);
				jsonobj.put("fromAppName", (String) obj[0]);
				jsonobj.put("toAppId", (Long) obj[3]);
				jsonobj.put("toAppName", (String) obj[2]);
				jsonobj.put("status", (String) obj[5]);
			} else {
				jsonobj.put("fromAppId", (Long) obj[3]);
				jsonobj.put("fromAppName", (String) obj[2]);
				jsonobj.put("toAppId", (Long) obj[1]);
				jsonobj.put("toAppName", (String) obj[0]);
				jsonobj.put("status", (String) obj[5]);
			}
			finalList.add(jsonobj);
		}
		log.info("found " + finalList.size()+" application dependency mappings for app_id = "+applicationId);
		return finalList;
	}

	@Override
	public List<AppData> getListOfAllInternalApps() {
		List<AppData> list = new ArrayList<AppData>();
		for (EtsApp etsApp : mongoTemplate.find(Query.query(Criteria.where("category").is("I")).with(new Sort(Sort.Direction.ASC , "status")), EtsApp.class)) {
			AppData appData = new AppData( etsApp.getAppName()
										 , etsApp.getAppId()
										 , String.valueOf(mongoTemplate.findOne(Query.query(Criteria.where("appid").is(etsApp.getAppId())), EtsAppStatus.class).getAppStatus()));
			list.add(appData);
		}
		log.info("found " + list.size()+" application name and ids ...");
		return list;
	}
	
	
	private List<Object[]> getAllAppHeirarchy(){
		List<Object[]> list = genericDao.getList(HqlQueryOne.ALL_APP_HIEARCHY.getQuery(), null, HqlQueryOne.MAX_RESULTSET_LIMIT.getValue());
		return list;		
	}
	
	/*private List<Long> getAllAppWithNoHeirarchy(){
		List<Long> list = genericDao.getList(HqlQueryOne.ALL_APP_NO_HIEARCHY.getQuery(), null, HqlQueryOne.MAX_RESULTSET_LIMIT.getValue());
		return list;		
	}*/
	
	private List<Object[]> getAppHeirarchyForApp(long appId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("vappId", appId);
		List<Object[]> list = genericDao.getList(HqlQueryOne.APP_HIEARCHY.getQuery(), paramMap, HqlQueryOne.MAX_RESULTSET_LIMIT.getValue());
		return list;		
	}
	

	
}
