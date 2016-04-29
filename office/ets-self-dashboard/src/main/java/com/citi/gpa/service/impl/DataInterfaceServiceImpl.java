package com.citi.gpa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.gpa.constants.HqlQueryOne;
import com.citi.gpa.dao.GenericDao;
import com.citi.gpa.service.DataInterfaceService;

@Service("dataInterfaceService")
public class DataInterfaceServiceImpl implements DataInterfaceService{
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private GenericDao genericDao;

	@Override
	public List<LinkedHashMap<String, Object>> getDataInterfaceForApp(long appId) {
		List<LinkedHashMap<String, Object>> finalList = new ArrayList<LinkedHashMap<String,Object>>();
		List<Object[]> dataInterfacelist = getDataInterfaceList(appId);
		for (Object[] obj : dataInterfacelist) {
			LinkedHashMap<String, Object> jsonobj = new LinkedHashMap<String, Object>();
			jsonobj.put("app_id", (Long) obj[0]);
			jsonobj.put("int_id", (Long) obj[1]);
			jsonobj.put("category", (String) obj[2]);
			jsonobj.put("name", (String) obj[3]);
			jsonobj.put("type", (String) obj[4]);
			jsonobj.put("desc", (String) obj[5]);
			jsonobj.put("status", "green");			
			finalList.add(jsonobj);
		}
		log.info("found "+ finalList.size()+" data interface records for app Id = " + appId);
		return finalList;
	}

	private List<Object[]> getDataInterfaceList(long appId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("vappId", appId);
		List<Object[]> list = genericDao.getList(HqlQueryOne.LIST_OF_DATA_INTERFACE_FOR_APP.getQuery(), paramMap, HqlQueryOne.MAX_RESULTSET_LIMIT.getValue());
		return list;
	}

}
