package com.citi.retail.optima.etl.aggregation.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.citi.retail.optima.etl.aggregation.model.AccountTraceabilityInfo;

public abstract class RetailBaseAccount implements Serializable {

	private static final long serialVersionUID = 1195167661702167491L;
	protected List<AccountTraceabilityInfo> accountTraceInfoList;
	protected String accountNumber;
	protected Integer refReportingBasis;
	protected String productType;
	protected Date reportDate;
	protected String naturalCcy;
	protected String portfolioId;
	protected String eRegion;
	protected String managedGeography;
	// Staging Output fields
	protected String localCcy;
	protected String baselPortfolioId;
	protected Double eRefFXrate;
	protected String eBusinessUnit;
	//ORA218
	protected String frsBusinessUnit;
	//ORA897
	protected String accountNumberQmemo;
	
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountTraceInfoList
	 */
	public List<AccountTraceabilityInfo> getAccountTraceInfoList() {
		return this.accountTraceInfoList;
	}

	/**
	 * @param accountTraceInfoList
	 *            the accountTraceInfoList to set
	 */
	public void setAccountTraceInfoList(
			List<AccountTraceabilityInfo> accountTraceInfoList) {
		this.accountTraceInfoList = accountTraceInfoList;
	}

	public String geteRegion() {
		return this.eRegion;
	}

	public void setERegion(String region) {
		this.eRegion = region;
	}

	public String getManagedGeography() {
		return this.managedGeography;
	}

	public void setManagedGeography(String managedGeography) {
		this.managedGeography = managedGeography;
	}

	public String getNaturalCcy() {
		return this.naturalCcy;
	}

	public void setNaturalCcy(String naturalCcy) {
		this.naturalCcy = naturalCcy;
	}

	public String getPortfolioId() {
		return this.portfolioId;
	}

	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getRefReportingBasis() {
		return this.refReportingBasis;
	}

	public void setRefReportingBasis(Integer refReportingBasis) {
		this.refReportingBasis = refReportingBasis;
	}

	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * @return the localCcy
	 */
	public String getLocalCcy() {
		return localCcy;
	}

	/**
	 * @param localCcy the localCcy to set
	 */
	public void setLocalCcy(String localCcy) {
		this.localCcy = localCcy;
	}

	/**
	 * @return the baselPortfolioId
	 */
	public String getBaselPortfolioId() {
		return baselPortfolioId;
	}

	/**
	 * @param baselPortfolioId the baselPortfolioId to set
	 */
	public void setBaselPortfolioId(String baselPortfolioId) {
		this.baselPortfolioId = baselPortfolioId;
	}

	/**
	 * @return the eRefFXrate
	 */
	public Double geteRefFXrate() {
		return eRefFXrate;
	}

	/**
	 * @param eRefFXrate the eRefFXrate to set
	 */
	public void setERefFXrate(Double eRefFXrate) {
		this.eRefFXrate = eRefFXrate;
	}

	/**
	 * @return the eBusinessUnit
	 */
	public String geteBusinessUnit() {
		return eBusinessUnit;
	}

	/**
	 * @param eBusinessUnit the eBusinessUnit to set
	 */
	public void seteBusinessUnit(String eBusinessUnit) {
		this.eBusinessUnit = eBusinessUnit;
	}

	/**
	 * @return the frsBusinessUnit
	 */
	public String getFrsBusinessUnit() {
		return frsBusinessUnit;
	}

	/**
	 * @param frsBusinessUnit the frsBusinessUnit to set
	 */
	public void setFrsBusinessUnit(String frsBusinessUnit) {
		this.frsBusinessUnit = frsBusinessUnit;
	}

	/**
	 * @return the accountNumberQmemo
	 */
	public String getAccountNumberQmemo() {
		return accountNumberQmemo;
	}

	/**
	 * @param accountNumberQmemo the accountNumberQmemo to set
	 */
	public void setAccountNumberQmemo(String accountNumberQmemo) {
		this.accountNumberQmemo = accountNumberQmemo;
	}


	
}
