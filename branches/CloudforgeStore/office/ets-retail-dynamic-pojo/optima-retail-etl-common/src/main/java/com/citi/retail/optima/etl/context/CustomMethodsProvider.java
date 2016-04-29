package com.citi.retail.optima.etl.context;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.retail.optima.etl.common.model.ArrangementTRLRecord;
import com.citi.retail.optima.etl.common.model.ArrangementTRLTwRcRecord;
import com.citi.retail.optima.etl.common.model.CardsTRLRecord;
import com.citi.retail.optima.etl.common.model.CommonBalanceMtgTRLRecord;
import com.citi.retail.optima.etl.common.model.CommonBalancePlTRLRecord;
import com.citi.retail.optima.etl.common.model.CommonBalanceRcTRLRecord;
import com.citi.retail.optima.etl.common.model.CommonBalanceTRLRecord;
import com.citi.retail.optima.etl.common.model.GclTRLRecord;
import com.citi.retail.optima.etl.common.model.HkMtgWoRecvTRLRecord;
import com.citi.retail.optima.etl.common.model.HkMtgWriteOffTRLRecord;
import com.citi.retail.optima.etl.common.model.InRcTRLRecord;
import com.citi.retail.optima.etl.common.model.LoansTRLRecord;
import com.citi.retail.optima.etl.common.model.MortgageTRLRecord;
import com.citi.retail.optima.etl.common.model.OreoTRLRecord;
import com.citi.retail.optima.etl.common.model.PreRainbowRecord;
import com.citi.retail.optima.etl.common.model.RainbowRecord;
import com.citi.retail.optima.etl.common.model.TwRcPostRainbowRecord;
import com.citi.retail.optima.etl.common.model.TwRcPreRainbowRecord;

/**
 * 
 * @author ms04453 Marker Class that holds static methods which could be used
 *         for some of the enrichment functionalities.
 * 
 */
