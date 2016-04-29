package com.citi.retail.optima.etl.context;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.reflection.util.OptimaRetailReflectionUtils;
import com.citi.retail.optima.etl.context.OptimaRetailCustomEvaluationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/retail.optima.etl.context.spel.xml" })
public class OptimaRetailCustomEvaluationContextTest {

	@Autowired
	private OptimaRetailCustomEvaluationContext evalContext;

	/**
	 * 
	 * @param evalContext
	 */
	public void setEvalContext(OptimaRetailCustomEvaluationContext evalContext) {
		this.evalContext = evalContext;
	}

	@Test
	public void testRegisterOptimaRetailEnrichFunction() throws Exception {
		assertTrue(this.evalContext.registerCustomFunction("getCardsMobBand",
				OptimaRetailReflectionUtils.getMethodReference(
						CustomMethodsProviderTest.class, "getCardsMobBand")));
		assertFalse(this.evalContext.registerCustomFunction("getCardsMobBand",
				OptimaRetailReflectionUtils.getMethodReference(
						CustomMethodsProviderTest.class, "")));
		assertFalse(this.evalContext.registerCustomFunction("getCardsMobBand",
				OptimaRetailReflectionUtils.getMethodReference(
						CustomMethodsProviderTest.class, "getCardsBand")));
	}

}
