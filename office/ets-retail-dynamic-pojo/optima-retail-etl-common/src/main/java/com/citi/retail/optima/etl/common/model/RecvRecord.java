/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

/**
 * @author sr67841
 * 
 */
public class RecvRecord extends DataAcqCardsBaseRecord{

	private Double newrc_p;

	public Double getNewrc_p() {
		return newrc_p;
	}

	public void setNewrc_p(Double newrc_p) {
		this.newrc_p = newrc_p;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecvRecord [newrc_p=" + newrc_p + "]";
	}
	

}
