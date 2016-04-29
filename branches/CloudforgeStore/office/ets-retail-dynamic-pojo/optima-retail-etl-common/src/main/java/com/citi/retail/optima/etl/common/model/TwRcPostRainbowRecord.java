package com.citi.retail.optima.etl.common.model;

import java.util.Date;
import java.util.List;

public class TwRcPostRainbowRecord extends InRcTRLRecord {
	private Integer acctActivationDt;
	private String acctIntrnlStatCde;
	private Date acctOpenDt;
	private String acctPrimBlkCde;
	private Date acctPrimBlkDt;
	private String acctRskLvl;
	private String agntCde;
	private Double cashIbnp;
	private Double cashSvcBnp;
	private String cclInd;
	private Double chrgOffLcyamt;
	/*
	 * changed to String as clntBirthDt is masked 
	 */
	private String clntBirthDt;
	private String clntEcsOccpnCde;
	private String clntResdStatCde;
	private String clntWorkIndustryCde;
	private String crdAcctNbr;
	private String crdBlkCde;
	private Date crdBlkCdeDt;
	private String crdBlkRsn;
	private Date crdCncldDt;
	private Date crdIssueDt;
	private String crdNbr;
	private String crdTyp;
	private Date creationDt;
	private Integer crlmRelnLcyamt;
	private String ctlFlag;
	private String delqStr;
	private String directDrInd;
	private String emvInd;
	private String lossMtgtnCnt;
	private Integer lstActyDt;
	private String nasSrcCde;
	private Integer nbrOfSupCrds;
	private String plsticIdCde;
	private String pymtHstryStr;
	private String relnNbr;
	private Double rtlIbnp;
	private Double rtlInsurBnp;
	private Double rtlMemberBnp;
	private Double rtlMiscBnp;
	private Double rtlSvcBnp;
	private String acctBlkRsn1Cyc;
	private String acctBlkRsn2Cyc;
	private String acctInd;
	private String acctPrimBlkRsnCde;
	private Integer alopAmnt;
	private Double alopCrlimit;
	private Integer anfee;
	private Double anr2;
	private String behscore;
	private String block1;
	private String bscoreid;
	private Integer btintr;
	private Double ciRate;
	private String clntNbr;
	private Integer clt1;
	private Double clt2;
	private Double cshblnc2;
	private Double cshfee;
	private Double cshintr;
	private Double currDueAmt;
	private Integer currblnc;
	private Integer cycle;
	private Integer datepay;
	private String delqprof;
	private Integer dwcpmTotalAmtDue;
	private String education;
	private Double enrLcyamt;
	private Integer eppAmnt;
	private String gender;
	private String idno;
	private Integer income;
	private Double latefee;
	private Double lcshamt2;
	private Integer lcshcnt2;
	private Integer lcycblnc;
	private Double lrtlamt2;
	private Integer lrtlcnt2;
	private Double monblnc;
	private Integer mue;
	private Integer nbalamt2;
	private Double ocshamt2;
	private Integer ocshcnt2;
	private Integer openAcct;
	private Integer openCif;
	private Double ortlamt2;
	private Integer ortlcnt2;
	private Integer otherfee;
	private String ovrlmtExclsnInd;
	private Integer past30Amt;
	private Double pastDueAmt;
	private Integer payamt1;
	private Integer payamt2;
	private Integer reanr;
	private Double riRate;
	private Double rtlintr;
	private String status1;
	private Integer totAcct;
	private Integer tte;
	private String usercde3;
	private String gcbcPortfolioId;
	private Integer finFico;
	private Integer alignScore;
	
