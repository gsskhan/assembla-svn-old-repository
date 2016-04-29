package com.citi.retail.optima.etl.aggregation.util;

/**
 * Access interface to aggregation rule element segment and metric attribute
 * @author yh43239
 *
 */
public interface AggregationRuleElementDefinition{
	public String[] getMetricKeys();
	public String[] getSegmentKeys();
}
