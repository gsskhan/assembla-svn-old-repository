package com.citi.retail.optima.etl.common.mail;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.citi.retail.optima.etl.common.mail.util.MailContentVO;
import com.citi.retail.optima.etl.common.mail.util.MailUtility;

/**
 * This class is defined for the JUNIT test case for Mail Utility.
 * @author sv16441
 *
 */
public class MailConfigurationTest {

	private org.springframework.context.ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new org.springframework.context.support.ClassPathXmlApplicationContext(new String[] {
				"retail.optima.etl.mail.xml" });
		Assert.assertNotNull("Application context cannot be null!", context);
	}

	@Test
	public void testSimpleMailConfiguration() {
		MailUtility mailUtility = (MailUtility) context.getBean("optimaMailUtility");
		MailContentVO mailContentVO = new MailContentVO();
		mailContentVO.setSubjectInfo("Testing Subject Line--");
		mailContentVO.setMailContent("Testing Mail Content ...");
		mailUtility.sendSimpleEmail(mailContentVO);
	}
	
	@Test
	public void testsendExceedUsageThresholdNotification() {
		MailUtility mailUtility = (MailUtility) context.getBean("optimaMailUtility");
		mailUtility.sendExceedUsageThresholdNotification("Testing Memory", new Long(80), new Long(20));
	}
	
	@Test
	public void testMIMEMailConfiguration() {
		MailUtility mailUtility = (MailUtility) context.getBean("optimaMailUtility");
		MailContentVO mailContentVO = new MailContentVO();
		mailContentVO.setSenderAddress("test@testing.com");
		mailContentVO.setReceiverAddress("test@test.com");
		mailContentVO.setSubjectInfo("Testing Subject Line--");
		mailContentVO.setMailContent("Testing Mail Content ...");
		mailUtility.sendMIMEEmail(mailContentVO);
	}
	
	@Test
	public void testSpecialAttachmentMailConfiguration() {
		MailUtility mailUtility = (MailUtility) context.getBean("optimaMailUtility");
		MailContentVO mailContentVO = new MailContentVO();
		mailContentVO.setSubjectInfo("Testing Subject Line--");
		mailContentVO.setMailContent("Testing Mail Content ...");
		mailContentVO.setAttachments(new File("MailConfigurationTest.java"));
		mailUtility.sendSpecialAttachmentsEmail(mailContentVO);
	}

}
