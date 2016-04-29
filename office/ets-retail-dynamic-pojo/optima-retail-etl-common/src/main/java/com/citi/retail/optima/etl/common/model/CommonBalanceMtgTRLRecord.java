/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gv74035
 *
 */
public class CommonBalanceMtgTRLRecord extends ExcludableRecord{
	
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
	private Integer FacilLegalStsDate;
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
	private String eOrgLtvRatio; /////
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



	//private String eGlAcct1;
	//private Long eTxnAmt;
	
	//private Integer balanceTyp;
	
	/*public String geteGlAcct1() {
		return eGlAcct1;
	}



	public void setEGlAcct1(String eGlAcct1) {
		this.eGlAcct1 = eGlAcct1;
	}*/



	/*public Long geteTransactianlaAmnt() {
		return eTransactianlaAmnt;
	}



	public void seteTransactianlaAmnt(Long eTransactianlaAmnt) {
		this.eTransactianlaAmnt = eTransactianlaAmnt;
	}*/

	public String geteGAAPInd() {
		return eGAAPInd;
	}



	public void setEGAAPInd(String eGAAPInd) {
		this.eGAAPInd = eGAAPInd;
	}



	
	public CommonBalanceMtgTRLRecord(){
		super();		
	}

	
	
	public String geteUniqueId() {
		return eUniqueId;
	}



	public void seteUniqueId(String eUniqueId) {
		this.eUniqueId = eUniqueId;
	}



	public String geteSrcSysId() {
		return eSrcSysId;
	}



	public void seteSrcSysId(String eSrcSysId) {
		this.eSrcSysId = eSrcSysId;
	}



	public String geteProdSysId() {
		return eProdSysId;
	}



	public void seteProdSysId(String eProdSysId) {
		this.eProdSysId = eProdSysId;
	}



	public String geteRecType() {
		return eRecType;
	}



	public void seteRecType(String eRecType) {
		this.eRecType = eRecType;
	}



	public Date geteAsOfDt() {
		return eAsOfDt;
	}



	public void seteAsOfDt(Date eAsOfDt) {
		this.eAsOfDt = eAsOfDt;
	}



	public String geteGlbProdId() {
		return eGlbProdId;
	}



	public void seteGlbProdId(String eGlbProdId) {
		this.eGlbProdId = eGlbProdId;
	}



	public String geteLocalProductId() {
		return eLocalProductId;
	}



	public void seteLocalProductId(String eLocalProductId) {
		this.eLocalProductId = eLocalProductId;
	}



	public String getLocalSubProductId() {
		return localSubProductId;
	}



	public void setLocalSubProductId(String localSubProductId) {
		this.localSubProductId = localSubProductId;
	}



	public String getEntStandProductId() {
		return entStandProductId;
	}



	public void setEntStandProductId(String entStandProductId) {
		this.entStandProductId = entStandProductId;
	}



	public String getArrngName() {
		return arrngName;
	}



	public void setArrngName(String arrngName) {
		this.arrngName = arrngName;
	}



	public String geteDescription() {
		return eDescription;
	}



	public void seteDescription(String eDescription) {
		this.eDescription = eDescription;
	}



	public Date geteBookingDate() {
		return eBookingDate;
	}



	public void seteBookingDate(Date eBookingDate) {
		this.eBookingDate = eBookingDate;
	}



	public Date geteOriginalEffDate() {
		return eOriginalEffDate;
	}



	public void seteOriginalEffDate(Date eOriginalEffDate) {
		this.eOriginalEffDate = eOriginalEffDate;
	}



	public Date geteEffDate() {
		return eEffDate;
	}



	public void seteEffDate(Date eEffDate) {
		this.eEffDate = eEffDate;
	}



	public Date geteEstmEndDate() {
		return eEstmEndDate;
	}



	public void seteEstmEndDate(Date eEstmEndDate) {
		this.eEstmEndDate = eEstmEndDate;
	}



	public Date geteEndDate() {
		return eEndDate;
	}



	public void seteEndDate(Date eEndDate) {
		this.eEndDate = eEndDate;
	}



	public String geteDenoCurrId() {
		return eDenoCurrId;
	}



	public void seteDenoCurrId(String eDenoCurrId) {
		this.eDenoCurrId = eDenoCurrId;
	}



	public Integer geteOrigChannelId() {
		return eOrigChannelId;
	}



	public void seteOrigChannelId(Integer eOrigChannelId) {
		this.eOrigChannelId = eOrigChannelId;
	}



	public String geteArrngPurpTypeId() {
		return eArrngPurpTypeId;
	}



	public void seteArrngPurpTypeId(String eArrngPurpTypeId) {
		this.eArrngPurpTypeId = eArrngPurpTypeId;
	}



	public Integer geteArrngBusIntType() {
		return eArrngBusIntType;
	}



	public void seteArrngBusIntType(Integer eArrngBusIntType) {
		this.eArrngBusIntType = eArrngBusIntType;
	}



	public Date geteArrngBussIntDate() {
		return eArrngBussIntDate;
	}



	public void seteArrngBussIntDate(Date eArrngBussIntDate) {
		this.eArrngBussIntDate = eArrngBussIntDate;
	}



	public String getePledgInd() {
		return ePledgInd;
	}



	public void setePledgInd(String ePledgInd) {
		this.ePledgInd = ePledgInd;
	}



	public String getePledgEligInd() {
		return ePledgEligInd;
	}



	public void setePledgEligInd(String ePledgEligInd) {
		this.ePledgEligInd = ePledgEligInd;
	}



	public Integer geteArrngMatuTypeId() {
		return eArrngMatuTypeId;
	}



	public void seteArrngMatuTypeId(Integer eArrngMatuTypeId) {
		this.eArrngMatuTypeId = eArrngMatuTypeId;
	}



	public String geteArrngFinStatTypId() {
		return eArrngFinStatTypId;
	}



	public void seteArrngFinStatTypId(String eArrngFinStatTypId) {
		this.eArrngFinStatTypId = eArrngFinStatTypId;
	}



	public Date geteArrngFinStatDate() {
		return eArrngFinStatDate;
	}



	public void seteArrngFinStatDate(Date eArrngFinStatDate) {
		this.eArrngFinStatDate = eArrngFinStatDate;
	}



	public Integer geteArrngPastDueDayCount() {
		return eArrngPastDueDayCount;
	}



	public void seteArrngPastDueDayCount(Integer eArrngPastDueDayCount) {
		this.eArrngPastDueDayCount = eArrngPastDueDayCount;
	}



	public Integer geteGracePerDayCnt() {
		return eGracePerDayCnt;
	}



	public void seteGracePerDayCnt(Integer eGracePerDayCnt) {
		this.eGracePerDayCnt = eGracePerDayCnt;
	}



	public Integer geteArrngPastDueAgeClass() {
		return eArrngPastDueAgeClass;
	}



	public void seteArrngPastDueAgeClass(Integer eArrngPastDueAgeClass) {
		this.eArrngPastDueAgeClass = eArrngPastDueAgeClass;
	}



	public Date geteArrngPastDueAgeClassDate() {
		return eArrngPastDueAgeClassDate;
	}



	public void seteArrngPastDueAgeClassDate(Date eArrngPastDueAgeClassDate) {
		this.eArrngPastDueAgeClassDate = eArrngPastDueAgeClassDate;
	}



	public Integer geteArrngLifeCycleStatusReasonTypeId() {
		return eArrngLifeCycleStatusReasonTypeId;
	}



	public void seteArrngLifeCycleStatusReasonTypeId(
			Integer eArrngLifeCycleStatusReasonTypeId) {
		this.eArrngLifeCycleStatusReasonTypeId = eArrngLifeCycleStatusReasonTypeId;
	}



	public Integer geteArrngLifeCycleStatusId() {
		return eArrngLifeCycleStatusId;
	}



	public void seteArrngLifeCycleStatusId(Integer eArrngLifeCycleStatusId) {
		this.eArrngLifeCycleStatusId = eArrngLifeCycleStatusId;
	}



	public Date geteArrngLifeCycleStatusDate() {
		return eArrngLifeCycleStatusDate;
	}



	public void seteArrngLifeCycleStatusDate(Date eArrngLifeCycleStatusDate) {
		this.eArrngLifeCycleStatusDate = eArrngLifeCycleStatusDate;
	}



	public Date getArrngNxtRenewalDate() {
		return arrngNxtRenewalDate;
	}



	public void setArrngNxtRenewalDate(Date arrngNxtRenewalDate) {
		this.arrngNxtRenewalDate = arrngNxtRenewalDate;
	}



	public Integer getArrngPriPayTypId() {
		return arrngPriPayTypId;
	}



	public void setArrngPriPayTypId(Integer arrngPriPayTypId) {
		this.arrngPriPayTypId = arrngPriPayTypId;
	}



	public Integer geteArrngAcqTypId() {
		return eArrngAcqTypId;
	}



	public void seteArrngAcqTypId(Integer eArrngAcqTypId) {
		this.eArrngAcqTypId = eArrngAcqTypId;
	}



	public Date geteArrngAcqDt() {
		return eArrngAcqDt;
	}



	public void seteArrngAcqDt(Date eArrngAcqDt) {
		this.eArrngAcqDt = eArrngAcqDt;
	}



	public Integer getArrngDisTypId() {
		return arrngDisTypId;
	}



	public void setArrngDisTypId(Integer arrngDisTypId) {
		this.arrngDisTypId = arrngDisTypId;
	}



	public Date getArrngDisTypDate() {
		return arrngDisTypDate;
	}



	public void setArrngDisTypDate(Date arrngDisTypDate) {
		this.arrngDisTypDate = arrngDisTypDate;
	}



	public Integer geteChrgOffTypeId() {
		return eChrgOffTypeId;
	}



	public void seteChrgOffTypeId(Integer eChrgOffTypeId) {
		this.eChrgOffTypeId = eChrgOffTypeId;
	}



	public Integer getOriInvInsCatId() {
		return oriInvInsCatId;
	}



	public void setOriInvInsCatId(Integer oriInvInsCatId) {
		this.oriInvInsCatId = oriInvInsCatId;
	}



	public String getOriInvInsActFlag() {
		return oriInvInsActFlag;
	}



	public void setOriInvInsActFlag(String oriInvInsActFlag) {
		this.oriInvInsActFlag = oriInvInsActFlag;
	}



	public BigDecimal getOriInvInsPer() {
		return oriInvInsPer;
	}



	public void setOriInvInsPer(BigDecimal oriInvInsPer) {
		this.oriInvInsPer = oriInvInsPer;
	}



	public Integer getArrngDayCntConTypId() {
		return arrngDayCntConTypId;
	}



	public void setArrngDayCntConTypId(Integer arrngDayCntConTypId) {
		this.arrngDayCntConTypId = arrngDayCntConTypId;
	}



	public Integer geteIntPayFrePerId() {
		return eIntPayFrePerId;
	}



	public void seteIntPayFrePerId(Integer eIntPayFrePerId) {
		this.eIntPayFrePerId = eIntPayFrePerId;
	}



	public Integer geteRateResetPerIntId() {
		return eRateResetPerIntId;
	}



	public void seteRateResetPerIntId(Integer eRateResetPerIntId) {
		this.eRateResetPerIntId = eRateResetPerIntId;
	}



	public Date getInIntRateResetDate() {
		return inIntRateResetDate;
	}



	public void setInIntRateResetDate(Date inIntRateResetDate) {
		this.inIntRateResetDate = inIntRateResetDate;
	}



	public Date getNxtIntRateResetDate() {
		return nxtIntRateResetDate;
	}



	public void setNxtIntRateResetDate(Date nxtIntRateResetDate) {
		this.nxtIntRateResetDate = nxtIntRateResetDate;
	}



	public Date getPrevLstIntRateResetDate() {
		return prevLstIntRateResetDate;
	}



	public void setPrevLstIntRateResetDate(Date prevLstIntRateResetDate) {
		this.prevLstIntRateResetDate = prevLstIntRateResetDate;
	}



	public String getTaxExemInd() {
		return taxExemInd;
	}



	public void setTaxExemInd(String taxExemInd) {
		this.taxExemInd = taxExemInd;
	}



	public String getOnBnkRelnInd() {
		return onBnkRelnInd;
	}



	public void setOnBnkRelnInd(String onBnkRelnInd) {
		this.onBnkRelnInd = onBnkRelnInd;
	}



	public Integer geteFinServiceTypId() {
		return eFinServiceTypId;
	}



	public void seteFinServiceTypId(Integer eFinServiceTypId) {
		this.eFinServiceTypId = eFinServiceTypId;
	}



	public Integer geteFinServiceLimitTypId() {
		return eFinServiceLimitTypId;
	}



	public void seteFinServiceLimitTypId(Integer eFinServiceLimitTypId) {
		this.eFinServiceLimitTypId = eFinServiceLimitTypId;
	}



	public BigDecimal geteOriginalAmt() {
		return eOriginalAmt;
	}



	public void seteOriginalAmt(BigDecimal eOriginalAmt) {
		this.eOriginalAmt = eOriginalAmt;
	}



	public BigDecimal geteOrgAmount() {
		return eOrgAmount;
	}



	public void seteOrgAmount(BigDecimal eOrgAmount) {
		this.eOrgAmount = eOrgAmount;
	}



	public Integer geteArrngSecTypId() {
		return eArrngSecTypId;
	}



	public void seteArrngSecTypId(Integer eArrngSecTypId) {
		this.eArrngSecTypId = eArrngSecTypId;
	}



