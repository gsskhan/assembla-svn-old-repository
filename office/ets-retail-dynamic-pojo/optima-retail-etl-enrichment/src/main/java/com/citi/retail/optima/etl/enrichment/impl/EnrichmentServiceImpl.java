/**
 * 
 */
package com.citi.retail.optima.etl.enrichment.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;

import com.citi.retail.optima.etl.enrichment.EnrichmentRulesLoader;
import com.citi.retail.optima.etl.enrichment.EnrichmentService;
import com.citi.retail.optima.etl.enrichment.common.EnrichmentRule;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentExceptionDetail;
import com.citi.retail.optima.etl.enrichment.exception.ExceptionType;

/**
 * @author ms04453
 * @param <T>
 * 
 */
public class EnrichmentServiceImpl<T> implements EnrichmentService<T>,
		InitializingBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnrichmentServiceImpl.class);
	
	private EvaluationContext evalContext;
	private EnrichmentRulesLoader enrichmentRules;
	private List<EnrichmentRule> enrichmentRulesList = new ArrayList<EnrichmentRule>();
	private List<String> keyList;
	
	private List<EnrichmentExceptionDetail> excetionDetailList;

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws EnrichmentException {

		if (this.evalContext == null) {
			LOGGER.error("OptimaCardsEnrichmentService cannot be loaded as the evaluation context is NULL");
			throw new EnrichmentException(
					//ExceptionType.FATAL,
					"OptimaCardsEnrichmentService cannot be loaded as the evaluation context is NULL");
		} else {
			this.enrichmentRulesList = this.enrichmentRules.getRulesList(this.keyList);			
		}
	}

	

	public T enrich(T currentItem) throws EnrichmentException {
//		long totalTime = System.currentTimeMillis();
		if (currentItem != null) {
			this.excetionDetailList = new ArrayList<EnrichmentExceptionDetail>();
			for (EnrichmentRule enrichmentRule : this.enrichmentRulesList) {
				try {						
					if (enrichmentRule.getRule() == null) {
						continue;
					}
//					long time = System.currentTimeMillis();							
					enrichmentRule.getRule().getValue(this.evalContext, currentItem);
//					System.out.println("Time taken for rule - "+enrichmentRule.getRule().getExpressionString()+" is " 
//					+((System.currentTimeMillis()-time))+ " milliseconds");
				} catch (EvaluationException e) {
					handleExceptions(enrichmentRule, e);
				}
			}
			
		} else {
			LOGGER.error("NULL valued Account Object passed into Enrichment Service, Hence add this to Skipped Records : "
					+ currentItem);
			throw new EnrichmentException("NULL valued Account Object passed into Enrichment Service, Hence add this to Skipped Records : "
					+ currentItem);
		}
		if (this.excetionDetailList != null
				&& this.excetionDetailList.size() != 0) {
			for(EnrichmentExceptionDetail exceptionDetail: this.excetionDetailList) {
				System.out.println(exceptionDetail.getRule());
				System.out.println(exceptionDetail.getExceptionMessage());
			}
			throw new EnrichmentException(excetionDetailList);			
		}
		//System.out.println("Total Time taken for enriching one record = "+(System.currentTimeMillis()-totalTime));
		return currentItem;
	}

	/**
	 * @param currExp
	 * @param exception
	 */
	private void handleExceptions(EnrichmentRule enrichmentRule,
			EvaluationException exception) {
		if (this.excetionDetailList == null) {
			this.excetionDetailList = new ArrayList<EnrichmentExceptionDetail>();
		}
		EnrichmentExceptionDetail enrichmentExceptionDetail = new EnrichmentExceptionDetail();
		enrichmentExceptionDetail
				.setUserErrorMessage("Error while enriching data for: "
						+ enrichmentRule.getRuleToExecute());
		enrichmentExceptionDetail
				.setExceptionMessage(exception.getMessage() == null ? exception
						.getClass().getName() : exception.getMessage());
		enrichmentExceptionDetail.setRule(enrichmentRule.getRuleToExecute());
		enrichmentExceptionDetail.setAttributeName(enrichmentRule.getAttrName());
		enrichmentExceptionDetail.setAttributeId(enrichmentRule.getAttributeId());
		enrichmentExceptionDetail.setExceptionType(ExceptionType.ERROR);
		enrichmentExceptionDetail.setStackTrace(EnrichmentException.getStackTrace(exception));
		this.excetionDetailList.add(enrichmentExceptionDetail);
	}

	/**
	 * @param evalContext
	 *            the evalContext to set
	 */
	public void setEvalContext(EvaluationContext evalContext) {
		this.evalContext = evalContext;
	}

	/**
	 * @return the evalContext
	 */
	public EvaluationContext getEvalContext() {
		return this.evalContext;
	}

	/**
	 * @param enrichmentRules
	 *            the enrichmentRules to set
	 */
	public void setEnrichmentRules(EnrichmentRulesLoader enrichmentRules) {
		this.enrichmentRules = enrichmentRules;
	}


	/**
	 * @return the keyList
	 */
	public List<String> getKeyList() {
		return this.keyList;
	}

	/**
	 * @param keyList
	 *            the keyList to set
	 */
	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}
		
	
	public void setEnrichmentRulesList(List<EnrichmentRule> enrichmentRulesList) {
		this.enrichmentRulesList = enrichmentRulesList;
	}

}
