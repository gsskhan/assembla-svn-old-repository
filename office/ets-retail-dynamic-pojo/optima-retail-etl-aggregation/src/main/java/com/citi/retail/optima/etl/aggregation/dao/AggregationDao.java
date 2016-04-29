/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.dao;

import java.util.List;

import com.citi.retail.optima.etl.aggregation.model.AggregationVO;

/**
 * @author mc56120
 * 
 */
public interface AggregationDao {

	/**
	 * Saving aggregation Result
	 * @param aggregationVO
	 * @return
	 */
	boolean saveAggregationResults(List<AggregationVO> aggregationVO);
}
