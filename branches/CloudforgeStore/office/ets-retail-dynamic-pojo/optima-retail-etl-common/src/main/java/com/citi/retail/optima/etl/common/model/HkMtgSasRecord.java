package com.citi.retail.optima.etl.common.model;

import java.util.Date;

public class HkMtgSasRecord extends MortgageTRLRecord {
	
	private String 	groupa;
	private String 	lnNo;
	private Integer lnStNo;
	private Integer	lnAmt; // double
	private Integer dpdnow;
	private String 	lnType;
	private Date 	lnDate;
	private String 	custNum;
	private String 	collId;
	private Integer sectype;
	private Integer apprVal; // double
	private Integer cltv;	// cltv
	private Integer osBlUsWithNeg;
	private Double osBlUs; // double
	private Double unIntUs;
	private Integer unintV2Us;
	private Integer numaccts;
	private Integer numnewaccts;
	private Integer purch;
	private Integer neworeorepo;
	private Double totoreorepo;
	private Integer governmentinsurance; // double
	private Integer govinsuind;
	private Integer mobbnd;
	private Integer newripfip;
	private Integer totripfip;
	private Double eBaseAmtCurr;
	private String checkDigit;
	private String citiId;
	private String stateId;
	private String zipCd;
	private String countryCd;
	private Double lateFeeUs;
	private Integer brCde;
	private Integer isCompId;
	private Double totalLateFeeAssAcyamt;
	
