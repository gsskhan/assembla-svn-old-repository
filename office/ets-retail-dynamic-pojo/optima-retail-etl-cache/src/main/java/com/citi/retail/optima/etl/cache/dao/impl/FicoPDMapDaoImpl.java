package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.FICOScoreVO;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

public class FicoPDMapDaoImpl implements CacheLoaderDao<FICOScoreVO>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(FicoPDMapDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<FICOScoreVO> ficoPDMapList;

	private String sql;

	public List<FICOScoreVO> getFicoPdMapData()
			throws OptimaRetailApplicationException {

		ficoPDMapList = new ArrayList<FICOScoreVO>();
		try {
			ficoPDMapList = mockScoreVOList();

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading PDRange " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading PDRange", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return ficoPDMapList;
	}

	@Override
	public List<FICOScoreVO> getCacheData(Object... args) throws Exception {
		return ficoPDMapList;
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
		getFicoPdMapData();

	}

	private List<FICOScoreVO> mockScoreVOList() {

		List<FICOScoreVO> rangeList = new ArrayList<FICOScoreVO>();
		FICOScoreVO scoreVO;

		for (int i = 0; i < 10; i++) {
			scoreVO = new FICOScoreVO();

			scoreVO.setFicoScore(560);
			scoreVO.setCreditBureau("TransUnion");
			scoreVO.setModelVersion("FICO 08 - Auto");

			Map<String, Double> productPDMap = new HashMap<String, Double>();
			productPDMap.put("AUTO", 0.1689);
			scoreVO.setProductPDMap(productPDMap);

			rangeList.add(scoreVO);
		}
		return rangeList;
	}

}
