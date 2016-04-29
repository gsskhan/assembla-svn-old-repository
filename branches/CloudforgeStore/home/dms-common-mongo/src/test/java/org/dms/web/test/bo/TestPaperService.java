package org.dms.web.test.bo;

import java.util.Map;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.dms.web.bo.PaperService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/applicationContext-mongo.xml","/spring/applicationContext-core.xml"})
public class TestPaperService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private PaperService paperService;
	
	@Test
	@Ignore
	public void getPaperDetailsTest(){
		Map<String, Object> map = paperService.getPaperDetails(1);
		Assert.assertNotNull(map);
		log.info(map.get("paperstore"));
		log.info(map.get("paperstatus"));
	}
	

}
