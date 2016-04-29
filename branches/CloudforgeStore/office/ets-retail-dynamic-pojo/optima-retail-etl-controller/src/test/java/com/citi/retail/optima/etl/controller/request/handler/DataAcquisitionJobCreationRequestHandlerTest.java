/**
 * 
 */
package com.citi.retail.optima.etl.controller.request.handler;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.dao.JobInstanceDao;
import com.citi.retail.optima.etl.controller.model.MessageLog;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * @author mc56120
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class DataAcquisitionJobCreationRequestHandlerTest {
	
	@Autowired
	private UserSubmissionJobCreationRequestHandler dataAcqJobCreationRequestHandler;

	@Autowired
	private JobInstanceDao jobInstanceDao;

	
	@Test
	public void testDataAcqJobCreationRequest()
			throws OptimaRetailApplicationException {
		dataAcqJobCreationRequestHandler.setJobInstanceDao(jobInstanceDao);
	}

	@Test
	public void testHandleMessageForException() throws OptimaRetailApplicationException {
		MessageLog messageLog = new MessageLog();
		List<String> prdList = new ArrayList<String>();
		prdList.add("CRD");		
		messageLog.setEventType("DATA_ACQUISITION");
		messageLog.setMessageId(200L);
		messageLog.setCountryCode("TW");
		messageLog.setFileName("OR_CRD_TW_RSK_20130930_HIST_TW_20140131_Control_V10.cnt");
		messageLog.setFileType("cnt");
		messageLog.setReptPeriod("20140202"); //wrong rpt period
		messageLog.setProductList(prdList);		
		messageLog.setPriority(new BigInteger("20"));
		Message<MessageLog> message = MessageBuilder.withPayload(messageLog).build();
/*		Assert.assertEquals(RequestMessageType.NEW_REQUEST,
				dataAcqJobCreationRequestHandler.handleRequest(message));
*/	
		}	

}
