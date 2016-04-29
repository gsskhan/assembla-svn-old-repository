/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.util.Date;

/**
 * @author sr67841
 * 
 */
public class TdrRecord extends DataAcqCardsBaseRecord {

	Date updatedDate;
	String tdrFlag;
	
	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * @return the tdrFlag
	 */
	public String getTdrFlag() {
		return tdrFlag;
	}
	/**
	 * @param tdrFlag the tdrFlag to set
	 */
	public void setTdrFlag(String tdrFlag) {
		this.tdrFlag = tdrFlag;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TdrRecord [updatedDate=" + updatedDate + ", tdrFlag=" + tdrFlag
				+ "]";
	}

	
}
