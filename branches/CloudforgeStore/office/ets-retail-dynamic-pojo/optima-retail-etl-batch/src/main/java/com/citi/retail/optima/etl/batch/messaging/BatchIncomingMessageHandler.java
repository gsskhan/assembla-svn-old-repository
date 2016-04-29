package com.citi.retail.optima.etl.batch.messaging;

import java.util.HashMap;
import java.util.Map;

import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.xml.transformer.UnmarshallingTransformer;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.xsd.internal.EventTypes;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

/**
 * Sets the message for routing to the specific channel in the batch channel
 * stream.
 * 
 * @author ns21567
 * 
 */
public class BatchIncomingMessageHandler extends AbstractMessageHandler{

	private static final String MESSAGE_TYPE = "MESSAGE_TYPE";
	
	private UnmarshallingTransformer transformer;
	
	private final MessagingTemplate messagingTemplate;
	
	private MessageChannel outputChannel;
	
	public BatchIncomingMessageHandler() {
		messagingTemplate = new MessagingTemplate();
	}

		@Override
		protected void handleMessageInternal(Message<?> message)
				throws Exception {

		OptimaRetailETLEvent messageLog = (OptimaRetailETLEvent) message.getPayload();
		Map<String, String> messageHeader = new HashMap<String, String>();

		messageHeader.put(MESSAGE_TYPE,
				messageLog.getEventType().toString());
		
		Message<OptimaRetailETLEvent> returnMessage = MessageBuilder
				.withPayload(messageLog).copyHeadersIfAbsent(messageHeader)
				.build();
		
		messagingTemplate.send(outputChannel, returnMessage);

	}
	
	public void setOutputChannel(MessageChannel outputChannel) {
		this.outputChannel = outputChannel;
	}

	public UnmarshallingTransformer getTransformer() {
		return transformer;
	}

	public void setTransformer(UnmarshallingTransformer transformer) {
		this.transformer = transformer;
	}

}
