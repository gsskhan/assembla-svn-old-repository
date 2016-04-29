/**
 * 
 */
package com.citi.retail.optima.etl.aggregation;

import java.util.List;
import java.util.Map;

import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;

/**
 * @author mc56120
 * 
 *         Aggregation service
 * @param <T>
 */
public interface AggregationService<T> {
	/**
	 * To Aggregate the data object being passed.
	 * 
	 * @param data
	 * @param aggregationMap
	 * @param accountTraceabilityRequired
	 * @return
	 * @throws AggregationException
	 */                
	T aggregate(T data, Map<String, Map<String, List<Number>>> aggregationMap,
			boolean accountTraceabilityRequired)
			throws AggregationException;

	/**
	 * To Aggregate collection of data object being passed.
	 * 
	 * @param dataList
	 * @param aggregationMap
	 * @param accountTraceabilityRequired
	 * @return
	 * @throws AggregationException
	 */
	List<T> aggregateList(List<T> dataList,
			Map<String, Map<String, List<Number>>> aggregationMap,
			boolean accountTraceabilityRequired)
			throws AggregationException;

	/**
	 * save aggregation output.
	 * 
	 * @return
	 * @throws AggregationException
	 */
	boolean saveAggregationResults() throws AggregationException;

	/**
	 * merge local maps from each partition
	 */
	void mergeAggregationResults() throws AggregationException;
	
	/**
	 * Expose Aggregation Results 
	 * @return
	 */
	Map<String, Map<String, List<Number>>> getAggregationResults();
	
	/**
	 * Get Aggregation Keys
	 * @return
	 */
	List<AggregationType> getAggregationTypeList();
}
