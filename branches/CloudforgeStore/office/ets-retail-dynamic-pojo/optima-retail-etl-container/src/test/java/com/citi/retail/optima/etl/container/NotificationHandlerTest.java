package com.citi.retail.optima.etl.container;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
//import java.lang.management.MemoryType;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.citi.retail.optima.etl.container.monitor.ContainerMemoryUsageNotificationListener;
import com.citi.retail.optima.etl.container.monitor.ContainerVMStatusExtractor;

public class NotificationHandlerTest extends AbstractStartedContainerTest {
	private final ContainerVMStatusExtractor containerVMStatusExtractor = new ContainerVMStatusExtractor();

	private final long exceedAmount = 75000000L;
	private final long waitForNotify = 5000L;

	private final ContainerMemoryUsageNotificationListener mockContainerMemoryUsageNotificationListener = Mockito
			.mock(ContainerMemoryUsageNotificationListener.class);

	@SuppressWarnings("static-access")
	@Test
	public void testMemoryUsageNotificationListener() throws Exception {
		Mockito.when(
				this.mockContainerMemoryUsageNotificationListener.getName())
				.thenReturn("mock");

		// use mock object
		Container container = Container.getInstance();
		container
				.addMemoryUsageListener(this.mockContainerMemoryUsageNotificationListener);

		// run
		List<MemoryPoolMXBean> memoryPoolMXBeanList = this.containerVMStatusExtractor
				.getMemoryPoolMXBeanList();

		MemoryPoolMXBean tenuredGenPool = this.containerVMStatusExtractor
				.getTenuredGenMemoryPoolMXBean(memoryPoolMXBeanList);
		long usageThreshold = tenuredGenPool.getUsageThreshold();

		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		long used = memoryMXBean.getHeapMemoryUsage().getUsed();

		// fill up memory
		List<Long> memoryFillUpObjectList = new LinkedList<Long>();
		while (used < (usageThreshold + this.exceedAmount)) {
			memoryFillUpObjectList.add(new Long(used));
			used = memoryMXBean.getHeapMemoryUsage().getUsed();
		}

		// wait for MemoryMXBean to notify
		try {
			Thread.currentThread().sleep(this.waitForNotify);
		} catch (InterruptedException e) {
		}

		// verification
		//Mockito.verify(this.mockContainerMemoryUsageNotificationListener,
			//	Mockito.atLeastOnce()).exceedUsageThreshold(
			//	Mockito.eq(MemoryType.HEAP), Mockito.anyLong(),
		//		Mockito.anyLong());
	}
}
