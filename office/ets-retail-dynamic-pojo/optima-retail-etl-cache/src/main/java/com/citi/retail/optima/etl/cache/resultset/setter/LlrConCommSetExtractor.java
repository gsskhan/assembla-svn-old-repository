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

import com.citi.retail.optima.etl.common.model.cache.LlrConCommDomain;

/**
 * @author TJ
 * 
 */
public class LlrConCommSetExtractor implements
		ResultSetExtractor<List<LlrConCommDomain>> {

	@Override
	public List<LlrConCommDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<LlrConCommDomain> resultList = new ArrayList<LlrConCommDomain>();
		LlrConCommDomain llrTform;
		while (rs.next()) {
			llrTform = new LlrConCommDomain();
			llrTform.setConsCommSpltId(rs.getLong("CONS_COMM_SPLT_ID"));
			llrTform.setSrcConsCommSplt(rs.getString("SRC_DATA_VAL"));
			llrTform.setTrgtConsCommSplt(rs.getString("TRGT_ATTR_VAL"));
			llrTform.setSysProcId(rs.getLong("SYS_PROC_ID"));
			resultList.add(llrTform);
		}
		return resultList;
	}
}
