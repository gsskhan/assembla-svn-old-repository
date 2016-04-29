package com.citi.retail.optima.etl.common.model;

public class TwRcIntRecord extends DataAcqTwRcBaseRecord{
	//private String cardnmbr;
	private Integer intr;

	public Integer getIntr() {
		return intr;
	}

	public void setIntr(Integer intr) {
		this.intr = intr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwRcIntRecord [intr=" + intr + "]";
	}

}
