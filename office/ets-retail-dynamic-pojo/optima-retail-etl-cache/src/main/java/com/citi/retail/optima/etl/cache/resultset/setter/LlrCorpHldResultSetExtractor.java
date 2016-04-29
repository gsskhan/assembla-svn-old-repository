/**
 * 
 */
package com.citi.retail.optima.etl.cache.resultset.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.common.model.cache.LlrCorpHldDomain;

/**
 * @author TJ
 * 
 */
public class LlrCorpHldResultSetExtractor implements
		ResultSetExtractor<List<LlrCorpHldDomain>> {

	@Override
	public List<LlrCorpHldDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<LlrCorpHldDomain> resultList = new ArrayList<LlrCorpHldDomain>();
		LlrCorpHldDomain llrCorpHld;

		while (rs.next()) {
			llrCorpHld = new LlrCorpHldDomain();
			llrCorpHld.setCorpHoldId(rs.getLong("CORP_HOLD_ID"));
			llrCorpHld.setSrcCorpHoldCd(rs.getString("SRC_DATA_VAL"));
			llrCorpHld.setSysProcId(rs.getLong("SYS_PROC_ID"));
			resultList.add(llrCorpHld);
		}
		return resultList;
	}
}
