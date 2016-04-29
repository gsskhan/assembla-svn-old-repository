package com.citi.retail.optima.etl.common.exception;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.common.ServiceName;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author hs73849 This Junit Class is to test the JSON String Conversion from
 *         toString.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/data/optima.logger.exception.test.data.xml" })
public class JsonConversionTest {

	@Autowired
	private OptimaRetailApplicationException optimaRetailApplicationExceptionTestData;

	private OptimaRetailDataException dataException;

	@Before
	public void setUp() {

		dataException = new OptimaRetailDataException(ServiceName.AGGREGATION,
				ExceptionType.ERROR);
		dataException.setRowId(500L);
	}

	@Test
	public void testRetailExceptionJsonConversion() throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		JsonNode node = mapper
				.readTree(optimaRetailApplicationExceptionTestData.toString());

		OptimaRetailApplicationException optimaRetailException = mapper
				.treeToValue(node, OptimaRetailApplicationException.class);

		Assert.isTrue(optimaRetailApplicationExceptionTestData.toString()
				.equals(optimaRetailException.toString()));

		dataException.setOptimaRetailSkippableList(null);
		node = mapper.readTree(dataException.toString());
		OptimaRetailDataException optimaDataRetailException = mapper
				.treeToValue(node, OptimaRetailDataException.class);

		Assert.isTrue(dataException.toString().equals(
				optimaDataRetailException.toString()));

		node = mapper.readTree(dataException.toString());
		optimaDataRetailException = mapper.treeToValue(node,
				OptimaRetailDataException.class);

		Assert.isTrue(dataException.toString().equals(
				optimaDataRetailException.toString()));

		optimaRetailApplicationExceptionTestData.setExceptionType(null);
		node = mapper.readTree(optimaRetailApplicationExceptionTestData
				.toString());
		optimaRetailException = mapper.treeToValue(node,
				OptimaRetailApplicationException.class);

		Assert.isTrue(optimaRetailApplicationExceptionTestData.toString()
				.equals(optimaRetailException.toString()));

		optimaRetailApplicationExceptionTestData
				.setDataException(dataException);

		node = mapper.readTree(optimaRetailApplicationExceptionTestData
				.toString());
		optimaRetailException = mapper.treeToValue(node,
				OptimaRetailApplicationException.class);

		Assert.isTrue(optimaRetailApplicationExceptionTestData.toString()
				.equals(optimaRetailException.toString()));

		node = mapper.readTree(optimaRetailApplicationExceptionTestData
				.toString());
		optimaRetailException = mapper.treeToValue(node,
				OptimaRetailApplicationException.class);

		Assert.isTrue(optimaRetailApplicationExceptionTestData.toString()
				.equals(optimaRetailException.toString()));

	}

	@Test
	public void testDataExceptionJsonConversion() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		OptimaRetailDataException optimaRetailDataException = mapper.readValue(
				dataException.toString(), OptimaRetailDataException.class);
		Assert.isTrue(dataException.toString().equals(
				optimaRetailDataException.toString()));
	}

	@Test
	public void testApplicationExceptionJsonConversion() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		optimaRetailApplicationExceptionTestData
				.setServiceName(ServiceName.BATCH);
		optimaRetailApplicationExceptionTestData
				.setExceptionType(ExceptionType.ERROR);
		OptimaRetailApplicationException optimaRetailApplicationException = mapper
				.readValue(optimaRetailApplicationExceptionTestData.toString(),
						OptimaRetailApplicationException.class);
		Assert.isTrue(optimaRetailApplicationExceptionTestData.toString()
				.equals(optimaRetailApplicationException.toString()));
	}

}