package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.FileScannerRulesLookup;
import com.citi.retail.optima.etl.common.filescanner.FileValidationRules;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.test.xml", "/optima.retail.cache.rules.xml"})
@Ignore
public class FileScannnerRulesLookupTest {

	@Autowired
	private FileScannerRulesLookup  fileScannerRulesLookup;	
	
	@Test	
	public void testCCARValidationRules() throws Exception {

		FileValidationRules rules = this.fileScannerRulesLookup.getFileScannerRules("CCAR");
		Assert.assertNotNull("CCAR Rules cannot be null!", rules);
	}
	
	@Test
	public void testFDICValidationRules() throws Exception {

		FileValidationRules rules = this.fileScannerRulesLookup.getFileScannerRules("FDIC");
		Assert.assertNotNull("FDIC Rules cannot be null!", rules);
	}
	
}
