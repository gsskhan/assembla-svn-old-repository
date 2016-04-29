package com.citi.optima.retail.batch.preprocess;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author km07890
 * @param <T>
 * 
 */

public class InMortgagesDataServiceImpl implements PreProcessorDataService{

	private final Map<String, Map<String, Object>> preProcessorDataServiceMap;

	public InMortgagesDataServiceImpl() {
		preProcessorDataServiceMap = new ConcurrentHashMap<String, Map<String, Object>>();
	}

	/**
	 * 
	 * @param processStepName
	 * @return
	 */
	@Override
	public Map<String, Object> getLocalPreProcessorDataServiceMap(
			String processStepName) {
		Map<String, Object> localHistoryMap;
		if (preProcessorDataServiceMap.containsKey(processStepName)) {
			localHistoryMap = preProcessorDataServiceMap.get(processStepName);
		} else {
			localHistoryMap = new ConcurrentHashMap<String, Object>();
		}
		preProcessorDataServiceMap.put(processStepName, localHistoryMap);
		return localHistoryMap;
	}

	/**
	 * @return the historyMap
	 */
	public Map<String, Map<String, Object>> getPreProcessorDataServiceMap() {
		return preProcessorDataServiceMap;
	}


}
