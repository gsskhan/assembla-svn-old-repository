/**
 * 
 */
package com.citi.retail.optima.etl.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hs73849
 * 
 */
public class OptimaRetailExceptionDetailTest {

	private OptimaRetailDataExceptionDetail exceptionDetail;

	@Before
	public void setUp() {
		exceptionDetail = new OptimaRetailDataExceptionDetail();
	}

	@Test
	public void testSetAccountTraceInfoList() {
		exceptionDetail.setRule("RULE_TEST");
		Assert.assertEquals("RULE_TEST", exceptionDetail.getRule());

		exceptionDetail.setStackTrace("STACK_TRACE");
		Assert.assertEquals("STACK_TRACE", exceptionDetail.getStackTrace());

		exceptionDetail.setAttributeName("AttributeName");
		Assert.assertEquals("AttributeName", exceptionDetail.getAttributeName());

		exceptionDetail.setUserErrorMessage("UserErrorMessage");
		Assert.assertEquals("UserErrorMessage",
				exceptionDetail.getUserErrorMessage());

		exceptionDetail.setExceptionMessage("ExceptionMessage");
		Assert.assertEquals("ExceptionMessage",
				exceptionDetail.getExceptionMessage());

		exceptionDetail.setExceptionType(ExceptionType.ERROR);
		Assert.assertEquals(ExceptionType.ERROR,
				exceptionDetail.getExceptionType());

		Map<String, String> otherAttributesMap = new HashMap<String, String>();

		otherAttributesMap.put("KEY1", "VALUE1");
		otherAttributesMap.put("KEY2", "VALUE2");

		exceptionDetail.setOtherAttributesMap(otherAttributesMap);
		Assert.assertNotNull(exceptionDetail.getOtherAttributesMap());

		Assert.assertNotNull(exceptionDetail.toString());
		Assert.assertNotNull(exceptionDetail.convertMaptoJsonString());

	}

}
