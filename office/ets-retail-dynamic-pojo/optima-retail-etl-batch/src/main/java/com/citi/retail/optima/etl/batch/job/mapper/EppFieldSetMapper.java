package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.EppRecord;
import com.citi.retail.optima.etl.common.model.FicoRecord;

public class EppFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {

	@Override
	public EppRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		EppRecord eppRecord = new EppRecord();
		eppRecord.setCardNumber(fieldSet.readString("cardNumber"));
		eppRecord.setBalance(readDouble(fieldSet, "balance"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ eppRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
					}
		return eppRecord;
	}
}