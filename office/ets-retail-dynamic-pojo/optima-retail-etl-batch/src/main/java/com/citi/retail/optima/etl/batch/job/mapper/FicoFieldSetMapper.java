package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.FicoRecord;

public class FicoFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {

	@Override
	public FicoRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		FicoRecord ficoRecord = new FicoRecord();
		ficoRecord.setCardNumber(fieldSet.readString("cardNumber"));
		ficoRecord.setAlignScore(readInt(fieldSet,"alignScore"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ ficoRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return ficoRecord;
	}
}