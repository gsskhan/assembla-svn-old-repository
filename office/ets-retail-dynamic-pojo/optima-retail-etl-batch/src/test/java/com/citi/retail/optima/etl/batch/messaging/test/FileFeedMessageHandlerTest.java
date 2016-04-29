package com.citi.retail.optima.etl.batch.messaging.test;

import java.math.BigInteger;
import java.sql.SQLException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.batch.dao.BatchJobDetailsDao;
import com.citi.retail.optima.etl.batch.dao.BatchJobInstanceDao;
import com.citi.retail.optima.etl.batch.dao.BatchMessageDao;
import com.citi.retail.optima.etl.batch.messaging.FileFeedMessageHandler;
import com.citi.retail.optima.etl.common.exception.OptimaRetailBaseException;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.batch.test.xml" })
public class FileFeedMessageHandlerTest {

	@Autowired
	FileFeedMessageHandler fileFeedHandler;

	@Autowired
	BatchMessageDao messageDao;

	@Autowired
	BatchJobDetailsDao batchDetailsDao;

	@Autowired
	BatchJobInstanceDao jobInstanceDao;

	@Test
	public void testGetBatchDetails() {

		this.fileFeedHandler.setJobInstanceDao(this.jobInstanceDao);

		testHandleMessage();
	}

	private void testHandleMessage() {

		OptimaRetailETLEvent etlEvent = new OptimaRetailETLEvent();

		etlEvent.setBatchInstanceId(new BigInteger("642"));
		etlEvent.setOriginalMsgId(new BigInteger("782"));
		etlEvent.setPriority(new BigInteger("9"));
		etlEvent.setReportPeriod("2012-12-31");

		try {
			try {
				this.fileFeedHandler.handleIncomingFeedRequest(MessageBuilder
						.withPayload(etlEvent).build());
			} catch (JAXBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (OptimaRetailBaseException e) {
			e.printStackTrace();
		}

	}

}
