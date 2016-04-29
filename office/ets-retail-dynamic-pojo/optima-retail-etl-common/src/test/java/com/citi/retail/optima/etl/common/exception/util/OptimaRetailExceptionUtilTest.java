/**
 * 
 */
package com.citi.retail.optima.etl.common.exception.util;

import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.common.exception.util.OptimaRetailExceptionUtil;

/**
 * @author mc56120
 * 
 */
public class OptimaRetailExceptionUtilTest {

	@Test
	public void testGetStackTrace() {
		try {
			throw new Exception();
		} catch (Exception e) {
			String stackTrace = OptimaRetailExceptionUtil.getStackTrace(e);
			Assert.assertNotNull(stackTrace);
		}

	}

}
