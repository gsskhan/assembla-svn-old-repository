package com.citi.retail.optima.etl.common.model;

public class TwRcRecdataRecord extends DataAcqTwRcBaseRecord{
	//private String acctnmbr;
	private Double newrcP;
	
	public Double getNewrcP() {
		return newrcP;
	}
	public void setNewrcP(Double newrcP) {
		this.newrcP = newrcP;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwRcRecdataRecord [newrcP=" + newrcP + "]";
	}

}
