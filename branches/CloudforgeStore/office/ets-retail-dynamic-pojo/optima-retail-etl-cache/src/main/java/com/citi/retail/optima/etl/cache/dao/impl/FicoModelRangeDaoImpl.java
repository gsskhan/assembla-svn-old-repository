package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.ModelRangeVO;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

public class FicoModelRangeDaoImpl implements CacheLoaderDao<ModelRangeVO>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(FicoModelRangeDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<ModelRangeVO> modelRangeList;

	private String sql;

	public List<ModelRangeVO> getFicoModelRangeData()
			throws OptimaRetailApplicationException {

		modelRangeList = new ArrayList<ModelRangeVO>();
		try {
			modelRangeList = mockScoreVOList();

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading PDRange " + e);

			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.FATAL,
					" Exception occured while loading PDRange", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return modelRangeList;
	}

	@Override
	public List<ModelRangeVO> getCacheData(Object... args) throws Exception {
		return modelRangeList;
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
		getFicoModelRangeData();

	}

	private List<ModelRangeVO> mockScoreVOList() {

		List<ModelRangeVO> rangeList = new ArrayList<ModelRangeVO>();
		ModelRangeVO scoreVO;

		for (int i = 0; i < 10; i++) {
			scoreVO = new ModelRangeVO();

			scoreVO.setCreditBureau("Transunion");
			scoreVO.setMaxValue(909);
			scoreVO.setMinValue(270);
			scoreVO.setModelVersion("Account Management Model 2.0");
			rangeList.add(scoreVO);
		}
		return rangeList;
	}

}
