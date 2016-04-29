/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount;



/**
 * @author sv16441
 *
 */
public class FDICFicoEvent extends BaseSubAccount{

	private Integer ficoScore;
	private String modelVersion;
	private String creditBureau;
	private String eventType;
	
	/**
	 * @return the ficoScore
	 */
	public Integer getFicoScore() {
		return ficoScore;
	}
	/**
	 * @param ficoScore the ficoScore to set
	 */
	public void setFicoScore(Integer eFicoScore) {
		this.ficoScore = eFicoScore;
	}
	/**
	 * @return the eModelVersion
	 */
	public String getModelVersion() {
		return modelVersion;
	}
	/**
	 * @param eModelVersion the eModelVersion to set
	 */
	public void setModelVersion(String eModelVersion) {
		this.modelVersion = eModelVersion;
	}
	/**
	 * @return the eCreditBureau
	 */
	public String getCreditBureau() {
		return creditBureau;
	}
	/**
	 * @param eCreditBureau the eCreditBureau to set
	 */
	public void setCreditBureau(String eCreditBureau) {
		this.creditBureau = eCreditBureau;
	}
	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}
