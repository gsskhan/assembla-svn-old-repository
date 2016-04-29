package com.citi.retail.optima.etl.common;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hs73849
 *
 */
public class ServiceNameTest {

	@Test
	public void testAGGREGATION() {
		Assert.assertEquals("AGGREGATION", ServiceName.AGGREGATION.name());
	}

	@Test
	public void testENRICHMENT() {
		Assert.assertEquals("ENRICHMENT", ServiceName.ENRICHMENT.name());
	}

	@Test
	public void testVALIDATION() {
		Assert.assertEquals("VALIDATION", ServiceName.VALIDATION.name());
	}

	@Test
	public void testBATCH() {
		Assert.assertEquals("BATCH", ServiceName.BATCH.name());
	}

	@Test
	public void testCONTROLLER() {
		Assert.assertEquals("CONTROLLER", ServiceName.CONTROLLER.name());
	}

	@Test
	public void testCACHE() {
		Assert.assertEquals("CACHE", ServiceName.CACHE.name());
	}
}
