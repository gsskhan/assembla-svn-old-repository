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

import com.citi.retail.optima.etl.common.model.cache.FicoBandDomain;

/**
 * @author TJ
 * 
 */
public class FicoResultSetExtractor implements
		ResultSetExtractor<List<FicoBandDomain>> {

	@Override
	public List<FicoBandDomain> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<FicoBandDomain> resultList = new ArrayList<FicoBandDomain>();
		FicoBandDomain ficoBand;

		while(rs.next()){
			ficoBand = new FicoBandDomain();
			ficoBand.setKeyId(rs.getInt("KEYID"));
			ficoBand.setBandDesc(rs.getString("BANDDESC"));
			ficoBand.setLowerBand(rs.getInt("LOWERBAND"));
			ficoBand.setUpperBand(rs.getInt("UPPERBAND"));
			ficoBand.setSegCode(rs.getInt("SEGCODE"));
			ficoBand.setSegVal(rs.getString("SEGVAL"));
			ficoBand.setSegmentType(rs.getString("SEGTYPE"));
			ficoBand.setProcessingUnitId(rs.getInt("PU"));
			resultList.add(ficoBand);
		}
		return resultList;		
	}
}
