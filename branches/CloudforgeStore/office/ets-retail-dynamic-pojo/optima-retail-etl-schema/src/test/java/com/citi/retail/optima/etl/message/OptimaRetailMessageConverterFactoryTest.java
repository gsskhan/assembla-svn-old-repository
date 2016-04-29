package com.citi.retail.optima.etl.message;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.xsd.genesis.GenesisRREvent;

/**
 * @author sr67841
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.messaging.dispatch.test.xml" })
public class OptimaRetailMessageConverterFactoryTest {

	@Autowired
	OptimaRetailMessageConverterFactory optimaRetailMessageConverterFactory;
	
	@Test
	public void getConverterTest() {
		
		GenesisRREvent event = new GenesisRREvent();
		MessageConverter messageConverter = optimaRetailMessageConverterFactory.getConverter(event);
		Assert.assertNotNull(messageConverter);

	}
}
