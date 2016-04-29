package com.citi.ets.publisher.test.common;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.citi.ets.publisher.common.EncryptDecryptUtil;

public class EncryptDecryptUtilTest {
	
	@Test
	@Ignore
	public void testMethod() throws Exception {
		
		String orignal = "GulamKhan";				
		System.out.println("String to encrypt =" + orignal);
		
		String encrtptedString = EncryptDecryptUtil.encrypt(orignal);
		Assert.assertNotNull(encrtptedString);		
		System.out.println("Encrypted = "+ encrtptedString);	
		
		String decryptedString = EncryptDecryptUtil.decrypt(encrtptedString);
		Assert.assertNotNull(decryptedString);
		Assert.assertEquals(orignal, decryptedString);
		System.out.println("Decrypted = "+ decryptedString);
		
		System.out.println("Finished");	
		
	}

}
