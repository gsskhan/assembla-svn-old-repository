/**
 * 
 */
package com.citi.retail.optima.etl.cache.model;

/**
 * @author mc56120
 *
 */
public class PuToSysProcIdVO {

	Integer processingUnit;
	Integer batchId;
	Integer sysProcId;

	
	/**
	 * @return the batchId
	 */
	public Integer getBatchId() {
		return batchId;
	}
	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	/**
	 * @return the processingUnit
	 */
	public Integer getProcessingUnit() {
		return processingUnit;
	}
	/**
	 * @param processingUnit the processingUnit to set
	 */
	public void setProcessingUnit(Integer processingUnit) {
		this.processingUnit = processingUnit;
	}
	/**
	 * @return the sysProcId
	 */
	public Integer getSysProcId() {
		return sysProcId;
	}
	/**
	 * @param sysProcId the sysProcId to set
	 */
	public void setSysProcId(Integer sysProcId) {
		this.sysProcId = sysProcId;
	}

}
