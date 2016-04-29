/**
 * 
 */
package com.citi.retail.optima.etl.batch.tasklet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.UrlResource;

import com.citi.retail.optima.etl.common.model.RainbowFileHeader;

public class HeaderTasklet implements Tasklet {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(HeaderTasklet.class);

	private Map<String, String> headerItemDetails = new HashMap<String, String>();
	private FlatFileItemWriter headerWriter;

	@SuppressWarnings("unchecked")
	@Override
	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {

		//Need to optimize
		
		for (Map.Entry<String, String> headerDetail : headerItemDetails.entrySet()) {
			
			headerWriter.setResource(new UrlResource(headerDetail.getKey()));
			headerWriter.open(chunkContext.getStepContext().getStepExecution()
					.getExecutionContext());
			ArrayList<RainbowFileHeader> rainbowFileHeaderList= new ArrayList<RainbowFileHeader>();
			RainbowFileHeader rainbowFileHeader = new RainbowFileHeader();
			rainbowFileHeader.setHeaderString(headerDetail.getValue());
			rainbowFileHeaderList.add(rainbowFileHeader);
			headerWriter.write(rainbowFileHeaderList);
			headerWriter.close();
		}

		return RepeatStatus.FINISHED;
	}

	public Map<String, String> getHeaderItemDetails() {
		return headerItemDetails;
	}

	public void setHeaderItemDetails(Map<String, String> headerItemDetails) {
		this.headerItemDetails = headerItemDetails;
	}

	public FlatFileItemWriter getHeaderWriter() {
		return headerWriter;
	}

	public void setHeaderWriter(FlatFileItemWriter headerWriter) {
		this.headerWriter = headerWriter;
	}

}
