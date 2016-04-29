/**
 * 
 */
package com.citi.retail.optima.etl.cache.model;

/**
 * @author mc56120
 *
 */
public class RegionVO {
	
	private Integer geographyId;
	private Integer regionIntCode;
	private String regionStrCode;
	private String regionName;
	private String regionDescr;
	private String segmentType;
	private String bussFuncCode;
	private Integer processingUnitId;

	
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
	 * @return the regionIntCode
	 */
	public Integer getRegionIntCode() {
		return regionIntCode;
	}
	/**
	 * @param regionIntCode the regionIntCode to set
	 */
	public void setRegionIntCode(Integer regionIntCode) {
		this.regionIntCode = regionIntCode;
	}
	/**
	 * @return the regionStrCode
	 */
	public String getRegionStrCode() {
		return regionStrCode;
	}
	/**
	 * @param regionStrCode the regionStrCode to set
	 */
	public void setRegionStrCode(String regionStrCode) {
		this.regionStrCode = regionStrCode;
	}
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	/**
	 * @return the regionDescr
	 */
	public String getRegionDescr() {
		return regionDescr;
	}
	/**
	 * @param regionDescr the regionDescr to set
	 */
	public void setRegionDescr(String regionDescr) {
		this.regionDescr = regionDescr;
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
	 * @return the bussFuncCode
	 */
	public String getBussFuncCode() {
		return bussFuncCode;
	}
	/**
	 * @param bussFuncCode the bussFuncCode to set
	 */
	public void setBussFuncCode(String bussFuncCode) {
		this.bussFuncCode = bussFuncCode;
	}
	
	

}
