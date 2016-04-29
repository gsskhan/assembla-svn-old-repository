package com.citi.retail.optima.etl.validation.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.constraint.impl.SPELRuleConstraint;
import com.citi.retail.optima.etl.validation.exception.ValidationDataException;
import com.citi.retail.optima.etl.validation.exception.ValidationException;
import com.citi.retail.optima.etl.validation.model.TestFedOutput;
import com.citi.retail.optima.etl.validation.support.ValidationCustomEvaluationContext;
import com.citi.retail.optima.etl.validation.validator.impl.SPELidator;

/**
 * 
 * @author av51190
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceImplNoCacheTest {

	private TestFedOutput modelObj;

	private List<RuleConstraint> validationRulesSet;
	
	@InjectMocks
	private ValidationServiceImpl<TestFedOutput> validationService;

	private ValidationCustomEvaluationContext evalContext;

	private SpelExpressionParser parser;

	@Before
	public void setUp() {
		parser = new SpelExpressionParser();
		this.modelObj = new TestFedOutput();
		this.validationRulesSet = new ArrayList<RuleConstraint>();
		setUpEvalContext();
		setUpValidator();
	}

	private void setUpValidator() {
		SPELidator<TestFedOutput> spel = new SPELidator<TestFedOutput>();
		spel.setEvalContext(evalContext);
		validationService.setValidator(spel);
	}
	
	private void setRuleList(){
		validationService.getValidator().setRulesList(this.validationRulesSet);
	}
	
	private void addRule(RuleConstraint rc){
		this.validationRulesSet.add(rc);
	}

	@Test
	public void testValidateNAccount() throws ValidationException {
		addRule(createRule("numberAccounts", "numberAccounts ge 0",
				"N_ACCT must not have a negative value"));
		setRuleList();
		
		this.modelObj.setNumberAccounts(0);
		validate(true);

		this.modelObj.setNumberAccounts(-1);
		validate(false);
		
		this.modelObj.setNumberAccounts(15);
		validate(true);
	}
	
	@Test
	public void testValidateReceivable() throws ValidationException {
		
		addRule(createRule("dollarAmtReceivables",
				"dollarAmtReceivables ge 0",
				"D_RECEIVABLES must not have a negative value"));
		setRuleList();
		
		this.modelObj.setDollarAmtReceivables(0.00);
		validate(true);
		
		this.modelObj.setDollarAmtReceivables(10.00);
		validate(true);
		
		this.modelObj.setDollarAmtReceivables(-20.00);
		validate(false);
		
	}
	
	@Test
	public void testValidateNAccountWithReceivables() throws ValidationException {
		addRule(createRule(
				"numberAccounts",
				"numberAccounts gt 0?(dollarAmtReceivables gt 0?true:false):true",
				"D_RECEIVABLES is greater than zero so N_ACCT must be greater than zero"));
		addRule(createRule(
				"dollarAmtReceivables",
				"dollarAmtReceivables eq 0?(numberAccounts eq 0?true:false):true",
				"A null or a zero value was provided for N_ACCT so D_RECEIVABLES must also have a value of null or zero"));
		addRule(createRule(
				"dollarAmtReceivables",
				"dollarAmtReceivables gt 0?(numberAccounts gt 0?true:false):true",
				"N_ACCT is greater than zero so D_RECEIVABLES must be greater than zero."));
		setRuleList();
		
		this.modelObj.setNumberAccounts(0);
		this.modelObj.setDollarAmtReceivables(0.00);
		validate(true);

		this.modelObj.setNumberAccounts(-1);
		validate(false);

		this.modelObj.setNumberAccounts(15);
		validate(false);

		this.modelObj.setDollarAmtReceivables(1200.00);
		validate(true);

		this.modelObj.setDollarAmtReceivables(-100.00);
		validate(false);
		
		this.modelObj.setNumberAccounts(-1);
		validate(true);
	}
		
	@Test
	public void testValidateNAccountWithUpb() throws ValidationException {
		addRule(createRule(
				"numberAccounts",
				"numberAccounts gt 0?(unpaidPrincipalBalance gt 0? true:false):true",
				"D_UNPD_PRIN_BALA is greater than zero so N_ACCT must be greater than zero."));
		
		setRuleList();
		
		this.modelObj.setNumberAccounts(0);
		this.modelObj.setUnpaidPrincipalBalance(0.0);
		validate(true);
		
		
		this.modelObj.setUnpaidPrincipalBalance(1200.00);
		validate(false);
		
		this.modelObj.setNumberAccounts(15);
		validate(true);
		
		this.modelObj.setUnpaidPrincipalBalance(-1200.00);
		validate(false);
		
		this.modelObj.setNumberAccounts(0);
		validate(true);
		
	}
	
	@Test
	public void testValidateReceivablesWithUpb() throws ValidationException {
		addRule(createRule(
				"dollarAmtReceivables",
				"dollarAmtReceivables ge unpaidPrincipalBalance",
				"Reported value for D_RECEIVABLES must be greater than or equal to DUNPDPRINBALA."));
		setRuleList();
	
		this.modelObj.setDollarAmtReceivables(0.0);
		this.modelObj.setUnpaidPrincipalBalance(0.0);
		validate(true);
		
		this.modelObj.setUnpaidPrincipalBalance(1200.00);
		validate(false);
		
		this.modelObj.setDollarAmtReceivables(1500.00);
		validate(true);
		
	}
	
	@Test
	public void testValidateCommitments() throws ValidationException {
		addRule(createRule(
				"numberAccounts",
				"numberAccounts gt 0?(dollarAmtCommitments gt 0?true:false):true",
				"D_COMMITMENTS is greater than zero so N_ACCT must be greater than zero"));	
		setRuleList();
		
		this.modelObj.setNumberAccounts(0);
		this.modelObj.setDollarAmtCommitments(0.0);
		validate(true);
		
		this.modelObj.setDollarAmtCommitments(1200.00);
		validate(false);

		this.modelObj.setNumberAccounts(20);
		validate(true);

		this.modelObj.setDollarAmtCommitments(0.0);
		validate(false);
		
	}

	private void validate(boolean isValid) throws ValidationException {
		try {
			this.validationService.validate(this.modelObj);
		} catch (ValidationDataException e) {
			//e.printStackTrace();
			Assert.isTrue(!isValid);
		}
	}
	
	private SPELRuleConstraint createRule(String attributeNm,
			String ruleAsString, String errMsg) {
		return createRule(attributeNm, ruleAsString, errMsg, "");
	}

	private SPELRuleConstraint createRule(String attributeNm,
			String ruleAsString, String errMsg, String auditValExpr) {
		SPELRuleConstraint rule = new SPELRuleConstraint();
		rule.setAttributeName(attributeNm);
		rule.setRuleAsString(ruleAsString);
		rule.setViolationMsg(errMsg);
		((SPELRuleConstraint) rule).setRule(parser.parseExpression(rule
				.getRuleAsString()));
		if (rule.getAuditValuesExprAsString() != null
				&& !"".equals(rule.getAuditValuesExprAsString())) {
			((SPELRuleConstraint) rule).setAuditValuesExpr(parser
					.parseExpression(rule.getAuditValuesExprAsString()));
		}
		return rule;
	}

	private void setUpEvalContext() {
		this.evalContext = new ValidationCustomEvaluationContext();
		this.evalContext.setRootObject(modelObj);

	}

}
