package com.citi.retail.optima.etl.cache.resultset.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.cache.model.ReportingPeriodVO;

public class ReportingPeriodResultSetExtractor implements
ResultSetExtractor<List<ReportingPeriodVO>> {

	@Override
	public List<ReportingPeriodVO> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<ReportingPeriodVO> resultList = new ArrayList<ReportingPeriodVO>();
		while(rs.next()){
			ReportingPeriodVO resultVo= new ReportingPeriodVO();
			resultVo.setRptPrd(rs.getInt("RPT_PRD"));
			resultVo.setRptMonth(rs.getInt("RPT_MO"));
			resultVo.setRptQtr(rs.getInt("RPT_QTR"));
			resultVo.setRptYr(rs.getInt("RPT_YR"));
			resultList.add(resultVo);
		}
		return resultList;
	}

}
