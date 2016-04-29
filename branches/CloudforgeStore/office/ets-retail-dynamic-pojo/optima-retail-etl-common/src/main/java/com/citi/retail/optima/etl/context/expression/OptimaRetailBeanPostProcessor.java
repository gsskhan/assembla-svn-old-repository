/**
 * 
 */
package com.citi.retail.optima.etl.context.expression;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author mc56120
 * 
 * Bean post processor
 *
 */
public class OptimaRetailBeanPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) {
		beanFactory.setBeanExpressionResolver(new BeanExpressionResolver());
	}

}
