/**
 * 
 */
package com.citi.retail.optima.etl.cache.model;

/**
 * @author mc56120
 *
 */
public class CountryRegionMappingVO {
	
	private String countryCode;
	private String segmentType;
	private Integer refGeographyId;
	private Integer processingUnitId;
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @return the processingUnitId
	 */
	public Integer getProcessingUnitId() {
		return processingUnitId;
	}
	/**
	 * @param processingUnitId the processingUnitId to set
	 */
	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the segmentType
	 */
	public String getSegmentType() {
		return segmentType;
	}
	/**
	 * @param segmentType the segmentType to set
	 */
	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
	}
	/**
	 * @return the refGeographyId
	 */
	public Integer getRefGeographyId() {
		return refGeographyId;
	}
	/**
	 * @param refGeographyId the refGeographyId to set
	 */
	public void setRefGeographyId(Integer refGeographyId) {
		this.refGeographyId = refGeographyId;
	}
	
}
