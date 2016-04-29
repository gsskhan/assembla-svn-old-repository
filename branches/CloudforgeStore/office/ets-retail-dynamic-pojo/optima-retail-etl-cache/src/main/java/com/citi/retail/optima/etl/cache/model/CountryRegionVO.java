/**
 * 
 */
package com.citi.retail.optima.etl.cache.model;

/**
 * @author mc56120
 *
 */
public class CountryRegionVO extends BaseRef{

	private Integer geographyId;
	private RegionVO regionVO;
	private RegionUserSegVO regionUserSegVO;
	private CountryRegionMappingVO countryRegionMapping;
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
	 * @return the regionVO
	 */
	public RegionVO getRegionVO() {
		return regionVO;
	}
	/**
	 * @param regionVO the regionVO to set
	 */
	public void setRegionVO(RegionVO regionVO) {
		this.regionVO = regionVO;
	}
	/**
	 * @return the regionUserSegVO
	 */
	public RegionUserSegVO getRegionUserSegVO() {
		return regionUserSegVO;
	}
	/**
	 * @param regionUserSegVO the regionUserSegVO to set
	 */
	public void setRegionUserSegVO(RegionUserSegVO regionUserSegVO) {
		this.regionUserSegVO = regionUserSegVO;
	}
	/**
	 * @return the countryRegionMapping
	 */
	public CountryRegionMappingVO getCountryRegionMapping() {
		return countryRegionMapping;
	}
	/**
	 * @param countryRegionMapping the countryRegionMapping to set
	 */
	public void setCountryRegionMapping(CountryRegionMappingVO countryRegionMapping) {
		this.countryRegionMapping = countryRegionMapping;
	}
	
}
