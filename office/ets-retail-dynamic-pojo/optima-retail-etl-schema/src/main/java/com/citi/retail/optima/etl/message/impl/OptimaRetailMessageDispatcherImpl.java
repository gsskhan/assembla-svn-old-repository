package com.citi.retail.optima.etl.message.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.message.OptimaRetailMessageConverterFactory;
import com.citi.retail.optima.etl.message.OptimaRetailMessageDispatcher;

public class OptimaRetailMessageDispatcherImpl implements
		OptimaRetailMessageDispatcher {

	private final JmsTemplate jmsTemplate;
	private final OptimaRetailMessageConverterFactory converterFactory;

	public OptimaRetailMessageDispatcherImpl(JmsTemplate jmsTemplate,
			OptimaRetailMessageConverterFactory converterFactory) {
		Assert.notNull(jmsTemplate, "jmsTemplate cannot be null!");
		Assert.notNull(converterFactory, "converterFactory cannot be null!");

		this.jmsTemplate = jmsTemplate;
		this.converterFactory = converterFactory;
	}

	@Override
	public void dispatchMessage(String queueName, final Object event)
			throws JMSException {
		this.jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return OptimaRetailMessageDispatcherImpl.this.converterFactory
						.getConverter(event).toMessage(event, session);
			}
		});

	}
}
