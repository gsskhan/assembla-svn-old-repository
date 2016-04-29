package com.citi.retail.optima.etl.cache.model;

public class RegionUserSegVO {
	
	private Integer geographyId;
	private Integer geographyRefId;
	private String outputSegType;
	/**
	 * @return the geographyId
	 */
	public Integer getGeographyId() {
		return geographyId;
	}
	/**
	 * @param geographyId the geographyId to set
	 */
	public void setGeographyId(Integer geographyId) {
		this.geographyId = geographyId;
	}	
	/**
	 * @return the outputSegType
	 */
	public String getOutputSegType() {
		return outputSegType;
	}
	/**
	 * @param outputSegType the outputSegType to set
	 */
	public void setOutputSegType(String outputSegType) {
		this.outputSegType = outputSegType;
	}
	/**
	 * @return the geographyRefId
	 */
	public Integer getGeographyRefId() {
		return geographyRefId;
	}
	/**
	 * @param geographyRefId the geographyRefId to set
	 */
	public void setGeographyRefId(Integer geographyRefId) {
		this.geographyRefId = geographyRefId;
	}	
	
}
