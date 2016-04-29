package com.citi.retail.optima.etl.common.model.subaccount;


/**
 * @author hs73849
 *
 */
public class FDICLocHistory extends BaseSubAccount {

	private Double currAdvisedCommittedLimit;
	private Double currAdvisedUncommittedLimitUsd;
	private Double currUnadvisedUncommittedLimitUsd;
	private Double eCreditLine;
	/**
	 * @return the currAdvisedCommittedLimit
	 */
	public Double getCurrAdvisedCommittedLimit() {
		return currAdvisedCommittedLimit;
	}
	/**
	 * @param currAdvisedCommittedLimit the currAdvisedCommittedLimit to set
	 */
	public void setCurrAdvisedCommittedLimit(Double currAdvisedCommittedLimit) {
		this.currAdvisedCommittedLimit = currAdvisedCommittedLimit;
	}
	/**
	 * @return the currAdvisedUncommittedLimitUsd
	 */
	public Double getCurrAdvisedUncommittedLimitUsd() {
		return currAdvisedUncommittedLimitUsd;
	}
	/**
	 * @param currAdvisedUncommittedLimitUsd the currAdvisedUncommittedLimitUsd to set
	 */
	public void setCurrAdvisedUncommittedLimitUsd(
			Double currAdvisedUncommittedLimitUsd) {
		this.currAdvisedUncommittedLimitUsd = currAdvisedUncommittedLimitUsd;
	}
	/**
	 * @return the currUnadvisedUncommittedLimitUsd
	 */
	public Double getCurrUnadvisedUncommittedLimitUsd() {
		return currUnadvisedUncommittedLimitUsd;
	}
	/**
	 * @param currUnadvisedUncommittedLimitUsd the currUnadvisedUncommittedLimitUsd to set
	 */
	public void setCurrUnadvisedUncommittedLimitUsd(
			Double currUnadvisedUncommittedLimitUsd) {
		this.currUnadvisedUncommittedLimitUsd = currUnadvisedUncommittedLimitUsd;
	}
	/**
	 * @return the eCreditLine
	 */
	public Double geteCreditLine() {
		return eCreditLine;
	}
	/**
	 * @param eCreditLine the eCreditLine to set
	 */
	public void seteCreditLine(Double eCreditLine) {
		this.eCreditLine = eCreditLine;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FDICLocHistory ["
				+ (currAdvisedCommittedLimit != null ? "currAdvisedCommittedLimit="
						+ currAdvisedCommittedLimit + ", "
						: "")
				+ (currAdvisedUncommittedLimitUsd != null ? "currAdvisedUncommittedLimitUsd="
						+ currAdvisedUncommittedLimitUsd + ", "
						: "")
				+ (currUnadvisedUncommittedLimitUsd != null ? "currUnadvisedUncommittedLimitUsd="
						+ currUnadvisedUncommittedLimitUsd + ", "
						: "")
				+ (eCreditLine != null ? "eCreditLine=" + eCreditLine : "")
				+ "]";
	}
}
