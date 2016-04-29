package com.citi.retail.optima.etl.aggregation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.citi.retail.optima.etl.common.util.QueryConfigUtility;

import ch.qos.logback.classic.Logger;

/**
 * Persistent accessor for retrieving aggregation rule info
 * @author yh43239
 *
 */
public class AggregationRulesDao {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationRulesDao.class);
	private static final String PROCESSING_UNIT_ID = "PROCESSING_UNIT_ID";
	private static final String PROC_UNIT_ID = "PROC_UNIT_ID";
	private static final String AGGR_RULE_ID = "AGGR_RULE_ID";
	private static final String AGGR_NM = "AGGR_NM";
	private static final String AGGR_ELEM_TYP_ID = "AGGR_ELEM_TYP_ID";
	private static final String ATTR_NM = "ATTR_NM";
	private static final String AGGR_ORD = "AGGR_ORD";
	private static final String KEY = "KEY";
	private static final String AGGR_DESC = "AGGR_DESC";
	private static final String ISRT_SQL = "ISRT_SQL";

	private JdbcTemplate jdbcTemplate;
	private String aggregationRuleSql;
	private String aggregationRuleWithKeySql;
	private String aggregationSqlRuleWithKeySql;
	
	/**
	 * Getting a list of none sql aggregation rules - without key identifier
	 * 
	 * @return List<AggregationRuleRef<NoneSqlRuleRef>>
	 */
	public List<AggregationRuleMeta> getAggregationRules() {

		List<AggregationRuleMeta> aggregationTypeRefList = jdbcTemplate
				.query(QueryConfigUtility.getValue("query.rules.aggregation"),
						new RowMapper<AggregationRuleMeta>() {

					AggregationRuleMeta aggregationRuleMeta = null;

							@Override
							public AggregationRuleMeta mapRow(
									ResultSet rs, int rowNum)
									throws SQLException {
								aggregationRuleMeta = new AggregationRuleMeta(rs.getInt(PROCESSING_UNIT_ID));					
								aggregationRuleMeta.setAggregationId(rs.getInt(AGGR_RULE_ID));
								aggregationRuleMeta.setAggregationName(rs.getString(AGGR_NM));
								aggregationRuleMeta.setAggregationRuleType(rs.getInt(AGGR_ELEM_TYP_ID));
								aggregationRuleMeta.setAggregationRule(rs.getString(ATTR_NM));
								aggregationRuleMeta.setAggregationRuleOrder(rs.getInt(AGGR_ORD));

								return aggregationRuleMeta;

							}
						});
		LOGGER.info("Obtained a list of aggregation rule meta from database: "
				+ aggregationTypeRefList == null ? "0" : String
				.valueOf(aggregationTypeRefList.size()));
		return aggregationTypeRefList;

	}

	/**
	 * Getting a list of none sql aggregation rules - with key identifier
	 * 
	 * @return List<AggregationRuleRef<NoneSqlRuleRef>>
	 */
	public List<AggregationRuleMeta> getAggregationRulesWithKey() {

		List<AggregationRuleMeta> aggregationTypeRefList = jdbcTemplate
				.query(QueryConfigUtility.getValue("query.rules.aggregation.with.key"),
						new RowMapper<AggregationRuleMeta>() {
					AggregationRuleMeta aggregationRulesMeta = null;

							@Override
							public AggregationRuleMeta mapRow(
									ResultSet rs, int rowNum)
									throws SQLException {
								aggregationRulesMeta = new AggregationRuleMeta(rs.getInt(PROCESSING_UNIT_ID));
								aggregationRulesMeta.setAggregationId(rs.getInt(AGGR_RULE_ID));
								aggregationRulesMeta.setAggregationName(rs.getString(AGGR_NM));
								aggregationRulesMeta.setRulesKey(rs.getString(KEY));
								aggregationRulesMeta.setAggregationRuleType(rs.getInt(AGGR_ELEM_TYP_ID));
								aggregationRulesMeta.setAggregationRule(rs.getString(ATTR_NM));
								aggregationRulesMeta.setAggregationRuleOrder(rs.getInt(AGGR_ORD));
								aggregationRulesMeta.setDesc(rs.getString(AGGR_DESC));

								return aggregationRulesMeta;
							}
						});
		LOGGER.info("Obtained a list of aggregation rule meta with key from database: "
				+ aggregationTypeRefList == null ? "0" : String
				.valueOf(aggregationTypeRefList.size()));
		return aggregationTypeRefList;
	}

	/**
	 * Getting a list of sql aggregation rules - with key identifier
	 * 
	 * @return List<AggregationRuleRef<SqlRuleRef>>
	 */
	public List<AggregationRuleSql> getAggregationSQLRuleRef() {

		List<AggregationRuleSql> aggregationTypeRefList = jdbcTemplate
				.query(QueryConfigUtility.getValue("query.rules.aggregation.sql.with.key"),
						new RowMapper<AggregationRuleSql>() {
					AggregationRuleSql aggregationRuleSql = null;

							@Override
							public AggregationRuleSql mapRow(
									ResultSet rs, int rowNum)
									throws SQLException {

								aggregationRuleSql = new AggregationRuleSql(rs.getInt(PROC_UNIT_ID));
								aggregationRuleSql.setRulesKey(rs.getString(KEY));
								aggregationRuleSql.setAggregationId(rs.getInt(AGGR_RULE_ID));
								aggregationRuleSql.setAggregationName(rs.getString(AGGR_NM));
								aggregationRuleSql.setInsertSql(rs.getString(ISRT_SQL));

								return aggregationRuleSql;
							}
						});
		LOGGER.info("Obtained a list ofaggregation rule sql with key from database: "
				+ aggregationTypeRefList == null ? "0" : String
				.valueOf(aggregationTypeRefList.size()));
		return aggregationTypeRefList;

	}

	/**
	 * Get sql to retrieve Aggregation rule meta
	 * @return
	 */
	public String getAggregationRuleSql() {
		return aggregationRuleSql;
	}
	/**
	 * Set sql to retrieve Aggregation rule meta injected via Spring
	 * @param aggregationRuleSql
	 */
	public void setAggregationRuleSql(String aggregationRuleSql) {
		this.aggregationRuleSql = aggregationRuleSql;
	}

	/**
	 * Get a variant of sql to retrive Aggregation Rule meta 
	 * @return
	 */
	public String getAggregationRuleWithKeySql() {
		return aggregationRuleWithKeySql;
	}
	
	/**
	 * Set sql to retrieve Aggregation rule meta with key injected via Spring
	 * @param aggregationRuleWithKeySql
	 */
	public void setAggregationRuleWithKeySql(String aggregationRuleWithKeySql) {
		this.aggregationRuleWithKeySql = aggregationRuleWithKeySql;
	}

	/**
	 * Get sql used to retrieve aggregation rule sql
	 * @return
	 */
	public String getAggregationSqlRuleWithKeySql() {
		return aggregationSqlRuleWithKeySql;
	}
	
	/**
	 * Set sql used to retrieve aggregation rule sql 
	 * @param aggregationSqlRuleWithKeySql
	 */

	public void setAggregationSqlRuleWithKeySql(String aggregationSqlRuleWithKeySql) {
		this.aggregationSqlRuleWithKeySql = aggregationSqlRuleWithKeySql;
	}

	/**
	 * Spring injected JDBC template
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
