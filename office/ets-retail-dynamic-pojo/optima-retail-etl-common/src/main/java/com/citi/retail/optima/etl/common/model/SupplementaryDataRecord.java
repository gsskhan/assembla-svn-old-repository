/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

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
	private String rowItemString;

	public String getRowItemString() {
		return rowItemString;
	}

	public void setRowItemString(String rowItemString) {
		this.rowItemString = rowItemString;
	}

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
		return "reporting_period,region,country,business_unit,product_type,b_cumulative_gross_chargeoffs,c_cumulative_impairments_fair_value_adjustments,f_auto_leases_rpt_y_14q,g_non_auto_leases_rpt_y_14q,h_non_purpose_sec_loans_rpt_bhckb539_bhckk207,i_sme_corp_card_loans_commercial_industrial_loans_us,j_sme_corp_card_loans_commercial_industrial_loans_outside_us,k_sme_corp_card_loans_ind_household_family_other_credit_cards,l_sme_corp_card_loans_household_family_other_revolving,submitter_id";
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SupplementaryDataRecord [cumLifeGrossChargeOffAmt="
				+ cumLifeGrossChargeOffAmt + ", cumLifePurcImprFairValAdj="
				+ cumLifePurcImprFairValAdj + ", autoLeaseRepY14QSch="
				+ autoLeaseRepY14QSch + ", nonAutoLeaseRepY14QSch="
				+ nonAutoLeaseRepY14QSch + ", nonPurSecBasLoaRep="
				+ nonPurSecBasLoaRep + ", smeCorpCardLoaRepComIndUs="
				+ smeCorpCardLoaRepComIndUs + ", smeCorpCardLoaRepComIndOutUs="
				+ smeCorpCardLoaRepComIndOutUs
				+ ", smeCorpCardLoaIndFamOtCard=" + smeCorpCardLoaIndFamOtCard
				+ ", smeCorpCardLoaIndFamOthers=" + smeCorpCardLoaIndFamOthers
				+ ", submitterId=" + submitterId + ", supplSkipRecord="
				+ supplSkipRecord + ", regionId=" + regionId + ", eProductId="
				+ eProductId + ", eFedProductId=" + eFedProductId
				+ ", eBusinessUnitId=" + eBusinessUnitId + ", eRegionId="
				+ eRegionId + ", eFedRegionSegmentId=" + eFedRegionSegmentId
				+ ", rowItemString=" + rowItemString + "]";
	}

}
