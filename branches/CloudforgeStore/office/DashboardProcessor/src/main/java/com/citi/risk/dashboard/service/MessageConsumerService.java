package com.citi.risk.dashboard.service;

import java.util.Date;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;
import org.springframework.integration.Message;
import org.springframework.integration.support.converter.SimpleMessageConverter;
import com.citi.risk.dashboard.vo.TibcoMessageDataHolder;

/**
 * 
 * @author gk85985
 * 
 *         This class consumes messages via JMS integration inbound channel,
 *         gets message details and forward them to "Message Processing Service"
 *         & "Message audit logging service".
 * 
 */
public class MessageConsumerService {

    private Logger log = Logger.getLogger(MessageConsumerService.class);

    /*
     * To process the incoming JMS messages via spring jms integration.
     */
    public TibcoMessageDataHolder processMessage(Message<?> message) {
        try {
            SimpleMessageConverter converter = new SimpleMessageConverter();
            log.debug("RECIEVED MESSAGE =" + message);
            if (converter.fromMessage(message) instanceof TextMessage) {
                TextMessage msg = (TextMessage) converter.fromMessage(message);
                log.debug("Received message(textmessage) = " + msg);
                if (msg.getJMSCorrelationID() == null) {
                    log.error("Received message has JMSCorrelationID as null, message dropped. Please check log for details.");
                    return null;
                }
                if (msg.getText() == null || msg.getText().isEmpty()) {
                    log.error("Received message content is null or empty.");
                }
                TibcoMessageDataHolder dataHolder = new TibcoMessageDataHolder();
                dataHolder.setXmlString(msg.getText());
                dataHolder.setCorrelationID(msg.getJMSCorrelationID());
                dataHolder.setTimestamp(msg.getJMSTimestamp());
                dataHolder.setMsgDateTime(new Date(msg.getJMSTimestamp()));
                return dataHolder;
            } else {
                log.error("Message received with not required payload. Message ="
                        + message);
                return null;
            }
        } catch (Exception e) {
            log.error("Problem processing message in MessageConsumerService.",
                    e);
            return null;
        }
    }
}
