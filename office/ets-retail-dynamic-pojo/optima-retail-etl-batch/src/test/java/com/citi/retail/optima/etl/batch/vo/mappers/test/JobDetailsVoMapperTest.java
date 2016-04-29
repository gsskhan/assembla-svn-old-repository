/**
 * 
 */
package com.citi.retail.optima.etl.batch.vo.mappers.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.citi.retail.optima.etl.batch.vo.BatchDetailsVO;
import com.citi.retail.optima.etl.batch.vo.mappers.JobDetailsVoMapper;

/**
 * @author mc56120
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class JobDetailsVoMapperTest {
	ResultSet rs = null;

	@Before
	public void init() throws Exception {
		rs = Mockito.mock(ResultSet.class);
		java.sql.Date dates = new java.sql.Date(new Date().getTime());
		Mockito.when(rs.getInt("BATCH_INST_ID")).thenReturn(100);
		Mockito.when(rs.getInt("BATCH_ID")).thenReturn(200);
		Mockito.when(rs.getInt("THLD_CNT")).thenReturn(10);
		Mockito.when(rs.getInt("yr")).thenReturn(2014);
		Mockito.when(rs.getInt("qtr")).thenReturn(1);
		Mockito.when(rs.getInt("mo")).thenReturn(1);
		Mockito.when(rs.getString("JOB_NM")).thenReturn("TestCards");
		Mockito.when(rs.getInt("THLD")).thenReturn(5);
		Mockito.when(rs.getInt("ROWCNT_RECV")).thenReturn(1000);
		Mockito.when(rs.getString("PORT_ID")).thenReturn("TestPortfolioId");
		Mockito.when(rs.getLong("SRC_MSG_ID")).thenReturn(1L);
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
	}

	@Test
	public void testMapper() throws SQLException {
		JobDetailsVoMapper mapper = new JobDetailsVoMapper();
		BatchDetailsVO jobDetailsVO = mapper.mapRow(rs, 0);
		Assert.assertEquals("TestCards", jobDetailsVO.getBatchName());
		Assert.assertTrue(jobDetailsVO.getThreadCount() == 10);
	}
}
