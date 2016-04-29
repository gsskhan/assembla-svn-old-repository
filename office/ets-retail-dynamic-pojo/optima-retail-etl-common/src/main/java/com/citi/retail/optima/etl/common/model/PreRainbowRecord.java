package com.citi.retail.optima.etl.common.model;

import java.util.Date;

public class PreRainbowRecord extends CardsTRLRecord{

	private Double alopCrLimit;
	private Double anr2;
	private Integer behScore;
	private Integer bScoreid;
	private Double ciRate;
	private Double cshFee;
	private Double cshIntr;
	private Integer  cycle;
	private Date datePay;
	private String  delqProf;
	private Double lateFee;
	private Double lcshAmt2;
	private Integer lcshCnt2;
	private Double lrtlAmt2;
	private Integer lrtlCnt2;
	private Double monbLnc;
	private Integer ocshCnt2;
	private Double ortlAmt2;
	private Integer ortlCnt2;
	private Double payAmt2;
	private Double riRate;
	private Double rtlIntr;

	private String achind;
	private Double anfee;
	private Integer availclt;
	private String block2;
	private String cardNmbr;
	private String cardType;
	private Double cashAccrIntr;
	private Double clt2;
	//changing the type to String
	private String custId;
	private Date dateBlk2;
	private Date dateClt2;
	private Date dateCncl;
	private Date datecsh;
	private Date dateOpen;
	private Date dateRtl;
	private Date dateSt2;
	private Date dateTmpf;
	private Date dateTmpt;
	private Date datLclt2;
	private Double intrst;
	private Double lclt2;
	private Double mdue;
	private Double ocsha;
	private Date reageDate1;
	private Integer rageReq1;
	private String riskLevl;
	private Double rtlAccrIntr;
	private String status2;
	private Double totAmtDue;
	private Double woIntr;
	private Double woPrn;
	private Date dateExp1;
	private Integer dcnt1;
	private Integer dueDateGrp;
	private TdrRecord eTdrRecord ;
	private String gcbcPortfolioId;
	//private Integer finFico;
	private Double eppAmnt;
	private Double otherFee;
	private String alignScore;
	
