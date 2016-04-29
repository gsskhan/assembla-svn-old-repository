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
import com.citi.retail.optima.etl.common.model.cache.VintageBandDomain;

/**
 * 
 * @author sv16441
 *
 */
public class VintageResultSetExtractor implements
		ResultSetExtractor<List<VintageBandDomain>> {

	@Override
	public List<VintageBandDomain> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<VintageBandDomain> referenceList = new ArrayList<VintageBandDomain>();
		VintageBandDomain vintageBand = null;
		
		while (rs.next()){
			vintageBand = new VintageBandDomain();
			vintageBand.setKeyId(rs.getInt("KEYID"));
			vintageBand.setBandDesc(rs.getString("BANDDESC"));
			vintageBand.setSegCode(rs.getInt("SEGCODE"));
			vintageBand.setSegVal(rs.getString("SEGVAL"));
			vintageBand.setSegmentType(rs.getString("SEGTYPE"));
			vintageBand.setProcessingUnitId(rs.getInt("PU"));			
			referenceList.add(vintageBand);	
		}
		return referenceList;
	}

}
