/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.util.Date;

/**
 * @author gv74035
 *
 */
public class RainbowRecord extends CardsTRLRecord{

	private String nasSrcCde;
	private String agntCde;
	private String crdBlkCode;
	private String crdBlkRsn;
	private Date   crdBlkCodeDate;
	private String crdType;
	private Date   crdCncldDate;
	private String acctPrimBlkCode;
	private String acctIntrnlStatCode;
	private Double chrgOffLcyAmt;
	private Double monbLnc;
	private Double clt2;
	private Integer nbrOfSupCrds;
	private Double payAmt2;
	private Double lrtlAmt2;
	private Double ortlAmt2;
	private Double lcshAmt2;
	private Double ocshAmt2;
	private Integer lrtlCnt2;
	private Integer ortlCnt2;
	private Integer lcshCnt2;
	private Integer ocshCnt2;
	private Double anr2;
	private String acctRiskLvl;
	private Double alopAmnt;
	private Double alopCrLimit;
	private String directDrIndicator;
	private Double crlmRelmLcyAmt;
	private Double cshBlnc2;
	private Double enrLcyAmt;
	private Double currDueAmt;
	private String delqStr;
	private String behScore;
	private String bScoreid;
	private String  block1;
	private Double  pastDueAmt;
	private Integer cycle;
	private Date 	acctPrimBlkDate;
	private String clntNbr;
	private Date 	acctOpenDate;
	private String cclIndicator;
	private Date	datePay;
	private Double lateFee;
	private Double anfee;
	private Double cshFee;
	private Double riRate;
	private Double ciRate;
	private Double cashIBnp;
	private Double cashSvcBnp;
	private Double rtlMemberBnp;
	private Double rtlIBnp;
	private Double rtlInsurBnp;
	private Double rtlMiscBnp;
	private Double rtlSvcBnp;
	private String  delqProf;
	private Double rtlIntr;
	private Double cshIntr;
	private String crdAcctNumber;
	private TdrRecord eTdrRecord;
	private String gcbcPortfolioId;
	private Integer finFico;
	private String alignScore;
	
