package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.PortfolioDefinitionLookup;
import com.citi.retail.optima.etl.common.model.cache.PortfolioDefinitionVO;

/**
 * 
 * @author av51190
 *
 */
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class PortfolioDefinitionLookupTest {	
	@Autowired
	private PortfolioDefinitionLookup portfolioDefinitionLookup;

	@Test
	public void testPortfolioLookup() throws Exception {
		PortfolioDefinitionVO portDefnitionVo = this.portfolioDefinitionLookup.getPortfolioDefinition("CNUI004,2,2012");
		Assert.assertTrue(portDefnitionVo!=null);		
		
		portDefnitionVo = this.portfolioDefinitionLookup.getPortfolioDefinition("CNUI004",201206);
		Assert.assertTrue(portDefnitionVo!=null);	
		portDefnitionVo=null;
		
		//portfolio not present
		portDefnitionVo = (PortfolioDefinitionVO)this.portfolioDefinitionLookup.getPortfolioDefinition("C1001");
		Assert.assertNull(portDefnitionVo);
	}
}
