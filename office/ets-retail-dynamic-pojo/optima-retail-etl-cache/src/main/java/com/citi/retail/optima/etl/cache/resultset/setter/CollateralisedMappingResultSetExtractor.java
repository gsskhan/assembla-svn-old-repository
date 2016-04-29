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
public class CollateralisedMappingResultSetExtractor implements
		ResultSetExtractor<List<SegmentMappingDomain>> {

	@Override
	public List<SegmentMappingDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		List<SegmentMappingDomain> referenceList = new ArrayList<SegmentMappingDomain>();
		SegmentMappingDomain collateralizedBandMap;
		while(rs.next()){
			collateralizedBandMap = new SegmentMappingDomain();
			
			collateralizedBandMap.setBandId(rs.getInt("TRGTBANDID"));
			collateralizedBandMap.setRefBandId(rs.getInt("SRCBANDID"));
			collateralizedBandMap.setOutputBandType(rs.getString("SEGTYPE"));		
			referenceList.add(collateralizedBandMap);
		}
		
		return referenceList;
	}

}
