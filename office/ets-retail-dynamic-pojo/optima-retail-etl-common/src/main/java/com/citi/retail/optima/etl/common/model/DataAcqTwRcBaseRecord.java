package com.citi.retail.optima.etl.common.model;

public class DataAcqTwRcBaseRecord {
	private String crdAcctNbr;
	private String crdNbr;	
	public String getCrdAcctNbr() {
		return crdAcctNbr;
	}

	public void setCrdAcctNbr(String crdAcctNbr) {
		this.crdAcctNbr = crdAcctNbr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataAcqTwRcBaseRecord [crdAcctNbr=" + crdAcctNbr + "]";
	}

	public String getCrdNbr() {
		return crdNbr;
	}

	public void setCrdNbr(String crdNbr) {
		this.crdNbr = crdNbr;
	}
	
}
