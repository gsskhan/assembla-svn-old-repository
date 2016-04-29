package com.citi.retail.optima.etl.container.monitor.handler;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.citi.retail.optima.etl.container.Container;
import com.citi.retail.optima.etl.container.monitor.ContainerMemoryUsageNotificationListener;

public abstract class AbstractMemoryUsageNotificationListener implements
		ContainerMemoryUsageNotificationListener {
	protected String name;

	public AbstractMemoryUsageNotificationListener(String name) {
		Assert.isTrue(StringUtils.hasText(name), "name cannot be null!");

		Container container = Container.getInstance();
		container.addMemoryUsageListener(this);
	}

	@Override
	public String getName() {
		return this.name;
	}
}
