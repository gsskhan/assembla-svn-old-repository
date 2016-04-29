/**
 * 
 */
package com.citi.retail.optima.etl.batch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author sr67841
 * @param <T>
 * 
 */
public class FileMergeTasklet implements Tasklet {

	
	private String outputLocation;

	@Override
	public RepeatStatus execute(StepContribution stepContribution,
			ChunkContext chunkContext) throws Exception {
				try {
					
					//String mergeCommand = "./FileMerger.ksh "  +  outputDirectory + " " + footerItem.getOutputFileResourceName()+ETLConstants.DAT;
					System.out.println("./FileMerger.ksh "  +  outputLocation);
					String mergeCommand = "./FileMerger.ksh "  +  outputLocation;
					 Process p = Runtime.getRuntime().exec(mergeCommand);
					 p.waitFor();
				} catch (Exception e) {

		}

		return RepeatStatus.FINISHED;
	}

	public String getOutputLocation() {
		return outputLocation;
	}

	public void setOutputLocation(String outputLocation) {
		this.outputLocation = outputLocation;
	}

}