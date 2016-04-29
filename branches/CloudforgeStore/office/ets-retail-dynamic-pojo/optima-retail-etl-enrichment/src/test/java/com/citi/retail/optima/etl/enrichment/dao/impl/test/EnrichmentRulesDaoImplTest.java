package com.citi.retail.optima.etl.enrichment.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.enrichment.dao.impl.EnrichmentRulesDaoImpl;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentException;
import com.citi.retail.optima.etl.enrichment.exception.EnrichmentExceptionDetail;
import com.citi.retail.optima.etl.enrichment.exception.ExceptionType;

/**
 * @author TJ
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.enrichment.config.test.xml"})
public class EnrichmentRulesDaoImplTest {
	
	@Autowired
	private EnrichmentRulesDaoImpl enrichmentRulesDao;
		
	@Test
	public void testGetEnrichmentRules() throws Exception {
		Assert.assertNotNull(this.enrichmentRulesDao.getEnrichmentRules("USCCARProcessStep:1"));
		Assert.assertTrue(this.enrichmentRulesDao.getEnrichmentRules("USCCARProcessStep:1").size() > 0);
	}

	@Test
	public void testGetEnrichmentRulesWithArugument() throws Exception {
		Assert.assertNotNull(this.enrichmentRulesDao
				.getEnrichmentRules(""));
	}
	
	@Test(expected = EnrichmentException.class)
	public void testSetSQL() throws EnrichmentException
	{		
		enrichmentRulesDao.setSql("");
		try {
			enrichmentRulesDao.getEnrichmentRules("USCCARProcessStep:1");
		} catch (EnrichmentException ex) {
			EnrichmentException exception = new EnrichmentException();
			Assert.assertNull(exception.getExceptionMessage());
			Assert.assertNull(exception.getExceptionTrace());
			Assert.assertNull(exception.getRootException());
			exception.setExceptionMessage("NO SQL");
			exception.setRootException("SQL Exception");
			exception.setExceptionTrace(ex.getExceptionTrace());
			EnrichmentExceptionDetail detal = new EnrichmentExceptionDetail();
			ExceptionType type = ExceptionType.ERROR;
			detal.setExceptionType(type);
			List<EnrichmentExceptionDetail> list = new ArrayList<EnrichmentExceptionDetail>();
			list.add(detal);
			exception.setExcetionDetailList(list);
			throw exception;			
		}
		
	}
	

}
