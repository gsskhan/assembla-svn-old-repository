package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.PDRangeVo;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author sr67841 This is the DAO class that loads the FICO from reference
 *         tables
 * 
 */
public class PDRangeDaoImpl implements CacheLoaderDao<PDRangeVo>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(PDRangeDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<PDRangeVo> pdRangeList;

	private String sql;

	public List<PDRangeVo> getFicoDetails() throws OptimaRetailApplicationException {

		pdRangeList = new ArrayList<PDRangeVo>();
		try {
			pdRangeList = mockRangeVOList();

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading PDRange " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading PDRange", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return pdRangeList;
	}

	@Override
	public List<PDRangeVo> getCacheData(Object... args) throws Exception {
		return pdRangeList;
	}

	/**
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param sQL
	 *            the sQL to set
	 */
	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		getFicoDetails();

	}

	private List<PDRangeVo> mockRangeVOList() {

		List<PDRangeVo> rangeList = new ArrayList<PDRangeVo>();
		PDRangeVo rangeVO;

		for (int i = 0; i < 10; i++) {
			rangeVO = new PDRangeVo();
			rangeVO.setBandDescr("some desc");
			rangeVO.setLowerBandValue(1.4f);
			rangeVO.setUpperBandValue(4.5f);
			rangeVO.setSegVal(2);
			rangeList.add(rangeVO);
		}
		return rangeList;
	}

}