	public Date getDateExp1() {
		return dateExp1;
	}
	public void setDateExp1(Date dateExp1) {
		this.dateExp1 = dateExp1;
	}
	public Integer getDcnt1() {
		return dcnt1;
	}
	public void setDcnt1(Integer dcnt1) {
		this.dcnt1 = dcnt1;
	}
	public Integer getDueDateGrp() {
		return dueDateGrp;
	}
	public void setDueDateGrp(Integer dueDateGrp) {
		this.dueDateGrp = dueDateGrp;
	}
	public Double getAlopCrLimit() {
		return alopCrLimit;
	}
	public void setAlopCrLimit(Double alopCrLimit) {
		this.alopCrLimit = alopCrLimit;
	}
	public Double getAnr2() {
		return anr2;
	}
	public void setAnr2(Double anr2) {
		this.anr2 = anr2;
	}
	public Integer getBehScore() {
		return behScore;
	}
	public void setBehScore(Integer behScore) {
		this.behScore = behScore;
	}
	public Integer getbScoreid() {
		return bScoreid;
	}
	public void setbScoreid(Integer bScoreid) {
		this.bScoreid = bScoreid;
	}
	public Double getCiRate() {
		return ciRate;
	}
	public void setCiRate(Double ciRate) {
		this.ciRate = ciRate;
	}
	public Double getCshFee() {
		return cshFee;
	}
	public void setCshFee(Double cshFee) {
		this.cshFee = cshFee;
	}
	public Double getCshIntr() {
		return cshIntr;
	}
	public void setCshIntr(Double cshIntr) {
		this.cshIntr = cshIntr;
	}
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	public Date getDatePay() {
		return datePay;
	}
	public void setDatePay(Date datePay) {
		this.datePay = datePay;
	}
	public String getDelqProf() {
		return delqProf;
	}
	public void setDelqProf(String delqProf) {
		this.delqProf = delqProf;
	}
	public Double getLateFee() {
		return lateFee;
	}
	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}
	public Double getLcshAmt2() {
		return lcshAmt2;
	}
	public void setLcshAmt2(Double lcshAmt2) {
		this.lcshAmt2 = lcshAmt2;
	}
	public Integer getLcshCnt2() {
		return lcshCnt2;
	}
	public void setLcshCnt2(Integer lcshCnt2) {
		this.lcshCnt2 = lcshCnt2;
	}
	public Double getLrtlAmt2() {
		return lrtlAmt2;
	}
	public void setLrtlAmt2(Double lrtlAmt2) {
		this.lrtlAmt2 = lrtlAmt2;
	}
	public Integer getLrtlCnt2() {
		return lrtlCnt2;
	}
	public void setLrtlCnt2(Integer lrtlCnt2) {
		this.lrtlCnt2 = lrtlCnt2;
	}
	public Double getMonbLnc() {
		return monbLnc;
	}
	public void setMonbLnc(Double monbLnc) {
		this.monbLnc = monbLnc;
	}
	public Integer getOcshCnt2() {
		return ocshCnt2;
	}
	public void setOcshCnt2(Integer ocshCnt2) {
		this.ocshCnt2 = ocshCnt2;
	}
	public Double getOrtlAmt2() {
		return ortlAmt2;
	}
	public void setOrtlAmt2(Double ortlAmt2) {
		this.ortlAmt2 = ortlAmt2;
	}
	public Integer getOrtlCnt2() {
		return ortlCnt2;
	}
	public void setOrtlCnt2(Integer ortlCnt2) {
		this.ortlCnt2 = ortlCnt2;
	}
	public Double getPayAmt2() {
		return payAmt2;
	}
	public void setPayAmt2(Double payAmt2) {
		this.payAmt2 = payAmt2;
	}
	public Double getRiRate() {
		return riRate;
	}
	public void setRiRate(Double riRate) {
		this.riRate = riRate;
	}
	public Double getRtlIntr() {
		return rtlIntr;
	}
	public void setRtlIntr(Double rtlIntr) {
		this.rtlIntr = rtlIntr;
	}
	public String getAchind() {
		return achind;
	}
	public void setAchind(String achind) {
		this.achind = achind;
	}
	public Double getAnfee() {
		return anfee;
	}
	public void setAnfee(Double anfee) {
		this.anfee = anfee;
	}
	public Integer getAvailclt() {
		return availclt;
	}
	public void setAvailclt(Integer availclt) {
		this.availclt = availclt;
	}
	public String getBlock2() {
		return block2;
	}
	public void setBlock2(String block2) {
		this.block2 = block2;
	}
	public String getCardNmbr() {
		return cardNmbr;
	}
	public void setCardNmbr(String cardNmbr) {
		this.cardNmbr = cardNmbr;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Double getCashAccrIntr() {
		return cashAccrIntr;
	}
	public void setCashAccrIntr(Double cashAccrIntr) {
		this.cashAccrIntr = cashAccrIntr;
	}
	public Double getClt2() {
		return clt2;
	}
	public void setClt2(Double clt2) {
		this.clt2 = clt2;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public Date getDateBlk2() {
		return dateBlk2;
	}
	public void setDateBlk2(Date dateBlk2) {
		this.dateBlk2 = dateBlk2;
	}
	public Date getDateClt2() {
		return dateClt2;
	}
	public void setDateClt2(Date dateClt2) {
		this.dateClt2 = dateClt2;
	}
	public Date getDateCncl() {
		return dateCncl;
	}
	public void setDateCncl(Date dateCncl) {
		this.dateCncl = dateCncl;
	}
	public Date getDatecsh() {
		return datecsh;
	}
	public void setDatecsh(Date datecsh) {
		this.datecsh = datecsh;
	}
	public Date getDateOpen() {
		return dateOpen;
	}
	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}
	public Date getDateRtl() {
		return dateRtl;
	}
	public void setDateRtl(Date dateRtl) {
		this.dateRtl = dateRtl;
	}
	public Date getDateSt2() {
		return dateSt2;
	}
	public void setDateSt2(Date dateSt2) {
		this.dateSt2 = dateSt2;
	}
	public Date getDateTmpf() {
		return dateTmpf;
	}
	public void setDateTmpf(Date dateTmpf) {
		this.dateTmpf = dateTmpf;
	}
	public Date getDateTmpt() {
		return dateTmpt;
	}
	public void setDateTmpt(Date dateTmpt) {
		this.dateTmpt = dateTmpt;
	}
	public Date getDatLclt2() {
		return datLclt2;
	}
	public void setDatLclt2(Date datLclt2) {
		this.datLclt2 = datLclt2;
	}
	public Double getIntrst() {
		return intrst;
	}
	public void setIntrst(Double intrst) {
		this.intrst = intrst;
	}
	public Double getLclt2() {
		return lclt2;
	}
	public void setLclt2(Double lclt2) {
		this.lclt2 = lclt2;
	}
	public Double getMdue() {
		return mdue;
	}
	public void setMdue(Double mdue) {
		this.mdue = mdue;
	}
	public Double getOcsha() {
		return ocsha;
	}
	public void setOcsha(Double ocsha) {
		this.ocsha = ocsha;
	}
	public Date getReageDate1() {
		return reageDate1;
	}
	public void setReageDate1(Date reageDate1) {
		this.reageDate1 = reageDate1;
	}
	public Integer getRageReq1() {
		return rageReq1;
	}
	public void setRageReq1(Integer rageReq1) {
		this.rageReq1 = rageReq1;
	}
	public String getRiskLevl() {
		return riskLevl;
	}
	public void setRiskLevl(String riskLevl) {
		this.riskLevl = riskLevl;
	}
	public Double getRtlAccrIntr() {
		return rtlAccrIntr;
	}
	public void setRtlAccrIntr(Double rtlAccrIntr) {
		this.rtlAccrIntr = rtlAccrIntr;
	}
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	public Double getTotAmtDue() {
		return totAmtDue;
	}
	public void setTotAmtDue(Double totAmtDue) {
		this.totAmtDue = totAmtDue;
	}
	public Double getWoIntr() {
		return woIntr;
	}
	public void setWoIntr(Double woIntr) {
		this.woIntr = woIntr;
	}
	public Double getWoPrn() {
		return woPrn;
	}
	public void setWoPrn(Double woPrn) {
		this.woPrn = woPrn;
	}
	public TdrRecord geteTdrRecord () {
		return eTdrRecord ;
	}
	public void setETdrRecord (TdrRecord eTdrRecord ) {
		this.eTdrRecord  = eTdrRecord ;
	}
	public String getGcbcPortfolioId() {
		return gcbcPortfolioId;
	}
	public void setGcbcPortfolioId(String gcbcPortfolioId) {
		this.gcbcPortfolioId = gcbcPortfolioId;
	}
	/*public Integer getFinFico() {
		return finFico;
	}
	public void setFinFico(Integer finFico) {
		this.finFico = finFico;
	}*/
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PreRainbowRecord [alopCrLimit=" + alopCrLimit + ", anr2="
				+ anr2 + ", behScore=" + behScore + ", bScoreid=" + bScoreid
				+ ", ciRate=" + ciRate + ", cshFee=" + cshFee + ", cshIntr="
				+ cshIntr + ", cycle=" + cycle + ", datePay=" + datePay
				+ ", delqProf=" + delqProf + ", lateFee=" + lateFee
				+ ", lcshAmt2=" + lcshAmt2 + ", lcshCnt2=" + lcshCnt2
				+ ", lrtlAmt2=" + lrtlAmt2 + ", lrtlCnt2=" + lrtlCnt2
				+ ", monbLnc=" + monbLnc + ", ocshCnt2=" + ocshCnt2
				+ ", ortlAmt2=" + ortlAmt2 + ", ortlCnt2=" + ortlCnt2
				+ ", payAmt2=" + payAmt2 + ", riRate=" + riRate + ", rtlIntr="
				+ rtlIntr + ", achind=" + achind + ", anfee=" + anfee
				+ ", availclt=" + availclt + ", block2=" + block2
				+ ", cardNmbr=" + cardNmbr + ", cardType=" + cardType
				+ ", cashAccrIntr=" + cashAccrIntr + ", clt2=" + clt2
				+ ", custId=" + custId + ", dateBlk2=" + dateBlk2
				+ ", dateClt2=" + dateClt2 + ", dateCncl=" + dateCncl
				+ ", datecsh=" + datecsh + ", dateOpen=" + dateOpen
				+ ", dateRtl=" + dateRtl + ", dateSt2=" + dateSt2
				+ ", dateTmpf=" + dateTmpf + ", dateTmpt=" + dateTmpt
				+ ", datLclt2=" + datLclt2 + ", intrst=" + intrst + ", lclt2="
				+ lclt2 + ", mdue=" + mdue + ", ocsha=" + ocsha
				+ ", reageDate1=" + reageDate1 + ", rageReq1=" + rageReq1
				+ ", riskLevl=" + riskLevl + ", rtlAccrIntr=" + rtlAccrIntr
				+ ", status2=" + status2 + ", totAmtDue=" + totAmtDue
				+ ", woIntr=" + woIntr + ", woPrn=" + woPrn + ", dateExp1="
				+ dateExp1 + ", dcnt1=" + dcnt1 + ", dueDateGrp=" + dueDateGrp
				+ ", eTdrRecord=" + eTdrRecord + "]";
	}
	/**
	 * @return the eppAmnt
	 */
	public Double getEppAmnt() {
		return eppAmnt;
	}
	/**
	 * @param eppAmnt the eppAmnt to set
	 */
	public void setEppAmnt(Double eppAmnt) {
		this.eppAmnt = eppAmnt;
	}
	/**
	 * @return the otherFee
	 */
	public Double getOtherFee() {
		return otherFee;
	}
	/**
	 * @param otherFee the otherFee to set
	 */
	public void setOtherFee(Double otherFee) {
		this.otherFee = otherFee;
	}
	public String getAlignScore() {
		return alignScore;
	}
	public void setAlignScore(String alignScore) {
		this.alignScore = alignScore;
	}
	
	
	
}