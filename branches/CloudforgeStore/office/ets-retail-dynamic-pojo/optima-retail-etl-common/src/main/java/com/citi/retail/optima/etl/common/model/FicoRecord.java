/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

/**
 * @author sv16441
 * 
 */
public class FicoRecord extends DataAcqCardsBaseRecord {

	Integer alignScore;

	/**
	 * @return the alignScore
	 */
	public Integer getAlignScore() {
		return alignScore;
	}

	/**
	 * @param alignScore the alignScore to set
	 */
	public void setAlignScore(Integer alignScore) {
		this.alignScore = alignScore;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FicoRecord [alignScore=" + alignScore + "]";
	}
	
	
}
