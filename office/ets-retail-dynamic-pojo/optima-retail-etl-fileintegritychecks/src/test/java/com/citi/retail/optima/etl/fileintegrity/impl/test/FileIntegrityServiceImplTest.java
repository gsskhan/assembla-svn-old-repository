package com.citi.retail.optima.etl.fileintegrity.impl.test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.fileintegrity.FileIntegrityService;
import com.citi.retail.optima.etl.fileintegrity.exception.FieldError;
import com.citi.retail.optima.etl.fileintegrity.exception.FileIntegrityDataException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/optima.retail.fileintegritychecks.test.xml"})
public class FileIntegrityServiceImplTest {
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceCcar;
	
	@Autowired
	private FileIntegrityService fileIntegrityServiceFdic;
	
	@Test
	public void testfileIntegrityServiceCcar() {
		Assert.assertNotNull(fileIntegrityServiceCcar);
	}
	
	@Test
	public void testfileIntegrityServiceFdic() {
		Assert.assertNotNull(fileIntegrityServiceFdic);
	}
	
	
	@Test
	public void testValidHeadersCCAR() {		
		int rowNum = 0;
		String correctHeader = "REPORTING_PERIOD,GCBC_PORTFOLIO_ID,SUBMITTER_ID,CONTACT_ID,VERSION,REGION,COUNTRY,PRODUCT_TYPE," +
				"COLLATERALIZED_FLG,CURR_LINE_LOAN_SIZE,ORIG_LTV,AGE,VINTAGE,CURR_DLQ_STATUS,ORIG_FICO,N_ACCT,D_UPB," +
				"D_ENR,D_OS_ACCT_GE30_DPD_24M,N_ACCTS_GE30_DPD_24M,D_ACCT_EVER_30DPD_LAST12,D_ACCT_EVER_60DPD_LAST12," +
				"N_NEW_ACCOUNTS,D_NEW_ACCOUNTS,D_COMMITMENTS,D_NEW_COMMITMENTS,D_COMMITMENT_INCREASES,D_COMMITMENT_DECREASES," +
				"D_MODIFICATIONS,D_GROSS_CONTRACTUAL_CO,D_BANKRUPTCY_CO,D_RECOVERIES,N_ACCT_CO,D_NET_CO,D_ADJ_NET_CO," +
				"D_FORECLOSURE,D_NEW_FORECLOSURE,D_REO,D_NEW_REO,D_VEHICLE_TYPE_CAR_VAN,D_VEHICLE_TYPE_SUV_TRUCK," +
				"D_VEHICLE_TYPE_SPORT,D_VEHICLE_TYPE_UNKNOWN,D_REPO,D_CUR_MONTH_REPO,D_PROJ_VALUE_LEASE," +
				"D_ACT_SALE_PROCEEDS_LEASE,REF_PORTFOLIO_CCY,REF_FX_RATE,REF_REPORTING_BASIS";
		
		String incorrectHeader = "REPORTING_PERIOD,GCBC_PORTFOLIO_ID,SUBMITTER_ID,CONTACT_ID,VERSION,REGION,COUNTRY,PRODUCT_TYPE," +
				"COLLATERALIZED_FLG,CURR_LINE_LOAN_SIZE,ORIG_LTV,AGE,VINTAGE,CURR_DLQ_STATUS,ORIG_FICO,N_ACCT,D_UPB," +
				"D_EN_ENR,D_OS_ACCT_GE30_DPD_24M,N_ACCTS_GE30_DPD_24M,D_ACCT_EVER_30DPD_LAST12,D_ACCT_EVER_60DPD_LAST12," +
				"N_NEW_ACCOUNTS,D_NEW_ACCOUNTS,D_COMMITMENTS,D_NEW_COMMITMENTS,D_COMMITMENT_INCREASES,D_COMMITMENT_DECREASES," +
				"D_MODIFICATIONS,D_GROSS_CONTRACTUAL_CO,D_BANKRUPTCY_CO,D_RECOVERIES,N_ACCT_CO,D_NET_CO,D_ADJ_NET_CO," +
				"D_FORECLOSURE,D_NEW_FORECLOSURE,D_REO,D_NEW_REO,D_VEHICLE_TYPE_CAR_VAN,D_VEHICLE_TYPE_SUV_TRUCK," +
				"D_VEHICLE_TYPE_SPORT,D_VEHICLE_TYPE_UNKNOWN,D_REPO,D_CUR_MONTH_REPO,D_PROJ_VALUE_LEASE," +
				"D_ACT_SALE_PROCEEDS_LEASE,REF_PORTFOLIO_CCY,REF_FX_RATE,REF_REPORTING_BASIS";
		
		try {	
			Assert.assertTrue(fileIntegrityServiceCcar.validate(correctHeader, rowNum));
		} catch (FileIntegrityDataException e) {
			Assert.fail();
		}	
		
		try {
			fileIntegrityServiceCcar.validate(incorrectHeader, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
		}
	}
	@Test
	public void testValidDatatypeCCAR() {
		int rowNum = 1;
		String lineVal = "201304,VNUR002,nv54287,ec56273,1,4,VN,CO_UR,-1,1,-1,-1,-1,1,3,5240,1744577,1769634,1047,7,0,0,756,0,7610754,873790,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,VND,0.000048,1";
		String falseVal = "201304,VNUR002,nv54287,ec56273,1,4,VN,CO_UR,AB,1,-1,-1,-1,1,3,5240,1744577,1769634,1047,7,0,0,756,0,7610754,873790,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,VND,0.000048,1";
		String falseCountVal = "201304,VNUR002,nv54287,ec56273,1,4,VN,CO_UR,1,-1,-1,-1,1,3,5240,1744577,1769634,1047,7,0,0,756,0,7610754,873790,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,VND,0.000048,1";
		try {
			Assert.assertTrue(fileIntegrityServiceCcar.validate(lineVal, rowNum));
		} catch (FileIntegrityDataException e) {
			Assert.fail();
		}
		
		falseVal = "201304,VNUR002,nv54287,ec56273,1,4,VN,CO_UR,AB,1,-1,-1,-1,1,3,5240,1744577,1769634,1047,7,0,0,756,0,7610754,873790,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,VND,JIK0,1";
		try {
			fileIntegrityServiceCcar.validate(falseVal, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
		}
		falseVal = "201304,VNUR002,nv54287,ec56273,1,4,VN,CO_UR,AB,1,-1,-1,-1,1,3,5240,1744577,1769634,1047,UV,0,0,756,0,761FG0754,873790,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,VND,0.000048,1";
		try {
			fileIntegrityServiceCcar.validate(falseVal, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
		}
		falseVal = "201304,VNUR002,nv54287,ec56273,1,4,VN,CO_UR,AB,1,-1,-1,-1,1,3,5240,1744577,1769634,1047,7,0,0,756,0,7610754,873790,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,VND,0.000048,KL";
		try {
			fileIntegrityServiceCcar.validate(falseVal, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
		}
		falseVal = "201304,VNUR002,nv54287,ec56273,1,4,VN,CO_UR,-1,1,-1,-1,-1,1,3,5240,,1769634,1047,7,0,0,756,0,7610754,873790,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,VND,0.000048,1";
		try {
			fileIntegrityServiceCcar.validate(falseVal, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
		}
		
		try {
			fileIntegrityServiceCcar.validate(falseCountVal, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
		}
		falseVal ="201207,MXUR025,QL83499,QL83499,1,3,MX,CA_BC,2,1,-1,4,1,5,9,2,3513,3513,3513,2,0,0,0,0,6500,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,USD,10.6,1";
		try {
			Assert.assertTrue(fileIntegrityServiceCcar.validate(falseVal, rowNum));
		} catch (FileIntegrityDataException e) {
			Assert.fail();
		}
		
		lineVal = "200701,THUR016,PS23425,SB64972,5,4,TH,CO_UR,-1,1,-1,-1,-1,1,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1068,0,-1068,0,0,0,0,0,0,0,0,0,0,0,0,0,THB,35.803,1";
		String lineValDuplicate = "200701,THUR016,PS23425,SB64972,5,4,TH,CO_UR,-1,1,-1,-1,-1,1,9,8330,6363647,6363647,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,THB,35.803,1";		
		try {
			Assert.assertTrue(fileIntegrityServiceCcar.validate(lineVal, rowNum));
			Assert.assertTrue(fileIntegrityServiceCcar.validate(lineValDuplicate, rowNum));
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
			for(int i=0;i<e.getFieldErrors().size();i++){
				Assert.assertTrue(e.getFieldErrors().get(i).getUserErrorMessage().contains("Duplicate"));
			}
		}
	}	
	
	@Test
	public void testValidDelimitersFdic() {
		int rowNum = 0;		
		
			String correctHeader = "REPORTING MONTH,REGION,COUNTRY,BUSINESS UNIT,PRODUCT CATEGORY,CREDIT BUREAU," +
					"MODEL VERSION,FICO/MODEL SCORE,ENR,EXCLUDED AMOUNT ,LOCAL CURRENCY CODE,FX RATE,CONTACT,SUBMITTER";
			
			String incorrectHeader = "REPORTING MONTH,REGION,COUNTRY,BUSINESS UNIT,PRODUCT CATEGORY,CREDIT BUREAU," +
					"MODEL VERSION,FICO/MODEL SCORE,ENR,EXCLUDED AMOUNT,LOCAL CURRENCY CODE,FX RATE,CONTACT,SUBMITTER,NEW_FIELD";
			
		try{
			Assert.assertTrue(fileIntegrityServiceFdic.validate(correctHeader, rowNum));			
		}catch (FileIntegrityDataException e) {
			Assert.fail();
		}
		
		String correctHeaderwithQuotes = "\"Reporting Month\",\"Region\",\"Country\",\"Business Unit\",\"Product Category\",\"Credit Bureau\"," +
				"\"Model Version\",\"FICO/Model Score\",\"ENR\",\"Excluded Amount\",\"Local Currency Code\",\"FX Rate\",\"Contact\",\"Submitter\"";
		try{
			Assert.assertTrue(fileIntegrityServiceFdic.validate(correctHeaderwithQuotes, rowNum));			
		}catch (FileIntegrityDataException e) {
			Assert.fail();
		}
				
		try {
			Assert.assertFalse(fileIntegrityServiceFdic.validate(incorrectHeader, 1));
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
			Assert.assertEquals(((FileIntegrityDataException)e).getFieldErrors().size(), 1);
		}
	}
	
	@Test
	public void testValidHeadersFdic() {		
		int rowNum = 0;
		String correctHeader = "REPORTING MONTH,REGION,COUNTRY,BUSINESS UNIT,PRODUCT CATEGORY,CREDIT BUREAU," +
				"MODEL VERSION,FICO/MODEL SCORE,ENR,EXCLUDED AMOUNT,LOCAL CURRENCY CODE,FX RATE,CONTACT,SUBMITTER";
		
		String incorrectHeader = "REPORTING MONTH,REGION,COUNTRY,BUSINESS UNIT,PRODUCT CATEGORY,CREDIT BUREAU," +
				"MODEL VERSION,FICO/MODEL SCORE,ENR,EXCLUDED AMOUNT,LOCAL CURRENCY CODE,FX RATE,CONTACT_NUM,SUBMITTER";
		
		try {	
			Assert.assertTrue(fileIntegrityServiceFdic.validate(correctHeader, rowNum));
		} catch (FileIntegrityDataException e) {
			Assert.fail();
		}		
		
		try {
			fileIntegrityServiceFdic.validate(incorrectHeader, rowNum);
		} catch (FileIntegrityDataException e) {
			List<FieldError> errors = e.getFieldErrors();
			for (FieldError error : errors) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("error", "file integrity error");
				error.setOtherAttributesMap(map);
				System.out.println(error.convertMaptoJsonString());
				System.out.println(error.getAttributeName());
				System.out.println(error.getExceptionMessage());
				System.out.println(error.getReportedValues());
				System.out.println(error.getRule());
				System.out.println(error.getAttributeId());
				System.out.println(error.getRuleId());
				System.out.println(error.getUserErrorMessage());
				System.out.println(error.getStackTrace());
				System.out.println(error.toString());
			}
			Assert.assertNotNull(e);
		}
	}
	@Test
	public void testValidDatatypeFdic() {
		int rowNum = 1;
		String lineVal = "201303,APAC,MY,APAC_GCG,CO_LO,Citi FICO Alignment,Citi FICO Alignment,511,3,0,MYR,3.0905,LW76731,LW76731";
		String falseVal = "201303,APAC,MY,APAC_GCG,CO_LO,Citi FICO Alignment,Citi FICO Alignment,511,KO,0,MYR,3.0905,LW76731,LW76731";
		String falseCountVal = "201303,APAC,MY,APAC_GCG,CO_LO,Citi FICO Alignment,Citi FICO Alignment,511,KO,0,MYR,3.0905,LW76731,LW76731,2";
		try {			
			Assert.assertTrue(fileIntegrityServiceFdic.validate(lineVal, rowNum));
		} catch (FileIntegrityDataException e) {
			Assert.fail();
		}
		
		boolean isValid = false;
		try {
			isValid = fileIntegrityServiceFdic.validate(falseVal, rowNum);
		} catch (FileIntegrityDataException e) {
			isValid = false;
			//Assert.assertNotNull(e);
		}
		Assert.assertFalse(isValid);
		
		falseVal = "201303,APAC,MY,APAC_GCG,CO_LO,Citi FICO Alignment,Citi FICO Alignment,511,3,0,MYR,POI,LW76731,LW76731";
		try {
			fileIntegrityServiceFdic.validate(falseVal, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
		}
		
		falseVal = "201303,APAC,MY,APAC_GCG,CO_LO,Citi FICO Alignment,Citi FICO Alignment,511,KO,0,MYR,3.0905,LW76731,LW76731";
		try {
			fileIntegrityServiceFdic.validate(falseVal, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
			//Duplicates also will be counted here
			Assert.assertEquals(((FileIntegrityDataException)e).getFieldErrors().size(), 2);
		}
		
		try {
			fileIntegrityServiceFdic.validate(falseCountVal, rowNum);
		} catch (FileIntegrityDataException e) {
			Assert.assertNotNull(e);
		}
	}	
	
	
	
}
