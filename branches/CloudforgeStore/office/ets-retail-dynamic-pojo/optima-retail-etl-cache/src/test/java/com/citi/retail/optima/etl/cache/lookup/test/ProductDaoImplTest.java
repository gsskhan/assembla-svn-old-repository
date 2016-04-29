package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.ProductDaoImpl;

/**
 * @author sr67841
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
@Ignore
public class ProductDaoImplTest {

	@Autowired
	private ProductDaoImpl productDaoImpl;


	@Test
	public void testProductDao() throws Exception {
		Assert.assertTrue(this.productDaoImpl.getProductDetails().size() > 0);
		Assert.assertFalse(this.productDaoImpl.getProductDetails().size() == 0);
	}

}
