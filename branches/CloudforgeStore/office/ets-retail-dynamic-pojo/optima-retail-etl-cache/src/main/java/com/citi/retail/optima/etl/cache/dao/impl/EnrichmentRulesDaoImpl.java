package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.EnrichmentRulesRef;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author mc56120
 * 
 */
public class EnrichmentRulesDaoImpl implements
		CacheLoaderDao<EnrichmentRulesRef> {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(EnrichmentRulesDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	private String sql;

	private String keySql;

	/**
	 * populate enrichment rules from DB
	 * 
	 * @return List<EnrichmentRulesRef>
	 * @throws OptimaRetailException
	 */
	@Deprecated
	public List<EnrichmentRulesRef> getEnrichmentRules()
			throws OptimaRetailApplicationException {
		try {
			List<EnrichmentRulesRef> enrichmentRulesRefList = jdbcTemplate
					.query(sql, new RowMapper<EnrichmentRulesRef>() {
						@Override
						public EnrichmentRulesRef mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							EnrichmentRulesRef enrichmentRulesRef = new EnrichmentRulesRef();
							enrichmentRulesRef.setRuleToExecute(rs
									.getString("ruleToExecute"));
							enrichmentRulesRef.setRuleOrder(rs
									.getInt("ruleOrder"));
							enrichmentRulesRef.setProcessingUnitId(rs
									.getInt("PROC_UNIT_ID"));
							return enrichmentRulesRef;
						}
					});
			return enrichmentRulesRefList;
		} catch (Exception e) {
			LOGGER.error(" Exception occured while Enrichment rules " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.FATAL,
					"Exception occured while Enrichment rules", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}

	/**
	 * populate enrichment rules from DB
	 * 
	 * @return List<EnrichmentRulesRef>
	 * @throws OptimaRetailException
	 */
	public List<EnrichmentRulesRef> getEnrichmentRulesWithKey()
			throws OptimaRetailApplicationException {
		try {
			List<EnrichmentRulesRef> enrichmentRulesRefList = jdbcTemplate
					.query(keySql, new RowMapper<EnrichmentRulesRef>() {
						@Override
						public EnrichmentRulesRef mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							EnrichmentRulesRef enrichmentRulesRef = new EnrichmentRulesRef();
							enrichmentRulesRef.setRuleToExecute(rs
									.getString("ruleToExecute"));
							enrichmentRulesRef.setRuleOrder(rs
									.getInt("ruleOrder"));
							enrichmentRulesRef.setRulesKey(rs.getString("KEY"));
							enrichmentRulesRef.setProcessingUnitId(rs
									.getInt("SYS_PROC_ID"));
							return enrichmentRulesRef;
						}
					});
			return enrichmentRulesRefList;
		} catch (Exception e) {
			LOGGER.error(" Exception occured while Enrichment rules " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.FATAL,
					"Exception occured while Enrichment rules", e.getMessage(),
					OptimaRetailExceptionUtil.getStackTrace(e));
		}

	}

	@Override
	public Collection<EnrichmentRulesRef> getCacheData(Object... args)
			throws Exception {
		return getEnrichmentRulesWithKey();
	}

	/**
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setKeySql(String keySql) {
		this.keySql = keySql;
	}

}
