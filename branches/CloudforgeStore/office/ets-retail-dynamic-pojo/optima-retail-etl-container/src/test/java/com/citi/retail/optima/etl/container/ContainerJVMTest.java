package com.citi.retail.optima.etl.container;

import org.junit.Test;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.container.monitor.ContainerJVMStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContainerJVMTest extends AbstractStartedContainerTest {

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testRetrieveJvmStatus() throws Exception {
		Assert.notNull(admin.retrieveJvmStatus(jmxHost, jmxPort, false),
				"Cannot retrieve JVM Status of the Container!");
	}

	@Test
	public void testSetHeapMemoryUsageWarningThreshold() throws Exception {
		// get default warning threshold
		JsonNode previouJvmStatus = this.mapper.readTree(admin
				.retrieveJvmStatus(jmxHost, jmxPort, false));
		long originalThresholdByteSize = previouJvmStatus
				.path("memoryUsageInfo")
				.path(ContainerJVMStatus.MemoryUsageInfoEnum.heapUsage.name())
				.path(ContainerJVMStatus.MemoryUsageDetailInfoEnum.threshold
						.name()).asLong();

		// set new threshold percentage
		admin.setHeapMemoryUsageWarningThreshold(jmxHost, jmxPort, 0.9);

		JsonNode currentJvmStatus = this.mapper.readTree(admin
				.retrieveJvmStatus(jmxHost, jmxPort, false));
		long updatedThresholdByteSize = currentJvmStatus
				.path("memoryUsageInfo")
				.path(ContainerJVMStatus.MemoryUsageInfoEnum.heapUsage.name())
				.path(ContainerJVMStatus.MemoryUsageDetailInfoEnum.threshold
						.name()).asLong();

		Assert.isTrue((originalThresholdByteSize != updatedThresholdByteSize),
				"Failed to set Heap Memory Usage Warning Threshold!");
	}

	@Test
	public void testSetNonHeapMemoryUsageWarningThreshold() throws Exception {
		// get default warning threshold
		JsonNode previouJvmStatus = this.mapper.readTree(admin
				.retrieveJvmStatus(jmxHost, jmxPort, false));
		long originalThresholdByteSize = previouJvmStatus
				.path("memoryUsageInfo")
				.path(ContainerJVMStatus.MemoryUsageInfoEnum.nonHeapUsage
						.name())
				.path(ContainerJVMStatus.MemoryUsageDetailInfoEnum.threshold
						.name()).asLong();

		// set new threshold percentage
		admin.setNonHeapMemoryUsageWarningThreshold(jmxHost, jmxPort, 0.9);

		JsonNode currentJvmStatus = this.mapper.readTree(admin
				.retrieveJvmStatus(jmxHost, jmxPort, false));
		long updatedThresholdByteSize = currentJvmStatus
				.path("memoryUsageInfo")
				.path(ContainerJVMStatus.MemoryUsageInfoEnum.nonHeapUsage
						.name())
				.path(ContainerJVMStatus.MemoryUsageDetailInfoEnum.threshold
						.name()).asLong();

		Assert.isTrue((originalThresholdByteSize != updatedThresholdByteSize),
				"Failed to set Non-Heap Memory Usage Warning Threshold!");
	}
}
