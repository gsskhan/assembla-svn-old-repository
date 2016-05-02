package org.demo.javaassist;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import org.apache.log4j.Logger;

public class DefineClassApp {
	
	private static Logger log = Logger.getLogger(DefineClassApp.class);

	public static void main(String[] args) throws Exception {
		log.info("Starting to create a new class on fly.");
		ClassPool pool = ClassPool.getDefault();
		CtClass pointClass = pool.makeClass("Point");
		// write the class to local hard disk.
		pointClass.writeFile("/tmp");
		log.info("Sucessfully written file for class "+ pointClass.getName());
		
		/* If a CtClass object is converted into a class file by writeFile(), toClass(), or toBytecode()
		, Javassist freezes that CtClass object. A frozen CtClass can be defrost so that modifications
		of the class definition will be permitted. */
		pointClass.defrost();
		pointClass.setName("NewPoint");
		pointClass.writeFile("/tmp");
		log.info("Sucessfully written changes file to disk for class "+ pointClass.getName());
		
		// Add a method to class
		pointClass.defrost();
		CtMethod printMethod = CtMethod.make("public int print(int val) { System.out.println(\"tested ok. Value passed = \"+val); return val; }", pointClass);
		pointClass.addMethod(printMethod);
		
		pointClass.writeFile("/tmp");
		log.info("Sucessfully written file for class "+ pointClass.getName());
		
		// Call a method
		Class<?> newClass = pointClass.toClass();
		Object obj = newClass.newInstance();
		Class<?>[] formalParams = new Class[] { int.class };
		Method newMethod = newClass.getMethod("print", formalParams);
		Object[] actualParams = new Object[]{new Integer(10)};
		log.info("Invoking the created class method.");
		int returnedValue = (int) newMethod.invoke(obj, actualParams);
		log.info("Returned value from method invoke = " + returnedValue);

		log.info("end ...");
	}

}
