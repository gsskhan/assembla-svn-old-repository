/**
 * 
 */
package com.citi.retail.optima.etl.controller.model;

import java.io.Serializable;

/**
 * @author mc56120
 *
 */
public class EventFileMapVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long reqEventId;
	private boolean cntrlFileFlag;
	private String inputFileName;

	/**
	 * @return the reqEventId
	 */
	public Long getReqEventId() {
		return reqEventId;
	}
	/**
	 * @param reqEventId the reqEventId to set
	 */
	public void setReqEventId(Long reqEventId) {
		this.reqEventId = reqEventId;
	}
	/**
	 * @return the cntrlFileFlag
	 */
	public boolean isCntrlFileFlag() {
		return cntrlFileFlag;
	}
	/**
	 * @param cntrlFileFlag the cntrlFileFlag to set
	 */
	public void setCntrlFileFlag(boolean cntrlFileFlag) {
		this.cntrlFileFlag = cntrlFileFlag;
	}
	/**
	 * @return the inputFileName
	 */
	public String getInputFileName() {
		return inputFileName;
	}
	/**
	 * @param inputFileName the inputFileName to set
	 */
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	

}
