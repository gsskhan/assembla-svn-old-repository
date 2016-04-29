package com.citi.retail.optima.etl.enrichment.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.enrichment.common.EnrichmentRule;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentExceptionDetail;
import com.citi.retail.optima.etl.enrichment.impl.EnrichmentServiceImpl;
import com.citi.retail.optima.etl.enrichment.model.UserSubmissionCCARRecord;


/**
 * @author sr67841
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.enrichment.config.test.xml"})
public class EnrichmentServiceImplTest {

	private UserSubmissionCCARRecord modelObj;
	
	@Autowired
	private EnrichmentServiceImpl<UserSubmissionCCARRecord> enrichmentService;

	private SpelExpressionParser parser = new SpelExpressionParser();

	@Before
	public void setUp() throws ParseException,EnrichmentException{	
		setUpModel();
		setUpKeyList();
	}

		
	private void setUpKeyList() throws EnrichmentException {		
		List<EnrichmentRule> list = new ArrayList<EnrichmentRule>();
		EnrichmentRule  rule = new EnrichmentRule();
		rule.setRuleToExecute("eFedAgeSegmentId=(age>35?9999:3)");
		rule.setRule(parseSPEL(rule.getRuleToExecute()));
		list.add(rule);
		rule = new EnrichmentRule();
		rule.setRuleToExecute("eFedDelqSegmentId=(delqStatus>7?179:99999)");
		rule.setRule(parseSPEL(rule.getRuleToExecute()));
		list.add(rule);		
		this.enrichmentService.setEnrichmentRulesList(list);
				
	}

	public void setUpModel() throws ParseException {		
		modelObj = new UserSubmissionCCARRecord();
		modelObj.setDelqStatus(59);
		modelObj.setOriginalLtv(3);
		modelObj.setAge(40);
		modelObj.setOrigFico(3);
		modelObj.setCountry("CN");
		modelObj.setProductType("CO_UI");
		modelObj.setCollateralizedFlag(-1);
		modelObj.setGcbcPortfolioId("CNUI004");
		modelObj.setRptPeriod(201202);
		modelObj.setNumNewAccounts(100);
		modelObj.setNumAccounts(100);
		modelObj.setCurrLineLoanSize(null);
		modelObj.setRegion("1");
		modelObj.setGrossContractualChargeOffAmt(100.0);
		modelObj.setBankruptcyChargeOffAmt(200.0);
		modelObj.setRecovery(200.0);
		modelObj.setAdjNetChargeOffAmt(100.0);
		modelObj.setNetChargeOffAmt(500.0);
	}
	

	@Test
	public void testEnrich() throws EnrichmentException
	{		
		this.modelObj = this.enrichmentService.enrich(this.modelObj);
		Assert.assertEquals("179",modelObj.geteFedDelqSegmentId());
		Assert.assertEquals("9999",modelObj.geteFedAgeSegmentId());		
	}	
	

	@Test(expected = EnrichmentException.class)
	public void testEnrichWithNull() throws EnrichmentException
	{
		try {
			this.enrichmentService.enrich(null);
		} catch(EnrichmentException ex) {
			throw new EnrichmentException("Excetion","Module object is empty");
		}
	}
	
	@Test(expected = EnrichmentException.class)
	public void testEnrichWithEvaluationException() throws EnrichmentException
	{
		try {
			List<EnrichmentRule> list = new ArrayList<EnrichmentRule>();
			EnrichmentRule  rule = new EnrichmentRule();
			rule.setAttributeId(435);
			rule.setAttrName("ePortfolioDefinition");
			rule.setRuleToExecute("getRegion=(age>35?9999:3)");
			rule.setRule(parseSPEL(rule.getRuleToExecute()));
			list.add(rule);
			Assert.assertNotNull(enrichmentService.getEvalContext());
			Assert.assertNotNull(enrichmentService.getKeyList());
			this.enrichmentService.setEnrichmentRulesList(list);
			this.enrichmentService.enrich(this.modelObj);			
		} catch(EnrichmentException ex) {			
			List<EnrichmentExceptionDetail> enrichmentExceptionDetailList = ex.getExcetionDetailList();
			for (EnrichmentExceptionDetail enrichmentExceptionDetail : enrichmentExceptionDetailList) {
				Assert.assertNotNull(enrichmentExceptionDetail.getRule());
				Assert.assertNotNull(enrichmentExceptionDetail.getStackTrace());
				Assert.assertNotNull(enrichmentExceptionDetail.getAttributeName());
				Assert.assertNotNull(enrichmentExceptionDetail.getAttributeId());
				Assert.assertNotNull(enrichmentExceptionDetail.getExceptionMessage());
				Assert.assertNotNull(enrichmentExceptionDetail.getUserErrorMessage());
				Assert.assertNotNull(enrichmentExceptionDetail.getExceptionType());
				
			}
			throw new EnrichmentException("Excetion","Module object is empty",ex);
		}
	}
		
	@Test(expected = EnrichmentException.class)
	public void testAfterPropertiesSet() throws EnrichmentException
	{
		enrichmentService.setEvalContext(null);
		this.enrichmentService.afterPropertiesSet();
		
	}
	
	
	
	private Expression parseSPEL(String expr)  {
		return this.parser.parseExpression(expr);
	}
	
}
