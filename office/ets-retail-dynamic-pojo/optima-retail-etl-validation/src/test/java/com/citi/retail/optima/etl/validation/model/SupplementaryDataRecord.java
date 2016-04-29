/**
 * 
 */
package com.citi.retail.optima.etl.validation.model;

/**
 * @author sv16441
 * 
 */
public class SupplementaryDataRecord extends UserSubmissionBaseRecord {

	private Double cumLifeGrossChargeOffAmt;
	private Double cumLifePurcImprFairValAdj;
	private Double autoLeaseRepY14QSch;
	private Double nonAutoLeaseRepY14QSch;
	private Double nonPurSecBasLoaRep;
	private Double smeCorpCardLoaRepComIndUs;
	private Double smeCorpCardLoaRepComIndOutUs;
	private Double smeCorpCardLoaIndFamOtCard;
	private Double smeCorpCardLoaIndFamOthers;
	private String submitterId;
	private String supplSkipRecord;
	private Integer regionId;

	private Integer eProductId;
	private Integer eFedProductId;
	private Integer eBusinessUnitId;
	private Integer eRegionId;
	private Integer eFedRegionSegmentId;

	/**
	 * @return the cumLifeGrossChargeOffAmt
	 */
	public Double getCumLifeGrossChargeOffAmt() {
		return cumLifeGrossChargeOffAmt;
	}

	/**
	 * @param cumLifeGrossChargeOffAmt
	 *            the cumLifeGrossChargeOffAmt to set
	 */
	public void setCumLifeGrossChargeOffAmt(Double cumLifeGrossChargeOffAmt) {
		this.cumLifeGrossChargeOffAmt = cumLifeGrossChargeOffAmt;
	}

	/**
	 * @return the cumLifePurcImprFairValAdj
	 */
	public Double getCumLifePurcImprFairValAdj() {
		return cumLifePurcImprFairValAdj;
	}

	/**
	 * @param cumLifePurcImprFairValAdj
	 *            the cumLifePurcImprFairValAdj to set
	 */
	public void setCumLifePurcImprFairValAdj(Double cumLifePurcImprFairValAdj) {
		this.cumLifePurcImprFairValAdj = cumLifePurcImprFairValAdj;
	}

	/**
	 * @return the autoLeaseRepY14QSch
	 */
	public Double getAutoLeaseRepY14QSch() {
		return autoLeaseRepY14QSch;
	}

	/**
	 * @param autoLeaseRepY14QSch
	 *            the autoLeaseRepY14QSch to set
	 */
	public void setAutoLeaseRepY14QSch(Double autoLeaseRepY14QSch) {
		this.autoLeaseRepY14QSch = autoLeaseRepY14QSch;
	}

	/**
	 * @return the nonAutoLeaseRepY14QSch
	 */
	public Double getNonAutoLeaseRepY14QSch() {
		return nonAutoLeaseRepY14QSch;
	}

	/**
	 * @param nonAutoLeaseRepY14QSch
	 *            the nonAutoLeaseRepY14QSch to set
	 */
	public void setNonAutoLeaseRepY14QSch(Double nonAutoLeaseRepY14QSch) {
		this.nonAutoLeaseRepY14QSch = nonAutoLeaseRepY14QSch;
	}

	/**
	 * @return the nonPurSecBasLoaRep
	 */
	public Double getNonPurSecBasLoaRep() {
		return nonPurSecBasLoaRep;
	}

	/**
	 * @param nonPurSecBasLoaRep
	 *            the nonPurSecBasLoaRep to set
	 */
	public void setNonPurSecBasLoaRep(Double nonPurSecBasLoaRep) {
		this.nonPurSecBasLoaRep = nonPurSecBasLoaRep;
	}

	/**
	 * @return the smeCorpCardLoaRepComIndUs
	 */
	public Double getSmeCorpCardLoaRepComIndUs() {
		return smeCorpCardLoaRepComIndUs;
	}

	/**
	 * @param smeCorpCardLoaRepComIndUs
	 *            the smeCorpCardLoaRepComIndUs to set
	 */
	public void setSmeCorpCardLoaRepComIndUs(Double smeCorpCardLoaRepComIndUs) {
		this.smeCorpCardLoaRepComIndUs = smeCorpCardLoaRepComIndUs;
	}

	/**
	 * @return the smeCorpCardLoaRepComIndOutUs
	 */
	public Double getSmeCorpCardLoaRepComIndOutUs() {
		return smeCorpCardLoaRepComIndOutUs;
	}

