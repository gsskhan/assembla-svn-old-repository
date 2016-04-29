package org.demo.commandrun;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SampleExecutor {
	
	public void executeJob() throws InterruptedException,
			ExecutionException, TimeoutException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> task = new Callable<String>() {
			@Override
			public String call() throws Exception {
				customProgram();
				return "Done";
			}

		};

		Future<String> future = executorService.submit(task);
		String retobj = null;
		try {
			retobj = future.get(3, TimeUnit.SECONDS);
			System.out.println("Finished! timeout");
		} catch (Exception e) {
			System.out.println("Terminated!");
		} finally {
			future.cancel(true);
			executorService.shutdownNow();
		}
				
		if (retobj == null) {
			throw new TimeoutException(" we killed the thread.. " + retobj);
		}
	}

	private void customProgram() throws InterruptedException {
		//int run = 1;
		System.out.println("sleeping started..");
		Thread.sleep(5000);
		System.out.println("sleeping end..");
		/*
		 * while (true) { Thread.sleep(1000); System.out.println("run .. " +
		 * run++); }
		 */
	}
}
