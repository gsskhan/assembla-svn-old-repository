package org.dms.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.dms.web.bo.ConstantsService;
import org.dms.web.core.JsonUtil;
import org.dms.web.entity.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/constant")
public class ConstantManageController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ConstantsService constantsService;
	
	@ResponseBody
	@RequestMapping("/all/json")
	public String getAllConstantsJSON(){
		log.info("finding all constants list ...");
		String result = JsonUtil.getJsonAsString(constantsService.findAllConstants());
		log.info(result);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/all/pdf")
	public void getAllConstantsPDF(HttpServletRequest request, HttpServletResponse response) throws IOException{
	    response.setContentType("application/pdf");
	    /* To prompt browser to ask to save file */
	    response.setHeader("Content-Disposition","attachment;filename=dms-constants.pdf");
	    byte[] pdf = constantsService.buildPdfListOfAllConstants();	    
	    response.getOutputStream().write(pdf);
	}
	
	@ResponseBody
	@RequestMapping(value="/add")
	public String addNewConstant(@RequestParam("variable")String variable 
			,@RequestParam("variableid")int variableId
			,@RequestParam("value")String value
			,@RequestParam("parentvariableid")int parentVarId){
		log.info("Adding [Variable="+variable+",VariableId="+variableId+",Value="+value+",ParentVariableId="+parentVarId+"].");
		String result = constantsService.addNewConstant(variable, variableId, value, parentVarId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("msg", result);
		log.info(result);
		return JsonUtil.getJsonAsString(resultMap);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete/{tempid}")
	public String deleteConstantJson(@PathVariable("tempid") int constantId){
		log.info("deleting constant with id "+ constantId + " ...");
		String result = new String();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			result = constantsService.removeConstant(constantId);
			resultMap.put("msg", result);	
			result = JsonUtil.getJsonAsString(resultMap);
		} catch (Exception e) {
			resultMap.put("msg", ExceptionUtils.getRootCauseMessage(e));
			result = JsonUtil.getJsonAsString(resultMap);
			log.error("error in deleting constant ...", e);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/edit/{tempid}")
	public String getConstantDetailsJson(@PathVariable("tempid") int constantId){
		log.info("finding constant with id "+ constantId + " ...");
		String result = new String();
		try {
			Constants cons = constantsService.findConstants(constantId);
			result = JsonUtil.getJsonAsString(cons);
			result = StringUtils.isEmpty(result) ? "" : result;
		} catch (Exception e) {			
			log.error("error in getting constants details ...", e);
		}		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/update")
	public String addNewConstant( @RequestParam("constId") int constantId 
			,@RequestParam("variable")String variable 
			,@RequestParam("variableid")int variableId
			,@RequestParam("value")String value
			,@RequestParam("parentvariableid")int parentVarId){
		log.info("Updating [Variable="+variable+",VariableId="+variableId+",Value="+value+",ParentVariableId="+parentVarId+"].");
		String result = constantsService.updateConstants(constantId, variable, variableId, value, parentVarId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("msg", result);
		log.info(result);
		return JsonUtil.getJsonAsString(resultMap);
	}
	
}
