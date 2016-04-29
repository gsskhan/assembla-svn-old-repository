/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

/**
 * @author sk00640
 *
 */
public class DataAcqPLBaseRecord {
	
	private String lnNo;

	/**
	 * @return the lnNo
	 */
	public String getLnNo() {
		return lnNo;
	}

	/**
	 * @param lnNo the lnNo to set
	 */
	public void setLnNo(String lnNo) {
		this.lnNo = lnNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataAcqPLBaseRecord [lnNo=" + lnNo + "]";
	}

}
