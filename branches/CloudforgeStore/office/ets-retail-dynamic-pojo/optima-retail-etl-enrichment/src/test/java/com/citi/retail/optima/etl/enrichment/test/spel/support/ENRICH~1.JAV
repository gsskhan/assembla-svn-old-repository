package com.citi.retail.optima.etl.enrichment.test.spel.support;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.enrichment.support.EnrichmentCustomEvaluationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.enrichment.config.test.xml" })
public class EnrichmentCustomEvaluationContextTest {

	@Autowired
	private EnrichmentCustomEvaluationContext evalContext;
		
	@Test
	public void testRegisterOptimaRetailEnrichFunction() throws Exception {
		assertTrue(this.evalContext
				.registerCustomFunction(
						"getRegion",
						getMethodReference(com.citi.retail.optima.etl.enrichment.model.UserSubmissionBaseRecord.class,
										"getRegion")));		
	}
	

	@Test
	public void testRegisterOptimaRetailEnrichFunctionWithEmptyMethod() throws Exception {
		assertFalse(this.evalContext
				.registerCustomFunction(
						"getRegion",
						getMethodReference(com.citi.retail.optima.etl.enrichment.model.UserSubmissionBaseRecord.class,
										"")));		
	}

	
	/**
	 * Helper Method that returns the method signature/reference for the given
	 * method name in the specified class passed to it. See
	 * <code>com.citi.retail.optima.etl.context.OptimaRetailCustomEvaluationContext</code>
	 * 
	 * @param classObj
	 * @param methodName
	 * @return Method
	 */
	public static Method getMethodReference(Class<?> classObj, String methodName) {

		if (classObj != null && methodName != null) {

			Method[] classMethods = classObj.getMethods();

			if (classMethods == null || classMethods.length == 0) {			
				return null;
			}
			for (Method m : classMethods) {
				if (m.getName().equals(methodName)) {
					return m;
				}
			}
		} else {
			
			return null;
		}
		return null;
	}

}
