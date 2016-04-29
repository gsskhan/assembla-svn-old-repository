package com.citi.optima.retail.batch.preprocess.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.optima.retail.batch.preprocess.PreProcessorDataServiceImpl;

/**
 * 
 * @author mc56120
 * 
 */
public class PreProcessorDataServiceImplTest {

	private PreProcessorDataServiceImpl preProcessorDataServiceImpl;
	private Map<String, Map<String, Map<String, Object>>> preProcessorDataServiceMap;
	private Map<String, Object> innerMap;

	@Before
	public void setUp() {
		preProcessorDataServiceImpl = new PreProcessorDataServiceImpl();
		preProcessorDataServiceMap = new HashMap<String, Map<String, Map<String, Object>>>();
		innerMap = new ConcurrentHashMap<String, Object>();
		innerMap.put("HistoryDelq", new HashMap<String, Object>());
		innerMap.put("EventDelq", new HashMap<String, Object>());
		preProcessorDataServiceImpl.getPreProcessorDataServiceMap().put("P1",
				innerMap);
	}

	@Test
	public void testGetLocalPreProcessorDataServiceMap() {
		Assert.assertNotNull(preProcessorDataServiceImpl
				.getLocalPreProcessorDataServiceMap("P1"));
		Assert.assertTrue(preProcessorDataServiceImpl
				.getLocalPreProcessorDataServiceMap("P1").size() > 0);
		Assert.assertNotNull(preProcessorDataServiceImpl
				.getLocalPreProcessorDataServiceMap("P2"));
		Assert.assertTrue(preProcessorDataServiceImpl
				.getLocalPreProcessorDataServiceMap("P2").size() == 0);

	}

}
