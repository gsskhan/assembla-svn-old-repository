package com.citi.retail.optima.etl.aggregation.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Account object for transactional attributes common across all products.
 * 
 * @author TJ
 * 
 */
public class RetailAccount extends RetailBaseAccount {

	private static final long serialVersionUID = 7394036563323364693L;

	protected Date accountOpenDate;
	protected Date acquisitionDate;
	protected Integer accountDaysPastDue;
	protected Integer ficoScore;
	protected Double accountEnr;
	protected Double netOutstandingFees;
	protected Double currAdvisedUncommitedLimitUSD;
	protected Double currUnadvisedUncommitedLimtUSD;
	protected Double creditLine;
	protected Integer accountStatusChargeOff;
	protected Date writeDownDate;
	protected Double principalContractualChargeOff;
	protected Double principalChargeOffBankruptcy;
	protected Double principalRecovery;
	protected Double recoveryInterestFees;
	protected Double recovery;
	protected Double principalChargeOff;
	protected Boolean isAccountNew;
	protected Double grossOutstandingPrinBal;
	protected Boolean isloanModified;
	// ORA393
	private String loanStatus; 

	protected Double netOutstandingPrinBal;
	protected Date accountFinalChargeOffDate;

	// Additional input attributes for Small business
	protected String eCcarAge;
	protected String eDelinquencyStatus;
	protected String eFicoEquivalent;
	protected Long eNumAccounts;
	protected Double eCommitmentAmt;
	protected Long eNumNewAccounts;
	protected Double eNewCommitmentAmt;
	protected Long eNumAccountChargeOff;
	protected Double eNetChargeOffReconAmt;
	// Additional output attributes for Home loan equity
	// Additional output attributes for Small Business
	protected String collateralizedFlag;
	protected String eCollateralizedFlag;
	protected Double eModificationAmt;

	protected Date acctSoldDate;
	protected Date acctClosedDate;

	protected Map<String, Boolean> includeAccount = new HashMap<String, Boolean>();
	protected Boolean accountBalanceInd;
	protected Integer eMob;
	
	protected Double eCreditLine;
	protected Integer eFicoScore;
	protected String accountLimitCd; 
	protected String eModelVersion;
	protected String eCreditBureau;
	protected Double eEnrAmount;
	protected Double eExcludeAmount;
	protected String eRefinanceDef;
	
	//ORA896
	protected String riskManagementType;
	//ORA705
	protected Double principalWriteDwnLTDImpactAllAmount;
	//ORA709
	protected Double interestWriteDwnLTDImpactAllAmount;
	//ORA713
	protected Double feeWriteDwnLTDImpactAllAmount;
	//ORA895
	protected Double impairCumulativePurchaseAmount;
	//ORA841
	protected Double adjCumulativeFairValueAmount;
	protected Double eCumulativeGrossChargeOffAmt;
	
	protected Double eImpairCumulativePurchaseAmount;
	protected Double eAdjCumulativeFairValueAmount;
	protected Double eAccountEnr;
	
	

	/**
	 * @return the accountOpenDate
	 */
	public Date getAccountOpenDate() {
		return this.accountOpenDate;
	}

	/**
	 * @return the acquisitionDate
	 */
	public Date getAcquisitionDate() {
		return this.acquisitionDate;
	}

	/**
	 * @return the accountDaysPastDue
	 */
	public Integer getAccountDaysPastDue() {
		return this.accountDaysPastDue;
	}

	/**
	 * @return the ficoScore
	 */
	public Integer getFicoScore() {
		return this.ficoScore;
	}

	/**
	 * @return the accountEnr
	 */
	public Double getAccountEnr() {
		return this.accountEnr;
	}

	/**
	 * @return the netOutstandingFees
	 */
	public Double getNetOutstandingFees() {
		return this.netOutstandingFees;
	}

