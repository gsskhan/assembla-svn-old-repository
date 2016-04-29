package com.citi.retail.optima.etl.validation.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.jdbc.core.ResultSetExtractor;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.constraint.impl.SPELRuleConstraint;
import com.citi.retail.optima.etl.validation.exception.ExceptionType;

/**
 * 
 * @author hp44940
 *
 */
public class ValidationRulesResultSetExtractor implements ResultSetExtractor<List<RuleConstraint>> {
	
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ValidationRulesResultSetExtractor.class);
	
	private SpelExpressionParser parser = new SpelExpressionParser();

	/**
	 * This method extract rules from database.
	 */
	public List<RuleConstraint> extractData(ResultSet rs) throws SQLException {
		List<RuleConstraint> rulesList = new  ArrayList<RuleConstraint>();
		while (rs.next()) {
			RuleConstraint ruleConstraint = new SPELRuleConstraint();
			ruleConstraint.setRulesKey(rs.getString("KEY"));
			ruleConstraint.setSysProcId(rs.getInt("SYS_PROC_ID"));
			ruleConstraint.setRuleId(rs.getInt("RULE_ID"));
			ruleConstraint.setRuleAsString(rs.getString("RULE_TO_EXECUTE"));
			ruleConstraint.setAttributeId(rs.getInt("RULE_ATTRIBUTE_ID"));
			ruleConstraint.setAttributeName(rs.getString("RULE_ATTRIBUTE"));
			ruleConstraint.setViolationMsg(rs.getString("ERR_MSG"));
			ruleConstraint.setAuditValuesExprAsString(rs.getString("AUDIT_VALUES"));
			try {
				if (ruleConstraint.getRuleAsString() != null
						&& !"".equals(ruleConstraint.getRuleAsString())) {
					((SPELRuleConstraint) ruleConstraint).setRule(parseSPEL(ruleConstraint.getRuleAsString()));
				}
				
				if (ruleConstraint.getAuditValuesExprAsString() != null
						&& !"".equals(ruleConstraint.getAuditValuesExprAsString())) {
					((SPELRuleConstraint) ruleConstraint)
							.setAuditValuesExpr(parseSPEL(ruleConstraint
									.getAuditValuesExprAsString()));
				}
			} catch (ParseException e) {
				LOGGER.error("Spel Expression Parser was unable to Parse the Expression: "
						+ ruleConstraint.getRuleAsString()
						+ " with following exception message: "
						+ e.getMessage());
				handleExceptions(ruleConstraint, e);
				throw e;
			}											
			rulesList.add(ruleConstraint);
			
			
		}
		
		return rulesList;
	}
	
	/**
	 * 
	 * @param rule
	 * @param exception
	 */
	private void handleExceptions(RuleConstraint ruleConstraint, Exception exception) {			
		LOGGER.info("UserErrorMessage --> Error:: Got a parsing error while loading validation rules :" + ruleConstraint.getRule());
		LOGGER.info("ExceptionMessage --> " + exception.getMessage() == null ? exception
				.getClass().getName() : exception.getMessage());
		LOGGER.info("Rule  --> " + ruleConstraint.getRule());
		LOGGER.info("Attribute on which error occured --> "
				+ ruleConstraint.getAttributeName());
		LOGGER.info("Exception type  --> "+ ExceptionType.ERROR);
		LOGGER.info("Exception Stack Trace --> " + exception.getStackTrace());
	}
	
	private Expression parseSPEL(String expr) {
		return this.parser.parseExpression(expr);
	}

}
