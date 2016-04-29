package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.SourceBUDaoImpl;

/**
 * @author sr67841
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class SourceBUDaoImplTest {

	@Autowired
	private SourceBUDaoImpl srcBUDao;

	@Test
	public void testSourceRgnDao() throws Exception {
		Assert.assertTrue(srcBUDao.getCacheData().size() > 0);
		Assert.assertFalse(srcBUDao.getCacheData().size() == 0);
	}

}