	/**
	 * @return the currAdvisedUncommitedLimitUSD
	 */
	public Double getCurrAdvisedUncommitedLimitUSD() {
		return this.currAdvisedUncommitedLimitUSD;
	}

	/**
	 * @return the currUnadvisedUncommitedLimtUSD
	 */
	public Double getCurrUnadvisedUncommitedLimtUSD() {
		return this.currUnadvisedUncommitedLimtUSD;
	}

	/**
	 * @return the creditLine
	 */
	public Double getCreditLine() {
		return this.creditLine;
	}

	/**
	 * @return the accountStatusChargeOff
	 */
	public Integer getAccountStatusChargeOff() {
		return this.accountStatusChargeOff;
	}

	/**
	 * @return the writeDownDate
	 */
	public Date getWriteDownDate() {
		return this.writeDownDate;
	}

	/**
	 * @return the principalContractualChargeOff
	 */
	public Double getPrincipalContractualChargeOff() {
		return this.principalContractualChargeOff;
	}

	/**
	 * @return the principalChargeOffBankruptcy
	 */
	public Double getPrincipalChargeOffBankruptcy() {
		return this.principalChargeOffBankruptcy;
	}

	/**
	 * @return the principalRecovery
	 */
	public Double getPrincipalRecovery() {
		return this.principalRecovery;
	}

	/**
	 * @return the recoveryInterestFees
	 */
	public Double getRecoveryInterestFees() {
		return this.recoveryInterestFees;
	}

	/**
	 * @return the recovery
	 */
	public Double getRecovery() {
		return this.recovery;
	}

	/**
	 * @return the principalChargeOff
	 */
	public Double getPrincipalChargeOff() {
		return this.principalChargeOff;
	}

	/**
	 * @return the isAccountNew
	 */
	public Boolean getIsAccountNew() {
		return this.isAccountNew;
	}

	/**
	 * @return the grossOutstandingPrinBal
	 */
	public Double getGrossOutstandingPrinBal() {
		return this.grossOutstandingPrinBal;
	}

	/**
	 * @return the isloanModified
	 */
	public Boolean getIsloanModified() {
		return this.isloanModified;
	}

	/**
	 * @return the netOutstandingPrinBal
	 */
	public Double getNetOutstandingPrinBal() {
		return this.netOutstandingPrinBal;
	}

	/**
	 * @return the eCcarAge
	 */
	public String geteCcarAge() {
		return this.eCcarAge;
	}

	/**
	 * @return the eDelinquencyStatus
	 */
	public String geteDelinquencyStatus() {
		return this.eDelinquencyStatus;
	}

	/**
	 * @return the eFicoEquivalent
	 */
	public String geteFicoEquivalent() {
		return this.eFicoEquivalent;
	}

	/**
	 * @return the eNumAccounts
	 */
	public Long geteNumAccounts() {
		return this.eNumAccounts;
	}


	/**
	 * @return the eCommitmentAmt
	 */
	public Double geteCommitmentAmt() {
		return this.eCommitmentAmt;
	}

	/**
	 * @return the eNumNewAccounts
	 */
	public Long geteNumNewAccounts() {
		return this.eNumNewAccounts;
	}

	/**
	 * @return the eNewCommitmentAmt
	 */
	public Double geteNewCommitmentAmt() {
		return this.eNewCommitmentAmt;
	}

	/**
	 * @return the eNumAccountChargeOff
	 */
	public Long geteNumAccountChargeOff() {
		return this.eNumAccountChargeOff;
	}


	/**
	 * @return the eNetChargeOffReconAmt
	 */
	public Double geteNetChargeOffReconAmt() {
		return this.eNetChargeOffReconAmt;
	}

	/**
	 * @return the eRiskType
	 */
	public String geteCollateralizedFlag() {
		return this.eCollateralizedFlag;
	}

	/**
	 * @return the eModificationAmt
	 */
	public Double geteModificationAmt() {
		return this.eModificationAmt;
	}

