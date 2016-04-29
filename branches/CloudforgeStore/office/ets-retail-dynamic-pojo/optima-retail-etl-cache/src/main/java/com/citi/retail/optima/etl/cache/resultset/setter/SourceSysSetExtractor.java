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

import com.citi.retail.optima.etl.common.model.cache.SourceSystemDomain;

/**
 * @author TJ
 * 
 */
public class SourceSysSetExtractor implements
		ResultSetExtractor<List<SourceSystemDomain>> {

	@Override
	public List<SourceSystemDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<SourceSystemDomain> resultList = new ArrayList<SourceSystemDomain>();
		SourceSystemDomain srcSysDomain;
		while (rs.next()) {
			srcSysDomain = new SourceSystemDomain();
			srcSysDomain.setSrcSysId(rs.getLong("src_sys_id"));
			srcSysDomain.setSrcSystemName(rs.getString("src_sys_nm"));

			resultList.add(srcSysDomain);
		}
		return resultList;
	}
}
