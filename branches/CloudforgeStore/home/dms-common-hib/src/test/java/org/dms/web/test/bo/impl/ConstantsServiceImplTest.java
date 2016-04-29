package org.dms.web.test.bo.impl;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.dms.web.bo.ConstantsService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/applicationContext-dbaccess.xml","/spring/applicationContext-core.xml"})
@TransactionConfiguration(transactionManager="dbTxManager", defaultRollback= true)
@Transactional
public class ConstantsServiceImplTest {
	
	private Logger log = Logger.getLogger(this.getClass());	
	
	@Autowired
	private ConstantsService constantsService;	
	
	@Test
	@Ignore
	public void testFindAllVariableNames(){
		log.info("started test method");
		List<String> list = constantsService.findAllVariableNames();
		Assert.assertNotNull(list);
		log.info("Result = "+list);
		log.info("completed test method");
	}

}
