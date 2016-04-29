package com.citi.retail.optima.etl.common.exception;

import java.io.Serializable;

import com.citi.retail.optima.etl.common.ETLLoggingConstants;
import com.citi.retail.optima.etl.common.ServiceName;

public class OptimaRetailBaseException extends Exception implements Serializable {

	private static final long serialVersionUID = -5315925267054880113L;

	private ServiceName serviceName;
	private ExceptionType exceptionType;
	
	public OptimaRetailBaseException(){		
	}

	public OptimaRetailBaseException(ServiceName serviceNameVal,
			ExceptionType exceptionTypeVal) {
		super();
		this.serviceName = serviceNameVal;
		this.exceptionType = exceptionTypeVal;
	}

	/**
	 * @return the serviceName
	 */
	public ServiceName getServiceName() {
		return this.serviceName;
	}

	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	public void setServiceName(ServiceName serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the exceptionType
	 */
	public ExceptionType getExceptionType() {
		return this.exceptionType;
	}

	/**
	 * @param exceptionType
	 *            the exceptionType to set
	 */
	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

	/*
	 * (non-Javadoc) To String Override for Converting the Object to JSON String
	 * Format
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('{');
		builder.append(constructJsonString());
		builder.append('}');
		return builder.toString();
	}

	/**
	 * @return
	 */
	public String constructJsonString() {
		StringBuilder builder = new StringBuilder();
		constructJsonStringbyParam(builder, "\"serviceName\" : \"", this.serviceName, "\"");
		constructJsonStringbyParam(builder, "\"exceptionType\" : \"", this.exceptionType, "\"");
		return builder.toString();
	}

	/**
	 * Internal Utility method to reduce cyclomatic complexity of above method
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

}
