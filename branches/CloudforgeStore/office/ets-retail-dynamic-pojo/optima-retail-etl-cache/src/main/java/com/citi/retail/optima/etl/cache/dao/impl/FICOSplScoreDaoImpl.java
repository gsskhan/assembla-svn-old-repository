package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

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

public class FICOSplScoreDaoImpl implements CacheLoaderDao<FICOScoreVO>,
		InitializingBean {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(FICOSplScoreDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	private List<FICOScoreVO> ficoSplScoreList;

	private String sql;

	public List<FICOScoreVO> getSplScoreDetails()
			throws OptimaRetailApplicationException {

		ficoSplScoreList = new ArrayList<FICOScoreVO>();
		try {
			ficoSplScoreList = mockScoreVOList();

		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading PDRange " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					"Exception occured while loading FICO Spl Score",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
		return ficoSplScoreList;
	}

	@Override
	public List<FICOScoreVO> getCacheData(Object... args) throws Exception {
		return ficoSplScoreList;
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
		getSplScoreDetails();

	}

	private List<FICOScoreVO> mockScoreVOList() {

		List<FICOScoreVO> rangeList = new ArrayList<FICOScoreVO>();
		FICOScoreVO scoreVO;

		for (int i = 0; i < 10; i++) {
			scoreVO = new FICOScoreVO();
			scoreVO.setReportingPeriod("201309");
			scoreVO.setFicoScore(560);
			scoreVO.setScoreDesc("Originated");
			scoreVO.setIncludeFlag(true);
			rangeList.add(scoreVO);
		}
		scoreVO = new FICOScoreVO();
		scoreVO.setReportingPeriod("201309");
		scoreVO.setFicoScore(5);
		scoreVO.setScoreDesc("Originated");
		scoreVO.setIncludeFlag(true);
		scoreVO.setSplScoreFlag(true);
		rangeList.add(scoreVO);

		return rangeList;
	}

}
