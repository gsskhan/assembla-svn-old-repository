package com.citi.retail.optima.etl.common.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author rb59055
 * 
 */
public class InRcTRLRecord {

	private String eUniqueIdSrcSys;
	private List<CommonBalanceRcTRLRecord> eCommonBalanceRcTRLRecords;
	private String eSrcSysId;
	private String eProdSysId;
	private String eRecordType;
	private Date eAsOfDate;
	private String eGlobProdId;
	private String arrngmentName;
	private String description;
	private Date eBookingDate;
	private Date eOrginalEffDate;
	private Date eEffectiveDate;
	private Date eEffectiveDateAIR;
	private Date estimEndDate;
	private Date eEndDate;
	private Date eEndDateAip;
	private Date eEndDateAR; // end date for Arrangment Rate
	private Integer eArrngTypeId;
	private String eDenominCurrId;
	private Integer eOrigChnlId;
	private Integer eArrngBusIntType;
	private Date eArrngBusIntDate;
	private String ePledgeInd;
	private String ePledgeEligInd;
	private Integer eArrngMatureTypeId;
	private Integer eArrngFinStatusTypeId;
	private Date eArrngFinStatusDate;
	private Integer eArrngPastDueDayCnt;
	private Integer eGracePeriodDayCnt;
	private Integer eArrngPastDueAgeClass;
	private Date eArrngPastDueAgeClassDate;
	private Integer arrngFinancialStatusReasonTypeId;
	private Integer eArrngLifeCycStatusTypeId;
	private Integer arrngLifeCycleStsReasonTypeId;
	private Date eArrngLifeCycStatusDate;
	private Date arrngNextRenewalDate;
	private Date nextRenewalDate;
	private Integer arrngPrimaryPymtTypeId;
	private String eEntrProdId;
	private String localProdCode;
	private String localSubProdCode;
	private String localProdCategoryCode;
	private Integer originalCampaignId;
	private String feeWaiverFlg;
	private Date feeWaiverExpDate;
	private Integer eAcctTypeId;
	private String eArrngAcqTypeId;
	private Date eArrngAcqDateCorp;
	private Date eArrngAcqDateRewrite;
	private Date eArrngAcqDate;
	private Date eArrngAcqDateRetail;
	private String eArrngDisposTypeId;
	private Date arrngDispositionDate;
	private Integer chargeOffTypeId;
	private Integer origOrInvestorInsuredCategryId;
	private String OrigOrInvestorInsuredActiveFlg;
	private Double OrigOrInvestorInsuredPerct;
	private Integer eArrngDayCnvtTypeId;
	private Integer eIntrBasisCalcPrdId;
	private Integer eIntrPymtFreqPrdId;
	private Integer feePymtFreqPeriodId;
	private Integer eRateRstPrdInrvId;
	private Date intIntrestRateResetDate;
	private Date eNxtIntrRateRstDate;
	private Date prevOrLastIntrRateResetDate;
	private String eAtmCardFlg;
	private String islamicAcctIndicator;
	private String taxExemptIndicator;
	private String onlineBankRltnIndicator;
	private Integer remainingDaysToMaturity;
	private Integer eFinServTypeId;
	private BigDecimal eOrigAmt;
	private String obligatorResourceIndicator;
	private String citiResourceIndicator;
	private Integer pymtFrequencyPeriodId;
	private String negativeAmortizationFlg;
	private String balloonRepymtIndicator;
	private Integer eIntrAccrStsTypeId;
	private Date eIntrAccrStsDate;
	private Integer intrOnlyTermPeriod;
	private Integer principalGracePeriod;
	private Integer noticePeriodDays;
	private Integer acquisitionCost;
	private String finServiceCurRestrctStsId;
	private Date finServiceCurRestrctStsDate;
	private String finServiceRestrctOrModresonTypeId;
	private String finServPrevRestructStsId;
	private Date finServRestructPrevStsDate;
	private Integer finServModifPrgmId;
	private Date finServModfPrgmStrtDate;
	private Integer finServModfPrgmCurrSts;
	private Date finServModfPrgmCurrStsDate;
	private Date finServModfPrgmEndDate;
	private Integer finServModfPrgmPrevStsTypeId;
	private Integer finServLimitTypeId;
	private Integer currFinServPrinRepymtTypeId;
	private String troubledDebtRestructFlg;
	private String restructOrModifFlag;
	private String marketRateYldAtRenFlg;
	private String overLimitIndicator;
	private String skipPymtIndicator;
	private String amortizationAccertionIndicator;
	private String securitizedIndicator;
	private Integer modfRetentOrLossMitgTypeId;
	private String regOEmpFlg;
	private Integer trppTenor;
	private Double acctTrppInstAmt;
	private String lineOfCrdAtmExtFlg;
	private String lineOfCrdLoanConvFlg;
	private Integer incomeDocTypeId;
	private String crdDeviationIndicator;
	private Integer pymtTotalNumber;
	private Integer remainingPymtNumbr;
	private String preComputedLoanFlg;
	private String discountPremLoanTypeId;
	private String ppInternalRefNumbr;
	private String localWarehouseReference;
	private String upstreamSysReference;
	private String customerTradeRefernce;
	private String eArrngPurposeTypeId1;
	private String arrngPurposeTypeId2;
	private String arrngPurposeTypeId3;
	private Double penaltyRate;
	private Double penaltyAmt;
	private Integer legalNotificationDays;
	private Date arrngNextPymtDueToBankDate;
	private Double arrngNextPymtDueToBankAmt;
	private Date arrngLastPymtDueToBankDate;
	private Double arrngLastPymtDueToBankAmt;
	private Date acctFirstAdvnceDate;
	private Double acctFirstAdvanceAmt;
	private Date acctFirstPymtDate;
	private Double acctFirstPymtAmt;
	private Date acctLastAdvanceDate;
	private Double acctLastAdvanceAmt;
	private Integer missedPymtNumbr;
	private Date acctLastRecoveryDate;
	private Date acctLastInstallDate;
	private Double totalPymts;
	private Date acctLastIntrReviewDate;
	private Date lastIntrCollectionDate;
	private String eDelq30DayPst2YrsFlg;
	private Integer eArrngSecureTypeId;
	private Integer lienPositionTypeId;
	private Double probabilityOfDefault;
	private String eBaselPortfolioId;
	private String otherAltId;
	private Integer eCreditFacTypeId;
	private Integer eFacLegalStstTypeId;
	private Date facilityLegalStsDate;
	private Integer eCredFacArrngApprvTypeId;
	private Date credFacArrngApprvDate;
	private Integer credFacRegSegTypeId;
	private Integer credFacAvailStsTypeId;
	private BigDecimal originalAdvisedCommitLimit;
	private BigDecimal originalAdvisedUncommittedLimit;
	private Double originalUnadvisedUncommitLimit;
	private Date lastCreditLimitChangeDate;
	private Integer credLimitChangeTypeId;
	private Date credLimitEffectiveDate;
	private Date credLimitEndDate;
	private String eCredLimitEvtIntTypeId;
	private Double credLimitEventAmt;
	private String eCcarProdCode;
	private Date bankruptcyCode;
	private String promoIntrRateEligibleFlg;
	private String pmacPortfolioId;
	private String eOrigAcctNumb;
	private Date lastWriteDownDate;
	private String currentlyNegativeAmortizeFlg;
	private String principalDeferralOptionFlg;
	private Date principalDefrralOptionEndDate;
	private String intrDeferralOptionFlg;
	private Date intrDeferralOptionEndDate;
	private Date intrOnlyOptionEndDate;
	private String eEverWrittenOffFlg;
	private String acctFundsAdvancedCompleteFlg;
	private Double totFundsDisbursedAmt;
	private Integer monthsOnBooksLocal;
	private String eRiskMgmtInd;
	private Integer daysPastDueCycleEnd;
	private Integer delinqBucket;
	private Integer cycleEndDelinqBucket;
	private String reservedForFutureGenesisUsage1; 
	private String reservedForFutureGenesisUsage2;
	private String reservedForFutureGenesisUsage3;
	private String reservedForFutureGenesisUsage4;
	private String reservedForFutureGenesisUsage5;
	private String reservedForFutureGenesisUsage6;
	private String reservedForFutureGenesisUsage7;
	private String reservedForFutureGenesisUsage8;
	private String reservedForFutureGenesisUsage9;
	private String reservedForFutureGenesisUsage10;
	private String reservedForFutureGenesisUsage11;
	private String reservedForFutureGenesisUsage12;
	private String reservedForFutureGenesisUsage13;
	private String reservedForFutureGenesisUsage14;
	private String reservedForFutureGenesisUsage15;
	private String reservedForFutureGenesisUsage16;
	private String reservedForFutureGenesisUsage17;
	private String reservedForFutureGenesisUsage18;
	private String reservedForFutureGenesisUsage19;
	private String eUniqIdSrsInvPty;
	private String eArrngInvlvPtyRoleType;
	private BigDecimal ePercentAmt;
	private String eInvlvPtySubTypeId;
	private String eRatingIssuerId;
	private String eModelCode;
	private Integer eRatingEventRsnTypeId;
	private Integer eRank;
	private String eRatingTypeCode;
	private String eRatingCode;
	private String eFicoEquiRatingCode;
	private String eRaingDescription;
	private String eScoreRqstReturnFlg;
	private String eModelCodeAIR;
	private Integer eResouceItemTypeId;
	private String primaryCollateralIndicator;
	private Integer revaluationCollateralInd;
	private String resourceItemName;
	private Integer srcSysId;
	private Double resourceItemValAmt;
	private Integer eResourceItemValMethId;
	private Date eResourceItemValEffDate;
	private Integer eResItemBalCurrId;
	private Integer eResItemBalTypeId;
	private Integer resItemValuationEvntReasonTypeId;
	private Integer eLoanToAstRelType;
	private Date eReltnEffDate;
	private Integer collateralTypeId;
	private String eStndrdArrgId;
	private Integer eCreditRiskMitgTypeId;
	private Integer collateralSrcTypeId;
	private String legalEnforcablityFlg;
	private String legalRightToPosFlg;
	private String reHypotheInd;
	private Integer collateralLocCode;
	private String intMarginOrValMargFlg;
	private Integer legNumbr;
	private String generalLdgerSysId;
	private Integer dealId;
	private String eBookingLedgerCountryCode;
	private Integer eBalType;
	private String eGLAccount1;
	private String glAccount2;
	private String fdlAccount;
	private String eTransCurrCode;
	private String eFuncCurrCode;
	private String eBaseCurrCode;
	private Double eTransAmt;
	private BigDecimal functionalAmt;
	private Double baseAmt;
	private String goc;
	private String bookingLedgerBranchCode;
	private String frsBusUnitCode;
	private String notForUse;
	private String localDeptId;
	private String eLocalLegVehicleId;
	private String fairValacctMethodFlg;
	private String fairValLevel;
	private String expenseCode;
	private String frsAfflCode;
	private String subStrategyCode;
	private String eGAAPInd;
	private String microCntStrtCodeOpenField1;
	private String firmAcctIMSNumbr;
	private String baseNumbLocafflCode;
	private String idProd;
	private String keyCode1;
	private String keyCode2;
	private String locLedgerAcctNumb;
	private String adjustmentInd;
	private String userId;
	private String adjustmentReasonCode;
	private String comments;
	private String localGlKey3;
	private String localGlKey4;
	private String adjStrdArrngId;
	private Integer eFeePymtFreqPrdId;
	private Double eBaseAmtCurr;
	private Integer eLossMitgPrgmId;
	private Integer eISupTypId;
	private String eRateTypeId;
	private Double eArrngPctAmt;
	private Integer eLegNumber;
	private String restrctFlg;
	private String originalAccountNumber;
	
	private BigDecimal eEffectiveRatePercent;
	private Double speedRatePer;
	private Integer arrngRateTypRelnTypId;
	private String rateId;
	private String rateName;
	private Integer eRateVarTypeId;
	private Date rateTypEffDate;
	private String eRateActiveFlag;
	private String eEffectiveRatePercentage;
	private Integer eFinServiceLimitTypId;
	private Integer eCAArrngBusIntType;
	private Integer eARGRank;
	private Date eARGEffectiveDate;
	private Date eARGEndDate;
	//private Double eEffRatePct;
	
	

	/**
	 * @return the eFinServiceLimitTypId
	 */
	public Integer geteFinServiceLimitTypId() {
		return eFinServiceLimitTypId;
	}

	public Date geteEndDateAR() {
		return eEndDateAR;
	}

	public void setEEndDateAR(Date eEndDateAR) {
		this.eEndDateAR = eEndDateAR;
	}

	/**
	 * @param eFinServiceLimitTypId the eFinServiceLimitTypId to set
	 */
	public void setEFinServiceLimitTypId(Integer eFinServiceLimitTypId) {
		this.eFinServiceLimitTypId = eFinServiceLimitTypId;
	}

	/**
	 * @return the eEffectiveRatePercentage
	 */
	public String geteEffectiveRatePercentage() {
		return eEffectiveRatePercentage;
	}

	/**
	 * @param eEffectiveRatePercentage the eEffectiveRatePercentage to set
	 */
	public void seteEffectiveRatePercentage(String eEffectiveRatePercentage) {
		this.eEffectiveRatePercentage = eEffectiveRatePercentage;	
	}

	private Double eRiRate;
	private Double eCiRate;
	

	public String geteUniqueIdSrcSys() {
		return eUniqueIdSrcSys;
	}

	public void setEUniqueIdSrcSys(String eUniqueIdSrcSys) {
		this.eUniqueIdSrcSys = eUniqueIdSrcSys;
	}

	public String geteSrcSysId() {
		return eSrcSysId;
	}

