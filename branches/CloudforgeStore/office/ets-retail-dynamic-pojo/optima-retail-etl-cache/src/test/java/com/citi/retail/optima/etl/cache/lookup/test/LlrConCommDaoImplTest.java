package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.LlrConCommDaoImpl;

/**
 * @author sr67841
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class LlrConCommDaoImplTest {

	@Autowired
	private LlrConCommDaoImpl llrConCommDao;

	@Test
	public void testFicoDao() throws Exception {
		Assert.assertTrue(llrConCommDao.getCacheData().size() > 0);
		Assert.assertFalse(llrConCommDao.getCacheData().size() == 0);
	}

}
