package com.citi.retail.optima.etl.batch.dao;

import com.citi.retail.optima.etl.batch.vo.BatchDetailsVO;

/*
 * @author ns21567
 */
public interface BatchJobDetailsDao {

	BatchDetailsVO getBatchdetails(int i);
	
	int getBatchId(int jobInsatnceId);

}
