/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

/**
 * @author gg48714
 *  
 */
public class FxRateRecord extends DataAcqCardsBaseRecord {

	private String unit;
	private String scenario;
	private Integer year;
	private Integer period;
	private Integer ledgerUnit;
	private String currency;
	private String citiSource;
	private String dataClass;
	private String acct;
	private Double rate;
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public Integer getLedgerUnit() {
		return ledgerUnit;
	}
	public void setLedgerUnit(Integer ledgerUnit) {
		this.ledgerUnit = ledgerUnit;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCitiSource() {
		return citiSource;
	}
	public void setCitiSource(String citiSource) {
		this.citiSource = citiSource;
	}
	public String getDataClass() {
		return dataClass;
	}
	public void setDataClass(String dataClass) {
		this.dataClass = dataClass;
	}
	public String getAcct() {
		return acct;
	}
	public void setAcct(String acct) {
		this.acct = acct;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FxRateRecord [unit=" + unit + ", scenario=" + scenario
				+ ", year=" + year + ", period=" + period + ", ledgerUnit="
				+ ledgerUnit + ", currency=" + currency + ", citiSource="
				+ citiSource + ", dataClass=" + dataClass + ", acct=" + acct
				+ ", rate=" + rate + "]";
	}
	
}
