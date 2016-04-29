/**
 * 
 */
package com.citi.retail.optima.etl.batch.job.infra.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import com.citi.retail.optima.etl.batch.job.infra.ProcessType;

/**
 * @author mc56120
 * 
 */
public class ProcessTypesTest {

	@Mock
	private ProcessType processTypes;

	@Test
	public void testProcessTypes() {
		Assert.assertEquals("BATCH", ProcessType.BATCH.toString());
		Assert.assertEquals("AGGRE", ProcessType.AGGRE.toString());
		Assert.assertEquals("ENRIC", ProcessType.ENRIC.toString());
	}
}