	private String crdNumber;
	
	
	public String getNasSrcCde() {
		return nasSrcCde;
	}
	public void setNasSrcCde(String nasSrcCde) {
		this.nasSrcCde = nasSrcCde;
	}
	public String getAgntCde() {
		return agntCde;
	}
	public void setAgntCde(String agntCde) {
		this.agntCde = agntCde;
	}
	/**
	 * @return the crdBlkCode
	 */
	public String getCrdBlkCode() {
		return crdBlkCode;
	}
	/**
	 * @param crdBlkCode the crdBlkCode to set
	 */
	public void setCrdBlkCode(String crdBlkCode) {
		this.crdBlkCode = crdBlkCode;
	}
	/**
	 * @return the crdBlkRsn
	 */
	public String getCrdBlkRsn() {
		return crdBlkRsn;
	}
	/**
	 * @param crdBlkRsn the crdBlkRsn to set
	 */
	public void setCrdBlkRsn(String crdBlkRsn) {
		this.crdBlkRsn = crdBlkRsn;
	}
	/**
	 * @return the crdBlkCodeDate
	 */
	public Date getCrdBlkCodeDate() {
		return crdBlkCodeDate;
	}
	/**
	 * @param crdBlkCodeDate the crdBlkCodeDate to set
	 */
	public void setCrdBlkCodeDate(Date crdBlkCodeDate) {
		this.crdBlkCodeDate = crdBlkCodeDate;
	}
	/**
	 * @return the crdType
	 */
	public String getCrdType() {
		return crdType;
	}
	/**
	 * @param crdType the crdType to set
	 */
	public void setCrdType(String crdType) {
		this.crdType = crdType;
	}
	/**
	 * @return the crdCncldDate
	 */
	public Date getCrdCncldDate() {
		return crdCncldDate;
	}
	/**
	 * @param crdCncldDate the crdCncldDate to set
	 */
	public void setCrdCncldDate(Date crdCncldDate) {
		this.crdCncldDate = crdCncldDate;
	}
	/**
	 * @return the acctPrimBlkCode
	 */
	public String getAcctPrimBlkCode() {
		return acctPrimBlkCode;
	}
	/**
	 * @param acctPrimBlkCode the acctPrimBlkCode to set
	 */
	public void setAcctPrimBlkCode(String acctPrimBlkCode) {
		this.acctPrimBlkCode = acctPrimBlkCode;
	}
	/**
	 * @return the acctIntrnlStatCode
	 */
	public String getAcctIntrnlStatCode() {
		return acctIntrnlStatCode;
	}
	/**
	 * @param acctIntrnlStatCode the acctIntrnlStatCode to set
	 */
	public void setAcctIntrnlStatCode(String acctIntrnlStatCode) {
		this.acctIntrnlStatCode = acctIntrnlStatCode;
	}
	/**
	 * @return the chrgOffLcyAmt
	 */
	public Double getChrgOffLcyAmt() {
		return chrgOffLcyAmt;
	}
	/**
	 * @param chrgOffLcyAmt the chrgOffLcyAmt to set
	 */
	public void setChrgOffLcyAmt(Double chrgOffLcyAmt) {
		this.chrgOffLcyAmt = chrgOffLcyAmt;
	}
	/**
	 * @return the monbLnc
	 */
	public Double getMonbLnc() {
		return monbLnc;
	}
	/**
	 * @param monbLnc the monbLnc to set
	 */
	public void setMonbLnc(Double monbLnc) {
		this.monbLnc = monbLnc;
	}
	/**
	 * @return the clt2
	 */
	public Double getClt2() {
		return clt2;
	}
	/**
	 * @param clt2 the clt2 to set
	 */
	public void setClt2(Double clt2) {
		this.clt2 = clt2;
	}
	/**
	 * @return the nbrOfSupCrds
	 */
	public Integer getNbrOfSupCrds() {
		return nbrOfSupCrds;
	}
	/**
	 * @param nbrOfSupCrds the nbrOfSupCrds to set
	 */
	public void setNbrOfSupCrds(Integer nbrOfSupCrds) {
		this.nbrOfSupCrds = nbrOfSupCrds;
	}
	/**
	 * @return the payAmt2
	 */
	public Double getPayAmt2() {
		return payAmt2;
	}
	/**
	 * @param payAmt2 the payAmt2 to set
	 */
	public void setPayAmt2(Double payAmt2) {
		this.payAmt2 = payAmt2;
	}
	/**
	 * @return the lrtlAmt2
	 */
	public Double getLrtlAmt2() {
		return lrtlAmt2;
	}
	/**
	 * @param lrtlAmt2 the lrtlAmt2 to set
	 */
	public void setLrtlAmt2(Double lrtlAmt2) {
		this.lrtlAmt2 = lrtlAmt2;
	}
	/**
	 * @return the ortlAmt2
	 */
	public Double getOrtlAmt2() {
		return ortlAmt2;
	}
	/**
	 * @param ortlAmt2 the ortlAmt2 to set
	 */
	public void setOrtlAmt2(Double ortlAmt2) {
		this.ortlAmt2 = ortlAmt2;
	}
	/**
	 * @return the lcshAmt2
	 */
	public Double getLcshAmt2() {
		return lcshAmt2;
	}
	/**
	 * @param lcshAmt2 the lcshAmt2 to set
	 */
	public void setLcshAmt2(Double lcshAmt2) {
		this.lcshAmt2 = lcshAmt2;
	}
	/**
	 * @return the ocshAmt2
	 */
	public Double getOcshAmt2() {
		return ocshAmt2;
	}
	/**
	 * @param ocshAmt2 the ocshAmt2 to set
	 */
	public void setOcshAmt2(Double ocshAmt2) {
		this.ocshAmt2 = ocshAmt2;
	}
	/**
	 * @return the lrtlCnt2
	 */
	public Integer getLrtlCnt2() {
		return lrtlCnt2;
	}
	/**
	 * @param lrtlCnt2 the lrtlCnt2 to set
	 */
	public void setLrtlCnt2(Integer lrtlCnt2) {
		this.lrtlCnt2 = lrtlCnt2;
	}
	/**
	 * @return the ortlCnt2
	 */
	public Integer getOrtlCnt2() {
		return ortlCnt2;
	}
	/**
	 * @param ortlCnt2 the ortlCnt2 to set
	 */
	public void setOrtlCnt2(Integer ortlCnt2) {
		this.ortlCnt2 = ortlCnt2;
	}
	/**
	 * @return the lcshCnt2
	 */
	public Integer getLcshCnt2() {
		return lcshCnt2;
	}
	/**
	 * @param lcshCnt2 the lcshCnt2 to set
	 */
	public void setLcshCnt2(Integer lcshCnt2) {
		this.lcshCnt2 = lcshCnt2;
	}
	/**
	 * @return the ocshCnt2
	 */
	public Integer getOcshCnt2() {
		return ocshCnt2;
	}
	/**
	 * @param ocshCnt2 the ocshCnt2 to set
	 */
	public void setOcshCnt2(Integer ocshCnt2) {
		this.ocshCnt2 = ocshCnt2;
	}
	/**
	 * @return the anr2
	 */
	public Double getAnr2() {
		return anr2;
	}
	/**
	 * @param anr2 the anr2 to set
	 */
	public void setAnr2(Double anr2) {
		this.anr2 = anr2;
	}
	/**
	 * @return the acctRiskLvl
	 */
	public String getAcctRiskLvl() {
		return acctRiskLvl;
	}
	/**
	 * @param acctRiskLvl the acctRiskLvl to set
	 */
	public void setAcctRiskLvl(String acctRiskLvl) {
		this.acctRiskLvl = acctRiskLvl;
	}
	/**
	 * @return the alopAmnt
	 */
	public Double getAlopAmnt() {
		return alopAmnt;
	}
	/**
	 * @param alopAmnt the alopAmnt to set
	 */
	public void setAlopAmnt(Double alopAmnt) {
		this.alopAmnt = alopAmnt;
	}
	/**
	 * @return the alopCrLimit
	 */
	public Double getAlopCrLimit() {
		return alopCrLimit;
	}
	/**
	 * @param alopCrLimit the alopCrLimit to set
	 */
	public void setAlopCrLimit(Double alopCrLimit) {
		this.alopCrLimit = alopCrLimit;
	}
	/**
	 * @return the directDrIndicator
	 */
	public String getDirectDrIndicator() {
		return directDrIndicator;
	}
	/**
	 * @param directDrIndicator the directDrIndicator to set
	 */
	public void setDirectDrIndicator(String directDrIndicator) {
		this.directDrIndicator = directDrIndicator;
	}
	/**
	 * @return the crlmRelmLcyAmt
	 */
	public Double getCrlmRelmLcyAmt() {
		return crlmRelmLcyAmt;
	}
	/**
	 * @param crlmRelmLcyAmt the crlmRelmLcyAmt to set
	 */
	public void setCrlmRelmLcyAmt(Double crlmRelmLcyAmt) {
		this.crlmRelmLcyAmt = crlmRelmLcyAmt;
	}
	/**
	 * @return the cshBlnc2
	 */
	public Double getCshBlnc2() {
		return cshBlnc2;
	}
	/**
	 * @param cshBlnc2 the cshBlnc2 to set
	 */
	public void setCshBlnc2(Double cshBlnc2) {
		this.cshBlnc2 = cshBlnc2;
	}
	/**
	 * @return the enrLcyAmt
	 */
	public Double getEnrLcyAmt() {
		return enrLcyAmt;
	}
	/**
	 * @param enrLcyAmt the enrLcyAmt to set
	 */
	public void setEnrLcyAmt(Double enrLcyAmt) {
		this.enrLcyAmt = enrLcyAmt;
	}
	/**
	 * @return the currDueAmt
	 */
	public Double getCurrDueAmt() {
		return currDueAmt;
	}
	/**
	 * @param currDueAmt the currDueAmt to set
	 */
	public void setCurrDueAmt(Double currDueAmt) {
		this.currDueAmt = currDueAmt;
	}
	/**
	 * @return the delqStr
	 */
	public String getDelqStr() {
		return delqStr;
	}
	/**
	 * @param delqStr the delqStr to set
	 */
	public void setDelqStr(String delqStr) {
		this.delqStr = delqStr;
	}
	/**
	 * @return the behScore
	 */
	public String getBehScore() {
		return behScore;
	}
	/**
	 * @param behScore the behScore to set
	 */
	public void setBehScore(String behScore) {
		this.behScore = behScore;
	}
	/**
	 * @return the bScoreid
	 */
	public String getbScoreid() {
		return bScoreid;
	}
	/**
	 * @param bScoreid the bScoreid to set
	 */
	public void setbScoreid(String bScoreid) {
		this.bScoreid = bScoreid;
	}
	/**
	 * @return the block1
	 */
	public String getBlock1() {
		return block1;
	}
	/**
	 * @param block1 the block1 to set
	 */
	public void setBlock1(String block1) {
		this.block1 = block1;
	}
	/**
	 * @return the pastDueAmt
	 */
	public Double getPastDueAmt() {
		return pastDueAmt;
	}
	/**
	 * @param pastDueAmt the pastDueAmt to set
	 */
	public void setPastDueAmt(Double pastDueAmt) {
		this.pastDueAmt = pastDueAmt;
	}
	/**
	 * @return the cycle
	 */
	public Integer getCycle() {
		return cycle;
	}
	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	/**
	 * @return the acctPrimBlkDate
	 */
	public Date getAcctPrimBlkDate() {
		return acctPrimBlkDate;
	}
	/**
	 * @param acctPrimBlkDate the acctPrimBlkDate to set
	 */
	public void setAcctPrimBlkDate(Date acctPrimBlkDate) {
		this.acctPrimBlkDate = acctPrimBlkDate;
	}
	/**
	 * @return the clntNbr
	 */
	public String getClntNbr() {
		return clntNbr;
	}
	/**
	 * @param clntNbr the clntNbr to set
	 */
	public void setClntNbr(String clntNbr) {
		this.clntNbr = clntNbr;
	}
	/**
	 * @return the acctOpenDate
	 */
	public Date getAcctOpenDate() {
		return acctOpenDate;
	}
	/**
	 * @param acctOpenDate the acctOpenDate to set
	 */
	public void setAcctOpenDate(Date acctOpenDate) {
		this.acctOpenDate = acctOpenDate;
	}
	/**
	 * @return the cclIndicator
	 */
	public String getCclIndicator() {
		return cclIndicator;
	}
	/**
	 * @param cclIndicator the cclIndicator to set
	 */
	public void setCclIndicator(String cclIndicator) {
		this.cclIndicator = cclIndicator;
	}
	/**
	 * @return the datePay
	 */
	public Date getDatePay() {
		return datePay;
	}
	/**
	 * @param datePay the datePay to set
	 */
	public void setDatePay(Date datePay) {
		this.datePay = datePay;
	}
	/**
	 * @return the lateFee
	 */
	public Double getLateFee() {
		return lateFee;
	}
	/**
	 * @param lateFee the lateFee to set
	 */
	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}
	public Double getAnfee() {
		return anfee;
	}
	public void setAnfee(Double anfee) {
		this.anfee = anfee;
	}
	/**
	 * @return the cshFee
	 */
	public Double getCshFee() {
		return cshFee;
	}
	/**
	 * @param cshFee the cshFee to set
	 */
	public void setCshFee(Double cshFee) {
		this.cshFee = cshFee;
	}
	/**
	 * @return the riRate
	 */
	public Double getRiRate() {
		return riRate;
	}
	/**
	 * @param riRate the riRate to set
	 */
	public void setRiRate(Double riRate) {
		this.riRate = riRate;
	}
	/**
	 * @return the ciRate
	 */
	public Double getCiRate() {
		return ciRate;
	}
	/**
	 * @param ciRate the ciRate to set
	 */
	public void setCiRate(Double ciRate) {
		this.ciRate = ciRate;
	}
	/**
	 * @return the cashIBnp
	 */
	public Double getCashIBnp() {
		return cashIBnp;
	}
	/**
	 * @param cashIBnp the cashIBnp to set
	 */
	public void setCashIBnp(Double cashIBnp) {
		this.cashIBnp = cashIBnp;
	}
	/**
	 * @return the cashSvcBnp
	 */
	public Double getCashSvcBnp() {
		return cashSvcBnp;
	}
	/**
	 * @param cashSvcBnp the cashSvcBnp to set
	 */
	public void setCashSvcBnp(Double cashSvcBnp) {
		this.cashSvcBnp = cashSvcBnp;
	}
	/**
	 * @return the rtlMemberBnp
	 */
	public Double getRtlMemberBnp() {
		return rtlMemberBnp;
	}
	/**
	 * @param rtlMemberBnp the rtlMemberBnp to set
	 */
	public void setRtlMemberBnp(Double rtlMemberBnp) {
		this.rtlMemberBnp = rtlMemberBnp;
	}
	/**
	 * @return the rtlIBnp
	 */
	public Double getRtlIBnp() {
		return rtlIBnp;
	}
	/**
	 * @param rtlIBnp the rtlIBnp to set
	 */
	public void setRtlIBnp(Double rtlIBnp) {
		this.rtlIBnp = rtlIBnp;
	}
	/**
	 * @return the rtlInsurBnp
	 */
	public Double getRtlInsurBnp() {
		return rtlInsurBnp;
	}
	/**
	 * @param rtlInsurBnp the rtlInsurBnp to set
	 */
	public void setRtlInsurBnp(Double rtlInsurBnp) {
		this.rtlInsurBnp = rtlInsurBnp;
	}
	/**
	 * @return the rtlMiscBnp
	 */
	public Double getRtlMiscBnp() {
		return rtlMiscBnp;
	}
	/**
	 * @param rtlMiscBnp the rtlMiscBnp to set
	 */
	public void setRtlMiscBnp(Double rtlMiscBnp) {
		this.rtlMiscBnp = rtlMiscBnp;
	}
	/**
	 * @return the rtlSvcBnp
	 */
	public Double getRtlSvcBnp() {
		return rtlSvcBnp;
	}
	/**
	 * @param rtlSvcBnp the rtlSvcBnp to set
	 */
	public void setRtlSvcBnp(Double rtlSvcBnp) {
		this.rtlSvcBnp = rtlSvcBnp;
	}
	/**
	 * @return the delqProf
	 */
	public String getDelqProf() {
		return delqProf;
	}
	/**
	 * @param delqProf the delqProf to set
	 */
	public void setDelqProf(String delqProf) {
		this.delqProf = delqProf;
	}
	/**
	 * @return the rtlIntr
	 */
	public Double getRtlIntr() {
		return rtlIntr;
	}
	/**
	 * @param rtlIntr the rtlIntr to set
	 */
	public void setRtlIntr(Double rtlIntr) {
		this.rtlIntr = rtlIntr;
	}
	/**
	 * @return the cshIntr
	 */
	public Double getCshIntr() {
		return cshIntr;
	}
	/**
	 * @param cshIntr the cshIntr to set
	 */
	public void setCshIntr(Double cshIntr) {
		this.cshIntr = cshIntr;
	}
	/**
	 * @return the crdAcctNumber
	 */
	public String getCrdAcctNumber() {
		return crdAcctNumber;
	}
	/**
	 * @param crdAcctNumber the crdAcctNumber to set
	 */
	public void setCrdAcctNumber(String crdAcctNumber) {
		this.crdAcctNumber = crdAcctNumber;
	}
	/**
	 * @return the eTdrRecord
	 */
	public TdrRecord geteTdrRecord() {
		return eTdrRecord;
	}
	/**
	 * @param eTdrRecord the eTdrRecord to set
	 */
	public void setETdrRecord(TdrRecord eTdrRecord) {
		this.eTdrRecord = eTdrRecord;
	}
	public String getGcbcPortfolioId() {
		return gcbcPortfolioId;
	}
	public void setGcbcPortfolioId(String gcbcPortfolioId) {
		this.gcbcPortfolioId = gcbcPortfolioId;
	}
	public Integer getFinFico() {
		return finFico;
	}
	public void setFinFico(Integer finFico) {
		this.finFico = finFico;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
	@Override
	public String toString() {
		return "RainbowRecord [nasSrcCde=" + nasSrcCde + ", agntCde=" + agntCde
				+ ", crdBlkCode=" + crdBlkCode + ", crdBlkRsn=" + crdBlkRsn
				+ ", crdBlkCodeDate=" + crdBlkCodeDate + ", crdType=" + crdType
				+ ", crdCncldDate=" + crdCncldDate + ", acctPrimBlkCode="
				+ acctPrimBlkCode + ", acctIntrnlStatCode="
				+ acctIntrnlStatCode + ", chrgOffLcyAmt=" + chrgOffLcyAmt
				+ ", monbLnc=" + monbLnc + ", clt2=" + clt2 + ", nbrOfSupCrds="
				+ nbrOfSupCrds + ", payAmt2=" + payAmt2 + ", lrtlAmt2="
				+ lrtlAmt2 + ", ortlAmt2=" + ortlAmt2 + ", lcshAmt2="
				+ lcshAmt2 + ", ocshAmt2=" + ocshAmt2 + ", lrtlCnt2="
				+ lrtlCnt2 + ", ortlCnt2=" + ortlCnt2 + ", lcshCnt2="
				+ lcshCnt2 + ", ocshCnt2=" + ocshCnt2 + ", anr2=" + anr2
				+ ", acctRiskLvl=" + acctRiskLvl + ", alopAmnt=" + alopAmnt
				+ ", alopCrLimit=" + alopCrLimit + ", directDrIndicator="
				+ directDrIndicator + ", crlmRelmLcyAmt=" + crlmRelmLcyAmt
				+ ", cshBlnc2=" + cshBlnc2 + ", enrLcyAmt=" + enrLcyAmt
				+ ", currDueAmt=" + currDueAmt + ", delqStr=" + delqStr
				+ ", behScore=" + behScore + ", bScoreid=" + bScoreid
				+ ", block1=" + block1 + ", pastDueAmt=" + pastDueAmt
				+ ", cycle=" + cycle + ", acctPrimBlkDate=" + acctPrimBlkDate
				+ ", clntNbr=" + clntNbr + ", acctOpenDate=" + acctOpenDate
				+ ", cclIndicator=" + cclIndicator + ", datePay=" + datePay
				+ ", lateFee=" + lateFee + ", anfee=" + anfee + ", cshFee="
				+ cshFee + ", riRate=" + riRate + ", ciRate=" + ciRate
				+ ", cashIBnp=" + cashIBnp + ", cashSvcBnp=" + cashSvcBnp
				+ ", rtlMemberBnp=" + rtlMemberBnp + ", rtlIBnp=" + rtlIBnp
				+ ", rtlInsurBnp=" + rtlInsurBnp + ", rtlMiscBnp=" + rtlMiscBnp
				+ ", rtlSvcBnp=" + rtlSvcBnp + ", delqProf=" + delqProf
				+ ", rtlIntr=" + rtlIntr + ", cshIntr=" + cshIntr
				+ ", crdAcctNumber=" + crdAcctNumber + ", eTdrRecord="
				+ eTdrRecord + "]";
	}
	public String getAlignScore() {
		return alignScore;
	}
	public void setAlignScore(String alignScore) {
		this.alignScore = alignScore;
	}
	public String getCrdNumber() {
		return crdNumber;
	}
	public void setCrdNumber(String crdNumber) {
		this.crdNumber = crdNumber;
	}
	
	
}
