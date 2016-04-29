package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.Map.Entry;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.SingleValueCacheLoaderDaoImpl;

/**
 * @author hs73849
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class BusinessUnitDaoImplTest {

	@Autowired
	@Qualifier("businessUnitDaoImpl")
	private SingleValueCacheLoaderDaoImpl<String, String> businessUnitDaoImpl;
	
	@Test
	public void testAgeDao() throws Exception {
		Set<Entry<String, String>> regionSet = businessUnitDaoImpl.getEntrySet();
		Assert.assertTrue(regionSet.size() > 0);
		Assert.assertFalse(regionSet.size() == 0);
	}
}