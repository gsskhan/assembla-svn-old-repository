/**
 * 
 */
package com.citi.retail.optima.etl.common.exception;

import java.util.List;

import com.citi.retail.optima.etl.common.ServiceName;

/**
 * @author TJ
 * 
 */
public class ItemValidationException extends OptimaRetailDataException {

	private static final long serialVersionUID = 7384527598204908164L;

	public ItemValidationException(ExceptionType exceptionTypeVal) {
		super(ServiceName.VALIDATION, exceptionTypeVal);
	}

	public ItemValidationException(ServiceName serviceNameVal,
			ExceptionType exceptionTypeVal) {
		super(serviceNameVal, exceptionTypeVal);
	}

	public ItemValidationException(ExceptionType exceptionTypeVal,
			List<OptimaRetailDataExceptionDetail> optimaRetailSkippableListVal) {
		super(ServiceName.VALIDATION, exceptionTypeVal,
				optimaRetailSkippableListVal);
	}

	public ItemValidationException(ServiceName serviceNameVal,
			ExceptionType exceptionTypeVal,
			List<OptimaRetailDataExceptionDetail> optimaRetailSkippableListVal) {
		super(serviceNameVal, exceptionTypeVal, optimaRetailSkippableListVal);
	}
}
