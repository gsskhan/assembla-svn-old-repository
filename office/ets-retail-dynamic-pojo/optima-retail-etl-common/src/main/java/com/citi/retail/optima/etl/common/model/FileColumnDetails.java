/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

/**
 * @author sm59053
 *
 */
public class FileColumnDetails {
	
	
	private int columnDetailsId;
	private int detailId;
	private int columnOrder;
	private String columnName;
	private String columnType;
	private String columnFormat;
	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the columnType
	 */
	public String getColumnType() {
		return columnType;
	}
	/**
	 * @param columnType the columnType to set
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	/**
	 * @return the columnFormat
	 */
	public String getColumnFormat() {
		return columnFormat;
	}
	/**
	 * @param columnFormat the columnFormat to set
	 */
	public void setColumnFormat(String columnFormat) {
		this.columnFormat = columnFormat;
	}
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
	 * @return the columnDetailsId
	 */
	public int getColumnDetailsId() {
		return columnDetailsId;
	}
	/**
	 * @param columnDetailsId the columnDetailsId to set
	 */
	public void setColumnDetailsId(int columnDetailsId) {
		this.columnDetailsId = columnDetailsId;
	}
	/**
	 * @return the columnOrder
	 */
	public int getColumnOrder() {
		return columnOrder;
	}
	/**
	 * @param columnOrder the columnOrder to set
	 */
	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}
	
}
