/**
 * 
 */
package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.AggregationSqlRef;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author mc56120
 * 
 */
public class AggregationSqlDaoImpl implements CacheLoaderDao<AggregationSqlRef> {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationRulesDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	private String keySql;

	@Override
	public List<AggregationSqlRef> getCacheData(Object... args)
			throws OptimaRetailApplicationException {
		try {
			List<AggregationSqlRef> aggregationTypeRefList = jdbcTemplate
					.query(keySql, new RowMapper<AggregationSqlRef>() {
						@Override
						public AggregationSqlRef mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							AggregationSqlRef aggregationSqlRef = new AggregationSqlRef();
							aggregationSqlRef.setRulesKey(rs.getString("KEY"));
							aggregationSqlRef.setProcessingUnitId(rs
									.getInt("PROC_UNIT_ID"));
							aggregationSqlRef.setAggregationId(rs
									.getInt("AGGR_RULE_ID"));
							aggregationSqlRef.setAggregationName(rs
									.getString("AGGR_NM"));
							aggregationSqlRef.setInsertSql(rs
									.getString("ISRT_SQL"));

							return aggregationSqlRef;
						}
					});
			return aggregationTypeRefList;
		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading Aggregation SQL "
					+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.FATAL,
					" Exception occured while loading Aggregation SQL",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setKeySql(String keySql) {
		this.keySql = keySql;
	}

}
