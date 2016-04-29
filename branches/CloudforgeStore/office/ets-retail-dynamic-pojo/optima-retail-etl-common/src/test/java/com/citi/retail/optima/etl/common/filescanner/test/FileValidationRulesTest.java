package com.citi.retail.optima.etl.common.filescanner.test;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.common.filescanner.ColumnRules;
import com.citi.retail.optima.etl.common.filescanner.FileValidationRules;

public class FileValidationRulesTest {
	
	FileValidationRules rules = new FileValidationRules();	
	ColumnRules columnRules1;
	ColumnRules columnRules2;
	
	@Test
	public void testRegexForCorrectDatatype() {
		SortedSet<ColumnRules> inputColumn = new TreeSet<ColumnRules>();
		columnRules1 = new ColumnRules((long)1, "REPORTING_PERIOD", true, 0, "Integer", null,false);
		inputColumn.add(columnRules1);
		rules.setFunctionName("CCAR");
		rules.setColumnCount(1);		
		rules.setDelimiter(",");
		rules.setInputColumn(inputColumn);
		rules.prepareObject();
		Assert.assertNotNull(rules.getRegExString());
	}
	
	@Test
	public void testRegexForFalseDatatype() {
		SortedSet<ColumnRules> inputColumn = new TreeSet<ColumnRules>();
		columnRules1 = new ColumnRules((long)1, "REPORTING_PERIOD", true, 0, "Int", null,false);
		inputColumn.add(columnRules1);
		rules.setFunctionName("CCAR");
		rules.setColumnCount(1);		
		rules.setDelimiter(",");
		rules.setInputColumn(inputColumn);
		rules.prepareObject();
		Assert.assertNotEquals(null, rules.getRegExString());
	}	
	
}
