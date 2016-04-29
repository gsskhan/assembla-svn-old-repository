package com.citi.retail.optima.etl.common.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class GclTRLRecord{
	
	//Start of Indicative attributes
	private String eUniqueId;
	private String eSrcSysId;
	private String eProdSysId;
	private String eRecType;	
	private Date eAsOfDt;
	private String eGlbProdId;
	private String eLocalProductId;
	private String localSubProductId;
	private String entStandProductId;
	private String arrngName;
	private String eDescription;
	private Date eBookingDate;
	private Date eOriginalEffDate;
	private Date eEffDate;
	private Date eEstmEndDate;
	private Date eEndDate;
	private String eDenoCurrId;
	private Integer eOrigChannelId;
	private String eArrngPurpTypeId;
	private Integer eArrngBusIntType;
	private Date eArrngBussIntDate;
	private String ePledgInd;
	private String ePledgEligInd;
	private Integer eArrngMatuTypeId;
	private String eArrngFinStatTypId;
	private Date eArrngFinStatDate;
	private Integer eArrngPastDueDayCount;	
	private Integer eGracePerDayCnt;
	private Integer eArrngPastDueAgeClass;
	private Date eArrngPastDueAgeClassDate;
	private Integer eArrngLifeCycleStatusReasonTypeId;
	private Integer eArrngLifeCycleStatusId;
	private Date eArrngLifeCycleStatusDate;
	private Date arrngNxtRenewalDate;
	private Integer arrngPriPayTypId;
	private Integer eArrngAcqTypId;
	private Date eArrngAcqDt;
	private Integer arrngDisTypId;
	private Date arrngDisTypDate;
	private Integer eChrgOffTypeId;
	private Integer oriInvInsCatId;
	private String oriInvInsActFlag;
	private BigDecimal oriInvInsPer;
	private Integer arrngDayCntConTypId;
	private Integer eIntPayFrePerId;
	private Integer eRateResetPerIntId;
	private Date inIntRateResetDate;
	private Date nxtIntRateResetDate;
	private Date prevLstIntRateResetDate;
	private String taxExemInd;
	private String onBnkRelnInd;
	private Integer eFinServiceTypId = 1;
	private Integer eFinServiceLimitTypId;
	private BigDecimal eOriginalAmt;
	private BigDecimal eOrgAmount;	
	private Integer eArrngSecTypId;
	private String citiRecInd;
	private Integer payFrePerId;
	private Integer eIntrstAccrualStatTypId;
	private Date eIntrstAccrualStatTypDate;
	private Integer intOnlyTermPeriod;
	private Integer finSerResCurStId;
	private Date finSerResCurStDate;
	private Integer finSerPrevResStId;
	private Date finSerPrevResStDate;
	private String trbDebtResFlag;
	private String mktRateYieldReneFlag;
	private String skipPayInd;
	private String eSecInd;
	private Integer trppTenor;
	private Double acctTrppInsAmt;
	private String locAutExtFlag;
	private String locTermLoanCovFlag;
	private Integer inDocTypId;
	private Date finserModProgStDate;
	private Date finserModProgEndDate;
	private Integer finSerResModRsnTypId;
	private Integer finSerModProgId;
	private Integer finSerModProgCurrSts;
	private Date finSerModProgCurrStsDate;
	private Integer finSerModProgPrevStsTypId;
	private Integer modRetenLossMitTypId;
	private Integer CreFacTypId;
	private Integer eFacilLegalStsTypId;
	private Date FacilLegalStsDate;
	private Integer eCreFacArrngAppTypId;
	private Date creFacArrngAppTypDate;
	private Integer creFacRegSegTypId;
	private Integer creFacAvastaTypId;
	private Date lstCreLmtChngDate;
	private Integer creLimitChnTypId;
	private Double eArrngNextPymtDueToBankAmt;
	private Date eArrngNextPymtDueToBankDate;
	private Date eArrngLastPymtToBankDate;
	private Integer eMissedPymtNumb;
	private Date acctLstRecDate;
	private Date acctLstInsDate;
	private Integer totPay;
	private Date acctLstIntRevDate;
	private Double PenRate;
	private Double PenAmt;
	private Double legNotDays;
	private String eBaselPortfolioId;
	private String othAltIdent;
	private String eLocalProdCategoryCode;
	private String eDelq30DayPast2YrsFlag;	
	private Integer linePosTypId;
	private Date eActualBillingCycleDate;
	private Integer feePayFreqPerId;
	private Double notPerDays;
	private Integer eCurrAmtType;
	private String feeWavFlag;
	private Date borDate;
	private Integer socEcoCatId;
	private Double acctFirstAdvAmt;	
	private Date acctFirstAdvDate;
	private Date acctFirstPayDate;
	private Double acctLastAdvAmt;
	private Date acctLastAdvDate;
	private Double acqCost;
	private String eObligorRecourseInd;	
	private Integer docTypId;
	private Date mtgModSigDate;
	private Integer mtgOriProgTypCode;
	private Integer mtgCreRiskCatIntId;
	private String eBalloonInd;
	private Integer helocTerm;
	private Integer  lmPlanCdId;
	private String escAcctMaintInd;
	private Integer mtgOriProgGroupId;
	private String comboLoanInd;
	private String sopAcctInd;
	private String negAmortFlag;
	private Integer intCalPerId;
	private String preComLoanFlag;
	private Integer amortAccInd;
	private Integer eNumSchePaymt;	
	private Integer eNumRemPaymt;
	private Date linePosTypEffDate;
	private String delqMethCode;	
	private Double accFirstPayAmt;
	private String eRestructureFlag;	
	private String eRegOEmpFlag;
	private Double probOfDefault;
	private Date eCrdtLimitEffctDate;
	private Date eCrdtLimitEndtDate;
	private String creditLmtEventInvTypId;
	private Double creditLmtEventAmt;
	private String eCcarProdCode;
	private  Date banktrupcyDate;
	private String promoIntRtaeEliFlag;
	private BigDecimal eOrgAdvisedCommitedLimit;
	private String pmacPortId;
	private String eOrgAcctNumbr;
	private Date lstWriteDwnDate;
	private String currNegAmmFlag;
	private String prinDeffOptFlag;
	private Date prinDeffOptEndDtae;
	private String intDeffOptFlag;
	private Date intDeffOptEndDtae;
	private Date intOnlyOptEndDtae;
	private BigDecimal eOrgCombLtvRatio;
	private BigDecimal eOrgLtvRatio; /////
	private Double totOriJunLienAmt;
	private String eEverWrittenOffFlag;	
	private String reoStsTypId;
	private String eNonTradeResidMtgFlag;
	private Integer mobLocal;	
	private String riskMngInd;
	private String DaysPastDueCyclEnd;
	private Integer eDelinquencyBucket;	
	private String cycleEndDelqBucket;	
	private String reservedForFutureGenesisUse1;
	private String reservedForFutureGenesisUse2;
	private String reservedForFutureGenesisUse3;
	private String reservedForFutureGenesisUse4;
	private String reservedForFutureGenesisUse5;
	private String reservedForFutureGenesisUse6;
	private String reservedForFutureGenesisUse7;
	private String reservedForFutureGenesisUse8;
	private String reservedForFutureGenesisUse9;
	private String reservedForFutureGenesisUse10;
	
	private String arrngFinStatusRsnTypId;
	private BigDecimal acctLastPaymtToBnkAcct;
	private Double orgAdvisedUnCommitedLimit;
	private Double orgUnAdvisedCommitedLimit;
	//ENd of Indicative attributes	
	//CB
    private Integer eLegNumber;
    private String eGlSysId;
    private Integer eDealId;
    private String eBookingLedgrCntryCode;   
    private String eGLAccount1;
    private String eGlAccount2;
    private String eFdlAccount;
    private BigDecimal eTxnAmt;
    private BigDecimal eFuncAmt;    
    private BigDecimal eBaseAmt;
    private String eGoc;
    private String eBookingLedgrBrCode;
    private String eFrsBuCode;
    private String eNotForUse;
    private String eLclDeptId;
    private String eLclLglVehicleCde;
    private String eFairValAcctMthFlg;
    private String eFairValLvl;
    private String eExpCode;
    private String eLocalProdCode;
    private String eFrsAffCode;
    private String eSubStatCode;
    private String eMicroCntrlCode;
    private String eFirmAccountImsNmbr;
    private String eBaseNmbr;
    private String eIdProd;
    private String eKeyCode1;
    private String eKeyCode2;
    private String eLclLdgrAcctNmbr;
    private String eAdjInd;
    private String eUserId;
    private String eAdjResnCode;
    private String eCmnReasonDesc;
    private String eLocalGlKey3;
    private String eLocalGlKey4;
    private String eAdjStndardArrngId;
    private String eAdjFinMarketPositionId;  
	//CB	
	//coll arrng
	private Integer eResourceItemTypId;
	private String primCollInd;
	private Integer revFreqId;
	private String resourceItemName;
	private String collArrngUniqueIdInSrcSys;
	private String collArrngSrcSysId;
	private String resItemValuAmt;
	private Integer eResItemValMethodId;
	private String legalEnfFlag;
	private String legalRightToPossFlag;
	private String reHypInd;
	private Integer collLocCode;
	private String inValMarginFlag;
	private Integer addTypId;
	private Integer loanToAssRelTyp;
	private Integer occTyp;
	private Date propApprDate;
	private Integer realPropTotUnit;
	private String realPropTypId;
	private String propLocName;
	private String ePropCity;
	private String ePropCountry;
	private String ePropState;
	private String ePropZipCode;
	private String ePropAddLine1;
	private String propAddLine2;
	private String propAddLine3;
	
	private String 	resItemValueAmt;
	private String 	resItemValMethodId;
	private String 	resItemValEffDt;
	private String 	eResItemBalCurrId;
	private String 	eResItemBalTypId;
	private String 	resItemValEvtRsnTypId;
	private String 	relEffDt;
	private String 	colTypId;
	private String 	eGlobProdIdentifier;
	private String 	eStdArrgId;
	private String 	arrgName;
	private String 	desc;
	private String 	bookingDt;
	private String 	origEffDt;
	private String 	effDt;
	private String 	estEndDt;
	private String 	endDt;
	private String 	arrngTypId;
	private Integer 	eDenomCurrId;
	private String 	orgChannelId;
	private String 	arrgPurpTypId;
	private String 	arrgBusIntentTyp;
	private String 	arrgBusIntntDt;
	private String 	pledgedInd;
	private String 	pledgedEligInd;
	private String 	arrgMatTypId;
	private String 	arrgFinStsTypId;
	private String 	arrgFinStsDt;
	private String 	arrgPastDueDayCnt;
	private String 	gracePrdDayCnt;
	private String 	arrgPastDueAgngClss;
	private String 	arrgPastDueAgngClssDt;
	private String 	arrgFinStsRsnTypId;
	private String 	arrgLifCyclStsTypId;
	private String 	arrgLifCyclStsRsnTypId;
	private String 	arrgLifCycStsDt;
	private String 	arrgNxtRnwlDt;
	private String 	eCreditRiskMtgtTypId;
	private String 	collSrcTypId;
	private String 	loanToAssetRelnType ;
	private String 	propApprTypId;	
	//coll arrng
	//arrng Rate
	private Double speedRatePer;
	private Integer arrngRateTypRelnTypId;
	private String rateTyp;
	private String rateId;
	private Date rateTypEffDate;
	private String eRateActiveFlag;	
	private String reservedForFutureGenesisUse11;
	private String reservedForFutureGenesisUse12;
	private String reservedForFutureGenesisUse13;
	private String reservedForFutureGenesisUse14;
	private String reservedForFutureGenesisUse15;
	private String rateName;
	private Integer eRateVarTypeId;

	//arrng Rate
	//arrng Rating
	private String eRatingIssId;
	private String eModelCd;
	private Integer eRatingEvnRsnTypId;
	private Integer eRank;
	private String eRatingTypCd;
	private String eRatingCd;
	private String eFicoEquvRatingCode;	
	private String ratingDesc;
	private String eScoreReqReturnFlag;
	//arrng Rating
	private String eInvPtyUniqueId;	
	private Integer eOrigChnlId;	
	private Integer eArrngDayCntConvTypId;
	private Integer eIntrPayFreqPeriodId;
	private Integer eRateResetPerodInterId;
	private Date eNxtIntrRateResetDate;	
	private Integer eArrngSecurTypeId;	
	private String eSecurizedInd;
	private String eCreditFacTypId;
	private Integer eCreditFacArrngAppTypId;		
	private Double eOriAmt;
	private Integer eCrdtLimitChangeTypeId; 	
	private Integer eAcLastPymtToBankAmount;	
	private Double eOriLtvRatio;		
	private String eArrngPtyRolType;
	private BigDecimal ePctAmt;
	private String eInvPtySubtypeId;	
	
	//arrngIpRating
	private String scoreReqReturnedFlg;
	//GI
	private String uniqueIdCardArng;
    private Integer supportSeqNumber;
    private Integer guranteeSupportTypeId;
    private String guranteeSupportCovBasicTypeId;
    private String guranteeSupportCovTypeId;
    private Date guranteeEffDate;
    private Date guranteeEndDate;    
    private Integer insurenceTypeId;
    private String insurenceSupportCovBasicTypeId;
    private String insurenceSupportCovTypeId;
    private Date insurenceEffDate;
    private Date insurenceEndDate;

	
	private Date ePropApprDate;
	private BigDecimal eEffectiveRatePercentage;
	private Integer eRateVarTypId;
	private String eRateTypeId;	
	private Integer eBalType;
	private String eFuncCurr;	
	private Date eRepPeriodMonth;
	private String eLoanAssestRelnType;
	private String eRealPropType;	
	private Date eArrngFinClassDate;		
	private Date eIntrstAccrualStatTypDt;
	private Date eRelationEffDate;
	private Integer eFacLegStatTypId;
	private Integer eAssestRelationType;
	private String eRecTypeColl;
	private String eGAAPInd;
	private String eTranCurr;	
	private String eBaseCurrCode;		
	private Integer eEntProdId;
	private String eIntrBAsicCalcPeriodId;	
	
	private String invPtyLocRltnpTypId;
	private String eUniqueIdSrcSysInvlParty;
	private String eInvlvPartySubTypeId;
	private Double eBaseAmtCurr;
	private Integer eLossMitgPrgmId;
	private Integer eISupTypId;
	private String ePmacPortId;
	
	private Date eCaEndDate;
	private Date eRptMonthDate;
	private Date eARGEffDate;
	private Date eARGEndDate;
	private Date eAIPEffDate;
	private Date eAIPEndDate;
	private Date eAREndDate;
	private Date eAIREndDate;
	
	private Integer eCAArrngBusIntType;
	
	/*public String geteGlAcct1() {
		return eGlAcct1;
	}
	public void setEGlAcct1(String eGlAcct1) {
		this.eGlAcct1 = eGlAcct1;
	}
	public Long geteTransactianlaAmnt() {
		return eTransactianlaAmnt;
	}
	public void setETransactianlaAmnt(Long eTransactianlaAmnt) {
		this.eTransactianlaAmnt = eTransactianlaAmnt;
	}
	public String getLocalLegalVehicleId() {
		return localLegalVehicleId;
	}
	public void setLocalLegalVehicleId(String localLegalVehicleId) {
		this.localLegalVehicleId = localLegalVehicleId;
	}
	public String geteGaapIndicator() {
		return eGaapIndicator;
	}
	public void setEGaapIndicator(String eGaapIndicator) {
		this.eGaapIndicator = eGaapIndicator;
	}*/
	/*private String eGlAcct1;
	private Long eTransactianlaAmnt;
	private String localLegalVehicleId;
	private String eGaapIndicator;*/
	
	
	
	
	
	private List<CommonBalanceMtgTRLRecord> eCommonBalMtgTRLRecords;
	
	private Integer eARGRank; 
	
	public String geteInvlvPartySubTypeId() {
		return eInvlvPartySubTypeId;
	}
	public void seteInvlvPartySubTypeId(String eInvlvPartySubTypeId) {
		this.eInvlvPartySubTypeId = eInvlvPartySubTypeId;
	}
	public void setEInvlvPartySubTypeId(String eInvlvPartySubTypeId) {
		this.eInvlvPartySubTypeId = eInvlvPartySubTypeId;
	}
	public String getInvPtyLocRltnpTypId() {
		return invPtyLocRltnpTypId;
	}
	public void setInvPtyLocRltnpTypId(String invPtyLocRltnpTypId) {
		this.invPtyLocRltnpTypId = invPtyLocRltnpTypId;
	}
	
	public Integer geteArrngLifeCycleStatusReasonTypeId() {
		return eArrngLifeCycleStatusReasonTypeId;
	}
	public void setEArrngLifeCycleStatusReasonTypeId(
			Integer eArrngLifeCycleStatusReasonTypeId) {
		this.eArrngLifeCycleStatusReasonTypeId = eArrngLifeCycleStatusReasonTypeId;
	}
	public Integer geteAcLastPymtToBankAmount() {
		return eAcLastPymtToBankAmount;
	}
	public void setEAcLastPymtToBankAmount(Integer eAcLastPymtToBankAmount) {
		this.eAcLastPymtToBankAmount = eAcLastPymtToBankAmount;
	}
	public Integer geteRank() {
		return eRank;
	}
	public void setERank(Integer eRank) {
		this.eRank = eRank;
	}

	public Date geteEstmEndDate() {
		return eEstmEndDate;
	}
	public void setEEstmEndDate(Date eEstmEndDate) {
		this.eEstmEndDate = eEstmEndDate;
	}
	public Date geteIntrstAccrualStatTypDt() {
		return eIntrstAccrualStatTypDt;
	}
	public void setEIntrstAccrualStatTypDt(Date eIntrstAccrualStatTypDt) {
		this.eIntrstAccrualStatTypDt = eIntrstAccrualStatTypDt;
	}
	public Integer geteAssestRelationType() {
		return eAssestRelationType;
	}
	public void setEAssestRelationType(Integer eAssestRelationType) {
		this.eAssestRelationType = eAssestRelationType;
	}
	public String geteRecTypeColl() {
		return eRecTypeColl;
	}
	public void setERecTypeColl(String eRecTypeColl) {
		this.eRecTypeColl = eRecTypeColl;
	}
	public String geteRateActiveFlag() {
		return eRateActiveFlag;
	}
	public void setERateActiveFlag(String eRateActiveFlag) {
		this.eRateActiveFlag = eRateActiveFlag;
	}
	public Date geteIntrstAccrualStatTypDate() {
		return eIntrstAccrualStatTypDate;
	}
	public void setEIntrstAccrualStatTypDate(Date eIntrstAccrualStatTypDate) {
		this.eIntrstAccrualStatTypDate = eIntrstAccrualStatTypDate;
	}
	
	public String geteDescription() {
		return eDescription;
	}
	public void setEDescription(String eDescription) {
		this.eDescription = eDescription;
	}
	public Date geteEndDate() {
		return eEndDate;
	}
	public void setEEndDate(Date eEndDate) {
		this.eEndDate = eEndDate;
	}
	
	public Integer geteChrgOffTypeId() {
		return eChrgOffTypeId;
	}
	public void setEChrgOffTypeId(Integer eChrgOffTypeId) {
		this.eChrgOffTypeId = eChrgOffTypeId;
	}
	public Integer geteCrdtLimitChangeTypeId() {
		return eCrdtLimitChangeTypeId;
	}
	public void setECrdtLimitChangeTypeId(Integer eCrdtLimitChangeTypeId) {
		this.eCrdtLimitChangeTypeId = eCrdtLimitChangeTypeId;
	}

	public Date geteArrngNextPymtDueToBankDate() {
		return eArrngNextPymtDueToBankDate;
	}
	public void setEArrngNextPymtDueToBankDate(Date eArrngNextPymtDueToBankDate) {
		this.eArrngNextPymtDueToBankDate = eArrngNextPymtDueToBankDate;
	}
	public Integer geteMissedPymtNumb() {
		return eMissedPymtNumb;
	}
	public void setEMissedPymtNumb(Integer eMissedPymtNumb) {
		this.eMissedPymtNumb = eMissedPymtNumb;
	}
	public String geteBaselPortfolioId() {
		return eBaselPortfolioId;
	}
	public void setEBaselPortfolioId(String eBaselPortfolioId) {
		this.eBaselPortfolioId = eBaselPortfolioId;
	}
	public String geteLocalProdCategoryCode() {
		return eLocalProdCategoryCode;
	}
	public void setELocalProdCategoryCode(String eLocalProdCategoryCode) {
		this.eLocalProdCategoryCode = eLocalProdCategoryCode;
	}
	public String geteCcarProdCode() {
		return eCcarProdCode;
	}
	public void setECcarProdCode(String eCcarProdCode) {
		this.eCcarProdCode = eCcarProdCode;
	}
	public BigDecimal geteOrgAdvisedCommitedLimit() {
		return eOrgAdvisedCommitedLimit;
	}
	public void setEOrgAdvisedCommitedLimit(Double eOrgAdvisedCommitedLimit) {
		if(eOrgAdvisedCommitedLimit == null){
			this.eOrgAdvisedCommitedLimit = null;
		} else if (eOrgAdvisedCommitedLimit == 0){
			this.eOrgAdvisedCommitedLimit = new BigDecimal(0);
		}
		else{
			this.eOrgAdvisedCommitedLimit = new BigDecimal(eOrgAdvisedCommitedLimit).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}
	public Integer geteDelinquencyBucket() {
		return eDelinquencyBucket;
	}
	public void setEDelinquencyBucket(Integer eDelinquencyBucket) {
		this.eDelinquencyBucket = eDelinquencyBucket;
	}
	public String geteInvPtySubtypeId() {
		return eInvPtySubtypeId;
	}
	public void setEInvPtySubtypeId(String eInvPtySubtypeId) {
		this.eInvPtySubtypeId = eInvPtySubtypeId;
	}
	
	public Date getePropApprDate() {
		return ePropApprDate;
	}
	public void setEPropApprDate(Date ePropApprDate) {
		this.ePropApprDate = ePropApprDate;
	}
	public BigDecimal geteEffectiveRatePercentage() {
		return eEffectiveRatePercentage;
	}
	public void setEEffectiveRatePercentage(Double eEffectiveRatePercentage) {
		if (eEffectiveRatePercentage == null)
		{
			this.eEffectiveRatePercentage = null;
		}else if (eEffectiveRatePercentage == 0)
		{
			this.eEffectiveRatePercentage = new BigDecimal(0);
		}else{
			this.eEffectiveRatePercentage = new BigDecimal(eEffectiveRatePercentage).setScale(8,BigDecimal.ROUND_HALF_UP);
		}


	}
	public String geteRateTypeId() {
		return eRateTypeId;
	}
	public void setERateTypeId(String eRateTypeId) {
		this.eRateTypeId = eRateTypeId;
	}
	public String geteFuncCurr() {
		return eFuncCurr;
	}
	public void setEFuncCurr(String eFuncCurr) {
		this.eFuncCurr = eFuncCurr;
	}
	public Date geteRepPeriodMonth() {
		return eRepPeriodMonth;
	}
	public void setERepPeriodMonth(Date eRepPeriodMonth) {
		this.eRepPeriodMonth = eRepPeriodMonth;
	}
	public String geteLoanAssestRelnType() {
		return eLoanAssestRelnType;
	}
	public void setELoanAssestRelnType(String eLoanAssestRelnType) {
		this.eLoanAssestRelnType = eLoanAssestRelnType;
	}

	public Date geteActualBillingCycleDate() {
		return eActualBillingCycleDate;
	}
	public void setEActualBillingCycleDate(Date eActualBillingCycleDate) {
		this.eActualBillingCycleDate = eActualBillingCycleDate;
	}
	public Date geteArrngFinClassDate() {
		return eArrngFinClassDate;
	}
	public void setEArrngFinClassDate(Date eArrngFinClassDate) {
		this.eArrngFinClassDate = eArrngFinClassDate;
	}
	public Date geteArrngFinStatDate() {
		return eArrngFinStatDate;
	}
	public void setEArrngFinStatDate(Date eArrngFinStatDate) {
		this.eArrngFinStatDate = eArrngFinStatDate;
	}

	public Date geteRelationEffDate() {
		return eRelationEffDate;
	}
	public void setERelationEffDate(Date eRelationEffDate) {
		this.eRelationEffDate = eRelationEffDate;
	}

	public String geteBaseCurrCode() {
		return eBaseCurrCode;
	}
	public void setEBaseCurrCode(String eBaseCurrCode) {
		this.eBaseCurrCode = eBaseCurrCode;
	}
	
	public String geteDelq30DayPast2YrsFlag() {
		return eDelq30DayPast2YrsFlag;
	}
	public void setEDelq30DayPast2YrsFlag(String eDelq30DayPast2YrsFlag) {
		this.eDelq30DayPast2YrsFlag = eDelq30DayPast2YrsFlag;
	}
	public String geteDenoCurrId() {
		return eDenoCurrId;
	}
	public void setEDenoCurrId(String eDenoCurrId) {
		this.eDenoCurrId = eDenoCurrId;
	}
	public String geteEverWrittenOffFlag() {
		return eEverWrittenOffFlag;
	}
	public void setEEverWrittenOffFlag(String eEverWrittenOffFlag) {
		this.eEverWrittenOffFlag = eEverWrittenOffFlag;
	}
	
	
	public Integer geteFacLegStatTypId() {
		return eFacLegStatTypId;
	}
	public void setEFacLegStatTypId(Integer eFacLegStatTypId) {
		this.eFacLegStatTypId = eFacLegStatTypId;
	}
	
	public String geteGAAPInd() {
		return eGAAPInd;
	}
	public void setEGAAPInd(String eGAAPInd) {
		this.eGAAPInd = eGAAPInd;
	}
	
	public String geteIntrBAsicCalcPeriodId() {
		return eIntrBAsicCalcPeriodId;
	}
	public void setEIntrBAsicCalcPeriodId(String eIntrBAsicCalcPeriodId) {
		this.eIntrBAsicCalcPeriodId = eIntrBAsicCalcPeriodId;
	}
	public BigDecimal geteOrgLtvRatio() {
		return eOrgLtvRatio;
	}
	
	public void setEOrgLtvRatio(Double eOrgLtvRatio) {
		if(eOrgLtvRatio == null){
			this.eOrgLtvRatio = null;
		} else if(eOrgLtvRatio == 0){
			this.eOrgLtvRatio = new BigDecimal(0);
		}else{
			this.eOrgLtvRatio = new  BigDecimal(eOrgLtvRatio).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}
	
	public Double geteOriLtvRatio() {
		return eOriLtvRatio;
	}
	
	public void setEOriLtvRatio(Double eOriLtvRatio) {
		this.eOriLtvRatio = eOriLtvRatio;
	}

	public String geteRatingIssId() {
		return eRatingIssId;
	}
	public void setERatingIssId(String eRatingIssId) {
		this.eRatingIssId = eRatingIssId;
	}
	public String geteModelCd() {
		return eModelCd;
	}
	public void setEModelCd(String eModelCd) {
		this.eModelCd = eModelCd;
	}
	public Integer geteRatingEvnRsnTypId() {
		return eRatingEvnRsnTypId;
	}
	public void setERatingEvnRsnTypId(Integer eRatingEvnRsnTypId) {
		this.eRatingEvnRsnTypId = eRatingEvnRsnTypId;
	}
	
	public String geteRatingTypCd() {
		return eRatingTypCd;
	}
	public void setERatingTypCd(String eRatingTypCd) {
		this.eRatingTypCd = eRatingTypCd;
	}
	public String geteRatingCd() {
		return eRatingCd;
	}
	public void setERatingCd(String eRatingCd) {
		this.eRatingCd = eRatingCd;
	}

	public Integer geteRateVarTypId() {
		return eRateVarTypId;
	}
	public void setERateVarTypId(Integer eRateVarTypId) {
		this.eRateVarTypId = eRateVarTypId;
	}

	public Double geteOriAmt() {
		return eOriAmt;
	}
	public void setEOriAmt(Double eOriAmt) {
		this.eOriAmt = eOriAmt;
	}
	public Integer geteBalType() {
		return eBalType;
	}
	public void setEBalType(Integer eBalType) {
		this.eBalType = eBalType;
	}

	public String geteProdSysId() {
		return eProdSysId;
	}
	public void setEProdSysId(String eProdSysId) {
		this.eProdSysId = eProdSysId;
	}

	public String geteUniqueId() {
		return eUniqueId;
	}
	public void setEUniqueId(String eUniqueId) {
		this.eUniqueId = eUniqueId;
	}
	public String geteSrcSysId() {
		return eSrcSysId;
	}
	public void setESrcSysId(String eSrcSysId) {
		this.eSrcSysId = eSrcSysId;
	}
	public Date geteAsOfDt() {
		return eAsOfDt;
	}
	public void setEAsOfDt(Date eAsOfDt) {
		this.eAsOfDt = eAsOfDt;
	}
	public String geteRecType() {
		return eRecType;
	}
	public void setERecType(String eRecType) {
		this.eRecType = eRecType;
	}
	public String geteGlbProdId() {
		return eGlbProdId;
	}
	public void setEGlbProdId(String eGlbProdId) {
		this.eGlbProdId = eGlbProdId;
	}
	public Date geteBookingDate() {
		return eBookingDate;
	}
	public void setEBookingDate(Date eBookingDate) {
		this.eBookingDate = eBookingDate;
	}
	public Date geteOriginalEffDate() {
		return eOriginalEffDate;
	}
	public void setEOriginalEffDate(Date eOriginalEffDate) {
		this.eOriginalEffDate = eOriginalEffDate;
	}
	public Date geteEffDate() {
		return eEffDate;
	}
	public void setEEffDate(Date eEffDate) {
		this.eEffDate = eEffDate;
	}
	public Integer geteOrigChnlId() {
		return eOrigChnlId;
	}
	public void setEOrigChnlId(Integer eOrigChnlId) {
		this.eOrigChnlId = eOrigChnlId;
	}
	public String geteArrngPurpTypeId() {
		return eArrngPurpTypeId;
	}
	public void setEArrngPurpTypeId(String eArrngPurpTypeId) {
		this.eArrngPurpTypeId = eArrngPurpTypeId;
	}
	public Integer geteArrngBusIntType() {
		return eArrngBusIntType;
	}
	public void setEArrngBusIntType(Integer eArrngBusIntType) {
		this.eArrngBusIntType = eArrngBusIntType;
	}
	public Integer geteArrngMatuTypeId() {
		return eArrngMatuTypeId;
	}
	public void setEArrngMatuTypeId(Integer eArrngMatuTypeId) {
		this.eArrngMatuTypeId = eArrngMatuTypeId;
	}
	public Integer geteArrngPastDueDayCount() {
		return eArrngPastDueDayCount;
	}
	public void setEArrngPastDueDayCount(Integer eArrngPastDueDayCount) {
		this.eArrngPastDueDayCount = eArrngPastDueDayCount;
	}
	public Integer geteArrngLifeCycleStatusId() {
		return eArrngLifeCycleStatusId;
	}
	public void setEArrngLifeCycleStatusId(Integer eArrngLifeCycleStatusId) {
		this.eArrngLifeCycleStatusId = eArrngLifeCycleStatusId;
	}
	public Date geteArrngLifeCycleStatusDate() {
		return eArrngLifeCycleStatusDate;
	}
	public void setEArrngLifeCycleStatusDate(Date eArrngLifeCycleStatusDate) {
		this.eArrngLifeCycleStatusDate = eArrngLifeCycleStatusDate;
	}
	public Date geteArrngAcqDt() {
		return eArrngAcqDt;
	}
	public void setEArrngAcqDt(Date eArrngAcqDt) {
		this.eArrngAcqDt = eArrngAcqDt;
	}
	public Integer geteArrngDayCntConvTypId() {
		return eArrngDayCntConvTypId;
	}
	public void setEArrngDayCntConvTypId(Integer eArrngDayCntConvTypId) {
		this.eArrngDayCntConvTypId = eArrngDayCntConvTypId;
	}
	public Integer geteIntrPayFreqPeriodId() {
		return eIntrPayFreqPeriodId;
	}
	public void setEIntrPayFreqPeriodId(Integer eIntrPayFreqPeriodId) {
		this.eIntrPayFreqPeriodId = eIntrPayFreqPeriodId;
	}
	public Integer geteRateResetPerodInterId() {
		return eRateResetPerodInterId;
	}
	public void setERateResetPerodInterId(Integer eRateResetPerodInterId) {
		this.eRateResetPerodInterId = eRateResetPerodInterId;
	}
	public Date geteNxtIntrRateResetDate() {
		return eNxtIntrRateResetDate;
	}
	public void setENxtIntrRateResetDate(Date eNxtIntrRateResetDate) {
		this.eNxtIntrRateResetDate = eNxtIntrRateResetDate;
	}
	public Integer geteFinServiceTypId() {
		return eFinServiceTypId;
	}
	public void setEFinServiceTypId(Integer eFinServiceTypId) {
		this.eFinServiceTypId = eFinServiceTypId;
	}
	public Integer geteFinServiceLimitTypId() {
		return eFinServiceLimitTypId;
	}
	public void setEFinServiceLimitTypId(Integer eFinServiceLimitTypId) {
		this.eFinServiceLimitTypId = eFinServiceLimitTypId;
	}
	public Integer geteArrngSecurTypeId() {
		return eArrngSecurTypeId;
	}
	public void setEArrngSecurTypeId(Integer eArrngSecurTypeId) {
		this.eArrngSecurTypeId = eArrngSecurTypeId;
	}
	public Integer geteIntrstAccrualStatTypId() {
		return eIntrstAccrualStatTypId;
	}
	public void setEIntrstAccrualStatTypId(Integer eIntrstAccrualStatTypId) {
		this.eIntrstAccrualStatTypId = eIntrstAccrualStatTypId;
	}
	public String geteSecurizedInd() {
		return eSecurizedInd;
	}
	public void setESecurizedInd(String eSecurizedInd) {
		this.eSecurizedInd = eSecurizedInd;
	}

	public Integer geteCreditFacArrngAppTypId() {
		return eCreditFacArrngAppTypId;
	}
	public void setECreditFacArrngAppTypId(Integer eCreditFacArrngAppTypId) {
		this.eCreditFacArrngAppTypId = eCreditFacArrngAppTypId;
	}
	public Date geteArrngBussIntDate() {
		return eArrngBussIntDate;
	}
	public void setEArrngBussIntDate(Date eArrngBussIntDate) {
		this.eArrngBussIntDate = eArrngBussIntDate;
	}
	public String getePledgInd() {
		return ePledgInd;
	}
	public void setEPledgInd(String ePledgInd) {
		this.ePledgInd = ePledgInd;
	}
	public String getePledgEligInd() {
		return ePledgEligInd;
	}
	public void setEPledgEligInd(String ePledgEligInd) {
		this.ePledgEligInd = ePledgEligInd;
	}
	public String geteObligorRecourseInd() {
		return eObligorRecourseInd;
	}
	public void setEObligorRecourseInd(String eObligorRecourseInd) {
		this.eObligorRecourseInd = eObligorRecourseInd;
	}
	public String geteInvPtyUniqueId() {
		return eInvPtyUniqueId;
	}
	public void setEInvPtyUniqueId(String eInvPtyUniqueId) {
		this.eInvPtyUniqueId = eInvPtyUniqueId;
	}
	public String geteArrngPtyRolType() {
		return eArrngPtyRolType;
	}
	public void setEArrngPtyRolType(String eArrngPtyRolType) {
		this.eArrngPtyRolType = eArrngPtyRolType;
	}
	public String geteRealPropType() {
		return eRealPropType;
	}
	public void setERealPropType(String eRealPropType) {
		this.eRealPropType = eRealPropType;
	}
	public String geteLocalProductId() {
		return eLocalProductId;
	}
	public void setELocalProductId(String eLocalProductId) {
		this.eLocalProductId = eLocalProductId;
	}
	public Date geteArrngLastPymtToBankDate() {
		return eArrngLastPymtToBankDate;
	}
	public void setEArrngLastPymtToBankDate(Date eArrngLastPymtToBankDate) {
		this.eArrngLastPymtToBankDate = eArrngLastPymtToBankDate;
	}
	public String geteTranCurr() {
		return eTranCurr;
	}
	public void setETranCurr(String eTranCurr) {
		this.eTranCurr = eTranCurr;
	}
	public Date geteArrngPastDueAgeClassDate() {
		return eArrngPastDueAgeClassDate;
	}
	public void setEArrngPastDueAgeClassDate(Date eArrngPastDueAgeClassDate) {
		this.eArrngPastDueAgeClassDate = eArrngPastDueAgeClassDate;
	}
	public BigDecimal getePctAmt() {
		return ePctAmt;
	}
	public void setEPctAmt(Integer ePctAmt) {
		this.ePctAmt = new BigDecimal(ePctAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public String geteRestructureFlag() {
		return eRestructureFlag;
	}
	public void setERestructureFlag(String eRestructureFlag) {
		this.eRestructureFlag = eRestructureFlag;
	}
	public Integer geteArrngPastDueAgeClass() {
		return eArrngPastDueAgeClass;
	}
	public void setEArrngPastDueAgeClass(Integer eArrngPastDueAgeClass) {
		this.eArrngPastDueAgeClass = eArrngPastDueAgeClass;
	}
	public String geteFicoEquvRatingCode() {
		return eFicoEquvRatingCode;
	}
	public void setEFicoEquvRatingCode(String eFicoEquvRatingCode) {
		this.eFicoEquvRatingCode = eFicoEquvRatingCode;
	}
	public Date geteCrdtLimitEffctDate() {
		return eCrdtLimitEffctDate;
	}
	public void setECrdtLimitEffctDate(Date eCrdtLimitEffctDate) {
		this.eCrdtLimitEffctDate = eCrdtLimitEffctDate;
	}

	public Integer geteEntProdId() {
		return eEntProdId;
	}
	public void setEEntProdId(Integer eEntProdId) {
		this.eEntProdId = eEntProdId;
	}
	public String geteOrgAcctNumbr() {
		return eOrgAcctNumbr;
	}
	public void setEOrgAcctNumbr(String eOrgAcctNumbr) {
		this.eOrgAcctNumbr = eOrgAcctNumbr;
	}
	public String geteCreditFacTypId() {
		return eCreditFacTypId;
	}
	public void setECreditFacTypId(String eCreditFacTypId) {
		this.eCreditFacTypId = eCreditFacTypId;
	}
	public String geteNonTradeResidMtgFlag() {
		return eNonTradeResidMtgFlag;
	}
	public void setENonTradeResidMtgFlag(String eNonTradeResidMtgFlag) {
		this.eNonTradeResidMtgFlag = eNonTradeResidMtgFlag;
	}
	/**
	 * @return the localSubProductId
	 */
	public String getLocalSubProductId() {
		return localSubProductId;
	}
	/**
	 * @param localSubProductId the localSubProductId to set
	 */
	public void setLocalSubProductId(String localSubProductId) {
		this.localSubProductId = localSubProductId;
	}
	/**
	 * @return the entStandProductId
	 */
	public String getEntStandProductId() {
		return entStandProductId;
	}
	/**
	 * @param entStandProductId the entStandProductId to set
	 */
	public void setEntStandProductId(String entStandProductId) {
		this.entStandProductId = entStandProductId;
	}
	/**
	 * @return the arrngName
	 */
	public String getArrngName() {
		return arrngName;
	}
	/**
	 * @param arrngName the arrngName to set
	 */
	public void setArrngName(String arrngName) {
		this.arrngName = arrngName;
	}
	/**
	 * @return the oriChannelId
	 */
	public Integer geteOrigChannelId() {
		return eOrigChannelId;
	}
	/**
	 * @param oriChannelId the oriChannelId to set
	 */
	public void setEOrigChannelId(Integer eOrigChannelId) {
		this.eOrigChannelId = eOrigChannelId;
	}
	/**
	 * @return the arrngFinStatTypId
	 */
	public String geteArrngFinStatTypId() {
		return eArrngFinStatTypId;
	}
	/**
	 * @param arrngFinStatTypId the arrngFinStatTypId to set
	 */
	public void setEArrngFinStatTypId(String eArrngFinStatTypId) {
		this.eArrngFinStatTypId = eArrngFinStatTypId;
	}
	/**
	 * @return the gracePerDayCnt
	 */
	public Integer geteGracePerDayCnt() {
		return eGracePerDayCnt;
	}
	/**
	 * @param gracePerDayCnt the gracePerDayCnt to set
	 */
	public void setEGracePerDayCnt(Integer eGracePerDayCnt) {
		this.eGracePerDayCnt = eGracePerDayCnt;
	}
	/**
	 * @return the arrngNxtRenewalDate
	 */
	public Date getArrngNxtRenewalDate() {
		return arrngNxtRenewalDate;
	}
	/**
	 * @param arrngNxtRenewalDate the arrngNxtRenewalDate to set
	 */
	public void setArrngNxtRenewalDate(Date arrngNxtRenewalDate) {
		this.arrngNxtRenewalDate = arrngNxtRenewalDate;
	}
	/**
	 * @return the arrngPriPayTypId
	 */
	public Integer getArrngPriPayTypId() {
		return arrngPriPayTypId;
	}
	/**
	 * @param arrngPriPayTypId the arrngPriPayTypId to set
	 */
	public void setArrngPriPayTypId(Integer arrngPriPayTypId) {
		this.arrngPriPayTypId = arrngPriPayTypId;
	}
	/**
	 * @return the arrngAcqTypId
	 */
	public Integer geteArrngAcqTypId() {
		return eArrngAcqTypId;
	}
	/**
	 * @param arrngAcqTypId the arrngAcqTypId to set
	 */
	public void setEArrngAcqTypId(Integer eArrngAcqTypId) {
		this.eArrngAcqTypId = eArrngAcqTypId;
	}
	/**
	 * @return the arrngDisTypId
	 */
	public Integer getArrngDisTypId() {
		return arrngDisTypId;
	}
	/**
	 * @param arrngDisTypId the arrngDisTypId to set
	 */
	public void setArrngDisTypId(Integer arrngDisTypId) {
		this.arrngDisTypId = arrngDisTypId;
	}
	/**
	 * @return the arrngDisTypDate
	 */
	public Date getArrngDisTypDate() {
		return arrngDisTypDate;
	}
	/**
	 * @param arrngDisTypDate the arrngDisTypDate to set
	 */
	public void setArrngDisTypDate(Date arrngDisTypDate) {
		this.arrngDisTypDate = arrngDisTypDate;
	}
	/**
	 * @return the oriInvInsCatId
	 */
	public Integer getOriInvInsCatId() {
		return oriInvInsCatId;
	}
	/**
	 * @param oriInvInsCatId the oriInvInsCatId to set
	 */
	public void setOriInvInsCatId(Integer oriInvInsCatId) {
		this.oriInvInsCatId = oriInvInsCatId;
	}
	/**
	 * @return the oriInvInsActFlag
	 */
	public String getOriInvInsActFlag() {
		return oriInvInsActFlag;
	}
	/**
	 * @param oriInvInsActFlag the oriInvInsActFlag to set
	 */
	public void setOriInvInsActFlag(String oriInvInsActFlag) {
		this.oriInvInsActFlag = oriInvInsActFlag;
	}
	/**
	 * @return the oriInvInsPer
	 */
	public BigDecimal getOriInvInsPer() {
		return oriInvInsPer;
	}
	/**
	 * @param oriInvInsPer the oriInvInsPer to set
	 */
	public void setOriInvInsPer(Double oriInvInsPer) {
		if(oriInvInsPer == null){
			this.oriInvInsPer = null;
		}else if(oriInvInsPer == 0){
			this.oriInvInsPer = new BigDecimal(0);
		} else{
			this.oriInvInsPer = new BigDecimal(oriInvInsPer).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	}
	/**
	 * @return the arrngDayCntConTypId
	 */
	public Integer getArrngDayCntConTypId() {
		return arrngDayCntConTypId;
	}
	/**
	 * @param arrngDayCntConTypId the arrngDayCntConTypId to set
	 */
	public void setArrngDayCntConTypId(Integer arrngDayCntConTypId) {
		this.arrngDayCntConTypId = arrngDayCntConTypId;
	}
	/**
	 * @return the intPayFrePerId
	 */
	public Integer geteIntPayFrePerId() {
		return eIntPayFrePerId;
	}
	/**
	 * @param intPayFrePerId the intPayFrePerId to set
	 */
	public void setEIntPayFrePerId(Integer eIntPayFrePerId) {
		this.eIntPayFrePerId = eIntPayFrePerId;
	}
	/**
	 * @return the rateResetPerIntId
	 */
	public Integer geteRateResetPerIntId() {
		return eRateResetPerIntId;
	}
	/**
	 * @param rateResetPerIntId the rateResetPerIntId to set
	 */
	public void setERateResetPerIntId(Integer eRateResetPerIntId) {
		this.eRateResetPerIntId = eRateResetPerIntId;
	}
	/**
	 * @return the inIntRateResetDate
	 */
	public Date getInIntRateResetDate() {
		return inIntRateResetDate;
	}
	/**
	 * @param inIntRateResetDate the inIntRateResetDate to set
	 */
	public void setInIntRateResetDate(Date inIntRateResetDate) {
		this.inIntRateResetDate = inIntRateResetDate;
	}
	/**
	 * @return the nxtIntRateResetDate
	 */
	public Date getNxtIntRateResetDate() {
		return nxtIntRateResetDate;
	}
	/**
	 * @param nxtIntRateResetDate the nxtIntRateResetDate to set
	 */
	public void setNxtIntRateResetDate(Date nxtIntRateResetDate) {
		this.nxtIntRateResetDate = nxtIntRateResetDate;
	}
	/**
	 * @return the prevLstIntRateResetDate
	 */
	public Date getPrevLstIntRateResetDate() {
		return prevLstIntRateResetDate;
	}
	/**
	 * @param prevLstIntRateResetDate the prevLstIntRateResetDate to set
	 */
	public void setPrevLstIntRateResetDate(Date prevLstIntRateResetDate) {
		this.prevLstIntRateResetDate = prevLstIntRateResetDate;
	}
	/**
	 * @return the taxExemInd
	 */
	public String getTaxExemInd() {
		return taxExemInd;
	}
	/**
	 * @param taxExemInd the taxExemInd to set
	 */
	public void setTaxExemInd(String taxExemInd) {
		this.taxExemInd = taxExemInd;
	}
	/**
	 * @return the onBnkRelnInd
	 */
	public String getOnBnkRelnInd() {
		return onBnkRelnInd;
	}
	/**
	 * @param onBnkRelnInd the onBnkRelnInd to set
	 */
	public void setOnBnkRelnInd(String onBnkRelnInd) {
		this.onBnkRelnInd = onBnkRelnInd;
	}
	/**
	 * @return the arrngSecTypId
	 */
	public Integer geteArrngSecTypId() {
		return eArrngSecTypId;
	}
	/**
	 * @param arrngSecTypId the arrngSecTypId to set
	 */
	public void setEArrngSecTypId(Integer eArrngSecTypId) {
		this.eArrngSecTypId = eArrngSecTypId;
	}
	/**
	 * @return the citiRecInd
	 */
	public String getCitiRecInd() {
		return citiRecInd;
	}
	/**
	 * @param citiRecInd the citiRecInd to set
	 */
	public void setCitiRecInd(String citiRecInd) {
		this.citiRecInd = citiRecInd;
	}
	/**
	 * @return the payFrePerId
	 */
	public Integer getPayFrePerId() {
		return payFrePerId;
	}
	/**
	 * @param payFrePerId the payFrePerId to set
	 */
	public void setPayFrePerId(Integer payFrePerId) {
		this.payFrePerId = payFrePerId;
	}
	/**
	 * @return the intOnlyTermPeriod
	 */
	public Integer getIntOnlyTermPeriod() {
		return intOnlyTermPeriod;
	}
	/**
	 * @param intOnlyTermPeriod the intOnlyTermPeriod to set
	 */
	public void setIntOnlyTermPeriod(Integer intOnlyTermPeriod) {
		this.intOnlyTermPeriod = intOnlyTermPeriod;
	}
	/**
	 * @return the finSerResCurStId
	 */
	public Integer getFinSerResCurStId() {
		return finSerResCurStId;
	}
	/**
	 * @param finSerResCurStId the finSerResCurStId to set
	 */
	public void setFinSerResCurStId(Integer finSerResCurStId) {
		this.finSerResCurStId = finSerResCurStId;
	}
	/**
	 * @return the finSerResCurStDate
	 */
	public Date getFinSerResCurStDate() {
		return finSerResCurStDate;
	}
	/**
	 * @param finSerResCurStDate the finSerResCurStDate to set
	 */
	public void setFinSerResCurStDate(Date finSerResCurStDate) {
		this.finSerResCurStDate = finSerResCurStDate;
	}
	/**
	 * @return the finSerPrevResStId
	 */
	public Integer getFinSerPrevResStId() {
		return finSerPrevResStId;
	}
	/**
	 * @param finSerPrevResStId the finSerPrevResStId to set
	 */
	public void setFinSerPrevResStId(Integer finSerPrevResStId) {
		this.finSerPrevResStId = finSerPrevResStId;
	}
	/**
	 * @return the finSerPrevResStDate
	 */
	public Date getFinSerPrevResStDate() {
		return finSerPrevResStDate;
	}
	/**
	 * @param finSerPrevResStDate the finSerPrevResStDate to set
	 */
	public void setFinSerPrevResStDate(Date finSerPrevResStDate) {
		this.finSerPrevResStDate = finSerPrevResStDate;
	}
	/**
	 * @return the trbDebtResFlag
	 */
	public String getTrbDebtResFlag() {
		return trbDebtResFlag;
	}
	/**
	 * @param trbDebtResFlag the trbDebtResFlag to set
	 */
	public void setTrbDebtResFlag(String trbDebtResFlag) {
		this.trbDebtResFlag = trbDebtResFlag;
	}
	/**
	 * @return the mktRateYieldReneFlag
	 */
	public String getMktRateYieldReneFlag() {
		return mktRateYieldReneFlag;
	}
	/**
	 * @param mktRateYieldReneFlag the mktRateYieldReneFlag to set
	 */
	public void setMktRateYieldReneFlag(String mktRateYieldReneFlag) {
		this.mktRateYieldReneFlag = mktRateYieldReneFlag;
	}
	/**
	 * @return the skipPayInd
	 */
	public String getSkipPayInd() {
		return skipPayInd;
	}
	/**
	 * @param skipPayInd the skipPayInd to set
	 */
	public void setSkipPayInd(String skipPayInd) {
		this.skipPayInd = skipPayInd;
	}
	/**
	 * @return the secInd
	 */
	public String geteSecInd() {
		return eSecInd;
	}
	/**
	 * @param secInd the secInd to set
	 */
	public void setESecInd(String eSecInd) {
		this.eSecInd = eSecInd;
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
	 * @return the acctTrppInsAmt
	 */
	public Double getAcctTrppInsAmt() {
		return acctTrppInsAmt;
	}
	/**
	 * @param acctTrppInsAmt the acctTrppInsAmt to set
	 */
	public void setAcctTrppInsAmt(Double acctTrppInsAmt) {
		this.acctTrppInsAmt = acctTrppInsAmt;
	}
	/**
	 * @return the locAutExtFlag
	 */
	public String getLocAutExtFlag() {
		return locAutExtFlag;
	}
	/**
	 * @param locAutExtFlag the locAutExtFlag to set
	 */
	public void setLocAutExtFlag(String locAutExtFlag) {
		this.locAutExtFlag = locAutExtFlag;
	}
	/**
	 * @return the locTermLoanCovFlag
	 */
	public String getLocTermLoanCovFlag() {
		return locTermLoanCovFlag;
	}
	/**
	 * @param locTermLoanCovFlag the locTermLoanCovFlag to set
	 */
	public void setLocTermLoanCovFlag(String locTermLoanCovFlag) {
		this.locTermLoanCovFlag = locTermLoanCovFlag;
	}
	/**
	 * @return the inDocTypId
	 */
	public Integer getInDocTypId() {
		return inDocTypId;
	}
	/**
	 * @param inDocTypId the inDocTypId to set
	 */
	public void setInDocTypId(Integer inDocTypId) {
		this.inDocTypId = inDocTypId;
	}
	/**
	 * @return the finserModProgStDate
	 */
	public Date getFinserModProgStDate() {
		return finserModProgStDate;
	}
	/**
	 * @param finserModProgStDate the finserModProgStDate to set
	 */
	public void setFinserModProgStDate(Date finserModProgStDate) {
		this.finserModProgStDate = finserModProgStDate;
	}
	/**
	 * @return the finserModProgEndDate
	 */
	public Date getFinserModProgEndDate() {
		return finserModProgEndDate;
	}
	/**
	 * @param finserModProgEndDate the finserModProgEndDate to set
	 */
	public void setFinserModProgEndDate(Date finserModProgEndDate) {
		this.finserModProgEndDate = finserModProgEndDate;
	}
	/**
	 * @return the finSerResModRsnTypId
	 */
	public Integer getFinSerResModRsnTypId() {
		return finSerResModRsnTypId;
	}
	/**
	 * @param finSerResModRsnTypId the finSerResModRsnTypId to set
	 */
	public void setFinSerResModRsnTypId(Integer finSerResModRsnTypId) {
		this.finSerResModRsnTypId = finSerResModRsnTypId;
	}
	/**
	 * @return the finSerModProgId
	 */
	public Integer getFinSerModProgId() {
		return finSerModProgId;
	}
	/**
	 * @param finSerModProgId the finSerModProgId to set
	 */
	public void setFinSerModProgId(Integer finSerModProgId) {
		this.finSerModProgId = finSerModProgId;
	}
	/**
	 * @return the finSerModProgCurrSts
	 */
	public Integer getFinSerModProgCurrSts() {
		return finSerModProgCurrSts;
	}
	/**
	 * @param finSerModProgCurrSts the finSerModProgCurrSts to set
	 */
	public void setFinSerModProgCurrSts(Integer finSerModProgCurrSts) {
		this.finSerModProgCurrSts = finSerModProgCurrSts;
	}
	/**
	 * @return the finSerModProgCurrStsDate
	 */
	public Date getFinSerModProgCurrStsDate() {
		return finSerModProgCurrStsDate;
	}
	/**
	 * @param finSerModProgCurrStsDate the finSerModProgCurrStsDate to set
	 */
	public void setFinSerModProgCurrStsDate(Date finSerModProgCurrStsDate) {
		this.finSerModProgCurrStsDate = finSerModProgCurrStsDate;
	}
	/**
	 * @return the finSerModProgPrevStsTypId
	 */
	public Integer getFinSerModProgPrevStsTypId() {
		return finSerModProgPrevStsTypId;
	}
	/**
	 * @param finSerModProgPrevStsTypId the finSerModProgPrevStsTypId to set
	 */
	public void setFinSerModProgPrevStsTypId(Integer finSerModProgPrevStsTypId) {
		this.finSerModProgPrevStsTypId = finSerModProgPrevStsTypId;
	}
	/**
	 * @return the modRetenLossMitTypId
	 */
	public Integer getModRetenLossMitTypId() {
		return modRetenLossMitTypId;
	}
	/**
	 * @param modRetenLossMitTypId the modRetenLossMitTypId to set
	 */
	public void setModRetenLossMitTypId(Integer modRetenLossMitTypId) {
		this.modRetenLossMitTypId = modRetenLossMitTypId;
	}
	/**
	 * @return the creFacTypId
	 */
	public Integer getCreFacTypId() {
		return CreFacTypId;
	}
	/**
	 * @param creFacTypId the creFacTypId to set
	 */
	public void setCreFacTypId(Integer creFacTypId) {
		CreFacTypId = creFacTypId;
	}
	/**
	 * @return the eFacilLegalStsTypId
	 */
	public Integer geteFacilLegalStsTypId() {
		return eFacilLegalStsTypId;
	}
	/**
	 * @param eFacilLegalStsTypId the eFacilLegalStsTypId to set
	 */
	public void seteFacilLegalStsTypId(Integer eFacilLegalStsTypId) {
		this.eFacilLegalStsTypId = eFacilLegalStsTypId;
	}
	/**
	 * @return the facilLegalStsDate
	 */
	public Date getFacilLegalStsDate() {
		return FacilLegalStsDate;
	}
	/**
	 * @param facilLegalStsDate the facilLegalStsDate to set
	 */
	public void setFacilLegalStsDate(Date facilLegalStsDate) {
		FacilLegalStsDate = facilLegalStsDate;
	}
	/**
	 * @return the creFacArrngAppTypId
	 */
	public Integer geteCreFacArrngAppTypId() {
		return eCreFacArrngAppTypId;
	}
	/**
	 * @param creFacArrngAppTypId the creFacArrngAppTypId to set
	 */
	public void setECreFacArrngAppTypId(Integer eCreFacArrngAppTypId) {
		this.eCreFacArrngAppTypId = eCreFacArrngAppTypId;
	}
	/**
	 * @return the creFacArrngAppTypDate
	 */
	public Date getCreFacArrngAppTypDate() {
		return creFacArrngAppTypDate;
	}
	/**
	 * @param creFacArrngAppTypDate the creFacArrngAppTypDate to set
	 */
	public void setCreFacArrngAppTypDate(Date creFacArrngAppTypDate) {
		this.creFacArrngAppTypDate = creFacArrngAppTypDate;
	}
	/**
	 * @return the creFacRegSegTypId
	 */
	public Integer getCreFacRegSegTypId() {
		return creFacRegSegTypId;
	}
	/**
	 * @param creFacRegSegTypId the creFacRegSegTypId to set
	 */
	public void setCreFacRegSegTypId(Integer creFacRegSegTypId) {
		this.creFacRegSegTypId = creFacRegSegTypId;
	}
	/**
	 * @return the creFacAvastaTypId
	 */
	public Integer getCreFacAvastaTypId() {
		return creFacAvastaTypId;
	}
	/**
	 * @param creFacAvastaTypId the creFacAvastaTypId to set
	 */
	public void setCreFacAvastaTypId(Integer creFacAvastaTypId) {
		this.creFacAvastaTypId = creFacAvastaTypId;
	}
	/**
	 * @return the lstCreLmtChngDate
	 */
	public Date getLstCreLmtChngDate() {
		return lstCreLmtChngDate;
	}
	/**
	 * @param lstCreLmtChngDate the lstCreLmtChngDate to set
	 */
	public void setLstCreLmtChngDate(Date lstCreLmtChngDate) {
		this.lstCreLmtChngDate = lstCreLmtChngDate;
	}
	/**
	 * @return the creLimitChnTypId
	 */
	public Integer getCreLimitChnTypId() {
		return creLimitChnTypId;
	}
	/**
	 * @param creLimitChnTypId the creLimitChnTypId to set
	 */
	public void setCreLimitChnTypId(Integer creLimitChnTypId) {
		this.creLimitChnTypId = creLimitChnTypId;
	}
	/**
	 * @return the eArrngNextPymtDueToBankAmt
	 */
	public Double geteArrngNextPymtDueToBankAmt() {
		return eArrngNextPymtDueToBankAmt;
	}
	/**
	 * @param eArrngNextPymtDueToBankAmt the eArrngNextPymtDueToBankAmt to set
	 */
	public void seteArrngNextPymtDueToBankAmt(Double eArrngNextPymtDueToBankAmt) {
		this.eArrngNextPymtDueToBankAmt = eArrngNextPymtDueToBankAmt;
	}
	/**
	 * @return the acctLstRecDate
	 */
	public Date getAcctLstRecDate() {
		return acctLstRecDate;
	}
	/**
	 * @param acctLstRecDate the acctLstRecDate to set
	 */
	public void setAcctLstRecDate(Date acctLstRecDate) {
		this.acctLstRecDate = acctLstRecDate;
	}
	/**
	 * @return the acctLstInsDate
	 */
	public Date getAcctLstInsDate() {
		return acctLstInsDate;
	}
	/**
	 * @param acctLstInsDate the acctLstInsDate to set
	 */
	public void setAcctLstInsDate(Date acctLstInsDate) {
		this.acctLstInsDate = acctLstInsDate;
	}
	/**
	 * @return the totPay
	 */
	public Integer getTotPay() {
		return totPay;
	}
	/**
	 * @param totPay the totPay to set
	 */
	public void setTotPay(Integer totPay) {
		this.totPay = totPay;
	}
	/**
	 * @return the acctLstIntRevDate
	 */
	public Date getAcctLstIntRevDate() {
		return acctLstIntRevDate;
	}
	/**
	 * @param acctLstIntRevDate the acctLstIntRevDate to set
	 */
	public void setAcctLstIntRevDate(Date acctLstIntRevDate) {
		this.acctLstIntRevDate = acctLstIntRevDate;
	}
	/**
	 * @return the penRate
	 */
	public Double getPenRate() {
		return PenRate;
	}
	/**
	 * @param penRate the penRate to set
	 */
	public void setPenRate(Double penRate) {
		PenRate = penRate;
	}
	/**
	 * @return the penAmt
	 */
	public Double getPenAmt() {
		return PenAmt;
	}
	/**
	 * @param penAmt the penAmt to set
	 */
	public void setPenAmt(Double penAmt) {
		PenAmt = penAmt;
	}
	/**
	 * @return the legNotDays
	 */
	public Double getLegNotDays() {
		return legNotDays;
	}
	/**
	 * @param legNotDays the legNotDays to set
	 */
	public void setLegNotDays(Double legNotDays) {
		this.legNotDays = legNotDays;
	}
	/**
	 * @return the othAltIdent
	 */
	public String getOthAltIdent() {
		return othAltIdent;
	}
	/**
	 * @param othAltIdent the othAltIdent to set
	 */
	public void setOthAltIdent(String othAltIdent) {
		this.othAltIdent = othAltIdent;
	}
	/**
	 * @return the linePosTypId
	 */
	public Integer getLinePosTypId() {
		return linePosTypId;
	}
	/**
	 * @param linePosTypId the linePosTypId to set
	 */
	public void setLinePosTypId(Integer linePosTypId) {
		this.linePosTypId = linePosTypId;
	}
	/**
	 * @return the feePayFreqPerId
	 */
	public Integer getFeePayFreqPerId() {
		return feePayFreqPerId;
	}
	/**
	 * @param feePayFreqPerId the feePayFreqPerId to set
	 */
	public void setFeePayFreqPerId(Integer feePayFreqPerId) {
		this.feePayFreqPerId = feePayFreqPerId;
	}
	/**
	 * @return the notPerDays
	 */
	public Double getNotPerDays() {
		return notPerDays;
	}
	/**
	 * @param notPerDays the notPerDays to set
	 */
	public void setNotPerDays(Double notPerDays) {
		this.notPerDays = notPerDays;
	}
	/**
	 * @return the currAmtTyp
	 */
	public Integer geteCurrAmtType() {
		return eCurrAmtType;
	}
	/**
	 * @param currAmtTyp the currAmtTyp to set
	 */
	public void setECurrAmtType(Integer eCurrAmtType) {
		this.eCurrAmtType = eCurrAmtType;
	}
	/**
	 * @return the feeWavFlag
	 */
	public String getFeeWavFlag() {
		return feeWavFlag;
	}
	/**
	 * @param feeWavFlag the feeWavFlag to set
	 */
	public void setFeeWavFlag(String feeWavFlag) {
		this.feeWavFlag = feeWavFlag;
	}
	/**
	 * @return the borDate
	 */
	public Date getBorDate() {
		return borDate;
	}
	/**
	 * @param borDate the borDate to set
	 */
	public void setBorDate(Date borDate) {
		this.borDate = borDate;
	}
	/**
	 * @return the socEcoCatId
	 */
	public Integer getSocEcoCatId() {
		return socEcoCatId;
	}
	/**
	 * @param socEcoCatId the socEcoCatId to set
	 */
	public void setSocEcoCatId(Integer socEcoCatId) {
		this.socEcoCatId = socEcoCatId;
	}
	/**
	 * @return the acctFirstAdvAmt
	 */
	public Double getAcctFirstAdvAmt() {
		return acctFirstAdvAmt;
	}
	/**
	 * @param acctFirstAdvAmt the acctFirstAdvAmt to set
	 */
	public void setAcctFirstAdvAmt(Double acctFirstAdvAmt) {
		this.acctFirstAdvAmt = acctFirstAdvAmt;
	}
	/**
	 * @return the acctFirstAdvDate
	 */
	public Date getAcctFirstAdvDate() {
		return acctFirstAdvDate;
	}
	/**
	 * @param acctFirstAdvDate the acctFirstAdvDate to set
	 */
	public void setAcctFirstAdvDate(Date acctFirstAdvDate) {
		this.acctFirstAdvDate = acctFirstAdvDate;
	}
	/**
	 * @return the acctFirstPayDate
	 */
	public Date getAcctFirstPayDate() {
		return acctFirstPayDate;
	}
	/**
	 * @param acctFirstPayDate the acctFirstPayDate to set
	 */
	public void setAcctFirstPayDate(Date acctFirstPayDate) {
		this.acctFirstPayDate = acctFirstPayDate;
	}
	/**
	 * @return the acctLastAdvAmt
	 */
	public Double getAcctLastAdvAmt() {
		return acctLastAdvAmt;
	}
	/**
	 * @param acctLastAdvAmt the acctLastAdvAmt to set
	 */
	public void setAcctLastAdvAmt(Double acctLastAdvAmt) {
		this.acctLastAdvAmt = acctLastAdvAmt;
	}
	/**
	 * @return the acctLastAdvDate
	 */
	public Date getAcctLastAdvDate() {
		return acctLastAdvDate;
	}
	/**
	 * @param acctLastAdvDate the acctLastAdvDate to set
	 */
	public void setAcctLastAdvDate(Date acctLastAdvDate) {
		this.acctLastAdvDate = acctLastAdvDate;
	}
	/**
	 * @return the acqCost
	 */
	public Double getAcqCost() {
		return acqCost;
	}
	/**
	 * @param acqCost the acqCost to set
	 */
	public void setAcqCost(Double acqCost) {
		this.acqCost = acqCost;
	}
	/**
	 * @return the docTypId
	 */
	public Integer getDocTypId() {
		return docTypId;
	}
	/**
	 * @param docTypId the docTypId to set
	 */
	public void setDocTypId(Integer docTypId) {
		this.docTypId = docTypId;
	}
	/**
	 * @return the mtgModSigDate
	 */
	public Date getMtgModSigDate() {
		return mtgModSigDate;
	}
	/**
	 * @param mtgModSigDate the mtgModSigDate to set
	 */
	public void setMtgModSigDate(Date mtgModSigDate) {
		this.mtgModSigDate = mtgModSigDate;
	}
	/**
	 * @return the mtgOriProgTypCode
	 */
	public Integer getMtgOriProgTypCode() {
		return mtgOriProgTypCode;
	}
	/**
	 * @param mtgOriProgTypCode the mtgOriProgTypCode to set
	 */
	public void setMtgOriProgTypCode(Integer mtgOriProgTypCode) {
		this.mtgOriProgTypCode = mtgOriProgTypCode;
	}
	/**
	 * @return the mtgCreRiskCatIntId
	 */
	public Integer getMtgCreRiskCatIntId() {
		return mtgCreRiskCatIntId;
	}
	/**
	 * @param mtgCreRiskCatIntId the mtgCreRiskCatIntId to set
	 */
	public void setMtgCreRiskCatIntId(Integer mtgCreRiskCatIntId) {
		this.mtgCreRiskCatIntId = mtgCreRiskCatIntId;
	}
	/**
	 * @return the balloonInd
	 */
	public String geteBalloonInd() {
		return eBalloonInd;
	}
	/**
	 * @param balloonInd the balloonInd to set
	 */
	public void setEBalloonInd(String eBalloonInd) {
		this.eBalloonInd = eBalloonInd;
	}
	/**
	 * @return the helocTerm
	 */
	public Integer getHelocTerm() {
		return helocTerm;
	}
	/**
	 * @param helocTerm the helocTerm to set
	 */
	public void setHelocTerm(Integer helocTerm) {
		this.helocTerm = helocTerm;
	}
	/**
	 * @return the lmPlanCdId
	 */
	public Integer getLmPlanCdId() {
		return lmPlanCdId;
	}
	/**
	 * @param lmPlanCdId the lmPlanCdId to set
	 */
	public void setLmPlanCdId(Integer lmPlanCdId) {
		this.lmPlanCdId = lmPlanCdId;
	}
	/**
	 * @return the escAcctMaintInd
	 */
	public String getEscAcctMaintInd() {
		return escAcctMaintInd;
	}
	/**
	 * @param escAcctMaintInd the escAcctMaintInd to set
	 */
	public void setEscAcctMaintInd(String escAcctMaintInd) {
		this.escAcctMaintInd = escAcctMaintInd;
	}
	/**
	 * @return the mtgOriProgGroupId
	 */
	public Integer getMtgOriProgGroupId() {
		return mtgOriProgGroupId;
	}
	/**
	 * @param mtgOriProgGroupId the mtgOriProgGroupId to set
	 */
	public void setMtgOriProgGroupId(Integer mtgOriProgGroupId) {
		this.mtgOriProgGroupId = mtgOriProgGroupId;
	}
	/**
	 * @return the comboLoanInd
	 */
	public String getComboLoanInd() {
		return comboLoanInd;
	}
	/**
	 * @param comboLoanInd the comboLoanInd to set
	 */
	public void setComboLoanInd(String comboLoanInd) {
		this.comboLoanInd = comboLoanInd;
	}
	/**
	 * @return the sopAcctInd
	 */
	public String getSopAcctInd() {
		return sopAcctInd;
	}
	/**
	 * @param sopAcctInd the sopAcctInd to set
	 */
	public void setSopAcctInd(String sopAcctInd) {
		this.sopAcctInd = sopAcctInd;
	}
	/**
	 * @return the negAmortFlag
	 */
	public String getNegAmortFlag() {
		return negAmortFlag;
	}
	/**
	 * @param negAmortFlag the negAmortFlag to set
	 */
	public void setNegAmortFlag(String negAmortFlag) {
		this.negAmortFlag = negAmortFlag;
	}
	/**
	 * @return the intCalPerId
	 */
	public Integer getIntCalPerId() {
		return intCalPerId;
	}
	/**
	 * @param intCalPerId the intCalPerId to set
	 */
	public void setIntCalPerId(Integer intCalPerId) {
		this.intCalPerId = intCalPerId;
	}
	/**
	 * @return the preComLoanFlag
	 */
	public String getPreComLoanFlag() {
		return preComLoanFlag;
	}
	/**
	 * @param preComLoanFlag the preComLoanFlag to set
	 */
	public void setPreComLoanFlag(String preComLoanFlag) {
		this.preComLoanFlag = preComLoanFlag;
	}
	/**
	 * @return the amortAccInd
	 */
	public Integer getAmortAccInd() {
		return amortAccInd;
	}
	/**
	 * @param amortAccInd the amortAccInd to set
	 */
	public void setAmortAccInd(Integer amortAccInd) {
		this.amortAccInd = amortAccInd;
	}
	/**
	 * @return the noSchePaymt
	 */
	public Integer geteNumSchePaymt() {
		return eNumSchePaymt;
	}
	/**
	 * @param noSchePaymt the noSchePaymt to set
	 */
	public void setENumSchePaymt(Integer eNumSchePaymt) {
		this.eNumSchePaymt = eNumSchePaymt;
	}
	/**
	 * @return the noRemPaymt
	 */
	public Integer geteNumRemPaymt() {
		return eNumRemPaymt;
	}
	/**
	 * @param noRemPaymt the noRemPaymt to set
	 */
	public void setENumRemPaymt(Integer eNumRemPaymt) {
		this.eNumRemPaymt = eNumRemPaymt;
	}
	/**
	 * @return the linePosTypEffDate
	 */
	public Date getLinePosTypEffDate() {
		return linePosTypEffDate;
	}
	/**
	 * @param linePosTypEffDate the linePosTypEffDate to set
	 */
	public void setLinePosTypEffDate(Date linePosTypEffDate) {
		this.linePosTypEffDate = linePosTypEffDate;
	}
	/**
	 * @return the delqMethCode
	 */
	public String getDelqMethCode() {
		return delqMethCode;
	}
	/**
	 * @param delqMethCode the delqMethCode to set
	 */
	public void setDelqMethCode(String delqMethCode) {
		this.delqMethCode = delqMethCode;
	}
	/**
	 * @return the accFirstPayAmt
	 */
	public Double getAccFirstPayAmt() {
		return accFirstPayAmt;
	}
	/**
	 * @param accFirstPayAmt the accFirstPayAmt to set
	 */
	public void setAccFirstPayAmt(Double accFirstPayAmt) {
		this.accFirstPayAmt = accFirstPayAmt;
	}
	/**
	 * @return the regOEmpFlag
	 */
	public String geteRegOEmpFlag() {
		return eRegOEmpFlag;
	}
	/**
	 * @param regOEmpFlag the regOEmpFlag to set
	 */
	public void setERegOEmpFlag(String eRegOEmpFlag) {
		this.eRegOEmpFlag = eRegOEmpFlag;
	}
	/**
	 * @return the probOfDefault
	 */
	public Double getProbOfDefault() {
		return probOfDefault;
	}
	/**
	 * @param probOfDefault the probOfDefault to set
	 */
	public void setProbOfDefault(Double probOfDefault) {
		this.probOfDefault = probOfDefault;
	}
	/**
	 * @return the eCrdtLimitEndtDate
	 */
	public Date geteCrdtLimitEndtDate() {
		return eCrdtLimitEndtDate;
	}
	/**
	 * @param eCrdtLimitEndtDate the eCrdtLimitEndtDate to set
	 */
	public void seteCrdtLimitEndtDate(Date eCrdtLimitEndtDate) {
		this.eCrdtLimitEndtDate = eCrdtLimitEndtDate;
	}
	public void setECrdtLimitEndtDate(Date eCrdtLimitEndtDate) {
		this.eCrdtLimitEndtDate = eCrdtLimitEndtDate;
	}
	/**
	 * @return the creditLmtEventInvTypId
	 */
	public String getCreditLmtEventInvTypId() {
		return creditLmtEventInvTypId;
	}
	/**
	 * @param creditLmtEventInvTypId the creditLmtEventInvTypId to set
	 */
	public void setCreditLmtEventInvTypId(String creditLmtEventInvTypId) {
		this.creditLmtEventInvTypId = creditLmtEventInvTypId;
	}
	/**
	 * @return the creditLmtEventAmt
	 */
	public Double getCreditLmtEventAmt() {
		return creditLmtEventAmt;
	}
	/**
	 * @param creditLmtEventAmt the creditLmtEventAmt to set
	 */
	public void setCreditLmtEventAmt(Double creditLmtEventAmt) {
		this.creditLmtEventAmt = creditLmtEventAmt;
	}
	/**
	 * @return the banktrupcyDate
	 */
	public Date getBanktrupcyDate() {
		return banktrupcyDate;
	}
	/**
	 * @param banktrupcyDate the banktrupcyDate to set
	 */
	public void setBanktrupcyDate(Date banktrupcyDate) {
		this.banktrupcyDate = banktrupcyDate;
	}
	/**
	 * @return the promoIntRtaeEliFlag
	 */
	public String getPromoIntRtaeEliFlag() {
		return promoIntRtaeEliFlag;
	}
	/**
	 * @param promoIntRtaeEliFlag the promoIntRtaeEliFlag to set
	 */
	public void setPromoIntRtaeEliFlag(String promoIntRtaeEliFlag) {
		this.promoIntRtaeEliFlag = promoIntRtaeEliFlag;
	}
	/**
	 * @return the pmacPortId
	 */
	public String getPmacPortId() {
		return pmacPortId;
	}
	/**
	 * @param pmacPortId the pmacPortId to set
	 */
	public void setPmacPortId(String pmacPortId) {
		this.pmacPortId = pmacPortId;
	}
	/**
	 * @return the lstWriteDwnDate
	 */
	public Date getLstWriteDwnDate() {
		return lstWriteDwnDate;
	}
	/**
	 * @param lstWriteDwnDate the lstWriteDwnDate to set
	 */
	public void setLstWriteDwnDate(Date lstWriteDwnDate) {
		this.lstWriteDwnDate = lstWriteDwnDate;
	}
	/**
	 * @return the currNegAmmFlag
	 */
	public String getCurrNegAmmFlag() {
		return currNegAmmFlag;
	}
	/**
	 * @param currNegAmmFlag the currNegAmmFlag to set
	 */
	public void setCurrNegAmmFlag(String currNegAmmFlag) {
		this.currNegAmmFlag = currNegAmmFlag;
	}
	/**
	 * @return the prinDeffOptFlag
	 */
	public String getPrinDeffOptFlag() {
		return prinDeffOptFlag;
	}
	/**
	 * @param prinDeffOptFlag the prinDeffOptFlag to set
	 */
	public void setPrinDeffOptFlag(String prinDeffOptFlag) {
		this.prinDeffOptFlag = prinDeffOptFlag;
	}
	/**
	 * @return the prinDeffOptEndDtae
	 */
	public Date getPrinDeffOptEndDtae() {
		return prinDeffOptEndDtae;
	}
	/**
	 * @param prinDeffOptEndDtae the prinDeffOptEndDtae to set
	 */
	public void setPrinDeffOptEndDtae(Date prinDeffOptEndDtae) {
		this.prinDeffOptEndDtae = prinDeffOptEndDtae;
	}
	/**
	 * @return the intDeffOptFlag
	 */
	public String getIntDeffOptFlag() {
		return intDeffOptFlag;
	}
	/**
	 * @param intDeffOptFlag the intDeffOptFlag to set
	 */
	public void setIntDeffOptFlag(String intDeffOptFlag) {
		this.intDeffOptFlag = intDeffOptFlag;
	}
	/**
	 * @return the intDeffOptEndDtae
	 */
	public Date getIntDeffOptEndDtae() {
		return intDeffOptEndDtae;
	}
	/**
	 * @param intDeffOptEndDtae the intDeffOptEndDtae to set
	 */
	public void setIntDeffOptEndDtae(Date intDeffOptEndDtae) {
		this.intDeffOptEndDtae = intDeffOptEndDtae;
	}
	/**
	 * @return the intOnlyOptEndDtae
	 */
	public Date getIntOnlyOptEndDtae() {
		return intOnlyOptEndDtae;
	}
	/**
	 * @param intOnlyOptEndDtae the intOnlyOptEndDtae to set
	 */
	public void setIntOnlyOptEndDtae(Date intOnlyOptEndDtae) {
		this.intOnlyOptEndDtae = intOnlyOptEndDtae;
	}
	/**
	 * @return the eOrgCombLtvRatio
	 */
	public BigDecimal geteOrgCombLtvRatio() {
		return eOrgCombLtvRatio;
	}
	/**
	 * @param eOrgCombLtvRatio the eOrgCombLtvRatio to set
	 */
	public void setEOrgCombLtvRatio(Double eOrgCombLtvRatio) {
		if(eOrgCombLtvRatio == null){
			this.eOrgCombLtvRatio = null;
		} else if(eOrgCombLtvRatio == 0){
			this.eOrgCombLtvRatio = new BigDecimal(0);
		} else{
			this.eOrgCombLtvRatio = new BigDecimal(eOrgCombLtvRatio).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}
	/**
	 * @return the totOriJunLienAmt
	 */
	public Double getTotOriJunLienAmt() {
		return totOriJunLienAmt;
	}
	/**
	 * @param totOriJunLienAmt the totOriJunLienAmt to set
	 */
	public void setTotOriJunLienAmt(Double totOriJunLienAmt) {
		this.totOriJunLienAmt = totOriJunLienAmt;
	}
	/**
	 * @return the reoStsTypId
	 */
	public String getReoStsTypId() {
		return reoStsTypId;
	}
	/**
	 * @param reoStsTypId the reoStsTypId to set
	 */
	public void setReoStsTypId(String reoStsTypId) {
		this.reoStsTypId = reoStsTypId;
	}
	/**
	 * @return the mobLocal
	 */
	public Integer getMobLocal() {
		return mobLocal;
	}
	/**
	 * @param mobLocal the mobLocal to set
	 */
	public void setMobLocal(Integer mobLocal) {
		this.mobLocal = mobLocal;
	}
	/**
	 * @return the riskMngInd
	 */
	public String getRiskMngInd() {
		return riskMngInd;
	}
	/**
	 * @param riskMngInd the riskMngInd to set
	 */
	public void setRiskMngInd(String riskMngInd) {
		this.riskMngInd = riskMngInd;
	}
	/**
	 * @return the daysPastDueCyclEnd
	 */
	public String getDaysPastDueCyclEnd() {
		return DaysPastDueCyclEnd;
	}
	/**
	 * @param daysPastDueCyclEnd the daysPastDueCyclEnd to set
	 */
	public void setDaysPastDueCyclEnd(String daysPastDueCyclEnd) {
		DaysPastDueCyclEnd = daysPastDueCyclEnd;
	}
	/**
	 * @return the cycleEndDelqBucket
	 */
	public String getCycleEndDelqBucket() {
		return cycleEndDelqBucket;
	}
	/**
	 * @param cycleEndDelqBucket the cycleEndDelqBucket to set
	 */
	public void setCycleEndDelqBucket(String cycleEndDelqBucket) {
		this.cycleEndDelqBucket = cycleEndDelqBucket;
	}
	/**
	 * @return the reservedForFutureGenesisUse1
	 */
	public String getReservedForFutureGenesisUse1() {
		return reservedForFutureGenesisUse1;
	}
	/**
	 * @param reservedForFutureGenesisUse1 the reservedForFutureGenesisUse1 to set
	 */
	public void setReservedForFutureGenesisUse1(String reservedForFutureGenesisUse1) {
		this.reservedForFutureGenesisUse1 = reservedForFutureGenesisUse1;
	}
	/**
	 * @return the reservedForFutureGenesisUse2
	 */
	public String getReservedForFutureGenesisUse2() {
		return reservedForFutureGenesisUse2;
	}
	/**
	 * @param reservedForFutureGenesisUse2 the reservedForFutureGenesisUse2 to set
	 */
	public void setReservedForFutureGenesisUse2(String reservedForFutureGenesisUse2) {
		this.reservedForFutureGenesisUse2 = reservedForFutureGenesisUse2;
	}
	/**
	 * @return the reservedForFutureGenesisUse3
	 */
	public String getReservedForFutureGenesisUse3() {
		return reservedForFutureGenesisUse3;
	}
	/**
	 * @param reservedForFutureGenesisUse3 the reservedForFutureGenesisUse3 to set
	 */
	public void setReservedForFutureGenesisUse3(String reservedForFutureGenesisUse3) {
		this.reservedForFutureGenesisUse3 = reservedForFutureGenesisUse3;
	}
	/**
	 * @return the reservedForFutureGenesisUse4
	 */
	public String getReservedForFutureGenesisUse4() {
		return reservedForFutureGenesisUse4;
	}
	/**
	 * @param reservedForFutureGenesisUse4 the reservedForFutureGenesisUse4 to set
	 */
	public void setReservedForFutureGenesisUse4(String reservedForFutureGenesisUse4) {
		this.reservedForFutureGenesisUse4 = reservedForFutureGenesisUse4;
	}
	/**
	 * @return the reservedForFutureGenesisUse5
	 */
	public String getReservedForFutureGenesisUse5() {
		return reservedForFutureGenesisUse5;
	}
	/**
	 * @param reservedForFutureGenesisUse5 the reservedForFutureGenesisUse5 to set
	 */
	public void setReservedForFutureGenesisUse5(String reservedForFutureGenesisUse5) {
		this.reservedForFutureGenesisUse5 = reservedForFutureGenesisUse5;
	}
	/**
	 * @return the reservedForFutureGenesisUse6
	 */
	public String getReservedForFutureGenesisUse6() {
		return reservedForFutureGenesisUse6;
	}
	/**
	 * @param reservedForFutureGenesisUse6 the reservedForFutureGenesisUse6 to set
	 */
	public void setReservedForFutureGenesisUse6(String reservedForFutureGenesisUse6) {
		this.reservedForFutureGenesisUse6 = reservedForFutureGenesisUse6;
	}
	/**
	 * @return the reservedForFutureGenesisUse7
	 */
	public String getReservedForFutureGenesisUse7() {
		return reservedForFutureGenesisUse7;
	}
	/**
	 * @param reservedForFutureGenesisUse7 the reservedForFutureGenesisUse7 to set
	 */
	public void setReservedForFutureGenesisUse7(String reservedForFutureGenesisUse7) {
		this.reservedForFutureGenesisUse7 = reservedForFutureGenesisUse7;
	}
	/**
	 * @return the reservedForFutureGenesisUse8
	 */
	public String getReservedForFutureGenesisUse8() {
		return reservedForFutureGenesisUse8;
	}
	/**
	 * @param reservedForFutureGenesisUse8 the reservedForFutureGenesisUse8 to set
	 */
	public void setReservedForFutureGenesisUse8(String reservedForFutureGenesisUse8) {
		this.reservedForFutureGenesisUse8 = reservedForFutureGenesisUse8;
	}
	/**
	 * @return the reservedForFutureGenesisUse9
	 */
	public String getReservedForFutureGenesisUse9() {
		return reservedForFutureGenesisUse9;
	}
	/**
	 * @param reservedForFutureGenesisUse9 the reservedForFutureGenesisUse9 to set
	 */
	public void setReservedForFutureGenesisUse9(String reservedForFutureGenesisUse9) {
		this.reservedForFutureGenesisUse9 = reservedForFutureGenesisUse9;
	}
	/**
	 * @return the reservedForFutureGenesisUse10
	 */
	public String getReservedForFutureGenesisUse10() {
		return reservedForFutureGenesisUse10;
	}
	/**
	 * @param reservedForFutureGenesisUse10 the reservedForFutureGenesisUse10 to set
	 */
	public void setReservedForFutureGenesisUse10(
			String reservedForFutureGenesisUse10) {
		this.reservedForFutureGenesisUse10 = reservedForFutureGenesisUse10;
	}
	/**
	 * @param eUniqueId the eUniqueId to set
	 */
	public void seteUniqueId(String eUniqueId) {
		this.eUniqueId = eUniqueId;
	}
	/**
	 * @param eSrcSysId the eSrcSysId to set
	 */
	public void seteSrcSysId(String eSrcSysId) {
		this.eSrcSysId = eSrcSysId;
	}
	/**
	 * @param eProdSysId the eProdSysId to set
	 */
	public void seteProdSysId(String eProdSysId) {
		this.eProdSysId = eProdSysId;
	}
	/**
	 * @param eRecType the eRecType to set
	 */
	public void seteRecType(String eRecType) {
		this.eRecType = eRecType;
	}
	/**
	 * @param eAsOfDt the eAsOfDt to set
	 */
	public void seteAsOfDt(Date eAsOfDt) {
		this.eAsOfDt = eAsOfDt;
	}
	/**
	 * @param eGlbProdId the eGlbProdId to set
	 */
	public void seteGlbProdId(String eGlbProdId) {
		this.eGlbProdId = eGlbProdId;
	}
	/**
	 * @param eLocalProductId the eLocalProductId to set
	 */
	public void seteLocalProductId(String eLocalProductId) {
		this.eLocalProductId = eLocalProductId;
	}
	/**
	 * @param eDescription the eDescription to set
	 */
	public void seteDescription(String eDescription) {
		this.eDescription = eDescription;
	}
	/**
	 * @param eBookingDate the eBookingDate to set
	 */
	public void seteBookingDate(Date eBookingDate) {
		this.eBookingDate = eBookingDate;
	}
	/**
	 * @param eOriginalEffDate the eOriginalEffDate to set
	 */
	public void seteOriginalEffDate(Date eOriginalEffDate) {
		this.eOriginalEffDate = eOriginalEffDate;
	}
	/**
	 * @param eEffDate the eEffDate to set
	 */
	public void seteEffDate(Date eEffDate) {
		this.eEffDate = eEffDate;
	}
	/**
	 * @param eEstmEndDate the eEstmEndDate to set
	 */
	public void seteEstmEndDate(Date eEstmEndDate) {
		this.eEstmEndDate = eEstmEndDate;
	}
	/**
	 * @param eEndDate the eEndDate to set
	 */
	public void seteEndDate(Date eEndDate) {
		this.eEndDate = eEndDate;
	}
	/**
	 * @param eDenoCurrId the eDenoCurrId to set
	 */
	public void seteDenoCurrId(String eDenoCurrId) {
		this.eDenoCurrId = eDenoCurrId;
	}
	/**
	 * @param eArrngPurpTypeId the eArrngPurpTypeId to set
	 */
	public void seteArrngPurpTypeId(String eArrngPurpTypeId) {
		this.eArrngPurpTypeId = eArrngPurpTypeId;
	}
	/**
	 * @param eArrngBusIntType the eArrngBusIntType to set
	 */
	public void seteArrngBusIntType(Integer eArrngBusIntType) {
		this.eArrngBusIntType = eArrngBusIntType;
	}
	/**
	 * @param eArrngBussIntDate the eArrngBussIntDate to set
	 */
	public void seteArrngBussIntDate(Date eArrngBussIntDate) {
		this.eArrngBussIntDate = eArrngBussIntDate;
	}
	/**
	 * @param ePledgInd the ePledgInd to set
	 */
	public void setePledgInd(String ePledgInd) {
		this.ePledgInd = ePledgInd;
	}
	/**
	 * @param ePledgEligInd the ePledgEligInd to set
	 */
	public void setePledgEligInd(String ePledgEligInd) {
		this.ePledgEligInd = ePledgEligInd;
	}
	/**
	 * @param eArrngMatuTypeId the eArrngMatuTypeId to set
	 */
	public void seteArrngMatuTypeId(Integer eArrngMatuTypeId) {
		this.eArrngMatuTypeId = eArrngMatuTypeId;
	}
	/**
	 * @param eArrngFinStatDate the eArrngFinStatDate to set
	 */
	public void seteArrngFinStatDate(Date eArrngFinStatDate) {
		this.eArrngFinStatDate = eArrngFinStatDate;
	}
	/**
	 * @param eArrngPastDueDayCount the eArrngPastDueDayCount to set
	 */
	public void seteArrngPastDueDayCount(Integer eArrngPastDueDayCount) {
		this.eArrngPastDueDayCount = eArrngPastDueDayCount;
	}
	/**
	 * @param eArrngPastDueAgeClass the eArrngPastDueAgeClass to set
	 */
	public void seteArrngPastDueAgeClass(Integer eArrngPastDueAgeClass) {
		this.eArrngPastDueAgeClass = eArrngPastDueAgeClass;
	}
	/**
	 * @param eArrngPastDueAgeClassDate the eArrngPastDueAgeClassDate to set
	 */
	public void seteArrngPastDueAgeClassDate(Date eArrngPastDueAgeClassDate) {
		this.eArrngPastDueAgeClassDate = eArrngPastDueAgeClassDate;
	}
	/**
	 * @param eArrngLifeCycleStatusReasonTypeId the eArrngLifeCycleStatusReasonTypeId to set
	 */
	public void seteArrngLifeCycleStatusReasonTypeId(
			Integer eArrngLifeCycleStatusReasonTypeId) {
		this.eArrngLifeCycleStatusReasonTypeId = eArrngLifeCycleStatusReasonTypeId;
	}
	/**
	 * @param eArrngLifeCycleStatusId the eArrngLifeCycleStatusId to set
	 */
	public void seteArrngLifeCycleStatusId(Integer eArrngLifeCycleStatusId) {
		this.eArrngLifeCycleStatusId = eArrngLifeCycleStatusId;
	}
	/**
	 * @param eArrngLifeCycleStatusDate the eArrngLifeCycleStatusDate to set
	 */
	public void seteArrngLifeCycleStatusDate(Date eArrngLifeCycleStatusDate) {
		this.eArrngLifeCycleStatusDate = eArrngLifeCycleStatusDate;
	}
	/**
	 * @param eArrngAcqDt the eArrngAcqDt to set
	 */
	public void seteArrngAcqDt(Date eArrngAcqDt) {
		this.eArrngAcqDt = eArrngAcqDt;
	}
	/**
	 * @param eChrgOffTypeId the eChrgOffTypeId to set
	 */
	public void seteChrgOffTypeId(Integer eChrgOffTypeId) {
		this.eChrgOffTypeId = eChrgOffTypeId;
	}
	/**
	 * @param eFinServiceTypId the eFinServiceTypId to set
	 */
	public void seteFinServiceTypId(Integer eFinServiceTypId) {
		this.eFinServiceTypId = eFinServiceTypId;
	}
	/**
	 * @param eFinServiceLimitTypId the eFinServiceLimitTypId to set
	 */
	public void seteFinServiceLimitTypId(Integer eFinServiceLimitTypId) {
		this.eFinServiceLimitTypId = eFinServiceLimitTypId;
	}
	/**
	 * @param eOrgAmount the eOrgAmount to set
	 */

	/**
	 * @param eIntrstAccrualStatTypId the eIntrstAccrualStatTypId to set
	 */
	public void seteIntrstAccrualStatTypId(Integer eIntrstAccrualStatTypId) {
		this.eIntrstAccrualStatTypId = eIntrstAccrualStatTypId;
	}
	/**
	 * @param eIntrstAccrualStatTypDate the eIntrstAccrualStatTypDate to set
	 */
	public void seteIntrstAccrualStatTypDate(Date eIntrstAccrualStatTypDate) {
		this.eIntrstAccrualStatTypDate = eIntrstAccrualStatTypDate;
	}
	/**
	 * @param eArrngNextPymtDueToBankDate the eArrngNextPymtDueToBankDate to set
	 */
	public void seteArrngNextPymtDueToBankDate(Date eArrngNextPymtDueToBankDate) {
		this.eArrngNextPymtDueToBankDate = eArrngNextPymtDueToBankDate;
	}
	/**
	 * @param eArrngLastPymtToBankDate the eArrngLastPymtToBankDate to set
	 */
	public void seteArrngLastPymtToBankDate(Date eArrngLastPymtToBankDate) {
		this.eArrngLastPymtToBankDate = eArrngLastPymtToBankDate;
	}
	/**
	 * @param eMissedPymtNumb the eMissedPymtNumb to set
	 */
	public void seteMissedPymtNumb(Integer eMissedPymtNumb) {
		this.eMissedPymtNumb = eMissedPymtNumb;
	}
	/**
	 * @param eBaselPortfolioId the eBaselPortfolioId to set
	 */
/*	public void seteBaselPortfolioId(String eBaselPortfolioId) {
		this.eBaselPortfolioId = eBaselPortfolioId;
	}*/
	/**
	 * @param eLocalProdCategoryCode the eLocalProdCategoryCode to set
	 */
	public void seteLocalProdCategoryCode(String eLocalProdCategoryCode) {
		this.eLocalProdCategoryCode = eLocalProdCategoryCode;
	}
	/**
	 * @param eDelq30DayPast2YrsFlag the eDelq30DayPast2YrsFlag to set
	 */
	public void seteDelq30DayPast2YrsFlag(String eDelq30DayPast2YrsFlag) {
		this.eDelq30DayPast2YrsFlag = eDelq30DayPast2YrsFlag;
	}
	/**
	 * @param eActualBillingCycleDate the eActualBillingCycleDate to set
	 */
	public void seteActualBillingCycleDate(Date eActualBillingCycleDate) {
		this.eActualBillingCycleDate = eActualBillingCycleDate;
	}
	/**
	 * @param eObligorRecourseInd the eObligorRecourseInd to set
	 */
	public void seteObligorRecourseInd(String eObligorRecourseInd) {
		this.eObligorRecourseInd = eObligorRecourseInd;
	}
	/**
	 * @param eRestructureFlag the eRestructureFlag to set
	 */
	public void seteRestructureFlag(String eRestructureFlag) {
		this.eRestructureFlag = eRestructureFlag;
	}
	/**
	 * @param eCrdtLimitEffctDate the eCrdtLimitEffctDate to set
	 */
	public void seteCrdtLimitEffctDate(Date eCrdtLimitEffctDate) {
		this.eCrdtLimitEffctDate = eCrdtLimitEffctDate;
	}
	/**
	 * @param eCcarProdCode the eCcarProdCode to set
	 */
	public void seteCcarProdCode(String eCcarProdCode) {
		this.eCcarProdCode = eCcarProdCode;
	}
/*	*//**
	 * @param eOrgAdvisedCommitedLimit the eOrgAdvisedCommitedLimit to set
	 *//*
	public void seteOrgAdvisedCommitedLimit(Double eOrgAdvisedCommitedLimit) {
		this.eOrgAdvisedCommitedLimit = new BigDecimal(eOrgAdvisedCommitedLimit).setScale(8,BigDecimal.ROUND_HALF_UP);
	}*/
	/**
	 * @param eOrgAcctNumbr the eOrgAcctNumbr to set
	 */
	public void seteOrgAcctNumbr(String eOrgAcctNumbr) {
		this.eOrgAcctNumbr = eOrgAcctNumbr;
	}
	/**
	 * @param eOrgLtvRatio the eOrgLtvRatio to set
	 */
//	public void seteOrgLtvRatio(String eOrgLtvRatio) {
//		this.eOrgLtvRatio =	new BigDecimal(eOrgLtvRatio).setScale(10,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eEverWrittenOffFlag the eEverWrittenOffFlag to set
	 */
	public void seteEverWrittenOffFlag(String eEverWrittenOffFlag) {
		this.eEverWrittenOffFlag = eEverWrittenOffFlag;
	}
	/**
	 * @param eNonTradeResidMtgFlag the eNonTradeResidMtgFlag to set
	 */
	public void seteNonTradeResidMtgFlag(String eNonTradeResidMtgFlag) {
		this.eNonTradeResidMtgFlag = eNonTradeResidMtgFlag;
	}
	/**
	 * @param eDelinquencyBucket the eDelinquencyBucket to set
	 */
	public void seteDelinquencyBucket(Integer eDelinquencyBucket) {
		this.eDelinquencyBucket = eDelinquencyBucket;
	}
	/**
	 * @param eInvPtyUniqueId the eInvPtyUniqueId to set
	 */
	public void seteInvPtyUniqueId(String eInvPtyUniqueId) {
		this.eInvPtyUniqueId = eInvPtyUniqueId;
	}
	/**
	 * @param eOrigChnlId the eOrigChnlId to set
	 */
	public void seteOrigChnlId(Integer eOrigChnlId) {
		this.eOrigChnlId = eOrigChnlId;
	}
	/**
	 * @param eArrngDayCntConvTypId the eArrngDayCntConvTypId to set
	 */
	public void seteArrngDayCntConvTypId(Integer eArrngDayCntConvTypId) {
		this.eArrngDayCntConvTypId = eArrngDayCntConvTypId;
	}
	/**
	 * @param eIntrPayFreqPeriodId the eIntrPayFreqPeriodId to set
	 */
	public void seteIntrPayFreqPeriodId(Integer eIntrPayFreqPeriodId) {
		this.eIntrPayFreqPeriodId = eIntrPayFreqPeriodId;
	}
	/**
	 * @param eRateResetPerodInterId the eRateResetPerodInterId to set
	 */
	public void seteRateResetPerodInterId(Integer eRateResetPerodInterId) {
		this.eRateResetPerodInterId = eRateResetPerodInterId;
	}
	/**
	 * @param eNxtIntrRateResetDate the eNxtIntrRateResetDate to set
	 */
	public void seteNxtIntrRateResetDate(Date eNxtIntrRateResetDate) {
		this.eNxtIntrRateResetDate = eNxtIntrRateResetDate;
	}
	/**
	 * @param eArrngSecurTypeId the eArrngSecurTypeId to set
	 */
	public void seteArrngSecurTypeId(Integer eArrngSecurTypeId) {
		this.eArrngSecurTypeId = eArrngSecurTypeId;
	}
	/**
	 * @param eSecurizedInd the eSecurizedInd to set
	 */
	public void seteSecurizedInd(String eSecurizedInd) {
		this.eSecurizedInd = eSecurizedInd;
	}
	/**
	 * @param eCreditFacTypId the eCreditFacTypId to set
	 */
	public void seteCreditFacTypId(String eCreditFacTypId) {
		this.eCreditFacTypId = eCreditFacTypId;
	}
	/**
	 * @param eCreditFacArrngAppTypId the eCreditFacArrngAppTypId to set
	 */
	public void seteCreditFacArrngAppTypId(Integer eCreditFacArrngAppTypId) {
		this.eCreditFacArrngAppTypId = eCreditFacArrngAppTypId;
	}
	/**
	 * @param eOriAmt the eOriAmt to set
	 */
	public void seteOriAmt(Double eOriAmt) {
		this.eOriAmt = eOriAmt;
	}
	/**
	 * @param eCrdtLimitChangeTypeId the eCrdtLimitChangeTypeId to set
	 */
	public void seteCrdtLimitChangeTypeId(Integer eCrdtLimitChangeTypeId) {
		this.eCrdtLimitChangeTypeId = eCrdtLimitChangeTypeId;
	}
	/**
	 * @param eAcLastPymtToBankAmount the eAcLastPymtToBankAmount to set
	 */
	public void seteAcLastPymtToBankAmount(Integer eAcLastPymtToBankAmount) {
		this.eAcLastPymtToBankAmount = eAcLastPymtToBankAmount;
	}
	/**
	 * @param eOriLtvRatio the eOriLtvRatio to set
	 */
	public void seteOriLtvRatio(Double eOriLtvRatio) {
		this.eOriLtvRatio = eOriLtvRatio;
	}
	/**
	 * @param eArrngPtyRolType the eArrngPtyRolType to set
	 */
	public void seteArrngPtyRolType(String eArrngPtyRolType) {
		this.eArrngPtyRolType = eArrngPtyRolType;
	}
	/**
	 * @param ePctAmt the ePctAmt to set
	 */
//	public void setePctAmt(Integer ePctAmt) {
//		this.ePctAmt = new BigDecimal(ePctAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eInvPtySubtypeId the eInvPtySubtypeId to set
	 */
	public void seteInvPtySubtypeId(String eInvPtySubtypeId) {
		this.eInvPtySubtypeId = eInvPtySubtypeId;
	}
	/**
	 * @param eRatingIssId the eRatingIssId to set
	 */
	public void seteRatingIssId(String eRatingIssId) {
		this.eRatingIssId = eRatingIssId;
	}
	/**
	 * @param eModelCd the eModelCd to set
	 */
	public void seteModelCd(String eModelCd) {
		this.eModelCd = eModelCd;
	}
	/**
	 * @param eRatingEvnRsnTypId the eRatingEvnRsnTypId to set
	 */
	public void seteRatingEvnRsnTypId(Integer eRatingEvnRsnTypId) {
		this.eRatingEvnRsnTypId = eRatingEvnRsnTypId;
	}
	/**
	 * @param eRank the eRank to set
	 */
	public void seteRank(Integer eRank) {
		this.eRank = eRank;
	}
	/**
	 * @param eRatingTypCd the eRatingTypCd to set
	 */
	public void seteRatingTypCd(String eRatingTypCd) {
		this.eRatingTypCd = eRatingTypCd;
	}
	/**
	 * @param eRatingCd the eRatingCd to set
	 */
	public void seteRatingCd(String eRatingCd) {
		this.eRatingCd = eRatingCd;
	}
	/**
	 * @param eFicoEquvRatingCode the eFicoEquvRatingCode to set
	 */
	public void seteFicoEquvRatingCode(String eFicoEquvRatingCode) {
		this.eFicoEquvRatingCode = eFicoEquvRatingCode;
	}
	/**
	 * @param ePropApprDate the ePropApprDate to set
	 */
	public void setePropApprDate(Date ePropApprDate) {
		this.ePropApprDate = ePropApprDate;
	}
	/**
	 * @param eEffectiveRatePercentage the eEffectiveRatePercentage to set
	 */
//	public void seteEffectiveRatePercentage(Double eEffectiveRatePercentage) {
//		this.eEffectiveRatePercentage = new BigDecimal(eEffectiveRatePercentage).setScale(8,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eRateVarTypId the eRateVarTypId to set
	 */
	public void seteRateVarTypId(Integer eRateVarTypId) {
		this.eRateVarTypId = eRateVarTypId;
	}
	/**
	 * @param eRateTypeId the eRateTypeId to set
	 */
	public void seteRateTypeId(String eRateTypeId) {
		this.eRateTypeId = eRateTypeId;
	}
	/**
	 * @param eBalTyp the eBalTyp to set
	 */
	public void seteBalType(Integer eBalType) {
		this.eBalType = eBalType;
	}
	/**
	 * @param eFuncCurr the eFuncCurr to set
	 */
	public void seteFuncCurr(String eFuncCurr) {
		this.eFuncCurr = eFuncCurr;
	}
	/**
	 * @param eRepPeriodMonth the eRepPeriodMonth to set
	 */
	public void seteRepPeriodMonth(Date eRepPeriodMonth) {
		this.eRepPeriodMonth = eRepPeriodMonth;
	}
	/**
	 * @param eLoanAssestRelnType the eLoanAssestRelnType to set
	 */
	public void seteLoanAssestRelnType(String eLoanAssestRelnType) {
		this.eLoanAssestRelnType = eLoanAssestRelnType;
	}
	/**
	 * @param eRealPropType the eRealPropType to set
	 */
	public void seteRealPropType(String eRealPropType) {
		this.eRealPropType = eRealPropType;
	}
	/**
	 * @param eArrngFinClassDate the eArrngFinClassDate to set
	 */
	public void seteArrngFinClassDate(Date eArrngFinClassDate) {
		this.eArrngFinClassDate = eArrngFinClassDate;
	}
	/**
	 * @param eIntrstAccrualStatTypDt the eIntrstAccrualStatTypDt to set
	 */
	public void seteIntrstAccrualStatTypDt(Date eIntrstAccrualStatTypDt) {
		this.eIntrstAccrualStatTypDt = eIntrstAccrualStatTypDt;
	}
	/**
	 * @param eRelationEffDate the eRelationEffDate to set
	 */
	public void seteRelationEffDate(Date eRelationEffDate) {
		this.eRelationEffDate = eRelationEffDate;
	}
	/**
	 * @param eFacLegStatTypId the eFacLegStatTypId to set
	 */
	public void seteFacLegStatTypId(Integer eFacLegStatTypId) {
		this.eFacLegStatTypId = eFacLegStatTypId;
	}
	/**
	 * @param eAssestRelationType the eAssestRelationType to set
	 */
	public void seteAssestRelationType(Integer eAssestRelationType) {
		this.eAssestRelationType = eAssestRelationType;
	}
	/**
	 * @param eRecTypeColl the eRecTypeColl to set
	 */
	public void seteRecTypeColl(String eRecTypeColl) {
		this.eRecTypeColl = eRecTypeColl;
	}
	/**
	 * @param eGAAPInd the eGAAPInd to set
	 */
	public void seteGAAPInd(String eGAAPInd) {
		this.eGAAPInd = eGAAPInd;
	}
	/**
	 * @param eTranCurr the eTranCurr to set
	 */
	public void seteTranCurr(String eTranCurr) {
		this.eTranCurr = eTranCurr;
	}
	/**
	 * @param eBaseCurrCode the eBaseCurrCode to set
	 */
	public void seteBaseCurrCode(String eBaseCurrCode) {
		this.eBaseCurrCode = eBaseCurrCode;
	}
	/**
	 * @param eEntProdId the eEntProdId to set
	 */
	public void seteEntProdId(Integer eEntProdId) {
		this.eEntProdId = eEntProdId;
	}
	/**
	 * @param eIntrBAsicCalcPeriodId the eIntrBAsicCalcPeriodId to set
	 */
	public void seteIntrBAsicCalcPeriodId(String eIntrBAsicCalcPeriodId) {
		this.eIntrBAsicCalcPeriodId = eIntrBAsicCalcPeriodId;
	}
	/**
	 * @param eRateActiveFlag the eRateActiveFlag to set
	 */
	public void seteRateActiveFlag(String eRateActiveFlag) {
		this.eRateActiveFlag = eRateActiveFlag;
	}
	
	public BigDecimal geteOriginalAmt() {
		return eOriginalAmt;
	}
	public void setEOriginalAmt(Double eOriginalAmt) {
		if(eOriginalAmt == null){
			this.eOriginalAmt = null;
		} else if(eOriginalAmt == 0){
			this.eOriginalAmt = new BigDecimal(0);
		} else{
			this.eOriginalAmt = new BigDecimal(eOriginalAmt).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}
	public BigDecimal geteOrgAmount() {
		return eOrgAmount;
	}
	public void setEOrgAmount(Integer eOrgAmount) {
		if(eOrgAmount == null){
			this.eOrgAmount = null;
		} else if(eOrgAmount == 0){
			this.eOrgAmount = new BigDecimal(0);
		} else{
			this.eOrgAmount = new BigDecimal(eOrgAmount).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}
	/**
	 * @return the arrngFinStatusRsnTypId
	 */
	public String getArrngFinStatusRsnTypId() {
		return arrngFinStatusRsnTypId;
	}
	/**
	 * @param arrngFinStatusRsnTypId the arrngFinStatusRsnTypId to set
	 */
	public void setArrngFinStatusRsnTypId(String arrngFinStatusRsnTypId) {
		this.arrngFinStatusRsnTypId = arrngFinStatusRsnTypId;
	}
	/**
	 * @return the acctLastPaymtToBnkAcct
	 */
	public BigDecimal getAcctLastPaymtToBnkAcct() {
		return acctLastPaymtToBnkAcct;
	}
	/**
	 * @param acctLastPaymtToBnkAcct the acctLastPaymtToBnkAcct to set
	 */
	public void setAcctLastPaymtToBnkAcct(Double acctLastPaymtToBnkAcct) {
		if(acctLastPaymtToBnkAcct == null){
			this.acctLastPaymtToBnkAcct = null;
		}else if(acctLastPaymtToBnkAcct == 0){
			this.acctLastPaymtToBnkAcct = new BigDecimal(0);
		}else{
			this.acctLastPaymtToBnkAcct = new BigDecimal(acctLastPaymtToBnkAcct).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}
	/**
	 * @return the orgAdvisedUnCommitedLimit
	 */
	public Double getOrgAdvisedUnCommitedLimit() {
		return orgAdvisedUnCommitedLimit;
	}
	/**
	 * @param orgAdvisedUnCommitedLimit the orgAdvisedUnCommitedLimit to set
	 */
	public void setOrgAdvisedUnCommitedLimit(Double orgAdvisedUnCommitedLimit) {
		this.orgAdvisedUnCommitedLimit = orgAdvisedUnCommitedLimit;
	}
	/**
	 * @return the orgUnAdvisedCommitedLimit
	 */
	public Double getOrgUnAdvisedCommitedLimit() {
		return orgUnAdvisedCommitedLimit;
	}
	/**
	 * @param orgUnAdvisedCommitedLimit the orgUnAdvisedCommitedLimit to set
	 */
	public void setOrgUnAdvisedCommitedLimit(Double orgUnAdvisedCommitedLimit) {
		this.orgUnAdvisedCommitedLimit = orgUnAdvisedCommitedLimit;
	}
	

	public String geteUniqueIdSrcSysInvlParty() {
		return eUniqueIdSrcSysInvlParty;
	}
	public void setEUniqueIdSrcSysInvlParty(String eUniqueIdSrcSysInvlParty) {
		this.eUniqueIdSrcSysInvlParty = eUniqueIdSrcSysInvlParty;
	}
	public Integer geteResourceItemTypId() {
		return eResourceItemTypId;
	}
	public String getPrimCollInd() {
		return primCollInd;
	}
	public Integer getRevFreqId() {
		return revFreqId;
	}
	public String getResourceItemName() {
		return resourceItemName;
	}
	public String getCollArrngUniqueIdInSrcSys() {
		return collArrngUniqueIdInSrcSys;
	}
	public String getCollArrngSrcSysId() {
		return collArrngSrcSysId;
	}
	public String getResItemValuAmt() {
		return resItemValuAmt;
	}
	public Integer geteResItemValMethodId() {
		return eResItemValMethodId;
	}
	public String getLegalEnfFlag() {
		return legalEnfFlag;
	}
	public String getLegalRightToPossFlag() {
		return legalRightToPossFlag;
	}
	public String getReHypInd() {
		return reHypInd;
	}
	public Integer getCollLocCode() {
		return collLocCode;
	}
	public String getInValMarginFlag() {
		return inValMarginFlag;
	}
	public Integer getAddTypId() {
		return addTypId;
	}
	public Integer getLoanToAssRelTyp() {
		return loanToAssRelTyp;
	}
	public Integer getOccTyp() {
		return occTyp;
	}
	public Date getPropApprDate() {
		return propApprDate;
	}
	public Integer getRealPropTotUnit() {
		return realPropTotUnit;
	}
	public String getRealPropTypId() {
		return realPropTypId;
	}
	public String getPropLocName() {
		return propLocName;
	}
	public String getePropCity() {
		return ePropCity;
	}
	public String getePropCountry() {
		return ePropCountry;
	}
	public String getePropState() {
		return ePropState;
	}
	public String getePropZipCode() {
		return ePropZipCode;
	}
	public String getePropAddLine1() {
		return ePropAddLine1;
	}
	public String getPropAddLine2() {
		return propAddLine2;
	}
	public String getPropAddLine3() {
		return propAddLine3;
	}

	public void setEResourceItemTypId(Integer eResourceItemTypId) {
		this.eResourceItemTypId = eResourceItemTypId;
	}
	public void setPrimCollInd(String primCollInd) {
		this.primCollInd = primCollInd;
	}
	public void setRevFreqId(Integer revFreqId) {
		this.revFreqId = revFreqId;
	}
	public void setResourceItemName(String resourceItemName) {
		this.resourceItemName = resourceItemName;
	}
	public void setCollArrngUniqueIdInSrcSys(String collArrngUniqueIdInSrcSys) {
		this.collArrngUniqueIdInSrcSys = collArrngUniqueIdInSrcSys;
	}
	public void setCollArrngSrcSysId(String collArrngSrcSysId) {
		this.collArrngSrcSysId = collArrngSrcSysId;
	}
	public void setResItemValuAmt(String resItemValuAmt) {
		this.resItemValuAmt = resItemValuAmt;
	}
	public void setEResItemValMethodId(Integer eResItemValMethodId) {
		this.eResItemValMethodId = eResItemValMethodId;
	}
	public void setLegalEnfFlag(String legalEnfFlag) {
		this.legalEnfFlag = legalEnfFlag;
	}
	public void setLegalRightToPossFlag(String legalRightToPossFlag) {
		this.legalRightToPossFlag = legalRightToPossFlag;
	}
	public void setReHypInd(String reHypInd) {
		this.reHypInd = reHypInd;
	}
	public void setCollLocCode(Integer collLocCode) {
		this.collLocCode = collLocCode;
	}
	public void setInValMarginFlag(String inValMarginFlag) {
		this.inValMarginFlag = inValMarginFlag;
	}
	public void setAddTypId(Integer addTypId) {
		this.addTypId = addTypId;
	}
	public void setLoanToAssRelTyp(Integer loanToAssRelTyp) {
		this.loanToAssRelTyp = loanToAssRelTyp;
	}
	public void setOccTyp(Integer occTyp) {
		this.occTyp = occTyp;
	}
	public void setPropApprDate(Date propApprDate) {
		this.propApprDate = propApprDate;
	}
	public void setRealPropTotUnit(Integer realPropTotUnit) {
		this.realPropTotUnit = realPropTotUnit;
	}
	public void setRealPropTypId(String realPropTypId) {
		this.realPropTypId = realPropTypId;
	}
	public void setPropLocName(String propLocName) {
		this.propLocName = propLocName;
	}
	public void setEPropCity(String ePropCity) {
		this.ePropCity = ePropCity;
	}
	public void setEPropCountry(String ePropCountry) {
		this.ePropCountry = ePropCountry;
	}
	public void setEPropState(String ePropState) {
		this.ePropState = ePropState;
	}
	public void setEPropZipCode(String ePropZipCode) {
		this.ePropZipCode = ePropZipCode;
	}
	public void setEPropAddLine1(String ePropAddLine1) {
		this.ePropAddLine1 = ePropAddLine1;
	}
	public void setPropAddLine2(String propAddLine2) {
		this.propAddLine2 = propAddLine2;
	}
	public void setPropAddLine3(String propAddLine3) {
		this.propAddLine3 = propAddLine3;
	}
	public Integer geteLegNumber() {
		return eLegNumber;
	}
	public String geteGlSysId() {
		return eGlSysId;
	}
	public Integer geteDealId() {
		return eDealId;
	}
	public String geteBookingLedgrCntryCode() {
		return eBookingLedgrCntryCode;
	}
	public String geteGLAccount1() {
		return eGLAccount1;
	}
	public String geteGlAccount2() {
		return eGlAccount2;
	}
	public String geteFdlAccount() {
		return eFdlAccount;
	}
	public BigDecimal geteTxnAmt() {
		return eTxnAmt;
	}
	public BigDecimal geteFuncAmt() {
		return eFuncAmt;
	}
	public BigDecimal geteBaseAmt() {
		return eBaseAmt;
	}
	public String geteGoc() {
		return eGoc;
	}
	public String geteBookingLedgrBrCode() {
		return eBookingLedgrBrCode;
	}
	public String geteFrsBuCode() {
		return eFrsBuCode;
	}
	public String geteNotForUse() {
		return eNotForUse;
	}
	public String geteLclDeptId() {
		return eLclDeptId;
	}
	public String geteLclLglVehicleCde() {
		return eLclLglVehicleCde;
	}
	public String geteFairValAcctMthFlg() {
		return eFairValAcctMthFlg;
	}
	public String geteFairValLvl() {
		return eFairValLvl;
	}
	public String geteExpCode() {
		return eExpCode;
	}
	public String geteLocalProdCode() {
		return eLocalProdCode;
	}
	public String geteFrsAffCode() {
		return eFrsAffCode;
	}
	public String geteSubStatCode() {
		return eSubStatCode;
	}
	public String geteMicroCntrlCode() {
		return eMicroCntrlCode;
	}
	public String geteFirmAccountImsNmbr() {
		return eFirmAccountImsNmbr;
	}
	public String geteBaseNmbr() {
		return eBaseNmbr;
	}
	public String geteIdProd() {
		return eIdProd;
	}
	public String geteKeyCode1() {
		return eKeyCode1;
	}
	public String geteKeyCode2() {
		return eKeyCode2;
	}
	public String geteLclLdgrAcctNmbr() {
		return eLclLdgrAcctNmbr;
	}
	public String geteAdjInd() {
		return eAdjInd;
	}
	public String geteUserId() {
		return eUserId;
	}
	public String geteAdjResnCode() {
		return eAdjResnCode;
	}
	public String geteCmnReasonDesc() {
		return eCmnReasonDesc;
	}
	public String geteLocalGlKey3() {
		return eLocalGlKey3;
	}
	public String geteLocalGlKey4() {
		return eLocalGlKey4;
	}
	public String geteAdjStndardArrngId() {
		return eAdjStndardArrngId;
	}
	public String geteAdjFinMarketPositionId() {
		return eAdjFinMarketPositionId;
	}
	
	public void setELegNumber(Integer eLegNumber) {
		this.eLegNumber = eLegNumber;
	}
	public void setEGlSysId(String eGlSysId) {
		this.eGlSysId = eGlSysId;
	}
	public void setEDealId(Integer eDealId) {
		this.eDealId = eDealId;
	}
	public void setEBookingLedgrCntryCode(String eBookingLedgrCntryCode) {
		this.eBookingLedgrCntryCode = eBookingLedgrCntryCode;
	}
	public void setEGLAccount1(String eGLAccount1) {
		this.eGLAccount1 = eGLAccount1;
	}
	public void setEGlAccount2(String eGlAccount2) {
		this.eGlAccount2 = eGlAccount2;
	}
	public void setEFdlAccount(String eFdlAccount) {
		this.eFdlAccount = eFdlAccount;
	}
	public void setETxnAmt(Double eTxnAmt) {
		if(eTxnAmt==null){
			this.eTxnAmt = null;
		}else if(eTxnAmt==0){
			this.eTxnAmt = new BigDecimal(0);
		}else{
			this.eTxnAmt = new BigDecimal(eTxnAmt).setScale(5,BigDecimal.ROUND_HALF_UP);
		}
		
	}
	public void setEFuncAmt(Double eFuncAmt) {
		if(eFuncAmt==null){
			this.eFuncAmt = null;
		}else if(eFuncAmt==0){
			this.eFuncAmt = new BigDecimal(0);
		}else{
			this.eFuncAmt = new BigDecimal(eFuncAmt).setScale(5,BigDecimal.ROUND_HALF_UP);
		}
	}
	public void setEBaseAmt(Double eBaseAmt) {
		if(eBaseAmt==null){
			this.eBaseAmt = null;
		}else if(eBaseAmt==0){
			this.eBaseAmt = new BigDecimal(0);
		}else{
			this.eBaseAmt = new BigDecimal(eBaseAmt).setScale(5,BigDecimal.ROUND_HALF_UP);
		}
	}
	public void setEGoc(String eGoc) {
		this.eGoc = eGoc;
	}
	public void setEBookingLedgrBrCode(String eBookingLedgrBrCode) {
		this.eBookingLedgrBrCode = eBookingLedgrBrCode;
	}
	public void setEFrsBuCode(String eFrsBuCode) {
		this.eFrsBuCode = eFrsBuCode;
	}
	public void setENotForUse(String eNotForUse) {
		this.eNotForUse = eNotForUse;
	}
	public void setELclDeptId(String eLclDeptId) {
		this.eLclDeptId = eLclDeptId;
	}
	public void setELclLglVehicleCde(String eLclLglVehicleCde) {
		this.eLclLglVehicleCde = eLclLglVehicleCde;
	}
	public void setEFairValAcctMthFlg(String eFairValAcctMthFlg) {
		this.eFairValAcctMthFlg = eFairValAcctMthFlg;
	}
	public void setEFairValLvl(String eFairValLvl) {
		this.eFairValLvl = eFairValLvl;
	}
	public void setEExpCode(String eExpCode) {
		this.eExpCode = eExpCode;
	}
	public void setELocalProdCode(String eLocalProdCode) {
		this.eLocalProdCode = eLocalProdCode;
	}
	public void setEFrsAffCode(String eFrsAffCode) {
		this.eFrsAffCode = eFrsAffCode;
	}
	public void setESubStatCode(String eSubStatCode) {
		this.eSubStatCode = eSubStatCode;
	}
	public void setEMicroCntrlCode(String eMicroCntrlCode) {
		this.eMicroCntrlCode = eMicroCntrlCode;
	}
	public void setEFirmAccountImsNmbr(String eFirmAccountImsNmbr) {
		this.eFirmAccountImsNmbr = eFirmAccountImsNmbr;
	}
	public void setEBaseNmbr(String eBaseNmbr) {
		this.eBaseNmbr = eBaseNmbr;
	}
	public void setEIdProd(String eIdProd) {
		this.eIdProd = eIdProd;
	}
	public void setEKeyCode1(String eKeyCode1) {
		this.eKeyCode1 = eKeyCode1;
	}
	public void setEKeyCode2(String eKeyCode2) {
		this.eKeyCode2 = eKeyCode2;
	}
	public void setELclLdgrAcctNmbr(String eLclLdgrAcctNmbr) {
		this.eLclLdgrAcctNmbr = eLclLdgrAcctNmbr;
	}
	public void setEAdjInd(String eAdjInd) {
		this.eAdjInd = eAdjInd;
	}
	public void setEUserId(String eUserId) {
		this.eUserId = eUserId;
	}
	public void setEAdjResnCode(String eAdjResnCode) {
		this.eAdjResnCode = eAdjResnCode;
	}
	public void setECmnReasonDesc(String eCmnReasonDesc) {
		this.eCmnReasonDesc = eCmnReasonDesc;
	}
	public void setELocalGlKey3(String eLocalGlKey3) {
		this.eLocalGlKey3 = eLocalGlKey3;
	}
	public void setELocalGlKey4(String eLocalGlKey4) {
		this.eLocalGlKey4 = eLocalGlKey4;
	}
	public void setEAdjStndardArrngId(String eAdjStndardArrngId) {
		this.eAdjStndardArrngId = eAdjStndardArrngId;
	}
	public void setEAdjFinMarketPositionId(String eAdjFinMarketPositionId) {
		this.eAdjFinMarketPositionId = eAdjFinMarketPositionId;
	}
	public Double getSpeedRatePer() {
		return speedRatePer;
	}
	public Integer getArrngRateTypRelnTypId() {
		return arrngRateTypRelnTypId;
	}
	public String getRateTyp() {
		return rateTyp;
	}
	public String getRateId() {
		return rateId;
	}
	public Date getRateTypEffDate() {
		return rateTypEffDate;
	}
	public String getReservedForFutureGenesisUse11() {
		return reservedForFutureGenesisUse11;
	}
	public String getReservedForFutureGenesisUse12() {
		return reservedForFutureGenesisUse12;
	}
	public String getReservedForFutureGenesisUse13() {
		return reservedForFutureGenesisUse13;
	}
	public String getReservedForFutureGenesisUse14() {
		return reservedForFutureGenesisUse14;
	}
	public String getReservedForFutureGenesisUse15() {
		return reservedForFutureGenesisUse15;
	}
	public void setSpeedRatePer(Double speedRatePer) {
		this.speedRatePer = speedRatePer;
	}
	public void setArrngRateTypRelnTypId(Integer arrngRateTypRelnTypId) {
		this.arrngRateTypRelnTypId = arrngRateTypRelnTypId;
	}
	public void setRateTyp(String rateTyp) {
		this.rateTyp = rateTyp;
	}
	public void setRateId(String rateId) {
		this.rateId = rateId;
	}
	public void setRateTypEffDate(Date rateTypEffDate) {
		this.rateTypEffDate = rateTypEffDate;
	}
	public void setReservedForFutureGenesisUse11(
			String reservedForFutureGenesisUse11) {
		this.reservedForFutureGenesisUse11 = reservedForFutureGenesisUse11;
	}
	public void setReservedForFutureGenesisUse12(
			String reservedForFutureGenesisUse12) {
		this.reservedForFutureGenesisUse12 = reservedForFutureGenesisUse12;
	}
	public void setReservedForFutureGenesisUse13(
			String reservedForFutureGenesisUse13) {
		this.reservedForFutureGenesisUse13 = reservedForFutureGenesisUse13;
	}
	public void setReservedForFutureGenesisUse14(
			String reservedForFutureGenesisUse14) {
		this.reservedForFutureGenesisUse14 = reservedForFutureGenesisUse14;
	}
	public void setReservedForFutureGenesisUse15(
			String reservedForFutureGenesisUse15) {
		this.reservedForFutureGenesisUse15 = reservedForFutureGenesisUse15;
	}
	public String getRatingDesc() {
		return ratingDesc;
	}
	public void setRatingDesc(String ratingDesc) {
		this.ratingDesc = ratingDesc;
	}
	public String geteScoreReqReturnFlag() {
		return eScoreReqReturnFlag;
	}
	public void setEScoreReqReturnFlag(String eScoreReqReturnFlag) {
		this.eScoreReqReturnFlag = eScoreReqReturnFlag;
	}
	public String getScoreReqReturnedFlg() {
		return scoreReqReturnedFlg;
	}
	public void setScoreReqReturnedFlg(String scoreReqReturnedFlg) {
		this.scoreReqReturnedFlg = scoreReqReturnedFlg;
	}
	public String getUniqueIdCardArng() {
		return uniqueIdCardArng;
	}
	public Integer getSupportSeqNumber() {
		return supportSeqNumber;
	}
	public Integer getGuranteeSupportTypeId() {
		return guranteeSupportTypeId;
	}
	public String getGuranteeSupportCovBasicTypeId() {
		return guranteeSupportCovBasicTypeId;
	}
	public String getGuranteeSupportCovTypeId() {
		return guranteeSupportCovTypeId;
	}
	public Date getGuranteeEffDate() {
		return guranteeEffDate;
	}
	public Date getGuranteeEndDate() {
		return guranteeEndDate;
	}
	public Integer getInsurenceTypeId() {
		return insurenceTypeId;
	}
	public String getInsurenceSupportCovBasicTypeId() {
		return insurenceSupportCovBasicTypeId;
	}
	public String getInsurenceSupportCovTypeId() {
		return insurenceSupportCovTypeId;
	}
	public Date getInsurenceEffDate() {
		return insurenceEffDate;
	}
	public Date getInsurenceEndDate() {
		return insurenceEndDate;
	}
	public void setUniqueIdCardArng(String uniqueIdCardArng) {
		this.uniqueIdCardArng = uniqueIdCardArng;
	}
	public void setSupportSeqNumber(Integer supportSeqNumber) {
		this.supportSeqNumber = supportSeqNumber;
	}
	public void setGuranteeSupportTypeId(Integer guranteeSupportTypeId) {
		this.guranteeSupportTypeId = guranteeSupportTypeId;
	}
	public void setGuranteeSupportCovBasicTypeId(
			String guranteeSupportCovBasicTypeId) {
		this.guranteeSupportCovBasicTypeId = guranteeSupportCovBasicTypeId;
	}
	public void setGuranteeSupportCovTypeId(String guranteeSupportCovTypeId) {
		this.guranteeSupportCovTypeId = guranteeSupportCovTypeId;
	}
	public void setGuranteeEffDate(Date guranteeEffDate) {
		this.guranteeEffDate = guranteeEffDate;
	}
	public void setGuranteeEndDate(Date guranteeEndDate) {
		this.guranteeEndDate = guranteeEndDate;
	}
	public void setInsurenceTypeId(Integer insurenceTypeId) {
		this.insurenceTypeId = insurenceTypeId;
	}
	public void setInsurenceSupportCovBasicTypeId(
			String insurenceSupportCovBasicTypeId) {
		this.insurenceSupportCovBasicTypeId = insurenceSupportCovBasicTypeId;
	}
	public void setInsurenceSupportCovTypeId(String insurenceSupportCovTypeId) {
		this.insurenceSupportCovTypeId = insurenceSupportCovTypeId;
	}
	public void setInsurenceEffDate(Date insurenceEffDate) {
		this.insurenceEffDate = insurenceEffDate;
	}
	public void setInsurenceEndDate(Date insurenceEndDate) {
		this.insurenceEndDate = insurenceEndDate;
	}
	/**
	 * @return the rateName
	 */
	public String getRateName() {
		return rateName;
	}
	/**
	 * @param rateName the rateName to set
	 */
	public void setRateName(String rateName) {
		this.rateName = rateName;
	}
	/**
	 * @return the rateVarTypeId
	 */
	public Integer geteRateVarTypeId() {
		return eRateVarTypeId;
	}
	/**
	 * @param rateVarTypeId the rateVarTypeId to set
	 */
	public void setERateVarTypeId(Integer eRateVarTypeId) {
		this.eRateVarTypeId = eRateVarTypeId;
	}	
	
	
	/**
	 * @return the resItemValueAmt
	 */
	public String getResItemValueAmt() {
		return resItemValueAmt;
	}
	/**
	 * @param resItemValueAmt the resItemValueAmt to set
	 */
	public void setResItemValueAmt(String resItemValueAmt) {
		this.resItemValueAmt = resItemValueAmt;
	}
	/**
	 * @return the resItemValMethodId
	 */
	public String getResItemValMethodId() {
		return resItemValMethodId;
	}
	/**
	 * @param resItemValMethodId the resItemValMethodId to set
	 */
	public void setResItemValMethodId(String resItemValMethodId) {
		this.resItemValMethodId = resItemValMethodId;
	}
	/**
	 * @return the resItemValEffDt
	 */
	public String getResItemValEffDt() {
		return resItemValEffDt;
	}
	/**
	 * @param resItemValEffDt the resItemValEffDt to set
	 */
	public void setResItemValEffDt(String resItemValEffDt) {
		this.resItemValEffDt = resItemValEffDt;
	}
	/**
	 * @return the resItemBalCurrId
	 */
	public String geteResItemBalCurrId() {
		return eResItemBalCurrId;
	}
	/**
	 * @param resItemBalCurrId the resItemBalCurrId to set
	 */
	public void setEResItemBalCurrId(String eResItemBalCurrId) {
		this.eResItemBalCurrId = eResItemBalCurrId;
	}
	/**
	 * @return the resItemBalTypId
	 */
	public String geteResItemBalTypId() {
		return eResItemBalTypId;
	}
	/**
	 * @param resItemBalTypId the resItemBalTypId to set
	 */
	public void setEResItemBalTypId(String eResItemBalTypId) {
		this.eResItemBalTypId = eResItemBalTypId;
	}
	/**
	 * @return the resItemValEvtRsnTypId
	 */
	public String getResItemValEvtRsnTypId() {
		return resItemValEvtRsnTypId;
	}
	/**
	 * @param resItemValEvtRsnTypId the resItemValEvtRsnTypId to set
	 */
	public void setResItemValEvtRsnTypId(String resItemValEvtRsnTypId) {
		this.resItemValEvtRsnTypId = resItemValEvtRsnTypId;
	}
	/**
	 * @return the relEffDt
	 */
	public String getRelEffDt() {
		return relEffDt;
	}
	/**
	 * @param relEffDt the relEffDt to set
	 */
	public void setRelEffDt(String relEffDt) {
		this.relEffDt = relEffDt;
	}
	/**
	 * @return the colTypId
	 */
	public String getColTypId() {
		return colTypId;
	}
	/**
	 * @param colTypId the colTypId to set
	 */
	public void setColTypId(String colTypId) {
		this.colTypId = colTypId;
	}
	/**
	 * @return the globProdIdentifier
	 */
	public String geteGlobProdIdentifier() {
		return eGlobProdIdentifier;
	}
	/**
	 * @param globProdIdentifier the globProdIdentifier to set
	 */
	public void setEGlobProdIdentifier(String eGlobProdIdentifier) {
		this.eGlobProdIdentifier = eGlobProdIdentifier;
	}
	/**
	 * @return the stdArrgId
	 */
	public String geteStdArrgId() {
		return eStdArrgId;
	}
	/**
	 * @param stdArrgId the stdArrgId to set
	 */
	public void setEStdArrgId(String eStdArrgId) {
		this.eStdArrgId = eStdArrgId;
	}
	/**
	 * @return the arrgName
	 */
	public String getArrgName() {
		return arrgName;
	}
	/**
	 * @param arrgName the arrgName to set
	 */
	public void setArrgName(String arrgName) {
		this.arrgName = arrgName;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the bookingDt
	 */
	public String getBookingDt() {
		return bookingDt;
	}
	/**
	 * @param bookingDt the bookingDt to set
	 */
	public void setBookingDt(String bookingDt) {
		this.bookingDt = bookingDt;
	}
	/**
	 * @return the origEffDt
	 */
	public String getOrigEffDt() {
		return origEffDt;
	}
	/**
	 * @param origEffDt the origEffDt to set
	 */
	public void setOrigEffDt(String origEffDt) {
		this.origEffDt = origEffDt;
	}
	/**
	 * @return the effDt
	 */
	public String getEffDt() {
		return effDt;
	}
	/**
	 * @param effDt the effDt to set
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	/**
	 * @return the estEndDt
	 */
	public String getEstEndDt() {
		return estEndDt;
	}
	/**
	 * @param estEndDt the estEndDt to set
	 */
	public void setEstEndDt(String estEndDt) {
		this.estEndDt = estEndDt;
	}
	/**
	 * @return the endDt
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @param endDt the endDt to set
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	/**
	 * @return the arrngTypId
	 */
	public String getArrngTypId() {
		return arrngTypId;
	}
	/**
	 * @param arrngTypId the arrngTypId to set
	 */
	public void setArrngTypId(String arrngTypId) {
		this.arrngTypId = arrngTypId;
	}
	/**
	 * @return the denomCurrId
	 */
	public Integer geteDenomCurrId() {
		return eDenomCurrId;
	}
	/**
	 * @param denomCurrId the denomCurrId to set
	 */
	public void setEDenomCurrId(Integer eDenomCurrId) {
		this.eDenomCurrId = eDenomCurrId;
	}
	/**
	 * @return the orgChannelId
	 */
	public String getOrgChannelId() {
		return orgChannelId;
	}
	/**
	 * @param orgChannelId the orgChannelId to set
	 */
	public void setOrgChannelId(String orgChannelId) {
		this.orgChannelId = orgChannelId;
	}
	/**
	 * @return the arrgPurpTypId
	 */
	public String getArrgPurpTypId() {
		return arrgPurpTypId;
	}
	/**
	 * @param arrgPurpTypId the arrgPurpTypId to set
	 */
	public void setArrgPurpTypId(String arrgPurpTypId) {
		this.arrgPurpTypId = arrgPurpTypId;
	}
	/**
	 * @return the arrgBusIntentTyp
	 */
	public String getArrgBusIntentTyp() {
		return arrgBusIntentTyp;
	}
	/**
	 * @param arrgBusIntentTyp the arrgBusIntentTyp to set
	 */
	public void setArrgBusIntentTyp(String arrgBusIntentTyp) {
		this.arrgBusIntentTyp = arrgBusIntentTyp;
	}
	/**
	 * @return the arrgBusIntntDt
	 */
	public String getArrgBusIntntDt() {
		return arrgBusIntntDt;
	}
	/**
	 * @param arrgBusIntntDt the arrgBusIntntDt to set
	 */
	public void setArrgBusIntntDt(String arrgBusIntntDt) {
		this.arrgBusIntntDt = arrgBusIntntDt;
	}
	/**
	 * @return the pledgedInd
	 */
	public String getPledgedInd() {
		return pledgedInd;
	}
	/**
	 * @param pledgedInd the pledgedInd to set
	 */
	public void setPledgedInd(String pledgedInd) {
		this.pledgedInd = pledgedInd;
	}
	/**
	 * @return the pledgedEligInd
	 */
	public String getPledgedEligInd() {
		return pledgedEligInd;
	}
	/**
	 * @param pledgedEligInd the pledgedEligInd to set
	 */
	public void setPledgedEligInd(String pledgedEligInd) {
		this.pledgedEligInd = pledgedEligInd;
	}
	/**
	 * @return the arrgMatTypId
	 */
	public String getArrgMatTypId() {
		return arrgMatTypId;
	}
	/**
	 * @param arrgMatTypId the arrgMatTypId to set
	 */
	public void setArrgMatTypId(String arrgMatTypId) {
		this.arrgMatTypId = arrgMatTypId;
	}
	/**
	 * @return the arrgFinStsTypId
	 */
	public String getArrgFinStsTypId() {
		return arrgFinStsTypId;
	}
	/**
	 * @param arrgFinStsTypId the arrgFinStsTypId to set
	 */
	public void setArrgFinStsTypId(String arrgFinStsTypId) {
		this.arrgFinStsTypId = arrgFinStsTypId;
	}
	/**
	 * @return the arrgFinStsDt
	 */
	public String getArrgFinStsDt() {
		return arrgFinStsDt;
	}
	/**
	 * @param arrgFinStsDt the arrgFinStsDt to set
	 */
	public void setArrgFinStsDt(String arrgFinStsDt) {
		this.arrgFinStsDt = arrgFinStsDt;
	}
	/**
	 * @return the arrgPastDueDayCnt
	 */
	public String getArrgPastDueDayCnt() {
		return arrgPastDueDayCnt;
	}
	/**
	 * @param arrgPastDueDayCnt the arrgPastDueDayCnt to set
	 */
	public void setArrgPastDueDayCnt(String arrgPastDueDayCnt) {
		this.arrgPastDueDayCnt = arrgPastDueDayCnt;
	}
	/**
	 * @return the gracePrdDayCnt
	 */
	public String getGracePrdDayCnt() {
		return gracePrdDayCnt;
	}
	/**
	 * @param gracePrdDayCnt the gracePrdDayCnt to set
	 */
	public void setGracePrdDayCnt(String gracePrdDayCnt) {
		this.gracePrdDayCnt = gracePrdDayCnt;
	}
	/**
	 * @return the arrgPastDueAgngClss
	 */
	public String getArrgPastDueAgngClss() {
		return arrgPastDueAgngClss;
	}
	/**
	 * @param arrgPastDueAgngClss the arrgPastDueAgngClss to set
	 */
	public void setArrgPastDueAgngClss(String arrgPastDueAgngClss) {
		this.arrgPastDueAgngClss = arrgPastDueAgngClss;
	}
	/**
	 * @return the arrgPastDueAgngClssDt
	 */
	public String getArrgPastDueAgngClssDt() {
		return arrgPastDueAgngClssDt;
	}
	/**
	 * @param arrgPastDueAgngClssDt the arrgPastDueAgngClssDt to set
	 */
	public void setArrgPastDueAgngClssDt(String arrgPastDueAgngClssDt) {
		this.arrgPastDueAgngClssDt = arrgPastDueAgngClssDt;
	}
	/**
	 * @return the arrgFinStsRsnTypId
	 */
	public String getArrgFinStsRsnTypId() {
		return arrgFinStsRsnTypId;
	}
	/**
	 * @param arrgFinStsRsnTypId the arrgFinStsRsnTypId to set
	 */
	public void setArrgFinStsRsnTypId(String arrgFinStsRsnTypId) {
		this.arrgFinStsRsnTypId = arrgFinStsRsnTypId;
	}
	/**
	 * @return the arrgLifCyclStsTypId
	 */
	public String getArrgLifCyclStsTypId() {
		return arrgLifCyclStsTypId;
	}
	/**
	 * @param arrgLifCyclStsTypId the arrgLifCyclStsTypId to set
	 */
	public void setArrgLifCyclStsTypId(String arrgLifCyclStsTypId) {
		this.arrgLifCyclStsTypId = arrgLifCyclStsTypId;
	}
	/**
	 * @return the arrgLifCyclStsRsnTypId
	 */
	public String getArrgLifCyclStsRsnTypId() {
		return arrgLifCyclStsRsnTypId;
	}
	/**
	 * @param arrgLifCyclStsRsnTypId the arrgLifCyclStsRsnTypId to set
	 */
	public void setArrgLifCyclStsRsnTypId(String arrgLifCyclStsRsnTypId) {
		this.arrgLifCyclStsRsnTypId = arrgLifCyclStsRsnTypId;
	}
	/**
	 * @return the arrgLifCycStsDt
	 */
	public String getArrgLifCycStsDt() {
		return arrgLifCycStsDt;
	}
	/**
	 * @param arrgLifCycStsDt the arrgLifCycStsDt to set
	 */
	public void setArrgLifCycStsDt(String arrgLifCycStsDt) {
		this.arrgLifCycStsDt = arrgLifCycStsDt;
	}
	/**
	 * @return the arrgNxtRnwlDt
	 */
	public String getArrgNxtRnwlDt() {
		return arrgNxtRnwlDt;
	}
	/**
	 * @param arrgNxtRnwlDt the arrgNxtRnwlDt to set
	 */
	public void setArrgNxtRnwlDt(String arrgNxtRnwlDt) {
		this.arrgNxtRnwlDt = arrgNxtRnwlDt;
	}
	/**
	 * @return the creditRiskMtgtTypId
	 */
	public String geteCreditRiskMtgtTypId() {
		return eCreditRiskMtgtTypId;
	}
	/**
	 * @param creditRiskMtgtTypId the creditRiskMtgtTypId to set
	 */
	public void setECreditRiskMtgtTypId(String eCreditRiskMtgtTypId) {
		this.eCreditRiskMtgtTypId = eCreditRiskMtgtTypId;
	}
	/**
	 * @return the collSrcTypId
	 */
	public String getCollSrcTypId() {
		return collSrcTypId;
	}
	/**
	 * @param collSrcTypId the collSrcTypId to set
	 */
	public void setCollSrcTypId(String collSrcTypId) {
		this.collSrcTypId = collSrcTypId;
	}
	/**
	 * @return the loanToAssetRelnType
	 */
	public String getLoanToAssetRelnType() {
		return loanToAssetRelnType;
	}
	/**
	 * @param loanToAssetRelnType the loanToAssetRelnType to set
	 */
	public void setLoanToAssetRelnType(String loanToAssetRelnType) {
		this.loanToAssetRelnType = loanToAssetRelnType;
	}
	/**
	 * @return the propApprTypId
	 */
	public String getPropApprTypId() {
		return propApprTypId;
	}
	/**
	 * @param propApprTypId the propApprTypId to set
	 */
	public void setPropApprTypId(String propApprTypId) {
		this.propApprTypId = propApprTypId;
	}
	/**
	 * @return the eCommonBalMtgTRLRecords
	 */
	public List<CommonBalanceMtgTRLRecord> geteCommonBalMtgTRLRecords() {
		return eCommonBalMtgTRLRecords;
	}
	/**
	 * @param eCommonBalMtgTRLRecords the eCommonBalMtgTRLRecords to set
	 */
	public void setECommonBalMtgTRLRecords(List<CommonBalanceMtgTRLRecord> eCommonBalMtgTRLRecords) {
		this.eCommonBalMtgTRLRecords = eCommonBalMtgTRLRecords;
	}
	public Double geteBaseAmtCurr() {
		return eBaseAmtCurr;
	}
	public void setEBaseAmtCurr(Double eBaseAmtCurr) {
		this.eBaseAmtCurr = eBaseAmtCurr;
	}
	/**
	 * @return the eLossMitgPrgmId
	 */
	public Integer geteLossMitgPrgmId() {
		return eLossMitgPrgmId;
	}
	/**
	 * @param eLossMitgPrgmId the eLossMitgPrgmId to set
	 */
	public void setELossMitgPrgmId(Integer eLossMitgPrgmId) {
		this.eLossMitgPrgmId = eLossMitgPrgmId;
	}
	/**
	 * @return the eISupTypId
	 */
	public Integer geteISupTypId() {
		return eISupTypId;
	}
	/**
	 * @param eISupTypId the eISupTypId to set
	 */
	public void setEISupTypId(Integer eISupTypId) {
		this.eISupTypId = eISupTypId;
	}
	public String getePmacPortId() {
		return ePmacPortId;
	}
	public void setEPmacPortId(String ePmacPortId) {
		this.ePmacPortId = ePmacPortId;
	}
	public Date geteCaEndDate() {
		return eCaEndDate;
	}
	public void setECaEndDate(Date eCaEndDate) {
		this.eCaEndDate = eCaEndDate;
	}
	public Date geteRptMonthDate() {
		return eRptMonthDate;
	}
	public void setERptMonthDate(Date eRptMonthDate) {
		this.eRptMonthDate = eRptMonthDate;
	}
	/**
	 * @return the eArRank
	 */
	public Integer geteARGRank() {
		return eARGRank;
	}
	/**
	 * @param eArRank the eArRank to set
	 */
	public void setEARGRank(Integer eARGRank) {
		this.eARGRank = eARGRank;
	}
	public Date geteARGEffDate() {
		return eARGEffDate;
	}
	public void setEARGEffDate(Date eARGEffDate) {
		this.eARGEffDate = eARGEffDate;
	}
	public Date geteARGEndDate() {
		return eARGEndDate;
	}
	public void setEARGEndDate(Date eARGEndDate) {
		this.eARGEndDate = eARGEndDate;
	}
	public Date geteAIPEffDate() {
		return eAIPEffDate;
	}
	public void setEAIPEffDate(Date eAIPEffDate) {
		this.eAIPEffDate = eAIPEffDate;
	}
	public Date geteAIPEndDate() {
		return eAIPEndDate;
	}
	public void setEAIPEndDate(Date eAIPEndDate) {
		this.eAIPEndDate = eAIPEndDate;
	}
	public Date geteAREndDate() {
		return eAREndDate;
	}
	public void setEAREndDate(Date eAREndDate) {
		this.eAREndDate = eAREndDate;
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
	public void seteCAArrngBusIntType(Integer eCAArrngBusIntType) {
		this.eCAArrngBusIntType = eCAArrngBusIntType;
	}
	public Date geteAIREndDate() {
		return eAIREndDate;
	}
	public void setEAIREndDate(Date eAIREndDate) {
		this.eAIREndDate = eAIREndDate;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 
	@Override
	public String toString() {
		return "MortgageTRLRecord [eUniqueId=" + eUniqueId + ", eSrcSysId="
				+ eSrcSysId + ", eProdSysId=" + eProdSysId + ", eRecType="
				+ eRecType + ", eAsOfDt=" + eAsOfDt + ", eGlbProdId="
				+ eGlbProdId + ", eLocalProductId=" + eLocalProductId
				+ ", localSubProductId=" + localSubProductId
				+ ", entStandProductId=" + entStandProductId + ", arrngName="
				+ arrngName + ", eDescription=" + eDescription
				+ ", eBookingDate=" + eBookingDate + ", eOriginalEffDate="
				+ eOriginalEffDate + ", eEffDate=" + eEffDate
				+ ", eEstmEndDate=" + eEstmEndDate + ", eEndDate=" + eEndDate
				+ ", eDenoCurrId=" + eDenoCurrId + ", eOrigChannelId="
				+ eOrigChannelId + ", eArrngPurpTypeId=" + eArrngPurpTypeId
				+ ", eArrngBusIntType=" + eArrngBusIntType
				+ ", eArrngBussIntDate=" + eArrngBussIntDate + ", ePledgInd="
				+ ePledgInd + ", ePledgEligInd=" + ePledgEligInd
				+ ", eArrngMatuTypeId=" + eArrngMatuTypeId
				+ ", eArrngFinStatTypId=" + eArrngFinStatTypId
				+ ", eArrngFinStatDate=" + eArrngFinStatDate
				+ ", eArrngPastDueDayCount=" + eArrngPastDueDayCount
				+ ", eGracePerDayCnt=" + eGracePerDayCnt
				+ ", eArrngPastDueAgeClass=" + eArrngPastDueAgeClass
				+ ", eArrngPastDueAgeClassDate=" + eArrngPastDueAgeClassDate
				+ ", eArrngLifeCycleStatusReasonTypeId="
				+ eArrngLifeCycleStatusReasonTypeId
				+ ", eArrngLifeCycleStatusId=" + eArrngLifeCycleStatusId
				+ ", eArrngLifeCycleStatusDate=" + eArrngLifeCycleStatusDate
				+ ", arrngNxtRenewalDate=" + arrngNxtRenewalDate
				+ ", arrngPriPayTypId=" + arrngPriPayTypId
				+ ", eArrngAcqTypId=" + eArrngAcqTypId + ", eArrngAcqDt="
				+ eArrngAcqDt + ", arrngDisTypId=" + arrngDisTypId
				+ ", arrngDisTypDate=" + arrngDisTypDate + ", eChrgOffTypeId="
				+ eChrgOffTypeId + ", oriInvInsCatId=" + oriInvInsCatId
				+ ", oriInvInsActFlag=" + oriInvInsActFlag + ", oriInvInsPer="
				+ oriInvInsPer + ", arrngDayCntConTypId=" + arrngDayCntConTypId
				+ ", eIntPayFrePerId=" + eIntPayFrePerId
				+ ", eRateResetPerIntId=" + eRateResetPerIntId
				+ ", inIntRateResetDate=" + inIntRateResetDate
				+ ", nxtIntRateResetDate=" + nxtIntRateResetDate
				+ ", prevLstIntRateResetDate=" + prevLstIntRateResetDate
				+ ", taxExemInd=" + taxExemInd + ", onBnkRelnInd="
				+ onBnkRelnInd + ", eFinServiceTypId=" + eFinServiceTypId
				+ ", eFinServiceLimitTypId=" + eFinServiceLimitTypId
				+ ", eOriginalAmt=" + eOriginalAmt + ", eOrgAmount="
				+ eOrgAmount + ", eArrngSecTypId=" + eArrngSecTypId
				+ ", citiRecInd=" + citiRecInd + ", payFrePerId=" + payFrePerId
				+ ", eIntrstAccrualStatTypId=" + eIntrstAccrualStatTypId
				+ ", eIntrstAccrualStatTypDate=" + eIntrstAccrualStatTypDate
				+ ", intOnlyTermPeriod=" + intOnlyTermPeriod
				+ ", finSerResCurStId=" + finSerResCurStId
				+ ", finSerResCurStDate=" + finSerResCurStDate
				+ ", finSerPrevResStId=" + finSerPrevResStId
				+ ", finSerPrevResStDate=" + finSerPrevResStDate
				+ ", trbDebtResFlag=" + trbDebtResFlag
				+ ", mktRateYieldReneFlag=" + mktRateYieldReneFlag
				+ ", skipPayInd=" + skipPayInd + ", eSecInd=" + eSecInd
				+ ", trppTenor=" + trppTenor + ", acctTrppInsAmt="
				+ acctTrppInsAmt + ", locAutExtFlag=" + locAutExtFlag
				+ ", locTermLoanCovFlag=" + locTermLoanCovFlag
				+ ", inDocTypId=" + inDocTypId + ", finserModProgStDate="
				+ finserModProgStDate + ", finserModProgEndDate="
				+ finserModProgEndDate + ", finSerResModRsnTypId="
				+ finSerResModRsnTypId + ", finSerModProgId=" + finSerModProgId
				+ ", finSerModProgCurrSts=" + finSerModProgCurrSts
				+ ", finSerModProgCurrStsDate=" + finSerModProgCurrStsDate
				+ ", finSerModProgPrevStsTypId=" + finSerModProgPrevStsTypId
				+ ", modRetenLossMitTypId=" + modRetenLossMitTypId
				+ ", CreFacTypId=" + CreFacTypId + ", eFacilLegalStsTypId="
				+ eFacilLegalStsTypId + ", FacilLegalStsDate="
				+ FacilLegalStsDate + ", eCreFacArrngAppTypId="
				+ eCreFacArrngAppTypId + ", creFacArrngAppTypDate="
				+ creFacArrngAppTypDate + ", creFacRegSegTypId="
				+ creFacRegSegTypId + ", creFacAvastaTypId="
				+ creFacAvastaTypId + ", lstCreLmtChngDate="
				+ lstCreLmtChngDate + ", creLimitChnTypId=" + creLimitChnTypId
				+ ", eArrngNextPymtDueToBankAmt=" + eArrngNextPymtDueToBankAmt
				+ ", eArrngNextPymtDueToBankDate="
				+ eArrngNextPymtDueToBankDate + ", eArrngLastPymtToBankDate="
				+ eArrngLastPymtToBankDate + ", eMissedPymtNumb="
				+ eMissedPymtNumb + ", acctLstRecDate=" + acctLstRecDate
				+ ", acctLstInsDate=" + acctLstInsDate + ", totPay=" + totPay
				+ ", acctLstIntRevDate=" + acctLstIntRevDate + ", PenRate="
				+ PenRate + ", PenAmt=" + PenAmt + ", legNotDays=" + legNotDays
				+ ", eBaselPortfolioId=" + eBaselPortfolioId + ", othAltIdent="
				+ othAltIdent + ", eLocalProdCategoryCode="
				+ eLocalProdCategoryCode + ", eDelq30DayPast2YrsFlag="
				+ eDelq30DayPast2YrsFlag + ", linePosTypId=" + linePosTypId
				+ ", eActualBillingCycleDate=" + eActualBillingCycleDate
				+ ", feePayFreqPerId=" + feePayFreqPerId + ", notPerDays="
				+ notPerDays + ", eCurrAmtType=" + eCurrAmtType
				+ ", feeWavFlag=" + feeWavFlag + ", borDate=" + borDate
				+ ", socEcoCatId=" + socEcoCatId + ", acctFirstAdvAmt="
				+ acctFirstAdvAmt + ", acctFirstAdvDate=" + acctFirstAdvDate
				+ ", acctFirstPayDate=" + acctFirstPayDate
				+ ", acctLastAdvAmt=" + acctLastAdvAmt + ", acctLastAdvDate="
				+ acctLastAdvDate + ", acqCost=" + acqCost
				+ ", eObligorRecourseInd=" + eObligorRecourseInd
				+ ", docTypId=" + docTypId + ", mtgModSigDate=" + mtgModSigDate
				+ ", mtgOriProgTypCode=" + mtgOriProgTypCode
				+ ", mtgCreRiskCatIntId=" + mtgCreRiskCatIntId
				+ ", eBalloonInd=" + eBalloonInd + ", helocTerm=" + helocTerm
				+ ", lmPlanCdId=" + lmPlanCdId + ", escAcctMaintInd="
				+ escAcctMaintInd + ", mtgOriProgGroupId=" + mtgOriProgGroupId
				+ ", comboLoanInd=" + comboLoanInd + ", sopAcctInd="
				+ sopAcctInd + ", negAmortFlag=" + negAmortFlag
				+ ", intCalPerId=" + intCalPerId + ", preComLoanFlag="
				+ preComLoanFlag + ", amortAccInd=" + amortAccInd
				+ ", eNumSchePaymt=" + eNumSchePaymt + ", eNumRemPaymt="
				+ eNumRemPaymt + ", linePosTypEffDate=" + linePosTypEffDate
				+ ", delqMethCode=" + delqMethCode + ", accFirstPayAmt="
				+ accFirstPayAmt + ", eRestructureFlag=" + eRestructureFlag
				+ ", eRegOEmpFlag=" + eRegOEmpFlag + ", probOfDefault="
				+ probOfDefault + ", eCrdtLimitEffctDate="
				+ eCrdtLimitEffctDate + ", eCrdtLimitEndtDate="
				+ eCrdtLimitEndtDate + ", creditLmtEventInvTypId="
				+ creditLmtEventInvTypId + ", creditLmtEventAmt="
				+ creditLmtEventAmt + ", eCcarProdCode=" + eCcarProdCode
				+ ", banktrupcyDate=" + banktrupcyDate
				+ ", promoIntRtaeEliFlag=" + promoIntRtaeEliFlag
				+ ", eOrgAdvisedCommitedLimit=" + eOrgAdvisedCommitedLimit
				+ ", pmacPortId=" + pmacPortId + ", eOrgAcctNumbr="
				+ eOrgAcctNumbr + ", lstWriteDwnDate=" + lstWriteDwnDate
				+ ", currNegAmmFlag=" + currNegAmmFlag + ", prinDeffOptFlag="
				+ prinDeffOptFlag + ", prinDeffOptEndDtae="
				+ prinDeffOptEndDtae + ", intDeffOptFlag=" + intDeffOptFlag
				+ ", intDeffOptEndDtae=" + intDeffOptEndDtae
				+ ", intOnlyOptEndDtae=" + intOnlyOptEndDtae
				+ ", eOrgCombLtvRatio=" + eOrgCombLtvRatio + ", eOrgLtvRatio="
				+ eOrgLtvRatio + ", totOriJunLienAmt=" + totOriJunLienAmt
				+ ", eEverWrittenOffFlag=" + eEverWrittenOffFlag
				+ ", reoStsTypId=" + reoStsTypId + ", eNonTradeResidMtgFlag="
				+ eNonTradeResidMtgFlag + ", mobLocal=" + mobLocal
				+ ", riskMngInd=" + riskMngInd + ", DaysPastDueCyclEnd="
				+ DaysPastDueCyclEnd + ", eDelinquencyBucket="
				+ eDelinquencyBucket + ", cycleEndDelqBucket="
				+ cycleEndDelqBucket + ", reservedForFutureGenesisUse1="
				+ reservedForFutureGenesisUse1
				+ ", reservedForFutureGenesisUse2="
				+ reservedForFutureGenesisUse2
				+ ", reservedForFutureGenesisUse3="
				+ reservedForFutureGenesisUse3
				+ ", reservedForFutureGenesisUse4="
				+ reservedForFutureGenesisUse4
				+ ", reservedForFutureGenesisUse5="
				+ reservedForFutureGenesisUse5
				+ ", reservedForFutureGenesisUse6="
				+ reservedForFutureGenesisUse6
				+ ", reservedForFutureGenesisUse7="
				+ reservedForFutureGenesisUse7
				+ ", reservedForFutureGenesisUse8="
				+ reservedForFutureGenesisUse8
				+ ", reservedForFutureGenesisUse9="
				+ reservedForFutureGenesisUse9
				+ ", reservedForFutureGenesisUse10="
				+ reservedForFutureGenesisUse10 + ", arrngFinStatusRsnTypId="
				+ arrngFinStatusRsnTypId + ", acctLastPaymtToBnkAcct="
				+ acctLastPaymtToBnkAcct + ", orgAdvisedUnCommitedLimit="
				+ orgAdvisedUnCommitedLimit + ", orgUnAdvisedCommitedLimit="
				+ orgUnAdvisedCommitedLimit + ", eLegNumber=" + eLegNumber
				+ ", eGlSysId=" + eGlSysId + ", eDealId=" + eDealId
				+ ", eBookingLedgrCntryCode=" + eBookingLedgrCntryCode
				+ ", eGLAccount1=" + eGLAccount1 + ", eGlAccount2="
				+ eGlAccount2 + ", eFdlAccount=" + eFdlAccount + ", eTxnAmt="
				+ eTxnAmt + ", eFuncAmt=" + eFuncAmt + ", eBaseAmt=" + eBaseAmt
				+ ", eGoc=" + eGoc + ", eBookingLedgrBrCode="
				+ eBookingLedgrBrCode + ", eFrsBuCode=" + eFrsBuCode
				+ ", eNotForUse=" + eNotForUse + ", eLclDeptId=" + eLclDeptId
				+ ", eLclLglVehicleCde=" + eLclLglVehicleCde
				+ ", eFairValAcctMthFlg=" + eFairValAcctMthFlg
				+ ", eFairValLvl=" + eFairValLvl + ", eExpCode=" + eExpCode
				+ ", eLocalProdCode=" + eLocalProdCode + ", eFrsAffCode="
				+ eFrsAffCode + ", eSubStatCode=" + eSubStatCode
				+ ", eMicroCntrlCode=" + eMicroCntrlCode
				+ ", eFirmAccountImsNmbr=" + eFirmAccountImsNmbr
				+ ", eBaseNmbr=" + eBaseNmbr + ", eIdProd=" + eIdProd
				+ ", eKeyCode1=" + eKeyCode1 + ", eKeyCode2=" + eKeyCode2
				+ ", eLclLdgrAcctNmbr=" + eLclLdgrAcctNmbr + ", eAdjInd="
				+ eAdjInd + ", eUserId=" + eUserId + ", eAdjResnCode="
				+ eAdjResnCode + ", eCmnReasonDesc=" + eCmnReasonDesc
				+ ", eLocalGlKey3=" + eLocalGlKey3 + ", eLocalGlKey4="
				+ eLocalGlKey4 + ", eAdjStndardArrngId=" + eAdjStndardArrngId
				+ ", eAdjFinMarketPositionId=" + eAdjFinMarketPositionId
				+ ", eResourceItemTypId=" + eResourceItemTypId
				+ ", primCollInd=" + primCollInd + ", revFreqId=" + revFreqId
				+ ", resourceItemName=" + resourceItemName
				+ ", collArrngUniqueIdInSrcSys=" + collArrngUniqueIdInSrcSys
				+ ", collArrngSrcSysId=" + collArrngSrcSysId
				+ ", resItemValuAmt=" + resItemValuAmt
				+ ", eResItemValMethodId=" + eResItemValMethodId
				+ ", legalEnfFlag=" + legalEnfFlag + ", legalRightToPossFlag="
				+ legalRightToPossFlag + ", reHypInd=" + reHypInd
				+ ", collLocCode=" + collLocCode + ", inValMarginFlag="
				+ inValMarginFlag + ", addTypId=" + addTypId
				+ ", loanToAssRelTyp=" + loanToAssRelTyp + ", occTyp=" + occTyp
				+ ", propApprDate=" + propApprDate + ", realPropTotUnit="
				+ realPropTotUnit + ", realPropTypId=" + realPropTypId
				+ ", propLocName=" + propLocName + ", ePropCity=" + ePropCity
				+ ", ePropCountry=" + ePropCountry + ", ePropState="
				+ ePropState + ", ePropZipCode=" + ePropZipCode
				+ ", ePropAddLine1=" + ePropAddLine1 + ", propAddLine2="
				+ propAddLine2 + ", propAddLine3=" + propAddLine3
				+ ", resItemValueAmt=" + resItemValueAmt
				+ ", resItemValMethodId=" + resItemValMethodId
				+ ", resItemValEffDt=" + resItemValEffDt
				+ ", eResItemBalCurrId=" + eResItemBalCurrId
				+ ", eResItemBalTypId=" + eResItemBalTypId
				+ ", resItemValEvtRsnTypId=" + resItemValEvtRsnTypId
				+ ", relEffDt=" + relEffDt + ", colTypId=" + colTypId
				+ ", eGlobProdIdentifier=" + eGlobProdIdentifier
				+ ", eStdArrgId=" + eStdArrgId + ", arrgName=" + arrgName
				+ ", desc=" + desc + ", bookingDt=" + bookingDt
				+ ", origEffDt=" + origEffDt + ", effDt=" + effDt
				+ ", estEndDt=" + estEndDt + ", endDt=" + endDt
				+ ", arrngTypId=" + arrngTypId + ", eDenomCurrId="
				+ eDenomCurrId + ", orgChannelId=" + orgChannelId
				+ ", arrgPurpTypId=" + arrgPurpTypId + ", arrgBusIntentTyp="
				+ arrgBusIntentTyp + ", arrgBusIntntDt=" + arrgBusIntntDt
				+ ", pledgedInd=" + pledgedInd + ", pledgedEligInd="
				+ pledgedEligInd + ", arrgMatTypId=" + arrgMatTypId
				+ ", arrgFinStsTypId=" + arrgFinStsTypId + ", arrgFinStsDt="
				+ arrgFinStsDt + ", arrgPastDueDayCnt=" + arrgPastDueDayCnt
				+ ", gracePrdDayCnt=" + gracePrdDayCnt
				+ ", arrgPastDueAgngClss=" + arrgPastDueAgngClss
				+ ", arrgPastDueAgngClssDt=" + arrgPastDueAgngClssDt
				+ ", arrgFinStsRsnTypId=" + arrgFinStsRsnTypId
				+ ", arrgLifCyclStsTypId=" + arrgLifCyclStsTypId
				+ ", arrgLifCyclStsRsnTypId=" + arrgLifCyclStsRsnTypId
				+ ", arrgLifCycStsDt=" + arrgLifCycStsDt + ", arrgNxtRnwlDt="
				+ arrgNxtRnwlDt + ", eCreditRiskMtgtTypId="
				+ eCreditRiskMtgtTypId + ", collSrcTypId=" + collSrcTypId
				+ ", loanToAssetRelnType=" + loanToAssetRelnType
				+ ", propApprTypId=" + propApprTypId + ", speedRatePer="
				+ speedRatePer + ", arrngRateTypRelnTypId="
				+ arrngRateTypRelnTypId + ", rateTyp=" + rateTyp + ", rateId="
				+ rateId + ", rateTypEffDate=" + rateTypEffDate
				+ ", eRateActiveFlag=" + eRateActiveFlag
				+ ", reservedForFutureGenesisUse11="
				+ reservedForFutureGenesisUse11
				+ ", reservedForFutureGenesisUse12="
				+ reservedForFutureGenesisUse12
				+ ", reservedForFutureGenesisUse13="
				+ reservedForFutureGenesisUse13
				+ ", reservedForFutureGenesisUse14="
				+ reservedForFutureGenesisUse14
				+ ", reservedForFutureGenesisUse15="
				+ reservedForFutureGenesisUse15 + ", rateName=" + rateName
				+ ", eRateVarTypeId=" + eRateVarTypeId + ", eRatingIssId="
				+ eRatingIssId + ", eModelCd=" + eModelCd
				+ ", eRatingEvnRsnTypId=" + eRatingEvnRsnTypId + ", eRank="
				+ eRank + ", eRatingTypCd=" + eRatingTypCd + ", eRatingCd="
				+ eRatingCd + ", eFicoEquvRatingCode=" + eFicoEquvRatingCode
				+ ", ratingDesc=" + ratingDesc + ", eScoreReqReturnFlag="
				+ eScoreReqReturnFlag + ", eInvPtyUniqueId=" + eInvPtyUniqueId
				+ ", eOrigChnlId=" + eOrigChnlId + ", eArrngDayCntConvTypId="
				+ eArrngDayCntConvTypId + ", eIntrPayFreqPeriodId="
				+ eIntrPayFreqPeriodId + ", eRateResetPerodInterId="
				+ eRateResetPerodInterId + ", eNxtIntrRateResetDate="
				+ eNxtIntrRateResetDate + ", eArrngSecurTypeId="
				+ eArrngSecurTypeId + ", eSecurizedInd=" + eSecurizedInd
				+ ", eCreditFacTypId=" + eCreditFacTypId
				+ ", eCreditFacArrngAppTypId=" + eCreditFacArrngAppTypId
				+ ", eOriAmt=" + eOriAmt + ", eCrdtLimitChangeTypeId="
				+ eCrdtLimitChangeTypeId + ", eAcLastPymtToBankAmount="
				+ eAcLastPymtToBankAmount + ", eOriLtvRatio=" + eOriLtvRatio
				+ ", eArrngPtyRolType=" + eArrngPtyRolType + ", ePctAmt="
				+ ePctAmt + ", eInvPtySubtypeId=" + eInvPtySubtypeId
				+ ", scoreReqReturnedFlg=" + scoreReqReturnedFlg
				+ ", uniqueIdCardArng=" + uniqueIdCardArng
				+ ", supportSeqNumber=" + supportSeqNumber
				+ ", guranteeSupportTypeId=" + guranteeSupportTypeId
				+ ", guranteeSupportCovBasicTypeId="
				+ guranteeSupportCovBasicTypeId + ", guranteeSupportCovTypeId="
				+ guranteeSupportCovTypeId + ", guranteeEffDate="
				+ guranteeEffDate + ", guranteeEndDate=" + guranteeEndDate
				+ ", insurenceTypeId=" + insurenceTypeId
				+ ", insurenceSupportCovBasicTypeId="
				+ insurenceSupportCovBasicTypeId
				+ ", insurenceSupportCovTypeId=" + insurenceSupportCovTypeId
				+ ", insurenceEffDate=" + insurenceEffDate
				+ ", insurenceEndDate=" + insurenceEndDate + ", ePropApprDate="
				+ ePropApprDate + ", eEffectiveRatePercentage="
				+ eEffectiveRatePercentage + ", eRateVarTypId=" + eRateVarTypId
				+ ", eRateTypeId=" + eRateTypeId + ", eBalType=" + eBalType
				+ ", eFuncCurr=" + eFuncCurr + ", eRepPeriodMonth="
				+ eRepPeriodMonth + ", eLoanAssestRelnType="
				+ eLoanAssestRelnType + ", eRealPropType=" + eRealPropType
				+ ", eArrngFinClassDate=" + eArrngFinClassDate
				+ ", eIntrstAccrualStatTypDt=" + eIntrstAccrualStatTypDt
				+ ", eRelationEffDate=" + eRelationEffDate
				+ ", eFacLegStatTypId=" + eFacLegStatTypId
				+ ", eAssestRelationType=" + eAssestRelationType
				+ ", eRecTypeColl=" + eRecTypeColl + ", eGAAPInd=" + eGAAPInd
				+ ", eTranCurr=" + eTranCurr + ", eBaseCurrCode="
				+ eBaseCurrCode + ", eEntProdId=" + eEntProdId
				+ ", eIntrBAsicCalcPeriodId=" + eIntrBAsicCalcPeriodId
				+ ", invPtyLocRltnpTypId=" + invPtyLocRltnpTypId
				+ ", eUniqueIdSrcSysInvlParty=" + eUniqueIdSrcSysInvlParty
				+ ", eMtgTdrRecord=" + eMtgTdrRecord + ", eMemoRecord="
				+ eMemoRecord + ", eInvlvPartySubTypeId="
				+ eInvlvPartySubTypeId + ", eWrtOffRecord=" + eWrtOffRecord
				+ ", eRecRecord=" + eRecRecord + ", eBaseAmtCurr="
				+ eBaseAmtCurr + ", eLossMitgPrgmId=" + eLossMitgPrgmId
				+ ", eISupTypId=" + eISupTypId + ", eCommonBalMtgTRLRecords="
				+ eCommonBalMtgTRLRecords + "]";
	}*/

}