package org.dms.web.dao;

import org.dms.web.exception.DmsRuntimeException;

public interface SequenceDao {
	
	long getNextSequenceId(String key) throws DmsRuntimeException;

}
