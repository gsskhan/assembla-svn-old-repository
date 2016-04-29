/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

/**
 * @author sr67841
 * 
 */
public class NtbRecord extends DataAcqCardsBaseRecord {

	Long clmt;

	public Long getClmt() {
		return clmt;
	}

	public void setClmt(Long clmt) {
		this.clmt = clmt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NtbRecord [clmt=" + clmt + "]";
	}

}
