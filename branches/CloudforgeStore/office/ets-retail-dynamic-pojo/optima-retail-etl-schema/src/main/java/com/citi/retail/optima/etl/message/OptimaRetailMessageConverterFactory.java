package com.citi.retail.optima.etl.message;

import org.springframework.jms.support.converter.MessageConverter;

public interface OptimaRetailMessageConverterFactory {
	MessageConverter getConverter(Object event);
}
