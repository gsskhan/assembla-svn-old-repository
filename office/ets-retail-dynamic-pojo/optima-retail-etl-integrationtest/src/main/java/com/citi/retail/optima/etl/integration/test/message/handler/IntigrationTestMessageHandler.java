package com.citi.retail.optima.etl.integration.test.message.handler;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

import com.citi.retail.optima.etl.integration.test.dao.IntegrationTestDao;
import com.citi.retail.optima.etl.integration.test.dao.impl.IntegrationTestDaoImpl;
import com.citi.retail.optima.etl.integration.test.model.MessageLog;
import com.citi.retail.optima.xsd.internal.EventTypes;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;



public class IntigrationTestMessageHandler implements MessageHandler,InitializingBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationTestDaoImpl.class);
	
	private Unmarshaller jaxbUnmarshaller;
	
	private IntegrationTestDao integrationTestDao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.jaxbUnmarshaller = JAXBContext.newInstance(
				"com.citi.retail.optima.xsd.internal").createUnmarshaller();
	}
	
	@Override
	public Message<MessageLog> handleMessage(Message<String> inputMessage) throws Exception {	
		Message<MessageLog> message = null;
		String xmlMessage = inputMessage.getPayload();
		OptimaRetailETLEvent optimaRetailETLEvent = (OptimaRetailETLEvent) this.jaxbUnmarshaller
				.unmarshal(new ByteArrayInputStream(xmlMessage.getBytes("UTF-8")));
		
			 MessageLog messageLog = new MessageLog();
			 messageLog.setMessage(xmlMessage);
			 messageLog.setEventType(optimaRetailETLEvent.getEventType().value());
			 if ("ORETL_JOB_COMPLETE".equalsIgnoreCase(messageLog.getEventType())) {
				 messageLog.setJobInstId(optimaRetailETLEvent.getBatchInstanceId());
			 }
			 Map<String, String> messageHeader = new HashMap<String, String>();
			 
			 if (messageLog.getEventType().equals(
					EventTypes.ORETL_JOB_COMPLETE.toString())) {
				messageHeader.put("MESSAGE_TYPE", "BATCH_COMPLETION");
			} else {
				messageHeader.put("MESSAGE_TYPE", "ORETL_NEW_JOB_REQUEST");
			}
				
			message = MessageBuilder.withPayload(messageLog)
						.copyHeadersIfAbsent(messageHeader).build();
		 
		 return message;
	}
	
	
	@Override
	public void handleRequestMessage(Message<MessageLog> requestMessage) throws Exception {
		try{
			LOGGER.info("Invoking procedure : ORC_COMP_ENRCH_AGG_CCAR_PRC with batch Id:"+requestMessage.getPayload().getJobInstId());
			integrationTestDao.testBatchJob(requestMessage.getPayload().getJobInstId());
		} catch (Exception e) {
			LOGGER.error("Exception :"+e.toString());
		}
	}

	
	public IntegrationTestDao getIntegrationTestDao() {
		return integrationTestDao;
	}


	public void setIntegrationTestDao(IntegrationTestDao integrationTestDao) {
		this.integrationTestDao = integrationTestDao;
	}

	@Override
	public void newJobRequestMessage(Message<MessageLog> requestMessage)
			throws Exception {
		LOGGER.info("Send a request message to controller queue.");
		// Ignore , it is controller input message.
		
	}


}
