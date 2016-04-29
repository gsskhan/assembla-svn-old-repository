package com.citi.retail.optima.etl.common.reflection.util;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author ms04453 Utility Class to handle customized java reflection calls for
 *         Optima retail
 */
public final class OptimaRetailReflectionUtils {

	private OptimaRetailReflectionUtils() {
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(OptimaRetailReflectionUtils.class);

	/**
	 * Helper Method that returns the method signature/reference for the given
	 * method name in the specified class passed to it. See
	 * <code>com.citi.retail.optima.etl.context.OptimaRetailCustomEvaluationContext</code>
	 * 
	 * @param classObj
	 * @param methodName
	 * @return Method
	 */
	public static Method getMethodReference(Class<?> classObj, String methodName) {

		if (classObj != null && methodName != null) {

			Method[] classMethods = classObj.getMethods();

			if (classMethods == null || classMethods.length == 0) {
				LOGGER.error("Get Method Failed For: "
						+ methodName
						+ " No Methods returned while doing getMethods on Class"
						+ classObj.getName());
				return null;
			}
			for (Method m : classMethods) {
				if (m.getName().equals(methodName)) {
					return m;
				}
			}
		} else {
			LOGGER.error("Get Method Failed For: " + methodName
					+ " No Such Class Exists as the Class passed in was "
					+ classObj);
			return null;
		}
		LOGGER.error("Get Method Failed For: " + methodName
				+ " No Such Method Exists in Class: " + classObj.getName());
		return null;

	}

}