	public String getCitiRecInd() {
		return citiRecInd;
	}



	public void setCitiRecInd(String citiRecInd) {
		this.citiRecInd = citiRecInd;
	}



	public Integer getPayFrePerId() {
		return payFrePerId;
	}



	public void setPayFrePerId(Integer payFrePerId) {
		this.payFrePerId = payFrePerId;
	}



	public Integer geteIntrstAccrualStatTypId() {
		return eIntrstAccrualStatTypId;
	}



	public void seteIntrstAccrualStatTypId(Integer eIntrstAccrualStatTypId) {
		this.eIntrstAccrualStatTypId = eIntrstAccrualStatTypId;
	}



	public Date geteIntrstAccrualStatTypDate() {
		return eIntrstAccrualStatTypDate;
	}



	public void seteIntrstAccrualStatTypDate(Date eIntrstAccrualStatTypDate) {
		this.eIntrstAccrualStatTypDate = eIntrstAccrualStatTypDate;
	}



	public Integer getIntOnlyTermPeriod() {
		return intOnlyTermPeriod;
	}



	public void setIntOnlyTermPeriod(Integer intOnlyTermPeriod) {
		this.intOnlyTermPeriod = intOnlyTermPeriod;
	}



	public Integer getFinSerResCurStId() {
		return finSerResCurStId;
	}



	public void setFinSerResCurStId(Integer finSerResCurStId) {
		this.finSerResCurStId = finSerResCurStId;
	}



	public Date getFinSerResCurStDate() {
		return finSerResCurStDate;
	}



	public void setFinSerResCurStDate(Date finSerResCurStDate) {
		this.finSerResCurStDate = finSerResCurStDate;
	}



	public Integer getFinSerPrevResStId() {
		return finSerPrevResStId;
	}



	public void setFinSerPrevResStId(Integer finSerPrevResStId) {
		this.finSerPrevResStId = finSerPrevResStId;
	}



	public Date getFinSerPrevResStDate() {
		return finSerPrevResStDate;
	}



	public void setFinSerPrevResStDate(Date finSerPrevResStDate) {
		this.finSerPrevResStDate = finSerPrevResStDate;
	}



	public String getTrbDebtResFlag() {
		return trbDebtResFlag;
	}



	public void setTrbDebtResFlag(String trbDebtResFlag) {
		this.trbDebtResFlag = trbDebtResFlag;
	}



	public String getMktRateYieldReneFlag() {
		return mktRateYieldReneFlag;
	}



	public void setMktRateYieldReneFlag(String mktRateYieldReneFlag) {
		this.mktRateYieldReneFlag = mktRateYieldReneFlag;
	}



	public String getSkipPayInd() {
		return skipPayInd;
	}



	public void setSkipPayInd(String skipPayInd) {
		this.skipPayInd = skipPayInd;
	}



	public String geteSecInd() {
		return eSecInd;
	}



	public void seteSecInd(String eSecInd) {
		this.eSecInd = eSecInd;
	}



	public Integer getTrppTenor() {
		return trppTenor;
	}



	public void setTrppTenor(Integer trppTenor) {
		this.trppTenor = trppTenor;
	}



	public Double getAcctTrppInsAmt() {
		return acctTrppInsAmt;
	}



	public void setAcctTrppInsAmt(Double acctTrppInsAmt) {
		this.acctTrppInsAmt = acctTrppInsAmt;
	}



	public String getLocAutExtFlag() {
		return locAutExtFlag;
	}



	public void setLocAutExtFlag(String locAutExtFlag) {
		this.locAutExtFlag = locAutExtFlag;
	}



	public String getLocTermLoanCovFlag() {
		return locTermLoanCovFlag;
	}



	public void setLocTermLoanCovFlag(String locTermLoanCovFlag) {
		this.locTermLoanCovFlag = locTermLoanCovFlag;
	}



	public Integer getInDocTypId() {
		return inDocTypId;
	}



	public void setInDocTypId(Integer inDocTypId) {
		this.inDocTypId = inDocTypId;
	}



	public Date getFinserModProgStDate() {
		return finserModProgStDate;
	}



	public void setFinserModProgStDate(Date finserModProgStDate) {
		this.finserModProgStDate = finserModProgStDate;
	}



	public Date getFinserModProgEndDate() {
		return finserModProgEndDate;
	}



	public void setFinserModProgEndDate(Date finserModProgEndDate) {
		this.finserModProgEndDate = finserModProgEndDate;
	}



	public Integer getFinSerResModRsnTypId() {
		return finSerResModRsnTypId;
	}



	public void setFinSerResModRsnTypId(Integer finSerResModRsnTypId) {
		this.finSerResModRsnTypId = finSerResModRsnTypId;
	}



	public Integer getFinSerModProgId() {
		return finSerModProgId;
	}



	public void setFinSerModProgId(Integer finSerModProgId) {
		this.finSerModProgId = finSerModProgId;
	}



	public Integer getFinSerModProgCurrSts() {
		return finSerModProgCurrSts;
	}



	public void setFinSerModProgCurrSts(Integer finSerModProgCurrSts) {
		this.finSerModProgCurrSts = finSerModProgCurrSts;
	}



	public Date getFinSerModProgCurrStsDate() {
		return finSerModProgCurrStsDate;
	}



	public void setFinSerModProgCurrStsDate(Date finSerModProgCurrStsDate) {
		this.finSerModProgCurrStsDate = finSerModProgCurrStsDate;
	}



	public Integer getFinSerModProgPrevStsTypId() {
		return finSerModProgPrevStsTypId;
	}



	public void setFinSerModProgPrevStsTypId(Integer finSerModProgPrevStsTypId) {
		this.finSerModProgPrevStsTypId = finSerModProgPrevStsTypId;
	}



	public Integer getModRetenLossMitTypId() {
		return modRetenLossMitTypId;
	}



	public void setModRetenLossMitTypId(Integer modRetenLossMitTypId) {
		this.modRetenLossMitTypId = modRetenLossMitTypId;
	}



	public Integer getCreFacTypId() {
		return CreFacTypId;
	}



	public void setCreFacTypId(Integer creFacTypId) {
		CreFacTypId = creFacTypId;
	}



	public Integer geteFacilLegalStsTypId() {
		return eFacilLegalStsTypId;
	}



	public void seteFacilLegalStsTypId(Integer eFacilLegalStsTypId) {
		this.eFacilLegalStsTypId = eFacilLegalStsTypId;
	}



	public Integer getFacilLegalStsDate() {
		return FacilLegalStsDate;
	}



	public void setFacilLegalStsDate(Integer facilLegalStsDate) {
		FacilLegalStsDate = facilLegalStsDate;
	}



	public Integer geteCreFacArrngAppTypId() {
		return eCreFacArrngAppTypId;
	}



	public void seteCreFacArrngAppTypId(Integer eCreFacArrngAppTypId) {
		this.eCreFacArrngAppTypId = eCreFacArrngAppTypId;
	}



	public Date getCreFacArrngAppTypDate() {
		return creFacArrngAppTypDate;
	}



	public void setCreFacArrngAppTypDate(Date creFacArrngAppTypDate) {
		this.creFacArrngAppTypDate = creFacArrngAppTypDate;
	}



	public Integer getCreFacRegSegTypId() {
		return creFacRegSegTypId;
	}



	public void setCreFacRegSegTypId(Integer creFacRegSegTypId) {
		this.creFacRegSegTypId = creFacRegSegTypId;
	}



	public Integer getCreFacAvastaTypId() {
		return creFacAvastaTypId;
	}



	public void setCreFacAvastaTypId(Integer creFacAvastaTypId) {
		this.creFacAvastaTypId = creFacAvastaTypId;
	}



	public Date getLstCreLmtChngDate() {
		return lstCreLmtChngDate;
	}



	public void setLstCreLmtChngDate(Date lstCreLmtChngDate) {
		this.lstCreLmtChngDate = lstCreLmtChngDate;
	}



	public Integer getCreLimitChnTypId() {
		return creLimitChnTypId;
	}



	public void setCreLimitChnTypId(Integer creLimitChnTypId) {
		this.creLimitChnTypId = creLimitChnTypId;
	}



	public Double geteArrngNextPymtDueToBankAmt() {
		return eArrngNextPymtDueToBankAmt;
	}



	public void seteArrngNextPymtDueToBankAmt(Double eArrngNextPymtDueToBankAmt) {
		this.eArrngNextPymtDueToBankAmt = eArrngNextPymtDueToBankAmt;
	}



	public Date geteArrngNextPymtDueToBankDate() {
		return eArrngNextPymtDueToBankDate;
	}



	public void seteArrngNextPymtDueToBankDate(Date eArrngNextPymtDueToBankDate) {
		this.eArrngNextPymtDueToBankDate = eArrngNextPymtDueToBankDate;
	}



	public Date geteArrngLastPymtToBankDate() {
		return eArrngLastPymtToBankDate;
	}



	public void seteArrngLastPymtToBankDate(Date eArrngLastPymtToBankDate) {
		this.eArrngLastPymtToBankDate = eArrngLastPymtToBankDate;
	}



	public Integer geteMissedPymtNumb() {
		return eMissedPymtNumb;
	}



	public void seteMissedPymtNumb(Integer eMissedPymtNumb) {
		this.eMissedPymtNumb = eMissedPymtNumb;
	}



	public Date getAcctLstRecDate() {
		return acctLstRecDate;
	}



	public void setAcctLstRecDate(Date acctLstRecDate) {
		this.acctLstRecDate = acctLstRecDate;
	}



	public Date getAcctLstInsDate() {
		return acctLstInsDate;
	}



	public void setAcctLstInsDate(Date acctLstInsDate) {
		this.acctLstInsDate = acctLstInsDate;
	}



	public Integer getTotPay() {
		return totPay;
	}



	public void setTotPay(Integer totPay) {
		this.totPay = totPay;
	}



	public Date getAcctLstIntRevDate() {
		return acctLstIntRevDate;
	}



	public void setAcctLstIntRevDate(Date acctLstIntRevDate) {
		this.acctLstIntRevDate = acctLstIntRevDate;
	}



	public Double getPenRate() {
		return PenRate;
	}



	public void setPenRate(Double penRate) {
		PenRate = penRate;
	}



	public Double getPenAmt() {
		return PenAmt;
	}



	public void setPenAmt(Double penAmt) {
		PenAmt = penAmt;
	}



	public Double getLegNotDays() {
		return legNotDays;
	}



	public void setLegNotDays(Double legNotDays) {
		this.legNotDays = legNotDays;
	}



	public String geteBaselPortfolioId() {
		return eBaselPortfolioId;
	}



	public void seteBaselPortfolioId(String eBaselPortfolioId) {
		this.eBaselPortfolioId = eBaselPortfolioId;
	}



	public String getOthAltIdent() {
		return othAltIdent;
	}



	public void setOthAltIdent(String othAltIdent) {
		this.othAltIdent = othAltIdent;
	}



	public String geteLocalProdCategoryCode() {
		return eLocalProdCategoryCode;
	}



	public void seteLocalProdCategoryCode(String eLocalProdCategoryCode) {
		this.eLocalProdCategoryCode = eLocalProdCategoryCode;
	}



	public String geteDelq30DayPast2YrsFlag() {
		return eDelq30DayPast2YrsFlag;
	}



	public void seteDelq30DayPast2YrsFlag(String eDelq30DayPast2YrsFlag) {
		this.eDelq30DayPast2YrsFlag = eDelq30DayPast2YrsFlag;
	}



	public Integer getLinePosTypId() {
		return linePosTypId;
	}



	public void setLinePosTypId(Integer linePosTypId) {
		this.linePosTypId = linePosTypId;
	}



	public Date geteActualBillingCycleDate() {
		return eActualBillingCycleDate;
	}



	public void seteActualBillingCycleDate(Date eActualBillingCycleDate) {
		this.eActualBillingCycleDate = eActualBillingCycleDate;
	}



	public Integer getFeePayFreqPerId() {
		return feePayFreqPerId;
	}



	public void setFeePayFreqPerId(Integer feePayFreqPerId) {
		this.feePayFreqPerId = feePayFreqPerId;
	}



	public Double getNotPerDays() {
		return notPerDays;
	}



	public void setNotPerDays(Double notPerDays) {
		this.notPerDays = notPerDays;
	}



	public Integer geteCurrAmtType() {
		return eCurrAmtType;
	}



	public void seteCurrAmtType(Integer eCurrAmtType) {
		this.eCurrAmtType = eCurrAmtType;
	}



	public String getFeeWavFlag() {
		return feeWavFlag;
	}



	public void setFeeWavFlag(String feeWavFlag) {
		this.feeWavFlag = feeWavFlag;
	}



	public Date getBorDate() {
		return borDate;
	}



	public void setBorDate(Date borDate) {
		this.borDate = borDate;
	}



	public Integer getSocEcoCatId() {
		return socEcoCatId;
	}



	public void setSocEcoCatId(Integer socEcoCatId) {
		this.socEcoCatId = socEcoCatId;
	}



	public Double getAcctFirstAdvAmt() {
		return acctFirstAdvAmt;
	}



	public void setAcctFirstAdvAmt(Double acctFirstAdvAmt) {
		this.acctFirstAdvAmt = acctFirstAdvAmt;
	}



	public Date getAcctFirstAdvDate() {
		return acctFirstAdvDate;
	}



