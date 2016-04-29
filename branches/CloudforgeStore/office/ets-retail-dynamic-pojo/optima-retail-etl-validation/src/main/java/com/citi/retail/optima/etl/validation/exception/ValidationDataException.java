/**
 * 
 */
package com.citi.retail.optima.etl.validation.exception;

import java.io.Serializable;
import java.util.List;

/**
 * @author TJ
 * 
 */
public class ValidationDataException extends Exception implements Serializable {

	private static final long serialVersionUID = 7384527598204908164L;
	
	private List<FieldError> fieldErrors;
	
	public ValidationDataException() {
		super();
	}
	
	public ValidationDataException(List<FieldError> fieldErrors) {
		super();
		this.fieldErrors = fieldErrors;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
		
}