public final class CustomMethodsProvider {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomMethodsProvider.class);
	private static final String CCARAGE_GREATER_TWO_YR_SEGMENT = "GT two years";
	private static final String CCARAGE_LESS_TWO_YR_SEGMENT = "LT two years";

	private static final int MULTIPLY_FACTOR_100 = 100;
	private static final int MONTHS_IN_YEAR = 12;
	private static final int TWO_YEARS_OF_AGE = 2;
	private static final int INVALID_VAL = -1;
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMM",
			Locale.ENGLISH);
	//public static BigDecimal inputCheckSumTwProd=new BigDecimal(0);
	//public static BigDecimal inputCheckSumTwPl=new BigDecimal(0);
	//public static BigDecimal inputCheckSumHkPlProd = new BigDecimal(0);
	//public static BigDecimal inputUpbCheckSumTwProd = new BigDecimal(0);
	/**
	 * Default Constructor
	 */
	private CustomMethodsProvider() {
		LOGGER.debug("CustomMethodsProvider Init");

	}

	/**
	 * This method returns the CCARAge depending on the Account Open Date or
	 * Acquisition Date
	 * 
	 * @param accountOpenDate
	 * @param acquistionDate
	 * @param reportingPeriod
	 * @return CCAR Age
	 */
	public static String deriveCCARAge(Date fromDate, Date toDate) {

		if (toDate == null || toDate == null) {
			return CCARAGE_GREATER_TWO_YR_SEGMENT;
		}

		int age = 0;

		int formattedFromDate = Integer.parseInt(DATE_FORMAT.format(fromDate));
		int formattedToDate = Integer.parseInt(DATE_FORMAT.format(toDate));

		int fromDateinMonths = formattedFromDate / MULTIPLY_FACTOR_100
				* MONTHS_IN_YEAR + formattedFromDate % MULTIPLY_FACTOR_100;

		int toDateinMonths = formattedToDate / MULTIPLY_FACTOR_100
				* MONTHS_IN_YEAR + formattedToDate % MULTIPLY_FACTOR_100;

		age = toDateinMonths - fromDateinMonths;

		if (age / MONTHS_IN_YEAR < TWO_YEARS_OF_AGE) {
			return CCARAGE_LESS_TWO_YR_SEGMENT;
		} else {
			return CCARAGE_GREATER_TWO_YR_SEGMENT;
		}

	}

	/**
	 * Custom Enrich method to find out whether a given date falls on current
	 * Reporting Month
	 * 
	 * @param currentPeriod
	 * @param incomingPeriod
	 * @return
	 */
	public static boolean isCurrentMonth(Date currentPeriod, Date incomingPeriod) {

		boolean isCurrentMonth = false;

		if (incomingPeriod != null
				&& currentPeriod != null
				&& DATE_FORMAT.format(currentPeriod).equals(
						DATE_FORMAT.format(incomingPeriod))) {
			isCurrentMonth = true;

		}
		return isCurrentMonth;

	}

	/**
	 * This method returns the difference between the arg1 --> account open date
	 * or account acquisition date depending on the Account Open Date or
	 * Acquisition Date whichever is not null and arg2 --> reporting date or
	 * accountFinalChargeOffDate depending on the reporting date or Account
	 * Final Charge Off Date whichever is not null.
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return difference in number of months
	 */
	public static int calculateAge(Date fromDate, Date toDate) {

		if (toDate == null || fromDate == null) {
			return INVALID_VAL;
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMM",
				Locale.ENGLISH);

		int formattedToDate = Integer.parseInt(dateFormat.format(toDate));
		int formattedFromDate = Integer.parseInt(dateFormat.format(fromDate));

		int fromDateinMonths = formattedFromDate / MULTIPLY_FACTOR_100
				* MONTHS_IN_YEAR + formattedFromDate % MULTIPLY_FACTOR_100;

		int toDateinMonths = formattedToDate / MULTIPLY_FACTOR_100
				* MONTHS_IN_YEAR + formattedToDate % MULTIPLY_FACTOR_100;

		if(toDateinMonths >= fromDateinMonths ){
			return toDateinMonths - fromDateinMonths;
		}else{
			return fromDateinMonths - toDateinMonths;
		}
		
	}
	
	
	public static Date convertDate(String format,String dateStr)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			LOGGER.error(" Error while converting the date "+dateStr);
		}
		return date;
	}
	
	public static String getBaselPortfolioId
	(Boolean status,Date update,String	crdType,String CardNumber,Date dateOpen) throws ParseException {
		
		String baselPortfolioId = null;
		SimpleDateFormat DateFormat = new SimpleDateFormat ("ddMMMyyyy");	
		
		if (status==false) {
			if (DateFormat.parse("01Jan2008").compareTo(update)>=0) {
				baselPortfolioId ="TWUR013";
			} else{
				baselPortfolioId ="TWUR014";
			}
		} else {
			if (crdType=="650"||crdType=="660"||crdType=="670"||crdType=="680"||crdType=="900") {
				baselPortfolioId ="TWUR008";
			} else if (crdType=="439"||crdType=="539"||crdType=="527"||crdType=="517"
					||crdType=="130"||crdType=="138"||crdType=="980"||crdType=="496"||crdType=="596"
					||(crdType=="130"&&(CardNumber.substring(0,8)=="43117817"
					||CardNumber.substring(0,8)=="43117815"||CardNumber.substring(0,8)=="43117814")
					||(crdType=="427"&&(CardNumber.substring(0,8)=="46367027"
					||CardNumber.substring(0,8)=="46367015"||CardNumber.substring(0,8)=="46367018")))) {
				baselPortfolioId ="TWUR009";
			} else if(crdType=="749"||crdType=="757"||(crdType=="755"&&DateFormat.parse("01Dec2008").compareTo(dateOpen)>=0)){
				baselPortfolioId ="TWUI021";
			} else if(crdType=="770"){
				baselPortfolioId ="TWUR011";
			} else{
				baselPortfolioId ="TWUR007";
			}
		}		
		return baselPortfolioId;
	}
	
	public static Date getBillCycleDate(Date asOfDate,int day) throws ParseException{
		String oldDate;
		Date newDate;
		int month;
		int year;
		
		SimpleDateFormat oldFormat = new SimpleDateFormat ("ddMMyyyy");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(asOfDate);
		
		month = cal.get(Calendar.MONTH)+1;
		year = cal.get(Calendar.YEAR);
		oldDate=String.format("%02d", day)+String.format("%02d", month)+year;
		newDate = oldFormat.parse(oldDate);
		return newDate;
	}
	
	public static List<ArrangementTRLRecord> splitForRateTypes(CardsTRLRecord record) throws ParseException{
		
		List<ArrangementTRLRecord> aRecords = new ArrayList<ArrangementTRLRecord>();
		ArrangementTRLRecord arrangementTRLRecord1  = new ArrangementTRLRecord(record);
		if(record.geteCiRate() != null){
		arrangementTRLRecord1.seteEffRatePct(record.geteCiRate());
		arrangementTRLRecord1.setEArrangeRateTypeRltnpType(81);
		}
		else{
			arrangementTRLRecord1.seteEffRatePct(new Double(1.25));
			arrangementTRLRecord1.setEArrangeRateTypeRltnpType(78);
		}
		aRecords.add(arrangementTRLRecord1);
		
		ArrangementTRLRecord arrangementTRLRecord2  = new ArrangementTRLRecord(record);
		if(record.geteRiRate() != null){
		arrangementTRLRecord2.seteEffRatePct(record.geteRiRate());
		}
		else{
			arrangementTRLRecord2.seteEffRatePct(new Double(1.25));
		}
		arrangementTRLRecord2.setEArrangeRateTypeRltnpType(78);
		
		aRecords.add(arrangementTRLRecord2);
		
		return aRecords;
	}	
	
	public static List<CommonBalanceTRLRecord> splitForBalanceTypesPreRnbw(PreRainbowRecord record) throws ParseException{
		
		List<CommonBalanceTRLRecord> aRecords = new ArrayList<CommonBalanceTRLRecord>();
		
		if(record.getCashAccrIntr() != null && record.getRtlAccrIntr() != null){
			checkForTxnAmt(aRecords, record,7,record.getCashAccrIntr()+record.getRtlAccrIntr());
		}else if(record.getCashAccrIntr() != null && record.getRtlAccrIntr() == null){
			checkForTxnAmt(aRecords, record,7,record.getCashAccrIntr());
		}else if(record.getCashAccrIntr() == null && record.getRtlAccrIntr() != null){
			checkForTxnAmt(aRecords, record,7,record.getRtlAccrIntr());
		}
			
			checkForTxnAmt(aRecords, record,9,record.geteTxnAmtForBal9());
			checkForTxnAmt(aRecords, record,163,record.getePayAmt2());
			if(record.getLrtlAmt2() != null && record.getOrtlAmt2() != null){
				checkForTxnAmt(aRecords, record,220,record.getLrtlAmt2()+record.getOrtlAmt2());
			} else if(record.getLrtlAmt2() != null && record.getOrtlAmt2() == null){
				checkForTxnAmt(aRecords, record,220,record.getLrtlAmt2());
			} else if(record.getLrtlAmt2() == null && record.getOrtlAmt2() != null){
				checkForTxnAmt(aRecords, record,220,record.getOrtlAmt2());
			}
			if(record.getLcshAmt2() != null && record.getOcsha() != null){
				checkForTxnAmt(aRecords, record,221,record.getLcshAmt2()+record.getOcsha());
			} else if(record.getLcshAmt2() != null && record.getOcsha() == null){
				checkForTxnAmt(aRecords, record,221,record.getLcshAmt2());
			} else if(record.getLcshAmt2() == null && record.getOcsha() != null){
				checkForTxnAmt(aRecords, record,221,record.getOcsha());
			}
			checkForTxnAmt(aRecords, record,223,record.getRtlIntr());
			checkForTxnAmt(aRecords, record,224,record.getCshIntr());
			checkForTxnAmt(aRecords, record,226,record.getIntrst());
			checkForTxnAmt(aRecords, record,242,record.getWoIntr());
			checkForTxnAmt(aRecords, record,254,record.geteRtlIntr());
			if(record.geteRtlIntr() != null && record.getCshIntr() != null){
				checkForTxnAmt(aRecords, record,257,record.geteRtlIntr()+record.getCshIntr());
			}else if(record.geteRtlIntr() != null && record.getCshIntr() == null){
				checkForTxnAmt(aRecords, record,257,record.geteRtlIntr());
			}else if(record.geteRtlIntr() == null && record.getCshIntr() != null){
				checkForTxnAmt(aRecords, record,257,record.getCshIntr());
			}
			checkForTxnAmt(aRecords, record,259,record.geteCshFee());
			checkForTxnAmt(aRecords, record,265,record.geteBalType265());
			if(record.getClt2() != null && record.getAlopCrLimit() != null){
				checkForTxnAmt(aRecords, record,270,record.getClt2()+record.getAlopCrLimit());
			}else if(record.getClt2() != null && record.getAlopCrLimit() == null){
				checkForTxnAmt(aRecords, record,270,record.getClt2());
			}else if(record.getClt2() == null && record.getAlopCrLimit() != null){
				checkForTxnAmt(aRecords, record,270,record.getAlopCrLimit());
			}
			checkForTxnAmt(aRecords, record,302,record.geteAnr2());
			checkForTxnAmt(aRecords, record,1042,record.geteRecoveriesAmount());
			checkForTxnAmt(aRecords, record,1209,record.geteLateFeeBilled());
			checkForTxnAmt(aRecords, record,1221,record.geteAnfee());
			if(record.getOcshCnt2() != null && record.getLcshCnt2() != null) {
				checkForTxnAmt(aRecords, record,1239,((Integer)(record.getOcshCnt2()+record.getLcshCnt2())).doubleValue());
			}if(record.getOcshCnt2() != null && record.getLcshCnt2() == null) {
				checkForTxnAmt(aRecords, record,1239,((Integer)record.getOcshCnt2()).doubleValue());
			}if(record.getOcshCnt2() == null && record.getLcshCnt2() != null) {
				checkForTxnAmt(aRecords, record,1239,((Integer)record.getLcshCnt2()).doubleValue());
			}
			if(record.getOrtlCnt2() != null && record.getLrtlCnt2() != null) {
				checkForTxnAmt(aRecords, record,1240,((Integer)(record.getOrtlCnt2()+record.getLrtlCnt2())).doubleValue());
			}if(record.getOrtlCnt2() != null && record.getLrtlCnt2() == null) {
				checkForTxnAmt(aRecords, record,1240,((Integer)record.getOrtlCnt2()).doubleValue());
			}if(record.getOrtlCnt2() == null && record.getLrtlCnt2() != null) {
				checkForTxnAmt(aRecords, record,1240,((Integer)record.getLrtlCnt2()).doubleValue());
			}
			checkForTxnAmt(aRecords, record,1284,record.geteMdue());
			/*checkForTxnAmt(aRecords, record,4097,record.getClt2());
			checkForTxnAmt(aRecords, record,4098,record.getLclt2());
			if (record.geteAvailclt() != null) {
				checkForTxnAmt(aRecords, record,4100,record.geteAvailclt().doubleValue());
			}
			checkForTxnAmt(aRecords, record,4101,record.geteTotAmtDue());
			if(record.getMonbLnc() != null){
				checkForTxnAmt(aRecords, record,4103,record.getMonbLnc());
			}*/
//			Calculate X = (MONBLNC
//					+ EPP_AMNT 
//					- CSHINTR
//					- RTLINTR
//					- CSHFEE
//					- ANFEE
//					- LATEFEE
//					- OTHERFEE)
			checkForTxnAmt(aRecords, record, 1, checkNull(record.getMonbLnc())+checkNull(record.getEppAmnt())-checkNull(record.getCshIntr())-checkNull(record.getRtlIntr())-checkNull(record.getCshFee())-checkNull(record.getAnfee())-checkNull(record.getLateFee())-checkNull(record.getOtherFee()));
		return aRecords;
	}
	private static void checkForTxnAmt(List<CommonBalanceTRLRecord> aRecords, CardsTRLRecord record, int balTyp, Double value) {
		// TODO Auto-generated method stub
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}

	private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, HkMtgWoRecvTRLRecord record, int balTyp, Double value) {
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, MortgageTRLRecord record, int balTyp, Double value) {
		// TODO Auto-generated method stub
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, HkMtgWriteOffTRLRecord record, int balTyp, Double value) {
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	
	private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, GclTRLRecord record, int balTyp, Double value) {
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}

	private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, OreoTRLRecord record, int balTyp, Double value) {
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	/*private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, InMtgOreoRecord record, int balTyp, Double value) {
		// TODO Auto-generated method stub
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, GcbcMtgRecord record, int balTyp, Double value) {
		// TODO Auto-generated method stub
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, GclMtgRecord record, int balTyp, Double value) {
		// TODO Auto-generated method stub
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}*/
	/*private static void checkForTxnAmt(List<CommonBalanceRcTRLRecord> aRecords, InRcCorpMastRecord record, int balTyp, Double value) {
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	private static void checkForTxnAmt(List<CommonBalanceRcTRLRecord> aRecords, InRcRetMastRecord record, int balTyp, Double value) {
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	private static void checkForTxnAmt(List<CommonBalanceRcTRLRecord> aRecords, InRcRwMastRecord record, int balTyp, Double value) {
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}*/
	/*private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, HkMtgSasRecord record, int balTyp, Double value) {
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}*/

	//	private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, HkMtgWrtOffRecord record, int balTyp, Double value) {
	//		if(value != null && value.doubleValue() != 0.0) {
	//			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
	//		}
	//	}
	//	
		/*private static void checkForTxnAmt(List<CommonBalanceMtgTRLRecord> aRecords, HkMtgRecoveryRecord record, int balTyp, Double value) {
			if(value != null && value.doubleValue() != 0.0) {
				aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
			}
		}*/

	//created by subhamoy
	
	//HkMtgWriteOffTRLRecord
		public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(HkMtgWriteOffTRLRecord record, Integer balType, Double txnAmt)
		{
			CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
			commonBalanceMtgTRLRecord.seteBalTyp(balType);
//			record.seteBalType(balType);
			if(txnAmt != null) {
				//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
				commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			}
			/** Added for functional Amount **/
			if(txnAmt != null) {
				commonBalanceMtgTRLRecord.seteFuncAmt(txnAmt);
			}
			/** Added for Base Amount **/
			if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
				//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
				commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			}else{
				//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
				commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
			}
			
			return commonBalanceMtgTRLRecord;
		}
	public static List<CommonBalanceTRLRecord> splitForBalanceTypesRnbw(RainbowRecord record) throws ParseException{

		List<CommonBalanceTRLRecord> aRecords = new ArrayList<CommonBalanceTRLRecord>();
		try {
			if(record.getCashIBnp() != null && record.getRtlIBnp() != null){
				checkForTxnAmt(aRecords, record,7,record.getCashIBnp()+record.getRtlIBnp());
			} else if(record.getCashIBnp() != null && record.getRtlIBnp() == null){
				checkForTxnAmt(aRecords, record,7,record.getCashIBnp());
			}else if(record.getCashIBnp() == null && record.getRtlIBnp() != null){
				checkForTxnAmt(aRecords, record,7,record.getRtlIBnp());
			}

			checkForTxnAmt(aRecords, record,9,record.geteTxnAmtForBal9());
			checkForTxnAmt(aRecords, record,140,record.getChrgOffLcyAmt());
			checkForTxnAmt(aRecords, record,167,record.getCashSvcBnp());
			//checkForTxnAmt(aRecords, record,173,record.getRtlMemberBnp());
			checkForTxnAmt(aRecords, record,174,record.getRtlMemberBnp()); // Mapping change. Moved the Mapping from 173 to 174.
			if(record.geteRtlMiscBnp() != null && record.geteRtlSvcBnp()!= null) {
				checkForTxnAmt(aRecords, record,177,(record.geteRtlMiscBnp()+ record.geteRtlSvcBnp()));
			}
			else if(record.geteRtlMiscBnp() != null ) {
				checkForTxnAmt(aRecords, record,177,record.geteRtlMiscBnp());
			}
			else if(record.geteRtlSvcBnp()!= null) {
				checkForTxnAmt(aRecords, record,177,record.geteRtlSvcBnp());
			}
			if(record.getLrtlAmt2() != null && record.getOrtlAmt2() != null){
				checkForTxnAmt(aRecords, record,220,record.getLrtlAmt2()+record.getOrtlAmt2());
			} else if(record.getLrtlAmt2() != null && record.getOrtlAmt2() == null){
				checkForTxnAmt(aRecords, record,220,record.getLrtlAmt2());
			} else if(record.getLrtlAmt2() == null && record.getOrtlAmt2() != null){
				checkForTxnAmt(aRecords, record,220,record.getOrtlAmt2());
			}

			if(record.getLcshAmt2() != null && record.getOcshAmt2() != null){
				checkForTxnAmt(aRecords, record,221,record.getLcshAmt2()+record.getOcshAmt2());
			} else if(record.getLcshAmt2() != null && record.getOcshAmt2() == null){
				checkForTxnAmt(aRecords, record,221,record.getLcshAmt2());
			} else if(record.getLcshAmt2() == null && record.getOcshAmt2() != null){
				checkForTxnAmt(aRecords, record,221,record.getOcshAmt2());
			}
			checkForTxnAmt(aRecords, record,223,record.geteRtlIntr());
			checkForTxnAmt(aRecords, record,224,record.getCshIntr());
			checkForTxnAmt(aRecords, record,228,record.geteCshFee());
			if(record.geteRtlIntr() != null && record.getCshIntr() != null){
				checkForTxnAmt(aRecords, record,257,record.geteRtlIntr()+record.getCshIntr());
			}else if(record.geteRtlIntr() != null && record.getCshIntr() == null){
				checkForTxnAmt(aRecords, record,257,record.geteRtlIntr());
			}else if(record.geteRtlIntr() == null && record.getCshIntr() != null){
				checkForTxnAmt(aRecords, record,257,record.getCshIntr());
			}

			checkForTxnAmt(aRecords, record,259,record.geteCshFee());
			checkForTxnAmt(aRecords, record, 263, record.getCshBlnc2());
			//if (record.geteBalType265()!=null && record.geteBalType265()!=0){
			//
			//}	
			checkForTxnAmt(aRecords, record,265,record.geteBalType265());
			if(record.getClt2() != null && record.getAlopCrLimit() != null){
				checkForTxnAmt(aRecords, record,270,record.getClt2()+record.getAlopCrLimit());
			}else if(record.getClt2() != null && record.getAlopCrLimit() == null){
				checkForTxnAmt(aRecords, record,270,record.getClt2());
			}else if(record.getClt2() == null && record.getAlopCrLimit() != null){
				checkForTxnAmt(aRecords, record,270,record.getAlopCrLimit());
			}

			checkForTxnAmt(aRecords, record,302,record.geteAnr2());
			checkForTxnAmt(aRecords, record,1042,record.geteRecoveriesAmount());
			checkForTxnAmt(aRecords, record,1209,record.geteLateFeeBilled());
			checkForTxnAmt(aRecords, record,1284,record.geteCurrDueAmt());
			/*checkForTxnAmt(aRecords, record,4091,record.geteCshBlnc2());
	checkForTxnAmt(aRecords, record,4098,record.geteCrlmRelmLcyAmt());
	if(record.getMonbLnc() != null){
		checkForTxnAmt(aRecords, record,4103,record.getMonbLnc());
	}
	checkForTxnAmt(aRecords, record,4161,record.getePastDueAmt());*/
	
//	Calculate X = (enr_lcyamt
//			- CASH_IBNP
//			- RTL_IBNP
//			- CASH_SVC_BNP
//			- RTL_INSUR_BNP
//			- RTL_MEMBER_BNP
//			- RTL_MISC_BNP
//			- RTL_SVC_BNP)
	checkForTxnAmt(aRecords, record, 1, checkNull(record.getEnrLcyAmt())-checkNull(record.getCashIBnp())-checkNull(record.getRtlIBnp())-checkNull(record.getCashSvcBnp())-checkNull(record.getRtlInsurBnp())-checkNull(record.getRtlMemberBnp())-checkNull(record.getRtlMiscBnp())-checkNull(record.getRtlSvcBnp()));
	} catch(Exception e){
		e.printStackTrace();
	}
	return aRecords;
}
	
	public static List<CommonBalanceTRLRecord> splitForBalanceTypesInCrd(CardsTRLRecord record,Double tr400PrincipalPu,Double tr400PrincipalCa,Double dwCredLine, Double loanOut, Double  dtLope1,Integer finGcl, Double finRec,Integer dtGwo,Double dtEnr1) throws ParseException{
	
	List<CommonBalanceTRLRecord> aRecords = new ArrayList<CommonBalanceTRLRecord>();
	
//	if (record.getdtGcl1 != null && record.getSetSf() != null && record.getSt() && ((record.getDtGcl1() + record.getSetSf())*record.getSt()) >0)
//	{
//		record.getSt() && ((record.getDtGcl1() + record.getSetSf())*record.getSt());
//	}
	//checkForTxnAmt(aRecords, record,140,record.getFinGcl().doubleValue());
		checkForTxnAmt(aRecords, record,262,tr400PrincipalPu);
		checkForTxnAmt(aRecords, record,263,tr400PrincipalCa);
		checkForTxnAmt(aRecords, record,269,dwCredLine);
		checkForTxnAmt(aRecords, record,270,loanOut);
		checkForTxnAmt(aRecords, record,272,dtLope1);
		checkForTxnAmt(aRecords, record,1286,finRec);
	//checkForTxnAmt(aRecords, record,4103,record.getDtEnr1());
		if(dtGwo != null){
			checkForTxnAmt(aRecords, record,140,dtGwo.doubleValue());	
		}
		if(finGcl != null){
			checkForTxnAmt(aRecords, record,9,finGcl.doubleValue());
		}
		if(finGcl != null && finRec!= null) {
			checkForTxnAmt(aRecords, record,268,(finGcl.doubleValue() - finRec.doubleValue()));
		}
		checkForTxnAmt(aRecords, record, 265, dtEnr1);
	
	
	
	
	return aRecords;
}

	public static synchronized CommonBalanceTRLRecord createCommonBalanceTRLRecord(CardsTRLRecord record,Integer balType, Double txnAmt)
	{
		CommonBalanceTRLRecord commonBalanceTRLRecord  = new CommonBalanceTRLRecord(record);
		commonBalanceTRLRecord.setEBalType(balType);
		if(txnAmt != null) {
			commonBalanceTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			commonBalanceTRLRecord.seteFuncAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			/*if(balType==265){
			inputCheckSumTwProd=inputCheckSumTwProd.add(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			}*/
		} else  {
			
			commonBalanceTRLRecord.setETxnAmt(new BigDecimal(record.geteTxnAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
			commonBalanceTRLRecord.seteFuncAmt(new BigDecimal(record.geteTxnAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
			/*if(balType==265){
			inputCheckSumTwProd=inputCheckSumTwProd.add(new BigDecimal(record.geteTxnAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
			}*/
		}

		/** Added for Base Amount **/
		if (commonBalanceTRLRecord.geteTnxCurrency().equals(commonBalanceTRLRecord.geteBaseCurcyCode())){
			commonBalanceTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			commonBalanceTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
			
		
		return commonBalanceTRLRecord;
	}
	
	
	public static Integer getMonthsTwPl(Date bookDate, Date misDate){ 
		if(bookDate == null || misDate == null){
			return 0;
		}
		else{			
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(bookDate);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(misDate);
			int difference = 0;
			if(bookDate.compareTo(misDate)<0){
				difference = getDiffernceOfMonths(cal1,cal2);
			}
			else if(bookDate.compareTo(misDate)>0){
				difference = getDiffernceOfMonths(cal2,cal1);
			}
			else{
				difference = 0;
			}
			return difference;
		}		

	}

	public static Integer getMonthsHKCardsRnbw(Date acctOpenDt,Date eRptMonthDate){
		if(acctOpenDt== null || eRptMonthDate == null){
			return 0;
		}
		else{			
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(acctOpenDt);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(eRptMonthDate);
			int difference = 0;
			if(acctOpenDt.compareTo(eRptMonthDate)<0){
				difference = getDiffernceOfMonths(cal1,cal2);
			}
			else if(acctOpenDt.compareTo(eRptMonthDate)>0){
				difference = getDiffernceOfMonths(cal2,cal1);
			}
			else{
				difference = 0;
			}
			return difference;
		}		
		
	}
	
	public static Integer getMonthsHKCardsPreRnbw(Date eRptMonthDate,Date cardOpenDte ){
		if(cardOpenDte== null || eRptMonthDate == null){
			return 0;
		}
		else{			
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(cardOpenDte);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(eRptMonthDate);
			int difference = 0;
			if(cardOpenDte.compareTo(eRptMonthDate)<0){
				difference = getDiffernceOfMonths(cal1,cal2);
			}
			else if(cardOpenDte.compareTo(eRptMonthDate)>0){
				difference = getDiffernceOfMonths(cal2,cal1);
			}
			else{
				difference = 0;
			}
			return difference;
		}		
		
	}


	private static int getDiffernceOfMonths(Calendar startDate, Calendar endDate) {
		int m1 = startDate.get(Calendar.YEAR) * 12 + startDate.get(Calendar.MONTH);
        int m2 = endDate.get(Calendar.YEAR) * 12 + endDate.get(Calendar.MONTH);
        return m2 - m1;
		
	}
	
	/**
	 * This method is for Fixing CB issue.
	 * Generating multiple rows for different Balance types
	 * @param record
	 * @return
	 * @throws ParseException
	 */
//	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForMtg(ALSRecord record) throws ParseException{
//
//		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();
//
//
//		checkForTxnAmt(aRecords,record,1,record.getEnrPrin());
//		if(record.geteMemoRecord() != null) {
//			checkForTxnAmt(aRecords,record,1042,record.geteMemoRecord().getGlrec());
//		}
//		checkForTxnAmt(aRecords,record,7,record.getPdoienCamt());
//		//checkForTxnAmt(aRecords,record,4127,record.getEnrPrin());
//		checkForTxnAmt(aRecords,record,253,record.getEnrPrin());
//		checkForTxnAmt(aRecords,record,230,record.getFeesDue());
//		checkForTxnAmt(aRecords,record,226,record.getUnInt());
//		checkForTxnAmt(aRecords,record,265,record.getOsballpay());
//
//		return aRecords;
//	}
	
	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForMtg(Object inputRecord, Double enrPrin,Double glrec,
			Double pdoienCamt, Double feesDue, Double unInt, Double osballpay) throws ParseException{

		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();

		MortgageTRLRecord record = null; 
		if(inputRecord instanceof MortgageTRLRecord) {
			record = (MortgageTRLRecord)inputRecord;
		}
		
		checkForTxnAmt(aRecords,record,1,enrPrin);
		//if(record.geteMemoRecord() != null) {
			checkForTxnAmt(aRecords,record,1042,glrec);
		//}
		checkForTxnAmt(aRecords,record,7,pdoienCamt);
		//checkForTxnAmt(aRecords,record,4127,record.getEnrPrin());
		checkForTxnAmt(aRecords,record,253,enrPrin);
		checkForTxnAmt(aRecords,record,230,feesDue);
		checkForTxnAmt(aRecords,record,226,unInt);
		checkForTxnAmt(aRecords,record,265,osballpay);

		return aRecords;
	}

	public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(MortgageTRLRecord record, Integer balType, Double txnAmt)
	{
		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
		commonBalanceMtgTRLRecord.seteBalTyp(balType);
//		record.seteBalType(balType);
		if(txnAmt != null) {
			//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		/** Added for functional Amount **/
		if(txnAmt != null) {
			commonBalanceMtgTRLRecord.seteFuncAmt(txnAmt);
		}
		/** Added for Base Amount **/
		if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		return commonBalanceMtgTRLRecord;
	}
	/*public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(InMtgOreoRecord record, Integer balType, Double txnAmt)
	{
		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
		commonBalanceMtgTRLRecord.seteBalTyp(balType);
		if(txnAmt != null) {
			//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} 
		
		*//** Added for Base Amount **//*
		if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		return commonBalanceMtgTRLRecord;
	}*/
	/*public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(GcbcMtgRecord record, Integer balType, Double txnAmt)
	{
		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
		commonBalanceMtgTRLRecord.seteBalTyp(balType);
		if(txnAmt != null) {
			//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} 		
		
		*//** Added for Base Amount **//*
		if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		return commonBalanceMtgTRLRecord;
	}*/
	/*public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(GclMtgRecord record, Integer balType, Double txnAmt)
	{
		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
		commonBalanceMtgTRLRecord.seteBalTyp(balType);
		if(txnAmt != null) {
			//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} 
		
		*//** Added for Base Amount **//*
		if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		return commonBalanceMtgTRLRecord;
	}*/

	/*public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(HkMtgSasRecord record, Integer balType, Double txnAmt)
	{
		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
		commonBalanceMtgTRLRecord.seteBalTyp(balType);
		if(txnAmt != null) {
			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} 		
		if(txnAmt != null) {
			commonBalanceMtgTRLRecord.seteFuncAmt(txnAmt);
		}
		*//** Added for Base Amount **//*
		if (commonBalanceMtgTRLRecord.geteTranCurr() != null && commonBalanceMtgTRLRecord.geteBaseCurrCode() != null && commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			if(record.geteBaseAmtCurr() != null){
				commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
			}

		}
		return commonBalanceMtgTRLRecord;
	}*/

	//	public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(HkMtgWrtOffRecord record, Integer balType, Double txnAmt)
	//	{
	//		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
	//		commonBalanceMtgTRLRecord.seteBalTyp(balType);
	//		if(txnAmt != null) {
	//			//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
	//			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
	//		} 
	//		
	//		/** Added for Base Amount **/
	//		if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
	//			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
	//			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
	//		}else{
	//			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
	//			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
	//		}
	//		return commonBalanceMtgTRLRecord;
	//	}
	//	
		/*public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(HkMtgRecoveryRecord record, Integer balType, Double txnAmt)
		{
			CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
			commonBalanceMtgTRLRecord.seteBalTyp(balType);
			if(txnAmt != null) {
				//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
				commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			} 
			
			*//** Added for Base Amount **//*
			if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
				//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
				commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			}else{
				//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
				commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
			}
			return commonBalanceMtgTRLRecord;
		}*/

	/**
	 * This method is for Fixing CB issue.
	 * Generating multiple rows for different Balance types
	 * @param record
	 * @return
	 * @throws ParseException
	 */
//	public static List<CommonBalancePlTRLRecord> splitForBalanceTypesForPL(LoansALSRecord record) throws ParseException{
//
//		List<CommonBalancePlTRLRecord> aRecords = new ArrayList<CommonBalancePlTRLRecord>();
//		checkForTxnAmt(aRecords,record,1,record.getEnrPrin());
//		if(record.geteMemoRecord() != null) {
//			checkForTxnAmt(aRecords,record,9,record.geteMemoRecord().getGlgwo());
//		}
//		checkForTxnAmt(aRecords,record,98,record.getPdoienCamt());
//		checkForTxnAmt(aRecords,record,168,record.getLatecgl());
//		checkForTxnAmt(aRecords,record,230,record.getFeesDue());
//		checkForTxnAmt(aRecords,record,111,record.getUnInt());
//		checkForTxnAmt(aRecords,record,4155,record.getDisbAmt());
//		if(record.geteMemoRecord() != null) {
//			if(record.geteMemoRecord().getGlgwo()!= null && record.geteMemoRecord().getGlrec() == null) {
//				checkForTxnAmt(aRecords,record,268,record.geteMemoRecord().getGlgwo());
//			} else if(record.geteMemoRecord().getGlgwo()!= null && record.geteMemoRecord().getGlrec() != null) {
//				checkForTxnAmt(aRecords,record,268,record.geteMemoRecord().getGlgwo()-record.geteMemoRecord().getGlrec());
//			}
//		}
//
//		//		IF SUBSTR(FMSACTNO,15,3) NE '135' THEN 
//		//		D_ENR=ROUND(SUM(ENRPRIN,-RESAMT,UNINT,FEESDUE),1) /*Accrual Accounts*/
//		//
//		//		ELSE D_ENR=ROUND(SUM(ENRPRIN,-RESAMT),1) /*Non-Accrual Accounts*/
//
//		Double dEnr = 0.0;
//		String fmAcNo = record.getFmsActNo();
//
//		if(fmAcNo != null && (fmAcNo.length() > 18) && fmAcNo.substring(15,18).equalsIgnoreCase("135")){
//			dEnr =  checkNull(record.getEnrPrin())  + checkNull(record.getUnInt()) + checkNull(record.getFeesDue()) - (record.getResAmt());
//		}else{
//			dEnr = checkNull(record.getEnrPrin()) - (record.getResAmt());
//		}
//
//		BigDecimal roundOffdEnr = new BigDecimal(dEnr).setScale(1, BigDecimal.ROUND_HALF_UP);
//		inputCheckSumTwPl = inputCheckSumTwPl.add(roundOffdEnr);
//		checkForTxnAmt(aRecords,record,265,roundOffdEnr.doubleValue());
//
//		checkForTxnAmt(aRecords,record,7,record.getUnearnin()); // added for fix defect id 100
//
//
//		return aRecords;
//	}
	
	public static List<CommonBalancePlTRLRecord> splitForBalanceTypesForPL(Object inputRecord, Double enrPrin, Double glgwo, Double pdoienCamt, 
			Double latecgl, Double feesDue, Double unInt, Double disbAmt, Double glrec, String fmsActNo, Double resAmt, Double unearnin) throws ParseException{

		List<CommonBalancePlTRLRecord> aRecords = new ArrayList<CommonBalancePlTRLRecord>();
		
		LoansTRLRecord record = null;
		
		if(inputRecord instanceof LoansTRLRecord){
			record = (LoansTRLRecord)inputRecord;
		}
		
		checkForTxnAmt(aRecords,record,1,enrPrin);
//		if(record.geteMemoRecord() != null) {
//			checkForTxnAmt(aRecords,record,9,glgwo);
//		}
		checkForTxnAmt(aRecords,record,98,pdoienCamt);
		checkForTxnAmt(aRecords,record,168,latecgl);
		checkForTxnAmt(aRecords,record,230,feesDue);
		checkForTxnAmt(aRecords,record,111,unInt);
		checkForTxnAmt(aRecords,record,4155,disbAmt);
	//	if(record.geteMemoRecord() != null) {
			if(glgwo != null &&  glrec == null) {
				checkForTxnAmt(aRecords,record,268,glgwo);
			} else if(glgwo != null && glrec != null) {
				checkForTxnAmt(aRecords,record,268,(glgwo - glrec));
			}
	//	}

//		IF SUBSTR(FMSACTNO,15,3) NE '135' THEN 
//		D_ENR=ROUND(SUM(ENRPRIN,-RESAMT,UNINT,FEESDUE),1) /*Accrual Accounts*/
//
//		ELSE D_ENR=ROUND(SUM(ENRPRIN,-RESAMT),1) /*Non-Accrual Accounts*/
		
		Double dEnr = 0.0;
		/*String fmAcNo = record.getFmsActNo();
		
		if(fmAcNo != null && (fmAcNo.length() > 18) && !fmAcNo.substring(14,17).equals("135")){
			dEnr =  checkNull(enrPrin)  + checkNull(unInt) + checkNull(feesDue) - checkNull(resAmt);
		}else{
			dEnr = checkNull(enrPrin) - (resAmt);
		}*/
		BigDecimal roundOffdEnr = new BigDecimal(dEnr).setScale(1, BigDecimal.ROUND_HALF_UP);
//		inputCheckSumTwPl = inputCheckSumTwPl.add(roundOffdEnr);
		checkForTxnAmt(aRecords,record,265,roundOffdEnr.doubleValue());
		
		checkForTxnAmt(aRecords,record,7,unearnin); // added for fix defect id 100
		
		
		return aRecords;
	}
	
	private static Double checkNull(Double value){
		if(value != null){
			return value;
		}else{
			return 0.0;
		}	
	}
	
	/*public static CommonBalancePlTRLRecord createCommonBalanceTRLRecord(LoansALSRecord record, Integer balType, Double txnAmt)
	{
		CommonBalancePlTRLRecord commonBalancePlTRLRecord  = new CommonBalancePlTRLRecord(record);
		commonBalancePlTRLRecord.seteBalType(balType);
		if(record.geteBalType() == null){
			record.setEBalType(balType);
		}
		else{
			record.setEBalType(record.geteBalType() + balType);
		}
		if(txnAmt != null) {
			//commonBalancePlTRLRecord.setETxnAmt(txnAmt);
			commonBalancePlTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} 
		
		*//** Added for Base Amount **//*
		if (commonBalancePlTRLRecord.geteTransCurr().equals(commonBalancePlTRLRecord.geteBaseCurrencyCode())){
			//commonBalancePlTRLRecord.setEBaseAmt(txnAmt);
			commonBalancePlTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalancePlTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			commonBalancePlTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		return commonBalancePlTRLRecord;
	}*/
	
	public static List<CommonBalancePlTRLRecord> splitForBalanceTypesInPl(LoansTRLRecord record,Integer dGcl, Integer dReco,Double fxRate) throws ParseException{
		
	List<CommonBalancePlTRLRecord> aRecords = new ArrayList<CommonBalancePlTRLRecord>();


		checkForTxnAmt(aRecords,record,1,record.getePrinAmt());
		//checkForTxnAmt(aRecords,record,140,record.geteCostOfCred());
		if(dGcl != null){
			checkForTxnAmt(aRecords,record,140,Double.valueOf(dGcl* fxRate));
		}

		checkForTxnAmt(aRecords,record,265,record.geteTotEnrReceivables());
		checkForTxnAmt(aRecords,record,269,record.geteCurAdvComLimit());
		//checkForTxnAmt(aRecords,record,1286,record.geteGrossRecoveryAmt());
		if(dReco != null){
			checkForTxnAmt(aRecords,record,1286,Double.valueOf(dReco* fxRate));
		}
		return aRecords;

	}

	//private static void checkForTxnAmt(List<CommonBalancePlTRLRecord> aRecords, inPLRecord record, int balTyp, Double value) {
	//	if(value != null && value.doubleValue() != 0.0) {
	//		aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
	//	}
	//}


public static List<CommonBalanceRcTRLRecord> splitForBalanceTypesInRcCorp(InRcTRLRecord record,
			
			Double prinBalFin,Double gclFin,Double totOsfin,Double recFin,Double lopEnr) throws ParseException{

		List<CommonBalanceRcTRLRecord> aRecords = new ArrayList<CommonBalanceRcTRLRecord>();

		checkForTxnAmt(aRecords,record,1,prinBalFin);
		checkForTxnAmt(aRecords,record,9,gclFin);
		checkForTxnAmt(aRecords,record,265,totOsfin);
		checkForTxnAmt(aRecords,record,272,recFin);
		checkForTxnAmt(aRecords,record,4086,lopEnr);

	return aRecords;
	
}

public static List<CommonBalanceRcTRLRecord> splitForBalanceTypesInRcRet(Object inputRecord,
		Double gcl,Double prinBal,Double recovery,Double lopEnr) throws ParseException{

	List<CommonBalanceRcTRLRecord> aRecords = new ArrayList<CommonBalanceRcTRLRecord>();
	
	InRcTRLRecord record = null;
	if(inputRecord instanceof InRcTRLRecord) {
		record = (InRcTRLRecord)inputRecord;
	}

	checkForTxnAmt(aRecords,record,1,prinBal);
	checkForTxnAmt(aRecords,record,9,gcl);
	checkForTxnAmt(aRecords,record,265,prinBal);
	checkForTxnAmt(aRecords,record,272,recovery);
	checkForTxnAmt(aRecords,record,4086,lopEnr);

	return aRecords;
	
}

public static List<CommonBalanceRcTRLRecord> splitForBalanceTypesInRcRw(Object inputRecord,
		Double prinBal,Double gcl,Double recovery) throws ParseException{

	List<CommonBalanceRcTRLRecord> aRecords = new ArrayList<CommonBalanceRcTRLRecord>();
	InRcTRLRecord record = null;
	if(inputRecord instanceof InRcTRLRecord) {
		record = (InRcTRLRecord)inputRecord;
	}

	checkForTxnAmt(aRecords,record,1,prinBal);
	checkForTxnAmt(aRecords,record,9,gcl);
	checkForTxnAmt(aRecords,record,265,prinBal);
	checkForTxnAmt(aRecords,record,272,recovery);
//	checkForTxnAmt(aRecords,record,4086,record.getlo());

	return aRecords;
	
}

	//commented out by subhamoy for duplicate records while doing for In Rc
	/*public static CommonBalanceRcTRLRecord createCommonBalanceTRLRecord(InRcRwMastRecord record,Integer balType, Double txnAmt) {
		CommonBalanceRcTRLRecord commonBalanceRcTRLRecord  = new CommonBalanceRcTRLRecord(record);
		commonBalanceRcTRLRecord.setEBalType(balType);
		if(txnAmt != null) {
			commonBalanceRcTRLRecord.setETransAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			commonBalanceRcTRLRecord.setFunctionalAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} else  {
			commonBalanceRcTRLRecord.setETransAmt(new BigDecimal(record.geteTransAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
			//		commonBalanceRcTRLRecord.setFunctionalAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}

		*//** Added for Base Amount **//*
		if (commonBalanceRcTRLRecord.geteTransCurrCode().equals(commonBalanceRcTRLRecord.geteBaseCurrCode())){
			commonBalanceRcTRLRecord.setBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			commonBalanceRcTRLRecord.setBaseAmt(new BigDecimal(txnAmt).multiply(new BigDecimal(record.geteBaseAmtCurr())).setScale(5, BigDecimal.ROUND_HALF_UP));
		}


		return commonBalanceRcTRLRecord;
	}*/

	//commented out by subhamoy for duplicate records while doing for In Rc
	/*public static CommonBalanceRcTRLRecord createCommonBalanceTRLRecord(InRcRetMastRecord record,Integer balType, Double txnAmt) {
		CommonBalanceRcTRLRecord commonBalanceRcTRLRecord  = new CommonBalanceRcTRLRecord(record);
		commonBalanceRcTRLRecord.setEBalType(balType);
		if(txnAmt != null) {
			commonBalanceRcTRLRecord.setETransAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			commonBalanceRcTRLRecord.setFunctionalAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			//commonBalanceTRLRecord.setETxnAmt(txnAmt);
		} else  {
			commonBalanceRcTRLRecord.setETransAmt(new BigDecimal(record.geteTransAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
			//		commonBalanceRcTRLRecord.setFunctionalAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			//commonBalanceTRLRecord.setETxnAmt(record.geteTxnAmt());
		}

		*//** Added for Base Amount **//*
		if (commonBalanceRcTRLRecord.geteTransCurrCode().equals(commonBalanceRcTRLRecord.geteBaseCurrCode())){
			//commonBalanceTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceRcTRLRecord.setBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			commonBalanceRcTRLRecord.setBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}


		return commonBalanceRcTRLRecord;
	}*/
	//commented out by subhamoy for duplicate records while doing for In Rc
	/*public static CommonBalanceRcTRLRecord createCommonBalanceTRLRecord(InRcCorpMastRecord record,Integer balType, Double txnAmt) {

		CommonBalanceRcTRLRecord commonBalanceRcTRLRecord  = null;
		try {
			commonBalanceRcTRLRecord  = new CommonBalanceRcTRLRecord(record);
			commonBalanceRcTRLRecord.setEBalType(balType);
			if(txnAmt != null) {
				commonBalanceRcTRLRecord.setETransAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
				commonBalanceRcTRLRecord.setFunctionalAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
				//commonBalanceTRLRecord.setETxnAmt(txnAmt);
			} else  {
				commonBalanceRcTRLRecord.setETransAmt(new BigDecimal(record.geteTransAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
				//		commonBalanceRcTRLRecord.setFunctionalAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
				//commonBalanceTRLRecord.setETxnAmt(record.geteTxnAmt());
			}

			*//** Added for Base Amount **//*
			if (commonBalanceRcTRLRecord.geteTransCurrCode().equals(commonBalanceRcTRLRecord.geteBaseCurrCode())){
				//commonBalanceTRLRecord.setEBaseAmt(txnAmt);
				commonBalanceRcTRLRecord.setBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			}else{
				//commonBalanceTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
				commonBalanceRcTRLRecord.setBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return commonBalanceRcTRLRecord;
	}*/


	/**
	 * This method is for Fixing CB issue.
	 * Generating multiple rows for different Balance types
	 * @param record
	 * @return
	 * @throws ParseException
	 */
	public static List<CommonBalanceTRLRecord> splitForBalanceTypesHkCrdPreRbnw(CardsTRLRecord record, Integer tenr,Double tintfee,Double fees,Integer crlmt,Integer uncrlmt,
			//wo
			String index,Double woamt,String type,String rcode,Double woprin,Date recordDateWo,Double wofee,Double woint,
			//reco
			Integer amt,Integer comm,Integer reci,Date recordDateRecv
			) throws ParseException{
		
		List<CommonBalanceTRLRecord> aRecords = new ArrayList<CommonBalanceTRLRecord>();
		/*HkCardsWoRecord woRecord =  record.geteHKCardsWoRecord();
		HkCardsRecoveryRecord recvRecord =  record.geteHkCardsRecoRecord();*/
		if(tenr != null){
			if(tintfee != null){
				checkForTxnAmt(aRecords,record,1,((tenr-tintfee)));
			} else {
				checkForTxnAmt(aRecords,record,1,((Integer)(tenr)).doubleValue());
			}
		}else{
			checkForTxnAmt(aRecords,record,1,tintfee);
		}
		checkForTxnAmt(aRecords,record,9,getTxnAmtForBal9(index,woamt,type,rcode,woprin, recordDateWo,record));
		if(tintfee != null){
			if(fees != null){
				checkForTxnAmt(aRecords,record,226,((tintfee-fees)));
			} else {
				checkForTxnAmt(aRecords,record,226,((tintfee)));
			}
		}
		if(fees != null){
			checkForTxnAmt(aRecords,record,230,fees.doubleValue());
		}
		if(tenr != null) {
				checkForTxnAmt(aRecords,record,265,tenr.doubleValue());
		}
		if(crlmt != null){
			checkForTxnAmt(aRecords,record,270,crlmt.doubleValue());
		}
		checkForTxnAmt(aRecords,record,271,getTxnAmtForBal271(uncrlmt,crlmt));
		checkForTxnAmt(aRecords,record,1042,getTxnAmtForBal1042(recordDateRecv,amt,comm,reci, record));
		checkForTxnAmt(aRecords,record,1286,getTxnAmtForBal1286(recordDateRecv,amt, record));
		checkForTxnAmt(aRecords,record,246,getTxnAmtForBal246(recordDateWo,wofee, record));
		checkForTxnAmt(aRecords,record,242,getTxnAmtForBal242(recordDateWo,woint, record));
		
		if(tenr != null) {
			checkForTxnAmt(aRecords,record,265,tenr.doubleValue());
		}
		return aRecords;
	}

	private static Double getTxnAmtForBal246(Date recordDate,
			Double wofee, CardsTRLRecord record) {
				if(checkForRptDate(recordDate, record)){
					if(wofee != null){
						return wofee;
					}
				}
		return null;
	}

	private static Double getTxnAmtForBal271(Integer uncrlmt,Integer crlmt) {
		if(uncrlmt != null){
			if(crlmt != null){
				if((uncrlmt - crlmt) > 0) {
					return (double) (uncrlmt - crlmt);
				} else { return new Double(0); }
			} else{
					return uncrlmt.doubleValue();
			}
		}
		return null;	
	}

	/**
	 * This method is for Fixing CB issue.
	 * Generating multiple rows for different Balance types
	 * @param record
	 * @return
	 * @throws ParseException
	 */
	public static List<CommonBalanceTRLRecord> splitForBalanceTypesHkCrdRbnw(CardsTRLRecord record,Double tenr,Double tintfee,Double cshServFeeBnpLcy,
			Double overlimtFeeBnpLcy,Double nsfFeeBnpLcy,Double membrFeeBnpLcy,Double rtlServFeeBnpLcy,Double crlmLcyamtM,
			Double alopBalLcyamtC,Double insFeeBnpLcy,Double collFeeBnpLcy,Double recovFeeBnpLcy,Double servFeeFeeBnpLcy,
			Integer uncrlmt,
			//wo
			String index,Double woamt,String type,String rcode,Double woprin,Date recordDateWo,Double wofee,Double woint,
			//reco
					Integer amt,Integer comm,Integer reci,Date recordDateRecv
			) throws ParseException{
		
		List<CommonBalanceTRLRecord> aRecords = new ArrayList<CommonBalanceTRLRecord>();
//		HkCardsWoRecord woRecord =  record.geteHKCardsWoRecord();
//		HkCardsRecoveryRecord recvRecord =  record.geteHkCardsRecoRecord();
		if(tenr != null){
			if(tintfee != null){
				checkForTxnAmt(aRecords,record,1,(tenr-tintfee));
			}
			else{
				checkForTxnAmt(aRecords,record,1,tenr);
			}
		}else{
			checkForTxnAmt(aRecords,record,1,tintfee);
		}
		
		if(cshServFeeBnpLcy != null ) {
			checkForTxnAmt(aRecords,record,167,cshServFeeBnpLcy);
		}
		if(overlimtFeeBnpLcy != null) {
			checkForTxnAmt(aRecords,record,170,overlimtFeeBnpLcy);
		}
		if(nsfFeeBnpLcy != null) {
			checkForTxnAmt(aRecords,record,172,nsfFeeBnpLcy);
		}
		if(membrFeeBnpLcy!= null) {
			checkForTxnAmt(aRecords,record,174,membrFeeBnpLcy);
		}
		if(rtlServFeeBnpLcy!= null) {
			checkForTxnAmt(aRecords,record,177,rtlServFeeBnpLcy);
		}
		checkForTxnAmt(aRecords,record,230,getTxnAmtForBal230HKCard(collFeeBnpLcy,cshServFeeBnpLcy,insFeeBnpLcy,
				nsfFeeBnpLcy,membrFeeBnpLcy,overlimtFeeBnpLcy,rtlServFeeBnpLcy,recovFeeBnpLcy,servFeeFeeBnpLcy));
		if(woint != null) {
				checkForTxnAmt(aRecords,record,242,getTxnAmtForBal242(recordDateWo,woint, record));
		}
		if(wofee != null) {
			checkForTxnAmt(aRecords,record,246,getTxnAmtForBal246(recordDateWo,wofee, record));
		}
			
		if(crlmLcyamtM != null){
			checkForTxnAmt(aRecords,record,270,crlmLcyamtM);
		}	
		checkForTxnAmt(aRecords,record,271,getTxnAMtForBal271(uncrlmt,crlmLcyamtM));
		if(alopBalLcyamtC != null){
			checkForTxnAmt(aRecords,record,273,alopBalLcyamtC);
		}
		if(insFeeBnpLcy != null){
			checkForTxnAmt(aRecords,record,1223,insFeeBnpLcy);
		}
		checkForTxnAmt(aRecords,record,1042,getTxnAmtForBal1042(recordDateRecv,amt,comm,reci, record));
		checkForTxnAmt(aRecords,record,1286,getTxnAmtForBal1286(recordDateRecv,amt, record));
		checkForTxnAmt(aRecords,record,9,getTxnAmtForBal9(index,woamt,type,rcode,woprin,recordDateWo,record));
		checkForTxnAmt(aRecords,record,226,getTxnAmtForBal226HKCard(tintfee,collFeeBnpLcy,cshServFeeBnpLcy,insFeeBnpLcy,
				nsfFeeBnpLcy,membrFeeBnpLcy,overlimtFeeBnpLcy,rtlServFeeBnpLcy,recovFeeBnpLcy,servFeeFeeBnpLcy));
		if(tenr != null){
			checkForTxnAmt(aRecords,record,265,tenr);
		}	
		return aRecords;
		}

		

		private static Double getTxnAmtForBal242(Date recordDate,Double woint,
			CardsTRLRecord record) {
				if(checkForRptDate(recordDate, record)){
					if(woint != null){
						return woint;
					}
				}
		return null;
	}

		private static Double getTxnAmtForBal226HKCard(Double tintfee,Double collFeeBnpLcy,Double cshServFeeBnpLcy,Double insFeeBnpLcy,
				Double nsfFeeBnpLcy,Double membrFeeBnpLcy,Double overlimtFeeBnpLcy,Double rtlServFeeBnpLcy,Double recovFeeBnpLcy,Double servFeeFeeBnpLcy) {
			if(tintfee != null){
				if(collFeeBnpLcy != null){
					if(cshServFeeBnpLcy != null){
						if(insFeeBnpLcy != null){
							if(membrFeeBnpLcy != null){
								if(nsfFeeBnpLcy != null){
									if(overlimtFeeBnpLcy != null){
										if(recovFeeBnpLcy != null){
											if(rtlServFeeBnpLcy != null){
												if(servFeeFeeBnpLcy != null){
													return (tintfee - collFeeBnpLcy - cshServFeeBnpLcy -insFeeBnpLcy
															-membrFeeBnpLcy - nsfFeeBnpLcy - overlimtFeeBnpLcy - recovFeeBnpLcy 
															-rtlServFeeBnpLcy-servFeeFeeBnpLcy);
												} else { return (tintfee - collFeeBnpLcy - cshServFeeBnpLcy -insFeeBnpLcy
														-membrFeeBnpLcy - nsfFeeBnpLcy - overlimtFeeBnpLcy - recovFeeBnpLcy 
														-rtlServFeeBnpLcy); }
											}else { return (tintfee - collFeeBnpLcy - cshServFeeBnpLcy -insFeeBnpLcy
													-membrFeeBnpLcy - nsfFeeBnpLcy - overlimtFeeBnpLcy - recovFeeBnpLcy); }
										} else { return (tintfee - collFeeBnpLcy - cshServFeeBnpLcy -insFeeBnpLcy
												-membrFeeBnpLcy - nsfFeeBnpLcy - overlimtFeeBnpLcy); }
									}else { return (tintfee - collFeeBnpLcy - cshServFeeBnpLcy -insFeeBnpLcy
											-membrFeeBnpLcy - nsfFeeBnpLcy); }
								}else { return (tintfee - collFeeBnpLcy - cshServFeeBnpLcy -insFeeBnpLcy
										-membrFeeBnpLcy); }
							}else { return (tintfee - collFeeBnpLcy - cshServFeeBnpLcy -insFeeBnpLcy); }
						}else { return (tintfee - collFeeBnpLcy - cshServFeeBnpLcy); }
					} else { return (tintfee - collFeeBnpLcy); }
				}else{ return tintfee.doubleValue(); }
			}
		return null;
	}

	private static Double getTxnAmtForBal226(Double tintfee, Double collFeeBnpLcy,
			Double cshServFeeBnpLcy,
			Double insFeeBnpLcy,
			Double membrFeeBnpLcy,
			Double nsfFeeBnpLcy,
			Double overlimtFeeBnpLcy,
			Double recovFeeBnpLcy,
			Double rtlServFeeBnpLcy,
			Double servFeeFeeBnpLcy) {
		if(tintfee==null){
		return null;
		}
		else {return ((tintfee!=null?tintfee:0)-(collFeeBnpLcy!=null?collFeeBnpLcy:0) - (cshServFeeBnpLcy!=null?cshServFeeBnpLcy:0) - (insFeeBnpLcy!=null?insFeeBnpLcy:0)
		-(membrFeeBnpLcy!=null?membrFeeBnpLcy:0) -(nsfFeeBnpLcy!=null?nsfFeeBnpLcy:0) - (overlimtFeeBnpLcy!=null?overlimtFeeBnpLcy:0) - (recovFeeBnpLcy!=null?recovFeeBnpLcy:0) - (rtlServFeeBnpLcy!=null?rtlServFeeBnpLcy:0) 
		-(servFeeFeeBnpLcy!=null?servFeeFeeBnpLcy:0));
		
		}
}

	private static Double getTxnAmtForBal1042(Date recordDate,Integer amt,Integer comm,Integer reci,
			CardsTRLRecord record) {
			if(checkForRptDate(recordDate, record)){
						return getTxnAmt1042(amt,comm,reci);
					}
			return null;
		}
		
		private static Double getTxnAmtForBal1286(Date recordDate,Integer amt,
				CardsTRLRecord record) {
			if(checkForRptDate(recordDate, record)){
						if(amt > 0){
							return amt.doubleValue();
						}
			}
			return null;
		}
			
			private static Double getTxnAmtForBal9(String index,Double woamt,String type,String rcode,Double woprin,Date recordDate,
					//rainbow attr
					CardsTRLRecord record){
				if(recordDate != null){
					if(checkForRptDate(recordDate, record)){
						if(index != null &&!index.equalsIgnoreCase("R") && woamt> 0 && type != "901" && type != "920"
							&& type != "930" && type != "940" && type != "921" && type != "941" 
							&& rcode.equalsIgnoreCase("B") || rcode.equalsIgnoreCase("T")){
							if(woprin != null){
								return woprin;
							}
						}
					}
				}
				return null;
			}
			
			
			private static boolean checkForRptDate(Date recordDate,
					CardsTRLRecord record){
				if(recordDate != null){
					Calendar reportStartDate = new GregorianCalendar();
					Calendar reportEndDate = new GregorianCalendar();
					reportStartDate.setTime(record.geteRptMonthDate());
					reportStartDate.set(Calendar.DAY_OF_MONTH, 1);
					reportEndDate.setTime(record.geteRptMonthDate());
					reportEndDate.set(Calendar.DAY_OF_MONTH, reportEndDate.getActualMaximum(Calendar.DAY_OF_MONTH) );
					if(recordDate != null){
						if(recordDate.after(reportStartDate.getTime()) &&  recordDate.before(reportEndDate.getTime())){
							return true;
						}
					}
				}
				return false;
			}
			
	
	/*public static void main(String args[]){
	HkCardsRecoveryRecord recvRecord = new HkCardsRecoveryRecord();
	HkCardsRainbowRecord record = new HkCardsRainbowRecord();
	record.setERptMonthDate(new Date());
	getTxnAmtForBal1042(recvRecord, record);
}*/

			private static Double getTxnAmt1042(Integer amt,Integer comm,Integer reci) {
				if(amt != null && amt > 0){
					if(comm != null){
						if(reci != null){
							return ((Integer)(amt - comm - reci)).doubleValue();
						} else { return ((Integer)(amt - comm)).doubleValue(); }
					} else { return ((Integer)(amt)).doubleValue(); }
				}
				return null; 
			}

			private static Double getTxnAMtForBal271(Integer uncrlmt,Double crlmLcyamtM) {
				if(uncrlmt != null){
					if(crlmLcyamtM != null){
						if((uncrlmt - crlmLcyamtM) > 0) {
							return uncrlmt - crlmLcyamtM;
						} else { return new Double(0); }
					} else{
							return uncrlmt.doubleValue();
					}
				}
				return null;	
			}

			private static Double getTxnAmtForBal230HKCard(Double collFeeBnpLcy,Double cshServFeeBnpLcy,Double insFeeBnpLcy,
					Double nsfFeeBnpLcy,Double membrFeeBnpLcy,Double overlimtFeeBnpLcy,Double rtlServFeeBnpLcy,Double recovFeeBnpLcy,Double servFeeFeeBnpLcy) {
				if(collFeeBnpLcy != null){
					if(cshServFeeBnpLcy != null){
						if(membrFeeBnpLcy != null){
							if(insFeeBnpLcy != null){
								if(nsfFeeBnpLcy != null){
									if(overlimtFeeBnpLcy != null){
										if(recovFeeBnpLcy != null){
											if(rtlServFeeBnpLcy != null){
												if(servFeeFeeBnpLcy != null){
													return ((Double)(collFeeBnpLcy+cshServFeeBnpLcy+membrFeeBnpLcy+insFeeBnpLcy+nsfFeeBnpLcy+overlimtFeeBnpLcy+recovFeeBnpLcy+rtlServFeeBnpLcy+servFeeFeeBnpLcy)).doubleValue();
												} else { return ((Double)(collFeeBnpLcy+cshServFeeBnpLcy+membrFeeBnpLcy+insFeeBnpLcy+nsfFeeBnpLcy+overlimtFeeBnpLcy+recovFeeBnpLcy+rtlServFeeBnpLcy)).doubleValue(); }
											} else { return ((collFeeBnpLcy+cshServFeeBnpLcy+membrFeeBnpLcy+insFeeBnpLcy+nsfFeeBnpLcy+overlimtFeeBnpLcy+recovFeeBnpLcy)); }
										} else { return ((collFeeBnpLcy+cshServFeeBnpLcy+membrFeeBnpLcy+insFeeBnpLcy+nsfFeeBnpLcy+overlimtFeeBnpLcy)); }
									} else { return ((collFeeBnpLcy+cshServFeeBnpLcy+membrFeeBnpLcy+insFeeBnpLcy+nsfFeeBnpLcy)); }
								} else { return ((collFeeBnpLcy+cshServFeeBnpLcy+membrFeeBnpLcy+insFeeBnpLcy)); }
							} else { return ((collFeeBnpLcy+cshServFeeBnpLcy+membrFeeBnpLcy)); }
						} else { return ((collFeeBnpLcy+cshServFeeBnpLcy)); }
					} else { return ((collFeeBnpLcy)); }
				}
				return null;
			}


	private static Double getTxnAmtForBal230(Double collFeeBnpLcy,
			Double cshServFeeBnpLcy,
			Double insFeeBnpLcy,
			Double membrFeeBnpLcy,
			Double nsfFeeBnpLcy,
			Double overlimtFeeBnpLcy,
			Double recovFeeBnpLcy,
			Double rtlServFeeBnpLcy,
			Double servFeeFeeBnpLcy) {
		if(collFeeBnpLcy==null){
		return null;
		}
		else {return ((collFeeBnpLcy!=null?collFeeBnpLcy:0) - (cshServFeeBnpLcy!=null?cshServFeeBnpLcy:0) - (insFeeBnpLcy!=null?insFeeBnpLcy:0)
		-(membrFeeBnpLcy!=null?membrFeeBnpLcy:0) -(nsfFeeBnpLcy!=null?nsfFeeBnpLcy:0) - (overlimtFeeBnpLcy!=null?overlimtFeeBnpLcy:0) - (recovFeeBnpLcy!=null?recovFeeBnpLcy:0) - (rtlServFeeBnpLcy!=null?rtlServFeeBnpLcy:0) 
		-(servFeeFeeBnpLcy!=null?servFeeFeeBnpLcy:0));
		
		}
		
	}


public static Date getAsOfDate(String input) throws ParseException{
	Calendar calendar = new GregorianCalendar();
	
	if(input != null)
	{
	String year = input.substring(0,4);
	String month = input.substring(4,6);

	int Curmonth = Integer.parseInt(month);
	int CurYear = Integer.parseInt(year);
	
	

	calendar.set(Calendar.MONTH, Curmonth-1);
	calendar.set(Calendar.YEAR, CurYear);			
	calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE));
	return calendar.getTime();
	}
	else
	{
		return calendar.getTime();
	}
				
	
}

	public static Integer getCredFacTypId(String port) throws ParseException{

//		String port = inPLrecord.getPort();	
		String baselid = port.substring(3);

	if(baselid.equalsIgnoreCase("I"))
	{
		return 7;
	}
	else
	{
	return 1;
	}
}
	
	

	
	/*public static CommonBalancePlTRLRecord createCommonBalanceTRLRecord(inPLRecord record, Integer balType, Double txnAmt)
	{
		CommonBalancePlTRLRecord commonBalancePlTRLRecord  = new CommonBalancePlTRLRecord(record);
		commonBalancePlTRLRecord.seteBalType(balType);
		if(record.geteBalType() == null){
			record.setEBalType(balType);
		}
		else{
			record.setEBalType(record.geteBalType() + balType);
		}
		System.out.println(record.geteUniqueIdSrcSys()+"***********" +record.geteBalType());
		if(txnAmt != null) {
			commonBalancePlTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} else  {
			commonBalancePlTRLRecord.setETxnAmt(new BigDecimal(record.geteTxnAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		
		*//** Added for Base Amount **//*
		if (commonBalancePlTRLRecord.geteTransCurr().equals(commonBalancePlTRLRecord.geteBaseCurrencyCode())){
			commonBalancePlTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			commonBalancePlTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		return commonBalancePlTRLRecord;
	}*/
	
	
	/** Custom Methods for HK PL BEGINS **/
public static synchronized CommonBalancePlTRLRecord createCommonBalanceTRLRecord(LoansTRLRecord record, Integer balType, Double txnAmt)
{
	CommonBalancePlTRLRecord commonBalancePlTRLRecord  = new CommonBalancePlTRLRecord(record);
	commonBalancePlTRLRecord.seteBalType(balType);
	if(txnAmt != null) {
		commonBalancePlTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		/*if(balType==1){
			inputCheckSumHkPlProd=inputCheckSumHkPlProd .add(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));

		}else if (balType==265){
			inputCheckSumTwPl = inputCheckSumTwPl.add(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}*/
	} else  {
		commonBalancePlTRLRecord.setETxnAmt(new BigDecimal(record.geteTxnAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
		/*if(balType==1){
			inputCheckSumHkPlProd=inputCheckSumHkPlProd .add(new BigDecimal(record.geteTxnAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else if (balType==265){
			inputCheckSumTwPl = inputCheckSumTwPl.add(new BigDecimal(record.geteTxnAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}*/
	}
	/** Added for Functional Amount **/
	if(txnAmt != null) {
		commonBalancePlTRLRecord.setFunctionalAmt(txnAmt);
	}

	/** Added for Base Amount **/
	if (commonBalancePlTRLRecord.geteTransCurr().equals(commonBalancePlTRLRecord.geteBaseCurrencyCode())){
		commonBalancePlTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
	}else{
		commonBalancePlTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
	}

	return commonBalancePlTRLRecord;
}

/*	public static CommonBalancePlTRLRecord createCommonBalanceTRLRecord(HKPLPostRainbowRecord record, Integer balType, Double txnAmt)
	{
		CommonBalancePlTRLRecord commonBalancePlTRLRecord  = new CommonBalancePlTRLRecord(record);
		commonBalancePlTRLRecord.seteBalType(balType);
		if(txnAmt != null) {
			commonBalancePlTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} else  {
			commonBalancePlTRLRecord.setETxnAmt(new BigDecimal(record.geteTxnAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		
		*//** Added for Base Amount **//*
		if (commonBalancePlTRLRecord.geteTransCurr().equals(commonBalancePlTRLRecord.geteBaseCurrencyCode())){
			commonBalancePlTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			commonBalancePlTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		return commonBalancePlTRLRecord;
	}
	*/
	

private static void checkForTxnAmt(List<CommonBalancePlTRLRecord> aRecords, LoansTRLRecord record, int balTyp, Double value) {
	// TODO Auto-generated method stub
	if(value != null && value.doubleValue() != 0.0) {
		aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
	}
}

//private static void checkForTxnAmt(List<CommonBalancePlTRLRecord> aRecords, HKPLPreRainbowRecord record, int balTyp, Double value) {
//	// TODO Auto-generated method stub
//	if(value != null && value.doubleValue() != 0.0) {
//		aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
//	}
//}



	public static List<CommonBalancePlTRLRecord> splitForBalanceTypesForHKPLPostRainbow(LoansTRLRecord record,Double recAmt,Double woAmt,Double accrIntYYMM,Double nbalYYMM,Double faceAmt, Double dlqIntYYMM,String lnTyp,Double enrPrinYYMM,Integer lnStYYMM) throws ParseException{	
	
	List<CommonBalancePlTRLRecord> aRecords = new ArrayList<CommonBalancePlTRLRecord>();
		checkForTxnAmt(aRecords,record,1,getTxnAmtForBal1HkPlRnbw(lnTyp, enrPrinYYMM, lnStYYMM, dlqIntYYMM, nbalYYMM, accrIntYYMM));
		if(woAmt != null){
			checkForTxnAmt(aRecords,record,9,woAmt);
			if(recAmt != null){
				checkForTxnAmt(aRecords,record,268,(woAmt - recAmt));
			}
		}
		checkForTxnAmt(aRecords,record,98,accrIntYYMM);
		checkForTxnAmt(aRecords,record,265,nbalYYMM);
		checkForTxnAmt(aRecords,record,4014,dlqIntYYMM);
		checkForTxnAmt(aRecords,record,1042,recAmt);
		checkForTxnAmt(aRecords,record,4155,faceAmt);
		return aRecords;
	}


	public static List<CommonBalancePlTRLRecord> splitForBalanceTypesForHKPLPreRainbow(LoansTRLRecord record,Double recAmt,Double woAmt,Double accrIntYYMM,Double nbalYYMM,Double faceAmt, Double dlqIntYYMM,String lnTyp,Double enrPrinYYMM,Integer lnStYYMM) throws ParseException{

		List<CommonBalancePlTRLRecord> aRecords = new ArrayList<CommonBalancePlTRLRecord>();
		checkForTxnAmt(aRecords,record,1,getTxnAmtForBal1HkPlPreRnbw( lnTyp, enrPrinYYMM, lnStYYMM, dlqIntYYMM, nbalYYMM, accrIntYYMM));
		if(woAmt != null){
			checkForTxnAmt(aRecords,record,9,woAmt);
			if(recAmt != null){
				checkForTxnAmt(aRecords,record,268,(woAmt - recAmt));
			}
		}
		checkForTxnAmt(aRecords,record,98,accrIntYYMM);
		checkForTxnAmt(aRecords,record,265,nbalYYMM);
		checkForTxnAmt(aRecords,record,4014,dlqIntYYMM);
		checkForTxnAmt(aRecords,record,1042,recAmt);
		checkForTxnAmt(aRecords,record,4155,faceAmt);
		return aRecords;

	}




	private static Double getTxnAmtForBal1HkPlPreRnbw(String lnTyp,Double enrPrinYYMM, Integer lnStYYMM, Double dlqIntYYMM, Double nbalYYMM, Double accrIntYYMM) {
		//	String lnTyp= record.getLnTyp();
		//	Double enrPrinYYMM = record.getEnrPrinYYMM();
		//	Integer lnStYYMM = record.getLnStYYMM();
		//	Double dlqIntYYMM = record.getDlqIntYYMM();
		//	Double nbalYYMM = record.getNbalYYMM();
		//	Double accrIntYYMM = record.getAccrIntYYMM();

		if("251".equalsIgnoreCase(lnTyp) || "252".equalsIgnoreCase(lnTyp) || "253".equalsIgnoreCase(lnTyp)) {
			return enrPrinYYMM;
		} else if(lnStYYMM!= null && lnStYYMM == 5 ) {
			return nbalYYMM;
		} else {
			return (nbalYYMM - (accrIntYYMM + dlqIntYYMM));
		} 
	}



	private static Double getTxnAmtForBal1HkPlRnbw(String lnTyp,Double enrPrinYYMM, Integer lnStYYMM, Double dlqIntYYMM, Double nbalYYMM, Double accrIntYYMM) {
		//	String lnTyp= record.getLnTyp();
		//	Double enrPrinYYMM = record.getEnrPrinYYMM();
		//	Integer lnStYYMM = record.getLnStYYMM();
		//	Double dlqIntYYMM = record.getDlqIntYYMM();
		//	Double nbalYYMM = record.getNbalYYMM();
		//	Double accrIntYYMM = record.getAccrIntYYMM();

		if("251".equalsIgnoreCase(lnTyp) || "252".equalsIgnoreCase(lnTyp) || "253".equalsIgnoreCase(lnTyp)) {
			return enrPrinYYMM;
		} else if(lnStYYMM!= null && lnStYYMM == 5 ) {
			return nbalYYMM;
		} else {
			return (nbalYYMM - (accrIntYYMM + dlqIntYYMM));
		} 
	}






	/** Custom Methods for HK PL ENDS **/
	
	
	
		/**
	 * This method is for Fixing CB issue.
	 * Generating multiple rows for different Balance types
	 * @param record
	 * @return
	 * @throws ParseException
	 */
	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForInMtgOreo(OreoTRLRecord record, Double oreoPosNew,Double oreoPos) throws ParseException{

		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();			
		checkForTxnAmt(aRecords,record,4083,oreoPosNew);
		checkForTxnAmt(aRecords,record,4085,oreoPos);

		if(oreoPosNew!= null && oreoPosNew != 0){
			checkForTxnAmt(aRecords,record,162,oreoPosNew);
		}else{
			checkForTxnAmt(aRecords,record,162,oreoPos);
		}

		return aRecords;
	}
	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForInMtgGcbc(MortgageTRLRecord record,String fipFlag,Double newprin,Double provHold,Double pos,Double netbal) throws ParseException{

		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();		

		//checkForTxnAmt(aRecords,record,1,record.getNewprin());
		checkForTxnAmt(aRecords,record,1,(newprin - provHold)); // sit fix
		if("Y".equals(fipFlag)){
			checkForTxnAmt(aRecords,record,181,pos);
		}
		//if(record.getNetbal() > 0){
		//	checkForTxnAmt(aRecords,record,4127,record.getNetbal());
		//}else{
		//	checkForTxnAmt(aRecords,record,4127,0.0);
		//}
		if(netbal >= 0){
			checkForTxnAmt(aRecords,record,265,netbal);
		}


			
			//checkForTxnAmt(aRecords,record,4086,record.getR);
		//	checkForTxnAmt(aRecords,record,4086,record.getReco()); // commented for Sit fix as per mapping sheet mapping indicator is blank
		//checkForTxnAmt(aRecords,record,1233,record.getGcl());

		return aRecords;
	}
	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForInMtgGcl(GclTRLRecord record,Double gcl,Double reco) throws ParseException{

		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();		
		//checkForTxnAmt(aRecords,record,4086,record.getReco()); // commented for Sit fix as per mapping sheet mapping indicator is blank
		checkForTxnAmt(aRecords,record,1233,gcl);
		checkForTxnAmt(aRecords,record,268,checkNull(gcl)-checkNull(reco));
		checkForTxnAmt(aRecords,record,1042,reco);
		return aRecords;
	}

	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForHkMtgPostRnbw(Object inputRecord,
			Double osBlUs,Double unIntUs,Double totoreorepo,Double recoveryAmt,Double lnAmt,Double gwo,Double lateFeeUs) throws ParseException{
		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();
		
		MortgageTRLRecord record = null;
		if(inputRecord instanceof MortgageTRLRecord) {
			record = (MortgageTRLRecord)inputRecord;
		}
		
		checkForTxnAmt(aRecords,record,1,osBlUs);
		checkForTxnAmt(aRecords,record,179,unIntUs);
		checkForTxnAmt(aRecords,record,181,totoreorepo);
		if(osBlUs!= null){
			if(unIntUs!= null){
				if(lateFeeUs != null){
					checkForTxnAmt(aRecords,record,265,(osBlUs + unIntUs + lateFeeUs));
				} else {
					checkForTxnAmt(aRecords,record,265,(osBlUs + unIntUs));
				}
			}else{
				checkForTxnAmt(aRecords,record,265,(osBlUs));
			}
		}
		if(recoveryAmt != null) {
			//checkForTxnAmt(aRecords,record,1286,record.geteRecRecord().getRecoveryAmt());
			checkForTxnAmt(aRecords,record,1286,recoveryAmt);
		}
		if(lnAmt != null){
			checkForTxnAmt(aRecords,record,4155,lnAmt);
		}
		if(gwo != null) {
			//checkForTxnAmt(aRecords,record,9,record.geteWrtOffRecord().getGwo());
			checkForTxnAmt(aRecords,record,9,gwo);
		}
		return aRecords;		
	}
	

	
	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForHkMtgPreRnbw(Object inputRecord,
			Double osBlUs,Double unIntUs,Double totoreorepo,Double latefeeus,Double recoveryAmt,Double lnAmt,Double gwo) throws ParseException{
		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();
		
		MortgageTRLRecord record = null;
		if(inputRecord instanceof MortgageTRLRecord) {
			record = (MortgageTRLRecord)inputRecord;
		}
		
		checkForTxnAmt(aRecords,record,1,osBlUs);
		checkForTxnAmt(aRecords,record,179,unIntUs);
		checkForTxnAmt(aRecords,record,181,totoreorepo);
		if(osBlUs!= null){
			if(unIntUs!= null){
				if(latefeeus != null){
					checkForTxnAmt(aRecords,record,265,(osBlUs + latefeeus));
				} else {
					checkForTxnAmt(aRecords,record,265,(osBlUs + unIntUs));
				}
			}else{
				checkForTxnAmt(aRecords,record,265,(osBlUs));
			}
		}
		if(recoveryAmt != null) {
			//checkForTxnAmt(aRecords,record,1286,record.geteRecRecord().getRecoveryAmt());
			checkForTxnAmt(aRecords,record,1286,recoveryAmt);
		}
		if(lnAmt != null){
			checkForTxnAmt(aRecords,record,4155,lnAmt);
		}
		if(gwo != null) {
			//checkForTxnAmt(aRecords,record,9,record.geteWrtOffRecord().getGwo());
			checkForTxnAmt(aRecords,record,9,gwo);
		}
		
		return aRecords;		
	}
	
//	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForHkMtgWrtOff(HkMtgWrtOffRecord record) throws ParseException{
//		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();	
//		checkForTxnAmt(aRecords,record,9,record.getGwo());
//		return aRecords;		
//	}
//	
//	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForHkMtgRecovery(HkMtgRecoveryRecord record) throws ParseException{
//		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();	
//		checkForTxnAmt(aRecords,record,4086,record.getRecoveryAmt());
//		checkForTxnAmt(aRecords,record,1286,record.getRecoveryAmt());
//		return aRecords;		
//	}
	/**
	 * This method is for Fixing CB issue.
	 * Generating multiple rows for different Balance types
	 * @param record
	 * @return
	 * @throws ParseException
	 */
	public static List<CommonBalanceRcTRLRecord> splitForBalanceTypesForHkRcPreRainbow(Object inputRecord,
			Double fees,
			Double woInt,
			String index,
			String cardType,
			String rCode,
			Double woPrin,
			Double woAmt,
			Date recordDate,
			Date eAsOfDate,Double tintfee,Double tenr,Double crlMt,Integer recvAmt,
			Integer recvCom,
			Integer recvReci) throws ParseException{

		List<CommonBalanceRcTRLRecord> aRecords = new ArrayList<CommonBalanceRcTRLRecord>();

		InRcTRLRecord record = null;
		if(inputRecord instanceof InRcTRLRecord) {
			record = (InRcTRLRecord)inputRecord;
		}

		//HkRcWoRecord woRecord = record.geteHKRcWoRecord();
		checkForTxnAmt(aRecords,record,230,fees!= null ? fees  : null);
		//checkForTxnAmt(aRecords,record,4097,record.getCrlmt()!= null ? record.getCrlmt().doubleValue()  : null); // commented for sit fix
		checkForTxnAmt(aRecords,record,242,woInt);
		checkForTxnAmt(aRecords,record,1042,getRecv(recvAmt,recvCom,recvReci));
		checkForTxnAmt(aRecords,record,9,getTxnAmtForBal9(index,woAmt,cardType,rCode,woPrin,recordDate,eAsOfDate));
		checkForTxnAmt(aRecords,record,1286,getTxnAmtForBal1286(recordDate,eAsOfDate,woAmt));
		checkForTxnAmt(aRecords,record,1,getTxnAmtForBal1HkRcPreRnbw(tenr,tintfee));
		checkForTxnAmt(aRecords,record,226,getTxnAmtForBal226(tintfee, fees));
		checkForTxnAmt(aRecords,record,265,tenr != null ? tenr  : null);
		checkForTxnAmt(aRecords,record,270,crlMt != null ? crlMt  : null);

		checkForTxnAmt(aRecords,record,246,getTxnAmtForBal246(recordDate,eAsOfDate,
				woPrin,woInt,woAmt));
		return aRecords;
	}

	private static Double getTxnAmtForBal1HkRcPreRnbw(Double tenr,Double tintfee) {
		//		Double tenr = record.getTenr();
		//		Integer tintfee = record.getTintfee();

		if(tenr!= null && tintfee != null){
			return (tenr - tintfee);
		}else if(tenr!= null && tintfee == null){
			return tenr;
		}else if(tenr== null && tintfee != null){
			return tintfee;
		}
		return null;
	}

	private static Double getTxnAmtForBal226(Double tintfee,Double fees) {
		//Integer fees = fees;

		if(tintfee!= null && fees != null){
			return (tintfee - fees);
		}else if(tintfee!= null && fees == null){
			return tintfee;
		}else if(tintfee== null && fees != null){
			return 0.0;
		}
		return null;
	}

	

	private static Double getTxnAmtForBal246(Date recordDate,Date eAsOfDate,
			Double woPrin,Double woInt,Double woAmt){
		if(checkForRptDate(recordDate,eAsOfDate)){
			getTxnAmt246(woPrin,woInt,woAmt);
		}
		return null;
	}

	private static Double getTxnAmt246(Double woPrin,Double woInt,Double woAmt) {
		if((woAmt != null) && (woInt != null)  && (woPrin != null)){
			return woAmt - woInt - woPrin;
		}
		return null; 
	}



	private static Double getTxnAmtForBal1286(Date recordDate,Date eAsOfDate,Double woAmt) {
		if(checkForRptDate(recordDate,eAsOfDate)){
			if(woAmt > 0){
				return woAmt;
			}
		}
		return null;
	}



	private static Double getTxnAmtForBal9(String index,Double woAmt,
			String cardType,String rCode,Double woPrin,Date recordDate,Date eAsOfDate){

		if(checkForRptDate(recordDate,eAsOfDate)){
			if(!index.equalsIgnoreCase("R") && woAmt > 0 && cardType != "901" && cardType != "920"
					&& cardType != "930" && cardType != "940" && cardType != "921" && cardType != "941" 
					&& rCode.equalsIgnoreCase("B") || rCode.equalsIgnoreCase("T")){
				if(woPrin != null){
					return woPrin;
				}
			}

		}
		return null;
	}

	private static boolean checkForRptDate(Date recordDate,Date eAsOfDate
			//			HkRcWoRecord woRecord, 		HkRcPreRainbowRecord record
			){
		if(recordDate != null){
			Calendar reportStartDate = new GregorianCalendar();
			Calendar reportEndDate = new GregorianCalendar();
			reportStartDate.setTime(eAsOfDate);
			reportStartDate.set(Calendar.DAY_OF_MONTH, 1);
			reportEndDate.setTime(eAsOfDate);
			reportEndDate.set(Calendar.DAY_OF_MONTH, reportEndDate.getActualMaximum(Calendar.DAY_OF_MONTH) );
			if(recordDate != null){
				if(recordDate.after(reportStartDate.getTime()) &&  recordDate.before(reportEndDate.getTime())){
					return true;
				}
			}
		}
		return false;
	}

	/*private static Double getTxnAmtForBal9(HkRcWoRecord woRecord, HkRcRainbowRecord record){
		if(woRecord != null){
			if(checkForRptDate(woRecord, record)){
				if(!woRecord.getIndex().equalsIgnoreCase("R") && woRecord.getWoamt()> 0 && record.getCrdTyp() != "901" && record.getCrdTyp() != "920"
					&& record.getCrdTyp() != "930" && record.getCrdTyp() != "940" && record.getCrdTyp() != "921" && record.getCrdTyp() != "941" 
					&& woRecord.getRcode().equalsIgnoreCase("B") || woRecord.getRcode().equalsIgnoreCase("T")){
					if(woRecord.getWoprin() != null){
						return woRecord.getWoprin().doubleValue();
					}
				}
			}
		}
		return null;
	}

	private static boolean checkForRptDate(HkRcWoRecord woRecord,
			HkRcRainbowRecord record){
      if(woRecord != null){
            Calendar reportStartDate = new GregorianCalendar();
            Calendar reportEndDate = new GregorianCalendar();
            reportStartDate.setTime(record.geteAsOfDate());
            reportStartDate.set(Calendar.DAY_OF_MONTH, 1);
            reportEndDate.setTime(record.geteAsOfDate());
            reportEndDate.set(Calendar.DAY_OF_MONTH, reportEndDate.getActualMaximum(Calendar.DAY_OF_MONTH) );
            if(woRecord.getRecord() != null){
                  if(woRecord.getRecord().after(reportStartDate.getTime()) &&  woRecord.getRecord().before(reportEndDate.getTime())){
                        return true;
                  }
            }
      }
      return false;
}

	private static boolean checkForRptDate(HkRcRecoveryRecord woRecord,
			HkRcPreRainbowRecord record){
      if(woRecord != null){
            Calendar reportStartDate = new GregorianCalendar();
            Calendar reportEndDate = new GregorianCalendar();
            reportStartDate.setTime(record.geteAsOfDate());
            reportStartDate.set(Calendar.DAY_OF_MONTH, 1);
            reportEndDate.setTime(record.geteAsOfDate());
            reportEndDate.set(Calendar.DAY_OF_MONTH, reportEndDate.getActualMaximum(Calendar.DAY_OF_MONTH) );
            if(woRecord.getRecord() != null){
                  if(woRecord.getRecord().after(reportStartDate.getTime()) &&  woRecord.getRecord().before(reportEndDate.getTime())){
                        return true;
                  }
            }
      }
      return false;
}

	private static boolean checkForRptDate(HkRcRecoveryRecord woRecord,
			HkRcRainbowRecord record){
      if(woRecord != null){
            Calendar reportStartDate = new GregorianCalendar();
            Calendar reportEndDate = new GregorianCalendar();
            reportStartDate.setTime(record.geteAsOfDate());
            reportStartDate.set(Calendar.DAY_OF_MONTH, 1);
            reportEndDate.setTime(record.geteAsOfDate());
            reportEndDate.set(Calendar.DAY_OF_MONTH, reportEndDate.getActualMaximum(Calendar.DAY_OF_MONTH) );
            if(woRecord.getRecord() != null){
                  if(woRecord.getRecord().after(reportStartDate.getTime()) &&  woRecord.getRecord().before(reportEndDate.getTime())){
                        return true;
                  }
            }
      }
      return false;
}*/


	public static List<CommonBalanceRcTRLRecord> splitForBalanceTypesForHkRcRainbow(Object inputRecord,
			Double insFeeBnpLcy,
			Double uncrlmt,
			Double crlmLcyamtM,
			String index,Double woAmt,
			String crdTyp,String rCode,Double woPrin,
			Date recordDate,Date eAsOfDate,
			Double tenr,Double tintfee,
			Double cshServFeeBnpLcy,
			Double overlimtFeeBnpLcy,
			Double nsfFeeBnpLcy,
			Double membrFeeBnpLcy,
			Double rtlServFeeBnpLcy,
			Double alopBalLcyamtC,
			Double woInt,
			Double collFeeBnpLcy,
			Double recovFeeBnpLcy,
			Double servFeeFeeBnpLcy,
			Integer recvAmt,
			Integer recvCom,
			Integer recvReci

			) throws ParseException{

		List<CommonBalanceRcTRLRecord> aRecords = new ArrayList<CommonBalanceRcTRLRecord>();
		
		InRcTRLRecord record = null;
		if(inputRecord instanceof InRcTRLRecord) {
			record = (InRcTRLRecord)inputRecord;
		}
		//HkRcWoRecord woRecord = record.geteHKRcWoRecord();

		checkForTxnAmt(aRecords,record,242,woInt);
		checkForTxnAmt(aRecords,record,1042,getRecv(recvAmt,recvCom,recvReci));
		checkForTxnAmt(aRecords,record,1223,insFeeBnpLcy!= null ? insFeeBnpLcy  : null);
		//checkForTxnAmt(aRecords,record,4097,record.getCrlmLcyamtM()!= null ? record.getCrlmLcyamtM().doubleValue()  : null); // commented for sit fix

		if(uncrlmt!= null && crlmLcyamtM != null)
		{			
			checkForTxnAmt(aRecords,record,271,((uncrlmt - crlmLcyamtM > 0) ? (crlmLcyamtM - crlmLcyamtM)  : 0));
		}
		checkForTxnAmt(aRecords,record,9,getTxnAmtForBal9(index,woAmt,crdTyp,rCode, woPrin, recordDate, eAsOfDate));
		checkForTxnAmt(aRecords,record,1286,getTxnAmtForBal1286(recordDate,eAsOfDate,woAmt));

		checkForTxnAmt(aRecords,record,1,getTxnAmtForBal1HkRcPreRnbw(tenr,tintfee));
		checkForTxnAmt(aRecords,record,167,cshServFeeBnpLcy!= null ? cshServFeeBnpLcy : null);
		checkForTxnAmt(aRecords,record,170,overlimtFeeBnpLcy!= null ? overlimtFeeBnpLcy  : null);
		checkForTxnAmt(aRecords,record,172,nsfFeeBnpLcy!= null ? nsfFeeBnpLcy  : null);
		checkForTxnAmt(aRecords,record,174,membrFeeBnpLcy!= null ? membrFeeBnpLcy  : null);
		checkForTxnAmt(aRecords,record,177,rtlServFeeBnpLcy!= null ? rtlServFeeBnpLcy  : null);
		checkForTxnAmt(aRecords,record,265,tenr!= null ? tenr  : null);
		checkForTxnAmt(aRecords,record,270,crlmLcyamtM!= null ? crlmLcyamtM  : null);
		checkForTxnAmt(aRecords,record,273,alopBalLcyamtC!= null ? alopBalLcyamtC  : null);

		checkForTxnAmt(aRecords,record,226,getTxnAmtForBal226(tintfee,collFeeBnpLcy,cshServFeeBnpLcy,
				insFeeBnpLcy,
				membrFeeBnpLcy,
				nsfFeeBnpLcy,
				overlimtFeeBnpLcy,
				recovFeeBnpLcy,
				rtlServFeeBnpLcy,
				servFeeFeeBnpLcy));




		checkForTxnAmt(aRecords,record,230,getTxnAmtForBal230(collFeeBnpLcy,cshServFeeBnpLcy,
				insFeeBnpLcy,
				membrFeeBnpLcy,
				nsfFeeBnpLcy,
				overlimtFeeBnpLcy,
				recovFeeBnpLcy,
				rtlServFeeBnpLcy,
				servFeeFeeBnpLcy));

		checkForTxnAmt(aRecords,record,246,getTxnAmtForBal246(recordDate, eAsOfDate,woPrin, woInt, woAmt));
		return aRecords;
	}
	private static Double getTxnAmtForBal1Rainbow(Double tenr,Integer tintfee) {
		//		Double tenr = record.getTenr();
		//		Integer tintfee = record.getTintfee();
		//	
		if(tenr!= null && tintfee != null){
			return (tenr.doubleValue() - tintfee.doubleValue());
		}else if(tenr!= null && tintfee == null){
			return tenr.doubleValue();
		}else if(tenr== null && tintfee != null){
			return 0.0;
		}
		return null;
	}

	private static Double getRecv(Integer recvAmt,
			Integer recvCom,
			Integer recvReci) {
		/*Integer recvAmt;
Integer recvCom;
Integer recvReci;*/


		/*recvAmt = record.geteHKRcRecvRecord().getAmt();
recvCom = record.geteHKRcRecvRecord().getComm();
recvReci = record.geteHKRcRecvRecord().getReci();*/

		if(recvAmt != null && recvCom != null && recvReci != null){
			return recvAmt.doubleValue() - recvCom.doubleValue() - recvReci.doubleValue();
		}else if(recvAmt != null && recvCom == null && recvReci == null){
			return recvAmt.doubleValue();
		}else if(recvAmt != null && recvCom == null && recvReci != null){
			return recvAmt.doubleValue() - recvReci.doubleValue();
		}else if(recvAmt != null && recvCom != null && recvReci == null){
			return recvAmt.doubleValue() - recvCom.doubleValue();
		}else if(recvAmt == null && recvCom != null && recvReci != null){
			return recvCom.doubleValue() - recvReci.doubleValue();
		}else if(recvCom != null && recvAmt == null && recvReci == null){
			return recvCom.doubleValue();
		}else if(recvReci != null && recvAmt == null && recvCom == null){
			return recvReci.doubleValue();
		}
		
		return null;
	}

	private static Double getWoint(Double woInt) {
		/*if(record.geteHKRcWoRecord() == null){
			return null;
		}*/
		//	if(record.geteHKRcWoRecord().getWoint()!=null){
		return woInt;
		//	}
		//	return null;
	}

	private static void checkForTxnAmt(List<CommonBalanceRcTRLRecord> aRecords, InRcTRLRecord record, int balTyp, Double value) {
		// TODO Auto-generated method stub II
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	
	public synchronized static CommonBalanceRcTRLRecord createCommonBalanceTRLRecord(InRcTRLRecord record,Integer balType, Double txnAmt) {
		CommonBalanceRcTRLRecord commonBalanceRcTRLRecord  = new CommonBalanceRcTRLRecord(record);
		//System.out.println("********************* balType = "+ balType);
		
		commonBalanceRcTRLRecord.setEBalType(balType);
		if(txnAmt != null) {
			commonBalanceRcTRLRecord.setETransAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			commonBalanceRcTRLRecord.setFunctionalAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			//commonBalanceTRLRecord.setETxnAmt(txnAmt);
			/*if(balType==265){
			inputCheckSumTwProd=inputCheckSumTwProd.add(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			}*/
		} else  {
			commonBalanceRcTRLRecord.setETransAmt(new BigDecimal(record.geteTransAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
			commonBalanceRcTRLRecord.setFunctionalAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
			//commonBalanceTRLRecord.setETxnAmt(record.geteTxnAmt());
			/*if(balType==265){
			inputCheckSumTwProd=inputCheckSumTwProd.add(new BigDecimal(record.geteTransAmt()).setScale(5, BigDecimal.ROUND_HALF_UP));
			}*/
		}

		/** Added for Base Amount **/
		if (commonBalanceRcTRLRecord.geteTransCurrCode().equals(commonBalanceRcTRLRecord.geteBaseCurrCode())){
			//commonBalanceTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceRcTRLRecord.setBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			//System.out.println("record.geteBaseAmtCurr() = "+ record.geteBaseAmtCurr());
			commonBalanceRcTRLRecord.setBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
			
		
		return commonBalanceRcTRLRecord;
	}
	
	
	
	public static Integer getDeliqValueasInt(String  input) throws ParseException{
		
//		String input = inCardsrecord.getTr400DeliqCnt();
		

		if(input == null || input == "")
		{
			return 9;
		}
		else
		{
		return Integer.valueOf(input);
		}
	}
	
	public static List<ArrangementTRLTwRcRecord> splitForRateTypesForTwRc(InRcTRLRecord record) throws ParseException {

		List<ArrangementTRLTwRcRecord> aRecords = new ArrayList<ArrangementTRLTwRcRecord>();
		//ArrangementTRLRecord arrangementTRLRecord1 = new ArrangementTRLRecord(record);
		ArrangementTRLTwRcRecord arrangementTRLRecord1 = new ArrangementTRLTwRcRecord(record);
		
		//System.out.println("record.geteCiRate()="+record.geteCiRate() + "; record.geteRiRate()="+record.geteRiRate()+ "; record.geteEffectiveRatePercent()= " + record.geteEffectiveRatePercent());
		
		if (record.geteCiRate() != null) {
			//System.out.println("setting ci");
			arrangementTRLRecord1.setEEffectiveRatePercent(record.geteCiRate());
			arrangementTRLRecord1.setArrngRateTypRelnTypId(81);
		} else {
			arrangementTRLRecord1.setEEffectiveRatePercent(new Double(1.25));
			arrangementTRLRecord1.setArrngRateTypRelnTypId(81);
		}
		aRecords.add(arrangementTRLRecord1);

		ArrangementTRLTwRcRecord arrangementTRLRecord2 = new ArrangementTRLTwRcRecord(record);
		if (record.geteRiRate() != null) {
			//System.out.println("setting ri");
			arrangementTRLRecord2.setEEffectiveRatePercent(record.geteRiRate());
		} else {
			arrangementTRLRecord2.setEEffectiveRatePercent(new Double(1.25));
		}
		arrangementTRLRecord2.setArrngRateTypRelnTypId(78);

		aRecords.add(arrangementTRLRecord2);

		return aRecords;
	}
	
	private static void checkForTxnAmt(List<CommonBalanceRcTRLRecord> aRecords, TwRcPreRainbowRecord record, int balTyp, Double value) {
		// TODO Auto-generated method stub
		if(value != null && value.doubleValue() != 0.0) {
			aRecords.add(createCommonBalanceTRLRecord(record,balTyp,value));
		}
	}
	
	public static List<CommonBalanceRcTRLRecord> splitForBalanceTypesForTwRcPreRainbow(TwRcPreRainbowRecord record) throws ParseException{
		List<CommonBalanceRcTRLRecord> aRecords = new ArrayList<CommonBalanceRcTRLRecord>();
		if(record.getCashAccrIntr() != null && record.getRtlAccrIntr() != null){
			checkForTxnAmt(aRecords,record,7,(record.getCashAccrIntr() + record.getRtlAccrIntr()));
		}else if(record.getCashAccrIntr() != null && record.getRtlAccrIntr() == null){
			checkForTxnAmt(aRecords,record,7,(record.getCashAccrIntr() + 0));
		}else if(record.getCashAccrIntr() == null && record.getRtlAccrIntr() != null){
			checkForTxnAmt(aRecords,record,7,(0 + record.getRtlAccrIntr()));
		}
		
		if(record.geteTwRcWoRecord() != null){
			checkForTxnAmt(aRecords,record,9,record.geteTwRcWoRecord().getWoP());
		}
		
		if(record.getLrtlamt2() != null && record.getOrtlamt2() != null){
			checkForTxnAmt(aRecords,record,220,record.getLrtlamt2() + record.getOrtlamt2());
		}else if(record.getLrtlamt2() != null && record.getOrtlamt2() == null){
			checkForTxnAmt(aRecords,record,220,record.getLrtlamt2());
		}else if(record.getLrtlamt2() == null && record.getOrtlamt2()!= null){
			checkForTxnAmt(aRecords,record,220,record.getOrtlamt2());
		}
		
		if(record.getLcshamt2() != null && record.getOcshamt2() != null){
			checkForTxnAmt(aRecords,record,221,(record.getLcshamt2() + record.getOcshamt2()));
		}else if(record.getLcshamt2() != null && record.getOcshamt2() == null){
			checkForTxnAmt(aRecords,record,221,record.getLcshamt2());
		}else if(record.getLcshamt2() == null && record.getOcshamt2() != null){
			checkForTxnAmt(aRecords,record,221,record.getOcshamt2());
		}
		
		checkForTxnAmt(aRecords,record,223,record.getRtlintr());
		checkForTxnAmt(aRecords,record,224,record.getCshintr());
		
		if(record.getRtlintr() != null &&  record.getCshintr() != null){
			checkForTxnAmt(aRecords,record,257,(record.getRtlintr()+ record.getCshintr()));
		}else if(record.getRtlintr() != null &&  record.getCshintr() == null){
			checkForTxnAmt(aRecords,record,257,record.getRtlintr());
		}else if(record.getRtlintr() == null &&  record.getCshintr() != null){
			checkForTxnAmt(aRecords,record,257,record.getCshintr());
		}
		
		checkForTxnAmt(aRecords,record,259,record.getCshfee());
		
		Double adj_balance = 0.0;
		Double adj_monblnc = 0.0;
		
		if(record.geteTwRcEppRecord() != null && record.geteTwRcEppRecord().getBalance() > 0){
			adj_balance = record.geteTwRcEppRecord().getBalance();
		}else{
			adj_balance = 0.0;
		}
		
		if(record.getMonblnc() < 0){
			adj_monblnc = 0.0;
		}else{
			adj_balance = record.getMonblnc();
		}
		Double totalBal265=adj_balance + adj_monblnc;
		/*if (record.geteBalType265()!=null && record.geteBalType265()!=0){
			inputCheckSumTwProd=inputCheckSumTwProd.add(new BigDecimal(record.geteBalType265()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}*/
		
		checkForTxnAmt(aRecords,record,265,totalBal265);
		//checkForTxnAmt(aRecords,record,269,0.0);
		
		if(record.getClt2() != null && record.getAlopCrlimit() != null){
			checkForTxnAmt(aRecords,record,270,(record.getClt2() + record.getAlopCrlimit()));
		}else if(record.getClt2() != null && record.getAlopCrlimit() == null){
			checkForTxnAmt(aRecords,record,270, record.getClt2());
		}else if(record.getClt2() == null && record.getAlopCrlimit() != null){
			checkForTxnAmt(aRecords,record,270, record.getAlopCrlimit());
		}		
		
		checkForTxnAmt(aRecords,record,271,0.0);
		checkForTxnAmt(aRecords,record,302,record.getAnr2());
		
		if(record.geteTwRcRecRecord() != null && record.geteTwRcWoRecord() != null){
			checkForTxnAmt(aRecords,record,1042,record.geteTwRcRecRecord().getNewrcP());
		}
		
		checkForTxnAmt(aRecords,record,1209,record.getLatefee());
		checkForTxnAmt(aRecords,record,1284,record.getMdue());
		//checkForTxnAmt(aRecords,record,4097,record.getClt2());
		
		
		checkForTxnAmt(aRecords, record, 1, checkNull(record.getMonblnc())+checkNull(record.getEppAmnt())-checkNull(record.getCshintr())-checkNull(record.getRtlintr())-checkNull(record.getCshfee())-checkNull(record.getAnfee())-checkNull(record.getLatefee())-checkNull(record.getOtherfee()));
		return aRecords;
	}
	
	public static List<CommonBalanceRcTRLRecord> splitForBalanceTypesForTwRcPostRainbow(TwRcPostRainbowRecord record) throws ParseException{
		List<CommonBalanceRcTRLRecord> aRecords = new ArrayList<CommonBalanceRcTRLRecord>();
		
		if(record.getCashIbnp() != null && record.getRtlIbnp() != null){
			checkForTxnAmt(aRecords,record,7,(record.getCashIbnp() + record.getRtlIbnp()));
		}else if(record.getCashIbnp() != null && record.getRtlIbnp() == null){
			checkForTxnAmt(aRecords,record,7,record.getCashIbnp());
		}else if(record.getCashIbnp() == null && record.getRtlIbnp() != null){
			checkForTxnAmt(aRecords,record,7,record.getRtlIbnp());
		}
		
		if(record.geteTwRcWoRecord() != null){
			checkForTxnAmt(aRecords,record,9,record.geteTwRcWoRecord().getWoP());
		}
		
		checkForTxnAmt(aRecords,record,140,record.getChrgOffLcyamt());
		checkForTxnAmt(aRecords,record,167,record.getCashSvcBnp());
		checkForTxnAmt(aRecords,record,173,record.getRtlMemberBnp());
		
		if(record.getRtlMiscBnp() != null &&  record.getRtlSvcBnp() != null){
			checkForTxnAmt(aRecords,record,177,(record.getRtlMiscBnp() + record.getRtlSvcBnp()));
		}else if(record.getRtlMiscBnp() != null &&  record.getRtlSvcBnp() == null){
			checkForTxnAmt(aRecords,record,177, record.getRtlMiscBnp());
		}else if(record.getRtlMiscBnp() == null &&  record.getRtlSvcBnp() != null){
			checkForTxnAmt(aRecords,record,177, record.getRtlSvcBnp());
		}
		
		
		if(record.getLrtlamt2() != null && record.getOrtlamt2() != null){
			checkForTxnAmt(aRecords,record,220,record.getLrtlamt2() + record.getOrtlamt2());
		}else if(record.getLrtlamt2() != null && record.getOrtlamt2() == null){
			checkForTxnAmt(aRecords,record,220,record.getLrtlamt2());
		}else if(record.getLrtlamt2() == null && record.getOrtlamt2()!= null){
			checkForTxnAmt(aRecords,record,220,record.getOrtlamt2());
		}
		
		if(record.getLcshamt2() != null && record.getOcshamt2() != null){
			checkForTxnAmt(aRecords,record,221,(record.getLcshamt2() + record.getOcshamt2()));
		}else if(record.getLcshamt2() != null && record.getOcshamt2() == null){
			checkForTxnAmt(aRecords,record,221,record.getLcshamt2());
		}else if(record.getLcshamt2() == null && record.getOcshamt2() != null){
			checkForTxnAmt(aRecords,record,221,record.getOcshamt2());
		}
		
		
		checkForTxnAmt(aRecords,record,223,record.getRtlintr());
		checkForTxnAmt(aRecords,record,224,record.getCshintr());
		checkForTxnAmt(aRecords,record,228,record.getCshfee());
		
		if(record.getRtlintr() != null &&  record.getCshintr() != null){
			checkForTxnAmt(aRecords,record,257,(record.getRtlintr()+ record.getCshintr()));
		}else if(record.getRtlintr() != null &&  record.getCshintr() == null){
			checkForTxnAmt(aRecords,record,257,record.getRtlintr());
		}else if(record.getRtlintr() == null &&  record.getCshintr() != null){
			checkForTxnAmt(aRecords,record,257,record.getCshintr());
		}
		
		checkForTxnAmt(aRecords,record,259,record.getCshfee());
		
		/*Double adj_balance = 0.0;
		Double adj_monblnc = 0.0;
		
		if(record.geteTwRcEppRecord() != null && record.geteTwRcEppRecord().getBalance() > 0){
			adj_balance = record.geteTwRcEppRecord().getBalance();
		}else{
			adj_balance = 0.0;
		}
		
		if(record.getMonblnc() < 0){
			adj_monblnc = 0.0;
		}else{
			adj_balance = record.getMonblnc();
		}
		*/
		/*if (record.geteBalType265()!=null && record.geteBalType265()!=0){
			inputCheckSumTwProd=inputCheckSumTwProd.add(new BigDecimal(record.geteBalType265()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}*/
		checkForTxnAmt(aRecords,record,265,record.geteBalType265());
		//checkForTxnAmt(aRecords,record,269,0.0);
		
		if(record.getClt2() != null && record.getAlopCrlimit() != null){
			checkForTxnAmt(aRecords,record,270,(record.getClt2() + record.getAlopCrlimit()));
		}else if(record.getClt2() != null && record.getAlopCrlimit() == null){
			checkForTxnAmt(aRecords,record,270, record.getClt2());
		}else if(record.getClt2() == null && record.getAlopCrlimit() != null){
			checkForTxnAmt(aRecords,record,270, record.getAlopCrlimit());
		}		
		
		checkForTxnAmt(aRecords,record,271,0.0);
		checkForTxnAmt(aRecords,record,302,record.getAnr2());
		
		if(record.geteTwRcRecRecord() != null && record.geteTwRcWoRecord() != null){
			checkForTxnAmt(aRecords,record,1042,record.geteTwRcRecRecord().getNewrcP());
		}
		
		checkForTxnAmt(aRecords,record,1209,record.getLatefee());	
		checkForTxnAmt(aRecords,record,4091,record.getCshblnc2());
		//checkForTxnAmt(aRecords,record,4097,record.getClt2());
		checkForTxnAmt(aRecords,record,4103,record.getMonblnc());
		checkForTxnAmt(aRecords,record,4161,record.getPastDueAmt());
		
		if(record.getCurrDueAmt() != null && record.getPastDueAmt() != null){
			checkForTxnAmt(aRecords,record,1284,(record.getCurrDueAmt() + record.getPastDueAmt()));
		}
			
		if(record.getCshblnc2() != null){
			checkForTxnAmt(aRecords,record,263,record.getCshblnc2());
		}
		
		checkForTxnAmt(aRecords, record, 1, checkNull(record.getEnrLcyamt())-checkNull(record.getCashIbnp())-checkNull(record.getRtlIbnp())-checkNull(record.getCashSvcBnp())-checkNull(record.getRtlInsurBnp())-checkNull(record.getRtlMemberBnp())-checkNull(record.getRtlMiscBnp())-checkNull(record.getRtlSvcBnp()));
		return aRecords;
	}
	
	 /* public static Date getLastDate2(String rptMonth){

          Date date = null;
          String input = rptMonth.toString();
          String year = input.substring(0,4);
          String month = input.substring(4,6);
          int Curmonth = Integer.parseInt(month);
          int CurYear = Integer.parseInt(year);

          Calendar calendar = new GregorianCalendar();
          calendar.set(Calendar.YEAR, CurYear);
          calendar.set(Calendar.MONTH, Curmonth-1);
          calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE));
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
          
          try {
                date = dateFormat.parse(calendar.getTime());
          } catch(Exception e){
                LOGGER.error("Exception occured while parsing the date" + rptMonth + e);
          }
          return date;
    }*/

	  public static Date getLastDate(Date rptMonth) throws ParseException{
			
		  
	//String input = rptMonth.toString();
//	String year = rptMonth.getYear();
//	String month = input.substring(4);

//	int Curmonth = Integer.parseInt(month);
//	int CurYear = Integer.parseInt(year);
	
	Calendar calendar = new GregorianCalendar();
	if(rptMonth != null)
	{
	calendar.setTime(rptMonth);
	calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE));
	return calendar.getTime();
	}
	else
	{
		return calendar.getTime();
	}
	
	
	
}


//	public static Integer getMonthsTwMtg(ALSRecord record){
//		if(record.getBookDate()== null || record.getMisDate() == null){
//			return 0;
//		}
//		else{			
//			Calendar cal1 = new GregorianCalendar();
//			cal1.setTime(record.getBookDate());
//			Calendar cal2 = new GregorianCalendar();
//			cal2.setTime(record.getMisDate());
//			int difference = 0;
//			if(record.getBookDate().compareTo(record.getMisDate())<0){
//				difference = getDiffernceOfMonths(cal1,cal2);
//			}
//			else if(record.getBookDate().compareTo(record.getMisDate())>0){
//				difference = getDiffernceOfMonths(cal2,cal1);
//			}
//			else{
//				difference = 0;
//			}
//			return difference;
//		}		
//
//	}
	
	public static Integer getMonthsTwMtg(Date bookDate, Date misDate){
		if(bookDate == null || misDate == null){
			return 0;
		}
		else{			
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(bookDate);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(misDate);
			int difference = 0;
			if(bookDate.compareTo(misDate)<0){
				difference = getDiffernceOfMonths(cal1,cal2);
			}
			else if(bookDate.compareTo(misDate)>0){
				difference = getDiffernceOfMonths(cal2,cal1);
			}
			else{
				difference = 0;
			}
			return difference;
		}		
		
	}

	public static String getDelq30DayPast2YrFlag(Integer cycDueM, Date misDate, Date rptMnthDate){
		if(misDate != null && rptMnthDate != null){
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(rptMnthDate);
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(rptMnthDate);
			cal2.set(Calendar.YEAR, cal2.get(Calendar.YEAR)-2);
			
//			if(cal2.getTime().after(misDate) && cal1.getTime().before(misDate)){
			if(misDate.after(cal2.getTime()) && misDate.before(cal1.getTime())){
				if(cycDueM != null && cycDueM > 2){
					return "Y";
				}
				else{
					return "U";
				}
			}else{
				return "U";
			}
		}else{
			return "U";
		}
		
	}
	public static BigDecimal wrapBigDecimalScal(Double ePctAmt, int scale) {
		BigDecimal bigDecimalValue=null;
		if(ePctAmt!=null){
			if(ePctAmt==0){
				bigDecimalValue=new BigDecimal(0);
			}else {
				bigDecimalValue=new BigDecimal(ePctAmt).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
		} 
		return bigDecimalValue;
	}

	public static List<CommonBalanceMtgTRLRecord> splitForBalanceTypesForHkMtgRecRecord(HkMtgWoRecvTRLRecord record,
			Double lnAmt,Double recoveryAmt) throws ParseException{
		List<CommonBalanceMtgTRLRecord> aRecords = new ArrayList<CommonBalanceMtgTRLRecord>();	

		if(lnAmt != null){
			checkForTxnAmt(aRecords,record,4155,lnAmt.doubleValue());
		}
		checkForTxnAmt(aRecords,record,1286,recoveryAmt);
		return aRecords;		
	}

	
	public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(HkMtgWoRecvTRLRecord record, Integer balType, Double txnAmt)
	{
		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
		commonBalanceMtgTRLRecord.seteBalTyp(balType);
		if(txnAmt != null) {
			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		} 		
		if(txnAmt != null) {
			commonBalanceMtgTRLRecord.seteFuncAmt(txnAmt);
		}
		/** Added for Base Amount **/
		if (commonBalanceMtgTRLRecord.geteTranCurr() != null && commonBalanceMtgTRLRecord.geteBaseCurrCode() != null && commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			if(record.geteBaseAmtCurr() != null){
				commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
			}
			
		}
		return commonBalanceMtgTRLRecord;
	}
	
	public static String getBaselPortfolioIdForInCrd
	(String cardsType, Date rptDate) throws ParseException {
		
		SimpleDateFormat DateFormat = new SimpleDateFormat ("yyyyMMdd");	
		if(cardsType != null ){
			if(cardsType.equalsIgnoreCase("BC")){
				return "INUR014";
			} else if(cardsType.equalsIgnoreCase("DC")){
				if(DateFormat.parse("20140301").compareTo(rptDate) > 0){
					return "INUR005";
				} else{
					return "INUR017";
				}
			} else if(cardsType.equalsIgnoreCase("RW")){
				if(DateFormat.parse("20131001").compareTo(rptDate) > 0){
					return "INUR013";
				} else{
					return "INUI022";
				}
			} else{
				return "NA";
			}
		} else{
			return "NA";
		}
	}
	
	public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(GclTRLRecord record, Integer balType, Double txnAmt)
	{
		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
		commonBalanceMtgTRLRecord.seteBalTyp(balType);
//		record.seteBalType(balType);
		if(txnAmt != null) {
			//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		/** Added for functional Amount **/
		if(txnAmt != null) {
			commonBalanceMtgTRLRecord.seteFuncAmt(txnAmt);
		}
		/** Added for Base Amount **/
		if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		return commonBalanceMtgTRLRecord;
	}
	
	public static CommonBalanceMtgTRLRecord createCommonBalanceTRLRecord(OreoTRLRecord record, Integer balType, Double txnAmt)
	{
		CommonBalanceMtgTRLRecord commonBalanceMtgTRLRecord  = new CommonBalanceMtgTRLRecord(record);
		commonBalanceMtgTRLRecord.seteBalTyp(balType);
//		record.seteBalType(balType);
		if(txnAmt != null) {
			//commonBalanceMtgTRLRecord.setETxnAmt(txnAmt);
			commonBalanceMtgTRLRecord.setETxnAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		/** Added for functional Amount **/
		if(txnAmt != null) {
			commonBalanceMtgTRLRecord.seteFuncAmt(txnAmt);
		}
		/** Added for Base Amount **/
		if (commonBalanceMtgTRLRecord.geteTranCurr().equals(commonBalanceMtgTRLRecord.geteBaseCurrCode())){
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt);
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt).setScale(5, BigDecimal.ROUND_HALF_UP));
		}else{
			//commonBalanceMtgTRLRecord.setEBaseAmt(txnAmt * record.geteBaseAmtCurr());
			commonBalanceMtgTRLRecord.setEBaseAmt(new BigDecimal(txnAmt * record.geteBaseAmtCurr()).setScale(5, BigDecimal.ROUND_HALF_UP));
		}
		
		return commonBalanceMtgTRLRecord;
	}
	public static Integer convertCharToInt(char val){
		return Character.getNumericValue(val);

	}
	
	public static String getBaselPortfolioIdForInRc(Date rptDate) throws ParseException {

		SimpleDateFormat DateFormat = new SimpleDateFormat ("yyyyMMdd");        

		if(DateFormat.parse("20130930").compareTo(rptDate) >= 0){
			return "INUR010";
		} else{
			return "INUI021";
		}
	}

	public static String getCcarProdCodeForInRc(String eBaselPortfolioId, Date rptDate) throws ParseException {

		SimpleDateFormat DateFormat = new SimpleDateFormat ("yyyyMMdd");        
		String cCar = "";
		
		if("INUR011".equals(eBaselPortfolioId) | "INUR012".equals(eBaselPortfolioId)){
			cCar = "CO_UR";
		}
		else if("INUR010".equals(eBaselPortfolioId) && DateFormat.parse("20130930").compareTo(rptDate) >= 0){
				cCar =  "CO_UR";
		} else if("INUI021".equals(eBaselPortfolioId) && DateFormat.parse("20130930").compareTo(rptDate) < 0){
				cCar =  "CO_UI";
		}		
		return cCar;
		
	}
	
	
	public static Integer getCycleEndDelinqBucketTwRC(TwRcPostRainbowRecord record){
		//System.out.println("getCycleEndDelinqBucketTwRC .......");
		String delqStr = record.getDelqStr();
		String firstChar = "";
		if(delqStr != null && delqStr.length() > 0){
			firstChar = delqStr.substring(0,1);
		}
		Integer delqStrInt = 0;
		try {
			delqStrInt = Integer.valueOf(firstChar);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println("delqStrInt="+delqStrInt);
	//	record.setCycleEndDelinqBucket(cycleEndDelinqBucket)
		return delqStrInt;
	}
	public static Integer getCycleEndDelinqBucketTwRCPre(TwRcPreRainbowRecord record){
		String delqStr = record.getDelqprof();
		String firstChar = "";
		Integer delqFirstChar = 0;;
		if(delqStr != null && delqStr.length() > 0){
			firstChar = delqStr.substring(0,1);
		}
		if(firstChar.matches("\\d")){
			try {
				delqFirstChar=Integer.valueOf(firstChar);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
			}
		}
		return delqFirstChar;
	}
	
	public static Integer getCycleEndDelinqBucketTwCrdPre(PreRainbowRecord record){
		//System.out.println("********************* getCycleEndDelinqBucketTwCrdPre");
		String delqStr = record.getDelqProf();
		String firstChar = "";
		Integer delqFirstChar = 0;;
		if(delqStr != null && delqStr.length() > 0){
			firstChar = delqStr.substring(0,1);
		}
		if(firstChar.matches("\\d")){
			try {
				delqFirstChar=Integer.valueOf(firstChar);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
			}
		}
		return delqFirstChar;
	}
	
	public static String geteDelq30DayPst2YrsFlgTwRc(TwRcPostRainbowRecord record){
		String delqStr = record.getDelqStr();
		//String firstChar = "";
		String flag="";
		if(delqStr != null && (delqStr.contains("1") | delqStr.contains("2") | delqStr.contains("3") |delqStr.contains("4") | delqStr.contains("5") |
				delqStr.contains("6") | delqStr.contains("7") | delqStr.contains("8") | delqStr.contains("9"))){
			flag = "Y";
		}else{
			flag = "N";
		}
		return flag;
	}
}
