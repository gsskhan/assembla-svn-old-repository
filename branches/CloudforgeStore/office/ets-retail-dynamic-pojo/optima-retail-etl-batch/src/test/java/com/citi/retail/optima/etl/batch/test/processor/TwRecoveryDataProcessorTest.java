package com.citi.retail.optima.etl.batch.test.processor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.batch.job.processor.da.TwRecoveryDataProcessor;
import com.citi.retail.optima.etl.common.model.RecvRecord;

public class TwRecoveryDataProcessorTest {

	private RecvRecord modelObj;
	private TwRecoveryDataProcessor<RecvRecord> recoveryDataProcessor = new TwRecoveryDataProcessor<RecvRecord>();

	@Before
	public void setUp() throws Exception {
		modelObj = new RecvRecord();
		modelObj.setCardNumber("12345");
/*		modelObj.setNewrc_p((long) 10.0);
*/		recoveryDataProcessor.setPreProcessMapName("preProcessMapName");
	}

	@Test(expected = NullPointerException.class)
	public void twRecoveryDataProcessTest() throws Exception {
			Assert.assertEquals(modelObj,
					recoveryDataProcessor.process(modelObj));
		
	}
}
