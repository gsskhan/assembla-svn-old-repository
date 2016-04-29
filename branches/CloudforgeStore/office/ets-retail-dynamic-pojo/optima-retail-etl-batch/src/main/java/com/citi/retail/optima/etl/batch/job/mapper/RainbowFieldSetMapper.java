package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.RainbowRecord;

public class RainbowFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {

	@Override
	public RainbowRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		RainbowRecord rainbowRecord = new RainbowRecord();
		rainbowRecord.setNasSrcCde(fieldSet.readString("nasSrcCde"));
		rainbowRecord.setAgntCde(fieldSet.readString("agntCde"));
		rainbowRecord.setCrdBlkCode(fieldSet.readString("crdBlkCode"));
		rainbowRecord.setCrdBlkRsn(fieldSet.readString("crdBlkRsn"));
		rainbowRecord.setCrdBlkCodeDate(readDate(fieldSet,"crdBlkCodeDate"));
		rainbowRecord.setCrdType(fieldSet.readString("crdType"));
		rainbowRecord.setCrdCncldDate(readDate(fieldSet,"crdCncldDate"));
		rainbowRecord.setAcctPrimBlkCode(fieldSet.readString("acctPrimBlkCode"));
		rainbowRecord.setAcctIntrnlStatCode(fieldSet.readString("acctIntrnlStatCode"));
		rainbowRecord.setChrgOffLcyAmt(readDouble(fieldSet,"chrgOffLcyAmt"));
		rainbowRecord.setMonbLnc(readDouble(fieldSet,"monbLnc"));
		rainbowRecord.setClt2(readDouble(fieldSet,"clt2"));
		rainbowRecord.setNbrOfSupCrds(readInt(fieldSet,"nbrOfSupCrds"));
		rainbowRecord.setPayAmt2(readDouble(fieldSet,"payAmt2"));
		rainbowRecord.setLrtlAmt2(readDouble(fieldSet,"lrtlAmt2"));
		rainbowRecord.setOrtlAmt2(readDouble(fieldSet,"ortlAmt2"));
		rainbowRecord.setLcshAmt2(readDouble(fieldSet,"lcshAmt2"));
		rainbowRecord.setOcshAmt2(readDouble(fieldSet,"ocshAmt2"));
		rainbowRecord.setLrtlCnt2(readInt(fieldSet,"lrtlCnt2"));
		rainbowRecord.setOrtlCnt2(readInt(fieldSet,"ortlCnt2"));
		rainbowRecord.setLcshCnt2(readInt(fieldSet,"lcshCnt2"));
		rainbowRecord.setOcshCnt2(readInt(fieldSet,"ocshCnt2"));
		rainbowRecord.setAnr2(readDouble(fieldSet,"anr2"));
		rainbowRecord.setAcctRiskLvl(fieldSet.readString("acctRiskLvl"));
		rainbowRecord.setAlopAmnt(readDouble(fieldSet,"alopAmnt"));
		rainbowRecord.setAlopCrLimit(readDouble(fieldSet,"alopCrLimit"));
		rainbowRecord.setDirectDrIndicator(fieldSet.readString("directDrIndicator"));
		rainbowRecord.setCrlmRelmLcyAmt(readDouble(fieldSet,"crlmRelmLcyAmt"));
		rainbowRecord.setCshBlnc2(readDouble(fieldSet,"cshBlnc2"));
		rainbowRecord.setEnrLcyAmt(readDouble(fieldSet,"enrLcyAmt"));
		rainbowRecord.setCurrDueAmt(readDouble(fieldSet,"currDueAmt"));
		rainbowRecord.setDelqStr(fieldSet.readString("delqStr"));
		rainbowRecord.setBehScore(fieldSet.readString("behScore"));
		rainbowRecord.setbScoreid(fieldSet.readString("bScoreid"));
		rainbowRecord.setBlock1(fieldSet.readString("block1"));
		rainbowRecord.setPastDueAmt(readDouble(fieldSet,"pastDueAmt"));
		rainbowRecord.setCycle(readInt(fieldSet,"cycle"));
		rainbowRecord.setAcctPrimBlkDate(readDate(fieldSet,"acctPrimBlkDate"));
		rainbowRecord.setClntNbr(fieldSet.readString("clntNbr"));
		rainbowRecord.setAcctOpenDate(readDate(fieldSet,"acctOpenDate"));
		rainbowRecord.setCclIndicator(fieldSet.readString("cclIndicator"));
		rainbowRecord.setDatePay(readDate(fieldSet,"datePay"));
		rainbowRecord.setLateFee(readDouble(fieldSet,"lateFee"));
		rainbowRecord.setAnfee(readDouble(fieldSet,"anfee"));
		rainbowRecord.setCshFee(readDouble(fieldSet,"cshFee"));
		rainbowRecord.setRiRate(readDouble(fieldSet,"riRate"));
		rainbowRecord.setCiRate(readDouble(fieldSet,"ciRate"));
		rainbowRecord.setCashIBnp(readDouble(fieldSet,"cashIBnp"));
		rainbowRecord.setCashSvcBnp(readDouble(fieldSet,"cashSvcBnp"));
		rainbowRecord.setRtlMemberBnp(readDouble(fieldSet,"rtlMemberBnp"));
		rainbowRecord.setRtlIBnp(readDouble(fieldSet,"rtlIBnp"));
		rainbowRecord.setRtlInsurBnp(readDouble(fieldSet,"rtlInsurBnp"));
		rainbowRecord.setRtlMiscBnp(readDouble(fieldSet,"rtlMiscBnp"));
		rainbowRecord.setRtlSvcBnp(readDouble(fieldSet,"rtlSvcBnp"));
		rainbowRecord.setDelqProf(fieldSet.readString("delqProf"));
		rainbowRecord.setRtlIntr(readDouble(fieldSet,"rtlIntr"));
		rainbowRecord.setCshIntr(readDouble(fieldSet,"cshIntr"));
		rainbowRecord.setCrdAcctNumber(fieldSet.readString("crdAcctNumber"));
		rainbowRecord.setGcbcPortfolioId(fieldSet.readString("gcbcPortfolioId"));
		/*rainbowRecord.setFinFico(readInt(fieldSet, "finfico"));*/
		rainbowRecord.setAlignScore(fieldSet.readString("alignScore"));
	//	rainbowRecord.setAlignScore(fieldSet.readString("CRD_NBR"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ rainbowRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return rainbowRecord;
	}
}