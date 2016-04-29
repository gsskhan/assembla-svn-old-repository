package com.citi.retail.optima.etl.common.model;

public class TwRcWoRecord extends DataAcqTwRcBaseRecord {
	private Double woP;
	private Integer woind;

	public Double getWoP() {
		return woP;
	}

	public void setWoP(Double woP) {
		this.woP = woP;
	}

	public Integer getWoind() {
		return woind;
	}

	public void setWoind(Integer woind) {
		this.woind = woind;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwRcWoRecord [woP=" + woP + ", woind=" + woind + "]";
	}

}
