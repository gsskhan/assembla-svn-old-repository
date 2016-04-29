package com.citi.retail.optima.etl.common.model;

import java.util.Date;

public class TwRcPreRainbowRecord extends InRcTRLRecord {
	private String acctind;
	private String agencode;
	private Integer alopAmnt;
	private Double alopCrlimit;
	private Integer alopOldCrlimit;
	private Integer alopSpLmtPer;
	private Integer alopTotlimit;
	private String altblk1;
	private String altblk2;
	private Double anfee;
	private Integer anr1;
	private Double anr2;
	private Integer bar;
	private Integer behscore;
	private String block1;
	private String block2;
	private Integer bs12M;
	private Integer bs6M;
	private Integer bscoreid;
	private Integer bsid12M;
	private Integer bsid6M;
	private String cardnmbr;
	private String cardtype;
	private Integer cbr;
	private String clscod1;
	private String clscod2;
	private Integer clt1;
	private Double clt2;
	private Integer cnr;
	private Integer coffamt;
	private Integer cshblnc1;
	private Integer cshblnc2;
	private Double cshfee;
	private Double cshintr;
	private Integer currblnc;
	private String currLscode;
	private Integer currLscodeEffDte;
	private String custid;
	private Integer cycle;
	private Date dateblk1;
	private Date dateblk2;
	/**
	 * changing datebrth to String as it is a masking data
	 */
	private String datebrth;
	private Date dateclt1;
	private Date dateclt2;
	private Date datecncl;
	private Date datecsh;
	private Date dateexp1;
	private Date dateexp2;
	private Date datefee;
	private Date dateopen;
	private Date datepay;
	private Date datertl;
	private Date datest1;
	private Date datest2;
	private Date datetmpf;
	private Date datetmpt;
	private Date datlclt1;
	private Date datlclt2;
	private Integer dcnt1;
	private Integer dcnt2;
	private Integer dcnt3;
	private Integer dcnt4;
	private Integer dcnt5;
	private Integer dcnt6;
	private Integer dcnt7;
	private Integer dcnt8;
	private String delqprof;
	private String devncode;
	private String duedategrp;
	private String eduction;
	private String emvCardUseInd;
	private String emvTag;
	private Double eppAmnt;
	private String feecode;
	private Integer finChrg;
	private String gender;
	private Integer hometime;
	private String homezip;
	private String hsowner;
	private String idno;
	private Integer income;
	private Integer intrst;
	private String jcicIcno;
	private String jcicSi;
	private Double latefee;
	private Integer lbehscor;
	private Integer lbscorid;
	private String lclscod1;
	private String lclscod2;
	private Integer lclt1;
	private Integer lclt2;
	private Integer lcshamt1;
	private Double lcshamt2;
	private Integer lcshcnt1;
	private Integer lcshcnt2;
	private Integer lcycblnc;
	private Integer lmonblnc;
	private Integer lrtlamt1;
	private Double lrtlamt2;
	private Integer lrtlcnt1;
	private Integer lrtlcnt2;
	private String marriage;
	private Double monblnc;
	private Double mdue;
	private String occupatn;
	private Integer ocshamt1;
	private Double ocshamt2;
	private Integer ocshcnt1;
	private Integer ocshcnt2;
	private Integer ortlamt1;
	private Double ortlamt2;
	private Integer ortlcnt1;
	private Integer ortlcnt2;
	private Double otherfee;
	private Integer payamt1;
	private Integer payamt2;
	private String pendLscode;
	private String photo;
	private Integer pot;
	private Integer potexp;
	private String prevLscode;
	private String professn;
	private Integer reagedate1;
	private Integer reagedate2;
	private String reagereq1;
	private String reagereq2;
	private Integer recIntr;
	private Integer recOth;
	private Integer recPrn;
	private String revind;
	private String risklevl;
	private Integer rtlblnc1;
	private Integer rtlblnc2;
	private Double rtlintr;
	private Integer score;
	private Integer scoreid;
	private String source;
	private String status1;
	private String status2;
	private Integer suppcard;
	private Integer tempclt;
	private String tempind;
	private Integer totAmtDue;
	private String workzip;
	private Integer woIntr;
	private Integer woOther;
	private Integer woPrn;
	private String achind;
	private Integer addressChgDte;
	private Integer availclt;
	private Integer avaline;
	private Double cashAccrIntr;
	private Double ciRate;
	private Integer creScor;
	private Integer creatdte;
	private Integer ebOinc;
	private String incInd;
	private Integer memberSinceDate;
	private Integer mue;
	private String oincInd;
	private Integer pinregen;
	private Integer revScor;
	private Double riRate;
	private Double rtlAccrIntr;
	private String scoreId;
	private Integer tte;
	private String usercde1;
	private String usercde2;
	private String usercde3;
	private Integer xferEff;
	private String zType;
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