	public void setAcctFirstAdvDate(Date acctFirstAdvDate) {
		this.acctFirstAdvDate = acctFirstAdvDate;
	}



	public Date getAcctFirstPayDate() {
		return acctFirstPayDate;
	}



	public void setAcctFirstPayDate(Date acctFirstPayDate) {
		this.acctFirstPayDate = acctFirstPayDate;
	}



	public Double getAcctLastAdvAmt() {
		return acctLastAdvAmt;
	}



	public void setAcctLastAdvAmt(Double acctLastAdvAmt) {
		this.acctLastAdvAmt = acctLastAdvAmt;
	}



	public Date getAcctLastAdvDate() {
		return acctLastAdvDate;
	}



	public void setAcctLastAdvDate(Date acctLastAdvDate) {
		this.acctLastAdvDate = acctLastAdvDate;
	}



	public Double getAcqCost() {
		return acqCost;
	}



	public void setAcqCost(Double acqCost) {
		this.acqCost = acqCost;
	}



	public String geteObligorRecourseInd() {
		return eObligorRecourseInd;
	}



	public void seteObligorRecourseInd(String eObligorRecourseInd) {
		this.eObligorRecourseInd = eObligorRecourseInd;
	}



	public Integer getDocTypId() {
		return docTypId;
	}



	public void setDocTypId(Integer docTypId) {
		this.docTypId = docTypId;
	}



	public Date getMtgModSigDate() {
		return mtgModSigDate;
	}



	public void setMtgModSigDate(Date mtgModSigDate) {
		this.mtgModSigDate = mtgModSigDate;
	}



	public Integer getMtgOriProgTypCode() {
		return mtgOriProgTypCode;
	}



	public void setMtgOriProgTypCode(Integer mtgOriProgTypCode) {
		this.mtgOriProgTypCode = mtgOriProgTypCode;
	}



	public Integer getMtgCreRiskCatIntId() {
		return mtgCreRiskCatIntId;
	}



	public void setMtgCreRiskCatIntId(Integer mtgCreRiskCatIntId) {
		this.mtgCreRiskCatIntId = mtgCreRiskCatIntId;
	}



	public String geteBalloonInd() {
		return eBalloonInd;
	}



	public void seteBalloonInd(String eBalloonInd) {
		this.eBalloonInd = eBalloonInd;
	}



	public Integer getHelocTerm() {
		return helocTerm;
	}



	public void setHelocTerm(Integer helocTerm) {
		this.helocTerm = helocTerm;
	}



	public Integer getLmPlanCdId() {
		return lmPlanCdId;
	}



	public void setLmPlanCdId(Integer lmPlanCdId) {
		this.lmPlanCdId = lmPlanCdId;
	}



	public String getEscAcctMaintInd() {
		return escAcctMaintInd;
	}



	public void setEscAcctMaintInd(String escAcctMaintInd) {
		this.escAcctMaintInd = escAcctMaintInd;
	}



	public Integer getMtgOriProgGroupId() {
		return mtgOriProgGroupId;
	}



	public void setMtgOriProgGroupId(Integer mtgOriProgGroupId) {
		this.mtgOriProgGroupId = mtgOriProgGroupId;
	}



	public String getComboLoanInd() {
		return comboLoanInd;
	}



	public void setComboLoanInd(String comboLoanInd) {
		this.comboLoanInd = comboLoanInd;
	}



	public String getSopAcctInd() {
		return sopAcctInd;
	}



	public void setSopAcctInd(String sopAcctInd) {
		this.sopAcctInd = sopAcctInd;
	}



	public String getNegAmortFlag() {
		return negAmortFlag;
	}



	public void setNegAmortFlag(String negAmortFlag) {
		this.negAmortFlag = negAmortFlag;
	}



	public Integer getIntCalPerId() {
		return intCalPerId;
	}



	public void setIntCalPerId(Integer intCalPerId) {
		this.intCalPerId = intCalPerId;
	}



	public String getPreComLoanFlag() {
		return preComLoanFlag;
	}



	public void setPreComLoanFlag(String preComLoanFlag) {
		this.preComLoanFlag = preComLoanFlag;
	}



	public Integer getAmortAccInd() {
		return amortAccInd;
	}



	public void setAmortAccInd(Integer amortAccInd) {
		this.amortAccInd = amortAccInd;
	}



	public Integer geteNumSchePaymt() {
		return eNumSchePaymt;
	}



	public void seteNumSchePaymt(Integer eNumSchePaymt) {
		this.eNumSchePaymt = eNumSchePaymt;
	}



	public Integer geteNumRemPaymt() {
		return eNumRemPaymt;
	}



	public void seteNumRemPaymt(Integer eNumRemPaymt) {
		this.eNumRemPaymt = eNumRemPaymt;
	}



	public Date getLinePosTypEffDate() {
		return linePosTypEffDate;
	}



	public void setLinePosTypEffDate(Date linePosTypEffDate) {
		this.linePosTypEffDate = linePosTypEffDate;
	}



	public String getDelqMethCode() {
		return delqMethCode;
	}



	public void setDelqMethCode(String delqMethCode) {
		this.delqMethCode = delqMethCode;
	}



	public Double getAccFirstPayAmt() {
		return accFirstPayAmt;
	}



	public void setAccFirstPayAmt(Double accFirstPayAmt) {
		this.accFirstPayAmt = accFirstPayAmt;
	}



	public String geteRestructureFlag() {
		return eRestructureFlag;
	}



	public void seteRestructureFlag(String eRestructureFlag) {
		this.eRestructureFlag = eRestructureFlag;
	}



	public String geteRegOEmpFlag() {
		return eRegOEmpFlag;
	}



	public void seteRegOEmpFlag(String eRegOEmpFlag) {
		this.eRegOEmpFlag = eRegOEmpFlag;
	}



	public Double getProbOfDefault() {
		return probOfDefault;
	}



	public void setProbOfDefault(Double probOfDefault) {
		this.probOfDefault = probOfDefault;
	}



	public Date geteCrdtLimitEffctDate() {
		return eCrdtLimitEffctDate;
	}



	public void seteCrdtLimitEffctDate(Date eCrdtLimitEffctDate) {
		this.eCrdtLimitEffctDate = eCrdtLimitEffctDate;
	}



	public Date geteCrdtLimitEndtDate() {
		return eCrdtLimitEndtDate;
	}



	public void seteCrdtLimitEndtDate(Date eCrdtLimitEndtDate) {
		this.eCrdtLimitEndtDate = eCrdtLimitEndtDate;
	}



	public String getCreditLmtEventInvTypId() {
		return creditLmtEventInvTypId;
	}



	public void setCreditLmtEventInvTypId(String creditLmtEventInvTypId) {
		this.creditLmtEventInvTypId = creditLmtEventInvTypId;
	}



	public Double getCreditLmtEventAmt() {
		return creditLmtEventAmt;
	}



	public void setCreditLmtEventAmt(Double creditLmtEventAmt) {
		this.creditLmtEventAmt = creditLmtEventAmt;
	}



	public String geteCcarProdCode() {
		return eCcarProdCode;
	}



	public void seteCcarProdCode(String eCcarProdCode) {
		this.eCcarProdCode = eCcarProdCode;
	}



	public Date getBanktrupcyDate() {
		return banktrupcyDate;
	}



	public void setBanktrupcyDate(Date banktrupcyDate) {
		this.banktrupcyDate = banktrupcyDate;
	}



	public String getPromoIntRtaeEliFlag() {
		return promoIntRtaeEliFlag;
	}



	public void setPromoIntRtaeEliFlag(String promoIntRtaeEliFlag) {
		this.promoIntRtaeEliFlag = promoIntRtaeEliFlag;
	}



	public BigDecimal geteOrgAdvisedCommitedLimit() {
		return eOrgAdvisedCommitedLimit;
	}



	public void seteOrgAdvisedCommitedLimit(BigDecimal eOrgAdvisedCommitedLimit) {
		this.eOrgAdvisedCommitedLimit = eOrgAdvisedCommitedLimit;
	}



	public String getPmacPortId() {
		return pmacPortId;
	}



	public void setPmacPortId(String pmacPortId) {
		this.pmacPortId = pmacPortId;
	}



	public String geteOrgAcctNumbr() {
		return eOrgAcctNumbr;
	}



	public void seteOrgAcctNumbr(String eOrgAcctNumbr) {
		this.eOrgAcctNumbr = eOrgAcctNumbr;
	}



	public Date getLstWriteDwnDate() {
		return lstWriteDwnDate;
	}



	public void setLstWriteDwnDate(Date lstWriteDwnDate) {
		this.lstWriteDwnDate = lstWriteDwnDate;
	}



	public String getCurrNegAmmFlag() {
		return currNegAmmFlag;
	}



	public void setCurrNegAmmFlag(String currNegAmmFlag) {
		this.currNegAmmFlag = currNegAmmFlag;
	}



	public String getPrinDeffOptFlag() {
		return prinDeffOptFlag;
	}



	public void setPrinDeffOptFlag(String prinDeffOptFlag) {
		this.prinDeffOptFlag = prinDeffOptFlag;
	}



	public Date getPrinDeffOptEndDtae() {
		return prinDeffOptEndDtae;
	}



	public void setPrinDeffOptEndDtae(Date prinDeffOptEndDtae) {
		this.prinDeffOptEndDtae = prinDeffOptEndDtae;
	}



	public String getIntDeffOptFlag() {
		return intDeffOptFlag;
	}



	public void setIntDeffOptFlag(String intDeffOptFlag) {
		this.intDeffOptFlag = intDeffOptFlag;
	}



	public Date getIntDeffOptEndDtae() {
		return intDeffOptEndDtae;
	}



	public void setIntDeffOptEndDtae(Date intDeffOptEndDtae) {
		this.intDeffOptEndDtae = intDeffOptEndDtae;
	}



	public Date getIntOnlyOptEndDtae() {
		return intOnlyOptEndDtae;
	}



	public void setIntOnlyOptEndDtae(Date intOnlyOptEndDtae) {
		this.intOnlyOptEndDtae = intOnlyOptEndDtae;
	}



	public BigDecimal geteOrgCombLtvRatio() {
		return eOrgCombLtvRatio;
	}



	public void seteOrgCombLtvRatio(BigDecimal eOrgCombLtvRatio) {
		this.eOrgCombLtvRatio = eOrgCombLtvRatio;
	}



	public String geteOrgLtvRatio() {
		return eOrgLtvRatio;
	}



	public void seteOrgLtvRatio(String eOrgLtvRatio) {
		this.eOrgLtvRatio = eOrgLtvRatio;
	}



	public Double getTotOriJunLienAmt() {
		return totOriJunLienAmt;
	}



	public void setTotOriJunLienAmt(Double totOriJunLienAmt) {
		this.totOriJunLienAmt = totOriJunLienAmt;
	}



	public String geteEverWrittenOffFlag() {
		return eEverWrittenOffFlag;
	}



	public void seteEverWrittenOffFlag(String eEverWrittenOffFlag) {
		this.eEverWrittenOffFlag = eEverWrittenOffFlag;
	}



	public String getReoStsTypId() {
		return reoStsTypId;
	}



	public void setReoStsTypId(String reoStsTypId) {
		this.reoStsTypId = reoStsTypId;
	}



	public String geteNonTradeResidMtgFlag() {
		return eNonTradeResidMtgFlag;
	}



	public void seteNonTradeResidMtgFlag(String eNonTradeResidMtgFlag) {
		this.eNonTradeResidMtgFlag = eNonTradeResidMtgFlag;
	}



	public Integer getMobLocal() {
		return mobLocal;
	}



	public void setMobLocal(Integer mobLocal) {
		this.mobLocal = mobLocal;
	}



	public String getRiskMngInd() {
		return riskMngInd;
	}



	public void setRiskMngInd(String riskMngInd) {
		this.riskMngInd = riskMngInd;
	}



	public String getDaysPastDueCyclEnd() {
		return DaysPastDueCyclEnd;
	}



	public void setDaysPastDueCyclEnd(String daysPastDueCyclEnd) {
		DaysPastDueCyclEnd = daysPastDueCyclEnd;
	}



	public Integer geteDelinquencyBucket() {
		return eDelinquencyBucket;
	}



	public void seteDelinquencyBucket(Integer eDelinquencyBucket) {
		this.eDelinquencyBucket = eDelinquencyBucket;
	}



	public String getCycleEndDelqBucket() {
		return cycleEndDelqBucket;
	}



	public void setCycleEndDelqBucket(String cycleEndDelqBucket) {
		this.cycleEndDelqBucket = cycleEndDelqBucket;
	}



	public String getReservedForFutureGenesisUse1() {
		return reservedForFutureGenesisUse1;
	}



	public void setReservedForFutureGenesisUse1(String reservedForFutureGenesisUse1) {
		this.reservedForFutureGenesisUse1 = reservedForFutureGenesisUse1;
	}



	public String getReservedForFutureGenesisUse2() {
		return reservedForFutureGenesisUse2;
	}



	public void setReservedForFutureGenesisUse2(String reservedForFutureGenesisUse2) {
		this.reservedForFutureGenesisUse2 = reservedForFutureGenesisUse2;
	}



	public String getReservedForFutureGenesisUse3() {
		return reservedForFutureGenesisUse3;
	}



	public void setReservedForFutureGenesisUse3(String reservedForFutureGenesisUse3) {
		this.reservedForFutureGenesisUse3 = reservedForFutureGenesisUse3;
	}