	private TwRcTdrdataRecord 	eTwRcTdrRecord;
	private TwRcRecdataRecord 	eTwRcRecRecord;
	private TwRcNtbRecord 		eTwRcNtbRecord;
	private TwRcIntRecord 		eTwRcIntRecord;
	private TwRcEppRecord 		eTwRcEppRecord;
	private TwRcFicoRecord 		eTwRcFicoRecord;
	private TwRcWoRecord 		eTwRcWoRecord;

	
	public Integer getAcctActivationDt() {
		return acctActivationDt;
	}
	public void setAcctActivationDt(Integer acctActivationDt) {
		this.acctActivationDt = acctActivationDt;
	}
	public String getAcctIntrnlStatCde() {
		return acctIntrnlStatCde;
	}
	public void setAcctIntrnlStatCde(String acctIntrnlStatCde) {
		this.acctIntrnlStatCde = acctIntrnlStatCde;
	}
	public Date getAcctOpenDt() {
		return acctOpenDt;
	}
	public void setAcctOpenDt(Date acctOpenDt) {
		this.acctOpenDt = acctOpenDt;
	}
	public String getAcctPrimBlkCde() {
		return acctPrimBlkCde;
	}
	public void setAcctPrimBlkCde(String acctPrimBlkCde) {
		this.acctPrimBlkCde = acctPrimBlkCde;
	}
	public Date getAcctPrimBlkDt() {
		return acctPrimBlkDt;
	}
	public void setAcctPrimBlkDt(Date acctPrimBlkDt) {
		this.acctPrimBlkDt = acctPrimBlkDt;
	}
	public String getAcctRskLvl() {
		return acctRskLvl;
	}
	public void setAcctRskLvl(String acctRskLvl) {
		this.acctRskLvl = acctRskLvl;
	}
	public String getAgntCde() {
		return agntCde;
	}
	public void setAgntCde(String agntCde) {
		this.agntCde = agntCde;
	}
	public Double getCashIbnp() {
		return cashIbnp;
	}
	public void setCashIbnp(Double cashIbnp) {
		this.cashIbnp = cashIbnp;
	}
	public Double getCashSvcBnp() {
		return cashSvcBnp;
	}
	public void setCashSvcBnp(Double cashSvcBnp) {
		this.cashSvcBnp = cashSvcBnp;
	}
	public String getCclInd() {
		return cclInd;
	}
	public void setCclInd(String cclInd) {
		this.cclInd = cclInd;
	}
	public Double getChrgOffLcyamt() {
		return chrgOffLcyamt;
	}
	public void setChrgOffLcyamt(Double chrgOffLcyamt) {
		this.chrgOffLcyamt = chrgOffLcyamt;
	}
	public String getClntBirthDt() {
		return clntBirthDt;
	}
	public void setClntBirthDt(String clntBirthDt) {
		this.clntBirthDt = clntBirthDt;
	}
	public String getClntEcsOccpnCde() {
		return clntEcsOccpnCde;
	}
	public void setClntEcsOccpnCde(String clntEcsOccpnCde) {
		this.clntEcsOccpnCde = clntEcsOccpnCde;
	}
	public String getClntResdStatCde() {
		return clntResdStatCde;
	}
	public void setClntResdStatCde(String clntResdStatCde) {
		this.clntResdStatCde = clntResdStatCde;
	}
	public String getClntWorkIndustryCde() {
		return clntWorkIndustryCde;
	}
	public void setClntWorkIndustryCde(String clntWorkIndustryCde) {
		this.clntWorkIndustryCde = clntWorkIndustryCde;
	}
	public String getCrdAcctNbr() {
		return crdAcctNbr;
	}
	public void setCrdAcctNbr(String crdAcctNbr) {
		this.crdAcctNbr = crdAcctNbr;
	}
	public String getCrdBlkCde() {
		return crdBlkCde;
	}
	public void setCrdBlkCde(String crdBlkCde) {
		this.crdBlkCde = crdBlkCde;
	}
	public Date getCrdBlkCdeDt() {
		return crdBlkCdeDt;
	}
	public void setCrdBlkCdeDt(Date crdBlkCdeDt) {
		this.crdBlkCdeDt = crdBlkCdeDt;
	}
	public String getCrdBlkRsn() {
		return crdBlkRsn;
	}
	public void setCrdBlkRsn(String crdBlkRsn) {
		this.crdBlkRsn = crdBlkRsn;
	}
	public Date getCrdCncldDt() {
		return crdCncldDt;
	}
	public void setCrdCncldDt(Date crdCncldDt) {
		this.crdCncldDt = crdCncldDt;
	}
	public Date getCrdIssueDt() {
		return crdIssueDt;
	}
	public void setCrdIssueDt(Date crdIssueDt) {
		this.crdIssueDt = crdIssueDt;
	}
	public String getCrdNbr() {
		return crdNbr;
	}
	public void setCrdNbr(String crdNbr) {
		this.crdNbr = crdNbr;
	}
	public String getCrdTyp() {
		return crdTyp;
	}
	public void setCrdTyp(String crdTyp) {
		this.crdTyp = crdTyp;
	}
	public Date getCreationDt() {
		return creationDt;
	}
	public void setCreationDt(Date creationDt) {
		this.creationDt = creationDt;
	}
	public Integer getCrlmRelnLcyamt() {
		return crlmRelnLcyamt;
	}
	public void setCrlmRelnLcyamt(Integer crlmRelnLcyamt) {
		this.crlmRelnLcyamt = crlmRelnLcyamt;
	}
	public String getCtlFlag() {
		return ctlFlag;
	}
	public void setCtlFlag(String ctlFlag) {
		this.ctlFlag = ctlFlag;
	}
	public String getDelqStr() {
		return delqStr;
	}
	public void setDelqStr(String delqStr) {
		this.delqStr = delqStr;
	}
	public String getDirectDrInd() {
		return directDrInd;
	}
	public void setDirectDrInd(String directDrInd) {
		this.directDrInd = directDrInd;
	}
	public String getEmvInd() {
		return emvInd;
	}
	public void setEmvInd(String emvInd) {
		this.emvInd = emvInd;
	}
	public String getLossMtgtnCnt() {
		return lossMtgtnCnt;
	}
	public void setLossMtgtnCnt(String lossMtgtnCnt) {
		this.lossMtgtnCnt = lossMtgtnCnt;
	}
	public Integer getLstActyDt() {
		return lstActyDt;
	}
	public void setLstActyDt(Integer lstActyDt) {
		this.lstActyDt = lstActyDt;
	}
	public String getNasSrcCde() {
		return nasSrcCde;
	}
	public void setNasSrcCde(String nasSrcCde) {
		this.nasSrcCde = nasSrcCde;
	}
	public Integer getNbrOfSupCrds() {
		return nbrOfSupCrds;
	}
	public void setNbrOfSupCrds(Integer nbrOfSupCrds) {
		this.nbrOfSupCrds = nbrOfSupCrds;
	}
	public String getPlsticIdCde() {
		return plsticIdCde;
	}
	public void setPlsticIdCde(String plsticIdCde) {
		this.plsticIdCde = plsticIdCde;
	}
	public String getPymtHstryStr() {
		return pymtHstryStr;
	}
	public void setPymtHstryStr(String pymtHstryStr) {
		this.pymtHstryStr = pymtHstryStr;
	}
	public String getRelnNbr() {
		return relnNbr;
	}
	public void setRelnNbr(String relnNbr) {
		this.relnNbr = relnNbr;
	}
	public Double getRtlIbnp() {
		return rtlIbnp;
	}
	public void setRtlIbnp(Double rtlIbnp) {
		this.rtlIbnp = rtlIbnp;
	}
	public Double getRtlInsurBnp() {
		return rtlInsurBnp;
	}
	public void setRtlInsurBnp(Double rtlInsurBnp) {
		this.rtlInsurBnp = rtlInsurBnp;
	}
	public Double getRtlMemberBnp() {
		return rtlMemberBnp;
	}
	public void setRtlMemberBnp(Double rtlMemberBnp) {
		this.rtlMemberBnp = rtlMemberBnp;
	}
	public Double getRtlMiscBnp() {
		return rtlMiscBnp;
	}
	public void setRtlMiscBnp(Double rtlMiscBnp) {
		this.rtlMiscBnp = rtlMiscBnp;
	}
	public Double getRtlSvcBnp() {
		return rtlSvcBnp;
	}
	public void setRtlSvcBnp(Double rtlSvcBnp) {
		this.rtlSvcBnp = rtlSvcBnp;
	}
	public String getAcctBlkRsn1Cyc() {
		return acctBlkRsn1Cyc;
	}
	public void setAcctBlkRsn1Cyc(String acctBlkRsn1Cyc) {
		this.acctBlkRsn1Cyc = acctBlkRsn1Cyc;
	}
	public String getAcctBlkRsn2Cyc() {
		return acctBlkRsn2Cyc;
	}
	public void setAcctBlkRsn2Cyc(String acctBlkRsn2Cyc) {
		this.acctBlkRsn2Cyc = acctBlkRsn2Cyc;
	}
	public String getAcctInd() {
		return acctInd;
	}
	public void setAcctInd(String acctInd) {
		this.acctInd = acctInd;
	}
	public String getAcctPrimBlkRsnCde() {
		return acctPrimBlkRsnCde;
	}
	public void setAcctPrimBlkRsnCde(String acctPrimBlkRsnCde) {
		this.acctPrimBlkRsnCde = acctPrimBlkRsnCde;
	}
	public Integer getAlopAmnt() {
		return alopAmnt;
	}
	public void setAlopAmnt(Integer alopAmnt) {
		this.alopAmnt = alopAmnt;
	}
	public Double getAlopCrlimit() {
		return alopCrlimit;
	}
	public void setAlopCrlimit(Double alopCrlimit) {
		this.alopCrlimit = alopCrlimit;
	}
	public Integer getAnfee() {
		return anfee;
	}
	public void setAnfee(Integer anfee) {
		this.anfee = anfee;
	}
	public Double getAnr2() {
		return anr2;
	}
	public void setAnr2(Double anr2) {
		this.anr2 = anr2;
	}
	public String getBehscore() {
		return behscore;
	}
	public void setBehscore(String behscore) {
		this.behscore = behscore;
	}
	public String getBlock1() {
		return block1;
	}
	public void setBlock1(String block1) {
		this.block1 = block1;
	}
	public String getBscoreid() {
		return bscoreid;
	}
	public void setBscoreid(String bscoreid) {
		this.bscoreid = bscoreid;
	}
	public Integer getBtintr() {
		return btintr;
	}
	public void setBtintr(Integer btintr) {
		this.btintr = btintr;
	}
	public Double getCiRate() {
		return ciRate;
	}
	public void setCiRate(Double ciRate) {
		this.ciRate = ciRate;
	}
	public String getClntNbr() {
		return clntNbr;
	}
	public void setClntNbr(String clntNbr) {
		this.clntNbr = clntNbr;
	}
	public Integer getClt1() {
		return clt1;
	}
	public void setClt1(Integer clt1) {
		this.clt1 = clt1;
	}
	public Double getClt2() {
		return clt2;
	}
	public void setClt2(Double clt2) {
		this.clt2 = clt2;
	}
	public Double getCshblnc2() {
		return cshblnc2;
	}
	public void setCshblnc2(Double cshblnc2) {
		this.cshblnc2 = cshblnc2;
	}
	public Double getCshfee() {
		return cshfee;
	}
	public void setCshfee(Double cshfee) {
		this.cshfee = cshfee;
	}
	public Double getCshintr() {
		return cshintr;
	}
	public void setCshintr(Double cshintr) {
		this.cshintr = cshintr;
	}
	public Double getCurrDueAmt() {
		return currDueAmt;
	}
	public void setCurrDueAmt(Double currDueAmt) {
		this.currDueAmt = currDueAmt;
	}
	public Integer getCurrblnc() {
		return currblnc;
	}
	public void setCurrblnc(Integer currblnc) {
		this.currblnc = currblnc;
	}
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	public Integer getDatepay() {
		return datepay;
	}
	public void setDatepay(Integer datepay) {
		this.datepay = datepay;
	}
	public String getDelqprof() {
		return delqprof;
	}
	public void setDelqprof(String delqprof) {
		this.delqprof = delqprof;
	}
	public Integer getDwcpmTotalAmtDue() {
		return dwcpmTotalAmtDue;
	}
	public void setDwcpmTotalAmtDue(Integer dwcpmTotalAmtDue) {
		this.dwcpmTotalAmtDue = dwcpmTotalAmtDue;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Double getEnrLcyamt() {
		return enrLcyamt;
	}
	public void setEnrLcyamt(Double enrLcyamt) {
		this.enrLcyamt = enrLcyamt;
	}
	public Integer getEppAmnt() {
		return eppAmnt;
	}
	public void setEppAmnt(Integer eppAmnt) {
		this.eppAmnt = eppAmnt;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public Integer getIncome() {
		return income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	public Double getLatefee() {
		return latefee;
	}
	public void setLatefee(Double latefee) {
		this.latefee = latefee;
	}
	public Double getLcshamt2() {
		return lcshamt2;
	}
	public void setLcshamt2(Double lcshamt2) {
		this.lcshamt2 = lcshamt2;
	}
	public Integer getLcshcnt2() {
		return lcshcnt2;
	}
	public void setLcshcnt2(Integer lcshcnt2) {
		this.lcshcnt2 = lcshcnt2;
	}
	public Integer getLcycblnc() {
		return lcycblnc;
	}
	public void setLcycblnc(Integer lcycblnc) {
		this.lcycblnc = lcycblnc;
	}
	public Double getLrtlamt2() {
		return lrtlamt2;
	}
	public void setLrtlamt2(Double lrtlamt2) {
		this.lrtlamt2 = lrtlamt2;
	}
	public Integer getLrtlcnt2() {
		return lrtlcnt2;
	}
	public void setLrtlcnt2(Integer lrtlcnt2) {
		this.lrtlcnt2 = lrtlcnt2;
	}
	public Double getMonblnc() {
		return monblnc;
	}
	public void setMonblnc(Double monblnc) {
		this.monblnc = monblnc;
	}
	public Integer getMue() {
		return mue;
	}
	public void setMue(Integer mue) {
		this.mue = mue;
	}
	public Integer getNbalamt2() {
		return nbalamt2;
	}
	public void setNbalamt2(Integer nbalamt2) {
		this.nbalamt2 = nbalamt2;
	}
	public Double getOcshamt2() {
		return ocshamt2;
	}
	public void setOcshamt2(Double ocshamt2) {
		this.ocshamt2 = ocshamt2;
	}
	public Integer getOcshcnt2() {
		return ocshcnt2;
	}
	public void setOcshcnt2(Integer ocshcnt2) {
		this.ocshcnt2 = ocshcnt2;
	}
	public Integer getOpenAcct() {
		return openAcct;
	}
	public void setOpenAcct(Integer openAcct) {
		this.openAcct = openAcct;
	}
	public Integer getOpenCif() {
		return openCif;
	}
	public void setOpenCif(Integer openCif) {
		this.openCif = openCif;
	}
	public Double getOrtlamt2() {
		return ortlamt2;
	}
	public void setOrtlamt2(Double ortlamt2) {
		this.ortlamt2 = ortlamt2;
	}
	public Integer getOrtlcnt2() {
		return ortlcnt2;
	}
	public void setOrtlcnt2(Integer ortlcnt2) {
		this.ortlcnt2 = ortlcnt2;
	}
	public Integer getOtherfee() {
		return otherfee;
	}
	public void setOtherfee(Integer otherfee) {
		this.otherfee = otherfee;
	}
	public String getOvrlmtExclsnInd() {
		return ovrlmtExclsnInd;
	}
	public void setOvrlmtExclsnInd(String ovrlmtExclsnInd) {
		this.ovrlmtExclsnInd = ovrlmtExclsnInd;
	}
	public Integer getPast30Amt() {
		return past30Amt;
	}
	public void setPast30Amt(Integer past30Amt) {
		this.past30Amt = past30Amt;
	}
	public Double getPastDueAmt() {
		return pastDueAmt;
	}
	public void setPastDueAmt(Double pastDueAmt) {
		this.pastDueAmt = pastDueAmt;
	}
	public Integer getPayamt1() {
		return payamt1;
	}
	public void setPayamt1(Integer payamt1) {
		this.payamt1 = payamt1;
	}
	public Integer getPayamt2() {
		return payamt2;
	}
	public void setPayamt2(Integer payamt2) {
		this.payamt2 = payamt2;
	}
	public Integer getReanr() {
		return reanr;
	}
	public void setReanr(Integer reanr) {
		this.reanr = reanr;
	}
	public Double getRiRate() {
		return riRate;
	}
	public void setRiRate(Double riRate) {
		this.riRate = riRate;
	}
	public Double getRtlintr() {
		return rtlintr;
	}
	public void setRtlintr(Double rtlintr) {
		this.rtlintr = rtlintr;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public Integer getTotAcct() {
		return totAcct;
	}
	public void setTotAcct(Integer totAcct) {
		this.totAcct = totAcct;
	}
	public Integer getTte() {
		return tte;
	}
	public void setTte(Integer tte) {
		this.tte = tte;
	}
	public String getUsercde3() {
		return usercde3;
	}
	public void setUsercde3(String usercde3) {
		this.usercde3 = usercde3;
	}
	public TwRcTdrdataRecord geteTwRcTdrRecord() {
		return eTwRcTdrRecord;
	}
	public void setETwRcTdrRecord(TwRcTdrdataRecord eTwRcTdrRecord) {
		this.eTwRcTdrRecord = eTwRcTdrRecord;
	}
	public TwRcRecdataRecord geteTwRcRecRecord() {
		return eTwRcRecRecord;
	}
	public void setETwRcRecRecord(TwRcRecdataRecord eTwRcRecRecord) {
		this.eTwRcRecRecord = eTwRcRecRecord;
	}
	public TwRcNtbRecord geteTwRcNtbRecord() {
		return eTwRcNtbRecord;
	}
	public void setETwRcNtbRecord(TwRcNtbRecord eTwRcNtbRecord) {
		this.eTwRcNtbRecord = eTwRcNtbRecord;
	}
	public TwRcIntRecord geteTwRcIntRecord() {
		return eTwRcIntRecord;
	}
	public void setETwRcIntRecord(TwRcIntRecord eTwRcIntRecord) {
		this.eTwRcIntRecord = eTwRcIntRecord;
	}
	public TwRcEppRecord geteTwRcEppRecord() {
		return eTwRcEppRecord;
	}
	public void setETwRcEppRecord(TwRcEppRecord eTwRcEppRecord) {
		this.eTwRcEppRecord = eTwRcEppRecord;
	}
	public TwRcFicoRecord geteTwRcFicoRecord() {
		return eTwRcFicoRecord;
	}
	public void setETwRcFicoRecord(TwRcFicoRecord eTwRcFicoRecord) {
		this.eTwRcFicoRecord = eTwRcFicoRecord;
	}
	public TwRcWoRecord geteTwRcWoRecord() {
		return eTwRcWoRecord;
	}
	public void setETwRcWoRecord(TwRcWoRecord eTwRcWoRecord) {
		this.eTwRcWoRecord = eTwRcWoRecord;
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
		return "TwRcPostRainbowRecord [acctActivationDt=" + acctActivationDt
				+ ", acctIntrnlStatCde=" + acctIntrnlStatCde + ", acctOpenDt="
				+ acctOpenDt + ", acctPrimBlkCde=" + acctPrimBlkCde
				+ ", acctPrimBlkDt=" + acctPrimBlkDt + ", acctRskLvl="
				+ acctRskLvl + ", agntCde=" + agntCde + ", cashIbnp="
				+ cashIbnp + ", cashSvcBnp=" + cashSvcBnp + ", cclInd="
				+ cclInd + ", chrgOffLcyamt=" + chrgOffLcyamt
				+ ", clntBirthDt=" + clntBirthDt + ", clntEcsOccpnCde="
				+ clntEcsOccpnCde + ", clntResdStatCde=" + clntResdStatCde
				+ ", clntWorkIndustryCde=" + clntWorkIndustryCde
				+ ", crdAcctNbr=" + crdAcctNbr + ", crdBlkCde=" + crdBlkCde
				+ ", crdBlkCdeDt=" + crdBlkCdeDt + ", crdBlkRsn=" + crdBlkRsn
				+ ", crdCncldDt=" + crdCncldDt + ", crdIssueDt=" + crdIssueDt
				+ ", crdNbr=" + crdNbr + ", crdTyp=" + crdTyp + ", creationDt="
				+ creationDt + ", crlmRelnLcyamt=" + crlmRelnLcyamt
				+ ", ctlFlag=" + ctlFlag + ", delqStr=" + delqStr
				+ ", directDrInd=" + directDrInd + ", emvInd=" + emvInd
				+ ", lossMtgtnCnt=" + lossMtgtnCnt + ", lstActyDt=" + lstActyDt
				+ ", nasSrcCde=" + nasSrcCde + ", nbrOfSupCrds=" + nbrOfSupCrds
				+ ", plsticIdCde=" + plsticIdCde + ", pymtHstryStr="
				+ pymtHstryStr + ", relnNbr=" + relnNbr + ", rtlIbnp="
				+ rtlIbnp + ", rtlInsurBnp=" + rtlInsurBnp + ", rtlMemberBnp="
				+ rtlMemberBnp + ", rtlMiscBnp=" + rtlMiscBnp + ", rtlSvcBnp="
				+ rtlSvcBnp + ", acctBlkRsn1Cyc=" + acctBlkRsn1Cyc
				+ ", acctBlkRsn2Cyc=" + acctBlkRsn2Cyc + ", acctInd=" + acctInd
				+ ", acctPrimBlkRsnCde=" + acctPrimBlkRsnCde + ", alopAmnt="
				+ alopAmnt + ", alopCrlimit=" + alopCrlimit + ", anfee="
				+ anfee + ", anr2=" + anr2 + ", behscore=" + behscore
				+ ", block1=" + block1 + ", bscoreid=" + bscoreid + ", btintr="
				+ btintr + ", ciRate=" + ciRate + ", clntNbr=" + clntNbr
				+ ", clt1=" + clt1 + ", clt2=" + clt2 + ", cshblnc2="
				+ cshblnc2 + ", cshfee=" + cshfee + ", cshintr=" + cshintr
				+ ", currDueAmt=" + currDueAmt + ", currblnc=" + currblnc
				+ ", cycle=" + cycle + ", datepay=" + datepay + ", delqprof="
				+ delqprof + ", dwcpmTotalAmtDue=" + dwcpmTotalAmtDue
				+ ", education=" + education + ", enrLcyamt=" + enrLcyamt
				+ ", eppAmnt=" + eppAmnt + ", gender=" + gender + ", idno="
				+ idno + ", income=" + income + ", latefee=" + latefee
				+ ", lcshamt2=" + lcshamt2 + ", lcshcnt2=" + lcshcnt2
				+ ", lcycblnc=" + lcycblnc + ", lrtlamt2=" + lrtlamt2
				+ ", lrtlcnt2=" + lrtlcnt2 + ", monblnc=" + monblnc + ", mue="
				+ mue + ", nbalamt2=" + nbalamt2 + ", ocshamt2=" + ocshamt2
				+ ", ocshcnt2=" + ocshcnt2 + ", openAcct=" + openAcct
				+ ", openCif=" + openCif + ", ortlamt2=" + ortlamt2
				+ ", ortlcnt2=" + ortlcnt2 + ", otherfee=" + otherfee
				+ ", ovrlmtExclsnInd=" + ovrlmtExclsnInd + ", past30Amt="
				+ past30Amt + ", pastDueAmt=" + pastDueAmt + ", payamt1="
				+ payamt1 + ", payamt2=" + payamt2 + ", reanr=" + reanr
				+ ", riRate=" + riRate + ", rtlintr=" + rtlintr + ", status1="
				+ status1 + ", totAcct=" + totAcct + ", tte=" + tte
				+ ", usercde3=" + usercde3 + ", gcbcPortfolioId="
				+ gcbcPortfolioId + ", finFico=" + finFico
				+ ", eTwRcTdrRecord=" + eTwRcTdrRecord + ", eTwRcRecRecord="
				+ eTwRcRecRecord + ", eTwRcNtbRecord=" + eTwRcNtbRecord
				+ ", eTwRcIntRecord=" + eTwRcIntRecord + ", eTwRcEppRecord="
				+ eTwRcEppRecord + ", eTwRcFicoRecord=" + eTwRcFicoRecord
				+ ", eTwRcWoRecord=" + eTwRcWoRecord + "]";
	}
	public Integer getAlignScore() {
		return alignScore;
	}
	public void setAlignScore(Integer alignScore) {
		this.alignScore = alignScore;
	}
	private Double eAdjBalance;
	
	public Double geteAdjBalance() {
		return eAdjBalance;
	}
	/**
	 * @param eAdjBalance the eAdjBalance to set
	 */
	public void setEAdjBalance(Double eAdjBalance) {
		this.eAdjBalance = eAdjBalance;
	}
	private Double eAdjMonBlnc;
	public Double geteAdjMonBlnc() {
		return eAdjMonBlnc;
	}
	/**
	 * @param eAdjMonBlnc the eAdjMonBlnc to set
	 */
	public void setEAdjMonBlnc(Double eAdjMonBlnc) {
		this.eAdjMonBlnc = eAdjMonBlnc;
	}
	private Double eBalType265;
	/**
	 * @return the eBalType265
	 */
	public Double geteBalType265() {
		return eBalType265;
	}
	/**
	 * @param eBalType265 the eBalType265 to set
	 */
	public void setEBalType265(Double eBalType265) {
		this.eBalType265 = eBalType265;
	}
	private Double ePayAmt2;
	/**
	 * @return the ePayAmt2
	 */
	public Double getePayAmt2() {
		return ePayAmt2;
	}
	/**
	 * @param ePayAmt2 the ePayAmt2 to set
	 */
	public void setEPayAmt2(Double ePayAmt2) {
		this.ePayAmt2 = ePayAmt2;
	}

}
