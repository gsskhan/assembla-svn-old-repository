package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.RecvRecord;

public class RecvFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper {

	@Override
	public RecvRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		RecvRecord recvRecord = new RecvRecord();
		/*recvRecord.setCardNumber(fieldSet.readString("cardNumber"));*/
		recvRecord.setAccNumber(fieldSet.readString("accNumber"));
		recvRecord.setNewrc_p(readDouble(fieldSet,"newrc_p"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ recvRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return recvRecord;
	}
}