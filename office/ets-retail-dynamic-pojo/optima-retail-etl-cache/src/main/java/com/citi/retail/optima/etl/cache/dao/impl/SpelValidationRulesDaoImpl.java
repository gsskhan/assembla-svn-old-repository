package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.SPELidationRulesRef;
import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * DAO class, to retrieve the list of Validation Rules from the Database. Uses
 * JDBCTemplate.
 */
public class SpelValidationRulesDaoImpl implements
		CacheLoaderDao<SPELidationRulesRef> {

	private final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(SpelValidationRulesDaoImpl.class);

	private JdbcTemplate jdbcTemplate;
	
	private String sql;

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private List<SPELidationRulesRef> getRulesData()
			throws OptimaRetailApplicationException {
		try {
			return this.jdbcTemplate.query(sql, new ParameterizedRowMapper<SPELidationRulesRef>() {
				public SPELidationRulesRef 	mapRow(ResultSet rs, int rowNum) throws SQLException{
					SPELidationRulesRef dto = new SPELidationRulesRef();
					dto.setRulesKey(rs.getString("KEY"));
					dto.setProcessingUnitId(rs.getInt("SYS_PROC_ID"));
					dto.setRuleId(rs.getInt("RULE_ID"));
					dto.setRuleToExecute(rs.getString("RULE_TO_EXECUTE"));
					dto.setRuleOrder(rs.getInt("RULE_ORDER"));					
					dto.setAttrId(rs.getInt("RULE_ATTRIBUTE_ID"));
					dto.setAttrName(rs.getString("RULE_ATTRIBUTE"));
					dto.setErrorMessage(rs.getString("ERR_MSG"));
					dto.setAuditValues(rs.getString("AUDIT_VALUES"));
					return dto;
				}
			});
			
		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading Validation rules "
					+ e);
			throw new OptimaRetailApplicationException(null, null, null,
					ServiceName.CACHE, ExceptionType.FATAL,
					"Exception occured while loading Validation rules",
					e.getMessage(), OptimaRetailExceptionUtil.getStackTrace(e));			
		}
	}

	@Override
	public Collection<SPELidationRulesRef> getCacheData(Object... args)
			throws Exception {
		return this.getRulesData();
	}

}
