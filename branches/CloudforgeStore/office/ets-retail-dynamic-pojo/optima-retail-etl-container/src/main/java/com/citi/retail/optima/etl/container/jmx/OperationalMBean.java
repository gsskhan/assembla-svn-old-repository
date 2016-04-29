package com.citi.retail.optima.etl.container.jmx;

public interface OperationalMBean {
	void start() throws Exception;

	void stop() throws Exception;

	boolean isAlive() throws Exception;
}
