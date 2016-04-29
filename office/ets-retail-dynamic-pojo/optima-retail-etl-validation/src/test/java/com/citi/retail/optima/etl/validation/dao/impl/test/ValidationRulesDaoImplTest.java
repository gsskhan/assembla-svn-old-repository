package com.citi.retail.optima.etl.validation.dao.impl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.validation.dao.impl.ValidationRulesDaoImpl;
import com.citi.retail.optima.etl.validation.exception.ValidationException;

/**
 * @author TJ
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.validation.test.xml"})

public class ValidationRulesDaoImplTest {
	
	@Autowired
	private ValidationRulesDaoImpl validationRulesDao;
	
	@Test
	public void testValidationRulesLoad() throws Exception {
		Assert.assertNotNull(this.validationRulesDao.getValidationRules("USCCARProcessStep:4"));
		Assert.assertTrue(this.validationRulesDao.getValidationRules("USCCARProcessStep:4").size() > 0);
	}

	@Test
	public void testSpelValidationRulesGetCacheData() throws Exception {
		Assert.assertNotNull(this.validationRulesDao
				.getValidationRules(""));
	}
	
	@Test
	public void testhandleExceptions() throws Exception {		
		Assert.assertNotNull(this.validationRulesDao
				.getValidationRules(""));
	}
	public void testSqlException() throws Exception {		
		Assert.assertNotNull(this.validationRulesDao
				.getValidationRules(""));
	}
	
	@Test(expected = ValidationException.class)
	public void testSetSQL() throws ValidationException
	{		
		validationRulesDao.setSql("");
		try {
			validationRulesDao.getValidationRules("USCCARProcessStep:4");
		} catch (ValidationException ex) {
			ValidationException exception = new ValidationException();
			Assert.assertNull(exception.getExceptionMessage());
			Assert.assertNull(exception.getExceptionTrace());
			Assert.assertNull(exception.getRootException());
			exception.setExceptionMessage("NO SQL");
			exception.setRootException("SQL Exception");
			exception.setExceptionTrace(ex.getExceptionTrace());
			
			throw exception;			
		}
		
	}


}
