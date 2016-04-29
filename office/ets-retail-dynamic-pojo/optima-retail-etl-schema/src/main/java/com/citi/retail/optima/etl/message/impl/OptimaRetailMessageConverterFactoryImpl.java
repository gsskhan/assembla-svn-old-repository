package com.citi.retail.optima.etl.message.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jms.support.converter.MessageConverter;

import com.citi.retail.optima.etl.message.OptimaRetailMessageConverterFactory;

public class OptimaRetailMessageConverterFactoryImpl implements
		OptimaRetailMessageConverterFactory {

	private final Map<Class<?>, MessageConverter> converterMap = new HashMap<Class<?>, MessageConverter>();

	public OptimaRetailMessageConverterFactoryImpl(
			Map<Class<?>, MessageConverter> converterMap) {
		this.converterMap.putAll(converterMap);
	}

	@Override
	public MessageConverter getConverter(Object event) {
		MessageConverter converter = this.converterMap.get(event.getClass());
		if (converter == null) {
			throw new IllegalStateException("Unknown event (class: "
					+ event.getClass().getName() + ") parameter!");
		}

		return converter;
	}
}
