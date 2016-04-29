package com.citi.retail.optima.etl.common.model;

public class FilePathDetailVO {
	
	private String cntryProd;
	private String inputFilePath;
	private String outputPath;
	private String processedPath;
	private String archivePath;
	/**
	 * @return the cntryProd
	 */
	public String getCntryProd() {
		return cntryProd;
	}
	/**
	 * @param cntryProd the cntryProd to set
	 */
	public void setCntryProd(String cntryProd) {
		this.cntryProd = cntryProd;
	}
	/**
	 * @return the inputFilePath
	 */
	public String getInputFilePath() {
		return inputFilePath;
	}
	/**
	 * @param inputFilePath the inputFilePath to set
	 */
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	/**
	 * @return the outputPath
	 */
	public String getOutputPath() {
		return outputPath;
	}
	/**
	 * @param outputPath the outputPath to set
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	/**
	 * @return the processedPath
	 */
	public String getProcessedPath() {
		return processedPath;
	}
	/**
	 * @param processedPath the processedPath to set
	 */
	public void setProcessedPath(String processedPath) {
		this.processedPath = processedPath;
	}
	/**
	 * @return the archivePath
	 */
	public String getArchivePath() {
		return archivePath;
	}
	/**
	 * @param archivePath the archivePath to set
	 */
	public void setArchivePath(String archivePath) {
		this.archivePath = archivePath;
	}
	
	
}
