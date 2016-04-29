/**
 * 
 */
package com.citi.retail.optima.etl.validation.model;


/**
 * @author sr67841
 *
 */
public class UserSubmissionFDICRecord extends UserSubmissionBaseRecord {
	
	private	String	creditBureau;
	private	String	modelVersion;
	private	Integer	modelScore;
	private	Double	excludedAmt;
	private	Double	fxRate;
	private	String	localCurrCode;
	private	String	submitterId;
	private	String	contactId;
	private	Double	refId;
	private	Double	dataVersion;
	private	Double	eFedPdPercent;
	private	Double	eFedEffEnrAmt;
	private	Double	eFedEnrGtTrshld;
	private	Double	eFedTotalExcludedAmt;
	private	Double	eFedScoredAmt;
	private	Double	eFedUnscoredAmt;
	private	Double	eFedSpecialScoredAmt;
	private	Double	eFedIncludeScoredAmt;
	private	Double	eFedTotalEffEnrAmt;
	private	Double	eFedTotalEnrAmt;
	private	Double	eFedPrivHighRiskEnrAmt;
	private	Double	eFedFinalHighRiskEnrAmt;
	private	Double	eFedAmountEnrPDBand[] = new Double[15];
	
	private Double pdThreshold;
	
	/**
	 * @return the creditBureau
	 */
	public String getCreditBureau() {
		return creditBureau;
	}
	/**
	 * @param creditBureau the creditBureau to set
	 */
	public void setCreditBureau(String creditBureau) {
		this.creditBureau = creditBureau;
	}
	/**
	 * @return the modelVersion
	 */
	public String getModelVersion() {
		return modelVersion;
	}
	/**
	 * @param modelVersion the modelVersion to set
	 */
	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}
	/**
	 * @return the modelScore
	 */
	public Integer getModelScore() {
		return modelScore;
	}
	/**
	 * @param modelScore the modelScore to set
	 */
	public void setModelScore(Integer modelScore) {
		this.modelScore = modelScore;
	}
	/**
	 * @return the excludedAmt
	 */
	public Double getExcludedAmt() {
		return excludedAmt;
	}
	/**
	 * @param excludedAmt the excludedAmt to set
	 */
	public void setExcludedAmt(Double excludedAmt) {
		this.excludedAmt = excludedAmt;
	}
	/**
	 * @return the fxRate
	 */
	public Double getFxRate() {
		return fxRate;
	}
	/**
	 * @param fxRate the fxRate to set
	 */
	public void setFxRate(Double fxRate) {
		this.fxRate = fxRate;
	}
	/**
	 * @return the localCurrCode
	 */
	public String getLocalCurrCode() {
		return localCurrCode;
	}
	/**
	 * @param localCurrCode the localCurrCode to set
	 */
	public void setLocalCurrCode(String localCurrCode) {
		this.localCurrCode = localCurrCode;
	}
	/**
	 * @return the submitterId
	 */
	public String getSubmitterId() {
		return submitterId;
	}
	/**
	 * @param submitterId the submitterId to set
	 */
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}
	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the refId
	 */
	public Double getRefId() {
		return refId;
	}
	/**
	 * @param refId the refId to set
	 */
	public void setRefId(Double refId) {
		this.refId = refId;
	}
	/**
	 * @return the dataVersion
	 */
	public Double getDataVersion() {
		return dataVersion;
	}
	/**
	 * @param dataVersion the dataVersion to set
	 */
	public void setDataVersion(Double dataVersion) {
		this.dataVersion = dataVersion;
	}
	/**
	 * @return the eFedPdPercent
	 */
	public Double geteFedPdPercent() {
		return eFedPdPercent;
	}
	/**
	 * @param eFedPdPercent the eFedPdPercent to set
	 */
	public void setEFedPdPercent(Double eFedPdPercent) {
		this.eFedPdPercent = eFedPdPercent;
	}
	/**
	 * @return the eFedEffEnrAmt
	 */
	public Double geteFedEffEnrAmt() {
		return eFedEffEnrAmt;
	}
	/**
	 * @param eFedEffEnrAmt the eFedEffEnrAmt to set
	 */
	public void setEFedEffEnrAmt(Double eFedEffEnrAmt) {
		this.eFedEffEnrAmt = eFedEffEnrAmt;
	}
	/**
	 * @return the eFedEnrGtTrshld
	 */
	public Double geteFedEnrGtTrshld() {
		return eFedEnrGtTrshld;
	}
	/**
	 * @param eFedEnrGtTrshld the eFedEnrGtTrshld to set
	 */
	public void setEFedEnrGtTrshld(Double eFedEnrGtTrshld) {
		this.eFedEnrGtTrshld = eFedEnrGtTrshld;
	}
	/**
	 * @return the eFedTotalExcludedAmt
	 */
	public Double geteFedTotalExcludedAmt() {
		return eFedTotalExcludedAmt;
	}
	/**
	 * @param eFedTotalExcludedAmt the eFedTotalExcludedAmt to set
	 */
	public void setEFedTotalExcludedAmt(Double eFedTotalExcludedAmt) {
		this.eFedTotalExcludedAmt = eFedTotalExcludedAmt;
	}
	/**
	 * @return the eFedScoredAmt
	 */
	public Double geteFedScoredAmt() {
		return eFedScoredAmt;
	}
	/**
	 * @param eFedScoredAmt the eFedScoredAmt to set
	 */
	public void setEFedScoredAmt(Double eFedScoredAmt) {
		this.eFedScoredAmt = eFedScoredAmt;
	}
	/**
	 * @return the eFedUnscoredAmt
	 */
	public Double geteFedUnscoredAmt() {
		return eFedUnscoredAmt;
	}
	/**
	 * @param eFedUnscoredAmt the eFedUnscoredAmt to set
	 */
	public void setEFedUnscoredAmt(Double eFedUnscoredAmt) {
		this.eFedUnscoredAmt = eFedUnscoredAmt;
	}
	/**
	 * @return the eFedSpecialScoredAmt
	 */
	public Double geteFedSpecialScoredAmt() {
		return eFedSpecialScoredAmt;
	}
	/**
	 * @param eFedSpecialScoredAmt the eFedSpecialScoredAmt to set
	 */
	public void setEFedSpecialScoredAmt(Double eFedSpecialScoredAmt) {
		this.eFedSpecialScoredAmt = eFedSpecialScoredAmt;
	}
	/**
	 * @return the eFedIncludeScoredAmt
	 */
	public Double geteFedIncludeScoredAmt() {
		return eFedIncludeScoredAmt;
	}
	/**
	 * @param eFedIncludeScoredAmt the eFedIncludeScoredAmt to set
	 */
	public void setEFedIncludeScoredAmt(Double eFedIncludeScoredAmt) {
		this.eFedIncludeScoredAmt = eFedIncludeScoredAmt;
	}
	/**
	 * @return the eFedTotalEffEnrAmt
	 */
	public Double geteFedTotalEffEnrAmt() {
		return eFedTotalEffEnrAmt;
	}
	/**
	 * @param eFedTotalEffEnrAmt the eFedTotalEffEnrAmt to set
	 */
	public void setEFedTotalEffEnrAmt(Double eFedTotalEffEnrAmt) {
		this.eFedTotalEffEnrAmt = eFedTotalEffEnrAmt;
	}
	/**
	 * @return the eFedTotalEnrAmt
	 */
	public Double geteFedTotalEnrAmt() {
		return eFedTotalEnrAmt;
	}
	/**
	 * @param eFedTotalEnrAmt the eFedTotalEnrAmt to set
	 */
	public void setEFedTotalEnrAmt(Double eFedTotalEnrAmt) {
		this.eFedTotalEnrAmt = eFedTotalEnrAmt;
	}
	/**
	 * @return the eFedPrivHighRiskEnrAmt
	 */
	public Double geteFedPrivHighRiskEnrAmt() {
		return eFedPrivHighRiskEnrAmt;
	}
	/**
	 * @param eFedPrivHighRiskEnrAmt the eFedPrivHighRiskEnrAmt to set
	 */
	public void setEFedPrivHighRiskEnrAmt(Double eFedPrivHighRiskEnrAmt) {
		this.eFedPrivHighRiskEnrAmt = eFedPrivHighRiskEnrAmt;
	}
	/**
	 * @return the eFedFinalHighRiskEnrAmt
	 */
	public Double geteFedFinalHighRiskEnrAmt() {
		return eFedFinalHighRiskEnrAmt;
	}
	/**
	 * @param eFedFinalHighRiskEnrAmt the eFedFinalHighRiskEnrAmt to set
	 */
	public void setEFedFinalHighRiskEnrAmt(Double eFedFinalHighRiskEnrAmt) {
		this.eFedFinalHighRiskEnrAmt = eFedFinalHighRiskEnrAmt;
	}
	/**
	 * @return the eFedAmountEnrPDBand
	 */
	public Double[] geteFedAmountEnrPDBand() {
		return eFedAmountEnrPDBand;
	}
	/**
	 * @param eFedAmountEnrPDBand the eFedAmountEnrPDBand to set
	 */
	public void setEFedAmountEnrPDBand(Double[] eFedAmountEnrPDBand) {
		this.eFedAmountEnrPDBand = eFedAmountEnrPDBand;
	}
	
	
	/**
	 * @return the pdThreshold
	 */
	public Double getPdThreshold() {
		return pdThreshold;
	}
	/**
	 * @param pdThreshold the pdThreshold to set
	 */
	public void setPdThreshold(Double pdThreshold) {
		this.pdThreshold = pdThreshold;
	}
}