	public String getGroupa() {
		return groupa;
	}
	public void setGroupa(String groupa) {
		this.groupa = groupa;
	}
	public String getLnNo() {
		return lnNo;
	}
	public void setLnNo(String lnNo) {
		this.lnNo = lnNo;
	}
	public Integer getLnStNo() {
		return lnStNo;
	}
	public void setLnStNo(Integer lnStNo) {
		this.lnStNo = lnStNo;
	}
	public Integer getLnAmt() {
		return lnAmt;
	}
	public void setLnAmt(Integer lnAmt) {
		this.lnAmt = lnAmt;
	}
	public Integer getDpdnow() {
		return dpdnow;
	}
	public void setDpdnow(Integer dpdnow) {
		this.dpdnow = dpdnow;
	}
	public String getLnType() {
		return lnType;
	}
	public void setLnType(String lnType) {
		this.lnType = lnType;
	}
	public Date getLnDate() {
		return lnDate;
	}
	public void setLnDate(Date lnDate) {
		this.lnDate = lnDate;
	}
	public String getCustNum() {
		return custNum;
	}
	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}
	public String getCollId() {
		return collId;
	}
	public void setCollId(String collId) {
		this.collId = collId;
	}
	public Integer getSectype() {
		return sectype;
	}
	public void setSectype(Integer sectype) {
		this.sectype = sectype;
	}
	public Integer getApprVal() {
		return apprVal;
	}
	public void setApprVal(Integer apprVal) {
		this.apprVal = apprVal;
	}
	public Integer getCltv() {
		return cltv;
	}
	public void setCltv(Integer cltv) {
		this.cltv = cltv;
	}
	public Integer getOsBlUsWithNeg() {
		return osBlUsWithNeg;
	}
	public void setOsBlUsWithNeg(Integer osBlUsWithNeg) {
		this.osBlUsWithNeg = osBlUsWithNeg;
	}
	public Double getOsBlUs() {
		return osBlUs;
	}
	public void setOsBlUs(Double osBlUs) {
		this.osBlUs = osBlUs;
	}
	public Double getUnIntUs() {
		return unIntUs;
	}
	public void setUnIntUs(Double unIntUs) {
		this.unIntUs = unIntUs;
	}
	public Integer getUnintV2Us() {
		return unintV2Us;
	}
	public void setUnintV2Us(Integer unintV2Us) {
		this.unintV2Us = unintV2Us;
	}
	public Integer getNumaccts() {
		return numaccts;
	}
	public void setNumaccts(Integer numaccts) {
		this.numaccts = numaccts;
	}
	public Integer getNumnewaccts() {
		return numnewaccts;
	}
	public void setNumnewaccts(Integer numnewaccts) {
		this.numnewaccts = numnewaccts;
	}
	public Integer getPurch() {
		return purch;
	}
	public void setPurch(Integer purch) {
		this.purch = purch;
	}
	public Integer getNeworeorepo() {
		return neworeorepo;
	}
	public void setNeworeorepo(Integer neworeorepo) {
		this.neworeorepo = neworeorepo;
	}
	public Double getTotoreorepo() {
		return totoreorepo;
	}
	public void setTotoreorepo(Double totoreorepo) {
		this.totoreorepo = totoreorepo;
	}
	public Integer getGovernmentinsurance() {
		return governmentinsurance;
	}
	public void setGovernmentinsurance(Integer governmentinsurance) {
		this.governmentinsurance = governmentinsurance;
	}
	public Integer getGovinsuind() {
		return govinsuind;
	}
	public void setGovinsuind(Integer govinsuind) {
		this.govinsuind = govinsuind;
	}
	public Integer getMobbnd() {
		return mobbnd;
	}
	public void setMobbnd(Integer mobbnd) {
		this.mobbnd = mobbnd;
	}
	public Integer getNewripfip() {
		return newripfip;
	}
	public void setNewripfip(Integer newripfip) {
		this.newripfip = newripfip;
	}
	public Integer getTotripfip() {
		return totripfip;
	}
	public void setTotripfip(Integer totripfip) {
		this.totripfip = totripfip;
	}
	public Double geteBaseAmtCurr() {
		return eBaseAmtCurr;
	}
	public void seteBaseAmtCurr(Double eBaseAmtCurr) {
		this.eBaseAmtCurr = eBaseAmtCurr;
	}
	public String getCheckDigit() {
		return checkDigit;
	}
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}
	public String getCitiId() {
		return citiId;
	}
	public void setCitiId(String citiId) {
		this.citiId = citiId;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getZipCd() {
		return zipCd;
	}
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	public String getCountryCd() {
		return countryCd;
	}
	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}
	public Double getLateFeeUs() {
		return lateFeeUs;
	}
	public void setLateFeeUs(Double lateFeeUs) {
		this.lateFeeUs = lateFeeUs;
	}
	
	
	
	
	public Integer getBrCde() {
		return brCde;
	}
	public void setBrCde(Integer brCde) {
		this.brCde = brCde;
	}
	public Integer getIsCompId() {
		return isCompId;
	}
	public void setIsCompId(Integer isCompId) {
		this.isCompId = isCompId;
	}
	public Double getTotalLateFeeAssAcyamt() {
		return totalLateFeeAssAcyamt;
	}
	public void setTotalLateFeeAssAcyamt(Double totalLateFeeAssAcyamt) {
		this.totalLateFeeAssAcyamt = totalLateFeeAssAcyamt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HkMtgSasRecord [groupa=" + groupa + ", lnNo=" + lnNo
				+ ", lnStNo=" + lnStNo + ", lnAmt=" + lnAmt + ", dpdnow="
				+ dpdnow + ", lnType=" + lnType + ", lnDate=" + lnDate
				+ ", custNum=" + custNum + ", collId=" + collId + ", sectype="
				+ sectype + ", apprVal=" + apprVal + ", cltv=" + cltv
				+ ", osBlUsWithNeg=" + osBlUsWithNeg + ", osBlUs=" + osBlUs
				+ ", unIntUs=" + unIntUs + ", unintV2Us=" + unintV2Us
				+ ", numaccts=" + numaccts + ", numnewaccts=" + numnewaccts
				+ ", purch=" + purch + ", neworeorepo=" + neworeorepo
				+ ", totoreorepo=" + totoreorepo + ", governmentinsurance="
				+ governmentinsurance + ", govinsuind=" + govinsuind
				+ ", mobbnd=" + mobbnd + ", newripfip=" + newripfip
				+ ", totripfip=" + totripfip + ", eBaseAmtCurr=" + eBaseAmtCurr
				+ ", checkDigit=" + checkDigit + ", citiId=" + citiId
				+ ", stateId=" + stateId + ", zipCd=" + zipCd + ", countryCd="
				+ countryCd + "]";
	}

	

}
