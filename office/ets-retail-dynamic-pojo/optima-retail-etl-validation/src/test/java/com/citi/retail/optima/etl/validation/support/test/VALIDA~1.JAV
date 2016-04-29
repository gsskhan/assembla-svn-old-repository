package com.citi.retail.optima.etl.validation.support.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.validation.support.ValidationCustomEvaluationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.validation.test.xml" })
public class ValidationCustomEvaluationContextTest {

	@Autowired
	private ValidationCustomEvaluationContext validationEvaluationContext;
	

	/**
	 * 
	 * @param evalContext
	 */
	public void setEvalContext(ValidationCustomEvaluationContext evalContext) {
		this.validationEvaluationContext = evalContext;
	}

	@Test
	public void testRegisterValidationFunction() throws Exception {
		assertTrue(this.validationEvaluationContext
				.registerCustomFunction(
						"getRegion",
						getMethodReference(com.citi.retail.optima.etl.validation.model.UserSubmissionBaseRecord.class,
										"getRegion")));		
	}
	@Test
	public void testRegisterValidationFunctionWithEmptyMethod() throws Exception {
		assertFalse(this.validationEvaluationContext
				.registerCustomFunction(
						"getRegion",
						getMethodReference(com.citi.retail.optima.etl.validation.model.UserSubmissionBaseRecord.class,
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
