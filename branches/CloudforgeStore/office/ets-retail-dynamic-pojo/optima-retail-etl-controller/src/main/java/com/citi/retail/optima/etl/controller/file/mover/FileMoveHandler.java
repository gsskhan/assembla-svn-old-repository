package com.citi.retail.optima.etl.controller.file.mover;

import org.springframework.integration.Message;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.model.RequestMessageType;
import com.citi.retail.optima.etl.controller.request.handler.RequestHandler;
import com.citi.retail.optima.xsd.internal.OptimaRetailETLEvent;

public class FileMoveHandler implements RequestHandler<OptimaRetailETLEvent>
{
	private FileMoverUtility fileMoveUtil;
	
	public void setFileMoveUtil(FileMoverUtility fileMoveUtil) {
		this.fileMoveUtil = fileMoveUtil;
	}	
	
	public RequestMessageType handleRequest(Message<OptimaRetailETLEvent> message)
			throws OptimaRetailApplicationException{
		try {			
			Long batchInstId = message.getPayload().getBatchInstanceId().longValue();		
			fileMoveUtil.moveFileForBatch(batchInstId, "success");
		}catch(OptimaRetailApplicationException e){
			throw e;
		}
		return RequestMessageType.BATCH_COMPLETION;
	}
}
