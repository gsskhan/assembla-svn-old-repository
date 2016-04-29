package org.dms.batch.tasklets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.dms.batch.core.OSValidator;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

public class ExecuteSystemCommand implements Tasklet{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private Resource windowsCommandFilePath;
	private Resource unixCommandFilePath;
	private String workingDirectory;

	@Override
	public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {
		log.info("operating system type: "+ OSValidator.OS);
		if (OSValidator.isWindows()) {
			File file = windowsCommandFilePath.getFile();
				// Old way 
				// this.runCommand("cmd /c "+file.getCanonicalPath());
			String[] command = {"CMD", "/C", file.getCanonicalPath()};
			this.execCommand(command);
		} else if (OSValidator.isUnix()) {
			File file = unixCommandFilePath.getFile();
				// Old way
				//this.runCommand("sh " +file.getCanonicalPath());
			String[] command = {"sh", file.getCanonicalPath()};
			this.execCommand(command);
		} else {
			throw new RuntimeException("program cannot execute commands for OS - " + OSValidator.OS);
		}
		return RepeatStatus.FINISHED;
	}

	/**
	 * Since JDK1.5 ProcessBuilder was introduced, it must be used in place of runtime class methods.
	 */
	@SuppressWarnings("unused")
	private void runCommand(String command) throws IOException, InterruptedException {
		log.info("command to execute: " + command);
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
		BufferedReader brIn = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader brErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

		String result = "";
		log.info("command execution result:");
		while ((result = brIn.readLine()) != null) {
			log.info(result);
		}
		log.info("command execution error(if any):");
		while ((result = brErr.readLine()) != null) {
			log.warn(result);
		}
	}
	
	private void execCommand(String[] command) throws IOException, InterruptedException {
		log.info("command to execute: " +Arrays.toString(command));
		ProcessBuilder pb = new ProcessBuilder().command(command).redirectErrorStream(true);		
		File workFilePath = new File(workingDirectory);
		if (! workFilePath.exists() || ! workFilePath.isDirectory()) {
			throw new RuntimeException("Working directory must be an existing directory.");
		}
		pb.directory(workFilePath);		
		Process process = pb.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String result = "";
		while ((result = br.readLine()) != null) {
			log.info(result);
		}
		process.waitFor();
	}

	public Resource getWindowsCommandFilePath() {
		return windowsCommandFilePath;
	}
	public void setWindowsCommandFilePath(Resource windowsCommandFilePath) {
		this.windowsCommandFilePath = windowsCommandFilePath;
	}
	public Resource getUnixCommandFilePath() {
		return unixCommandFilePath;
	}
	public void setUnixCommandFilePath(Resource unixCommandFilePath) {
		this.unixCommandFilePath = unixCommandFilePath;
	}
	public String getWorkingDirectory() {
		return workingDirectory;
	}
	public void setWorkingDirectory(String workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

}
