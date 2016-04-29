package com.citi.retail.optima.etl.batch.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;

public class BatchErrorReportServiceImpl implements ErrorReportDataService {

	private final Map<String, Map<String, OptimaRetailDataException>> errorDataServiceMap;

	private final Map<String, List<String>> errorDataServiceList;

	public BatchErrorReportServiceImpl() {
		errorDataServiceMap = new ConcurrentHashMap<String, Map<String, OptimaRetailDataException>>();
		errorDataServiceList = new ConcurrentHashMap<String, List<String>>();
	}

	@Override
	public Map<String, OptimaRetailDataException> getLocalErrorDataServiceMap(
			String processStepName) {
		Map<String, OptimaRetailDataException> localHistoryMap;
		if (errorDataServiceMap.containsKey(processStepName)) {
			localHistoryMap = errorDataServiceMap.get(processStepName);
		} else {
			localHistoryMap = new ConcurrentHashMap<String, OptimaRetailDataException>();
		}
		errorDataServiceMap.put(processStepName, localHistoryMap);
		return localHistoryMap;
	}

	@Override
	public List<String> getLocalErrorDataServiceList(String processStepName) {
		List<String> localHistoryList;
		if (errorDataServiceList.containsKey(processStepName)) {
			localHistoryList = errorDataServiceList.get(processStepName);
		} else {
			localHistoryList = new ArrayList<String>();
		}
		errorDataServiceList.put(processStepName, localHistoryList);
		return localHistoryList;
	}

}
