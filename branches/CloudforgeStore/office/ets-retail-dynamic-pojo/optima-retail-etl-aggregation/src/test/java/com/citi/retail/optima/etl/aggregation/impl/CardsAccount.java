package com.citi.retail.optima.etl.aggregation.impl;



public class CardsAccount extends RetailAccount {

	// B-13
	private Double eOutstandingDPDOver30Amt;  
	// B-14
	private Long eNumAcctDPDOver30;  

	public Long geteNumAcctDPDOver30() {
		return this.eNumAcctDPDOver30;
	}

	public void setENumAcctDPDOver30(Long numAcctDPDOver30) {
		this.eNumAcctDPDOver30 = numAcctDPDOver30;
	}

	public Double geteOutstandingDPDOver30Amt() {
		return this.eOutstandingDPDOver30Amt;
	}

	public void setEOutstandingDPDOver30Amt(Double outstandingDPDOver30Amt) {
		this.eOutstandingDPDOver30Amt = outstandingDPDOver30Amt;
	}

	public void setNetOutstandingPrinBal(double double1) {

	}

}
