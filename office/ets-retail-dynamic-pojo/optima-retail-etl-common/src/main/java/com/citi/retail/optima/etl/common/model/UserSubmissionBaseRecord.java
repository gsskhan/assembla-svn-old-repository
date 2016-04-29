/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sr67841
 * 
 */
public class UserSubmissionBaseRecord implements Cloneable {

	protected String region;
	protected String country;
	protected String businessUnit;
	protected String productType;
	protected String createdBy;
	protected Date createdDt;
	protected String portfolioId;
	protected Integer rptPeriod;
	protected Double enrAmt;
	protected Integer rowId;
	protected Integer processingUnit;

	protected Map<String, Boolean> includeAccount = new HashMap<String, Boolean>();

	protected Double eEnrAmt;

	/**
	 * @return the includeAccount
	 */
	public Map<String, Boolean> getIncludeAccount() {
		return includeAccount;
	}

	/**
	 * @param includeAccount
	 *            the includeAccount to set
	 */
	public void setIncludeAccount(Map<String, Boolean> includeAccount) {
		this.includeAccount = includeAccount;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the businessUnit
	 */
	public String getBusinessUnit() {
		return businessUnit;
	}

	/**
	 * @param businessUnit
	 *            the businessUnit to set
	 */
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDt
	 */
	public Date getCreatedDt() {
		return createdDt;
	}

	/**
	 * @param createdDt
	 *            the createdDt to set
	 */
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	/**
	 * @return the portfolioId
	 */
	public String getPortfolioId() {
		return portfolioId;
	}

	/**
	 * @param portfolioId
	 *            the portfolioId to set
	 */
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	/**
	 * @return the rptPeriod
	 */
	public Integer getRptPeriod() {
		return rptPeriod;
	}

	/**
	 * @param rptPeriod
	 *            the rptPeriod to set
	 */
	public void setRptPeriod(Integer rptPeriod) {
		this.rptPeriod = rptPeriod;
	}

	/**
	 * @return the enrAmt
	 */
	public Double getEnrAmt() {
		return enrAmt;
	}

	/**
	 * @param enrAmt
	 *            the enrAmt to set
	 */
	public void setEnrAmt(Double enrAmt) {
		this.enrAmt = enrAmt;
	}

	/**
	 * @return the rowId
	 */
	public Integer getRowId() {
		return rowId;
	}

	/**
	 * @param rowId
	 *            the rowId to set
	 */
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	/**
	 * @return the processingUnit
	 */
	public Integer getProcessingUnit() {
		return processingUnit;
	}

	/**
	 * @param processingUnit
	 *            the processingUnit to set
	 */
	public void setProcessingUnit(Integer processingUnit) {
		this.processingUnit = processingUnit;
	}

	/**
	 * @return the eEnrAmt
	 */
	public Double geteEnrAmt() {
		return eEnrAmt;
	}

	/**
	 * @param eEnrAmt
	 *            the eEnrAmt to set
	 */
	public void setEEnrAmt(Double eEnrAmt) {
		this.eEnrAmt = eEnrAmt;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserSubmissionBaseRecord [region=" + region + ", country="
				+ country + ", businessUnit=" + businessUnit + ", productType="
				+ productType + ", createdBy=" + createdBy + ", createdDt="
				+ createdDt + ", portfolioId=" + portfolioId + ", rptPeriod="
				+ rptPeriod + ", enrAmt=" + enrAmt + ", rowId=" + rowId
				+ ", processingUnit=" + processingUnit + ", includeAccount="
				+ includeAccount + ", eEnrAmt=" + eEnrAmt + "]";
	}

}