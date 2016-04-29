package com.citi.ets.publisher.test.common;

import java.sql.Timestamp;
import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.citi.ets.publisher.common.GenerateXMLHelper;
import com.citi.ets.publisher.domain.AlertsView;


public class GenerateXMLHelperTest {
	
	private Logger log = Logger.getLogger(GenerateXMLHelperTest.class);
	
	@Test
	@Ignore
	public void createAlertsViewXMLTest() throws Exception{
		GenerateXMLHelper helper = new GenerateXMLHelper();
		Timestamp eventTimestamp = new Timestamp(new Date().getTime());		
		AlertsView alert = new AlertsView(161602, "IEM", "Process & Batch Jobs", "Thread", eventTimestamp, "swiemap4p::10299Alert State 2"
										, "903.00", 2, 0);
		String xml = helper.createAlertsViewXML(alert);
		log.info(xml);
		Assert.assertNotNull(xml);
		
	}

}
