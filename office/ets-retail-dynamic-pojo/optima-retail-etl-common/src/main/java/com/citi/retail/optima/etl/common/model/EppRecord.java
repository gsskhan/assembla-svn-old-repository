/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

/**
 * @author sr67841
 * 
 */
public class EppRecord extends DataAcqCardsBaseRecord{

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
		return "EppRecord [balance=" + balance + "]";
	}
	

}
