package com.citi.retail.optima.etl.controller.resource.manager;

import java.util.Comparator;

import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 *
 */
public class JobInstanceComparator implements Comparator<BatchInstance> {

	public int compare(BatchInstance o1, BatchInstance o2) {

		if (o1.getCurrentPriority() == o2.getCurrentPriority()) {
			if (o1.getBatchInstanceId() < o2.getBatchInstanceId()) {
				return -1;
			} else {
				return 1;
			}
		} else if (o1.getCurrentPriority() < o2.getCurrentPriority()) {
			return 1;
		}
		return 0;
	}

}
