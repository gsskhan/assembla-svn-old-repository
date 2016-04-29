package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.TwRcFicoRecord;

public class TwRcFicoFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {
	
	public TwRcFicoRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		TwRcFicoRecord record = new TwRcFicoRecord();
		record.setCrdAcctNbr(fieldSet.readString("crdAcctNbr"));
		record.setAignscore(readInt(fieldSet,"aignscore"));
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
