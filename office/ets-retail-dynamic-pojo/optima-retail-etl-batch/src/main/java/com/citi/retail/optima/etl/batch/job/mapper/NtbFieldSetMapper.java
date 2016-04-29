package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.FicoRecord;
import com.citi.retail.optima.etl.common.model.NtbRecord;

public class NtbFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {

	@Override
	public NtbRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		NtbRecord ntbRecord = new NtbRecord();
		ntbRecord.setCardNumber(fieldSet.readString("cardNumber"));
		ntbRecord.setClmt(readLong(fieldSet,"clmt"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ ntbRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return ntbRecord;
	}
}