package com.citi.retail.optima.etl.enrichment.dao.impl;

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

import com.citi.retail.optima.etl.enrichment.common.EnrichmentRule;
import com.citi.retail.optima.etl.enrichment.exception.ExceptionType;

/**
 * 
 * @author hp44940
 *
 */
public class EnrichmentRulesResultSetExtractor implements ResultSetExtractor<List<EnrichmentRule>> {
	
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(EnrichmentRulesResultSetExtractor.class);
	
	private SpelExpressionParser parser = new SpelExpressionParser();

	/**
	 * This method extract rules from database.
	 */
	public List<EnrichmentRule> extractData(ResultSet rs) throws SQLException {
		List<EnrichmentRule> rulesList = new ArrayList<EnrichmentRule>();
		while (rs.next()) {
			EnrichmentRule enrichmentRule = new EnrichmentRule();
			enrichmentRule.setRuleToExecute(rs.getString("ruleToExecute"));
			enrichmentRule.setAttrName(rs.getString("ruleAttribute"));
			enrichmentRule.setRuleOrder(rs
					.getInt("ruleOrder"));
			enrichmentRule.setRulesKey(rs.getString("KEY"));
			enrichmentRule.setSysProcId(rs
					.getInt("SYS_PROC_ID"));
			enrichmentRule.setAttributeId(rs
					.getInt("ATTR_ID"));
					
			try {
				if (enrichmentRule.getRuleToExecute() != null
						&& !"".equals(enrichmentRule.getRuleToExecute())) {
					enrichmentRule.setRule(parseSPEL(enrichmentRule.getRuleToExecute()));
				}
				
			} catch (ParseException e) {
				LOGGER.error("Spel Expression Parser was unable to Parse the Expression: "
						+ enrichmentRule.getRuleToExecute()
						+ " with following exception message: "
						+ e.getMessage());
				handleExceptions(enrichmentRule, e);
				throw e;
			}											
									
			rulesList.add(enrichmentRule);
			
		}
		
		return rulesList;
	}
	
	/**
	 * 
	 * @param rule
	 * @param exception
	 */
	private void handleExceptions(EnrichmentRule enrichmentRule, Exception exception) {			
		LOGGER.info("UserErrorMessage --> Error:: Got a parsing error while loading validation rules :" + enrichmentRule.getRule());
		LOGGER.info("ExceptionMessage --> " + exception.getMessage() == null ? exception
				.getClass().getName() : exception.getMessage());
		LOGGER.info("Rule  --> " + enrichmentRule.getRule());
		System.out.println("RRRRRRRRRRRRR<<<<" + enrichmentRule.getRule());
		LOGGER.info("Rule Key on which error occured --> "
				+ enrichmentRule.getRulesKey());
		LOGGER.info("Exception type  --> "+ ExceptionType.ERROR);
		LOGGER.info("Exception Stack Trace --> " + exception.getStackTrace());
	}
	
	private Expression parseSPEL(String expr) {
		Expression expression = null;
//		long time= System.currentTimeMillis();
		
		 expression = this.parser.parseExpression(expr);
//		 System.out.println("Time taken for parsing rule - "+expr+" is " +((System.currentTimeMillis()-time))+ " milliseconds");
		
		 return expression;
	}

}
