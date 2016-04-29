package com.citi.retail.optima.etl.batch.job.writer.fieldextractor.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

import com.citi.retail.optima.etl.batch.job.writer.fieldextractor.RRASCustomFieldExtractor;
import com.citi.retail.optima.etl.common.model.RainbowRecord;

@RunWith(MockitoJUnitRunner.class)
public class RRASCustomFieldExtractorTest {
	
	@Mock
	DelimitedLineAggregator<RainbowRecord> aggregator;
	
	RainbowRecord record;
	
	@Before
	public void setUp(){
		record = new RainbowRecord();
		 Calendar working = GregorianCalendar.getInstance();		    
		record.setEUniqueId("UniquieId");
		record.setESrcSysId("Source");
		record.setEProdSysId("Prod");
		record.setERecType("RecType");
		record.setAlopAmnt(100.0);
		working.set(2013, 1, 31, 0, 0, 1);
		record.setERptMonthDate(working.getTime());
		record.setEEndDate(working.getTime());
		aggregator = new DelimitedLineAggregator<RainbowRecord>();
		aggregator.setDelimiter("|");
		RRASCustomFieldExtractor<RainbowRecord> fieldExtractor = new RRASCustomFieldExtractor<RainbowRecord>();
		String[] names = {"eUniqueId","eSrcSysId","eProdSysId","eRecType","alopAmnt","eRptMonthDate","eEndDate"};
		fieldExtractor.setNames(names);
		Map<String,String> formatMap = new HashMap<String,String>();
		formatMap.put("eRptMonthDate", "yyyy-MM-dd");
		formatMap.put("eEndDate", "yyyyMMdd");
		fieldExtractor.setFormatMap(formatMap);
		aggregator.setFieldExtractor(fieldExtractor);
	}
	
	@Test
	public void testCustomExtractor(){
		String output = aggregator.aggregate(record);
		Assert.assertNotNull(output);
		String[] outputBreak = output.split("\\|");
		Assert.assertNotNull(outputBreak);
		Assert.assertTrue(outputBreak.length==7);
		Assert.assertEquals(record.geteUniqueId(), outputBreak[0]);
		Assert.assertEquals(record.geteSrcSysId(), outputBreak[1]);
		Assert.assertEquals(record.geteProdSysId(), outputBreak[2]);
		Assert.assertEquals(record.geteRecType(), outputBreak[3]);
		Assert.assertEquals(record.getAlopAmnt().toString(), outputBreak[4]);
		Assert.assertEquals("2013-03-03", outputBreak[5]);
		Assert.assertEquals("20130303", outputBreak[6]);
			
	}
	
	@Test
	public void testCustomExtractorForNullDate(){	
		record.setEEndDate(null);
		String output = aggregator.aggregate(record);
		Assert.assertNotNull(output);
		String[] outputBreak = output.split("\\|");
		Assert.assertNotNull(outputBreak);
		Assert.assertTrue(outputBreak.length==6);				
	}
	
	@Test
	public void testCustomExtractorForNullMap(){
		RRASCustomFieldExtractor<RainbowRecord> fieldExtractor = new RRASCustomFieldExtractor<RainbowRecord>();
		String[] names = {"eUniqueId","eSrcSysId","eProdSysId","eRecType","alopAmnt","eRptMonthDate","eEndDate"};
		fieldExtractor.setNames(names);
		aggregator.setFieldExtractor(fieldExtractor);
		
		String output = aggregator.aggregate(record);
		Assert.assertNotNull(output);
		String[] outputBreak = output.split("\\|");
		Assert.assertNotNull(outputBreak);
		Assert.assertTrue(outputBreak.length==7);
		Assert.assertEquals(record.geteUniqueId(), outputBreak[0]);
		Assert.assertEquals(record.geteSrcSysId(), outputBreak[1]);
		Assert.assertEquals(record.geteProdSysId(), outputBreak[2]);
		Assert.assertEquals(record.geteRecType(), outputBreak[3]);
		Assert.assertEquals(record.getAlopAmnt().toString(), outputBreak[4]);
		Assert.assertEquals("Sun Mar 03 00:00:01 EST 2013", outputBreak[5]);
		Assert.assertEquals("Sun Mar 03 00:00:01 EST 2013", outputBreak[6]);			
	}
	
}
