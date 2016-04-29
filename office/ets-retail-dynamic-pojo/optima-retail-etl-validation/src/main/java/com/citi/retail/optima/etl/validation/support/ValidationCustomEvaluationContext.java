/*
 */
package com.citi.retail.optima.etl.validation.support;

import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author TJ 
 * 		This Class provides a customized Evaluation Context for the
 *         Optima Retail Evaluation Context to register custom functions and
 *         also registers the application context Bean Factory as Bean Resolver
 *         for current Context. This context is passed on to the 
 *         services and the SPELs are evaluated on this context. Hence the
 *         custom functions and the bean references from the application context
 *         could be directly referenced in SpEL expressions to be evaluated. It
 *         implements ApplicationContextAware interface to inject the current
 *         application context as bean resolver for this evaluation context. See
 *         Also <code>StandardEvaluationContext</code>,
 *         <code>ApplicationContextAware</code>
 */
public class ValidationCustomEvaluationContext extends
		StandardEvaluationContext implements ApplicationContextAware {

	private ApplicationContext appContext;
	
	private CustomEvaluationProvider<Map<String, Method>> customEvaluationProvider;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ValidationCustomEvaluationContext.class);
	
	private static final String EMPTY_STRING = "";

	
	/**
	 * Initializes the DefaultBeanFactory of Application Context as the Bean
	 * Resolver for the current Context and registers the Custom Function(s).
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public void init() throws NoSuchMethodException {
		if (customEvaluationProvider != null) {
			Map<String, Method>  customFunctions = customEvaluationProvider.getCustomFunctions();			
			for (String key : customFunctions.keySet()) {
				registerCustomFunction(key, customFunctions.get(key));
			}
		}
		LOGGER.debug("ValidationCustomEvaluationContext Initialisation Begin");
		setBeanResolver(new BeanFactoryResolver(this.appContext));
		LOGGER.debug("ValidationEvaluationContext Initialisation End");

	}

	/**
	 * Registers the <code>java.lang.reflect.Method</code> reference of the
	 * custom methods created in optima retail in the current evaluation
	 * context. This enables the usage of the custom functions in SpEL
	 * expressions by the name specified in the parameter
	 * customFunctionName
	 * 
	 * @param customFunctionName
	 * @param customMethod
	 */
	public boolean registerCustomFunction(
			String customFunctionName, Method customMethod) {

		boolean exitStatus;
		if (customMethod != null && customFunctionName != null
				&& !EMPTY_STRING.equals(customFunctionName)) {

			registerFunction(customFunctionName, customMethod);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Custom Function Registered with Name: "
						+ customFunctionName);
			}
			exitStatus = true;
		} else {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Failed to Register the custom Function with Name: "
						+ customFunctionName);
			}
			exitStatus = false;
		}
		return exitStatus;
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) {

		this.appContext = applicationContext;
	}
	
	public void setCustomEvaluationProvider(
			CustomEvaluationProvider<Map<String, Method>> customEvaluationProvider) {
		this.customEvaluationProvider = customEvaluationProvider;
	}

}
