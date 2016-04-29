/**
 * 
 */
package com.citi.ets.dashboard.bean;


/**
 * @author ak64503
 *
 */
public class SectorBean {
	
	private String SectorName;
	private String SubSectorName;
	private String DynamicAppName;
	private String SubDynamicAppName;
	
	private ColumnDetails ColumnDetails;

	/**
	 * @return the sectorName
	 */
	public String getSectorName() {
	    return SectorName;
	}

	/**
	 * @param sectorName the sectorName to set
	 */
	public void setSectorName(String sectorName) {
	    SectorName = sectorName;
	}

	/**
	 * @return the subSectorName
	 */
	public String getSubSectorName() {
	    return SubSectorName;
	}

	/**
	 * @param subSectorName the subSectorName to set
	 */
	public void setSubSectorName(String subSectorName) {
	    SubSectorName = subSectorName;
	}

	/**
	 * @return the dynamicAppName
	 */
	public String getDynamicAppName() {
	    return DynamicAppName;
	}

	/**
	 * @param dynamicAppName the dynamicAppName to set
	 */
	public void setDynamicAppName(String dynamicAppName) {
	    DynamicAppName = dynamicAppName;
	}

	/**
	 * @return the columnDetails
	 */
	public ColumnDetails getColumnDetails() {
	    return ColumnDetails;
	}

	/**
	 * @param columnDetails the columnDetails to set
	 */
	public void setColumnDetails(ColumnDetails columnDetails) {
	    ColumnDetails = columnDetails;
	}

	/**
	 * @return the subDynamicAppName
	 */
	public String getSubDynamicAppName() {
		return SubDynamicAppName;
	}

	/**
	 * @param subDynamicAppName the subDynamicAppName to set
	 */
	public void setSubDynamicAppName(String subDynamicAppName) {
		SubDynamicAppName = subDynamicAppName;
	}


}
