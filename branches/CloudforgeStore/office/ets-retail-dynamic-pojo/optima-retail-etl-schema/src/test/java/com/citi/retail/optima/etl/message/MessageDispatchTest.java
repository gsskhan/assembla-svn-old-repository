package com.citi.retail.optima.etl.message;

import java.math.BigInteger;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * This test class test the message dispatching from ETL system
 * 
 * @author ns21567
 * 
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.messaging.dispatch.test.xml" })
public class MessageDispatchTest {

	@Autowired
	private OptimaRetailMessageDispatcher optimaRetailMessageDispatcher;

	@Test
	public void testInternalMessageDispatch() throws Exception {

		OptimaRetailETLEvent outgoingMessage = null;
		try {
			outgoingMessage = new OptimaRetailETLEvent();
			Long jobId = 1212312312312l;
			outgoingMessage
					.setBatchInstanceId(new BigInteger(jobId.toString()));
			outgoingMessage.setEventTimestamp("2013-03-14 17:37:52");
			outgoingMessage.setRequestID("ORETL-" + Math.random());
			outgoingMessage
					.setEventType(com.citi.retail.optima.xsd.internal.EventTypes.ORETL_JOB_COMPLETE);

			Long origMessageLong = 23423423l;

			BigInteger originalMessageId = new BigInteger(
					origMessageLong.toString());
			outgoingMessage.setOriginalMsgId(originalMessageId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.optimaRetailMessageDispatcher.dispatchMessage("BatchTest",
				outgoingMessage);

	}
}
