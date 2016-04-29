package com.citi.gpa.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.citi.gpa.domain.AppData;
import com.citi.gpa.domain.AppDependency;

public interface AppMappingService {
	
	List<AppDependency> getAllAppDependency();
	
	List<AppData> getListOfAllInternalApps();
	
	List<LinkedHashMap<String, Object>> getAppDependencyForApp(long applicationId);

}
