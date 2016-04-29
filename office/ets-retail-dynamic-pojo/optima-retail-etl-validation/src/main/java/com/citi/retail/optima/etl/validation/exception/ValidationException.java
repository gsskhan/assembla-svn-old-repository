package com.citi.retail.optima.etl.validation.exception;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;

public class ValidationException extends Exception implements Serializable {

	private static final long serialVersionUID = -5315925267054880113L;
	
	private String rootException;
	private String exceptionMessage;
	private String exceptionTrace;
	
	public ValidationException() {
		super();
	}
	
	public ValidationException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}
	
	public ValidationException(String exceptionMessage, String rootException) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.rootException = rootException;		
	}
	
	public ValidationException( String exceptionMessage, String rootException, Exception e) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.rootException = rootException;
		this.exceptionTrace = getStackTrace(e);
	}
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getRootException() {
		return rootException;
	}
	public void setRootException(String rootException) {
		this.rootException = rootException;
	}
	public String getExceptionTrace() {
		return exceptionTrace;
	}
	public void setExceptionTrace(String exceptionTrace) {
		this.exceptionTrace = exceptionTrace;
	}
	
	/**
	 * @param e
	 * @return 
	 * This method is used to convert the Exception 
	 * stack trace to String.
	 */
	public static String getStackTrace(Exception e) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		e.printStackTrace(printWriter);
		String s = result.toString().replace("\n", "\\n");
		String s1 = s.replace("\r", "\\r");
		String s2 = s1.replace("\t", "\\t");
		return s2.replace("\"", "\\\"");
	}
}
