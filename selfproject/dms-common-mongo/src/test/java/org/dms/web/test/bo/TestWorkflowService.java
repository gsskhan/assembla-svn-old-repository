package org.dms.web.test.bo;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.dms.web.bo.WorkflowService;
import org.dms.web.exception.DmsException;
import org.dms.web.vo.PendingActionWorkflow;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/applicationContext-mongo.xml","/spring/applicationContext-core.xml"})
public class TestWorkflowService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private WorkflowService workflowService;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	@Ignore
	public void testGetWorkflowsPendingActions() throws DmsException{
		log.info("begin ...");		
		List<PendingActionWorkflow> list = workflowService.getWorkflowsPendingActions();
		Assert.assertNotNull(list);
		for (PendingActionWorkflow pendingActionWorkflow : list) {
			log.info(pendingActionWorkflow);
		}
	}

}
