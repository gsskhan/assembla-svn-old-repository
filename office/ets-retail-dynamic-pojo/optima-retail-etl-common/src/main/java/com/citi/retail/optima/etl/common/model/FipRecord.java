package com.citi.retail.optima.etl.common.model;

public class FipRecord extends DataAcqMtgBaseRecord{

	String keepFlag;
	String stateNow;
	
	public String getKeepFlag() {
		return keepFlag;
	}
	public void setKeepFlag(String keepFlag) {
		this.keepFlag = keepFlag;
	}
	public String getStateNow() {
		return stateNow;
	}
	public void setStateNow(String stateNow) {
		this.stateNow = stateNow;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FipRecord [keepFlag=" + keepFlag + ", stateNow=" + stateNow
				+ "]";
	}
	
	
	
}
