/**
 * 
 */
package com.citi.retail.optima.etl.aggregation;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.citi.retail.optima.etl.aggregation.dao.AggregationRuleSql;
import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;

/**
 * @author mc56120
 * @param<T> It is responsible to load aggregation rules and instantiate the
 *           aggregation service.
 * 
 */
public interface AggregationServiceFactory<T> {

	/**
	 * returns Aggregation Service instance.
	 * 
	 * @param keyList
	 * @param batchInstanceId
	 * @param monthEndDate
	 * @param stepName
	 * @return
	 * @throws AggregationException
	 */
	AggregationService<T> getAggregationService(List<String> keyList,
			Long batchInstanceId, Date monthEndDate, String stepName) throws AggregationException
			;

	/**
	 * load aggregation rules.
	 * 
	 * @param keyList
	 * @return
	 * @throws AggregationException
	 */
	List<AggregationType> loadAggregationRules(List<String> keyList) throws AggregationException;

	/**
	 * clear aggregation service after job completion.
	 * 
	 * @param batchInstanceId
	 * @param stepName
	 */
	void clearAggregationServiceFromMap(Long batchInstanceId, String stepName);

	/**
	 * 
	 * @param keyList
	 * @return
	 * @throws AggregationException
	 */
	Map<String, AggregationRuleSql> loadAggregationInsertSqlRules(
			List<String> keyList) throws AggregationException;
	
	
	/**
	 * Get Aggregation Service
	 * @param keyList
	 * @param batchInstanceId
	 * @param monthEndDate
	 * @param stepName
	 * @param sysProcId
	 * @return
	 * @throws AggregationException
	 */
	AggregationService<T> getAggregationService(List<String> keyList,
			Long batchInstanceId, Date monthEndDate, String stepName, Integer sysProcId)
			throws AggregationException;	
	/**
	 * Get instance of Aggregation Service associated to a key
	 * @param key
	 * @return
	 * @throws AggregationException
	 */
	AggregationService<T> getAggregationServiceFromPool(String key) 
			throws AggregationException;
	
	
	/**
	 * Remove instance of Aggregation Service assocated to an batch and sys process
	 * @param batchInstanceId
	 * @param sysProcId
	 */
	void clearAggregationServiceFromMap(Long batchInstanceId,
			Integer sysProcId);	
}
