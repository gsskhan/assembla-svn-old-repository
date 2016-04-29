package com.citi.retail.optima.etl.aggregation.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.aggregation.exception.AggregationException;
import com.citi.retail.optima.etl.aggregation.model.AggregationType;
import com.citi.retail.optima.etl.aggregation.util.AggregationResultToJsonUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.aggregation.test.config.xml"})
public class JsonAggregationSpelValidatorTest  {
	
	@Autowired
	private AggregationServiceFactoryImpl<?> aggregationServiceFactoryImpl;
	private Map<String, Map<String, List<Number>>> agrregationResultMap;
	protected ArrayNode json;
	protected ObjectMapper jsonMapper ;
	//private AggregationRuleElementDefinitionHelper aggregationRuleElementDefinitionHelper = null;
	private List<AggregationType> aggregationTypeList = null;


	/*protected void validate(boolean isValid) throws AggregationException {
		validate(isValid, json);
	}
	*/
	@Before
	public void setUp() {
	

		//this.validationRulesList = new ArrayList<RuleConstraint>();
		jsonMapper = new ObjectMapper();
		jsonMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
		jsonMapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
		jsonMapper.configure(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM, false);
		//aggregationRuleElementDefinitionHelper = new AggregationRuleElementDefinitionHelper();
		setupModel();
		//StandardEvaluationContext evalContext = (StandardEvaluationContext)this.spelidator.getEvalContext();
		//evalContext.addPropertyAccessor(new MapAccessor());
		//evalContext.addPropertyAccessor(new JsonPropertyAccessor());
		
	}
	
	protected void setupModel(){

		agrregationResultMap = new HashMap<String, Map<String, List<Number>>>(); 
		//set Sys Proc Rule ID key
		agrregationResultMap.put("3:8", new HashMap<String, List<Number>>(3));
		//set segment attribute key id
		agrregationResultMap.get("3:8").put("01#03#02#03#01#01", new ArrayList<Number>(130));
		//set Number value 
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(10);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(20);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(30);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(40);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(50);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(60);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(70);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(80);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(90);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(100);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(110);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(120);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(130);
		agrregationResultMap.get("3:8").get("01#03#02#03#01#01").add(140);
		
		
		/*
		eFedProductTypeSegmentId
		eFedAgeSegmentId
		eFedRegionSegmentId
		eFedDelqSegmentId
		eFedFicoSegmentId
		rptPeriod
		-------------- metric header----------
		eFedNumAccounts
		eEnrAmt
		eFedUnpaidPrinBalAmt
		eFedCommitmentAmt
		eFedNumNewAccounts
		eFedNewCommitmentAmt
		eFedGrossContractualChargeOffAmt
		eFedBankruptcyChargeOffAmt
		eFedRecoveryAmt
		eFedNumAcctChargeOf
		eFedNetChargeOffAmt
		eFedAdjNetChargeOffAmt
		eFedOutstandingDpdOver30Amt
		eFedNumAcctDpdOver30
		*/

		
	}
	

	@Test
	/**
	 * Test accesses in a Json stored as a Map Object
	 * @throws OptimaRetailApplicationException
	 */
	public void testValidateJson() throws AggregationException {
		
		String expeted = "[{\"SysProcId\":\"3\",\"RuleId\":\"8\",\"RuleInstanceKey\":\"01#03#02#03#01#01\","
				+ "\"eFedNumAccounts\":10.0,\"eEnrAmt\":20.0,\"eFedUnpaidPrinBalAmt\":30.0,\"eFedCommitmentAmt\":40.0,"
				+ "\"eFedNumNewAccounts\":50.0,\"eFedNewCommitmentAmt\":60.0,\"eFedGrossContractualChargeOffAmt\":70.0,"
				+ "\"eFedBankruptcyChargeOffAmt\":80.0,\"eFedRecoveryAmt\":90.0,\"eFedNumAcctChargeOf\":100.0,"
				+ "\"eFedNetChargeOffAmt\":110.0,\"eFedAdjNetChargeOffAmt\":120.0,\"eFedOutstandingDpdOver30Amt\":130.0,"
				+ "\"eFedNumAcctDpdOver30\":140.0}]";
		//setSpelRules();
		aggregationTypeList = aggregationServiceFactoryImpl.loadAggregationRules(getKeyList());
		
		//Assert.assertNotNull(aggregationTypeList);
		//Assert.assertTrue(aggregationTypeList.size() > 0);
	
		//aggregationRuleElementDefinitionHelper.setAggregationRuleTypeDefintion(aggregationTypeList);
		
		//show what we got from cache
		displayAggregationRuleElementDefinition(aggregationTypeList);
		
		//json = (ArrayNode) AggregationResultToJsonUtil.ENTRY.toJson(agrregationResultMap, aggregationRuleElementDefinitionHelper);
		//show what we got in json
	    //displayJosnResult(json);
		
		
		
		Assert.assertEquals(expeted, json.toString());
	
	}
	

	//show what we got in json
	/**
	 * show Json Result in string 
	 */
	private void displayJosnResult(ArrayNode json){
		System.out.println(json);
	}
	
	/**
	 * Build KeyList
	 */
	private List<String> getKeyList(){
		List<String> keyList = new ArrayList<String>();
		//Load up value from aggregationTypeList from cache
		String sysProcId = "3";
		String category = "USCCARProcessStep";
		String key = category + ":" + sysProcId;
		keyList.add(key);
		return keyList;
	}
	
	/**
	 * Display AggregationRuleElementDefinition
	 */
    private void displayAggregationRuleElementDefinition(List<AggregationType> aggregationTypeList){
    	
    	System.out.println("******************************************************************************************");
    	System.out.println("************************** Aggregation Rule Element Definition****************************");
    	System.out.println("***************************************BEGIN**********************************************");
    	
    	
    	//verified that we have got from cache
		for (AggregationType aggregationType : aggregationTypeList) {
			System.out.println("+++++++++++++++++++++++++++++++++");
			System.out.println(aggregationType.getName());
			System.out.println(aggregationType.getId());
			System.out.println(aggregationType.getSysProcId());
			System.out.println("+++++++++++++++++++++++++++++++++");
		}
    	
    	/*for(String puRuleIdKey:AggregationRuleElementDefinitionHelper.getAggregationDefintionBySysProcAndRuleId().keySet()){
			System.out.println("=================== Process Unite : Rule Id ===============");
			System.out.println(puRuleIdKey);
			System.out.println("-------------- segment header----------");
			for(String segment: AggregationRuleElementDefinitionHelper.getAggregationDefintionBySysProcAndRuleId().get(puRuleIdKey).getSegmentKeys()){
				System.out.println(segment);
			}
			System.out.println("-------------- metric header----------");
			for(String metric: AggregationRuleElementDefinitionHelper.getAggregationDefintionBySysProcAndRuleId().get(puRuleIdKey).getMetricKeys()){
				System.out.println(metric);
			}
		}*/
    	
    	
    	
    	
    	System.out.println("******************************************************************************************");
    	System.out.println("************************** Aggregation Rule Element Definition****************************");
    	System.out.println("***************************************END************************************************");   
    	
    }
    
    
    
    
    
  

}
