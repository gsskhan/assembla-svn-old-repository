package com.citi.retail.optima.etl.aggregation.util;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * This holds a list of mapped aggregation results in json arraynode
 * 
 * @author yh43239
 * 
 */

public class AggregationJsonResultVO {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationJsonResultVO.class);
	// jobKey a unique job key associated to a job, job instance and job
	// execution
	private String jobKey = null;
	private ArrayNode arrayNode = null;

	/**
	 * Job key is the unique key per job execuation instance
	 * @param jobKey
	 * @param jsonList
	 */
	public AggregationJsonResultVO(String jobKey, ArrayNode jsonList) {
		this.jobKey = jobKey;
		this.arrayNode = jsonList;
	}

	public String getJobKey() {
		return jobKey;
	}

	public ArrayNode getArrayNode() {
		return arrayNode;
	}

}
