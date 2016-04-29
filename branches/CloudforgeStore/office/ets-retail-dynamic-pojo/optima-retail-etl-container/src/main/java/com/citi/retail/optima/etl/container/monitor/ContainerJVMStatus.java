package com.citi.retail.optima.etl.container.monitor;

import java.io.Serializable;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainerJVMStatus implements Serializable {
	private static final long serialVersionUID = 7497632708555663389L;
			
	public enum ModuleInfoEnum { moduleName, alive };
	public enum PlatformInfoEnum { osName, osVersion, osArch, javaVersion, javaVendor, vmVersion, vmVendor, availableProcessors };
	public enum MemoryUsageInfoEnum { totalPhysicalMemorySize, freePhysicalMemorySize, totalSwapSpaceSize, freeSwapSpaceSize, committedVirtualMemorySize, heapUsage, nonHeapUsage};
	public enum MemoryUsageDetailInfoEnum { threshold, thresholdCount, initAmount, currentlyUsedAmount, committedAmount, maxAmount };
	public enum ThreadingInfoEnum { startedThreadCount, liveThreadCount, peakThreadCount, daemonThreadCount, deadLockedThreadList, threadDetailsList };
	public enum ThreadingDetailInfoEnum { threadId, threadName, state }; 

	private Date recordTime;

	// in milliseconds
	private long containerUptime;

	private Double systemLoadAverage;

	// in nanoseconds (-1 if this operation is not supported)
	private long processCpuTime;	
	
	private OperatingSystemMXBean operatingSystemMXBean;
	
	private final Map<String,Object> moduleInfo = new HashMap<String,Object>();
	private final Map<String,Object> platformInfo = new HashMap<String,Object>();	
	private final Map<String,Object> memoryUsageInfo = new HashMap<String,Object>();
	private final Map<String,Object> threadingInfo = new HashMap<String,Object>();

	@SuppressWarnings("restriction")
	public ContainerJVMStatus(Date recordTime, String moduleName,
			boolean alive, RuntimeMXBean runtimeMXBean,
			OperatingSystemMXBean operatingSystemMXBean,
			MemoryMXBean memoryMXBean, MemoryPoolMXBean tenuredGenPool,
			MemoryPoolMXBean permGenPool, ThreadMXBean threadMXBean,
			boolean detectDeadLock) {

		this.recordTime = recordTime;
		this.containerUptime = runtimeMXBean.getUptime();
		
		if (operatingSystemMXBean.getSystemLoadAverage() > 0) {
			this.systemLoadAverage = operatingSystemMXBean.getSystemLoadAverage();
		}
		
		// nanoseconds
		if (operatingSystemMXBean instanceof com.sun.management.OperatingSystemMXBean) {
			this.operatingSystemMXBean = operatingSystemMXBean;				
		}
	
		putModuleInfo(moduleName, alive);		
		putPlatformInfo(operatingSystemMXBean);
		putMemoryUsageInfo(operatingSystemMXBean, memoryMXBean, tenuredGenPool, permGenPool);
		putThreadingInfo(threadMXBean, detectDeadLock);
	}
		
	public Date getRecordTime() {
		return recordTime;
	}

	public long getContainerUptime() {
		return containerUptime;
	}

	public Double getSystemLoadAverage() {
		return systemLoadAverage;
	}

	public long getProcessCpuTime() {
		if (processCpuTime <=0 && operatingSystemMXBean != null) {
			this.processCpuTime = ((com.sun.management.OperatingSystemMXBean) operatingSystemMXBean).getProcessCpuTime();	
		}		
		return processCpuTime;
	}
	
	public Map<String, Object> getModuleInfo() {
		Map<String,Object> data = new HashMap<String,Object>();
		data.putAll(moduleInfo);
		return data;
	}

	public Map<String, Object> getPlatformInfo() {
		Map<String,Object> data = new HashMap<String,Object>();
		data.putAll(platformInfo);
		return data;
	}

	public Map<String, Object> getMemoryUsageInfo() {
		Map<String,Object> data = new HashMap<String,Object>();
		data.putAll(memoryUsageInfo);
		return data;
	}

	public Map<String, Object> getThreadingInfo() {
		Map<String,Object> data = new HashMap<String,Object>();
		data.putAll(threadingInfo);
		return data;
	}

	private void putModuleInfo(String moduleName, boolean alive) {
		this.moduleInfo.put(ModuleInfoEnum.moduleName.name(), moduleName);
		this.moduleInfo.put(ModuleInfoEnum.alive.name(), alive);
	}
	
	private void putPlatformInfo(OperatingSystemMXBean operatingSystemMXBean) {
		this.platformInfo.put(PlatformInfoEnum.osName.name(), System.getProperty("os.name"));
		this.platformInfo.put(PlatformInfoEnum.osVersion.name(), System.getProperty("os.version"));
		this.platformInfo.put(PlatformInfoEnum.osArch.name(), System.getProperty("os.osArch"));
		
		this.platformInfo.put(PlatformInfoEnum.javaVersion.name(), System.getProperty("java.version"));
		this.platformInfo.put(PlatformInfoEnum.javaVendor.name(), System.getProperty("java.vendor"));
		
		this.platformInfo.put(PlatformInfoEnum.vmVersion.name(), System.getProperty("java.vm.version"));
		this.platformInfo.put(PlatformInfoEnum.vmVendor.name(), System.getProperty("java.vm.vendor"));
		
		this.platformInfo.put(
				PlatformInfoEnum.availableProcessors.name(),
				operatingSystemMXBean.getAvailableProcessors()
		);		
	}
	
	@SuppressWarnings("restriction")
	private void putMemoryUsageInfo(OperatingSystemMXBean operatingSystemMXBean, MemoryMXBean memoryMXBean, MemoryPoolMXBean tenuredGenPool, MemoryPoolMXBean permGenPool) {
		if (operatingSystemMXBean instanceof com.sun.management.OperatingSystemMXBean) {
			com.sun.management.OperatingSystemMXBean osMXBean = (com.sun.management.OperatingSystemMXBean)operatingSystemMXBean;			
			
			// in bytes
			this.memoryUsageInfo.put(MemoryUsageInfoEnum.totalPhysicalMemorySize.name(), osMXBean.getTotalPhysicalMemorySize());
			this.memoryUsageInfo.put(MemoryUsageInfoEnum.freePhysicalMemorySize.name(), osMXBean.getFreePhysicalMemorySize());
			this.memoryUsageInfo.put(MemoryUsageInfoEnum.totalSwapSpaceSize.name(), osMXBean.getTotalSwapSpaceSize());
			this.memoryUsageInfo.put(MemoryUsageInfoEnum.freeSwapSpaceSize.name(), osMXBean.getFreeSwapSpaceSize());
			
			// in bytes (-1 if this operation is not supported)
			if (osMXBean.getCommittedVirtualMemorySize() != -1) {
				this.memoryUsageInfo.put(MemoryUsageInfoEnum.committedVirtualMemorySize.name(), osMXBean.getCommittedVirtualMemorySize());
			}						
		}
		
		this.memoryUsageInfo.put(
				MemoryUsageInfoEnum.heapUsage.name(),
				getMemoryUsageDetailInfoMap(memoryMXBean.getHeapMemoryUsage(), tenuredGenPool)
		);
		
		this.memoryUsageInfo.put(
				MemoryUsageInfoEnum.nonHeapUsage.name(),
				getMemoryUsageDetailInfoMap(memoryMXBean.getNonHeapMemoryUsage(), permGenPool)
		);		
		
	}
	
	private Map<String,Object> getMemoryUsageDetailInfoMap(MemoryUsage memoryUsage, MemoryPoolMXBean memoryPoolMXBean) {
		Map<String,Object> memoryUsageDetailInfo = new HashMap<String,Object>();
		
		if (memoryPoolMXBean.getUsageThreshold() != 0) {
			memoryUsageDetailInfo.put(MemoryUsageDetailInfoEnum.threshold.name(), memoryPoolMXBean.getUsageThreshold());
			memoryUsageDetailInfo.put(MemoryUsageDetailInfoEnum.thresholdCount.name(), memoryPoolMXBean.getUsageThresholdCount());
		}
		
		memoryUsageDetailInfo.put(MemoryUsageDetailInfoEnum.initAmount.name(), memoryUsage.getInit());
		memoryUsageDetailInfo.put(MemoryUsageDetailInfoEnum.currentlyUsedAmount.name(), memoryUsage.getUsed());
		memoryUsageDetailInfo.put(MemoryUsageDetailInfoEnum.committedAmount.name(), memoryUsage.getCommitted());
		memoryUsageDetailInfo.put(MemoryUsageDetailInfoEnum.maxAmount.name(), memoryUsage.getMax());	
		
		return memoryUsageDetailInfo;
	}
	
	private void putThreadingInfo(ThreadMXBean threadMXBean, boolean detectDeadLock) {
		this.threadingInfo.put(ThreadingInfoEnum.startedThreadCount.name(), threadMXBean.getTotalStartedThreadCount());
		this.threadingInfo.put(ThreadingInfoEnum.liveThreadCount.name(), threadMXBean.getThreadCount());
		this.threadingInfo.put(ThreadingInfoEnum.peakThreadCount.name(), threadMXBean.getPeakThreadCount());
		this.threadingInfo.put(ThreadingInfoEnum.daemonThreadCount.name(), threadMXBean.getDaemonThreadCount());
		
		if (detectDeadLock) {
			this.threadingInfo.put(
					ThreadingInfoEnum.deadLockedThreadList.name(),
					threadMXBean.findDeadlockedThreads()
			);
		}
		
		this.threadingInfo.put(
				ThreadingInfoEnum.threadDetailsList.name(),
				getThreadingDetailInfoList(threadMXBean)
		);		
	}
		
	private List<Map<String,Object>> getThreadingDetailInfoList(ThreadMXBean threadMXBean) {
		List<Map<String,Object>> threadingDetailInfoList = new ArrayList<Map<String,Object>>();
		
		for (long threadId : threadMXBean.getAllThreadIds()) {
			ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
			threadingDetailInfoList.add(getThreadingDetailInfoMap(threadInfo));			
		}
		
		return threadingDetailInfoList;
	}
	
	private Map<String,Object> getThreadingDetailInfoMap(ThreadInfo threadInfo) {
		Map<String,Object> threadingDetailInfoMap = new HashMap<String,Object>();
		
		threadingDetailInfoMap.put(ThreadingDetailInfoEnum.threadId.name(), threadInfo.getThreadId());
		threadingDetailInfoMap.put(ThreadingDetailInfoEnum.threadName.name(), threadInfo.getThreadName());
		threadingDetailInfoMap.put(ThreadingDetailInfoEnum.state.name(), threadInfo.getThreadState().name());
		
		return threadingDetailInfoMap;
	}
}
