package com.citi.retail.optima.etl.common.exception.util;

import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.common.exception.ExceptionType;

/**
 * @author hs73849
 * 
 */
public class ExceptionTypeTest {

	@Test
	public void testExceptionTypes() {
		Assert.assertEquals("ERROR", ExceptionType.ERROR.name());
		Assert.assertEquals("FATAL", ExceptionType.FATAL.name());
		Assert.assertEquals("NONSKIPPABLE", ExceptionType.NONSKIPPABLE.name());
		Assert.assertEquals("SKIPPABLE", ExceptionType.SKIPPABLE.name());
		Assert.assertEquals("WARNING", ExceptionType.WARNING.name());
	}
}
