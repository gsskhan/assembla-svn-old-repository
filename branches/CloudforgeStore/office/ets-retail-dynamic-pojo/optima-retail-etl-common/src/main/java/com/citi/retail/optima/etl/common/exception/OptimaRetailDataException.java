package com.citi.retail.optima.etl.common.exception;

import java.io.Serializable;
import java.util.List;

import com.citi.retail.optima.etl.common.ETLLoggingConstants;
import com.citi.retail.optima.etl.common.ServiceName;

public class OptimaRetailDataException extends OptimaRetailBaseException
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5315925267054880113L;

	private Long rowId;
	private List<OptimaRetailDataExceptionDetail> optimaRetailSkippableList;

	public OptimaRetailDataException() {
	}

	public OptimaRetailDataException(ServiceName serviceNameVal,
			ExceptionType exceptionTypeVal) {
		super(serviceNameVal, exceptionTypeVal);
	}
	

	public OptimaRetailDataException(ServiceName serviceNameVal,
			ExceptionType exceptionTypeVal,
			List<OptimaRetailDataExceptionDetail> optimaRetailSkippableListVal) {
		super(serviceNameVal, exceptionTypeVal);
		this.optimaRetailSkippableList = optimaRetailSkippableListVal;
	}

	public OptimaRetailDataException(ServiceName serviceNameVal,
			ExceptionType exceptionTypeVal, Long rowId) {
		super(serviceNameVal, exceptionTypeVal);
		this.rowId = rowId;
	}

	public OptimaRetailDataException(ServiceName serviceNameVal,
			ExceptionType exceptionTypeVal, Long rowId,
			List<OptimaRetailDataExceptionDetail> optimaRetailSkippableListVal) {
		this(serviceNameVal, exceptionTypeVal, rowId);
		this.optimaRetailSkippableList = optimaRetailSkippableListVal;
	}

	/**
	 * @return the rowId
	 */
	public Long getRowId() {
		return rowId;
	}

	/**
	 * @param rowId
	 *            the rowId to set
	 */
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}


	/**
	 * @return the optimaRetailSkippable
	 */
	public List<OptimaRetailDataExceptionDetail> getOptimaRetailSkippableList() {
		return this.optimaRetailSkippableList;
	}

	/**
	 * @param optimaRetailSkippable
	 *            the optimaRetailSkippable to set
	 */
	public void setOptimaRetailSkippableList(
			List<OptimaRetailDataExceptionDetail> optimaRetailSkippableList) {
		this.optimaRetailSkippableList = optimaRetailSkippableList;
	}

	/**
	 * @param optimaRetailSkippable
	 *            the optimaRetailSkippable to add
	 */
	public void add(OptimaRetailDataExceptionDetail optimaRetailSkippable) {
		this.optimaRetailSkippableList.add(optimaRetailSkippable);
	}

	/*
	 * (non-Javadoc) To String Override for Converting the Object to JSON String
	 * Format
	 */
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
	public String constructJsonString() {
		StringBuilder builder = new StringBuilder();
		constructJsonStringbyParam(builder, "\"rowId\" : \"", this.rowId, "\"");
		constructJsonStringbyParam(builder, "\"optimaRetailSkippableList\" : ",
				this.optimaRetailSkippableList, "");
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
	
}
