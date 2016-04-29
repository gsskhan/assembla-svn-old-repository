package com.citi.retail.optima.etl.common.model;

public class OreoRecord extends DataAcqMtgBaseRecord{

	String status;
	Double origBookValue;
	Double netBookValue;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the origBookValue
	 */
	public Double getOrigBookValue() {
		return origBookValue;
	}
	/**
	 * @param origBookValue the origBookValue to set
	 */
	public void setOrigBookValue(Double origBookValue) {
		this.origBookValue = origBookValue;
	}
	/**
	 * @return the netBookValue
	 */
	public Double getNetBookValue() {
		return netBookValue;
	}
	/**
	 * @param netBookValue the netBookValue to set
	 */
	public void setNetBookValue(Double netBookValue) {
		this.netBookValue = netBookValue;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OreoRecord [status=" + status + ", origBookValue="
				+ origBookValue + ", netBookValue=" + netBookValue + "]";
	}
	
	

}
