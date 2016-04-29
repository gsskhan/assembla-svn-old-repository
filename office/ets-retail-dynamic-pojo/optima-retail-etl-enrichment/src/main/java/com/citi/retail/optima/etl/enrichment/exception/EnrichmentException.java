/**
 * 
 */
package com.citi.retail.optima.etl.enrichment.exception;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

/**
 * @author TJ
 *
 */
public class EnrichmentException extends Exception implements Serializable {

	private static final long serialVersionUID = 3340581139671581172L;
	
	private String rootException;
	private String exceptionMessage;
	private String exceptionTrace;
	
	private List<EnrichmentExceptionDetail> excetionDetailList;
	
	

	public EnrichmentException() {
		super();
	}
	
	public EnrichmentException(List<EnrichmentExceptionDetail> excetionDetailList) {
		super();
		this.excetionDetailList = excetionDetailList;
	}
	
	public EnrichmentException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}
	
	public EnrichmentException(String exceptionMessage, String rootException) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.rootException = rootException;		
	}
	
	public EnrichmentException( String exceptionMessage, String rootException, Exception e) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.rootException = rootException;
		this.exceptionTrace = getStackTrace(e);
	}
		

	public String getRootException() {
		return rootException;
	}

	public void setRootException(String rootException) {
		this.rootException = rootException;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionTrace() {
		return exceptionTrace;
	}

	public void setExceptionTrace(String exceptionTrace) {
		this.exceptionTrace = exceptionTrace;
	}	
	
	public List<EnrichmentExceptionDetail> getExcetionDetailList() {
		return excetionDetailList;
	}

	public void setExcetionDetailList(
			List<EnrichmentExceptionDetail> excetionDetailList) {
		this.excetionDetailList = excetionDetailList;
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
