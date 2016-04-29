package com.citi.risk.dashboard.test.util;


import org.junit.Test;
import com.citi.risk.dashboard.util.ConstantsUtil;
import junit.framework.Assert;

public class ConstantsUtilTest {
	
	
	@Test
	public void testConstants(){		
		
		Assert.assertNotNull(ConstantsUtil.UPDATE_USER_NAME_DEV.getConstants());

		
	}

}
