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

import com.citi.retail.optima.etl.validation.ValidationRulesLoader;
import com.citi.retail.optima.etl.validation.constraint.RuleConstraint;
import com.citi.retail.optima.etl.validation.constraint.impl.SPELRuleConstraint;
import com.citi.retail.optima.etl.validation.exception.ValidationDataException;
import com.citi.retail.optima.etl.validation.exception.ValidationException;
import com.citi.retail.optima.etl.validation.model.UserSubmissionFDICRecord;

/**
 * 
 * @author sv16441
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.validation.test.xml"})
public class ValidationServiceImplTest {

	private UserSubmissionFDICRecord modelObj;


	@Autowired
	private ValidationServiceImpl<UserSubmissionFDICRecord> validationService;
	
	private ValidationRulesLoader rulesLoader;

	@Before
	public void setUp() {
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
		List<String> keyList = new ArrayList<String>();
		keyList.add("suppDataProcessStep:19");
		validationService.setKeyList(keyList);
		validationService.setProcessingUnitIdsString("19");
		rulesLoader =validationService.getRulesLoader();
	}

	@Test(expected = ValidationException.class)
	public void testValidate() throws ValidationDataException, ValidationException {	
		try {
			Assert.assertNotNull(this.validationService.getRulesLoader());
			Assert.assertNotNull(this.validationService.getKeyList());
			Assert.assertNotNull(this.validationService.getProcessingUnitIdsString());
			Assert.assertNull(this.validationService.validate(this.modelObj));	
		} catch(ValidationException ex) {
			System.out.println(ex.getExceptionMessage());
			System.out.println(ex.getExceptionTrace());
			System.out.println(ex.getRootException());
			System.out.println(ex.getExceptionMessage());
			throw new ValidationException("Excetion");
		}
		 		
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateWithValidExcetionMessage() throws ValidationDataException, ValidationException {	
		try {
			Assert.assertNull(this.validationService.validate(this.modelObj));	
		} catch(ValidationException ex) {			
			throw new ValidationException("Excetion","Rules not loaded");
		}		 		
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateWithoutExcetionMessage() throws ValidationDataException, ValidationException {	
		try {
			Assert.assertNull(this.validationService.validate(this.modelObj));	
		} catch(ValidationException ex) {			
			throw new ValidationException();
		}		 		
	}
		
}
