/**
 * 
 */
package com.citi.optima.retail.batch.preprocess.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.optima.retail.batch.preprocess.PreProcessorDataServiceFactoryImpl;

/**
 * @author mc56120
 * 
 */
public class PreProcessorDataServiceFactoryImplTest {

	private PreProcessorDataServiceFactoryImpl preProcessorDataServiceFactory;

	@Before
	public void setUp() {
		preProcessorDataServiceFactory = new PreProcessorDataServiceFactoryImpl();
	}

	@Test
	public void testGetPreProcessorDataService() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Long batchInstanceId = 1L;
		Assert.assertNull(preProcessorDataServiceFactory
				.getPreProcessorDataServiceMap().get(batchInstanceId));
		Assert.assertNotNull(preProcessorDataServiceFactory
				.getPreProcessorDataService(batchInstanceId,
						"com.citi.optima.retail.batch.preprocess.TwCardsDataServiceImpl"));
		Assert.assertNotNull(preProcessorDataServiceFactory
				.getPreProcessorDataServiceMap().get(batchInstanceId));
		Assert.assertNotNull(preProcessorDataServiceFactory
				.getPreProcessorDataService(batchInstanceId,
						"com.citi.optima.retail.batch.preprocess.TwCardsDataServiceImpl"));
	}

	@Test
	public void testClearPreProcessorDataServiceMap()
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Long batchInstanceId = 1L;
		preProcessorDataServiceFactory
				.getPreProcessorDataService(batchInstanceId,
						"com.citi.optima.retail.batch.preprocess.TwCardsDataServiceImpl");
		Assert.assertNotNull(preProcessorDataServiceFactory
				.getPreProcessorDataServiceMap().get(batchInstanceId));
		preProcessorDataServiceFactory.clearPreProcessorDataServiceMap(1L);
		Assert.assertNull(preProcessorDataServiceFactory
				.getPreProcessorDataServiceMap().get(batchInstanceId));
	}
}
