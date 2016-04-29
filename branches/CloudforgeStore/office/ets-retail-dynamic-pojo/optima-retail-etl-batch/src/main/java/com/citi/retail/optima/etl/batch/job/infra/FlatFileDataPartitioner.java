package com.citi.retail.optima.etl.batch.job.infra;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.util.Assert;

import com.citi.retail.optima.etl.common.ETLConstants;

public class FlatFileDataPartitioner implements InitializingBean,Partitioner{

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FlatFileDataPartitioner.class);
	
	private final static String OS = System.getProperty("os.name").toLowerCase();



	private Resource[] resources;
	
	private String directoryName;
	
	private String originalFile;
	
	private String splitFile;
	
	private String archvFile;
	
	
	private String filePattern;
	
	private File[] fileArray;

	private int noOfRecordsPerSplit;
	
	private EvaluationContext evalContext;
	
//	@Value("${filewatcher.script.folder}")
//	private String splitScript;

	private String startTime;
	private String jobName;
	
	
	
	/**
	 * @return the originalFile
	 */
	public String getOriginalFile() {
		return originalFile;
	}

	/**
	 * @param originalFile the originalFile to set
	 */
	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	/**
	 * @return the splitFile
	 */
	public String getSplitFile() {
		return splitFile;
	}

	/**
	 * @param splitFile the splitFile to set
	 */
	public void setSplitFile(String splitFile) {
		this.splitFile = splitFile;
	}

	/**
	 * @return the archvFile
	 */
	public String getArchvFile() {
		return archvFile;
	}

	/**
	 * @param archvFile the archvFile to set
	 */
	public void setArchvFile(String archvFile) {
		this.archvFile = archvFile;
	}

	public void getResources() {

		try {
			//dont trigger split for windows env
			if((OS.indexOf("win") >= 0)){
				
			}else{
				splitFile();
			}
			
		} catch (Exception e) {
			LOGGER.info(" Error in Spliting " + e);
		}

		try {
			
			File folder = null;
			if((OS.indexOf("win") >= 0)){
				folder = new File(originalFile);
			}else{
				folder = new File(splitFile);
			}
			File[] fileArr;

			int i = 0;
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			
			if(folder.isDirectory()){
				fileArr = folder.listFiles();
				resources = new Resource[fileArr.length];
				for(File file : fileArr){
					//if(Pattern.matches(filePattern,file.getName())){
					if(file.getName().contains(filePattern)){
						LOGGER.info(directoryName+filePattern);
						resources[i] = resolver.getResource("file:"+ file.getAbsolutePath());
						i++;
					}
				}
			}
			
		} catch (Exception e) {
			LOGGER.info(" Error in getting the resources/fils " + e);
		}

	}
	
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>(gridSize);
		Integer i = 0;
		getResources();
		for (Resource resource : resources) {
			
			if (resource!=null) {
				ExecutionContext context = new ExecutionContext();
				Assert.state(resource.exists(), "Resource does not exist: "
						+ resource);
				try {
					context.putString("fileName", resource.getURL()
							.toExternalForm());
					context.putInt(ETLConstants.PARTITION_ID,i);
				} catch (IOException e) {
					throw new IllegalArgumentException(
							"File could not be located for: " + resource, e);
				}
				map.put(i.toString(), context);
				i++;
			}
		}
		return map;
	}

	public void splitFile() throws Exception {

		LOGGER.info(" Split Started ");
		
		String splitCommand = "sh ./FileSplitter.sh "
				//+ originalFile + " "+ splitFile + " " + filePattern + " " + noOfRecordsPerSplit;
				+ originalFile + " "+ splitFile + " " + filePattern + " " + noOfRecordsPerSplit + " " + getJobName() + " " + getStartTime() +" "+ archvFile;
		Process p = Runtime.getRuntime().exec(splitCommand);
		p.waitFor();

		LOGGER.info(" Split Successfull " + splitCommand);
	}

	/**
	 * @return the directoryName
	 */
	public String getDirectoryName() {
		return directoryName;
	}

	/**
	 * @param directoryName
	 *            the directoryName to set
	 */
	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	/**
	 * @return the filePattern
	 */
	public String getFilePattern() {
		return filePattern;
	}

	/**
	 * @param filePattern
	 *            the filePattern to set
	 */
	public void setFilePattern(String filePattern) {
		this.filePattern = filePattern;
	}

	/**
	 * @return the noOfRecordsPerSplit
	 */
	public int getNoOfRecordsPerSplit() {
		return noOfRecordsPerSplit;
	}

	/**
	 * @param noOfRecordsPerSplit
	 *            the noOfRecordsPerSplit to set
	 */
	public void setNoOfRecordsPerSplit(int noOfRecordsPerSplit) {
		this.noOfRecordsPerSplit = noOfRecordsPerSplit;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the evalContext
	 */
	public EvaluationContext getEvalContext() {
		return evalContext;
	}

	/**
	 * @param evalContext the evalContext to set
	 */
	public void setEvalContext(EvaluationContext evalContext) {
		this.evalContext = evalContext;
	}
}
