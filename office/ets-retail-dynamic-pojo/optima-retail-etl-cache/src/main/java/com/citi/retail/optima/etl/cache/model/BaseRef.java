package com.citi.retail.optima.etl.cache.model;

/**
 * @author sr67841 This is the Base object model that is using in caching.
 * 
 */
public class BaseRef {

	// functionName,productName and schedule will be removed. It is not removed
	// now so that build doesnt break. Only scheduleId will be used in future
	private String functionName;
	private String productName;
	private Integer processingUnitId;

	public BaseRef() {
	};

	public BaseRef(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
	}

	/**
	 * @return the functionName
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * @param functionName
	 *            the functionName to set
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the processingUnitId
	 */
	public Integer getProcessingUnitId() {
		return processingUnitId;
	}

	/**
	 * @param processingUnitId
	 *            the processingUnitId to set
	 */
	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
	}

	@Override
	public int hashCode() {
		return getProcessingUnitId();
	}

	@Override
	public boolean equals(Object obj) {
		BaseRef baseRef = (BaseRef) obj;
		if (getProcessingUnitId().equals(baseRef.getProcessingUnitId())) {
			return true;
		} 
		return false;
		
	}
}
