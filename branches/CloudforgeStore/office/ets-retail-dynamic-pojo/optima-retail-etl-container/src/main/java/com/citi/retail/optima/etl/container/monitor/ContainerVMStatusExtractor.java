package com.citi.retail.optima.etl.container.monitor;

import java.io.IOException;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.management.JMException;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

public class ContainerVMStatusExtractor {

	public OperatingSystemMXBean getOperatingSystemMXBean() {
		return ManagementFactory.getOperatingSystemMXBean();
	}

	public OperatingSystemMXBean getOperatingSystemMXBean(
			MBeanServerConnection connection) throws IOException {
		return ManagementFactory
				.<OperatingSystemMXBean> newPlatformMXBeanProxy(connection,
						ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
						OperatingSystemMXBean.class);
	}

	public ClassLoadingMXBean getClassLoadingMXBean() {
		return ManagementFactory.getClassLoadingMXBean();
	}

	public ClassLoadingMXBean getClassLoadingMXBean(
			MBeanServerConnection connection) throws IOException {
		return ManagementFactory.<ClassLoadingMXBean> newPlatformMXBeanProxy(
				connection, ManagementFactory.CLASS_LOADING_MXBEAN_NAME,
				ClassLoadingMXBean.class);
	}

	public MemoryMXBean getMemoryMXBean() throws IOException {
		return ManagementFactory.getMemoryMXBean();
	}

	public MemoryMXBean getMemoryMXBean(MBeanServerConnection connection)
			throws IOException {
		return ManagementFactory.<MemoryMXBean> newPlatformMXBeanProxy(
				connection, ManagementFactory.MEMORY_MXBEAN_NAME,
				MemoryMXBean.class);
	}

	public ThreadMXBean getThreadMXBean() {
		return ManagementFactory.getThreadMXBean();
	}

	public ThreadMXBean getThreadMXBean(MBeanServerConnection connection)
			throws IOException {
		return ManagementFactory.<ThreadMXBean> newPlatformMXBeanProxy(
				connection, ManagementFactory.THREAD_MXBEAN_NAME,
				ThreadMXBean.class);
	}

	public RuntimeMXBean getRuntimeMXBean() {
		return ManagementFactory.getRuntimeMXBean();
	}

	public RuntimeMXBean getRuntimeMXBean(MBeanServerConnection connection)
			throws IOException {
		return ManagementFactory.<RuntimeMXBean> newPlatformMXBeanProxy(
				connection, ManagementFactory.RUNTIME_MXBEAN_NAME,
				RuntimeMXBean.class);
	}

	public CompilationMXBean getCompilationMXBean() {
		return ManagementFactory.getCompilationMXBean();
	}

	public CompilationMXBean getCompilationMXBean(
			MBeanServerConnection connection) throws IOException {
		return ManagementFactory.<CompilationMXBean> newPlatformMXBeanProxy(
				connection, ManagementFactory.COMPILATION_MXBEAN_NAME,
				CompilationMXBean.class);
	}

	public List<GarbageCollectorMXBean> getGarbageCollectorMXBeanList() {
		return ManagementFactory.getGarbageCollectorMXBeans();
	}

	public List<GarbageCollectorMXBean> getGarbageCollectorMXBeanList(
			MBeanServerConnection connection) throws JMException, IOException {
		List<GarbageCollectorMXBean> list = new ArrayList<GarbageCollectorMXBean>();

		ObjectName gcName = new ObjectName(
				ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*");
		for (ObjectName name : connection.queryNames(gcName, null)) {
			GarbageCollectorMXBean gc = ManagementFactory
					.<GarbageCollectorMXBean> newPlatformMXBeanProxy(
							connection, name.getCanonicalName(),
							GarbageCollectorMXBean.class);
			list.add(gc);
		}

		return list;
	}

	public List<MemoryManagerMXBean> getMemoryManagerMXBeanList() {
		return ManagementFactory.getMemoryManagerMXBeans();
	}

	public List<MemoryManagerMXBean> getMemoryManagerMXBeanList(
			MBeanServerConnection connection) throws JMException, IOException {
		List<MemoryManagerMXBean> list = new ArrayList<MemoryManagerMXBean>();

		ObjectName mmName = new ObjectName(
				ManagementFactory.MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE + ",*");
		for (ObjectName name : connection.queryNames(mmName, null)) {
			MemoryManagerMXBean mm = ManagementFactory
					.<MemoryManagerMXBean> newPlatformMXBeanProxy(connection,
							name.getCanonicalName(), MemoryManagerMXBean.class);
			list.add(mm);
		}

		return list;
	}

	public List<MemoryPoolMXBean> getMemoryPoolMXBeanList() {
		return ManagementFactory.getMemoryPoolMXBeans();
	}

	public List<MemoryPoolMXBean> getMemoryPoolMXBeanList(
			MBeanServerConnection connection) throws JMException, IOException {
		List<MemoryPoolMXBean> list = new ArrayList<MemoryPoolMXBean>();

		ObjectName mpName = new ObjectName(
				ManagementFactory.MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",*");
		for (ObjectName name : connection.queryNames(mpName, null)) {
			MemoryPoolMXBean mp = ManagementFactory
					.<MemoryPoolMXBean> newPlatformMXBeanProxy(connection,
							name.getCanonicalName(), MemoryPoolMXBean.class);
			list.add(mp);
		}

		return list;
	}

	public MemoryPoolMXBean getTenuredGenMemoryPoolMXBean(
			List<MemoryPoolMXBean> memoryPoolMXBeanList) {
		MemoryPoolMXBean tenuredGen = null;
		for (MemoryPoolMXBean pool : memoryPoolMXBeanList) {
			if (pool.getType().equals(MemoryType.HEAP)
					&& (pool.getName().indexOf("Eden") == -1)
					&& (pool.getName().indexOf("Survivor") == -1)) {
				tenuredGen = pool;
				break;
			}
		}
		return tenuredGen;
	}

	public MemoryPoolMXBean getPermGenMemoryPoolMXBean(
			List<MemoryPoolMXBean> memoryPoolMXBeanList) {
		MemoryPoolMXBean permGen = null;
		for (MemoryPoolMXBean pool : memoryPoolMXBeanList) {
			if ((pool.getType().equals(MemoryType.NON_HEAP))
					&& (pool.getName().indexOf("Perm") != -1)) {
				permGen = pool;
				break;
			}
		}
		return permGen;
	}

	public ContainerJVMStatus retrieveContainerJVMStatus(String moduleName,
			boolean isAlive, RuntimeMXBean runtimeMXBean,
			OperatingSystemMXBean operatingSystemMXBean,
			MemoryMXBean memoryMXBean, MemoryPoolMXBean tenuredGenPool,
			MemoryPoolMXBean permGenPool, ThreadMXBean threadMXBean,
			boolean detectDeadLock) throws Exception {

		return new ContainerJVMStatus(Calendar.getInstance().getTime(),
				moduleName, isAlive, runtimeMXBean, operatingSystemMXBean,
				memoryMXBean, tenuredGenPool, permGenPool, threadMXBean,
				detectDeadLock);
	}
}
