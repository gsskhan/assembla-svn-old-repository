/**
 * 
 */
package com.citi.retail.optima.etl.common.log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;

/**
 * @author sr67841
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"/data/optima.logger.exception.test.data.xml","/retail.optima.etl.logging.exception.publisher.test.xml"		})
public class AsyncJmsAppenderTest {
	
	private static final Logger LOGGER = LoggerFactory
	.getLogger(AsyncJmsAppenderTest.class);

	@Autowired
	private OptimaRetailDataException  optimaRetailDataException;
	
	@Autowired
	private OptimaRetailApplicationException  optimaRetailApplicationExceptionTestData;

	@Before
	public void setUp() {

	}

	
	@Test
	public void testApplicationException() {
		LOGGER.info(LoggingMarker.JMS.getMarker(),optimaRetailApplicationExceptionTestData.toString(),"ApplicationException");
	}
	
}
