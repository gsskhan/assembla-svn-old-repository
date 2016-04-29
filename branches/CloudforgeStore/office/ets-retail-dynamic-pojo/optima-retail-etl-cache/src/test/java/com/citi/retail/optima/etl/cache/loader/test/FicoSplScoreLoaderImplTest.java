package com.citi.retail.optima.etl.cache.loader.test;

import static org.junit.Assert.assertTrue;
import net.sf.ehcache.Ehcache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.citi.retail.optima.etl.cache.ehcache.FICOSplScoreCacheLoaderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class FicoSplScoreLoaderImplTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private FICOSplScoreCacheLoaderImpl ficoSplScrCacheLoader;

	@Test
	public void testReferenceLoader() throws Exception {

		this.ficoSplScrCacheLoader.afterPropertiesSet();

		Cache cache = (Cache) ReflectionTestUtils.getField(
				this.ficoSplScrCacheLoader, "cache");
		Ehcache ehcache = (Ehcache) cache.getNativeCache();

		assertTrue(ehcache.getKeys().size() > 0);
	}
}
