package org.dms.web.test.bo.impl;

import org.apache.log4j.Logger;
import org.dms.web.bo.PaperService;
import org.dms.web.entity.PaperStore;
import org.dms.web.exception.DmsException;
import org.junit.Assert;
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
public class PaperServiceImplTest {
	
	private Logger log = Logger.getLogger(this.getClass());	
	
	@Autowired
	PaperService paperService;
	
	@Ignore
	@Test
	public void testGetPaper() throws DmsException{
		String testTitle = "Test Paper";
		String testNumber = "1408871292726";
		PaperStore paperStore =	paperService.getPaper(testTitle, testNumber);
		Assert.assertNotNull(paperStore);
		Assert.assertSame(testTitle, paperStore.getPaperTitle());
		log.info(paperStore);
	}

}
