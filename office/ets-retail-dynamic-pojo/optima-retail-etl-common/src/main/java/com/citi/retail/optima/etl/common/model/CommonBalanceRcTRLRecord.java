/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author sm59053
 *
 */
public class CommonBalanceRcTRLRecord {
	
	
	private List<CommonBalanceRcTRLRecord> eCommonBalanceRcTRLRecords;
	private String eUniqueIdSrcSys;
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
	private Date estimEndDate;
	private Date eEndDate;
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
	private BigDecimal eTransAmt;
	private BigDecimal functionalAmt;
	private BigDecimal baseAmt;
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

	
	
	public CommonBalanceRcTRLRecord(InRcTRLRecord record) {
		this.eUniqueIdSrcSys = record.geteUniqueIdSrcSys();
		this.eCommonBalanceRcTRLRecords = record.geteCommonBalanceRcTRLRecords();
		this.eSrcSysId = record.geteSrcSysId();
		this.eProdSysId = record.geteProdSysId();
		this.eRecordType = record.geteRecordType();
		this.eAsOfDate = record.geteAsOfDate();
		this.eGlobProdId = record.geteGlobProdId();
		this.arrngmentName = record.getArrngmentName();
		this.description = record.getDescription();
		this.eBookingDate = record.geteBookingDate();
		this.eOrginalEffDate = record.geteOrginalEffDate();
		this.eEffectiveDate = record.geteEffectiveDate();
		this.estimEndDate = record.getEstimEndDate();
		this.eEndDate = record.geteEndDate();
		this.eArrngTypeId = record.geteArrngTypeId();
		this.eDenominCurrId = record.geteDenominCurrId();
		this.eOrigChnlId = record.geteOrigChnlId();
		this.eArrngBusIntType = record.geteArrngBusIntType();
		this.eArrngBusIntDate = record.geteArrngBusIntDate();
		this.ePledgeInd = record.getePledgeInd();
		this.ePledgeEligInd = record.getePledgeEligInd();
		this.eArrngMatureTypeId = record.geteArrngMatureTypeId();
		this.eArrngFinStatusTypeId = record.geteArrngFinStatusTypeId();
		this.eArrngFinStatusDate = record.geteArrngFinStatusDate();
		this.eArrngPastDueDayCnt = record.geteArrngPastDueDayCnt();
		this.eGracePeriodDayCnt = record.geteGracePeriodDayCnt();
		this.eArrngPastDueAgeClass = record.geteArrngPastDueAgeClass();
		this.eArrngPastDueAgeClass = record.geteArrngPastDueAgeClass();
		this.arrngFinancialStatusReasonTypeId = record.getArrngFinancialStatusReasonTypeId();
		this.eArrngLifeCycStatusTypeId = record.geteArrngLifeCycStatusTypeId();
		this.arrngLifeCycleStsReasonTypeId = record.getArrngLifeCycleStsReasonTypeId();
		this.eArrngLifeCycStatusDate = record.geteArrngLifeCycStatusDate();
		this.arrngNextRenewalDate = record.getArrngNextRenewalDate();
		this.nextRenewalDate = record.getNextRenewalDate();
		this.arrngPrimaryPymtTypeId = record.getArrngPrimaryPymtTypeId();
		this.eEntrProdId = record.geteEntrProdId();
		this.localProdCode = record.getLocalProdCode();
		this.localSubProdCode = record.getLocalSubProdCode();
		this.localProdCategoryCode = record.getLocalProdCategoryCode();
		this.originalCampaignId = record.getOriginalCampaignId();
		this.feeWaiverFlg = record.getFeeWaiverFlg();
		this.feeWaiverExpDate = record.getFeeWaiverExpDate();
		this.eAcctTypeId = record.geteAcctTypeId();
		this.eArrngAcqTypeId = record.geteArrngAcqTypeId();
		this.eArrngAcqDateCorp = record.geteArrngAcqDateCorp();
		this.eArrngAcqDateRewrite = record.geteArrngAcqDateRewrite();
		this.eArrngAcqDate = record.geteArrngAcqDate();
		this.eArrngAcqDateRetail = record.geteArrngAcqDateRetail();
		this.eArrngDisposTypeId = record.geteArrngDisposTypeId();
		this.arrngDispositionDate = record.getArrngDispositionDate();
		this.chargeOffTypeId = record.getChargeOffTypeId();
		this.origOrInvestorInsuredCategryId = record.getOrigOrInvestorInsuredCategryId();
		this.OrigOrInvestorInsuredActiveFlg = record.getOrigOrInvestorInsuredActiveFlg();
		this.OrigOrInvestorInsuredPerct = record.getOrigOrInvestorInsuredPerct();
		this.eArrngDayCnvtTypeId = record.geteArrngDayCnvtTypeId();
		this.eIntrBasisCalcPrdId = record.geteIntrBasisCalcPrdId();
		this.eIntrPymtFreqPrdId = record.geteIntrPymtFreqPrdId();
		this.feePymtFreqPeriodId = record.getFeePymtFreqPeriodId();
		this.eRateRstPrdInrvId = record.geteRateRstPrdInrvId();
		this.intIntrestRateResetDate = record.getIntIntrestRateResetDate();
		this.eNxtIntrRateRstDate = record.geteNxtIntrRateRstDate();
		this.prevOrLastIntrRateResetDate = record.getPrevOrLastIntrRateResetDate();
		this.eAtmCardFlg = record.geteAtmCardFlg();
		this.islamicAcctIndicator = record.getIslamicAcctIndicator();
		this.taxExemptIndicator = record.getTaxExemptIndicator();
		this.onlineBankRltnIndicator = record.getOnlineBankRltnIndicator();
		this.remainingDaysToMaturity = record.getRemainingDaysToMaturity();
		this.eFinServTypeId = record.geteFinServTypeId();
		this.eOrigAmt = record.geteOrigAmt();
		this.obligatorResourceIndicator = record.getObligatorResourceIndicator();
		this.citiResourceIndicator = record.getCitiResourceIndicator();
		this.pymtFrequencyPeriodId = record.getPymtFrequencyPeriodId();
		this.negativeAmortizationFlg = record.getNegativeAmortizationFlg();
		this.balloonRepymtIndicator = record.getBalloonRepymtIndicator();
		this.eIntrAccrStsTypeId = record.geteIntrAccrStsTypeId();
		this.eIntrAccrStsDate = record.geteIntrAccrStsDate();
		this.intrOnlyTermPeriod = record.getIntrOnlyTermPeriod();
		this.principalGracePeriod = record.getPrincipalGracePeriod();
		this.noticePeriodDays = record.getNoticePeriodDays();
		this.acquisitionCost = record.getAcquisitionCost();
		this.finServiceCurRestrctStsId = record.getFinServiceCurRestrctStsId();
		this.finServiceCurRestrctStsDate = record.getFinServiceCurRestrctStsDate();
		this.finServiceRestrctOrModresonTypeId = record.getFinServiceRestrctOrModresonTypeId();
		this.finServPrevRestructStsId = record.getFinServPrevRestructStsId();
		this.finServRestructPrevStsDate = record.getFinServRestructPrevStsDate();
		this.finServModifPrgmId = record.getFinServModifPrgmId();
		this.finServModfPrgmStrtDate = record.getFinServModfPrgmStrtDate();
		this.finServModfPrgmCurrSts = record.getFinServModfPrgmCurrSts();
		this.finServModfPrgmCurrSts = record.getFinServModfPrgmCurrSts();
		this.finServModfPrgmEndDate = record.getFinServModfPrgmEndDate();
		this.finServModfPrgmPrevStsTypeId = record.getFinServModfPrgmPrevStsTypeId();
		this.finServLimitTypeId = record.getFinServLimitTypeId();
		this.currFinServPrinRepymtTypeId = record.getCurrFinServPrinRepymtTypeId();
		this.troubledDebtRestructFlg = record.getTroubledDebtRestructFlg();
		this.restructOrModifFlag = record.getRestructOrModifFlag();
		this.marketRateYldAtRenFlg = record.getMarketRateYldAtRenFlg();
		this.overLimitIndicator = record.getOverLimitIndicator();
		this.skipPymtIndicator = record.getSkipPymtIndicator();
		this.amortizationAccertionIndicator = record.getAmortizationAccertionIndicator();
		this.securitizedIndicator = record.getSecuritizedIndicator();
		this.modfRetentOrLossMitgTypeId = record.getModfRetentOrLossMitgTypeId();
		this.regOEmpFlg = record.getRegOEmpFlg();
		this.trppTenor = record.getTrppTenor();
		this.acctTrppInstAmt = record.getAcctTrppInstAmt();
		this.lineOfCrdAtmExtFlg = record.getLineOfCrdAtmExtFlg();
		this.lineOfCrdLoanConvFlg = record.getLineOfCrdLoanConvFlg();
		this.incomeDocTypeId = record.getIncomeDocTypeId();
		this.crdDeviationIndicator = record.getCrdDeviationIndicator();
		this.pymtTotalNumber = record.getPymtTotalNumber();
		this.remainingPymtNumbr = record.getRemainingPymtNumbr();
		this.preComputedLoanFlg = record.getPreComputedLoanFlg();
		this.discountPremLoanTypeId = record.getDiscountPremLoanTypeId();
		this.ppInternalRefNumbr = record.getPpInternalRefNumbr();
		this.localWarehouseReference = record.getLocalWarehouseReference();
		this.upstreamSysReference = record.getUpstreamSysReference();
		this.customerTradeRefernce = record.getCustomerTradeRefernce();
		this.eArrngPurposeTypeId1 = record.geteArrngPurposeTypeId1();
		this.arrngPurposeTypeId2 = record.getArrngPurposeTypeId2();
		this.arrngPurposeTypeId3 = record.getArrngPurposeTypeId3();
		this.penaltyRate = record.getPenaltyRate();
		this.penaltyAmt = record.getPenaltyAmt();
		this.legalNotificationDays = record.getLegalNotificationDays();
		this.arrngNextPymtDueToBankDate = record.getArrngNextPymtDueToBankDate();
		this.arrngNextPymtDueToBankAmt = record.getArrngNextPymtDueToBankAmt();
		this.arrngLastPymtDueToBankDate = record.getArrngLastPymtDueToBankDate();
		this.arrngLastPymtDueToBankAmt = record.getArrngLastPymtDueToBankAmt();
		this.acctFirstAdvnceDate = record.getAcctFirstAdvnceDate();
		this.acctFirstAdvanceAmt = record.getAcctFirstAdvanceAmt();
		this.acctFirstPymtDate = record.getAcctFirstPymtDate();
		this.acctFirstPymtAmt = record.getAcctFirstPymtAmt();
		this.acctLastAdvanceDate = record.getAcctLastAdvanceDate();
		this.acctLastAdvanceAmt = record.getAcctLastAdvanceAmt();
		this.missedPymtNumbr = record.getMissedPymtNumbr();
		this.acctLastRecoveryDate = record.getAcctLastRecoveryDate();
		this.acctLastInstallDate = record.getAcctLastInstallDate();
		this.totalPymts = record.getTotalPymts();
		this.acctLastIntrReviewDate = record.getAcctLastIntrReviewDate();
		this.lastIntrCollectionDate = record.getLastIntrCollectionDate();
		this.eDelq30DayPst2YrsFlg = record.geteDelq30DayPst2YrsFlg();
		this.eArrngSecureTypeId = record.geteArrngSecureTypeId();
		this.lienPositionTypeId = record.getLienPositionTypeId();
		this.probabilityOfDefault = record.getProbabilityOfDefault();
		this.eBaselPortfolioId = record.geteBaselPortfolioId();
		this.otherAltId = record.getOtherAltId();
		this.eCreditFacTypeId = record.geteCreditFacTypeId();
		this.eFacLegalStstTypeId = record.geteFacLegalStstTypeId();
		this.facilityLegalStsDate = record.getFacilityLegalStsDate();
		this.eCredFacArrngApprvTypeId = record.geteCredFacArrngApprvTypeId();
		this.credFacArrngApprvDate = record.getCredFacArrngApprvDate();
		this.credFacRegSegTypeId = record.getCredFacRegSegTypeId();
		this.credFacAvailStsTypeId = record.getCredFacAvailStsTypeId();
		this.originalAdvisedCommitLimit = record.getOriginalAdvisedCommitLimit();
		this.originalAdvisedUncommittedLimit = record.getOriginalAdvisedUncommittedLimit();
		this.originalUnadvisedUncommitLimit = record.getOriginalUnadvisedUncommitLimit();
		this.lastCreditLimitChangeDate = record.getLastCreditLimitChangeDate();
		this.credLimitChangeTypeId = record.getCredLimitChangeTypeId();
		this.credLimitEffectiveDate = record.getCredLimitEffectiveDate();
		this.credLimitEndDate = record.getCredLimitEndDate();
		this.eCredLimitEvtIntTypeId = record.geteCredLimitEvtIntTypeId();
		this.credLimitEventAmt = record.getCredLimitEventAmt();
		this.eCcarProdCode = record.geteCcarProdCode();
		this.bankruptcyCode = record.getBankruptcyCode();
		this.promoIntrRateEligibleFlg = record.getPromoIntrRateEligibleFlg();
		this.pmacPortfolioId = record.getPmacPortfolioId();
		this.eOrigAcctNumb = record.geteOrigAcctNumb();
		this.lastWriteDownDate = record.getLastWriteDownDate();
		this.currentlyNegativeAmortizeFlg = record.getCurrentlyNegativeAmortizeFlg();
		this.principalDeferralOptionFlg = record.getPrincipalDeferralOptionFlg();
		this.principalDefrralOptionEndDate = record.getPrincipalDefrralOptionEndDate();
		this.intrDeferralOptionFlg = record.getIntrDeferralOptionFlg();
		this.intrDeferralOptionEndDate = record.getIntrDeferralOptionEndDate();
		this.intrOnlyOptionEndDate = record.getIntrOnlyOptionEndDate();
		this.eEverWrittenOffFlg = record.geteEverWrittenOffFlg();
		this.acctFundsAdvancedCompleteFlg = record.getAcctFundsAdvancedCompleteFlg();
		this.totFundsDisbursedAmt = record.getTotFundsDisbursedAmt();
		this.monthsOnBooksLocal = record.getMonthsOnBooksLocal();
		this.eRiskMgmtInd = record.geteRiskMgmtInd();
		this.daysPastDueCycleEnd = record.getDaysPastDueCycleEnd();
		this.delinqBucket = record.getDelinqBucket();
		this.cycleEndDelinqBucket = record.getCycleEndDelinqBucket();
		this.reservedForFutureGenesisUsage1 = record.getReservedForFutureGenesisUsage1();
		this.reservedForFutureGenesisUsage2 = record.getReservedForFutureGenesisUsage2();
		this.reservedForFutureGenesisUsage3 = record.getReservedForFutureGenesisUsage3();
		this.reservedForFutureGenesisUsage4 = record.getReservedForFutureGenesisUsage4();
		this.reservedForFutureGenesisUsage5 = record.getReservedForFutureGenesisUsage5();
		this.reservedForFutureGenesisUsage6 = record.getReservedForFutureGenesisUsage6();
		this.reservedForFutureGenesisUsage7 = record.getReservedForFutureGenesisUsage7();
		this.reservedForFutureGenesisUsage8 = record.getReservedForFutureGenesisUsage8();
		this.reservedForFutureGenesisUsage9 = record.getReservedForFutureGenesisUsage9();
		this.reservedForFutureGenesisUsage10 = record.getReservedForFutureGenesisUsage10();
		this.reservedForFutureGenesisUsage11 = record.getReservedForFutureGenesisUsage11();
		this.reservedForFutureGenesisUsage12 = record.getReservedForFutureGenesisUsage12();
		this.reservedForFutureGenesisUsage13 = record.getReservedForFutureGenesisUsage13();
		this.reservedForFutureGenesisUsage14 = record.getReservedForFutureGenesisUsage14();
		this.reservedForFutureGenesisUsage15 = record.getReservedForFutureGenesisUsage15();
		this.reservedForFutureGenesisUsage16 = record.getReservedForFutureGenesisUsage16();
		this.reservedForFutureGenesisUsage17 = record.getReservedForFutureGenesisUsage17();
		this.reservedForFutureGenesisUsage18 = record.getReservedForFutureGenesisUsage18();
		this.reservedForFutureGenesisUsage19 = record.getReservedForFutureGenesisUsage19();
		this.eUniqIdSrsInvPty = record.geteUniqIdSrsInvPty();
		this.eArrngInvlvPtyRoleType = record.geteArrngInvlvPtyRoleType();
		this.ePercentAmt = record.getePercentAmt();
		this.eInvlvPtySubTypeId = record.geteInvlvPtySubTypeId();
		this.eRatingIssuerId = record.geteRatingIssuerId();
		this.eModelCode = record.geteModelCode();
		this.eRatingEventRsnTypeId = record.geteRatingEventRsnTypeId();
		this.eRank = record.geteRank();
		this.eRatingTypeCode = record.geteRatingTypeCode();
		this.eRatingCode = record.geteRatingCode();
		this.eFicoEquiRatingCode = record.geteFicoEquiRatingCode();
		this.eRaingDescription = record.geteRaingDescription();
		this.eScoreRqstReturnFlg = record.geteScoreRqstReturnFlg();
		this.eModelCodeAIR = record.geteModelCodeAIR();
		this.eResouceItemTypeId = record.geteResouceItemTypeId();
		this.primaryCollateralIndicator = record.getPrimaryCollateralIndicator();
		this.revaluationCollateralInd = record.getRevaluationCollateralInd();
		this.resourceItemName = record.getResourceItemName();
		this.srcSysId = record.getSrcSysId();
		this.resourceItemValAmt = record.getResourceItemValAmt();
		this.eResourceItemValMethId = record.geteResourceItemValMethId();
		this.eResourceItemValEffDate = record.geteResourceItemValEffDate();
		this.eResItemBalCurrId = record.geteResItemBalCurrId();
		this.eResItemBalTypeId = record.geteResItemBalTypeId();
		this.resItemValuationEvntReasonTypeId = record.getResItemValuationEvntReasonTypeId();
		this.eLoanToAstRelType = record.geteLoanToAstRelType();
		this.eReltnEffDate = record.geteReltnEffDate();
		this.collateralTypeId = record.getCollateralTypeId();
		this.eStndrdArrgId = record.geteStndrdArrgId();
		this.eCreditRiskMitgTypeId = record.geteCreditRiskMitgTypeId();
		this.collateralSrcTypeId = record.getCollateralSrcTypeId();
		this.legalEnforcablityFlg = record.getLegalEnforcablityFlg();
		this.legalRightToPosFlg = record.getLegalRightToPosFlg();
		this.reHypotheInd = record.getReHypotheInd();
		this.collateralLocCode = record.getCollateralLocCode();
		this.intMarginOrValMargFlg = record.getIntMarginOrValMargFlg();
		this.legNumbr = record.getLegNumbr();
		this.generalLdgerSysId = record.getGeneralLdgerSysId();
		this.dealId = record.getDealId();
		this.eBookingLedgerCountryCode = record.geteBookingLedgerCountryCode();
		this.eBalType = record.geteBalType();
		this.eGLAccount1 = record.geteGLAccount1();
		this.glAccount2 = record.getGlAccount2();
		this.fdlAccount = record.getFdlAccount();
		this.eTransCurrCode = record.geteTransCurrCode();
		this.eFuncCurrCode = record.geteFuncCurrCode();
		this.eBaseCurrCode = record.geteBaseCurrCode();
		//this.eTransAmt = record.geteTransAmt();
		this.functionalAmt = record.getFunctionalAmt();
		//this.baseAmt = record.getBaseAmt();
		this.goc = record.getGoc();
		this.bookingLedgerBranchCode = record.getBookingLedgerBranchCode();
		this.frsBusUnitCode = record.getFrsBusUnitCode();
		this.notForUse = record.getNotForUse();
		this.localDeptId = record.getLocalDeptId();
		this.eLocalLegVehicleId = record.geteLocalLegVehicleId();
		this.fairValacctMethodFlg = record.getFairValacctMethodFlg();
		this.fairValLevel = record.getFairValLevel();
		this.expenseCode = record.getExpenseCode();
		this.frsAfflCode = record.getFrsAfflCode();
		this.subStrategyCode = record.getSubStrategyCode();
		this.eGAAPInd = record.geteGAAPInd();
		this.microCntStrtCodeOpenField1 = record.getMicroCntStrtCodeOpenField1();
		this.firmAcctIMSNumbr = record.getFirmAcctIMSNumbr();
		this.baseNumbLocafflCode = record.getBaseNumbLocafflCode();
		this.idProd = record.getIdProd();
		this.keyCode1 = record.getKeyCode1();
		this.keyCode2 = record.getKeyCode2();
		this.locLedgerAcctNumb = record.getLocLedgerAcctNumb();
		this.adjustmentInd = record.getAdjustmentInd();
		this.userId = record.getUserId();
		this.adjustmentReasonCode = record.getAdjustmentReasonCode();
		this.comments = record.getComments();
		this.localGlKey3 = record.getLocalGlKey3();
		this.localGlKey4 = record.getLocalGlKey4();
		this.adjStrdArrngId = record.getAdjStrdArrngId();
		this.eFeePymtFreqPrdId = record.geteFeePymtFreqPrdId();
		//this.eBaseAmtCurr = record.geteBaseAmtCurr();

	}

