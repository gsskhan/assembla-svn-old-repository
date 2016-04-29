/**
 * 
 */
package com.citi.retail.optima.etl.validation.model;


/**
 * @author sr67841
 * 
 */
public class UserSubmissionCCARRecord extends UserSubmissionBaseRecord {

	private Integer collateralizedFlag;
	private String gcbcPortfolioId;
	private Integer currLineLoanSize;
	private Integer originalLtv;
	private Integer age;
	private Integer delqStatus;
	private Integer origFico;
	private Integer vintage;
	private Integer numAccounts;
	private Double unpaidPrinBalAmt;
	private Double outstandingDpdOver30Amt;
	private Integer numAcctDpdOver30;
	private Double accountEver30DpdLast12Amt;
	private Double accountEver60DpdLast12Amt;
	private Integer numNewAccounts;
	private Double newAccountAmt;
	private Double commitmentAmt;
	private Double newCommitmentAmt;
	private Double commitmentIncrAmt;
	private Double commitmentDecrAmt;
	private Double modificationAmt;
	private Double grossContractualChargeOffAmt;
	private Double bankruptcyChargeOffAmt;
	private Double recovery;
	private Double numAcctChargeOff;
	private Double netChargeOffAmt;
	private Double adjNetChargeOffAmt;
	private Double foreclosureAmt;
	private Double newForeclosureAmt;
	private Double reoAmt;
	private Double newReoAmt;
	private Double vehicleTypeCarVanAmt;
	private Double vehicleTypeSuvTruckAmt;
	private Double vehicleTypeSportAmt;
	private Double vehicleTypeUnknown;
	private Double repo;
	private Double currentMonthRepo;
	private Double projectedValueLease;
	private Double ActSaleProceedsLease;
	private String refPortfolioCcy;
	private Double fxRate;
	private Integer rptBasis;
	private String submitterId;
	private String contactId;
	private Double dataVersion;

	private String eFedPortfolio;
	private String eBusinessUnit;
	private String eFedRegionSegmentId;
	private String eFedProductTypeSegmentId;
	private String eFedOrigLtvSegmentId;
	private String eFedAgeSegmentId;
	private String eFedDelqSegmentId;
	private String eFedFicoSegmentId;
	private String eFedCollateralizedSegmentId;
	private Double eFedOutstandingDpdOver30Amt;
	private Integer eFedNumAcctDpdOver30;
	private Double eFedAccountEver30DpdLast12Amt;
	private Double eFedAccountEver60DpdLast12Amt;
	private Integer eFedNumNewAccounts;
	private Double eFedNewAccountAmt;
	private Double eFedCommitmentAmt;
	private Double eFedNewCommitmentAmt;
	private Double eFedCommitmentIncrAmt;
	private Double eFedCommitmentDecAmt;
	private Double eFedModificationAmt;
	private Double eFedGrossContractualChargeOffAmt;
	private Double eFedBankruptcyChargeOffAmt;
	private Double eFedRecoveryAmt;
	private Integer eFedNumAcctChargeOf;
	private Double eFedNetChargeOffAmt;
	private Double eFedAdjNetChargeOffAmt;
	private Double eFedForeclosureAmt;
	private Double eFedNewForeclosureAmt;
	private Double eFedReoAmt;
	private Double eFedNewReoAmt;
	private Double eFedVhclTypeCarVanAmt;
	private Double eFedVhclTypeSuvTruckAmt;
	private Double eFedVhclTypeSportAmt;
	private Double eFedVhclTypeUnknownAmt;
	private Double eFedRepoAmt;
	private Double eFedCurrentMonthRepoAmt;
	private Double eFedProjValueLeaseAmt;
	private Double eFedActSaleProceedsLeaseAmt;
	private Integer eFedNumAccounts;
	private Double eFedUnpaidPrinBalAmt;
	private Double eAdjustmentAmt;
	private Double eCalcNetChargeOffAmt;
	private PortfolioDefinitionVO ePortfolioDefinition;
	private boolean eExcludePortfolio;
	private String eFedCurrLineLoanSize;
	private String eFedVintage;
	private Double eFedFxRate;

	private String eFedRefPortfolioCcy;
	private Integer eFedRefRptBasis;

	private Double ePearlDlqSeg;
	private Double eGcl;

	/**
	 * @return the collateralizedFlag
	 */
	public Integer getCollateralizedFlag() {
		return collateralizedFlag;
	}

	/**
	 * @param collateralizedFlag
	 *            the collateralizedFlag to set
	 */
	public void setCollateralizedFlag(Integer collateralizedFlag) {
		this.collateralizedFlag = collateralizedFlag;
	}

	/**
	 * @return the gcbcPortfolioId
	 */
	public String getGcbcPortfolioId() {
		return gcbcPortfolioId;
	}

	/**
	 * @param gcbcPortfolioId
	 *            the gcbcPortfolioId to set
	 */
	public void setGcbcPortfolioId(String gcbcPortfolioId) {
		this.gcbcPortfolioId = gcbcPortfolioId;
	}

	/**
	 * @return the currLineLoanSize
	 */
	public Integer getCurrLineLoanSize() {
		return currLineLoanSize;
	}

	/**
	 * @param currLineLoanSize
	 *            the currLineLoanSize to set
	 */
	public void setCurrLineLoanSize(Integer currLineLoanSize) {
		this.currLineLoanSize = currLineLoanSize;
	}

	/**
	 * @return the originalLtv
	 */
	public Integer getOriginalLtv() {
		return originalLtv;
	}

