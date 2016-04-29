package com.citi.retail.optima.etl.common.exception;

import java.io.Serializable;


import com.citi.retail.optima.etl.common.ETLLoggingConstants;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.JobConfigDao;

public class OptimaRetailApplicationException extends OptimaRetailBaseException
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5315925267054880113L;

	private Long requestLogId;
	private Long jobInstanceId;
	private Long batchInstanceId;
	private String exceptionMessage;
	private String rootException;
	private String exceptionTrace;
	private OptimaRetailDataException dataException;
	private JobConfigDao jobConfigDao;
	

	/**
	 * Constructor for data exceptions
	 * 
	 * @param lrequestLogId
	 * @param ljobInstanceId
	 * @param lbatchInstanceId
	 * @param lserviceName
	 * @param lexceptionType
	 * @param lexceptionMessage
	 * @param lexceptionTrace
	 * @param ldataException
	 */
	public OptimaRetailApplicationException(Long lrequestLogId,
			Long ljobInstanceId, Long lbatchInstanceId,
			ServiceName lserviceName, ExceptionType lexceptionType,
			String lexceptionMessage, String lrootException,
			String lexceptionTrace, OptimaRetailDataException ldataException,JobConfigDao jobConfigDao) {
		super(lserviceName, lexceptionType);
		requestLogId = lrequestLogId;
		jobInstanceId = ljobInstanceId;
		batchInstanceId = lbatchInstanceId;
		exceptionMessage = lexceptionMessage;
		exceptionTrace = lexceptionTrace;
		dataException = ldataException;
		rootException = lrootException;
		this.jobConfigDao = jobConfigDao;
		clearRunningJob();
	}

	/**
	 * Without data exception
	 */
	public OptimaRetailApplicationException(Long requestLogId,
			Long jobInstanceId, Long batchInstanceId, ServiceName serviceName,
			ExceptionType exceptionType, String exceptionMessage,
			String rootException, String exceptionTrace,JobConfigDao jobConfigDao) {
		super(serviceName, exceptionType);
		this.requestLogId = requestLogId;
		this.jobInstanceId = jobInstanceId;
		this.batchInstanceId = batchInstanceId;
		this.exceptionMessage = exceptionMessage;
		this.rootException = rootException;
		this.exceptionTrace = exceptionTrace;
		this.jobConfigDao = jobConfigDao;
		clearRunningJob();
	}

	public OptimaRetailApplicationException(ServiceName serviceName,
			ExceptionType exceptionType, String exceptionMessage,
			String rootException, String exceptionTrace,
			OptimaRetailDataException dataException) {
		super(serviceName, exceptionType);
		this.exceptionMessage = exceptionMessage;
		this.rootException = rootException;
		this.exceptionTrace = exceptionTrace;
		this.dataException = dataException;
	}

	public Long getRequestLogId() {
		return requestLogId;
	}

	public void setRequestLogId(Long requestLogId) {
		this.requestLogId = requestLogId;
	}

	public Long getJobInstanceId() {
		return jobInstanceId;
	}

	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}

	public Long getBatchInstanceId() {
		return batchInstanceId;
	}

	public void setBatchInstanceId(Long batchInstanceId) {
		this.batchInstanceId = batchInstanceId;
	}

	public OptimaRetailDataException getDataException() {
		return dataException;
	}

	public void setDataException(OptimaRetailDataException dataException) {
		this.dataException = dataException;
	}

	public OptimaRetailApplicationException() {
	}

	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage
	 *            the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getRootException() {
		return rootException;
	}

	public void setRootException(String rootException) {
		this.rootException = rootException;
	}

	/**
	 * @return the exceptionTrace
	 */
	public String getExceptionTrace() {
		return exceptionTrace;
	}

	/**
	 * @param exceptionTrace
	 *            the exceptionTrace to set
	 */
	public void setExceptionTrace(String exceptionTrace) {
		this.exceptionTrace = exceptionTrace;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('{');
		builder.append(super.constructJsonString());
		String json = constructJsonString();
		if (json.length() > 0) {
			builder.append(ETLLoggingConstants.COMMA_STRING + json);
		} else {
			builder.append(json);
		}
		builder.append('}');
		return builder.toString();
	}

	/**
	 * @return
	 */
	@Override
	public String constructJsonString() {
		StringBuilder builder = new StringBuilder();
		constructJsonStringbyParam(builder, "\"requestLogId\" : \"",
				requestLogId, "\"");
		constructJsonStringbyParam(builder, "\"jobInstanceId\" : \"",
				jobInstanceId, "\"");
		constructJsonStringbyParam(builder, "\"batchInstanceId\" : \"",
				batchInstanceId, "\"");
		constructJsonStringbyParam(builder, "\"exceptionMessage\" : \"",
				exceptionMessage, "\"");
		constructJsonStringbyParam(builder, "\"rootException\" : \"",
				rootException, "\"");
		constructJsonStringbyParam(builder, "\"exceptionTrace\" : \"",
				exceptionTrace, "\"");
		if (dataException != null) {
			constructJsonStringbyParam(builder, "\"dataException\" : ",
					dataException.toString(), "");
		}

		return builder.toString();
	}

	/**
	 * Internal Utility method to reduce cyclomatic complexity of above method
	 * 
	 * @param builder
	 * @param paramCaption
	 * @param param
	 * @param paramSuffix
	 */
	private void constructJsonStringbyParam(StringBuilder builder,
			String paramCaption, Object param, String paramSuffix) {
		if (param != null) {
			if (builder.length() > 0) {
				builder.append(ETLLoggingConstants.COMMA_STRING);
			}
			builder.append(paramCaption).append(param);
			if (paramSuffix != null && !"".equals(paramSuffix)) {
				builder.append(paramSuffix);
			}
		}
	}
	
	private void clearRunningJob(){
		if(requestLogId != null){
			jobConfigDao.clearRunningEntries(jobConfigDao.getControlFileNameByReqLogId(requestLogId));
		} else if(batchInstanceId != null){
			jobConfigDao.clearRunningEntries(jobConfigDao.getControlFileNameByReqLogId(jobConfigDao.getRequestLogId(batchInstanceId)));
		}
	}

	/**
	 * @return the jobConfigDao
	 */
	public JobConfigDao getJobConfigDao() {
		return jobConfigDao;
	}

	/**
	 * @param jobConfigDao the jobConfigDao to set
	 */
	public void setJobConfigDao(JobConfigDao jobConfigDao) {
		this.jobConfigDao = jobConfigDao;
	}


}
