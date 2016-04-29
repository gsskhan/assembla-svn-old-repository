package com.citi.retail.optima.etl.common.model;

public class MemoRecord extends DataAcqMtgBaseRecord{

	Double glgwo;
	Double bankruptcy;
	Double glrec;
	String gcbcPortfolioId;
	Double orgLtv;
	
	/**
	 * @return the glgwo
	 */
	public Double getGlgwo() {
		return glgwo;
	}
	/**
	 * @return the gcbcPortfolioId
	 */
	public String getGcbcPortfolioId() {
		return gcbcPortfolioId;
	}
	/**
	 * @param gcbcPortfolioId the gcbcPortfolioId to set
	 */
	public void setGcbcPortfolioId(String gcbcPortfolioId) {
		this.gcbcPortfolioId = gcbcPortfolioId;
	}
	/**
	 * @param glgwo the glgwo to set
	 */
	public void setGlgwo(Double glgwo) {
		this.glgwo = glgwo;
	}
	/**
	 * @return the bankruptcy
	 */
	public Double getBankruptcy() {
		return bankruptcy;
	}
	/**
	 * @param bankruptcy the bankruptcy to set
	 */
	public void setBankruptcy(Double bankruptcy) {
		this.bankruptcy = bankruptcy;
	}
	/**
	 * @return the glrec
	 */
	public Double getGlrec() {
		return glrec;
	}
	/**
	 * @param glrec the glrec to set
	 */
	public void setGlrec(Double glrec) {
		this.glrec = glrec;
	}
	
	
	
	public Double getOrgLtv() {
		return orgLtv;
	}
	public void setOrgLtv(Double orgLtv) {
		this.orgLtv = orgLtv;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MemoRecord [glgwo=" + glgwo + ", bankruptcy=" + bankruptcy
				+ ", glrec=" + glrec + ", gcbcPortfolioId=" + gcbcPortfolioId + ", orgLtv="+ orgLtv
				+ "]";
	}
	
	
		
}
