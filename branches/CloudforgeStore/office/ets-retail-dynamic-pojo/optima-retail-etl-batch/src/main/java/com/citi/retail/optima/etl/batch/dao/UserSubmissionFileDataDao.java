package com.citi.retail.optima.etl.batch.dao;


/**
 * @author sr67841
 *
 */
public interface UserSubmissionFileDataDao {

	boolean updateUserSubmissionStatus(long fileRefId, String status);

}
