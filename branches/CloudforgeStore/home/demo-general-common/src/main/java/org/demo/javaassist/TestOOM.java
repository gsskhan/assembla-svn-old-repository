package org.demo.javaassist;

public class TestOOM {

	public static void main(String[] args) {
		System.out.println("running");
		TestOOM oom = new TestOOM();
		try {
			oom.sample();
		} catch (Error e) {
			System.out.println("caught exception - " + e);
		}
	}
	
	private void sample() {
		System.out.println("throwing exception ....");
		throw new OutOfMemoryError("crisis");
	}

}
