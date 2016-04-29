package com.citi.retail.optima.etl.common.model;

public class CbFinanceRecord {

	private String country;
	private String portfolioId;
	private String portfolioIdDesc;
	private String prvlLvid;
	private String manSegId;
	private String goc;
	private String frsBu;
	private String frsOu;
	
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPortfolioIdDesc() {
		return portfolioIdDesc;
	}
	public void setPortfolioIdDesc(String portfolioIdDesc) {
		this.portfolioIdDesc = portfolioIdDesc;
	}
	public String getPrvlLvid() {
		return prvlLvid;
	}
	public void setPrvlLvid(String prvlLvid) {
		this.prvlLvid = prvlLvid;
	}
	public String getManSegId() {
		return manSegId;
	}
	public void setManSegId(String manSegId) {
		this.manSegId = manSegId;
	}
	public String getFrsOu() {
		return frsOu;
	}
	public void setFrsOu(String frsOu) {
		this.frsOu = frsOu;
	}
	public String getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getGoc() {
		return goc;
	}
	public void setGoc(String goc) {
		this.goc = goc;
	}
	public String getFrsBu() {
		return frsBu;
	}
	public void setFrsBu(String frsBu) {
		this.frsBu = frsBu;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FxRateRecord [portfolioId=" +portfolioId +", goc=" + goc +", frsBu=" + frsBu +", country="+ country + ", prlvlvid=" + prvlLvid + ", mansegid=" + manSegId +", portfoliodesc=" + portfolioIdDesc +", frsOu=" +frsOu +"]";
	}
	
}
