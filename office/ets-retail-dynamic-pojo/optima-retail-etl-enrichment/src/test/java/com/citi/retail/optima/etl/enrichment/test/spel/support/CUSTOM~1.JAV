package com.citi.retail.optima.etl.enrichment.test.spel.support;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.citi.retail.optima.etl.enrichment.support.CustomEvaluationProvider;

public class CustomEvaluationProviderImpl implements CustomEvaluationProvider<Map<String, Method>> {

	public Map<String, Method> getCustomFunctions() {
		Map<String, Method> map = new  ConcurrentHashMap<String, Method>();	
		map.put("getCollateralizedFlag", 
				getMethodReference(com.citi.retail.optima.etl.enrichment.model.UserSubmissionCCARRecord.class,"getCollateralizedFlag"));
		map.put("getGcbcPortfolioId", 
				getMethodReference(com.citi.retail.optima.etl.enrichment.model.UserSubmissionCCARRecord.class,"getGcbcPortfolioId"));
		map.put("getCurrLineLoanSize", 
				getMethodReference(com.citi.retail.optima.etl.enrichment.model.UserSubmissionCCARRecord.class,"getCurrLineLoanSize"));
		map.put("getOriginalLtv", 
				getMethodReference(com.citi.retail.optima.etl.enrichment.model.UserSubmissionCCARRecord.class,"getOriginalLtv"));
		return map;
	}
	
	
	public static Method getMethodReference(Class<?> classObj, String methodName) {

		if (classObj != null && methodName != null) {

			Method[] classMethods = classObj.getMethods();

			if (classMethods == null || classMethods.length == 0) {				
				return null;
			}
			for (Method m : classMethods) {
				if (m.getName().equals(methodName)) {
					return m;
				}
			}
		} else {
			
			return null;
		}
		return null;
	}

}
