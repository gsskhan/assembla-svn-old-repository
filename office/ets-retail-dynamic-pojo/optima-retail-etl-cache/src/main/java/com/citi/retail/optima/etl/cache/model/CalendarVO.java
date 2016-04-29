/**
 * 
 */
package com.citi.retail.optima.etl.cache.model;

import java.util.Date;

/**
 * @author av51190
 *
 */
public class CalendarVO {

	private Integer processingUnit;
	private String fedSchl;	
	private Integer rptYr;
	private Integer rptQtr;
	private Date reqstDt;
	private Date startDt;
	private Date endDt;
	private Integer allowedPeriod1;
	private Integer allowedPeriod2;
	/**
	 * @return the allowedPeriod1
	 */
	public Integer getAllowedPeriod1() {
		return allowedPeriod1;
	}
	/**
	 * @param allowedPeriod1 the allowedPeriod1 to set
	 */
	public void setAllowedPeriod1(Integer allowedPeriod1) {
		this.allowedPeriod1 = allowedPeriod1;
	}
	/**
	 * @return the allowedPeriod2
	 */
	public Integer getAllowedPeriod2() {
		return allowedPeriod2;
	}
	/**
	 * @param allowedPeriod2 the allowedPeriod2 to set
	 */
	public void setAllowedPeriod2(Integer allowedPeriod2) {
		this.allowedPeriod2 = allowedPeriod2;
	}
	/**
	 * @return the processingUnit
	 */
	public Integer getProcessingUnit() {
		return processingUnit;
	}
	/**
	 * @param processingUnit the processingUnit to set
	 */
	public void setProcessingUnit(Integer processingUnit) {
		this.processingUnit = processingUnit;
	}
	/**
	 * @return the fedSchl
	 */
	public String getFedSchl() {
		return fedSchl;
	}
	/**
	 * @param fedSchl the fedSchl to set
	 */
	public void setFedSchl(String fedSchl) {
		this.fedSchl = fedSchl;
	}
	/**
	 * @return the rptYr
	 */
	public Integer getRptYr() {
		return rptYr;
	}
	/**
	 * @param rptYr the rptYr to set
	 */
	public void setRptYr(Integer rptYr) {
		this.rptYr = rptYr;
	}
	/**
	 * @return the rptQtr
	 */
	public Integer getRptQtr() {
		return rptQtr;
	}
	/**
	 * @param rptQtr the rptQtr to set
	 */
	public void setRptQtr(Integer rptQtr) {
		this.rptQtr = rptQtr;
	}
	/**
	 * @return the reqstDt
	 */
	public Date getReqstDt() {
		return reqstDt;
	}
	/**
	 * @param reqstDt the reqstDt to set
	 */
	public void setReqstDt(Date reqstDt) {
		this.reqstDt = reqstDt;
	}
	/**
	 * @return the startDt
	 */
	public Date getStartDt() {
		return startDt;
	}
	/**
	 * @param startDt the startDt to set
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	/**
	 * @return the endDt
	 */
	public Date getEndDt() {
		return endDt;
	}
	/**
	 * @param endDt the endDt to set
	 */
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	
}
