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

import com.citi.retail.optima.etl.common.model.cache.LlrTFormDomain;

/**
 * @author TJ
 * 
 */
public class LlrTFormResultSetExtractor implements
		ResultSetExtractor<List<LlrTFormDomain>> {

	@Override
	public List<LlrTFormDomain> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<LlrTFormDomain> resultList = new ArrayList<LlrTFormDomain>();
		LlrTFormDomain llrTform;

		while (rs.next()) {
			llrTform = new LlrTFormDomain();
			llrTform.setSrcSysId(rs.getLong("SYS_PROC_ID"));
			llrTform.setSrcDataVal(rs.getString("SRC_DATA_VAL"));
			llrTform.setTrgtAttr(rs.getString("TRGT_ATTR"));
			llrTform.setTrgtAttrVal(rs.getString("TRGT_ATTR_VAL"));
			llrTform.setEffSts(rs.getString("EFF_STS"));
			llrTform.setEffDt(rs.getDate("EFF_DT"));
			llrTform.setEndDt(rs.getDate("END_DT"));
			resultList.add(llrTform);
		}
		return resultList;
	}
}
