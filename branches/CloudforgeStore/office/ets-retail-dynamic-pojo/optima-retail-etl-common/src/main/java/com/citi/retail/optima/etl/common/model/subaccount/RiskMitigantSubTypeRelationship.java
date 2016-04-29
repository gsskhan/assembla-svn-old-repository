/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount;

import java.util.Date;

/**
 * @author TJ
 * 
 */
public class RiskMitigantSubTypeRelationship extends BaseSubAccount {

	// ORA628
	private String riskMitigationSubtype; 
	
	private Date insuranceEffectiveDate;
	private Date insuranceExpirationDate;
	private Double latestCollateralValue;
	private Double originalCollateralValue;
	private Double guaranteeAmount;
	private String insuranceCoverageBasis;
	private Double insuranceFixedAmount;
	private Double insuranceCoveragePercent;
	private Double eExcludeAmount;
	

	public String getRiskMitigationSubtype() {
		return this.riskMitigationSubtype;
	}

	public void setRiskMitigationSubtype(String riskMitigationSubtype) {
		this.riskMitigationSubtype = riskMitigationSubtype;
	}

	/**
	 * @return the insuranceEffectiveDate
	 */
	public Date getInsuranceEffectiveDate() {
		return insuranceEffectiveDate;
	}

	/**
	 * @param insuranceEffectiveDate the insuranceEffectiveDate to set
	 */
	public void setInsuranceEffectiveDate(Date insuranceEffectiveDate) {
		this.insuranceEffectiveDate = insuranceEffectiveDate;
	}

	/**
	 * @return the insuranceExpirationDate
	 */
	public Date getInsuranceExpirationDate() {
		return insuranceExpirationDate;
	}

	/**
	 * @param insuranceExpirationDate the insuranceExpirationDate to set
	 */
	public void setInsuranceExpirationDate(Date insuranceExpirationDate) {
		this.insuranceExpirationDate = insuranceExpirationDate;
	}

	/**
	 * @return the latestCollateralValue
	 */
	public Double getLatestCollateralValue() {
		return latestCollateralValue;
	}

	/**
	 * @param latestCollateralValue the latestCollateralValue to set
	 */
	public void setLatestCollateralValue(Double latestCollateralValue) {
		this.latestCollateralValue = latestCollateralValue;
	}

	/**
	 * @return the originalCollateralValue
	 */
	public Double getOriginalCollateralValue() {
		return originalCollateralValue;
	}

	/**
	 * @param originalCollateralValue the originalCollateralValue to set
	 */
	public void setOriginalCollateralValue(Double originalCollateralValue) {
		this.originalCollateralValue = originalCollateralValue;
	}

	/**
	 * @return the guaranteeAmount
	 */
	public Double getGuaranteeAmount() {
		return guaranteeAmount;
	}

	/**
	 * @param guaranteeAmount the guaranteeAmount to set
	 */
	public void setGuaranteeAmount(Double guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	/**
	 * @return the insuranceCoverageBasis
	 */
	public String getInsuranceCoverageBasis() {
		return insuranceCoverageBasis;
	}

	/**
	 * @param insuranceCoverageBasis the insuranceCoverageBasis to set
	 */
	public void setInsuranceCoverageBasis(String insuranceCoverageBasis) {
		this.insuranceCoverageBasis = insuranceCoverageBasis;
	}

	/**
	 * @return the insuranceFixedAmount
	 */
	public Double getInsuranceFixedAmount() {
		return insuranceFixedAmount;
	}

	/**
	 * @param insuranceFixedAmount the insuranceFixedAmount to set
	 */
	public void setInsuranceFixedAmount(Double insuranceFixedAmount) {
		this.insuranceFixedAmount = insuranceFixedAmount;
	}

	/**
	 * @return the insuranceCoveragePercent
	 */
	public Double getInsuranceCoveragePercent() {
		return insuranceCoveragePercent;
	}

	/**
	 * @param insuranceCoveragePercent the insuranceCoveragePercent to set
	 */
	public void setInsuranceCoveragePercent(Double insuranceCoveragePercent) {
		this.insuranceCoveragePercent = insuranceCoveragePercent;
	}

	/**
	 * @return the eExcludeAmount
	 */
	public Double geteExcludeAmount() {
		return eExcludeAmount;
	}

	/**
	 * @param eExcludeAmount the eExcludeAmount to set
	 */
	public void setEExcludeAmount(Double eExcludeAmount) {
		this.eExcludeAmount = eExcludeAmount;
	}
	

}
