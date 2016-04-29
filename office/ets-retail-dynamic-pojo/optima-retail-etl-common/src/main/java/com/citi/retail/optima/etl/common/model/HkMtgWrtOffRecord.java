package com.citi.retail.optima.etl.common.model;

import java.util.Date;

public class HkMtgWrtOffRecord extends HkMtgWriteOffTRLRecord {
	private Date woDate;
	private String acctnumb;
	private String woInd;
	private Double gwo;
	private String woType;
	private String checkDigitHkMtg;
	public Date getWoDate() {
		return woDate;
	}
	public void setWoDate(Date woDate) {
		this.woDate = woDate;
	}
	public String getAcctnumb() {
		return acctnumb;
	}
	public void setAcctnumb(String acctnumb) {
		this.acctnumb = acctnumb;
	}
	public String getWoInd() {
		return woInd;
	}
	public void setWoInd(String woInd) {
		this.woInd = woInd;
	}
	public Double getGwo() {
		return gwo;
	}
	public void setGwo(Double gwo) {
		this.gwo = gwo;
	}
	public String getWoType() {
		return woType;
	}
	public void setWoType(String woType) {
		this.woType = woType;
	}
	public String getCheckDigitHkMtg() {
		return checkDigitHkMtg;
	}
	public void setCheckDigitHkMtg(String checkDigitHkMtg) {
		this.checkDigitHkMtg = checkDigitHkMtg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HkMtgWrtOffRecord [woDate=" + woDate + ", acctnumb=" + acctnumb
				+ ", woInd=" + woInd + ", gwo=" + gwo + ", woType=" + woType
				+ "]";
	}
	
}
