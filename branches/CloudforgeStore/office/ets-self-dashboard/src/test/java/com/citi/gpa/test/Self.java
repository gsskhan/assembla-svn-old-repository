package com.citi.gpa.test;

import org.junit.Ignore;
import org.junit.Test;


public class Self {

	@Test
	@Ignore
	public void testFirstMethod(){
		String str = "RISK ODS";
		System.out.println(str.replaceAll(" ", "-"));
	}
	
}
