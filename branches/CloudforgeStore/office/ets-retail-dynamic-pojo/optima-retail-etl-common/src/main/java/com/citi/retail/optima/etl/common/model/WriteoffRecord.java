/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

/**
 * @author sr67841
 *
 */
public class WriteoffRecord extends DataAcqCardsBaseRecord{

	private Long chargeOffIndicator;
	private Double principleChargeOff;
	
	private Long woP;
	private Double woInd;
	
	
	
	/**
	 * @return the chargeOffIndicator
	 */
	public Long getChargeOffIndicator() {
		return chargeOffIndicator;
	}
	/**
	 * @param chargeOffIndicator the chargeOffIndicator to set
	 */
	public void setChargeOffIndicator(Long chargeOffIndicator) {
		this.chargeOffIndicator = chargeOffIndicator;
	}
	/**
	 * @return the principleChargeOff
	 */
	public Double getPrincipleChargeOff() {
		return principleChargeOff;
	}
	/**
	 * @param principleChargeOff the principleChargeOff to set
	 */
	public void setPrincipleChargeOff(Double principleChargeOff) {
		this.principleChargeOff = principleChargeOff;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WriteoffRecord [chargeOffIndicator=" + chargeOffIndicator
				+ ", principleChargeOff=" + principleChargeOff + "]";
	}
	public Long getWoP() {
		return woP;
	}
	public void setWoP(Long woP) {
		this.woP = woP;
	}
	public Double getWoInd() {
		return woInd;
	}
	public void setWoInd(Double woInd) {
		this.woInd = woInd;
	}

	
	
}
