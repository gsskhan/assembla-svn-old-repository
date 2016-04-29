/**
 * 
 */
package com.citi.retail.optima.etl.common.model;


/**
 * @author sr67841
 *
 */
public class HkRcBaseRecord {

	String acNo;

	/**
	 * @return the acNo
	 */
	public String getAcNo() {
		return acNo;
	}

	/**
	 * @param acNo the acNo to set
	 */
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HkRcBaseRecord [acNo=" + acNo + "]";
	}

	
	

}