	/**
	 * @return the acctSoldDate
	 */
	public Date getAcctSoldDate() {
		return this.acctSoldDate;
	}

	/**
	 * @return the acctClosedDate
	 */
	public Date getAcctClosedDate() {
		return this.acctClosedDate;
	}

	/**
	 * @return the includeAccount
	 */
	public Map<String, Boolean> getIncludeAccount() {
		return this.includeAccount;
	}

	/**
	 * @return the accountBalanceInd
	 */
	public Boolean getAccountBalanceInd() {
		return this.accountBalanceInd;
	}

	/**
	 * @param accountOpenDate
	 *            the accountOpenDate to set
	 */
	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	/**
	 * @param acquisitionDate
	 *            the acquisitionDate to set
	 */
	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	/**
	 * @param accountDaysPastDue
	 *            the accountDaysPastDue to set
	 */
	public void setAccountDaysPastDue(Integer accountDaysPastDue) {
		this.accountDaysPastDue = accountDaysPastDue;
	}

	/**
	 * @param ficoScore
	 *            the ficoScore to set
	 */
	public void setFicoScore(Integer ficoScore) {
		this.ficoScore = ficoScore;
	}

	/**
	 * @param accountEnr
	 *            the accountEnr to set
	 */
	public void setAccountEnr(Double accountEnr) {
		this.accountEnr = accountEnr;
	}


	/**
	 * @param netOutstandingFees
	 *            the netOutstandingFees to set
	 */
	public void setNetOutstandingFees(Double netOutstandingFees) {
		this.netOutstandingFees = netOutstandingFees;
	}

	/**
	 * @param currAdvisedUncommitedLimitUSD
	 *            the currAdvisedUncommitedLimitUSD to set
	 */
	public void setCurrAdvisedUncommitedLimitUSD(
			Double currAdvisedUncommitedLimitUSD) {
		this.currAdvisedUncommitedLimitUSD = currAdvisedUncommitedLimitUSD;
	}

	/**
	 * @param currUnadvisedUncommitedLimtUSD
	 *            the currUnadvisedUncommitedLimtUSD to set
	 */
	public void setCurrUnadvisedUncommitedLimtUSD(
			Double currUnadvisedUncommitedLimtUSD) {
		this.currUnadvisedUncommitedLimtUSD = currUnadvisedUncommitedLimtUSD;
	}

	/**
	 * @param creditLine
	 *            the creditLine to set
	 */
	public void setCreditLine(Double creditLine) {
		this.creditLine = creditLine;
	}

	/**
	 * @param accountStatusChargeOff
	 *            the accountStatusChargeOff to set
	 */
	public void setAccountStatusChargeOff(Integer accountStatusChargeOff) {
		this.accountStatusChargeOff = accountStatusChargeOff;
	}

	/**
	 * @param writeDownDate
	 *            the writeDownDate to set
	 */
	public void setWriteDownDate(Date writeDownDate) {
		this.writeDownDate = writeDownDate;
	}

	/**
	 * @param principalContractualChargeOff
	 *            the principalContractualChargeOff to set
	 */
	public void setPrincipalContractualChargeOff(
			Double principalContractualChargeOff) {
		this.principalContractualChargeOff = principalContractualChargeOff;
	}

	/**
	 * @param principalChargeOffBankruptcy
	 *            the principalChargeOffBankruptcy to set
	 */
	public void setPrincipalChargeOffBankruptcy(
			Double principalChargeOffBankruptcy) {
		this.principalChargeOffBankruptcy = principalChargeOffBankruptcy;
	}

	/**
	 * @param principalRecovery
	 *            the principalRecovery to set
	 */
	public void setPrincipalRecovery(Double principalRecovery) {
		this.principalRecovery = principalRecovery;
	}

	/**
	 * @param recoveryInterestFees
	 *            the recoveryInterestFees to set
	 */
	public void setRecoveryInterestFees(Double recoveryInterestFees) {
		this.recoveryInterestFees = recoveryInterestFees;
	}