	public void setESrcSysId(String eSrcSysId) {
		this.eSrcSysId = eSrcSysId;
	}

	public String geteProdSysId() {
		return eProdSysId;
	}

	public void setEProdSysId(String eProdSysId) {
		this.eProdSysId = eProdSysId;
	}

	public String geteRecordType() {
		return eRecordType;
	}

	public void setERecordType(String eRecordType) {
		this.eRecordType = eRecordType;
	}

	public Date geteAsOfDate() {
		return eAsOfDate;
	}

	public void setEAsOfDate(Date eAsOfDate) {
		this.eAsOfDate = eAsOfDate;
	}

	public String geteGlobProdId() {
		return eGlobProdId;
	}

	public void setEGlobProdId(String eGlobProdId) {
		this.eGlobProdId = eGlobProdId;
	}

	public String getArrngmentName() {
		return arrngmentName;
	}

	public void setArrngmentName(String arrngmentName) {
		this.arrngmentName = arrngmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date geteOrginalEffDate() {
		return eOrginalEffDate;
	}

	public void setEOrginalEffDate(Date eOrginalEffDate) {
		this.eOrginalEffDate = eOrginalEffDate;
	}

	public Date geteEffectiveDate() {
		return eEffectiveDate;
	}

	public void setEEffectiveDate(Date eEffectiveDate) {
		this.eEffectiveDate = eEffectiveDate;
	}

	public Date getEstimEndDate() {
		return estimEndDate;
	}

	public void setEstimEndDate(Date estimEndDate) {
		this.estimEndDate = estimEndDate;
	}

	public Date geteEndDate() {
		return eEndDate;
	}

	public void setEEndDate(Date eEndDate) {
		this.eEndDate = eEndDate;
	}

	public Integer geteArrngTypeId() {
		return eArrngTypeId;
	}

	public void setEArrngTypeId(Integer eArrngTypeId) {
		this.eArrngTypeId = eArrngTypeId;
	}

	public String geteDenominCurrId() {
		return eDenominCurrId;
	}

	public void setEDenominCurrId(String eDenominCurrId) {
		this.eDenominCurrId = eDenominCurrId;
	}

	public Integer geteOrigChnlId() {
		return eOrigChnlId;
	}

	public void setEOrigChnlId(Integer eOrigChnlId) {
		this.eOrigChnlId = eOrigChnlId;
	}

	public Integer geteArrngBusIntType() {
		return eArrngBusIntType;
	}

	public void setEArrngBusIntType(Integer eArrngBusIntType) {
		this.eArrngBusIntType = eArrngBusIntType;
	}

	public String getePledgeInd() {
		return ePledgeInd;
	}

	public void setEPledgeInd(String ePledgeInd) {
		this.ePledgeInd = ePledgeInd;
	}

	public String getePledgeEligInd() {
		return ePledgeEligInd;
	}

	public void setEPledgeEligInd(String ePledgeEligInd) {
		this.ePledgeEligInd = ePledgeEligInd;
	}

	public Integer geteArrngMatureTypeId() {
		return eArrngMatureTypeId;
	}

	public void setEArrngMatureTypeId(Integer eArrngMatureTypeId) {
		this.eArrngMatureTypeId = eArrngMatureTypeId;
	}

	public Integer geteArrngFinStatusTypeId() {
		return eArrngFinStatusTypeId;
	}

	public void setEArrngFinStatusTypeId(Integer eArrngFinStatusTypeId) {
		this.eArrngFinStatusTypeId = eArrngFinStatusTypeId;
	}

	public Date geteArrngFinStatusDate() {
		return eArrngFinStatusDate;
	}

	public void setEArrngFinStatusDate(Date eArrngFinStatusDate) {
		this.eArrngFinStatusDate = eArrngFinStatusDate;
	}

	public Integer geteArrngPastDueDayCnt() {
		return eArrngPastDueDayCnt;
	}

	public void setEArrngPastDueDayCnt(Integer eArrngPastDueDayCnt) {
		this.eArrngPastDueDayCnt = eArrngPastDueDayCnt;
	}

	public Integer geteGracePeriodDayCnt() {
		return eGracePeriodDayCnt;
	}

	public void setEGracePeriodDayCnt(Integer eGracePeriodDayCnt) {
		this.eGracePeriodDayCnt = eGracePeriodDayCnt;
	}

	public Integer geteArrngPastDueAgeClass() {
		return eArrngPastDueAgeClass;
	}

	public void setEArrngPastDueAgeClass(Integer eArrngPastDueAgeClass) {
		this.eArrngPastDueAgeClass = eArrngPastDueAgeClass;
	}

	public Date geteArrngPastDueAgeClassDate() {
		return eArrngPastDueAgeClassDate;
	}

	public void setEArrngPastDueAgeClassDate(Date eArrngPastDueAgeClassDate) {
		this.eArrngPastDueAgeClassDate = eArrngPastDueAgeClassDate;
	}

	public Integer getArrngFinancialStatusReasonTypeId() {
		return arrngFinancialStatusReasonTypeId;
	}

	public void setArrngFinancialStatusReasonTypeId(
			Integer arrngFinancialStatusReasonTypeId) {
		this.arrngFinancialStatusReasonTypeId = arrngFinancialStatusReasonTypeId;
	}

	public Integer geteArrngLifeCycStatusTypeId() {
		return eArrngLifeCycStatusTypeId;
	}

	public void setEArrngLifeCycStatusTypeId(Integer eArrngLifeCycStatusTypeId) {
		this.eArrngLifeCycStatusTypeId = eArrngLifeCycStatusTypeId;
	}

	public Integer getArrngLifeCycleStsReasonTypeId() {
		return arrngLifeCycleStsReasonTypeId;
	}

	public void setArrngLifeCycleStsReasonTypeId(
			Integer arrngLifeCycleStsReasonTypeId) {
		this.arrngLifeCycleStsReasonTypeId = arrngLifeCycleStsReasonTypeId;
	}

	public Date geteArrngLifeCycStatusDate() {
		return eArrngLifeCycStatusDate;
	}

	public void setEArrngLifeCycStatusDate(Date eArrngLifeCycStatusDate) {
		this.eArrngLifeCycStatusDate = eArrngLifeCycStatusDate;
	}

	public Date getArrngNextRenewalDate() {
		return arrngNextRenewalDate;
	}

	public void setArrngNextRenewalDate(Date arrngNextRenewalDate) {
		this.arrngNextRenewalDate = arrngNextRenewalDate;
	}

	public Date getNextRenewalDate() {
		return nextRenewalDate;
	}

	public void setNextRenewalDate(Date nextRenewalDate) {
		this.nextRenewalDate = nextRenewalDate;
	}

	public Integer getArrngPrimaryPymtTypeId() {
		return arrngPrimaryPymtTypeId;
	}

	public void setArrngPrimaryPymtTypeId(Integer arrngPrimaryPymtTypeId) {
		this.arrngPrimaryPymtTypeId = arrngPrimaryPymtTypeId;
	}

	public String geteEntrProdId() {
		return eEntrProdId;
	}

	public void setEEntrProdId(String eEntrProdId) {
		this.eEntrProdId = eEntrProdId;
	}

	public String getLocalProdCode() {
		return localProdCode;
	}

	public void setLocalProdCode(String localProdCode) {
		this.localProdCode = localProdCode;
	}

	public String getLocalSubProdCode() {
		return localSubProdCode;
	}

	public void setLocalSubProdCode(String localSubProdCode) {
		this.localSubProdCode = localSubProdCode;
	}

	public String getLocalProdCategoryCode() {
		return localProdCategoryCode;
	}

	public void setLocalProdCategoryCode(String localProdCategoryCode) {
		this.localProdCategoryCode = localProdCategoryCode;
	}

	public Integer getOriginalCampaignId() {
		return originalCampaignId;
	}

	public void setOriginalCampaignId(Integer originalCampaignId) {
		this.originalCampaignId = originalCampaignId;
	}

	public String getFeeWaiverFlg() {
		return feeWaiverFlg;
	}

	public void setFeeWaiverFlg(String feeWaiverFlg) {
		this.feeWaiverFlg = feeWaiverFlg;
	}

	public Date getFeeWaiverExpDate() {
		return feeWaiverExpDate;
	}

	public void setFeeWaiverExpDate(Date feeWaiverExpDate) {
		this.feeWaiverExpDate = feeWaiverExpDate;
	}

	public Integer geteAcctTypeId() {
		return eAcctTypeId;
	}

	public void setEAcctTypeId(Integer eAcctTypeId) {
		this.eAcctTypeId = eAcctTypeId;
	}

	public String geteArrngAcqTypeId() {
		return eArrngAcqTypeId;
	}

	public void setEArrngAcqTypeId(String eArrngAcqTypeId) {
		this.eArrngAcqTypeId = eArrngAcqTypeId;
	}

	public Date geteArrngAcqDateCorp() {
		return eArrngAcqDateCorp;
	}

	public void setEArrngAcqDateCorp(Date eArrngAcqDateCorp) {
		this.eArrngAcqDateCorp = eArrngAcqDateCorp;
	}

	public Date geteArrngAcqDateRewrite() {
		return eArrngAcqDateRewrite;
	}

	public void setEArrngAcqDateRewrite(Date eArrngAcqDateRewrite) {
		this.eArrngAcqDateRewrite = eArrngAcqDateRewrite;
	}

	public Date geteArrngAcqDateRetail() {
		return eArrngAcqDateRetail;
	}

	public void setEArrngAcqDateRetail(Date eArrngAcqDateRetail) {
		this.eArrngAcqDateRetail = eArrngAcqDateRetail;
	}

	public String geteArrngDisposTypeId() {
		return eArrngDisposTypeId;
	}

	public void setEArrngDisposTypeId(String eArrngDisposTypeId) {
		this.eArrngDisposTypeId = eArrngDisposTypeId;
	}

	public Date getArrngDispositionDate() {
		return arrngDispositionDate;
	}

	public void setArrngDispositionDate(Date arrngDispositionDate) {
		this.arrngDispositionDate = arrngDispositionDate;
	}

	public Integer getChargeOffTypeId() {
		return chargeOffTypeId;
	}

	public void setChargeOffTypeId(Integer chargeOffTypeId) {
		this.chargeOffTypeId = chargeOffTypeId;
	}

	public Integer getOrigOrInvestorInsuredCategryId() {
		return origOrInvestorInsuredCategryId;
	}

	public void setOrigOrInvestorInsuredCategryId(
			Integer origOrInvestorInsuredCategryId) {
		this.origOrInvestorInsuredCategryId = origOrInvestorInsuredCategryId;
	}

	public String getOrigOrInvestorInsuredActiveFlg() {
		return OrigOrInvestorInsuredActiveFlg;
	}

	public void setOrigOrInvestorInsuredActiveFlg(
			String origOrInvestorInsuredActiveFlg) {
		OrigOrInvestorInsuredActiveFlg = origOrInvestorInsuredActiveFlg;
	}

	public Double getOrigOrInvestorInsuredPerct() {
		return OrigOrInvestorInsuredPerct;
	}

	public void setOrigOrInvestorInsuredPerct(Double origOrInvestorInsuredPerct) {
		OrigOrInvestorInsuredPerct = origOrInvestorInsuredPerct;
	}

	public Integer geteArrngDayCnvtTypeId() {
		return eArrngDayCnvtTypeId;
	}

	public void setEArrngDayCnvtTypeId(Integer eArrngDayCnvtTypeId) {
		this.eArrngDayCnvtTypeId = eArrngDayCnvtTypeId;
	}

	public Integer geteIntrBasisCalcPrdId() {
		return eIntrBasisCalcPrdId;
	}

	public void setEIntrBasisCalcPrdId(Integer eIntrBasisCalcPrdId) {
		this.eIntrBasisCalcPrdId = eIntrBasisCalcPrdId;
	}

	public Integer geteIntrPymtFreqPrdId() {
		return eIntrPymtFreqPrdId;
	}

	public void setEIntrPymtFreqPrdId(Integer eIntrPymtFreqPrdId) {
		this.eIntrPymtFreqPrdId = eIntrPymtFreqPrdId;
	}

	public Integer getFeePymtFreqPeriodId() {
		return feePymtFreqPeriodId;
	}

	public void setFeePymtFreqPeriodId(Integer feePymtFreqPeriodId) {
		this.feePymtFreqPeriodId = feePymtFreqPeriodId;
	}

	public Integer geteRateRstPrdInrvId() {
		return eRateRstPrdInrvId;
	}

	public void setERateRstPrdInrvId(Integer eRateRstPrdInrvId) {
		this.eRateRstPrdInrvId = eRateRstPrdInrvId;
	}

	public Date getIntIntrestRateResetDate() {
		return intIntrestRateResetDate;
	}

	public void setIntIntrestRateResetDate(Date intIntrestRateResetDate) {
		this.intIntrestRateResetDate = intIntrestRateResetDate;
	}

	public Date geteNxtIntrRateRstDate() {
		return eNxtIntrRateRstDate;
	}

	public void setENxtIntrRateRstDate(Date eNxtIntrRateRstDate) {
		this.eNxtIntrRateRstDate = eNxtIntrRateRstDate;
	}

	public Date getPrevOrLastIntrRateResetDate() {
		return prevOrLastIntrRateResetDate;
	}

	public void setPrevOrLastIntrRateResetDate(Date prevOrLastIntrRateResetDate) {
		this.prevOrLastIntrRateResetDate = prevOrLastIntrRateResetDate;
	}

	public String geteAtmCardFlg() {
		return eAtmCardFlg;
	}

	public void setEAtmCardFlg(String eAtmCardFlg) {
		this.eAtmCardFlg = eAtmCardFlg;
	}

	public String getIslamicAcctIndicator() {
		return islamicAcctIndicator;
	}

	public void setIslamicAcctIndicator(String islamicAcctIndicator) {
		this.islamicAcctIndicator = islamicAcctIndicator;
	}

	public String getTaxExemptIndicator() {
		return taxExemptIndicator;
	}

	public void setTaxExemptIndicator(String taxExemptIndicator) {
		this.taxExemptIndicator = taxExemptIndicator;
	}

	public String getOnlineBankRltnIndicator() {
		return onlineBankRltnIndicator;
	}

	public void setOnlineBankRltnIndicator(String onlineBankRltnIndicator) {
		this.onlineBankRltnIndicator = onlineBankRltnIndicator;
	}

	public Integer getRemainingDaysToMaturity() {
		return remainingDaysToMaturity;
	}

	public void setRemainingDaysToMaturity(Integer remainingDaysToMaturity) {
		this.remainingDaysToMaturity = remainingDaysToMaturity;
	}

	public Integer geteFinServTypeId() {
		return eFinServTypeId;
	}

	public void setEFinServTypeId(Integer eFinServTypeId) {
		this.eFinServTypeId = eFinServTypeId;
	}

	public String getObligatorResourceIndicator() {
		return obligatorResourceIndicator;
	}

	public void setObligatorResourceIndicator(String obligatorResourceIndicator) {
		this.obligatorResourceIndicator = obligatorResourceIndicator;
	}

	public String getCitiResourceIndicator() {
		return citiResourceIndicator;
	}

	public void setCitiResourceIndicator(String citiResourceIndicator) {
		this.citiResourceIndicator = citiResourceIndicator;
	}

	public Integer getPymtFrequencyPeriodId() {
		return pymtFrequencyPeriodId;
	}

	public void setPymtFrequencyPeriodId(Integer pymtFrequencyPeriodId) {
		this.pymtFrequencyPeriodId = pymtFrequencyPeriodId;
	}

	public String getNegativeAmortizationFlg() {
		return negativeAmortizationFlg;
	}

	public void setNegativeAmortizationFlg(String negativeAmortizationFlg) {
		this.negativeAmortizationFlg = negativeAmortizationFlg;
	}

	public String getBalloonRepymtIndicator() {
		return balloonRepymtIndicator;
	}

	public void setBalloonRepymtIndicator(String balloonRepymtIndicator) {
		this.balloonRepymtIndicator = balloonRepymtIndicator;
	}

	public Integer geteIntrAccrStsTypeId() {
		return eIntrAccrStsTypeId;
	}

	public void setEIntrAccrStsTypeId(Integer eIntrAccrStsTypeId) {
		this.eIntrAccrStsTypeId = eIntrAccrStsTypeId;
	}

	public Date geteIntrAccrStsDate() {
		return eIntrAccrStsDate;
	}

	public void setEIntrAccrStsDate(Date eIntrAccrStsDate) {
		this.eIntrAccrStsDate = eIntrAccrStsDate;
	}

	public Integer getIntrOnlyTermPeriod() {
		return intrOnlyTermPeriod;
	}

	public void setIntrOnlyTermPeriod(Integer intrOnlyTermPeriod) {
		this.intrOnlyTermPeriod = intrOnlyTermPeriod;
	}

	public Integer getPrincipalGracePeriod() {
		return principalGracePeriod;
	}

	public void setPrincipalGracePeriod(Integer principalGracePeriod) {
		this.principalGracePeriod = principalGracePeriod;
	}

	public Integer getNoticePeriodDays() {
		return noticePeriodDays;
	}

	public void setNoticePeriodDays(Integer noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
	}

	public Integer getAcquisitionCost() {
		return acquisitionCost;
	}

	public void setAcquisitionCost(Integer acquisitionCost) {
		this.acquisitionCost = acquisitionCost;
	}

	public String getFinServiceCurRestrctStsId() {
		return finServiceCurRestrctStsId;
	}

	public void setFinServiceCurRestrctStsId(String finServiceCurRestrctStsId) {
		this.finServiceCurRestrctStsId = finServiceCurRestrctStsId;
	}

	public Date getFinServiceCurRestrctStsDate() {
		return finServiceCurRestrctStsDate;
	}

	public void setFinServiceCurRestrctStsDate(Date finServiceCurRestrctStsDate) {
		this.finServiceCurRestrctStsDate = finServiceCurRestrctStsDate;
	}

	public String getFinServiceRestrctOrModresonTypeId() {
		return finServiceRestrctOrModresonTypeId;
	}

	public void setFinServiceRestrctOrModresonTypeId(
			String finServiceRestrctOrModresonTypeId) {
		this.finServiceRestrctOrModresonTypeId = finServiceRestrctOrModresonTypeId;
	}

	public String getFinServPrevRestructStsId() {
		return finServPrevRestructStsId;
	}

	public void setFinServPrevRestructStsId(String finServPrevRestructStsId) {
		this.finServPrevRestructStsId = finServPrevRestructStsId;
	}

	public Date getFinServRestructPrevStsDate() {
		return finServRestructPrevStsDate;
	}

	public void setFinServRestructPrevStsDate(Date finServRestructPrevStsDate) {
		this.finServRestructPrevStsDate = finServRestructPrevStsDate;
	}

	public Integer getFinServModifPrgmId() {
		return finServModifPrgmId;
	}

	public void setFinServModifPrgmId(Integer finServModifPrgmId) {
		this.finServModifPrgmId = finServModifPrgmId;
	}

	public Date getFinServModfPrgmStrtDate() {
		return finServModfPrgmStrtDate;
	}

	public void setFinServModfPrgmStrtDate(Date finServModfPrgmStrtDate) {
		this.finServModfPrgmStrtDate = finServModfPrgmStrtDate;
	}

	public Integer getFinServModfPrgmCurrSts() {
		return finServModfPrgmCurrSts;
	}

	public void setFinServModfPrgmCurrSts(Integer finServModfPrgmCurrSts) {
		this.finServModfPrgmCurrSts = finServModfPrgmCurrSts;
	}

	public Date getFinServModfPrgmCurrStsDate() {
		return finServModfPrgmCurrStsDate;
	}

	public void setFinServModfPrgmCurrStsDate(Date finServModfPrgmCurrStsDate) {
		this.finServModfPrgmCurrStsDate = finServModfPrgmCurrStsDate;
	}

	public Date getFinServModfPrgmEndDate() {
		return finServModfPrgmEndDate;
	}

	public void setFinServModfPrgmEndDate(Date finServModfPrgmEndDate) {
		this.finServModfPrgmEndDate = finServModfPrgmEndDate;
	}

	public Integer getFinServModfPrgmPrevStsTypeId() {
		return finServModfPrgmPrevStsTypeId;
	}

	public void setFinServModfPrgmPrevStsTypeId(
			Integer finServModfPrgmPrevStsTypeId) {
		this.finServModfPrgmPrevStsTypeId = finServModfPrgmPrevStsTypeId;
	}

	public Integer getFinServLimitTypeId() {
		return finServLimitTypeId;
	}

	public void setFinServLimitTypeId(Integer finServLimitTypeId) {
		this.finServLimitTypeId = finServLimitTypeId;
	}

	public Integer getCurrFinServPrinRepymtTypeId() {
		return currFinServPrinRepymtTypeId;
	}

	public void setCurrFinServPrinRepymtTypeId(
			Integer currFinServPrinRepymtTypeId) {
		this.currFinServPrinRepymtTypeId = currFinServPrinRepymtTypeId;
	}

	public String getTroubledDebtRestructFlg() {
		return troubledDebtRestructFlg;
	}

	public void setTroubledDebtRestructFlg(String troubledDebtRestructFlg) {
		this.troubledDebtRestructFlg = troubledDebtRestructFlg;
	}

	public String getRestructOrModifFlag() {
		return restructOrModifFlag;
	}

	public void setRestructOrModifFlag(String restructOrModifFlag) {
		this.restructOrModifFlag = restructOrModifFlag;
	}

	public String getMarketRateYldAtRenFlg() {
		return marketRateYldAtRenFlg;
	}

	public void setMarketRateYldAtRenFlg(String marketRateYldAtRenFlg) {
		this.marketRateYldAtRenFlg = marketRateYldAtRenFlg;
	}

	public String getOverLimitIndicator() {
		return overLimitIndicator;
	}

	public void setOverLimitIndicator(String overLimitIndicator) {
		this.overLimitIndicator = overLimitIndicator;
	}

	public String getSkipPymtIndicator() {
		return skipPymtIndicator;
	}

	public void setSkipPymtIndicator(String skipPymtIndicator) {
		this.skipPymtIndicator = skipPymtIndicator;
	}

	public String getAmortizationAccertionIndicator() {
		return amortizationAccertionIndicator;
	}

	public void setAmortizationAccertionIndicator(
			String amortizationAccertionIndicator) {
		this.amortizationAccertionIndicator = amortizationAccertionIndicator;
	}

	public String getSecuritizedIndicator() {
		return securitizedIndicator;
	}

	public void setSecuritizedIndicator(String securitizedIndicator) {
		this.securitizedIndicator = securitizedIndicator;
	}

	public Integer getModfRetentOrLossMitgTypeId() {
		return modfRetentOrLossMitgTypeId;
	}

	public void setModfRetentOrLossMitgTypeId(Integer modfRetentOrLossMitgTypeId) {
		this.modfRetentOrLossMitgTypeId = modfRetentOrLossMitgTypeId;
	}

	public String getRegOEmpFlg() {
		return regOEmpFlg;
	}

	public void setRegOEmpFlg(String regOEmpFlg) {
		this.regOEmpFlg = regOEmpFlg;
	}

	public Integer getTrppTenor() {
		return trppTenor;
	}

	public void setTrppTenor(Integer trppTenor) {
		this.trppTenor = trppTenor;
	}

	public Double getAcctTrppInstAmt() {
		return acctTrppInstAmt;
	}

	public void setAcctTrppInstAmt(Double acctTrppInstAmt) {
		this.acctTrppInstAmt = acctTrppInstAmt;
	}

	public String getLineOfCrdAtmExtFlg() {
		return lineOfCrdAtmExtFlg;
	}

	public void setLineOfCrdAtmExtFlg(String lineOfCrdAtmExtFlg) {
		this.lineOfCrdAtmExtFlg = lineOfCrdAtmExtFlg;
	}

	public String getLineOfCrdLoanConvFlg() {
		return lineOfCrdLoanConvFlg;
	}

	public void setLineOfCrdLoanConvFlg(String lineOfCrdLoanConvFlg) {
		this.lineOfCrdLoanConvFlg = lineOfCrdLoanConvFlg;
	}

	public Integer getIncomeDocTypeId() {
		return incomeDocTypeId;
	}

	public void setIncomeDocTypeId(Integer incomeDocTypeId) {
		this.incomeDocTypeId = incomeDocTypeId;
	}

	public String getCrdDeviationIndicator() {
		return crdDeviationIndicator;
	}

	public void setCrdDeviationIndicator(String crdDeviationIndicator) {
		this.crdDeviationIndicator = crdDeviationIndicator;
	}

	public Integer getPymtTotalNumber() {
		return pymtTotalNumber;
	}

	public void setPymtTotalNumber(Integer pymtTotalNumber) {
		this.pymtTotalNumber = pymtTotalNumber;
	}

	public Integer getRemainingPymtNumbr() {
		return remainingPymtNumbr;
	}

	public void setRemainingPymtNumbr(Integer remainingPymtNumbr) {
		this.remainingPymtNumbr = remainingPymtNumbr;
	}

	public String getPreComputedLoanFlg() {
		return preComputedLoanFlg;
	}

	public void setPreComputedLoanFlg(String preComputedLoanFlg) {
		this.preComputedLoanFlg = preComputedLoanFlg;
	}

	public String getDiscountPremLoanTypeId() {
		return discountPremLoanTypeId;
	}

	public void setDiscountPremLoanTypeId(String discountPremLoanTypeId) {
		this.discountPremLoanTypeId = discountPremLoanTypeId;
	}

	public String getPpInternalRefNumbr() {
		return ppInternalRefNumbr;
	}

	public void setPpInternalRefNumbr(String ppInternalRefNumbr) {
		this.ppInternalRefNumbr = ppInternalRefNumbr;
	}

	public String getUpstreamSysReference() {
		return upstreamSysReference;
	}

	public void setUpstreamSysReference(String upstreamSysReference) {
		this.upstreamSysReference = upstreamSysReference;
	}

	public String getCustomerTradeRefernce() {
		return customerTradeRefernce;
	}

	public void setCustomerTradeRefernce(String customerTradeRefernce) {
		this.customerTradeRefernce = customerTradeRefernce;
	}

	public String geteArrngPurposeTypeId1() {
		return eArrngPurposeTypeId1;
	}

	public void setEArrngPurposeTypeId1(String eArrngPurposeTypeId1) {
		this.eArrngPurposeTypeId1 = eArrngPurposeTypeId1;
	}

	public String getArrngPurposeTypeId2() {
		return arrngPurposeTypeId2;
	}

	public void setArrngPurposeTypeId2(String arrngPurposeTypeId2) {
		this.arrngPurposeTypeId2 = arrngPurposeTypeId2;
	}

	public String getArrngPurposeTypeId3() {
		return arrngPurposeTypeId3;
	}

	public void setArrngPurposeTypeId3(String arrngPurposeTypeId3) {
		this.arrngPurposeTypeId3 = arrngPurposeTypeId3;
	}

	public Double getPenaltyRate() {
		return penaltyRate;
	}

	public void setPenaltyRate(Double penaltyRate) {
		this.penaltyRate = penaltyRate;
	}

	public Double getPenaltyAmt() {
		return penaltyAmt;
	}

	public void setPenaltyAmt(Double penaltyAmt) {
		this.penaltyAmt = penaltyAmt;
	}

	public Integer getLegalNotificationDays() {
		return legalNotificationDays;
	}

	public void setLegalNotificationDays(Integer legalNotificationDays) {
		this.legalNotificationDays = legalNotificationDays;
	}

	public Date getArrngNextPymtDueToBankDate() {
		return arrngNextPymtDueToBankDate;
	}

	public void setArrngNextPymtDueToBankDate(Date arrngNextPymtDueToBankDate) {
		this.arrngNextPymtDueToBankDate = arrngNextPymtDueToBankDate;
	}

	public Double getArrngNextPymtDueToBankAmt() {
		return arrngNextPymtDueToBankAmt;
	}

	public void setArrngNextPymtDueToBankAmt(Double arrngNextPymtDueToBankAmt) {
		this.arrngNextPymtDueToBankAmt = arrngNextPymtDueToBankAmt;
	}

	public Date getArrngLastPymtDueToBankDate() {
		return arrngLastPymtDueToBankDate;
	}

	public void setArrngLastPymtDueToBankDate(Date arrngLastPymtDueToBankDate) {
		this.arrngLastPymtDueToBankDate = arrngLastPymtDueToBankDate;
	}

	public Double getArrngLastPymtDueToBankAmt() {
		return arrngLastPymtDueToBankAmt;
	}

	public void setArrngLastPymtDueToBankAmt(Double arrngLastPymtDueToBankAmt) {
		this.arrngLastPymtDueToBankAmt = arrngLastPymtDueToBankAmt;
	}

	public Date getAcctFirstAdvnceDate() {
		return acctFirstAdvnceDate;
	}

	public void setAcctFirstAdvnceDate(Date acctFirstAdvnceDate) {
		this.acctFirstAdvnceDate = acctFirstAdvnceDate;
	}

	public Double getAcctFirstAdvanceAmt() {
		return acctFirstAdvanceAmt;
	}

	public void setAcctFirstAdvanceAmt(Double acctFirstAdvanceAmt) {
		this.acctFirstAdvanceAmt = acctFirstAdvanceAmt;
	}

	public Date getAcctFirstPymtDate() {
		return acctFirstPymtDate;
	}

	public void setAcctFirstPymtDate(Date acctFirstPymtDate) {
		this.acctFirstPymtDate = acctFirstPymtDate;
	}

	public Double getAcctFirstPymtAmt() {
		return acctFirstPymtAmt;
	}

	public void setAcctFirstPymtAmt(Double acctFirstPymtAmt) {
		this.acctFirstPymtAmt = acctFirstPymtAmt;
	}

	public Date getAcctLastAdvanceDate() {
		return acctLastAdvanceDate;
	}

	public void setAcctLastAdvanceDate(Date acctLastAdvanceDate) {
		this.acctLastAdvanceDate = acctLastAdvanceDate;
	}

	public Double getAcctLastAdvanceAmt() {
		return acctLastAdvanceAmt;
	}

	public void setAcctLastAdvanceAmt(Double acctLastAdvanceAmt) {
		this.acctLastAdvanceAmt = acctLastAdvanceAmt;
	}

	public Integer getMissedPymtNumbr() {
		return missedPymtNumbr;
	}

	public void setMissedPymtNumbr(Integer missedPymtNumbr) {
		this.missedPymtNumbr = missedPymtNumbr;
	}

	public Date getAcctLastRecoveryDate() {
		return acctLastRecoveryDate;
	}

	public void setAcctLastRecoveryDate(Date acctLastRecoveryDate) {
		this.acctLastRecoveryDate = acctLastRecoveryDate;
	}

	public Date getAcctLastInstallDate() {
		return acctLastInstallDate;
	}

	public void setAcctLastInstallDate(Date acctLastInstallDate) {
		this.acctLastInstallDate = acctLastInstallDate;
	}

	public Double getTotalPymts() {
		return totalPymts;
	}

	public void setTotalPymts(Double totalPymts) {
		this.totalPymts = totalPymts;
	}

	public Date getAcctLastIntrReviewDate() {
		return acctLastIntrReviewDate;
	}

	public void setAcctLastIntrReviewDate(Date acctLastIntrReviewDate) {
		this.acctLastIntrReviewDate = acctLastIntrReviewDate;
	}

	public Date getLastIntrCollectionDate() {
		return lastIntrCollectionDate;
	}

	public void setLastIntrCollectionDate(Date lastIntrCollectionDate) {
		this.lastIntrCollectionDate = lastIntrCollectionDate;
	}

	public String geteDelq30DayPst2YrsFlg() {
		return eDelq30DayPst2YrsFlg;
	}

	public void setEDelq30DayPst2YrsFlg(String eDelq30DayPst2YrsFlg) {
		this.eDelq30DayPst2YrsFlg = eDelq30DayPst2YrsFlg;
	}

	public Integer geteArrngSecureTypeId() {
		return eArrngSecureTypeId;
	}

	public void setEArrngSecureTypeId(Integer eArrngSecureTypeId) {
		this.eArrngSecureTypeId = eArrngSecureTypeId;
	}

	public Integer getLienPositionTypeId() {
		return lienPositionTypeId;
	}

	public void setLienPositionTypeId(Integer lienPositionTypeId) {
		this.lienPositionTypeId = lienPositionTypeId;
	}

	public Double getProbabilityOfDefault() {
		return probabilityOfDefault;
	}

	public void setProbabilityOfDefault(Double probabilityOfDefault) {
		this.probabilityOfDefault = probabilityOfDefault;
	}

	public String getOtherAltId() {
		return otherAltId;
	}

	public void setOtherAltId(String otherAltId) {
		this.otherAltId = otherAltId;
	}

	public Integer geteFacLegalStstTypeId() {
		return eFacLegalStstTypeId;
	}

	public void setEFacLegalStstTypeId(Integer eFacLegalStstTypeId) {
		this.eFacLegalStstTypeId = eFacLegalStstTypeId;
	}

	public Date getFacilityLegalStsDate() {
		return facilityLegalStsDate;
	}

	public void setFacilityLegalStsDate(Date facilityLegalStsDate) {
		this.facilityLegalStsDate = facilityLegalStsDate;
	}

	public Integer geteCredFacArrngApprvTypeId() {
		return eCredFacArrngApprvTypeId;
	}

	public void setECredFacArrngApprvTypeId(Integer eCredFacArrngApprvTypeId) {
		this.eCredFacArrngApprvTypeId = eCredFacArrngApprvTypeId;
	}

	public Date getCredFacArrngApprvDate() {
		return credFacArrngApprvDate;
	}

	public void setCredFacArrngApprvDate(Date credFacArrngApprvDate) {
		this.credFacArrngApprvDate = credFacArrngApprvDate;
	}

	public Integer getCredFacRegSegTypeId() {
		return credFacRegSegTypeId;
	}

	public void setCredFacRegSegTypeId(Integer credFacRegSegTypeId) {
		this.credFacRegSegTypeId = credFacRegSegTypeId;
	}

	public Integer getCredFacAvailStsTypeId() {
		return credFacAvailStsTypeId;
	}

	public void setCredFacAvailStsTypeId(Integer credFacAvailStsTypeId) {
		this.credFacAvailStsTypeId = credFacAvailStsTypeId;
	}

	public BigDecimal getOriginalAdvisedCommitLimit() {
		return originalAdvisedCommitLimit;
	}

	public void setOriginalAdvisedCommitLimit(Double originalAdvisedCommitLimit) {
		if(originalAdvisedCommitLimit == null){
			this.originalAdvisedCommitLimit = null;
		}else if(originalAdvisedCommitLimit == 0){
			this.originalAdvisedCommitLimit = new BigDecimal(0);
		}else{
			this.originalAdvisedCommitLimit = new BigDecimal(originalAdvisedCommitLimit).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}

	public BigDecimal getOriginalAdvisedUncommittedLimit() {
		return originalAdvisedUncommittedLimit;
	}

	public void setOriginalAdvisedUncommittedLimit(
			Double originalAdvisedUncommittedLimit) {
		if(originalAdvisedUncommittedLimit == null){
			this.originalAdvisedUncommittedLimit = null;
		}else if(originalAdvisedUncommittedLimit == 0){
			this.originalAdvisedUncommittedLimit = new BigDecimal(0);
		}else{
			this.originalAdvisedUncommittedLimit = new BigDecimal(originalAdvisedUncommittedLimit).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}

	public Double getOriginalUnadvisedUncommitLimit() {
		return originalUnadvisedUncommitLimit;
	}

	public void setOriginalUnadvisedUncommitLimit(
			Double originalUnadvisedUncommitLimit) {
		this.originalUnadvisedUncommitLimit = originalUnadvisedUncommitLimit;
	}

	public Date getLastCreditLimitChangeDate() {
		return lastCreditLimitChangeDate;
	}

	public void setLastCreditLimitChangeDate(Date lastCreditLimitChangeDate) {
		this.lastCreditLimitChangeDate = lastCreditLimitChangeDate;
	}

	public Integer getCredLimitChangeTypeId() {
		return credLimitChangeTypeId;
	}

	public void setCredLimitChangeTypeId(Integer credLimitChangeTypeId) {
		this.credLimitChangeTypeId = credLimitChangeTypeId;
	}

	public Date getCredLimitEffectiveDate() {
		return credLimitEffectiveDate;
	}

	public void setCredLimitEffectiveDate(Date credLimitEffectiveDate) {
		this.credLimitEffectiveDate = credLimitEffectiveDate;
	}

	public Date getCredLimitEndDate() {
		return credLimitEndDate;
	}

	public void setCredLimitEndDate(Date credLimitEndDate) {
		this.credLimitEndDate = credLimitEndDate;
	}

	public String geteCredLimitEvtIntTypeId() {
		return eCredLimitEvtIntTypeId;
	}

	public void setECredLimitEvtIntTypeId(String eCredLimitEvtIntTypeId) {
		this.eCredLimitEvtIntTypeId = eCredLimitEvtIntTypeId;
	}

	public Double getCredLimitEventAmt() {
		return credLimitEventAmt;
	}

	public void setCredLimitEventAmt(Double credLimitEventAmt) {
		this.credLimitEventAmt = credLimitEventAmt;
	}

	public String geteCcarProdCode() {
		return eCcarProdCode;
	}

	public void setECcarProdCode(String eCcarProdCode) {
		this.eCcarProdCode = eCcarProdCode;
	}

	public Date getBankruptcyCode() {
		return bankruptcyCode;
	}

	public void setBankruptcyCode(Date bankruptcyCode) {
		this.bankruptcyCode = bankruptcyCode;
	}

	public String getPromoIntrRateEligibleFlg() {
		return promoIntrRateEligibleFlg;
	}

	public void setPromoIntrRateEligibleFlg(String promoIntrRateEligibleFlg) {
		this.promoIntrRateEligibleFlg = promoIntrRateEligibleFlg;
	}

	public String getPmacPortfolioId() {
		return pmacPortfolioId;
	}

	public void setPmacPortfolioId(String pmacPortfolioId) {
		this.pmacPortfolioId = pmacPortfolioId;
	}

	public String geteOrigAcctNumb() {
		return eOrigAcctNumb;
	}

	public void setEOrigAcctNumb(String eOrigAcctNumb) {
		this.eOrigAcctNumb = eOrigAcctNumb;
	}

	public Date getLastWriteDownDate() {
		return lastWriteDownDate;
	}

	public void setLastWriteDownDate(Date lastWriteDownDate) {
		this.lastWriteDownDate = lastWriteDownDate;
	}

	public String getCurrentlyNegativeAmortizeFlg() {
		return currentlyNegativeAmortizeFlg;
	}

	public void setCurrentlyNegativeAmortizeFlg(
			String currentlyNegativeAmortizeFlg) {
		this.currentlyNegativeAmortizeFlg = currentlyNegativeAmortizeFlg;
	}

	public String getPrincipalDeferralOptionFlg() {
		return principalDeferralOptionFlg;
	}

	public void setPrincipalDeferralOptionFlg(String principalDeferralOptionFlg) {
		this.principalDeferralOptionFlg = principalDeferralOptionFlg;
	}

	public Date getPrincipalDefrralOptionEndDate() {
		return principalDefrralOptionEndDate;
	}

	public void setPrincipalDefrralOptionEndDate(
			Date principalDefrralOptionEndDate) {
		this.principalDefrralOptionEndDate = principalDefrralOptionEndDate;
	}

	public String getIntrDeferralOptionFlg() {
		return intrDeferralOptionFlg;
	}

	public void setIntrDeferralOptionFlg(String intrDeferralOptionFlg) {
		this.intrDeferralOptionFlg = intrDeferralOptionFlg;
	}

	public Date getIntrDeferralOptionEndDate() {
		return intrDeferralOptionEndDate;
	}

	public void setIntrDeferralOptionEndDate(Date intrDeferralOptionEndDate) {
		this.intrDeferralOptionEndDate = intrDeferralOptionEndDate;
	}

	public Date getIntrOnlyOptionEndDate() {
		return intrOnlyOptionEndDate;
	}

	public void setIntrOnlyOptionEndDate(Date intrOnlyOptionEndDate) {
		this.intrOnlyOptionEndDate = intrOnlyOptionEndDate;
	}

	public String geteEverWrittenOffFlg() {
		return eEverWrittenOffFlg;
	}

	public void setEEverWrittenOffFlg(String eEverWrittenOffFlg) {
		this.eEverWrittenOffFlg = eEverWrittenOffFlg;
	}

	public String getAcctFundsAdvancedCompleteFlg() {
		return acctFundsAdvancedCompleteFlg;
	}

	public void setAcctFundsAdvancedCompleteFlg(
			String acctFundsAdvancedCompleteFlg) {
		this.acctFundsAdvancedCompleteFlg = acctFundsAdvancedCompleteFlg;
	}

	public Double getTotFundsDisbursedAmt() {
		return totFundsDisbursedAmt;
	}

	public void setTotFundsDisbursedAmt(Double totFundsDisbursedAmt) {
		this.totFundsDisbursedAmt = totFundsDisbursedAmt;
	}

	public Integer getMonthsOnBooksLocal() {
		return monthsOnBooksLocal;
	}

	public void setMonthsOnBooksLocal(Integer monthsOnBooksLocal) {
		this.monthsOnBooksLocal = monthsOnBooksLocal;
	}

	public String geteRiskMgmtInd() {
		return eRiskMgmtInd;
	}

	public void setERiskMgmtInd(String eRiskMgmtInd) {
		this.eRiskMgmtInd = eRiskMgmtInd;
	}

	public Integer getDaysPastDueCycleEnd() {
		return daysPastDueCycleEnd;
	}

	public void setDaysPastDueCycleEnd(Integer daysPastDueCycleEnd) {
		this.daysPastDueCycleEnd = daysPastDueCycleEnd;
	}

	public Integer getDelinqBucket() {
		return delinqBucket;
	}

	public void setDelinqBucket(Integer delinqBucket) {
		this.delinqBucket = delinqBucket;
	}

	public Integer getCycleEndDelinqBucket() {
		return cycleEndDelinqBucket;
	}

	public void setCycleEndDelinqBucket(Integer cycleEndDelinqBucket) {
		this.cycleEndDelinqBucket = cycleEndDelinqBucket;
	}

	public String getReservedForFutureGenesisUsage1() {
		return reservedForFutureGenesisUsage1;
	}

	public void setReservedForFutureGenesisUsage1(
			String reservedForFutureGenesisUsage1) {
		this.reservedForFutureGenesisUsage1 = reservedForFutureGenesisUsage1;
	}

	public String getReservedForFutureGenesisUsage2() {
		return reservedForFutureGenesisUsage2;
	}

	public void setReservedForFutureGenesisUsage2(
			String reservedForFutureGenesisUsage2) {
		this.reservedForFutureGenesisUsage2 = reservedForFutureGenesisUsage2;
	}

	public String getReservedForFutureGenesisUsage3() {
		return reservedForFutureGenesisUsage3;
	}

	public void setReservedForFutureGenesisUsage3(
			String reservedForFutureGenesisUsage3) {
		this.reservedForFutureGenesisUsage3 = reservedForFutureGenesisUsage3;
	}

	public String getReservedForFutureGenesisUsage4() {
		return reservedForFutureGenesisUsage4;
	}

	public void setReservedForFutureGenesisUsage4(
			String reservedForFutureGenesisUsage4) {
		this.reservedForFutureGenesisUsage4 = reservedForFutureGenesisUsage4;
	}

	public String getReservedForFutureGenesisUsage5() {
		return reservedForFutureGenesisUsage5;
	}

	public void setReservedForFutureGenesisUsage5(
			String reservedForFutureGenesisUsage5) {
		this.reservedForFutureGenesisUsage5 = reservedForFutureGenesisUsage5;
	}

	public String getReservedForFutureGenesisUsage6() {
		return reservedForFutureGenesisUsage6;
	}

	public void setReservedForFutureGenesisUsage6(
			String reservedForFutureGenesisUsage6) {
		this.reservedForFutureGenesisUsage6 = reservedForFutureGenesisUsage6;
	}

	public String getReservedForFutureGenesisUsage7() {
		return reservedForFutureGenesisUsage7;
	}

	public void setReservedForFutureGenesisUsage7(
			String reservedForFutureGenesisUsage7) {
		this.reservedForFutureGenesisUsage7 = reservedForFutureGenesisUsage7;
	}

	public String getReservedForFutureGenesisUsage8() {
		return reservedForFutureGenesisUsage8;
	}

	public void setReservedForFutureGenesisUsage8(
			String reservedForFutureGenesisUsage8) {
		this.reservedForFutureGenesisUsage8 = reservedForFutureGenesisUsage8;
	}

	public String getReservedForFutureGenesisUsage9() {
		return reservedForFutureGenesisUsage9;
	}

	public void setReservedForFutureGenesisUsage9(
			String reservedForFutureGenesisUsage9) {
		this.reservedForFutureGenesisUsage9 = reservedForFutureGenesisUsage9;
	}

	public String getReservedForFutureGenesisUsage10() {
		return reservedForFutureGenesisUsage10;
	}

	public void setReservedForFutureGenesisUsage10(
			String reservedForFutureGenesisUsage10) {
		this.reservedForFutureGenesisUsage10 = reservedForFutureGenesisUsage10;
	}

	public String getReservedForFutureGenesisUsage11() {
		return reservedForFutureGenesisUsage11;
	}

	public void setReservedForFutureGenesisUsage11(
			String reservedForFutureGenesisUsage11) {
		this.reservedForFutureGenesisUsage11 = reservedForFutureGenesisUsage11;
	}

	public String getReservedForFutureGenesisUsage12() {
		return reservedForFutureGenesisUsage12;
	}

	public void setReservedForFutureGenesisUsage12(
			String reservedForFutureGenesisUsage12) {
		this.reservedForFutureGenesisUsage12 = reservedForFutureGenesisUsage12;
	}

	public String getReservedForFutureGenesisUsage13() {
		return reservedForFutureGenesisUsage13;
	}

	public void setReservedForFutureGenesisUsage13(
			String reservedForFutureGenesisUsage13) {
		this.reservedForFutureGenesisUsage13 = reservedForFutureGenesisUsage13;
	}

	public String getReservedForFutureGenesisUsage14() {
		return reservedForFutureGenesisUsage14;
	}

	public void setReservedForFutureGenesisUsage14(
			String reservedForFutureGenesisUsage14) {
		this.reservedForFutureGenesisUsage14 = reservedForFutureGenesisUsage14;
	}

	public String getReservedForFutureGenesisUsage15() {
		return reservedForFutureGenesisUsage15;
	}

	public void setReservedForFutureGenesisUsage15(
			String reservedForFutureGenesisUsage15) {
		this.reservedForFutureGenesisUsage15 = reservedForFutureGenesisUsage15;
	}

	public String getReservedForFutureGenesisUsage16() {
		return reservedForFutureGenesisUsage16;
	}

	public void setReservedForFutureGenesisUsage16(
			String reservedForFutureGenesisUsage16) {
		this.reservedForFutureGenesisUsage16 = reservedForFutureGenesisUsage16;
	}

	public String getReservedForFutureGenesisUsage17() {
		return reservedForFutureGenesisUsage17;
	}

	public void setReservedForFutureGenesisUsage17(
			String reservedForFutureGenesisUsage17) {
		this.reservedForFutureGenesisUsage17 = reservedForFutureGenesisUsage17;
	}

	public String getReservedForFutureGenesisUsage18() {
		return reservedForFutureGenesisUsage18;
	}

	public void setReservedForFutureGenesisUsage18(
			String reservedForFutureGenesisUsage18) {
		this.reservedForFutureGenesisUsage18 = reservedForFutureGenesisUsage18;
	}

	public String getReservedForFutureGenesisUsage19() {
		return reservedForFutureGenesisUsage19;
	}

	public void setReservedForFutureGenesisUsage19(
			String reservedForFutureGenesisUsage19) {
		this.reservedForFutureGenesisUsage19 = reservedForFutureGenesisUsage19;
	}

	public String geteUniqIdSrsInvPty() {
		return eUniqIdSrsInvPty;
	}

	public void setEUniqIdSrsInvPty(String eUniqIdSrsInvPty) {
		this.eUniqIdSrsInvPty = eUniqIdSrsInvPty;
	}

	public String geteArrngInvlvPtyRoleType() {
		return eArrngInvlvPtyRoleType;
	}

	public void setEArrngInvlvPtyRoleType(String eArrngInvlvPtyRoleType) {
		this.eArrngInvlvPtyRoleType = eArrngInvlvPtyRoleType;
	}

	public BigDecimal getePercentAmt() {
		return ePercentAmt;
	}

	public void setEPercentAmt(Double ePercentAmt) {
		this.ePercentAmt = new BigDecimal(ePercentAmt).setScale(2,BigDecimal.ROUND_HALF_UP);

	}

	public String geteInvlvPtySubTypeId() {
		return eInvlvPtySubTypeId;
	}

	public void setEInvlvPtySubTypeId(String eInvlvPtySubTypeId) {
		this.eInvlvPtySubTypeId = eInvlvPtySubTypeId;
	}

	public String geteRatingIssuerId() {
		return eRatingIssuerId;
	}

	public void setERatingIssuerId(String eRatingIssuerId) {
		this.eRatingIssuerId = eRatingIssuerId;
	}

	public String geteModelCode() {
		return eModelCode;
	}

	public void setEModelCode(String eModelCode) {
		this.eModelCode = eModelCode;
	}

	public Integer geteRatingEventRsnTypeId() {
		return eRatingEventRsnTypeId;
	}

	public void setERatingEventRsnTypeId(Integer eRatingEventRsnTypeId) {
		this.eRatingEventRsnTypeId = eRatingEventRsnTypeId;
	}

	public Integer geteRank() {
		return eRank;
	}

	public void setERank(Integer eRank) {
		this.eRank = eRank;
	}

	public String geteRatingTypeCode() {
		return eRatingTypeCode;
	}

	public void setERatingTypeCode(String eRatingTypeCode) {
		this.eRatingTypeCode = eRatingTypeCode;
	}

	public String geteRatingCode() {
		return eRatingCode;
	}

	public void setERatingCode(String eRatingCode) {
		this.eRatingCode = eRatingCode;
	}

	public String geteFicoEquiRatingCode() {
		return eFicoEquiRatingCode;
	}

	public void setEFicoEquiRatingCode(String eFicoEquiRatingCode) {
		this.eFicoEquiRatingCode = eFicoEquiRatingCode;
	}

	public String geteRaingDescription() {
		return eRaingDescription;
	}

	public void setERaingDescription(String eRaingDescription) {
		this.eRaingDescription = eRaingDescription;
	}

	public String geteScoreRqstReturnFlg() {
		return eScoreRqstReturnFlg;
	}

	public void setEScoreRqstReturnFlg(String eScoreRqstReturnFlg) {
		this.eScoreRqstReturnFlg = eScoreRqstReturnFlg;
	}

	public String geteModelCodeAIR() {
		return eModelCodeAIR;
	}

	public void setEModelCodeAIR(String eModelCodeAIR) {
		this.eModelCodeAIR = eModelCodeAIR;
	}

	public Integer geteResouceItemTypeId() {
		return eResouceItemTypeId;
	}

	public void setEResouceItemTypeId(Integer eResouceItemTypeId) {
		this.eResouceItemTypeId = eResouceItemTypeId;
	}

	public String getPrimaryCollateralIndicator() {
		return primaryCollateralIndicator;
	}

	public void setPrimaryCollateralIndicator(String primaryCollateralIndicator) {
		this.primaryCollateralIndicator = primaryCollateralIndicator;
	}

	public Integer getRevaluationCollateralInd() {
		return revaluationCollateralInd;
	}

	public void setRevaluationCollateralInd(Integer revaluationCollateralInd) {
		this.revaluationCollateralInd = revaluationCollateralInd;
	}

	public String getResourceItemName() {
		return resourceItemName;
	}

	public void setResourceItemName(String resourceItemName) {
		this.resourceItemName = resourceItemName;
	}

	public Integer getSrcSysId() {
		return srcSysId;
	}

	public void setSrcSysId(Integer srcSysId) {
		this.srcSysId = srcSysId;
	}

	public Double getResourceItemValAmt() {
		return resourceItemValAmt;
	}

	public void setResourceItemValAmt(Double resourceItemValAmt) {
		this.resourceItemValAmt = resourceItemValAmt;
	}

	public Integer geteResourceItemValMethId() {
		return eResourceItemValMethId;
	}

	public void setEResourceItemValMethId(Integer eResourceItemValMethId) {
		this.eResourceItemValMethId = eResourceItemValMethId;
	}

	public Date geteResourceItemValEffDate() {
		return eResourceItemValEffDate;
	}

	public void setEResourceItemValEffDate(Date eResourceItemValEffDate) {
		this.eResourceItemValEffDate = eResourceItemValEffDate;
	}

	public Integer geteResItemBalCurrId() {
		return eResItemBalCurrId;
	}

	public void setEResItemBalCurrId(Integer eResItemBalCurrId) {
		this.eResItemBalCurrId = eResItemBalCurrId;
	}

	public Integer geteResItemBalTypeId() {
		return eResItemBalTypeId;
	}

	public void setEResItemBalTypeId(Integer eResItemBalTypeId) {
		this.eResItemBalTypeId = eResItemBalTypeId;
	}

	public Integer getResItemValuationEvntReasonTypeId() {
		return resItemValuationEvntReasonTypeId;
	}

	public void setResItemValuationEvntReasonTypeId(
			Integer resItemValuationEvntReasonTypeId) {
		this.resItemValuationEvntReasonTypeId = resItemValuationEvntReasonTypeId;
	}

	public Integer geteLoanToAstRelType() {
		return eLoanToAstRelType;
	}

	public void setELoanToAstRelType(Integer eLoanToAstRelType) {
		this.eLoanToAstRelType = eLoanToAstRelType;
	}

	public Date geteReltnEffDate() {
		return eReltnEffDate;
	}

	public void setEReltnEffDate(Date eReltnEffDate) {
		this.eReltnEffDate = eReltnEffDate;
	}

	public Integer getCollateralTypeId() {
		return collateralTypeId;
	}

	public void setCollateralTypeId(Integer collateralTypeId) {
		this.collateralTypeId = collateralTypeId;
	}

	public String geteStndrdArrgId() {
		return eStndrdArrgId;
	}

	public void setEStndrdArrgId(String eStndrdArrgId) {
		this.eStndrdArrgId = eStndrdArrgId;
	}

	public Integer geteCreditRiskMitgTypeId() {
		return eCreditRiskMitgTypeId;
	}

	public void setECreditRiskMitgTypeId(Integer eCreditRiskMitgTypeId) {
		this.eCreditRiskMitgTypeId = eCreditRiskMitgTypeId;
	}

	public Integer getCollateralSrcTypeId() {
		return collateralSrcTypeId;
	}

	public void setCollateralSrcTypeId(Integer collateralSrcTypeId) {
		this.collateralSrcTypeId = collateralSrcTypeId;
	}

	public String getLegalEnforcablityFlg() {
		return legalEnforcablityFlg;
	}

	public void setLegalEnforcablityFlg(String legalEnforcablityFlg) {
		this.legalEnforcablityFlg = legalEnforcablityFlg;
	}

	public String getLegalRightToPosFlg() {
		return legalRightToPosFlg;
	}

	public void setLegalRightToPosFlg(String legalRightToPosFlg) {
		this.legalRightToPosFlg = legalRightToPosFlg;
	}

	public String getReHypotheInd() {
		return reHypotheInd;
	}

	public void setReHypotheInd(String reHypotheInd) {
		this.reHypotheInd = reHypotheInd;
	}

	public Integer getCollateralLocCode() {
		return collateralLocCode;
	}

	public void setCollateralLocCode(Integer collateralLocCode) {
		this.collateralLocCode = collateralLocCode;
	}

	public String getIntMarginOrValMargFlg() {
		return intMarginOrValMargFlg;
	}

	public void setIntMarginOrValMargFlg(String intMarginOrValMargFlg) {
		this.intMarginOrValMargFlg = intMarginOrValMargFlg;
	}

	public Integer getLegNumbr() {
		return legNumbr;
	}

	public void setLegNumbr(Integer legNumbr) {
		this.legNumbr = legNumbr;
	}

	public String getGeneralLdgerSysId() {
		return generalLdgerSysId;
	}

	public void setGeneralLdgerSysId(String generalLdgerSysId) {
		this.generalLdgerSysId = generalLdgerSysId;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String geteBookingLedgerCountryCode() {
		return eBookingLedgerCountryCode;
	}

	public void setEBookingLedgerCountryCode(String eBookingLedgerCountryCode) {
		this.eBookingLedgerCountryCode = eBookingLedgerCountryCode;
	}

	public Integer geteBalType() {
		return eBalType;
	}

	public void setEBalType(Integer eBalType) {
		this.eBalType = eBalType;
	}

	public String geteGLAccount1() {
		return eGLAccount1;
	}

	public void setEGLAccount1(String eGLAccount1) {
		this.eGLAccount1 = eGLAccount1;
	}

	public String getGlAccount2() {
		return glAccount2;
	}

	public void setGlAccount2(String glAccount2) {
		this.glAccount2 = glAccount2;
	}

	public String getFdlAccount() {
		return fdlAccount;
	}

	public void setFdlAccount(String fdlAccount) {
		this.fdlAccount = fdlAccount;
	}

	public String geteTransCurrCode() {
		return eTransCurrCode;
	}

	public void setETransCurrCode(String eTransCurrCode) {
		this.eTransCurrCode = eTransCurrCode;
	}

	public String geteFuncCurrCode() {
		return eFuncCurrCode;
	}

	public void setEFuncCurrCode(String eFuncCurrCode) {
		this.eFuncCurrCode = eFuncCurrCode;
	}

	public String geteBaseCurrCode() {
		return eBaseCurrCode;
	}

	public void setEBaseCurrCode(String eBaseCurrCode) {
		this.eBaseCurrCode = eBaseCurrCode;
	}

	public Double geteTransAmt() {
		return eTransAmt;
	}

	public void setETransAmt(Double eTransAmt) {
		this.eTransAmt = eTransAmt;
	}

	public BigDecimal getFunctionalAmt() {
		return functionalAmt;
	}

	public void setFunctionalAmt(Double functionalAmt) {
		this.functionalAmt = new BigDecimal(functionalAmt).setScale(5,BigDecimal.ROUND_HALF_UP);
	}

	public Double getBaseAmt() {
		return baseAmt;
	}

	public void setBaseAmt(Double baseAmt) {
		this.baseAmt = baseAmt;
	}

	public String getGoc() {
		return goc;
	}

	public void setGoc(String goc) {
		this.goc = goc;
	}

	public String getBookingLedgerBranchCode() {
		return bookingLedgerBranchCode;
	}

	public void setBookingLedgerBranchCode(String bookingLedgerBranchCode) {
		this.bookingLedgerBranchCode = bookingLedgerBranchCode;
	}

	public String getFrsBusUnitCode() {
		return frsBusUnitCode;
	}

	public void setFrsBusUnitCode(String frsBusUnitCode) {
		this.frsBusUnitCode = frsBusUnitCode;
	}

	public String getNotForUse() {
		return notForUse;
	}

	public void setNotForUse(String notForUse) {
		this.notForUse = notForUse;
	}

	public String getLocalDeptId() {
		return localDeptId;
	}

	public void setLocalDeptId(String localDeptId) {
		this.localDeptId = localDeptId;
	}

	public String geteLocalLegVehicleId() {
		return eLocalLegVehicleId;
	}

	public void setELocalLegVehicleId(String eLocalLegVehicleId) {
		this.eLocalLegVehicleId = eLocalLegVehicleId;
	}

	public String getFairValacctMethodFlg() {
		return fairValacctMethodFlg;
	}

	public void setFairValacctMethodFlg(String fairValacctMethodFlg) {
		this.fairValacctMethodFlg = fairValacctMethodFlg;
	}

	public String getFairValLevel() {
		return fairValLevel;
	}

	public void setFairValLevel(String fairValLevel) {
		this.fairValLevel = fairValLevel;
	}

	public String getExpenseCode() {
		return expenseCode;
	}

	public void setExpenseCode(String expenseCode) {
		this.expenseCode = expenseCode;
	}

	public String getFrsAfflCode() {
		return frsAfflCode;
	}

	public void setFrsAfflCode(String frsAfflCode) {
		this.frsAfflCode = frsAfflCode;
	}

	public String getSubStrategyCode() {
		return subStrategyCode;
	}

	public void setSubStrategyCode(String subStrategyCode) {
		this.subStrategyCode = subStrategyCode;
	}

	public String geteGAAPInd() {
		return eGAAPInd;
	}

	public void setEGAAPInd(String eGAAPInd) {
		this.eGAAPInd = eGAAPInd;
	}

	public String getMicroCntStrtCodeOpenField1() {
		return microCntStrtCodeOpenField1;
	}

	public void setMicroCntStrtCodeOpenField1(String microCntStrtCodeOpenField1) {
		this.microCntStrtCodeOpenField1 = microCntStrtCodeOpenField1;
	}

	public String getFirmAcctIMSNumbr() {
		return firmAcctIMSNumbr;
	}

	public void setFirmAcctIMSNumbr(String firmAcctIMSNumbr) {
		this.firmAcctIMSNumbr = firmAcctIMSNumbr;
	}

	public String getBaseNumbLocafflCode() {
		return baseNumbLocafflCode;
	}

	public void setBaseNumbLocafflCode(String baseNumbLocafflCode) {
		this.baseNumbLocafflCode = baseNumbLocafflCode;
	}

	public String getIdProd() {
		return idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public String getKeyCode1() {
		return keyCode1;
	}

	public void setKeyCode1(String keyCode1) {
		this.keyCode1 = keyCode1;
	}

	public String getKeyCode2() {
		return keyCode2;
	}

	public void setKeyCode2(String keyCode2) {
		this.keyCode2 = keyCode2;
	}

	public String getLocLedgerAcctNumb() {
		return locLedgerAcctNumb;
	}

	public void setLocLedgerAcctNumb(String locLedgerAcctNumb) {
		this.locLedgerAcctNumb = locLedgerAcctNumb;
	}

	public String getAdjustmentInd() {
		return adjustmentInd;
	}

	public void setAdjustmentInd(String adjustmentInd) {
		this.adjustmentInd = adjustmentInd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdjustmentReasonCode() {
		return adjustmentReasonCode;
	}

	public void setAdjustmentReasonCode(String adjustmentReasonCode) {
		this.adjustmentReasonCode = adjustmentReasonCode;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLocalGlKey3() {
		return localGlKey3;
	}

	public void setLocalGlKey3(String localGlKey3) {
		this.localGlKey3 = localGlKey3;
	}

	public String getLocalGlKey4() {
		return localGlKey4;
	}

	public void setLocalGlKey4(String localGlKey4) {
		this.localGlKey4 = localGlKey4;
	}

	public String getAdjStrdArrngId() {
		return adjStrdArrngId;
	}

	public void setAdjStrdArrngId(String adjStrdArrngId) {
		this.adjStrdArrngId = adjStrdArrngId;
	}

	/**
	 * @return the eBookingDate
	 */
	public Date geteBookingDate() {
		return eBookingDate;
	}

	/**
	 * @param eBookingDate
	 *            the eBookingDate to set
	 */
	public void setEBookingDate(Date eBookingDate) {
		this.eBookingDate = eBookingDate;
	}

	/**
	 * @return the eArrngBusIntDate
	 */
	public Date geteArrngBusIntDate() {
		return eArrngBusIntDate;
	}

	/**
	 * @param eArrngBusIntDate
	 *            the eArrngBusIntDate to set
	 */
	public void setEArrngBusIntDate(Date eArrngBusIntDate) {
		this.eArrngBusIntDate = eArrngBusIntDate;
	}

	/**
	 * @return the eOrigAmt
	 */
	public BigDecimal geteOrigAmt() {
		return eOrigAmt;
	}

	/**
	 * @param eOrigAmt
	 *            the eOrigAmt to set
	 */
	public void setEOrigAmt(Double eOrigAmt) {
		if(eOrigAmt == null){
			this.eOrigAmt = null;
		}else if(eOrigAmt == 0){
			this.eOrigAmt = new BigDecimal(0);
		}else{
			this.eOrigAmt = new BigDecimal(eOrigAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	}

	/**
	 * @return the localWarehouseReference
	 */
	public String getLocalWarehouseReference() {
		return localWarehouseReference;
	}

	/**
	 * @param localWarehouseReference
	 *            the localWarehouseReference to set
	 */
	public void setLocalWarehouseReference(String localWarehouseReference) {
		this.localWarehouseReference = localWarehouseReference;
	}

	/**
	 * @return the eBaselPortfolioId
	 */
	public String geteBaselPortfolioId() {
		return eBaselPortfolioId;
	}

	/**
	 * @param eBaselPortfolioId
	 *            the eBaselPortfolioId to set
	 */
	public void setEBaselPortfolioId(String eBaselPortfolioId) {
		this.eBaselPortfolioId = eBaselPortfolioId;
	}

	/**
	 * @return the eCreditFacTypeId
	 */
	public Integer geteCreditFacTypeId() {
		return eCreditFacTypeId;
	}

	/**
	 * @param eCreditFacTypeId
	 *            the eCreditFacTypeId to set
	 */
	public void setECreditFacTypeId(Integer eCreditFacTypeId) {
		this.eCreditFacTypeId = eCreditFacTypeId;
	}

	/**
	 * @return the eFeePymtFreqPrdId
	 */
	public Integer geteFeePymtFreqPrdId() {
		return eFeePymtFreqPrdId;
	}

	/**
	 * @param eFeePymtFreqPrdId
	 *            the eFeePymtFreqPrdId to set
	 */
	public void setEFeePymtFreqPrdId(Integer eFeePymtFreqPrdId) {
		this.eFeePymtFreqPrdId = eFeePymtFreqPrdId;
	}

	/**
	 * @return the eArrngAcqDate
	 */
	public Date geteArrngAcqDate() {
		return eArrngAcqDate;
	}

	/**
	 * @param eArrngAcqDate
	 *            the eArrngAcqDate to set
	 */
	public void setEArrngAcqDate(Date eArrngAcqDate) {
		this.eArrngAcqDate = eArrngAcqDate;
	}

	/**
	 * @return the eCommonBalanceRcTRLRecords
	 */
	public List<CommonBalanceRcTRLRecord> geteCommonBalanceRcTRLRecords() {
		return eCommonBalanceRcTRLRecords;
	}

	/**
	 * @param eCommonBalanceRcTRLRecords
	 *            the eCommonBalanceRcTRLRecords to set
	 */
	public void setECommonBalanceRcTRLRecords(
			List<CommonBalanceRcTRLRecord> eCommonBalanceRcTRLRecords) {
		this.eCommonBalanceRcTRLRecords = eCommonBalanceRcTRLRecords;
	}

	/**
	 * @return the eBaseAmtCurr
	 */
	public Double geteBaseAmtCurr() {
		return eBaseAmtCurr;
	}

	/**
	 * @param eBaseAmtCurr
	 *            the eBaseAmtCurr to set
	 */
	public void setEBaseAmtCurr(Double eBaseAmtCurr) {
		this.eBaseAmtCurr = eBaseAmtCurr;
	}	

	public BigDecimal geteEffectiveRatePercent() {
		return eEffectiveRatePercent;
	}

	public void setEEffectiveRatePercent(Double eEffectiveRatePercent) {
		if(eEffectiveRatePercent == null){
			this.eEffectiveRatePercent = null;
		}else if(eEffectiveRatePercent == 0){
			this.eEffectiveRatePercent = new BigDecimal(0);
		}
		else{
				this.eEffectiveRatePercent=new BigDecimal(eEffectiveRatePercent).setScale(8,BigDecimal.ROUND_HALF_UP);
		}
		
		
	}

	public Double getSpeedRatePer() {
		return speedRatePer;
	}

	public void setSpeedRatePer(Double speedRatePer) {
		this.speedRatePer = speedRatePer;
	}

	public Integer getArrngRateTypRelnTypId() {
		return arrngRateTypRelnTypId;
	}

	public void setArrngRateTypRelnTypId(Integer arrngRateTypRelnTypId) {
		this.arrngRateTypRelnTypId = arrngRateTypRelnTypId;
	}

	public String getRateId() {
		return rateId;
	}

	public void setRateId(String rateId) {
		this.rateId = rateId;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public Integer geteRateVarTypeId() {
		return eRateVarTypeId;
	}

	public void setERateVarTypeId(Integer eRateVarTypeId) {
		this.eRateVarTypeId = eRateVarTypeId;
	}

	public String geteRateTypeId() {
		return eRateTypeId;
	}

	public void setERateTypeId(String eRateTypeId) {
		this.eRateTypeId = eRateTypeId;
	}

	public Date getRateTypEffDate() {
		return rateTypEffDate;
	}

	public void setRateTypEffDate(Date rateTypEffDate) {
		this.rateTypEffDate = rateTypEffDate;
	}

	public String geteRateActiveFlag() {
		return eRateActiveFlag;
	}

	public void setERateActiveFlag(String eRateActiveFlag) {
		this.eRateActiveFlag = eRateActiveFlag;
	}

	public Double geteRiRate() {
		return eRiRate;
	}

	public void setERiRate(Double eRiRate) {
		this.eRiRate = eRiRate;
	}

	public Double geteCiRate() {
		return eCiRate;
	}

	public void setECiRate(Double eCiRate) {
		this.eCiRate = eCiRate;
	}

	public Integer geteLossMitgPrgmId() {
		return eLossMitgPrgmId;
	}

	public void setELossMitgPrgmId(Integer eLossMitgPrgmId) {
		this.eLossMitgPrgmId = eLossMitgPrgmId;
	}

	public Integer geteISupTypId() {
		return eISupTypId;
	}

	public void setEISupTypId(Integer eISupTypId) {
		this.eISupTypId = eISupTypId;
	}

	public Double geteArrngPctAmt() {
		return eArrngPctAmt;
	}

	public void setEArrngPctAmt(Double eArrngPctAmt) {
		this.eArrngPctAmt = eArrngPctAmt;
	}

	public Integer geteLegNumber() {
		return eLegNumber;
	}

	public void setELegNumber(Integer eLegNumber) {
		this.eLegNumber = eLegNumber;
	}

	public String getRestrctFlg() {
		return restrctFlg;
	}

	public void setRestrctFlg(String restrctFlg) {
		this.restrctFlg = restrctFlg;
	}

	public String getOriginalAccountNumber() {
		return originalAccountNumber;
	}

	public void setOriginalAccountNumber(String originalAccountNumber) {
		this.originalAccountNumber = originalAccountNumber;
	}
	
private List<ArrangementTRLTwRcRecord> eArragnmntTRLRecords;
	
	public List<ArrangementTRLTwRcRecord> geteArragnmntTRLRecords() {
		return eArragnmntTRLRecords;
	}
	public void setEArragnmntTRLRecords(List<ArrangementTRLTwRcRecord> eArragnmntTRLRecords) {
		this.eArragnmntTRLRecords = eArragnmntTRLRecords;
	}
	
	

//	public Double geteEffRatePct() {
//		return eEffRatePct;
//	}
//
//	public void setEEffRatePct(Double eEffRatePct) {
//		this.eEffRatePct = eEffRatePct;
//	}
	
	/**
	 * @param originalAdvisedUncommittedLimit the originalAdvisedUncommittedLimit to set
	/**
	 * @return the eAirEndDate
	 */
	public Date geteAirEndDate() {
		return eAirEndDate;
	}

	/**
	 * @param eAirEndDate the eAirEndDate to set
	 */
	public void setEAirEndDate(Date eAirEndDate) {
		this.eAirEndDate = eAirEndDate;
	}

	private Date eAirEndDate;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InRcTRLRecord [eUniqueIdSrcSys=" + eUniqueIdSrcSys
				+ ", eCommonBalanceRcTRLRecords=" + eCommonBalanceRcTRLRecords
				+ ", eSrcSysId=" + eSrcSysId + ", eProdSysId=" + eProdSysId
				+ ", eRecordType=" + eRecordType + ", eAsOfDate=" + eAsOfDate
				+ ", eGlobProdId=" + eGlobProdId + ", arrngmentName="
				+ arrngmentName + ", description=" + description
				+ ", eBookingDate=" + eBookingDate + ", eOrginalEffDate="
				+ eOrginalEffDate + ", eEffectiveDate=" + eEffectiveDate
				+ ", estimEndDate=" + estimEndDate + ", eEndDate=" + eEndDate
				+ ", eArrngTypeId=" + eArrngTypeId + ", eDenominCurrId="
				+ eDenominCurrId + ", eOrigChnlId=" + eOrigChnlId
				+ ", eArrngBusIntType=" + eArrngBusIntType
				+ ", eArrngBusIntDate=" + eArrngBusIntDate + ", ePledgeInd="
				+ ePledgeInd + ", ePledgeEligInd=" + ePledgeEligInd
				+ ", eArrngMatureTypeId=" + eArrngMatureTypeId
				+ ", eArrngFinStatusTypeId=" + eArrngFinStatusTypeId
				+ ", eArrngFinStatusDate=" + eArrngFinStatusDate
				+ ", eArrngPastDueDayCnt=" + eArrngPastDueDayCnt
				+ ", eGracePeriodDayCnt=" + eGracePeriodDayCnt
				+ ", eArrngPastDueAgeClass=" + eArrngPastDueAgeClass
				+ ", eArrngPastDueAgeClassDate=" + eArrngPastDueAgeClassDate
				+ ", arrngFinancialStatusReasonTypeId="
				+ arrngFinancialStatusReasonTypeId
				+ ", eArrngLifeCycStatusTypeId=" + eArrngLifeCycStatusTypeId
				+ ", arrngLifeCycleStsReasonTypeId="
				+ arrngLifeCycleStsReasonTypeId + ", eArrngLifeCycStatusDate="
				+ eArrngLifeCycStatusDate + ", arrngNextRenewalDate="
				+ arrngNextRenewalDate + ", nextRenewalDate=" + nextRenewalDate
				+ ", arrngPrimaryPymtTypeId=" + arrngPrimaryPymtTypeId
				+ ", eEntrProdId=" + eEntrProdId + ", localProdCode="
				+ localProdCode + ", localSubProdCode=" + localSubProdCode
				+ ", localProdCategoryCode=" + localProdCategoryCode
				+ ", originalCampaignId=" + originalCampaignId
				+ ", feeWaiverFlg=" + feeWaiverFlg + ", feeWaiverExpDate="
				+ feeWaiverExpDate + ", eAcctTypeId=" + eAcctTypeId
				+ ", eArrngAcqTypeId=" + eArrngAcqTypeId
				+ ", eArrngAcqDateCorp=" + eArrngAcqDateCorp
				+ ", eArrngAcqDateRewrite=" + eArrngAcqDateRewrite
				+ ", eArrngAcqDate=" + eArrngAcqDate + ", eArrngAcqDateRetail="
				+ eArrngAcqDateRetail + ", eArrngDisposTypeId="
				+ eArrngDisposTypeId + ", arrngDispositionDate="
				+ arrngDispositionDate + ", chargeOffTypeId=" + chargeOffTypeId
				+ ", origOrInvestorInsuredCategryId="
				+ origOrInvestorInsuredCategryId
				+ ", OrigOrInvestorInsuredActiveFlg="
				+ OrigOrInvestorInsuredActiveFlg
				+ ", OrigOrInvestorInsuredPerct=" + OrigOrInvestorInsuredPerct
				+ ", eArrngDayCnvtTypeId=" + eArrngDayCnvtTypeId
				+ ", eIntrBasisCalcPrdId=" + eIntrBasisCalcPrdId
				+ ", eIntrPymtFreqPrdId=" + eIntrPymtFreqPrdId
				+ ", feePymtFreqPeriodId=" + feePymtFreqPeriodId
				+ ", eRateRstPrdInrvId=" + eRateRstPrdInrvId
				+ ", intIntrestRateResetDate=" + intIntrestRateResetDate
				+ ", eNxtIntrRateRstDate=" + eNxtIntrRateRstDate
				+ ", prevOrLastIntrRateResetDate="
				+ prevOrLastIntrRateResetDate + ", eAtmCardFlg=" + eAtmCardFlg
				+ ", islamicAcctIndicator=" + islamicAcctIndicator
				+ ", taxExemptIndicator=" + taxExemptIndicator
				+ ", onlineBankRltnIndicator=" + onlineBankRltnIndicator
				+ ", remainingDaysToMaturity=" + remainingDaysToMaturity
				+ ", eFinServTypeId=" + eFinServTypeId + ", eOrigAmt="
				+ eOrigAmt + ", obligatorResourceIndicator="
				+ obligatorResourceIndicator + ", citiResourceIndicator="
				+ citiResourceIndicator + ", pymtFrequencyPeriodId="
				+ pymtFrequencyPeriodId + ", negativeAmortizationFlg="
				+ negativeAmortizationFlg + ", balloonRepymtIndicator="
				+ balloonRepymtIndicator + ", eIntrAccrStsTypeId="
				+ eIntrAccrStsTypeId + ", eIntrAccrStsDate=" + eIntrAccrStsDate
				+ ", intrOnlyTermPeriod=" + intrOnlyTermPeriod
				+ ", principalGracePeriod=" + principalGracePeriod
				+ ", noticePeriodDays=" + noticePeriodDays
				+ ", acquisitionCost=" + acquisitionCost
				+ ", finServiceCurRestrctStsId=" + finServiceCurRestrctStsId
				+ ", finServiceCurRestrctStsDate="
				+ finServiceCurRestrctStsDate
				+ ", finServiceRestrctOrModresonTypeId="
				+ finServiceRestrctOrModresonTypeId
				+ ", finServPrevRestructStsId=" + finServPrevRestructStsId
				+ ", finServRestructPrevStsDate=" + finServRestructPrevStsDate
				+ ", finServModifPrgmId=" + finServModifPrgmId
				+ ", finServModfPrgmStrtDate=" + finServModfPrgmStrtDate
				+ ", finServModfPrgmCurrSts=" + finServModfPrgmCurrSts
				+ ", finServModfPrgmCurrStsDate=" + finServModfPrgmCurrStsDate
				+ ", finServModfPrgmEndDate=" + finServModfPrgmEndDate
				+ ", finServModfPrgmPrevStsTypeId="
				+ finServModfPrgmPrevStsTypeId + ", finServLimitTypeId="
				+ finServLimitTypeId + ", currFinServPrinRepymtTypeId="
				+ currFinServPrinRepymtTypeId + ", troubledDebtRestructFlg="
				+ troubledDebtRestructFlg + ", restructOrModifFlag="
				+ restructOrModifFlag + ", marketRateYldAtRenFlg="
				+ marketRateYldAtRenFlg + ", overLimitIndicator="
				+ overLimitIndicator + ", skipPymtIndicator="
				+ skipPymtIndicator + ", amortizationAccertionIndicator="
				+ amortizationAccertionIndicator + ", securitizedIndicator="
				+ securitizedIndicator + ", modfRetentOrLossMitgTypeId="
				+ modfRetentOrLossMitgTypeId + ", regOEmpFlg=" + regOEmpFlg
				+ ", trppTenor=" + trppTenor + ", acctTrppInstAmt="
				+ acctTrppInstAmt + ", lineOfCrdAtmExtFlg="
				+ lineOfCrdAtmExtFlg + ", lineOfCrdLoanConvFlg="
				+ lineOfCrdLoanConvFlg + ", incomeDocTypeId=" + incomeDocTypeId
				+ ", crdDeviationIndicator=" + crdDeviationIndicator
				+ ", pymtTotalNumber=" + pymtTotalNumber
				+ ", remainingPymtNumbr=" + remainingPymtNumbr
				+ ", preComputedLoanFlg=" + preComputedLoanFlg
				+ ", discountPremLoanTypeId=" + discountPremLoanTypeId
				+ ", ppInternalRefNumbr=" + ppInternalRefNumbr
				+ ", localWarehouseReference=" + localWarehouseReference
				+ ", upstreamSysReference=" + upstreamSysReference
				+ ", customerTradeRefernce=" + customerTradeRefernce
				+ ", eArrngPurposeTypeId1=" + eArrngPurposeTypeId1
				+ ", arrngPurposeTypeId2=" + arrngPurposeTypeId2
				+ ", arrngPurposeTypeId3=" + arrngPurposeTypeId3
				+ ", penaltyRate=" + penaltyRate + ", penaltyAmt=" + penaltyAmt
				+ ", legalNotificationDays=" + legalNotificationDays
				+ ", arrngNextPymtDueToBankDate=" + arrngNextPymtDueToBankDate
				+ ", arrngNextPymtDueToBankAmt=" + arrngNextPymtDueToBankAmt
				+ ", arrngLastPymtDueToBankDate=" + arrngLastPymtDueToBankDate
				+ ", arrngLastPymtDueToBankAmt=" + arrngLastPymtDueToBankAmt
				+ ", acctFirstAdvnceDate=" + acctFirstAdvnceDate
				+ ", acctFirstAdvanceAmt=" + acctFirstAdvanceAmt
				+ ", acctFirstPymtDate=" + acctFirstPymtDate
				+ ", acctFirstPymtAmt=" + acctFirstPymtAmt
				+ ", acctLastAdvanceDate=" + acctLastAdvanceDate
				+ ", acctLastAdvanceAmt=" + acctLastAdvanceAmt
				+ ", missedPymtNumbr=" + missedPymtNumbr
				+ ", acctLastRecoveryDate=" + acctLastRecoveryDate
				+ ", acctLastInstallDate=" + acctLastInstallDate
				+ ", totalPymts=" + totalPymts + ", acctLastIntrReviewDate="
				+ acctLastIntrReviewDate + ", lastIntrCollectionDate="
				+ lastIntrCollectionDate + ", eDelq30DayPst2YrsFlg="
				+ eDelq30DayPst2YrsFlg + ", eArrngSecureTypeId="
				+ eArrngSecureTypeId + ", lienPositionTypeId="
				+ lienPositionTypeId + ", probabilityOfDefault="
				+ probabilityOfDefault + ", eBaselPortfolioId="
				+ eBaselPortfolioId + ", otherAltId=" + otherAltId
				+ ", eCreditFacTypeId=" + eCreditFacTypeId
				+ ", eFacLegalStstTypeId=" + eFacLegalStstTypeId
				+ ", facilityLegalStsDate=" + facilityLegalStsDate
				+ ", eCredFacArrngApprvTypeId=" + eCredFacArrngApprvTypeId
				+ ", credFacArrngApprvDate=" + credFacArrngApprvDate
				+ ", credFacRegSegTypeId=" + credFacRegSegTypeId
				+ ", credFacAvailStsTypeId=" + credFacAvailStsTypeId
				+ ", originalAdvisedCommitLimit=" + originalAdvisedCommitLimit
				+ ", originalAdvisedUncommittedLimit="
				+ originalAdvisedUncommittedLimit
				+ ", originalUnadvisedUncommitLimit="
				+ originalUnadvisedUncommitLimit
				+ ", lastCreditLimitChangeDate=" + lastCreditLimitChangeDate
				+ ", credLimitChangeTypeId=" + credLimitChangeTypeId
				+ ", credLimitEffectiveDate=" + credLimitEffectiveDate
				+ ", credLimitEndDate=" + credLimitEndDate
				+ ", eCredLimitEvtIntTypeId=" + eCredLimitEvtIntTypeId
				+ ", credLimitEventAmt=" + credLimitEventAmt
				+ ", eCcarProdCode=" + eCcarProdCode + ", bankruptcyCode="
				+ bankruptcyCode + ", promoIntrRateEligibleFlg="
				+ promoIntrRateEligibleFlg + ", pmacPortfolioId="
				+ pmacPortfolioId + ", eOrigAcctNumb=" + eOrigAcctNumb
				+ ", lastWriteDownDate=" + lastWriteDownDate
				+ ", currentlyNegativeAmortizeFlg="
				+ currentlyNegativeAmortizeFlg
				+ ", principalDeferralOptionFlg=" + principalDeferralOptionFlg
				+ ", principalDefrralOptionEndDate="
				+ principalDefrralOptionEndDate + ", intrDeferralOptionFlg="
				+ intrDeferralOptionFlg + ", intrDeferralOptionEndDate="
				+ intrDeferralOptionEndDate + ", intrOnlyOptionEndDate="
				+ intrOnlyOptionEndDate + ", eEverWrittenOffFlg="
				+ eEverWrittenOffFlg + ", acctFundsAdvancedCompleteFlg="
				+ acctFundsAdvancedCompleteFlg + ", totFundsDisbursedAmt="
				+ totFundsDisbursedAmt + ", monthsOnBooksLocal="
				+ monthsOnBooksLocal + ", eRiskMgmtInd=" + eRiskMgmtInd
				+ ", daysPastDueCycleEnd=" + daysPastDueCycleEnd
				+ ", delinqBucket=" + delinqBucket + ", cycleEndDelinqBucket="
				+ cycleEndDelinqBucket + ", reservedForFutureGenesisUsage1="
				+ reservedForFutureGenesisUsage1
				+ ", reservedForFutureGenesisUsage2="
				+ reservedForFutureGenesisUsage2
				+ ", reservedForFutureGenesisUsage3="
				+ reservedForFutureGenesisUsage3
				+ ", reservedForFutureGenesisUsage4="
				+ reservedForFutureGenesisUsage4
				+ ", reservedForFutureGenesisUsage5="
				+ reservedForFutureGenesisUsage5
				+ ", reservedForFutureGenesisUsage6="
				+ reservedForFutureGenesisUsage6
				+ ", reservedForFutureGenesisUsage7="
				+ reservedForFutureGenesisUsage7
				+ ", reservedForFutureGenesisUsage8="
				+ reservedForFutureGenesisUsage8
				+ ", reservedForFutureGenesisUsage9="
				+ reservedForFutureGenesisUsage9
				+ ", reservedForFutureGenesisUsage10="
				+ reservedForFutureGenesisUsage10
				+ ", reservedForFutureGenesisUsage11="
				+ reservedForFutureGenesisUsage11
				+ ", reservedForFutureGenesisUsage12="
				+ reservedForFutureGenesisUsage12
				+ ", reservedForFutureGenesisUsage13="
				+ reservedForFutureGenesisUsage13
				+ ", reservedForFutureGenesisUsage14="
				+ reservedForFutureGenesisUsage14
				+ ", reservedForFutureGenesisUsage15="
				+ reservedForFutureGenesisUsage15
				+ ", reservedForFutureGenesisUsage16="
				+ reservedForFutureGenesisUsage16
				+ ", reservedForFutureGenesisUsage17="
				+ reservedForFutureGenesisUsage17
				+ ", reservedForFutureGenesisUsage18="
				+ reservedForFutureGenesisUsage18
				+ ", reservedForFutureGenesisUsage19="
				+ reservedForFutureGenesisUsage19 + ", eUniqIdSrsInvPty="
				+ eUniqIdSrsInvPty + ", eArrngInvlvPtyRoleType="
				+ eArrngInvlvPtyRoleType + ", ePercentAmt=" + ePercentAmt
				+ ", eInvlvPtySubTypeId=" + eInvlvPtySubTypeId
				+ ", eRatingIssuerId=" + eRatingIssuerId + ", eModelCode="
				+ eModelCode + ", eRatingEventRsnTypeId="
				+ eRatingEventRsnTypeId + ", eRank=" + eRank
				+ ", eRatingTypeCode=" + eRatingTypeCode + ", eRatingCode="
				+ eRatingCode + ", eFicoEquiRatingCode=" + eFicoEquiRatingCode
				+ ", eRaingDescription=" + eRaingDescription
				+ ", eScoreRqstReturnFlg=" + eScoreRqstReturnFlg
				+ ", eModelCodeAIR=" + eModelCodeAIR + ", eResouceItemTypeId="
				+ eResouceItemTypeId + ", primaryCollateralIndicator="
				+ primaryCollateralIndicator + ", revaluationCollateralInd="
				+ revaluationCollateralInd + ", resourceItemName="
				+ resourceItemName + ", srcSysId=" + srcSysId
				+ ", resourceItemValAmt=" + resourceItemValAmt
				+ ", eResourceItemValMethId=" + eResourceItemValMethId
				+ ", eResourceItemValEffDate=" + eResourceItemValEffDate
				+ ", eResItemBalCurrId=" + eResItemBalCurrId
				+ ", eResItemBalTypeId=" + eResItemBalTypeId
				+ ", resItemValuationEvntReasonTypeId="
				+ resItemValuationEvntReasonTypeId + ", eLoanToAstRelType="
				+ eLoanToAstRelType + ", eReltnEffDate=" + eReltnEffDate
				+ ", collateralTypeId=" + collateralTypeId + ", eStndrdArrgId="
				+ eStndrdArrgId + ", eCreditRiskMitgTypeId="
				+ eCreditRiskMitgTypeId + ", collateralSrcTypeId="
				+ collateralSrcTypeId + ", legalEnforcablityFlg="
				+ legalEnforcablityFlg + ", legalRightToPosFlg="
				+ legalRightToPosFlg + ", reHypotheInd=" + reHypotheInd
				+ ", collateralLocCode=" + collateralLocCode
				+ ", intMarginOrValMargFlg=" + intMarginOrValMargFlg
				+ ", legNumbr=" + legNumbr + ", generalLdgerSysId="
				+ generalLdgerSysId + ", dealId=" + dealId
				+ ", eBookingLedgerCountryCode=" + eBookingLedgerCountryCode
				+ ", eBalType=" + eBalType + ", eGLAccount1=" + eGLAccount1
				+ ", glAccount2=" + glAccount2 + ", fdlAccount=" + fdlAccount
				+ ", eTransCurrCode=" + eTransCurrCode + ", eFuncCurrCode="
				+ eFuncCurrCode + ", eBaseCurrCode=" + eBaseCurrCode
				+ ", eTransAmt=" + eTransAmt + ", functionalAmt="
				+ functionalAmt + ", baseAmt=" + baseAmt + ", goc=" + goc
				+ ", bookingLedgerBranchCode=" + bookingLedgerBranchCode
				+ ", frsBusUnitCode=" + frsBusUnitCode + ", notForUse="
				+ notForUse + ", localDeptId=" + localDeptId
				+ ", eLocalLegVehicleId=" + eLocalLegVehicleId
				+ ", fairValacctMethodFlg=" + fairValacctMethodFlg
				+ ", fairValLevel=" + fairValLevel + ", expenseCode="
				+ expenseCode + ", frsAfflCode=" + frsAfflCode
				+ ", subStrategyCode=" + subStrategyCode + ", eGAAPInd="
				+ eGAAPInd + ", microCntStrtCodeOpenField1="
				+ microCntStrtCodeOpenField1 + ", firmAcctIMSNumbr="
				+ firmAcctIMSNumbr + ", baseNumbLocafflCode="
				+ baseNumbLocafflCode + ", idProd=" + idProd + ", keyCode1="
				+ keyCode1 + ", keyCode2=" + keyCode2 + ", locLedgerAcctNumb="
				+ locLedgerAcctNumb + ", adjustmentInd=" + adjustmentInd
				+ ", userId=" + userId + ", adjustmentReasonCode="
				+ adjustmentReasonCode + ", comments=" + comments
				+ ", localGlKey3=" + localGlKey3 + ", localGlKey4="
				+ localGlKey4 + ", adjStrdArrngId=" + adjStrdArrngId
				+ ", eFeePymtFreqPrdId=" + eFeePymtFreqPrdId
				+ ", eBaseAmtCurr=" + eBaseAmtCurr 
				+ ", eLossMitgPrgmId=" + eLossMitgPrgmId + ", eISupTypId="
				+ eISupTypId + ", eRateTypeId=" + eRateTypeId
				+ ", eArrngPctAmt=" + eArrngPctAmt + ", eLegNumber="
				+ eLegNumber + ", restrctFlg=" + restrctFlg
				+ ", originalAccountNumber=" + originalAccountNumber
				+ ", eEffectiveRatePercent=" + eEffectiveRatePercent
				+ ", speedRatePer=" + speedRatePer + ", arrngRateTypRelnTypId="
				+ arrngRateTypRelnTypId + ", rateId=" + rateId + ", rateName="
				+ rateName + ", eRateVarTypeId=" + eRateVarTypeId
				+ ", rateTypEffDate=" + rateTypEffDate + ", eRateActiveFlag="
				+ eRateActiveFlag + ", eRiRate=" + eRiRate + ", eCiRate="
				+ eCiRate + ", eArragnmntTRLRecords=" + eArragnmntTRLRecords
				+ ", eAirEndDate=" + eAirEndDate + "]";
	}

	/**
	 * @return the eARGRank
	 */
	public Integer geteARGRank() {
		return eARGRank;
	}

	/**
	 * @param eARGRank the eARGRank to set
	 */
	public void setEARGRank(Integer eARGRank) {
		this.eARGRank = eARGRank;
	}

	/**
	 * @return the eCAArrngBusIntType
	 */
	public Integer geteCAArrngBusIntType() {
		return eCAArrngBusIntType;
	}

	/**
	 * @param eCAArrngBusIntType the eCAArrngBusIntType to set
	 */
	public void setECAArrngBusIntType(Integer eCAArrngBusIntType) {
		this.eCAArrngBusIntType = eCAArrngBusIntType;
	}

	public Date geteARGEffectiveDate() {
		return eARGEffectiveDate;
	}

	public void setEARGEffectiveDate(Date eARGEffectiveDate) {
		this.eARGEffectiveDate = eARGEffectiveDate;
	}

	public Date geteARGEndDate() {
		return eARGEndDate;
	}

	public void setEARGEndDate(Date eARGEndDate) {
		this.eARGEndDate = eARGEndDate;
	}

	public Date geteEffectiveDateAIR() {
		return eEffectiveDateAIR;
	}

	public void setEEffectiveDateAIR(Date eEffectiveDateAIR) {
		this.eEffectiveDateAIR = eEffectiveDateAIR;
	}

	public Date geteEndDateAip() {
		return eEndDateAip;
	}

	public void setEEndDateAip(Date eEndDateAip) {
		this.eEndDateAip = eEndDateAip;
	}
	
	
}
