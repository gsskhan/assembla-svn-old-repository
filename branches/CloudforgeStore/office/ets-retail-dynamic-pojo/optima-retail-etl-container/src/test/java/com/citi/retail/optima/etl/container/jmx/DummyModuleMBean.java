package com.citi.retail.optima.etl.container.jmx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DummyModuleMBean implements OperationalMBean {
	private static final Log LOGGER = LogFactory.getLog(DummyModuleMBean.class);

	private boolean running = false;

	@Override
	public void start() throws Exception {
		if (!running) {
			// set running status to true
			this.running = true;
		} else {
			LOGGER.info("module is running already ...");
		}
	}

	@Override
	public void stop() throws Exception {
		if (running) {
			// set running status to false
			this.running = false;
		} else {
			LOGGER.info("module is not running ...");
		}
	}

	@Override
	public boolean isAlive() throws Exception {
		return this.running;
	}

}
