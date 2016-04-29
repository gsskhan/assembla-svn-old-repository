package com.citi.retail.optima.etl.validation.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.dao.ValidationRulesDao;
import com.citi.retail.optima.etl.validation.exception.ValidationException;

/**
 * DAO class, to retrieve the list of Validation Rules from the Database. Uses
 * JDBCTemplate.
 */
public class ValidationRulesDaoImpl implements ValidationRulesDao<List<RuleConstraint>> {
	
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ValidationRulesDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;
	
	private String sql;

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<RuleConstraint> getValidationRules(String key)
			throws ValidationException {
		return this.getRulesData(key);
	}
	
	/**
	 * 
	 * @return
	 * @throws ValidationException
	 */
	private List<RuleConstraint> getRulesData(final String  key) throws ValidationException {
		try {
			return jdbcTemplate.query(sql,	new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, key);
				}
			},	new ValidationRulesResultSetExtractor());
						
		} catch (Exception e) {
			LOGGER.error(" Exception occured while loading Validation rules "
					+ e);
			throw new ValidationException("Exception occured while loading Validation rules",
					e.getMessage(), e);	
		}
	}
	
}