	/**
	 * @return the eUniqueIdSrcSys
	 */
	public String geteUniqueIdSrcSys() {
		return eUniqueIdSrcSys;
	}

	/**
	 * @param eUniqueIdSrcSys the eUniqueIdSrcSys to set
	 */
	public void setEUniqueIdSrcSys(String eUniqueIdSrcSys) {
		this.eUniqueIdSrcSys = eUniqueIdSrcSys;
	}

	/**
	 * @return the eCommonBalanceRcTRLRecords
	 */
	public List<CommonBalanceRcTRLRecord> geteCommonBalanceRcTRLRecords() {
		return eCommonBalanceRcTRLRecords;
	}
	/**
	 * @param eCommonBalanceRcTRLRecords the eCommonBalanceRcTRLRecords to set
	 */
	public void setECommonBalanceRcTRLRecords(
			List<CommonBalanceRcTRLRecord> eCommonBalanceRcTRLRecords) {
		this.eCommonBalanceRcTRLRecords = eCommonBalanceRcTRLRecords;
	}
	/**
	 * @return the eSrcSysId
	 */
	public String geteSrcSysId() {
		return eSrcSysId;
	}
	/**
	 * @param eSrcSysId the eSrcSysId to set
	 */
	public void setESrcSysId(String eSrcSysId) {
		this.eSrcSysId = eSrcSysId;
	}
	/**
	 * @return the eProdSysId
	 */
	public String geteProdSysId() {
		return eProdSysId;
	}
	/**
	 * @param eProdSysId the eProdSysId to set
	 */
	public void setEProdSysId(String eProdSysId) {
		this.eProdSysId = eProdSysId;
	}
	/**
	 * @return the eRecordType
	 */
	public String geteRecordType() {
		return eRecordType;
	}
	/**
	 * @param eRecordType the eRecordType to set
	 */
	public void setERecordType(String eRecordType) {
		this.eRecordType = eRecordType;
	}
	/**
	 * @return the eAsOfDate
	 */
	public Date geteAsOfDate() {
		return eAsOfDate;
	}
	/**
	 * @param eAsOfDate the eAsOfDate to set
	 */
	public void setEAsOfDate(Date eAsOfDate) {
		this.eAsOfDate = eAsOfDate;
	}
	/**
	 * @return the eGlobProdId
	 */
	public String geteGlobProdId() {
		return eGlobProdId;
	}
	/**
	 * @param eGlobProdId the eGlobProdId to set
	 */
	public void setEGlobProdId(String eGlobProdId) {
		this.eGlobProdId = eGlobProdId;
	}
	/**
	 * @return the arrngmentName
	 */
	public String getArrngmentName() {
		return arrngmentName;
	}
	/**
	 * @param arrngmentName the arrngmentName to set
	 */
	public void setArrngmentName(String arrngmentName) {
		this.arrngmentName = arrngmentName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the eBookingDate
	 */
	public Date geteBookingDate() {
		return eBookingDate;
	}
	/**
	 * @param eBookingDate the eBookingDate to set
	 */
	public void setEBookingDate(Date eBookingDate) {
		this.eBookingDate = eBookingDate;
	}
	/**
	 * @return the eOrginalEffDate
	 */
	public Date geteOrginalEffDate() {
		return eOrginalEffDate;
	}
	/**
	 * @param eOrginalEffDate the eOrginalEffDate to set
	 */
	public void setEOrginalEffDate(Date eOrginalEffDate) {
		this.eOrginalEffDate = eOrginalEffDate;
	}
	/**
	 * @return the eEffectiveDate
	 */
	public Date geteEffectiveDate() {
		return eEffectiveDate;
	}
	/**
	 * @param eEffectiveDate the eEffectiveDate to set
	 */
	public void setEEffectiveDate(Date eEffectiveDate) {
		this.eEffectiveDate = eEffectiveDate;
	}
	/**
	 * @return the estimEndDate
	 */
	public Date getEstimEndDate() {
		return estimEndDate;
	}
	/**
	 * @param estimEndDate the estimEndDate to set
	 */
	public void setEstimEndDate(Date estimEndDate) {
		this.estimEndDate = estimEndDate;
	}
	/**
	 * @return the eEndDate
	 */
	public Date geteEndDate() {
		return eEndDate;
	}
	/**
	 * @param eEndDate the eEndDate to set
	 */
	public void setEEndDate(Date eEndDate) {
		this.eEndDate = eEndDate;
	}
	/**
	 * @return the eArrngTypeId
	 */
	public Integer geteArrngTypeId() {
		return eArrngTypeId;
	}
	/**
	 * @param eArrngTypeId the eArrngTypeId to set
	 */
	public void setEArrngTypeId(Integer eArrngTypeId) {
		this.eArrngTypeId = eArrngTypeId;
	}
	/**
	 * @return the eDenominCurrId
	 */
	public String geteDenominCurrId() {
		return eDenominCurrId;
	}
	/**
	 * @param eDenominCurrId the eDenominCurrId to set
	 */
	public void setEDenominCurrId(String eDenominCurrId) {
		this.eDenominCurrId = eDenominCurrId;
	}
	/**
	 * @return the eOrigChnlId
	 */
	public Integer geteOrigChnlId() {
		return eOrigChnlId;
	}
	/**
	 * @param eOrigChnlId the eOrigChnlId to set
	 */
	public void setEOrigChnlId(Integer eOrigChnlId) {
		this.eOrigChnlId = eOrigChnlId;
	}
	/**
	 * @return the eArrngBusIntType
	 */
	public Integer geteArrngBusIntType() {
		return eArrngBusIntType;
	}
	/**
	 * @param eArrngBusIntType the eArrngBusIntType to set
	 */
	public void setEArrngBusIntType(Integer eArrngBusIntType) {
		this.eArrngBusIntType = eArrngBusIntType;
	}
	/**
	 * @return the eArrngBusIntDate
	 */
	public Date geteArrngBusIntDate() {
		return eArrngBusIntDate;
	}
	/**
	 * @param eArrngBusIntDate the eArrngBusIntDate to set
	 */
	public void setEArrngBusIntDate(Date eArrngBusIntDate) {
		this.eArrngBusIntDate = eArrngBusIntDate;
	}
	/**
	 * @return the ePledgeInd
	 */
	public String getePledgeInd() {
		return ePledgeInd;
	}
	/**
	 * @param ePledgeInd the ePledgeInd to set
	 */
	public void setEPledgeInd(String ePledgeInd) {
		this.ePledgeInd = ePledgeInd;
	}
	/**
	 * @return the ePledgeEligInd
	 */
	public String getePledgeEligInd() {
		return ePledgeEligInd;
	}
	/**
	 * @param ePledgeEligInd the ePledgeEligInd to set
	 */
	public void setEPledgeEligInd(String ePledgeEligInd) {
		this.ePledgeEligInd = ePledgeEligInd;
	}
	/**
	 * @return the eArrngMatureTypeId
	 */
	public Integer geteArrngMatureTypeId() {
		return eArrngMatureTypeId;
	}
	/**
	 * @param eArrngMatureTypeId the eArrngMatureTypeId to set
	 */
	public void setEArrngMatureTypeId(Integer eArrngMatureTypeId) {
		this.eArrngMatureTypeId = eArrngMatureTypeId;
	}
	/**
	 * @return the eArrngFinStatusTypeId
	 */
	public Integer geteArrngFinStatusTypeId() {
		return eArrngFinStatusTypeId;
	}
	/**
	 * @param eArrngFinStatusTypeId the eArrngFinStatusTypeId to set
	 */
	public void setEArrngFinStatusTypeId(Integer eArrngFinStatusTypeId) {
		this.eArrngFinStatusTypeId = eArrngFinStatusTypeId;
	}
	/**
	 * @return the eArrngFinStatusDate
	 */
	public Date geteArrngFinStatusDate() {
		return eArrngFinStatusDate;
	}
	/**
	 * @param eArrngFinStatusDate the eArrngFinStatusDate to set
	 */
	public void setEArrngFinStatusDate(Date eArrngFinStatusDate) {
		this.eArrngFinStatusDate = eArrngFinStatusDate;
	}
	/**
	 * @return the eArrngPastDueDayCnt
	 */
	public Integer geteArrngPastDueDayCnt() {
		return eArrngPastDueDayCnt;
	}
	/**
	 * @param eArrngPastDueDayCnt the eArrngPastDueDayCnt to set
	 */
	public void setEArrngPastDueDayCnt(Integer eArrngPastDueDayCnt) {
		this.eArrngPastDueDayCnt = eArrngPastDueDayCnt;
	}
	/**
	 * @return the eGracePeriodDayCnt
	 */
	public Integer geteGracePeriodDayCnt() {
		return eGracePeriodDayCnt;
	}
	/**
	 * @param eGracePeriodDayCnt the eGracePeriodDayCnt to set
	 */
	public void setEGracePeriodDayCnt(Integer eGracePeriodDayCnt) {
		this.eGracePeriodDayCnt = eGracePeriodDayCnt;
	}
	/**
	 * @return the eArrngPastDueAgeClass
	 */
	public Integer geteArrngPastDueAgeClass() {
		return eArrngPastDueAgeClass;
	}
	/**
	 * @param eArrngPastDueAgeClass the eArrngPastDueAgeClass to set
	 */
	public void setEArrngPastDueAgeClass(Integer eArrngPastDueAgeClass) {
		this.eArrngPastDueAgeClass = eArrngPastDueAgeClass;
	}
	/**
	 * @return the eArrngPastDueAgeClassDate
	 */
	public Date geteArrngPastDueAgeClassDate() {
		return eArrngPastDueAgeClassDate;
	}
	/**
	 * @param eArrngPastDueAgeClassDate the eArrngPastDueAgeClassDate to set
	 */
	public void setEArrngPastDueAgeClassDate(Date eArrngPastDueAgeClassDate) {
		this.eArrngPastDueAgeClassDate = eArrngPastDueAgeClassDate;
	}
	/**
	 * @return the arrngFinancialStatusReasonTypeId
	 */
	public Integer getArrngFinancialStatusReasonTypeId() {
		return arrngFinancialStatusReasonTypeId;
	}
	/**
	 * @param arrngFinancialStatusReasonTypeId the arrngFinancialStatusReasonTypeId to set
	 */
	public void setArrngFinancialStatusReasonTypeId(
			Integer arrngFinancialStatusReasonTypeId) {
		this.arrngFinancialStatusReasonTypeId = arrngFinancialStatusReasonTypeId;
	}
	/**
	 * @return the eArrngLifeCycStatusTypeId
	 */
	public Integer geteArrngLifeCycStatusTypeId() {
		return eArrngLifeCycStatusTypeId;
	}
	/**
	 * @param eArrngLifeCycStatusTypeId the eArrngLifeCycStatusTypeId to set
	 */
	public void setEArrngLifeCycStatusTypeId(Integer eArrngLifeCycStatusTypeId) {
		this.eArrngLifeCycStatusTypeId = eArrngLifeCycStatusTypeId;
	}
	/**
	 * @return the arrngLifeCycleStsReasonTypeId
	 */
	public Integer getArrngLifeCycleStsReasonTypeId() {
		return arrngLifeCycleStsReasonTypeId;
	}
	/**
	 * @param arrngLifeCycleStsReasonTypeId the arrngLifeCycleStsReasonTypeId to set
	 */
	public void setArrngLifeCycleStsReasonTypeId(
			Integer arrngLifeCycleStsReasonTypeId) {
		this.arrngLifeCycleStsReasonTypeId = arrngLifeCycleStsReasonTypeId;
	}
	/**
	 * @return the eArrngLifeCycStatusDate
	 */
	public Date geteArrngLifeCycStatusDate() {
		return eArrngLifeCycStatusDate;
	}
	/**
	 * @param eArrngLifeCycStatusDate the eArrngLifeCycStatusDate to set
	 */
	public void setEArrngLifeCycStatusDate(Date eArrngLifeCycStatusDate) {
		this.eArrngLifeCycStatusDate = eArrngLifeCycStatusDate;
	}
	/**
	 * @return the arrngNextRenewalDate
	 */
	public Date getArrngNextRenewalDate() {
		return arrngNextRenewalDate;
	}
	/**
	 * @param arrngNextRenewalDate the arrngNextRenewalDate to set
	 */
	public void setArrngNextRenewalDate(Date arrngNextRenewalDate) {
		this.arrngNextRenewalDate = arrngNextRenewalDate;
	}
	/**
	 * @return the nextRenewalDate
	 */
	public Date getNextRenewalDate() {
		return nextRenewalDate;
	}
	/**
	 * @param nextRenewalDate the nextRenewalDate to set
	 */
	public void setNextRenewalDate(Date nextRenewalDate) {
		this.nextRenewalDate = nextRenewalDate;
	}
	/**
	 * @return the arrngPrimaryPymtTypeId
	 */
	public Integer getArrngPrimaryPymtTypeId() {
		return arrngPrimaryPymtTypeId;
	}
	/**
	 * @param arrngPrimaryPymtTypeId the arrngPrimaryPymtTypeId to set
	 */
	public void setArrngPrimaryPymtTypeId(Integer arrngPrimaryPymtTypeId) {
		this.arrngPrimaryPymtTypeId = arrngPrimaryPymtTypeId;
	}
	/**
	 * @return the eEntrProdId
	 */
	public String geteEntrProdId() {
		return eEntrProdId;
	}
	/**
	 * @param eEntrProdId the eEntrProdId to set
	 */
	public void setEEntrProdId(String eEntrProdId) {
		this.eEntrProdId = eEntrProdId;
	}
	/**
	 * @return the localProdCode
	 */
	public String getLocalProdCode() {
		return localProdCode;
	}
	/**
	 * @param localProdCode the localProdCode to set
	 */
	public void setLocalProdCode(String localProdCode) {
		this.localProdCode = localProdCode;
	}
	/**
	 * @return the localSubProdCode
	 */
	public String getLocalSubProdCode() {
		return localSubProdCode;
	}
	/**
	 * @param localSubProdCode the localSubProdCode to set
	 */
	public void setLocalSubProdCode(String localSubProdCode) {
		this.localSubProdCode = localSubProdCode;
	}
	/**
	 * @return the localProdCategoryCode
	 */
	public String getLocalProdCategoryCode() {
		return localProdCategoryCode;
	}
	/**
	 * @param localProdCategoryCode the localProdCategoryCode to set
	 */
	public void setLocalProdCategoryCode(String localProdCategoryCode) {
		this.localProdCategoryCode = localProdCategoryCode;
	}
	/**
	 * @return the originalCampaignId
	 */
	public Integer getOriginalCampaignId() {
		return originalCampaignId;
	}
	/**
	 * @param originalCampaignId the originalCampaignId to set
	 */
	public void setOriginalCampaignId(Integer originalCampaignId) {
		this.originalCampaignId = originalCampaignId;
	}
	/**
	 * @return the feeWaiverFlg
	 */
	public String getFeeWaiverFlg() {
		return feeWaiverFlg;
	}
	/**
	 * @param feeWaiverFlg the feeWaiverFlg to set
	 */
	public void setFeeWaiverFlg(String feeWaiverFlg) {
		this.feeWaiverFlg = feeWaiverFlg;
	}
	/**
	 * @return the feeWaiverExpDate
	 */
	public Date getFeeWaiverExpDate() {
		return feeWaiverExpDate;
	}
	/**
	 * @param feeWaiverExpDate the feeWaiverExpDate to set
	 */
	public void setFeeWaiverExpDate(Date feeWaiverExpDate) {
		this.feeWaiverExpDate = feeWaiverExpDate;
	}
	/**
	 * @return the eAcctTypeId
	 */
	public Integer geteAcctTypeId() {
		return eAcctTypeId;
	}
	/**
	 * @param eAcctTypeId the eAcctTypeId to set
	 */
	public void setEAcctTypeId(Integer eAcctTypeId) {
		this.eAcctTypeId = eAcctTypeId;
	}
	/**
	 * @return the eArrngAcqTypeId
	 */
	public String geteArrngAcqTypeId() {
		return eArrngAcqTypeId;
	}
	/**
	 * @param eArrngAcqTypeId the eArrngAcqTypeId to set
	 */
	public void setEArrngAcqTypeId(String eArrngAcqTypeId) {
		this.eArrngAcqTypeId = eArrngAcqTypeId;
	}
	/**
	 * @return the eArrngAcqDateCorp
	 */
	public Date geteArrngAcqDateCorp() {
		return eArrngAcqDateCorp;
	}
	/**
	 * @param eArrngAcqDateCorp the eArrngAcqDateCorp to set
	 */
	public void setEArrngAcqDateCorp(Date eArrngAcqDateCorp) {
		this.eArrngAcqDateCorp = eArrngAcqDateCorp;
	}
	/**
	 * @return the eArrngAcqDateRewrite
	 */
	public Date geteArrngAcqDateRewrite() {
		return eArrngAcqDateRewrite;
	}
	/**
	 * @param eArrngAcqDateRewrite the eArrngAcqDateRewrite to set
	 */
	public void setEArrngAcqDateRewrite(Date eArrngAcqDateRewrite) {
		this.eArrngAcqDateRewrite = eArrngAcqDateRewrite;
	}
	/**
	 * @return the eArrngAcqDate
	 */
	public Date geteArrngAcqDate() {
		return eArrngAcqDate;
	}
	/**
	 * @param eArrngAcqDate the eArrngAcqDate to set
	 */
	public void setEArrngAcqDate(Date eArrngAcqDate) {
		this.eArrngAcqDate = eArrngAcqDate;
	}
	/**
	 * @return the eArrngAcqDateRetail
	 */
	public Date geteArrngAcqDateRetail() {
		return eArrngAcqDateRetail;
	}
	/**
	 * @param eArrngAcqDateRetail the eArrngAcqDateRetail to set
	 */
	public void setEArrngAcqDateRetail(Date eArrngAcqDateRetail) {
		this.eArrngAcqDateRetail = eArrngAcqDateRetail;
	}
	/**
	 * @return the eArrngDisposTypeId
	 */
	public String geteArrngDisposTypeId() {
		return eArrngDisposTypeId;
	}
	/**
	 * @param eArrngDisposTypeId the eArrngDisposTypeId to set
	 */
	public void setEArrngDisposTypeId(String eArrngDisposTypeId) {
		this.eArrngDisposTypeId = eArrngDisposTypeId;
	}
	/**
	 * @return the arrngDispositionDate
	 */
	public Date getArrngDispositionDate() {
		return arrngDispositionDate;
	}
	/**
	 * @param arrngDispositionDate the arrngDispositionDate to set
	 */
	public void setArrngDispositionDate(Date arrngDispositionDate) {
		this.arrngDispositionDate = arrngDispositionDate;
	}
	/**
	 * @return the chargeOffTypeId
	 */
	public Integer getChargeOffTypeId() {
		return chargeOffTypeId;
	}
	/**
	 * @param chargeOffTypeId the chargeOffTypeId to set
	 */
	public void setChargeOffTypeId(Integer chargeOffTypeId) {
		this.chargeOffTypeId = chargeOffTypeId;
	}
	/**
	 * @return the origOrInvestorInsuredCategryId
	 */
	public Integer getOrigOrInvestorInsuredCategryId() {
		return origOrInvestorInsuredCategryId;
	}
	/**
	 * @param origOrInvestorInsuredCategryId the origOrInvestorInsuredCategryId to set
	 */
	public void setOrigOrInvestorInsuredCategryId(
			Integer origOrInvestorInsuredCategryId) {
		this.origOrInvestorInsuredCategryId = origOrInvestorInsuredCategryId;
	}
	/**
	 * @return the origOrInvestorInsuredActiveFlg
	 */
	public String getOrigOrInvestorInsuredActiveFlg() {
		return OrigOrInvestorInsuredActiveFlg;
	}
	/**
	 * @param origOrInvestorInsuredActiveFlg the origOrInvestorInsuredActiveFlg to set
	 */
	public void setOrigOrInvestorInsuredActiveFlg(
			String origOrInvestorInsuredActiveFlg) {
		OrigOrInvestorInsuredActiveFlg = origOrInvestorInsuredActiveFlg;
	}
	/**
	 * @return the origOrInvestorInsuredPerct
	 */
	public Double getOrigOrInvestorInsuredPerct() {
		return OrigOrInvestorInsuredPerct;
	}
	/**
	 * @param origOrInvestorInsuredPerct the origOrInvestorInsuredPerct to set
	 */
	public void setOrigOrInvestorInsuredPerct(Double origOrInvestorInsuredPerct) {
		OrigOrInvestorInsuredPerct = origOrInvestorInsuredPerct;
	}
	/**
	 * @return the eArrngDayCnvtTypeId
	 */
	public Integer geteArrngDayCnvtTypeId() {
		return eArrngDayCnvtTypeId;
	}
	/**
	 * @param eArrngDayCnvtTypeId the eArrngDayCnvtTypeId to set
	 */
	public void setEArrngDayCnvtTypeId(Integer eArrngDayCnvtTypeId) {
		this.eArrngDayCnvtTypeId = eArrngDayCnvtTypeId;
	}
	/**
	 * @return the eIntrBasisCalcPrdId
	 */
	public Integer geteIntrBasisCalcPrdId() {
		return eIntrBasisCalcPrdId;
	}
	/**
	 * @param eIntrBasisCalcPrdId the eIntrBasisCalcPrdId to set
	 */
	public void setEIntrBasisCalcPrdId(Integer eIntrBasisCalcPrdId) {
		this.eIntrBasisCalcPrdId = eIntrBasisCalcPrdId;
	}
	/**
	 * @return the eIntrPymtFreqPrdId
	 */
	public Integer geteIntrPymtFreqPrdId() {
		return eIntrPymtFreqPrdId;
	}
	/**
	 * @param eIntrPymtFreqPrdId the eIntrPymtFreqPrdId to set
	 */
	public void setEIntrPymtFreqPrdId(Integer eIntrPymtFreqPrdId) {
		this.eIntrPymtFreqPrdId = eIntrPymtFreqPrdId;
	}
	/**
	 * @return the feePymtFreqPeriodId
	 */
	public Integer getFeePymtFreqPeriodId() {
		return feePymtFreqPeriodId;
	}
	/**
	 * @param feePymtFreqPeriodId the feePymtFreqPeriodId to set
	 */
	public void setFeePymtFreqPeriodId(Integer feePymtFreqPeriodId) {
		this.feePymtFreqPeriodId = feePymtFreqPeriodId;
	}
	/**
	 * @return the eRateRstPrdInrvId
	 */
	public Integer geteRateRstPrdInrvId() {
		return eRateRstPrdInrvId;
	}
	/**
	 * @param eRateRstPrdInrvId the eRateRstPrdInrvId to set
	 */
	public void setERateRstPrdInrvId(Integer eRateRstPrdInrvId) {
		this.eRateRstPrdInrvId = eRateRstPrdInrvId;
	}
	/**
	 * @return the intIntrestRateResetDate
	 */
	public Date getIntIntrestRateResetDate() {
		return intIntrestRateResetDate;
	}
	/**
	 * @param intIntrestRateResetDate the intIntrestRateResetDate to set
	 */
	public void setIntIntrestRateResetDate(Date intIntrestRateResetDate) {
		this.intIntrestRateResetDate = intIntrestRateResetDate;
	}
	/**
	 * @return the eNxtIntrRateRstDate
	 */
	public Date geteNxtIntrRateRstDate() {
		return eNxtIntrRateRstDate;
	}
	/**
	 * @param eNxtIntrRateRstDate the eNxtIntrRateRstDate to set
	 */
	public void setENxtIntrRateRstDate(Date eNxtIntrRateRstDate) {
		this.eNxtIntrRateRstDate = eNxtIntrRateRstDate;
	}
	/**
	 * @return the prevOrLastIntrRateResetDate
	 */
	public Date getPrevOrLastIntrRateResetDate() {
		return prevOrLastIntrRateResetDate;
	}
	/**
	 * @param prevOrLastIntrRateResetDate the prevOrLastIntrRateResetDate to set
	 */
	public void setPrevOrLastIntrRateResetDate(Date prevOrLastIntrRateResetDate) {
		this.prevOrLastIntrRateResetDate = prevOrLastIntrRateResetDate;
	}
	/**
	 * @return the eAtmCardFlg
	 */
	public String geteAtmCardFlg() {
		return eAtmCardFlg;
	}
	/**
	 * @param eAtmCardFlg the eAtmCardFlg to set
	 */
	public void setEAtmCardFlg(String eAtmCardFlg) {
		this.eAtmCardFlg = eAtmCardFlg;
	}
	/**
	 * @return the islamicAcctIndicator
	 */
	public String getIslamicAcctIndicator() {
		return islamicAcctIndicator;
	}
	/**
	 * @param islamicAcctIndicator the islamicAcctIndicator to set
	 */
	public void setIslamicAcctIndicator(String islamicAcctIndicator) {
		this.islamicAcctIndicator = islamicAcctIndicator;
	}
	/**
	 * @return the taxExemptIndicator
	 */
	public String getTaxExemptIndicator() {
		return taxExemptIndicator;
	}
	/**
	 * @param taxExemptIndicator the taxExemptIndicator to set
	 */
	public void setTaxExemptIndicator(String taxExemptIndicator) {
		this.taxExemptIndicator = taxExemptIndicator;
	}
	/**
	 * @return the onlineBankRltnIndicator
	 */
	public String getOnlineBankRltnIndicator() {
		return onlineBankRltnIndicator;
	}
	/**
	 * @param onlineBankRltnIndicator the onlineBankRltnIndicator to set
	 */
	public void setOnlineBankRltnIndicator(String onlineBankRltnIndicator) {
		this.onlineBankRltnIndicator = onlineBankRltnIndicator;
	}
	/**
	 * @return the remainingDaysToMaturity
	 */
	public Integer getRemainingDaysToMaturity() {
		return remainingDaysToMaturity;
	}
	/**
	 * @param remainingDaysToMaturity the remainingDaysToMaturity to set
	 */
	public void setRemainingDaysToMaturity(Integer remainingDaysToMaturity) {
		this.remainingDaysToMaturity = remainingDaysToMaturity;
	}
	/**
	 * @return the eFinServTypeId
	 */
	public Integer geteFinServTypeId() {
		return eFinServTypeId;
	}
	/**
	 * @param eFinServTypeId the eFinServTypeId to set
	 */
	public void setEFinServTypeId(Integer eFinServTypeId) {
		this.eFinServTypeId = eFinServTypeId;
	}
	/**
	 * @return the eOrigAmt
	 */
	public BigDecimal geteOrigAmt() {
		return eOrigAmt;
	}
	/**
	 * @param eOrigAmt the eOrigAmt to set
	 */
	public void setEOrigAmt(BigDecimal eOrigAmt) {
		this.eOrigAmt = eOrigAmt;
	}
	/**
	 * @return the obligatorResourceIndicator
	 */
	public String getObligatorResourceIndicator() {
		return obligatorResourceIndicator;
	}
	/**
	 * @param obligatorResourceIndicator the obligatorResourceIndicator to set
	 */
	public void setObligatorResourceIndicator(String obligatorResourceIndicator) {
		this.obligatorResourceIndicator = obligatorResourceIndicator;
	}
	/**
	 * @return the citiResourceIndicator
	 */
	public String getCitiResourceIndicator() {
		return citiResourceIndicator;
	}
	/**
	 * @param citiResourceIndicator the citiResourceIndicator to set
	 */
	public void setCitiResourceIndicator(String citiResourceIndicator) {
		this.citiResourceIndicator = citiResourceIndicator;
	}
	/**
	 * @return the pymtFrequencyPeriodId
	 */
	public Integer getPymtFrequencyPeriodId() {
		return pymtFrequencyPeriodId;
	}
	/**
	 * @param pymtFrequencyPeriodId the pymtFrequencyPeriodId to set
	 */
	public void setPymtFrequencyPeriodId(Integer pymtFrequencyPeriodId) {
		this.pymtFrequencyPeriodId = pymtFrequencyPeriodId;
	}
	/**
	 * @return the negativeAmortizationFlg
	 */
	public String getNegativeAmortizationFlg() {
		return negativeAmortizationFlg;
	}
	/**
	 * @param negativeAmortizationFlg the negativeAmortizationFlg to set
	 */
	public void setNegativeAmortizationFlg(String negativeAmortizationFlg) {
		this.negativeAmortizationFlg = negativeAmortizationFlg;
	}
	/**
	 * @return the balloonRepymtIndicator
	 */
	public String getBalloonRepymtIndicator() {
		return balloonRepymtIndicator;
	}
	/**
	 * @param balloonRepymtIndicator the balloonRepymtIndicator to set
	 */
	public void setBalloonRepymtIndicator(String balloonRepymtIndicator) {
		this.balloonRepymtIndicator = balloonRepymtIndicator;
	}
	/**
	 * @return the eIntrAccrStsTypeId
	 */
	public Integer geteIntrAccrStsTypeId() {
		return eIntrAccrStsTypeId;
	}
	/**
	 * @param eIntrAccrStsTypeId the eIntrAccrStsTypeId to set
	 */
	public void setEIntrAccrStsTypeId(Integer eIntrAccrStsTypeId) {
		this.eIntrAccrStsTypeId = eIntrAccrStsTypeId;
	}
	/**
	 * @return the eIntrAccrStsDate
	 */
	public Date geteIntrAccrStsDate() {
		return eIntrAccrStsDate;
	}
	/**
	 * @param eIntrAccrStsDate the eIntrAccrStsDate to set
	 */
	public void setEIntrAccrStsDate(Date eIntrAccrStsDate) {
		this.eIntrAccrStsDate = eIntrAccrStsDate;
	}
	/**
	 * @return the intrOnlyTermPeriod
	 */
	public Integer getIntrOnlyTermPeriod() {
		return intrOnlyTermPeriod;
	}
	/**
	 * @param intrOnlyTermPeriod the intrOnlyTermPeriod to set
	 */
	public void setIntrOnlyTermPeriod(Integer intrOnlyTermPeriod) {
		this.intrOnlyTermPeriod = intrOnlyTermPeriod;
	}
	/**
	 * @return the principalGracePeriod
	 */
	public Integer getPrincipalGracePeriod() {
		return principalGracePeriod;
	}
	/**
	 * @param principalGracePeriod the principalGracePeriod to set
	 */
	public void setPrincipalGracePeriod(Integer principalGracePeriod) {
		this.principalGracePeriod = principalGracePeriod;
	}
	/**
	 * @return the noticePeriodDays
	 */
	public Integer getNoticePeriodDays() {
		return noticePeriodDays;
	}
	/**
	 * @param noticePeriodDays the noticePeriodDays to set
	 */
	public void setNoticePeriodDays(Integer noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
	}
	/**
	 * @return the acquisitionCost
	 */
	public Integer getAcquisitionCost() {
		return acquisitionCost;
	}
	/**
	 * @param acquisitionCost the acquisitionCost to set
	 */
	public void setAcquisitionCost(Integer acquisitionCost) {
		this.acquisitionCost = acquisitionCost;
	}
	/**
	 * @return the finServiceCurRestrctStsId
	 */
	public String getFinServiceCurRestrctStsId() {
		return finServiceCurRestrctStsId;
	}
	/**
	 * @param finServiceCurRestrctStsId the finServiceCurRestrctStsId to set
	 */
	public void setFinServiceCurRestrctStsId(String finServiceCurRestrctStsId) {
		this.finServiceCurRestrctStsId = finServiceCurRestrctStsId;
	}
	/**
	 * @return the finServiceCurRestrctStsDate
	 */
	public Date getFinServiceCurRestrctStsDate() {
		return finServiceCurRestrctStsDate;
	}
	/**
	 * @param finServiceCurRestrctStsDate the finServiceCurRestrctStsDate to set
	 */
	public void setFinServiceCurRestrctStsDate(Date finServiceCurRestrctStsDate) {
		this.finServiceCurRestrctStsDate = finServiceCurRestrctStsDate;
	}
	/**
	 * @return the finServiceRestrctOrModresonTypeId
	 */
	public String getFinServiceRestrctOrModresonTypeId() {
		return finServiceRestrctOrModresonTypeId;
	}
	/**
	 * @param finServiceRestrctOrModresonTypeId the finServiceRestrctOrModresonTypeId to set
	 */
	public void setFinServiceRestrctOrModresonTypeId(
			String finServiceRestrctOrModresonTypeId) {
		this.finServiceRestrctOrModresonTypeId = finServiceRestrctOrModresonTypeId;
	}
	/**
	 * @return the finServPrevRestructStsId
	 */
	public String getFinServPrevRestructStsId() {
		return finServPrevRestructStsId;
	}
	/**
	 * @param finServPrevRestructStsId the finServPrevRestructStsId to set
	 */
	public void setFinServPrevRestructStsId(String finServPrevRestructStsId) {
		this.finServPrevRestructStsId = finServPrevRestructStsId;
	}
	/**
	 * @return the finServRestructPrevStsDate
	 */
	public Date getFinServRestructPrevStsDate() {
		return finServRestructPrevStsDate;
	}
	/**
	 * @param finServRestructPrevStsDate the finServRestructPrevStsDate to set
	 */
	public void setFinServRestructPrevStsDate(Date finServRestructPrevStsDate) {
		this.finServRestructPrevStsDate = finServRestructPrevStsDate;
	}
	/**
	 * @return the finServModifPrgmId
	 */
	public Integer getFinServModifPrgmId() {
		return finServModifPrgmId;
	}
	/**
	 * @param finServModifPrgmId the finServModifPrgmId to set
	 */
	public void setFinServModifPrgmId(Integer finServModifPrgmId) {
		this.finServModifPrgmId = finServModifPrgmId;
	}
	/**
	 * @return the finServModfPrgmStrtDate
	 */
	public Date getFinServModfPrgmStrtDate() {
		return finServModfPrgmStrtDate;
	}
	/**
	 * @param finServModfPrgmStrtDate the finServModfPrgmStrtDate to set
	 */
	public void setFinServModfPrgmStrtDate(Date finServModfPrgmStrtDate) {
		this.finServModfPrgmStrtDate = finServModfPrgmStrtDate;
	}
	/**
	 * @return the finServModfPrgmCurrSts
	 */
	public Integer getFinServModfPrgmCurrSts() {
		return finServModfPrgmCurrSts;
	}
	/**
	 * @param finServModfPrgmCurrSts the finServModfPrgmCurrSts to set
	 */
	public void setFinServModfPrgmCurrSts(Integer finServModfPrgmCurrSts) {
		this.finServModfPrgmCurrSts = finServModfPrgmCurrSts;
	}
	/**
	 * @return the finServModfPrgmCurrStsDate
	 */
	public Date getFinServModfPrgmCurrStsDate() {
		return finServModfPrgmCurrStsDate;
	}
	/**
	 * @param finServModfPrgmCurrStsDate the finServModfPrgmCurrStsDate to set
	 */
	public void setFinServModfPrgmCurrStsDate(Date finServModfPrgmCurrStsDate) {
		this.finServModfPrgmCurrStsDate = finServModfPrgmCurrStsDate;
	}
	/**
	 * @return the finServModfPrgmEndDate
	 */
	public Date getFinServModfPrgmEndDate() {
		return finServModfPrgmEndDate;
	}
	/**
	 * @param finServModfPrgmEndDate the finServModfPrgmEndDate to set
	 */
	public void setFinServModfPrgmEndDate(Date finServModfPrgmEndDate) {
		this.finServModfPrgmEndDate = finServModfPrgmEndDate;
	}
	/**
	 * @return the finServModfPrgmPrevStsTypeId
	 */
	public Integer getFinServModfPrgmPrevStsTypeId() {
		return finServModfPrgmPrevStsTypeId;
	}
	/**
	 * @param finServModfPrgmPrevStsTypeId the finServModfPrgmPrevStsTypeId to set
	 */
	public void setFinServModfPrgmPrevStsTypeId(Integer finServModfPrgmPrevStsTypeId) {
		this.finServModfPrgmPrevStsTypeId = finServModfPrgmPrevStsTypeId;
	}
	/**
	 * @return the finServLimitTypeId
	 */
	public Integer getFinServLimitTypeId() {
		return finServLimitTypeId;
	}
	/**
	 * @param finServLimitTypeId the finServLimitTypeId to set
	 */
	public void setFinServLimitTypeId(Integer finServLimitTypeId) {
		this.finServLimitTypeId = finServLimitTypeId;
	}
	/**
	 * @return the currFinServPrinRepymtTypeId
	 */
	public Integer getCurrFinServPrinRepymtTypeId() {
		return currFinServPrinRepymtTypeId;
	}
	/**
	 * @param currFinServPrinRepymtTypeId the currFinServPrinRepymtTypeId to set
	 */
	public void setCurrFinServPrinRepymtTypeId(Integer currFinServPrinRepymtTypeId) {
		this.currFinServPrinRepymtTypeId = currFinServPrinRepymtTypeId;
	}
	/**
	 * @return the troubledDebtRestructFlg
	 */
	public String getTroubledDebtRestructFlg() {
		return troubledDebtRestructFlg;
	}
	/**
	 * @param troubledDebtRestructFlg the troubledDebtRestructFlg to set
	 */
	public void setTroubledDebtRestructFlg(String troubledDebtRestructFlg) {
		this.troubledDebtRestructFlg = troubledDebtRestructFlg;
	}
	/**
	 * @return the restructOrModifFlag
	 */
	public String getRestructOrModifFlag() {
		return restructOrModifFlag;
	}
	/**
	 * @param restructOrModifFlag the restructOrModifFlag to set
	 */
	public void setRestructOrModifFlag(String restructOrModifFlag) {
		this.restructOrModifFlag = restructOrModifFlag;
	}
	/**
	 * @return the marketRateYldAtRenFlg
	 */
	public String getMarketRateYldAtRenFlg() {
		return marketRateYldAtRenFlg;
	}
	/**
	 * @param marketRateYldAtRenFlg the marketRateYldAtRenFlg to set
	 */
	public void setMarketRateYldAtRenFlg(String marketRateYldAtRenFlg) {
		this.marketRateYldAtRenFlg = marketRateYldAtRenFlg;
	}
	/**
	 * @return the overLimitIndicator
	 */
	public String getOverLimitIndicator() {
		return overLimitIndicator;
	}
	/**
	 * @param overLimitIndicator the overLimitIndicator to set
	 */
	public void setOverLimitIndicator(String overLimitIndicator) {
		this.overLimitIndicator = overLimitIndicator;
	}
	/**
	 * @return the skipPymtIndicator
	 */
	public String getSkipPymtIndicator() {
		return skipPymtIndicator;
	}
	/**
	 * @param skipPymtIndicator the skipPymtIndicator to set
	 */
	public void setSkipPymtIndicator(String skipPymtIndicator) {
		this.skipPymtIndicator = skipPymtIndicator;
	}
	/**
	 * @return the amortizationAccertionIndicator
	 */
	public String getAmortizationAccertionIndicator() {
		return amortizationAccertionIndicator;
	}
	/**
	 * @param amortizationAccertionIndicator the amortizationAccertionIndicator to set
	 */
	public void setAmortizationAccertionIndicator(
			String amortizationAccertionIndicator) {
		this.amortizationAccertionIndicator = amortizationAccertionIndicator;
	}
	/**
	 * @return the securitizedIndicator
	 */
	public String getSecuritizedIndicator() {
		return securitizedIndicator;
	}
	/**
	 * @param securitizedIndicator the securitizedIndicator to set
	 */
	public void setSecuritizedIndicator(String securitizedIndicator) {
		this.securitizedIndicator = securitizedIndicator;
	}
	/**
	 * @return the modfRetentOrLossMitgTypeId
	 */
	public Integer getModfRetentOrLossMitgTypeId() {
		return modfRetentOrLossMitgTypeId;
	}
	/**
	 * @param modfRetentOrLossMitgTypeId the modfRetentOrLossMitgTypeId to set
	 */
	public void setModfRetentOrLossMitgTypeId(Integer modfRetentOrLossMitgTypeId) {
		this.modfRetentOrLossMitgTypeId = modfRetentOrLossMitgTypeId;
	}
	/**
	 * @return the regOEmpFlg
	 */
	public String getRegOEmpFlg() {
		return regOEmpFlg;
	}
	/**
	 * @param regOEmpFlg the regOEmpFlg to set
	 */
	public void setRegOEmpFlg(String regOEmpFlg) {
		this.regOEmpFlg = regOEmpFlg;
	}
	/**
	 * @return the trppTenor
	 */
	public Integer getTrppTenor() {
		return trppTenor;
	}
	/**
	 * @param trppTenor the trppTenor to set
	 */
	public void setTrppTenor(Integer trppTenor) {
		this.trppTenor = trppTenor;
	}
	/**
	 * @return the acctTrppInstAmt
	 */
	public Double getAcctTrppInstAmt() {
		return acctTrppInstAmt;
	}
	/**
	 * @param acctTrppInstAmt the acctTrppInstAmt to set
	 */
	public void setAcctTrppInstAmt(Double acctTrppInstAmt) {
		this.acctTrppInstAmt = acctTrppInstAmt;
	}
	/**
	 * @return the lineOfCrdAtmExtFlg
	 */
	public String getLineOfCrdAtmExtFlg() {
		return lineOfCrdAtmExtFlg;
	}
	/**
	 * @param lineOfCrdAtmExtFlg the lineOfCrdAtmExtFlg to set
	 */
	public void setLineOfCrdAtmExtFlg(String lineOfCrdAtmExtFlg) {
		this.lineOfCrdAtmExtFlg = lineOfCrdAtmExtFlg;
	}
	/**
	 * @return the lineOfCrdLoanConvFlg
	 */
	public String getLineOfCrdLoanConvFlg() {
		return lineOfCrdLoanConvFlg;
	}
	/**
	 * @param lineOfCrdLoanConvFlg the lineOfCrdLoanConvFlg to set
	 */
	public void setLineOfCrdLoanConvFlg(String lineOfCrdLoanConvFlg) {
		this.lineOfCrdLoanConvFlg = lineOfCrdLoanConvFlg;
	}
	/**
	 * @return the incomeDocTypeId
	 */
	public Integer getIncomeDocTypeId() {
		return incomeDocTypeId;
	}
	/**
	 * @param incomeDocTypeId the incomeDocTypeId to set
	 */
	public void setIncomeDocTypeId(Integer incomeDocTypeId) {
		this.incomeDocTypeId = incomeDocTypeId;
	}
	/**
	 * @return the crdDeviationIndicator
	 */
	public String getCrdDeviationIndicator() {
		return crdDeviationIndicator;
	}
	/**
	 * @param crdDeviationIndicator the crdDeviationIndicator to set
	 */
	public void setCrdDeviationIndicator(String crdDeviationIndicator) {
		this.crdDeviationIndicator = crdDeviationIndicator;
	}
	/**
	 * @return the pymtTotalNumber
	 */
	public Integer getPymtTotalNumber() {
		return pymtTotalNumber;
	}
	/**
	 * @param pymtTotalNumber the pymtTotalNumber to set
	 */
	public void setPymtTotalNumber(Integer pymtTotalNumber) {
		this.pymtTotalNumber = pymtTotalNumber;
	}
	/**
	 * @return the remainingPymtNumbr
	 */
	public Integer getRemainingPymtNumbr() {
		return remainingPymtNumbr;
	}
	/**
	 * @param remainingPymtNumbr the remainingPymtNumbr to set
	 */
	public void setRemainingPymtNumbr(Integer remainingPymtNumbr) {
		this.remainingPymtNumbr = remainingPymtNumbr;
	}
	/**
	 * @return the preComputedLoanFlg
	 */
	public String getPreComputedLoanFlg() {
		return preComputedLoanFlg;
	}
	/**
	 * @param preComputedLoanFlg the preComputedLoanFlg to set
	 */
	public void setPreComputedLoanFlg(String preComputedLoanFlg) {
		this.preComputedLoanFlg = preComputedLoanFlg;
	}
	/**
	 * @return the discountPremLoanTypeId
	 */
	public String getDiscountPremLoanTypeId() {
		return discountPremLoanTypeId;
	}
	/**
	 * @param discountPremLoanTypeId the discountPremLoanTypeId to set
	 */
	public void setDiscountPremLoanTypeId(String discountPremLoanTypeId) {
		this.discountPremLoanTypeId = discountPremLoanTypeId;
	}
	/**
	 * @return the ppInternalRefNumbr
	 */
	public String getPpInternalRefNumbr() {
		return ppInternalRefNumbr;
	}
	/**
	 * @param ppInternalRefNumbr the ppInternalRefNumbr to set
	 */
	public void setPpInternalRefNumbr(String ppInternalRefNumbr) {
		this.ppInternalRefNumbr = ppInternalRefNumbr;
	}
	/**
	 * @return the localWarehouseReference
	 */
	public String getLocalWarehouseReference() {
		return localWarehouseReference;
	}
	/**
	 * @param localWarehouseReference the localWarehouseReference to set
	 */
	public void setLocalWarehouseReference(String localWarehouseReference) {
		this.localWarehouseReference = localWarehouseReference;
	}
	/**
	 * @return the upstreamSysReference
	 */
	public String getUpstreamSysReference() {
		return upstreamSysReference;
	}
	/**
	 * @param upstreamSysReference the upstreamSysReference to set
	 */
	public void setUpstreamSysReference(String upstreamSysReference) {
		this.upstreamSysReference = upstreamSysReference;
	}
	/**
	 * @return the customerTradeRefernce
	 */
	public String getCustomerTradeRefernce() {
		return customerTradeRefernce;
	}
	/**
	 * @param customerTradeRefernce the customerTradeRefernce to set
	 */
	public void setCustomerTradeRefernce(String customerTradeRefernce) {
		this.customerTradeRefernce = customerTradeRefernce;
	}
	/**
	 * @return the eArrngPurposeTypeId1
	 */
	public String geteArrngPurposeTypeId1() {
		return eArrngPurposeTypeId1;
	}
	/**
	 * @param eArrngPurposeTypeId1 the eArrngPurposeTypeId1 to set
	 */
	public void setEArrngPurposeTypeId1(String eArrngPurposeTypeId1) {
		this.eArrngPurposeTypeId1 = eArrngPurposeTypeId1;
	}
	/**
	 * @return the arrngPurposeTypeId2
	 */
	public String getArrngPurposeTypeId2() {
		return arrngPurposeTypeId2;
	}
	/**
	 * @param arrngPurposeTypeId2 the arrngPurposeTypeId2 to set
	 */
	public void setArrngPurposeTypeId2(String arrngPurposeTypeId2) {
		this.arrngPurposeTypeId2 = arrngPurposeTypeId2;
	}
	/**
	 * @return the arrngPurposeTypeId3
	 */
	public String getArrngPurposeTypeId3() {
		return arrngPurposeTypeId3;
	}
	/**
	 * @param arrngPurposeTypeId3 the arrngPurposeTypeId3 to set
	 */
	public void setArrngPurposeTypeId3(String arrngPurposeTypeId3) {
		this.arrngPurposeTypeId3 = arrngPurposeTypeId3;
	}
	/**
	 * @return the penaltyRate
	 */
	public Double getPenaltyRate() {
		return penaltyRate;
	}
	/**
	 * @param penaltyRate the penaltyRate to set
	 */
	public void setPenaltyRate(Double penaltyRate) {
		this.penaltyRate = penaltyRate;
	}
	/**
	 * @return the penaltyAmt
	 */
	public Double getPenaltyAmt() {
		return penaltyAmt;
	}
	/**
	 * @param penaltyAmt the penaltyAmt to set
	 */
	public void setPenaltyAmt(Double penaltyAmt) {
		this.penaltyAmt = penaltyAmt;
	}
	/**
	 * @return the legalNotificationDays
	 */
	public Integer getLegalNotificationDays() {
		return legalNotificationDays;
	}
	/**
	 * @param legalNotificationDays the legalNotificationDays to set
	 */
	public void setLegalNotificationDays(Integer legalNotificationDays) {
		this.legalNotificationDays = legalNotificationDays;
	}
	/**
	 * @return the arrngNextPymtDueToBankDate
	 */
	public Date getArrngNextPymtDueToBankDate() {
		return arrngNextPymtDueToBankDate;
	}
	/**
	 * @param arrngNextPymtDueToBankDate the arrngNextPymtDueToBankDate to set
	 */
	public void setArrngNextPymtDueToBankDate(Date arrngNextPymtDueToBankDate) {
		this.arrngNextPymtDueToBankDate = arrngNextPymtDueToBankDate;
	}
	/**
	 * @return the arrngNextPymtDueToBankAmt
	 */
	public Double getArrngNextPymtDueToBankAmt() {
		return arrngNextPymtDueToBankAmt;
	}
	/**
	 * @param arrngNextPymtDueToBankAmt the arrngNextPymtDueToBankAmt to set
	 */
	public void setArrngNextPymtDueToBankAmt(Double arrngNextPymtDueToBankAmt) {
		this.arrngNextPymtDueToBankAmt = arrngNextPymtDueToBankAmt;
	}
	/**
	 * @return the arrngLastPymtDueToBankDate
	 */
	public Date getArrngLastPymtDueToBankDate() {
		return arrngLastPymtDueToBankDate;
	}
	/**
	 * @param arrngLastPymtDueToBankDate the arrngLastPymtDueToBankDate to set
	 */
	public void setArrngLastPymtDueToBankDate(Date arrngLastPymtDueToBankDate) {
		this.arrngLastPymtDueToBankDate = arrngLastPymtDueToBankDate;
	}
	/**
	 * @return the arrngLastPymtDueToBankAmt
	 */
	public Double getArrngLastPymtDueToBankAmt() {
		return arrngLastPymtDueToBankAmt;
	}
	/**
	 * @param arrngLastPymtDueToBankAmt the arrngLastPymtDueToBankAmt to set
	 */
	public void setArrngLastPymtDueToBankAmt(Double arrngLastPymtDueToBankAmt) {
		this.arrngLastPymtDueToBankAmt = arrngLastPymtDueToBankAmt;
	}
	/**
	 * @return the acctFirstAdvnceDate
	 */
	public Date getAcctFirstAdvnceDate() {
		return acctFirstAdvnceDate;
	}
	/**
	 * @param acctFirstAdvnceDate the acctFirstAdvnceDate to set
	 */
	public void setAcctFirstAdvnceDate(Date acctFirstAdvnceDate) {
		this.acctFirstAdvnceDate = acctFirstAdvnceDate;
	}
	/**
	 * @return the acctFirstAdvanceAmt
	 */
	public Double getAcctFirstAdvanceAmt() {
		return acctFirstAdvanceAmt;
	}
	/**
	 * @param acctFirstAdvanceAmt the acctFirstAdvanceAmt to set
	 */
	public void setAcctFirstAdvanceAmt(Double acctFirstAdvanceAmt) {
		this.acctFirstAdvanceAmt = acctFirstAdvanceAmt;
	}
	/**
	 * @return the acctFirstPymtDate
	 */
	public Date getAcctFirstPymtDate() {
		return acctFirstPymtDate;
	}
	/**
	 * @param acctFirstPymtDate the acctFirstPymtDate to set
	 */
	public void setAcctFirstPymtDate(Date acctFirstPymtDate) {
		this.acctFirstPymtDate = acctFirstPymtDate;
	}
	/**
	 * @return the acctFirstPymtAmt
	 */
	public Double getAcctFirstPymtAmt() {
		return acctFirstPymtAmt;
	}
	/**
	 * @param acctFirstPymtAmt the acctFirstPymtAmt to set
	 */
	public void setAcctFirstPymtAmt(Double acctFirstPymtAmt) {
		this.acctFirstPymtAmt = acctFirstPymtAmt;
	}
	/**
	 * @return the acctLastAdvanceDate
	 */
	public Date getAcctLastAdvanceDate() {
		return acctLastAdvanceDate;
	}
	/**
	 * @param acctLastAdvanceDate the acctLastAdvanceDate to set
	 */
	public void setAcctLastAdvanceDate(Date acctLastAdvanceDate) {
		this.acctLastAdvanceDate = acctLastAdvanceDate;
	}
	/**
	 * @return the acctLastAdvanceAmt
	 */
	public Double getAcctLastAdvanceAmt() {
		return acctLastAdvanceAmt;
	}
	/**
	 * @param acctLastAdvanceAmt the acctLastAdvanceAmt to set
	 */
	public void setAcctLastAdvanceAmt(Double acctLastAdvanceAmt) {
		this.acctLastAdvanceAmt = acctLastAdvanceAmt;
	}
	/**
	 * @return the missedPymtNumbr
	 */
	public Integer getMissedPymtNumbr() {
		return missedPymtNumbr;
	}
	/**
	 * @param missedPymtNumbr the missedPymtNumbr to set
	 */
	public void setMissedPymtNumbr(Integer missedPymtNumbr) {
		this.missedPymtNumbr = missedPymtNumbr;
	}
	/**
	 * @return the acctLastRecoveryDate
	 */
	public Date getAcctLastRecoveryDate() {
		return acctLastRecoveryDate;
	}
	/**
	 * @param acctLastRecoveryDate the acctLastRecoveryDate to set
	 */
	public void setAcctLastRecoveryDate(Date acctLastRecoveryDate) {
		this.acctLastRecoveryDate = acctLastRecoveryDate;
	}
	/**
	 * @return the acctLastInstallDate
	 */
	public Date getAcctLastInstallDate() {
		return acctLastInstallDate;
	}
	/**
	 * @param acctLastInstallDate the acctLastInstallDate to set
	 */
	public void setAcctLastInstallDate(Date acctLastInstallDate) {
		this.acctLastInstallDate = acctLastInstallDate;
	}
	/**
	 * @return the totalPymts
	 */
	public Double getTotalPymts() {
		return totalPymts;
	}
	/**
	 * @param totalPymts the totalPymts to set
	 */
	public void setTotalPymts(Double totalPymts) {
		this.totalPymts = totalPymts;
	}
	/**
	 * @return the acctLastIntrReviewDate
	 */
	public Date getAcctLastIntrReviewDate() {
		return acctLastIntrReviewDate;
	}
	/**
	 * @param acctLastIntrReviewDate the acctLastIntrReviewDate to set
	 */
	public void setAcctLastIntrReviewDate(Date acctLastIntrReviewDate) {
		this.acctLastIntrReviewDate = acctLastIntrReviewDate;
	}
	/**
	 * @return the lastIntrCollectionDate
	 */
	public Date getLastIntrCollectionDate() {
		return lastIntrCollectionDate;
	}
	/**
	 * @param lastIntrCollectionDate the lastIntrCollectionDate to set
	 */
	public void setLastIntrCollectionDate(Date lastIntrCollectionDate) {
		this.lastIntrCollectionDate = lastIntrCollectionDate;
	}
	/**
	 * @return the eDelq30DayPst2YrsFlg
	 */
	public String geteDelq30DayPst2YrsFlg() {
		return eDelq30DayPst2YrsFlg;
	}
	/**
	 * @param eDelq30DayPst2YrsFlg the eDelq30DayPst2YrsFlg to set
	 */
	public void setEDelq30DayPst2YrsFlg(String eDelq30DayPst2YrsFlg) {
		this.eDelq30DayPst2YrsFlg = eDelq30DayPst2YrsFlg;
	}
	/**
	 * @return the eArrngSecureTypeId
	 */
	public Integer geteArrngSecureTypeId() {
		return eArrngSecureTypeId;
	}
	/**
	 * @param eArrngSecureTypeId the eArrngSecureTypeId to set
	 */
	public void setEArrngSecureTypeId(Integer eArrngSecureTypeId) {
		this.eArrngSecureTypeId = eArrngSecureTypeId;
	}
	/**
	 * @return the lienPositionTypeId
	 */
	public Integer getLienPositionTypeId() {
		return lienPositionTypeId;
	}
	/**
	 * @param lienPositionTypeId the lienPositionTypeId to set
	 */
	public void setLienPositionTypeId(Integer lienPositionTypeId) {
		this.lienPositionTypeId = lienPositionTypeId;
	}
	/**
	 * @return the probabilityOfDefault
	 */
	public Double getProbabilityOfDefault() {
		return probabilityOfDefault;
	}
	/**
	 * @param probabilityOfDefault the probabilityOfDefault to set
	 */
	public void setProbabilityOfDefault(Double probabilityOfDefault) {
		this.probabilityOfDefault = probabilityOfDefault;
	}
	/**
	 * @return the eBaselPortfolioId
	 */
	public String geteBaselPortfolioId() {
		return eBaselPortfolioId;
	}
	/**
	 * @param eBaselPortfolioId the eBaselPortfolioId to set
	 */
	public void setEBaselPortfolioId(String eBaselPortfolioId) {
		this.eBaselPortfolioId = eBaselPortfolioId;
	}
	/**
	 * @return the otherAltId
	 */
	public String getOtherAltId() {
		return otherAltId;
	}
	/**
	 * @param otherAltId the otherAltId to set
	 */
	public void setOtherAltId(String otherAltId) {
		this.otherAltId = otherAltId;
	}
	/**
	 * @return the eCreditFacTypeId
	 */
	public Integer geteCreditFacTypeId() {
		return eCreditFacTypeId;
	}
	/**
	 * @param eCreditFacTypeId the eCreditFacTypeId to set
	 */
	public void setECreditFacTypeId(Integer eCreditFacTypeId) {
		this.eCreditFacTypeId = eCreditFacTypeId;
	}
	/**
	 * @return the eFacLegalStstTypeId
	 */
	public Integer geteFacLegalStstTypeId() {
		return eFacLegalStstTypeId;
	}
	/**
	 * @param eFacLegalStstTypeId the eFacLegalStstTypeId to set
	 */
	public void setEFacLegalStstTypeId(Integer eFacLegalStstTypeId) {
		this.eFacLegalStstTypeId = eFacLegalStstTypeId;
	}
	/**
	 * @return the facilityLegalStsDate
	 */
	public Date getFacilityLegalStsDate() {
		return facilityLegalStsDate;
	}
	/**
	 * @param facilityLegalStsDate the facilityLegalStsDate to set
	 */
	public void setFacilityLegalStsDate(Date facilityLegalStsDate) {
		this.facilityLegalStsDate = facilityLegalStsDate;
	}
	/**
	 * @return the eCredFacArrngApprvTypeId
	 */
	public Integer geteCredFacArrngApprvTypeId() {
		return eCredFacArrngApprvTypeId;
	}
	/**
	 * @param eCredFacArrngApprvTypeId the eCredFacArrngApprvTypeId to set
	 */
	public void setECredFacArrngApprvTypeId(Integer eCredFacArrngApprvTypeId) {
		this.eCredFacArrngApprvTypeId = eCredFacArrngApprvTypeId;
	}
	/**
	 * @return the credFacArrngApprvDate
	 */
	public Date getCredFacArrngApprvDate() {
		return credFacArrngApprvDate;
	}
	/**
	 * @param credFacArrngApprvDate the credFacArrngApprvDate to set
	 */
	public void setCredFacArrngApprvDate(Date credFacArrngApprvDate) {
		this.credFacArrngApprvDate = credFacArrngApprvDate;
	}
	/**
	 * @return the credFacRegSegTypeId
	 */
	public Integer getCredFacRegSegTypeId() {
		return credFacRegSegTypeId;
	}
	/**
	 * @param credFacRegSegTypeId the credFacRegSegTypeId to set
	 */
	public void setCredFacRegSegTypeId(Integer credFacRegSegTypeId) {
		this.credFacRegSegTypeId = credFacRegSegTypeId;
	}
	/**
	 * @return the credFacAvailStsTypeId
	 */
	public Integer getCredFacAvailStsTypeId() {
		return credFacAvailStsTypeId;
	}
	/**
	 * @param credFacAvailStsTypeId the credFacAvailStsTypeId to set
	 */
	public void setCredFacAvailStsTypeId(Integer credFacAvailStsTypeId) {
		this.credFacAvailStsTypeId = credFacAvailStsTypeId;
	}
	/**
	 * @return the originalAdvisedCommitLimit
	 */
	public BigDecimal getOriginalAdvisedCommitLimit() {
		return originalAdvisedCommitLimit;
	}
	/**
	 * @param originalAdvisedCommitLimit the originalAdvisedCommitLimit to set
	 */
	public void setOriginalAdvisedCommitLimit(BigDecimal originalAdvisedCommitLimit) {
		this.originalAdvisedCommitLimit = originalAdvisedCommitLimit;
	}
	/**
	 * @return the originalAdvisedUncommittedLimit
	 */
	public BigDecimal getOriginalAdvisedUncommittedLimit() {
		return originalAdvisedUncommittedLimit;
	}
	/**
	 * @param originalAdvisedUncommittedLimit the originalAdvisedUncommittedLimit to set
	 */
	public void setOriginalAdvisedUncommittedLimit(
			BigDecimal originalAdvisedUncommittedLimit) {
		this.originalAdvisedUncommittedLimit = originalAdvisedUncommittedLimit;
	}
	/**
	 * @return the originalUnadvisedUncommitLimit
	 */
	public Double getOriginalUnadvisedUncommitLimit() {
		return originalUnadvisedUncommitLimit;
	}
	/**
	 * @param originalUnadvisedUncommitLimit the originalUnadvisedUncommitLimit to set
	 */
	public void setOriginalUnadvisedUncommitLimit(
			Double originalUnadvisedUncommitLimit) {
		this.originalUnadvisedUncommitLimit = originalUnadvisedUncommitLimit;
	}
	/**
	 * @return the lastCreditLimitChangeDate
	 */
	public Date getLastCreditLimitChangeDate() {
		return lastCreditLimitChangeDate;
	}
	/**
	 * @param lastCreditLimitChangeDate the lastCreditLimitChangeDate to set
	 */
	public void setLastCreditLimitChangeDate(Date lastCreditLimitChangeDate) {
		this.lastCreditLimitChangeDate = lastCreditLimitChangeDate;
	}
	/**
	 * @return the credLimitChangeTypeId
	 */
	public Integer getCredLimitChangeTypeId() {
		return credLimitChangeTypeId;
	}
	/**
	 * @param credLimitChangeTypeId the credLimitChangeTypeId to set
	 */
	public void setCredLimitChangeTypeId(Integer credLimitChangeTypeId) {
		this.credLimitChangeTypeId = credLimitChangeTypeId;
	}
	/**
	 * @return the credLimitEffectiveDate
	 */
	public Date getCredLimitEffectiveDate() {
		return credLimitEffectiveDate;
	}
	/**
	 * @param credLimitEffectiveDate the credLimitEffectiveDate to set
	 */
	public void setCredLimitEffectiveDate(Date credLimitEffectiveDate) {
		this.credLimitEffectiveDate = credLimitEffectiveDate;
	}
	/**
	 * @return the credLimitEndDate
	 */
	public Date getCredLimitEndDate() {
		return credLimitEndDate;
	}
	/**
	 * @param credLimitEndDate the credLimitEndDate to set
	 */
	public void setCredLimitEndDate(Date credLimitEndDate) {
		this.credLimitEndDate = credLimitEndDate;
	}
	/**
	 * @return the eCredLimitEvtIntTypeId
	 */
	public String geteCredLimitEvtIntTypeId() {
		return eCredLimitEvtIntTypeId;
	}
	/**
	 * @param eCredLimitEvtIntTypeId the eCredLimitEvtIntTypeId to set
	 */
	public void setECredLimitEvtIntTypeId(String eCredLimitEvtIntTypeId) {
		this.eCredLimitEvtIntTypeId = eCredLimitEvtIntTypeId;
	}
	/**
	 * @return the credLimitEventAmt
	 */
	public Double getCredLimitEventAmt() {
		return credLimitEventAmt;
	}
	/**
	 * @param credLimitEventAmt the credLimitEventAmt to set
	 */
	public void setCredLimitEventAmt(Double credLimitEventAmt) {
		this.credLimitEventAmt = credLimitEventAmt;
	}
	/**
	 * @return the eCcarProdCode
	 */
	public String geteCcarProdCode() {
		return eCcarProdCode;
	}
	/**
	 * @param eCcarProdCode the eCcarProdCode to set
	 */
	public void setECcarProdCode(String eCcarProdCode) {
		this.eCcarProdCode = eCcarProdCode;
	}
	/**
	 * @return the bankruptcyCode
	 */
	public Date getBankruptcyCode() {
		return bankruptcyCode;
	}
	/**
	 * @param bankruptcyCode the bankruptcyCode to set
	 */
	public void setBankruptcyCode(Date bankruptcyCode) {
		this.bankruptcyCode = bankruptcyCode;
	}
	/**
	 * @return the promoIntrRateEligibleFlg
	 */
	public String getPromoIntrRateEligibleFlg() {
		return promoIntrRateEligibleFlg;
	}
	/**
	 * @param promoIntrRateEligibleFlg the promoIntrRateEligibleFlg to set
	 */
	public void setPromoIntrRateEligibleFlg(String promoIntrRateEligibleFlg) {
		this.promoIntrRateEligibleFlg = promoIntrRateEligibleFlg;
	}
	/**
	 * @return the pmacPortfolioId
	 */
	public String getPmacPortfolioId() {
		return pmacPortfolioId;
	}
	/**
	 * @param pmacPortfolioId the pmacPortfolioId to set
	 */
	public void setPmacPortfolioId(String pmacPortfolioId) {
		this.pmacPortfolioId = pmacPortfolioId;
	}
	/**
	 * @return the eOrigAcctNumb
	 */
	public String geteOrigAcctNumb() {
		return eOrigAcctNumb;
	}
	/**
	 * @param eOrigAcctNumb the eOrigAcctNumb to set
	 */
	public void setEOrigAcctNumb(String eOrigAcctNumb) {
		this.eOrigAcctNumb = eOrigAcctNumb;
	}
	/**
	 * @return the lastWriteDownDate
	 */
	public Date getLastWriteDownDate() {
		return lastWriteDownDate;
	}
	/**
	 * @param lastWriteDownDate the lastWriteDownDate to set
	 */
	public void setLastWriteDownDate(Date lastWriteDownDate) {
		this.lastWriteDownDate = lastWriteDownDate;
	}
	/**
	 * @return the currentlyNegativeAmortizeFlg
	 */
	public String getCurrentlyNegativeAmortizeFlg() {
		return currentlyNegativeAmortizeFlg;
	}
	/**
	 * @param currentlyNegativeAmortizeFlg the currentlyNegativeAmortizeFlg to set
	 */
	public void setCurrentlyNegativeAmortizeFlg(String currentlyNegativeAmortizeFlg) {
		this.currentlyNegativeAmortizeFlg = currentlyNegativeAmortizeFlg;
	}
	/**
	 * @return the principalDeferralOptionFlg
	 */
	public String getPrincipalDeferralOptionFlg() {
		return principalDeferralOptionFlg;
	}
	/**
	 * @param principalDeferralOptionFlg the principalDeferralOptionFlg to set
	 */
	public void setPrincipalDeferralOptionFlg(String principalDeferralOptionFlg) {
		this.principalDeferralOptionFlg = principalDeferralOptionFlg;
	}
	/**
	 * @return the principalDefrralOptionEndDate
	 */
	public Date getPrincipalDefrralOptionEndDate() {
		return principalDefrralOptionEndDate;
	}
	/**
	 * @param principalDefrralOptionEndDate the principalDefrralOptionEndDate to set
	 */
	public void setPrincipalDefrralOptionEndDate(Date principalDefrralOptionEndDate) {
		this.principalDefrralOptionEndDate = principalDefrralOptionEndDate;
	}
	/**
	 * @return the intrDeferralOptionFlg
	 */
	public String getIntrDeferralOptionFlg() {
		return intrDeferralOptionFlg;
	}
	/**
	 * @param intrDeferralOptionFlg the intrDeferralOptionFlg to set
	 */
	public void setIntrDeferralOptionFlg(String intrDeferralOptionFlg) {
		this.intrDeferralOptionFlg = intrDeferralOptionFlg;
	}
	/**
	 * @return the intrDeferralOptionEndDate
	 */
	public Date getIntrDeferralOptionEndDate() {
		return intrDeferralOptionEndDate;
	}
	/**
	 * @param intrDeferralOptionEndDate the intrDeferralOptionEndDate to set
	 */
	public void setIntrDeferralOptionEndDate(Date intrDeferralOptionEndDate) {
		this.intrDeferralOptionEndDate = intrDeferralOptionEndDate;
	}
	/**
	 * @return the intrOnlyOptionEndDate
	 */
	public Date getIntrOnlyOptionEndDate() {
		return intrOnlyOptionEndDate;
	}
	/**
	 * @param intrOnlyOptionEndDate the intrOnlyOptionEndDate to set
	 */
	public void setIntrOnlyOptionEndDate(Date intrOnlyOptionEndDate) {
		this.intrOnlyOptionEndDate = intrOnlyOptionEndDate;
	}
	/**
	 * @return the eEverWrittenOffFlg
	 */
	public String geteEverWrittenOffFlg() {
		return eEverWrittenOffFlg;
	}
	/**
	 * @param eEverWrittenOffFlg the eEverWrittenOffFlg to set
	 */
	public void setEEverWrittenOffFlg(String eEverWrittenOffFlg) {
		this.eEverWrittenOffFlg = eEverWrittenOffFlg;
	}
	/**
	 * @return the acctFundsAdvancedCompleteFlg
	 */
	public String getAcctFundsAdvancedCompleteFlg() {
		return acctFundsAdvancedCompleteFlg;
	}
	/**
	 * @param acctFundsAdvancedCompleteFlg the acctFundsAdvancedCompleteFlg to set
	 */
	public void setAcctFundsAdvancedCompleteFlg(String acctFundsAdvancedCompleteFlg) {
		this.acctFundsAdvancedCompleteFlg = acctFundsAdvancedCompleteFlg;
	}
	/**
	 * @return the totFundsDisbursedAmt
	 */
	public Double getTotFundsDisbursedAmt() {
		return totFundsDisbursedAmt;
	}
	/**
	 * @param totFundsDisbursedAmt the totFundsDisbursedAmt to set
	 */
	public void setTotFundsDisbursedAmt(Double totFundsDisbursedAmt) {
		this.totFundsDisbursedAmt = totFundsDisbursedAmt;
	}
	/**
	 * @return the monthsOnBooksLocal
	 */
	public Integer getMonthsOnBooksLocal() {
		return monthsOnBooksLocal;
	}
	/**
	 * @param monthsOnBooksLocal the monthsOnBooksLocal to set
	 */
	public void setMonthsOnBooksLocal(Integer monthsOnBooksLocal) {
		this.monthsOnBooksLocal = monthsOnBooksLocal;
	}
	/**
	 * @return the eRiskMgmtInd
	 */
	public String geteRiskMgmtInd() {
		return eRiskMgmtInd;
	}
	/**
	 * @param eRiskMgmtInd the eRiskMgmtInd to set
	 */
	public void setERiskMgmtInd(String eRiskMgmtInd) {
		this.eRiskMgmtInd = eRiskMgmtInd;
	}
	/**
	 * @return the daysPastDueCycleEnd
	 */
	public Integer getDaysPastDueCycleEnd() {
		return daysPastDueCycleEnd;
	}
	/**
	 * @param daysPastDueCycleEnd the daysPastDueCycleEnd to set
	 */
	public void setDaysPastDueCycleEnd(Integer daysPastDueCycleEnd) {
		this.daysPastDueCycleEnd = daysPastDueCycleEnd;
	}
	/**
	 * @return the delinqBucket
	 */
	public Integer getDelinqBucket() {
		return delinqBucket;
	}
	/**
	 * @param delinqBucket the delinqBucket to set
	 */
	public void setDelinqBucket(Integer delinqBucket) {
		this.delinqBucket = delinqBucket;
	}
	/**
	 * @return the cycleEndDelinqBucket
	 */
	public Integer getCycleEndDelinqBucket() {
		return cycleEndDelinqBucket;
	}
	/**
	 * @param cycleEndDelinqBucket the cycleEndDelinqBucket to set
	 */
	public void setCycleEndDelinqBucket(Integer cycleEndDelinqBucket) {
		this.cycleEndDelinqBucket = cycleEndDelinqBucket;
	}
	/**
	 * @return the reservedForFutureGenesisUsage1
	 */
	public String getReservedForFutureGenesisUsage1() {
		return reservedForFutureGenesisUsage1;
	}
	/**
	 * @param reservedForFutureGenesisUsage1 the reservedForFutureGenesisUsage1 to set
	 */
	public void setReservedForFutureGenesisUsage1(
			String reservedForFutureGenesisUsage1) {
		this.reservedForFutureGenesisUsage1 = reservedForFutureGenesisUsage1;
	}
	/**
	 * @return the reservedForFutureGenesisUsage2
	 */
	public String getReservedForFutureGenesisUsage2() {
		return reservedForFutureGenesisUsage2;
	}
	/**
	 * @param reservedForFutureGenesisUsage2 the reservedForFutureGenesisUsage2 to set
	 */
	public void setReservedForFutureGenesisUsage2(
			String reservedForFutureGenesisUsage2) {
		this.reservedForFutureGenesisUsage2 = reservedForFutureGenesisUsage2;
	}
	/**
	 * @return the reservedForFutureGenesisUsage3
	 */
	public String getReservedForFutureGenesisUsage3() {
		return reservedForFutureGenesisUsage3;
	}
	/**
	 * @param reservedForFutureGenesisUsage3 the reservedForFutureGenesisUsage3 to set
	 */
	public void setReservedForFutureGenesisUsage3(
			String reservedForFutureGenesisUsage3) {
		this.reservedForFutureGenesisUsage3 = reservedForFutureGenesisUsage3;
	}
	/**
	 * @return the reservedForFutureGenesisUsage4
	 */
	public String getReservedForFutureGenesisUsage4() {
		return reservedForFutureGenesisUsage4;
	}
	/**
	 * @param reservedForFutureGenesisUsage4 the reservedForFutureGenesisUsage4 to set
	 */
	public void setReservedForFutureGenesisUsage4(
			String reservedForFutureGenesisUsage4) {
		this.reservedForFutureGenesisUsage4 = reservedForFutureGenesisUsage4;
	}
	/**
	 * @return the reservedForFutureGenesisUsage5
	 */
	public String getReservedForFutureGenesisUsage5() {
		return reservedForFutureGenesisUsage5;
	}
	/**
	 * @param reservedForFutureGenesisUsage5 the reservedForFutureGenesisUsage5 to set
	 */
	public void setReservedForFutureGenesisUsage5(
			String reservedForFutureGenesisUsage5) {
		this.reservedForFutureGenesisUsage5 = reservedForFutureGenesisUsage5;
	}
	/**
	 * @return the reservedForFutureGenesisUsage6
	 */
	public String getReservedForFutureGenesisUsage6() {
		return reservedForFutureGenesisUsage6;
	}
	/**
	 * @param reservedForFutureGenesisUsage6 the reservedForFutureGenesisUsage6 to set
	 */
	public void setReservedForFutureGenesisUsage6(
			String reservedForFutureGenesisUsage6) {
		this.reservedForFutureGenesisUsage6 = reservedForFutureGenesisUsage6;
	}
	/**
	 * @return the reservedForFutureGenesisUsage7
	 */
	public String getReservedForFutureGenesisUsage7() {
		return reservedForFutureGenesisUsage7;
	}
	/**
	 * @param reservedForFutureGenesisUsage7 the reservedForFutureGenesisUsage7 to set
	 */
	public void setReservedForFutureGenesisUsage7(
			String reservedForFutureGenesisUsage7) {
		this.reservedForFutureGenesisUsage7 = reservedForFutureGenesisUsage7;
	}
	/**
	 * @return the reservedForFutureGenesisUsage8
	 */
	public String getReservedForFutureGenesisUsage8() {
		return reservedForFutureGenesisUsage8;
	}
	/**
	 * @param reservedForFutureGenesisUsage8 the reservedForFutureGenesisUsage8 to set
	 */
	public void setReservedForFutureGenesisUsage8(
			String reservedForFutureGenesisUsage8) {
		this.reservedForFutureGenesisUsage8 = reservedForFutureGenesisUsage8;
	}
	/**
	 * @return the reservedForFutureGenesisUsage9
	 */
	public String getReservedForFutureGenesisUsage9() {
		return reservedForFutureGenesisUsage9;
	}
	/**
	 * @param reservedForFutureGenesisUsage9 the reservedForFutureGenesisUsage9 to set
	 */
	public void setReservedForFutureGenesisUsage9(
			String reservedForFutureGenesisUsage9) {
		this.reservedForFutureGenesisUsage9 = reservedForFutureGenesisUsage9;
	}
	/**
	 * @return the reservedForFutureGenesisUsage10
	 */
	public String getReservedForFutureGenesisUsage10() {
		return reservedForFutureGenesisUsage10;
	}
	/**
	 * @param reservedForFutureGenesisUsage10 the reservedForFutureGenesisUsage10 to set
	 */
	public void setReservedForFutureGenesisUsage10(
			String reservedForFutureGenesisUsage10) {
		this.reservedForFutureGenesisUsage10 = reservedForFutureGenesisUsage10;
	}
	/**
	 * @return the reservedForFutureGenesisUsage11
	 */
	public String getReservedForFutureGenesisUsage11() {
		return reservedForFutureGenesisUsage11;
	}
	/**
	 * @param reservedForFutureGenesisUsage11 the reservedForFutureGenesisUsage11 to set
	 */
	public void setReservedForFutureGenesisUsage11(
			String reservedForFutureGenesisUsage11) {
		this.reservedForFutureGenesisUsage11 = reservedForFutureGenesisUsage11;
	}
	/**
	 * @return the reservedForFutureGenesisUsage12
	 */
	public String getReservedForFutureGenesisUsage12() {
		return reservedForFutureGenesisUsage12;
	}
	/**
	 * @param reservedForFutureGenesisUsage12 the reservedForFutureGenesisUsage12 to set
	 */
	public void setReservedForFutureGenesisUsage12(
			String reservedForFutureGenesisUsage12) {
		this.reservedForFutureGenesisUsage12 = reservedForFutureGenesisUsage12;
	}
	/**
	 * @return the reservedForFutureGenesisUsage13
	 */
	public String getReservedForFutureGenesisUsage13() {
		return reservedForFutureGenesisUsage13;
	}
	/**
	 * @param reservedForFutureGenesisUsage13 the reservedForFutureGenesisUsage13 to set
	 */
	public void setReservedForFutureGenesisUsage13(
			String reservedForFutureGenesisUsage13) {
		this.reservedForFutureGenesisUsage13 = reservedForFutureGenesisUsage13;
	}
	/**
	 * @return the reservedForFutureGenesisUsage14
	 */
	public String getReservedForFutureGenesisUsage14() {
		return reservedForFutureGenesisUsage14;
	}
	/**
	 * @param reservedForFutureGenesisUsage14 the reservedForFutureGenesisUsage14 to set
	 */
	public void setReservedForFutureGenesisUsage14(
			String reservedForFutureGenesisUsage14) {
		this.reservedForFutureGenesisUsage14 = reservedForFutureGenesisUsage14;
	}
	/**
	 * @return the reservedForFutureGenesisUsage15
	 */
	public String getReservedForFutureGenesisUsage15() {
		return reservedForFutureGenesisUsage15;
	}
	/**
	 * @param reservedForFutureGenesisUsage15 the reservedForFutureGenesisUsage15 to set
	 */
	public void setReservedForFutureGenesisUsage15(
			String reservedForFutureGenesisUsage15) {
		this.reservedForFutureGenesisUsage15 = reservedForFutureGenesisUsage15;
	}
	/**
	 * @return the reservedForFutureGenesisUsage16
	 */
	public String getReservedForFutureGenesisUsage16() {
		return reservedForFutureGenesisUsage16;
	}
	/**
	 * @param reservedForFutureGenesisUsage16 the reservedForFutureGenesisUsage16 to set
	 */
	public void setReservedForFutureGenesisUsage16(
			String reservedForFutureGenesisUsage16) {
		this.reservedForFutureGenesisUsage16 = reservedForFutureGenesisUsage16;
	}
	/**
	 * @return the reservedForFutureGenesisUsage17
	 */
	public String getReservedForFutureGenesisUsage17() {
		return reservedForFutureGenesisUsage17;
	}
	/**
	 * @param reservedForFutureGenesisUsage17 the reservedForFutureGenesisUsage17 to set
	 */
	public void setReservedForFutureGenesisUsage17(
			String reservedForFutureGenesisUsage17) {
		this.reservedForFutureGenesisUsage17 = reservedForFutureGenesisUsage17;
	}
	/**
	 * @return the reservedForFutureGenesisUsage18
	 */
	public String getReservedForFutureGenesisUsage18() {
		return reservedForFutureGenesisUsage18;
	}
	/**
	 * @param reservedForFutureGenesisUsage18 the reservedForFutureGenesisUsage18 to set
	 */
	public void setReservedForFutureGenesisUsage18(
			String reservedForFutureGenesisUsage18) {
		this.reservedForFutureGenesisUsage18 = reservedForFutureGenesisUsage18;
	}
	/**
	 * @return the reservedForFutureGenesisUsage19
	 */
	public String getReservedForFutureGenesisUsage19() {
		return reservedForFutureGenesisUsage19;
	}
	/**
	 * @param reservedForFutureGenesisUsage19 the reservedForFutureGenesisUsage19 to set
	 */
	public void setReservedForFutureGenesisUsage19(
			String reservedForFutureGenesisUsage19) {
		this.reservedForFutureGenesisUsage19 = reservedForFutureGenesisUsage19;
	}
	/**
	 * @return the eUniqIdSrsInvPty
	 */
	public String geteUniqIdSrsInvPty() {
		return eUniqIdSrsInvPty;
	}
	/**
	 * @param eUniqIdSrsInvPty the eUniqIdSrsInvPty to set
	 */
	public void setEUniqIdSrsInvPty(String eUniqIdSrsInvPty) {
		this.eUniqIdSrsInvPty = eUniqIdSrsInvPty;
	}
	/**
	 * @return the eArrngInvlvPtyRoleType
	 */
	public String geteArrngInvlvPtyRoleType() {
		return eArrngInvlvPtyRoleType;
	}
	/**
	 * @param eArrngInvlvPtyRoleType the eArrngInvlvPtyRoleType to set
	 */
	public void setEArrngInvlvPtyRoleType(String eArrngInvlvPtyRoleType) {
		this.eArrngInvlvPtyRoleType = eArrngInvlvPtyRoleType;
	}
	/**
	 * @return the ePercentAmt
	 */
	public BigDecimal getePercentAmt() {
		return ePercentAmt;
	}
	/**
	 * @param ePercentAmt the ePercentAmt to set
	 */
	public void setEPercentAmt(BigDecimal ePercentAmt) {
		this.ePercentAmt = ePercentAmt;
	}
	/**
	 * @return the eInvlvPtySubTypeId
	 */
	public String geteInvlvPtySubTypeId() {
		return eInvlvPtySubTypeId;
	}
	/**
	 * @param eInvlvPtySubTypeId the eInvlvPtySubTypeId to set
	 */
	public void setEInvlvPtySubTypeId(String eInvlvPtySubTypeId) {
		this.eInvlvPtySubTypeId = eInvlvPtySubTypeId;
	}
	/**
	 * @return the eRatingIssuerId
	 */
	public String geteRatingIssuerId() {
		return eRatingIssuerId;
	}
	/**
	 * @param eRatingIssuerId the eRatingIssuerId to set
	 */
	public void setERatingIssuerId(String eRatingIssuerId) {
		this.eRatingIssuerId = eRatingIssuerId;
	}
	/**
	 * @return the eModelCode
	 */
	public String geteModelCode() {
		return eModelCode;
	}
	/**
	 * @param eModelCode the eModelCode to set
	 */
	public void setEModelCode(String eModelCode) {
		this.eModelCode = eModelCode;
	}
	/**
	 * @return the eRatingEventRsnTypeId
	 */
	public Integer geteRatingEventRsnTypeId() {
		return eRatingEventRsnTypeId;
	}
	/**
	 * @param eRatingEventRsnTypeId the eRatingEventRsnTypeId to set
	 */
	public void setERatingEventRsnTypeId(Integer eRatingEventRsnTypeId) {
		this.eRatingEventRsnTypeId = eRatingEventRsnTypeId;
	}
	/**
	 * @return the eRank
	 */
	public Integer geteRank() {
		return eRank;
	}
	/**
	 * @param eRank the eRank to set
	 */
	public void setERank(Integer eRank) {
		this.eRank = eRank;
	}
	/**
	 * @return the eRatingTypeCode
	 */
	public String geteRatingTypeCode() {
		return eRatingTypeCode;
	}
	/**
	 * @param eRatingTypeCode the eRatingTypeCode to set
	 */
	public void setERatingTypeCode(String eRatingTypeCode) {
		this.eRatingTypeCode = eRatingTypeCode;
	}
	/**
	 * @return the eRatingCode
	 */
	public String geteRatingCode() {
		return eRatingCode;
	}
	/**
	 * @param eRatingCode the eRatingCode to set
	 */
	public void setERatingCode(String eRatingCode) {
		this.eRatingCode = eRatingCode;
	}
	/**
	 * @return the eFicoEquiRatingCode
	 */
	public String geteFicoEquiRatingCode() {
		return eFicoEquiRatingCode;
	}
	/**
	 * @param eFicoEquiRatingCode the eFicoEquiRatingCode to set
	 */
	public void setEFicoEquiRatingCode(String eFicoEquiRatingCode) {
		this.eFicoEquiRatingCode = eFicoEquiRatingCode;
	}
	/**
	 * @return the eRaingDescription
	 */
	public String geteRaingDescription() {
		return eRaingDescription;
	}
	/**
	 * @param eRaingDescription the eRaingDescription to set
	 */
	public void setERaingDescription(String eRaingDescription) {
		this.eRaingDescription = eRaingDescription;
	}
	/**
	 * @return the eScoreRqstReturnFlg
	 */
	public String geteScoreRqstReturnFlg() {
		return eScoreRqstReturnFlg;
	}
	/**
	 * @param eScoreRqstReturnFlg the eScoreRqstReturnFlg to set
	 */
	public void setEScoreRqstReturnFlg(String eScoreRqstReturnFlg) {
		this.eScoreRqstReturnFlg = eScoreRqstReturnFlg;
	}
	/**
	 * @return the eModelCodeAIR
	 */
	public String geteModelCodeAIR() {
		return eModelCodeAIR;
	}
	/**
	 * @param eModelCodeAIR the eModelCodeAIR to set
	 */
	public void setEModelCodeAIR(String eModelCodeAIR) {
		this.eModelCodeAIR = eModelCodeAIR;
	}
	/**
	 * @return the eResouceItemTypeId
	 */
	public Integer geteResouceItemTypeId() {
		return eResouceItemTypeId;
	}
	/**
	 * @param eResouceItemTypeId the eResouceItemTypeId to set
	 */
	public void setEResouceItemTypeId(Integer eResouceItemTypeId) {
		this.eResouceItemTypeId = eResouceItemTypeId;
	}
	/**
	 * @return the primaryCollateralIndicator
	 */
	public String getPrimaryCollateralIndicator() {
		return primaryCollateralIndicator;
	}
	/**
	 * @param primaryCollateralIndicator the primaryCollateralIndicator to set
	 */
	public void setPrimaryCollateralIndicator(String primaryCollateralIndicator) {
		this.primaryCollateralIndicator = primaryCollateralIndicator;
	}
	/**
	 * @return the revaluationCollateralInd
	 */
	public Integer getRevaluationCollateralInd() {
		return revaluationCollateralInd;
	}
	/**
	 * @param revaluationCollateralInd the revaluationCollateralInd to set
	 */
	public void setRevaluationCollateralInd(Integer revaluationCollateralInd) {
		this.revaluationCollateralInd = revaluationCollateralInd;
	}
	/**
	 * @return the resourceItemName
	 */
	public String getResourceItemName() {
		return resourceItemName;
	}
	/**
	 * @param resourceItemName the resourceItemName to set
	 */
	public void setResourceItemName(String resourceItemName) {
		this.resourceItemName = resourceItemName;
	}
	/**
	 * @return the srcSysId
	 */
	public Integer getSrcSysId() {
		return srcSysId;
	}
	/**
	 * @param srcSysId the srcSysId to set
	 */
	public void setSrcSysId(Integer srcSysId) {
		this.srcSysId = srcSysId;
	}
	/**
	 * @return the resourceItemValAmt
	 */
	public Double getResourceItemValAmt() {
		return resourceItemValAmt;
	}
	/**
	 * @param resourceItemValAmt the resourceItemValAmt to set
	 */
	public void setResourceItemValAmt(Double resourceItemValAmt) {
		this.resourceItemValAmt = resourceItemValAmt;
	}
	/**
	 * @return the eResourceItemValMethId
	 */
	public Integer geteResourceItemValMethId() {
		return eResourceItemValMethId;
	}
	/**
	 * @param eResourceItemValMethId the eResourceItemValMethId to set
	 */
	public void setEResourceItemValMethId(Integer eResourceItemValMethId) {
		this.eResourceItemValMethId = eResourceItemValMethId;
	}
	/**
	 * @return the eResourceItemValEffDate
	 */
	public Date geteResourceItemValEffDate() {
		return eResourceItemValEffDate;
	}
	/**
	 * @param eResourceItemValEffDate the eResourceItemValEffDate to set
	 */
	public void setEResourceItemValEffDate(Date eResourceItemValEffDate) {
		this.eResourceItemValEffDate = eResourceItemValEffDate;
	}
	/**
	 * @return the eResItemBalCurrId
	 */
	public Integer geteResItemBalCurrId() {
		return eResItemBalCurrId;
	}
	/**
	 * @param eResItemBalCurrId the eResItemBalCurrId to set
	 */
	public void setEResItemBalCurrId(Integer eResItemBalCurrId) {
		this.eResItemBalCurrId = eResItemBalCurrId;
	}
	/**
	 * @return the eResItemBalTypeId
	 */
	public Integer geteResItemBalTypeId() {
		return eResItemBalTypeId;
	}
	/**
	 * @param eResItemBalTypeId the eResItemBalTypeId to set
	 */
	public void setEResItemBalTypeId(Integer eResItemBalTypeId) {
		this.eResItemBalTypeId = eResItemBalTypeId;
	}
	/**
	 * @return the resItemValuationEvntReasonTypeId
	 */
	public Integer getResItemValuationEvntReasonTypeId() {
		return resItemValuationEvntReasonTypeId;
	}
	/**
	 * @param resItemValuationEvntReasonTypeId the resItemValuationEvntReasonTypeId to set
	 */
	public void setResItemValuationEvntReasonTypeId(
			Integer resItemValuationEvntReasonTypeId) {
		this.resItemValuationEvntReasonTypeId = resItemValuationEvntReasonTypeId;
	}
	/**
	 * @return the eLoanToAstRelType
	 */
	public Integer geteLoanToAstRelType() {
		return eLoanToAstRelType;
	}
	/**
	 * @param eLoanToAstRelType the eLoanToAstRelType to set
	 */
	public void setELoanToAstRelType(Integer eLoanToAstRelType) {
		this.eLoanToAstRelType = eLoanToAstRelType;
	}
	/**
	 * @return the eReltnEffDate
	 */
	public Date geteReltnEffDate() {
		return eReltnEffDate;
	}
	/**
	 * @param eReltnEffDate the eReltnEffDate to set
	 */
	public void setEReltnEffDate(Date eReltnEffDate) {
		this.eReltnEffDate = eReltnEffDate;
	}
	/**
	 * @return the collateralTypeId
	 */
	public Integer getCollateralTypeId() {
		return collateralTypeId;
	}
	/**
	 * @param collateralTypeId the collateralTypeId to set
	 */
	public void setCollateralTypeId(Integer collateralTypeId) {
		this.collateralTypeId = collateralTypeId;
	}
	/**
	 * @return the eStndrdArrgId
	 */
	public String geteStndrdArrgId() {
		return eStndrdArrgId;
	}
	/**
	 * @param eStndrdArrgId the eStndrdArrgId to set
	 */
	public void setEStndrdArrgId(String eStndrdArrgId) {
		this.eStndrdArrgId = eStndrdArrgId;
	}
	/**
	 * @return the eCreditRiskMitgTypeId
	 */
	public Integer geteCreditRiskMitgTypeId() {
		return eCreditRiskMitgTypeId;
	}
	/**
	 * @param eCreditRiskMitgTypeId the eCreditRiskMitgTypeId to set
	 */
	public void setECreditRiskMitgTypeId(Integer eCreditRiskMitgTypeId) {
		this.eCreditRiskMitgTypeId = eCreditRiskMitgTypeId;
	}
	/**
	 * @return the collateralSrcTypeId
	 */
	public Integer getCollateralSrcTypeId() {
		return collateralSrcTypeId;
	}
	/**
	 * @param collateralSrcTypeId the collateralSrcTypeId to set
	 */
	public void setCollateralSrcTypeId(Integer collateralSrcTypeId) {
		this.collateralSrcTypeId = collateralSrcTypeId;
	}
	/**
	 * @return the legalEnforcablityFlg
	 */
	public String getLegalEnforcablityFlg() {
		return legalEnforcablityFlg;
	}
	/**
	 * @param legalEnforcablityFlg the legalEnforcablityFlg to set
	 */
	public void setLegalEnforcablityFlg(String legalEnforcablityFlg) {
		this.legalEnforcablityFlg = legalEnforcablityFlg;
	}
	/**
	 * @return the legalRightToPosFlg
	 */
	public String getLegalRightToPosFlg() {
		return legalRightToPosFlg;
	}
	/**
	 * @param legalRightToPosFlg the legalRightToPosFlg to set
	 */
	public void setLegalRightToPosFlg(String legalRightToPosFlg) {
		this.legalRightToPosFlg = legalRightToPosFlg;
	}
	/**
	 * @return the reHypotheInd
	 */
	public String getReHypotheInd() {
		return reHypotheInd;
	}
	/**
	 * @param reHypotheInd the reHypotheInd to set
	 */
	public void setReHypotheInd(String reHypotheInd) {
		this.reHypotheInd = reHypotheInd;
	}
	/**
	 * @return the collateralLocCode
	 */
	public Integer getCollateralLocCode() {
		return collateralLocCode;
	}
	/**
	 * @param collateralLocCode the collateralLocCode to set
	 */
	public void setCollateralLocCode(Integer collateralLocCode) {
		this.collateralLocCode = collateralLocCode;
	}
	/**
	 * @return the intMarginOrValMargFlg
	 */
	public String getIntMarginOrValMargFlg() {
		return intMarginOrValMargFlg;
	}
	/**
	 * @param intMarginOrValMargFlg the intMarginOrValMargFlg to set
	 */
	public void setIntMarginOrValMargFlg(String intMarginOrValMargFlg) {
		this.intMarginOrValMargFlg = intMarginOrValMargFlg;
	}
	/**
	 * @return the legNumbr
	 */
	public Integer getLegNumbr() {
		return legNumbr;
	}
	/**
	 * @param legNumbr the legNumbr to set
	 */
	public void setLegNumbr(Integer legNumbr) {
		this.legNumbr = legNumbr;
	}
	/**
	 * @return the generalLdgerSysId
	 */
	public String getGeneralLdgerSysId() {
		return generalLdgerSysId;
	}
	/**
	 * @param generalLdgerSysId the generalLdgerSysId to set
	 */
	public void setGeneralLdgerSysId(String generalLdgerSysId) {
		this.generalLdgerSysId = generalLdgerSysId;
	}
	/**
	 * @return the dealId
	 */
	public Integer getDealId() {
		return dealId;
	}
	/**
	 * @param dealId the dealId to set
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	/**
	 * @return the eBookingLedgerCountryCode
	 */
	public String geteBookingLedgerCountryCode() {
		return eBookingLedgerCountryCode;
	}
	/**
	 * @param eBookingLedgerCountryCode the eBookingLedgerCountryCode to set
	 */
	public void setEBookingLedgerCountryCode(String eBookingLedgerCountryCode) {
		this.eBookingLedgerCountryCode = eBookingLedgerCountryCode;
	}
	/**
	 * @return the eBalType
	 */
	public Integer geteBalType() {
		return eBalType;
	}
	/**
	 * @param eBalType the eBalType to set
	 */
	public void setEBalType(Integer eBalType) {
		this.eBalType = eBalType;
	}
	/**
	 * @return the eGLAccount1
	 */
	public String geteGLAccount1() {
		return eGLAccount1;
	}
	/**
	 * @param eGLAccount1 the eGLAccount1 to set
	 */
	public void setEGLAccount1(String eGLAccount1) {
		this.eGLAccount1 = eGLAccount1;
	}
	/**
	 * @return the glAccount2
	 */
	public String getGlAccount2() {
		return glAccount2;
	}
	/**
	 * @param glAccount2 the glAccount2 to set
	 */
	public void setGlAccount2(String glAccount2) {
		this.glAccount2 = glAccount2;
	}
	/**
	 * @return the fdlAccount
	 */
	public String getFdlAccount() {
		return fdlAccount;
	}
	/**
	 * @param fdlAccount the fdlAccount to set
	 */
	public void setFdlAccount(String fdlAccount) {
		this.fdlAccount = fdlAccount;
	}
	/**
	 * @return the eTransCurrCode
	 */
	public String geteTransCurrCode() {
		return eTransCurrCode;
	}
	/**
	 * @param eTransCurrCode the eTransCurrCode to set
	 */
	public void setETransCurrCode(String eTransCurrCode) {
		this.eTransCurrCode = eTransCurrCode;
	}
	/**
	 * @return the eFuncCurrCode
	 */
	public String geteFuncCurrCode() {
		return eFuncCurrCode;
	}
	/**
	 * @param eFuncCurrCode the eFuncCurrCode to set
	 */
	public void setEFuncCurrCode(String eFuncCurrCode) {
		this.eFuncCurrCode = eFuncCurrCode;
	}
	/**
	 * @return the eBaseCurrCode
	 */
	public String geteBaseCurrCode() {
		return eBaseCurrCode;
	}
	/**
	 * @param eBaseCurrCode the eBaseCurrCode to set
	 */
	public void setEBaseCurrCode(String eBaseCurrCode) {
		this.eBaseCurrCode = eBaseCurrCode;
	}
	/**
	 * @return the eTransAmt
	 */
	public BigDecimal geteTransAmt() {
		return eTransAmt;
	}
	/**
	 * @param eTransAmt the eTransAmt to set
	 */
	public void setETransAmt(BigDecimal eTransAmt) {
		this.eTransAmt = eTransAmt;
	}
	/**
	 * @return the functionalAmt
	 */
	public BigDecimal getFunctionalAmt() {
		return functionalAmt;
	}
	/**
	 * @param functionalAmt the functionalAmt to set
	 */
	public void setFunctionalAmt(BigDecimal functionalAmt) {
		this.functionalAmt = functionalAmt;
	}
	/**
	 * @return the baseAmt
	 */
	public BigDecimal getBaseAmt() {
		return baseAmt;
	}
	/**
	 * @param baseAmt the baseAmt to set
	 */
	public void setBaseAmt(BigDecimal baseAmt) {
		this.baseAmt = baseAmt;
	}
	/**
	 * @return the goc
	 */
	public String getGoc() {
		return goc;
	}
	/**
	 * @param goc the goc to set
	 */
	public void setGoc(String goc) {
		this.goc = goc;
	}
	/**
	 * @return the bookingLedgerBranchCode
	 */
	public String getBookingLedgerBranchCode() {
		return bookingLedgerBranchCode;
	}
	/**
	 * @param bookingLedgerBranchCode the bookingLedgerBranchCode to set
	 */
	public void setBookingLedgerBranchCode(String bookingLedgerBranchCode) {
		this.bookingLedgerBranchCode = bookingLedgerBranchCode;
	}
	/**
	 * @return the frsBusUnitCode
	 */
	public String getFrsBusUnitCode() {
		return frsBusUnitCode;
	}
	/**
	 * @param frsBusUnitCode the frsBusUnitCode to set
	 */
	public void setFrsBusUnitCode(String frsBusUnitCode) {
		this.frsBusUnitCode = frsBusUnitCode;
	}
	/**
	 * @return the notForUse
	 */
	public String getNotForUse() {
		return notForUse;
	}
	/**
	 * @param notForUse the notForUse to set
	 */
	public void setNotForUse(String notForUse) {
		this.notForUse = notForUse;
	}
	/**
	 * @return the localDeptId
	 */
	public String getLocalDeptId() {
		return localDeptId;
	}
	/**
	 * @param localDeptId the localDeptId to set
	 */
	public void setLocalDeptId(String localDeptId) {
		this.localDeptId = localDeptId;
	}
	/**
	 * @return the eLocalLegVehicleId
	 */
	public String geteLocalLegVehicleId() {
		return eLocalLegVehicleId;
	}
	/**
	 * @param eLocalLegVehicleId the eLocalLegVehicleId to set
	 */
	public void setELocalLegVehicleId(String eLocalLegVehicleId) {
		this.eLocalLegVehicleId = eLocalLegVehicleId;
	}
	/**
	 * @return the fairValacctMethodFlg
	 */
	public String getFairValacctMethodFlg() {
		return fairValacctMethodFlg;
	}
	/**
	 * @param fairValacctMethodFlg the fairValacctMethodFlg to set
	 */
	public void setFairValacctMethodFlg(String fairValacctMethodFlg) {
		this.fairValacctMethodFlg = fairValacctMethodFlg;
	}
	/**
	 * @return the fairValLevel
	 */
	public String getFairValLevel() {
		return fairValLevel;
	}
	/**
	 * @param fairValLevel the fairValLevel to set
	 */
	public void setFairValLevel(String fairValLevel) {
		this.fairValLevel = fairValLevel;
	}
	/**
	 * @return the expenseCode
	 */
	public String getExpenseCode() {
		return expenseCode;
	}
	/**
	 * @param expenseCode the expenseCode to set
	 */
	public void setExpenseCode(String expenseCode) {
		this.expenseCode = expenseCode;
	}
	/**
	 * @return the frsAfflCode
	 */
	public String getFrsAfflCode() {
		return frsAfflCode;
	}
	/**
	 * @param frsAfflCode the frsAfflCode to set
	 */
	public void setFrsAfflCode(String frsAfflCode) {
		this.frsAfflCode = frsAfflCode;
	}
	/**
	 * @return the subStrategyCode
	 */
	public String getSubStrategyCode() {
		return subStrategyCode;
	}
	/**
	 * @param subStrategyCode the subStrategyCode to set
	 */
	public void setSubStrategyCode(String subStrategyCode) {
		this.subStrategyCode = subStrategyCode;
	}
	/**
	 * @return the eGAAPInd
	 */
	public String geteGAAPInd() {
		return eGAAPInd;
	}
	/**
	 * @param eGAAPInd the eGAAPInd to set
	 */
	public void setEGAAPInd(String eGAAPInd) {
		this.eGAAPInd = eGAAPInd;
	}
	/**
	 * @return the microCntStrtCodeOpenField1
	 */
	public String getMicroCntStrtCodeOpenField1() {
		return microCntStrtCodeOpenField1;
	}
	/**
	 * @param microCntStrtCodeOpenField1 the microCntStrtCodeOpenField1 to set
	 */
	public void setMicroCntStrtCodeOpenField1(String microCntStrtCodeOpenField1) {
		this.microCntStrtCodeOpenField1 = microCntStrtCodeOpenField1;
	}
	/**
	 * @return the firmAcctIMSNumbr
	 */
	public String getFirmAcctIMSNumbr() {
		return firmAcctIMSNumbr;
	}
	/**
	 * @param firmAcctIMSNumbr the firmAcctIMSNumbr to set
	 */
	public void setFirmAcctIMSNumbr(String firmAcctIMSNumbr) {
		this.firmAcctIMSNumbr = firmAcctIMSNumbr;
	}
	/**
	 * @return the baseNumbLocafflCode
	 */
	public String getBaseNumbLocafflCode() {
		return baseNumbLocafflCode;
	}
	/**
	 * @param baseNumbLocafflCode the baseNumbLocafflCode to set
	 */
	public void setBaseNumbLocafflCode(String baseNumbLocafflCode) {
		this.baseNumbLocafflCode = baseNumbLocafflCode;
	}
	/**
	 * @return the idProd
	 */
	public String getIdProd() {
		return idProd;
	}
	/**
	 * @param idProd the idProd to set
	 */
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	/**
	 * @return the keyCode1
	 */
	public String getKeyCode1() {
		return keyCode1;
	}
	/**
	 * @param keyCode1 the keyCode1 to set
	 */
	public void setKeyCode1(String keyCode1) {
		this.keyCode1 = keyCode1;
	}
	/**
	 * @return the keyCode2
	 */
	public String getKeyCode2() {
		return keyCode2;
	}
	/**
	 * @param keyCode2 the keyCode2 to set
	 */
	public void setKeyCode2(String keyCode2) {
		this.keyCode2 = keyCode2;
	}
	/**
	 * @return the locLedgerAcctNumb
	 */
	public String getLocLedgerAcctNumb() {
		return locLedgerAcctNumb;
	}
	/**
	 * @param locLedgerAcctNumb the locLedgerAcctNumb to set
	 */
	public void setLocLedgerAcctNumb(String locLedgerAcctNumb) {
		this.locLedgerAcctNumb = locLedgerAcctNumb;
	}
	/**
	 * @return the adjustmentInd
	 */
	public String getAdjustmentInd() {
		return adjustmentInd;
	}
	/**
	 * @param adjustmentInd the adjustmentInd to set
	 */
	public void setAdjustmentInd(String adjustmentInd) {
		this.adjustmentInd = adjustmentInd;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the adjustmentReasonCode
	 */
	public String getAdjustmentReasonCode() {
		return adjustmentReasonCode;
	}
	/**
	 * @param adjustmentReasonCode the adjustmentReasonCode to set
	 */
	public void setAdjustmentReasonCode(String adjustmentReasonCode) {
		this.adjustmentReasonCode = adjustmentReasonCode;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the localGlKey3
	 */
	public String getLocalGlKey3() {
		return localGlKey3;
	}
	/**
	 * @param localGlKey3 the localGlKey3 to set
	 */
	public void setLocalGlKey3(String localGlKey3) {
		this.localGlKey3 = localGlKey3;
	}
	/**
	 * @return the localGlKey4
	 */
	public String getLocalGlKey4() {
		return localGlKey4;
	}
	/**
	 * @param localGlKey4 the localGlKey4 to set
	 */
	public void setLocalGlKey4(String localGlKey4) {
		this.localGlKey4 = localGlKey4;
	}
	/**
	 * @return the adjStrdArrngId
	 */
	public String getAdjStrdArrngId() {
		return adjStrdArrngId;
	}
	/**
	 * @param adjStrdArrngId the adjStrdArrngId to set
	 */
	public void setAdjStrdArrngId(String adjStrdArrngId) {
		this.adjStrdArrngId = adjStrdArrngId;
	}
	/**
	 * @return the eFeePymtFreqPrdId
	 */
	public Integer geteFeePymtFreqPrdId() {
		return eFeePymtFreqPrdId;
	}
	/**
	 * @param eFeePymtFreqPrdId the eFeePymtFreqPrdId to set
	 */
	public void setEFeePymtFreqPrdId(Integer eFeePymtFreqPrdId) {
		this.eFeePymtFreqPrdId = eFeePymtFreqPrdId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommonBalanceRcTRLRecord [eCommonBalanceRcTRLRecords="
				+ eCommonBalanceRcTRLRecords + ", eUniqueIdSrcSys="
				+ eUniqueIdSrcSys + ", eSrcSysId=" + eSrcSysId
				+ ", eProdSysId=" + eProdSysId + ", eRecordType=" + eRecordType
				+ ", eAsOfDate=" + eAsOfDate + ", eGlobProdId=" + eGlobProdId
				+ ", arrngmentName=" + arrngmentName + ", description="
				+ description + ", eBookingDate=" + eBookingDate
				+ ", eOrginalEffDate=" + eOrginalEffDate + ", eEffectiveDate="
				+ eEffectiveDate + ", estimEndDate=" + estimEndDate
				+ ", eEndDate=" + eEndDate + ", eArrngTypeId=" + eArrngTypeId
				+ ", eDenominCurrId=" + eDenominCurrId + ", eOrigChnlId="
				+ eOrigChnlId + ", eArrngBusIntType=" + eArrngBusIntType
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
				+ ", eFeePymtFreqPrdId=" + eFeePymtFreqPrdId + "]";
	}
	
}
