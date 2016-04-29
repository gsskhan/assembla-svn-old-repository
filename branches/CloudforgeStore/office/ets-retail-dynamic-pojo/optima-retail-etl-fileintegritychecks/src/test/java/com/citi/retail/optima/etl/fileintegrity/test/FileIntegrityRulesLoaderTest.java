package com.citi.retail.optima.etl.fileintegrity.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.fileintegrity.FileIntegrityRulesLoader;
import com.citi.retail.optima.etl.fileintegrity.common.FileValidationRules;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/optima.retail.fileintegritychecks.test.xml"})
public class FileIntegrityRulesLoaderTest {

	@Autowired
	private  FileIntegrityRulesLoader fileIntegrityRulesLoader;
	
	
	@Test
	public void testGetRulesList() throws Exception {
		FileValidationRules fileValidationRules = fileIntegrityRulesLoader.getRulesList("CCAR");
		Assert.assertNotNull(fileValidationRules);		
	}
	
	@Test
	public void testEmptyRulesList() throws Exception {
		FileValidationRules fileValidationRules = fileIntegrityRulesLoader.getRulesList("TEST");
		Assert.assertNull(fileValidationRules);		
	}


}
