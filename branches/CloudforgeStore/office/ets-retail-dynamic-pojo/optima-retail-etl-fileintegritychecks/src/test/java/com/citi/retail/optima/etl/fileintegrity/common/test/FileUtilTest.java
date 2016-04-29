package com.citi.retail.optima.etl.fileintegrity.common.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.fileintegrity.common.FileUtil;
import com.citi.retail.optima.etl.fileintegrity.constants.FileIntegrityConstants;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;
/**
 * @author av51190
 * 
 */
public class FileUtilTest {
	
	
	@Test
	public void testGetStringFromColumns() {
		Set<Integer> orderSets = new HashSet<Integer>();
		String line = "AB,3,4,5,6";
		String delimiter = ",";			
		try {			
			orderSets.add(0);
			orderSets.add(1);		
			Assert.assertEquals("AB3", FileUtil.getStringFromColumns(line, orderSets, delimiter));
			orderSets.add(3);		
			Assert.assertEquals("AB35", FileUtil.getStringFromColumns(line, orderSets, delimiter));			
		} catch (FileIntegrityDataException e) {
			Assert.assertTrue(false);			
		}		
		orderSets.add(6);
		try{
			Assert.assertEquals("AB35", FileUtil.getStringFromColumns(line, orderSets, delimiter));
		}catch(FileIntegrityDataException e) {
			Assert.assertTrue(true);			
		}		
	}
	
	@Test
	public void testNoOfDelimitersMatch() {
		String line = "AB,3,4,5,6";
		String delimiter = ",";
		Assert.assertTrue(FileUtil.noOfColumnsMatch(line,delimiter,5));
		delimiter = ";";
		Assert.assertTrue(FileUtil.noOfColumnsMatch(line,delimiter,0));		
		line = "AB|3|4|5|6|7";
		delimiter="|";
		Assert.assertTrue(FileUtil.noOfColumnsMatch(line,delimiter,6));		
		line=null;
		Assert.assertTrue(FileUtil.noOfColumnsMatch(line,delimiter,0));
	}
	
	@Test
	public void testIsDataTypeMatchingForString() {
		String value = "ABCD123_ ";
		String regex = FileIntegrityConstants.REGEX_STRING;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
	}
	
	@Test
	public void testIsDataTypeMatchingForNumber() {
		String value = "123";
		String regex = FileIntegrityConstants.REGEX_NUMBER;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		Assert.assertFalse(FileUtil.fileTypeValidation("textfile"));
		Assert.assertFalse(FileUtil.dataTypeValidation("125","Sting"));
		Assert.assertTrue(FileUtil.dataTypeValidation("125","Integer"));	
	}
	
	@Test
	public void testIsDataTypeMatchingForNegativeNumber() {
		String value = "123";
		String regex = FileIntegrityConstants.REGEX_NEGATIVENUMBER;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
	}
	
	@Test
	public void testIsDataTypeMatchingForDecimalNumber() {
		String value = "123";
		String regex = FileIntegrityConstants.REGEX_DECIMALNUMBER;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "123.12";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
	}
	
	@Test
	public void testIsDataTypeMatchingForNegativeDecimalNumber() {
		String value = "123";
		String regex = FileIntegrityConstants.REGEX_NEGATIVEDECIMALNUMBER;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "123.12";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));	
	}
	
	@Test
	public void testIsDataTypeMatchingForNotNullString() {
		String value = "ABCD123_ ";
		String regex = FileIntegrityConstants.REGEX_STRING_NOTNULL;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
	}
	
	@Test
	public void testIsDataTypeMatchingForNotNullNumber() {
		String value = "123";
		String regex = FileIntegrityConstants.REGEX_NUMBER_NOTNULL;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
	}
	
	@Test
	public void testIsDataTypeMatchingForNegativeNotNullNumber() {
		String value = "123";
		String regex = FileIntegrityConstants.REGEX_NEGATIVENUMBER_NOTNULL;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
	}
	
	@Test
	public void testIsDataTypeMatchingForDecimalNotNullNumber() {
		String value = "123";
		String regex = FileIntegrityConstants.REGEX_DECIMALNUMBER_NOTNULL;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "123.12";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
	}
	
	@Test
	public void testIsDataTypeMatchingForNegativeDecimalNotNullNumber() {
		String value = "123";
		String regex = FileIntegrityConstants.REGEX_NEGATIVEDECIMALNUMBER_NOTNULL;
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "123.12";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
	}	
	
	@Test
	public void testIsDataTypeMatchingForCustomRegex() {
		String value = "123";
		String regex = "([\\d]{1,24})";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "1234567812345678123456782";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));

		value = "123";
		regex = "([0-9a-zA-Z_ ]{1,3})";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "-123";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "1234";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "-123.12";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "A";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "ABC";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		value = "ABCD";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "";
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = null;
		Assert.assertFalse(FileUtil.isDataTypeMatching(value, regex));
		value = "201307#PLSI014";
		regex = "([\\d]*)#([0-9a-zA-Z_ ]+)";
		Assert.assertTrue(FileUtil.isDataTypeMatching(value, regex));
		
	}
	
	@Test
	public void testIsEmpty(){		
		Assert.assertTrue(FileUtil.isEmpty(" "));
		Assert.assertTrue(FileUtil.isEmpty(null));
		Assert.assertTrue(FileUtil.isEmpty(""));
		Assert.assertFalse(FileUtil.isEmpty("ABC"));
		Assert.assertFalse(FileUtil.isEmpty("123"));
		Assert.assertFalse(FileUtil.isEmpty("-123"));
		Assert.assertFalse(FileUtil.isEmpty("-123.0"));
		Assert.assertFalse(FileUtil.isEmpty("123.0"));
	}
	
	@Test
	public void testExceedsMaxLength(){		
		Assert.assertTrue(FileUtil.exceedsMaxLength("ABC",2));
		Assert.assertTrue(FileUtil.exceedsMaxLength("-123456789.12345678912345",24));
		Assert.assertFalse(FileUtil.exceedsMaxLength("-123456789.123456789123",24));
		Assert.assertFalse(FileUtil.exceedsMaxLength("-123456789.123456789123",null));
		Assert.assertFalse(FileUtil.exceedsMaxLength("AV51190",7));
		Assert.assertTrue(FileUtil.exceedsMaxLength("AV511900",7));
		Assert.assertTrue(FileUtil.exceedsMaxLength("1234567891234567891234567",24));
		Assert.assertFalse(FileUtil.exceedsMaxLength("123456789123456789123456",24));
	}

}

