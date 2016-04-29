/**
 * 
 */
package com.citi.retail.optima.etl.cache.dao.impl;
        

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.CountryGeographyMapVO;
import com.citi.retail.optima.etl.cache.model.GeographyVO;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author mc56120
 *
 */
public class GeographyCacheDaoImpl implements CacheLoaderDao<GeographyVO>,InitializingBean { 

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(GeographyCacheDaoImpl.class);
	protected String sql;
	protected JdbcTemplate jdbcTemplate;
	private List<GeographyVO> resultList;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		resultList=getCacheData();
	}

	@Override
	public List<GeographyVO> getCacheData(Object... args) throws Exception {
		return this.resultList;
	}
	/**
	 * 
	 * @return
	 * @throws OptimaRetailException
	 */
	public List<GeographyVO> getCacheData()  throws OptimaRetailApplicationException {

		Set<Entry<Integer, GeographyVO>> mapEntrySet;
		List<GeographyVO> result = new ArrayList<GeographyVO>();
		try {
			result = jdbcTemplate
					.query(sql,
							new ResultSetExtractor<List<GeographyVO>>() {
						@SuppressWarnings("unchecked")
						@Override
						public List<GeographyVO> extractData(
								ResultSet rs) throws SQLException {
							List<GeographyVO> tempList= new ArrayList<GeographyVO>();
							GeographyVO geogVo=null;
							while (rs.next()) {
								geogVo=new GeographyVO();
								geogVo.setGeographyId(rs.getInt("RGN_ID"));
								geogVo.setGeographyCd(rs.getInt("RGN_CD"));
								geogVo.setGeographyName(rs.getString("RGN_NM"));
								geogVo.setGeographyDesc(rs.getString("RGN_DESC"));
								geogVo.setProcUnitId(rs.getInt("PROC_UNIT_ID"));
								tempList.add(geogVo);
							}
							return tempList;
						}
					});

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading Geography cache "
					+ e);
			throw new OptimaRetailApplicationException(
					null,
					null,
					null,
					ServiceName.CACHE,
					ExceptionType.ERROR,
					"Exception occured while loading Geography cache",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return result;
	}

	/**
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}


}
