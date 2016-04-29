/**
 * 
 */
package com.citi.retail.optima.etl.controller.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mc56120
 *
 */
public class EventFileMapVOTest {

	private EventFileMapVO eventFileMap;
	
	@Before
	public void setup(){
		eventFileMap= new EventFileMapVO();
	}
	
	@Test
	public void testSetReqEventId() {
		eventFileMap.setReqEventId(new Long(1));
		Assert.assertEquals(new Long(1), eventFileMap.getReqEventId());
	}	
	
	@Test
	public void testSetCntrlFileFlag() {
		eventFileMap.setCntrlFileFlag(true);
		Assert.assertEquals(Boolean.TRUE, eventFileMap.isCntrlFileFlag());
	}
	
	@Test
	public void testSetInputFileName() {
		eventFileMap.setInputFileName("Test File Name");
		Assert.assertEquals("Test File Name", eventFileMap.getInputFileName());
	}	
	
	
}

