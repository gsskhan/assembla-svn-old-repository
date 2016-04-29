package com.citi.retail.optima.etl.common.model;

public class TwRcEppRecord extends DataAcqTwRcBaseRecord{
	//private String crdAcctNbr;
	private Double balance;
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwRcEppRecord [balance=" + balance + "]";
	}

}
