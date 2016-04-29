package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;



import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.FxRateRecord;

public class FxRateFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper<FxRateRecord> {

	@Override
	public FxRateRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		
		FxRateRecord fxRateRecord = new FxRateRecord();
		
		fxRateRecord.setUnit(fieldSet.readString("Unit"));
		fxRateRecord.setScenario(fieldSet.readString("Scenario"));
		fxRateRecord.setYear(readInt(fieldSet,"Year"));
		fxRateRecord.setPeriod(readInt(fieldSet,"Period"));
		fxRateRecord.setLedgerUnit(readInt(fieldSet,"LedgerUnit"));
		fxRateRecord.setCurrency(fieldSet.readString("Currency"));
		fxRateRecord.setCitiSource(fieldSet.readString("CitiSource"));
		fxRateRecord.setDataClass(fieldSet.readString("DataClass"));
		fxRateRecord.setAcct(fieldSet.readString("Acct"));
		fxRateRecord.setRate(readDouble (fieldSet,"Rate"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ fxRateRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return fxRateRecord;
	}
}