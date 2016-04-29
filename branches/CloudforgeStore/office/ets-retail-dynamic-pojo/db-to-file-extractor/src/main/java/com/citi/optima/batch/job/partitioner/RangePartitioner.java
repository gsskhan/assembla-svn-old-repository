package com.citi.optima.batch.job.partitioner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class RangePartitioner implements Partitioner,InitializingBean,JobExecutionListener {
	
	private static final SimpleDateFormat pattern = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private JdbcTemplate jdbcTemp;
	
	private DataSource dataSource;
	
	private int count = 0;
	
	private String queryRetreiverQuery;
	
	private String queryToFile;
	
	private String outputLocation;
	
	private String outputFileName;
	
	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		
		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

		int range = count/gridSize;
		int fromId = 1;
		int toId = range;

		for (int i = 1; i <= gridSize; i++) {
			ExecutionContext value = new ExecutionContext();
			if(i==gridSize){
				toId = count;
			}
			System.out.println("\nStarting : Thread" + i);
			System.out.println("fromId : " + fromId);
			System.out.println("toId : " + toId);

			value.putInt("fromId", fromId);
			value.putInt("toId", toId);

			// give each thread a name
			value.putString("name", "Thread" + i);
			value.put("query", getQueryToFile());
			value.put("outputLocation", getOutputLocation());
			//value.put("outputFileName", getOutputFileName());
			result.put("partition" + i, value);

			fromId = toId + 1;
			toId += range;

		}

		return result;
	}
	
	public String getQueryRetreiverQuery() {
		return queryRetreiverQuery;
	}

	public void setQueryRetreiverQuery(String queryRetreiverQuery) {
		this.queryRetreiverQuery = queryRetreiverQuery;
	}
	
	/**
	 * @return the queryMap
	 */
//	public Map<String, String> getQueryMap() {
//		return this.queryMap;
//	}
//
	/**
	 * @param queryMap
	 *            the queryMap to set
	 */
//	public void setQueryMap(Map<String, String> queryMap) {
//		this.queryMap = queryMap;
//	}
//
	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @return the queryName
	 */
//	public String getQueryName() {
//		return queryName;
//	}

	/**
	 * @param queryName the queryName to set
	 */
//	public void setQueryName(String queryName) {
//		this.queryName = queryName;
//	}

	@Override
	public void afterPropertiesSet() throws Exception {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		
		String[] args = new String[1];
		args[0] = jobExecution.getJobInstance().getJobParameters().getString("cntryProd");
		
		String extractSQL = "";
		String outputLocation = "";
		SqlRowSet rowSet = jdbcTemp.queryForRowSet(queryRetreiverQuery,(Object[])args);
		if(rowSet.next()) {
			extractSQL = rowSet.getString(1);
			outputLocation = rowSet.getString(2);
		}
				
		if(extractSQL == null || extractSQL.length() == 0){
			throw new RuntimeException("The Country Product value is invalid or does not have " +
					"sql query assigned to it !!!");
		}
		
		if(!args[0].contains("-")){
			throw new RuntimeException("The Country Product value is invalid");
		}
		
		String[] strArr = args[0].split("-");
		String country = strArr[0];
		String product = strArr[1];
		
		String reportingPeriod = jobExecution.getJobInstance().getJobParameters().getString("rptPrd");
		String rptPrd1 = "";
		String rptPrd2 = "";
		
		if(reportingPeriod.contains("-")){
			String[] rptArr = reportingPeriod.split("-");
			rptPrd1 = rptArr[0];
			rptPrd2 = rptArr[1];
		}else{
			rptPrd1 = rptPrd2 = reportingPeriod;
		}
		
		outputFileName = country + "_" + product + "_" + rptPrd1 + "_"
				+rptPrd2 + "_" + pattern.format(new Date())+".dat";

		extractSQL = extractSQL.toLowerCase();
		String countSQL = extractSQL.replace("#ctry", "'" + country + "'").replace("#prod", "'" + product + "'").replace("#rptprd1", 
				rptPrd1).replace("#rptprd2",rptPrd2);
		countSQL = countSQL.substring(countSQL.indexOf("from"));
		countSQL = "select count(*) "+ countSQL;
		count = jdbcTemp.queryForInt(countSQL);
		extractSQL = "SELECT * from (" + extractSQL.replace("#ctry",  "'" + country + "'").replace("#prod",  "'" + product + "'").replace("#rptprd1", 
				rptPrd1).replace("#rptprd2",rptPrd2).replace("#end_col", " ROWNUM as TMP_ROW_NUM");
		extractSQL = extractSQL + ") where TMP_ROW_NUM >= ? and TMP_ROW_NUM <= ?";
		setOutputLocation(outputLocation);
		setQueryToFile(extractSQL);
		jobExecution.getExecutionContext().
			put("outputLocation", outputLocation);
		//setOutputFileName(outputFileName);
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job done!!!");
		System.exit(0);
	}

	/**
	 * @return the queryToFile
	 */
	public String getQueryToFile() {
		return queryToFile;
	}

	/**
	 * @param queryToFile the queryToFile to set
	 */
	public void setQueryToFile(String queryToFile) {
		this.queryToFile = queryToFile;
	}

	public String getOutputLocation() {
		return outputLocation;
	}

	public void setOutputLocation(String outputLocation) {
		this.outputLocation = outputLocation;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

}
