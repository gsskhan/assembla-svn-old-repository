package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.WriteoffRecord;

public class WoFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {

	@Override
	public WriteoffRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		WriteoffRecord writeoffRecord = new WriteoffRecord();
		writeoffRecord.setCardNumber(fieldSet.readString("accNumber"));
		writeoffRecord.setChargeOffIndicator(readLong(fieldSet, "woP"));
		writeoffRecord.setPrincipleChargeOff(readDouble(fieldSet, "woInd"));
		
		/*writeoffRecord.setCardNumber(fieldSet.readString("cardNumber"));
		writeoffRecord.setChargeOffIndicator(readLong(fieldSet, "chargeOffIndicator"));
		writeoffRecord.setPrincipleChargeOff(readDouble(fieldSet, "principleChargeOff"));*/
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ writeoffRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return writeoffRecord;
	}
}