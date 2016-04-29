package com.citi.retail.optima.etl.common.model;

import java.sql.Date;

public class GcbcPortfolioDefinition  implements Cloneable {
	
	private Long batchId;
	private String portfolioId;
	private Long rptPeriod;
	private Date effDt;
	private String effStatus;
	private String portfolioDesc;
	private Long regId;
	private String regCd;
	private String countryCd;	
	private Long srcSycId;
	private String approvalFlg;
	private String baselId;
	private String emrPrdId;
	private String bslReporting;
	private String version;
	private String stdRewriteId;
	private String businessId4;
	private String businessId5;
	private String businessId6;
	private String productId4;
	private String productId5;
	private String productId6;
	private Long businessUnit;
	private String sourceCurr;
	private Long processUnitId;
	private String productCd;
	private String dissAllowflg;
	private String numAcctsdefn;	
	private String bkdissAllowflg;
	private String secflg;
	private String createdBy;
	private Date createdDt;
	private String lastUpdatedBy;
	private Date lastUpdatedDt;
	
	public Long getBatchId() {
		return batchId;
	}
	
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	public String getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public Long getRptPeriod() {
		return rptPeriod;
	}
	public void setRptPeriod(Long rptPeriod) {
		this.rptPeriod = rptPeriod;
	}
	public Date getEffDt() {
		return effDt;
	}
	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	public String getEffStatus() {
		return effStatus;
	}
	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;
	}
	public String getPortfolioDesc() {
		return portfolioDesc;
	}
	public void setPortfolioDesc(String portfolioDesc) {
		this.portfolioDesc = portfolioDesc;
	}
	public Long getRegId() {
		return regId;
	}
	public void setRegId(Long regId) {
		this.regId = regId;
	}
	public String getCountryCd() {
		return countryCd;
	}
	public String getRegCd() {
		return regCd;
	}

	public void setRegCd(String regCd) {
		this.regCd = regCd;
	}
	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}
	public Long getSrcSycId() {
		return srcSycId;
	}
	public void setSrcSycId(Long srcSycId) {
		this.srcSycId = srcSycId;
	}
	public String getApprovalFlg() {
		return approvalFlg;
	}
	public void setApprovalFlg(String approvalFlg) {
		this.approvalFlg = approvalFlg;
	}
	public String getBaselId() {
		return baselId;
	}
	public void setBaselId(String baselId) {
		this.baselId = baselId;
	}
	public String getEmrPrdId() {
		return emrPrdId;
	}
	public void setEmrPrdId(String emrPrdId) {
		this.emrPrdId = emrPrdId;
	}
	public String getBslReporting() {
		return bslReporting;
	}
	public void setBslReporting(String bslReporting) {
		this.bslReporting = bslReporting;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStdRewriteId() {
		return stdRewriteId;
	}
	public void setStdRewriteId(String stdRewriteId) {
		this.stdRewriteId = stdRewriteId;
	}
	public String getBusinessId4() {
		return businessId4;
	}
	public void setBusinessId4(String businessId4) {
		this.businessId4 = businessId4;
	}
	public String getBusinessId5() {
		return businessId5;
	}
	public void setBusinessId5(String businessId5) {
		this.businessId5 = businessId5;
	}
	public String getBusinessId6() {
		return businessId6;
	}
	public void setBusinessId6(String businessId6) {
		this.businessId6 = businessId6;
	}
	public String getProductId4() {
		return productId4;
	}
	public void setProductId4(String productId4) {
		this.productId4 = productId4;
	}
	public String getProductId5() {
		return productId5;
	}
	public void setProductId5(String productId5) {
		this.productId5 = productId5;
	}
	public String getProductId6() {
		return productId6;
	}
	public void setProductId6(String productId6) {
		this.productId6 = productId6;
	}
	public Long getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(Long businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getSourceCurr() {
		return sourceCurr;
	}
	public void setSourceCurr(String sourceCurr) {
		this.sourceCurr = sourceCurr;
	}
	public Long getProcessUnitId() {
		return processUnitId;
	}
	public void setProcessUnitId(Long processUnitId) {
		this.processUnitId = processUnitId;
	}

	public String getDissAllowflg() {
		return dissAllowflg;
	}
	public void setDissAllowflg(String dissAllowflg) {
		this.dissAllowflg = dissAllowflg;
	}
	public String getNumAcctsdefn() {
		return numAcctsdefn;
	}
	public void setNumAcctsdefn(String numAcctsdefn) {
		this.numAcctsdefn = numAcctsdefn;
	}
	public String getBkdissAllowflg() {
		return bkdissAllowflg;
	}
	public void setBkdissAllowflg(String bkdissAllowflg) {
		this.bkdissAllowflg = bkdissAllowflg;
	}
	public String getSecflg() {
		return secflg;
	}
	public void setSecflg(String secflg) {
		this.secflg = secflg;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}
	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	}
