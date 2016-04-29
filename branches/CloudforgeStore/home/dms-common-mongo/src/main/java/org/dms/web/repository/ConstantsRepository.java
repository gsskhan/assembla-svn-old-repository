package org.dms.web.repository;

import java.io.Serializable;
import java.util.List;

import org.dms.web.document.Constants;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConstantsRepository extends MongoRepository<Constants, Serializable>{
	
	Constants findOneByVariableNameAndVariableValue(String variableName, String variableValue);
	
	List<Constants> findDistinctVariableValueByVariableName(String variableName);
	
	List<Constants> findByVariableNameRegex(String variableName);
	
	Long deleteConstantsById(String id);
	
	Constants findOneById(String id); 

}
