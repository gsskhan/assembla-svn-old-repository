/**
 * 
 */
package com.citi.retail.optima.etl.batch.vo.mappers.test;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.citi.retail.optima.etl.batch.vo.MessageLogVO;
import com.citi.retail.optima.etl.batch.vo.mappers.MessageLogMapper;

/**
 * @author mc56120
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageLogMapperTest {
	ResultSet rs = null;
	@Mock
	Blob testBlob;

	private java.sql.Timestamp dates = new java.sql.Timestamp(
			new Date().getTime());

	@Before
	public void init() throws Exception {
		rs = Mockito.mock(ResultSet.class);
		Mockito.when(rs.getInt("msg_id")).thenReturn(1);
		Mockito.when(rs.getBlob("msg")).thenReturn(testBlob);
		Mockito.when(rs.getTimestamp("recv_ts")).thenReturn(dates);
	}

	@Test
	public void testMapper() throws SQLException {
		MessageLogMapper mapper = new MessageLogMapper();
		MessageLogVO messageVo = mapper.mapRow(rs, 0);
		Assert.assertTrue(messageVo.getOriginalMessageId() == 0);
		Assert.assertEquals(dates, messageVo.getEventTimestamp());
	}

}
