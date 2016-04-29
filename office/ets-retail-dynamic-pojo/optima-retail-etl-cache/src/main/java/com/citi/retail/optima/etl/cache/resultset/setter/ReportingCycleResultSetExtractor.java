package com.citi.retail.optima.etl.cache.resultset.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.common.model.cache.ReportCycleDomain;

public class ReportingCycleResultSetExtractor implements
		ResultSetExtractor<List<ReportCycleDomain>> {

	@Override
	public List<ReportCycleDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		List<ReportCycleDomain> resultList = new ArrayList<ReportCycleDomain>();
		while (rs.next()) {
			ReportCycleDomain resultVo = new ReportCycleDomain();

			resultVo.setRptCycId(rs.getLong("rprt_cyc_id"));
			resultVo.setRptCycQtr(rs.getString("rprt_cyc_qtr"));
			resultVo.setRptCycNm(rs.getString("rprt_cyc_nm"));
			resultVo.setRptCycYr(rs.getString("rprt_cyc_yr"));
			resultList.add(resultVo);
		}
		return resultList;
	}

}
