package com.citi.retail.optima.etl.common.model;

public class UserSubmissionFVOHFSRecord extends UserSubmissionBaseRecord {

	private String retailLoanType;
	private Double unpaidPrinBalAmt;
	private Integer loanVintage;
	private Double carryingValue;
	private String submitterId;
	private Integer regionId;
	private Integer eRegionId;
	private Integer eLoanId;
	private Integer eBusinessUnitId;
	private Integer eFedLoanId;
	private Integer eFedRegionSegmentId;
	private String eGeo;
	private Integer eVintageBandId;
	
	public String getRetailLoanType() {
		return retailLoanType;
	}
	public void setRetailLoanType(String retailLoanType) {
		this.retailLoanType = retailLoanType;
	}
	public Double getUnpaidPrinBalAmt() {
		return unpaidPrinBalAmt;
	}
	public void setUnpaidPrinBalAmt(Double unpaidPrinBalAmt) {
		this.unpaidPrinBalAmt = unpaidPrinBalAmt;
	}
	public Integer getLoanVintage() {
		return loanVintage;
	}
	public void setLoanVintage(Integer loanVintage) {
		this.loanVintage = loanVintage;
	}
	public Double getCarryingValue() {
		return carryingValue;
	}
	public void setCarryingValue(Double carryingValue) {
		this.carryingValue = carryingValue;
	}
	public String getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public Integer geteRegionId() {
		return eRegionId;
	}
	public void setERegionId(Integer eRegionId) {
		this.eRegionId = eRegionId;
	}
	public Integer geteLoanId() {
		return eLoanId;
	}
	public void setELoanId(Integer eLoanId) {
		this.eLoanId = eLoanId;
	}
	public Integer geteBusinessUnitId() {
		return eBusinessUnitId;
	}
	public void setEBusinessUnitId(Integer eBusinessUnitId) {
		this.eBusinessUnitId = eBusinessUnitId;
	}	
	public Integer geteFedLoanId() {
		return eFedLoanId;
	}
	public void setEFedLoanId(Integer eFedLoanId) {
		this.eFedLoanId = eFedLoanId;
	}
	public Integer geteFedRegionSegmentId() {
		return eFedRegionSegmentId;
	}
	public void setEFedRegionSegmentId(Integer eFedRegionSegmentId) {
		this.eFedRegionSegmentId = eFedRegionSegmentId;
	}
	public String geteGeo() {
		return eGeo;
	}
	public void setEGeo(String eGeo) {
		this.eGeo = eGeo;
	}
	public Integer geteVintageBandId() {
		return eVintageBandId;
	}
	public void setEVintageBandId(Integer eVintageBandId) {
		this.eVintageBandId = eVintageBandId;
	}
	
	public String inputRecordString() {

		StringBuilder inputRecord = new StringBuilder();
		inputRecord.append(rptPeriod).append(",");
		inputRecord.append(regionId).append(",");
		inputRecord.append(country).append(",");
		inputRecord.append(businessUnit).append(",");
		inputRecord.append(retailLoanType).append(",");
		inputRecord.append(loanVintage).append(",");
		inputRecord.append(unpaidPrinBalAmt==null?0:unpaidPrinBalAmt.intValue()).append(",");
		inputRecord.append(carryingValue==null?0:carryingValue.intValue()).append(",");
		inputRecord.append(submitterId);
		return inputRecord.toString();
	}
	
	public String inputRecordHeader() {
		return "Reporting_period,Region,Country,Business_Unit,FVO_HFS_Retail_Loan_Type,Loan_Vintage,Unpaid_Principal_Balance_MM,Carrying_Value_MM,submitter_id";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserSubmissionFVOHFSRecord [retailLoanType=" + retailLoanType
				+ ", unpaidPrinBalAmt=" + unpaidPrinBalAmt + ", loanVintage="
				+ loanVintage + ", carryingValue=" + carryingValue
				+ ", submitterId=" + submitterId + ", regionId=" + regionId
				+ ", eRegionId=" + eRegionId + ", eLoanId=" + eLoanId
				+ ", eBusinessUnitId=" + eBusinessUnitId + ", eFedLoanId="
				+ eFedLoanId + ", eFedRegionSegmentId=" + eFedRegionSegmentId
				+ ", eGeo=" + eGeo + ", eVintageBandId=" + eVintageBandId + "]";
	}
			
}
