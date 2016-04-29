/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.util.Date;
import java.util.List;

/**
 * @author sm59053
 *
 */
public class POCFileDetailsVO {

	private int detailId = 0;
	private int batchId = 0;
	private String fileCd = null;
	private String countryCd = null;
	private String productcd = null;
	private List<FileColumnDetails> columnDetails = null;
	private String columnNameList;
	private boolean isSupportFile = false;
	private Date dataDate = null;
	/**
	 * @return the detailId
	 */
	public int getDetailId() {
		return detailId;
	}
	/**
	 * @param detailId the detailId to set
	 */
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	/**
	 * @return the batchId
	 */
	public int getBatchId() {
		return batchId;
	}
	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	/**
	 * @return the fileCd
	 */
	public String getFileCd() {
		return fileCd;
	}
	/**
	 * @param fileCd the fileCd to set
	 */
	public void setFileCd(String fileCd) {
		this.fileCd = fileCd;
	}
	
	/**
	 * @return the dataDate
	 */
	public Date getDataDate() {
		return dataDate;
	}
	/**
	 * @param dataDate the dataDate to set
	 */
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}
	/**
	 * @return the columnDetails
	 */
	public List<FileColumnDetails> getColumnDetails() {
		return columnDetails;
	}
	/**
	 * @param columnDetails the columnDetails to set
	 */
	public void setColumnDetails(List<FileColumnDetails> columnDetails) {
		this.columnDetails = columnDetails;
	}
	/**
	 * @return the columnNameList
	 */
	public String getColumnNameList() {
		return columnNameList;
	}
	/**
	 * @param columnNameList the columnNameList to set
	 */
	public void setColumnNameList(String columnNameList) {
		this.columnNameList = columnNameList;
	}
	/**
	 * @return the countryCd
	 */
	public String getCountryCd() {
		return countryCd;
	}
	/**
	 * @param countryCd the countryCd to set
	 */
	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}
	/**
	 * @return the productcd
	 */
	public String getProductcd() {
		return productcd;
	}
	/**
	 * @param productcd the productcd to set
	 */
	public void setProductcd(String productcd) {
		this.productcd = productcd;
	}
	/**
	 * @return the isSupportFile
	 */
	public boolean isSupportFile() {
		return isSupportFile;
	}
	/**
	 * @param isSupportFile the isSupportFile to set
	 */
	public void setSupportFile(boolean isSupportFile) {
		this.isSupportFile = isSupportFile;
	}
}
