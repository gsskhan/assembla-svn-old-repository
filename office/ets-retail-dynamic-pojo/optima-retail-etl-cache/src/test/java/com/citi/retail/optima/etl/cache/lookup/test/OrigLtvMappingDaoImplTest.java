package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.OrigLtvMappingDaoImpl;

/**
 * @author mc56120
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class OrigLtvMappingDaoImplTest {

	@Autowired
	private OrigLtvMappingDaoImpl ltvMappingDaoImpl;

	@Test
	public void testLtvRatioDao() throws Exception {
		Assert.assertTrue(this.ltvMappingDaoImpl.getCacheData().size() > 0);
		Assert.assertFalse(this.ltvMappingDaoImpl.getCacheData().size() == 0);
	}

}
