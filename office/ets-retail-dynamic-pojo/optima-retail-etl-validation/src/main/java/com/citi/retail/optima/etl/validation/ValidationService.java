package com.citi.retail.optima.etl.validation;

import com.citi.retail.optima.etl.validation.exception.ValidationException;
import com.citi.retail.optima.etl.validation.exception.ValidationDataException;

/**
 * 
 * @author MK67854 This Interface is implemented by actual Validation service
 *         for each of the account Type. This declares/defines the methods that
 *         perform validation across different account types.
 * @param <T>
 */
public interface ValidationService<T> {

	/**
	 * The implementation of this method has to provide the functionality of
	 * validating the current account object being passed.
	 * 
	 * @param currentAccount
	 * @return validated Account Object of same type
	 * @throws Exception
	 */
	T validate(T item) throws ValidationDataException, ValidationException;
}
