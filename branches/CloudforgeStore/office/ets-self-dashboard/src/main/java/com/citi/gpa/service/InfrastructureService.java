package com.citi.gpa.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface InfrastructureService {
	
	public List<LinkedHashMap<String, Object>> getInfrastructureForApp(long appId);

}
