package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.MemoRecord;

/**
 * @author ps07396
 *
 */
public class MemoFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper<MemoRecord>{

	@Override
	public MemoRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		
		MemoRecord memorecord=new MemoRecord();
		memorecord.setGcbcPortfolioId(fieldSet.readString("gcbc_portfolio_id"));
		memorecord.setAcctnumb(fieldSet.readString("acctnumb"));
		memorecord.setGlgwo(readDouble(fieldSet,"glgwo"));
		memorecord.setGlrec(readDouble(fieldSet,"glrec"));
		memorecord.setBankruptcy(readDouble(fieldSet,"bankruptcy"));
		memorecord.setOrgLtv(readDouble(fieldSet, "orgLtv"));
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ memorecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
			KPILOGGER.error(LoggingMarker.KPI.getMarker(), "\n");
		}
		return memorecord;
	}

}
