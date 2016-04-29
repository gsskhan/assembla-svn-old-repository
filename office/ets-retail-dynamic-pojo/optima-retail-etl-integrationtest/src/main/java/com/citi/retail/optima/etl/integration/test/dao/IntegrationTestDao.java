package com.citi.retail.optima.etl.integration.test.dao;

import java.math.BigInteger;

public interface IntegrationTestDao {
	
	void testBatchJob(BigInteger batchInstanceId) throws Exception;
}
