package com.citi.retail.optima.etl.validation.support.test;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.citi.retail.optima.etl.validation.support.CustomEvaluationProvider;

public class CustomEvaluationProviderImpl implements CustomEvaluationProvider<Map<String, Method>> {

	public Map<String, Method> getCustomFunctions() {
		Map<String, Method> map = new  ConcurrentHashMap<String, Method>();	
		map.put("getRegion", 
				getMethodReference(com.citi.retail.optima.etl.validation.model.UserSubmissionBaseRecord.class,"getRegion"));
		map.put("getCountry", 
				getMethodReference(com.citi.retail.optima.etl.validation.model.UserSubmissionBaseRecord.class,"getCountry"));
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
