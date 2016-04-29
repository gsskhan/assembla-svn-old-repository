package com.citi.retail.optima.etl.common.exception.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author hs73849 Utility class for Optima Retail and Controller Exception
 */
public final class OptimaRetailExceptionUtil {
	
	private OptimaRetailExceptionUtil()	{
	}

	/**
	 * @param e
	 * @return 
	 * This method is used to convert the Exception 
	 * stack trace to String.
	 */
	public static String getStackTrace(Exception e) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		e.printStackTrace(printWriter);
		String s = result.toString().replace("\n", "\\n");
		String s1 = s.replace("\r", "\\r");
		String s2 = s1.replace("\t", "\\t");
		return s2.replace("\"", "\\\"");
	}
}
