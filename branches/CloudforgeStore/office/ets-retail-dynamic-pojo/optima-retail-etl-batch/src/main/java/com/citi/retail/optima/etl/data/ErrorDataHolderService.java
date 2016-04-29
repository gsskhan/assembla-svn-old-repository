package com.citi.retail.optima.etl.data;

import java.util.List;
import java.util.Map;

import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;

public interface ErrorDataHolderService<T> {

	Map<Integer, List<List<T>>> getDataMapByBatchInstanceId(Long batchInstanceId);

	Map<String, OptimaRetailDataException> getErrorMapByBatchInstanceId(
			Long batchInstanceId);
}
