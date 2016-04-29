package com.citi.retail.optima.etl.common.model;

public class TwRcFicoRecord extends DataAcqTwRcBaseRecord{
	//private String cardnmbr;
	private Integer aignscore;
	
	public Integer getAignscore() {
		return aignscore;
	}
	public void setAignscore(Integer aignscore) {
		this.aignscore = aignscore;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwRcFicoRecord [aignscore=" + aignscore + "]";
	}
	
}
