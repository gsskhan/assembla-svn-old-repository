package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.OreoRecord;

/**
 * @author ps07396
 *
 */
public class OreoFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper{

	@Override
	public OreoRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		OreoRecord oreorecord=new OreoRecord();
		oreorecord.setStatus(fieldSet.readString("status"));
		oreorecord.setAcctnumb(fieldSet.readString("acctnumb"));
		oreorecord.setOrigBookValue(readDouble(fieldSet, "orgbkval"));
		oreorecord.setNetBookValue(readDouble(fieldSet, "netbkval"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ oreorecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return oreorecord;
	}

}
