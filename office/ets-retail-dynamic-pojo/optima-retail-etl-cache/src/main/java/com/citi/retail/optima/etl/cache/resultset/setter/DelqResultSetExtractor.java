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

import com.citi.retail.optima.etl.common.model.cache.DelqBandDomain;

/**
 * @author TJ
 * 
 */
public class DelqResultSetExtractor implements
		ResultSetExtractor<List<DelqBandDomain>> {

	@Override
	public List<DelqBandDomain> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<DelqBandDomain> resultList = new ArrayList<DelqBandDomain>();
		DelqBandDomain delqBand;
		while(rs.next()){
			delqBand = new DelqBandDomain();
			delqBand.setKeyId(rs.getInt("KEYID"));
			delqBand.setBandDesc(rs.getString("BANDDESC"));
			delqBand.setLowerBand(rs.getInt("LOWERBAND"));
			delqBand.setUpperBand(rs.getInt("UPPERBAND"));
			delqBand.setSegCode(rs.getInt("SEGCODE"));
			delqBand.setSegVal(rs.getString("SEGVAL"));
			delqBand.setSegmentType(rs.getString("SEGTYPE"));
			delqBand.setProcessingUnitId(rs.getInt("PU"));
			resultList.add(delqBand);
		}
		return resultList;
	}
}
