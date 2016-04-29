/**
 * 
 */
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
import com.citi.retail.optima.etl.cache.model.AggregationRulesRef;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author mc56120
 * 
 */
public class AggregationRulesDaoImpl implements
		CacheLoaderDao<AggregationRulesRef> {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationRulesDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	private String sql;

	private String keySql;

	public List<AggregationRulesRef> getAggregationRules(Object... args)
			throws OptimaRetailApplicationException {
		try {
			List<AggregationRulesRef> aggregationTypeRefList = jdbcTemplate
					.query(sql, new RowMapper<AggregationRulesRef>() {
						@Override
						public AggregationRulesRef mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							AggregationRulesRef aggregationRulesRef = new AggregationRulesRef();
							aggregationRulesRef.setProcessingUnitId(rs
									.getInt("PROCESSING_UNIT_ID"));
							aggregationRulesRef.setAggregationId(rs
									.getInt("AGGR_RULE_ID"));
							aggregationRulesRef.setAggregationName(rs
									.getString("AGGR_NM"));
							aggregationRulesRef.setAggregationRuleType(rs
									.getInt("AGGR_ELEM_TYP_ID"));
							aggregationRulesRef.setAggregationRule(rs
									.getString("ATTR_NM"));
							aggregationRulesRef.setAggregationRuleOrder(rs
									.getInt("AGGR_ORD"));
							return aggregationRulesRef;
						}
					});
			return aggregationTypeRefList;
		} catch (Exception e) {
			LOGGER.error(" Exception occured while Aggregation rules " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.FATAL,
					"Exception occured while Aggregation rules",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
	}

	public List<AggregationRulesRef> getAggregationRulesWithKey(Object... args)
			throws OptimaRetailApplicationException {
		try {
			List<AggregationRulesRef> aggregationTypeRefList = jdbcTemplate
					.query(keySql, new RowMapper<AggregationRulesRef>() {
						@Override
						public AggregationRulesRef mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							AggregationRulesRef aggregationRulesRef = new AggregationRulesRef();
							aggregationRulesRef.setProcessingUnitId(rs
									.getInt("PROCESSING_UNIT_ID"));
							aggregationRulesRef.setRulesKey(rs.getString("KEY"));
							aggregationRulesRef.setAggregationId(rs
									.getInt("AGGR_RULE_ID"));
							aggregationRulesRef.setAggregationName(rs
									.getString("AGGR_NM"));
							aggregationRulesRef.setAggregationRuleType(rs
									.getInt("AGGR_ELEM_TYP_ID"));
							aggregationRulesRef.setAggregationRule(rs
									.getString("ATTR_NM"));
							aggregationRulesRef.setAggregationRuleOrder(rs
									.getInt("AGGR_ORD"));
							aggregationRulesRef.setDesc(rs
									.getString("AGGR_DESC"));							
							return aggregationRulesRef;
						}
					});
			return aggregationTypeRefList;
		} catch (Exception e) {
			LOGGER.error(" Exception occured while Aggregation rules " + e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.FATAL,
					"Exception occured while Aggregation rules",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public Collection<AggregationRulesRef> getCacheData(Object... args)
			throws Exception {
		return getAggregationRulesWithKey(args);
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
