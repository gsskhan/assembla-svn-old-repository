package com.citi.retail.optima.etl.controller.dao;

import java.util.List;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 *
 */
public interface JobInstanceLoaderDao {

	List<BatchInstance> getAllJobs() throws OptimaRetailApplicationException;
}
