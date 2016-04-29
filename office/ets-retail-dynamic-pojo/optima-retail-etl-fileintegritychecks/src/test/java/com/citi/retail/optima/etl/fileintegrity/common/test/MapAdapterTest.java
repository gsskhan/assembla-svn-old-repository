package com.citi.retail.optima.etl.fileintegrity.common.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.fileintegrity.common.MapAdapter;
import com.citi.retail.optima.etl.fileintegrity.common.MapAdapter.AdaptedMap;

public class MapAdapterTest {
	MapAdapter adapter = new MapAdapter(); 
	
	@Test
	public void  testMarshal() throws Exception {		
		Map<String, String> map = new HashMap<String, String>();
		map.put("REPORTING PERIOD","201210");
		Assert.assertNotNull(adapter.marshal(map));		
	}
	@Test
	public void testUnmarshal() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("REPORTING PERIOD","201210");
		AdaptedMap adaptedMap = adapter.marshal(map);
		Assert.assertNotNull(adapter.unmarshal(adaptedMap));				
	}	
}
