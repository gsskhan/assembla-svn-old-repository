package org.demo.lambda;

import org.apache.log4j.Logger;

public class HelloLambda {	

	private static Logger log = Logger.getLogger(HelloLambda.class);

	public static void main(String[] args) {
		log.info("program started...");
		log.info("declaring method body");
		
		SayHello method1 =  (name) -> { 
			log.info("Hello ! "+ name);
			return true;
			};
			
		log.info("runnning method1");
		method1.print("Gulam");
		
		SayHello method2 =  (name) -> { 
			log.info("Hi ! "+ name);
			return true;
			};
			
		log.info("runnning method2");
		method2.print("Gulam");
		
		log.info("program end ...");

	}

}
