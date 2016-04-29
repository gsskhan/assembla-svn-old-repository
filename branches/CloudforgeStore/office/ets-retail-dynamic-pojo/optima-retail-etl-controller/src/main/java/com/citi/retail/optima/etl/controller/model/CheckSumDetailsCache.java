package com.citi.retail.optima.etl.controller.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.citi.optima.batch.job.jdbc.ETLQueryExecutor;

public class CheckSumDetailsCache implements InitializingBean{
	private ETLQueryExecutor etlQueryExecutor;
	private static Map<String, List<CheckSumDetailsVO>> checksumMap= null;

	@Override
	public void afterPropertiesSet() throws Exception {
		setChecksumMap(etlQueryExecutor.getOutputChecksumDetails());
		
	}

	/**
	 * @return the etlQueryExecutor
	 */
	public ETLQueryExecutor getEtlQueryExecutor() {
		return etlQueryExecutor;
	}

	/**
	 * @param etlQueryExecutor the etlQueryExecutor to set
	 */
	public void setEtlQueryExecutor(ETLQueryExecutor etlQueryExecutor) {
		this.etlQueryExecutor = etlQueryExecutor;
	}

	/**
	 * @return the checksumMap
	 */
	public static Map<String, List<CheckSumDetailsVO>> getChecksumMap() {
		return checksumMap;
	}

	/**
	 * @param checksumMap the checksumMap to set
	 */
	public static void setChecksumMap(Map<String, List<CheckSumDetailsVO>> checksumMap) {
		CheckSumDetailsCache.checksumMap = checksumMap;
	}
	
	public static List<CheckSumDetailsVO> getCheckSumDetailsListWithCntrProd(String key){
		return checksumMap.get(key);
	}

}
