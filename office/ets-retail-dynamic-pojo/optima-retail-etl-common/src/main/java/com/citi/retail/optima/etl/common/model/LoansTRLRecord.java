package com.citi.retail.optima.etl.common.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LoansTRLRecord extends ExcludableRecord{
		
	private Integer eFinServiceTypId;
	private String eUniqueIdSrcSys;
	private String eRecordType;
	private Date eAsOfDate;
	private String eGlobalProdId;
	private Date eBookingDate;
	private Date eOrgEffctDate;
	private Date eEffectiveDate;
	private Date eArrgBusIntentDate;
	private Integer eArrngMatuTypeId;
	private Date eArrngFinStsDate;
	private Integer eArrngPastDueDayCount;
	private Integer eGracePrdDayCount;
	private Integer eArrgPastDueAgeClass;
	private Date eArrgPastDueAgeClassDate;
	private Integer eArrngLifeCycleStatusId;//Change
	private Integer eArrngLifeCycleStatusReasonTypeId;	
	private Date eArrngLifeCycleStatusDate;
	private String eArrngAcqustnTypeId;
	private Date eArrngAcqustnDate;
	private Integer eArrngDayCntConvTypId;
	private Integer eIntrBasicCalcPeriodId;
	private Date eNxtIntrRateResetDate;
	private Date eIntrAccrualStsDate;
	private String eArrngPurposeTypeId1;
	private String eDelinq30DayPast2YrsFlag;
	private Integer eCreditFacilityTypeId;
	private Integer eFacilLegalStsTypeId;
	private String eEverWrittenOffFlag;
	private String eDescription;
	private Date eEstimEndDate;
	private Date eEndDate;
	private Integer eArrngLifeCycStatReasonTypeId;
	private Integer eArrngPrimaryPymntTypeId;
	private String eLocalProductCode;
	private Integer eAcctTypeId;
	private Integer eChrgOffTypeId;
	private Integer eRemngDaysToMaturity;
	private BigDecimal eOriginalAmt;
	private String eTrblDebtRestructureFlag;
	private Integer ePymntTotalNumbr;
	private BigDecimal ePenaltyAmnt;
	private Date eArrngNextPymtDueToBankDate;
	private BigDecimal eArrngNextPymtDueToBankAmnt;
	private Date eArrngLastPymtToBankDate;
	private BigDecimal eAcctLastPymtToBankAmount;
	private Integer eMissedPymtNumbr;
	private BigDecimal eTotalPymnts;
	private String eBaselPortfolioId;
	private Date eCreditLimitEffctDate;
	private String eCcarProdCode;
	private BigDecimal eTotalFundsDisbAmnt;
	private Integer eDaysPastDueCycEnd;
	private Integer eCycleEndDelinqBucket;
	private String eUniqueIdSrcSysInvlParty;
	private String eArrgInvlvPartyRoleType;
	private BigDecimal ePctAmt;
	//private String eInvlvPartySubTypeId;
	private Integer eRank;
	private String eFicoEquiRatingCode;
	private BigDecimal eEffctRatePercent;
	private String eRateTypeId;
	private String eFuncCurrencyCode;
	private Double eTxnAmt;
	private String eGaapIndicator;
	private String eBaseCurrencyCode;
	private String eEntrProdId;
	private Integer eArrgFinancialStatusTypeId;
	private Date eMtgIndEndDate;
	
	//Changes -- 
	private String eSrcSysId;
	private String eProdSysId;
	private String eInvPtySubtypeId;
	private String eRatingIssuerId;
	private String eModelCode;
	private Integer eRatingEventReasonTypId;
	private String eRatingTypCode;
	private String eRatingDescription;
	private String eScoreReqReturnedFlg;
	private String eRateActiveFlg;
	private Date eRateTypEffDt;
	private String eDenominationCurrencyId;
	private Integer eArrngBusIntType;
	private String ePledgedIndicator;
	private String ePledgedElgibilityIndicator;
	
	private Date eArrngNextRenewalDate;
	private Date eNextReviewdate;
	private Integer eArrngSecurityTypId;
	private String eRiskMgmntInd;
	
    private Integer eArrgBusIntentType;
	
	private Double ePrinAmt;
	private Double eCostOfCred;
	private Double eTotEnrReceivables;
	private Double eCurAdvComLimit;
	private Double eGrossRecoveryAmt;
	private Date eARGEndDate;
	private Integer eARGRank;
	private Date eARGEffDate;
	private Date eAIPEndDate;
	private Date eAIPEffDate;
	private Date eAREndDate;
	private Integer eCAArrngBusIntType;
	private Date eAIREffDate;
	private Date eAIREndDate;
	
	
	
	
	private Double eBaseAmtCurr;
	
	public Double geteBaseAmtCurr() {
		return eBaseAmtCurr;
	}
	public void setEBaseAmtCurr(Double eBaseAmtCurr) {
		this.eBaseAmtCurr = eBaseAmtCurr;
	}
	
	//Changes -- 
	
	/*//checksum changes
	public static BigDecimal arFinStatTypIDCkSum = new BigDecimal(0);
	public static BigDecimal arPastDueAgeClassCkSum = new BigDecimal(0);*/

	/**
	 * @return the eUniqueIdSrcSys
	 */
	public String geteUniqueIdSrcSys() {
		return eUniqueIdSrcSys;
	}
	/**
	 * @return the ePrinAmt
	 */
	public Double getePrinAmt() {
		return ePrinAmt;
	}
	/**
	 * @param ePrinAmt the ePrinAmt to set
	 */
	public void setEPrinAmt(Double ePrinAmt) {
		this.ePrinAmt = ePrinAmt;
	}
	/**
	 * @return the eCostOfCred
	 */
	public Double geteCostOfCred() {
		return eCostOfCred;
	}
	/**
	 * @param eCostOfCred the eCostOfCred to set
	 */
	public void setECostOfCred(Double eCostOfCred) {
		this.eCostOfCred = eCostOfCred;
	}
	/**
	 * @return the eTotEnrReceivables
	 */
	public Double geteTotEnrReceivables() {
		return eTotEnrReceivables;
	}
	/**
	 * @param eTotEnrReceivables the eTotEnrReceivables to set
	 */
	public void setETotEnrReceivables(Double eTotEnrReceivables) {
		this.eTotEnrReceivables = eTotEnrReceivables;
	}
	/**
	 * @return the eCurAdvComLimit
	 */
	public Double geteCurAdvComLimit() {
		return eCurAdvComLimit;
	}
	/**
	 * @param eCurAdvComLimit the eCurAdvComLimit to set
	 */
	public void setECurAdvComLimit(Double eCurAdvComLimit) {
		this.eCurAdvComLimit = eCurAdvComLimit;
	}
	/**
	 * @return the eGrossRecoveryAmt
	 */
	public Double geteGrossRecoveryAmt() {
		return eGrossRecoveryAmt;
	}
	/**
	 * @param eGrossRecoveryAmt the eGrossRecoveryAmt to set
	 */
	public void setEGrossRecoveryAmt(Double eGrossRecoveryAmt) {
		this.eGrossRecoveryAmt = eGrossRecoveryAmt;
	}
	/**
	 * @param eUniqueIdSrcSys the eUniqueIdSrcSys to set
	 */
	public void setEUniqueIdSrcSys(String eUniqueIdSrcSys) {
		this.eUniqueIdSrcSys = eUniqueIdSrcSys;
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
	 * @return the eGlobalProdId
	 */
	public String geteGlobalProdId() {
		return eGlobalProdId;
	}
	/**
	 * @param eGlobalProdId the eGlobalProdId to set
	 */
	public void setEGlobalProdId(String eGlobalProdId) {
		this.eGlobalProdId = eGlobalProdId;
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
	 * @return the eOrgEffctDate
	 */
	public Date geteOrgEffctDate() {
		return eOrgEffctDate;
	}
	/**
	 * @param eOrgEffctDate the eOrgEffctDate to set
	 */
	public void setEOrgEffctDate(Date eOrgEffctDate) {
		this.eOrgEffctDate = eOrgEffctDate;
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
	 * @return the eArrgBusIntentDate
	 */
	public Date geteArrgBusIntentDate() {
		return eArrgBusIntentDate;
	}
	/**
	 * @param eArrgBusIntentDate the eArrgBusIntentDate to set
	 */
	public void setEArrgBusIntentDate(Date eArrgBusIntentDate) {
		this.eArrgBusIntentDate = eArrgBusIntentDate;
	}
	/**
	 * @return the eArrngMatuTypeId
	 */
	public Integer geteArrngMatuTypeId() {
		return eArrngMatuTypeId;
	}
	/**
	 * @param eArrngMatuTypeId the eArrngMatuTypeId to set
	 */
	public void setEArrngMatuTypeId(Integer eArrngMatuTypeId) {
		this.eArrngMatuTypeId = eArrngMatuTypeId;
	}
	/**
	 * @return the eArrngFinStsDate
	 */
	public Date geteArrngFinStsDate() {
		return eArrngFinStsDate;
	}
	/**
	 * @param eArrngFinStsDate the eArrngFinStsDate to set
	 */
	public void setEArrngFinStsDate(Date eArrngFinStsDate) {
		this.eArrngFinStsDate = eArrngFinStsDate;
	}

	/**
	 * @return the eArrngPastDueDayCount
	 */
	public Integer geteArrngPastDueDayCount() {
		return eArrngPastDueDayCount;
	}
	/**
	 * @param eArrngPastDueDayCount the eArrngPastDueDayCount to set
	 */
	public void setEArrngPastDueDayCount(Integer eArrngPastDueDayCount) {
		this.eArrngPastDueDayCount = eArrngPastDueDayCount;
	}


	/**
	 * @return the eGracePrdDayCount
	 */
	public Integer geteGracePrdDayCount() {
		return eGracePrdDayCount;
	}
	/**
	 * @param eGracePrdDayCount the eGracePrdDayCount to set
	 */
	public void setEGracePrdDayCount(Integer eGracePrdDayCount) {
		this.eGracePrdDayCount = eGracePrdDayCount;
	}
	/**
	 * @return the eArrgPastDueAgeClass
	 */
	public Integer geteArrgPastDueAgeClass() {
		return eArrgPastDueAgeClass;
	}
	/**
	 * @param eArrgPastDueAgeClass the eArrgPastDueAgeClass to set
	 */
	public void setEArrgPastDueAgeClass(Integer eArrgPastDueAgeClass) {
		this.eArrgPastDueAgeClass = eArrgPastDueAgeClass;
		/*arPastDueAgeClassCkSum = arPastDueAgeClassCkSum.add(new BigDecimal(eArrgPastDueAgeClass));
		CustomMethodsProvider.setArPastDueAgeClassCkSum(arPastDueAgeClassCkSum);*/
	}
	/**
	 * @return the eArrgPastDueAgeClassDate
	 */
	public Date geteArrgPastDueAgeClassDate() {
		return eArrgPastDueAgeClassDate;
	}
	/**
	 * @param eArrgPastDueAgeClassDate the eArrgPastDueAgeClassDate to set
	 */
	public void setEArrgPastDueAgeClassDate(Date eArrgPastDueAgeClassDate) {
		this.eArrgPastDueAgeClassDate = eArrgPastDueAgeClassDate;
	}
	/**
	 * @return the eArrngLifeCycleStatusTypeId //Change start
	 */
	public Integer geteArrngLifeCycleStatusId() {
		return eArrngLifeCycleStatusId;
	}
	/**
	 * @param eArrngLifeCycleStatusTypeId the eArrngLifeCycleStatusTypeId to set
	 */
	public void setEArrngLifeCycleStatusId(Integer eArrngLifeCycleStatusId) {
		this.eArrngLifeCycleStatusId = eArrngLifeCycleStatusId;//change End
	}
	/**
	 * @return the eArrngLifeCycleStatusDate
	 */
	public Date geteArrngLifeCycleStatusDate() {
		return eArrngLifeCycleStatusDate;
	}
	/**
	 * @param eArrngLifeCycleStatusDate the eArrngLifeCycleStatusDate to set
	 */
	public void setEArrngLifeCycleStatusDate(Date eArrngLifeCycleStatusDate) {
		this.eArrngLifeCycleStatusDate = eArrngLifeCycleStatusDate;
	}
	/**
	 * @return the eArrngAcqustnTypeId
	 */
	public String geteArrngAcqustnTypeId() {
		return eArrngAcqustnTypeId;
	}
	/**
	 * @param eArrngAcqustnTypeId the eArrngAcqustnTypeId to set
	 */
	public void setEArrngAcqustnTypeId(String eArrngAcqustnTypeId) {
		this.eArrngAcqustnTypeId = eArrngAcqustnTypeId;
	}
	/**
	 * @return the eArrngAcqustnDate
	 */
	public Date geteArrngAcqustnDate() {
		return eArrngAcqustnDate;
	}
	/**
	 * @param eArrngAcqustnDate the eArrngAcqustnDate to set
	 */
	public void setEArrngAcqustnDate(Date eArrngAcqustnDate) {
		this.eArrngAcqustnDate = eArrngAcqustnDate;
	}
	/**
	 * @return the eArrngDayCntConvTypId
	 */
	public Integer geteArrngDayCntConvTypId() {
		return eArrngDayCntConvTypId;
	}
	/**
	 * @param eArrngDayCntConvTypId the eArrngDayCntConvTypId to set
	 */
	public void setEArrngDayCntConvTypId(Integer eArrngDayCntConvTypId) {
		this.eArrngDayCntConvTypId = eArrngDayCntConvTypId;
	}
	/**
	 * @return the eIntrBasicCalcPeriodId
	 */
	public Integer geteIntrBasicCalcPeriodId() {
		return eIntrBasicCalcPeriodId;
	}
	/**
	 * @param eIntrBasicCalcPeriodId the eIntrBasicCalcPeriodId to set
	 */
	public void setEIntrBasicCalcPeriodId(Integer eIntrBasicCalcPeriodId) {
		this.eIntrBasicCalcPeriodId = eIntrBasicCalcPeriodId;
	}
	/**
	 * @return the eNxtIntrRateResetDate
	 */
	public Date geteNxtIntrRateResetDate() {
		return eNxtIntrRateResetDate;
	}
	/**
	 * @param eNxtIntrRateResetDate the eNxtIntrRateResetDate to set
	 */
	public void setENxtIntrRateResetDate(Date eNxtIntrRateResetDate) {
		this.eNxtIntrRateResetDate = eNxtIntrRateResetDate;
	}
	/**
	 * @return the eIntrAccrualStsDate
	 */
	public Date geteIntrAccrualStsDate() {
		return eIntrAccrualStsDate;
	}
	/**
	 * @param eIntrAccrualStsDate the eIntrAccrualStsDate to set
	 */
	public void setEIntrAccrualStsDate(Date eIntrAccrualStsDate) {
		this.eIntrAccrualStsDate = eIntrAccrualStsDate;
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
	 * @return the eDelinq30DayPast2YrsFlag
	 */
	public String geteDelinq30DayPast2YrsFlag() {
		return eDelinq30DayPast2YrsFlag;
	}
	/**
	 * @param eDelinq30DayPast2YrsFlag the eDelinq30DayPast2YrsFlag to set
	 */
	public void setEDelinq30DayPast2YrsFlag(String eDelinq30DayPast2YrsFlag) {
		this.eDelinq30DayPast2YrsFlag = eDelinq30DayPast2YrsFlag;
	}
	/**
	 * @return the eCreditFacilityTypeId
	 */
	public Integer geteCreditFacilityTypeId() {
		return eCreditFacilityTypeId;
	}
	/**
	 * @param eCreditFacilityTypeId the eCreditFacilityTypeId to set
	 */
	public void setECreditFacilityTypeId(Integer eCreditFacilityTypeId) {
		this.eCreditFacilityTypeId = eCreditFacilityTypeId;
	}
	/**
	 * @return the eFacilLegalStsTypeId
	 */
	public Integer geteFacilLegalStsTypeId() {
		return eFacilLegalStsTypeId;
	}
	/**
	 * @param eFacilLegalStsTypeId the eFacilLegalStsTypeId to set
	 */
	public void setEFacilLegalStsTypeId(Integer eFacilLegalStsTypeId) {
		this.eFacilLegalStsTypeId = eFacilLegalStsTypeId;
	}
	/**
	 * @return the eEverWrittenOffFlag
	 */
	public String geteEverWrittenOffFlag() {
		return eEverWrittenOffFlag;
	}
	/**
	 * @param eEverWrittenOffFlag the eEverWrittenOffFlag to set
	 */
	public void setEEverWrittenOffFlag(String eEverWrittenOffFlag) {
		this.eEverWrittenOffFlag = eEverWrittenOffFlag;
	}
	/**
	 * @return the eDescription
	 */
	public String geteDescription() {
		return eDescription;
	}
	/**
	 * @param eDescription the eDescription to set
	 */
	public void setEDescription(String eDescription) {
		this.eDescription = eDescription;
	}
	/**
	 * @return the eEstimEndDate
	 */
	public Date geteEstimEndDate() {
		return eEstimEndDate;
	}
	/**
	 * @param eEstimEndDate the eEstimEndDate to set
	 */
	public void setEEstimEndDate(Date eEstimEndDate) {
		this.eEstimEndDate = eEstimEndDate;
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
	 * @return the eArrngLifeCycleStatusReasonTypeId
	 */
	public Integer geteArrngLifeCycStatReasonTypeId() {
		return eArrngLifeCycStatReasonTypeId;
	}
	/**
	 * @param eArrngLifeCycleStatusReasonTypeId the eArrngLifeCycleStatusReasonTypeId to set
	 */
	public void setEArrngLifeCycStatReasonTypeId(
			Integer eArrngLifeCycStatReasonTypeId) {
		this.eArrngLifeCycStatReasonTypeId = eArrngLifeCycStatReasonTypeId;
	}
	/**
	 * @return the eArrngPrimaryPymntTypeId
	 */
	public Integer geteArrngPrimaryPymntTypeId() {
		return eArrngPrimaryPymntTypeId;
	}
	/**
	 * @param eArrngPrimaryPymntTypeId the eArrngPrimaryPymntTypeId to set
	 */
	public void setEArrngPrimaryPymntTypeId(Integer eArrngPrimaryPymntTypeId) {
		this.eArrngPrimaryPymntTypeId = eArrngPrimaryPymntTypeId;
	}
	/**
	 * @return the eLocalProductCode
	 */
	public String geteLocalProductCode() {
		return eLocalProductCode;
	}
	/**
	 * @param eLocalProductCode the eLocalProductCode to set
	 */
	public void setELocalProductCode(String eLocalProductCode) {
		this.eLocalProductCode = eLocalProductCode;
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
	 * @return the eChrgOffTypeId
	 */
	public Integer geteChrgOffTypeId() {
		return eChrgOffTypeId;
	}
	/**
	 * @param eChrgOffTypeId the eChrgOffTypeId to set
	 */
	public void setEChrgOffTypeId(Integer eChrgOffTypeId) {
		this.eChrgOffTypeId = eChrgOffTypeId;
	}
	/**
	 * @return the eRemngDaysToMaturity
	 */
	public Integer geteRemngDaysToMaturity() {
		return eRemngDaysToMaturity;
	}
	/**
	 * @param eRemngDaysToMaturity the eRemngDaysToMaturity to set
	 */
	public void setERemngDaysToMaturity(Integer eRemngDaysToMaturity) {
		this.eRemngDaysToMaturity = eRemngDaysToMaturity;
	}
	/**
	 * @return the eOriginalAmt
	 */
	public BigDecimal geteOriginalAmt() {
		return eOriginalAmt;
	}
	/**
	 * @param eOriginalAmt the eOriginalAmt to set
	 */
	public void setEOriginalAmt(Double eOriginalAmt) {
		if(eOriginalAmt == null){
			this.eOriginalAmt = null;
		}else if(eOriginalAmt == 0){
			this.eOriginalAmt = new BigDecimal(0);
		}else{
			this.eOriginalAmt = new BigDecimal(eOriginalAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
	}
	/**
	 * @return the eTrblDebtRestructureFlag
	 */
	public String geteTrblDebtRestructureFlag() {
		return eTrblDebtRestructureFlag;
	}
	/**
	 * @param eTrblDebtRestructureFlag the eTrblDebtRestructureFlag to set
	 */
	public void setETrblDebtRestructureFlag(String eTrblDebtRestructureFlag) {
		this.eTrblDebtRestructureFlag = eTrblDebtRestructureFlag;
	}
	/**
	 * @return the ePymntTotalNumbr
	 */
	public Integer getePymntTotalNumbr() {
		return ePymntTotalNumbr;
	}
	/**
	 * @param ePymntTotalNumbr the ePymntTotalNumbr to set
	 */
	public void setEPymntTotalNumbr(Integer ePymntTotalNumbr) {
		this.ePymntTotalNumbr = ePymntTotalNumbr;
	}
	/**
	 * @return the ePenaltyAmnt
	 */
	public BigDecimal getePenaltyAmnt() {
		return ePenaltyAmnt;
	}
	/**
	 * @param ePenaltyAmnt the ePenaltyAmnt to set
	 */
	public void setEPenaltyAmnt(Long ePenaltyAmnt) {
		if(ePenaltyAmnt == null){
			this.ePenaltyAmnt = null;
		}else if(ePenaltyAmnt == 0){
			this.ePenaltyAmnt = new BigDecimal(0);
		}else{
			this.ePenaltyAmnt = new BigDecimal(ePenaltyAmnt).setScale(5,BigDecimal.ROUND_HALF_UP);
		}
		
	}
	/**
	 * @return the eArrngNextPymntDueToBankDate
	 */
	public Date geteArrngNextPymtDueToBankDate() {
		return eArrngNextPymtDueToBankDate;
	}
	/**
	 * @param eArrngNextPymntDueToBankDate the eArrngNextPymntDueToBankDate to set
	 */
	public void setEArrngNextPymtDueToBankDate(Date eArrngNextPymtDueToBankDate) {
		this.eArrngNextPymtDueToBankDate = eArrngNextPymtDueToBankDate;
	}
	/**
	 * @return the eArrngNextPymntDueToBankAmnt
	 */
	public BigDecimal geteArrngNextPymtDueToBankAmnt() {
		return eArrngNextPymtDueToBankAmnt;
	}
	/**
	 * @param eArrngNextPymntDueToBankAmnt the eArrngNextPymntDueToBankAmnt to set
	 */
	public void setEArrngNextPymtDueToBankAmnt(Long eArrngNextPymtDueToBankAmnt) {
		if(eArrngNextPymtDueToBankAmnt == null){
			this.eArrngNextPymtDueToBankAmnt = null;
		}else if(eArrngNextPymtDueToBankAmnt == 0){
			this.eArrngNextPymtDueToBankAmnt = new BigDecimal(0);
		}else{
			this.eArrngNextPymtDueToBankAmnt = new BigDecimal(eArrngNextPymtDueToBankAmnt).setScale(5,BigDecimal.ROUND_HALF_UP);
		}
	}
	/**
	 * @return the eArrngLastPymntToBankDate
	 */
	public Date geteArrngLastPymtToBankDate() {
		return eArrngLastPymtToBankDate;
	}
	/**
	 * @param eArrngLastPymntToBankDate the eArrngLastPymntToBankDate to set
	 */
	public void setEArrngLastPymtToBankDate(Date eArrngLastPymtToBankDate) {
		this.eArrngLastPymtToBankDate = eArrngLastPymtToBankDate;
	}
	/**
	 * @return the eAcctLastPymntToBankAmount
	 */
	public BigDecimal getAcctLastPymtToBankAmount() {
		return eAcctLastPymtToBankAmount;
	}
	/**
	 * @param eAcctLastPymntToBankAmount the eAcctLastPymntToBankAmount to set
	 */
	public void setEAcctLastPymtToBankAmount(Long eAcctLastPymtToBankAmount) {
		if(eAcctLastPymtToBankAmount == null){
			this.eAcctLastPymtToBankAmount = null;
		}else if(eAcctLastPymtToBankAmount == 0){
			this.eAcctLastPymtToBankAmount = new BigDecimal(0);
		}else{
			this.eAcctLastPymtToBankAmount = new BigDecimal(eAcctLastPymtToBankAmount).setScale(5,BigDecimal.ROUND_HALF_UP);;
		}
	}
	/**
	 * @return the eMissedPymntNumbr
	 */
	public Integer geteMissedPymtNumbr() {
		return eMissedPymtNumbr;
	}
	/**
	 * @param eMissedPymntNumbr the eMissedPymntNumbr to set
	 */
	public void setEMissedPymtNumbr(Integer eMissedPymtNumbr) {
		this.eMissedPymtNumbr = eMissedPymtNumbr;
	}
	/**
	 * @return the eTotalPymnts
	 */
	public BigDecimal geteTotalPymnts() {
		return eTotalPymnts;
	}
	/**
	 * @param eTotalPymnts the eTotalPymnts to set
	 */
	public void setETotalPymnts(Long eTotalPymnts) {
		if(eTotalPymnts == null){
			this.eTotalPymnts = null;
		}else if(eTotalPymnts == 0){
			this.eTotalPymnts = new BigDecimal(0);
		}else{
			this.eTotalPymnts = new BigDecimal(eTotalPymnts).setScale(5,BigDecimal.ROUND_HALF_UP);
		}
		
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
	 * @return the eCreditLimitEffctDate
	 */
	public Date geteCreditLimitEffctDate() {
		return eCreditLimitEffctDate;
	}
	/**
	 * @param eCreditLimitEffctDate the eCreditLimitEffctDate to set
	 */
	public void setECreditLimitEffctDate(Date eCreditLimitEffctDate) {
		this.eCreditLimitEffctDate = eCreditLimitEffctDate;
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
	 * @return the eTotalFundsDisbAmnt
	 */
	public BigDecimal geteTotalFundsDisbAmnt() {
		return eTotalFundsDisbAmnt;
	}
	/**
	 * @param eTotalFundsDisbAmnt the eTotalFundsDisbAmnt to set
	 */
	public void setETotalFundsDisbAmnt(Long eTotalFundsDisbAmnt) {
		if(eTotalFundsDisbAmnt == null){
			this.eTotalFundsDisbAmnt = null;
		}else if(eTotalFundsDisbAmnt == 0){
			this.eTotalFundsDisbAmnt = new BigDecimal(0);
		}else{
			this.eTotalFundsDisbAmnt = new BigDecimal(eTotalFundsDisbAmnt).setScale(10,BigDecimal.ROUND_HALF_UP);;
		}
		
	}
	/**
	 * @return the eDaysPastDueCycEnd
	 */
	public Integer geteDaysPastDueCycEnd() {
		return eDaysPastDueCycEnd;
	}
	/**
	 * @param eDaysPastDueCycEnd the eDaysPastDueCycEnd to set
	 */
	public void setEDaysPastDueCycEnd(Integer eDaysPastDueCycEnd) {
		this.eDaysPastDueCycEnd = eDaysPastDueCycEnd;
	}
	/**
	 * @return the eCycleEndDelinqBucket
	 */
	public Integer geteCycleEndDelinqBucket() {
		return eCycleEndDelinqBucket;
	}
	/**
	 * @param eCycleEndDelinqBucket the eCycleEndDelinqBucket to set
	 */
	public void setECycleEndDelinqBucket(Integer eCycleEndDelinqBucket) {
		this.eCycleEndDelinqBucket = eCycleEndDelinqBucket;
	}
	/**
	 * @return the eUniqueIdSrsSysInvIParty
	 */
	public String geteUniqueIdSrcSysInvlParty() {
		return eUniqueIdSrcSysInvlParty;
	}
	/**
	 * @param eUniqueIdSrsSysInvIParty the eUniqueIdSrsSysInvIParty to set
	 */
	public void setEUniqueIdSrcSysInvlParty(String eUniqueIdSrcSysInvlParty) {
		this.eUniqueIdSrcSysInvlParty = eUniqueIdSrcSysInvlParty;
	}
	/**
	 * @return the eArrgInvIvPartyRoleType
	 */
	public String geteArrgInvlvPartyRoleType() {
		return eArrgInvlvPartyRoleType;
	}
	/**
	 * @param eArrgInvIvPartyRoleType the eArrgInvIvPartyRoleType to set
	 */
	public void setEArrgInvlvPartyRoleType(String eArrgInvlvPartyRoleType) {
		this.eArrgInvlvPartyRoleType = eArrgInvlvPartyRoleType;
	}
	/**
	 * @return the ePercentAmnt
	 */
	public BigDecimal getePctAmt() {
		return ePctAmt;
	}
	/**
	 * @param ePercentAmnt the ePercentAmnt to set
	 */
	public void setEPctAmt(Integer ePctAmt) {
		if(ePctAmt == null){
			this.ePctAmt = null;
		}else if(ePctAmt == 0){
			this.ePctAmt = new BigDecimal(0);
		}else{
			this.ePctAmt = new BigDecimal(ePctAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
		
	}
//	/**
//	 * @return the eInvIvPartySubTypeId-- Change
//	 */
//	public String geteInvlvPartySubTypeId() {
//		return eInvlvPartySubTypeId;
//	}
//	/**
//	 * @param eInvIvPartySubTypeId the eInvIvPartySubTypeId to set
//	 */
//	public void setEInvIvPartySubTypeId(String eInvlvPartySubTypeId) {
//		this.eInvlvPartySubTypeId = eInvlvPartySubTypeId;
//	} // Change
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
	 * @return the eEffctRatePercent
	 */
	public BigDecimal geteEffctRatePercent() {
		return eEffctRatePercent;
	}
	/**
	 * @param eEffctRatePercent the eEffctRatePercent to set
	 */
	public void setEEffctRatePercent(Long eEffctRatePercent) {
		if(eEffctRatePercent == null){
			this.eEffctRatePercent = null;
		}else if(eEffctRatePercent == 0){
			this.eEffctRatePercent = new BigDecimal(0);
		}else{
			this.eEffctRatePercent =new BigDecimal(eEffctRatePercent).setScale(8,BigDecimal.ROUND_HALF_UP);
		}
		 
	}
	/**
	 * @return the eRateTypeId
	 */
	public String geteRateTypeId() {
		return eRateTypeId;
	}
	/**
	 * @param eRateTypeId the eRateTypeId to set
	 */
	public void setERateTypeId(String eRateTypeId) {
		this.eRateTypeId = eRateTypeId;
	}
	/**
	 * @return the eFuncCurrencyCode
	 */
	public String geteFuncCurrencyCode() {
		return eFuncCurrencyCode;
	}
	/**
	 * @param eFuncCurrencyCode the eFuncCurrencyCode to set
	 */
	public void setEFuncCurrencyCode(String eFuncCurrencyCode) {
		this.eFuncCurrencyCode = eFuncCurrencyCode;
	}
	/**
	 * @return the eTransactianlaAmnt
	 */
	public Double geteTxnAmt() {
		return eTxnAmt;
	}
	/**
	 * @param eTransactianlaAmnt the eTransactianlaAmnt to set
	 */
	public void setETxnAmt(Double eTxnAmt) {
		this.eTxnAmt = eTxnAmt;
	}
	/**
	 * @return the eGaapIndicator
	 */
	public String geteGaapIndicator() {
		return eGaapIndicator;
	}
	/**
	 * @param eGaapIndicator the eGaapIndicator to set
	 */
	public void setEGaapIndicator(String eGaapIndicator) {
		this.eGaapIndicator = eGaapIndicator;
	}
	/**
	 * @return the eBaseCurrencyCode
	 */
	public String geteBaseCurrencyCode() {
		return eBaseCurrencyCode;
	}
	/**
	 * @param eBaseCurrencyCode the eBaseCurrencyCode to set
	 */
	public void setEBaseCurrencyCode(String eBaseCurrencyCode) {
		this.eBaseCurrencyCode = eBaseCurrencyCode;
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
	 * @return the eArrgFinancialStatusTypeId
	 */
	public Integer geteArrgFinancialStatusTypeId() {
		return eArrgFinancialStatusTypeId;
	}
	/**
	 * @param eArrgFinancialStatusTypeId the eArrgFinancialStatusTypeId to set
	 */
	public void setEArrgFinancialStatusTypeId(Integer eArrgFinancialStatusTypeId) {
		this.eArrgFinancialStatusTypeId = eArrgFinancialStatusTypeId;
	}
	/**
	 * @return the eFinServiceTypId
	 */
	public Integer geteFinServiceTypId() {
		return eFinServiceTypId;
	}
	/**
	 * @param eFinServiceTypId the eFinServiceTypId to set
	 */
	public void setEFinServiceTypId(Integer eFinServiceTypId) {
		this.eFinServiceTypId = eFinServiceTypId;
	}
	/**
	 * @return the srcSysIdentifier
	 */
		
	//private String srcSysIdentifier; -- Change
	//private String prodSysIdentifier; -- Change
	private String arrangmentName;
	private String arrangementTypeId;
	//private String denominationCurrencyId;--Change
	private String eOriginatingChannelId;
	//private String arrgBusIntentType;Change
	//private String pledgedIndicator;Change
	//private String pledgedElgibilityIndicator change;
	private String eArrngFinStsType;
	//private String arrngNextRenewalDate change;
	//private String nextReviewdate;
	private String localSubProductCode;
	private String eLocalProdCategoryCode;//change
	private String originalCampaignId;
	private String feeWaiverFlag;
	private String feeWaiverExpiryDate;
	private String arrangementDispositionTypeId;
	private String arrangementDispositionDate;
	private String investorInsuredCategory;
	private String investorInsuredActiveFlag;
	private String investorInsuredPercentage;
	private Integer eIntrPymntFrequencyPeriodicityId;
	private String feePymntFrequencyPeriodicityId;
	private String eRateResetPeriodicityIntId;
	private String inititalIntrRateResetDt;
	private String lastIntrRateResetDt;
	private String atmCardFlag;
	private String islamicAcctIndicator;
	private String taxExemptIndicator;
	private String onlineBankingInd;
	private String financeServiceTypId;
	private String obligorRecourseInd;
	private String citiRecourseInd;
	private String pymtFreqPeriodicityId;
	private String negativeAmortizationFlg;
	private String ballonRepymntInd;
	private String eIntrstAccrualStatTypId;//Change
	private String intrOnlyTermPd;
	private String principalGracePeriod;
	private String noticePeriodDays;
	private String acquisitionCost;
	private String finServiceCurrReStsId;
	private String finServiceCurrReStsDt;
	private String finServiceReTypId;
	private String finServicePreStsId;
	private String finServicePreStsDt;
	private String finServiceModPgmId;
	private String finServiceModPgmStrtDt;
	private String finServiceModPgmCurrSts;
	private String finServiceModPgmCurrStsDt;
	private String finServiceModPgmEndDt;
	private String finServiceModPgmPreStsDt;
	private String finServLimitTypId;
	private String currFinServPrincplRpymntTypId;
	private String restrctFlg;
	private String mktRtYldRenegtnFlag;
	private String overlmtInd;
	private String skipPymntInd;
	private String amortAccretionInd;
	private String secInd;
	private String modRetention;
	private String regOEmpFlg;
	private String trppTenor;
	private String accTrppInstamtamt;
	private String lnCrdtAutomaticExtFlg;
	private String lnCrdtTermLnConvFlg;
	private String incmeDocTypId;
	private String crdtDevinInd;
	private String remainingPymntNumbr;
	private String preComputedLoanFlg;
	private String premiumLoanFlg;
	private String ppIntrRefNo;
	private String localWarehouseRef;
	private String upStrmSysRef;
	private String custTradeRef;
	private String arrngPurposeTypeId2;
	private String arrngPurposeTypeId3;
	private String penaltyRate;
	private String legalNotificationDays;
	private String accntFirstAdvDt;
	private String accntFirstAdvAmnt;
	private String acctFirstPymntDate;
	private String acctFirstPymntAmnt;
	private String acctLstAdvDt;
	private String acctLstAdvAmnt;
	private String acctLstRecDt;
	private String acctLstInstDt;
	private String acctLstIntrreviewDt;
	private String lstIntrCollectionDt;
	//private String arrngSecurityTypId --Change;
	private String lienPosTypId;
	private String PD;
	private String otherAlternateId;
	private String facilLegalStsTypeDt;
	private Integer eCreditFacArrngApprTypId;
	private String creditFacArrngApprDt;
	private String creditFacReguSgmntTypId;
	private String creditFacAvailStsTypId;
	private String origAdvisedComLmt;
	private String origAdvisedUncomLmt;
	private String origUnAdvisedUncomLmt;
	private String lstCreditLmtChngDt;
	private String crdtLmtChngTypId;
	private String crdtLmtEndDt;
	private String crdtLmtEvtIniTypId;
	private String crdtLmtEvtAmnt;
	private Date bankruptcyDt;
	private String promoIntrRtElgFlg;
	private String ePmacId;
	private String origAcctNum;
	private Date eLstWriteDownDt;
	private String currNgvAmortFlg;
	private String princDeferralOptionFlg;
	private String princDeferralOptionEndDate;
	private String interestDeferralOptionFlg;
	private String interestDeferralOptionEndDt;
	private String interestOnlyOptionEndDt;
	private String acctFundsAdvCompltFlg;
	private Integer eMonthsOnBooksLocal;
	//private String riskMgmntInd;
	private String eDelBucket;
	//private String ratingIssuerId;change
	//private String modelCode;Change
	//private String ratingEventReasonTypId;
	//private String ratingTypCode;CHANGE
	private String eRatingCode;
	//private String ratingDescription;Change
	//private String scoreReqReturnedFlg;Change
	private String spreadRatePercent;
	private String arrngRelationshipTypeId;
	private String rateId;
	private String rateName;
	private Integer eRateVarTypeId;
    private Integer eRateVariabilityTypId;
	//private String rateTypEffDt;
	//private String rateActiveFlg;
	private String legNumber;
	private String generalLedgerSysId;
	private String dealId;
	private String bookingLedgerCC;
	private String balanceTyp;
	private String eGLAccount1;
	private String glAcct2;
	private String fdlAcct;
	private String eTransCurr;
	private String funcCurrCode;
	private BigDecimal functionalAmt;
	private String baseAmt;
	private String goc;
	private String bookingLedgerBranchCode;
	private String frsBUCode;
	private String notForUse;
	private String localDeptId;
	private String eLocalLegalVehicleId;
	private String fairValueAccMethodFlg;
	private String fairValue;
	private String expenseCode;
	private String frsAffCode;
	private String subStrategyCode;
	private String microControlStratCode;
	private String firmAcctIMSNo;
	private String baseNo;
	private String prodId;
	private String keyCode1;
	private String keyCode2;
	private String localLedgerAcctNo;
	private String adjInd;
	private String userId;
	private String adjReasonCode;
	private String comment;
	private String localGlKey3;
	private String localGlKey4;
	private String adjStdArrngId;
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
	private Integer eBalType;
	private List<CommonBalancePlTRLRecord> eCommonBalPlTRLRecords;
	
	private Integer eArrTypId;
	private String eCredLimEvtInitTypeId;
	private String eTranCurCode;
	private String eBookLedCntryCode;
	
	private Integer eLossMitgPrgmId;
	private Integer eISupTypId;
	private Double eArrngPctAmt;
/**
	 * @return the eArrTypId
	 */
	public Integer geteArrTypId() {
		return eArrTypId;
	}
	/**
	 * @param eArrTypId the eArrTypId to set
	 */
	public void setEArrTypId(Integer eArrTypId) {
		this.eArrTypId = eArrTypId;
	}
	/**
	 * @return the eCredLimEvtInitTypeId
	 */
	public String geteCredLimEvtInitTypeId() {
		return eCredLimEvtInitTypeId;
	}
	/**
	 * @param eCredLimEvtInitTypeId the eCredLimEvtInitTypeId to set
	 */
	public void setECredLimEvtInitTypeId(String eCredLimEvtInitTypeId) {
		this.eCredLimEvtInitTypeId = eCredLimEvtInitTypeId;
	}
	/**
	 * @return the eTranCurCode
	 */
	public String geteTranCurCode() {
		return eTranCurCode;
	}
	/**
	 * @param eTranCurCode the eTranCurCode to set
	 */
	public void setETranCurCode(String eTranCurCode) {
		this.eTranCurCode = eTranCurCode;
	}
	/**
	 * @return the eBookLedCntryCode
	 */
	public String geteBookLedCntryCode() {
		return eBookLedCntryCode;
	}
	/**
	 * @param eBookLedCntryCode the eBookLedCntryCode to set
	 */
	public void setEBookLedCntryCode(String eBookLedCntryCode) {
		this.eBookLedCntryCode = eBookLedCntryCode;
	}
	//	public String getSrcSysIdentifier() { //Change
//		return srcSysIdentifier;
//	}
//	/**
//	 * @param srcSysIdentifier the srcSysIdentifier to set
//	 */
//	public void setSrcSysIdentifier(String srcSysIdentifier) {
//		this.srcSysIdentifier = srcSysIdentifier;
//	}
//	/**
//	 * @return the prodSysIdentifier
//	 */
//	public String getProdSysIdentifier() {
//		return prodSysIdentifier;
//	}
//	/**
//	 * @param prodSysIdentifier the prodSysIdentifier to set
//	 */
//	public void setProdSysIdentifier(String prodSysIdentifier) {
//		this.prodSysIdentifier = prodSysIdentifier;
//	}
	/**
	 * @return the arrangmentName
	 */
	public String getArrangmentName() {
		return arrangmentName;
	}
	/**
	 * @param arrangmentName the arrangmentName to set
	 */
	public void setArrangmentName(String arrangmentName) {
		this.arrangmentName = arrangmentName;
	}
	/**
	 * @return the arrangementTypeId
	 */
	public String getArrangementTypeId() {
		return arrangementTypeId;
	}
	/**
	 * @param arrangementTypeId the arrangementTypeId to set
	 */
	public void setArrangementTypeId(String arrangementTypeId) {
		this.arrangementTypeId = arrangementTypeId;
	}
//	/**
//	 * @return the denominationCurrencyId //Change
//	 */
//	public String getDenominationCurrencyId() {
//		return denominationCurrencyId;
//	}
//	/**
//	 * @param denominationCurrencyId the denominationCurrencyId to set
//	 */
//	public void setDenominationCurrencyId(String denominationCurrencyId) {
//		this.denominationCurrencyId = denominationCurrencyId;
//	}
	/**
	 * @return the originatingChannelId
	 */
	public String geteOriginatingChannelId() {
		return eOriginatingChannelId;
	}
	/**
	 * @param originatingChannelId the originatingChannelId to set
	 */
	public void setEOriginatingChannelId(String eOriginatingChannelId) {
		this.eOriginatingChannelId = eOriginatingChannelId;
	}
	/**
	 * @return the arrgBusIntentType
	 */
//	public String getArrgBusIntentType() {
//		return arrgBusIntentType;
//	}
//	/**
//	 * @param arrgBusIntentType the arrgBusIntentType to set
//	 */
//	public void setArrgBusIntentType(String arrgBusIntentType) {
//		this.arrgBusIntentType = arrgBusIntentType;
//	}
//	/**
//	 * @return the pledgedIndicator
//	 */
//	public String getPledgedIndicator() {
//		return pledgedIndicator;
//	}
//	/**
//	 * @param pledgedIndicator the pledgedIndicator to set
//	 */
//	public void setPledgedIndicator(String pledgedIndicator) {
//		this.pledgedIndicator = pledgedIndicator;
//	}
//	/**
//	 * @return the pledgedElgibilityIndicator
//	 */
//	public String getPledgedElgibilityIndicator() {
//		return pledgedElgibilityIndicator;
//	}
//	/**
//	 * @param pledgedElgibilityIndicator the pledgedElgibilityIndicator to set
//	 */
//	public void setPledgedElgibilityIndicator(String pledgedElgibilityIndicator) {
//		this.pledgedElgibilityIndicator = pledgedElgibilityIndicator;
//	}
	/**
	 * @return the arrngFinStsType
	 */
	public String geteArrngFinStsType() {
		return eArrngFinStsType;
	}
	/**
	 * @param arrngFinStsType the arrngFinStsType to set
	 */
	public void setEArrngFinStsType(String eArrngFinStsType) {
		this.eArrngFinStsType = eArrngFinStsType;
		/*arFinStatTypIDCkSum = arFinStatTypIDCkSum.add(new BigDecimal(eArrngFinStsType));
		CustomMethodsProvider.setArFinStatTypIDCkSum(arFinStatTypIDCkSum);*/
	}
	/**
	 * @return the arrngNextRenewalDate
	 */
//	public String getArrngNextRenewalDate() {
//		return arrngNextRenewalDate;
//	}
//	/**
//	 * @param arrngNextRenewalDate the arrngNextRenewalDate to set
//	 */
//	public void setArrngNextRenewalDate(String arrngNextRenewalDate) {
//		this.arrngNextRenewalDate = arrngNextRenewalDate;
//	}
	/**
	 * @return the nextReviewdate
	 */
//	public String getNextReviewdate() {
//		return nextReviewdate;
//	}
//	/**
//	 * @param nextReviewdate the nextReviewdate to set
//	 */
//	public void setNextReviewdate(String nextReviewdate) {
//		this.nextReviewdate = nextReviewdate;
//	}
	/**
	 * @return the localSubProductCode
	 */
	public String getLocalSubProductCode() {
		return localSubProductCode;
	}
	/**
	 * @param localSubProductCode the localSubProductCode to set
	 */
	public void setLocalSubProductCode(String localSubProductCode) {
		this.localSubProductCode = localSubProductCode;
	}
	/**
	 * @return the localProductCategoryCode
	 */
	public String geteLocalProdCategoryCode() {
		return eLocalProdCategoryCode;
	}
	/**
	 * @param localProductCategoryCode the localProductCategoryCode to set
	 */
	public void setELocalProdCategoryCode(String eLocalProdCategoryCode) {
		this.eLocalProdCategoryCode = eLocalProdCategoryCode;
	}
	/**
	 * @return the originalCampaignId
	 */
	public String getOriginalCampaignId() {
		return originalCampaignId;
	}
	/**
	 * @param originalCampaignId the originalCampaignId to set
	 */
	public void setOriginalCampaignId(String originalCampaignId) {
		this.originalCampaignId = originalCampaignId;
	}
	/**
	 * @return the feeWaiverFlag
	 */
	public String getFeeWaiverFlag() {
		return feeWaiverFlag;
	}
	/**
	 * @param feeWaiverFlag the feeWaiverFlag to set
	 */
	public void setFeeWaiverFlag(String feeWaiverFlag) {
		this.feeWaiverFlag = feeWaiverFlag;
	}
	/**
	 * @return the feeWaiverExpiryDate
	 */
	public String getFeeWaiverExpiryDate() {
		return feeWaiverExpiryDate;
	}
	/**
	 * @param feeWaiverExpiryDate the feeWaiverExpiryDate to set
	 */
	public void setFeeWaiverExpiryDate(String feeWaiverExpiryDate) {
		this.feeWaiverExpiryDate = feeWaiverExpiryDate;
	}
	/**
	 * @return the arrangementDispositionTypeId
	 */
	public String getArrangementDispositionTypeId() {
		return arrangementDispositionTypeId;
	}
	/**
	 * @param arrangementDispositionTypeId the arrangementDispositionTypeId to set
	 */
	public void setArrangementDispositionTypeId(String arrangementDispositionTypeId) {
		this.arrangementDispositionTypeId = arrangementDispositionTypeId;
	}
	/**
	 * @return the arrangementDispositionDate
	 */
	public String getArrangementDispositionDate() {
		return arrangementDispositionDate;
	}
	/**
	 * @param arrangementDispositionDate the arrangementDispositionDate to set
	 */
	public void setArrangementDispositionDate(String arrangementDispositionDate) {
		this.arrangementDispositionDate = arrangementDispositionDate;
	}
	/**
	 * @return the investorInsuredCategory
	 */
	public String getInvestorInsuredCategory() {
		return investorInsuredCategory;
	}
	/**
	 * @param investorInsuredCategory the investorInsuredCategory to set
	 */
	public void setInvestorInsuredCategory(String investorInsuredCategory) {
		this.investorInsuredCategory = investorInsuredCategory;
	}
	/**
	 * @return the investorInsuredActiveFlag
	 */
	public String getInvestorInsuredActiveFlag() {
		return investorInsuredActiveFlag;
	}
	/**
	 * @param investorInsuredActiveFlag the investorInsuredActiveFlag to set
	 */
	public void setInvestorInsuredActiveFlag(String investorInsuredActiveFlag) {
		this.investorInsuredActiveFlag = investorInsuredActiveFlag;
	}
	/**
	 * @return the investorInsuredPercentage
	 */
	public String getInvestorInsuredPercentage() {
		return investorInsuredPercentage;
	}
	/**
	 * @param investorInsuredPercentage the investorInsuredPercentage to set
	 */
	public void setInvestorInsuredPercentage(String investorInsuredPercentage) {
		this.investorInsuredPercentage = investorInsuredPercentage;
	}
	/**
	 * @return the intrPymntFrequencyPeriodicityId
	 */
	public Integer geteIntrPymntFrequencyPeriodicityId() {
		return eIntrPymntFrequencyPeriodicityId;
	}
	/**
	 * @param intrPymntFrequencyPeriodicityId the intrPymntFrequencyPeriodicityId to set
	 */
	public void setEIntrPymntFrequencyPeriodicityId(
			Integer eIntrPymntFrequencyPeriodicityId) {
		this.eIntrPymntFrequencyPeriodicityId = eIntrPymntFrequencyPeriodicityId;
	}
	/**
	 * @return the feePymntFrequencyPeriodicityId
	 */
	public String getFeePymntFrequencyPeriodicityId() {
		return feePymntFrequencyPeriodicityId;
	}
	/**
	 * @param feePymntFrequencyPeriodicityId the feePymntFrequencyPeriodicityId to set
	 */
	public void setFeePymntFrequencyPeriodicityId(
			String feePymntFrequencyPeriodicityId) {
		this.feePymntFrequencyPeriodicityId = feePymntFrequencyPeriodicityId;
	}
	/**
	 * @return the rateResetPeriodicityIntId
	 */
	public String geteRateResetPeriodicityIntId() {
		return eRateResetPeriodicityIntId;
	}
	/**
	 * @param rateResetPeriodicityIntId the rateResetPeriodicityIntId to set
	 */
	public void setERateResetPeriodicityIntId(String eRateResetPeriodicityIntId) {
		this.eRateResetPeriodicityIntId = eRateResetPeriodicityIntId;
	}
	/**
	 * @return the inititalIntrRateResetDt
	 */
	public String getInititalIntrRateResetDt() {
		return inititalIntrRateResetDt;
	}
	/**
	 * @param inititalIntrRateResetDt the inititalIntrRateResetDt to set
	 */
	public void setInititalIntrRateResetDt(String inititalIntrRateResetDt) {
		this.inititalIntrRateResetDt = inititalIntrRateResetDt;
	}
	/**
	 * @return the lastIntrRateResetDt
	 */
	public String getLastIntrRateResetDt() {
		return lastIntrRateResetDt;
	}
	/**
	 * @param lastIntrRateResetDt the lastIntrRateResetDt to set
	 */
	public void setLastIntrRateResetDt(String lastIntrRateResetDt) {
		this.lastIntrRateResetDt = lastIntrRateResetDt;
	}
	/**
	 * @return the atmCardFlag
	 */
	public String getAtmCardFlag() {
		return atmCardFlag;
	}
	/**
	 * @param atmCardFlag the atmCardFlag to set
	 */
	public void setAtmCardFlag(String atmCardFlag) {
		this.atmCardFlag = atmCardFlag;
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
	 * @return the onlineBankingInd
	 */
	public String getOnlineBankingInd() {
		return onlineBankingInd;
	}
	/**
	 * @param onlineBankingInd the onlineBankingInd to set
	 */
	public void setOnlineBankingInd(String onlineBankingInd) {
		this.onlineBankingInd = onlineBankingInd;
	}
	/**
	 * @return the financeServiceTypId
	 */
	public String getFinanceServiceTypId() {
		return financeServiceTypId;
	}
	/**
	 * @param financeServiceTypId the financeServiceTypId to set
	 */
	public void setFinanceServiceTypId(String financeServiceTypId) {
		this.financeServiceTypId = financeServiceTypId;
	}
	/**
	 * @return the obligorRecourseInd
	 */
	public String getObligorRecourseInd() {
		return obligorRecourseInd;
	}
	/**
	 * @param obligorRecourseInd the obligorRecourseInd to set
	 */
	public void setObligorRecourseInd(String obligorRecourseInd) {
		this.obligorRecourseInd = obligorRecourseInd;
	}
	/**
	 * @return the citiRecourseInd
	 */
	public String getCitiRecourseInd() {
		return citiRecourseInd;
	}
	/**
	 * @param citiRecourseInd the citiRecourseInd to set
	 */
	public void setCitiRecourseInd(String citiRecourseInd) {
		this.citiRecourseInd = citiRecourseInd;
	}
	/**
	 * @return the pymtFreqPeriodicityId
	 */
	public String getPymtFreqPeriodicityId() {
		return pymtFreqPeriodicityId;
	}
	/**
	 * @param pymtFreqPeriodicityId the pymtFreqPeriodicityId to set
	 */
	public void setPymtFreqPeriodicityId(String pymtFreqPeriodicityId) {
		this.pymtFreqPeriodicityId = pymtFreqPeriodicityId;
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
	 * @return the ballonRepymntInd
	 */
	public String getBallonRepymntInd() {
		return ballonRepymntInd;
	}
	/**
	 * @param ballonRepymntInd the ballonRepymntInd to set
	 */
	public void setBallonRepymntInd(String ballonRepymntInd) {
		this.ballonRepymntInd = ballonRepymntInd;
	}
	/**
	 * @return the intrAccrualStstypeId
	 */
	public String geteIntrstAccrualStatTypId() {//Change
		return eIntrstAccrualStatTypId;
	}
	/**
	 * @param intrAccrualStstypeId the intrAccrualStstypeId to set
	 */
	public void setEIntrstAccrualStatTypId(String eIntrstAccrualStatTypId) {
		this.eIntrstAccrualStatTypId = eIntrstAccrualStatTypId;//change
	}
	/**
	 * @return the intrOnlyTermPd
	 */
	public String getIntrOnlyTermPd() {
		return intrOnlyTermPd;
	}
	/**
	 * @param intrOnlyTermPd the intrOnlyTermPd to set
	 */
	public void setIntrOnlyTermPd(String intrOnlyTermPd) {
		this.intrOnlyTermPd = intrOnlyTermPd;
	}
	/**
	 * @return the principalGracePeriod
	 */
	public String getPrincipalGracePeriod() {
		return principalGracePeriod;
	}
	/**
	 * @param principalGracePeriod the principalGracePeriod to set
	 */
	public void setPrincipalGracePeriod(String principalGracePeriod) {
		this.principalGracePeriod = principalGracePeriod;
	}
	/**
	 * @return the noticePeriodDays
	 */
	public String getNoticePeriodDays() {
		return noticePeriodDays;
	}
	/**
	 * @param noticePeriodDays the noticePeriodDays to set
	 */
	public void setNoticePeriodDays(String noticePeriodDays) {
		this.noticePeriodDays = noticePeriodDays;
	}
	/**
	 * @return the acquisitionCost
	 */
	public String getAcquisitionCost() {
		return acquisitionCost;
	}
	/**
	 * @param acquisitionCost the acquisitionCost to set
	 */
	public void setAcquisitionCost(String acquisitionCost) {
		this.acquisitionCost = acquisitionCost;
	}
	/**
	 * @return the finServiceCurrReStsId
	 */
	public String getFinServiceCurrReStsId() {
		return finServiceCurrReStsId;
	}
	/**
	 * @param finServiceCurrReStsId the finServiceCurrReStsId to set
	 */
	public void setFinServiceCurrReStsId(String finServiceCurrReStsId) {
		this.finServiceCurrReStsId = finServiceCurrReStsId;
	}
	/**
	 * @return the finServiceCurrReStsDt
	 */
	public String getFinServiceCurrReStsDt() {
		return finServiceCurrReStsDt;
	}
	/**
	 * @param finServiceCurrReStsDt the finServiceCurrReStsDt to set
	 */
	public void setFinServiceCurrReStsDt(String finServiceCurrReStsDt) {
		this.finServiceCurrReStsDt = finServiceCurrReStsDt;
	}
	/**
	 * @return the finServiceReTypId
	 */
	public String getFinServiceReTypId() {
		return finServiceReTypId;
	}
	/**
	 * @param finServiceReTypId the finServiceReTypId to set
	 */
	public void setFinServiceReTypId(String finServiceReTypId) {
		this.finServiceReTypId = finServiceReTypId;
	}
	/**
	 * @return the finServicePreStsId
	 */
	public String getFinServicePreStsId() {
		return finServicePreStsId;
	}
	/**
	 * @param finServicePreStsId the finServicePreStsId to set
	 */
	public void setFinServicePreStsId(String finServicePreStsId) {
		this.finServicePreStsId = finServicePreStsId;
	}
	/**
	 * @return the finServicePreStsDt
	 */
	public String getFinServicePreStsDt() {
		return finServicePreStsDt;
	}
	/**
	 * @param finServicePreStsDt the finServicePreStsDt to set
	 */
	public void setFinServicePreStsDt(String finServicePreStsDt) {
		this.finServicePreStsDt = finServicePreStsDt;
	}
	/**
	 * @return the finServiceModPgmId
	 */
	public String getFinServiceModPgmId() {
		return finServiceModPgmId;
	}
	/**
	 * @param finServiceModPgmId the finServiceModPgmId to set
	 */
	public void setFinServiceModPgmId(String finServiceModPgmId) {
		this.finServiceModPgmId = finServiceModPgmId;
	}
	/**
	 * @return the finServiceModPgmStrtDt
	 */
	public String getFinServiceModPgmStrtDt() {
		return finServiceModPgmStrtDt;
	}
	/**
	 * @param finServiceModPgmStrtDt the finServiceModPgmStrtDt to set
	 */
	public void setFinServiceModPgmStrtDt(String finServiceModPgmStrtDt) {
		this.finServiceModPgmStrtDt = finServiceModPgmStrtDt;
	}
	/**
	 * @return the finServiceModPgmCurrSts
	 */
	public String getFinServiceModPgmCurrSts() {
		return finServiceModPgmCurrSts;
	}
	/**
	 * @param finServiceModPgmCurrSts the finServiceModPgmCurrSts to set
	 */
	public void setFinServiceModPgmCurrSts(String finServiceModPgmCurrSts) {
		this.finServiceModPgmCurrSts = finServiceModPgmCurrSts;
	}
	/**
	 * @return the finServiceModPgmCurrStsDt
	 */
	public String getFinServiceModPgmCurrStsDt() {
		return finServiceModPgmCurrStsDt;
	}
	/**
	 * @param finServiceModPgmCurrStsDt the finServiceModPgmCurrStsDt to set
	 */
	public void setFinServiceModPgmCurrStsDt(String finServiceModPgmCurrStsDt) {
		this.finServiceModPgmCurrStsDt = finServiceModPgmCurrStsDt;
	}
	/**
	 * @return the finServiceModPgmEndDt
	 */
	public String getFinServiceModPgmEndDt() {
		return finServiceModPgmEndDt;
	}
	/**
	 * @param finServiceModPgmEndDt the finServiceModPgmEndDt to set
	 */
	public void setFinServiceModPgmEndDt(String finServiceModPgmEndDt) {
		this.finServiceModPgmEndDt = finServiceModPgmEndDt;
	}
	/**
	 * @return the finServiceModPgmPreStsDt
	 */
	public String getFinServiceModPgmPreStsDt() {
		return finServiceModPgmPreStsDt;
	}
	/**
	 * @param finServiceModPgmPreStsDt the finServiceModPgmPreStsDt to set
	 */
	public void setFinServiceModPgmPreStsDt(String finServiceModPgmPreStsDt) {
		this.finServiceModPgmPreStsDt = finServiceModPgmPreStsDt;
	}
	/**
	 * @return the finServLimitTypId
	 */
	public String getFinServLimitTypId() {
		return finServLimitTypId;
	}
	/**
	 * @param finServLimitTypId the finServLimitTypId to set
	 */
	public void setFinServLimitTypId(String finServLimitTypId) {
		this.finServLimitTypId = finServLimitTypId;
	}
	/**
	 * @return the currFinServPrincplRpymntTypId
	 */
	public String getCurrFinServPrincplRpymntTypId() {
		return currFinServPrincplRpymntTypId;
	}
	/**
	 * @param currFinServPrincplRpymntTypId the currFinServPrincplRpymntTypId to set
	 */
	public void setCurrFinServPrincplRpymntTypId(
			String currFinServPrincplRpymntTypId) {
		this.currFinServPrincplRpymntTypId = currFinServPrincplRpymntTypId;
	}
	/**
	 * @return the restrctFlg
	 */
	public String getRestrctFlg() {
		return restrctFlg;
	}
	/**
	 * @param restrctFlg the restrctFlg to set
	 */
	public void setRestrctFlg(String restrctFlg) {
		this.restrctFlg = restrctFlg;
	}
	/**
	 * @return the mktRtYldRenegtnFlag
	 */
	public String getMktRtYldRenegtnFlag() {
		return mktRtYldRenegtnFlag;
	}
	/**
	 * @param mktRtYldRenegtnFlag the mktRtYldRenegtnFlag to set
	 */
	public void setMktRtYldRenegtnFlag(String mktRtYldRenegtnFlag) {
		this.mktRtYldRenegtnFlag = mktRtYldRenegtnFlag;
	}
	/**
	 * @return the overlmtInd
	 */
	public String getOverlmtInd() {
		return overlmtInd;
	}
	/**
	 * @param overlmtInd the overlmtInd to set
	 */
	public void setOverlmtInd(String overlmtInd) {
		this.overlmtInd = overlmtInd;
	}
	/**
	 * @return the skipPymntInd
	 */
	public String getSkipPymntInd() {
		return skipPymntInd;
	}
	/**
	 * @param skipPymntInd the skipPymntInd to set
	 */
	public void setSkipPymntInd(String skipPymntInd) {
		this.skipPymntInd = skipPymntInd;
	}
	/**
	 * @return the amortAccretionInd
	 */
	public String getAmortAccretionInd() {
		return amortAccretionInd;
	}
	/**
	 * @param amortAccretionInd the amortAccretionInd to set
	 */
	public void setAmortAccretionInd(String amortAccretionInd) {
		this.amortAccretionInd = amortAccretionInd;
	}
	/**
	 * @return the secInd
	 */
	public String getSecInd() {
		return secInd;
	}
	/**
	 * @param secInd the secInd to set
	 */
	public void setSecInd(String secInd) {
		this.secInd = secInd;
	}
	/**
	 * @return the modRetention
	 */
	public String getModRetention() {
		return modRetention;
	}
	/**
	 * @param modRetention the modRetention to set
	 */
	public void setModRetention(String modRetention) {
		this.modRetention = modRetention;
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
	public String getTrppTenor() {
		return trppTenor;
	}
	/**
	 * @param trppTenor the trppTenor to set
	 */
	public void setTrppTenor(String trppTenor) {
		this.trppTenor = trppTenor;
	}
	/**
	 * @return the accTrppInstamtamt
	 */
	public String getAccTrppInstamtamt() {
		return accTrppInstamtamt;
	}
	/**
	 * @param accTrppInstamtamt the accTrppInstamtamt to set
	 */
	public void setAccTrppInstamtamt(String accTrppInstamtamt) {
		this.accTrppInstamtamt = accTrppInstamtamt;
	}
	/**
	 * @return the lnCrdtAutomaticExtFlg
	 */
	public String getLnCrdtAutomaticExtFlg() {
		return lnCrdtAutomaticExtFlg;
	}
	/**
	 * @param lnCrdtAutomaticExtFlg the lnCrdtAutomaticExtFlg to set
	 */
	public void setLnCrdtAutomaticExtFlg(String lnCrdtAutomaticExtFlg) {
		this.lnCrdtAutomaticExtFlg = lnCrdtAutomaticExtFlg;
	}
	/**
	 * @return the lnCrdtTermLnConvFlg
	 */
	public String getLnCrdtTermLnConvFlg() {
		return lnCrdtTermLnConvFlg;
	}
	/**
	 * @param lnCrdtTermLnConvFlg the lnCrdtTermLnConvFlg to set
	 */
	public void setLnCrdtTermLnConvFlg(String lnCrdtTermLnConvFlg) {
		this.lnCrdtTermLnConvFlg = lnCrdtTermLnConvFlg;
	}
	/**
	 * @return the incmeDocTypId
	 */
	public String getIncmeDocTypId() {
		return incmeDocTypId;
	}
	/**
	 * @param incmeDocTypId the incmeDocTypId to set
	 */
	public void setIncmeDocTypId(String incmeDocTypId) {
		this.incmeDocTypId = incmeDocTypId;
	}
	/**
	 * @return the crdtDevinInd
	 */
	public String getCrdtDevinInd() {
		return crdtDevinInd;
	}
	/**
	 * @param crdtDevinInd the crdtDevinInd to set
	 */
	public void setCrdtDevinInd(String crdtDevinInd) {
		this.crdtDevinInd = crdtDevinInd;
	}
	/**
	 * @return the remainingPymntNumbr
	 */
	public String getRemainingPymntNumbr() {
		return remainingPymntNumbr;
	}
	/**
	 * @param remainingPymntNumbr the remainingPymntNumbr to set
	 */
	public void setRemainingPymntNumbr(String remainingPymntNumbr) {
		this.remainingPymntNumbr = remainingPymntNumbr;
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
	 * @return the premiumLoanFlg
	 */
	public String getPremiumLoanFlg() {
		return premiumLoanFlg;
	}
	/**
	 * @param premiumLoanFlg the premiumLoanFlg to set
	 */
	public void setPremiumLoanFlg(String premiumLoanFlg) {
		this.premiumLoanFlg = premiumLoanFlg;
	}
	/**
	 * @return the ppIntrRefNo
	 */
	public String getPpIntrRefNo() {
		return ppIntrRefNo;
	}
	/**
	 * @param ppIntrRefNo the ppIntrRefNo to set
	 */
	public void setPpIntrRefNo(String ppIntrRefNo) {
		this.ppIntrRefNo = ppIntrRefNo;
	}
	/**
	 * @return the localWarehouseRef
	 */
	public String getLocalWarehouseRef() {
		return localWarehouseRef;
	}
	/**
	 * @param localWarehouseRef the localWarehouseRef to set
	 */
	public void setLocalWarehouseRef(String localWarehouseRef) {
		this.localWarehouseRef = localWarehouseRef;
	}
	/**
	 * @return the upStrmSysRef
	 */
	public String getUpStrmSysRef() {
		return upStrmSysRef;
	}
	/**
	 * @param upStrmSysRef the upStrmSysRef to set
	 */
	public void setUpStrmSysRef(String upStrmSysRef) {
		this.upStrmSysRef = upStrmSysRef;
	}
	/**
	 * @return the custTradeRef
	 */
	public String getCustTradeRef() {
		return custTradeRef;
	}
	/**
	 * @param custTradeRef the custTradeRef to set
	 */
	public void setCustTradeRef(String custTradeRef) {
		this.custTradeRef = custTradeRef;
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
	public String getPenaltyRate() {
		return penaltyRate;
	}
	/**
	 * @param penaltyRate the penaltyRate to set
	 */
	public void setPenaltyRate(String penaltyRate) {
		this.penaltyRate = penaltyRate;
	}
	/**
	 * @return the legalNotificationDays
	 */
	public String getLegalNotificationDays() {
		return legalNotificationDays;
	}
	/**
	 * @param legalNotificationDays the legalNotificationDays to set
	 */
	public void setLegalNotificationDays(String legalNotificationDays) {
		this.legalNotificationDays = legalNotificationDays;
	}
	/**
	 * @return the accntFirstAdvDt
	 */
	public String getAccntFirstAdvDt() {
		return accntFirstAdvDt;
	}
	/**
	 * @param accntFirstAdvDt the accntFirstAdvDt to set
	 */
	public void setAccntFirstAdvDt(String accntFirstAdvDt) {
		this.accntFirstAdvDt = accntFirstAdvDt;
	}
	/**
	 * @return the accntFirstAdvAmnt
	 */
	public String getAccntFirstAdvAmnt() {
		return accntFirstAdvAmnt;
	}
	/**
	 * @param accntFirstAdvAmnt the accntFirstAdvAmnt to set
	 */
	public void setAccntFirstAdvAmnt(String accntFirstAdvAmnt) {
		this.accntFirstAdvAmnt = accntFirstAdvAmnt;
	}
	/**
	 * @return the acctFirstPymntDate
	 */
	public String getAcctFirstPymntDate() {
		return acctFirstPymntDate;
	}
	/**
	 * @param acctFirstPymntDate the acctFirstPymntDate to set
	 */
	public void setAcctFirstPymntDate(String acctFirstPymntDate) {
		this.acctFirstPymntDate = acctFirstPymntDate;
	}
	/**
	 * @return the acctFirstPymntAmnt
	 */
	public String getAcctFirstPymntAmnt() {
		return acctFirstPymntAmnt;
	}
	/**
	 * @param acctFirstPymntAmnt the acctFirstPymntAmnt to set
	 */
	public void setAcctFirstPymntAmnt(String acctFirstPymntAmnt) {
		this.acctFirstPymntAmnt = acctFirstPymntAmnt;
	}
	/**
	 * @return the acctLstAdvDt
	 */
	public String getAcctLstAdvDt() {
		return acctLstAdvDt;
	}
	/**
	 * @param acctLstAdvDt the acctLstAdvDt to set
	 */
	public void setAcctLstAdvDt(String acctLstAdvDt) {
		this.acctLstAdvDt = acctLstAdvDt;
	}
	/**
	 * @return the acctLstAdvAmnt
	 */
	public String getAcctLstAdvAmnt() {
		return acctLstAdvAmnt;
	}
	/**
	 * @param acctLstAdvAmnt the acctLstAdvAmnt to set
	 */
	public void setAcctLstAdvAmnt(String acctLstAdvAmnt) {
		this.acctLstAdvAmnt = acctLstAdvAmnt;
	}
	/**
	 * @return the acctLstRecDt
	 */
	public String getAcctLstRecDt() {
		return acctLstRecDt;
	}
	/**
	 * @param acctLstRecDt the acctLstRecDt to set
	 */
	public void setAcctLstRecDt(String acctLstRecDt) {
		this.acctLstRecDt = acctLstRecDt;
	}
	/**
	 * @return the acctLstInstDt
	 */
	public String getAcctLstInstDt() {
		return acctLstInstDt;
	}
	/**
	 * @param acctLstInstDt the acctLstInstDt to set
	 */
	public void setAcctLstInstDt(String acctLstInstDt) {
		this.acctLstInstDt = acctLstInstDt;
	}
	/**
	 * @return the acctLstIntrreviewDt
	 */
	public String getAcctLstIntrreviewDt() {
		return acctLstIntrreviewDt;
	}
	/**
	 * @param acctLstIntrreviewDt the acctLstIntrreviewDt to set
	 */
	public void setAcctLstIntrreviewDt(String acctLstIntrreviewDt) {
		this.acctLstIntrreviewDt = acctLstIntrreviewDt;
	}
	/**
	 * @return the lstIntrCollectionDt
	 */
	public String getLstIntrCollectionDt() {
		return lstIntrCollectionDt;
	}
	/**
	 * @param lstIntrCollectionDt the lstIntrCollectionDt to set
	 */
	public void setLstIntrCollectionDt(String lstIntrCollectionDt) {
		this.lstIntrCollectionDt = lstIntrCollectionDt;
	}
//	/**
//	 * @return the arrngSecurityTypId
//	 */
//	public String getArrngSecurityTypId() {
//		return arrngSecurityTypId;
//	}
//	/**
//	 * @param arrngSecurityTypId the arrngSecurityTypId to set
//	 */
//	public void setArrngSecurityTypId(String arrngSecurityTypId) {
//		this.arrngSecurityTypId = arrngSecurityTypId;
//	}
	/**
	 * @return the lienPosTypId
	 */
	public String getLienPosTypId() {
		return lienPosTypId;
	}
	/**
	 * @param lienPosTypId the lienPosTypId to set
	 */
	public void setLienPosTypId(String lienPosTypId) {
		this.lienPosTypId = lienPosTypId;
	}
	/**
	 * @return the pD
	 */
	public String getPD() {
		return PD;
	}
	/**
	 * @param pD the pD to set
	 */
	public void setPD(String pD) {
		PD = pD;
	}
	/**
	 * @return the otherAlternateId
	 */
	public String getOtherAlternateId() {
		return otherAlternateId;
	}
	/**
	 * @param otherAlternateId the otherAlternateId to set
	 */
	public void setOtherAlternateId(String otherAlternateId) {
		this.otherAlternateId = otherAlternateId;
	}
	/**
	 * @return the facilLegalStsTypeDt
	 */
	public String getFacilLegalStsTypeDt() {
		return facilLegalStsTypeDt;
	}
	/**
	 * @param facilLegalStsTypeDt the facilLegalStsTypeDt to set
	 */
	public void setFacilLegalStsTypeDt(String facilLegalStsTypeDt) {
		this.facilLegalStsTypeDt = facilLegalStsTypeDt;
	}
	/**
	 * @return the creditFacArrngApprTypId
	 */
	public Integer geteCreditFacArrngApprTypId() {
		return eCreditFacArrngApprTypId;
	}
	/**
	 * @param creditFacArrngApprTypId the creditFacArrngApprTypId to set
	 */
	public void setECreditFacArrngApprTypId(Integer eCreditFacArrngApprTypId) {
		this.eCreditFacArrngApprTypId = eCreditFacArrngApprTypId;
	}
	/**
	 * @return the creditFacArrngApprDt
	 */
	public String getCreditFacArrngApprDt() {
		return creditFacArrngApprDt;
	}
	/**
	 * @param creditFacArrngApprDt the creditFacArrngApprDt to set
	 */
	public void setCreditFacArrngApprDt(String creditFacArrngApprDt) {
		this.creditFacArrngApprDt = creditFacArrngApprDt;
	}
	/**
	 * @return the creditFacReguSgmntTypId
	 */
	public String getCreditFacReguSgmntTypId() {
		return creditFacReguSgmntTypId;
	}
	/**
	 * @param creditFacReguSgmntTypId the creditFacReguSgmntTypId to set
	 */
	public void setCreditFacReguSgmntTypId(String creditFacReguSgmntTypId) {
		this.creditFacReguSgmntTypId = creditFacReguSgmntTypId;
	}
	/**
	 * @return the creditFacAvailStsTypId
	 */
	public String getCreditFacAvailStsTypId() {
		return creditFacAvailStsTypId;
	}
	/**
	 * @param creditFacAvailStsTypId the creditFacAvailStsTypId to set
	 */
	public void setCreditFacAvailStsTypId(String creditFacAvailStsTypId) {
		this.creditFacAvailStsTypId = creditFacAvailStsTypId;
	}
	/**
	 * @return the origAdvisedComLmt
	 */
	public String getOrigAdvisedComLmt() {
		return origAdvisedComLmt;
	}
	/**
	 * @param origAdvisedComLmt the origAdvisedComLmt to set
	 */
	public void setOrigAdvisedComLmt(String origAdvisedComLmt) {
		this.origAdvisedComLmt = origAdvisedComLmt;
	}
	/**
	 * @return the origAdvisedUncomLmt
	 */
	public String getOrigAdvisedUncomLmt() {
		return origAdvisedUncomLmt;
	}
	/**
	 * @param origAdvisedUncomLmt the origAdvisedUncomLmt to set
	 */
	public void setOrigAdvisedUncomLmt(String origAdvisedUncomLmt) {
		this.origAdvisedUncomLmt = origAdvisedUncomLmt;
	}
	/**
	 * @return the origUnAdvisedUncomLmt
	 */
	public String getOrigUnAdvisedUncomLmt() {
		return origUnAdvisedUncomLmt;
	}
	/**
	 * @param origUnAdvisedUncomLmt the origUnAdvisedUncomLmt to set
	 */
	public void setOrigUnAdvisedUncomLmt(String origUnAdvisedUncomLmt) {
		this.origUnAdvisedUncomLmt = origUnAdvisedUncomLmt;
	}
	/**
	 * @return the lstCreditLmtChngDt
	 */
	public String getLstCreditLmtChngDt() {
		return lstCreditLmtChngDt;
	}
	/**
	 * @param lstCreditLmtChngDt the lstCreditLmtChngDt to set
	 */
	public void setLstCreditLmtChngDt(String lstCreditLmtChngDt) {
		this.lstCreditLmtChngDt = lstCreditLmtChngDt;
	}
	/**
	 * @return the crdtLmtChngTypId
	 */
	public String getCrdtLmtChngTypId() {
		return crdtLmtChngTypId;
	}
	/**
	 * @param crdtLmtChngTypId the crdtLmtChngTypId to set
	 */
	public void setCrdtLmtChngTypId(String crdtLmtChngTypId) {
		this.crdtLmtChngTypId = crdtLmtChngTypId;
	}
	/**
	 * @return the crdtLmtEndDt
	 */
	public String getCrdtLmtEndDt() {
		return crdtLmtEndDt;
	}
	/**
	 * @param crdtLmtEndDt the crdtLmtEndDt to set
	 */
	public void setCrdtLmtEndDt(String crdtLmtEndDt) {
		this.crdtLmtEndDt = crdtLmtEndDt;
	}
	/**
	 * @return the crdtLmtEvtIniTypId
	 */
	public String getCrdtLmtEvtIniTypId() {
		return crdtLmtEvtIniTypId;
	}
	/**
	 * @param crdtLmtEvtIniTypId the crdtLmtEvtIniTypId to set
	 */
	public void setCrdtLmtEvtIniTypId(String crdtLmtEvtIniTypId) {
		this.crdtLmtEvtIniTypId = crdtLmtEvtIniTypId;
	}
	/**
	 * @return the crdtLmtEvtAmnt
	 */
	public String getCrdtLmtEvtAmnt() {
		return crdtLmtEvtAmnt;
	}
	/**
	 * @param crdtLmtEvtAmnt the crdtLmtEvtAmnt to set
	 */
	public void setCrdtLmtEvtAmnt(String crdtLmtEvtAmnt) {
		this.crdtLmtEvtAmnt = crdtLmtEvtAmnt;
	}
	/**
	 * @return the bankruptcyDt
	 */
	public Date getBankruptcyDt() {
		return bankruptcyDt;
	}
	/**
	 * @param bankruptcyDt the bankruptcyDt to set
	 */
	public void setBankruptcyDt(Date bankruptcyDt) {
		this.bankruptcyDt = bankruptcyDt;
	}
	/**
	 * @return the promoIntrRtElgFlg
	 */
	public String getPromoIntrRtElgFlg() {
		return promoIntrRtElgFlg;
	}
	/**
	 * @param promoIntrRtElgFlg the promoIntrRtElgFlg to set
	 */
	public void setPromoIntrRtElgFlg(String promoIntrRtElgFlg) {
		this.promoIntrRtElgFlg = promoIntrRtElgFlg;
	}
	/**
	 * @return the pmacId
	 */
	public String getePmacId() {
		return ePmacId;
	}
	/**
	 * @param pmacId the pmacId to set
	 */
	public void setEPmacId(String ePmacId) {
		this.ePmacId = ePmacId;
	}
	/**
	 * @return the origAcctNum
	 */
	public String getOrigAcctNum() {
		return origAcctNum;
	}
	/**
	 * @param origAcctNum the origAcctNum to set
	 */
	public void setOrigAcctNum(String origAcctNum) {
		this.origAcctNum = origAcctNum;
	}
	/**
	 * @return the lstWriteDownDt
	 */
	public Date geteLstWriteDownDt() {
		return eLstWriteDownDt;
	}
	/**
	 * @param lstWriteDownDt the lstWriteDownDt to set
	 */
	public void setELstWriteDownDt(Date eLstWriteDownDt) {
		this.eLstWriteDownDt = eLstWriteDownDt;
	}
	/**
	 * @return the currNgvAmortFlg
	 */
	public String getCurrNgvAmortFlg() {
		return currNgvAmortFlg;
	}
	/**
	 * @param currNgvAmortFlg the currNgvAmortFlg to set
	 */
	public void setCurrNgvAmortFlg(String currNgvAmortFlg) {
		this.currNgvAmortFlg = currNgvAmortFlg;
	}
	/**
	 * @return the princDeferralOptionFlg
	 */
	public String getPrincDeferralOptionFlg() {
		return princDeferralOptionFlg;
	}
	/**
	 * @param princDeferralOptionFlg the princDeferralOptionFlg to set
	 */
	public void setPrincDeferralOptionFlg(String princDeferralOptionFlg) {
		this.princDeferralOptionFlg = princDeferralOptionFlg;
	}
	/**
	 * @return the princDeferralOptionEndDate
	 */
	public String getPrincDeferralOptionEndDate() {
		return princDeferralOptionEndDate;
	}
	/**
	 * @param princDeferralOptionEndDate the princDeferralOptionEndDate to set
	 */
	public void setPrincDeferralOptionEndDate(String princDeferralOptionEndDate) {
		this.princDeferralOptionEndDate = princDeferralOptionEndDate;
	}
	/**
	 * @return the interestDeferralOptionFlg
	 */
	public String getInterestDeferralOptionFlg() {
		return interestDeferralOptionFlg;
	}
	/**
	 * @param interestDeferralOptionFlg the interestDeferralOptionFlg to set
	 */
	public void setInterestDeferralOptionFlg(String interestDeferralOptionFlg) {
		this.interestDeferralOptionFlg = interestDeferralOptionFlg;
	}
	/**
	 * @return the interestDeferralOptionEndDt
	 */
	public String getInterestDeferralOptionEndDt() {
		return interestDeferralOptionEndDt;
	}
	/**
	 * @param interestDeferralOptionEndDt the interestDeferralOptionEndDt to set
	 */
	public void setInterestDeferralOptionEndDt(String interestDeferralOptionEndDt) {
		this.interestDeferralOptionEndDt = interestDeferralOptionEndDt;
	}
	/**
	 * @return the interestOnlyOptionEndDt
	 */
	public String getInterestOnlyOptionEndDt() {
		return interestOnlyOptionEndDt;
	}
	/**
	 * @param interestOnlyOptionEndDt the interestOnlyOptionEndDt to set
	 */
	public void setInterestOnlyOptionEndDt(String interestOnlyOptionEndDt) {
		this.interestOnlyOptionEndDt = interestOnlyOptionEndDt;
	}
	/**
	 * @return the acctFundsAdvCompltFlg
	 */
	public String getAcctFundsAdvCompltFlg() {
		return acctFundsAdvCompltFlg;
	}
	/**
	 * @param acctFundsAdvCompltFlg the acctFundsAdvCompltFlg to set
	 */
	public void setAcctFundsAdvCompltFlg(String acctFundsAdvCompltFlg) {
		this.acctFundsAdvCompltFlg = acctFundsAdvCompltFlg;
	}
	/**
	 * @return the monthsOnBooksLocal
	 */
	public Integer geteMonthsOnBooksLocal() {
		return eMonthsOnBooksLocal;
	}
	/**
	 * @param monthsOnBooksLocal the monthsOnBooksLocal to set
	 */
	public void setEMonthsOnBooksLocal(Integer eMonthsOnBooksLocal) {
		this.eMonthsOnBooksLocal = eMonthsOnBooksLocal;
	}
	/**
	 * @return the riskMgmntInd
	 */
//	public String getRiskMgmntInd() {
//		return riskMgmntInd;
//	}
//	/**
//	 * @param riskMgmntInd the riskMgmntInd to set
//	 */
//	public void setRiskMgmntInd(String riskMgmntInd) {
//		this.riskMgmntInd = riskMgmntInd;
//	}
	/**
	 * @return the delBucket
	 */
	public String geteDelBucket() {
		return eDelBucket;
	}
	/**
	 * @param delBucket the delBucket to set
	 */
	public void setEDelBucket(String eDelBucket) {
		this.eDelBucket = eDelBucket;
	}
	/**
	 * @return the reservedforfutureGenesisusage1
	 */
	public String getReservedforfutureGenesisusage1() {
		return reservedforfutureGenesisusage1;
	}
	/**
	 * @param reservedforfutureGenesisusage1 the reservedforfutureGenesisusage1 to set
	 */
	public void setReservedforfutureGenesisusage1(
			String reservedforfutureGenesisusage1) {
		this.reservedforfutureGenesisusage1 = reservedforfutureGenesisusage1;
	}
	/**
	 * @return the reservedforfutureGenesisusage2
	 */
	public String getReservedforfutureGenesisusage2() {
		return reservedforfutureGenesisusage2;
	}
	/**
	 * @param reservedforfutureGenesisusage2 the reservedforfutureGenesisusage2 to set
	 */
	public void setReservedforfutureGenesisusage2(
			String reservedforfutureGenesisusage2) {
		this.reservedforfutureGenesisusage2 = reservedforfutureGenesisusage2;
	}
	/**
	 * @return the reservedforfutureGenesisusage3
	 */
	public String getReservedforfutureGenesisusage3() {
		return reservedforfutureGenesisusage3;
	}
	/**
	 * @param reservedforfutureGenesisusage3 the reservedforfutureGenesisusage3 to set
	 */
	public void setReservedforfutureGenesisusage3(
			String reservedforfutureGenesisusage3) {
		this.reservedforfutureGenesisusage3 = reservedforfutureGenesisusage3;
	}
	/**
	 * @return the reservedforfutureGenesisusage4
	 */
	public String getReservedforfutureGenesisusage4() {
		return reservedforfutureGenesisusage4;
	}
	/**
	 * @param reservedforfutureGenesisusage4 the reservedforfutureGenesisusage4 to set
	 */
	public void setReservedforfutureGenesisusage4(
			String reservedforfutureGenesisusage4) {
		this.reservedforfutureGenesisusage4 = reservedforfutureGenesisusage4;
	}
	/**
	 * @return the reservedforfutureGenesisusage5
	 */
	public String getReservedforfutureGenesisusage5() {
		return reservedforfutureGenesisusage5;
	}
	/**
	 * @param reservedforfutureGenesisusage5 the reservedforfutureGenesisusage5 to set
	 */
	public void setReservedforfutureGenesisusage5(
			String reservedforfutureGenesisusage5) {
		this.reservedforfutureGenesisusage5 = reservedforfutureGenesisusage5;
	}
	/**
	 * @return the reservedforfutureGenesisusage6
	 */
	public String getReservedforfutureGenesisusage6() {
		return reservedforfutureGenesisusage6;
	}
	/**
	 * @param reservedforfutureGenesisusage6 the reservedforfutureGenesisusage6 to set
	 */
	public void setReservedforfutureGenesisusage6(
			String reservedforfutureGenesisusage6) {
		this.reservedforfutureGenesisusage6 = reservedforfutureGenesisusage6;
	}
	/**
	 * @return the reservedforfutureGenesisusage7
	 */
	public String getReservedforfutureGenesisusage7() {
		return reservedforfutureGenesisusage7;
	}
	/**
	 * @param reservedforfutureGenesisusage7 the reservedforfutureGenesisusage7 to set
	 */
	public void setReservedforfutureGenesisusage7(
			String reservedforfutureGenesisusage7) {
		this.reservedforfutureGenesisusage7 = reservedforfutureGenesisusage7;
	}
	/**
	 * @return the reservedforfutureGenesisusage8
	 */
	public String getReservedforfutureGenesisusage8() {
		return reservedforfutureGenesisusage8;
	}
	/**
	 * @param reservedforfutureGenesisusage8 the reservedforfutureGenesisusage8 to set
	 */
	public void setReservedforfutureGenesisusage8(
			String reservedforfutureGenesisusage8) {
		this.reservedforfutureGenesisusage8 = reservedforfutureGenesisusage8;
	}
	/**
	 * @return the reservedforfutureGenesisusage9
	 */
	public String getReservedforfutureGenesisusage9() {
		return reservedforfutureGenesisusage9;
	}
	/**
	 * @param reservedforfutureGenesisusage9 the reservedforfutureGenesisusage9 to set
	 */
	public void setReservedforfutureGenesisusage9(
			String reservedforfutureGenesisusage9) {
		this.reservedforfutureGenesisusage9 = reservedforfutureGenesisusage9;
	}
	/**
	 * @return the reservedforfutureGenesisusage10
	 */
	public String getReservedforfutureGenesisusage10() {
		return reservedforfutureGenesisusage10;
	}
	/**
	 * @param reservedforfutureGenesisusage10 the reservedforfutureGenesisusage10 to set
	 */
	public void setReservedforfutureGenesisusage10(
			String reservedforfutureGenesisusage10) {
		this.reservedforfutureGenesisusage10 = reservedforfutureGenesisusage10;
	}
	/**
	 * @return the reservedforfutureGenesisusage11
	 */
	public String getReservedforfutureGenesisusage11() {
		return reservedforfutureGenesisusage11;
	}
	/**
	 * @param reservedforfutureGenesisusage11 the reservedforfutureGenesisusage11 to set
	 */
	public void setReservedforfutureGenesisusage11(
			String reservedforfutureGenesisusage11) {
		this.reservedforfutureGenesisusage11 = reservedforfutureGenesisusage11;
	}
	/**
	 * @return the reservedforfutureGenesisusage12
	 */
	public String getReservedforfutureGenesisusage12() {
		return reservedforfutureGenesisusage12;
	}
	/**
	 * @param reservedforfutureGenesisusage12 the reservedforfutureGenesisusage12 to set
	 */
	public void setReservedforfutureGenesisusage12(
			String reservedforfutureGenesisusage12) {
		this.reservedforfutureGenesisusage12 = reservedforfutureGenesisusage12;
	}
	/**
	 * @return the reservedforfutureGenesisusage13
	 */
	public String getReservedforfutureGenesisusage13() {
		return reservedforfutureGenesisusage13;
	}
	/**
	 * @param reservedforfutureGenesisusage13 the reservedforfutureGenesisusage13 to set
	 */
	public void setReservedforfutureGenesisusage13(
			String reservedforfutureGenesisusage13) {
		this.reservedforfutureGenesisusage13 = reservedforfutureGenesisusage13;
	}
	/**
	 * @return the eAcctLastPymtToBankAmount
	 */
	public BigDecimal geteAcctLastPymtToBankAmount() {
		return eAcctLastPymtToBankAmount;
	}
//	/**
//	 * @param eAcctLastPymtToBankAmount the eAcctLastPymtToBankAmount to set
//	 */
//	public void seteAcctLastPymtToBankAmount(Long eAcctLastPymtToBankAmount) {
//		this.eAcctLastPymtToBankAmount = new BigDecimal(eAcctLastPymtToBankAmount).setScale(5,BigDecimal.ROUND_HALF_UP);;
//	}
	/**
	 * @param eFinServiceTypId the eFinServiceTypId to set
	 */
	public void seteFinServiceTypId(Integer eFinServiceTypId) {
		this.eFinServiceTypId = eFinServiceTypId;
	}
	/**
	 * @param eUniqueIdSrcSys the eUniqueIdSrcSys to set
	 */
	public void seteUniqueIdSrcSys(String eUniqueIdSrcSys) {
		this.eUniqueIdSrcSys = eUniqueIdSrcSys;
	}
	/**
	 * @param eRecordType the eRecordType to set
	 */
	public void seteRecordType(String eRecordType) {
		this.eRecordType = eRecordType;
	}
	/**
	 * @param eAsOfDate the eAsOfDate to set
	 */
	public void seteAsOfDate(Date eAsOfDate) {
		this.eAsOfDate = eAsOfDate;
	}
	/**
	 * @param eGlobalProdId the eGlobalProdId to set
	 */
	public void seteGlobalProdId(String eGlobalProdId) {
		this.eGlobalProdId = eGlobalProdId;
	}
	/**
	 * @param eBookingDate the eBookingDate to set
	 */
	public void seteBookingDate(Date eBookingDate) {
		this.eBookingDate = eBookingDate;
	}
	/**
	 * @param eOrgEffctDate the eOrgEffctDate to set
	 */
	public void seteOrgEffctDate(Date eOrgEffctDate) {
		this.eOrgEffctDate = eOrgEffctDate;
	}
	/**
	 * @param eEffectiveDate the eEffectiveDate to set
	 */
	public void seteEffectiveDate(Date eEffectiveDate) {
		this.eEffectiveDate = eEffectiveDate;
	}
	/**
	 * @param eArrgBusIntentDate the eArrgBusIntentDate to set
	 */
	public void seteArrgBusIntentDate(Date eArrgBusIntentDate) {
		this.eArrgBusIntentDate = eArrgBusIntentDate;
	}
	/**
	 * @param eArrngMatuTypeId the eArrngMatuTypeId to set
	 */
	public void seteArrngMatuTypeId(Integer eArrngMatuTypeId) {
		this.eArrngMatuTypeId = eArrngMatuTypeId;
	}
	/**
	 * @param eArrngFinStsDate the eArrngFinStsDate to set
	 */
	public void seteArrngFinStsDate(Date eArrngFinStsDate) {
		this.eArrngFinStsDate = eArrngFinStsDate;
	}
	/**
	 * @param eArrngPastDueDayCount the eArrngPastDueDayCount to set
	 */
	public void seteArrngPastDueDayCount(Integer eArrngPastDueDayCount) {
		this.eArrngPastDueDayCount = eArrngPastDueDayCount;
	}
	/**
	 * @param eGracePrdDayCount the eGracePrdDayCount to set
	 */
	public void seteGracePrdDayCount(Integer eGracePrdDayCount) {
		this.eGracePrdDayCount = eGracePrdDayCount;
	}
	/**
	 * @param eArrgPastDueAgeClass the eArrgPastDueAgeClass to set
	 */
	public void seteArrgPastDueAgeClass(Integer eArrgPastDueAgeClass) {
		this.eArrgPastDueAgeClass = eArrgPastDueAgeClass;
	}
	/**
	 * @param eArrgPastDueAgeClassDate the eArrgPastDueAgeClassDate to set
	 */
	public void seteArrgPastDueAgeClassDate(Date eArrgPastDueAgeClassDate) {
		this.eArrgPastDueAgeClassDate = eArrgPastDueAgeClassDate;
	}
	/**
	 * @param eArrngLifeCycleStatusTypeId the eArrngLifeCycleStatusTypeId to set
	 */
	public void setEArrngLifeCycleStatusTypeId(Integer eArrngLifeCycleStatusId) {//cHANGE
		this.eArrngLifeCycleStatusId = eArrngLifeCycleStatusId;
	}
	/**
	 * @param eArrngLifeCycleStatusDate the eArrngLifeCycleStatusDate to set
	 */
	public void seteArrngLifeCycleStatusDate(Date eArrngLifeCycleStatusDate) {
		this.eArrngLifeCycleStatusDate = eArrngLifeCycleStatusDate;
	}
	/**
	 * @param eArrngAcqustnTypeId the eArrngAcqustnTypeId to set
	 */
	public void seteArrngAcqustnTypeId(String eArrngAcqustnTypeId) {
		this.eArrngAcqustnTypeId = eArrngAcqustnTypeId;
	}
	/**
	 * @param eArrngAcqustnDate the eArrngAcqustnDate to set
	 */
	public void seteArrngAcqustnDate(Date eArrngAcqustnDate) {
		this.eArrngAcqustnDate = eArrngAcqustnDate;
	}
	/**
	 * @param eArrngDayCntConvTypId the eArrngDayCntConvTypId to set
	 */
	public void seteArrngDayCntConvTypId(Integer eArrngDayCntConvTypId) {
		this.eArrngDayCntConvTypId = eArrngDayCntConvTypId;
	}
	/**
	 * @param eIntrBasicCalcPeriodId the eIntrBasicCalcPeriodId to set
	 */
	public void seteIntrBasicCalcPeriodId(Integer eIntrBasicCalcPeriodId) {
		this.eIntrBasicCalcPeriodId = eIntrBasicCalcPeriodId;
	}
	/**
	 * @param eNxtIntrRateResetDate the eNxtIntrRateResetDate to set
	 */
	public void seteNxtIntrRateResetDate(Date eNxtIntrRateResetDate) {
		this.eNxtIntrRateResetDate = eNxtIntrRateResetDate;
	}
	/**
	 * @param eIntrAccrualStsDate the eIntrAccrualStsDate to set
	 */
	public void seteIntrAccrualStsDate(Date eIntrAccrualStsDate) {
		this.eIntrAccrualStsDate = eIntrAccrualStsDate;
	}
	/**
	 * @param eArrngPurposeTypeId1 the eArrngPurposeTypeId1 to set
	 */
	public void seteArrngPurposeTypeId1(String eArrngPurposeTypeId1) {
		this.eArrngPurposeTypeId1 = eArrngPurposeTypeId1;
	}
	/**
	 * @param eDelinq30DayPast2YrsFlag the eDelinq30DayPast2YrsFlag to set
	 */
	public void seteDelinq30DayPast2YrsFlag(String eDelinq30DayPast2YrsFlag) {
		this.eDelinq30DayPast2YrsFlag = eDelinq30DayPast2YrsFlag;
	}
	/**
	 * @param eCreditFacilityTypeId the eCreditFacilityTypeId to set
	 */
	public void seteCreditFacilityTypeId(Integer eCreditFacilityTypeId) {
		this.eCreditFacilityTypeId = eCreditFacilityTypeId;
	}
	/**
	 * @param eFacilLegalStsTypeId the eFacilLegalStsTypeId to set
	 */
	public void seteFacilLegalStsTypeId(Integer eFacilLegalStsTypeId) {
		this.eFacilLegalStsTypeId = eFacilLegalStsTypeId;
	}
	/**
	 * @param eEverWrittenOffFlag the eEverWrittenOffFlag to set
	 */
	public void seteEverWrittenOffFlag(String eEverWrittenOffFlag) {
		this.eEverWrittenOffFlag = eEverWrittenOffFlag;
	}
	/**
	 * @param eDescription the eDescription to set
	 */
	public void seteDescription(String eDescription) {
		this.eDescription = eDescription;
	}
	/**
	 * @param eEstimEndDate the eEstimEndDate to set
	 */
	public void seteEstimEndDate(Date eEstimEndDate) {
		this.eEstimEndDate = eEstimEndDate;
	}
/*	*//**
	 * @param eEndDate the eEndDate to set
	 *//*
	public void seteEndDate(Date eEndDate) {
		this.eEndDate = eEndDate;
	}*/
	/**
	 * @param eArrngLifeCycStatReasonTypeId the eArrngLifeCycStatReasonTypeId to set
	 */
	public void seteArrngLifeCycStatReasonTypeId(
			Integer eArrngLifeCycStatReasonTypeId) {
		this.eArrngLifeCycStatReasonTypeId = eArrngLifeCycStatReasonTypeId;
	}
	/**
	 * @param eArrngPrimaryPymntTypeId the eArrngPrimaryPymntTypeId to set
	 */
	public void seteArrngPrimaryPymntTypeId(Integer eArrngPrimaryPymntTypeId) {
		this.eArrngPrimaryPymntTypeId = eArrngPrimaryPymntTypeId;
	}
	/**
	 * @param eLocalProductCode the eLocalProductCode to set
	 */
	public void seteLocalProductCode(String eLocalProductCode) {
		this.eLocalProductCode = eLocalProductCode;
	}
	/**
	 * @param eAcctTypeId the eAcctTypeId to set
	 */
	public void seteAcctTypeId(Integer eAcctTypeId) {
		this.eAcctTypeId = eAcctTypeId;
	}
	/**
	 * @param eChrgOffTypeId the eChrgOffTypeId to set
	 */
	public void seteChrgOffTypeId(Integer eChrgOffTypeId) {
		this.eChrgOffTypeId = eChrgOffTypeId;
	}
	/**
	 * @param eRemngDaysToMaturity the eRemngDaysToMaturity to set
	 */
	public void seteRemngDaysToMaturity(Integer eRemngDaysToMaturity) {
		this.eRemngDaysToMaturity = eRemngDaysToMaturity;
	}
	/**
	 * @param eOriginalAmt the eOriginalAmt to set
	 */
//	public void seteOriginalAmt(Long eOriginalAmt) {
//		this.eOriginalAmt = new BigDecimal(eOriginalAmt).setScale(5,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eTrblDebtRestructureFlag the eTrblDebtRestructureFlag to set
	 */
	public void seteTrblDebtRestructureFlag(String eTrblDebtRestructureFlag) {
		this.eTrblDebtRestructureFlag = eTrblDebtRestructureFlag;
	}
	/**
	 * @param ePymntTotalNumbr the ePymntTotalNumbr to set
	 */
	public void setePymntTotalNumbr(Integer ePymntTotalNumbr) {
		this.ePymntTotalNumbr = ePymntTotalNumbr;
	}
	/**
	 * @param ePenaltyAmnt the ePenaltyAmnt to set
	 */
//	public void setePenaltyAmnt(Long ePenaltyAmnt) {
//		this.ePenaltyAmnt = new BigDecimal(ePenaltyAmnt).setScale(5,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eArrngNextPymtDueToBankDate the eArrngNextPymtDueToBankDate to set
	 */
	public void seteArrngNextPymtDueToBankDate(Date eArrngNextPymtDueToBankDate) {
		this.eArrngNextPymtDueToBankDate = eArrngNextPymtDueToBankDate;
	}
	/**
	 * @param eArrngNextPymtDueToBankAmnt the eArrngNextPymtDueToBankAmnt to set
	 */
//	public void seteArrngNextPymtDueToBankAmnt(Long eArrngNextPymtDueToBankAmnt) {
//		this.eArrngNextPymtDueToBankAmnt = new BigDecimal(eArrngNextPymtDueToBankAmnt).setScale(5,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eArrngLastPymtToBankDate the eArrngLastPymtToBankDate to set
	 */
	public void seteArrngLastPymtToBankDate(Date eArrngLastPymtToBankDate) {
		this.eArrngLastPymtToBankDate = eArrngLastPymtToBankDate;
	}
	/**
	 * @param eMissedPymtNumbr the eMissedPymtNumbr to set
	 */
	public void seteMissedPymtNumbr(Integer eMissedPymtNumbr) {
		this.eMissedPymtNumbr = eMissedPymtNumbr;
	}
	/**
	 * @param eTotalPymnts the eTotalPymnts to set
	 */
//	public void seteTotalPymnts(Long eTotalPymnts) {
//		this.eTotalPymnts = new BigDecimal(eTotalPymnts).setScale(5,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eBaselPortfolioId the eBaselPortfolioId to set
	 */
	public void seteBaselPortfolioId(String eBaselPortfolioId) {
		this.eBaselPortfolioId = eBaselPortfolioId;
	}
	/**
	 * @param eCreditLimitEffctDate the eCreditLimitEffctDate to set
	 */
	public void seteCreditLimitEffctDate(Date eCreditLimitEffctDate) {
		this.eCreditLimitEffctDate = eCreditLimitEffctDate;
	}
	/**
	 * @param eCcarProdCode the eCcarProdCode to set
	 */
	public void seteCcarProdCode(String eCcarProdCode) {
		this.eCcarProdCode = eCcarProdCode;
	}
	/**
	 * @param eTotalFundsDisbAmnt the eTotalFundsDisbAmnt to set
	 */
//	public void seteTotalFundsDisbAmnt(Long eTotalFundsDisbAmnt) {
//		this.eTotalFundsDisbAmnt = new BigDecimal(eTotalFundsDisbAmnt).setScale(10,BigDecimal.ROUND_HALF_UP);;
//	}
	/**
	 * @param eDaysPastDueCycEnd the eDaysPastDueCycEnd to set
	 */
	public void seteDaysPastDueCycEnd(Integer eDaysPastDueCycEnd) {
		this.eDaysPastDueCycEnd = eDaysPastDueCycEnd;
	}
	/**
	 * @param eCycleEndDelinqBucket the eCycleEndDelinqBucket to set
	 */
	public void seteCycleEndDelinqBucket(Integer eCycleEndDelinqBucket) {
		this.eCycleEndDelinqBucket = eCycleEndDelinqBucket;
	}
	/**
	 * @param eUniqueIdSrcSysInvlParty the eUniqueIdSrcSysInvlParty to set
	 */
	public void seteUniqueIdSrcSysInvlParty(String eUniqueIdSrcSysInvlParty) {
		this.eUniqueIdSrcSysInvlParty = eUniqueIdSrcSysInvlParty;
	}
	/**
	 * @param eArrgInvlvPartyRoleType the eArrgInvlvPartyRoleType to set
	 */
	public void seteArrgInvlvPartyRoleType(String eArrgInvlvPartyRoleType) {
		this.eArrgInvlvPartyRoleType = eArrgInvlvPartyRoleType;
	}
	/**
	 * @param ePctAmt the ePctAmt to set
	 */
//	public void setePctAmt(Integer ePctAmt) {
//		this.ePctAmt = new BigDecimal(ePctAmt).setScale(10,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eInvlvPartySubTypeId the eInvlvPartySubTypeId to set
	 */
//	public void seteInvlvPartySubTypeId(String eInvlvPartySubTypeId) {
//		this.eInvlvPartySubTypeId = eInvlvPartySubTypeId;
//	}
	/**
	 * @param eRank the eRank to set
	 */
	public void seteRank(Integer eRank) {
		this.eRank = eRank;
	}
	/**
	 * @param eFicoEquiRatingCode the eFicoEquiRatingCode to set
	 */
	public void seteFicoEquiRatingCode(String eFicoEquiRatingCode) {
		this.eFicoEquiRatingCode = eFicoEquiRatingCode;
	}
	/**
	 * @param eEffctRatePercent the eEffctRatePercent to set
	 */
//	public void seteEffctRatePercent(Long eEffctRatePercent) {
//		this.eEffctRatePercent = new BigDecimal(eEffctRatePercent).setScale(10,BigDecimal.ROUND_HALF_UP);
//	}
	/**
	 * @param eRateTypeId the eRateTypeId to set
	 */
	public void seteRateTypeId(String eRateTypeId) {
		this.eRateTypeId = eRateTypeId;
	}
	/**
	 * @param eFuncCurrencyCode the eFuncCurrencyCode to set
	 */
	public void seteFuncCurrencyCode(String eFuncCurrencyCode) {
		this.eFuncCurrencyCode = eFuncCurrencyCode;
	}
	/**
	 * @param eTransactianlaAmnt the eTransactianlaAmnt to set
	 */
	public void seteTransactianlaAmnt(Double eTxnAmt) {
		this.eTxnAmt = eTxnAmt;
	}
	/**
	 * @param eGaapIndicator the eGaapIndicator to set
	 */
	public void seteGaapIndicator(String eGaapIndicator) {
		this.eGaapIndicator = eGaapIndicator;
	}
	/**
	 * @param eBaseCurrencyCode the eBaseCurrencyCode to set
	 */
	public void seteBaseCurrencyCode(String eBaseCurrencyCode) {
		this.eBaseCurrencyCode = eBaseCurrencyCode;
	}
	/**
	 * @param eEntrProdId the eEntrProdId to set
	 */
	public void seteEntrProdId(String eEntrProdId) {
		this.eEntrProdId = eEntrProdId;
	}
	/**
	 * @param eArrgFinancialStatusTypeId the eArrgFinancialStatusTypeId to set
	 */
	public void seteArrgFinancialStatusTypeId(Integer eArrgFinancialStatusTypeId) {
		this.eArrgFinancialStatusTypeId = eArrgFinancialStatusTypeId;
	}
	/**
	 * @return the reservedforfutureGenesisusage14
	 */
	public String getReservedforfutureGenesisusage14() {
		return reservedforfutureGenesisusage14;
	}
	/**
	 * @param reservedforfutureGenesisusage14 the reservedforfutureGenesisusage14 to set
	 */
	public void setReservedforfutureGenesisusage14(
			String reservedforfutureGenesisusage14) {
		this.reservedforfutureGenesisusage14 = reservedforfutureGenesisusage14;
	}
	/**
	 * @return the reservedforfutureGenesisusage15
	 */
	public String getReservedforfutureGenesisusage15() {
		return reservedforfutureGenesisusage15;
	}
	/**
	 * @param reservedforfutureGenesisusage15 the reservedforfutureGenesisusage15 to set
	 */
	public void setReservedforfutureGenesisusage15(
			String reservedforfutureGenesisusage15) {
		this.reservedforfutureGenesisusage15 = reservedforfutureGenesisusage15;
	}
	/**
	 * @return the reservedforfutureGenesisusage16
	 */
	public String getReservedforfutureGenesisusage16() {
		return reservedforfutureGenesisusage16;
	}
	/**
	 * @param reservedforfutureGenesisusage16 the reservedforfutureGenesisusage16 to set
	 */
	public void setReservedforfutureGenesisusage16(
			String reservedforfutureGenesisusage16) {
		this.reservedforfutureGenesisusage16 = reservedforfutureGenesisusage16;
	}
	/**
	 * @return the reservedforfutureGenesisusage17
	 */
	public String getReservedforfutureGenesisusage17() {
		return reservedforfutureGenesisusage17;
	}
	/**
	 * @param reservedforfutureGenesisusage17 the reservedforfutureGenesisusage17 to set
	 */
	public void setReservedforfutureGenesisusage17(
			String reservedforfutureGenesisusage17) {
		this.reservedforfutureGenesisusage17 = reservedforfutureGenesisusage17;
	}
	/**
	 * @return the reservedforfutureGenesisusage18
	 */
	public String getReservedforfutureGenesisusage18() {
		return reservedforfutureGenesisusage18;
	}
	/**
	 * @param reservedforfutureGenesisusage18 the reservedforfutureGenesisusage18 to set
	 */
	public void setReservedforfutureGenesisusage18(
			String reservedforfutureGenesisusage18) {
		this.reservedforfutureGenesisusage18 = reservedforfutureGenesisusage18;
	}
	/**
	 * @return the reservedforfutureGenesisusage19
	 */
	public String getReservedforfutureGenesisusage19() {
		return reservedforfutureGenesisusage19;
	}
	/**
	 * @param reservedforfutureGenesisusage19 the reservedforfutureGenesisusage19 to set
	 */
	public void setReservedforfutureGenesisusage19(
			String reservedforfutureGenesisusage19) {
		this.reservedforfutureGenesisusage19 = reservedforfutureGenesisusage19;
	}
//	/**
//	 * @return the ratingIssuerId
//	 */
//	public String getRatingIssuerId() {
//		return ratingIssuerId;
//	}
//	/**
//	 * @param ratingIssuerId the ratingIssuerId to set
//	 */
//	public void setRatingIssuerId(String ratingIssuerId) {
//		this.ratingIssuerId = ratingIssuerId;
//	}
//	/**
//	 * @return the modelCode
//	 */
//	public String getModelCode() {
//		return modelCode;
//	}
//	/**
//	 * @param modelCode the modelCode to set
//	 */
//	public void setModelCode(String modelCode) {
//		this.modelCode = modelCode;
//	}Change
	
	/**
	 * @return the ratingEventReasonTypId
	 */
//	public String getRatingEventReasonTypId() {
//		return ratingEventReasonTypId;
//	}
//	/**
//	 * @param ratingEventReasonTypId the ratingEventReasonTypId to set
//	 */
//	public void setRatingEventReasonTypId(String ratingEventReasonTypId) {
//		this.ratingEventReasonTypId = ratingEventReasonTypId;
//	}
//	/**
//	 * @return the ratingTypCode
//	 */
//	public String getRatingTypCode() {
//		return ratingTypCode;
//	}
//	/**
//	 * @param ratingTypCode the ratingTypCode to set
//	 */
//	public void setRatingTypCode(String ratingTypCode) {
//		this.ratingTypCode = ratingTypCode;
//	}
	/**
	 * @return the ratingCode
	 */
	public String geteRatingCode() {
		return eRatingCode;
	}
	/**
	 * @param ratingCode the ratingCode to set
	 */
	public void setERatingCode(String eRatingCode) {
		this.eRatingCode = eRatingCode;
	}
	/**
	 * @return the ratingDescription
	 */
//	public String getRatingDescription() {
//		return ratingDescription;
//	}
//	/**
//	 * @param ratingDescription the ratingDescription to set
//	 */
//	public void setRatingDescription(String ratingDescription) {
//		this.ratingDescription = ratingDescription;
//	}
	/**
	 * @return the scoreReqReturnedFlg
	 */
//	public String getScoreReqReturnedFlg() {
//		return scoreReqReturnedFlg;
//	}
//	/**
//	 * @param scoreReqReturnedFlg the scoreReqReturnedFlg to set
//	 */
//	public void setScoreReqReturnedFlg(String scoreReqReturnedFlg) {
//		this.scoreReqReturnedFlg = scoreReqReturnedFlg;
//	}
	/**
	 * @return the spreadRatePercent
	 */
	public String getSpreadRatePercent() {
		return spreadRatePercent;
	}
	/**
	 * @param spreadRatePercent the spreadRatePercent to set
	 */
	public void setSpreadRatePercent(String spreadRatePercent) {
		this.spreadRatePercent = spreadRatePercent;
	}
	/**
	 * @return the arrngRelationshipTypeId
	 */
	public String getArrngRelationshipTypeId() {
		return arrngRelationshipTypeId;
	}
	/**
	 * @param arrngRelationshipTypeId the arrngRelationshipTypeId to set
	 */
	public void setArrngRelationshipTypeId(String arrngRelationshipTypeId) {
		this.arrngRelationshipTypeId = arrngRelationshipTypeId;
	}
	/**
	 * @return the rateId
	 */
	public String getRateId() {
		return rateId;
	}
	/**
	 * @param rateId the rateId to set
	 */
	public void setRateId(String rateId) {
		this.rateId = rateId;
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
	 * @return the rateVariabilityTypId
	 */
	public Integer geteRateVarTypeId() {
		return eRateVarTypeId;
	}
	/**
	 * @param rateVariabilityTypId the rateVariabilityTypId to set
	 */
	public void setERateVarTypeId(Integer eRateVarTypeId) {
		this.eRateVarTypeId = eRateVarTypeId;
	}
		/**
	 * @return the rateVariabilityTypId
	 */
	public Integer geteRateVariabilityTypId() {
		return eRateVariabilityTypId;
	}
	/**
	 * @param rateVariabilityTypId the rateVariabilityTypId to set
	 */
	public void setERateVariabilityTypId(Integer eRateVariabilityTypId) {
		this.eRateVariabilityTypId = eRateVariabilityTypId;
	}
//	/**
//	 * @return the rateTypEffDt
//	 */
//	public String getRateTypEffDt() {
//		return rateTypEffDt;
//	}
//	/**
//	 * @param rateTypEffDt the rateTypEffDt to set
//	 */
//	public void setRateTypEffDt(String rateTypEffDt) {
//		this.rateTypEffDt = rateTypEffDt;
//	}
//	/**
//	 * @return the rateActiveFlg
//	 */
//	public String getRateActiveFlg() {
//		return rateActiveFlg;
//	}
//	/**
//	 * @param rateActiveFlg the rateActiveFlg to set
//	 */
//	public void setRateActiveFlg(String rateActiveFlg) {
//		this.rateActiveFlg = rateActiveFlg;
//	}
	/**
	 * @return the legNumber
	 */
	public String getLegNumber() {
		return legNumber;
	}
	/**
	 * @param legNumber the legNumber to set
	 */
	public void setLegNumber(String legNumber) {
		this.legNumber = legNumber;
	}
	/**
	 * @return the generalLedgerSysId
	 */
	public String getGeneralLedgerSysId() {
		return generalLedgerSysId;
	}
	/**
	 * @param generalLedgerSysId the generalLedgerSysId to set
	 */
	public void setGeneralLedgerSysId(String generalLedgerSysId) {
		this.generalLedgerSysId = generalLedgerSysId;
	}
	/**
	 * @return the dealId
	 */
	public String getDealId() {
		return dealId;
	}
	/**
	 * @param dealId the dealId to set
	 */
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	/**
	 * @return the bookingLedgerCC
	 */
	public String getBookingLedgerCC() {
		return bookingLedgerCC;
	}
	/**
	 * @param bookingLedgerCC the bookingLedgerCC to set
	 */
	public void setBookingLedgerCC(String bookingLedgerCC) {
		this.bookingLedgerCC = bookingLedgerCC;
	}
	/**
	 * @return the balanceTyp
	 */
	public String getBalanceTyp() {
		return balanceTyp;
	}
	/**
	 * @param balanceTyp the balanceTyp to set
	 */
	public void setBalanceTyp(String balanceTyp) {
		this.balanceTyp = balanceTyp;
	}
	/**
	 * @return the glAcct1
	 */
	public String geteGLAccount1() {
		return eGLAccount1;
	}
	/**
	 * @param glAcct1 the glAcct1 to set
	 */
	public void setEGLAccount1(String eGLAccount1) {
		this.eGLAccount1 = eGLAccount1;
	}
	/**
	 * @return the glAcct2
	 */
	public String getGlAcct2() {
		return glAcct2;
	}
	/**
	 * @param glAcct2 the glAcct2 to set
	 */
	public void setGlAcct2(String glAcct2) {
		this.glAcct2 = glAcct2;
	}
	/**
	 * @return the fdlAcct
	 */
	public String getFdlAcct() {
		return fdlAcct;
	}
	/**
	 * @param fdlAcct the fdlAcct to set
	 */
	public void setFdlAcct(String fdlAcct) {
		this.fdlAcct = fdlAcct;
	}
	/**
	 * @return the funcCurrCode
	 */
	public String getFuncCurrCode() {
		return funcCurrCode;
	}
	/**
	 * @param funcCurrCode the funcCurrCode to set
	 */
	public void setFuncCurrCode(String funcCurrCode) {
		this.funcCurrCode = funcCurrCode;
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
	public void setFunctionalAmt(Double functionalAmt) {
		this.functionalAmt =new BigDecimal(functionalAmt).setScale(5,BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * @return the baseAmt
	 */
	public String getBaseAmt() {
		return baseAmt;
	}
	/**
	 * @param baseAmt the baseAmt to set
	 */
	public void setBaseAmt(String baseAmt) {
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
	 * @return the frsBUCode
	 */
	public String getFrsBUCode() {
		return frsBUCode;
	}
	/**
	 * @param frsBUCode the frsBUCode to set
	 */
	public void setFrsBUCode(String frsBUCode) {
		this.frsBUCode = frsBUCode;
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
	 * @return the localLegalVehicleId
	 */
	public String geteLocalLegalVehicleId() {
		return eLocalLegalVehicleId;
	}
	/**
	 * @param localLegalVehicleId the localLegalVehicleId to set
	 */
	public void setELocalLegalVehicleId(String eLocalLegalVehicleId) {
		this.eLocalLegalVehicleId = eLocalLegalVehicleId;
	}
	/**
	 * @return the fairValueAccMethodFlg
	 */
	public String getFairValueAccMethodFlg() {
		return fairValueAccMethodFlg;
	}
	/**
	 * @param fairValueAccMethodFlg the fairValueAccMethodFlg to set
	 */
	public void setFairValueAccMethodFlg(String fairValueAccMethodFlg) {
		this.fairValueAccMethodFlg = fairValueAccMethodFlg;
	}
	/**
	 * @return the fairValue
	 */
	public String getFairValue() {
		return fairValue;
	}
	/**
	 * @param fairValue the fairValue to set
	 */
	public void setFairValue(String fairValue) {
		this.fairValue = fairValue;
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
	 * @return the frsAffCode
	 */
	public String getFrsAffCode() {
		return frsAffCode;
	}
	/**
	 * @param frsAffCode the frsAffCode to set
	 */
	public void setFrsAffCode(String frsAffCode) {
		this.frsAffCode = frsAffCode;
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
	 * @return the microControlStratCode
	 */
	public String getMicroControlStratCode() {
		return microControlStratCode;
	}
	/**
	 * @param microControlStratCode the microControlStratCode to set
	 */
	public void setMicroControlStratCode(String microControlStratCode) {
		this.microControlStratCode = microControlStratCode;
	}
	/**
	 * @return the firmAcctIMSNo
	 */
	public String getFirmAcctIMSNo() {
		return firmAcctIMSNo;
	}
	/**
	 * @param firmAcctIMSNo the firmAcctIMSNo to set
	 */
	public void setFirmAcctIMSNo(String firmAcctIMSNo) {
		this.firmAcctIMSNo = firmAcctIMSNo;
	}
	/**
	 * @return the baseNo
	 */
	public String getBaseNo() {
		return baseNo;
	}
	/**
	 * @param baseNo the baseNo to set
	 */
	public void setBaseNo(String baseNo) {
		this.baseNo = baseNo;
	}
	/**
	 * @return the prodId
	 */
	public String getProdId() {
		return prodId;
	}
	/**
	 * @param prodId the prodId to set
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId;
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
	 * @return the localLedgerAcctNo
	 */
	public String getLocalLedgerAcctNo() {
		return localLedgerAcctNo;
	}
	/**
	 * @param localLedgerAcctNo the localLedgerAcctNo to set
	 */
	public void setLocalLedgerAcctNo(String localLedgerAcctNo) {
		this.localLedgerAcctNo = localLedgerAcctNo;
	}
	/**
	 * @return the adjInd
	 */
	public String getAdjInd() {
		return adjInd;
	}
	/**
	 * @param adjInd the adjInd to set
	 */
	public void setAdjInd(String adjInd) {
		this.adjInd = adjInd;
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
	 * @return the adjReasonCode
	 */
	public String getAdjReasonCode() {
		return adjReasonCode;
	}
	/**
	 * @param adjReasonCode the adjReasonCode to set
	 */
	public void setAdjReasonCode(String adjReasonCode) {
		this.adjReasonCode = adjReasonCode;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @return the adjStdArrngId
	 */
	public String getAdjStdArrngId() {
		return adjStdArrngId;
	}
	/**
	 * @param adjStdArrngId the adjStdArrngId to set
	 */
	public void setAdjStdArrngId(String adjStdArrngId) {
		this.adjStdArrngId = adjStdArrngId;
	}
	/**
	 * @return the transactionCurrCode
	 */
	public String geteTransCurr() {
		return eTransCurr;
	}
	/**
	 * @param transactionCurrCode the transactionCurrCode to set
	 */
	public void setETransCurr(String eTransCurr) {
		this.eTransCurr = eTransCurr;
	}
	public Integer geteArrngLifeCycleStatusReasonTypeId() {
		return eArrngLifeCycleStatusReasonTypeId;
	}
	public void setEArrngLifeCycleStatusReasonTypeId(
			Integer eArrngLifeCycleStatusReasonTypeId) {
		this.eArrngLifeCycleStatusReasonTypeId = eArrngLifeCycleStatusReasonTypeId;
	}
	
	//Changes -- 
	
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
	
	public String geteInvPtySubtypeId() {
		return eInvPtySubtypeId;
	}
	public void setEInvPtySubtypeId(String eInvPtySubtypeId) {
		this.eInvPtySubtypeId = eInvPtySubtypeId;
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
	public Integer geteRatingEventReasonTypId() {
		return eRatingEventReasonTypId;
	}
	public void setERatingEventReasonTypId(Integer eRatingEventReasonTypId) {
		this.eRatingEventReasonTypId = eRatingEventReasonTypId;
	}
	public String geteRatingTypCode() {
		return eRatingTypCode;
	}
	public void setERatingTypCode(String eRatingTypCode) {
		this.eRatingTypCode = eRatingTypCode;
	}
	
	public String geteRatingDescription() {
		return eRatingDescription;
	}
	public void setERatingDescription(String eRatingDescription) {
		this.eRatingDescription = eRatingDescription;
	}
	
	public String geteScoreReqReturnedFlg() {
		return eScoreReqReturnedFlg;
	}
	public void setEScoreReqReturnedFlg(String eScoreReqReturnedFlg) {
		this.eScoreReqReturnedFlg = eScoreReqReturnedFlg;
	}
	
	public String geteRateActiveFlg() {
		return eRateActiveFlg;
	}
	public void setERateActiveFlg(String eRateActiveFlg) {
		this.eRateActiveFlg = eRateActiveFlg;
	}
	
	/**
	 * @return the eOrgEffctDate
	 */
	public Date geteRateTypEffDt() {
		return eRateTypEffDt;
	}
	public void setERateTypEffDt(Date eRateTypEffDt) {
		this.eRateTypEffDt = eRateTypEffDt;
	}
	
	public String geteDenominationCurrencyId() {
		return eDenominationCurrencyId;
	}
	public void setEDenominationCurrencyId(String eDenominationCurrencyId) {
		this.eDenominationCurrencyId = eDenominationCurrencyId;
	}
	
	public Integer geteArrngBusIntType() {
		return eArrngBusIntType;
	}
	public void setEArrngBusIntType(Integer eArrngBusIntType) {
		this.eArrngBusIntType = eArrngBusIntType;
	}
	
	public Integer geteArrgBusIntentType() {
		return eArrgBusIntentType;
	}
	public void setEArrgBusIntentType(Integer eArrgBusIntentType) {
		this.eArrgBusIntentType = eArrgBusIntentType;
	}
	
	public String getePledgedIndicator() {
		return ePledgedIndicator;
	}
	public void setEPledgedIndicator(String ePledgedIndicator) {
		this.ePledgedIndicator = ePledgedIndicator;
	}
	
	/**
	 * @return the pledgedElgibilityIndicator
	 */
	public String getePledgedElgibilityIndicator() {
		return ePledgedElgibilityIndicator;
	}
	/**
	 * @param pledgedElgibilityIndicator the pledgedElgibilityIndicator to set
	 */
	public void setEPledgedElgibilityIndicator(String ePledgedElgibilityIndicator) {
		this.ePledgedElgibilityIndicator = ePledgedElgibilityIndicator;
	}
	
	public Date geteArrngNextRenewalDate() {
		return eArrngNextRenewalDate;
	}
	public void setEArrngNextRenewalDate(Date eArrngNextRenewalDate) {
		this.eArrngNextRenewalDate = eArrngNextRenewalDate;
	}
	
	public Date geteNextReviewdate() {
		return eNextReviewdate;
	}
	public void setENextReviewdate(Date eNextReviewdate) {
		this.eNextReviewdate = eNextReviewdate;
	}
	
	public Integer geteArrngSecurityTypId() {
		return eArrngSecurityTypId;
	}
	public void setEArrngSecurityTypId(Integer eArrngSecurityTypId) {
		this.eArrngSecurityTypId = eArrngSecurityTypId;
	}
	
	public String geteRiskMgmntInd() {
		return eRiskMgmntInd;
	}
	/**
	 * @param pledgedElgibilityIndicator the pledgedElgibilityIndicator to set
	 */
	public void setERiskMgmntInd(String eRiskMgmntInd) {
		this.eRiskMgmntInd = eRiskMgmntInd;
	}
	/**
	 * @return the eMtgIndEndDate
	 */
	public Date geteMtgIndEndDate() {
		return eMtgIndEndDate;
	}
	/**
	 * @param eMtgIndEndDate the eMtgIndEndDate to set
	 */
	public void setEMtgIndEndDate(Date eMtgIndEndDate) {
		this.eMtgIndEndDate = eMtgIndEndDate;
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
	 * @return the eCommonBalPlTRLRecords
	 */
	public List<CommonBalancePlTRLRecord> geteCommonBalPlTRLRecords() {
		return eCommonBalPlTRLRecords;
	}
	/**
	 * @param eCommonBalPlTRLRecords the eCommonBalPlTRLRecords to set
	 */
	public void setECommonBalPlTRLRecords(List<CommonBalancePlTRLRecord> eCommonBalPlTRLRecords) {
		this.eCommonBalPlTRLRecords = eCommonBalPlTRLRecords;
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
	/**
	 * @return the eArrngPctAmt
	 */
	public Double geteArrngPctAmt() {
		return eArrngPctAmt;
	}
	/**
	 * @param eArrngPctAmt the eArrngPctAmt to set
	 */
	public void setEArrngPctAmt(Double eArrngPctAmt) {
		this.eArrngPctAmt = eArrngPctAmt;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoansTRLRecord [eFinServiceTypId=" + eFinServiceTypId
				+ ", eUniqueIdSrcSys=" + eUniqueIdSrcSys + ", eRecordType="
				+ eRecordType + ", eAsOfDate=" + eAsOfDate + ", eGlobalProdId="
				+ eGlobalProdId + ", eBookingDate=" + eBookingDate
				+ ", eOrgEffctDate=" + eOrgEffctDate + ", eEffectiveDate="
				+ eEffectiveDate + ", eArrgBusIntentDate=" + eArrgBusIntentDate
				+ ", eArrngMatuTypeId=" + eArrngMatuTypeId
				+ ", eArrngFinStsDate=" + eArrngFinStsDate
				+ ", eArrngPastDueDayCount=" + eArrngPastDueDayCount
				+ ", eGracePrdDayCount=" + eGracePrdDayCount
				+ ", eArrgPastDueAgeClass=" + eArrgPastDueAgeClass
				+ ", eArrgPastDueAgeClassDate=" + eArrgPastDueAgeClassDate
				+ ", eArrngLifeCycleStatusId=" + eArrngLifeCycleStatusId
				+ ", eArrngLifeCycleStatusReasonTypeId="
				+ eArrngLifeCycleStatusReasonTypeId
				+ ", eArrngLifeCycleStatusDate=" + eArrngLifeCycleStatusDate
				+ ", eArrngAcqustnTypeId=" + eArrngAcqustnTypeId
				+ ", eArrngAcqustnDate=" + eArrngAcqustnDate
				+ ", eArrngDayCntConvTypId=" + eArrngDayCntConvTypId
				+ ", eIntrBasicCalcPeriodId=" + eIntrBasicCalcPeriodId
				+ ", eNxtIntrRateResetDate=" + eNxtIntrRateResetDate
				+ ", eIntrAccrualStsDate=" + eIntrAccrualStsDate
				+ ", eArrngPurposeTypeId1=" + eArrngPurposeTypeId1
				+ ", eDelinq30DayPast2YrsFlag=" + eDelinq30DayPast2YrsFlag
				+ ", eCreditFacilityTypeId=" + eCreditFacilityTypeId
				+ ", eFacilLegalStsTypeId=" + eFacilLegalStsTypeId
				+ ", eEverWrittenOffFlag=" + eEverWrittenOffFlag
				+ ", eDescription=" + eDescription + ", eEstimEndDate="
				+ eEstimEndDate + ", eEndDate=" + eEndDate
				+ ", eArrngLifeCycStatReasonTypeId="
				+ eArrngLifeCycStatReasonTypeId + ", eArrngPrimaryPymntTypeId="
				+ eArrngPrimaryPymntTypeId + ", eLocalProductCode="
				+ eLocalProductCode + ", eAcctTypeId=" + eAcctTypeId
				+ ", eChrgOffTypeId=" + eChrgOffTypeId
				+ ", eRemngDaysToMaturity=" + eRemngDaysToMaturity
				+ ", eOriginalAmt=" + eOriginalAmt
				+ ", eTrblDebtRestructureFlag=" + eTrblDebtRestructureFlag
				+ ", ePymntTotalNumbr=" + ePymntTotalNumbr + ", ePenaltyAmnt="
				+ ePenaltyAmnt + ", eArrngNextPymtDueToBankDate="
				+ eArrngNextPymtDueToBankDate
				+ ", eArrngNextPymtDueToBankAmnt="
				+ eArrngNextPymtDueToBankAmnt + ", eArrngLastPymtToBankDate="
				+ eArrngLastPymtToBankDate + ", eAcctLastPymtToBankAmount="
				+ eAcctLastPymtToBankAmount + ", eMissedPymtNumbr="
				+ eMissedPymtNumbr + ", eTotalPymnts=" + eTotalPymnts
				+ ", eBaselPortfolioId=" + eBaselPortfolioId
				+ ", eCreditLimitEffctDate=" + eCreditLimitEffctDate
				+ ", eCcarProdCode=" + eCcarProdCode + ", eTotalFundsDisbAmnt="
				+ eTotalFundsDisbAmnt + ", eDaysPastDueCycEnd="
				+ eDaysPastDueCycEnd + ", eCycleEndDelinqBucket="
				+ eCycleEndDelinqBucket + ", eUniqueIdSrcSysInvlParty="
				+ eUniqueIdSrcSysInvlParty + ", eArrgInvlvPartyRoleType="
				+ eArrgInvlvPartyRoleType + ", ePctAmt=" + ePctAmt + ", eRank="
				+ eRank + ", eFicoEquiRatingCode=" + eFicoEquiRatingCode
				+ ", eEffctRatePercent=" + eEffctRatePercent + ", eRateTypeId="
				+ eRateTypeId + ", eFuncCurrencyCode=" + eFuncCurrencyCode
				+ ", eTxnAmt=" + eTxnAmt + ", eGaapIndicator=" + eGaapIndicator
				+ ", eBaseCurrencyCode=" + eBaseCurrencyCode + ", eEntrProdId="
				+ eEntrProdId + ", eArrgFinancialStatusTypeId="
				+ eArrgFinancialStatusTypeId 
				+ ", eMtgIndEndDate=" + eMtgIndEndDate + ", eSrcSysId="
				+ eSrcSysId + ", eProdSysId=" + eProdSysId
				+ ", eInvPtySubtypeId=" + eInvPtySubtypeId
				+ ", eRatingIssuerId=" + eRatingIssuerId + ", eModelCode="
				+ eModelCode + ", eRatingEventReasonTypId="
				+ eRatingEventReasonTypId + ", eRatingTypCode="
				+ eRatingTypCode + ", eRatingDescription=" + eRatingDescription
				+ ", eScoreReqReturnedFlg=" + eScoreReqReturnedFlg
				+ ", eRateActiveFlg=" + eRateActiveFlg + ", eRateTypEffDt="
				+ eRateTypEffDt + ", eDenominationCurrencyId="
				+ eDenominationCurrencyId + ", eArrngBusIntType="
				+ eArrngBusIntType + ", ePledgedIndicator=" + ePledgedIndicator
				+ ", ePledgedElgibilityIndicator="
				+ ePledgedElgibilityIndicator + ", eArrngNextRenewalDate="
				+ eArrngNextRenewalDate + ", eNextReviewdate="
				+ eNextReviewdate + ", eArrngSecurityTypId="
				+ eArrngSecurityTypId + ", eRiskMgmntInd=" + eRiskMgmntInd
				+ ", eArrgBusIntentType=" + eArrgBusIntentType + ", ePrinAmt="
				+ ePrinAmt + ", eCostOfCred=" + eCostOfCred
				+ ", eTotEnrReceivables=" + eTotEnrReceivables
				+ ", eCurAdvComLimit=" + eCurAdvComLimit
				+ ", eGrossRecoveryAmt=" + eGrossRecoveryAmt
				+ ", eBaseAmtCurr=" + eBaseAmtCurr + ", arrangmentName="
				+ arrangmentName + ", arrangementTypeId=" + arrangementTypeId
				+ ", eOriginatingChannelId=" + eOriginatingChannelId
				+ ", eArrngFinStsType=" + eArrngFinStsType
				+ ", localSubProductCode=" + localSubProductCode
				+ ", eLocalProdCategoryCode=" + eLocalProdCategoryCode
				+ ", originalCampaignId=" + originalCampaignId
				+ ", feeWaiverFlag=" + feeWaiverFlag + ", feeWaiverExpiryDate="
				+ feeWaiverExpiryDate + ", arrangementDispositionTypeId="
				+ arrangementDispositionTypeId
				+ ", arrangementDispositionDate=" + arrangementDispositionDate
				+ ", investorInsuredCategory=" + investorInsuredCategory
				+ ", investorInsuredActiveFlag=" + investorInsuredActiveFlag
				+ ", investorInsuredPercentage=" + investorInsuredPercentage
				+ ", eIntrPymntFrequencyPeriodicityId="
				+ eIntrPymntFrequencyPeriodicityId
				+ ", feePymntFrequencyPeriodicityId="
				+ feePymntFrequencyPeriodicityId
				+ ", eRateResetPeriodicityIntId=" + eRateResetPeriodicityIntId
				+ ", inititalIntrRateResetDt=" + inititalIntrRateResetDt
				+ ", lastIntrRateResetDt=" + lastIntrRateResetDt
				+ ", atmCardFlag=" + atmCardFlag + ", islamicAcctIndicator="
				+ islamicAcctIndicator + ", taxExemptIndicator="
				+ taxExemptIndicator + ", onlineBankingInd=" + onlineBankingInd
				+ ", financeServiceTypId=" + financeServiceTypId
				+ ", obligorRecourseInd=" + obligorRecourseInd
				+ ", citiRecourseInd=" + citiRecourseInd
				+ ", pymtFreqPeriodicityId=" + pymtFreqPeriodicityId
				+ ", negativeAmortizationFlg=" + negativeAmortizationFlg
				+ ", ballonRepymntInd=" + ballonRepymntInd
				+ ", eIntrstAccrualStatTypId=" + eIntrstAccrualStatTypId
				+ ", intrOnlyTermPd=" + intrOnlyTermPd
				+ ", principalGracePeriod=" + principalGracePeriod
				+ ", noticePeriodDays=" + noticePeriodDays
				+ ", acquisitionCost=" + acquisitionCost
				+ ", finServiceCurrReStsId=" + finServiceCurrReStsId
				+ ", finServiceCurrReStsDt=" + finServiceCurrReStsDt
				+ ", finServiceReTypId=" + finServiceReTypId
				+ ", finServicePreStsId=" + finServicePreStsId
				+ ", finServicePreStsDt=" + finServicePreStsDt
				+ ", finServiceModPgmId=" + finServiceModPgmId
				+ ", finServiceModPgmStrtDt=" + finServiceModPgmStrtDt
				+ ", finServiceModPgmCurrSts=" + finServiceModPgmCurrSts
				+ ", finServiceModPgmCurrStsDt=" + finServiceModPgmCurrStsDt
				+ ", finServiceModPgmEndDt=" + finServiceModPgmEndDt
				+ ", finServiceModPgmPreStsDt=" + finServiceModPgmPreStsDt
				+ ", finServLimitTypId=" + finServLimitTypId
				+ ", currFinServPrincplRpymntTypId="
				+ currFinServPrincplRpymntTypId + ", restrctFlg=" + restrctFlg
				+ ", mktRtYldRenegtnFlag=" + mktRtYldRenegtnFlag
				+ ", overlmtInd=" + overlmtInd + ", skipPymntInd="
				+ skipPymntInd + ", amortAccretionInd=" + amortAccretionInd
				+ ", secInd=" + secInd + ", modRetention=" + modRetention
				+ ", regOEmpFlg=" + regOEmpFlg + ", trppTenor=" + trppTenor
				+ ", accTrppInstamtamt=" + accTrppInstamtamt
				+ ", lnCrdtAutomaticExtFlg=" + lnCrdtAutomaticExtFlg
				+ ", lnCrdtTermLnConvFlg=" + lnCrdtTermLnConvFlg
				+ ", incmeDocTypId=" + incmeDocTypId + ", crdtDevinInd="
				+ crdtDevinInd + ", remainingPymntNumbr=" + remainingPymntNumbr
				+ ", preComputedLoanFlg=" + preComputedLoanFlg
				+ ", premiumLoanFlg=" + premiumLoanFlg + ", ppIntrRefNo="
				+ ppIntrRefNo + ", localWarehouseRef=" + localWarehouseRef
				+ ", upStrmSysRef=" + upStrmSysRef + ", custTradeRef="
				+ custTradeRef + ", arrngPurposeTypeId2=" + arrngPurposeTypeId2
				+ ", arrngPurposeTypeId3=" + arrngPurposeTypeId3
				+ ", penaltyRate=" + penaltyRate + ", legalNotificationDays="
				+ legalNotificationDays + ", accntFirstAdvDt="
				+ accntFirstAdvDt + ", accntFirstAdvAmnt=" + accntFirstAdvAmnt
				+ ", acctFirstPymntDate=" + acctFirstPymntDate
				+ ", acctFirstPymntAmnt=" + acctFirstPymntAmnt
				+ ", acctLstAdvDt=" + acctLstAdvDt + ", acctLstAdvAmnt="
				+ acctLstAdvAmnt + ", acctLstRecDt=" + acctLstRecDt
				+ ", acctLstInstDt=" + acctLstInstDt + ", acctLstIntrreviewDt="
				+ acctLstIntrreviewDt + ", lstIntrCollectionDt="
				+ lstIntrCollectionDt + ", lienPosTypId=" + lienPosTypId
				+ ", PD=" + PD + ", otherAlternateId=" + otherAlternateId
				+ ", facilLegalStsTypeDt=" + facilLegalStsTypeDt
				+ ", eCreditFacArrngApprTypId=" + eCreditFacArrngApprTypId
				+ ", creditFacArrngApprDt=" + creditFacArrngApprDt
				+ ", creditFacReguSgmntTypId=" + creditFacReguSgmntTypId
				+ ", creditFacAvailStsTypId=" + creditFacAvailStsTypId
				+ ", origAdvisedComLmt=" + origAdvisedComLmt
				+ ", origAdvisedUncomLmt=" + origAdvisedUncomLmt
				+ ", origUnAdvisedUncomLmt=" + origUnAdvisedUncomLmt
				+ ", lstCreditLmtChngDt=" + lstCreditLmtChngDt
				+ ", crdtLmtChngTypId=" + crdtLmtChngTypId + ", crdtLmtEndDt="
				+ crdtLmtEndDt + ", crdtLmtEvtIniTypId=" + crdtLmtEvtIniTypId
				+ ", crdtLmtEvtAmnt=" + crdtLmtEvtAmnt + ", bankruptcyDt="
				+ bankruptcyDt + ", promoIntrRtElgFlg=" + promoIntrRtElgFlg
				+ ", ePmacId=" + ePmacId + ", origAcctNum=" + origAcctNum
				+ ", eLstWriteDownDt=" + eLstWriteDownDt + ", currNgvAmortFlg="
				+ currNgvAmortFlg + ", princDeferralOptionFlg="
				+ princDeferralOptionFlg + ", princDeferralOptionEndDate="
				+ princDeferralOptionEndDate + ", interestDeferralOptionFlg="
				+ interestDeferralOptionFlg + ", interestDeferralOptionEndDt="
				+ interestDeferralOptionEndDt + ", interestOnlyOptionEndDt="
				+ interestOnlyOptionEndDt + ", acctFundsAdvCompltFlg="
				+ acctFundsAdvCompltFlg + ", eMonthsOnBooksLocal="
				+ eMonthsOnBooksLocal + ", eDelBucket=" + eDelBucket
				+ ", eRatingCode=" + eRatingCode + ", spreadRatePercent="
				+ spreadRatePercent + ", arrngRelationshipTypeId="
				+ arrngRelationshipTypeId + ", rateId=" + rateId
				+ ", rateName=" + rateName + ", eRateVarTypeId="
				+ eRateVarTypeId + ", eRateVariabilityTypId="
				+ eRateVariabilityTypId + ", legNumber=" + legNumber
				+ ", generalLedgerSysId=" + generalLedgerSysId + ", dealId="
				+ dealId + ", bookingLedgerCC=" + bookingLedgerCC
				+ ", balanceTyp=" + balanceTyp + ", eGLAccount1=" + eGLAccount1
				+ ", glAcct2=" + glAcct2 + ", fdlAcct=" + fdlAcct
				+ ", eTransCurr=" + eTransCurr + ", funcCurrCode="
				+ funcCurrCode + ", functionalAmt=" + functionalAmt
				+ ", baseAmt=" + baseAmt + ", goc=" + goc
				+ ", bookingLedgerBranchCode=" + bookingLedgerBranchCode
				+ ", frsBUCode=" + frsBUCode + ", notForUse=" + notForUse
				+ ", localDeptId=" + localDeptId + ", eLocalLegalVehicleId="
				+ eLocalLegalVehicleId + ", fairValueAccMethodFlg="
				+ fairValueAccMethodFlg + ", fairValue=" + fairValue
				+ ", expenseCode=" + expenseCode + ", frsAffCode=" + frsAffCode
				+ ", subStrategyCode=" + subStrategyCode
				+ ", microControlStratCode=" + microControlStratCode
				+ ", firmAcctIMSNo=" + firmAcctIMSNo + ", baseNo=" + baseNo
				+ ", prodId=" + prodId + ", keyCode1=" + keyCode1
				+ ", keyCode2=" + keyCode2 + ", localLedgerAcctNo="
				+ localLedgerAcctNo + ", adjInd=" + adjInd + ", userId="
				+ userId + ", adjReasonCode=" + adjReasonCode + ", comment="
				+ comment + ", localGlKey3=" + localGlKey3 + ", localGlKey4="
				+ localGlKey4 + ", adjStdArrngId=" + adjStdArrngId
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
				+ reservedforfutureGenesisusage19 + ", eBalType=" + eBalType
				+ ", eCommonBalPlTRLRecords=" + eCommonBalPlTRLRecords
				+ ", eArrTypId=" + eArrTypId + ", eCredLimEvtInitTypeId="
				+ eCredLimEvtInitTypeId + ", eTranCurCode=" + eTranCurCode
				+ ", eBookLedCntryCode=" + eBookLedCntryCode
				+ ", eLossMitgPrgmId=" + eLossMitgPrgmId + ", eISupTypId="
				+ eISupTypId + ", eArrngPctAmt=" + eArrngPctAmt + "]";
	}
	public Date geteARGEndDate() {
		return eARGEndDate;
	}
	public void setEARGEndDate(Date eARGEndDate) {
		this.eARGEndDate = eARGEndDate;
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
	public Date geteARGEffDate() {
		return eARGEffDate;
	}
	public void setEARGEffDate(Date eARGEffDate) {
		this.eARGEffDate = eARGEffDate;
	}
	public Date geteAIPEndDate() {
		return eAIPEndDate;
	}
	public void setEAIPEndDate(Date eAIPEndDate) {
		this.eAIPEndDate = eAIPEndDate;
	}
	public Date geteAIPEffDate() {
		return eAIPEffDate;
	}
	public void setEAIPEffDate(Date eAIPEffDate) {
		this.eAIPEffDate = eAIPEffDate;
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
	public void setECAArrngBusIntType(Integer eCAArrngBusIntType) {
		this.eCAArrngBusIntType = eCAArrngBusIntType;
	}
	public Date geteAIREffDate() {
		return eAIREffDate;
	}
	public void setEAIREffDate(Date eAIREffDate) {
		this.eAIREffDate = eAIREffDate;
	}
	public Date geteAIREndDate() {
		return eAIREndDate;
	}
	public void setEAIREndDate(Date eAIREndDate) {
		this.eAIREndDate = eAIREndDate;
	}
	
	//Changes
	
	
	
}
