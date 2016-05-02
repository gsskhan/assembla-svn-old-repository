package org.demo.commandrun;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestProcessBuilder {
	
	public static void main(String[] args) {
		ProcessBuilder processBuilder = new ProcessBuilder("nohup","/home/gsskhan/sample/sample.sh", "&");
		processBuilder.directory(new File("/tmp"));
		processBuilder.redirectErrorStream(true);
		try {
			Process process = processBuilder.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			System.out.println("output:-");
			while ((line = br.readLine())!=null) {
				System.out.println(line);
			}
			process.waitFor();
		} catch (IOException e) {
			System.out.println("error startting process ...");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("error startting process interuppted ...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("unknown error startting process ...");
			e.printStackTrace();
		}
		
		
		
	}

}
