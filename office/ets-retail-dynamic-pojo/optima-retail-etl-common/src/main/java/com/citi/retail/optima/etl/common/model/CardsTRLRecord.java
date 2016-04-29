/**
 * 
 */
package com.citi.retail.optima.etl.common.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author gv74035
 *
 */
public class CardsTRLRecord extends ExcludableRecord{

	protected String eSrcSysId;
	protected String eProdSysId;
	protected String eRecType;
	protected String eRatingIssuerId;
	protected String eModelCode;
	protected Integer eRatingReasonId;
	protected Integer eRank;
	protected Date eEffDate;
	protected Date eEndDate;
	protected Date eRptMonthDate;
	protected Long eFicoScore ;
	protected String eRatingDesc;
	protected String eScoreReturnFlag;
	protected String eArrangementRoleType;
	protected Double ePercentAmount;
	protected String eInvolvedPartySubtypeId;
	protected BigDecimal eFuncAmt;
		
	protected String eGlbProdId;
	protected String eEntProdId;
	protected String eStdArrgId;
	protected Date eOrgEffDate;
	protected String eDenCurrencyId;
	protected Integer eOrigChnlId;
	protected Integer eArrngPurpTypeId;
	protected Integer eArrngBusIntType;
	protected Date eArrngBussIntDate;
	protected String ePledgInd;
	protected String ePledgEligInd;
	protected Integer eArrngMatuTypeId;
	protected Integer eArrngFinStatTypId;
	protected Date eArrngFinStatDate;
	protected Integer eGracePeriodDayCnt;
	protected Integer eArrngPastDueAgeClass;
	protected Integer eArrngLifCycStat;
	protected Integer eArrngLifCycStatReasonTypId;
	protected Integer eArrngPrimPayTypeId;
	protected Integer eAccTypId;
	protected Integer eArrngAcqTypId ;
	protected Date eArrngAcqDt;
	protected Integer eChrgOffTypId;
	protected Integer eOrigInsuredCatId;
	protected Double eOrigInsuredPct;
	protected Integer eArrngDayCntConvTypId;
	protected Integer eIntrBasCalcPerId;
	protected Integer eIntrPayFreqPeriodId;
	protected Integer eRateResetPerodInterId;
	protected Date eInitIntrestRateResetDt;
	protected Date eNxtIntrRateResetDate ;
	protected String eIslamicAccInd ;
	protected String eTaxExemptInd ;
	protected Integer eFinServiceTypId;
	protected Integer eFinServiceLimitTypId;
	protected Integer eArrngSecurTypeId;
	protected String eCitiRecourseInd;
	protected Integer ePaymentFreqPeriodId;
	protected Integer eCurrFinServicePrinRepayTypId;
	protected Integer eIntrstAccrualStatTypId;
	protected Date eIntrstAccrualStatTypDt;
	protected Date eFinanceServRestCurrStatDate;
	protected Integer eFinanceServRestCurrStatId;
	protected String eTroubledDebtRestructFlag;
	protected String eOverLimInd;
	protected String eSkipPayInd;
	protected String eSecurizedInd;
	protected String eLOCAutExtFlag;
	protected String eLOCTermLoanConFlag;
	protected String eCreditDeviationInd;
	protected Integer eFinServiceModReasTypId;
	protected Integer eCreditFacTypId;
	protected Integer eFacLegStatTypId;
	protected Date eFacilityLegStatDt;
	protected Integer eCreditFacArrngAppTypId;
	protected Date eCredFacArrngAppDt;
	protected Integer eCreditFacAvailStatTypId;
	protected String eAssocAffCode;
	protected Integer eCredCrdClassTyp;
	protected Integer eCredCardTypId;
	protected Integer eCredLimChngTypId;
	protected String eReissueFlag;
	protected Date eAccLastRecDate;
	protected Integer eTotCashTxn;
	protected Integer eTotPurchaseTxn;
	protected Double ePenaltyRate;
	protected Double ePenaltyAmt;
	protected Integer eLegalNotificationDays;
	protected String eDelq30pst2yrsFlag;
	protected Integer eLienPositTypId;
	protected Date eActualBillingCycDt;
	protected Integer eFeePayFreqPeriodId;
	protected String eCCARProdCode;
	protected String ePromoIntRateEligFlag;
	protected BigDecimal eOrigAdvisedUncomLimit;
	protected String eRestructureFlag;
	protected Date eLastWritDwnDt;
	protected String eRiskManagInd;
	protected Integer eDelqBucket;
	


	protected String eUniqueId;
	protected Date eBookingDate;
	protected Date eArrngLifCycStatDate;
	protected Integer eCredCardPortfolioId;
	protected Integer eNumOfAddCards;
	protected Date eArrngLstPayToBnkDt;
	protected BigDecimal eAccLstPayToBnkAmt;
	protected String eLocalBlkCde;
	protected String eCardsFirstDigit;


	protected Integer eArrngPastDueDayCount;
	protected Date eArrngNxtRenewDt;
	protected BigDecimal eOriginalAmt;
	protected Date eCredCrdBillCycDt;
	protected String eBaselPortId;
	protected Integer eMonthsOnBooksLocal;
	protected String eMonthsOnBooksLocalInCard;


	protected String eInvPtyUniqueId;
	protected String eArrngPtyRolType;
	protected BigDecimal ePctAmt;
	protected String eInvPtySubTypeId;
	protected String eRatingCode;
	protected String eFicoEqvRatingCode;
	protected String eScoreReqReturnFlag;
	protected Integer eRateVarTypId;
	protected String eRateTypId;
	protected Integer eLegNumber;
	protected String eBkingLedgCntryCde;
	protected String eTnxCurrency;
	protected String eFuncCurcyCode;
	protected String eBaseCurcyCode;
	protected String eGAAPInd;
	protected Integer eRatingEveReasTypId;
	protected BigDecimal eEffRatePct;
	protected Date eArrngPastDueAgeClassDate;
	
	protected String eRateActiveFlag;
	private Date eLstCredLmtChngDt;
	private Date eLstReageDt;
	private BigDecimal eArrngNxtPayDueAmt;
	private Date eLstRetTransDt;
	private Date eLstCashTranDt;
	private Date eCredLimEffDt;
	private Date eCredLimEndDt;
	private BigDecimal eCredLimEveAmt;
	private String eBkingLedgerCountryCode;
	private Date creditLimitEfcDate;
	
	
	private List<ArrangementTRLRecord> eArragnmntTRLRecords;
	private Double eRiRate;
	private Double eCiRate;
	
	
	private List<CommonBalanceTRLRecord> eCommonBalTRLRecords;
	private Double eTotIntAccrued;
	private Double eGrossChargeOffBal;
	private Double eAnnualFeesUnpaid;
	private Double eOtherCreditCardFeesUpd;
	private Double eGrsPurchasePrnplRecvs;
	private Double eGrsCashAdvPrnplRecvs;
	private Double eGrsPurchaseIntRecvs;
	private Double eGrssTotIntRecvs;
	private Double eGrsCashAdvIntRecvs;
	private Double eGrsCashAdvFeeRecvs;
	private Double eTotIntBalEnr;
	private Double eCurAdvisedUncommtdLmt;
	private Double eAlopUnpaidPrnplBal;
	private Double eTotBalAnr;
	private Double eRecoveriesAmount;
	private Double eLateFeeBilled;
	private Double eInsuranceCost;
	private Double eCashAdvPrnplEnr;
	private Double eCashBalAnr;
	private Double eTotCreditLimit;
	private Double eTotUsedCreditLimit;
	private Double eCreditCardEndingBal;
	private Double eBalAtCashApr;
	private Double eTotPastDueAmount;
	private Double eContractualWoPrnplAmt;
	private Double eAtmFeeUpd;
	private Double eWoTotPnrplRecvl;
	private Double eWoTotIntRecvl;
	private String eCycEndDelqBucket;
	private String notForUse;
	private String expenseCode;
	
	private Double eBaseAmtCurr;
	private String eWoDelq;
	private String eDelqSubStr;
	private Double eTxnAmtForBal9;
	private Date eAIPEndDate;
	private Date eAREndDate;
		
	/***
	 * This section is for fixing CB issue
	 * @return
	 */
	private Double ePayAmt2; 
	private Double eRtlMiscBnp;
	/**
	 * @return the eCshFee
	 */
	public Double geteCshFee() {
		return eCshFee;
	}
	/**
	 * @param eCshFee the eCshFee to set
	 */
	public void setECshFee(Double eCshFee) {
		this.eCshFee = eCshFee;
	}
	/**
	 * @return the eAnr2
	 */
	public Double geteAnr2() {
		return eAnr2;
	}
	/**
	 * @param eAnr2 the eAnr2 to set
	 */
	public void setEAnr2(Double eAnr2) {
		this.eAnr2 = eAnr2;
	}
	/**
	 * @return the eCurrDueAmt
	 */
	public Double geteCurrDueAmt() {
		return eCurrDueAmt;
	}
	/**
	 * @param eCurrDueAmt the eCurrDueAmt to set
	 */
	public void setECurrDueAmt(Double eCurrDueAmt) {
		this.eCurrDueAmt = eCurrDueAmt;
	}
	/**
	 * @return the eCshBlnc2
	 */
	public Double geteCshBlnc2() {
		return eCshBlnc2;
	}
	/**
	 * @param eCshBlnc2 the eCshBlnc2 to set
	 */
	public void setECshBlnc2(Double eCshBlnc2) {
		this.eCshBlnc2 = eCshBlnc2;
	}
	/**
	 * @return the eCrlmRelmLcyAmt
	 */
	public Double geteCrlmRelmLcyAmt() {
		return eCrlmRelmLcyAmt;
	}
	/**
	 * @param eCrlmRelmLcyAmt the eCrlmRelmLcyAmt to set
	 */
	public void setECrlmRelmLcyAmt(Double eCrlmRelmLcyAmt) {
		this.eCrlmRelmLcyAmt = eCrlmRelmLcyAmt;
	}
	/**
	 * @return the ePastDueAmt
	 */
	public Double getePastDueAmt() {
		return ePastDueAmt;
	}
	/**
	 * @param ePastDueAmt the ePastDueAmt to set
	 */
	public void setEPastDueAmt(Double ePastDueAmt) {
		this.ePastDueAmt = ePastDueAmt;
	}

	private Double eRtlSvcBnp;
	private Double eCshFee;
	private Double eAnr2;
	private Double eCurrDueAmt;
	private Double eCshBlnc2;
	private Double eCrlmRelmLcyAmt;
	private Double ePastDueAmt;
	
	private Double eRtlIntr;
	private Double eAnfee;
	private Double eMdue;
	private Double eClt2;
	private Double eLclt2;
	private Integer eAvailclt;
	private Double eTotAmtDue;
	