	/**
	 * @param recovery
	 *            the recovery to set
	 */
	public void setRecovery(Double recovery) {
		this.recovery = recovery;
	}

	/**
	 * @param principalChargeOff
	 *            the principalChargeOff to set
	 */
	public void setPrincipalChargeOff(Double principalChargeOff) {
		this.principalChargeOff = principalChargeOff;
	}

	/**
	 * @param isAccountNew
	 *            the isAccountNew to set
	 */
	public void setIsAccountNew(Boolean isAccountNew) {
		this.isAccountNew = isAccountNew;
	}

	/**
	 * @param grossOutstandingPrinBal
	 *            the grossOutstandingPrinBal to set
	 */
	public void setGrossOutstandingPrinBal(Double grossOutstandingPrinBal) {
		this.grossOutstandingPrinBal = grossOutstandingPrinBal;
	}


	/**
	 * @param isloanModified
	 *            the isloanModified to set
	 */
	public void setIsloanModified(Boolean isloanModified) {
		this.isloanModified = isloanModified;
	}

	/**
	 * @param netOutstandingPrinBal
	 *            the netOutstandingPrinBal to set
	 */
	public void setNetOutstandingPrinBal(Double netOutstandingPrinBal) {
		this.netOutstandingPrinBal = netOutstandingPrinBal;
	}

	/**
	 * @param eCcarAge
	 *            the eCcarAge to set
	 */
	public void setECcarAge(String eCcarAge) {
		this.eCcarAge = eCcarAge;
	}

	/**
	 * @param eDelinquencyStatus
	 *            the eDelinquencyStatus to set
	 */
	public void setEDelinquencyStatus(String eDelinquencyStatus) {
		this.eDelinquencyStatus = eDelinquencyStatus;
	}

	/**
	 * @param eFicoEquivalent
	 *            the eFicoEquivalent to set
	 */
	public void setEFicoEquivalent(String eFicoEquivalent) {
		this.eFicoEquivalent = eFicoEquivalent;
	}

	/**
	 * @param eNumAccounts
	 *            the eNumAccounts to set
	 */
	public void setENumAccounts(Long eNumAccounts) {
		this.eNumAccounts = eNumAccounts;
	}



	/**
	 * @param eCommitmentAmt
	 *            the eCommitmentAmt to set
	 */
	public void setECommitmentAmt(Double eCommitmentAmt) {
		this.eCommitmentAmt = eCommitmentAmt;
	}

	/**
	 * @param eNumNewAccounts
	 *            the eNumNewAccounts to set
	 */
	public void setENumNewAccounts(Long eNumNewAccounts) {
		this.eNumNewAccounts = eNumNewAccounts;
	}

	/**
	 * @param eNewCommitmentAmt
	 *            the eNewCommitmentAmt to set
	 */
	public void setENewCommitmentAmt(Double eNewCommitmentAmt) {
		this.eNewCommitmentAmt = eNewCommitmentAmt;
	}


	/**
	 * @param eNumAccountChargeOff
	 *            the eNumAccountChargeOff to set
	 */
	public void setENumAccountChargeOff(Long eNumAccountChargeOff) {
		this.eNumAccountChargeOff = eNumAccountChargeOff;
	}

	/**
	 * @param eNetChargeOffReconAmt
	 *            the eNetChargeOffReconAmt to set
	 */
	public void setENetChargeOffReconAmt(Double eNetChargeOffReconAmt) {
		this.eNetChargeOffReconAmt = eNetChargeOffReconAmt;
	}

	/**
	 * @param eRiskType
	 *            the eRiskType to set
	 */
	public void setECollateralizedFlag(String eCollateralizedFlag) {
		this.eCollateralizedFlag = eCollateralizedFlag;
	}

	/**
	 * @param eModificationAmt
	 *            the eModificationAmt to set
	 */
	public void setEModificationAmt(Double eModificationAmt) {
		this.eModificationAmt = eModificationAmt;
	}

