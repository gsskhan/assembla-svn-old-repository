package com.citi.retail.optima.etl.aggregation.util;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Give toJson, a single utility method to convert instance of rule element value into JSON representation
 * @author yh43239
 *
 */
public enum AggregationResultToJsonUtil {
	ENTRY();
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AggregationResultToJsonUtil.class);
	private static final String RULE_INSTANCE_KEY_DELIMITER=";;;";
	private static final String COLON=":";
	private  ObjectMapper jacksonMapper = new ObjectMapper();
	private ArrayNode arrayContainerNode = null;
	private JsonNode elementHashNode = null;
	private String[] segmentTypes = null;
    private String[] metricTypes = null;
    private List<Number> metricValues = null;
    
	private AggregationResultToJsonUtil() {

		//initialize Jackson lib
		jacksonMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
		jacksonMapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
		jacksonMapper.configure(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM,false);
	}


   /**
    * Convert agrregationResultMap into JSON representation enhanced with information from Rule Element Definition
    * @param agrregationResultMap
    * @param aggregationRuleElementDefinitionHelper
    * @return
    */

	/*public JsonNode toJson( Map<String, Map<String, List<Number>>> agrregationResultMap, AggregationRuleElementDefinitionHelper aggregationRuleElementDefinitionHelper){
		
		AggregationRuleMeta ruleDefnition = null;
		String[] segmentValues = null;
		String[] sysProcRuleIdKeyCombo = null;
		arrayContainerNode = jacksonMapper.createArrayNode();
		elementHashNode = jacksonMapper.createObjectNode();
		
		     //by sysProc:aggr_rule_id
			for(String sysProcRuleIdKey: agrregationResultMap.keySet()){
				
				//ruleDefnition = AggregationRuleElementDefinitionHelper.getAggregationDefintionBySysProcAndRuleId().get(sysProcRuleIdKey);
				
				for(String ruleInstanceKey: agrregationResultMap.get(sysProcRuleIdKey).keySet()){
					
					//keyInstance
					segmentValues = ruleInstanceKey.split(RULE_INSTANCE_KEY_DELIMITER);
					metricValues = agrregationResultMap.get(sysProcRuleIdKey).get(ruleInstanceKey);
					segmentTypes = ruleDefnition.getSegmentKeys();
					metricTypes = ruleDefnition.getMetricKeys();
					
                    //add info to make message self containing
					sysProcRuleIdKeyCombo = sysProcRuleIdKey.split(COLON);
					((ObjectNode) elementHashNode).put("SysProcId",sysProcRuleIdKeyCombo[0]);
					((ObjectNode) elementHashNode).put("RuleId",sysProcRuleIdKeyCombo[1]);
					((ObjectNode) elementHashNode).put("RuleInstanceKey",ruleInstanceKey);
					
                    if(segmentTypes.length!=segmentValues.length){
                    	LOGGER.error("Error segmentType and segmentValues size missmatch: segmentTypes size = "+segmentTypes.length+" and segmentValues size = "+segmentValues.length);
                    }else{
                    	 //mapping segment value to segment attribute
    					for (int i = 0; i < segmentTypes.length; i++) {
    						((ObjectNode) elementHashNode).put(segmentTypes[i], segmentValues[i]);
    					}
                    }
                    
                    if(metricTypes.length!=metricValues.size()){
                    	LOGGER.error("Error metricType and metricVaues size missmatch: metricType size = " + metricTypes.length+" and metricValues size = "+metricValues.size());
                    }else{
                    	//mapping metric value to metric attribute.
    					for (int j = 0; j < metricTypes.length; j++) {
    						((ObjectNode) elementHashNode).put(metricTypes[j], metricValues.get(j)==null?0:metricValues.get(j).doubleValue());

    					}
                    }
                    			
					arrayContainerNode.add(elementHashNode);
					
				}
		
			}
			
	  
		return arrayContainerNode;
  
	}*/
	

}
