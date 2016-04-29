package com.citi.retail.optima.etl.batch.messaging.test;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.batch.messaging.BatchIncomingMessageHandler;
import com.citi.retail.optima.xsd.internal.EventTypes;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.batch.test.xml" })
public class BatchIncomingMessageHandlerTest {

	@Autowired
	private BatchIncomingMessageHandler incomingMessageHandler;

	@Test
	public void testHandleMessage() {

		OptimaRetailETLEvent etlEvent = new OptimaRetailETLEvent();

		etlEvent.setBatchInstanceId(new BigInteger("2624"));
		etlEvent.setOriginalMsgId(new BigInteger("1487"));
		etlEvent.setPortfolioID("CA_CC1");
		etlEvent.setPriority(new BigInteger("2"));
		etlEvent.setReportPeriod("2012-12-31");
		etlEvent.setEventType(EventTypes.ORETL_NEW_JOB_REQUEST);

	//	this.incomingMessageHandler.handleMessageInternal(null);
	}

}
