package org.demo.commandrun;

public class TestExecutor {
	
	public static void main(String[] args) {
		System.out.println("program started ...");
		try {
			SampleExecutor job = new SampleExecutor();
			job.executeJob();		
		} catch (Exception e) {
			System.out.println("error in main >>>> " + e);
			e.printStackTrace();
		}
		System.out.println("program end ...");
	}

}