	/**
	 * @param originalLtv
	 *            the originalLtv to set
	 */
	public void setOriginalLtv(Integer originalLtv) {
		this.originalLtv = originalLtv;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the delqStatus
	 */
	public Integer getDelqStatus() {
		return delqStatus;
	}

	/**
	 * @param delqStatus
	 *            the delqStatus to set
	 */
	public void setDelqStatus(Integer delqStatus) {
		this.delqStatus = delqStatus;
	}

	/**
	 * @return the origFico
	 */
	public Integer getOrigFico() {
		return origFico;
	}

	/**
	 * @param origFico
	 *            the origFico to set
	 */
	public void setOrigFico(Integer origFico) {
		this.origFico = origFico;
	}

	/**
	 * @return the vintage
	 */
	public Integer getVintage() {
		return vintage;
	}

	/**
	 * @param vintage
	 *            the vintage to set
	 */
	public void setVintage(Integer vintage) {
		this.vintage = vintage;
	}

	/**
	 * @return the numAccounts
	 */
	public Integer getNumAccounts() {
		return numAccounts;
	}

	/**
	 * @param numAccounts
	 *            the numAccounts to set
	 */
	public void setNumAccounts(Integer numAccounts) {
		this.numAccounts = numAccounts;
	}

	/**
	 * @return the unpaidPrinBal
	 */
	public Double getUnpaidPrinBalAmt() {
		return unpaidPrinBalAmt;
	}

	/**
	 * @param unpaidPrinBal
	 *            the unpaidPrinBal to set
	 */
	public void setUnpaidPrinBalAmt(Double unpaidPrinBalAmt) {
		this.unpaidPrinBalAmt = unpaidPrinBalAmt;
	}

	/**
	 * @return the outstandingDpdOver30Amt
	 */
	public Double getOutstandingDpdOver30Amt() {
		return outstandingDpdOver30Amt;
	}

	/**
	 * @param outstandingDpdOver30Amt
	 *            the outstandingDpdOver30Amt to set
	 */
	public void setOutstandingDpdOver30Amt(Double outstandingDpdOver30Amt) {
		this.outstandingDpdOver30Amt = outstandingDpdOver30Amt;
	}

	/**
	 * @return the numAcctDpdOver30
	 */
	public Integer getNumAcctDpdOver30() {
		return numAcctDpdOver30;
	}

	/**
	 * @param numAcctDpdOver30
	 *            the numAcctDpdOver30 to set
	 */
	public void setNumAcctDpdOver30(Integer numAcctDpdOver30) {
		this.numAcctDpdOver30 = numAcctDpdOver30;
	}

	/**
	 * @return the accountEver30DpdLast12Amt
	 */
	public Double getAccountEver30DpdLast12Amt() {
		return accountEver30DpdLast12Amt;
	}

	/**
	 * @param accountEver30DpdLast12Amt
	 *            the accountEver30DpdLast12Amt to set
	 */
	public void setAccountEver30DpdLast12Amt(Double accountEver30DpdLast12Amt) {
		this.accountEver30DpdLast12Amt = accountEver30DpdLast12Amt;
	}

	/**
	 * @return the accountEver60DpdLast12Amt
	 */
	public Double getAccountEver60DpdLast12Amt() {
		return accountEver60DpdLast12Amt;
	}

	/**
	 * @param accountEver60DpdLast12Amt
	 *            the accountEver60DpdLast12Amt to set
	 */
	public void setAccountEver60DpdLast12Amt(Double accountEver60DpdLast12Amt) {
		this.accountEver60DpdLast12Amt = accountEver60DpdLast12Amt;
	}

	/**
	 * @return the numNewAccounts
	 */
	public Integer getNumNewAccounts() {
		return numNewAccounts;
	}

	/**
	 * @param numNewAccounts
	 *            the numNewAccounts to set
	 */
	public void setNumNewAccounts(Integer numNewAccounts) {
		this.numNewAccounts = numNewAccounts;
	}

	/**
	 * @return the newAccountAmt
	 */
	public Double getNewAccountAmt() {
		return newAccountAmt;
	}

	/**
	 * @param newAccountAmt
	 *            the newAccountAmt to set
	 */
	public void setNewAccountAmt(Double newAccountAmt) {
		this.newAccountAmt = newAccountAmt;
	}

	/**
	 * @return the commitmentAmt
	 */
	public Double getCommitmentAmt() {
		return commitmentAmt;
	}

	/**
	 * @param commitmentAmt
	 *            the commitmentAmt to set
	 */
	public void setCommitmentAmt(Double commitmentAmt) {
		this.commitmentAmt = commitmentAmt;
	}

	/**
	 * @return the newCommitmentAmt
	 */
	public Double getNewCommitmentAmt() {
		return newCommitmentAmt;
	}

	/**
	 * @param newCommitmentAmt
	 *            the newCommitmentAmt to set
	 */
	public void setNewCommitmentAmt(Double newCommitmentAmt) {
		this.newCommitmentAmt = newCommitmentAmt;
	}

	/**
	 * @return the commitmentIncrAmt
	 */
	public Double getCommitmentIncrAmt() {
		return commitmentIncrAmt;
	}

	/**
	 * @param commitmentIncrAmt
	 *            the commitmentIncrAmt to set
	 */
	public void setCommitmentIncrAmt(Double commitmentIncrAmt) {
		this.commitmentIncrAmt = commitmentIncrAmt;
	}

	/**
	 * @return the commitmentDecrAmt
	 */
	public Double getCommitmentDecrAmt() {
		return commitmentDecrAmt;
	}

	/**
	 * @param commitmentDecrAmt
	 *            the commitmentDecrAmt to set
	 */
	public void setCommitmentDecrAmt(Double commitmentDecrAmt) {
		this.commitmentDecrAmt = commitmentDecrAmt;
	}

	/**
	 * @return the modificationAmt
	 */
	public Double getModificationAmt() {
		return modificationAmt;
	}

	/**
	 * @param modificationAmt
	 *            the modificationAmt to set
	 */
	public void setModificationAmt(Double modificationAmt) {
		this.modificationAmt = modificationAmt;
	}

	/**
	 * @return the grossContractualChargeOffAmt
	 */
	public Double getGrossContractualChargeOffAmt() {
		return grossContractualChargeOffAmt;
	}

	/**
	 * @param grossContractualChargeOffAmt
	 *            the grossContractualChargeOffAmt to set
	 */
	public void setGrossContractualChargeOffAmt(
			Double grossContractualChargeOffAmt) {
		this.grossContractualChargeOffAmt = grossContractualChargeOffAmt;
	}

	/**
	 * @return the bankruptcyChargeOffAmt
	 */
	public Double getBankruptcyChargeOffAmt() {
		return bankruptcyChargeOffAmt;
	}

	/**
	 * @param bankruptcyChargeOffAmt
	 *            the bankruptcyChargeOffAmt to set
	 */
	public void setBankruptcyChargeOffAmt(Double bankruptcyChargeOffAmt) {
		this.bankruptcyChargeOffAmt = bankruptcyChargeOffAmt;
	}

	/**
	 * @return the recovery
	 */
	public Double getRecovery() {
		return recovery;
	}

	/**
	 * @param recovery
	 *            the recovery to set
	 */
	public void setRecovery(Double recovery) {
		this.recovery = recovery;
	}

	/**
	 * @return the numAcctChargeOff
	 */
	public Double getNumAcctChargeOff() {
		return numAcctChargeOff;
	}

	/**
	 * @param numAcctChargeOff
	 *            the numAcctChargeOff to set
	 */
	public void setNumAcctChargeOff(Double numAcctChargeOff) {
		this.numAcctChargeOff = numAcctChargeOff;
	}

	/**
	 * @return the netChargeOffAmt
	 */
	public Double getNetChargeOffAmt() {
		return netChargeOffAmt;
	}

	/**
	 * @param netChargeOffAmt
	 *            the netChargeOffAmt to set
	 */
	public void setNetChargeOffAmt(Double netChargeOffAmt) {
		this.netChargeOffAmt = netChargeOffAmt;
	}

	/**
	 * @return the adjNetChargeOffAmt
	 */
	public Double getAdjNetChargeOffAmt() {
		return adjNetChargeOffAmt;
	}

	/**
	 * @param adjNetChargeOffAmt
	 *            the adjNetChargeOffAmt to set
	 */
	public void setAdjNetChargeOffAmt(Double adjNetChargeOffAmt) {
		this.adjNetChargeOffAmt = adjNetChargeOffAmt;
	}

	/**
	 * @return the foreclosureAmt
	 */
	public Double getForeclosureAmt() {
		return foreclosureAmt;
	}

	/**
	 * @param foreclosureAmt
	 *            the foreclosureAmt to set
	 */
	public void setForeclosureAmt(Double foreclosureAmt) {
		this.foreclosureAmt = foreclosureAmt;
	}

	/**
	 * @return the newForeclosureAmt
	 */
	public Double getNewForeclosureAmt() {
		return newForeclosureAmt;
	}

	/**
	 * @param newForeclosureAmt
	 *            the newForeclosureAmt to set
	 */
	public void setNewForeclosureAmt(Double newForeclosureAmt) {
		this.newForeclosureAmt = newForeclosureAmt;
	}

	/**
	 * @return the reoAmt
	 */
	public Double getReoAmt() {
		return reoAmt;
	}

	/**
	 * @param reoAmt
	 *            the reoAmt to set
	 */
	public void setReoAmt(Double reoAmt) {
		this.reoAmt = reoAmt;
	}

	/**
	 * @return the newReoAmt
	 */
	public Double getNewReoAmt() {
		return newReoAmt;
	}

	/**
	 * @param newReoAmt
	 *            the newReoAmt to set
	 */
	public void setNewReoAmt(Double newReoAmt) {
		this.newReoAmt = newReoAmt;
	}

	/**
	 * @return the vehicleTypeCarVanAmt
	 */
	public Double getVehicleTypeCarVanAmt() {
		return vehicleTypeCarVanAmt;
	}

	/**
	 * @param vehicleTypeCarVanAmt
	 *            the vehicleTypeCarVanAmt to set
	 */
	public void setVehicleTypeCarVanAmt(Double vehicleTypeCarVanAmt) {
		this.vehicleTypeCarVanAmt = vehicleTypeCarVanAmt;
	}

	/**
	 * @return the vehicleTypeSuvTruckAmt
	 */
	public Double getVehicleTypeSuvTruckAmt() {
		return vehicleTypeSuvTruckAmt;
	}

	/**
	 * @param vehicleTypeSuvTruckAmt
	 *            the vehicleTypeSuvTruckAmt to set
	 */
	public void setVehicleTypeSuvTruckAmt(Double vehicleTypeSuvTruckAmt) {
		this.vehicleTypeSuvTruckAmt = vehicleTypeSuvTruckAmt;
	}

	/**
	 * @return the vehicleTypeSportAmt
	 */
	public Double getVehicleTypeSportAmt() {
		return vehicleTypeSportAmt;
	}

	/**
	 * @param vehicleTypeSportAmt
	 *            the vehicleTypeSportAmt to set
	 */
	public void setVehicleTypeSportAmt(Double vehicleTypeSportAmt) {
		this.vehicleTypeSportAmt = vehicleTypeSportAmt;
	}

	/**
	 * @return the vehicleTypeUnknown
	 */
	public Double getVehicleTypeUnknown() {
		return vehicleTypeUnknown;
	}

	/**
	 * @param vehicleTypeUnknown
	 *            the vehicleTypeUnknown to set
	 */
	public void setVehicleTypeUnknown(Double vehicleTypeUnknown) {
		this.vehicleTypeUnknown = vehicleTypeUnknown;
	}

	/**
	 * @return the repo
	 */
	public Double getRepo() {
		return repo;
	}

	/**
	 * @param repo
	 *            the repo to set
	 */
	public void setRepo(Double repo) {
		this.repo = repo;
	}

	/**
	 * @return the currentMonthRepo
	 */
	public Double getCurrentMonthRepo() {
		return currentMonthRepo;
	}

	/**
	 * @param currentMonthRepo
	 *            the currentMonthRepo to set
	 */
	public void setCurrentMonthRepo(Double currentMonthRepo) {
		this.currentMonthRepo = currentMonthRepo;
	}

	/**
	 * @return the projectedValueLease
	 */
	public Double getProjectedValueLease() {
		return projectedValueLease;
	}

	/**
	 * @param projectedValueLease
	 *            the projectedValueLease to set
	 */
	public void setProjectedValueLease(Double projectedValueLease) {
		this.projectedValueLease = projectedValueLease;
	}

	/**
	 * @return the actSaleProceedsLease
	 */
	public Double getActSaleProceedsLease() {
		return ActSaleProceedsLease;
	}

	/**
	 * @param actSaleProceedsLease
	 *            the actSaleProceedsLease to set
	 */
	public void setActSaleProceedsLease(Double actSaleProceedsLease) {
		ActSaleProceedsLease = actSaleProceedsLease;
	}

	/**
	 * @return the refPortfolioCcy
	 */
	public String getRefPortfolioCcy() {
		return refPortfolioCcy;
	}

	/**
	 * @param refPortfolioCcy
	 *            the refPortfolioCcy to set
	 */
	public void setRefPortfolioCcy(String refPortfolioCcy) {
		this.refPortfolioCcy = refPortfolioCcy;
	}

	/**
	 * @return the fxRate
	 */
	public Double getFxRate() {
		return fxRate;
	}

	/**
	 * @param fxRate
	 *            the fxRate to set
	 */
	public void setFxRate(Double fxRate) {
		this.fxRate = fxRate;
	}

	/**
	 * @return the rptBasis
	 */
	public Integer getRptBasis() {
		return rptBasis;
	}

	/**
	 * @param rptBasis
	 *            the rptBasis to set
	 */
	public void setRptBasis(Integer rptBasis) {
		this.rptBasis = rptBasis;
	}

	/**
	 * @return the submitterId
	 */
	public String getSubmitterId() {
		return submitterId;
	}

	/**
	 * @param submitterId
	 *            the submitterId to set
	 */
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}

	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}

	/**
	 * @param contactId
	 *            the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the dataVersion
	 */
	public Double getDataVersion() {
		return dataVersion;
	}

	/**
	 * @param dataVersion
	 *            the dataVersion to set
	 */
	public void setDataVersion(Double dataVersion) {
		this.dataVersion = dataVersion;
	}

	/**
	 * @return the eFedPortfolio
	 */
	public String geteFedPortfolio() {
		return eFedPortfolio;
	}

	/**
	 * @param eFedPortfolio
	 *            the eFedPortfolio to set
	 */
	public void setEFedPortfolio(String eFedPortfolio) {
		this.eFedPortfolio = eFedPortfolio;
	}

	/**
	 * @return the eBusinessUnit
	 */
	public String geteBusinessUnit() {
		return eBusinessUnit;
	}

	/**
	 * @param eBusinessUnit
	 *            the eBusinessUnit to set
	 */
	public void setEBusinessUnit(String eBusinessUnit) {
		this.eBusinessUnit = eBusinessUnit;
	}

	/**
	 * @return the eFedRegionSegmentId
	 */
	public String geteFedRegionSegmentId() {
		return eFedRegionSegmentId;
	}

	/**
	 * @param eFedRegionSegmentId
	 *            the eFedRegionSegmentId to set
	 */
	public void setEFedRegionSegmentId(String eFedRegionSegmentId) {
		this.eFedRegionSegmentId = eFedRegionSegmentId;
	}

	/**
	 * @return the eFedProductTypeSegmentId
	 */
	public String geteFedProductTypeSegmentId() {
		return eFedProductTypeSegmentId;
	}

	/**
	 * @param eFedProductTypeSegmentId
	 *            the eFedProductTypeSegmentId to set
	 */
	public void setEFedProductTypeSegmentId(String eFedProductTypeSegmentId) {
		this.eFedProductTypeSegmentId = eFedProductTypeSegmentId;
	}

	/**
	 * @return the eFedOrigLtvSegmentId
	 */
	public String geteFedOrigLtvSegmentId() {
		return eFedOrigLtvSegmentId;
	}

	/**
	 * @param eFedOrigLtvSegmentId
	 *            the eFedOrigLtvSegmentId to set
	 */
	public void setEFedOrigLtvSegmentId(String eFedOrigLtvSegmentId) {
		this.eFedOrigLtvSegmentId = eFedOrigLtvSegmentId;
	}

	/**
	 * @return the eFedAgeSegmentId
	 */
	public String geteFedAgeSegmentId() {
		return eFedAgeSegmentId;
	}

	/**
	 * @param eFedAgeSegmentId
	 *            the eFedAgeSegmentId to set
	 */
	public void setEFedAgeSegmentId(String eFedAgeSegmentId) {
		this.eFedAgeSegmentId = eFedAgeSegmentId;
	}

	/**
	 * @return the eFedDelqSegmentId
	 */
	public String geteFedDelqSegmentId() {
		return eFedDelqSegmentId;
	}

	/**
	 * @param eFedDelqSegmentId
	 *            the eFedDelqSegmentId to set
	 */
	public void setEFedDelqSegmentId(String eFedDelqSegmentId) {
		this.eFedDelqSegmentId = eFedDelqSegmentId;
	}

	/**
	 * @return the eFedFicoSegmentId
	 */
	public String geteFedFicoSegmentId() {
		return eFedFicoSegmentId;
	}

	/**
	 * @param eFedFicoSegmentId
	 *            the eFedFicoSegmentId to set
	 */
	public void setEFedFicoSegmentId(String eFedFicoSegmentId) {
		this.eFedFicoSegmentId = eFedFicoSegmentId;
	}

	/**
	 * @return the eFedCollateralizedSegmentId
	 */
	public String geteFedCollateralizedSegmentId() {
		return eFedCollateralizedSegmentId;
	}

	/**
	 * @param eFedCollateralizedSegmentId
	 *            the eFedCollateralizedSegmentId to set
	 */
	public void setEFedCollateralizedSegmentId(
			String eFedCollateralizedSegmentId) {
		this.eFedCollateralizedSegmentId = eFedCollateralizedSegmentId;
	}

	/**
	 * @return the eFedOutstandingDpdOver30Amt
	 */
	public Double geteFedOutstandingDpdOver30Amt() {
		return eFedOutstandingDpdOver30Amt;
	}

	/**
	 * @param eFedOutstandingDpdOver30Amt
	 *            the eFedOutstandingDpdOver30Amt to set
	 */
	public void setEFedOutstandingDpdOver30Amt(
			Double eFedOutstandingDpdOver30Amt) {
		this.eFedOutstandingDpdOver30Amt = eFedOutstandingDpdOver30Amt;
	}

	/**
	 * @return the eFedNumAcctDpdOver30
	 */
	public Integer geteFedNumAcctDpdOver30() {
		return eFedNumAcctDpdOver30;
	}

	/**
	 * @param eFedNumAcctDpdOver30
	 *            the eFedNumAcctDpdOver30 to set
	 */
	public void setEFedNumAcctDpdOver30(Integer eFedNumAcctDpdOver30) {
		this.eFedNumAcctDpdOver30 = eFedNumAcctDpdOver30;
	}

	/**
	 * @return the eFedAccountEver30DpdLast12Amt
	 */
	public Double geteFedAccountEver30DpdLast12Amt() {
		return eFedAccountEver30DpdLast12Amt;
	}

	/**
	 * @param eFedAccountEver30DpdLast12Amt
	 *            the eFedAccountEver30DpdLast12Amt to set
	 */
	public void setEFedAccountEver30DpdLast12Amt(
			Double eFedAccountEver30DpdLast12Amt) {
		this.eFedAccountEver30DpdLast12Amt = eFedAccountEver30DpdLast12Amt;
	}

	/**
	 * @return the eFedAccountEver60DpdLast12Amt
	 */
	public Double geteFedAccountEver60DpdLast12Amt() {
		return eFedAccountEver60DpdLast12Amt;
	}

	/**
	 * @param eFedAccountEver60DpdLast12Amt
	 *            the eFedAccountEver60DpdLast12Amt to set
	 */
	public void setEFedAccountEver60DpdLast12Amt(
			Double eFedAccountEver60DpdLast12Amt) {
		this.eFedAccountEver60DpdLast12Amt = eFedAccountEver60DpdLast12Amt;
	}

	/**
	 * @return the eFedNumNewAccounts
	 */
	public Integer geteFedNumNewAccounts() {
		return eFedNumNewAccounts;
	}

	/**
	 * @param eFedNumNewAccounts
	 *            the eFedNumNewAccounts to set
	 */
	public void setEFedNumNewAccounts(Integer eFedNumNewAccounts) {
		this.eFedNumNewAccounts = eFedNumNewAccounts;
	}

	/**
	 * @return the eFedNewAccountAmt
	 */
	public Double geteFedNewAccountAmt() {
		return eFedNewAccountAmt;
	}

	/**
	 * @param eFedNewAccountAmt
	 *            the eFedNewAccountAmt to set
	 */
	public void setEFedNewAccountAmt(Double eFedNewAccountAmt) {
		this.eFedNewAccountAmt = eFedNewAccountAmt;
	}

	/**
	 * @return the eFedCommitmentAmt
	 */
	public Double geteFedCommitmentAmt() {
		return eFedCommitmentAmt;
	}

	/**
	 * @param eFedCommitmentAmt
	 *            the eFedCommitmentAmt to set
	 */
	public void setEFedCommitmentAmt(Double eFedCommitmentAmt) {
		this.eFedCommitmentAmt = eFedCommitmentAmt;
	}

	/**
	 * @return the eFedNewCommitmentAmt
	 */
	public Double geteFedNewCommitmentAmt() {
		return eFedNewCommitmentAmt;
	}

	/**
	 * @param eFedNewCommitmentAmt
	 *            the eFedNewCommitmentAmt to set
	 */
	public void setEFedNewCommitmentAmt(Double eFedNewCommitmentAmt) {
		this.eFedNewCommitmentAmt = eFedNewCommitmentAmt;
	}

	/**
	 * @return the eFedCommitmentIncrAmt
	 */
	public Double geteFedCommitmentIncrAmt() {
		return eFedCommitmentIncrAmt;
	}

	/**
	 * @param eFedCommitmentIncrAmt
	 *            the eFedCommitmentIncrAmt to set
	 */
	public void setEFedCommitmentIncrAmt(Double eFedCommitmentIncrAmt) {
		this.eFedCommitmentIncrAmt = eFedCommitmentIncrAmt;
	}

	/**
	 * @return the eFedCommitmentDecAmt
	 */
	public Double geteFedCommitmentDecAmt() {
		return eFedCommitmentDecAmt;
	}

	/**
	 * @param eFedCommitmentDecAmt
	 *            the eFedCommitmentDecAmt to set
	 */
	public void setEFedCommitmentDecAmt(Double eFedCommitmentDecAmt) {
		this.eFedCommitmentDecAmt = eFedCommitmentDecAmt;
	}

	/**
	 * @return the eFedModificationAmt
	 */
	public Double geteFedModificationAmt() {
		return eFedModificationAmt;
	}

	/**
	 * @param eFedModificationAmt
	 *            the eFedModificationAmt to set
	 */
	public void setEFedModificationAmt(Double eFedModificationAmt) {
		this.eFedModificationAmt = eFedModificationAmt;
	}

	/**
	 * @return the eFedGrossContractualChargeOffAmt
	 */
	public Double geteFedGrossContractualChargeOffAmt() {
		return eFedGrossContractualChargeOffAmt;
	}

	/**
	 * @param eFedGrossContractualChargeOffAmt
	 *            the eFedGrossContractualChargeOffAmt to set
	 */
	public void setEFedGrossContractualChargeOffAmt(
			Double eFedGrossContractualChargeOffAmt) {
		this.eFedGrossContractualChargeOffAmt = eFedGrossContractualChargeOffAmt;
	}

	/**
	 * @return the eFedBankruptcyChargeOffAmt
	 */
	public Double geteFedBankruptcyChargeOffAmt() {
		return eFedBankruptcyChargeOffAmt;
	}

	/**
	 * @param eFedBankruptcyChargeOffAmt
	 *            the eFedBankruptcyChargeOffAmt to set
	 */
	public void setEFedBankruptcyChargeOffAmt(Double eFedBankruptcyChargeOffAmt) {
		this.eFedBankruptcyChargeOffAmt = eFedBankruptcyChargeOffAmt;
	}

	/**
	 * @return the eFedRecoveryAmt
	 */
	public Double geteFedRecoveryAmt() {
		return eFedRecoveryAmt;
	}

	/**
	 * @param eFedRecoveryAmt
	 *            the eFedRecoveryAmt to set
	 */
	public void setEFedRecoveryAmt(Double eFedRecoveryAmt) {
		this.eFedRecoveryAmt = eFedRecoveryAmt;
	}

	/**
	 * @return the eFedNumAcctChargeOf
	 */
	public Integer geteFedNumAcctChargeOf() {
		return eFedNumAcctChargeOf;
	}

	/**
	 * @param eFedNumAcctChargeOf
	 *            the eFedNumAcctChargeOf to set
	 */
	public void setEFedNumAcctChargeOf(Integer eFedNumAcctChargeOf) {
		this.eFedNumAcctChargeOf = eFedNumAcctChargeOf;
	}

	/**
	 * @return the eFedNetChargeOffAmt
	 */
	public Double geteFedNetChargeOffAmt() {
		return eFedNetChargeOffAmt;
	}

	/**
	 * @param eFedNetChargeOffAmt
	 *            the eFedNetChargeOffAmt to set
	 */
	public void setEFedNetChargeOffAmt(Double eFedNetChargeOffAmt) {
		this.eFedNetChargeOffAmt = eFedNetChargeOffAmt;
	}

	/**
	 * @return the eFedAdjNetChargeOffAmt
	 */
	public Double geteFedAdjNetChargeOffAmt() {
		return eFedAdjNetChargeOffAmt;
	}

	/**
	 * @param eFedAdjNetChargeOffAmt
	 *            the eFedAdjNetChargeOffAmt to set
	 */
	public void setEFedAdjNetChargeOffAmt(Double eFedAdjNetChargeOffAmt) {
		this.eFedAdjNetChargeOffAmt = eFedAdjNetChargeOffAmt;
	}

	/**
	 * @return the eFedForeclosureAmt
	 */
	public Double geteFedForeclosureAmt() {
		return eFedForeclosureAmt;
	}

	/**
	 * @param eFedForeclosureAmt
	 *            the eFedForeclosureAmt to set
	 */
	public void setEFedForeclosureAmt(Double eFedForeclosureAmt) {
		this.eFedForeclosureAmt = eFedForeclosureAmt;
	}

	/**
	 * @return the eFedNewForeclosureAmt
	 */
	public Double geteFedNewForeclosureAmt() {
		return eFedNewForeclosureAmt;
	}

	/**
	 * @param eFedNewForeclosureAmt
	 *            the eFedNewForeclosureAmt to set
	 */
	public void setEFedNewForeclosureAmt(Double eFedNewForeclosureAmt) {
		this.eFedNewForeclosureAmt = eFedNewForeclosureAmt;
	}

	/**
	 * @return the eFedReoAmt
	 */
	public Double geteFedReoAmt() {
		return eFedReoAmt;
	}

	/**
	 * @param eFedReoAmt
	 *            the eFedReoAmt to set
	 */
	public void setEFedReoAmt(Double eFedReoAmt) {
		this.eFedReoAmt = eFedReoAmt;
	}

	/**
	 * @return the eFedNewReoAmt
	 */
	public Double geteFedNewReoAmt() {
		return eFedNewReoAmt;
	}

	/**
	 * @param eFedNewReoAmt
	 *            the eFedNewReoAmt to set
	 */
	public void setEFedNewReoAmt(Double eFedNewReoAmt) {
		this.eFedNewReoAmt = eFedNewReoAmt;
	}

	/**
	 * @return the eFedVhclTypeCarVanAmt
	 */
	public Double geteFedVhclTypeCarVanAmt() {
		return eFedVhclTypeCarVanAmt;
	}

	/**
	 * @param eFedVhclTypeCarVanAmt
	 *            the eFedVhclTypeCarVanAmt to set
	 */
	public void setEFedVhclTypeCarVanAmt(Double eFedVhclTypeCarVanAmt) {
		this.eFedVhclTypeCarVanAmt = eFedVhclTypeCarVanAmt;
	}

	/**
	 * @return the eFedVhclTypeSuvTruckAmt
	 */
	public Double geteFedVhclTypeSuvTruckAmt() {
		return eFedVhclTypeSuvTruckAmt;
	}

	/**
	 * @param eFedVhclTypeSuvTruckAmt
	 *            the eFedVhclTypeSuvTruckAmt to set
	 */
	public void setEFedVhclTypeSuvTruckAmt(Double eFedVhclTypeSuvTruckAmt) {
		this.eFedVhclTypeSuvTruckAmt = eFedVhclTypeSuvTruckAmt;
	}

	/**
	 * @return the eFedVhclTypeSportAmt
	 */
	public Double geteFedVhclTypeSportAmt() {
		return eFedVhclTypeSportAmt;
	}

	/**
	 * @param eFedVhclTypeSportAmt
	 *            the eFedVhclTypeSportAmt to set
	 */
	public void setEFedVhclTypeSportAmt(Double eFedVhclTypeSportAmt) {
		this.eFedVhclTypeSportAmt = eFedVhclTypeSportAmt;
	}

	/**
	 * @return the eFedVhclTypeUnknownAmt
	 */
	public Double geteFedVhclTypeUnknownAmt() {
		return eFedVhclTypeUnknownAmt;
	}

	/**
	 * @param eFedVhclTypeUnknownAmt
	 *            the eFedVhclTypeUnknownAmt to set
	 */
	public void setEFedVhclTypeUnknownAmt(Double eFedVhclTypeUnknownAmt) {
		this.eFedVhclTypeUnknownAmt = eFedVhclTypeUnknownAmt;
	}

	/**
	 * @return the eFedRepoAmt
	 */
	public Double geteFedRepoAmt() {
		return eFedRepoAmt;
	}

	/**
	 * @param eFedRepoAmt
	 *            the eFedRepoAmt to set
	 */
	public void setEFedRepoAmt(Double eFedRepoAmt) {
		this.eFedRepoAmt = eFedRepoAmt;
	}

	/**
	 * @return the eFedCurrentMonthRepoAmt
	 */
	public Double geteFedCurrentMonthRepoAmt() {
		return eFedCurrentMonthRepoAmt;
	}

	/**
	 * @param eFedCurrentMonthRepoAmt
	 *            the eFedCurrentMonthRepoAmt to set
	 */
	public void setEFedCurrentMonthRepoAmt(Double eFedCurrentMonthRepoAmt) {
		this.eFedCurrentMonthRepoAmt = eFedCurrentMonthRepoAmt;
	}

	/**
	 * @return the eFedProjValueLeaseAmt
	 */
	public Double geteFedProjValueLeaseAmt() {
		return eFedProjValueLeaseAmt;
	}

	/**
	 * @param eFedProjValueLeaseAmt
	 *            the eFedProjValueLeaseAmt to set
	 */
	public void setEFedProjValueLeaseAmt(Double eFedProjValueLeaseAmt) {
		this.eFedProjValueLeaseAmt = eFedProjValueLeaseAmt;
	}

	/**
	 * @return the eFedActSaleProceedsLeaseAmt
	 */
	public Double geteFedActSaleProceedsLeaseAmt() {
		return eFedActSaleProceedsLeaseAmt;
	}

	/**
	 * @param eFedActSaleProceedsLeaseAmt
	 *            the eFedActSaleProceedsLeaseAmt to set
	 */
	public void setEFedActSaleProceedsLeaseAmt(
			Double eFedActSaleProceedsLeaseAmt) {
		this.eFedActSaleProceedsLeaseAmt = eFedActSaleProceedsLeaseAmt;
	}

	/**
	 * @return the eFedNumAccounts
	 */
	public Integer geteFedNumAccounts() {
		return eFedNumAccounts;
	}

	/**
	 * @param eFedNumAccounts
	 *            the eFedNumAccounts to set
	 */
	public void setEFedNumAccounts(Integer eFedNumAccounts) {
		this.eFedNumAccounts = eFedNumAccounts;
	}

	/**
	 * @return the eFedUnpaidPrinBalAmt
	 */
	public Double geteFedUnpaidPrinBalAmt() {
		return eFedUnpaidPrinBalAmt;
	}

	/**
	 * @param eFedUnpaidPrinBalAmt
	 *            the eFedUnpaidPrinBalAmt to set
	 */
	public void setEFedUnpaidPrinBalAmt(Double eFedUnpaidPrinBalAmt) {
		this.eFedUnpaidPrinBalAmt = eFedUnpaidPrinBalAmt;
	}

	/**
	 * @return the eAdjustmentAmt
	 */
	public Double geteAdjustmentAmt() {
		return eAdjustmentAmt;
	}

	/**
	 * @param eAdjustmentAmt
	 *            the eAdjustmentAmt to set
	 */
	public void setEAdjustmentAmt(Double eAdjustmentAmt) {
		this.eAdjustmentAmt = eAdjustmentAmt;
	}

	/**
	 * @return the eCalcNetChargeOffAmt
	 */
	public Double geteCalcNetChargeOffAmt() {
		return eCalcNetChargeOffAmt;
	}

	/**
	 * @param eCalcNetChargeOffAmt
	 *            the eCalcNetChargeOffAmt to set
	 */
	public void setECalcNetChargeOffAmt(Double eCalcNetChargeOffAmt) {
		this.eCalcNetChargeOffAmt = eCalcNetChargeOffAmt;
	}

	/**
	 * @return the ePortfolioDefinition
	 */
	public PortfolioDefinitionVO getePortfolioDefinition() {
		return ePortfolioDefinition;
	}

	/**
	 * @param ePortfolioDefinition
	 *            the ePortfolioDefinition to set
	 */
	public void setEPortfolioDefinition(
			PortfolioDefinitionVO ePortfolioDefinition) {
		this.ePortfolioDefinition = ePortfolioDefinition;
	}

	/**
	 * @return the eExcludePortfolio
	 */
	public boolean iseExcludePortfolio() {
		return eExcludePortfolio;
	}

	/**
	 * @param eExcludePortfolio
	 *            the eExcludePortfolio to set
	 */
	public void setEExcludePortfolio(boolean eExcludePortfolio) {
		this.eExcludePortfolio = eExcludePortfolio;
	}

	/**
	 * @return the eFedCurrLineLoanSize
	 */
	public String geteFedCurrLineLoanSize() {
		return eFedCurrLineLoanSize;
	}

	/**
	 * @param eFedCurrLineLoanSize
	 *            the eFedCurrLineLoanSize to set
	 */
	public void setEFedCurrLineLoanSize(String eFedCurrLineLoanSize) {
		this.eFedCurrLineLoanSize = eFedCurrLineLoanSize;
	}

	/**
	 * @return the eFedVintage
	 */
	public String geteFedVintage() {
		return eFedVintage;
	}

	/**
	 * @param eFedVintage
	 *            the eFedVintage to set
	 */
	public void setEFedVintage(String eFedVintage) {
		this.eFedVintage = eFedVintage;
	}

	/**
	 * @return the eFedFxRate
	 */
	public Double geteFedFxRate() {
		return eFedFxRate;
	}

	/**
	 * @param eFedFxRate
	 *            the eFedFxRate to set
	 */
	public void setEFedFxRate(Double eFedFxRate) {
		this.eFedFxRate = eFedFxRate;
	}

	/**
	 * @return the eFedRefPortfolioCcy
	 */
	public String geteFedRefPortfolioCcy() {
		return eFedRefPortfolioCcy;
	}

	/**
	 * @param eFedRefPortfolioCcy
	 *            the eFedRefPortfolioCcy to set
	 */
	public void setEFedRefPortfolioCcy(String eFedRefPortfolioCcy) {
		this.eFedRefPortfolioCcy = eFedRefPortfolioCcy;
	}

	/**
	 * @return the eFedRefRptBasis
	 */
	public Integer geteFedRefRptBasis() {
		return eFedRefRptBasis;
	}

	/**
	 * @param eFedRefRptBasis
	 *            the eFedRefRptBasis to set
	 */
	public void setEFedRefRptBasis(Integer eFedRefRptBasis) {
		this.eFedRefRptBasis = eFedRefRptBasis;
	}

	/**
	 * @return the ePearlDlqSeg
	 */
	public Double getePearlDlqSeg() {
		return ePearlDlqSeg;
	}

	/**
	 * @param ePearlDlqSeg
	 *            the ePearlDlqSeg to set
	 */
	public void setEPearlDlqSeg(Double ePearlDlqSeg) {
		this.ePearlDlqSeg = ePearlDlqSeg;
	}

	/**
	 * @return the eGcl
	 */
	public Double geteGcl() {
		return eGcl;
	}

	/**
	 * @param eGcl
	 *            the eGcl to set
	 */
	public void setEGcl(Double eGcl) {
		this.eGcl = eGcl;
	}

	public String inputRecordHeader() {
		return "rptPeriod,gcbcPortfolioId,submitterId,contactId,dataVersion,region,country,productType,collateralizedFlag,currLineLoanSize,originalLtv,age,vintage,delqStatus,origFico,netAccounts,unpaidPrinBalAmt,enrAmt,outstandingDpdOver30Amt,numAcctDpdOver30,accountEver30DpdLast12Amt,accountEver60DpdLast12Amt,numNewAccounts,newAccountAmt,commitmentAmt,newCommitmentAmt,commitmentIncrAmt,commitmentDecrAmt,modificationAmt,grossContractualChargeOffAmt,bankruptcyChargeOffAmt,recovery,numAcctChargeOff,netChargeOffAmt,adjNetChargeOffAmt,foreclosureAmt,newForeclosureAmt,reoAmt,newReoAmt,vehicleTypeCarVanAmt,vehicleTypeSuvTruckAmt,vehicleTypeSportAmt,vehicleTypeUnknown,repo,currentMonthRepo,projectedvalueLease,ActSaleProceedsLease,refPortfolioCcy,fxRate,rptBasis";
	}

	public String inputRecordString() {

		String inputRecord = rptPeriod + "," + gcbcPortfolioId + ","
				+ submitterId + "," + contactId + "," + dataVersion + ","
				+ region + "," + country + "," + productType + ","
				+ collateralizedFlag + "," + currLineLoanSize + ","
				+ originalLtv + "," + age + "," + vintage + "," + delqStatus
				+ "," + origFico + "," + numAccounts + "," + unpaidPrinBalAmt
				+ "," + enrAmt + "," + outstandingDpdOver30Amt + ","
				+ numAcctDpdOver30 + "," + accountEver30DpdLast12Amt + ","
				+ accountEver60DpdLast12Amt + "," + numNewAccounts + ","
				+ newAccountAmt + "," + commitmentAmt + "," + newCommitmentAmt
				+ "," + commitmentIncrAmt + "," + commitmentDecrAmt + ","
				+ modificationAmt + "," + grossContractualChargeOffAmt + ","
				+ bankruptcyChargeOffAmt + "," + recovery + ","
				+ numAcctChargeOff + "," + netChargeOffAmt + ","
				+ adjNetChargeOffAmt + "," + foreclosureAmt + ","
				+ newForeclosureAmt + "," + reoAmt + "," + newReoAmt + ","
				+ vehicleTypeCarVanAmt + "," + vehicleTypeSuvTruckAmt + ","
				+ vehicleTypeSportAmt + "," + vehicleTypeUnknown + "," + repo
				+ "," + currentMonthRepo + "," + "" + ","
				+ ActSaleProceedsLease + "," + refPortfolioCcy + "," + fxRate
				+ "," + rptBasis + "," + "Exception";

		return inputRecord;
	}

}
