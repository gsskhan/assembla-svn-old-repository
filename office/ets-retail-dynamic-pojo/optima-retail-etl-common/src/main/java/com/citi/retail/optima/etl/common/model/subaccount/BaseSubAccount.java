/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount;

import java.util.Date;
import java.util.List;

import com.citi.retail.optima.etl.common.model.AccountTraceabilityInfo;

/**
 * @author tr31047
 * 
 */
public abstract class BaseSubAccount {

	protected List<AccountTraceabilityInfo> accountTraceInfoList;
	// ORA047
	protected String accountNumber;  
	// ORA362
	protected String portfolioId;  
	// ORA382
	protected String productType;  
	// ORA183
	protected Date reportDate; 
	// ORA048
	protected Date accountOpenDate;  
	// ORA361
	protected Date acquisitionDate;  

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

	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public Date getAccountOpenDate() {
		return this.accountOpenDate;
	}

	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public Date getAcquisitionDate() {
		return this.acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

}
