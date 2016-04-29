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

import com.citi.retail.optima.etl.common.model.cache.SourceRegionDomain;

/**
 * @author TJ
 * 
 */
public class SourceRegionSetExtractor implements
		ResultSetExtractor<List<SourceRegionDomain>> {

	@Override
	public List<SourceRegionDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<SourceRegionDomain> resultList = new ArrayList<SourceRegionDomain>();
		SourceRegionDomain regionDomain;
		while (rs.next()) {
			regionDomain = new SourceRegionDomain();

			regionDomain.setRgnId(rs.getLong("rgn_id"));
			regionDomain.setSourceDataVal(rs.getString("src_data_val"));
			regionDomain.setTrgtAttribute(rs.getString("TRGT_ATTR"));
			regionDomain.setRgnNm(rs.getString("rgn_nm"));
			regionDomain.setTrgtAttributeVal(rs.getString("TRGT_ATTR_VAL"));
			regionDomain.setSysProcId(rs.getLong("SYS_PROC_ID"));
			resultList.add(regionDomain);
		}
		return resultList;
	}
}
