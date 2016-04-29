package com.citi.retail.optima.etl.validation.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.constraint.impl.SPELRuleConstraint;
import com.citi.retail.optima.etl.validation.exception.FieldError;
import com.citi.retail.optima.etl.validation.exception.ValidationDataException;
import com.citi.retail.optima.etl.validation.exception.ValidationException;
import com.citi.retail.optima.etl.validation.model.UserSubmissionFDICRecord;
import com.citi.retail.optima.etl.validation.support.ValidationCustomEvaluationContext;
import com.citi.retail.optima.etl.validation.validator.impl.SPELidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.validation.test.xml"})
public class SPELidatorTest {
	
	private UserSubmissionFDICRecord modelObj;
	
	@Autowired
	private SPELidator spelidator;
	
	@Autowired
	private ValidationCustomEvaluationContext validationEvaluationContext;
	
	private List<RuleConstraint> rulesList;
	
	@Before
	public void setUp() {
		rulesList = new ArrayList<RuleConstraint>();
		SPELRuleConstraint ruleConstraint = new SPELRuleConstraint();
		ruleConstraint.setAttributeId(1);
		ruleConstraint.setAttributeName("rptPeriod");
		rulesList.add(ruleConstraint);
		this.modelObj = new UserSubmissionFDICRecord();
		this.modelObj.setRegion("USA");
		this.modelObj.setRptPeriod(201311);
		this.modelObj.setBusinessUnit("XYZ");
		this.modelObj.setProductType("CA_AB");
		this.modelObj.setCreditBureau("CA_AB");
		this.modelObj.setModelVersion("CA_AB");
		this.modelObj.setModelScore(12);
		this.modelObj.setEnrAmt(new Double(12.12));
		this.modelObj.setCountry("US");
		this.modelObj.setDataVersion(new Double(23));
		this.spelidator.setRulesList(rulesList);
		this.spelidator.setEvalContext(validationEvaluationContext);
	}

	@Test(expected = ValidationDataException.class)
	public void testValidateWithNull() throws ValidationDataException, ValidationException {	
		try {
			this.spelidator.validate(null); 		
		} catch(ValidationDataException ex) {
			List<FieldError> errors = ex.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(error.getAttributeName());
				System.out.println(error.getExceptionMessage());
				System.out.println(error.getRule());
				System.out.println(error.getStackTrace());
				System.out.println(error.getUserErrorMessage());
				System.out.println(error.toString());
				System.out.println(error.getExceptionType());
				System.out.println(error.getRuleId());
				System.out.println(error.getAttributeId());
			}			
			throw ex;
		}
			
	}
	
	@Test(expected = ValidationDataException.class)
	public void testValidationWithEmptyEvaContest() throws Exception {
		SPELRuleConstraint constant = new SPELRuleConstraint();
		constant.setRulesKey("USCCARProcessStep:4");
		SpelExpressionParser parser = new SpelExpressionParser();
		constant.setRule(parser.parseExpression("modelScore eq 20"));
		constant.setAuditValuesExpr(parser.parseExpression("rptBasis eq 1"));	
		constant.setAttributeId(303);
		constant.setRuleOrder(1);
		List<RuleConstraint> list = new ArrayList<RuleConstraint>();
		list.add(constant);
		spelidator.setRulesList(list);
		this.spelidator.validate(modelObj);				
		list = spelidator.getRulesList();
		RuleConstraint ruleConstraint = list.get(0);
		Assert.assertNotNull(ruleConstraint.getSysProcId());
		Assert.assertNotNull(ruleConstraint.getRulesKey());
		Assert.assertNotNull(constant.getRuleOrder());
		
	}
	
	@Test(expected = ValidationException.class)
	public void testAfterPropertiesSet() throws Exception {
		this.spelidator.setEvalContext(null);
//		this.spelidator.afterPropertiesSet();		
	}
	
	
	@Test
	public void testValidate() throws Exception {
		try {
			this.spelidator.setRulesList(null);
			this.spelidator.validate(null);
		} catch (Exception ex) {
			Assert.fail();
		}
		
				
	}
	
}
