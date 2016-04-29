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

import com.citi.retail.optima.etl.cache.model.GeographyFedSegVO;

/**
 * @author mc56120
 *
 */
public class GeographyFedSegResultSetExtractor implements 
ResultSetExtractor<List<GeographyFedSegVO>> {
	@Override
	public List<GeographyFedSegVO> extractData(ResultSet rs) throws SQLException,
	DataAccessException {
		List<GeographyFedSegVO> resultList = new ArrayList<GeographyFedSegVO>();
		GeographyFedSegVO countryGeographyMapVO;
		while(rs.next()){
			countryGeographyMapVO = new GeographyFedSegVO();
			countryGeographyMapVO.setGeographyBandId(rs.getInt("GEO_BND_ID"));
			countryGeographyMapVO.setGeographyId(rs.getInt("RGN_ID"));
			countryGeographyMapVO.setProcessingUnitId(rs.getInt("PROC_UNIT_ID"));
			countryGeographyMapVO.setGeographyFedSeg(rs.getString("GEO_BND_CD"));
			countryGeographyMapVO.setGeographyBndDescr(rs.getString("GEO_BND_DESC"));
			resultList.add(countryGeographyMapVO);
		}
		return resultList;		
	}


}
