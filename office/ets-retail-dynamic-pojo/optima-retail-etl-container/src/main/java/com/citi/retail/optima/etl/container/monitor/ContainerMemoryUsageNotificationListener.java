package com.citi.retail.optima.etl.container.monitor;

import java.lang.management.MemoryType;

public interface ContainerMemoryUsageNotificationListener {
	String getName();

	void exceedUsageThreshold(MemoryType memoryType, long max, long used)
			throws Exception;
}
