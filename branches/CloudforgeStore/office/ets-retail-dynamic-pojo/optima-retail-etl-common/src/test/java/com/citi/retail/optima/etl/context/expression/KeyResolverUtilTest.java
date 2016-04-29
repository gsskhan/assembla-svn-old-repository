/**
 * 
 */
package com.citi.retail.optima.etl.context.expression;

import java.util.ArrayList;
import java.util.List;



import org.junit.Assert;
import org.junit.Test;

import com.citi.retail.optima.etl.context.expression.KeyResolverUtil;

/**
 * @author mc56120
 *
 */

public class KeyResolverUtilTest {
	@Test
	public void testGetConcatenatedKeys(){
		List<Integer> processingUnitList = new ArrayList<Integer>();
		processingUnitList.add(1);
		String categoryName = "";
		String srcId = "";
		List<String> result = KeyResolverUtil.getConcatenatedKeys(processingUnitList, categoryName,srcId);
		Assert.assertEquals("1", result.get(0));
		result.clear();
		
		categoryName="commitmentIncreaseEvent";
		srcId="Genesis";
		result = KeyResolverUtil.getConcatenatedKeys(processingUnitList, categoryName,srcId);
		Assert.assertEquals("Genesis:commitmentIncreaseEvent:1", result.get(0));
		
	}
}
