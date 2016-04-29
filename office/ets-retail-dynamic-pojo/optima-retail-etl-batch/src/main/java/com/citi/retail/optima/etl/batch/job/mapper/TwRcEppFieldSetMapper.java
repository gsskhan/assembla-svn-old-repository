package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.TwRcEppRecord;

public class TwRcEppFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {

	public TwRcEppRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		TwRcEppRecord record = new TwRcEppRecord();		
		record.setCrdAcctNbr(fieldSet.readString("crdAcctNbr"));
		record.setBalance(readDouble(fieldSet,"balance"));
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
