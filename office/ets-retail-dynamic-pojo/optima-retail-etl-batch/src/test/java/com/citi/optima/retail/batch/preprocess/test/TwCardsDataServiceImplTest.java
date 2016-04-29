package com.citi.optima.retail.batch.preprocess.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.optima.retail.batch.preprocess.PreProcessorDataServiceImpl;
import com.citi.optima.retail.batch.preprocess.TwCardsDataServiceImpl;

public class TwCardsDataServiceImplTest {
	private TwCardsDataServiceImpl twCardsDataServiceImpl;
	private Map<String, Map<String, Map<String, Object>>> preProcessorDataServiceMap;
	private Map<String, Object> innerMap;
	
	@Before
	public void setUp() {
		twCardsDataServiceImpl = new TwCardsDataServiceImpl();
		preProcessorDataServiceMap = new HashMap<String, Map<String, Map<String, Object>>>();
		innerMap = new ConcurrentHashMap<String, Object>();
		innerMap.put("HistoryDelq", new HashMap<String, Object>());
		innerMap.put("EventDelq", new HashMap<String, Object>());
		twCardsDataServiceImpl.getPreProcessorDataServiceMap().put("P1",
				innerMap);
	}
	
	@Test
	public void testGetLocalPreProcessorDataServiceMap() {
		Assert.assertNotNull(twCardsDataServiceImpl
				.getLocalPreProcessorDataServiceMap("P1"));
		Assert.assertTrue(twCardsDataServiceImpl
				.getLocalPreProcessorDataServiceMap("P1").size() > 0);
		Assert.assertNotNull(twCardsDataServiceImpl
				.getLocalPreProcessorDataServiceMap("P2"));
		Assert.assertTrue(twCardsDataServiceImpl
				.getLocalPreProcessorDataServiceMap("P2").size() == 0);

	}
}