	/**
	 * @param acctSoldDate
	 *            the acctSoldDate to set
	 */
	public void setAcctSoldDate(Date acctSoldDate) {
		this.acctSoldDate = acctSoldDate;
	}

	/**
	 * @param acctClosedDate
	 *            the acctClosedDate to set
	 */
	public void setAcctClosedDate(Date acctClosedDate) {
		this.acctClosedDate = acctClosedDate;
	}

	/**
	 * @param includeAccount
	 *            the includeAccount to set
	 */
	public void setIncludeAccount(Map<String, Boolean> includeAccount) {
		this.includeAccount = includeAccount;
	}

	/**
	 * @param accountBalanceInd
	 *            the accountBalanceInd to set
	 */
	public void setAccountBalanceInd(Boolean accountBalanceInd) {
		this.accountBalanceInd = accountBalanceInd;
	}

	public String getCollateralizedFlag() {
		return collateralizedFlag;
	}

	public void setCollateralizedFlag(String collateralizedFlag) {
		this.collateralizedFlag = collateralizedFlag;
	}

	public Integer geteMob() {
		return eMob;
	}

	public void setEMob(Integer eMob) {
		this.eMob = eMob;
	}

	public Date getAccountFinalChargeOffDate() {
		return accountFinalChargeOffDate;
	}

	public void setAccountFinalChargeOffDate(Date accountFinalChargeOffDate) {
		this.accountFinalChargeOffDate = accountFinalChargeOffDate;
	}

	/**
	 * @return the eCreditLine
	 */
	public Double geteCreditLine() {
		return eCreditLine;
	}

	/**
	 * @param eCreditLine the eCreditLine to set
	 */
	public void setECreditLine(Double eCreditLine) {
		this.eCreditLine = eCreditLine;
	}

	/**
	 * @return the eFicoScore
	 */
	public Integer geteFicoScore() {
		return eFicoScore;
	}

	/**
	 * @param eFicoScore the eFicoScore to set
	 */
	public void setEFicoScore(Integer eFicoScore) {
		this.eFicoScore = eFicoScore;
	}

	/**
	 * @return the accountLimitCd
	 */
	public String getAccountLimitCd() {
		return accountLimitCd;
	}

	/**
	 * @param accountLimitCd the accountLimitCd to set
	 */
	public void setAccountLimitCd(String accountLimitCd) {
		this.accountLimitCd = accountLimitCd;
	}

	/**
	 * @return the eModelVersion
	 */
	public String geteModelVersion() {
		return eModelVersion;
	}

	/**
	 * @param eModelVersion the eModelVersion to set
	 */
	public void setEModelVersion(String eModelVersion) {
		this.eModelVersion = eModelVersion;
	}

	/**
	 * @return the eCreditBureau
	 */
	public String geteCreditBureau() {
		return eCreditBureau;
	}

	/**
	 * @param eCreditBureau the eCreditBureau to set
	 */
	public void setECreditBureau(String eCreditBureau) {
		this.eCreditBureau = eCreditBureau;
	}

	/**
	 * @return the eEnrAmount
	 */
	public Double geteEnrAmount() {
		return eEnrAmount;
	}

	/**
	 * @param eEnrAmount the eEnrAmount to set
	 */
	public void setEEnrAmount(Double eEnrAmount) {
		this.eEnrAmount = eEnrAmount;
	}

	/**
	 * @return the eExcludeAmount
	 */
	public Double geteExcludeAmount() {
		return eExcludeAmount;
	}

	/**
	 * @param eExcludeAmount the eExcludeAmount to set
	 */
	public void setEExcludeAmount(Double eExcludeAmount) {
		this.eExcludeAmount = eExcludeAmount;
	}

	/**
	 * @return the eRefinanceDef
	 */
	public String geteRefinanceDef() {
		return eRefinanceDef;
	}

