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
import com.citi.retail.optima.etl.cache.model.CountryGeographyMapVO;

/**
 * @author mc56120
 *
 */
public class CountryGeographyMapResultSetExtractor implements
ResultSetExtractor<List<CountryGeographyMapVO>> {

	@Override
	public List<CountryGeographyMapVO> extractData(ResultSet rs) throws SQLException,
	DataAccessException {
		List<CountryGeographyMapVO> resultList = new ArrayList<CountryGeographyMapVO>();
		CountryGeographyMapVO countryGeographyMapVO;
		while(rs.next()){
			countryGeographyMapVO = new CountryGeographyMapVO();
			countryGeographyMapVO.setProcessingUnit(rs.getInt("PROC_UNIT_ID"));
			countryGeographyMapVO.setCountryCd(rs.getString("CNTRY_CD"));
			countryGeographyMapVO.setGeographyId(rs.getInt("GEOGRAPHY_ID"));
			countryGeographyMapVO.setGeographyCd(rs.getInt("GEOGRAPHY_CD"));
			countryGeographyMapVO.setGeographyName(rs.getString("GEOGRAPHY_NAME"));
			countryGeographyMapVO.setGeographyDesc(rs.getString("GEOGRAPHY_DESC"));
			resultList.add(countryGeographyMapVO);
		}
		return resultList;		
	}

}
