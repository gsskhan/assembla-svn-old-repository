package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.FicoRecord;
import com.citi.retail.optima.etl.common.model.TdrRecord;

public class TdrFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {

	@Override
	public TdrRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		TdrRecord tdrRecord = new TdrRecord();
		tdrRecord.setCardNumber(fieldSet.readString("cardNumber"));
		tdrRecord.setTdrFlag(fieldSet.readString("tdrFlag"));
		tdrRecord.setUpdatedDate(readDate(fieldSet, "updatedDate"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ tdrRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return tdrRecord;
	}
}