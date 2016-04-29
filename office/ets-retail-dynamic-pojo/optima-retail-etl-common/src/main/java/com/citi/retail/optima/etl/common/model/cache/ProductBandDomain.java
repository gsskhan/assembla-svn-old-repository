package com.citi.retail.optima.etl.common.model.cache;

/**
 * domain object for collateralised band
 * @author av51190
 *
 */
public class ProductBandDomain {

	private Integer processingUnitId;
	private String accLvlproductTypeCd;
	private String segmentType;
	private Long productBandId;
	public Long getProductBandId() {
		return productBandId;
	}
	public void setProductBandId(Long productBandId) {
		this.productBandId = productBandId;
	}
	private String productTypeCd;
	private String productTypeSegVal;
	private String productTypeSegDesc;
	
	public Integer getProcessingUnitId() {
		return processingUnitId;
	}
	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
	}
	public String getProductTypeCd() {
		return productTypeCd;
	}
	public void setProductTypeCd(String productTypeCd) {
		this.productTypeCd = productTypeCd;
	}
	public String getProductTypeSegVal() {
		return productTypeSegVal;
	}
	public void setProductTypeSegVal(String productTypeSegVal) {
		this.productTypeSegVal = productTypeSegVal;
	}
	public String getProductTypeSegDesc() {
		return productTypeSegDesc;
	}
	public void setProductTypeSegDesc(String productTypeSegDesc) {
		this.productTypeSegDesc = productTypeSegDesc;
	}
	public String getAccLvlproductTypeCd() {
		return accLvlproductTypeCd;
	}
	public void setAccLvlproductTypeCd(String accLvlproductTypeCd) {
		this.accLvlproductTypeCd = accLvlproductTypeCd;
	}
	public String getSegmentType() {
		return segmentType;
	}
	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
	}
	
}
