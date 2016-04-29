/**
 * 
 */
package com.citi.retail.optima.etl.context.expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.citi.retail.optima.etl.common.reflection.util.OptimaRetailReflectionUtils;

/**
 * @author mc56120
 * 
 */
public class BeanExpressionResolver extends StandardBeanExpressionResolver {

	private static Logger logger = LoggerFactory
			.getLogger(BeanExpressionResolver.class);

	@Override
	protected void customizeEvaluationContext(
			StandardEvaluationContext evalContext) {
		try {
			evalContext
					.registerFunction(
							"getConcatenatedKeys",
							OptimaRetailReflectionUtils
									.getMethodReference(
											com.citi.retail.optima.etl.context.expression.KeyResolverUtil.class,
											"getConcatenatedKeys"));
			evalContext
			.registerFunction(
					"getInputFilePath",
					OptimaRetailReflectionUtils
							.getMethodReference(
									com.citi.retail.optima.etl.common.model.FilePathDetailsCache.class,
									"getInputFilePath"));
			evalContext
			.registerFunction(
					"getOutputFilePath",
					OptimaRetailReflectionUtils
							.getMethodReference(
									com.citi.retail.optima.etl.common.model.FilePathDetailsCache.class,
									"getOutputFilePath"));
			evalContext
			.registerFunction(
					"getArchiveFilePath",
					OptimaRetailReflectionUtils
							.getMethodReference(
									com.citi.retail.optima.etl.common.model.FilePathDetailsCache.class,
									"getArchiveFilePath"));
			evalContext
			.registerFunction(
					"getProcessedFilePath",
					OptimaRetailReflectionUtils
							.getMethodReference(
									com.citi.retail.optima.etl.common.model.FilePathDetailsCache.class,
									"getProcessedFilePath"));
			evalContext
			.registerFunction(
					"getFileColumnNameList",
					OptimaRetailReflectionUtils
							.getMethodReference(
									com.citi.retail.optima.etl.context.expression.KeyResolverUtil.class,
									"getFileColumnNameList"));
			
			evalContext
			.registerFunction(
					"getOutputFileColumnNameList",
					OptimaRetailReflectionUtils
							.getMethodReference(
									com.citi.retail.optima.etl.context.expression.KeyResolverUtil.class,
									"getOutputFileColumnNameList"));
			
			
		} catch (SecurityException e) {
			logger.error("Exception Details -> " + e);
		}
	}
}
