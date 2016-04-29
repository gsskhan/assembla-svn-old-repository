package com.citi.retail.optima.etl.cache.resultset.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.cache.model.CountryVO;

public class CountryResultSetExtractor implements
ResultSetExtractor<List<CountryVO>> {

	@Override
	public List<CountryVO> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<CountryVO> resultList = new ArrayList<CountryVO>();
		CountryVO country;
		while(rs.next()){
			country = new CountryVO();
			country.setCountryCode(rs.getString("cntry_cd"));
			country.setCountryDescr(rs.getString("cntry_desc"));
			resultList.add(country);
		}
		return resultList;
	}

}
