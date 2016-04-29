/**
 * 
 */
package com.citi.retail.optima.etl.batch.job.writer.test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.citi.retail.optima.etl.batch.job.writer.helper.AccountTracePrepStmtSetter;
import com.citi.retail.optima.etl.common.model.AccountTraceabilityInfo;

/**
 * @author mc56120
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountTracePrepStmtSetterTest {

	private AccountTracePrepStmtSetter accountTracePrepStmtSetter = new AccountTracePrepStmtSetter();

	@Mock
	private PreparedStatement prepStmt;

	private AccountTraceabilityInfo accountTraceabilityInfo = new AccountTraceabilityInfo();

	@Before
	public void setUp() {
		accountTraceabilityInfo.setAccountNumber("1234");
		accountTraceabilityInfo.setAggregationTypeId(1L);
		accountTraceabilityInfo.setBatchInstanceId(100L);
		accountTraceabilityInfo.setProcessingUnitId(1);
	}

	@Test
	public void testSetValues() throws SQLException {
		accountTracePrepStmtSetter.setValues(accountTraceabilityInfo, prepStmt);
	}
}
