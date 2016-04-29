/**
 * 
 */
package com.citi.retail.optima.etl.controller.model;

/**
 * @author sm59053
 *
 */
public class CheckSumDetailsVO {
	
	private String countryProdCd;
	private String inputFieldPos;
	private String outputBalTypFieldPos;
	private String outputBalValFieldPos;
	private String cksumFieldName;
	private String cksumBalType;
	
	/**
	 * @return the countryProdCd
	 */
	public String getCountryProdCd() {
		return countryProdCd;
	}
	/**
	 * @param countryProdCd the countryProdCd to set
	 */
	public void setCountryProdCd(String countryProdCd) {
		this.countryProdCd = countryProdCd;
	}
	/**
	 * @return the inputFieldPos
	 */
	public String getInputFieldPos() {
		return inputFieldPos;
	}
	/**
	 * @param inputFieldPos the inputFieldPos to set
	 */
	public void setInputFieldPos(String inputFieldPos) {
		this.inputFieldPos = inputFieldPos;
	}
	/**
	 * @return the outputBalTypFieldPos
	 */
	public String getOutputBalTypFieldPos() {
		return outputBalTypFieldPos;
	}
	/**
	 * @param outputBalTypFieldPos the outputBalTypFieldPos to set
	 */
	public void setOutputBalTypFieldPos(String outputBalTypFieldPos) {
		this.outputBalTypFieldPos = outputBalTypFieldPos;
	}
	/**
	 * @return the outputBalValFieldPos
	 */
	public String getOutputBalValFieldPos() {
		return outputBalValFieldPos;
	}
	/**
	 * @param outputBalValFieldPos the outputBalValFieldPos to set
	 */
	public void setOutputBalValFieldPos(String outputBalValFieldPos) {
		this.outputBalValFieldPos = outputBalValFieldPos;
	}
	public String getCksumFieldName() {
		return cksumFieldName;
	}
	public void setCksumFieldName(String cksumFieldName) {
		this.cksumFieldName = cksumFieldName;
	}
	public String getCksumBalType() {
		return cksumBalType;
	}
	public void setCksumBalType(String cksumBalType) {
		this.cksumBalType = cksumBalType;
	}

}
