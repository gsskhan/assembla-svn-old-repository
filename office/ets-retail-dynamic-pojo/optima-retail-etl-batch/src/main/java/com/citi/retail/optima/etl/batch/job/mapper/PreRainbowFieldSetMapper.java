package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.PreRainbowRecord;

public class PreRainbowFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper<PreRainbowRecord> {

	@Override
	public PreRainbowRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		PreRainbowRecord preRainbowRecord = new PreRainbowRecord();
		preRainbowRecord.setAchind(fieldSet.readString("achind"));
		preRainbowRecord.setAlopCrLimit(readDouble(fieldSet,"alopCrLimit"));
		preRainbowRecord.setAnfee(readDouble(fieldSet,"anfee"));
		preRainbowRecord.setAnr2(readDouble(fieldSet,"anr2"));
		preRainbowRecord.setAvailclt(readInt(fieldSet,"availclt"));
		preRainbowRecord.setBehScore(readInt(fieldSet,"behScore"));
		preRainbowRecord.setBlock2(fieldSet.readString("block2"));
		preRainbowRecord.setbScoreid(readInt(fieldSet,"bScoreid"));
		preRainbowRecord.setCardNmbr(fieldSet.readString("cardNmbr"));
		preRainbowRecord.setCardType(fieldSet.readString("cardType"));
		preRainbowRecord.setCashAccrIntr(readDouble(fieldSet,"cashAccrIntr"));
		preRainbowRecord.setCiRate(readDouble(fieldSet,"ciRate"));
		preRainbowRecord.setClt2(readDouble(fieldSet,"clt2"));
		preRainbowRecord.setCshFee(readDouble(fieldSet,"cshFee"));
		preRainbowRecord.setCshIntr(readDouble(fieldSet,"cshIntr"));
		preRainbowRecord.setCustId(fieldSet.readString("custId"));
		preRainbowRecord.setCycle(readInt(fieldSet,"cycle"));
		preRainbowRecord.setDateBlk2(readDate(fieldSet,"dateBlk2"));
		preRainbowRecord.setDateClt2(readDate(fieldSet,"dateClt2"));
		preRainbowRecord.setDateCncl(readDate(fieldSet,"dateCncl"));
		preRainbowRecord.setDatecsh(readDate(fieldSet,"datecsh"));
		preRainbowRecord.setDateExp1(readDate(fieldSet,"dateExp1"));
		preRainbowRecord.setDateOpen(readDate(fieldSet,"dateOpen"));
		preRainbowRecord.setDatePay(readDate(fieldSet,"datePay"));
		preRainbowRecord.setDateRtl(readDate(fieldSet,"dateRtl"));
		preRainbowRecord.setDateSt2(readDate(fieldSet,"dateSt2"));
		preRainbowRecord.setDateTmpf(readDate(fieldSet,"dateTmpf"));
		preRainbowRecord.setDateTmpt(readDate(fieldSet,"dateTmpt"));
		preRainbowRecord.setDatLclt2(readDate(fieldSet,"datLclt2"));
		preRainbowRecord.setDcnt1(readInt(fieldSet,"dcnt1"));
		preRainbowRecord.setDelqProf(fieldSet.readString("delqProf"));
		preRainbowRecord.setDueDateGrp(readInt(fieldSet,"dueDateGrp"));
		preRainbowRecord.setIntrst(readDouble(fieldSet,"intrst"));
		preRainbowRecord.setLateFee(readDouble(fieldSet,"lateFee"));
		preRainbowRecord.setLclt2(readDouble(fieldSet,"lclt2"));
		preRainbowRecord.setLcshAmt2(readDouble(fieldSet,"lcshAmt2"));
		preRainbowRecord.setLcshCnt2(readInt(fieldSet,"lcshCnt2"));
		preRainbowRecord.setLrtlAmt2(readDouble(fieldSet,"lrtlAmt2"));
		preRainbowRecord.setLrtlCnt2(readInt(fieldSet,"lrtlCnt2"));
		preRainbowRecord.setMdue(readDouble(fieldSet,"mdue"));
		preRainbowRecord.setMonbLnc(readDouble(fieldSet,"monbLnc"));
		preRainbowRecord.setOcsha(readDouble(fieldSet,"ocsha"));
		preRainbowRecord.setOcshCnt2(readInt(fieldSet,"ocshCnt2"));
		preRainbowRecord.setOrtlAmt2(readDouble(fieldSet,"ortlAmt2"));
		preRainbowRecord.setOrtlCnt2(readInt(fieldSet,"ortlCnt2"));
		preRainbowRecord.setPayAmt2(readDouble(fieldSet,"payAmt2"));
		preRainbowRecord.setRageReq1(readInt(fieldSet,"rageReq1"));
		preRainbowRecord.setReageDate1(readDate(fieldSet,"reageDate1"));
		preRainbowRecord.setRiRate(readDouble(fieldSet,"riRate"));
		preRainbowRecord.setRiskLevl(fieldSet.readString("riskLevl"));
		preRainbowRecord.setRtlAccrIntr(readDouble(fieldSet,"rtlAccrIntr"));
		preRainbowRecord.setRtlIntr(readDouble(fieldSet,"rtlIntr"));
		preRainbowRecord.setStatus2(fieldSet.readString("status2"));
		preRainbowRecord.setTotAmtDue(readDouble(fieldSet,"totAmtDue"));
		preRainbowRecord.setWoIntr(readDouble(fieldSet,"woIntr"));
		preRainbowRecord.setWoPrn(readDouble(fieldSet,"woPrn"));
		preRainbowRecord.setEppAmnt(readDouble(fieldSet,"EPP_AMNT"));
		preRainbowRecord.setOtherFee(readDouble(fieldSet, "OTHERFEE"));
		preRainbowRecord.setGcbcPortfolioId(fieldSet.readString("gcbcPortfolioId"));
		//preRainbowRecord.setFinFico(readInt(fieldSet, "finfico"));
		preRainbowRecord.setAlignScore(fieldSet.readString("alignScore"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ preRainbowRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return preRainbowRecord;
	}

}
