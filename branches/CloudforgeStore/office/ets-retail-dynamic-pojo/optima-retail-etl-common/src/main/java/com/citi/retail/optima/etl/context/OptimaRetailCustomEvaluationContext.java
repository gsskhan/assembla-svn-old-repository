/*
 */
package com.citi.retail.optima.etl.context;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.citi.retail.optima.etl.common.reflection.util.OptimaRetailReflectionUtils;

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
public class OptimaRetailCustomEvaluationContext extends
		StandardEvaluationContext implements ApplicationContextAware {

	private ApplicationContext appContext;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OptimaRetailCustomEvaluationContext.class);
	private static final String EMPTY_STRING = "";

	/**
	 * Initializes the DefaultBeanFactory of Application Context as the Bean
	 * Resolver for the current Context and registers the Custom Function(s).
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public void init() throws NoSuchMethodException {

		LOGGER.debug("OptimaRetailCustomEvaluationContext Initialisation Begin");
		setBeanResolver(new BeanFactoryResolver(this.appContext));
		/*
		 * Use the Following code as sample to Register Custom Functions during
		 * Init
		 */

		registerCustomFunction(
				"isCurrentMonth",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"isCurrentMonth"));
		registerCustomFunction(
				"calculateAge",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"calculateAge"));
		registerCustomFunction(
				"convertDate",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"convertDate"));
		registerCustomFunction(
				"getBillCycleDate",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getBillCycleDate"));
		registerCustomFunction(
				"getBaselPortfolioId",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getBaselPortfolioId"));
		
		registerCustomFunction(
				"splitForRateTypes",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForRateTypes"));
		
		registerCustomFunction(
				"splitForBalanceTypesPreRnbw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesPreRnbw"));
		
		registerCustomFunction(
				"splitForBalanceTypesRnbw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesRnbw"));
		
		registerCustomFunction(
				"getMonths",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getMonths"));
		registerCustomFunction(
				"getMonthsHKCardsRnbw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getMonthsHKCardsRnbw"));
		registerCustomFunction(
				"getMonthsHKCardsPreRnbw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getMonthsHKCardsPreRnbw"));
		registerCustomFunction(
				"splitForBalanceTypesForMtg",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForMtg"));
		
		registerCustomFunction(
				"splitForBalanceTypesForPL",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForPL"));
		
		registerCustomFunction(
				"splitForBalanceTypesInCrd",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesInCrd"));
		
		registerCustomFunction(
				"splitForBalanceTypesInRcCorp",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesInRcCorp"));
		registerCustomFunction(
				"splitForBalanceTypesInRcRw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesInRcRw"));
		registerCustomFunction(
				"splitForBalanceTypesInRcRet",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesInRcRet"));
		registerCustomFunction(
				"splitForBalanceTypesInPl",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesInPl"));
		
		registerCustomFunction(
				"getAsOfDate",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getAsOfDate"));
		
	
		registerCustomFunction(
				"getCredFacTypId",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getCredFacTypId"));
		
			registerCustomFunction(
				"splitForBalanceTypesForInMtgOreo",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForInMtgOreo"));
		
		registerCustomFunction(
				"splitForBalanceTypesForInMtgGcbc",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForInMtgGcbc"));
		
		registerCustomFunction(
				"splitForBalanceTypesForHKPLPostRainbow",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHKPLPostRainbow"));
		
		
		registerCustomFunction(
				"splitForBalanceTypesForHKPLPreRainbow",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHKPLPreRainbow"));
		
		
		registerCustomFunction(
				"splitForBalanceTypesForInMtgGcl",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForInMtgGcl"));			
		registerCustomFunction(
				"splitForBalanceTypesHkCrdPreRbnw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesHkCrdPreRbnw"));			
		registerCustomFunction(
				"splitForBalanceTypesHkCrdRbnw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesHkCrdRbnw"));			
		registerCustomFunction(
				"splitForBalanceTypesForHkMtgPostRnbw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHkMtgPostRnbw"));
		
		registerCustomFunction(
				"splitForBalanceTypesForHkMtgPreRnbw",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHkMtgPreRnbw"));		
		
		registerCustomFunction(
				"splitForBalanceTypesForHKPLPostRainbow",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHKPLPostRainbow"));
		
		
		registerCustomFunction(
				"splitForBalanceTypesForHKPLPreRainbow",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHKPLPreRainbow"));
		
		registerCustomFunction(
				"splitForBalanceTypesForHkRcPreRainbow",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHkRcPreRainbow"));	
		registerCustomFunction(
				"splitForBalanceTypesForHkRcRainbow",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHkRcRainbow"));
		
		
		registerCustomFunction(
				"getDeliqValueasInt",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getDeliqValueasInt"));
		
		
		registerCustomFunction(
				"splitForRateTypesForTwRc",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForRateTypesForTwRc"));
		
		registerCustomFunction(
				"splitForBalanceTypesForTwRcPreRainbow",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForTwRcPreRainbow"));
		
		registerCustomFunction(
				"splitForBalanceTypesForTwRcPostRainbow",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForTwRcPostRainbow"));
		
		registerCustomFunction(
				"getLastDate",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getLastDate"));
		
		registerCustomFunction(
				"getMonthsTwMtg",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getMonthsTwMtg"));
		
		registerCustomFunction(
				"getDelq30DayPast2YrFlag",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getDelq30DayPast2YrFlag"));
		registerCustomFunction(
				"splitForBalanceTypesForHkMtgRecRecord",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"splitForBalanceTypesForHkMtgRecRecord"));
		registerCustomFunction(
				"getBaselPortfolioIdForInCrd",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getBaselPortfolioIdForInCrd"));
		registerCustomFunction(
				"convertCharToInt",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"convertCharToInt"));
		
		registerCustomFunction(
				"getBaselPortfolioIdForInRc",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getBaselPortfolioIdForInRc"));
		
		
		registerCustomFunction(
				"getCcarProdCodeForInRc",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getCcarProdCodeForInRc"));
		
		registerCustomFunction(
				"getCycleEndDelinqBucketTwRC",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getCycleEndDelinqBucketTwRC"));
		registerCustomFunction(
				"getCycleEndDelinqBucketTwRCPre",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getCycleEndDelinqBucketTwRCPre"));
		
		registerCustomFunction(
				"getCycleEndDelinqBucketTwCrdPre",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"getCycleEndDelinqBucketTwCrdPre"));
		
		
		registerCustomFunction(
				"geteDelq30DayPst2YrsFlgTwRc",
				OptimaRetailReflectionUtils
						.getMethodReference(
								com.citi.retail.optima.etl.context.CustomMethodsProvider.class,
								"geteDelq30DayPst2YrsFlgTwRc"));
						
		LOGGER.debug("OptimaRetailEvaluationContext Initialisation End");

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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {

		this.appContext = applicationContext;
	}

}
