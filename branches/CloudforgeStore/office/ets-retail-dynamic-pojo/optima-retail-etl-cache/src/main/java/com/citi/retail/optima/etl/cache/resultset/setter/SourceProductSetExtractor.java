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

import com.citi.retail.optima.etl.common.model.cache.SourceProductDomain;

/**
 * @author TJ
 * 
 */
public class SourceProductSetExtractor implements
		ResultSetExtractor<List<SourceProductDomain>> {

	@Override
	public List<SourceProductDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<SourceProductDomain> resultList = new ArrayList<SourceProductDomain>();
		SourceProductDomain prodDomain;
		while (rs.next()) {
			prodDomain = new SourceProductDomain();
			prodDomain.setProdTypId(rs.getLong("prod_typ_id"));
			prodDomain.setSrcProd1(rs.getString("src_prod1"));
			prodDomain.setSrcProd2(rs.getString("src_prod2"));
			prodDomain.setSrcProd3(rs.getString("src_prod3"));

			resultList.add(prodDomain);
		}
		return resultList;
	}
}
