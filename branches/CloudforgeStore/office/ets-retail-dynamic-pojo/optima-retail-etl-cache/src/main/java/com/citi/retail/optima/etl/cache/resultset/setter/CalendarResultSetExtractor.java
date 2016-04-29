package com.citi.retail.optima.etl.cache.resultset.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.cache.model.CalendarVO;

public class CalendarResultSetExtractor implements
ResultSetExtractor<List<CalendarVO>> {

	@Override
	public List<CalendarVO> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<CalendarVO> resultList = new ArrayList<CalendarVO>();
		while(rs.next()){
			CalendarVO resultVo= new CalendarVO();
			resultVo.setProcessingUnit(rs.getInt("proc_unit_id"));
			resultVo.setFedSchl(rs.getString("fed_scd_id"));
			resultVo.setRptYr(rs.getInt("rpt_yr"));
			resultVo.setRptQtr(rs.getInt("rpt_qtr"));
			resultVo.setReqstDt(rs.getDate("rqst_dt"));
			resultVo.setStartDt(rs.getDate("start_dt"));
			resultVo.setEndDt(rs.getDate("end_dt"));
			resultVo.setAllowedPeriod1(rs.getInt("allw_prd1"));
			resultVo.setAllowedPeriod2(rs.getInt("allw_prd2"));
			resultList.add(resultVo);
		}
		return resultList;
	}

}
