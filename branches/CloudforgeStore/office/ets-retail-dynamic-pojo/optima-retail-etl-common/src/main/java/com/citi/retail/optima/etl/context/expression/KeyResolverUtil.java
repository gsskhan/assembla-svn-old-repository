/**
 * 
 */
package com.citi.retail.optima.etl.context.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.citi.retail.optima.etl.common.FileDetailsReader;

/**
 * @author mc56120
 * 
 */
public final class KeyResolverUtil {

	/**
	 * Private Constructor to avoid Sonar violation for Utility classes
	 */
	private KeyResolverUtil() {
	}	

	/**
	 * @param srcId
	 * @param processingUnit
	 * @param categoryName
	 * @return
	 */
	public static List<String> getConcatenatedKeys(
			List<Integer> processingUnit, String categoryName,String srcId) {
		List<String> keyList = new ArrayList<String>();
		String concatenatedStr = null;

		for (Integer pUnit : processingUnit) {
			concatenatedStr = "";
			if (srcId != null && srcId.length() > 0) {
				concatenatedStr = srcId+":";
			}

			if (categoryName != null && categoryName.length() > 0) {
				concatenatedStr = concatenatedStr+categoryName+":";
			} 

			concatenatedStr = concatenatedStr + pUnit.toString();
			keyList.add(concatenatedStr);
		}
		return keyList;
	}
	public static String getFileColumnNameList(String key){
		return FileDetailsReader.fileColumnDetailsMap.get(key);
	}
	
	public static String getOutputFileColumnNameList(String key){
		return FileDetailsReader.tabColumnsDetailsMap.get(key);
	}
	/**
	 * used by preprocessors and service rules to create a key to be used in preProcessor lookup's
	 * @param vars
	 * @return
	 */
	public static String keyCreator(Object... vars) {
		StringBuilder keyString = new StringBuilder();
		int i = 1;
		for (Object var : vars) {
			if (var != null) {
				keyString.append(var.toString().toLowerCase().trim());
				if (vars.length != i) {
					keyString.append(",");
				}
			} else {
				if (vars.length != i) {
					keyString.append(",");
				}
			}
			i++;
		}
		return keyString.toString();
	}	
}
