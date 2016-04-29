/**
 * 
 */
package com.citi.retail.optima.etl.batch.vo.test;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.citi.retail.optima.etl.batch.vo.MessageLogVO;

/**
 * @author mc56120
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageLogVOTest {

	@Mock
	Blob testBlob;

	private MessageLogVO messageLogVO;

	@Before
	public void setUp() {
		messageLogVO = new MessageLogVO();
	}

	@Test
	public void testSetOriginalMessageId() {
		messageLogVO.setOriginalMessageId(1234);
		Assert.assertTrue(messageLogVO.getOriginalMessageId() == 1234);
	}

	@Test
	public void testSetEventTimestamp() {
		Timestamp ts = new Timestamp(new Date().getTime());
		messageLogVO.setEventTimestamp(ts);
		Assert.assertEquals(ts, messageLogVO.getEventTimestamp());
	}

}
