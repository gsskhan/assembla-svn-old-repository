package com.citi.retail.optima.etl.container.monitor.handler;

import java.lang.management.MemoryType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class LogMemoryUsageNotificationHandler extends
		AbstractMemoryUsageNotificationListener {
	private static final Log LOGGER = LogFactory
			.getLog(LogMemoryUsageNotificationHandler.class);

	public LogMemoryUsageNotificationHandler(String name) {
		super(name);
	}

	@Override
	public void exceedUsageThreshold(MemoryType memoryType, long max, long used)
			throws Exception {
		LOGGER.warn("Exceeding memory usage: type=" + memoryType.name()
				+ ", max=" + max + ", used=" + used);
	}
}
