package com.citi.retail.optima.etl.fileintegrity.common.test;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.fileintegrity.common.ColumnRules;
import com.citi.retail.optima.etl.fileintegrity.common.FileValidationRules;

public class FileValidationRulesTest {
	
	FileValidationRules rules = new FileValidationRules();	
	ColumnRules columnRules1;
	ColumnRules columnRules2;
	
	@Test
	public void testRegexForCorrectDatatype() {
		SortedSet<ColumnRules> inputColumn = new TreeSet<ColumnRules>();		
		columnRules1 = new ColumnRules((long)1, "REPORTING_PERIOD", true, 0, "Integer", null,false);
		SortedSet<ColumnRules> inputColumn1 = new TreeSet<ColumnRules>();
		columnRules2 = new ColumnRules((long)1, "REPORTING_PERIOD", true, 0, "Int", null,false);
		inputColumn.add(columnRules1);
		inputColumn1.add(columnRules2);
		rules.setFunctionName("CCAR");
		rules.setColumnCount(1);		
		rules.setDelimiter(",");
		rules.setInputColumn(inputColumn);
		rules.prepareObject();
		Assert.assertTrue(columnRules1.getDuplicate());
		Assert.assertNotNull(columnRules1.getColumnId());
		Assert.assertNotNull(columnRules1.compareTo(columnRules2));
		Assert.assertNotNull(rules.getRegExString());
		Assert.assertNull(rules.getAcceptedValues());
		Assert.assertNull(rules.getRowCount());
		Assert.assertNotNull(rules.getAllowedExtentions());
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