	public String getReservedForFutureGenesisUse4() {
		return reservedForFutureGenesisUse4;
	}



	public void setReservedForFutureGenesisUse4(String reservedForFutureGenesisUse4) {
		this.reservedForFutureGenesisUse4 = reservedForFutureGenesisUse4;
	}



	public String getReservedForFutureGenesisUse5() {
		return reservedForFutureGenesisUse5;
	}



	public void setReservedForFutureGenesisUse5(String reservedForFutureGenesisUse5) {
		this.reservedForFutureGenesisUse5 = reservedForFutureGenesisUse5;
	}



	public String getReservedForFutureGenesisUse6() {
		return reservedForFutureGenesisUse6;
	}



	public void setReservedForFutureGenesisUse6(String reservedForFutureGenesisUse6) {
		this.reservedForFutureGenesisUse6 = reservedForFutureGenesisUse6;
	}



	public String getReservedForFutureGenesisUse7() {
		return reservedForFutureGenesisUse7;
	}



	public void setReservedForFutureGenesisUse7(String reservedForFutureGenesisUse7) {
		this.reservedForFutureGenesisUse7 = reservedForFutureGenesisUse7;
	}



	public String getReservedForFutureGenesisUse8() {
		return reservedForFutureGenesisUse8;
	}



	public void setReservedForFutureGenesisUse8(String reservedForFutureGenesisUse8) {
		this.reservedForFutureGenesisUse8 = reservedForFutureGenesisUse8;
	}



	public String getReservedForFutureGenesisUse9() {
		return reservedForFutureGenesisUse9;
	}



	public void setReservedForFutureGenesisUse9(String reservedForFutureGenesisUse9) {
		this.reservedForFutureGenesisUse9 = reservedForFutureGenesisUse9;
	}



	public String getReservedForFutureGenesisUse10() {
		return reservedForFutureGenesisUse10;
	}



	public void setReservedForFutureGenesisUse10(
			String reservedForFutureGenesisUse10) {
		this.reservedForFutureGenesisUse10 = reservedForFutureGenesisUse10;
	}



	public String getArrngFinStatusRsnTypId() {
		return arrngFinStatusRsnTypId;
	}



	public void setArrngFinStatusRsnTypId(String arrngFinStatusRsnTypId) {
		this.arrngFinStatusRsnTypId = arrngFinStatusRsnTypId;
	}



	public BigDecimal getAcctLastPaymtToBnkAcct() {
		return acctLastPaymtToBnkAcct;
	}



	public void setAcctLastPaymtToBnkAcct(BigDecimal acctLastPaymtToBnkAcct) {
		this.acctLastPaymtToBnkAcct = acctLastPaymtToBnkAcct;
	}



	public Double getOrgAdvisedUnCommitedLimit() {
		return orgAdvisedUnCommitedLimit;
	}



	public void setOrgAdvisedUnCommitedLimit(Double orgAdvisedUnCommitedLimit) {
		this.orgAdvisedUnCommitedLimit = orgAdvisedUnCommitedLimit;
	}



	public Double getOrgUnAdvisedCommitedLimit() {
		return orgUnAdvisedCommitedLimit;
	}



	public void setOrgUnAdvisedCommitedLimit(Double orgUnAdvisedCommitedLimit) {
		this.orgUnAdvisedCommitedLimit = orgUnAdvisedCommitedLimit;
	}



	public Integer geteLegNumber() {
		return eLegNumber;
	}



	public void seteLegNumber(Integer eLegNumber) {
		this.eLegNumber = eLegNumber;
	}



	public String geteGlSysId() {
		return eGlSysId;
	}



	public void seteGlSysId(String eGlSysId) {
		this.eGlSysId = eGlSysId;
	}



	public Integer geteDealId() {
		return eDealId;
	}



	public void seteDealId(Integer eDealId) {
		this.eDealId = eDealId;
	}



	public String geteBookingLedgrCntryCode() {
		return eBookingLedgrCntryCode;
	}



	public void seteBookingLedgrCntryCode(String eBookingLedgrCntryCode) {
		this.eBookingLedgrCntryCode = eBookingLedgrCntryCode;
	}



	public String geteGLAccount1() {
		return eGLAccount1;
	}



	public void seteGLAccount1(String eGLAccount1) {
		this.eGLAccount1 = eGLAccount1;
	}



	public String geteGlAccount2() {
		return eGlAccount2;
	}



	public void seteGlAccount2(String eGlAccount2) {
		this.eGlAccount2 = eGlAccount2;
	}



	public String geteFdlAccount() {
		return eFdlAccount;
	}



	public void seteFdlAccount(String eFdlAccount) {
		this.eFdlAccount = eFdlAccount;
	}



	public BigDecimal geteTxnAmt() {
		return eTxnAmt;
	}



	public void setETxnAmt(BigDecimal eTxnAmt) {
		this.eTxnAmt = eTxnAmt;
	}



	public BigDecimal geteFuncAmt() {
		return eFuncAmt;
	}



	public void seteFuncAmt(Double eFuncAmt) {
		this.eFuncAmt =new BigDecimal(eFuncAmt).setScale(5,BigDecimal.ROUND_HALF_UP);
	}



	public BigDecimal geteBaseAmt() {
		return eBaseAmt;
	}



	public void setEBaseAmt(BigDecimal eBaseAmt) {
		this.eBaseAmt = eBaseAmt;
	}



	public String geteGoc() {
		return eGoc;
	}



	public void seteGoc(String eGoc) {
		this.eGoc = eGoc;
	}



	public String geteBookingLedgrBrCode() {
		return eBookingLedgrBrCode;
	}



	public void seteBookingLedgrBrCode(String eBookingLedgrBrCode) {
		this.eBookingLedgrBrCode = eBookingLedgrBrCode;
	}



	public String geteFrsBuCode() {
		return eFrsBuCode;
	}



	public void seteFrsBuCode(String eFrsBuCode) {
		this.eFrsBuCode = eFrsBuCode;
	}



	public String geteNotForUse() {
		return eNotForUse;
	}



	public void seteNotForUse(String eNotForUse) {
		this.eNotForUse = eNotForUse;
	}



	public String geteLclDeptId() {
		return eLclDeptId;
	}



	public void seteLclDeptId(String eLclDeptId) {
		this.eLclDeptId = eLclDeptId;
	}



	public String geteLclLglVehicleCde() {
		return eLclLglVehicleCde;
	}



	public void seteLclLglVehicleCde(String eLclLglVehicleCde) {
		this.eLclLglVehicleCde = eLclLglVehicleCde;
	}



	public String geteFairValAcctMthFlg() {
		return eFairValAcctMthFlg;
	}



	public void seteFairValAcctMthFlg(String eFairValAcctMthFlg) {
		this.eFairValAcctMthFlg = eFairValAcctMthFlg;
	}



	public String geteFairValLvl() {
		return eFairValLvl;
	}



	public void seteFairValLvl(String eFairValLvl) {
		this.eFairValLvl = eFairValLvl;
	}



	public String geteExpCode() {
		return eExpCode;
	}



	public void seteExpCode(String eExpCode) {
		this.eExpCode = eExpCode;
	}



	public String geteLocalProdCode() {
		return eLocalProdCode;
	}



	public void seteLocalProdCode(String eLocalProdCode) {
		this.eLocalProdCode = eLocalProdCode;
	}



	public String geteFrsAffCode() {
		return eFrsAffCode;
	}



	public void seteFrsAffCode(String eFrsAffCode) {
		this.eFrsAffCode = eFrsAffCode;
	}



	public String geteSubStatCode() {
		return eSubStatCode;
	}



	public void seteSubStatCode(String eSubStatCode) {
		this.eSubStatCode = eSubStatCode;
	}



	public String geteMicroCntrlCode() {
		return eMicroCntrlCode;
	}



	public void seteMicroCntrlCode(String eMicroCntrlCode) {
		this.eMicroCntrlCode = eMicroCntrlCode;
	}



	public String geteFirmAccountImsNmbr() {
		return eFirmAccountImsNmbr;
	}



	public void seteFirmAccountImsNmbr(String eFirmAccountImsNmbr) {
		this.eFirmAccountImsNmbr = eFirmAccountImsNmbr;
	}



	public String geteBaseNmbr() {
		return eBaseNmbr;
	}



	public void seteBaseNmbr(String eBaseNmbr) {
		this.eBaseNmbr = eBaseNmbr;
	}



	public String geteIdProd() {
		return eIdProd;
	}



	public void seteIdProd(String eIdProd) {
		this.eIdProd = eIdProd;
	}



	public String geteKeyCode1() {
		return eKeyCode1;
	}



	public void seteKeyCode1(String eKeyCode1) {
		this.eKeyCode1 = eKeyCode1;
	}



	public String geteKeyCode2() {
		return eKeyCode2;
	}



	public void seteKeyCode2(String eKeyCode2) {
		this.eKeyCode2 = eKeyCode2;
	}



	public String geteLclLdgrAcctNmbr() {
		return eLclLdgrAcctNmbr;
	}



	public void seteLclLdgrAcctNmbr(String eLclLdgrAcctNmbr) {
		this.eLclLdgrAcctNmbr = eLclLdgrAcctNmbr;
	}



	public String geteAdjInd() {
		return eAdjInd;
	}



	public void seteAdjInd(String eAdjInd) {
		this.eAdjInd = eAdjInd;
	}



	public String geteUserId() {
		return eUserId;
	}



	public void seteUserId(String eUserId) {
		this.eUserId = eUserId;
	}



	public String geteAdjResnCode() {
		return eAdjResnCode;
	}



	public void seteAdjResnCode(String eAdjResnCode) {
		this.eAdjResnCode = eAdjResnCode;
	}



	public String geteCmnReasonDesc() {
		return eCmnReasonDesc;
	}



	public void seteCmnReasonDesc(String eCmnReasonDesc) {
		this.eCmnReasonDesc = eCmnReasonDesc;
	}



	public String geteLocalGlKey3() {
		return eLocalGlKey3;
	}



	public void seteLocalGlKey3(String eLocalGlKey3) {
		this.eLocalGlKey3 = eLocalGlKey3;
	}



	public String geteLocalGlKey4() {
		return eLocalGlKey4;
	}



	public void seteLocalGlKey4(String eLocalGlKey4) {
		this.eLocalGlKey4 = eLocalGlKey4;
	}



	public String geteAdjStndardArrngId() {
		return eAdjStndardArrngId;
	}



	public void seteAdjStndardArrngId(String eAdjStndardArrngId) {
		this.eAdjStndardArrngId = eAdjStndardArrngId;
	}



	public String geteAdjFinMarketPositionId() {
		return eAdjFinMarketPositionId;
	}



	public void seteAdjFinMarketPositionId(String eAdjFinMarketPositionId) {
		this.eAdjFinMarketPositionId = eAdjFinMarketPositionId;
	}



	public Integer geteResourceItemTypId() {
		return eResourceItemTypId;
	}



	public void seteResourceItemTypId(Integer eResourceItemTypId) {
		this.eResourceItemTypId = eResourceItemTypId;
	}



	public String getPrimCollInd() {
		return primCollInd;
	}



	public void setPrimCollInd(String primCollInd) {
		this.primCollInd = primCollInd;
	}



	public Integer getRevFreqId() {
		return revFreqId;
	}



	public void setRevFreqId(Integer revFreqId) {
		this.revFreqId = revFreqId;
	}



	public String getResourceItemName() {
		return resourceItemName;
	}



	public void setResourceItemName(String resourceItemName) {
		this.resourceItemName = resourceItemName;
	}



	public String getCollArrngUniqueIdInSrcSys() {
		return collArrngUniqueIdInSrcSys;
	}



	public void setCollArrngUniqueIdInSrcSys(String collArrngUniqueIdInSrcSys) {
		this.collArrngUniqueIdInSrcSys = collArrngUniqueIdInSrcSys;
	}



	public String getCollArrngSrcSysId() {
		return collArrngSrcSysId;
	}



	public void setCollArrngSrcSysId(String collArrngSrcSysId) {
		this.collArrngSrcSysId = collArrngSrcSysId;
	}



	public String getResItemValuAmt() {
		return resItemValuAmt;
	}



	public void setResItemValuAmt(String resItemValuAmt) {
		this.resItemValuAmt = resItemValuAmt;
	}



	public Integer geteResItemValMethodId() {
		return eResItemValMethodId;
	}



	public void seteResItemValMethodId(Integer eResItemValMethodId) {
		this.eResItemValMethodId = eResItemValMethodId;
	}



	public String getLegalEnfFlag() {
		return legalEnfFlag;
	}



	public void setLegalEnfFlag(String legalEnfFlag) {
		this.legalEnfFlag = legalEnfFlag;
	}



	public String getLegalRightToPossFlag() {
		return legalRightToPossFlag;
	}



	public void setLegalRightToPossFlag(String legalRightToPossFlag) {
		this.legalRightToPossFlag = legalRightToPossFlag;
	}



	public String getReHypInd() {
		return reHypInd;
	}



	public void setReHypInd(String reHypInd) {
		this.reHypInd = reHypInd;
	}



	public Integer getCollLocCode() {
		return collLocCode;
	}



	public void setCollLocCode(Integer collLocCode) {
		this.collLocCode = collLocCode;
	}



	public String getInValMarginFlag() {
		return inValMarginFlag;
	}



	public void setInValMarginFlag(String inValMarginFlag) {
		this.inValMarginFlag = inValMarginFlag;
	}



