package com.citi.retail.optima.etl.common.model;

import java.net.URI;

/*
 * @author - ns21567
 * This class holds all the information of a user submitted file.
 * All the user submission information required to launch the job is stored and retrieved from this POJO
 * */
public class FileInformation {

	public FileInformation() {
		super();
	}
	
	private Long fileId;
	private String fileName;
	private String fileType;
	private URI fileLocation;
	
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public URI getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(URI fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	
	
}