	/**
	 * @param smeCorpCardLoaRepComIndOutUs
	 *            the smeCorpCardLoaRepComIndOutUs to set
	 */
	public void setSmeCorpCardLoaRepComIndOutUs(
			Double smeCorpCardLoaRepComIndOutUs) {
		this.smeCorpCardLoaRepComIndOutUs = smeCorpCardLoaRepComIndOutUs;
	}

	/**
	 * @return the smeCorpCardLoaIndFamOtCard
	 */
	public Double getSmeCorpCardLoaIndFamOtCard() {
		return smeCorpCardLoaIndFamOtCard;
	}

	/**
	 * @param smeCorpCardLoaIndFamOtCard
	 *            the smeCorpCardLoaIndFamOtCard to set
	 */
	public void setSmeCorpCardLoaIndFamOtCard(Double smeCorpCardLoaIndFamOtCard) {
		this.smeCorpCardLoaIndFamOtCard = smeCorpCardLoaIndFamOtCard;
	}

	/**
	 * @return the smeCorpCardLoaIndFamOthers
	 */
	public Double getSmeCorpCardLoaIndFamOthers() {
		return smeCorpCardLoaIndFamOthers;
	}

	/**
	 * @param smeCorpCardLoaIndFamOthers
	 *            the smeCorpCardLoaIndFamOthers to set
	 */
	public void setSmeCorpCardLoaIndFamOthers(Double smeCorpCardLoaIndFamOthers) {
		this.smeCorpCardLoaIndFamOthers = smeCorpCardLoaIndFamOthers;
	}

	/**
	 * @return the submitterId
	 */
	public String getSubmitterId() {
		return submitterId;
	}

	/**
	 * @param submitterId
	 *            the submitterId to set
	 */
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}

	public String inputRecordHeader() {
		return "rptPeriod,region,country,businessUnit,productType,cumLifeGrossChargeOffAmt,cumLifePurcImprFairValAdj,autoLeaseRepY14QSch,nonAutoLeaseRepY14QSch,nonPurSecBasLoaRep,smeCorpCardLoaRepComIndUs,smeCorpCardLoaRepComIndOutUs,smeCorpCardLoaIndFamOtCard,smeCorpCardLoaIndFamOthers,submitterId";
	}

	public String inputRecordString() {

		String inputRecord = rptPeriod + "," + regionId + "," + country + ","
				+ businessUnit + "," + productType + ","
				+ cumLifeGrossChargeOffAmt + "," + cumLifePurcImprFairValAdj
				+ "," + autoLeaseRepY14QSch + "," + nonAutoLeaseRepY14QSch
				+ "," + nonPurSecBasLoaRep + "," + smeCorpCardLoaRepComIndUs
				+ "," + smeCorpCardLoaRepComIndOutUs + ","
				+ smeCorpCardLoaIndFamOtCard + "," + smeCorpCardLoaIndFamOthers
				+ "," + submitterId + "," + "Exception";

		return inputRecord;
	}

	/**
	 * @return the supplSkipRecord
	 */
	public String getSupplSkipRecord() {
		return supplSkipRecord;
	}

	/**
	 * @param supplSkipRecord
	 *            the supplSkipRecord to set
	 */
	public void setSupplSkipRecord(String supplSkipRecord) {
		this.supplSkipRecord = supplSkipRecord;
	}

	public Integer geteProductId() {
		return eProductId;
	}

	public void setEProductId(Integer eProductId) {
		this.eProductId = eProductId;
	}

	public Integer geteBusinessUnitId() {
		return eBusinessUnitId;
	}

	public void setEBusinessUnitId(Integer eBusinessUnitId) {
		this.eBusinessUnitId = eBusinessUnitId;
	}

	public Integer geteRegionId() {
		return eRegionId;
	}

	public void setERegionId(Integer eRegionId) {
		this.eRegionId = eRegionId;
	}

	public Integer geteFedRegionSegmentId() {
		return eFedRegionSegmentId;
	}

	public void setEFedRegionSegmentId(Integer eFedRegionSegmentId) {
		this.eFedRegionSegmentId = eFedRegionSegmentId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	/**
	 * @return the eFedProductId
	 */
	public Integer geteFedProductId() {
		return eFedProductId;
	}

	/**
	 * @param eFedProductId
	 *            the eFedProductId to set
	 */
	public void setEFedProductId(Integer eFedProductId) {
		this.eFedProductId = eFedProductId;
	}

}
