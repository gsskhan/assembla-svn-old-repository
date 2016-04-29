package com.citi.retail.optima.etl.batch.job.writer.helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.citi.retail.optima.etl.common.model.AccountTraceabilityInfo;

public class AccountTracePrepStmtSetter implements
		ItemPreparedStatementSetter<AccountTraceabilityInfo> {

	@Override
	public void setValues(AccountTraceabilityInfo item, PreparedStatement ps)
			throws SQLException {

		ps.setString(1, item.getAccountNumber());
		ps.setLong(2, item.getAggregationTypeId());
		ps.setLong(3, item.getBatchInstanceId());
		ps.setInt(4, item.getProcessingUnitId());

	}

}
