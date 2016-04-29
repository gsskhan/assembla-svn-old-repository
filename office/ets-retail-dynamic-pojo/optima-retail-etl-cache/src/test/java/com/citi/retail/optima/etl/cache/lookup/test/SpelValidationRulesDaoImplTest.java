package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.SpelValidationRulesDaoImpl;

/**
 * @author sv16441
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class SpelValidationRulesDaoImplTest {

	@Autowired
	private SpelValidationRulesDaoImpl spelValidationRulesDao;

	@Test
	public void testSpelValidationRulesLoad() throws Exception {
		Assert.assertNotNull(this.spelValidationRulesDao.getCacheData());
		Assert.assertTrue(this.spelValidationRulesDao.getCacheData().size() > 0);
	}

	@Test
	public void testSpelValidationRulesGetCacheData() throws Exception {
		Assert.assertNotNull(this.spelValidationRulesDao
				.getCacheData(new Object[0]));
	}
}