	public Integer getAddTypId() {
		return addTypId;
	}



	public void setAddTypId(Integer addTypId) {
		this.addTypId = addTypId;
	}



	public Integer getLoanToAssRelTyp() {
		return loanToAssRelTyp;
	}



	public void setLoanToAssRelTyp(Integer loanToAssRelTyp) {
		this.loanToAssRelTyp = loanToAssRelTyp;
	}



	public Integer getOccTyp() {
		return occTyp;
	}



	public void setOccTyp(Integer occTyp) {
		this.occTyp = occTyp;
	}



	public Date getPropApprDate() {
		return propApprDate;
	}



	public void setPropApprDate(Date propApprDate) {
		this.propApprDate = propApprDate;
	}



	public Integer getRealPropTotUnit() {
		return realPropTotUnit;
	}



	public void setRealPropTotUnit(Integer realPropTotUnit) {
		this.realPropTotUnit = realPropTotUnit;
	}



	public String getRealPropTypId() {
		return realPropTypId;
	}



	public void setRealPropTypId(String realPropTypId) {
		this.realPropTypId = realPropTypId;
	}



	public String getPropLocName() {
		return propLocName;
	}



	public void setPropLocName(String propLocName) {
		this.propLocName = propLocName;
	}



	public String getePropCity() {
		return ePropCity;
	}



	public void setePropCity(String ePropCity) {
		this.ePropCity = ePropCity;
	}



	public String getePropCountry() {
		return ePropCountry;
	}



	public void setePropCountry(String ePropCountry) {
		this.ePropCountry = ePropCountry;
	}



	public String getePropState() {
		return ePropState;
	}



	public void setePropState(String ePropState) {
		this.ePropState = ePropState;
	}



	public String getePropZipCode() {
		return ePropZipCode;
	}



	public void setePropZipCode(String ePropZipCode) {
		this.ePropZipCode = ePropZipCode;
	}



	public String getePropAddLine1() {
		return ePropAddLine1;
	}



	public void setePropAddLine1(String ePropAddLine1) {
		this.ePropAddLine1 = ePropAddLine1;
	}



	public String getPropAddLine2() {
		return propAddLine2;
	}



	public void setPropAddLine2(String propAddLine2) {
		this.propAddLine2 = propAddLine2;
	}



	public String getPropAddLine3() {
		return propAddLine3;
	}



	public void setPropAddLine3(String propAddLine3) {
		this.propAddLine3 = propAddLine3;
	}



	public String getResItemValueAmt() {
		return resItemValueAmt;
	}



	public void setResItemValueAmt(String resItemValueAmt) {
		this.resItemValueAmt = resItemValueAmt;
	}



	public String getResItemValMethodId() {
		return resItemValMethodId;
	}



	public void setResItemValMethodId(String resItemValMethodId) {
		this.resItemValMethodId = resItemValMethodId;
	}



	public String getResItemValEffDt() {
		return resItemValEffDt;
	}



	public void setResItemValEffDt(String resItemValEffDt) {
		this.resItemValEffDt = resItemValEffDt;
	}



	public String geteResItemBalCurrId() {
		return eResItemBalCurrId;
	}



	public void seteResItemBalCurrId(String eResItemBalCurrId) {
		this.eResItemBalCurrId = eResItemBalCurrId;
	}



	public String geteResItemBalTypId() {
		return eResItemBalTypId;
	}



	public void seteResItemBalTypId(String eResItemBalTypId) {
		this.eResItemBalTypId = eResItemBalTypId;
	}



	public String getResItemValEvtRsnTypId() {
		return resItemValEvtRsnTypId;
	}



	public void setResItemValEvtRsnTypId(String resItemValEvtRsnTypId) {
		this.resItemValEvtRsnTypId = resItemValEvtRsnTypId;
	}



	public String getRelEffDt() {
		return relEffDt;
	}



	public void setRelEffDt(String relEffDt) {
		this.relEffDt = relEffDt;
	}



	public String getColTypId() {
		return colTypId;
	}



	public void setColTypId(String colTypId) {
		this.colTypId = colTypId;
	}



	public String geteGlobProdIdentifier() {
		return eGlobProdIdentifier;
	}



	public void seteGlobProdIdentifier(String eGlobProdIdentifier) {
		this.eGlobProdIdentifier = eGlobProdIdentifier;
	}



	public String geteStdArrgId() {
		return eStdArrgId;
	}



	public void seteStdArrgId(String eStdArrgId) {
		this.eStdArrgId = eStdArrgId;
	}



	public String getArrgName() {
		return arrgName;
	}



	public void setArrgName(String arrgName) {
		this.arrgName = arrgName;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public String getBookingDt() {
		return bookingDt;
	}



	public void setBookingDt(String bookingDt) {
		this.bookingDt = bookingDt;
	}



	public String getOrigEffDt() {
		return origEffDt;
	}



	public void setOrigEffDt(String origEffDt) {
		this.origEffDt = origEffDt;
	}



	public String getEffDt() {
		return effDt;
	}



	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}



	public String getEstEndDt() {
		return estEndDt;
	}



	public void setEstEndDt(String estEndDt) {
		this.estEndDt = estEndDt;
	}



