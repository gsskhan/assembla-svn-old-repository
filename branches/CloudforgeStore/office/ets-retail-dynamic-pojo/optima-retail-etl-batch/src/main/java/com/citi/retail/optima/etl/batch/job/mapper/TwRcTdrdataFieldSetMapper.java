package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.TwRcTdrdataRecord;

public class TwRcTdrdataFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper{
	public TwRcTdrdataRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		TwRcTdrdataRecord record = new TwRcTdrdataRecord();
		record.setCrdAcctNbr(fieldSet.readString("crdAcctNbr"));
		//record.setCrdNbr(fieldSet.readString("crdNbr"));
		record.setUpdate(readInt(fieldSet,"update"));
	//	record.setAcctOpenDt(readDate(fieldSet,"acctOpenDt","yyyy-MM-dd"));
		record.setAcctOpenDt(readDate(fieldSet,"acctOpenDt","MM/dd/yyyy"));
		record.setTdrflag(readInt(fieldSet,"tdrflag"));
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
