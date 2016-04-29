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

import com.citi.retail.optima.etl.common.model.cache.CollateralisedBandDomain;

/**
 * 
 * @author mc56120
 *
 */
public class CollateralisedResultSetExtractor implements
		ResultSetExtractor<List<CollateralisedBandDomain>> {

	@Override
	public List<CollateralisedBandDomain> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<CollateralisedBandDomain> referenceList = new ArrayList<CollateralisedBandDomain>();
		CollateralisedBandDomain collateralizedBand = null;
		
		while (rs.next()){
			collateralizedBand = new CollateralisedBandDomain();
			collateralizedBand.setKeyId(rs.getInt("KEYID"));
			collateralizedBand.setBandDesc(rs.getString("BANDDESC"));
			collateralizedBand.setSegCode(rs.getInt("SEGCODE"));
			collateralizedBand.setSegVal(rs.getString("SEGVAL"));
			collateralizedBand.setSegmentType(rs.getString("SEGTYPE"));
			collateralizedBand.setProcessingUnitId(rs.getInt("PU"));			
			referenceList.add(collateralizedBand);	
		}
		return referenceList;
	}

}
