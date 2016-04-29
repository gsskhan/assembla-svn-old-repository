/**
 * 
 */
package com.citi.retail.optima.etl.batch.job.infra.test;

import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.item.ExecutionContext;

import com.citi.retail.optima.etl.batch.job.infra.FlatFileDataPartitioner;
import com.citi.retail.optima.etl.batch.job.infra.ProcessType;

/**
 * @author sr67841
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class FlatFileDataPartitionerTest {

	@Mock
	private FlatFileDataPartitioner flatFileDataPartitioner;
	
	@Before
	public void setUp() throws Exception {
		when(flatFileDataPartitioner.getDirectoryName()).thenReturn(
				"C:/data/");
		when(flatFileDataPartitioner.getFilePattern()).thenReturn(
		"*RNBW*");
		when(flatFileDataPartitioner.getNoOfRecordsPerSplit()).thenReturn(
		100);
		
	}

	@Test
	public void testPatition() {
	
		Map<String, ExecutionContext> partitionMap= flatFileDataPartitioner.partition(5);
		System.out.println(" partitionMap "+partitionMap.toString());
		Assert.assertNotNull(partitionMap);
		
	}
}
