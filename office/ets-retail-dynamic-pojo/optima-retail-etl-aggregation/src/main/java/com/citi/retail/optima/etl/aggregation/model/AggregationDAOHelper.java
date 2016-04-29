/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.model;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * Aggregation DAO helper class
 * 
 * @author mc56120
 * 
 */
public class AggregationDAOHelper implements Serializable {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationDAOHelper.class);
	private static final long serialVersionUID = 1L;
	private List<String> aggregationKey;
	private List<Number> aggregationValues;

	/**
	 * 
	 * @param aggregationKey
	 * @param aggregationValues
	 */
	public AggregationDAOHelper(List<String> aggrKey, List<Number> aggrValues) {
		aggregationKey = aggrKey;
		aggregationValues = aggrValues;
	}

	/**
	 * @return the aggregationKey
	 */
	public List<String> getAggregationKey() {
		return aggregationKey;
	}

	/**
	 * @return the aggregationValues
	 */
	public List<Number> getAggregationValues() {
		return aggregationValues;
	}

}
