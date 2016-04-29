package com.citi.ets.publisher.service;

import java.util.ArrayList;
import javax.jms.JMSException;
import com.citi.ets.publisher.vo.XmlDataHolder;

/**
 * 
 * @author gk85985
 *
 */

public interface XmlSendService {
	
	public void jmsXMLSender(ArrayList<XmlDataHolder> xmlList) throws JMSException;

}
