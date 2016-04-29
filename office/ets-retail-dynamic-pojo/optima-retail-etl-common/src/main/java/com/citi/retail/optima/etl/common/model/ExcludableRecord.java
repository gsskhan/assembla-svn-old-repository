package com.citi.retail.optima.etl.common.model;

public abstract class ExcludableRecord {

	protected boolean eWriteRecordsToRejects;
	
	public boolean geteWriteRecordsToRejects() {
		return eWriteRecordsToRejects;
	}
	
	public void setEWriteRecordsToRejects(boolean eWriteRecordsToRejects) {
		this.eWriteRecordsToRejects = eWriteRecordsToRejects;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExcludableRecord [eWriteRecordsToRejects="
				+ eWriteRecordsToRejects + "]";
	}
	
	
}
