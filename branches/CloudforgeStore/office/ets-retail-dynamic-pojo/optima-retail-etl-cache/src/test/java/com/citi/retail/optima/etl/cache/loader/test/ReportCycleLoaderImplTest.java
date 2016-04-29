package com.citi.retail.optima.etl.cache.loader.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.citi.retail.optima.etl.cache.dao.impl.ReportCycleDaoImpl;
import com.citi.retail.optima.etl.cache.ehcache.loaders.ReportingCycleCacheLoaderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.test.xml",
		"/optima.retail.cache.test.xml" })
public class ReportCycleLoaderImplTest {

	@Autowired
	private ReportCycleDaoImpl rptCycleDao;

	@Autowired
	private ReportingCycleCacheLoaderImpl rptCycleCacheLoader;

	@Test
	public void testReferenceLoader() throws Exception {

		rptCycleCacheLoader.afterPropertiesSet();

		ReflectionTestUtils.setField(rptCycleCacheLoader, "dao", rptCycleDao);
	}
}
