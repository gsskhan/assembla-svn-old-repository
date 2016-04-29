package com.citi.retail.optima.etl.aggregation.util;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.model.AggregationType;

/**
 * Wrapper class to give access to segment and metric attribute for an instance of rule element
 * @author yh43239
 *
 */
public class AggregationRuleMeta implements AggregationRuleElementDefinition{
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationRuleMeta.class);
	private final String[] segmentkeys;
	private final String[] metricKeys;
	
	/**
	 * This gets the segment keys and metric keys per aggregation rule
	 * @param aggregationType
	 */
	public  AggregationRuleMeta(AggregationType aggregationType) {
		segmentkeys = aggregationType.getAggregationRuleKeySpelExpr().toArray(new String[]{});
		metricKeys = aggregationType.getColumnsToAggregateValueSpelExpr().toArray(new String[]{});
	}
	
	/**
	 * Gets the metric keys in an array
	 */
	public String[] getMetricKeys() {
	
		return metricKeys;
	}

	/**
	 * Gets the Segment keys in an array
	 */
	public String[] getSegmentKeys() {
		return segmentkeys;
	}

}