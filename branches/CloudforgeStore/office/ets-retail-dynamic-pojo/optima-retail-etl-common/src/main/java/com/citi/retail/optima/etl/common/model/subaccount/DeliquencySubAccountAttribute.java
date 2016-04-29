/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount;

import java.util.Date;

/**
 * @author TJ
 * 
 */
public class DeliquencySubAccountAttribute extends BaseSubAccount {

	// ORA625
	private Date deliquencyStartDt;
	// ORA626
	private Date deliquencyEndDt; 
	// ORA627
	private Integer deliquencyDuration;  

	private Integer eDaysPastDue;

	private String eDelinquentStatus;

	public Date getDeliquencyStartDt() {
		return this.deliquencyStartDt;
	}

	public void setDeliquencyStartDt(Date deliquencyStartDt) {
		this.deliquencyStartDt = deliquencyStartDt;
	}

	public Date getDeliquencyEndDt() {
		return this.deliquencyEndDt;
	}

	public void setDeliquencyEndDt(Date deliquencyEndDt) {
		this.deliquencyEndDt = deliquencyEndDt;
	}

	public Integer getDeliquencyDuration() {
		return this.deliquencyDuration;
	}

	public void setDeliquencyDuration(Integer deliquencyDuration) {
		this.deliquencyDuration = deliquencyDuration;
	}

	public Integer getEDaysPastDue() {
		return this.eDaysPastDue;
	}

	public void setEDaysPastDue(Integer daysPastDue) {
		this.eDaysPastDue = daysPastDue;
	}

	public String getEDelinquentStatus() {
		return this.eDelinquentStatus;
	}

	public void setEDelinquentStatus(String delinquentStatus) {
		this.eDelinquentStatus = delinquentStatus;
	}
}
