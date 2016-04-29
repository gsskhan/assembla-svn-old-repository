package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.citi.retail.optima.etl.cache.dao.impl.ValidationRulesDaoImpl;
import com.citi.retail.optima.etl.common.db.dao.ConstraintMapping;

/**
 * Tests whether the List of Validation rules are retrieved from the Database
 * properly.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.rules.xml",
		"/optima.retail.cache.test.xml" })
public class ValidationRulesDaoImplTest {

	@Autowired
	private ValidationRulesDaoImpl validationRulesDao;

	@Test
	public void testGetRulesData() throws Exception {
		Collection<ConstraintMapping> rules = validationRulesDao.getCacheData();
		Assert.assertNotNull("List of Constraint Rules cannot be null!", rules);
		Assert.assertTrue("List of Constraint Rules cannot be empty!",
				rules.size() > 0);
	}

}
