/**
 * 
 */
package com.citi.retail.optima.etl.cache.lookup.test;

import java.util.Set;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.dao.impl.GeographyCacheDaoImpl;
import com.citi.retail.optima.etl.cache.dao.impl.SingleValueCacheLoaderDaoImpl;
import com.citi.retail.optima.etl.cache.model.GeographyVO;

/**
 * @author mc56120
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class GeographyDaoImplTest {

	@Autowired
		private GeographyCacheDaoImpl geographyDaoImpl;


	@Test
	public void testRegionDao() throws Exception {
		Assert.assertTrue(this.geographyDaoImpl.getCacheData().size() > 0);
		Assert.assertFalse(this.geographyDaoImpl.getCacheData().size() == 0);
	}	
}
