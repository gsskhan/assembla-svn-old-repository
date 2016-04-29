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

import com.citi.retail.optima.etl.common.model.cache.SourceCountryDomain;

/**
 * @author TJ
 * 
 */
public class SourceCountrySetExtractor implements
		ResultSetExtractor<List<SourceCountryDomain>> {

	@Override
	public List<SourceCountryDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<SourceCountryDomain> resultList = new ArrayList<SourceCountryDomain>();
		SourceCountryDomain countryDomain;
		while (rs.next()) {
			countryDomain = new SourceCountryDomain();
			countryDomain.setTrgtCntryCd(rs.getString("TRGT_CNTRY_VAL"));
			countryDomain.setSrcCntryCd(rs.getString("SRC_CNTRY_VAL"));
			countryDomain.setTrgtAttribute(rs.getString("TRGT_ATTR"));
			countryDomain.setSourceSysId(rs.getLong("SYS_PROC_ID"));
			resultList.add(countryDomain);
		}
		return resultList;
	}
}
