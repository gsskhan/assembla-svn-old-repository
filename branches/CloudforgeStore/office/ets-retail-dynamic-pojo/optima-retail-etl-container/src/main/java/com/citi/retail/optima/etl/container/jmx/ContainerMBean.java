package com.citi.retail.optima.etl.container.jmx;

public interface ContainerMBean {

	String OBJECT_NAME = ContainerUtil.OPTIMA_RETAIL_ETL
			+ ":module=Container";

	void stop() throws Exception;

	void startModule() throws Exception;

	void stopModule() throws Exception;

	String getModuleName() throws Exception;

	String getModuleJmxObjectName() throws Exception;

	String getModuleJmxServiceUrl() throws Exception;

	String getContainerJVMStatusJsonString(boolean detectDeadLock)
			throws Exception;

	void setHeapMemoryUsageWarningThreshold(double percentage) throws Exception;

	void setNonHeapMemoryUsageWarningThreshold(double percentage)
			throws Exception;
}
