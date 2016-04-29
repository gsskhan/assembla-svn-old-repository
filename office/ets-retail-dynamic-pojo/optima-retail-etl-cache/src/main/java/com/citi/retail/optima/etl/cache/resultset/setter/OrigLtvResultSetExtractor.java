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

import com.citi.retail.optima.etl.common.model.cache.OrigLtvBandDomain;

/**
 * 
 * @author mc56120
 *
 */
public class OrigLtvResultSetExtractor implements
		ResultSetExtractor<List<OrigLtvBandDomain>> {

	@Override
	public List<OrigLtvBandDomain> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<OrigLtvBandDomain> resultList = new ArrayList<OrigLtvBandDomain>();
		OrigLtvBandDomain origLtvBand;
		while(rs.next()){
			origLtvBand = new OrigLtvBandDomain();
			origLtvBand.setKeyId(rs.getInt("KEYID"));
			origLtvBand.setBandDesc(rs.getString("BANDDESC"));
			origLtvBand.setLowerBand(rs.getInt("LOWERBAND"));
			origLtvBand.setUpperBand(rs.getInt("UPPERBAND"));
			origLtvBand.setSegCode(rs.getInt("SEGCODE"));
			origLtvBand.setSegVal(rs.getString("SEGVAL"));
			origLtvBand.setSegmentType(rs.getString("SEGTYPE"));
			origLtvBand.setProcessingUnitId(rs.getInt("PU"));
			resultList.add(origLtvBand);
		}
		return resultList;		
	}

}
