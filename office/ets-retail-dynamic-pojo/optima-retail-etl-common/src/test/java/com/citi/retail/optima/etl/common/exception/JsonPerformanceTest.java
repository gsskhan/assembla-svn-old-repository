package com.citi.retail.optima.etl.common.exception;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.common.log.LoggingMarker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author hs73849 This Test Class is for testing the Manual JSON Conversion
 *         with jackson API.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/data/optima.logger.exception.test.data.xml" })
public class JsonPerformanceTest {

	@Autowired
	private OptimaRetailApplicationException optimaRetailExceptionTestData;

	private final ObjectMapper mapper = new ObjectMapper();

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(JsonPerformanceTest.class);

	@Test
	public void testJsonRetailExceptionAPIConversion()
			throws JsonProcessingException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			mapper.writeValueAsString(optimaRetailExceptionTestData);
		}
		LOGGER.error(LoggingMarker.CONSOLE.getMarker(),
				"Total Time Taken to Complete forming the JSON String Using API "
						+ ((System.currentTimeMillis() - start) / 1000));
	}

	@Test
	public void testJsonRetailExceptionToStringConversion()
			throws JsonProcessingException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			optimaRetailExceptionTestData.toString();
		}
		LOGGER.error(LoggingMarker.CONSOLE.getMarker(),
				"Total Time Taken to Complete forming the JSON String Using toString "
						+ ((System.currentTimeMillis() - start) / 1000));
	}

}
