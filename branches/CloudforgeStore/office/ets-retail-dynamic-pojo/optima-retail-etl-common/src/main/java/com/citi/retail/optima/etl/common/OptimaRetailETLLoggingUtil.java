package com.citi.retail.optima.etl.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.item.ExecutionContext;

public final class OptimaRetailETLLoggingUtil {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(OptimaRetailETLLoggingUtil.class);

	private static final String SEPARATOR_STRING = "###";
	
    private OptimaRetailETLLoggingUtil (){
    	
    }
	
	public static Date convertDate(java.sql.Date dateObj) {
		Date utilDate = null;
		if (dateObj != null) {
			utilDate = new Date(dateObj.getTime());
		}
		return utilDate;
	}

	public static Date convertDateFormat(String dateString, String format) {

		DateFormat df = new SimpleDateFormat(format);
		Date parsedDate = null;
		try {
			parsedDate = df.parse(dateString);
		} catch (ParseException e) {
			LOGGER.error("Exception Details -> " + e);
		}

		return parsedDate;

	}

	public static String formatDate(Date reportPeriod) {
		DateFormat df = new SimpleDateFormat("yyyyMM");
		return df.format(reportPeriod);
	}


	// Need to change this similar to convetExcutionContextToString. This is
	// another way of doing. Selecting only keys rather than excluding unwanted
	// keys
	public static String convertJoParamToString(JobExecution jobExecution) {

		JobParameters params = jobExecution.getJobInstance().getJobParameters();

		return ETLConstants.REPORT_DATE + ":"
				+ params.getDate(ETLConstants.REPORT_DATE) + "|"
				+ ETLConstants.PORTFOLIO_ID + ":"
				+ params.getString(ETLConstants.PORTFOLIO_ID) + "|"
				+ ETLConstants.PROCESSING_UNIT_ID_LIST + ":"
				+ params.getString(ETLConstants.PROCESSING_UNIT_ID_LIST) + "|"
				+ ETLConstants.ROW_COUNT + ":"
				+ params.getLong(ETLConstants.ROW_COUNT) + "|"
				+ ETLConstants.THRESHOLD + ":"
				+ params.getLong(ETLConstants.THRESHOLD) + "|"
				+ ETLConstants.ORIGINAL_MSG_ID + ":"
				+ params.getLong(ETLConstants.ORIGINAL_MSG_ID) + "|"
				+ ETLConstants.PRODUCT_LIST_STR + ":"
				+ params.getString(ETLConstants.PRODUCT_LIST_STR);

	}

	public static String convetExcutionContextToString(
			ExecutionContext executionContext, List excludedConextKeysList) {
		Set<Entry<String, Object>> executionContextEntries = executionContext
				.entrySet();
		String executionContextString = "";
		for (Entry<String, Object> executionContextEntry : executionContextEntries) {
			if (!excludedConextKeysList
					.contains(executionContextEntry.getKey())) {
				executionContextString += executionContextEntry.getKey() + "|"
						+ executionContextEntry.getValue().toString() + "#";
			}
		}
		return executionContextString;
	}

	public static String convetStepExcutionContextToString(
			ExecutionContext executionContext) {
		return convetExcutionContextToString(executionContext,
				Arrays.asList(ETLConstants.EXCLUDE_STEP_EXECUTION_KEY_ARRAY));
	}

	public static String convetJobExcutionContextToString(
			ExecutionContext executionContext) {
		return convetExcutionContextToString(executionContext,
				Arrays.asList(ETLConstants.EXCLUDE_JOB_EXECUTION_KEY_ARRAY));
	}

	public static String createLoggingMessage(Object loggingObject,
			Long batchInstanceId, String objectName) {

		FormattingTuple msg = MessageFormatter.format(":", loggingObject);

		return batchInstanceId + SEPARATOR_STRING + objectName
				+ SEPARATOR_STRING + msg.getArgArray()[0].toString();

	}
}
