package com.citi.retail.optima.etl.validation.model;

public class TestFedOutput {
	private String portfolioId;
	private String reportingMonth;
	private String productType;
	private Integer numberAccounts;
	private Double dollarAmtReceivables;
	private Double unpaidPrincipalBalance;
	private Double dollarAmtCommitments;
	
	private Double dollarAmtUnpaidPrincipal;
	public Double getUnpaidPrincipalBalance() {
		return unpaidPrincipalBalance;
	}
	public void setUnpaidPrincipalBalance(Double unpaidPrincipalBalance) {
		this.unpaidPrincipalBalance = unpaidPrincipalBalance;
	}
	private Integer numberOfNewAccounts;
	private Double dollarAmtNewCommitments;
	
	public String getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getReportingMonth() {
		return reportingMonth;
	}
	public void setReportingMonth(String reportingMonth) {
		this.reportingMonth = reportingMonth;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getNumberAccounts() {
		return numberAccounts;
	}
	public void setNumberAccounts(Integer numberAccounts) {
		this.numberAccounts = numberAccounts;
	}
	public Double getDollarAmtReceivables() {
		return dollarAmtReceivables;
	}
	public void setDollarAmtReceivables(Double dollarAmtReceivables) {
		this.dollarAmtReceivables = dollarAmtReceivables;
	}
	public Double getDollarAmtUnpaidPrincipal() {
		return dollarAmtUnpaidPrincipal;
	}
	public void setDollarAmtUnpaidPrincipal(Double dollarAmtUnpaidPrincipal) {
		this.dollarAmtUnpaidPrincipal = dollarAmtUnpaidPrincipal;
	}
	public Double getDollarAmtCommitments() {
		return dollarAmtCommitments;
	}
	public void setDollarAmtCommitments(Double dollarAmtCommitments) {
		this.dollarAmtCommitments = dollarAmtCommitments;
	}
	public Integer getNumberOfNewAccounts() {
		return numberOfNewAccounts;
	}
	public void setNumberOfNewAccounts(Integer numberOfNewAccounts) {
		this.numberOfNewAccounts = numberOfNewAccounts;
	}
	public Double getDollarAmtNewCommitments() {
		return dollarAmtNewCommitments;
	}
	public void setDollarAmtNewCommitments(Double dollarAmtNewCommitments) {
		this.dollarAmtNewCommitments = dollarAmtNewCommitments;
	}
}
