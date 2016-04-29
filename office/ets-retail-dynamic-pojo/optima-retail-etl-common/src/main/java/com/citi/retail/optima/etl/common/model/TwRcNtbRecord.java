package com.citi.retail.optima.etl.common.model;

public class TwRcNtbRecord extends DataAcqTwRcBaseRecord{
	//private String cardno;
	private Integer clmt;
	
	public Integer getClmt() {
		return clmt;
	}
	public void setClmt(Integer clmt) {
		this.clmt = clmt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwRcNtbRecord [clmt=" + clmt + "]";
	}

}
