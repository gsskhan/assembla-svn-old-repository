package com.citi.retail.optima.etl.batch.job.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.citi.retail.optima.etl.common.model.CbFinanceRecord;

public class CbFinanceFieldSetMapper extends AbstractFieldSetMapper implements FieldSetMapper<CbFinanceRecord> {

	@Override
	public CbFinanceRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		
		CbFinanceRecord cbFinanceRecord = new CbFinanceRecord();
		
		cbFinanceRecord.setPortfolioId(fieldSet.readString("portfolioid"));
		cbFinanceRecord.setGoc(fieldSet.readString("goc"));
		cbFinanceRecord.setFrsBu(fieldSet.readString("frsbu"));
		cbFinanceRecord.setCountry(fieldSet.readString("country"));
		cbFinanceRecord.setPortfolioIdDesc(fieldSet.readString("portfolioiddesc"));
		cbFinanceRecord.setPrvlLvid(fieldSet.readString("prlvlvid"));
		cbFinanceRecord.setManSegId(fieldSet.readString("mansegid"));
		cbFinanceRecord.setFrsOu(fieldSet.readString("frsou"));
		
		/**For Logging
		 * 
		 */
		if(getExceptionList().size() > 0) {
		KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR Record: "+ cbFinanceRecord.toString());
			for(Exception e: getExceptionList()) {
				KPILOGGER.error(LoggingMarker.KPI.getMarker(), "ERROR DETAILS: "+e.getMessage());
			}
			getExceptionList().clear();
		}
		return cbFinanceRecord;
	}

}