	/**
	 * @param eRefinanceDef the eRefinanceDef to set
	 */
	public void setERefinanceDef(String eRefinanceDef) {
		this.eRefinanceDef = eRefinanceDef;
	}

	public String getRiskManagementType() {
		return riskManagementType;
	}

	public void setRiskManagementType(String riskManagementType) {
		this.riskManagementType = riskManagementType;
	}

	public Double getPrincipalWriteDwnLTDImpactAllAmount() {
		return principalWriteDwnLTDImpactAllAmount;
	}

	public void setPrincipalWriteDwnLTDImpactAllAmount(
			Double principalWriteDwnLTDImpactAllAmount) {
		this.principalWriteDwnLTDImpactAllAmount = principalWriteDwnLTDImpactAllAmount;
	}

	public Double getInterestWriteDwnLTDImpactAllAmount() {
		return interestWriteDwnLTDImpactAllAmount;
	}

	public void setInterestWriteDwnLTDImpactAllAmount(
			Double interestWriteDwnLTDImpactAllAmount) {
		this.interestWriteDwnLTDImpactAllAmount = interestWriteDwnLTDImpactAllAmount;
	}

	public Double getFeeWriteDwnLTDImpactAllAmount() {
		return feeWriteDwnLTDImpactAllAmount;
	}

	public void setFeeWriteDwnLTDImpactAllAmount(
			Double feeWriteDwnLTDImpactAllAmount) {
		this.feeWriteDwnLTDImpactAllAmount = feeWriteDwnLTDImpactAllAmount;
	}

	public Double getImpairCumulativePurchaseAmount() {
		return impairCumulativePurchaseAmount;
	}

	public void setImpairCumulativePurchaseAmount(
			Double impairCumulativePurchaseAmount) {
		this.impairCumulativePurchaseAmount = impairCumulativePurchaseAmount;
	}

	public Double getAdjCumulativeFairValueAmount() {
		return adjCumulativeFairValueAmount;
	}

	public void setAdjCumulativeFairValueAmount(Double adjCumulativeFairValueAmount) {
		this.adjCumulativeFairValueAmount = adjCumulativeFairValueAmount;
	}

	public Double geteCumulativeGrossChargeOffAmt() {
		return eCumulativeGrossChargeOffAmt;
	}

	public void setECumulativeGrossChargeOffAmt(Double eCumulativeGrossChargeOffAmt) {
		this.eCumulativeGrossChargeOffAmt = eCumulativeGrossChargeOffAmt;
	}

	/**
	 * @return the eImpairCumulativePurchaseAmount
	 */
	public Double geteImpairCumulativePurchaseAmount() {
		return eImpairCumulativePurchaseAmount;
	}

	/**
	 * @param eImpairCumulativePurchaseAmount the eImpairCumulativePurchaseAmount to set
	 */
	public void setEImpairCumulativePurchaseAmount(
			Double eImpairCumulativePurchaseAmount) {
		this.eImpairCumulativePurchaseAmount = eImpairCumulativePurchaseAmount;
	}

	/**
	 * @return the eAdjCumulativeFairValueAmount
	 */
	public Double geteAdjCumulativeFairValueAmount() {
		return eAdjCumulativeFairValueAmount;
	}

	/**
	 * @param eAdjCumulativeFairValueAmount the eAdjCumulativeFairValueAmount to set
	 */
	public void setEAdjCumulativeFairValueAmount(
			Double eAdjCumulativeFairValueAmount) {
		this.eAdjCumulativeFairValueAmount = eAdjCumulativeFairValueAmount;
	}

	/**
	 * @return the eAccountEnr
	 */
	public Double geteAccountEnr() {
		return eAccountEnr;
	}

	/**
	 * @param eAccountEnr the eAccountEnr to set
	 */
	public void setEAccountEnr(Double eAccountEnr) {
		this.eAccountEnr = eAccountEnr;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

}