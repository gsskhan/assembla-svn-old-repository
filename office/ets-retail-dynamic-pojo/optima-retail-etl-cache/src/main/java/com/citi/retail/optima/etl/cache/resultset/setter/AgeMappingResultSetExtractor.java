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
public class AgeMappingResultSetExtractor implements
		ResultSetExtractor<List<SegmentMappingDomain>> {

	@Override
	public List<SegmentMappingDomain> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		List<SegmentMappingDomain> resultList = new ArrayList<SegmentMappingDomain>();
		SegmentMappingDomain segMapping;

		while(rs.next()){
			segMapping = new SegmentMappingDomain();
			segMapping.setBandId(rs.getInt("TRGTBANDID"));
			segMapping.setRefBandId(rs.getInt("SRCBANDID"));
			segMapping.setOutputBandType(rs.getString("SEGTYPE"));
			resultList.add(segMapping);
		}
		return resultList;		
	}

}
