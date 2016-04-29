/**
 * 
 */
package com.citi.retail.optima.etl.fileintegrity.exception;

import java.io.Serializable;
import java.util.List;

/**
 * @author TJ
 * 
 */
public class FileIntegrityDataException extends Exception implements Serializable {

	private static final long serialVersionUID = 7384527598204908164L;
	
	private List<FieldError> fieldErrors;
	
	public FileIntegrityDataException() {
		super();
	}
	
	public FileIntegrityDataException(List<FieldError> validationErrors) {		
		super();
		this.fieldErrors = validationErrors;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
		
}