	public String getAcctind() {
		return acctind;
	}

	public void setAcctind(String acctind) {
		this.acctind = acctind;
	}

	public String getAgencode() {
		return agencode;
	}

	public void setAgencode(String agencode) {
		this.agencode = agencode;
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

	public Integer getAlopOldCrlimit() {
		return alopOldCrlimit;
	}

	public void setAlopOldCrlimit(Integer alopOldCrlimit) {
		this.alopOldCrlimit = alopOldCrlimit;
	}

	public Integer getAlopSpLmtPer() {
		return alopSpLmtPer;
	}

	public void setAlopSpLmtPer(Integer alopSpLmtPer) {
		this.alopSpLmtPer = alopSpLmtPer;
	}

	public Integer getAlopTotlimit() {
		return alopTotlimit;
	}

	public void setAlopTotlimit(Integer alopTotlimit) {
		this.alopTotlimit = alopTotlimit;
	}

	public String getAltblk1() {
		return altblk1;
	}

	public void setAltblk1(String altblk1) {
		this.altblk1 = altblk1;
	}

	public String getAltblk2() {
		return altblk2;
	}

	public void setAltblk2(String altblk2) {
		this.altblk2 = altblk2;
	}

	public Double getAnfee() {
		return anfee;
	}

	public void setAnfee(Double anfee) {
		this.anfee = anfee;
	}

	public Integer getAnr1() {
		return anr1;
	}

	public void setAnr1(Integer anr1) {
		this.anr1 = anr1;
	}

	public Double getAnr2() {
		return anr2;
	}

	public void setAnr2(Double anr2) {
		this.anr2 = anr2;
	}

	public Integer getBar() {
		return bar;
	}

	public void setBar(Integer bar) {
		this.bar = bar;
	}

	public Integer getBehscore() {
		return behscore;
	}

	public void setBehscore(Integer behscore) {
		this.behscore = behscore;
	}

	public String getBlock1() {
		return block1;
	}

	public void setBlock1(String block1) {
		this.block1 = block1;
	}

	public String getBlock2() {
		return block2;
	}

	public void setBlock2(String block2) {
		this.block2 = block2;
	}

	public Integer getBs12M() {
		return bs12M;
	}

	public void setBs12M(Integer bs12m) {
		bs12M = bs12m;
	}

	public Integer getBs6M() {
		return bs6M;
	}

	public void setBs6M(Integer bs6m) {
		bs6M = bs6m;
	}

	public Integer getBscoreid() {
		return bscoreid;
	}

	public void setBscoreid(Integer bscoreid) {
		this.bscoreid = bscoreid;
	}

	public Integer getBsid12M() {
		return bsid12M;
	}

	public void setBsid12M(Integer bsid12m) {
		bsid12M = bsid12m;
	}

	public Integer getBsid6M() {
		return bsid6M;
	}

	public void setBsid6M(Integer bsid6m) {
		bsid6M = bsid6m;
	}

	public String getCardnmbr() {
		return cardnmbr;
	}

	public void setCardnmbr(String cardnmbr) {
		this.cardnmbr = cardnmbr;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public Integer getCbr() {
		return cbr;
	}

	public void setCbr(Integer cbr) {
		this.cbr = cbr;
	}

	public String getClscod1() {
		return clscod1;
	}

	public void setClscod1(String clscod1) {
		this.clscod1 = clscod1;
	}

	public String getClscod2() {
		return clscod2;
	}

	public void setClscod2(String clscod2) {
		this.clscod2 = clscod2;
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

	public Integer getCnr() {
		return cnr;
	}

	public void setCnr(Integer cnr) {
		this.cnr = cnr;
	}

	public Integer getCoffamt() {
		return coffamt;
	}

	public void setCoffamt(Integer coffamt) {
		this.coffamt = coffamt;
	}

	public Integer getCshblnc1() {
		return cshblnc1;
	}

	public void setCshblnc1(Integer cshblnc1) {
		this.cshblnc1 = cshblnc1;
	}

	public Integer getCshblnc2() {
		return cshblnc2;
	}

	public void setCshblnc2(Integer cshblnc2) {
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

	public Integer getCurrblnc() {
		return currblnc;
	}

	public void setCurrblnc(Integer currblnc) {
		this.currblnc = currblnc;
	}

	public String getCurrLscode() {
		return currLscode;
	}

	public void setCurrLscode(String currLscode) {
		this.currLscode = currLscode;
	}

	public Integer getCurrLscodeEffDte() {
		return currLscodeEffDte;
	}

	public void setCurrLscodeEffDte(Integer currLscodeEffDte) {
		this.currLscodeEffDte = currLscodeEffDte;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public Date getDateblk1() {
		return dateblk1;
	}

	public void setDateblk1(Date dateblk1) {
		this.dateblk1 = dateblk1;
	}

	public Date getDateblk2() {
		return dateblk2;
	}

	public void setDateblk2(Date dateblk2) {
		this.dateblk2 = dateblk2;
	}

	public String getDatebrth() {
		return datebrth;
	}

	public void setDatebrth(String datebrth) {
		this.datebrth = datebrth;
	}

	public Date getDateclt1() {
		return dateclt1;
	}

	public void setDateclt1(Date dateclt1) {
		this.dateclt1 = dateclt1;
	}

	public Date getDateclt2() {
		return dateclt2;
	}

	public void setDateclt2(Date dateclt2) {
		this.dateclt2 = dateclt2;
	}

	public Date getDatecncl() {
		return datecncl;
	}

	public void setDatecncl(Date datecncl) {
		this.datecncl = datecncl;
	}

	public Date getDatecsh() {
		return datecsh;
	}

	public void setDatecsh(Date datecsh) {
		this.datecsh = datecsh;
	}

	public Date getDateexp1() {
		return dateexp1;
	}

	public void setDateexp1(Date dateexp1) {
		this.dateexp1 = dateexp1;
	}

	public Date getDateexp2() {
		return dateexp2;
	}

	public void setDateexp2(Date dateexp2) {
		this.dateexp2 = dateexp2;
	}

	public Date getDatefee() {
		return datefee;
	}

	public void setDatefee(Date datefee) {
		this.datefee = datefee;
	}

	public Date getDateopen() {
		return dateopen;
	}

	public void setDateopen(Date dateopen) {
		this.dateopen = dateopen;
	}

	public Date getDatepay() {
		return datepay;
	}

	public void setDatepay(Date datepay) {
		this.datepay = datepay;
	}

	public Date getDatertl() {
		return datertl;
	}

	public void setDatertl(Date datertl) {
		this.datertl = datertl;
	}

	public Date getDatest1() {
		return datest1;
	}

	public void setDatest1(Date datest1) {
		this.datest1 = datest1;
	}

	public Date getDatest2() {
		return datest2;
	}

	public void setDatest2(Date datest2) {
		this.datest2 = datest2;
	}

	public Date getDatetmpf() {
		return datetmpf;
	}

	public void setDatetmpf(Date datetmpf) {
		this.datetmpf = datetmpf;
	}

	public Date getDatetmpt() {
		return datetmpt;
	}

	public void setDatetmpt(Date datetmpt) {
		this.datetmpt = datetmpt;
	}

	public Date getDatlclt1() {
		return datlclt1;
	}

	public void setDatlclt1(Date datlclt1) {
		this.datlclt1 = datlclt1;
	}

	public Date getDatlclt2() {
		return datlclt2;
	}

	public void setDatlclt2(Date datlclt2) {
		this.datlclt2 = datlclt2;
	}

	public Integer getDcnt1() {
		return dcnt1;
	}

	public void setDcnt1(Integer dcnt1) {
		this.dcnt1 = dcnt1;
	}

	public Integer getDcnt2() {
		return dcnt2;
	}

	public void setDcnt2(Integer dcnt2) {
		this.dcnt2 = dcnt2;
	}

	public Integer getDcnt3() {
		return dcnt3;
	}

	public void setDcnt3(Integer dcnt3) {
		this.dcnt3 = dcnt3;
	}

	public Integer getDcnt4() {
		return dcnt4;
	}

	public void setDcnt4(Integer dcnt4) {
		this.dcnt4 = dcnt4;
	}

	public Integer getDcnt5() {
		return dcnt5;
	}

	public void setDcnt5(Integer dcnt5) {
		this.dcnt5 = dcnt5;
	}

	public Integer getDcnt6() {
		return dcnt6;
	}

	public void setDcnt6(Integer dcnt6) {
		this.dcnt6 = dcnt6;
	}

	public Integer getDcnt7() {
		return dcnt7;
	}

	public void setDcnt7(Integer dcnt7) {
		this.dcnt7 = dcnt7;
	}

	public Integer getDcnt8() {
		return dcnt8;
	}

	public void setDcnt8(Integer dcnt8) {
		this.dcnt8 = dcnt8;
	}

	public String getDelqprof() {
		return delqprof;
	}

	public void setDelqprof(String delqprof) {
		this.delqprof = delqprof;
	}

	public String getDevncode() {
		return devncode;
	}

	public void setDevncode(String devncode) {
		this.devncode = devncode;
	}

	public String getDuedategrp() {
		return duedategrp;
	}

	public void setDuedategrp(String duedategrp) {
		this.duedategrp = duedategrp;
	}

	public String getEduction() {
		return eduction;
	}

	public void setEduction(String eduction) {
		this.eduction = eduction;
	}

	public String getEmvCardUseInd() {
		return emvCardUseInd;
	}

	public void setEmvCardUseInd(String emvCardUseInd) {
		this.emvCardUseInd = emvCardUseInd;
	}

	public String getEmvTag() {
		return emvTag;
	}

	public void setEmvTag(String emvTag) {
		this.emvTag = emvTag;
	}

	public Double getEppAmnt() {
		return eppAmnt;
	}

	public void setEppAmnt(Double eppAmnt) {
		this.eppAmnt = eppAmnt;
	}

	public String getFeecode() {
		return feecode;
	}

	public void setFeecode(String feecode) {
		this.feecode = feecode;
	}

	public Integer getFinChrg() {
		return finChrg;
	}

	public void setFinChrg(Integer finChrg) {
		this.finChrg = finChrg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getHometime() {
		return hometime;
	}

	public void setHometime(Integer hometime) {
		this.hometime = hometime;
	}

	public String getHomezip() {
		return homezip;
	}

	public void setHomezip(String homezip) {
		this.homezip = homezip;
	}

	public String getHsowner() {
		return hsowner;
	}

	public void setHsowner(String hsowner) {
		this.hsowner = hsowner;
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

	public Integer getIntrst() {
		return intrst;
	}

	public void setIntrst(Integer intrst) {
		this.intrst = intrst;
	}

	public String getJcicIcno() {
		return jcicIcno;
	}

	public void setJcicIcno(String jcicIcno) {
		this.jcicIcno = jcicIcno;
	}

	public String getJcicSi() {
		return jcicSi;
	}

	public void setJcicSi(String jcicSi) {
		this.jcicSi = jcicSi;
	}

	public Double getLatefee() {
		return latefee;
	}

	public void setLatefee(Double latefee) {
		this.latefee = latefee;
	}

	public Integer getLbehscor() {
		return lbehscor;
	}

	public void setLbehscor(Integer lbehscor) {
		this.lbehscor = lbehscor;
	}

	public Integer getLbscorid() {
		return lbscorid;
	}

	public void setLbscorid(Integer lbscorid) {
		this.lbscorid = lbscorid;
	}

	public String getLclscod1() {
		return lclscod1;
	}

	public void setLclscod1(String lclscod1) {
		this.lclscod1 = lclscod1;
	}

	public String getLclscod2() {
		return lclscod2;
	}

	public void setLclscod2(String lclscod2) {
		this.lclscod2 = lclscod2;
	}

	public Integer getLclt1() {
		return lclt1;
	}

	public void setLclt1(Integer lclt1) {
		this.lclt1 = lclt1;
	}

	public Integer getLclt2() {
		return lclt2;
	}

	public void setLclt2(Integer lclt2) {
		this.lclt2 = lclt2;
	}

	public Integer getLcshamt1() {
		return lcshamt1;
	}

	public void setLcshamt1(Integer lcshamt1) {
		this.lcshamt1 = lcshamt1;
	}

	public Double getLcshamt2() {
		return lcshamt2;
	}

	public void setLcshamt2(Double lcshamt2) {
		this.lcshamt2 = lcshamt2;
	}

	public Integer getLcshcnt1() {
		return lcshcnt1;
	}

	public void setLcshcnt1(Integer lcshcnt1) {
		this.lcshcnt1 = lcshcnt1;
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

	public Integer getLmonblnc() {
		return lmonblnc;
	}

	public void setLmonblnc(Integer lmonblnc) {
		this.lmonblnc = lmonblnc;
	}

	public Integer getLrtlamt1() {
		return lrtlamt1;
	}

	public void setLrtlamt1(Integer lrtlamt1) {
		this.lrtlamt1 = lrtlamt1;
	}

	public Double getLrtlamt2() {
		return lrtlamt2;
	}

	public void setLrtlamt2(Double lrtlamt2) {
		this.lrtlamt2 = lrtlamt2;
	}

	public Integer getLrtlcnt1() {
		return lrtlcnt1;
	}

	public void setLrtlcnt1(Integer lrtlcnt1) {
		this.lrtlcnt1 = lrtlcnt1;
	}

	public Integer getLrtlcnt2() {
		return lrtlcnt2;
	}

	public void setLrtlcnt2(Integer lrtlcnt2) {
		this.lrtlcnt2 = lrtlcnt2;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public Double getMonblnc() {
		return monblnc;
	}

	public void setMonblnc(Double monblnc) {
		this.monblnc = monblnc;
	}

	public Double getMdue() {
		return mdue;
	}

	public void setMdue(Double mdue) {
		this.mdue = mdue;
	}

	public String getOccupatn() {
		return occupatn;
	}

	public void setOccupatn(String occupatn) {
		this.occupatn = occupatn;
	}

	public Integer getOcshamt1() {
		return ocshamt1;
	}

	public void setOcshamt1(Integer ocshamt1) {
		this.ocshamt1 = ocshamt1;
	}

	public Double getOcshamt2() {
		return ocshamt2;
	}

	public void setOcshamt2(Double ocshamt2) {
		this.ocshamt2 = ocshamt2;
	}

	public Integer getOcshcnt1() {
		return ocshcnt1;
	}

	public void setOcshcnt1(Integer ocshcnt1) {
		this.ocshcnt1 = ocshcnt1;
	}

	public Integer getOcshcnt2() {
		return ocshcnt2;
	}

	public void setOcshcnt2(Integer ocshcnt2) {
		this.ocshcnt2 = ocshcnt2;
	}

	public Integer getOrtlamt1() {
		return ortlamt1;
	}

	public void setOrtlamt1(Integer ortlamt1) {
		this.ortlamt1 = ortlamt1;
	}

	public Double getOrtlamt2() {
		return ortlamt2;
	}

	public void setOrtlamt2(Double ortlamt2) {
		this.ortlamt2 = ortlamt2;
	}

	public Integer getOrtlcnt1() {
		return ortlcnt1;
	}

	public void setOrtlcnt1(Integer ortlcnt1) {
		this.ortlcnt1 = ortlcnt1;
	}

	public Integer getOrtlcnt2() {
		return ortlcnt2;
	}

	public void setOrtlcnt2(Integer ortlcnt2) {
		this.ortlcnt2 = ortlcnt2;
	}

	public Double getOtherfee() {
		return otherfee;
	}

	public void setOtherfee(Double otherfee) {
		this.otherfee = otherfee;
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

	public String getPendLscode() {
		return pendLscode;
	}

	public void setPendLscode(String pendLscode) {
		this.pendLscode = pendLscode;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getPot() {
		return pot;
	}

	public void setPot(Integer pot) {
		this.pot = pot;
	}

	public Integer getPotexp() {
		return potexp;
	}

	public void setPotexp(Integer potexp) {
		this.potexp = potexp;
	}

	public String getPrevLscode() {
		return prevLscode;
	}

	public void setPrevLscode(String prevLscode) {
		this.prevLscode = prevLscode;
	}

	public String getProfessn() {
		return professn;
	}

	public void setProfessn(String professn) {
		this.professn = professn;
	}

	public Integer getReagedate1() {
		return reagedate1;
	}

	public void setReagedate1(Integer reagedate1) {
		this.reagedate1 = reagedate1;
	}

	public Integer getReagedate2() {
		return reagedate2;
	}

	public void setReagedate2(Integer reagedate2) {
		this.reagedate2 = reagedate2;
	}

	public String getReagereq1() {
		return reagereq1;
	}

	public void setReagereq1(String reagereq1) {
		this.reagereq1 = reagereq1;
	}

	public String getReagereq2() {
		return reagereq2;
	}

	public void setReagereq2(String reagereq2) {
		this.reagereq2 = reagereq2;
	}

	public Integer getRecIntr() {
		return recIntr;
	}

	public void setRecIntr(Integer recIntr) {
		this.recIntr = recIntr;
	}

	public Integer getRecOth() {
		return recOth;
	}

	public void setRecOth(Integer recOth) {
		this.recOth = recOth;
	}

	public Integer getRecPrn() {
		return recPrn;
	}

	public void setRecPrn(Integer recPrn) {
		this.recPrn = recPrn;
	}

	public String getRevind() {
		return revind;
	}

	public void setRevind(String revind) {
		this.revind = revind;
	}

	public String getRisklevl() {
		return risklevl;
	}

	public void setRisklevl(String risklevl) {
		this.risklevl = risklevl;
	}

	public Integer getRtlblnc1() {
		return rtlblnc1;
	}

	public void setRtlblnc1(Integer rtlblnc1) {
		this.rtlblnc1 = rtlblnc1;
	}

	public Integer getRtlblnc2() {
		return rtlblnc2;
	}

	public void setRtlblnc2(Integer rtlblnc2) {
		this.rtlblnc2 = rtlblnc2;
	}

	public Double getRtlintr() {
		return rtlintr;
	}

	public void setRtlintr(Double rtlintr) {
		this.rtlintr = rtlintr;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScoreid() {
		return scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public Integer getSuppcard() {
		return suppcard;
	}

	public void setSuppcard(Integer suppcard) {
		this.suppcard = suppcard;
	}

	public Integer getTempclt() {
		return tempclt;
	}

	public void setTempclt(Integer tempclt) {
		this.tempclt = tempclt;
	}

	public String getTempind() {
		return tempind;
	}

	public void setTempind(String tempind) {
		this.tempind = tempind;
	}

	public Integer getTotAmtDue() {
		return totAmtDue;
	}

	public void setTotAmtDue(Integer totAmtDue) {
		this.totAmtDue = totAmtDue;
	}

	public String getWorkzip() {
		return workzip;
	}

	public void setWorkzip(String workzip) {
		this.workzip = workzip;
	}

	public Integer getWoIntr() {
		return woIntr;
	}

	public void setWoIntr(Integer woIntr) {
		this.woIntr = woIntr;
	}

	public Integer getWoOther() {
		return woOther;
	}

	public void setWoOther(Integer woOther) {
		this.woOther = woOther;
	}

	public Integer getWoPrn() {
		return woPrn;
	}

	public void setWoPrn(Integer woPrn) {
		this.woPrn = woPrn;
	}

	public String getAchind() {
		return achind;
	}

	public void setAchind(String achind) {
		this.achind = achind;
	}

	public Integer getAddressChgDte() {
		return addressChgDte;
	}

	public void setAddressChgDte(Integer addressChgDte) {
		this.addressChgDte = addressChgDte;
	}

	public Integer getAvailclt() {
		return availclt;
	}

	public void setAvailclt(Integer availclt) {
		this.availclt = availclt;
	}

	public Integer getAvaline() {
		return avaline;
	}

	public void setAvaline(Integer avaline) {
		this.avaline = avaline;
	}

	public Double getCashAccrIntr() {
		return cashAccrIntr;
	}

	public void setCashAccrIntr(Double cashAccrIntr) {
		this.cashAccrIntr = cashAccrIntr;
	}

	public Double getCiRate() {
		return ciRate;
	}

	public void setCiRate(Double ciRate) {
		this.ciRate = ciRate;
	}

	public Integer getCreScor() {
		return creScor;
	}

	public void setCreScor(Integer creScor) {
		this.creScor = creScor;
	}

	public Integer getCreatdte() {
		return creatdte;
	}

	public void setCreatdte(Integer creatdte) {
		this.creatdte = creatdte;
	}

	public Integer getEbOinc() {
		return ebOinc;
	}

	public void setEbOinc(Integer ebOinc) {
		this.ebOinc = ebOinc;
	}

	public String getIncInd() {
		return incInd;
	}

	public void setIncInd(String incInd) {
		this.incInd = incInd;
	}

	public Integer getMemberSinceDate() {
		return memberSinceDate;
	}

	public void setMemberSinceDate(Integer memberSinceDate) {
		this.memberSinceDate = memberSinceDate;
	}

	public Integer getMue() {
		return mue;
	}

	public void setMue(Integer mue) {
		this.mue = mue;
	}

	public String getOincInd() {
		return oincInd;
	}

	public void setOincInd(String oincInd) {
		this.oincInd = oincInd;
	}

	public Integer getPinregen() {
		return pinregen;
	}

	public void setPinregen(Integer pinregen) {
		this.pinregen = pinregen;
	}

	public Integer getRevScor() {
		return revScor;
	}

	public void setRevScor(Integer revScor) {
		this.revScor = revScor;
	}

	public Double getRiRate() {
		return riRate;
	}

	public void setRiRate(Double riRate) {
		this.riRate = riRate;
	}

	public Double getRtlAccrIntr() {
		return rtlAccrIntr;
	}

	public void setRtlAccrIntr(Double rtlAccrIntr) {
		this.rtlAccrIntr = rtlAccrIntr;
	}

	public String getScoreId() {
		return scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}

	public Integer getTte() {
		return tte;
	}

	public void setTte(Integer tte) {
		this.tte = tte;
	}

	public String getUsercde1() {
		return usercde1;
	}

	public void setUsercde1(String usercde1) {
		this.usercde1 = usercde1;
	}

	public String getUsercde2() {
		return usercde2;
	}

	public void setUsercde2(String usercde2) {
		this.usercde2 = usercde2;
	}

	public String getUsercde3() {
		return usercde3;
	}

	public void setUsercde3(String usercde3) {
		this.usercde3 = usercde3;
	}

	public Integer getXferEff() {
		return xferEff;
	}

	public void setXferEff(Integer xferEff) {
		this.xferEff = xferEff;
	}

	public String getzType() {
		return zType;
	}

	public void setzType(String zType) {
		this.zType = zType;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwRcPreRainbowRecord [acctind=" + acctind + ", agencode="
				+ agencode + ", alopAmnt=" + alopAmnt + ", alopCrlimit="
				+ alopCrlimit + ", alopOldCrlimit=" + alopOldCrlimit
				+ ", alopSpLmtPer=" + alopSpLmtPer + ", alopTotlimit="
				+ alopTotlimit + ", altblk1=" + altblk1 + ", altblk2="
				+ altblk2 + ", anfee=" + anfee + ", anr1=" + anr1 + ", anr2="
				+ anr2 + ", bar=" + bar + ", behscore=" + behscore
				+ ", block1=" + block1 + ", block2=" + block2 + ", bs12M="
				+ bs12M + ", bs6M=" + bs6M + ", bscoreid=" + bscoreid
				+ ", bsid12M=" + bsid12M + ", bsid6M=" + bsid6M + ", cardnmbr="
				+ cardnmbr + ", cardtype=" + cardtype + ", cbr=" + cbr
				+ ", clscod1=" + clscod1 + ", clscod2=" + clscod2 + ", clt1="
				+ clt1 + ", clt2=" + clt2 + ", cnr=" + cnr + ", coffamt="
				+ coffamt + ", cshblnc1=" + cshblnc1 + ", cshblnc2=" + cshblnc2
				+ ", cshfee=" + cshfee + ", cshintr=" + cshintr + ", currblnc="
				+ currblnc + ", currLscode=" + currLscode
				+ ", currLscodeEffDte=" + currLscodeEffDte + ", custid="
				+ custid + ", cycle=" + cycle + ", dateblk1=" + dateblk1
				+ ", dateblk2=" + dateblk2 + ", datebrth=" + datebrth
				+ ", dateclt1=" + dateclt1 + ", dateclt2=" + dateclt2
				+ ", datecncl=" + datecncl + ", datecsh=" + datecsh
				+ ", dateexp1=" + dateexp1 + ", dateexp2=" + dateexp2
				+ ", datefee=" + datefee + ", dateopen=" + dateopen
				+ ", datepay=" + datepay + ", datertl=" + datertl
				+ ", datest1=" + datest1 + ", datest2=" + datest2
				+ ", datetmpf=" + datetmpf + ", datetmpt=" + datetmpt
				+ ", datlclt1=" + datlclt1 + ", datlclt2=" + datlclt2
				+ ", dcnt1=" + dcnt1 + ", dcnt2=" + dcnt2 + ", dcnt3=" + dcnt3
				+ ", dcnt4=" + dcnt4 + ", dcnt5=" + dcnt5 + ", dcnt6=" + dcnt6
				+ ", dcnt7=" + dcnt7 + ", dcnt8=" + dcnt8 + ", delqprof="
				+ delqprof + ", devncode=" + devncode + ", duedategrp="
				+ duedategrp + ", eduction=" + eduction + ", emvCardUseInd="
				+ emvCardUseInd + ", emvTag=" + emvTag + ", eppAmnt=" + eppAmnt
				+ ", feecode=" + feecode + ", finChrg=" + finChrg + ", gender="
				+ gender + ", hometime=" + hometime + ", homezip=" + homezip
				+ ", hsowner=" + hsowner + ", idno=" + idno + ", income="
				+ income + ", intrst=" + intrst + ", jcicIcno=" + jcicIcno
				+ ", jcicSi=" + jcicSi + ", latefee=" + latefee + ", lbehscor="
				+ lbehscor + ", lbscorid=" + lbscorid + ", lclscod1="
				+ lclscod1 + ", lclscod2=" + lclscod2 + ", lclt1=" + lclt1
				+ ", lclt2=" + lclt2 + ", lcshamt1=" + lcshamt1 + ", lcshamt2="
				+ lcshamt2 + ", lcshcnt1=" + lcshcnt1 + ", lcshcnt2="
				+ lcshcnt2 + ", lcycblnc=" + lcycblnc + ", lmonblnc="
				+ lmonblnc + ", lrtlamt1=" + lrtlamt1 + ", lrtlamt2="
				+ lrtlamt2 + ", lrtlcnt1=" + lrtlcnt1 + ", lrtlcnt2="
				+ lrtlcnt2 + ", marriage=" + marriage + ", monblnc=" + monblnc
				+ ", mdue=" + mdue + ", occupatn=" + occupatn + ", ocshamt1="
				+ ocshamt1 + ", ocshamt2=" + ocshamt2 + ", ocshcnt1="
				+ ocshcnt1 + ", ocshcnt2=" + ocshcnt2 + ", ortlamt1="
				+ ortlamt1 + ", ortlamt2=" + ortlamt2 + ", ortlcnt1="
				+ ortlcnt1 + ", ortlcnt2=" + ortlcnt2 + ", otherfee="
				+ otherfee + ", payamt1=" + payamt1 + ", payamt2=" + payamt2
				+ ", pendLscode=" + pendLscode + ", photo=" + photo + ", pot="
				+ pot + ", potexp=" + potexp + ", prevLscode=" + prevLscode
				+ ", professn=" + professn + ", reagedate1=" + reagedate1
				+ ", reagedate2=" + reagedate2 + ", reagereq1=" + reagereq1
				+ ", reagereq2=" + reagereq2 + ", recIntr=" + recIntr
				+ ", recOth=" + recOth + ", recPrn=" + recPrn + ", revind="
				+ revind + ", risklevl=" + risklevl + ", rtlblnc1=" + rtlblnc1
				+ ", rtlblnc2=" + rtlblnc2 + ", rtlintr=" + rtlintr
				+ ", score=" + score + ", scoreid=" + scoreid + ", source="
				+ source + ", status1=" + status1 + ", status2=" + status2
				+ ", suppcard=" + suppcard + ", tempclt=" + tempclt
				+ ", tempind=" + tempind + ", totAmtDue=" + totAmtDue
				+ ", workzip=" + workzip + ", woIntr=" + woIntr + ", woOther="
				+ woOther + ", woPrn=" + woPrn + ", achind=" + achind
				+ ", addressChgDte=" + addressChgDte + ", availclt=" + availclt
				+ ", avaline=" + avaline + ", cashAccrIntr=" + cashAccrIntr
				+ ", ciRate=" + ciRate + ", creScor=" + creScor + ", creatdte="
				+ creatdte + ", ebOinc=" + ebOinc + ", incInd=" + incInd
				+ ", memberSinceDate=" + memberSinceDate + ", mue=" + mue
				+ ", oincInd=" + oincInd + ", pinregen=" + pinregen
				+ ", revScor=" + revScor + ", riRate=" + riRate
				+ ", rtlAccrIntr=" + rtlAccrIntr + ", scoreId=" + scoreId
				+ ", tte=" + tte + ", usercde1=" + usercde1 + ", usercde2="
				+ usercde2 + ", usercde3=" + usercde3 + ", xferEff=" + xferEff
				+ ", zType=" + zType + ", gcbcPortfolioId=" + gcbcPortfolioId
				+ ", finFico=" + finFico + ", eTwRcTdrRecord=" + eTwRcTdrRecord
				+ ", eTwRcRecRecord=" + eTwRcRecRecord + ", eTwRcNtbRecord="
				+ eTwRcNtbRecord + ", eTwRcIntRecord=" + eTwRcIntRecord
				+ ", eTwRcEppRecord=" + eTwRcEppRecord + ", eTwRcFicoRecord="
				+ eTwRcFicoRecord + ", eTwRcWoRecord=" + eTwRcWoRecord + "]";
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
