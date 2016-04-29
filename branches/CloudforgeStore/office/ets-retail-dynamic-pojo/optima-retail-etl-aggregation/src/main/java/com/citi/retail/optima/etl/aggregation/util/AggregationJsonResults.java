package com.citi.retail.optima.etl.aggregation.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;

import ch.qos.logback.classic.Logger;


/**
 * This class holds all aggregation results in json array for all processes in the app.
 * The json arrays are associated to a custom job key.
 * Each json array represent a result set of aggregation from a chunck step process 
 * i.e. One job key points to an array of AggregationJsonResultVO each AggregationJsonResultVO stores
 * a list of aggregated results from a step process. 
 *
 *
 * Currently our deployment plan is to have one to one relationship between jvm and spring context.
 * Upon change of the plan we may need to convert this to spring context based 
 * and inject it to the appropriate class as needed. 
 * 
 *
 * @author yh43239
 *
 */
public class AggregationJsonResults {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationJsonResults.class);
    private static HashMap<String,ArrayList<AggregationJsonResultVO>> jsonResults=new HashMap<String,ArrayList<AggregationJsonResultVO>>(100);
	private static final String JOB_KEY_DELIMITER = ":";
    
	public AggregationJsonResults() {
    }
	
	/**
	 * associate an aggreagted result list in json to a unique job execution (spring batch term: job->job instance->job execution)
	 * @param targetJobKey
	 * @param aggregationResultVO
	 */
	public static void add(String targetJobKey, AggregationJsonResultVO aggregationResultVO){
		if(jsonResults.get(targetJobKey)==null){
			jsonResults.put(targetJobKey, new ArrayList<AggregationJsonResultVO>(10));
		}
		jsonResults.get(targetJobKey).add(aggregationResultVO);
		displayJsonString(aggregationResultVO);
	}
	
	public static ArrayList<AggregationJsonResultVO> getList(String targetJobKey){
		return jsonResults.get(targetJobKey);
	}

	/**
	 * Generate a unique job key associated to a job, job instance and job execution
	 * @param jobExecuation
	 * @return
	 */
	public static String generateJobKey(JobExecution jobExecution){
		
		Long jobExecutionId = jobExecution.getJobId();
		String jobName = jobExecution.getJobInstance().getJobName();
		Long jobInstanceId = jobExecution.getJobInstance().getId();
		Long jobId = jobExecution.getJobId();
		//The key will be in the following format
		//jobName:jobId:jobInstanceId:jobExecutionId
		StringBuilder sb = new StringBuilder();
		sb.append(jobName);
		sb.append(JOB_KEY_DELIMITER);
		sb.append(jobId);
		sb.append(JOB_KEY_DELIMITER);
		sb.append(jobInstanceId);
		sb.append(JOB_KEY_DELIMITER);
		sb.append(jobExecutionId);
		
		return sb.toString();
	}
	
   /**
    * Should be call upon a termination of job run
    * @param targetJobKey
    */
	public static void clearResults(String targetJobKey){
		 
		 jsonResults.remove(targetJobKey);
	}
	
	/**
	 * Debugging method used to display the result  of Json to output console
	 * @param aggregationResultVO
	 */
	
	public static void displayJsonString(AggregationJsonResultVO aggregationResultVO){
		LOGGER.debug(aggregationResultVO.getArrayNode().toString());
	}
}
