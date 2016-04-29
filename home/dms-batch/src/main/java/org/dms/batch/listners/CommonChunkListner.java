package org.dms.batch.listners;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;

public class CommonChunkListner implements ChunkListener{
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public void afterChunk(ChunkContext context) {		

		StepContext sc = context.getStepContext();		
		Map<String, Object> secMap = sc.getStepExecutionContext();
		log.info("TEST>>>>>>"+secMap);
		String message =new String();
		for (Map.Entry<String, Object> entry : secMap.entrySet()) {
			if(entry.getKey().equalsIgnoreCase("FlatFileItemWriter.current.count"))
				message = message + "Current writer count - " + entry.getValue() +", ";
			if(entry.getKey().equalsIgnoreCase("FlatFileItemWriter.written"))
				message = message + "Current written count - " + entry.getValue() +", ";
			if(entry.getKey().equalsIgnoreCase("FlatFileItemReader.read.count"))
				message = message + "Current reader count - " + entry.getValue() +".";
		}				
		log.info("Finished processing : [" + message+"]");
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		StepContext sc = context.getStepContext();		
		Map<String, Object> secMap = sc.getStepExecutionContext();
		log.error("Finished processing with error : " + secMap );	
	}

	@Override
	public void beforeChunk(ChunkContext context) {		
		StepContext sc = context.getStepContext();		
		Map<String, Object> secMap = sc.getStepExecutionContext();
		log.info("TEST>>>>>>"+secMap);
		String message =new String();
		for (Map.Entry<String, Object> entry : secMap.entrySet()) {
			if(entry.getKey().equalsIgnoreCase("FlatFileItemWriter.current.count"))
				message = message + "Current writer count - " + entry.getValue() +", ";
			if(entry.getKey().equalsIgnoreCase("FlatFileItemWriter.written"))
				message = message + "Current written count - " + entry.getValue() +", ";
			if(entry.getKey().equalsIgnoreCase("FlatFileItemReader.read.count"))
				message = message + "Current reader count - " + entry.getValue() +".";
		}				
		log.info("Started processing  : [" + message+"]");		
	}
	

}
