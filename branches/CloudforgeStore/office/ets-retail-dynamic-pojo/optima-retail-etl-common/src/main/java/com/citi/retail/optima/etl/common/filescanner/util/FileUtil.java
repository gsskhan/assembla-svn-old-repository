package com.citi.retail.optima.etl.common.filescanner.util;

import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.citi.retail.optima.etl.common.ServiceName;
import com.citi.retail.optima.etl.common.exception.ExceptionType;
import com.citi.retail.optima.etl.common.exception.OptimaRetailDataException;

public final class FileUtil {

	/**
	 * Private Constructor to avoid Sonar violation for Utility classes
	 */
	private FileUtil() {
	}

	public static String getStringFromColumns(String line,
			Set<Integer> orderSets, String delimiter)
			throws OptimaRetailDataException {
		StringBuffer buf = new StringBuffer("");
		String[] lineBreak = line.split(delimiter);
		for (Integer order : orderSets) {
			if (order < lineBreak.length) {
				buf.append(lineBreak[order]);
			} else {
				throw new OptimaRetailDataException(ServiceName.BATCH,
						ExceptionType.SKIPPABLE);
			}
		}
		return buf.toString();
	}

	public static boolean noOfColumnsMatch(String line, String delimiter,
			Integer expectedNoOfDelimiters) {
		if (expectedNoOfDelimiters == null || expectedNoOfDelimiters == 0) {
			return true;
		} else {
			int countOccurrences = StringUtils.countOccurrencesOf(line,
					delimiter);
			return (countOccurrences == (expectedNoOfDelimiters - 1));
		}
	}

	public static boolean fileTypeValidation(String fileName) {
		boolean returnType = false;
		returnType = fileName
				.matches("[a-zA-Z]+(_[a-zA-Z])+(_[0-9])+(_[0-91-zA-Z])+(_CCAR1)+(_[0-91-zA-Z])") ? true
				: false;
		return returnType;
	}

	public static boolean dataTypeValidation(String fieldValue, String dataType) {
		boolean returnType = false;
		if (dataType.equalsIgnoreCase("String")) {
			returnType = fieldValue.matches("[0-9a-zA-Z]*") ? true : false;
		} else if (dataType.equalsIgnoreCase("Integer")
				|| dataType.equalsIgnoreCase("int")
				|| dataType.equalsIgnoreCase("float")
				|| dataType.equalsIgnoreCase("long")) {
			returnType = fieldValue.matches("^[0-9]*(.[0-9]+)?$") ? true
					: false;
		} else if (dataType.equalsIgnoreCase("date")) {
			returnType = (fieldValue.matches("((19|20)\\d\\d(0?[1-9]|1[012]))") ? true
					: false);
		}
		return returnType;
	}

	public static boolean isDataTypeMatching(String line, String regexStr) {
		if (line == null) {
			return false;
		}
		return Pattern.matches(regexStr, line);
	}
	
	public static boolean isEmpty(String s) {
	    if ((s != null) && (s.trim().length() > 0))
	        return false;
	    else
	        return true;
	}
	
	public static boolean exceedsMaxLength(String s,Integer maxlength) {
		if(maxlength==null) {return false;}
	    if ((s != null) && (s.length() > maxlength))
	        return true;
	    else
	        return false;
	}
}
