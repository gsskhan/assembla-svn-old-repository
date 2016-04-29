package org.dms.web.bo;

import java.util.List;

import org.dms.web.document.Constants;

public interface ConstantsService {
	
	String addNewConstant(String variableName, int variableId, String value, int parentVariableId);
	List<Constants> findAllConstantsForVariable(String variable);
	List<String> findAllValuesForVariable(String variable);
	List<String> findAllVariableNames();
	List<Constants> findAllConstants();
	String removeConstant(String constantId);
	Constants findConstants(String constantId);
	String updateConstants(String constantId, String variableName, int variableId, String value, int parentVariableId);
	byte[] buildPdfListOfAllConstants();	
	
}
