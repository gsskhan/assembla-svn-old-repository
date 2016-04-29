package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.TwRcPostRainbowRecord;
import com.citi.retail.optima.etl.common.model.TwRcPreRainbowRecord;

public class TwRcPostRainbowFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper{

	public TwRcPostRainbowRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		TwRcPostRainbowRecord record = new TwRcPostRainbowRecord();
		record.setAcctActivationDt(readInt(fieldSet,"acctActivationDt"));
		record.setAcctIntrnlStatCde(fieldSet.readString("acctIntrnlStatCde"));
		record.setAcctOpenDt(readDate(fieldSet,"acctOpenDt","ddMMMyyyy"));
		record.setAcctPrimBlkCde(fieldSet.readString("acctPrimBlkCde"));
		record.setAcctPrimBlkDt(readDate(fieldSet,"acctPrimBlkDt"));
		record.setAcctRskLvl(fieldSet.readString("acctRskLvl"));
		record.setAgntCde(fieldSet.readString("agntCde"));
		record.setCashIbnp(readDouble(fieldSet,"cashIbnp"));
		record.setCashSvcBnp(readDouble(fieldSet,"cashSvcBnp"));
		record.setCclInd(fieldSet.readString("cclInd"));
		record.setChrgOffLcyamt(readDouble(fieldSet,"chrgOffLcyamt"));
		//record.setClntBirthDt(readDate(fieldSet,"clntBirthDt"));
		record.setClntEcsOccpnCde(fieldSet.readString("clntEcsOccpnCde"));
		record.setClntResdStatCde(fieldSet.readString("clntResdStatCde"));
		record.setClntWorkIndustryCde(fieldSet.readString("clntWorkIndustryCde"));
		record.setCrdAcctNbr(fieldSet.readString("crdAcctNbr"));
		record.setCrdBlkCde(fieldSet.readString("crdBlkCde"));
		record.setCrdBlkCdeDt(readDate(fieldSet,"crdBlkCdeDt"));
		record.setCrdBlkRsn(fieldSet.readString("crdBlkRsn"));
		record.setCrdCncldDt(readDate(fieldSet,"crdCncldDt"));
		record.setCrdIssueDt(readDate(fieldSet,"crdIssueDt"));
		record.setCrdNbr(fieldSet.readString("crdNbr"));
		record.setCrdTyp(fieldSet.readString("crdTyp"));
		record.setCreationDt(readDate(fieldSet,"creationDt"));
		record.setCrlmRelnLcyamt(readInt(fieldSet,"crlmRelnLcyamt"));
		record.setCtlFlag(fieldSet.readString("ctlFlag"));
		//record.setDelqStr(readInt(fieldSet,"delqStr"));
		record.setDelqStr(fieldSet.readString("delqStr"));
		record.setDirectDrInd(fieldSet.readString("directDrInd"));
		record.setEmvInd(fieldSet.readString("emvInd"));
		record.setLossMtgtnCnt(fieldSet.readString("lossMtgtnCnt"));
		record.setLstActyDt(readInt(fieldSet,"lstActyDt"));
		record.setNasSrcCde(fieldSet.readString("nasSrcCde"));
		record.setNbrOfSupCrds(readInt(fieldSet,"nbrOfSupCrds"));
		record.setPlsticIdCde(fieldSet.readString("plsticIdCde"));
		record.setPymtHstryStr(fieldSet.readString("pymtHstryStr"));
		record.setRelnNbr(fieldSet.readString("relnNbr"));
		record.setRtlIbnp(readDouble(fieldSet,"rtlIbnp"));
		record.setRtlInsurBnp(readDouble(fieldSet,"rtlInsurBnp"));
		record.setRtlMemberBnp(readDouble(fieldSet,"rtlMemberBnp"));
		record.setRtlMiscBnp(readDouble(fieldSet,"rtlMiscBnp"));
		record.setRtlSvcBnp(readDouble(fieldSet,"rtlSvcBnp"));
		record.setAcctBlkRsn1Cyc(fieldSet.readString("acctBlkRsn1Cyc"));
		record.setAcctBlkRsn2Cyc(fieldSet.readString("acctBlkRsn2Cyc"));
		record.setAcctInd(fieldSet.readString("acctInd"));
		record.setAcctPrimBlkRsnCde(fieldSet.readString("acctPrimBlkRsnCde"));
		record.setAlopAmnt(readInt(fieldSet,"alopAmnt"));
		record.setAlopCrlimit(readDouble(fieldSet,"alopCrlimit"));
		record.setAnfee (readInt(fieldSet,"anfee"));
		record.setAnr2(readDouble(fieldSet,"anr2"));
		record.setBehscore(fieldSet.readString("behscore"));
		record.setBlock1(fieldSet.readString("block1"));
		record.setBscoreid(fieldSet.readString("bscoreid"));
		record.setBtintr(readInt(fieldSet,"btintr"));
		record.setCiRate(readDouble(fieldSet,"ciRate"));
		record.setClntNbr(fieldSet.readString("clntNbr"));
		record.setClt1(readInt(fieldSet,"clt1"));
		record.setClt2(readDouble(fieldSet,"clt2"));
		record.setCshblnc2(readDouble(fieldSet,"cshblnc2"));
		record.setCshfee(readDouble(fieldSet,"cshfee"));
		record.setCshintr(readDouble(fieldSet,"cshintr"));
		record.setCurrDueAmt(readDouble(fieldSet,"currDueAmt"));
		record.setCurrblnc(readInt(fieldSet,"currblnc"));
		record.setCycle(readInt(fieldSet,"cycle"));
		record.setDatepay(readInt(fieldSet,"datepay"));
		record.setDelqprof(fieldSet.readString("delqprof"));
		record.setDwcpmTotalAmtDue(readInt(fieldSet,"dwcpmTotalAmtDue"));
		record.setEducation(fieldSet.readString("education"));
		record.setEnrLcyamt(readDouble(fieldSet,"enrLcyamt"));
		record.setEppAmnt(readInt(fieldSet,"eppAmnt"));
		record.setGender(fieldSet.readString("gender"));
		record.setIdno(fieldSet.readString("idno"));
		record.setIncome(readInt(fieldSet,"income"));
		record.setLatefee(readDouble(fieldSet,"latefee"));
		record.setLcshamt2(readDouble(fieldSet,"lcshamt2"));
		record.setLcshcnt2(readInt(fieldSet,"lcshcnt2"));
		record.setLcycblnc(readInt(fieldSet,"lcycblnc"));
		record.setLrtlamt2(readDouble(fieldSet,"lrtlamt2"));
		record.setLrtlcnt2(readInt(fieldSet,"lrtlcnt2"));
		record.setMonblnc(readDouble(fieldSet,"monblnc"));
		record.setMue (readInt(fieldSet,"mue"));
		record.setNbalamt2(readInt(fieldSet,"nbalamt2"));
		record.setOcshamt2(readDouble(fieldSet,"ocshamt2"));
		record.setOcshcnt2(readInt(fieldSet,"ocshcnt2"));
		record.setOpenAcct(readInt(fieldSet,"openAcct"));
		record.setOpenCif(readInt(fieldSet,"openCif"));
		record.setOrtlamt2(readDouble(fieldSet,"ortlamt2"));
		record.setOrtlcnt2(readInt(fieldSet,"ortlcnt2"));
		record.setOtherfee(readInt(fieldSet,"otherfee"));
		record.setOvrlmtExclsnInd(fieldSet.readString("ovrlmtExclsnInd"));
		record.setPast30Amt(readInt(fieldSet,"past30Amt"));
		record.setPastDueAmt(readDouble(fieldSet,"pastDueAmt"));
		record.setPayamt1(readInt(fieldSet,"payamt1"));
		record.setPayamt2(readInt(fieldSet,"payamt2"));
		record.setReanr(readInt(fieldSet,"reanr"));
		record.setRiRate(readDouble(fieldSet,"riRate"));
		record.setRtlintr(readDouble(fieldSet,"rtlintr"));
		record.setStatus1(fieldSet.readString("status1"));
		record.setTotAcct(readInt(fieldSet,"totAcct"));
		record.setTte(readInt(fieldSet,"tte"));
		record.setUsercde3(fieldSet.readString("usercde3"));
		record.setGcbcPortfolioId(fieldSet.readString("gcbcPortfolioId"));
		//record.setFinFico(readInt(fieldSet,"finFico"));
		record.setAlignScore(readInt(fieldSet,"alignScore"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ record.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return record;
	}

}
