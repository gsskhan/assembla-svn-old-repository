package com.citi.retail.optima.etl.enrichment.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.expression.ParseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.enrichment.common.EnrichmentRule;
import com.citi.retail.optima.etl.enrichment.dao.EnrichmentRulesDao;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;

/**
 * @author mc56120
 * 
 */
public class EnrichmentRulesDaoImpl implements
	EnrichmentRulesDao<List<EnrichmentRule>>{

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(EnrichmentRulesDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	private String sql;
	
	

	private ResultSetExtractor<List<EnrichmentRule>> resultSetExtractor;


	public List<EnrichmentRule> getEnrichmentRules(String key)
			throws EnrichmentException {
		return this.getRulesData(key);
	}
	
	/**
	 * 
	 * @return
	 * @throws EnrichmentException
	 */
	private List<EnrichmentRule> getRulesData(final String  key) throws EnrichmentException {		
		try {
			String sql = "SELECT * FROM (SELECT DECODE(map.cat_cd , NULL,'',map.cat_cd||':') || DECODE(map.sys_proc_id , NULL,'',map.sys_proc_id) AS KEY, map.sys_proc_id AS sys_proc_id,attr.attr_id as attr_id ,attr.attr_nm AS ruleAttribute, REPLACE(REPLACE(REPLACE(enrch_rule_to_exec, '{scheduleIdHolder}', pu.proc_unit_id), '{busFuncHolder}', Trim(pu.bus_func_cd)),'{sysProcHolder}', Trim(spd.sys_proc_id)) AS ruleToExecute , e.enrch_rule_ord AS ruleorder FROM TMP_RRC_ENRCH_RULE_POC e,TMP_RRC_ENRCH_MAP_POC map,TMP_RRC_ETL_ATTRIBUTE_POC attr, HDA_SYS_PROC_DEF spd, RRR_PROC_UNIT pu WHERE map.enrch_rule_id=e.enrch_rule_id AND map.attr_id =attr.attr_id AND map.sys_proc_id    =spd.sys_proc_id AND spd.proc_unit_id   =pu.proc_unit_id AND map.eff_sts ='A' AND e.eff_sts ='A' ORDER BY ruleorder) WHERE KEY=?";
			return jdbcTemplate.query(sql,	
					new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, key);
				}
			},	
			resultSetExtractor);
		} catch (ParseException ex) {
			LOGGER.error("Spel Expression Parser was unable to Parse the Expression: ");
			throw ex;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(" Exception occured while loading Validation rules "
					+ e);
			throw new EnrichmentException("Exception occured while Enrichment rules",
					e.getMessage(), e);
		}		
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
	
	public void setResultSetExtractor(
			ResultSetExtractor<List<EnrichmentRule>> resultSetExtractor) {
		this.resultSetExtractor = resultSetExtractor;
	}

}
