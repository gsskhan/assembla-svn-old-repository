package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.SingleValueCacheLoaderDaoImpl;

/**
 * @author TJ
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
@Ignore
public class FDICRegionDaoImplTest {

	@Autowired
	@Qualifier("fdicRegionDaoImpl")
	private SingleValueCacheLoaderDaoImpl<String, String> regionDaoImpl;


	@Test
	public void testRegionDao() throws Exception {
		Set<Entry<String, String>> regionSet = regionDaoImpl.getEntrySet();
		Assert.assertTrue(regionSet.size() > 0);
		Assert.assertFalse(regionSet.size() == 0);
	}

}
