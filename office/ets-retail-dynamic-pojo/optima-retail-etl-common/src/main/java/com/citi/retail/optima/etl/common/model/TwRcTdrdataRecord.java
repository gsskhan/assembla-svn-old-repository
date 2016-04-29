package com.citi.retail.optima.etl.common.model;

import java.util.Date;

public class TwRcTdrdataRecord extends DataAcqTwRcBaseRecord{
	private Integer update;
	//private String cardnmbr;
	private Date acctOpenDt;
	private Integer tdrflag;
	public Integer getUpdate() {
		return update;
	}
	public void setUpdate(Integer update) {
		this.update = update;
	}
	
	public Date getAcctOpenDt() {
		return acctOpenDt;
	}
	public void setAcctOpenDt(Date acctOpenDt) {
		this.acctOpenDt = acctOpenDt;
	}
	public Integer getTdrflag() {
		return tdrflag;
	}
	public void setTdrflag(Integer tdrflag) {
		this.tdrflag = tdrflag;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwRcTdrdataRecord [update=" + update + ", acctOpenDt="
				+ acctOpenDt + ", tdrflag=" + tdrflag + "]";
	}

}
