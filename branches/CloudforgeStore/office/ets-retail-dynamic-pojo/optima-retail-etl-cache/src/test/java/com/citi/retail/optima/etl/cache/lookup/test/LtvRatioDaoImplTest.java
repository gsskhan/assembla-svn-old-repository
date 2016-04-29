package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.OrigLtvBandDaoImpl;

/**
 * @author sr67841
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class LtvRatioDaoImplTest {

	@Autowired
	private OrigLtvBandDaoImpl ltvDaoImpl;

	@Test
	public void testLtvRatioDao() throws Exception {
		Assert.assertTrue(this.ltvDaoImpl.getCacheData().size() > 0);
		Assert.assertFalse(this.ltvDaoImpl.getCacheData().size() == 0);
	}

}
