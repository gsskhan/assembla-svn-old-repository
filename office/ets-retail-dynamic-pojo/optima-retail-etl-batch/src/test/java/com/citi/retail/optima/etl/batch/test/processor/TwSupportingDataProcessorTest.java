package com.citi.retail.optima.etl.batch.test.processor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.citi.retail.optima.etl.batch.job.processor.da.TwSupportingDataProcessor;
import com.citi.retail.optima.etl.common.model.RecvRecord;

public class TwSupportingDataProcessorTest {
	private RecvRecord modelObj;
	private TwSupportingDataProcessor<RecvRecord> supportingDataProcessor = new TwSupportingDataProcessor<RecvRecord>();
	@Before
	public void setUp() throws Exception {
		modelObj = new RecvRecord();
		modelObj.setCardNumber("12345");
		/*modelObj.setNewrc_p((long) 10.0);*/
		supportingDataProcessor.setPreProcessMapName("preProcessMapName");
		supportingDataProcessor.afterPropertiesSet();
	}
	
	@Ignore
	@Test(expected = NullPointerException.class)
	public void twSupportingDataProcessorTest() throws Exception {
		Assert.assertEquals(modelObj,
				supportingDataProcessor.process(modelObj));
	}
}
