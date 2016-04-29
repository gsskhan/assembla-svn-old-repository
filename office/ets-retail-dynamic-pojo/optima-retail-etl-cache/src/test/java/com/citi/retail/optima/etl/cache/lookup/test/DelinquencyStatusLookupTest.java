package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.DelqBandLookup;

/**
 * @author sr67841
 * 
 */

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class DelinquencyStatusLookupTest {

	@Autowired
	private DelqBandLookup delqBandLookup;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Test
	public void testDelQBandLookup() throws Exception {
		Assert.assertTrue(this.delqBandLookup
				.getDelqSegmentationValue(2, 58, "User Reference").getSegCode()
				.equals(3));
		Assert.assertEquals("30",this.delqBandLookup
				.getOutputSegmentationId(2, 3, "User Reference", "Fed Reference"));		
	}

	@Test
	public void testDelQMapingLookup() throws Exception {

		Assert.assertTrue(this.delqBandLookup
				.deriveOutputSegmentation(2, 3, "User Reference", "Fed Reference")
				.getSegVal().equals("02"));
		Assert.assertTrue(this.delqBandLookup
				.deriveOutputSegmentation(2, 3, "User Reference", "PEARL")
				.getSegVal().equals("30+"));
		Assert.assertTrue(this.delqBandLookup
				.deriveOutputSegmentation(2, 1, "User Reference", "PEARL")
				.getSegVal().equals("-30"));
		Assert.assertTrue(this.delqBandLookup
				.deriveOutputSegmentation(2, 7, "User Reference", "PEARL")
				.getSegVal().equals("90+"));
	}
}