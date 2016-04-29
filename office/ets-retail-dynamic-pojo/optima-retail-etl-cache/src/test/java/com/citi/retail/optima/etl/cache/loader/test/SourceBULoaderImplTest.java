package com.citi.retail.optima.etl.cache.loader.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.citi.retail.optima.etl.cache.dao.impl.SourceBUDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.loaders.SourceBUCacheLoaderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class SourceBULoaderImplTest {

	@Autowired
	private SourceBUDaoImpl srcbuDao;

	@Autowired
	private SourceBUCacheLoaderImpl srcbuLoader;

	@Test
	public void testRegionLoader() throws Exception {

		srcbuLoader.afterPropertiesSet();

		ReflectionTestUtils.setField(srcbuLoader, "dao", srcbuDao);
	}
}
