/**
 * 
 */
package com.citi.retail.optima.etl.common.test.data;

import java.io.Serializable;
import java.util.List;

/**
 * Mock Account Data.
 * 
 * @author mc56120
 * 
 */
public class OptimaRetailMockAccountData implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer delinquencyBucket;
	private Integer daysPastDue;
	private String ficoBand;
	private int numDefault;
	private double unusedStart;
	private double incBalDflt;
	private List<Long> aggregationTypeIdList;

	/**
	 * @return the delinquencyBucket
	 */
	public Integer getDelinquencyBucket() {
		return delinquencyBucket;
	}

	/**
	 * @param delinquencyBucket
	 *            the delinquencyBucket to set
	 */
	public void setDelinquencyBucket(Integer delinquencyBucket) {
		this.delinquencyBucket = delinquencyBucket;
	}

	/**
	 * @return the daysPastDue
	 */
	public Integer getDaysPastDue() {
		return daysPastDue;
	}

	/**
	 * @param daysPastDue
	 *            the daysPastDue to set
	 */
	public void setDaysPastDue(Integer daysPastDue) {
		this.daysPastDue = daysPastDue;
	}

	/**
	 * @return the ficoBand
	 */
	public String getFicoBand() {
		return ficoBand;
	}

	/**
	 * @param ficoBand
	 *            the ficoBand to set
	 */
	public void setFicoBand(String ficoBand) {
		this.ficoBand = ficoBand;
	}

	/**
	 * @return the numDefault
	 */
	public int getNumDefault() {
		return numDefault;
	}

	/**
	 * @param numDefault
	 *            the numDefault to set
	 */
	public void setNumDefault(int numDefault) {
		this.numDefault = numDefault;
	}

	/**
	 * @return the unusedStart
	 */
	public double getUnusedStart() {
		return unusedStart;
	}

	/**
	 * @param unusedStart
	 *            the unusedStart to set
	 */
	public void setUnusedStart(double unusedStart) {
		this.unusedStart = unusedStart;
	}

	/**
	 * @return the incBalDflt
	 */
	public double getIncBalDflt() {
		return incBalDflt;
	}

	/**
	 * @param incBalDflt
	 *            the incBalDflt to set
	 */
	public void setIncBalDflt(double incBalDflt) {
		this.incBalDflt = incBalDflt;
	}

	/**
	 * @return the aggregationTypeIdList
	 */
	public List<Long> getAggregationTypeIdList() {
		return aggregationTypeIdList;
	}

	/**
	 * @param aggregationTypeIdList
	 *            the aggregationTypeIdList to set
	 */
	public void setAggregationTypeIdList(List<Long> aggregationTypeIdList) {
		this.aggregationTypeIdList = aggregationTypeIdList;
	}

}
