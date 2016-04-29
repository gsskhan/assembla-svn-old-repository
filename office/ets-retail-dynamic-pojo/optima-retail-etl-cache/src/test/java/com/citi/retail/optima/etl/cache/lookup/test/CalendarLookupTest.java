package com.citi.retail.optima.etl.cache.lookup.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.cache.lookup.ReferenceValueLookup;
import com.citi.retail.optima.etl.cache.model.CalendarVO;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;

/**
 * 
 * @author mc56120
 *
 */
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.cache.referencedata.xml",
		"/optima.retail.cache.test.xml" })
public class CalendarLookupTest {

	@Autowired
	private ReferenceValueLookup calendarLookup;

	@Test
	public void testCountryLookup() {
		CalendarVO calendar = null;
		try{
			calendar = (CalendarVO)this.calendarLookup.getValidCalendar(2);
			Assert.assertTrue(calendar!=null);
		}catch(OptimaRetailBaseException e){
			Assert.fail();
		}		
	}
}
