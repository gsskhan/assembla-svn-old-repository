package com.citi.gpa.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface DataInterfaceService {
	
	List<LinkedHashMap<String, Object>> getDataInterfaceForApp(long appId);

}
