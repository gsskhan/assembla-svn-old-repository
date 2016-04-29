/**
 * 
 */
package com.citi.retail.optima.etl.controller.resource.manager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.controller.model.BatchInstance;


/**
 * @author hs73849
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.controller.test.xml" })
public class JobInstanceComparatorTest {

	private JobInstanceComparator jobInstanceComparator = new JobInstanceComparator();

	@Test
	public void testPriorityEquals() {
		BatchInstance instance1 = new BatchInstance();
		instance1.setCurrentPriority(9);
		instance1.setBatchInstanceId(11L);

		BatchInstance instance2 = new BatchInstance();
		instance2.setCurrentPriority(9);
		instance2.setBatchInstanceId(11L);
		int result = jobInstanceComparator.compare(instance1, instance2);
		Assert.assertEquals(result, 1);

		instance1.setBatchInstanceId(3L);
		result = jobInstanceComparator.compare(instance1, instance2);
		Assert.assertEquals(result, -1);
	}

	@Test
	public void testPriorityLessThan() {
		BatchInstance instance1 = new BatchInstance();
		instance1.setCurrentPriority(9);

		BatchInstance instance2 = new BatchInstance();
		instance2.setCurrentPriority(19);
		int result = jobInstanceComparator.compare(instance1, instance2);
		Assert.assertEquals(result, 1);
	}

	@Test
	public void testPriorityGreaterThan() {
		BatchInstance instance1 = new BatchInstance();
		instance1.setCurrentPriority(19);

		BatchInstance instance2 = new BatchInstance();
		instance2.setCurrentPriority(9);
		int result = jobInstanceComparator.compare(instance1, instance2);
		Assert.assertEquals(result, 0);
	}

}
