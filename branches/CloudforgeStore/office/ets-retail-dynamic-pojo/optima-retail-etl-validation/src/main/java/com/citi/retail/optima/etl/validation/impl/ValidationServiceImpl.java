/**
 * 
 */
package com.citi.retail.optima.etl.validation.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.expression.EvaluationContext;

import com.citi.retail.optima.etl.validation.ValidationRulesLoader;
import com.citi.retail.optima.etl.validation.ValidationService;
import com.citi.retail.optima.etl.validation.exception.ValidationDataException;
import com.citi.retail.optima.etl.validation.exception.ValidationException;
import com.citi.retail.optima.etl.validation.validator.ItemValidator;

/**
 * @author TJ
 * 
 */
public class ValidationServiceImpl<T> implements ValidationService<T>,
		InitializingBean {

	private ItemValidator<T> validator;
	
	private EvaluationContext evalContext;

	private List<String> keyList;

	private String processingUnitIdsString;

	private ValidationRulesLoader rulesLoader;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ValidationServiceImpl.class);

	
	public T validate(T item) throws
			ValidationException, ValidationDataException {

		try {

			validator.validate(item);

		} catch (ValidationDataException validationDataException) {
			LOGGER.error("Validation errors logged for the bean with following props: "
					+ item);
			throw validationDataException;
		} catch (Exception e) {
			LOGGER.error("ValidationServiceSpelImpl.validate() | Exception Occured for the Bean with Following props: "
					+ item);
			// skip the item
			throw new ValidationException(					
					"ValidationServiceSpelImpl.validate() | Exception Occured for the Bean with Following props: ",
					e.getMessage(),e);
		}

		return item;
	}

	public void afterPropertiesSet() throws Exception {	
		validator.setEvalContext(evalContext);
		validator.setRulesList(rulesLoader.getRulesList(keyList));
	}

	public List<String> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}

	public String getProcessingUnitIdsString() {
		return processingUnitIdsString;
	}

	public void setProcessingUnitIdsString(String processingUnitIdsString) {
		this.processingUnitIdsString = processingUnitIdsString;
	}

	public ValidationRulesLoader getRulesLoader() {
		return rulesLoader;
	}

	public void setRulesLoader(ValidationRulesLoader rulesLoader) {
		this.rulesLoader = rulesLoader;
	}

	public ItemValidator<T> getValidator() {
		return validator;
	}

	public void setValidator(ItemValidator<T> validator) {
		this.validator = validator;
	}
	
	public EvaluationContext getEvalContext() {
		return evalContext;
	}

	public void setEvalContext(EvaluationContext evalContext) {
		this.evalContext = evalContext;
	}

}
