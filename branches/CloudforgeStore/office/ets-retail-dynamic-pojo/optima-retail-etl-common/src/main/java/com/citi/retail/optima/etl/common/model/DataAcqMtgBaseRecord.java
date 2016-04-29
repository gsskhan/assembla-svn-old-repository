/**
 * 
 */
package com.citi.retail.optima.etl.common.model;


/**
 * @author sr67841
 *
 */
public class DataAcqMtgBaseRecord {

	String acctnumb;
	String lnNo;

	/**
	 * @return the acctnumb
	 */
	public String getAcctnumb() {
		return acctnumb;
	}

	/**
	 * @param acctnumb the acctnumb to set
	 */
	public void setAcctnumb(String acctnumb) {
		this.acctnumb = acctnumb;
	}

	public String getLnNo() {
		return lnNo;
	}

	public void setLnNo(String lnNo) {
		this.lnNo = lnNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataAcqMtgBaseRecord [acctnumb=" + acctnumb + ", lnNo=" + lnNo
				+ "]";
	}

	
	
}
