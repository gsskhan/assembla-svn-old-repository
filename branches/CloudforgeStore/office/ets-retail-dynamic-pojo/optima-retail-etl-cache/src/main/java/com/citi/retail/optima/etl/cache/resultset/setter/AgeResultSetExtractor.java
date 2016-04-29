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

import com.citi.retail.optima.etl.common.model.cache.AgeBandDomain;

/**
 * 
 * @author mc56120
 *
 */
public class AgeResultSetExtractor implements
		ResultSetExtractor<List<AgeBandDomain>> {

	@Override
	public List<AgeBandDomain> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<AgeBandDomain> resultList = new ArrayList<AgeBandDomain>();
		AgeBandDomain ageBand;
		while(rs.next()){
			ageBand = new AgeBandDomain();
			ageBand.setKeyId(rs.getInt("KEYID"));
			ageBand.setBandDesc(rs.getString("BANDDESC"));
			ageBand.setLowerBand(rs.getInt("LOWERBAND"));
			ageBand.setUpperBand(rs.getInt("UPPERBAND"));
			ageBand.setSegCode(rs.getInt("SEGCODE"));
			ageBand.setSegVal(rs.getString("SEGVAL"));
			ageBand.setSegmentType(rs.getString("SEGTYPE"));
			ageBand.setProcessingUnitId(rs.getInt("PU"));
			resultList.add(ageBand);
		}
		return resultList;		
	}

}
