package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.Collection;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.db.dao.ConstraintMapping;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * DAO class, to retrieve the list of Validation Rules from the Database. Uses
 * JDBCTemplate.
 */
public class ValidationRulesDaoImpl implements
		CacheLoaderDao<ConstraintMapping> {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(ValidationRulesDaoImpl.class);

	private JdbcTemplate jdbcTemplate;
	private String sql;

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private List<ConstraintMapping> getRulesData()
			throws OptimaRetailApplicationException {
		try {
			List<ConstraintMapping> mappingList = jdbcTemplate.query(sql,
					new ConstraintMappingResultSetExtractor());
			return mappingList;
		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading Validation rules "
					+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.ERROR,
					" Exception occured while loading Validation rules",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public Collection<ConstraintMapping> getCacheData(Object... args)
			throws Exception {
		return this.getRulesData();
	}

}