	public Date geteArrngPastDueAgeClassDate() {
		return eArrngPastDueAgeClassDate;
	}
	public void setEArrngPastDueAgeClassDate(Date eArrngPastDueAgeClassDate) {
		this.eArrngPastDueAgeClassDate = eArrngPastDueAgeClassDate;
	}
	public String geteBkingLedgerCountryCode() {
		return eBkingLedgerCountryCode;
	}
	public void setEBkingLedgerCountryCode(String eBkingLedgerCountryCode) {
		this.eBkingLedgerCountryCode = eBkingLedgerCountryCode;
	}	
	public BigDecimal geteCredLimEveAmt() {
		return eCredLimEveAmt;
	}
	public void setECredLimEveAmt(Double eCredLimEveAmt) {
		if (eCredLimEveAmt==null){
			this.eCredLimEveAmt = null;
		}
		else if(eCredLimEveAmt ==0){
			this.eCredLimEveAmt=new BigDecimal(0);	
		}
		else {
			this.eCredLimEveAmt = new BigDecimal(eCredLimEveAmt).setScale(10,BigDecimal.ROUND_HALF_UP);
		}

	}
	public Date geteCredLimEffDt() {
		return eCredLimEffDt;
	}
	public void setECredLimEffDt(Date eCredLimEffDt) {
		this.eCredLimEffDt = eCredLimEffDt;
	}
	public Date geteCredLimEndDt() {
		return eCredLimEndDt;
	}
	public void setECredLimEndDt(Date eCredLimEndDt) {
		this.eCredLimEndDt = eCredLimEndDt;
	}
	public Date geteLstReageDt() {
		return eLstReageDt;
	}
	public void setELstReageDt(Date eLstReageDt) {
		this.eLstReageDt = eLstReageDt;
	}
	public BigDecimal geteArrngNxtPayDueAmt() {
		return eArrngNxtPayDueAmt;
	}
	public void setEArrngNxtPayDueAmt(Double eArrngNxtPayDueAmt) {
		if (eArrngNxtPayDueAmt==null){
			this.eArrngNxtPayDueAmt = null;
		}
		else if(eArrngNxtPayDueAmt ==0){
			this.eArrngNxtPayDueAmt=new BigDecimal(0);	
		}
		else {
			this.eArrngNxtPayDueAmt = new BigDecimal(eArrngNxtPayDueAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}

	}
	public Date geteLstRetTransDt() {
		return eLstRetTransDt;
	}
	public void setELstRetTransDt(Date eLstRetTransDt) {
		this.eLstRetTransDt = eLstRetTransDt;
	}
	public Date geteLstCashTranDt() {
		return eLstCashTranDt;
	}
	public void setELstCashTranDt(Date eLstCashTranDt) {
		this.eLstCashTranDt = eLstCashTranDt;
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
	 * @return the eRecType
	 */
	public String geteRecType() {
		return eRecType;
	}
	/**
	 * @param eRecType the eRecType to set
	 */
	public void setERecType(String eRecType) {
		this.eRecType = eRecType;
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
	 * @return the eRatingReasonId
	 */
	public Integer geteRatingReasonId() {
		return eRatingReasonId;
	}
	/**
	 * @param eRatingReasonId the eRatingReasonId to set
	 */
	public void setERatingReasonId(Integer eRatingReasonId) {
		this.eRatingReasonId = eRatingReasonId;
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
	 * @return the eEffDate
	 */
	public Date geteEffDate() {
		return eEffDate;
	}
	/**
	 * @param eEffDate the eEffDate to set
	 */
	public void setEEffDate(Date eEffDate) {
		this.eEffDate = eEffDate;
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
	 * @return the eFicoScore
	 */
	public Long geteFicoScore() {
		return eFicoScore;
	}
	/**
	 * @param eFicoScore the eFicoScore to set
	 */
	public void setEFicoScore(Long eFicoScore) {
		this.eFicoScore = eFicoScore;
	}
	/**
	 * @return the eRatingDesc
	 */
	public String geteRatingDesc() {
		return eRatingDesc;
	}
	/**
	 * @param eRatingDesc the eRatingDesc to set
	 */
	public void setERatingDesc(String eRatingDesc) {
		this.eRatingDesc = eRatingDesc;
	}
	/**
	 * @return the eScoreReturnFlag
	 */
	public String geteScoreReturnFlag() {
		return eScoreReturnFlag;
	}
	/**
	 * @param eScoreReturnFlag the eScoreReturnFlag to set
	 */
	public void setEScoreReturnFlag(String eScoreReturnFlag) {
		this.eScoreReturnFlag = eScoreReturnFlag;
	}
	/**
	 * @return the eArrangementRoleType
	 */
	public String geteArrangementRoleType() {
		return eArrangementRoleType;
	}
	/**
	 * @param eArrangementRoleType the eArrangementRoleType to set
	 */
	public void setEArrangementRoleType(String eArrangementRoleType) {
		this.eArrangementRoleType = eArrangementRoleType;
	}
	/**
	 * @return the ePercentAmount
	 */
	public Double getePercentAmount() {
		return ePercentAmount;
	}
	/**
	 * @param ePercentAmount the ePercentAmount to set
	 */
	public void setEPercentAmount(Double ePercentAmount) {
		this.ePercentAmount = ePercentAmount;
	}
	/**
	 * @return the eInvolvedPartySubtypeId
	 */
	public String geteInvolvedPartySubtypeId() {
		return eInvolvedPartySubtypeId;
	}
	/**
	 * @param eInvolvedPartySubtypeId the eInvolvedPartySubtypeId to set
	 */
	public void setEInvolvedPartySubtypeId(String eInvolvedPartySubtypeId) {
		this.eInvolvedPartySubtypeId = eInvolvedPartySubtypeId;
	}

	public Integer geteCreditFacAvailStatTypId() {
		return eCreditFacAvailStatTypId;
	}
	public void setECreditFacAvailStatTypId(Integer eCreditFacAvailStatTypId) {
		this.eCreditFacAvailStatTypId = eCreditFacAvailStatTypId;
	}
	public String geteAssocAffCode() {
		return eAssocAffCode;
	}
	public void setEAssocAffCode(String eAssocAffCode) {
		this.eAssocAffCode = eAssocAffCode;
	}
	public String geteDenCurrencyId() {
		return eDenCurrencyId;
	}
	public void setEDenCurrencyId(String eDenCurrencyId) {
		this.eDenCurrencyId = eDenCurrencyId;
	}
	public String geteGlbProdId() {
		return eGlbProdId;
	}
	public void setEGlbProdId(String eGlbProdId) {
		this.eGlbProdId = eGlbProdId;
	}
	public String geteEntProdId() {
		return eEntProdId;
	}
	public void setEEntProdId(String eEntProdId) {
		this.eEntProdId = eEntProdId;
	}
	public String geteStdArrgId() {
		return eStdArrgId;
	}
	public void setEStdArrgId(String eStdArrgId) {
		this.eStdArrgId = eStdArrgId;
	}
	public Date geteOrgEffDate() {
		return eOrgEffDate;
	}
	public void setEOrgEffDate(Date eOrgEffDate) {
		this.eOrgEffDate = eOrgEffDate;
	}
	public Integer geteOrigChnlId() {
		return eOrigChnlId;
	}
	public void setEOrigChnlId(Integer eOrigChnlId) {
		this.eOrigChnlId = eOrigChnlId;
	}
	public Integer geteArrngPurpTypeId() {
		return eArrngPurpTypeId;
	}
	public void setEArrngPurpTypeId(Integer eArrngPurpTypeId) {
		this.eArrngPurpTypeId = eArrngPurpTypeId;
	}
	public Integer geteArrngBusIntType() {
		return eArrngBusIntType;
	}
	public void setEArrngBusIntType(Integer eArrngBusIntType) {
		this.eArrngBusIntType = eArrngBusIntType;
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
	public Integer geteArrngMatuTypeId() {
		return eArrngMatuTypeId;
	}
	public void setEArrngMatuTypeId(Integer eArrngMatuTypeId) {
		this.eArrngMatuTypeId = eArrngMatuTypeId;
	}
	public Integer geteArrngFinStatTypId() {
		return eArrngFinStatTypId;
	}
	public void setEArrngFinStatTypId(Integer eArrngFinStatTypId) {
		this.eArrngFinStatTypId = eArrngFinStatTypId;
	}
	public Date geteArrngFinStatDate() {
		return eArrngFinStatDate;
	}
	public void setEArrngFinStatDate(Date eArrngFinStatDate) {
		this.eArrngFinStatDate = eArrngFinStatDate;
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
	public Integer geteArrngLifCycStat() {
		return eArrngLifCycStat;
	}
	public void setEArrngLifCycStat(Integer eArrngLifCycStat) {
		this.eArrngLifCycStat = eArrngLifCycStat;
	}
	public Integer geteArrngLifCycStatReasonTypId() {
		return eArrngLifCycStatReasonTypId;
	}
	public void setEArrngLifCycStatReasonTypId(Integer eArrngLifCycStatReasonTypId) {
		this.eArrngLifCycStatReasonTypId = eArrngLifCycStatReasonTypId;
	}
	public Integer geteArrngPrimPayTypeId() {
		return eArrngPrimPayTypeId;
	}
	public void setEArrngPrimPayTypeId(Integer eArrngPrimPayTypeId) {
		this.eArrngPrimPayTypeId = eArrngPrimPayTypeId;
	}
	public Integer geteAccTypId() {
		return eAccTypId;
	}
	public void setEAccTypId(Integer eAccTypId) {
		this.eAccTypId = eAccTypId;
	}
	public Integer geteArrngAcqTypId() {
		return eArrngAcqTypId;
	}
	public void setEArrngAcqTypId(Integer eArrngAcqTypId) {
		this.eArrngAcqTypId = eArrngAcqTypId;
	}
	public Date geteArrngAcqDt() {
		return eArrngAcqDt;
	}
	public void setEArrngAcqDt(Date eArrngAcqDt) {
		this.eArrngAcqDt = eArrngAcqDt;
	}
	public Integer geteChrgOffTypId() {
		return eChrgOffTypId;
	}
	public void setEChrgOffTypId(Integer eChrgOffTypId) {
		this.eChrgOffTypId = eChrgOffTypId;
	}
	public Integer geteOrigInsuredCatId() {
		return eOrigInsuredCatId;
	}
	public void setEOrigInsuredCatId(Integer eOrigInsuredCatId) {
		this.eOrigInsuredCatId = eOrigInsuredCatId;
	}
	public Double geteOrigInsuredPct() {
		return eOrigInsuredPct;
	}
	public void setEOrigInsuredPct(Double eOrigInsuredPct) {
		this.eOrigInsuredPct = eOrigInsuredPct;
	}
	public Integer geteArrngDayCntConvTypId() {
		return eArrngDayCntConvTypId;
	}
	public void setEArrngDayCntConvTypId(Integer eArrngDayCntConvTypId) {
		this.eArrngDayCntConvTypId = eArrngDayCntConvTypId;
	}
	public Integer geteIntrBasCalcPerId() {
		return eIntrBasCalcPerId;
	}
	public void setEIntrBasCalcPerId(Integer eIntrBasCalcPerId) {
		this.eIntrBasCalcPerId = eIntrBasCalcPerId;
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
	public Date geteInitIntrestRateResetDt() {
		return eInitIntrestRateResetDt;
	}
	public void setEInitIntrestRateResetDt(Date eInitIntrestRateResetDt) {
		this.eInitIntrestRateResetDt = eInitIntrestRateResetDt;
	}
	public Date geteNxtIntrRateResetDate() {
		return eNxtIntrRateResetDate;
	}
	public void setENxtIntrRateResetDate(Date eNxtIntrRateResetDate) {
		this.eNxtIntrRateResetDate = eNxtIntrRateResetDate;
	}
	public String geteIslamicAccInd() {
		return eIslamicAccInd;
	}
	public void setEIslamicAccInd(String eIslamicAccInd) {
		this.eIslamicAccInd = eIslamicAccInd;
	}
	public String geteTaxExemptInd() {
		return eTaxExemptInd;
	}
	public void setETaxExemptInd(String eTaxExemptInd) {
		this.eTaxExemptInd = eTaxExemptInd;
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
	public String geteCitiRecourseInd() {
		return eCitiRecourseInd;
	}
	public void setECitiRecourseInd(String eCitiRecourseInd) {
		this.eCitiRecourseInd = eCitiRecourseInd;
	}
	public Integer getePaymentFreqPeriodId() {
		return ePaymentFreqPeriodId;
	}
	public void setEPaymentFreqPeriodId(Integer ePaymentFreqPeriodId) {
		this.ePaymentFreqPeriodId = ePaymentFreqPeriodId;
	}
	public Integer geteCurrFinServicePrinRepayTypId() {
		return eCurrFinServicePrinRepayTypId;
	}
	public void setECurrFinServicePrinRepayTypId(
			Integer eCurrFinServicePrinRepayTypId) {
		this.eCurrFinServicePrinRepayTypId = eCurrFinServicePrinRepayTypId;
	}
	public Integer geteIntrstAccrualStatTypId() {
		return eIntrstAccrualStatTypId;
	}
	public void setEIntrstAccrualStatTypId(Integer eIntrstAccrualStatTypId) {
		this.eIntrstAccrualStatTypId = eIntrstAccrualStatTypId;
	}
	public Date geteIntrstAccrualStatTypDt() {
		return eIntrstAccrualStatTypDt;
	}
	public void setEIntrstAccrualStatTypDt(Date eIntrstAccrualStatTypDt) {
		this.eIntrstAccrualStatTypDt = eIntrstAccrualStatTypDt;
	}
	public Date geteFinanceServRestCurrStatDate() {
		return eFinanceServRestCurrStatDate;
	}
	public void setEFinanceServRestCurrStatDate(Date eFinanceServRestCurrStatDate) {
		this.eFinanceServRestCurrStatDate = eFinanceServRestCurrStatDate;
	}
	public Integer geteFinanceServRestCurrStatId() {
		return eFinanceServRestCurrStatId;
	}
	public void setEFinanceServRestCurrStatId(Integer eFinanceServRestCurrStatId) {
		this.eFinanceServRestCurrStatId = eFinanceServRestCurrStatId;
	}
	public String geteTroubledDebtRestructFlag() {
		return eTroubledDebtRestructFlag;
	}
	public void setETroubledDebtRestructFlag(String eTroubledDebtRestructFlag) {
		this.eTroubledDebtRestructFlag = eTroubledDebtRestructFlag;
	}
	public String geteOverLimInd() {
		return eOverLimInd;
	}
	public void setEOverLimInd(String eOverLimInd) {
		this.eOverLimInd = eOverLimInd;
	}
	public String geteSkipPayInd() {
		return eSkipPayInd;
	}
	public void setESkipPayInd(String eSkipPayInd) {
		this.eSkipPayInd = eSkipPayInd;
	}
	public String geteSecurizedInd() {
		return eSecurizedInd;
	}
	public void setESecurizedInd(String eSecurizedInd) {
		this.eSecurizedInd = eSecurizedInd;
	}
	public String geteLOCAutExtFlag() {
		return eLOCAutExtFlag;
	}
	public void setELOCAutExtFlag(String eLOCAutExtFlag) {
		this.eLOCAutExtFlag = eLOCAutExtFlag;
	}
	public String geteLOCTermLoanConFlag() {
		return eLOCTermLoanConFlag;
	}
	public void setELOCTermLoanConFlag(String eLOCTermLoanConFlag) {
		this.eLOCTermLoanConFlag = eLOCTermLoanConFlag;
	}
	public String geteCreditDeviationInd() {
		return eCreditDeviationInd;
	}
	public void setECreditDeviationInd(String eCreditDeviationInd) {
		this.eCreditDeviationInd = eCreditDeviationInd;
	}
	public Integer geteFinServiceModReasTypId() {
		return eFinServiceModReasTypId;
	}
	public void setEFinServiceModReasTypId(Integer eFinServiceModReasTypId) {
		this.eFinServiceModReasTypId = eFinServiceModReasTypId;
	}
	public Integer geteCreditFacTypId() {
		return eCreditFacTypId;
	}
	public void setECreditFacTypId(Integer eCreditFacTypId) {
		this.eCreditFacTypId = eCreditFacTypId;
	}
	public Integer geteFacLegStatTypId() {
		return eFacLegStatTypId;
	}
	public void setEFacLegStatTypId(Integer eFacLegStatTypId) {
		this.eFacLegStatTypId = eFacLegStatTypId;
	}
	public Date geteFacilityLegStatDt() {
		return eFacilityLegStatDt;
	}
	public void setEFacilityLegStatDt(Date eFacilityLegStatDt) {
		this.eFacilityLegStatDt = eFacilityLegStatDt;
	}
	public Integer geteCreditFacArrngAppTypId() {
		return eCreditFacArrngAppTypId;
	}
	public void setECreditFacArrngAppTypId(Integer eCreditFacArrngAppTypId) {
		this.eCreditFacArrngAppTypId = eCreditFacArrngAppTypId;
	}
	public Date geteCredFacArrngAppDt() {
		return eCredFacArrngAppDt;
	}
	public void setECredFacArrngAppDt(Date eCredFacArrngAppDt) {
		this.eCredFacArrngAppDt = eCredFacArrngAppDt;
	}
	public Integer geteCredCrdClassTyp() {
		return eCredCrdClassTyp;
	}
	public void setECredCrdClassTyp(Integer eCredCrdClassTyp) {
		this.eCredCrdClassTyp = eCredCrdClassTyp;
	}
	public Integer geteCredCardTypId() {
		return eCredCardTypId;
	}
	public void setECredCardTypId(Integer eCredCardTypId) {
		this.eCredCardTypId = eCredCardTypId;
	}
	public Integer geteCredLimChngTypId() {
		return eCredLimChngTypId;
	}
	public void setECredLimChngTypId(Integer eCredLimChngTypId) {
		this.eCredLimChngTypId = eCredLimChngTypId;
	}
	public String geteReissueFlag() {
		return eReissueFlag;
	}
	public void setEReissueFlag(String eReissueFlag) {
		this.eReissueFlag = eReissueFlag;
	}
	public Date geteAccLastRecDate() {
		return eAccLastRecDate;
	}
	public void setEAccLastRecDate(Date eAccLastRecDate) {
		this.eAccLastRecDate = eAccLastRecDate;
	}
	public Integer geteTotCashTxn() {
		return eTotCashTxn;
	}
	public void setETotCashTxn(Integer eTotCashTxn) {
		this.eTotCashTxn = eTotCashTxn;
	}
	public Integer geteTotPurchaseTxn() {
		return eTotPurchaseTxn;
	}
	public void setETotPurchaseTxn(Integer eTotPurchaseTxn) {
		this.eTotPurchaseTxn = eTotPurchaseTxn;
	}
	public Double getePenaltyRate() {
		return ePenaltyRate;
	}
	public void setEPenaltyRate(Double ePenaltyRate) {
		this.ePenaltyRate = ePenaltyRate;
	}
	public Double getePenaltyAmt() {
		return ePenaltyAmt;
	}
	public void setEPenaltyAmt(Double ePenaltyAmt) {
		this.ePenaltyAmt = ePenaltyAmt;
	}
	public Integer geteLegalNotificationDays() {
		return eLegalNotificationDays;
	}
	public void setELegalNotificationDays(Integer eLegalNotificationDays) {
		this.eLegalNotificationDays = eLegalNotificationDays;
	}
	public String geteDelq30pst2yrsFlag() {
		return eDelq30pst2yrsFlag;
	}
	public void setEDelq30pst2yrsFlag(String eDelq30pst2yrsFlag) {
		this.eDelq30pst2yrsFlag = eDelq30pst2yrsFlag;
	}
	public Integer geteLienPositTypId() {
		return eLienPositTypId;
	}
	public void setELienPositTypId(Integer eLienPositTypId) {
		this.eLienPositTypId = eLienPositTypId;
	}
	public Date geteActualBillingCycDt() {
		return eActualBillingCycDt;
	}
	public void setEActualBillingCycDt(Date eActualBillingCycDt) {
		this.eActualBillingCycDt = eActualBillingCycDt;
	}
	public Integer geteFeePayFreqPeriodId() {
		return eFeePayFreqPeriodId;
	}
	public void setEFeePayFreqPeriodId(Integer eFeePayFreqPeriodId) {
		this.eFeePayFreqPeriodId = eFeePayFreqPeriodId;
	}
	public String geteCCARProdCode() {
		return eCCARProdCode;
	}
	public void setECCARProdCode(String eCCARProdCode) {
		this.eCCARProdCode = eCCARProdCode;
	}
	public String getePromoIntRateEligFlag() {
		return ePromoIntRateEligFlag;
	}
	public void setEPromoIntRateEligFlag(String ePromoIntRateEligFlag) {
		this.ePromoIntRateEligFlag = ePromoIntRateEligFlag;
	}
	public BigDecimal geteOrigAdvisedUncomLimit() {
		return eOrigAdvisedUncomLimit;
	}
	public void setEOrigAdvisedUncomLimit(Double eOrigAdvisedUncomLimit) {
		if (eOrigAdvisedUncomLimit==null){
			this.eOrigAdvisedUncomLimit = null;
		}
		else if(eOrigAdvisedUncomLimit ==0){
			this.eOrigAdvisedUncomLimit=new BigDecimal(0);	
		}
		else {
			this.eOrigAdvisedUncomLimit = new BigDecimal(eOrigAdvisedUncomLimit).setScale(10,BigDecimal.ROUND_HALF_UP);
		}

	}
	public String geteRestructureFlag() {
		return eRestructureFlag;
	}
	public void setERestructureFlag(String eRestructureFlag) {
		this.eRestructureFlag = eRestructureFlag;
	}
	public Date geteLastWritDwnDt() {
		return eLastWritDwnDt;
	}
	public void setELastWritDwnDt(Date eLastWritDwnDt) {
		this.eLastWritDwnDt = eLastWritDwnDt;
	}
	public String geteRiskManagInd() {
		return eRiskManagInd;
	}
	public void setERiskManagInd(String eRiskManagInd) {
		this.eRiskManagInd = eRiskManagInd;
	}
	public Integer geteDelqBucket() {
		return eDelqBucket;
	}
	public void setEDelqBucket(Integer eDelqBucket) {
		this.eDelqBucket = eDelqBucket;
	}
	
	public String geteUniqueId() {
		return eUniqueId;
	}
	public void setEUniqueId(String eUniqueId) {
		this.eUniqueId = eUniqueId;
	}
	public Date geteBookingDate() {
		return eBookingDate;
	}
	public void setEBookingDate(Date eBookingDate) {
		this.eBookingDate = eBookingDate;
	}
	public Date geteArrngLifCycStatDate() {
		return eArrngLifCycStatDate;
	}
	public void setEArrngLifCycStatDate(Date eArrngLifCycStatDate) {
		this.eArrngLifCycStatDate = eArrngLifCycStatDate;
	}
	public Integer geteCredCardPortfolioId() {
		return eCredCardPortfolioId;
	}
	public void setECredCardPortfolioId(Integer eCredCardPortfolioId) {
		this.eCredCardPortfolioId = eCredCardPortfolioId;
	}
	public Integer geteNumOfAddCards() {
		return eNumOfAddCards;
	}
	public void setENumOfAddCards(Integer eNumOfAddCards) {
		this.eNumOfAddCards = eNumOfAddCards;
	}
	public Date geteArrngLstPayToBnkDt() {
		return eArrngLstPayToBnkDt;
	}
	public void setEArrngLstPayToBnkDt(Date eArrngLstPayToBnkDt) {
		this.eArrngLstPayToBnkDt = eArrngLstPayToBnkDt;
	}
	public BigDecimal geteAccLstPayToBnkAmt() {
		return eAccLstPayToBnkAmt;
	}
	public void setEAccLstPayToBnkAmt(Double eAccLstPayToBnkAmt) {
		if (eAccLstPayToBnkAmt==null){
			this.eAccLstPayToBnkAmt = null;
		}
		else if(eAccLstPayToBnkAmt ==0){
			this.eAccLstPayToBnkAmt=new BigDecimal(0);	
		}
		else {
			this.eAccLstPayToBnkAmt = new BigDecimal(eAccLstPayToBnkAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}

	}
	public String geteLocalBlkCde() {
		return eLocalBlkCde;
	}
	public void setELocalBlkCde(String eLocalBlkCde) {
		this.eLocalBlkCde = eLocalBlkCde;
	}
	public String geteCardsFirstDigit() {
		return eCardsFirstDigit;
	}
	public void setECardsFirstDigit(String eCardsFirstDigit) {
		this.eCardsFirstDigit = eCardsFirstDigit;
	}
	public Date geteArrngNxtRenewDt() {
		return eArrngNxtRenewDt;
	}
	public void setEArrngNxtRenewDt(Date eArrngNxtRenewDt) {
		this.eArrngNxtRenewDt = eArrngNxtRenewDt;
	}
	public Integer geteArrngPastDueDayCount() {
		return eArrngPastDueDayCount;
	}

	public void setEArrngPastDueDayCount(Integer eArrngPastDueDayCount) {
		this.eArrngPastDueDayCount = eArrngPastDueDayCount;
	}

	public BigDecimal geteOriginalAmt() {
		return eOriginalAmt;
	}

	public void setEOriginalAmt(Double eOriginalAmt) {
		if (eOriginalAmt==null){
			this.eOriginalAmt = null;
		}
		else if(eOriginalAmt ==0){
			this.eOriginalAmt=new BigDecimal(0);	
		}
		else {
			this.eOriginalAmt = new BigDecimal(eOriginalAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	}

	public Date geteCredCrdBillCycDt() {
		return eCredCrdBillCycDt;
	}

	public void setECredCrdBillCycDt(Date eCredCrdBillCycDt) {
		this.eCredCrdBillCycDt = eCredCrdBillCycDt;
	}

	public String geteBaselPortId() {
		return eBaselPortId;
	}

	public void setEBaselPortId(String eBaselPortId) {
		this.eBaselPortId = eBaselPortId;
	}

	public Integer geteMonthsOnBooksLocal() {
		return eMonthsOnBooksLocal;
	}

	public void setEMonthsOnBooksLocal(Integer eMonthsOnBooksLocal) {
		this.eMonthsOnBooksLocal = eMonthsOnBooksLocal;
	}
	public Date geteRptMonthDate() {
		return eRptMonthDate;
	}
	public void setERptMonthDate(Date eRptMonthDate) {
		this.eRptMonthDate = eRptMonthDate;
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
	public BigDecimal getePctAmt() {
		return ePctAmt;
	}
	public void setEPctAmt(Double ePctAmt) {
		if (ePctAmt==null){
			this.ePctAmt = null;
		}
		else if(ePctAmt ==0){
			this.ePctAmt=new BigDecimal(0);	
		}
		else {
			this.ePctAmt = new BigDecimal(ePctAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}

	}
	public String geteInvPtySubTypeId() {
		return eInvPtySubTypeId;
	}
	public void setEInvPtySubTypeId(String eInvPtySubTypeId) {
		this.eInvPtySubTypeId = eInvPtySubTypeId;
	}

	
	public String geteRatingCode() {
		return eRatingCode;
	}

	public void setERatingCode(String eRatingCode) {
		this.eRatingCode = eRatingCode;
	}

	public String geteFicoEqvRatingCode() {
		return eFicoEqvRatingCode;
	}

	public void setEFicoEqvRatingCode(String eFicoEqvRatingCode) {
		this.eFicoEqvRatingCode = eFicoEqvRatingCode;
	}

	public String geteScoreReqReturnFlag() {
		return eScoreReqReturnFlag;
	}

	public void setEScoreReqReturnFlag(String eScoreReqReturnFlag) {
		this.eScoreReqReturnFlag = eScoreReqReturnFlag;
	}

	public Integer geteRateVarTypId() {
		return eRateVarTypId;
	}

	public void setERateVarTypId(Integer eRateVarTypId) {
		this.eRateVarTypId = eRateVarTypId;
	}

	public String geteRateTypId() {
		return eRateTypId;
	}

	public void setERateTypId(String eRateTypId) {
		this.eRateTypId = eRateTypId;
	}

	public Integer geteLegNumber() {
		return eLegNumber;
	}

	public void setELegNumber(Integer eLegNumber) {
		this.eLegNumber = eLegNumber;
	}

	public String geteBkingLedgCntryCde() {
		return eBkingLedgCntryCde;
	}

	public void setEBkingLedgCntryCde(String eBkingLedgCntryCde) {
		this.eBkingLedgCntryCde = eBkingLedgCntryCde;
	}

	public String geteTnxCurrency() {
		return eTnxCurrency;
	}

	public void setETnxCurrency(String eTnxCurrency) {
		this.eTnxCurrency = eTnxCurrency;
	}

	public String geteFuncCurcyCode() {
		return eFuncCurcyCode;
	}

	public void setEFuncCurcyCode(String eFuncCurcyCode) {
		this.eFuncCurcyCode = eFuncCurcyCode;
	}

	public String geteBaseCurcyCode() {
		return eBaseCurcyCode;
	}

	public void setEBaseCurcyCode(String eBaseCurcyCode) {
		this.eBaseCurcyCode = eBaseCurcyCode;
	}

	public String geteGAAPInd() {
		return eGAAPInd;
	}

	public void setEGAAPInd(String eGAAPInd) {
		this.eGAAPInd = eGAAPInd;
	}
	public Integer geteRatingEveReasTypId() {
		return eRatingEveReasTypId;
	}
	public void setERatingEveReasTypId(Integer eRatingEveReasTypId) {
		this.eRatingEveReasTypId = eRatingEveReasTypId;
	}
	/**
	 * @return the eEffRatePct
	 */
	public BigDecimal geteEffRatePct() {
		return eEffRatePct;
	}
	/**
	 * @param eEffRatePct the eEffRatePct to set
	 */
	public void setEEffRatePct(Double eEffRatePct) {
		if (eEffRatePct==null){
			this.eEffRatePct = null;
		}
		else if(eEffRatePct ==0){
			this.eEffRatePct=new BigDecimal(0);	
		}
		else {
			this.eEffRatePct = new BigDecimal(eEffRatePct).setScale(8,BigDecimal.ROUND_HALF_UP);
		}
	}
	/**
	 * @return the eRateActiveFlag
	 */
	public String geteRateActiveFlag() {
		return eRateActiveFlag;
	}
	/**
	 * @param eRateActiveFlag the eRateActiveFlag to set
	 */
	public void setERateActiveFlag(String eRateActiveFlag) {
		this.eRateActiveFlag = eRateActiveFlag;
	}
	public Date geteLstCredLmtChngDt() {
		return eLstCredLmtChngDt;
	}
	public void setELstCredLmtChngDt(Date eLstCredLmtChngDt) {
		this.eLstCredLmtChngDt = eLstCredLmtChngDt;
	}
	
	private Date lastCashTransactionDt;
	private Date lastRetailTransactionDt;
	private BigDecimal arrangementNextPaymentDue;
	private String lstReageDt;
	private Date lstCreditLimitChangeDt;
	private Date estimatedEndDate;
	private String localProductId;
	private String localSubProductId;
	private Date creditLimitEndDate;
	private String arrangementName;
	private String description;
	private String denominationCurrencyId;
	private String originatingChannelId;
	private String arrangementPurposeTypeId;
	private String pledgedIndicator;
	private String pledgeEligibilityIndicator;
	private String gracePeriodDayCount;
	private String arrangementPastDueAgingClassificationDate;
	private String arrangementFinancialStatusReasonTypeId;
	private String arrangementAcquisitionTypeId;
	private String arrangementDispositionTypeId;
	private String arrangementDispositionDate;
	private String originatororInvestorInsuredCategoryId;
	private String originatororInvestorInsuredActiveFlag;
	private BigDecimal originatororInvestorInsuredPercentage;
	private String previousorLastInterestRateResetDate;
	private String onlineBankingRelationshipIndicator;
	private String interestOnlyTermPeriod;
	private Date finServRestCurrentStatDate;
	private String finServPrevRestructureStatId;
	private String financeServiceRestructurePreviousStatusDate;
	private String eMktRateYieldAtRenegotiationFlag;
	private String overlimitIndicator;
	private String skipPaymentIndicator;
	private String securitizedIndicator;
	private String tRPPTenor;
	private String accountTRPPInstallmentAmount;
	private String incomeDocumentationTypeId;
	private String financeServiceModificationProgramStartDate;
	private String financeServiceModificationProgramEndDate;
	private String financeServiceModificationProgramId;
	private String financeServiceModificationProgramCurrentStatus;
	private String financeServiceModificationProgramCurrentStatusDate;
	private String financeServiceModificationProgramPreviousStatusTypeId;
	private String modificationRetentionorLossMitigationTypeId;
	private String creditFacilityRegulatorySegmentTypeId;
	private String creditCardPortfolioId1;
	private String creditCardPortfolioId2;
	private String creditCardPortfolioId3;
	private String creditCardTypeId1;
	private String creditCardTypeId2;
	private String noPresetSpendingLimitIndicator;
	private String creditLimitChangeTypeId;
	private String reageMethodType;
	private String aLOPStartDate;
	private String aLOPEndDate;
	private String previousALOPStartDate;
	private String previousALOPEndDate;
	private String lOPStartDate;
	private String lOPEndDate;
	private String previousLOPStartDate;
	private String previousLOPEndDate;
	private String ePPStartDate;
	private String ePPEndDate;
	private String previousEPPStartDate;
	private String previousEPPEndDate;
	private String arrangementNextPaymentDuetoBankDate;
	private String missedPaymentsNumber;
	private String nextMembershipFeePaymentDueDate;
	private String accountLastRecoveryDate;
	private String lastBalanceTransferDate;
	private String totalBalconTransactions;
	private String accountLastInstallmentDate;
	private String rewardCostPointEarned;
	private String rewardCostRate;
	private String lastCustomerServiceMinimumPaymentDueAdjustmentAmount;
	private String totalPayments;
	private String accountLastInterestReviewDate;
	private String totalALOPTransactions;
	private String totalLOPTransactions;
	private String totalEPPTransactions;
	private String otherAlternateIdentifier;
	private String previousAccountReasonTypeId;
	private String localProductCategoryCode;
	private String noticePeriodDays;
	private String creditLimitEventInitiationTypeId;
	private String bankruptcyDate;
	private String ePromoInterestRateEligibleFlag;
	private String originalUnadvisedUncommittedLimit;
	private String originalPurchaseLimit;
	private String originalCashLimit;
	private String pMACPortfolioID;
	private String originalAccountNumber;
	private String daysPastDueCycleEnd;
	private String reservedforfutureGenesisusage1;
	private String reservedforfutureGenesisusage2;
	private String reservedforfutureGenesisusage3;
	private String reservedforfutureGenesisusage4;
	private String reservedforfutureGenesisusage5;
	private String reservedforfutureGenesisusage6;
	private String reservedforfutureGenesisusage7;
	private String reservedforfutureGenesisusage8;
	private String reservedforfutureGenesisusage9;
	private String reservedforfutureGenesisusage10;
	private String reservedforfutureGenesisusage11;
	private String reservedforfutureGenesisusage12;
	private String reservedforfutureGenesisusage13;
	private String reservedforfutureGenesisusage14;
	private String reservedforfutureGenesisusage15;
	private String reservedforfutureGenesisusage16;
	private String reservedforfutureGenesisusage17;
	private String reservedforfutureGenesisusage18;
	private String reservedforfutureGenesisusage19;
	private String reservedforfutureGenesisusage20;
	private String reservedforfutureGenesisusage21;
	private BigDecimal creditLimitEventAmt;
	private String originalAdvisedCommittedLimit;


	
	public void seteInvPtySubTypeId(String eInvPtySubTypeId) {
		this.eInvPtySubTypeId = eInvPtySubTypeId;
	}
	public Date getLastCashTransactionDt() {
		return lastCashTransactionDt;
	}
	public void setLastCashTransactionDt(Date lastCashTransactionDt) {
		this.lastCashTransactionDt = lastCashTransactionDt;
	}
	public Date getLastRetailTransactionDt() {
		return lastRetailTransactionDt;
	}
	public void setLastRetailTransactionDt(Date lastRetailTransactionDt) {
		this.lastRetailTransactionDt = lastRetailTransactionDt;
	}
	public BigDecimal getArrangementNextPaymentDue() {
		return arrangementNextPaymentDue;
	}
	public void setArrangementNextPaymentDue(Double arrangementNextPaymentDue) {
		if (arrangementNextPaymentDue==null){
			this.arrangementNextPaymentDue = null;
		}
		else if(arrangementNextPaymentDue ==0){
			this.arrangementNextPaymentDue=new BigDecimal(0);	
		}
		else {
			this.arrangementNextPaymentDue = new BigDecimal(arrangementNextPaymentDue).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	}
	public String getLstReageDt() {
		return lstReageDt;
	}
	public void setLstReageDt(String lstReageDt) {
		this.lstReageDt = lstReageDt;
	}
	public Date getLstCreditLimitChangeDt() {
		return lstCreditLimitChangeDt;
	}
	public void setLstCreditLimitChangeDt(Date lstCreditLimitChangeDt) {
		this.lstCreditLimitChangeDt = lstCreditLimitChangeDt;
	}
	public Date getEstimatedEndDate() {
		return estimatedEndDate;
	}
	public void setEstimatedEndDate(Date estimatedEndDate) {
		this.estimatedEndDate = estimatedEndDate;
	}
	public String getLocalProductId() {
		return localProductId;
	}
	public void setLocalProductId(String localProductId) {
		this.localProductId = localProductId;
	}
	public String getLocalSubProductId() {
		return localSubProductId;
	}
	public void setLocalSubProductId(String localSubProductId) {
		this.localSubProductId = localSubProductId;
	}
	public Date getCreditLimitEndDate() {
		return creditLimitEndDate;
	}
	public void setCreditLimitEndDate(Date creditLimitEndDate) {
		this.creditLimitEndDate = creditLimitEndDate;
	}
	public String getDenominationCurrencyId() {
		return denominationCurrencyId;
	}
	public void setDenominationCurrencyId(String denominationCurrencyId) {
		this.denominationCurrencyId = denominationCurrencyId;
	}
	public String getOriginatingChannelId() {
		return originatingChannelId;
	}
	public void setOriginatingChannelId(String originatingChannelId) {
		this.originatingChannelId = originatingChannelId;
	}
	public String getArrangementPurposeTypeId() {
		return arrangementPurposeTypeId;
	}
	public void setArrangementPurposeTypeId(String arrangementPurposeTypeId) {
		this.arrangementPurposeTypeId = arrangementPurposeTypeId;
	}
	public String getPledgedIndicator() {
		return pledgedIndicator;
	}
	public void setPledgedIndicator(String pledgedIndicator) {
		this.pledgedIndicator = pledgedIndicator;
	}
	public String getPledgeEligibilityIndicator() {
		return pledgeEligibilityIndicator;
	}
	public void setPledgeEligibilityIndicator(String pledgeEligibilityIndicator) {
		this.pledgeEligibilityIndicator = pledgeEligibilityIndicator;
	}
	public String getGracePeriodDayCount() {
		return gracePeriodDayCount;
	}
	public void setGracePeriodDayCount(String gracePeriodDayCount) {
		this.gracePeriodDayCount = gracePeriodDayCount;
	}
	public String getArrangementPastDueAgingClassificationDate() {
		return arrangementPastDueAgingClassificationDate;
	}
	public void setArrangementPastDueAgingClassificationDate(
			String arrangementPastDueAgingClassificationDate) {
		this.arrangementPastDueAgingClassificationDate = arrangementPastDueAgingClassificationDate;
	}
	public String getArrangementFinancialStatusReasonTypeId() {
		return arrangementFinancialStatusReasonTypeId;
	}
	public void setArrangementFinancialStatusReasonTypeId(
			String arrangementFinancialStatusReasonTypeId) {
		this.arrangementFinancialStatusReasonTypeId = arrangementFinancialStatusReasonTypeId;
	}
	public String getArrangementAcquisitionTypeId() {
		return arrangementAcquisitionTypeId;
	}
	public void setArrangementAcquisitionTypeId(String arrangementAcquisitionTypeId) {
		this.arrangementAcquisitionTypeId = arrangementAcquisitionTypeId;
	}
	public String getArrangementDispositionTypeId() {
		return arrangementDispositionTypeId;
	}
	public void setArrangementDispositionTypeId(String arrangementDispositionTypeId) {
		this.arrangementDispositionTypeId = arrangementDispositionTypeId;
	}
	public String getArrangementDispositionDate() {
		return arrangementDispositionDate;
	}
	public void setArrangementDispositionDate(String arrangementDispositionDate) {
		this.arrangementDispositionDate = arrangementDispositionDate;
	}
	public String getOriginatororInvestorInsuredCategoryId() {
		return originatororInvestorInsuredCategoryId;
	}
	public void setOriginatororInvestorInsuredCategoryId(
			String originatororInvestorInsuredCategoryId) {
		this.originatororInvestorInsuredCategoryId = originatororInvestorInsuredCategoryId;
	}
	public String getOriginatororInvestorInsuredActiveFlag() {
		return originatororInvestorInsuredActiveFlag;
	}
	public void setOriginatororInvestorInsuredActiveFlag(
			String originatororInvestorInsuredActiveFlag) {
		this.originatororInvestorInsuredActiveFlag = originatororInvestorInsuredActiveFlag;
	}
	public BigDecimal getOriginatororInvestorInsuredPercentage() {
		return originatororInvestorInsuredPercentage;
	}
	public void setOriginatororInvestorInsuredPercentage(
			Double originatororInvestorInsuredPercentage) {
		if (originatororInvestorInsuredPercentage==null){
			this.originatororInvestorInsuredPercentage = null;
		}
		else if(originatororInvestorInsuredPercentage ==0){
			this.originatororInvestorInsuredPercentage=new BigDecimal(0);	
		}
		else {
			this.originatororInvestorInsuredPercentage = new BigDecimal(originatororInvestorInsuredPercentage).setScale(8,BigDecimal.ROUND_HALF_UP);
		}

	}
	public String getPreviousorLastInterestRateResetDate() {
		return previousorLastInterestRateResetDate;
	}
	public void setPreviousorLastInterestRateResetDate(
			String previousorLastInterestRateResetDate) {
		this.previousorLastInterestRateResetDate = previousorLastInterestRateResetDate;
	}
	public String getOnlineBankingRelationshipIndicator() {
		return onlineBankingRelationshipIndicator;
	}
	public void setOnlineBankingRelationshipIndicator(
			String onlineBankingRelationshipIndicator) {
		this.onlineBankingRelationshipIndicator = onlineBankingRelationshipIndicator;
	}
	public String getInterestOnlyTermPeriod() {
		return interestOnlyTermPeriod;
	}
	public void setInterestOnlyTermPeriod(String interestOnlyTermPeriod) {
		this.interestOnlyTermPeriod = interestOnlyTermPeriod;
	}
	
	public String getFinanceServiceRestructurePreviousStatusDate() {
		return financeServiceRestructurePreviousStatusDate;
	}
	public void setFinanceServiceRestructurePreviousStatusDate(
			String financeServiceRestructurePreviousStatusDate) {
		this.financeServiceRestructurePreviousStatusDate = financeServiceRestructurePreviousStatusDate;
	}
	public String geteMktRateYieldAtRenegotiationFlag() {
		return eMktRateYieldAtRenegotiationFlag;
	}
	public void setEMktRateYieldAtRenegotiationFlag(
			String eMktRateYieldAtRenegotiationFlag) {
		this.eMktRateYieldAtRenegotiationFlag = eMktRateYieldAtRenegotiationFlag;
	}
	public String getOverlimitIndicator() {
		return overlimitIndicator;
	}
	public void setOverlimitIndicator(String overlimitIndicator) {
		this.overlimitIndicator = overlimitIndicator;
	}
	public String getSkipPaymentIndicator() {
		return skipPaymentIndicator;
	}
	public void setSkipPaymentIndicator(String skipPaymentIndicator) {
		this.skipPaymentIndicator = skipPaymentIndicator;
	}
	public String getSecuritizedIndicator() {
		return securitizedIndicator;
	}
	public void setSecuritizedIndicator(String securitizedIndicator) {
		this.securitizedIndicator = securitizedIndicator;
	}
	public String gettRPPTenor() {
		return tRPPTenor;
	}
	public void settRPPTenor(String tRPPTenor) {
		this.tRPPTenor = tRPPTenor;
	}
	public String getAccountTRPPInstallmentAmount() {
		return accountTRPPInstallmentAmount;
	}
	public void setAccountTRPPInstallmentAmount(String accountTRPPInstallmentAmount) {
		this.accountTRPPInstallmentAmount = accountTRPPInstallmentAmount;
	}
	public String getIncomeDocumentationTypeId() {
		return incomeDocumentationTypeId;
	}
	public void setIncomeDocumentationTypeId(String incomeDocumentationTypeId) {
		this.incomeDocumentationTypeId = incomeDocumentationTypeId;
	}
	public String getFinanceServiceModificationProgramStartDate() {
		return financeServiceModificationProgramStartDate;
	}
	public void setFinanceServiceModificationProgramStartDate(
			String financeServiceModificationProgramStartDate) {
		this.financeServiceModificationProgramStartDate = financeServiceModificationProgramStartDate;
	}
	public String getFinanceServiceModificationProgramEndDate() {
		return financeServiceModificationProgramEndDate;
	}
	public void setFinanceServiceModificationProgramEndDate(
			String financeServiceModificationProgramEndDate) {
		this.financeServiceModificationProgramEndDate = financeServiceModificationProgramEndDate;
	}
	public String getFinanceServiceModificationProgramId() {
		return financeServiceModificationProgramId;
	}
	public void setFinanceServiceModificationProgramId(
			String financeServiceModificationProgramId) {
		this.financeServiceModificationProgramId = financeServiceModificationProgramId;
	}
	public String getFinanceServiceModificationProgramCurrentStatus() {
		return financeServiceModificationProgramCurrentStatus;
	}
	public void setFinanceServiceModificationProgramCurrentStatus(
			String financeServiceModificationProgramCurrentStatus) {
		this.financeServiceModificationProgramCurrentStatus = financeServiceModificationProgramCurrentStatus;
	}
	public String getFinanceServiceModificationProgramCurrentStatusDate() {
		return financeServiceModificationProgramCurrentStatusDate;
	}
	public void setFinanceServiceModificationProgramCurrentStatusDate(
			String financeServiceModificationProgramCurrentStatusDate) {
		this.financeServiceModificationProgramCurrentStatusDate = financeServiceModificationProgramCurrentStatusDate;
	}
	public String getFinanceServiceModificationProgramPreviousStatusTypeId() {
		return financeServiceModificationProgramPreviousStatusTypeId;
	}
	public void setFinanceServiceModificationProgramPreviousStatusTypeId(
			String financeServiceModificationProgramPreviousStatusTypeId) {
		this.financeServiceModificationProgramPreviousStatusTypeId = financeServiceModificationProgramPreviousStatusTypeId;
	}
	public String getModificationRetentionorLossMitigationTypeId() {
		return modificationRetentionorLossMitigationTypeId;
	}
	public void setModificationRetentionorLossMitigationTypeId(
			String modificationRetentionorLossMitigationTypeId) {
		this.modificationRetentionorLossMitigationTypeId = modificationRetentionorLossMitigationTypeId;
	}
	public String getCreditFacilityRegulatorySegmentTypeId() {
		return creditFacilityRegulatorySegmentTypeId;
	}
	public void setCreditFacilityRegulatorySegmentTypeId(
			String creditFacilityRegulatorySegmentTypeId) {
		this.creditFacilityRegulatorySegmentTypeId = creditFacilityRegulatorySegmentTypeId;
	}
	public String getCreditCardPortfolioId1() {
		return creditCardPortfolioId1;
	}
	public void setCreditCardPortfolioId1(String creditCardPortfolioId1) {
		this.creditCardPortfolioId1 = creditCardPortfolioId1;
	}
	public String getCreditCardPortfolioId2() {
		return creditCardPortfolioId2;
	}
	public void setCreditCardPortfolioId2(String creditCardPortfolioId2) {
		this.creditCardPortfolioId2 = creditCardPortfolioId2;
	}
	public String getCreditCardPortfolioId3() {
		return creditCardPortfolioId3;
	}
	public void setCreditCardPortfolioId3(String creditCardPortfolioId3) {
		this.creditCardPortfolioId3 = creditCardPortfolioId3;
	}
	public String getCreditCardTypeId1() {
		return creditCardTypeId1;
	}
	public void setCreditCardTypeId1(String creditCardTypeId1) {
		this.creditCardTypeId1 = creditCardTypeId1;
	}
	public String getCreditCardTypeId2() {
		return creditCardTypeId2;
	}
	public void setCreditCardTypeId2(String creditCardTypeId2) {
		this.creditCardTypeId2 = creditCardTypeId2;
	}
	public String getNoPresetSpendingLimitIndicator() {
		return noPresetSpendingLimitIndicator;
	}
	public void setNoPresetSpendingLimitIndicator(
			String noPresetSpendingLimitIndicator) {
		this.noPresetSpendingLimitIndicator = noPresetSpendingLimitIndicator;
	}
	public String getCreditLimitChangeTypeId() {
		return creditLimitChangeTypeId;
	}
	public void setCreditLimitChangeTypeId(String creditLimitChangeTypeId) {
		this.creditLimitChangeTypeId = creditLimitChangeTypeId;
	}
	public String getReageMethodType() {
		return reageMethodType;
	}
	public void setReageMethodType(String reageMethodType) {
		this.reageMethodType = reageMethodType;
	}
	public String getaLOPStartDate() {
		return aLOPStartDate;
	}
	public void setaLOPStartDate(String aLOPStartDate) {
		this.aLOPStartDate = aLOPStartDate;
	}
	public String getaLOPEndDate() {
		return aLOPEndDate;
	}
	public void setaLOPEndDate(String aLOPEndDate) {
		this.aLOPEndDate = aLOPEndDate;
	}
	public String getPreviousALOPStartDate() {
		return previousALOPStartDate;
	}
	public void setPreviousALOPStartDate(String previousALOPStartDate) {
		this.previousALOPStartDate = previousALOPStartDate;
	}
	public String getPreviousALOPEndDate() {
		return previousALOPEndDate;
	}
	public void setPreviousALOPEndDate(String previousALOPEndDate) {
		this.previousALOPEndDate = previousALOPEndDate;
	}
	public String getlOPStartDate() {
		return lOPStartDate;
	}
	public void setlOPStartDate(String lOPStartDate) {
		this.lOPStartDate = lOPStartDate;
	}
	public String getlOPEndDate() {
		return lOPEndDate;
	}
	public void setlOPEndDate(String lOPEndDate) {
		this.lOPEndDate = lOPEndDate;
	}
	public String getPreviousLOPStartDate() {
		return previousLOPStartDate;
	}
	public void setPreviousLOPStartDate(String previousLOPStartDate) {
		this.previousLOPStartDate = previousLOPStartDate;
	}
	public String getPreviousLOPEndDate() {
		return previousLOPEndDate;
	}
	public void setPreviousLOPEndDate(String previousLOPEndDate) {
		this.previousLOPEndDate = previousLOPEndDate;
	}
	public String getePPStartDate() {
		return ePPStartDate;
	}
	public void setePPStartDate(String ePPStartDate) {
		this.ePPStartDate = ePPStartDate;
	}
	public String getePPEndDate() {
		return ePPEndDate;
	}
	public void setePPEndDate(String ePPEndDate) {
		this.ePPEndDate = ePPEndDate;
	}
	public String getPreviousEPPStartDate() {
		return previousEPPStartDate;
	}
	public void setPreviousEPPStartDate(String previousEPPStartDate) {
		this.previousEPPStartDate = previousEPPStartDate;
	}
	public String getPreviousEPPEndDate() {
		return previousEPPEndDate;
	}
	public void setPreviousEPPEndDate(String previousEPPEndDate) {
		this.previousEPPEndDate = previousEPPEndDate;
	}
	public String getArrangementNextPaymentDuetoBankDate() {
		return arrangementNextPaymentDuetoBankDate;
	}
	public void setArrangementNextPaymentDuetoBankDate(
			String arrangementNextPaymentDuetoBankDate) {
		this.arrangementNextPaymentDuetoBankDate = arrangementNextPaymentDuetoBankDate;
	}
	public String getMissedPaymentsNumber() {
		return missedPaymentsNumber;
	}
	public void setMissedPaymentsNumber(String missedPaymentsNumber) {
		this.missedPaymentsNumber = missedPaymentsNumber;
	}
	public String getNextMembershipFeePaymentDueDate() {
		return nextMembershipFeePaymentDueDate;
	}
	public void setNextMembershipFeePaymentDueDate(
			String nextMembershipFeePaymentDueDate) {
		this.nextMembershipFeePaymentDueDate = nextMembershipFeePaymentDueDate;
	}
	public String getAccountLastRecoveryDate() {
		return accountLastRecoveryDate;
	}
	public void setAccountLastRecoveryDate(String accountLastRecoveryDate) {
		this.accountLastRecoveryDate = accountLastRecoveryDate;
	}
	public String getLastBalanceTransferDate() {
		return lastBalanceTransferDate;
	}
	public void setLastBalanceTransferDate(String lastBalanceTransferDate) {
		this.lastBalanceTransferDate = lastBalanceTransferDate;
	}
	public String getTotalBalconTransactions() {
		return totalBalconTransactions;
	}
	public void setTotalBalconTransactions(String totalBalconTransactions) {
		this.totalBalconTransactions = totalBalconTransactions;
	}
	public String getAccountLastInstallmentDate() {
		return accountLastInstallmentDate;
	}
	public void setAccountLastInstallmentDate(String accountLastInstallmentDate) {
		this.accountLastInstallmentDate = accountLastInstallmentDate;
	}
	public String getRewardCostPointEarned() {
		return rewardCostPointEarned;
	}
	public void setRewardCostPointEarned(String rewardCostPointEarned) {
		this.rewardCostPointEarned = rewardCostPointEarned;
	}
	public String getRewardCostRate() {
		return rewardCostRate;
	}
	public void setRewardCostRate(String rewardCostRate) {
		this.rewardCostRate = rewardCostRate;
	}
	public String getLastCustomerServiceMinimumPaymentDueAdjustmentAmount() {
		return lastCustomerServiceMinimumPaymentDueAdjustmentAmount;
	}
	public void setLastCustomerServiceMinimumPaymentDueAdjustmentAmount(
			String lastCustomerServiceMinimumPaymentDueAdjustmentAmount) {
		this.lastCustomerServiceMinimumPaymentDueAdjustmentAmount = lastCustomerServiceMinimumPaymentDueAdjustmentAmount;
	}
	public String getTotalPayments() {
		return totalPayments;
	}
	public void setTotalPayments(String totalPayments) {
		this.totalPayments = totalPayments;
	}
	public String getAccountLastInterestReviewDate() {
		return accountLastInterestReviewDate;
	}
	public void setAccountLastInterestReviewDate(
			String accountLastInterestReviewDate) {
		this.accountLastInterestReviewDate = accountLastInterestReviewDate;
	}
	public String getTotalALOPTransactions() {
		return totalALOPTransactions;
	}
	public void setTotalALOPTransactions(String totalALOPTransactions) {
		this.totalALOPTransactions = totalALOPTransactions;
	}
	public String getTotalLOPTransactions() {
		return totalLOPTransactions;
	}
	public void setTotalLOPTransactions(String totalLOPTransactions) {
		this.totalLOPTransactions = totalLOPTransactions;
	}
	public String getTotalEPPTransactions() {
		return totalEPPTransactions;
	}
	public void setTotalEPPTransactions(String totalEPPTransactions) {
		this.totalEPPTransactions = totalEPPTransactions;
	}
	public String getOtherAlternateIdentifier() {
		return otherAlternateIdentifier;
	}
	public void setOtherAlternateIdentifier(String otherAlternateIdentifier) {
		this.otherAlternateIdentifier = otherAlternateIdentifier;
	}
	public String getPreviousAccountReasonTypeId() {
		return previousAccountReasonTypeId;
	}
	public void setPreviousAccountReasonTypeId(String previousAccountReasonTypeId) {
		this.previousAccountReasonTypeId = previousAccountReasonTypeId;
	}
	public String getLocalProductCategoryCode() {
		return localProductCategoryCode;
	}
	public void setLocalProductCategoryCode(String localProductCategoryCode) {
		this.localProductCategoryCode = localProductCategoryCode;
	}
	public String getNoticePeriodDays() {
		return noticePeriodDays;
	}
	public void setNoticePeriodDays(String noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
	}
	public String getCreditLimitEventInitiationTypeId() {
		return creditLimitEventInitiationTypeId;
	}
	public void setCreditLimitEventInitiationTypeId(
			String creditLimitEventInitiationTypeId) {
		this.creditLimitEventInitiationTypeId = creditLimitEventInitiationTypeId;
	}
	public String getBankruptcyDate() {
		return bankruptcyDate;
	}
	public void setBankruptcyDate(String bankruptcyDate) {
		this.bankruptcyDate = bankruptcyDate;
	}
	public String getePromoInterestRateEligibleFlag() {
		return ePromoInterestRateEligibleFlag;
	}
	public void setEPromoInterestRateEligibleFlag(
			String ePromoInterestRateEligibleFlag) {
		this.ePromoInterestRateEligibleFlag = ePromoInterestRateEligibleFlag;
	}
	public String getOriginalUnadvisedUncommittedLimit() {
		return originalUnadvisedUncommittedLimit;
	}
	public void setOriginalUnadvisedUncommittedLimit(
			String originalUnadvisedUncommittedLimit) {
		this.originalUnadvisedUncommittedLimit = originalUnadvisedUncommittedLimit;
	}
	public String getOriginalPurchaseLimit() {
		return originalPurchaseLimit;
	}
	public void setOriginalPurchaseLimit(String originalPurchaseLimit) {
		this.originalPurchaseLimit = originalPurchaseLimit;
	}
	public String getOriginalCashLimit() {
		return originalCashLimit;
	}
	public void setOriginalCashLimit(String originalCashLimit) {
		this.originalCashLimit = originalCashLimit;
	}
	public String getpMACPortfolioID() {
		return pMACPortfolioID;
	}
	public void setpMACPortfolioID(String pMACPortfolioID) {
		this.pMACPortfolioID = pMACPortfolioID;
	}
	public String getOriginalAccountNumber() {
		return originalAccountNumber;
	}
	public void setOriginalAccountNumber(String originalAccountNumber) {
		this.originalAccountNumber = originalAccountNumber;
	}
	public String getDaysPastDueCycleEnd() {
		return daysPastDueCycleEnd;
	}
	public void setDaysPastDueCycleEnd(String daysPastDueCycleEnd) {
		this.daysPastDueCycleEnd = daysPastDueCycleEnd;
	}
	public String getReservedforfutureGenesisusage1() {
		return reservedforfutureGenesisusage1;
	}
	public void setReservedforfutureGenesisusage1(
			String reservedforfutureGenesisusage1) {
		this.reservedforfutureGenesisusage1 = reservedforfutureGenesisusage1;
	}
	public String getReservedforfutureGenesisusage2() {
		return reservedforfutureGenesisusage2;
	}
	public void setReservedforfutureGenesisusage2(
			String reservedforfutureGenesisusage2) {
		this.reservedforfutureGenesisusage2 = reservedforfutureGenesisusage2;
	}
	public String getReservedforfutureGenesisusage3() {
		return reservedforfutureGenesisusage3;
	}
	public void setReservedforfutureGenesisusage3(
			String reservedforfutureGenesisusage3) {
		this.reservedforfutureGenesisusage3 = reservedforfutureGenesisusage3;
	}
	public String getReservedforfutureGenesisusage4() {
		return reservedforfutureGenesisusage4;
	}
	public void setReservedforfutureGenesisusage4(
			String reservedforfutureGenesisusage4) {
		this.reservedforfutureGenesisusage4 = reservedforfutureGenesisusage4;
	}
	public String getReservedforfutureGenesisusage5() {
		return reservedforfutureGenesisusage5;
	}
	public void setReservedforfutureGenesisusage5(
			String reservedforfutureGenesisusage5) {
		this.reservedforfutureGenesisusage5 = reservedforfutureGenesisusage5;
	}
	public String getReservedforfutureGenesisusage6() {
		return reservedforfutureGenesisusage6;
	}
	public void setReservedforfutureGenesisusage6(
			String reservedforfutureGenesisusage6) {
		this.reservedforfutureGenesisusage6 = reservedforfutureGenesisusage6;
	}
	public String getReservedforfutureGenesisusage7() {
		return reservedforfutureGenesisusage7;
	}
	public void setReservedforfutureGenesisusage7(
			String reservedforfutureGenesisusage7) {
		this.reservedforfutureGenesisusage7 = reservedforfutureGenesisusage7;
	}
	public String getReservedforfutureGenesisusage8() {
		return reservedforfutureGenesisusage8;
	}
	public void setReservedforfutureGenesisusage8(
			String reservedforfutureGenesisusage8) {
		this.reservedforfutureGenesisusage8 = reservedforfutureGenesisusage8;
	}
	public String getReservedforfutureGenesisusage9() {
		return reservedforfutureGenesisusage9;
	}
	public void setReservedforfutureGenesisusage9(
			String reservedforfutureGenesisusage9) {
		this.reservedforfutureGenesisusage9 = reservedforfutureGenesisusage9;
	}
	public String getReservedforfutureGenesisusage10() {
		return reservedforfutureGenesisusage10;
	}
	public void setReservedforfutureGenesisusage10(
			String reservedforfutureGenesisusage10) {
		this.reservedforfutureGenesisusage10 = reservedforfutureGenesisusage10;
	}
	public String getReservedforfutureGenesisusage11() {
		return reservedforfutureGenesisusage11;
	}
	public void setReservedforfutureGenesisusage11(
			String reservedforfutureGenesisusage11) {
		this.reservedforfutureGenesisusage11 = reservedforfutureGenesisusage11;
	}
	public String getReservedforfutureGenesisusage12() {
		return reservedforfutureGenesisusage12;
	}
	public void setReservedforfutureGenesisusage12(
			String reservedforfutureGenesisusage12) {
		this.reservedforfutureGenesisusage12 = reservedforfutureGenesisusage12;
	}
	public String getReservedforfutureGenesisusage13() {
		return reservedforfutureGenesisusage13;
	}
	public void setReservedforfutureGenesisusage13(
			String reservedforfutureGenesisusage13) {
		this.reservedforfutureGenesisusage13 = reservedforfutureGenesisusage13;
	}
	public String getReservedforfutureGenesisusage14() {
		return reservedforfutureGenesisusage14;
	}
	public void setReservedforfutureGenesisusage14(
			String reservedforfutureGenesisusage14) {
		this.reservedforfutureGenesisusage14 = reservedforfutureGenesisusage14;
	}
	public String getReservedforfutureGenesisusage15() {
		return reservedforfutureGenesisusage15;
	}
	public void setReservedforfutureGenesisusage15(
			String reservedforfutureGenesisusage15) {
		this.reservedforfutureGenesisusage15 = reservedforfutureGenesisusage15;
	}
	public String getReservedforfutureGenesisusage16() {
		return reservedforfutureGenesisusage16;
	}
	public void setReservedforfutureGenesisusage16(
			String reservedforfutureGenesisusage16) {
		this.reservedforfutureGenesisusage16 = reservedforfutureGenesisusage16;
	}
	public String getReservedforfutureGenesisusage17() {
		return reservedforfutureGenesisusage17;
	}
	public void setReservedforfutureGenesisusage17(
			String reservedforfutureGenesisusage17) {
		this.reservedforfutureGenesisusage17 = reservedforfutureGenesisusage17;
	}
	public String getReservedforfutureGenesisusage18() {
		return reservedforfutureGenesisusage18;
	}
	public void setReservedforfutureGenesisusage18(
			String reservedforfutureGenesisusage18) {
		this.reservedforfutureGenesisusage18 = reservedforfutureGenesisusage18;
	}
	public String getReservedforfutureGenesisusage19() {
		return reservedforfutureGenesisusage19;
	}
	public void setReservedforfutureGenesisusage19(
			String reservedforfutureGenesisusage19) {
		this.reservedforfutureGenesisusage19 = reservedforfutureGenesisusage19;
	}
	public String getReservedforfutureGenesisusage20() {
		return reservedforfutureGenesisusage20;
	}
	public void setReservedforfutureGenesisusage20(
			String reservedforfutureGenesisusage20) {
		this.reservedforfutureGenesisusage20 = reservedforfutureGenesisusage20;
	}
	public String getReservedforfutureGenesisusage21() {
		return reservedforfutureGenesisusage21;
	}
	public void setReservedforfutureGenesisusage21(
			String reservedforfutureGenesisusage21) {
		this.reservedforfutureGenesisusage21 = reservedforfutureGenesisusage21;
	}
	public BigDecimal getCreditLimitEventAmt() {
		return creditLimitEventAmt;
	}
	public void setCreditLimitEventAmt(Double creditLimitEventAmt) {
		if (creditLimitEventAmt==null){
			this.creditLimitEventAmt = null;
		}
		else if(creditLimitEventAmt ==0){
			this.creditLimitEventAmt=new BigDecimal(0);	
		}
		else {
			this.creditLimitEventAmt = new BigDecimal(creditLimitEventAmt).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}
	public String getOriginalAdvisedCommittedLimit() {
		return originalAdvisedCommittedLimit;
	}
	public void setOriginalAdvisedCommittedLimit(
			String originalAdvisedUncommittedLimit) {
		this.originalAdvisedCommittedLimit = originalAdvisedUncommittedLimit;
	}
	public void seteSrcSysId(String eSrcSysId) {
		this.eSrcSysId = eSrcSysId;
	}
	public void seteProdSysId(String eProdSysId) {
		this.eProdSysId = eProdSysId;
	}
	public void seteRecType(String eRecType) {
		this.eRecType = eRecType;
	}
	public void seteRatingIssuerId(String eRatingIssuerId) {
		this.eRatingIssuerId = eRatingIssuerId;
	}
	public void seteModelCode(String eModelCode) {
		this.eModelCode = eModelCode;
	}
	public void seteRatingReasonId(Integer eRatingReasonId) {
		this.eRatingReasonId = eRatingReasonId;
	}
	public void seteRank(Integer eRank) {
		this.eRank = eRank;
	}
	public void seteEffDate(Date eEffDate) {
		this.eEffDate = eEffDate;
	}
	public void seteEndDate(Date eEndDate) {
		this.eEndDate = eEndDate;
	}
	public void seteRptMonthDate(Date eRptMonthDate) {
		this.eRptMonthDate = eRptMonthDate;
	}
	public void seteFicoScore(Long eFicoScore) {
		this.eFicoScore = eFicoScore;
	}
	public void seteRatingDesc(String eRatingDesc) {
		this.eRatingDesc = eRatingDesc;
	}
	public void seteScoreReturnFlag(String eScoreReturnFlag) {
		this.eScoreReturnFlag = eScoreReturnFlag;
	}
	public void seteArrangementRoleType(String eArrangementRoleType) {
		this.eArrangementRoleType = eArrangementRoleType;
	}
	public void setePercentAmount(Double ePercentAmount) {
		this.ePercentAmount = ePercentAmount;
	}
	public void seteInvolvedPartySubtypeId(String eInvolvedPartySubtypeId) {
		this.eInvolvedPartySubtypeId = eInvolvedPartySubtypeId;
	}
	public void seteGlbProdId(String eGlbProdId) {
		this.eGlbProdId = eGlbProdId;
	}
	public void seteEntProdId(String eEntProdId) {
		this.eEntProdId = eEntProdId;
	}
	public void seteStdArrgId(String eStdArrgId) {
		this.eStdArrgId = eStdArrgId;
	}
	public void seteOrgEffDate(Date eOrgEffDate) {
		this.eOrgEffDate = eOrgEffDate;
	}
	public void seteDenCurrencyId(String eDenCurrencyId) {
		this.eDenCurrencyId = eDenCurrencyId;
	}
	public void seteOrigChnlId(Integer eOrigChnlId) {
		this.eOrigChnlId = eOrigChnlId;
	}
	public void seteArrngPurpTypeId(Integer eArrngPurpTypeId) {
		this.eArrngPurpTypeId = eArrngPurpTypeId;
	}
	public void seteArrngBusIntType(Integer eArrngBusIntType) {
		this.eArrngBusIntType = eArrngBusIntType;
	}
	public void seteArrngBussIntDate(Date eArrngBussIntDate) {
		this.eArrngBussIntDate = eArrngBussIntDate;
	}
	public void setePledgInd(String ePledgInd) {
		this.ePledgInd = ePledgInd;
	}
	public void setePledgEligInd(String ePledgEligInd) {
		this.ePledgEligInd = ePledgEligInd;
	}
	public void seteArrngMatuTypeId(Integer eArrngMatuTypeId) {
		this.eArrngMatuTypeId = eArrngMatuTypeId;
	}
	public void seteArrngFinStatTypId(Integer eArrngFinStatTypId) {
		this.eArrngFinStatTypId = eArrngFinStatTypId;
	}
	public void seteArrngFinStatDate(Date eArrngFinStatDate) {
		this.eArrngFinStatDate = eArrngFinStatDate;
	}
	public void seteGracePeriodDayCnt(Integer eGracePeriodDayCnt) {
		this.eGracePeriodDayCnt = eGracePeriodDayCnt;
	}
	public void seteArrngPastDueAgeClass(Integer eArrngPastDueAgeClass) {
		this.eArrngPastDueAgeClass = eArrngPastDueAgeClass;
	}
	public void seteArrngLifCycStat(Integer eArrngLifCycStat) {
		this.eArrngLifCycStat = eArrngLifCycStat;
	}
	public void seteArrngLifCycStatReasonTypId(Integer eArrngLifCycStatReasonTypId) {
		this.eArrngLifCycStatReasonTypId = eArrngLifCycStatReasonTypId;
	}
	public void seteArrngPrimPayTypeId(Integer eArrngPrimPayTypeId) {
		this.eArrngPrimPayTypeId = eArrngPrimPayTypeId;
	}
	public void seteAccTypId(Integer eAccTypId) {
		this.eAccTypId = eAccTypId;
	}
	public void seteArrngAcqTypId(Integer eArrngAcqTypId) {
		this.eArrngAcqTypId = eArrngAcqTypId;
	}
	public void seteArrngAcqDt(Date eArrngAcqDt) {
		this.eArrngAcqDt = eArrngAcqDt;
	}
	public void seteChrgOffTypId(Integer eChrgOffTypId) {
		this.eChrgOffTypId = eChrgOffTypId;
	}
	public void seteOrigInsuredCatId(Integer eOrigInsuredCatId) {
		this.eOrigInsuredCatId = eOrigInsuredCatId;
	}
	public void seteOrigInsuredPct(Double eOrigInsuredPct) {
		this.eOrigInsuredPct = eOrigInsuredPct;
	}
	public void seteArrngDayCntConvTypId(Integer eArrngDayCntConvTypId) {
		this.eArrngDayCntConvTypId = eArrngDayCntConvTypId;
	}
	public void seteIntrBasCalcPerId(Integer eIntrBasCalcPerId) {
		this.eIntrBasCalcPerId = eIntrBasCalcPerId;
	}
	public void seteIntrPayFreqPeriodId(Integer eIntrPayFreqPeriodId) {
		this.eIntrPayFreqPeriodId = eIntrPayFreqPeriodId;
	}
	public void seteRateResetPerodInterId(Integer eRateResetPerodInterId) {
		this.eRateResetPerodInterId = eRateResetPerodInterId;
	}
	public void seteInitIntrestRateResetDt(Date eInitIntrestRateResetDt) {
		this.eInitIntrestRateResetDt = eInitIntrestRateResetDt;
	}
	public void seteNxtIntrRateResetDate(Date eNxtIntrRateResetDate) {
		this.eNxtIntrRateResetDate = eNxtIntrRateResetDate;
	}
	public void seteIslamicAccInd(String eIslamicAccInd) {
		this.eIslamicAccInd = eIslamicAccInd;
	}
	public void seteTaxExemptInd(String eTaxExemptInd) {
		this.eTaxExemptInd = eTaxExemptInd;
	}
	public void seteFinServiceTypId(Integer eFinServiceTypId) {
		this.eFinServiceTypId = eFinServiceTypId;
	}
	public void seteFinServiceLimitTypId(Integer eFinServiceLimitTypId) {
		this.eFinServiceLimitTypId = eFinServiceLimitTypId;
	}
	public void seteArrngSecurTypeId(Integer eArrngSecurTypeId) {
		this.eArrngSecurTypeId = eArrngSecurTypeId;
	}
	public void seteCitiRecourseInd(String eCitiRecourseInd) {
		this.eCitiRecourseInd = eCitiRecourseInd;
	}
	public void setePaymentFreqPeriodId(Integer ePaymentFreqPeriodId) {
		this.ePaymentFreqPeriodId = ePaymentFreqPeriodId;
	}
	public void seteCurrFinServicePrinRepayTypId(
			Integer eCurrFinServicePrinRepayTypId) {
		this.eCurrFinServicePrinRepayTypId = eCurrFinServicePrinRepayTypId;
	}
	public void seteIntrstAccrualStatTypId(Integer eIntrstAccrualStatTypId) {
		this.eIntrstAccrualStatTypId = eIntrstAccrualStatTypId;
	}
	public void seteIntrstAccrualStatTypDt(Date eIntrstAccrualStatTypDt) {
		this.eIntrstAccrualStatTypDt = eIntrstAccrualStatTypDt;
	}
	public void seteFinanceServRestCurrStatDate(Date eFinanceServRestCurrStatDate) {
		this.eFinanceServRestCurrStatDate = eFinanceServRestCurrStatDate;
	}
	public void seteFinanceServRestCurrStatId(Integer eFinanceServRestCurrStatId) {
		this.eFinanceServRestCurrStatId = eFinanceServRestCurrStatId;
	}
	public void seteTroubledDebtRestructFlag(String eTroubledDebtRestructFlag) {
		this.eTroubledDebtRestructFlag = eTroubledDebtRestructFlag;
	}
	public void seteOverLimInd(String eOverLimInd) {
		this.eOverLimInd = eOverLimInd;
	}
	public void seteSkipPayInd(String eSkipPayInd) {
		this.eSkipPayInd = eSkipPayInd;
	}
	public void seteSecurizedInd(String eSecurizedInd) {
		this.eSecurizedInd = eSecurizedInd;
	}
	public void seteLOCAutExtFlag(String eLOCAutExtFlag) {
		this.eLOCAutExtFlag = eLOCAutExtFlag;
	}
	public void seteLOCTermLoanConFlag(String eLOCTermLoanConFlag) {
		this.eLOCTermLoanConFlag = eLOCTermLoanConFlag;
	}
	public void seteCreditDeviationInd(String eCreditDeviationInd) {
		this.eCreditDeviationInd = eCreditDeviationInd;
	}
	public void seteFinServiceModReasTypId(Integer eFinServiceModReasTypId) {
		this.eFinServiceModReasTypId = eFinServiceModReasTypId;
	}
	public void seteCreditFacTypId(Integer eCreditFacTypId) {
		this.eCreditFacTypId = eCreditFacTypId;
	}
	public void seteFacLegStatTypId(Integer eFacLegStatTypId) {
		this.eFacLegStatTypId = eFacLegStatTypId;
	}
	public void seteFacilityLegStatDt(Date eFacilityLegStatDt) {
		this.eFacilityLegStatDt = eFacilityLegStatDt;
	}
	public void seteCreditFacArrngAppTypId(Integer eCreditFacArrngAppTypId) {
		this.eCreditFacArrngAppTypId = eCreditFacArrngAppTypId;
	}
	public void seteCredFacArrngAppDt(Date eCredFacArrngAppDt) {
		this.eCredFacArrngAppDt = eCredFacArrngAppDt;
	}
	public void seteCreditFacAvailStatTypId(Integer eCreditFacAvailStatTypId) {
		this.eCreditFacAvailStatTypId = eCreditFacAvailStatTypId;
	}
	public void seteAssocAffCode(String eAssocAffCode) {
		this.eAssocAffCode = eAssocAffCode;
	}
	public void seteCredCrdClassTyp(Integer eCredCrdClassTyp) {
		this.eCredCrdClassTyp = eCredCrdClassTyp;
	}
	public void seteCredCardTypId(Integer eCredCardTypId) {
		this.eCredCardTypId = eCredCardTypId;
	}
	public void seteCredLimChngTypId(Integer eCredLimChngTypId) {
		this.eCredLimChngTypId = eCredLimChngTypId;
	}
	public void seteReissueFlag(String eReissueFlag) {
		this.eReissueFlag = eReissueFlag;
	}
	public void seteAccLastRecDate(Date eAccLastRecDate) {
		this.eAccLastRecDate = eAccLastRecDate;
	}
	public void seteTotCashTxn(Integer eTotCashTxn) {
		this.eTotCashTxn = eTotCashTxn;
	}
	public void seteTotPurchaseTxn(Integer eTotPurchaseTxn) {
		this.eTotPurchaseTxn = eTotPurchaseTxn;
	}
	public void setePenaltyRate(Double ePenaltyRate) {
		this.ePenaltyRate = ePenaltyRate;
	}
	public void setePenaltyAmt(Double ePenaltyAmt) {
		this.ePenaltyAmt = ePenaltyAmt;
	}
	public void seteLegalNotificationDays(Integer eLegalNotificationDays) {
		this.eLegalNotificationDays = eLegalNotificationDays;
	}
	public void seteDelq30pst2yrsFlag(String eDelq30pst2yrsFlag) {
		this.eDelq30pst2yrsFlag = eDelq30pst2yrsFlag;
	}
	public void seteLienPositTypId(Integer eLienPositTypId) {
		this.eLienPositTypId = eLienPositTypId;
	}
	public void seteActualBillingCycDt(Date eActualBillingCycDt) {
		this.eActualBillingCycDt = eActualBillingCycDt;
	}
	public void seteFeePayFreqPeriodId(Integer eFeePayFreqPeriodId) {
		this.eFeePayFreqPeriodId = eFeePayFreqPeriodId;
	}
	public void seteCCARProdCode(String eCCARProdCode) {
		this.eCCARProdCode = eCCARProdCode;
	}
	public void setePromoIntRateEligFlag(String ePromoIntRateEligFlag) {
		this.ePromoIntRateEligFlag = ePromoIntRateEligFlag;
	}
	public void seteOrigAdvisedUncomLimit(Double eOrigAdvisedUncomLimit) {
		if (eOrigAdvisedUncomLimit==null){
			this.eOrigAdvisedUncomLimit = null;
		}
		else if(eOrigAdvisedUncomLimit ==0){
			this.eOrigAdvisedUncomLimit=new BigDecimal(0);	
		}
		else {
			this.eOrigAdvisedUncomLimit = new BigDecimal(eOrigAdvisedUncomLimit).setScale(10,BigDecimal.ROUND_HALF_UP);
		}

	}
	public void seteRestructureFlag(String eRestructureFlag) {
		this.eRestructureFlag = eRestructureFlag;
	}
	public void seteLastWritDwnDt(Date eLastWritDwnDt) {
		this.eLastWritDwnDt = eLastWritDwnDt;
	}
	public void seteRiskManagInd(String eRiskManagInd) {
		this.eRiskManagInd = eRiskManagInd;
	}
	public void seteDelqBucket(Integer eDelqBucket) {
		this.eDelqBucket = eDelqBucket;
	}
	public void seteUniqueId(String eUniqueId) {
		this.eUniqueId = eUniqueId;
	}
	public void seteBookingDate(Date eBookingDate) {
		this.eBookingDate = eBookingDate;
	}
	public void seteArrngLifCycStatDate(Date eArrngLifCycStatDate) {
		this.eArrngLifCycStatDate = eArrngLifCycStatDate;
	}
	public void seteCredCardPortfolioId(Integer eCredCardPortfolioId) {
		this.eCredCardPortfolioId = eCredCardPortfolioId;
	}
	public void seteNumOfAddCards(Integer eNumOfAddCards) {
		this.eNumOfAddCards = eNumOfAddCards;
	}
	public void seteArrngLstPayToBnkDt(Date eArrngLstPayToBnkDt) {
		this.eArrngLstPayToBnkDt = eArrngLstPayToBnkDt;
	}
	public void seteAccLstPayToBnkAmt(Double eAccLstPayToBnkAmt) {
		if (eAccLstPayToBnkAmt==null){
			this.eAccLstPayToBnkAmt = null;
		}
		else if(eAccLstPayToBnkAmt ==0){
			this.eAccLstPayToBnkAmt=new BigDecimal(0);	
		}
		else {
			this.eAccLstPayToBnkAmt = new BigDecimal(eAccLstPayToBnkAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	}
	public void seteLocalBlkCde(String eLocalBlkCde) {
		this.eLocalBlkCde = eLocalBlkCde;
	}
	public void seteCardsFirstDigit(String eCardsFirstDigit) {
		this.eCardsFirstDigit = eCardsFirstDigit;
	}
	public void seteArrngPastDueDayCount(Integer eArrngPastDueDayCount) {
		this.eArrngPastDueDayCount = eArrngPastDueDayCount;
	}
	public void seteArrngNxtRenewDt(Date eArrngNxtRenewDt) {
		this.eArrngNxtRenewDt = eArrngNxtRenewDt;
	}
	public void seteOriginalAmt(Double eOriginalAmt) {
		if (eOriginalAmt==null){
			this.eOriginalAmt = null;
		}
		else if(eOriginalAmt ==0){
			this.eOriginalAmt=new BigDecimal(0);	
		}
		else {
			this.eOriginalAmt = new BigDecimal(eOriginalAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	}
	public void seteCredCrdBillCycDt(Date eCredCrdBillCycDt) {
		this.eCredCrdBillCycDt = eCredCrdBillCycDt;
	}
	public void seteBaselPortId(String eBaselPortId) {
		this.eBaselPortId = eBaselPortId;
	}
	public void seteMonthsOnBooksLocal(Integer eMonthsOnBooksLocal) {
		this.eMonthsOnBooksLocal = eMonthsOnBooksLocal;
	}
	public void seteInvPtyUniqueId(String eInvPtyUniqueId) {
		this.eInvPtyUniqueId = eInvPtyUniqueId;
	}
	public void seteArrngPtyRolType(String eArrngPtyRolType) {
		this.eArrngPtyRolType = eArrngPtyRolType;
	}
/*	public void setePctAmt(Double ePctAmt) {
		this.ePctAmt = ePctAmt;
	}*/
	public void seteRatingCode(String eRatingCode) {
		this.eRatingCode = eRatingCode;
	}
	public void seteFicoEqvRatingCode(String eFicoEqvRatingCode) {
		this.eFicoEqvRatingCode = eFicoEqvRatingCode;
	}
	public void seteScoreReqReturnFlag(String eScoreReqReturnFlag) {
		this.eScoreReqReturnFlag = eScoreReqReturnFlag;
	}
/*	public void seteRateVarTypId(Integer eRateVarTypId) {
		this.eRateVarTypId = eRateVarTypId;
	}*/
	public void seteRateTypId(String eRateTypId) {
		this.eRateTypId = eRateTypId;
	}
	public void seteLegNumber(Integer eLegNumber) {
		this.eLegNumber = eLegNumber;
	}
	public void seteBkingLedgCntryCde(String eBkingLedgCntryCde) {
		this.eBkingLedgCntryCde = eBkingLedgCntryCde;
	}
	public void seteTnxCurrency(String eTnxCurrency) {
		this.eTnxCurrency = eTnxCurrency;
	}
	public void seteFuncCurcyCode(String eFuncCurcyCode) {
		this.eFuncCurcyCode = eFuncCurcyCode;
	}
	public void seteBaseCurcyCode(String eBaseCurcyCode) {
		this.eBaseCurcyCode = eBaseCurcyCode;
	}
	public void seteGAAPInd(String eGAAPInd) {
		this.eGAAPInd = eGAAPInd;
	}
	public void seteRatingEveReasTypId(Integer eRatingEveReasTypId) {
		this.eRatingEveReasTypId = eRatingEveReasTypId;
	}
	/*public void seteEffRatePct(Double eEffRatePct) {
		this.eEffRatePct = new BigDecimal(eEffRatePct).setScale(8, BigDecimal.ROUND_HALF_UP);
	}*/
	public void seteRateActiveFlag(String eRateActiveFlag) {
		this.eRateActiveFlag = eRateActiveFlag;
	}
	public void seteLstCredLmtChngDt(Date eLstCredLmtChngDt) {
		this.eLstCredLmtChngDt = eLstCredLmtChngDt;
	}
	public void seteLstReageDt(Date eLstReageDt) {
		this.eLstReageDt = eLstReageDt;
	}
	public void seteArrngNxtPayDueAmt(Double eArrngNxtPayDueAmt) {
		if (eArrngNxtPayDueAmt==null){
			this.eArrngNxtPayDueAmt = null;
		}
		else if(eArrngNxtPayDueAmt ==0){
			this.eArrngNxtPayDueAmt=new BigDecimal(0);	
		}
		else {
			this.eArrngNxtPayDueAmt = new BigDecimal(eArrngNxtPayDueAmt).setScale(8,BigDecimal.ROUND_HALF_UP);
		}
	}
	public void seteLstRetTransDt(Date eLstRetTransDt) {
		this.eLstRetTransDt = eLstRetTransDt;
	}
	public void seteLstCashTranDt(Date eLstCashTranDt) {
		this.eLstCashTranDt = eLstCashTranDt;
	}
	public void seteCredLimEffDt(Date eCredLimEffDt) {
		this.eCredLimEffDt = eCredLimEffDt;
	}
	public void seteCredLimEndDt(Date eCredLimEndDt) {
		this.eCredLimEndDt = eCredLimEndDt;
	}
	public void seteCredLimEveAmt(Double eCredLimEveAmt) {
		if (eCredLimEveAmt==null){
			this.eCredLimEveAmt = null;
		}
		else if(eCredLimEveAmt ==0){
			this.eCredLimEveAmt=new BigDecimal(0);	
		}
		else {
			this.eCredLimEveAmt = new BigDecimal(eCredLimEveAmt).setScale(10,BigDecimal.ROUND_HALF_UP);
		}
	}
	public void seteBkingLedgerCountryCode(String eBkingLedgerCountryCode) {
		this.eBkingLedgerCountryCode = eBkingLedgerCountryCode;
	}
	
	

	/**
	 * New Non-mapped fields start here
	 */
	protected String eRatingTypeCode;
	
	protected Double eSpreadRatePercent; 

	protected Integer eArrangeRateTypeRltnpType;
	
	protected Integer eRateId;

	protected String eRateName;
	
	protected Date eRateTypeEffDate; 

	protected String eGeneralLedgerSysId;
	
	protected Integer eDealId;
	
	protected Integer eBalType;
	
	protected String eGLAccount1;
	
	protected String eGLAccount2;
	
	protected String eFdlAccount;
	
	protected Double eTxnAmt;
	
	protected Double eBaseAmt;
	
	protected String eGOC;
	
	protected String eBookingLedgerBranchCode;
	
	protected String eFrsBUCode;
	
	protected String eLocalDeptId;
	
	protected String eLocalLegalVehicleId;
	
	protected String eFairValueAccountingMethodFlag;
	
	protected String eFairValueLevel;
	
	protected String eLocalProductCode;
	
	protected String eFrsAffiliateCode;
	
	protected String eSubStrategyCode;
	
	protected String eMicroControlStratCode;

	protected String eFirmAcctImsNumber;

	protected String eLocalAffiliateCode;

	protected String eIdProd;

	protected String eKeyCode1;

	protected String eKeyCode2;

	protected String eLocalLedgerAcctNumber;

	protected String eAdjInd;

	protected String eSoeId;

	protected String eAdjReasonCode;

	protected String eComments;

	protected String eLocalGLKey3;

	protected String eLocalGLKey4;

	protected String eAdjStdArrngId;

	protected String eAdjFinMktPosId;


	public String geteRatingTypeCode() {
		return eRatingTypeCode;
	}
	public void setERatingTypeCode(String eRatingTypeCode) {
		this.eRatingTypeCode = eRatingTypeCode;
	}
	public Double geteSpreadRatePercent() {
		return eSpreadRatePercent;
	}
	public void setESpreadRatePercent(Double eSpreadRatePercent) {
		this.eSpreadRatePercent = eSpreadRatePercent;
	}
	public Integer geteArrangeRateTypeRltnpType() {
		return eArrangeRateTypeRltnpType;
	}
	public void setEArrangeRateTypeRltnpType(Integer eArrangeRateTypeRltnpType) {
		this.eArrangeRateTypeRltnpType = eArrangeRateTypeRltnpType;
	}
	public Integer geteRateId() {
		return eRateId;
	}
	public void setERateId(Integer eRateId) {
		this.eRateId = eRateId;
	}
	public String geteRateName() {
		return eRateName;
	}
	public void setERateName(String eRateName) {
		this.eRateName = eRateName;
	}
	public String geteGeneralLedgerSysId() {
		return eGeneralLedgerSysId;
	}
	public void setEGeneralLedgerSysId(String eGeneralLedgerSysId) {
		this.eGeneralLedgerSysId = eGeneralLedgerSysId;
	}
	public Integer geteDealId() {
		return eDealId;
	}
	public void setEDealId(Integer eDealId) {
		this.eDealId = eDealId;
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
	public String geteGLAccount2() {
		return eGLAccount2;
	}
	public void setEGLAccount2(String eGLAccount2) {
		this.eGLAccount2 = eGLAccount2;
	}
	public String geteFdlAccount() {
		return eFdlAccount;
	}
	public void setEFdlAccount(String eFdlAccount) {
		this.eFdlAccount = eFdlAccount;
	}
	public Double geteBaseAmt() {
		return eBaseAmt;
	}
	public void setEBaseAmt(Double eBaseAmt) {
		this.eBaseAmt = eBaseAmt;
	}
	public String geteGOC() {
		return eGOC;
	}
	public void setEGOC(String eGOC) {
		this.eGOC = eGOC;
	}
	public String geteBookingLedgerBranchCode() {
		return eBookingLedgerBranchCode;
	}
	public void setEBookingLedgerBranchCode(String eBookingLedgerBranchCode) {
		this.eBookingLedgerBranchCode = eBookingLedgerBranchCode;
	}
	public String geteFrsBUCode() {
		return eFrsBUCode;
	}
	public void setEFrsBUCode(String eFrsBUCode) {
		this.eFrsBUCode = eFrsBUCode;
	}
	public String geteLocalDeptId() {
		return eLocalDeptId;
	}
	public void setELocalDeptId(String eLocalDeptId) {
		this.eLocalDeptId = eLocalDeptId;
	}
	public String geteLocalLegalVehicleId() {
		return eLocalLegalVehicleId;
	}
	public void setELocalLegalVehicleId(String eLocalLegalVehicleId) {
		this.eLocalLegalVehicleId = eLocalLegalVehicleId;
	}
	public String geteFairValueAccountingMethodFlag() {
		return eFairValueAccountingMethodFlag;
	}
	public void setEFairValueAccountingMethodFlag(
			String eFairValueAccountingMethodFlag) {
		this.eFairValueAccountingMethodFlag = eFairValueAccountingMethodFlag;
	}
	public String geteFairValueLevel() {
		return eFairValueLevel;
	}
	public void setEFairValueLevel(String eFairValueLevel) {
		this.eFairValueLevel = eFairValueLevel;
	}
	public String geteLocalProductCode() {
		return eLocalProductCode;
	}
	public void setELocalProductCode(String eLocalProductCode) {
		this.eLocalProductCode = eLocalProductCode;
	}
	public String geteFrsAffiliateCode() {
		return eFrsAffiliateCode;
	}
	public void setEFrsAffiliateCode(String eFrsAffiliateCode) {
		this.eFrsAffiliateCode = eFrsAffiliateCode;
	}
	public String geteIdProd() {
		return eIdProd;
	}
	public void setEIdProd(String eIdProd) {
		this.eIdProd = eIdProd;
	}
	public String geteKeyCode1() {
		return eKeyCode1;
	}
	public void setEKeyCode1(String eKeyCode1) {
		this.eKeyCode1 = eKeyCode1;
	}
	public String geteKeyCode2() {
		return eKeyCode2;
	}
	public void setEKeyCode2(String eKeyCode2) {
		this.eKeyCode2 = eKeyCode2;
	}
	public String geteLocalLedgerAcctNumber() {
		return eLocalLedgerAcctNumber;
	}
	public void setELocalLedgerAcctNumber(String eLocalLedgerAcctNumber) {
		this.eLocalLedgerAcctNumber = eLocalLedgerAcctNumber;
	}
	public String geteAdjInd() {
		return eAdjInd;
	}
	public void setEAdjInd(String eAdjInd) {
		this.eAdjInd = eAdjInd;
	}
	public String geteAdjReasonCode() {
		return eAdjReasonCode;
	}
	public void setEAdjReasonCode(String eAdjReasonCode) {
		this.eAdjReasonCode = eAdjReasonCode;
	}
	public String geteComments() {
		return eComments;
	}
	public void setEComments(String eComments) {
		this.eComments = eComments;
	}
	public String geteLocalGLKey3() {
		return eLocalGLKey3;
	}
	public void setELocalGLKey3(String eLocalGLKey3) {
		this.eLocalGLKey3 = eLocalGLKey3;
	}
	public String geteLocalGLKey4() {
		return eLocalGLKey4;
	}
	public void setELocalGLKey4(String eLocalGLKey4) {
		this.eLocalGLKey4 = eLocalGLKey4;
	}
	public String geteAdjStdArrngId() {
		return eAdjStdArrngId;
	}
	public void setEAdjStdArrngId(String eAdjStdArrngId) {
		this.eAdjStdArrngId = eAdjStdArrngId;
	}
	public String geteAdjFinMktPosId() {
		return eAdjFinMktPosId;
	}
	public void setEAdjFinMktPosId(String eAdjFinMktPosId) {
		this.eAdjFinMktPosId = eAdjFinMktPosId;
	}
	public Double geteTxnAmt() {
		return eTxnAmt;
	}
	
	public void setETxnAmt(Double eTxnAmt) {
		this.eTxnAmt = eTxnAmt;
	}
	public Date geteRateTypeEffDate() {
		return eRateTypeEffDate;
	}
	public void seteRateTypeEffDate(Date eRateTypeEffDate) {
		this.eRateTypeEffDate = eRateTypeEffDate;
	}
	public BigDecimal geteFuncAmt() {
		return eFuncAmt;
	}
	public void setEFuncAmt(Double eFuncAmt) {
		this.eFuncAmt = new BigDecimal(eFuncAmt).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public String geteSubStrategyCode() {
		return eSubStrategyCode;
	}
	public String geteMicroControlStratCode() {
		return eMicroControlStratCode;
	}
	public String geteFirmAcctImsNumber() {
		return eFirmAcctImsNumber;
	}
	
	public void setEFirmAcctImsNumber(String eFirmAcctImsNumber) {
		this.eFirmAcctImsNumber = eFirmAcctImsNumber;
	}
	public String geteLocalAffiliateCode() {
		return eLocalAffiliateCode;
	}
	public String geteSoeId() {
		return eSoeId;
	}
	
	public List<ArrangementTRLRecord> geteArragnmntTRLRecords() {
		return eArragnmntTRLRecords;
	}
	public void setEArragnmntTRLRecords(
			List<ArrangementTRLRecord> eArragnmntTRLRecords) {
		this.eArragnmntTRLRecords = eArragnmntTRLRecords;
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
	public Double geteTotIntAccrued() {
		return eTotIntAccrued;
	}
	public void setETotIntAccrued(Double eTotIntAccrued) {
		this.eTotIntAccrued = eTotIntAccrued;
	}
	public Double geteGrossChargeOffBal() {
		return eGrossChargeOffBal;
	}
	public void setEGrossChargeOffBal(Double eGrossChargeOffBal) {
		this.eGrossChargeOffBal = eGrossChargeOffBal;
	}
	public Double geteAnnualFeesUnpaid() {
		return eAnnualFeesUnpaid;
	}
	public void setEAnnualFeesUnpaid(Double eAnnualFeesUnpaid) {
		this.eAnnualFeesUnpaid = eAnnualFeesUnpaid;
	}
	public Double geteOtherCreditCardFeesUpd() {
		return eOtherCreditCardFeesUpd;
	}
	public void setEOtherCreditCardFeesUpd(Double eOtherCreditCardFeesUpd) {
		this.eOtherCreditCardFeesUpd = eOtherCreditCardFeesUpd;
	}
	public Double geteGrsPurchasePrnplRecvs() {
		return eGrsPurchasePrnplRecvs;
	}
	public void setEGrsPurchasePrnplRecvs(Double eGrsPurchasePrnplRecvs) {
		this.eGrsPurchasePrnplRecvs = eGrsPurchasePrnplRecvs;
	}
	public Double geteGrsCashAdvPrnplRecvs() {
		return eGrsCashAdvPrnplRecvs;
	}
	public void setEGrsCashAdvPrnplRecvs(Double eGrsCashAdvPrnplRecvs) {
		this.eGrsCashAdvPrnplRecvs = eGrsCashAdvPrnplRecvs;
	}
	public Double geteGrsPurchaseIntRecvs() {
		return eGrsPurchaseIntRecvs;
	}
	public void setEGrsPurchaseIntRecvs(Double eGrsPurchaseIntRecvs) {
		this.eGrsPurchaseIntRecvs = eGrsPurchaseIntRecvs;
	}
	public Double geteGrsCashAdvIntRecvs() {
		return eGrsCashAdvIntRecvs;
	}
	public void setEGrsCashAdvIntRecvs(Double eGrsCashAdvIntRecvs) {
		this.eGrsCashAdvIntRecvs = eGrsCashAdvIntRecvs;
	}
	public Double geteGrsCashAdvFeeRecvs() {
		return eGrsCashAdvFeeRecvs;
	}
	public void setEGrsCashAdvFeeRecvs(Double eGrsCashAdvFeeRecvs) {
		this.eGrsCashAdvFeeRecvs = eGrsCashAdvFeeRecvs;
	}
	public Double geteTotIntBalEnr() {
		return eTotIntBalEnr;
	}
	public void setETotIntBalEnr(Double eTotIntBalEnr) {
		this.eTotIntBalEnr = eTotIntBalEnr;
	}
	public Double geteCurAdvisedUncommtdLmt() {
		return eCurAdvisedUncommtdLmt;
	}
	public void setECurAdvisedUncommtdLmt(Double eCurAdvisedUncommtdLmt) {
		this.eCurAdvisedUncommtdLmt = eCurAdvisedUncommtdLmt;
	}
	public Double geteAlopUnpaidPrnplBal() {
		return eAlopUnpaidPrnplBal;
	}
	public void setEAlopUnpaidPrnplBal(Double eAlopUnpaidPrnplBal) {
		this.eAlopUnpaidPrnplBal = eAlopUnpaidPrnplBal;
	}
	public Double geteTotBalAnr() {
		return eTotBalAnr;
	}
	public void setETotBalAnr(Double eTotBalAnr) {
		this.eTotBalAnr = eTotBalAnr;
	}
	public Double geteRecoveriesAmount() {
		return eRecoveriesAmount;
	}
	public void setERecoveriesAmount(Double eRecoveriesAmount) {
		this.eRecoveriesAmount = eRecoveriesAmount;
	}
	public Double geteLateFeeBilled() {
		return eLateFeeBilled;
	}
	public void setELateFeeBilled(Double eLateFeeBilled) {
		this.eLateFeeBilled = eLateFeeBilled;
	}
	public Double geteInsuranceCost() {
		return eInsuranceCost;
	}
	public void setEInsuranceCost(Double eInsuranceCost) {
		this.eInsuranceCost = eInsuranceCost;
	}
	public Double geteCashAdvPrnplEnr() {
		return eCashAdvPrnplEnr;
	}
	public void setECashAdvPrnplEnr(Double eCashAdvPrnplEnr) {
		this.eCashAdvPrnplEnr = eCashAdvPrnplEnr;
	}
	public Double geteCashBalAnr() {
		return eCashBalAnr;
	}
	public void setECashBalAnr(Double eCashBalAnr) {
		this.eCashBalAnr = eCashBalAnr;
	}
	public Double geteTotCreditLimit() {
		return eTotCreditLimit;
	}
	public void setETotCreditLimit(Double eTotCreditLimit) {
		this.eTotCreditLimit = eTotCreditLimit;
	}
	public Double geteTotUsedCreditLimit() {
		return eTotUsedCreditLimit;
	}
	public void setETotUsedCreditLimit(Double eTotUsedCreditLimit) {
		this.eTotUsedCreditLimit = eTotUsedCreditLimit;
	}
	public Double geteCreditCardEndingBal() {
		return eCreditCardEndingBal;
	}
	public void setECreditCardEndingBal(Double eCreditCardEndingBal) {
		this.eCreditCardEndingBal = eCreditCardEndingBal;
	}
	public Double geteBalAtCashApr() {
		return eBalAtCashApr;
	}
	public void setEBalAtCashApr(Double eBalAtCashApr) {
		this.eBalAtCashApr = eBalAtCashApr;
	}
	public Double geteTotPastDueAmount() {
		return eTotPastDueAmount;
	}
	public void setETotPastDueAmount(Double eTotPastDueAmount) {
		this.eTotPastDueAmount = eTotPastDueAmount;
	}
	public Double geteContractualWoPrnplAmt() {
		return eContractualWoPrnplAmt;
	}
	public void setEContractualWoPrnplAmt(Double eContractualWoPrnplAmt) {
		this.eContractualWoPrnplAmt = eContractualWoPrnplAmt;
	}
	public Double geteAtmFeeUpd() {
		return eAtmFeeUpd;
	}
	public void setEAtmFeeUpd(Double eAtmFeeUpd) {
		this.eAtmFeeUpd = eAtmFeeUpd;
	}
	public Double geteGrssTotIntRecvs() {
		return eGrssTotIntRecvs;
	}
	public void setEGrssTotIntRecvs(Double eGrssTotIntRecvs) {
		this.eGrssTotIntRecvs = eGrssTotIntRecvs;
	}
	public Double geteWoTotPnrplRecvl() {
		return eWoTotPnrplRecvl;
	}
	public void setEWoTotPnrplRecvl(Double eWoTotPnrplRecvl) {
		this.eWoTotPnrplRecvl = eWoTotPnrplRecvl;
	}
	public Double geteWoTotIntRecvl() {
		return eWoTotIntRecvl;
	}
	public void setEWoTotIntRecvl(Double eWoTotIntRecvl) {
		this.eWoTotIntRecvl = eWoTotIntRecvl;
	}
	public List<CommonBalanceTRLRecord> geteCommonBalTRLRecords() {
		return eCommonBalTRLRecords;
	}
	public void setECommonBalTRLRecords(
			List<CommonBalanceTRLRecord> eCommonBalTRLRecords) {
		this.eCommonBalTRLRecords = eCommonBalTRLRecords;
	}	
	
	
	private Integer eCredCardTypId2;
	//private String eRatingTypeCode;
	private Date eLossMitgStartDate;
	private Integer eResrcItemValuationMthdId;
	private String eResrcItemBalCurrId;
	private Integer eResrcItemBalTypId;
	private Integer eArrgnTypId;
	private Integer eLoanAssestRelnType;
	private String eLocalProdId;
	private Date eEstmEndDate;
	
	// Loss Mitg
	private Integer eModTyp;
	private Integer eRatModTypId;
	private Integer eLossMitgCnt;
	private Date eLossMitgEndDate;
	private String eLossMitgFDICTypId;
	private String eRestModFlg;
	private String eTrbdDebtRestFlg;
	private Integer eLossMitgPrgmId;
	private String eLossMitgTypId;

	// Guarantee Ins
	private Integer eGSupSeqNum;
	private Integer eGSupTypId;
	private String eGSupCovBasTypId;
	private String eGSubCovTypId;
	private Date eGEffDate;
	private Date eGEndDate;
	private Integer eISupTypId;
	private String eISupCovBasTypId;
	private String eISubCovTypId;
	private Date eIEffDate;
	private Date eIEndDate;
	
	
 
	
	// Arrang Event
	private Integer eArrangEveRltnlpTypId;
	private String eCmpCd;
	private Integer eCmpTypId;


	
	
	public Integer geteLoanAssestRelnType() {
		return eLoanAssestRelnType;
	}
	public void setELoanAssestRelnType(Integer eLoanAssestRelnType) {
		this.eLoanAssestRelnType = eLoanAssestRelnType;
	}
	public String geteLocalProdId() {
		return eLocalProdId;
	}
	public void setELocalProdId(String eLocalProdId) {
		this.eLocalProdId = eLocalProdId;
	}
	public Integer geteCredCardTypId2() {
		return eCredCardTypId2;
	}
	public void setECredCardTypId2(Integer eCredCardTypId2) {
		this.eCredCardTypId2 = eCredCardTypId2;
	}
	/*public String geteRatingTypeCode() {
		return eRatingTypeCode;
	}
	public void setERatingTypeCode(String eRatingTypeCode) {
		this.eRatingTypeCode = eRatingTypeCode;
	}*/
	public Date geteLossMitgStartDate() {
		return eLossMitgStartDate;
	}
	public void setELossMitgStartDate(Date eLossMitgStartDate) {
		this.eLossMitgStartDate = eLossMitgStartDate;
	}
	public Integer geteResrcItemValuationMthdId() {
		return eResrcItemValuationMthdId;
	}
	public void setEResrcItemValuationMthdId(Integer eResrcItemValuationMthdId) {
		this.eResrcItemValuationMthdId = eResrcItemValuationMthdId;
	}
	public String geteResrcItemBalCurrId() {
		return eResrcItemBalCurrId;
	}
	public void setEResrcItemBalCurrId(String eResrcItemBalCurrId) {
		this.eResrcItemBalCurrId = eResrcItemBalCurrId;
	}
	public Integer geteResrcItemBalTypId() {
		return eResrcItemBalTypId;
	}
	public void setEResrcItemBalTypId(Integer eResrcItemBalTypId) {
		this.eResrcItemBalTypId = eResrcItemBalTypId;
	}
	public Integer geteArrgnTypId() {
		return eArrgnTypId;
	}
	public void setEArrgnTypId(Integer eArrgnTypId) {
		this.eArrgnTypId = eArrgnTypId;
	}

	public Date geteEstmEndDate() {
		return eEstmEndDate;
	}
	public void setEEstmEndDate(Date eEstmEndDate) {
		this.eEstmEndDate = eEstmEndDate;
	}
	
	public Integer geteModTyp() {
		return eModTyp;
	}
	public void setEModTyp(Integer eModTyp) {
		this.eModTyp = eModTyp;
	}
	public Integer geteRatModTypId() {
		return eRatModTypId;
	}
	public void setERatModTypId(Integer eRatModTypId) {
		this.eRatModTypId = eRatModTypId;
	}
	public Integer geteLossMitgCnt() {
		return eLossMitgCnt;
	}
	public void setELossMitgCnt(Integer eLossMitgCnt) {
		this.eLossMitgCnt = eLossMitgCnt;
	}
	public Date geteLossMitgEndDate() {
		return eLossMitgEndDate;
	}
	public void setELossMitgEndDate(Date eLossMitgEndDate) {
		this.eLossMitgEndDate = eLossMitgEndDate;
	}
	public String geteLossMitgFDICTypId() {
		return eLossMitgFDICTypId;
	}
	public void setELossMitgFDICTypId(String eLossMitgFDICTypId) {
		this.eLossMitgFDICTypId = eLossMitgFDICTypId;
	}
	public String geteRestModFlg() {
		return eRestModFlg;
	}
	public void setERestModFlg(String eRestModFlg) {
		this.eRestModFlg = eRestModFlg;
	}
	public String geteTrbdDebtRestFlg() {
		return eTrbdDebtRestFlg;
	}
	public void setETrbdDebtRestFlg(String eTrbdDebtRestFlg) {
		this.eTrbdDebtRestFlg = eTrbdDebtRestFlg;
	}
	public Integer geteLossMitgPrgmId() {
		return eLossMitgPrgmId;
	}
	public void setELossMitgPrgmId(Integer eLossMitgPrgmId) {
		this.eLossMitgPrgmId = eLossMitgPrgmId;
	}
	public String geteLossMitgTypId() {
		return eLossMitgTypId;
	}
	public void setELossMitgTypId(String eLossMitgTypId) {
		this.eLossMitgTypId = eLossMitgTypId;
	}
	public Integer geteGSupSeqNum() {
		return eGSupSeqNum;
	}
	public void setEGSupSeqNum(Integer eGSupSeqNum) {
		this.eGSupSeqNum = eGSupSeqNum;
	}
	public Integer geteGSupTypId() {
		return eGSupTypId;
	}
	public void setEGSupTypId(Integer eGSupTypId) {
		this.eGSupTypId = eGSupTypId;
	}
	public String geteGSupCovBasTypId() {
		return eGSupCovBasTypId;
	}
	public void setEGSupCovBasTypId(String eGSupCovBasTypId) {
		this.eGSupCovBasTypId = eGSupCovBasTypId;
	}
	public String geteGSubCovTypId() {
		return eGSubCovTypId;
	}
	public void setEGSubCovTypId(String eGSubCovTypId) {
		this.eGSubCovTypId = eGSubCovTypId;
	}
	public Date geteGEffDate() {
		return eGEffDate;
	}
	public void setEGEffDate(Date eGEffDate) {
		this.eGEffDate = eGEffDate;
	}
	public Date geteGEndDate() {
		return eGEndDate;
	}
	public void setEGEndDate(Date eGEndDate) {
		this.eGEndDate = eGEndDate;
	}
	public Integer geteISupTypId() {
		return eISupTypId;
	}
	public void setEISupTypId(Integer eISupTypId) {
		this.eISupTypId = eISupTypId;
	}
	public String geteISupCovBasTypId() {
		return eISupCovBasTypId;
	}
	public void setEISupCovBasTypId(String eISupCovBasTypId) {
		this.eISupCovBasTypId = eISupCovBasTypId;
	}
	public String geteISubCovTypId() {
		return eISubCovTypId;
	}
	public void setEISubCovTypId(String eISubCovTypId) {
		this.eISubCovTypId = eISubCovTypId;
	}
	public Date geteIEffDate() {
		return eIEffDate;
	}
	public void setEIEffDate(Date eIEffDate) {
		this.eIEffDate = eIEffDate;
	}
	public Date geteIEndDate() {
		return eIEndDate;
	}
	public void setEIEndDate(Date eIEndDate) {
		this.eIEndDate = eIEndDate;
	}
	public Integer geteArrangEveRltnlpTypId() {
		return eArrangEveRltnlpTypId;
	}
	public void setEArrangEveRltnlpTypId(Integer eArrangEveRltnlpTypId) {
		this.eArrangEveRltnlpTypId = eArrangEveRltnlpTypId;
	}
	public String geteCmpCd() {
		return eCmpCd;
	}
	public void setECmpCd(String eCmpCd) {
		this.eCmpCd = eCmpCd;
	}
	public Integer geteCmpTypId() {
		return eCmpTypId;
	}
	public void setECmpTypId(Integer eCmpTypId) {
		this.eCmpTypId = eCmpTypId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArrangementName() {
		return arrangementName;
	}
	public void setArrangementName(String arrangementName) {
		this.arrangementName = arrangementName;
	}
	public String geteCycEndDelqBucket() {
		return eCycEndDelqBucket;
	}
	public void setECycEndDelqBucket(String eCycEndDelqBucket) {
		this.eCycEndDelqBucket = eCycEndDelqBucket;
	}
	
	/**
	 * @return the eAdjBalance
	 */
	public Double geteAdjBalance() {
		return eAdjBalance;
	}
	/**
	 * @param eAdjBalance the eAdjBalance to set
	 */
	public void setEAdjBalance(Double eAdjBalance) {
		this.eAdjBalance = eAdjBalance;
	}

	/**
	 * @return the eAdjMonBlnc
	 */
	public Double geteAdjMonBlnc() {
		return eAdjMonBlnc;
	}
	/**
	 * @param eAdjMonBlnc the eAdjMonBlnc to set
	 */
	public void setEAdjMonBlnc(Double eAdjMonBlnc) {
		this.eAdjMonBlnc = eAdjMonBlnc;
	}

	/**
	 * @return the eBalType265
	 */
	public Double geteBalType265() {
		return eBalType265;
	}
	/**
	 * @param eBalType265 the eBalType265 to set
	 */
	public void setEBalType265(Double eBalType265) {
		this.eBalType265 = eBalType265;
	}

	/**
	 * @return the ePayAmt2
	 */
	public Double getePayAmt2() {
		return ePayAmt2;
	}
	/**
	 * @param ePayAmt2 the ePayAmt2 to set
	 */
	public void setEPayAmt2(Double ePayAmt2) {
		this.ePayAmt2 = ePayAmt2;
	}

	/**
	 * @return the eRtlMiscBnp
	 */
	public Double geteRtlMiscBnp() {
		return eRtlMiscBnp;
	}
	/**
	 * @param eRtlMiscBnp the eRtlMiscBnp to set
	 */
	public void setERtlMiscBnp(Double eRtlMiscBnp) {
		this.eRtlMiscBnp = eRtlMiscBnp;
	}

	/**
	 * @return the eRtlSvcBnp
	 */
	public Double geteRtlSvcBnp() {
		return eRtlSvcBnp;
	}
	/**
	 * @param eRtlSvcBnp the eRtlSvcBnp to set
	 */
	public void setERtlSvcBnp(Double eRtlSvcBnp) {
		this.eRtlSvcBnp = eRtlSvcBnp;
	}

	/**
	 * @return the eRtlIntr
	 */
	public Double geteRtlIntr() {
		return eRtlIntr;
	}
	/**
	 * @param eRtlIntr the eRtlIntr to set
	 */
	public void setERtlIntr(Double eRtlIntr) {
		this.eRtlIntr = eRtlIntr;
	}

	/**
	 * @return the eAnfee
	 */
	public Double geteAnfee() {
		return eAnfee;
	}
	/**
	 * @param eAnfee the eAnfee to set
	 */
	public void setEAnfee(Double eAnfee) {
		this.eAnfee = eAnfee;
	}

	/**
	 * @return the eClt2
	 */
	public Double geteClt2() {
		return eClt2;
	}
	/**
	 * @param eClt2 the eClt2 to set
	 */
	public void setEClt2(Double eClt2) {
		this.eClt2 = eClt2;
	}

	/**
	 * @return the eMdue
	 */
	public Double geteMdue() {
		return eMdue;
	}
	/**
	 * @param eMdue the eMdue to set
	 */
	public void setEMdue(Double eMdue) {
		this.eMdue = eMdue;
	}

	/**
	 * @return the eLclt2
	 */
	public Double geteLclt2() {
		return eLclt2;
	}
	/**
	 * @param eLclt2 the eLclt2 to set
	 */
	public void setELclt2(Double eLclt2) {
		this.eLclt2 = eLclt2;
	}

	/**
	 * @return the eTotAmtDue
	 */
	public Double geteTotAmtDue() {
		return eTotAmtDue;
	}
	/**
	 * @param eTotAmtDue the eTotAmtDue to set
	 */
	public void setETotAmtDue(Double eTotAmtDue) {
		this.eTotAmtDue = eTotAmtDue;
	}

	/**
	 * @return the eAvailclt
	 */
	public Integer geteAvailclt() {
		return eAvailclt;
	}
	/**
	 * @param eAvailclt the eAvailclt to set
	 */
	public void setEAvailclt(Integer eAvailclt) {
		this.eAvailclt = eAvailclt;
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

	public Double geteBaseAmtCurr() {
		return eBaseAmtCurr;
	}
	public void setEBaseAmtCurr(Double eBaseAmtCurr) {
		this.eBaseAmtCurr = eBaseAmtCurr;
	}
	/**
	 * the below attributes are for fixing CB issue
	 */
	private Double eAdjBalance;
	private Double eAdjMonBlnc;
	private Double eBalType265;
	private Date eAirEndDate;
	
	public void seteCredCardTypId2(Integer eCredCardTypId2) {
		this.eCredCardTypId2 = eCredCardTypId2;
	}
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
	public Date getFinServRestCurrentStatDate() {
		return finServRestCurrentStatDate;
	}
	public void setFinServRestCurrentStatDate(Date finServRestCurrentStatDate) {
		this.finServRestCurrentStatDate = finServRestCurrentStatDate;
	}
	public String getFinServPrevRestructureStatId() {
		return finServPrevRestructureStatId;
	}
	public void setFinServPrevRestructureStatId(
			String finServPrevRestructureStatId) {
		this.finServPrevRestructureStatId = finServPrevRestructureStatId;
	}
	public Date getCreditLimitEfcDate() {
		return creditLimitEfcDate;
	}
	public void setCreditLimitEfcDate(Date creditLimitEfcDate) {
		this.creditLimitEfcDate = creditLimitEfcDate;
	}
	public String geteWoDelq() {
		return eWoDelq;
	}
	public void setEWoDelq(String eWoDelq) {
		this.eWoDelq = eWoDelq;
	}
	public String geteDelqSubStr() {
		return eDelqSubStr;
	}
	public void setEDelqSubStr(String eDelqSubStr) {
		this.eDelqSubStr = eDelqSubStr;
	}
	public Double geteTxnAmtForBal9() {
		return eTxnAmtForBal9;
	}
	public void setETxnAmtForBal9(Double eTxnAmtForBal9) {
		this.eTxnAmtForBal9 = eTxnAmtForBal9;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CardsTRLRecord [eSrcSysId=" + eSrcSysId + ", eProdSysId="
				+ eProdSysId + ", eRecType=" + eRecType + ", eRatingIssuerId="
				+ eRatingIssuerId + ", eModelCode=" + eModelCode
				+ ", eRatingReasonId=" + eRatingReasonId + ", eRank=" + eRank
				+ ", eEffDate=" + eEffDate + ", eEndDate=" + eEndDate
				+ ", eRptMonthDate=" + eRptMonthDate + ", eFicoScore="
				+ eFicoScore + ", eRatingDesc=" + eRatingDesc
				+ ", eScoreReturnFlag=" + eScoreReturnFlag
				+ ", eArrangementRoleType=" + eArrangementRoleType
				+ ", ePercentAmount=" + ePercentAmount
				+ ", eInvolvedPartySubtypeId=" + eInvolvedPartySubtypeId
				+ ", eFuncAmt=" + eFuncAmt + ", eGlbProdId=" + eGlbProdId
				+ ", eEntProdId=" + eEntProdId + ", eStdArrgId=" + eStdArrgId
				+ ", eOrgEffDate=" + eOrgEffDate + ", eDenCurrencyId="
				+ eDenCurrencyId + ", eOrigChnlId=" + eOrigChnlId
				+ ", eArrngPurpTypeId=" + eArrngPurpTypeId
				+ ", eArrngBusIntType=" + eArrngBusIntType
				+ ", eArrngBussIntDate=" + eArrngBussIntDate + ", ePledgInd="
				+ ePledgInd + ", ePledgEligInd=" + ePledgEligInd
				+ ", eArrngMatuTypeId=" + eArrngMatuTypeId
				+ ", eArrngFinStatTypId=" + eArrngFinStatTypId
				+ ", eArrngFinStatDate=" + eArrngFinStatDate
				+ ", eGracePeriodDayCnt=" + eGracePeriodDayCnt
				+ ", eArrngPastDueAgeClass=" + eArrngPastDueAgeClass
				+ ", eArrngLifCycStat=" + eArrngLifCycStat
				+ ", eArrngLifCycStatReasonTypId="
				+ eArrngLifCycStatReasonTypId + ", eArrngPrimPayTypeId="
				+ eArrngPrimPayTypeId + ", eAccTypId=" + eAccTypId
				+ ", eArrngAcqTypId=" + eArrngAcqTypId + ", eArrngAcqDt="
				+ eArrngAcqDt + ", eChrgOffTypId=" + eChrgOffTypId
				+ ", eOrigInsuredCatId=" + eOrigInsuredCatId
				+ ", eOrigInsuredPct=" + eOrigInsuredPct
				+ ", eArrngDayCntConvTypId=" + eArrngDayCntConvTypId
				+ ", eIntrBasCalcPerId=" + eIntrBasCalcPerId
				+ ", eIntrPayFreqPeriodId=" + eIntrPayFreqPeriodId
				+ ", eRateResetPerodInterId=" + eRateResetPerodInterId
				+ ", eInitIntrestRateResetDt=" + eInitIntrestRateResetDt
				+ ", eNxtIntrRateResetDate=" + eNxtIntrRateResetDate
				+ ", eIslamicAccInd=" + eIslamicAccInd + ", eTaxExemptInd="
				+ eTaxExemptInd + ", eFinServiceTypId=" + eFinServiceTypId
				+ ", eFinServiceLimitTypId=" + eFinServiceLimitTypId
				+ ", eArrngSecurTypeId=" + eArrngSecurTypeId
				+ ", eCitiRecourseInd=" + eCitiRecourseInd
				+ ", ePaymentFreqPeriodId=" + ePaymentFreqPeriodId
				+ ", eCurrFinServicePrinRepayTypId="
				+ eCurrFinServicePrinRepayTypId + ", eIntrstAccrualStatTypId="
				+ eIntrstAccrualStatTypId + ", eIntrstAccrualStatTypDt="
				+ eIntrstAccrualStatTypDt + ", eFinanceServRestCurrStatDate="
				+ eFinanceServRestCurrStatDate
				+ ", eFinanceServRestCurrStatId=" + eFinanceServRestCurrStatId
				+ ", eTroubledDebtRestructFlag=" + eTroubledDebtRestructFlag
				+ ", eOverLimInd=" + eOverLimInd + ", eSkipPayInd="
				+ eSkipPayInd + ", eSecurizedInd=" + eSecurizedInd
				+ ", eLOCAutExtFlag=" + eLOCAutExtFlag
				+ ", eLOCTermLoanConFlag=" + eLOCTermLoanConFlag
				+ ", eCreditDeviationInd=" + eCreditDeviationInd
				+ ", eFinServiceModReasTypId=" + eFinServiceModReasTypId
				+ ", eCreditFacTypId=" + eCreditFacTypId
				+ ", eFacLegStatTypId=" + eFacLegStatTypId
				+ ", eFacilityLegStatDt=" + eFacilityLegStatDt
				+ ", eCreditFacArrngAppTypId=" + eCreditFacArrngAppTypId
				+ ", eCredFacArrngAppDt=" + eCredFacArrngAppDt
				+ ", eCreditFacAvailStatTypId=" + eCreditFacAvailStatTypId
				+ ", eAssocAffCode=" + eAssocAffCode + ", eCredCrdClassTyp="
				+ eCredCrdClassTyp + ", eCredCardTypId=" + eCredCardTypId
				+ ", eCredLimChngTypId=" + eCredLimChngTypId
				+ ", eReissueFlag=" + eReissueFlag + ", eAccLastRecDate="
				+ eAccLastRecDate + ", eTotCashTxn=" + eTotCashTxn
				+ ", eTotPurchaseTxn=" + eTotPurchaseTxn + ", ePenaltyRate="
				+ ePenaltyRate + ", ePenaltyAmt=" + ePenaltyAmt
				+ ", eLegalNotificationDays=" + eLegalNotificationDays
				+ ", eDelq30pst2yrsFlag=" + eDelq30pst2yrsFlag
				+ ", eLienPositTypId=" + eLienPositTypId
				+ ", eActualBillingCycDt=" + eActualBillingCycDt
				+ ", eFeePayFreqPeriodId=" + eFeePayFreqPeriodId
				+ ", eCCARProdCode=" + eCCARProdCode
				+ ", ePromoIntRateEligFlag=" + ePromoIntRateEligFlag
				+ ", eOrigAdvisedUncomLimit=" + eOrigAdvisedUncomLimit
				+ ", eRestructureFlag=" + eRestructureFlag
				+ ", eLastWritDwnDt=" + eLastWritDwnDt + ", eRiskManagInd="
				+ eRiskManagInd + ", eDelqBucket=" + eDelqBucket
				+ ", eUniqueId=" + eUniqueId + ", eBookingDate=" + eBookingDate
				+ ", eArrngLifCycStatDate=" + eArrngLifCycStatDate
				+ ", eCredCardPortfolioId=" + eCredCardPortfolioId
				+ ", eNumOfAddCards=" + eNumOfAddCards
				+ ", eArrngLstPayToBnkDt=" + eArrngLstPayToBnkDt
				+ ", eAccLstPayToBnkAmt=" + eAccLstPayToBnkAmt
				+ ", eLocalBlkCde=" + eLocalBlkCde + ", eCardsFirstDigit="
				+ eCardsFirstDigit + ", eArrngPastDueDayCount="
				+ eArrngPastDueDayCount + ", eArrngNxtRenewDt="
				+ eArrngNxtRenewDt + ", eOriginalAmt=" + eOriginalAmt
				+ ", eCredCrdBillCycDt=" + eCredCrdBillCycDt
				+ ", eBaselPortId=" + eBaselPortId + ", eMonthsOnBooksLocal="
				+ eMonthsOnBooksLocal + ", eInvPtyUniqueId=" + eInvPtyUniqueId
				+ ", eArrngPtyRolType=" + eArrngPtyRolType + ", ePctAmt="
				+ ePctAmt + ", eInvPtySubTypeId=" + eInvPtySubTypeId
				+ ", eRatingCode=" + eRatingCode + ", eFicoEqvRatingCode="
				+ eFicoEqvRatingCode + ", eScoreReqReturnFlag="
				+ eScoreReqReturnFlag + ", eRateVarTypId=" + eRateVarTypId
				+ ", eRateTypId=" + eRateTypId + ", eLegNumber=" + eLegNumber
				+ ", eBkingLedgCntryCde=" + eBkingLedgCntryCde
				+ ", eTnxCurrency=" + eTnxCurrency + ", eFuncCurcyCode="
				+ eFuncCurcyCode + ", eBaseCurcyCode=" + eBaseCurcyCode
				+ ", eGAAPInd=" + eGAAPInd + ", eRatingEveReasTypId="
				+ eRatingEveReasTypId + ", eEffRatePct=" + eEffRatePct
				+ ", eArrngPastDueAgeClassDate=" + eArrngPastDueAgeClassDate
				+ ", eRateActiveFlag=" + eRateActiveFlag
				+ ", eLstCredLmtChngDt=" + eLstCredLmtChngDt + ", eLstReageDt="
				+ eLstReageDt + ", eArrngNxtPayDueAmt=" + eArrngNxtPayDueAmt
				+ ", eLstRetTransDt=" + eLstRetTransDt + ", eLstCashTranDt="
				+ eLstCashTranDt + ", eCredLimEffDt=" + eCredLimEffDt
				+ ", eCredLimEndDt=" + eCredLimEndDt + ", eCredLimEveAmt="
				+ eCredLimEveAmt + ", eBkingLedgerCountryCode="
				+ eBkingLedgerCountryCode + ", creditLimitEfcDate="
				+ creditLimitEfcDate + ", eArragnmntTRLRecords="
				+ eArragnmntTRLRecords + ", eRiRate=" + eRiRate + ", eCiRate="
				+ eCiRate + ", eCommonBalTRLRecords=" + eCommonBalTRLRecords
				+ ", eTotIntAccrued=" + eTotIntAccrued
				+ ", eGrossChargeOffBal=" + eGrossChargeOffBal
				+ ", eAnnualFeesUnpaid=" + eAnnualFeesUnpaid
				+ ", eOtherCreditCardFeesUpd=" + eOtherCreditCardFeesUpd
				+ ", eGrsPurchasePrnplRecvs=" + eGrsPurchasePrnplRecvs
				+ ", eGrsCashAdvPrnplRecvs=" + eGrsCashAdvPrnplRecvs
				+ ", eGrsPurchaseIntRecvs=" + eGrsPurchaseIntRecvs
				+ ", eGrssTotIntRecvs=" + eGrssTotIntRecvs
				+ ", eGrsCashAdvIntRecvs=" + eGrsCashAdvIntRecvs
				+ ", eGrsCashAdvFeeRecvs=" + eGrsCashAdvFeeRecvs
				+ ", eTotIntBalEnr=" + eTotIntBalEnr
				+ ", eCurAdvisedUncommtdLmt=" + eCurAdvisedUncommtdLmt
				+ ", eAlopUnpaidPrnplBal=" + eAlopUnpaidPrnplBal
				+ ", eTotBalAnr=" + eTotBalAnr + ", eRecoveriesAmount="
				+ eRecoveriesAmount + ", eLateFeeBilled=" + eLateFeeBilled
				+ ", eInsuranceCost=" + eInsuranceCost + ", eCashAdvPrnplEnr="
				+ eCashAdvPrnplEnr + ", eCashBalAnr=" + eCashBalAnr
				+ ", eTotCreditLimit=" + eTotCreditLimit
				+ ", eTotUsedCreditLimit=" + eTotUsedCreditLimit
				+ ", eCreditCardEndingBal=" + eCreditCardEndingBal
				+ ", eBalAtCashApr=" + eBalAtCashApr + ", eTotPastDueAmount="
				+ eTotPastDueAmount + ", eContractualWoPrnplAmt="
				+ eContractualWoPrnplAmt + ", eAtmFeeUpd=" + eAtmFeeUpd
				+ ", eWoTotPnrplRecvl=" + eWoTotPnrplRecvl
				+ ", eWoTotIntRecvl=" + eWoTotIntRecvl + ", eCycEndDelqBucket="
				+ eCycEndDelqBucket + ", notForUse=" + notForUse
				+ ", expenseCode=" + expenseCode + ", eBaseAmtCurr="
				+ eBaseAmtCurr + ", eWoDelq=" + eWoDelq + ", eDelqSubStr="
				+ eDelqSubStr + ", eTxnAmtForBal9=" + eTxnAmtForBal9
				+ ", ePayAmt2=" + ePayAmt2 + ", eRtlMiscBnp=" + eRtlMiscBnp
				+ ", eRtlSvcBnp=" + eRtlSvcBnp + ", eCshFee=" + eCshFee
				+ ", eAnr2=" + eAnr2 + ", eCurrDueAmt=" + eCurrDueAmt
				+ ", eCshBlnc2=" + eCshBlnc2 + ", eCrlmRelmLcyAmt="
				+ eCrlmRelmLcyAmt + ", ePastDueAmt=" + ePastDueAmt
				+ ", eRtlIntr=" + eRtlIntr + ", eAnfee=" + eAnfee + ", eMdue="
				+ eMdue + ", eClt2=" + eClt2 + ", eLclt2=" + eLclt2
				+ ", eAvailclt=" + eAvailclt + ", eTotAmtDue=" + eTotAmtDue
				+ ", lastCashTransactionDt=" + lastCashTransactionDt
				+ ", lastRetailTransactionDt=" + lastRetailTransactionDt
				+ ", arrangementNextPaymentDue=" + arrangementNextPaymentDue
				+ ", lstReageDt=" + lstReageDt + ", lstCreditLimitChangeDt="
				+ lstCreditLimitChangeDt + ", estimatedEndDate="
				+ estimatedEndDate + ", localProductId=" + localProductId
				+ ", localSubProductId=" + localSubProductId
				+ ", creditLimitEndDate=" + creditLimitEndDate
				+ ", arrangementName=" + arrangementName + ", description="
				+ description + ", denominationCurrencyId="
				+ denominationCurrencyId + ", originatingChannelId="
				+ originatingChannelId + ", arrangementPurposeTypeId="
				+ arrangementPurposeTypeId + ", pledgedIndicator="
				+ pledgedIndicator + ", pledgeEligibilityIndicator="
				+ pledgeEligibilityIndicator + ", gracePeriodDayCount="
				+ gracePeriodDayCount
				+ ", arrangementPastDueAgingClassificationDate="
				+ arrangementPastDueAgingClassificationDate
				+ ", arrangementFinancialStatusReasonTypeId="
				+ arrangementFinancialStatusReasonTypeId
				+ ", arrangementAcquisitionTypeId="
				+ arrangementAcquisitionTypeId
				+ ", arrangementDispositionTypeId="
				+ arrangementDispositionTypeId
				+ ", arrangementDispositionDate=" + arrangementDispositionDate
				+ ", originatororInvestorInsuredCategoryId="
				+ originatororInvestorInsuredCategoryId
				+ ", originatororInvestorInsuredActiveFlag="
				+ originatororInvestorInsuredActiveFlag
				+ ", originatororInvestorInsuredPercentage="
				+ originatororInvestorInsuredPercentage
				+ ", previousorLastInterestRateResetDate="
				+ previousorLastInterestRateResetDate
				+ ", onlineBankingRelationshipIndicator="
				+ onlineBankingRelationshipIndicator
				+ ", interestOnlyTermPeriod=" + interestOnlyTermPeriod
				+ ", finServRestCurrentStatDate=" + finServRestCurrentStatDate
				+ ", finServPrevRestructureStatId="
				+ finServPrevRestructureStatId
				+ ", financeServiceRestructurePreviousStatusDate="
				+ financeServiceRestructurePreviousStatusDate
				+ ", eMktRateYieldAtRenegotiationFlag="
				+ eMktRateYieldAtRenegotiationFlag + ", overlimitIndicator="
				+ overlimitIndicator + ", skipPaymentIndicator="
				+ skipPaymentIndicator + ", securitizedIndicator="
				+ securitizedIndicator + ", tRPPTenor=" + tRPPTenor
				+ ", accountTRPPInstallmentAmount="
				+ accountTRPPInstallmentAmount + ", incomeDocumentationTypeId="
				+ incomeDocumentationTypeId
				+ ", financeServiceModificationProgramStartDate="
				+ financeServiceModificationProgramStartDate
				+ ", financeServiceModificationProgramEndDate="
				+ financeServiceModificationProgramEndDate
				+ ", financeServiceModificationProgramId="
				+ financeServiceModificationProgramId
				+ ", financeServiceModificationProgramCurrentStatus="
				+ financeServiceModificationProgramCurrentStatus
				+ ", financeServiceModificationProgramCurrentStatusDate="
				+ financeServiceModificationProgramCurrentStatusDate
				+ ", financeServiceModificationProgramPreviousStatusTypeId="
				+ financeServiceModificationProgramPreviousStatusTypeId
				+ ", modificationRetentionorLossMitigationTypeId="
				+ modificationRetentionorLossMitigationTypeId
				+ ", creditFacilityRegulatorySegmentTypeId="
				+ creditFacilityRegulatorySegmentTypeId
				+ ", creditCardPortfolioId1=" + creditCardPortfolioId1
				+ ", creditCardPortfolioId2=" + creditCardPortfolioId2
				+ ", creditCardPortfolioId3=" + creditCardPortfolioId3
				+ ", creditCardTypeId1=" + creditCardTypeId1
				+ ", creditCardTypeId2=" + creditCardTypeId2
				+ ", noPresetSpendingLimitIndicator="
				+ noPresetSpendingLimitIndicator + ", creditLimitChangeTypeId="
				+ creditLimitChangeTypeId + ", reageMethodType="
				+ reageMethodType + ", aLOPStartDate=" + aLOPStartDate
				+ ", aLOPEndDate=" + aLOPEndDate + ", previousALOPStartDate="
				+ previousALOPStartDate + ", previousALOPEndDate="
				+ previousALOPEndDate + ", lOPStartDate=" + lOPStartDate
				+ ", lOPEndDate=" + lOPEndDate + ", previousLOPStartDate="
				+ previousLOPStartDate + ", previousLOPEndDate="
				+ previousLOPEndDate + ", ePPStartDate=" + ePPStartDate
				+ ", ePPEndDate=" + ePPEndDate + ", previousEPPStartDate="
				+ previousEPPStartDate + ", previousEPPEndDate="
				+ previousEPPEndDate + ", arrangementNextPaymentDuetoBankDate="
				+ arrangementNextPaymentDuetoBankDate
				+ ", missedPaymentsNumber=" + missedPaymentsNumber
				+ ", nextMembershipFeePaymentDueDate="
				+ nextMembershipFeePaymentDueDate
				+ ", accountLastRecoveryDate=" + accountLastRecoveryDate
				+ ", lastBalanceTransferDate=" + lastBalanceTransferDate
				+ ", totalBalconTransactions=" + totalBalconTransactions
				+ ", accountLastInstallmentDate=" + accountLastInstallmentDate
				+ ", rewardCostPointEarned=" + rewardCostPointEarned
				+ ", rewardCostRate=" + rewardCostRate
				+ ", lastCustomerServiceMinimumPaymentDueAdjustmentAmount="
				+ lastCustomerServiceMinimumPaymentDueAdjustmentAmount
				+ ", totalPayments=" + totalPayments
				+ ", accountLastInterestReviewDate="
				+ accountLastInterestReviewDate + ", totalALOPTransactions="
				+ totalALOPTransactions + ", totalLOPTransactions="
				+ totalLOPTransactions + ", totalEPPTransactions="
				+ totalEPPTransactions + ", otherAlternateIdentifier="
				+ otherAlternateIdentifier + ", previousAccountReasonTypeId="
				+ previousAccountReasonTypeId + ", localProductCategoryCode="
				+ localProductCategoryCode + ", noticePeriodDays="
				+ noticePeriodDays + ", creditLimitEventInitiationTypeId="
				+ creditLimitEventInitiationTypeId + ", bankruptcyDate="
				+ bankruptcyDate + ", ePromoInterestRateEligibleFlag="
				+ ePromoInterestRateEligibleFlag
				+ ", originalUnadvisedUncommittedLimit="
				+ originalUnadvisedUncommittedLimit
				+ ", originalPurchaseLimit=" + originalPurchaseLimit
				+ ", originalCashLimit=" + originalCashLimit
				+ ", pMACPortfolioID=" + pMACPortfolioID
				+ ", originalAccountNumber=" + originalAccountNumber
				+ ", daysPastDueCycleEnd=" + daysPastDueCycleEnd
				+ ", reservedforfutureGenesisusage1="
				+ reservedforfutureGenesisusage1
				+ ", reservedforfutureGenesisusage2="
				+ reservedforfutureGenesisusage2
				+ ", reservedforfutureGenesisusage3="
				+ reservedforfutureGenesisusage3
				+ ", reservedforfutureGenesisusage4="
				+ reservedforfutureGenesisusage4
				+ ", reservedforfutureGenesisusage5="
				+ reservedforfutureGenesisusage5
				+ ", reservedforfutureGenesisusage6="
				+ reservedforfutureGenesisusage6
				+ ", reservedforfutureGenesisusage7="
				+ reservedforfutureGenesisusage7
				+ ", reservedforfutureGenesisusage8="
				+ reservedforfutureGenesisusage8
				+ ", reservedforfutureGenesisusage9="
				+ reservedforfutureGenesisusage9
				+ ", reservedforfutureGenesisusage10="
				+ reservedforfutureGenesisusage10
				+ ", reservedforfutureGenesisusage11="
				+ reservedforfutureGenesisusage11
				+ ", reservedforfutureGenesisusage12="
				+ reservedforfutureGenesisusage12
				+ ", reservedforfutureGenesisusage13="
				+ reservedforfutureGenesisusage13
				+ ", reservedforfutureGenesisusage14="
				+ reservedforfutureGenesisusage14
				+ ", reservedforfutureGenesisusage15="
				+ reservedforfutureGenesisusage15
				+ ", reservedforfutureGenesisusage16="
				+ reservedforfutureGenesisusage16
				+ ", reservedforfutureGenesisusage17="
				+ reservedforfutureGenesisusage17
				+ ", reservedforfutureGenesisusage18="
				+ reservedforfutureGenesisusage18
				+ ", reservedforfutureGenesisusage19="
				+ reservedforfutureGenesisusage19
				+ ", reservedforfutureGenesisusage20="
				+ reservedforfutureGenesisusage20
				+ ", reservedforfutureGenesisusage21="
				+ reservedforfutureGenesisusage21 + ", creditLimitEventAmt="
				+ creditLimitEventAmt + ", originalAdvisedCommittedLimit="
				+ originalAdvisedCommittedLimit + ", eRatingTypeCode="
				+ eRatingTypeCode + ", eSpreadRatePercent="
				+ eSpreadRatePercent + ", eArrangeRateTypeRltnpType="
				+ eArrangeRateTypeRltnpType + ", eRateId=" + eRateId
				+ ", eRateName=" + eRateName + ", eRateTypeEffDate="
				+ eRateTypeEffDate + ", eGeneralLedgerSysId="
				+ eGeneralLedgerSysId + ", eDealId=" + eDealId + ", eBalType="
				+ eBalType + ", eGLAccount1=" + eGLAccount1 + ", eGLAccount2="
				+ eGLAccount2 + ", eFdlAccount=" + eFdlAccount + ", eTxnAmt="
				+ eTxnAmt + ", eBaseAmt=" + eBaseAmt + ", eGOC=" + eGOC
				+ ", eBookingLedgerBranchCode=" + eBookingLedgerBranchCode
				+ ", eFrsBUCode=" + eFrsBUCode + ", eLocalDeptId="
				+ eLocalDeptId + ", eLocalLegalVehicleId="
				+ eLocalLegalVehicleId + ", eFairValueAccountingMethodFlag="
				+ eFairValueAccountingMethodFlag + ", eFairValueLevel="
				+ eFairValueLevel + ", eLocalProductCode=" + eLocalProductCode
				+ ", eFrsAffiliateCode=" + eFrsAffiliateCode
				+ ", eSubStrategyCode=" + eSubStrategyCode
				+ ", eMicroControlStratCode=" + eMicroControlStratCode
				+ ", eFirmAcctImsNumber=" + eFirmAcctImsNumber
				+ ", eLocalAffiliateCode=" + eLocalAffiliateCode + ", eIdProd="
				+ eIdProd + ", eKeyCode1=" + eKeyCode1 + ", eKeyCode2="
				+ eKeyCode2 + ", eLocalLedgerAcctNumber="
				+ eLocalLedgerAcctNumber + ", eAdjInd=" + eAdjInd + ", eSoeId="
				+ eSoeId + ", eAdjReasonCode=" + eAdjReasonCode
				+ ", eComments=" + eComments + ", eLocalGLKey3=" + eLocalGLKey3
				+ ", eLocalGLKey4=" + eLocalGLKey4 + ", eAdjStdArrngId="
				+ eAdjStdArrngId + ", eAdjFinMktPosId=" + eAdjFinMktPosId
				+ ", eCredCardTypId2=" + eCredCardTypId2
				+ ", eLossMitgStartDate=" + eLossMitgStartDate
				+ ", eResrcItemValuationMthdId=" + eResrcItemValuationMthdId
				+ ", eResrcItemBalCurrId=" + eResrcItemBalCurrId
				+ ", eResrcItemBalTypId=" + eResrcItemBalTypId
				+ ", eArrgnTypId=" + eArrgnTypId + ", eLoanAssestRelnType="
				+ eLoanAssestRelnType + ", eLocalProdId=" + eLocalProdId
				+ ", eEstmEndDate=" + eEstmEndDate + ", eModTyp=" + eModTyp
				+ ", eRatModTypId=" + eRatModTypId + ", eLossMitgCnt="
				+ eLossMitgCnt + ", eLossMitgEndDate=" + eLossMitgEndDate
				+ ", eLossMitgFDICTypId=" + eLossMitgFDICTypId
				+ ", eRestModFlg=" + eRestModFlg + ", eTrbdDebtRestFlg="
				+ eTrbdDebtRestFlg + ", eLossMitgPrgmId=" + eLossMitgPrgmId
				+ ", eLossMitgTypId=" + eLossMitgTypId + ", eGSupSeqNum="
				+ eGSupSeqNum + ", eGSupTypId=" + eGSupTypId
				+ ", eGSupCovBasTypId=" + eGSupCovBasTypId + ", eGSubCovTypId="
				+ eGSubCovTypId + ", eGEffDate=" + eGEffDate + ", eGEndDate="
				+ eGEndDate + ", eISupTypId=" + eISupTypId
				+ ", eISupCovBasTypId=" + eISupCovBasTypId + ", eISubCovTypId="
				+ eISubCovTypId + ", eIEffDate=" + eIEffDate + ", eIEndDate="
				+ eIEndDate + ", eArrangEveRltnlpTypId="
				+ eArrangEveRltnlpTypId + ", eCmpCd=" + eCmpCd + ", eCmpTypId="
				+ eCmpTypId + ", eAdjBalance=" + eAdjBalance + ", eAdjMonBlnc="
				+ eAdjMonBlnc + ", eBalType265=" + eBalType265
				+ ", eAirEndDate=" + eAirEndDate + "]";
	}
	public Date geteAIPEndDate() {
		return eAIPEndDate;
	}
	public void setEAIPEndDate(Date eAIPEndDate) {
		this.eAIPEndDate = eAIPEndDate;
	}
	public void seteAIPEndDate(Date eAIPEndDate) {
		this.eAIPEndDate = eAIPEndDate;
	}
	public Date geteAREndDate() {
		return eAREndDate;
	}
	public void setEAREndDate(Date eAREndDate) {
		this.eAREndDate = eAREndDate;
	}
	public void seteAREndDate(Date eAREndDate) {
		this.eAREndDate = eAREndDate;
	}
	
	public String geteMonthsOnBooksLocalInCard() {
		return eMonthsOnBooksLocalInCard;
	}
	public void setEMonthsOnBooksLocalInCard(String eMonthsOnBooksLocalInCard) {
		this.eMonthsOnBooksLocalInCard = eMonthsOnBooksLocalInCard;
	}
	
}
