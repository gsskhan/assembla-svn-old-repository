package com.citi.retail.optima.etl.fileintegrity.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.fileintegrity.dao.impl.FileIntegrityRulesDaoImpl;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityException;


public class FileIntegrityRulesDaoImplTest {
	
	private FileIntegrityRulesDaoImpl dao;	
	
	@Before
	public void init() throws Exception {
		dao = new FileIntegrityRulesDaoImpl();	
	}
	
	@Test(expected = FileIntegrityException.class)
	public void testFetFileValitionRulesData() throws  FileIntegrityException {
		try {
			dao.getValidationRules();	
		} catch(FileIntegrityException ex) {
			Assert.assertNull(dao.getRuleFileNames());
			throw ex;
		}		
	}

}
