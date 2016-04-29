package com.citi.retail.optima.etl.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;

public class DataHolderServiceImpl<T> implements ErrorDataHolderService {

	Map<Long, Map<Integer, List<List<T>>>> dataMap = new HashMap<Long, Map<Integer, List<List<T>>>>();
	Map<Long, Map<String, OptimaRetailDataException>> errorMap = new HashMap<Long, Map<String, OptimaRetailDataException>>();

	@Override
	public Map<Integer, List<List<T>>> getDataMapByBatchInstanceId(
			Long batchInstanceId) {
		Map<Integer, List<List<T>>> batchInstanceDataMap = dataMap.get(batchInstanceId);
		if(batchInstanceDataMap == null)
		{
			batchInstanceDataMap = new HashMap<Integer, List<List<T>>>();
			dataMap.put(batchInstanceId, batchInstanceDataMap);
		}
		return batchInstanceDataMap;
	}
	
	@Override
	public Map<String, OptimaRetailDataException> getErrorMapByBatchInstanceId(
			Long batchInstanceId) {
		Map<String, OptimaRetailDataException> batchInstanceErrorMap = errorMap.get(batchInstanceId);
		if(batchInstanceErrorMap == null)
		{
			batchInstanceErrorMap = new HashMap<String, OptimaRetailDataException>();
			errorMap.put(batchInstanceId, batchInstanceErrorMap);
		}
		return batchInstanceErrorMap;
	}
}