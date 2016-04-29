/**
 * 
 */
package com.citi.optima.retail.batch.preprocess;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mc56120
 * @param <T>
 * 
 */
public class TwCardsDataServiceImpl implements PreProcessorDataService {

	/**
	 * eg :
	 * 
	 * Map<p1, Map<delqHistory,Map<Acctno, Data>>>
	 * Map<p2,Map<commitEvent,Map<Acctno, Data>>>
	 */
	private final Map<String, Map<String, Object>> preProcessorDataServiceMap;

	public TwCardsDataServiceImpl() {
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
