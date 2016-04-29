/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount;

public class CommitmentSubAccountAttribute extends BaseSubAccount {

	private Double commitmentIncrease; 
	private Double commitmentDecrease;
	
	public Double getCommitmentIncrease() {
		return commitmentIncrease;
	}
	public void setCommitmentIncrease(Double commitmentIncrease) {
		this.commitmentIncrease = commitmentIncrease;
	}
	public Double getCommitmentDecrease() {
		return commitmentDecrease;
	}
	public void setCommitmentDecrease(Double commitmentDecrease) {
		this.commitmentDecrease = commitmentDecrease;
	}

	
}