	public String getEndDt() {
		return endDt;
	}



	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}



	public String getArrngTypId() {
		return arrngTypId;
	}



	public void setArrngTypId(String arrngTypId) {
		this.arrngTypId = arrngTypId;
	}



	public Integer geteDenomCurrId() {
		return eDenomCurrId;
	}



	public void seteDenomCurrId(Integer eDenomCurrId) {
		this.eDenomCurrId = eDenomCurrId;
	}



	public String getOrgChannelId() {
		return orgChannelId;
	}



	public void setOrgChannelId(String orgChannelId) {
		this.orgChannelId = orgChannelId;
	}



	public String getArrgPurpTypId() {
		return arrgPurpTypId;
	}



	public void setArrgPurpTypId(String arrgPurpTypId) {
		this.arrgPurpTypId = arrgPurpTypId;
	}



	public String getArrgBusIntentTyp() {
		return arrgBusIntentTyp;
	}



	public void setArrgBusIntentTyp(String arrgBusIntentTyp) {
		this.arrgBusIntentTyp = arrgBusIntentTyp;
	}



	public String getArrgBusIntntDt() {
		return arrgBusIntntDt;
	}



	public void setArrgBusIntntDt(String arrgBusIntntDt) {
		this.arrgBusIntntDt = arrgBusIntntDt;
	}



	public String getPledgedInd() {
		return pledgedInd;
	}



	public void setPledgedInd(String pledgedInd) {
		this.pledgedInd = pledgedInd;
	}



	public String getPledgedEligInd() {
		return pledgedEligInd;
	}



	public void setPledgedEligInd(String pledgedEligInd) {
		this.pledgedEligInd = pledgedEligInd;
	}



	public String getArrgMatTypId() {
		return arrgMatTypId;
	}



	public void setArrgMatTypId(String arrgMatTypId) {
		this.arrgMatTypId = arrgMatTypId;
	}



	public String getArrgFinStsTypId() {
		return arrgFinStsTypId;
	}



	public void setArrgFinStsTypId(String arrgFinStsTypId) {
		this.arrgFinStsTypId = arrgFinStsTypId;
	}



	public String getArrgFinStsDt() {
		return arrgFinStsDt;
	}



	public void setArrgFinStsDt(String arrgFinStsDt) {
		this.arrgFinStsDt = arrgFinStsDt;
	}



	public String getArrgPastDueDayCnt() {
		return arrgPastDueDayCnt;
	}



	public void setArrgPastDueDayCnt(String arrgPastDueDayCnt) {
		this.arrgPastDueDayCnt = arrgPastDueDayCnt;
	}



	public String getGracePrdDayCnt() {
		return gracePrdDayCnt;
	}



	public void setGracePrdDayCnt(String gracePrdDayCnt) {
		this.gracePrdDayCnt = gracePrdDayCnt;
	}



	public String getArrgPastDueAgngClss() {
		return arrgPastDueAgngClss;
	}



	public void setArrgPastDueAgngClss(String arrgPastDueAgngClss) {
		this.arrgPastDueAgngClss = arrgPastDueAgngClss;
	}



	public String getArrgPastDueAgngClssDt() {
		return arrgPastDueAgngClssDt;
	}



	public void setArrgPastDueAgngClssDt(String arrgPastDueAgngClssDt) {
		this.arrgPastDueAgngClssDt = arrgPastDueAgngClssDt;
	}



	public String getArrgFinStsRsnTypId() {
		return arrgFinStsRsnTypId;
	}



	public void setArrgFinStsRsnTypId(String arrgFinStsRsnTypId) {
		this.arrgFinStsRsnTypId = arrgFinStsRsnTypId;
	}



	public String getArrgLifCyclStsTypId() {
		return arrgLifCyclStsTypId;
	}



	public void setArrgLifCyclStsTypId(String arrgLifCyclStsTypId) {
		this.arrgLifCyclStsTypId = arrgLifCyclStsTypId;
	}



	public String getArrgLifCyclStsRsnTypId() {
		return arrgLifCyclStsRsnTypId;
	}



	public void setArrgLifCyclStsRsnTypId(String arrgLifCyclStsRsnTypId) {
		this.arrgLifCyclStsRsnTypId = arrgLifCyclStsRsnTypId;
	}



	public String getArrgLifCycStsDt() {
		return arrgLifCycStsDt;
	}



	public void setArrgLifCycStsDt(String arrgLifCycStsDt) {
		this.arrgLifCycStsDt = arrgLifCycStsDt;
	}



	public String getArrgNxtRnwlDt() {
		return arrgNxtRnwlDt;
	}



	public void setArrgNxtRnwlDt(String arrgNxtRnwlDt) {
		this.arrgNxtRnwlDt = arrgNxtRnwlDt;
	}



	public String geteCreditRiskMtgtTypId() {
		return eCreditRiskMtgtTypId;
	}



	public void seteCreditRiskMtgtTypId(String eCreditRiskMtgtTypId) {
		this.eCreditRiskMtgtTypId = eCreditRiskMtgtTypId;
	}



	public String getCollSrcTypId() {
		return collSrcTypId;
	}



	public void setCollSrcTypId(String collSrcTypId) {
		this.collSrcTypId = collSrcTypId;
	}



	public String getLoanToAssetRelnType() {
		return loanToAssetRelnType;
	}



	public void setLoanToAssetRelnType(String loanToAssetRelnType) {
		this.loanToAssetRelnType = loanToAssetRelnType;
	}



	public String getPropApprTypId() {
		return propApprTypId;
	}



	public void setPropApprTypId(String propApprTypId) {
		this.propApprTypId = propApprTypId;
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



	public String getRateTyp() {
		return rateTyp;
	}



	public void setRateTyp(String rateTyp) {
		this.rateTyp = rateTyp;
	}



	public String getRateId() {
		return rateId;
	}



	public void setRateId(String rateId) {
		this.rateId = rateId;
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



	public void seteRateActiveFlag(String eRateActiveFlag) {
		this.eRateActiveFlag = eRateActiveFlag;
	}



	public String getReservedForFutureGenesisUse11() {
		return reservedForFutureGenesisUse11;
	}



	public void setReservedForFutureGenesisUse11(
			String reservedForFutureGenesisUse11) {
		this.reservedForFutureGenesisUse11 = reservedForFutureGenesisUse11;
	}



	public String getReservedForFutureGenesisUse12() {
		return reservedForFutureGenesisUse12;
	}



	public void setReservedForFutureGenesisUse12(
			String reservedForFutureGenesisUse12) {
		this.reservedForFutureGenesisUse12 = reservedForFutureGenesisUse12;
	}



	public String getReservedForFutureGenesisUse13() {
		return reservedForFutureGenesisUse13;
	}



	public void setReservedForFutureGenesisUse13(
			String reservedForFutureGenesisUse13) {
		this.reservedForFutureGenesisUse13 = reservedForFutureGenesisUse13;
	}



	public String getReservedForFutureGenesisUse14() {
		return reservedForFutureGenesisUse14;
	}



	public void setReservedForFutureGenesisUse14(
			String reservedForFutureGenesisUse14) {
		this.reservedForFutureGenesisUse14 = reservedForFutureGenesisUse14;
	}



	public String getReservedForFutureGenesisUse15() {
		return reservedForFutureGenesisUse15;
	}



	public void setReservedForFutureGenesisUse15(
			String reservedForFutureGenesisUse15) {
		this.reservedForFutureGenesisUse15 = reservedForFutureGenesisUse15;
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



	public void seteRateVarTypeId(Integer eRateVarTypeId) {
		this.eRateVarTypeId = eRateVarTypeId;
	}



	public String geteRatingIssId() {
		return eRatingIssId;
	}



	public void seteRatingIssId(String eRatingIssId) {
		this.eRatingIssId = eRatingIssId;
	}



	public String geteModelCd() {
		return eModelCd;
	}



	public void seteModelCd(String eModelCd) {
		this.eModelCd = eModelCd;
	}



	public Integer geteRatingEvnRsnTypId() {
		return eRatingEvnRsnTypId;
	}



	public void seteRatingEvnRsnTypId(Integer eRatingEvnRsnTypId) {
		this.eRatingEvnRsnTypId = eRatingEvnRsnTypId;
	}



	public Integer geteRank() {
		return eRank;
	}



	public void seteRank(Integer eRank) {
		this.eRank = eRank;
	}



	public String geteRatingTypCd() {
		return eRatingTypCd;
	}



	public void seteRatingTypCd(String eRatingTypCd) {
		this.eRatingTypCd = eRatingTypCd;
	}



	public String geteRatingCd() {
		return eRatingCd;
	}



	public void seteRatingCd(String eRatingCd) {
		this.eRatingCd = eRatingCd;
	}



	public String geteFicoEquvRatingCode() {
		return eFicoEquvRatingCode;
	}



	public void seteFicoEquvRatingCode(String eFicoEquvRatingCode) {
		this.eFicoEquvRatingCode = eFicoEquvRatingCode;
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



	public void seteScoreReqReturnFlag(String eScoreReqReturnFlag) {
		this.eScoreReqReturnFlag = eScoreReqReturnFlag;
	}



	public String geteInvPtyUniqueId() {
		return eInvPtyUniqueId;
	}



	public void seteInvPtyUniqueId(String eInvPtyUniqueId) {
		this.eInvPtyUniqueId = eInvPtyUniqueId;
	}



	public Integer geteOrigChnlId() {
		return eOrigChnlId;
	}



	public void seteOrigChnlId(Integer eOrigChnlId) {
		this.eOrigChnlId = eOrigChnlId;
	}



	public Integer geteArrngDayCntConvTypId() {
		return eArrngDayCntConvTypId;
	}



	public void seteArrngDayCntConvTypId(Integer eArrngDayCntConvTypId) {
		this.eArrngDayCntConvTypId = eArrngDayCntConvTypId;
	}



	public Integer geteIntrPayFreqPeriodId() {
		return eIntrPayFreqPeriodId;
	}



	public void seteIntrPayFreqPeriodId(Integer eIntrPayFreqPeriodId) {
		this.eIntrPayFreqPeriodId = eIntrPayFreqPeriodId;
	}



	public Integer geteRateResetPerodInterId() {
		return eRateResetPerodInterId;
	}



	public void seteRateResetPerodInterId(Integer eRateResetPerodInterId) {
		this.eRateResetPerodInterId = eRateResetPerodInterId;
	}



	public Date geteNxtIntrRateResetDate() {
		return eNxtIntrRateResetDate;
	}



	public void seteNxtIntrRateResetDate(Date eNxtIntrRateResetDate) {
		this.eNxtIntrRateResetDate = eNxtIntrRateResetDate;
	}



	public Integer geteArrngSecurTypeId() {
		return eArrngSecurTypeId;
	}



	public void seteArrngSecurTypeId(Integer eArrngSecurTypeId) {
		this.eArrngSecurTypeId = eArrngSecurTypeId;
	}



	public String geteSecurizedInd() {
		return eSecurizedInd;
	}



	public void seteSecurizedInd(String eSecurizedInd) {
		this.eSecurizedInd = eSecurizedInd;
	}



	public String geteCreditFacTypId() {
		return eCreditFacTypId;
	}



	public void seteCreditFacTypId(String eCreditFacTypId) {
		this.eCreditFacTypId = eCreditFacTypId;
	}



	public Integer geteCreditFacArrngAppTypId() {
		return eCreditFacArrngAppTypId;
	}



	public void seteCreditFacArrngAppTypId(Integer eCreditFacArrngAppTypId) {
		this.eCreditFacArrngAppTypId = eCreditFacArrngAppTypId;
	}



	public Double geteOriAmt() {
		return eOriAmt;
	}



	public void seteOriAmt(Double eOriAmt) {
		this.eOriAmt = eOriAmt;
	}



	public Integer geteCrdtLimitChangeTypeId() {
		return eCrdtLimitChangeTypeId;
	}



	public void seteCrdtLimitChangeTypeId(Integer eCrdtLimitChangeTypeId) {
		this.eCrdtLimitChangeTypeId = eCrdtLimitChangeTypeId;
	}



	public Integer geteAcLastPymtToBankAmount() {
		return eAcLastPymtToBankAmount;
	}



	public void seteAcLastPymtToBankAmount(Integer eAcLastPymtToBankAmount) {
		this.eAcLastPymtToBankAmount = eAcLastPymtToBankAmount;
	}



	public Double geteOriLtvRatio() {
		return eOriLtvRatio;
	}



	public void seteOriLtvRatio(Double eOriLtvRatio) {
		this.eOriLtvRatio = eOriLtvRatio;
	}



	public String geteArrngPtyRolType() {
		return eArrngPtyRolType;
	}



	public void seteArrngPtyRolType(String eArrngPtyRolType) {
		this.eArrngPtyRolType = eArrngPtyRolType;
	}



	public BigDecimal getePctAmt() {
		return ePctAmt;
	}



	public void setePctAmt(BigDecimal ePctAmt) {
		this.ePctAmt = ePctAmt;
	}



	public String geteInvPtySubtypeId() {
		return eInvPtySubtypeId;
	}



	public void seteInvPtySubtypeId(String eInvPtySubtypeId) {
		this.eInvPtySubtypeId = eInvPtySubtypeId;
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



	public void setUniqueIdCardArng(String uniqueIdCardArng) {
		this.uniqueIdCardArng = uniqueIdCardArng;
	}



	public Integer getSupportSeqNumber() {
		return supportSeqNumber;
	}



	public void setSupportSeqNumber(Integer supportSeqNumber) {
		this.supportSeqNumber = supportSeqNumber;
	}



	public Integer getGuranteeSupportTypeId() {
		return guranteeSupportTypeId;
	}



	public void setGuranteeSupportTypeId(Integer guranteeSupportTypeId) {
		this.guranteeSupportTypeId = guranteeSupportTypeId;
	}



	public String getGuranteeSupportCovBasicTypeId() {
		return guranteeSupportCovBasicTypeId;
	}



	public void setGuranteeSupportCovBasicTypeId(
			String guranteeSupportCovBasicTypeId) {
		this.guranteeSupportCovBasicTypeId = guranteeSupportCovBasicTypeId;
	}



	public String getGuranteeSupportCovTypeId() {
		return guranteeSupportCovTypeId;
	}



	public void setGuranteeSupportCovTypeId(String guranteeSupportCovTypeId) {
		this.guranteeSupportCovTypeId = guranteeSupportCovTypeId;
	}



	public Date getGuranteeEffDate() {
		return guranteeEffDate;
	}



	public void setGuranteeEffDate(Date guranteeEffDate) {
		this.guranteeEffDate = guranteeEffDate;
	}



	public Date getGuranteeEndDate() {
		return guranteeEndDate;
	}



	public void setGuranteeEndDate(Date guranteeEndDate) {
		this.guranteeEndDate = guranteeEndDate;
	}



	public Integer getInsurenceTypeId() {
		return insurenceTypeId;
	}



	public void setInsurenceTypeId(Integer insurenceTypeId) {
		this.insurenceTypeId = insurenceTypeId;
	}



	public String getInsurenceSupportCovBasicTypeId() {
		return insurenceSupportCovBasicTypeId;
	}



	public void setInsurenceSupportCovBasicTypeId(
			String insurenceSupportCovBasicTypeId) {
		this.insurenceSupportCovBasicTypeId = insurenceSupportCovBasicTypeId;
	}



	public String getInsurenceSupportCovTypeId() {
		return insurenceSupportCovTypeId;
	}



	public void setInsurenceSupportCovTypeId(String insurenceSupportCovTypeId) {
		this.insurenceSupportCovTypeId = insurenceSupportCovTypeId;
	}



	public Date getInsurenceEffDate() {
		return insurenceEffDate;
	}



	public void setInsurenceEffDate(Date insurenceEffDate) {
		this.insurenceEffDate = insurenceEffDate;
	}



	public Date getInsurenceEndDate() {
		return insurenceEndDate;
	}



	public void setInsurenceEndDate(Date insurenceEndDate) {
		this.insurenceEndDate = insurenceEndDate;
	}



	public Date getePropApprDate() {
		return ePropApprDate;
	}



	public void setePropApprDate(Date ePropApprDate) {
		this.ePropApprDate = ePropApprDate;
	}



	public BigDecimal geteEffectiveRatePercentage() {
		return eEffectiveRatePercentage;
	}



	public void seteEffectiveRatePercentage(BigDecimal eEffectiveRatePercentage) {
		this.eEffectiveRatePercentage = eEffectiveRatePercentage;
	}



	public Integer geteRateVarTypId() {
		return eRateVarTypId;
	}



	public void seteRateVarTypId(Integer eRateVarTypId) {
		this.eRateVarTypId = eRateVarTypId;
	}



	public String geteRateTypeId() {
		return eRateTypeId;
	}



	public void seteRateTypeId(String eRateTypeId) {
		this.eRateTypeId = eRateTypeId;
	}



	public Integer geteBalType() {
		return eBalType;
	}



	public void seteBalTyp(Integer eBalType) {
		this.eBalType = eBalType;
	}



	public String geteFuncCurr() {
		return eFuncCurr;
	}



	public void seteFuncCurr(String eFuncCurr) {
		this.eFuncCurr = eFuncCurr;
	}



	public Date geteRepPeriodMonth() {
		return eRepPeriodMonth;
	}



	public void seteRepPeriodMonth(Date eRepPeriodMonth) {
		this.eRepPeriodMonth = eRepPeriodMonth;
	}



	public String geteLoanAssestRelnType() {
		return eLoanAssestRelnType;
	}



	public void seteLoanAssestRelnType(String eLoanAssestRelnType) {
		this.eLoanAssestRelnType = eLoanAssestRelnType;
	}



	public String geteRealPropType() {
		return eRealPropType;
	}



	public void seteRealPropType(String eRealPropType) {
		this.eRealPropType = eRealPropType;
	}



	public Date geteArrngFinClassDate() {
		return eArrngFinClassDate;
	}



	public void seteArrngFinClassDate(Date eArrngFinClassDate) {
		this.eArrngFinClassDate = eArrngFinClassDate;
	}



	public Date geteIntrstAccrualStatTypDt() {
		return eIntrstAccrualStatTypDt;
	}



	public void seteIntrstAccrualStatTypDt(Date eIntrstAccrualStatTypDt) {
		this.eIntrstAccrualStatTypDt = eIntrstAccrualStatTypDt;
	}



	public Date geteRelationEffDate() {
		return eRelationEffDate;
	}



	public void seteRelationEffDate(Date eRelationEffDate) {
		this.eRelationEffDate = eRelationEffDate;
	}



	public Integer geteFacLegStatTypId() {
		return eFacLegStatTypId;
	}



	public void seteFacLegStatTypId(Integer eFacLegStatTypId) {
		this.eFacLegStatTypId = eFacLegStatTypId;
	}



	public Integer geteAssestRelationType() {
		return eAssestRelationType;
	}



	public void seteAssestRelationType(Integer eAssestRelationType) {
		this.eAssestRelationType = eAssestRelationType;
	}



	public String geteRecTypeColl() {
		return eRecTypeColl;
	}



	public void seteRecTypeColl(String eRecTypeColl) {
		this.eRecTypeColl = eRecTypeColl;
	}



	

	public String geteTranCurr() {
		return eTranCurr;
	}



	public void seteTranCurr(String eTranCurr) {
		this.eTranCurr = eTranCurr;
	}



	public String geteBaseCurrCode() {
		return eBaseCurrCode;
	}



	public void seteBaseCurrCode(String eBaseCurrCode) {
		this.eBaseCurrCode = eBaseCurrCode;
	}



	public Integer geteEntProdId() {
		return eEntProdId;
	}



	public void seteEntProdId(Integer eEntProdId) {
		this.eEntProdId = eEntProdId;
	}



	public String geteIntrBAsicCalcPeriodId() {
		return eIntrBAsicCalcPeriodId;
	}



	public void seteIntrBAsicCalcPeriodId(String eIntrBAsicCalcPeriodId) {
		this.eIntrBAsicCalcPeriodId = eIntrBAsicCalcPeriodId;
	}



	public String getInvPtyLocRltnpTypId() {
		return invPtyLocRltnpTypId;
	}



	public void setInvPtyLocRltnpTypId(String invPtyLocRltnpTypId) {
		this.invPtyLocRltnpTypId = invPtyLocRltnpTypId;
	}



	public String geteUniqueIdSrcSysInvlParty() {
		return eUniqueIdSrcSysInvlParty;
	}



	public void seteUniqueIdSrcSysInvlParty(String eUniqueIdSrcSysInvlParty) {
		this.eUniqueIdSrcSysInvlParty = eUniqueIdSrcSysInvlParty;
	}









	public String geteInvlvPartySubTypeId() {
		return eInvlvPartySubTypeId;
	}



	public void seteInvlvPartySubTypeId(String eInvlvPartySubTypeId) {
		this.eInvlvPartySubTypeId = eInvlvPartySubTypeId;
	}



	public CommonBalanceMtgTRLRecord(MortgageTRLRecord alsRecord){
		
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
//		this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
//		this.eBaseAmt = new BigDecimal(alsRecord.geteBaseAmt());
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommonBalanceMtgTRLRecord [eUniqueId=" + eUniqueId
				+ ", eSrcSysId=" + eSrcSysId + ", eProdSysId=" + eProdSysId
				+ ", eRecType=" + eRecType + ", eAsOfDt=" + eAsOfDt
				+ ", eGlbProdId=" + eGlbProdId + ", eLocalProductId="
				+ eLocalProductId + ", localSubProductId=" + localSubProductId
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
				+ ", eInvlvPartySubTypeId="
				+ eInvlvPartySubTypeId + "]";
	}



	/*public CommonBalanceMtgTRLRecord(InMtgOreoRecord alsRecord) {
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
		//this.eBaseAmt = new BigDecimal(alsRecord.geteBaseAmt());
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eMtgTdrRecord = alsRecord.geteMtgTdrRecord();
		this.eMemoRecord = alsRecord.geteMemoRecord();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
	}



	public CommonBalanceMtgTRLRecord(GcbcMtgRecord alsRecord) {
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
//		this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
//		this.eBaseAmt = new BigDecimal(alsRecord.geteBaseAmt());
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eMtgTdrRecord = alsRecord.geteMtgTdrRecord();
		this.eMemoRecord = alsRecord.geteMemoRecord();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
	}



	public CommonBalanceMtgTRLRecord(GclMtgRecord alsRecord) {
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
		//this.eBaseAmt = new BigDecimal(alsRecord.geteBaseAmt());
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eMtgTdrRecord = alsRecord.geteMtgTdrRecord();
		this.eMemoRecord = alsRecord.geteMemoRecord();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
	}



	public CommonBalanceMtgTRLRecord(HkMtgSasRecord alsRecord) {
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
	//	this.eTxnAmt = alsRecord.geteTxnAmt();
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eMtgTdrRecord = alsRecord.geteMtgTdrRecord();
		this.eMemoRecord = alsRecord.geteMemoRecord();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
	}	*/
	
	
	public CommonBalanceMtgTRLRecord(HkMtgWriteOffTRLRecord alsRecord){
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
//		this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
//		this.eBaseAmt = new BigDecimal(alsRecord.geteBaseAmt());
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		
	
	}
	
	public CommonBalanceMtgTRLRecord(HkMtgWoRecvTRLRecord alsRecord){
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
//		this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
//		this.eBaseAmt = new BigDecimal(alsRecord.geteBaseAmt());
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		
	
	}
	
	public CommonBalanceMtgTRLRecord(GclTRLRecord alsRecord){

		
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
//		this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
//		this.eBaseAmt = new BigDecimal(alsRecord.geteBaseAmt());
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		
	
	}
	
	public CommonBalanceMtgTRLRecord(OreoTRLRecord alsRecord){


		
		this.eUniqueId = alsRecord.geteUniqueId();
		this.eSrcSysId = alsRecord.geteSrcSysId();
		this.eProdSysId = alsRecord.geteProdSysId();
		this.eRecType = alsRecord.geteRecType();
		this.eAsOfDt = alsRecord.geteAsOfDt();
		this.eGlbProdId = alsRecord.geteGlbProdId();
		this.eLocalProductId = alsRecord.geteLocalProductId();
		this.localSubProductId = alsRecord.getLocalSubProductId();
		this.entStandProductId = alsRecord.getEntStandProductId();
		this.arrngName = alsRecord.getArrngName();
		this.eDescription = alsRecord.geteDescription();
		this.eDenoCurrId = alsRecord.geteDenoCurrId();
		this.eOrigChannelId = alsRecord.geteOrigChannelId();
		this.eArrngPurpTypeId = alsRecord.geteArrngPurpTypeId();
		this.eArrngBusIntType = alsRecord.geteArrngBusIntType();
		this.ePledgInd = alsRecord.getePledgInd();
		this.ePledgEligInd = alsRecord.getePledgEligInd();
		this.eArrngMatuTypeId = alsRecord.geteArrngMatuTypeId();
		this.eArrngFinStatTypId = alsRecord.geteArrngFinStatTypId();
		this.eArrngPastDueDayCount = alsRecord.geteArrngPastDueDayCount();
		this.eGracePerDayCnt = alsRecord.geteGracePerDayCnt();
		this.eArrngPastDueAgeClass = alsRecord.geteArrngPastDueAgeClass();
		this.eArrngLifeCycleStatusReasonTypeId = alsRecord.geteArrngLifeCycleStatusReasonTypeId();
		this.eArrngLifeCycleStatusId = alsRecord.geteArrngLifeCycleStatusId();
		this.arrngPriPayTypId = alsRecord.getArrngPriPayTypId();
		this.eArrngAcqTypId = alsRecord.geteArrngAcqTypId();
		this.eArrngAcqDt = alsRecord.geteArrngAcqDt();
		this.arrngDisTypId = alsRecord.getArrngDisTypId();
		this.eChrgOffTypeId = alsRecord.geteChrgOffTypeId();
		this.oriInvInsCatId = alsRecord.getOriInvInsCatId();
		this.oriInvInsActFlag = alsRecord.getOriInvInsActFlag();
		this.oriInvInsPer = alsRecord.getOriInvInsPer();
		this.arrngDayCntConTypId = alsRecord.getArrngDayCntConTypId();
		this.eIntPayFrePerId = alsRecord.geteIntPayFrePerId();
		this.eRateResetPerIntId = alsRecord.geteRateResetPerIntId();
		this.taxExemInd = alsRecord.getTaxExemInd();
		this.onBnkRelnInd = alsRecord.getOnBnkRelnInd();
		this.eFinServiceTypId = alsRecord.geteFinServiceTypId();
		this.eFinServiceLimitTypId = alsRecord.geteFinServiceLimitTypId();
		this.eOriginalAmt = alsRecord.geteOriginalAmt();
		this.eOrgAmount = alsRecord.geteOrgAmount();
		this.eArrngSecTypId = alsRecord.geteArrngSecTypId();
		this.citiRecInd = alsRecord.getCitiRecInd();
		this.payFrePerId = alsRecord.getPayFrePerId();
		this.eIntrstAccrualStatTypId = alsRecord.geteIntrstAccrualStatTypId();
		this.intOnlyTermPeriod = alsRecord.getIntOnlyTermPeriod();
		this.finSerResCurStId = alsRecord.getFinSerResCurStId();
		this.finSerPrevResStId = alsRecord.getFinSerPrevResStId();
		this.trbDebtResFlag = alsRecord.getTrbDebtResFlag();
		this.mktRateYieldReneFlag = alsRecord.getMktRateYieldReneFlag();
		this.skipPayInd = alsRecord.getSkipPayInd();
		this.eSecInd = alsRecord.geteSecInd();
		this.trppTenor = alsRecord.getTrppTenor();
		this.acctTrppInsAmt = alsRecord.getAcctTrppInsAmt();
		this.locAutExtFlag = alsRecord.getLocAutExtFlag();
		this.locTermLoanCovFlag = alsRecord.getLocTermLoanCovFlag();
		this.inDocTypId = alsRecord.getInDocTypId();
		this.finSerResModRsnTypId = alsRecord.getFinSerResModRsnTypId();
		this.finSerModProgId = alsRecord.getFinSerModProgId();
		this.finSerModProgCurrSts = alsRecord.getFinSerModProgCurrSts();
		this.finSerModProgPrevStsTypId = alsRecord.getFinSerModProgPrevStsTypId();
		this.modRetenLossMitTypId = alsRecord.getModRetenLossMitTypId();
		this.CreFacTypId = alsRecord.getCreFacTypId();
		this.eFacilLegalStsTypId = alsRecord.geteFacilLegalStsTypId();
		this.eCreFacArrngAppTypId = alsRecord.geteCreFacArrngAppTypId();
		this.creFacRegSegTypId = alsRecord.getCreFacRegSegTypId();
		this.creFacAvastaTypId = alsRecord.getCreFacAvastaTypId();
		this.creLimitChnTypId = alsRecord.getCreLimitChnTypId();
		this.eArrngNextPymtDueToBankAmt = alsRecord.geteArrngNextPymtDueToBankAmt();
		this.eMissedPymtNumb = alsRecord.geteMissedPymtNumb();
		this.totPay = alsRecord.getTotPay();
		this.PenRate = alsRecord.getPenRate();
		this.PenAmt = alsRecord.getPenAmt();
		this.legNotDays = alsRecord.getLegNotDays();
		this.eBaselPortfolioId = alsRecord.geteBaselPortfolioId();
		this.othAltIdent = alsRecord.getOthAltIdent();
		this.eLocalProdCategoryCode = alsRecord.geteLocalProdCategoryCode();
		this.eDelq30DayPast2YrsFlag = alsRecord.geteDelq30DayPast2YrsFlag();
		this.linePosTypId = alsRecord.getLinePosTypId();
		this.feePayFreqPerId = alsRecord.getFeePayFreqPerId();
		this.notPerDays = alsRecord.getNotPerDays();
		this.eCurrAmtType = alsRecord.geteCurrAmtType();
		this.feeWavFlag = alsRecord.getFeeWavFlag();
		this.socEcoCatId = alsRecord.getSocEcoCatId();
		this.acctFirstAdvAmt = alsRecord.getAcctFirstAdvAmt();
		this.acctLastAdvAmt = alsRecord.getAcctLastAdvAmt();
		this.acqCost = alsRecord.getAcqCost();
		this.eObligorRecourseInd = alsRecord.geteObligorRecourseInd();
		this.docTypId = alsRecord.getDocTypId();
		this.mtgOriProgTypCode = alsRecord.getMtgOriProgTypCode();
		this.mtgCreRiskCatIntId = alsRecord.getMtgCreRiskCatIntId();
		this.eBalloonInd = alsRecord.geteBalloonInd();
		this.helocTerm = alsRecord.getHelocTerm();
		this.lmPlanCdId = alsRecord.getLmPlanCdId();
		this.escAcctMaintInd = alsRecord.getEscAcctMaintInd();
		this.mtgOriProgGroupId = alsRecord.getMtgOriProgGroupId();
		this.comboLoanInd = alsRecord.getComboLoanInd();
		this.sopAcctInd = alsRecord.getSopAcctInd();
		this.negAmortFlag = alsRecord.getNegAmortFlag();
		this.intCalPerId = alsRecord.getIntCalPerId();
		this.preComLoanFlag = alsRecord.getPreComLoanFlag();
		this.amortAccInd = alsRecord.getAmortAccInd();
		this.eNumSchePaymt = alsRecord.geteNumSchePaymt();
		this.eNumRemPaymt = alsRecord.geteNumRemPaymt();
		this.delqMethCode = alsRecord.getDelqMethCode();
		this.accFirstPayAmt = alsRecord.getAccFirstPayAmt();
		this.eRestructureFlag = alsRecord.geteRestructureFlag();
		this.eRegOEmpFlag = alsRecord.geteRegOEmpFlag();
		this.probOfDefault = alsRecord.getProbOfDefault();
		this.creditLmtEventInvTypId = alsRecord.getCreditLmtEventInvTypId();
		this.creditLmtEventAmt = alsRecord.getCreditLmtEventAmt();
		this.eCcarProdCode = alsRecord.geteCcarProdCode();
		this.promoIntRtaeEliFlag = alsRecord.getPromoIntRtaeEliFlag();
		this.eOrgAdvisedCommitedLimit = alsRecord.geteOrgAdvisedCommitedLimit();
		this.pmacPortId = alsRecord.getPmacPortId();
		this.eOrgAcctNumbr = alsRecord.geteOrgAcctNumbr();
		this.currNegAmmFlag = alsRecord.getCurrNegAmmFlag();
		this.prinDeffOptFlag = alsRecord.getPrinDeffOptFlag();
		this.prinDeffOptEndDtae = alsRecord.getPrinDeffOptEndDtae();
		this.intDeffOptFlag = alsRecord.getIntDeffOptFlag();
		this.intDeffOptEndDtae = alsRecord.getIntDeffOptEndDtae();
		this.intOnlyOptEndDtae = alsRecord.getIntOnlyOptEndDtae();
		this.eOrgCombLtvRatio = alsRecord.geteOrgCombLtvRatio();
		this.totOriJunLienAmt = alsRecord.getTotOriJunLienAmt();
		this.eEverWrittenOffFlag = alsRecord.geteEverWrittenOffFlag();
		this.reoStsTypId = alsRecord.getReoStsTypId();
		this.eNonTradeResidMtgFlag = alsRecord.geteNonTradeResidMtgFlag();
		this.mobLocal = alsRecord.getMobLocal();
		this.riskMngInd = alsRecord.getRiskMngInd();
		this.DaysPastDueCyclEnd = alsRecord.getDaysPastDueCyclEnd();
		this.eDelinquencyBucket = alsRecord.geteDelinquencyBucket();
		this.cycleEndDelqBucket = alsRecord.getCycleEndDelqBucket();
		this.reservedForFutureGenesisUse1 = alsRecord.getReservedForFutureGenesisUse1();
		this.reservedForFutureGenesisUse2 = alsRecord.getReservedForFutureGenesisUse2();
		this.reservedForFutureGenesisUse3 = alsRecord.getReservedForFutureGenesisUse3();
		this.reservedForFutureGenesisUse4 = alsRecord.getReservedForFutureGenesisUse4();
		this.reservedForFutureGenesisUse5 = alsRecord.getReservedForFutureGenesisUse5();
		this.reservedForFutureGenesisUse6 = alsRecord.getReservedForFutureGenesisUse6();
		this.reservedForFutureGenesisUse7 = alsRecord.getReservedForFutureGenesisUse7();
		this.reservedForFutureGenesisUse8 = alsRecord.getReservedForFutureGenesisUse8();
		this.reservedForFutureGenesisUse9 = alsRecord.getReservedForFutureGenesisUse9();
		this.reservedForFutureGenesisUse10 = alsRecord.getReservedForFutureGenesisUse10();
		this.arrngFinStatusRsnTypId = alsRecord.getArrngFinStatusRsnTypId();
		this.acctLastPaymtToBnkAcct = alsRecord.getAcctLastPaymtToBnkAcct();
		this.orgAdvisedUnCommitedLimit = alsRecord.getOrgAdvisedUnCommitedLimit();
		this.orgUnAdvisedCommitedLimit = alsRecord.getOrgUnAdvisedCommitedLimit();
		this.eLegNumber = alsRecord.geteLegNumber();
		this.eGlSysId = alsRecord.geteGlSysId();
		this.eDealId = alsRecord.geteDealId();
		this.eBookingLedgrCntryCode = alsRecord.geteBookingLedgrCntryCode();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		this.eGlAccount2 = alsRecord.geteGlAccount2();
		this.eFdlAccount = alsRecord.geteFdlAccount();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
//		this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eFuncAmt = alsRecord.geteFuncAmt();
		//this.eBaseAmt = alsRecord.geteBaseAmt();
//		this.eBaseAmt = new BigDecimal(alsRecord.geteBaseAmt());
		this.eGoc = alsRecord.geteGoc();
		this.eBookingLedgrBrCode = alsRecord.geteBookingLedgrBrCode();
		this.eFrsBuCode = alsRecord.geteFrsBuCode();
		this.eNotForUse = alsRecord.geteNotForUse();
		this.eLclDeptId = alsRecord.geteLclDeptId();
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eFairValAcctMthFlg = alsRecord.geteFairValAcctMthFlg();
		this.eFairValLvl = alsRecord.geteFairValLvl();
		this.eExpCode = alsRecord.geteExpCode();
		this.eLocalProdCode = alsRecord.geteLocalProdCode();
		this.eFrsAffCode = alsRecord.geteFrsAffCode();
		this.eSubStatCode = alsRecord.geteSubStatCode();
		this.eMicroCntrlCode = alsRecord.geteMicroCntrlCode();
		this.eFirmAccountImsNmbr = alsRecord.geteFirmAccountImsNmbr();
		this.eBaseNmbr = alsRecord.geteBaseNmbr();
		this.eIdProd = alsRecord.geteIdProd();
		this.eKeyCode1 = alsRecord.geteKeyCode1();
		this.eKeyCode2 = alsRecord.geteKeyCode2();
		this.eLclLdgrAcctNmbr = alsRecord.geteLclLdgrAcctNmbr();
		this.eAdjInd = alsRecord.geteAdjInd();
		this.eUserId = alsRecord.geteUserId();
		this.eAdjResnCode = alsRecord.geteAdjResnCode();
		this.eCmnReasonDesc = alsRecord.geteCmnReasonDesc();
		this.eLocalGlKey3 = alsRecord.geteLocalGlKey3();
		this.eLocalGlKey4 = alsRecord.geteLocalGlKey4();
		this.eAdjStndardArrngId = alsRecord.geteAdjStndardArrngId();
		this.eAdjFinMarketPositionId = alsRecord.geteAdjFinMarketPositionId();
		this.eResourceItemTypId = alsRecord.geteResourceItemTypId();
		this.primCollInd = alsRecord.getPrimCollInd();
		this.revFreqId = alsRecord.getRevFreqId();
		this.resourceItemName = alsRecord.getResourceItemName();
		this.collArrngUniqueIdInSrcSys = alsRecord.getCollArrngUniqueIdInSrcSys();
		this.collArrngSrcSysId = alsRecord.getCollArrngSrcSysId();
		this.resItemValuAmt = alsRecord.getResItemValuAmt();
		this.eResItemValMethodId = alsRecord.geteResItemValMethodId();
		this.legalEnfFlag = alsRecord.getLegalEnfFlag();
		this.legalRightToPossFlag = alsRecord.getLegalRightToPossFlag();
		this.reHypInd = alsRecord.getReHypInd();
		this.collLocCode = alsRecord.getCollLocCode();
		this.inValMarginFlag = alsRecord.getInValMarginFlag();
		this.addTypId = alsRecord.getAddTypId();
		this.loanToAssRelTyp = alsRecord.getLoanToAssRelTyp();
		this.occTyp = alsRecord.getOccTyp();
		this.realPropTotUnit = alsRecord.getRealPropTotUnit();
		this.realPropTypId = alsRecord.getRealPropTypId();
		this.propLocName = alsRecord.getPropLocName();
		this.ePropCity = alsRecord.getePropCity();
		this.ePropCountry = alsRecord.getePropCountry();
		this.ePropState = alsRecord.getePropState();
		this.ePropZipCode = alsRecord.getePropZipCode();
		this.ePropAddLine1 = alsRecord.getePropAddLine1();
		this.propAddLine2 = alsRecord.getPropAddLine2();
		this.propAddLine3 = alsRecord.getPropAddLine3();
		this.resItemValueAmt = alsRecord.getResItemValueAmt();
		this.resItemValMethodId = alsRecord.getResItemValMethodId();
		this.resItemValEffDt = alsRecord.getResItemValEffDt();
		this.eResItemBalCurrId = alsRecord.geteResItemBalCurrId();
		this.eResItemBalTypId = alsRecord.geteResItemBalTypId();
		this.resItemValEvtRsnTypId = alsRecord.getResItemValEvtRsnTypId();
		this.relEffDt = alsRecord.getRelEffDt();
		this.colTypId = alsRecord.getColTypId();
		this.eGlobProdIdentifier = alsRecord.geteGlobProdIdentifier();
		this.eStdArrgId = alsRecord.geteStdArrgId();
		this.arrgName = alsRecord.getArrgName();
		this.desc = alsRecord.getDesc();
		this.bookingDt = alsRecord.getBookingDt();
		this.origEffDt = alsRecord.getOrigEffDt();
		this.effDt = alsRecord.getEffDt();
		this.estEndDt = alsRecord.getEstEndDt();
		this.endDt = alsRecord.getEndDt();
		this.arrngTypId = alsRecord.getArrngTypId();
		this.eDenomCurrId = alsRecord.geteDenomCurrId();
		this.orgChannelId = alsRecord.getOrgChannelId();
		this.arrgPurpTypId = alsRecord.getArrgPurpTypId();
		this.arrgBusIntentTyp = alsRecord.getArrgBusIntentTyp();
		this.arrgBusIntntDt = alsRecord.getArrgBusIntntDt();
		this.pledgedInd = alsRecord.getPledgedInd();
		this.pledgedEligInd = alsRecord.getPledgedEligInd();
		this.arrgMatTypId = alsRecord.getArrgMatTypId();
		this.arrgFinStsTypId = alsRecord.getArrgFinStsTypId();
		this.arrgFinStsDt = alsRecord.getArrgFinStsDt();
		this.arrgPastDueDayCnt = alsRecord.getArrgPastDueDayCnt();
		this.gracePrdDayCnt = alsRecord.getGracePrdDayCnt();
		this.arrgPastDueAgngClss = alsRecord.getArrgPastDueAgngClss();
		this.arrgPastDueAgngClssDt = alsRecord.getArrgPastDueAgngClssDt();
		this.arrgFinStsRsnTypId = alsRecord.getArrgFinStsRsnTypId();
		this.arrgLifCyclStsTypId = alsRecord.getArrgLifCyclStsTypId();
		this.arrgLifCyclStsRsnTypId = alsRecord.getArrgLifCyclStsRsnTypId();
		this.arrgLifCycStsDt = alsRecord.getArrgLifCycStsDt();
		this.arrgNxtRnwlDt = alsRecord.getArrgNxtRnwlDt();
		this.eCreditRiskMtgtTypId = alsRecord.geteCreditRiskMtgtTypId();
		this.collSrcTypId = alsRecord.getCollSrcTypId();
		this.loanToAssetRelnType = alsRecord.getLoanToAssetRelnType();
		this.propApprTypId = alsRecord.getPropApprTypId();
		this.speedRatePer = alsRecord.getSpeedRatePer();
		this.arrngRateTypRelnTypId = alsRecord.getArrngRateTypRelnTypId();
		this.rateTyp = alsRecord.getRateTyp();
		this.rateId = alsRecord.getRateId();
		this.eRateActiveFlag = alsRecord.geteRateActiveFlag();
		this.reservedForFutureGenesisUse11 = alsRecord.getReservedForFutureGenesisUse11();
		this.reservedForFutureGenesisUse12 = alsRecord.getReservedForFutureGenesisUse12();
		this.reservedForFutureGenesisUse13 = alsRecord.getReservedForFutureGenesisUse13();
		this.reservedForFutureGenesisUse14 = alsRecord.getReservedForFutureGenesisUse14();
		this.reservedForFutureGenesisUse15 = alsRecord.getReservedForFutureGenesisUse15();
		this.rateName = alsRecord.getRateName();
		this.eRateVarTypeId = alsRecord.geteRateVarTypeId();
		this.eRatingIssId = alsRecord.geteRatingIssId();
		this.eModelCd = alsRecord.geteModelCd();
		this.eRatingEvnRsnTypId = alsRecord.geteRatingEvnRsnTypId();
		this.eRank = alsRecord.geteRank();
		this.eRatingTypCd = alsRecord.geteRatingTypCd();
		this.eRatingCd = alsRecord.geteRatingCd();
		this.eFicoEquvRatingCode = alsRecord.geteFicoEquvRatingCode();
		this.ratingDesc = alsRecord.getRatingDesc();
		this.eScoreReqReturnFlag = alsRecord.geteScoreReqReturnFlag();
		this.eInvPtyUniqueId = alsRecord.geteInvPtyUniqueId();
		this.eOrigChnlId = alsRecord.geteOrigChnlId();
		this.eArrngDayCntConvTypId = alsRecord.geteArrngDayCntConvTypId();
		this.eIntrPayFreqPeriodId = alsRecord.geteIntrPayFreqPeriodId();
		this.eRateResetPerodInterId = alsRecord.geteRateResetPerodInterId();
		this.eArrngSecurTypeId = alsRecord.geteArrngSecurTypeId();
		this.eSecurizedInd = alsRecord.geteSecurizedInd();
		this.eCreditFacTypId = alsRecord.geteCreditFacTypId();
		this.eCreditFacArrngAppTypId = alsRecord.geteCreditFacArrngAppTypId();
		this.eOriAmt = alsRecord.geteOriAmt();
		this.eCrdtLimitChangeTypeId = alsRecord.geteCrdtLimitChangeTypeId();
		this.eAcLastPymtToBankAmount = alsRecord.geteAcLastPymtToBankAmount();
		this.eOriLtvRatio = alsRecord.geteOriLtvRatio();
		this.eArrngPtyRolType = alsRecord.geteArrngPtyRolType();
		this.ePctAmt = alsRecord.getePctAmt();
		this.eInvPtySubtypeId = alsRecord.geteInvPtySubtypeId();
		this.scoreReqReturnedFlg = alsRecord.getScoreReqReturnedFlg();
		this.uniqueIdCardArng = alsRecord.getUniqueIdCardArng();
		this.supportSeqNumber = alsRecord.getSupportSeqNumber();
		this.guranteeSupportTypeId = alsRecord.getGuranteeSupportTypeId();
		this.guranteeSupportCovBasicTypeId = alsRecord.getGuranteeSupportCovBasicTypeId();
		this.guranteeSupportCovTypeId = alsRecord.getGuranteeSupportCovTypeId();
		this.insurenceTypeId = alsRecord.getInsurenceTypeId();
		this.insurenceSupportCovBasicTypeId = alsRecord.getInsurenceSupportCovBasicTypeId();
		this.insurenceSupportCovTypeId = alsRecord.getInsurenceSupportCovTypeId();
		this.eEffectiveRatePercentage = alsRecord.geteEffectiveRatePercentage();
		this.eRateVarTypId = alsRecord.geteRateVarTypId();
		this.eRateTypeId = alsRecord.geteRateTypeId();
		this.eBalType = alsRecord.geteBalType();
		this.eFuncCurr = alsRecord.geteFuncCurr();
		this.eRepPeriodMonth = alsRecord.geteRepPeriodMonth();
		this.eLoanAssestRelnType = alsRecord.geteLoanAssestRelnType();
		this.eRealPropType = alsRecord.geteRealPropType();
		this.eIntrstAccrualStatTypDt = alsRecord.geteIntrstAccrualStatTypDt();
		this.eFacLegStatTypId = alsRecord.geteFacLegStatTypId();
		this.eAssestRelationType = alsRecord.geteAssestRelationType();
		this.eRecTypeColl = alsRecord.geteRecTypeColl();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		this.eTranCurr = alsRecord.geteTranCurr();
		this.eBaseCurrCode = alsRecord.geteBaseCurrCode();
		this.eEntProdId = alsRecord.geteEntProdId();
		this.eIntrBAsicCalcPeriodId = alsRecord.geteIntrBAsicCalcPeriodId();
		this.invPtyLocRltnpTypId = alsRecord.getInvPtyLocRltnpTypId();
		this.eUniqueIdSrcSysInvlParty = alsRecord.geteUniqueIdSrcSysInvlParty();
		this.eInvlvPartySubTypeId = alsRecord.geteInvlvPartySubTypeId();
		this.eGLAccount1 = alsRecord.geteGLAccount1();
		//this.eTxnAmt = alsRecord.geteTxnAmt();
		//this.eTxnAmt = new BigDecimal(alsRecord.geteTxnAmt());
		this.eLclLglVehicleCde = alsRecord.geteLclLglVehicleCde();
		this.eGAAPInd = alsRecord.geteGAAPInd();
		
	
	
	}
}
