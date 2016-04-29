package com.citi.retail.optima.etl.controller.container.jmx.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.controller.container.jmx.ControllerMBean;

/**
 * This class provides the implementation for the ControllerMBean interface.
 * 
 * @author rs70128
 * 
 */
public class ControllerMBeanImpl implements ControllerMBean, InitializingBean,
		DisposableBean {

	private static final Log LOGGER = LogFactory
			.getLog(ControllerMBeanImpl.class);

	private boolean running = false;
	private JmsMessageDrivenEndpoint genesisJmsAdapter;
	private JmsMessageDrivenEndpoint internalJmsAdapter;

	public void setGenesisJmsAdapter(JmsMessageDrivenEndpoint genesisJmsAdapter) {
		this.genesisJmsAdapter = genesisJmsAdapter;
	}

	public void setInternalJmsAdapter(
			JmsMessageDrivenEndpoint internalJmsAdapter) {
		this.internalJmsAdapter = internalJmsAdapter;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.genesisJmsAdapter,
				"Inbound message adapter cannot be null!");
	}

	@Override
	public void destroy() throws Exception {
		stop();
	}

	@Override
	public synchronized void start() throws Exception {
		if (!this.running) {
			// do recovery if the container did not shutdown properly before
			recoveryProcess();

			// set running status to true
			this.running = true;

			// kicks off pending process

			// starts all inbound adapters
			if (this.genesisJmsAdapter != null) {
				this.genesisJmsAdapter.start();
			}

			if (this.internalJmsAdapter != null) {
				this.internalJmsAdapter.start();
			}
		} else {
			LOGGER.info("module is running already ...");
		}
	}

	@Override
	public synchronized void stop() throws Exception {
		if (this.running) {
			// set running status to false
			this.running = false;

			// stop all inbound adapters
			if (this.genesisJmsAdapter != null) {
				this.genesisJmsAdapter.stop();
			}

			if (this.internalJmsAdapter != null) {
				this.internalJmsAdapter.stop();
			}

			// wait for current running tasks to finish
			awaitTermination();
		} else {
			LOGGER.info("module is not running ...");
		}
	}

	@Override
	public boolean isAlive() throws Exception {
		return this.running;
	}

	private void recoveryProcess() {

	}

	private void awaitTermination() {
		// TODO
	}
}
