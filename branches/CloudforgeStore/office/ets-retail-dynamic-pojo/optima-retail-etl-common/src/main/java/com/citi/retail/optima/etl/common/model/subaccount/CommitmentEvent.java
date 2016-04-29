package com.citi.retail.optima.etl.common.model.subaccount;

import java.util.Date;

/**
 * @author TJ
 * 
 */
public class CommitmentEvent extends BaseSubAccount {

	// ORA641 
	private String accountLimitEventCd;
	// ORA642
	private Double accountLimitEventAmount; 
	// ORA645
	private Date accountLimitEventDate; 
	// ORA647
	private String accountLimitEventInitCd;  

	private Double eCommitmentIncAmt;
	private Double eCommitmentDecAmt;

	public String getAccountLimitEventCd() {
		return this.accountLimitEventCd;
	}

	public void setAccountLimitEventCd(String accountLimitEventCd) {
		this.accountLimitEventCd = accountLimitEventCd;
	}

	public Double getAccountLimitEventAmount() {
		return this.accountLimitEventAmount;
	}

	public void setAccountLimitEventAmount(Double accountLimitEventAmount) {
		this.accountLimitEventAmount = accountLimitEventAmount;
	}

	public Date getAccountLimitEventDate() {
		return this.accountLimitEventDate;
	}

	public void setAccountLimitEventDate(Date accountLimitEventDate) {
		this.accountLimitEventDate = accountLimitEventDate;
	}

	public String getAccountLimitEventInitCd() {
		return this.accountLimitEventInitCd;
	}

	public void setAccountLimitEventInitCd(String accountLimitEventInitCd) {
		this.accountLimitEventInitCd = accountLimitEventInitCd;
	}

	public Double geteCommitmentIncAmt() {
		return this.eCommitmentIncAmt;
	}

	public void seteCommitmentIncAmt(Double eCommitmentIncAmt) {
		this.eCommitmentIncAmt = eCommitmentIncAmt;
	}

	public Double geteCommitmentDecAmt() {
		return this.eCommitmentDecAmt;
	}

	public void seteCommitmentDecAmt(Double eCommitmentDecAmt) {
		this.eCommitmentDecAmt = eCommitmentDecAmt;
	}

}
