package com.citi.retail.optima.etl.common.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * 
 * @author ns21567 Appender to log intermediate results in the database for
 *         detailed integration test.
 */
public class CustomDbAppender extends AppenderBase<ILoggingEvent> {

	private final JdbcTemplate jdbcTemplate;
	private static final String SEPARATOR_STRING = "###";
	
	static int i = 0;

	public CustomDbAppender() {

		this.jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(
				"jdbc:oracle:thin:@mworsdb1s.nam.nsroot.net:1526:ORDSDVG",
				"ORDSETL", "ordsetl", false));

	}

	@Override
	protected void append(ILoggingEvent eventObject) {

		final String className;
		final String methodName;
		final String formattedMessage;
		final String batchInstanceId;
		final String objectType;
		String message[];
		
		i++;		
		message = eventObject.getFormattedMessage()
				.split(this.SEPARATOR_STRING);
		batchInstanceId = message[0];
		formattedMessage = message[2];
		objectType = message[1];

		StackTraceElement callerData = eventObject.getCallerData()[0];
		if (callerData != null) {
			className = callerData.getClassName();
			methodName = callerData.getMethodName();
		} else {
			className = null;
			methodName = null;
		}

		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con
						.prepareStatement("insert into ORC_DEBUG_LOG values(?,?,?,?,?)");
				ps.setInt(1, Integer.valueOf(batchInstanceId));

				if (formattedMessage != null) {
					ps.setString(2, formattedMessage);
				} else {
					ps.setNull(2, Types.NULL);
				}
				ps.setString(3, methodName);
				ps.setString(4, className);
				ps.setString(5, objectType);
				return ps;
			}
		});
	}
}
