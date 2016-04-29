package com.citi.retail.optima.etl.cache.loader.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.citi.retail.optima.etl.cache.dao.impl.SourceSystemDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.loaders.SourceSysCacheLoaderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class SourceSystemLoaderImplTest {

	@Autowired
	private SourceSystemDaoImpl srcSysDao;

	@Autowired
	private SourceSysCacheLoaderImpl srcSysLoader;

	@Test
	public void testRegionLoader() throws Exception {

		srcSysLoader.afterPropertiesSet();

		ReflectionTestUtils.setField(srcSysLoader, "dao", srcSysDao);
	}
}
