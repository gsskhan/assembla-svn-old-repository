package com.citi.retail.optima.etl.common.test.reflection.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.reflection.util.OptimaRetailReflectionUtils;

/**
 * @author ms04453
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/retail.optima.etl.logging.exception.publisher.test.xml" })
public class OptimaRetailReflectionUtilsTest {

	@Test
	public void testGetMethodReference() {
		/*
		 * Calling Get method Reference with an existent method name from a
		 * valid Mock Class
		 */
		assertNotNull(OptimaRetailReflectionUtils.getMethodReference(
				MockEnrichmentProvider.class, "getCardsMobBand"));
		/*
		 * Calling Get method Reference with a empty method name from a valid
		 * Mock Class
		 */
		assertNull(OptimaRetailReflectionUtils.getMethodReference(
				MockEnrichmentProvider.class, ""));
		/*
		 * Calling Get method Reference with a non existent method name from a
		 * valid Mock Class
		 */
		assertNull(OptimaRetailReflectionUtils.getMethodReference(
				MockEnrichmentProvider.class, "getCardsBand"));

	}
}
