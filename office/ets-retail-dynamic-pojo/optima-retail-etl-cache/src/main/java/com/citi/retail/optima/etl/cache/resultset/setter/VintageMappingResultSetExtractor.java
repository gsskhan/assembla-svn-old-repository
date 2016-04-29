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

import com.citi.retail.optima.etl.common.model.cache.SegmentMappingDomain;


/**
 * 
 * @author mc56120
 *
 */
public class VintageMappingResultSetExtractor implements
		ResultSetExtractor<List<SegmentMappingDomain>> {

	@Override
	public List<SegmentMappingDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		List<SegmentMappingDomain> referenceList = new ArrayList<SegmentMappingDomain>();
		SegmentMappingDomain vintageBandMap;
		while(rs.next()){
			vintageBandMap = new SegmentMappingDomain();
			
			vintageBandMap.setBandId(rs.getInt("TRGTBANDID"));
			vintageBandMap.setRefBandId(rs.getInt("SRCBANDID"));
			vintageBandMap.setOutputBandType(rs.getString("SEGTYPE"));		
			referenceList.add(vintageBandMap);
		}
		
		return referenceList;
	}

}
