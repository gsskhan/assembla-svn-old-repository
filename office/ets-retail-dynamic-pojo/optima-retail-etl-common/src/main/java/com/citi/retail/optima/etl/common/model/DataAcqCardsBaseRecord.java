/**
 * 
 */
package com.citi.retail.optima.etl.common.model;


/**
 * @author sr67841
 *
 */
public class DataAcqCardsBaseRecord {

	private String cardNumber;
	private String accNumber;
	private String acNo;
	private String currAccountNo;
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataAcqCardsBaseRecord [cardNumber=" + cardNumber + "]";
	}

	public String getAcNo() {
		return acNo;
	}

	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}

	public String getCurrAccountNo() {
		return currAccountNo;
	}

	public void setCurrAccountNo(String currAccountNo) {
		this.currAccountNo = currAccountNo;
	}

	/**
	 * @return the accNumber
	 */
	public String getAccNumber() {
		return accNumber;
	}

	/**
	 * @param accNumber the accNumber to set
	 */
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	

}
