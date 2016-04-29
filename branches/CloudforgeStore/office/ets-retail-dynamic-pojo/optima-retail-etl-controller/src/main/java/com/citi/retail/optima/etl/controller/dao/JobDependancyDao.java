package com.citi.retail.optima.etl.controller.dao;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * @author hs73849
 * 
 */
public interface JobDependancyDao {

	boolean isJobTypeDependencyAvailable(Long jobTypeId, Long jobInstanceId)
			throws OptimaRetailApplicationException;
}
