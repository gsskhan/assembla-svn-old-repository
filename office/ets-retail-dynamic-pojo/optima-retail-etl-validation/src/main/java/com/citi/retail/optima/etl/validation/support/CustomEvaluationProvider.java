package com.citi.retail.optima.etl.validation.support;

import java.lang.reflect.Method;
import java.util.Map;

public interface CustomEvaluationProvider <T> {
	Map<String, Method> getCustomFunctions();
}
