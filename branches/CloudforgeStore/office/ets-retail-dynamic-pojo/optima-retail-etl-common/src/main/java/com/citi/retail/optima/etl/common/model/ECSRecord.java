package com.citi.retail.optima.etl.common.model;

public class ECSRecord {

	Double balance;
	Long crd_acct_nbr;

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Long getCrd_acct_nbr() {
		return crd_acct_nbr;
	}

	public void setCrd_acct_nbr(Long crd_acct_nbr) {
		this.crd_acct_nbr = crd_acct_nbr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ECSRecord [balance=" + balance + ", crd_acct_nbr="
				+ crd_acct_nbr + "]";
	}

}
