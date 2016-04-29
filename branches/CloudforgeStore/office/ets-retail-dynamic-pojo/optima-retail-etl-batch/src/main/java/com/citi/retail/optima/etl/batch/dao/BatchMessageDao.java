package com.citi.retail.optima.etl.batch.dao;

import com.citi.retail.optima.etl.batch.vo.MessageLogVO;

public interface BatchMessageDao {

	MessageLogVO getOriginalRequestMessage(int jobinstanceId);

}
