package org.dms.batch.tasklets;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MoveDumpToHdfs implements Tasklet{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private String hdfsUrl;
	private String filesPath;

	@Override
	public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {
		this.copyFromLocalToHdfs();
		return RepeatStatus.FINISHED;
	}

	private void copyFromLocalToHdfs() throws Exception {		
			log.info("started: move database dump files to HDFS.");
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", this.hdfsUrl);
			FileSystem hdfs = FileSystem.get(conf);
			Path hdfsHomeDir = hdfs.getHomeDirectory();
			Path workingDir = hdfs.getWorkingDirectory();
			log.info("HDFS home "+ hdfsHomeDir+", working directory "+workingDir);
			Path newFolderPath= new Path("/dms");
			newFolderPath = Path.mergePaths(workingDir, newFolderPath);
			if(hdfs.exists(newFolderPath)) {
			      hdfs.delete(newFolderPath, true); //Delete existing Directory
			}
			hdfs.mkdirs(newFolderPath); //Create new Directory
			log.info("created hdfs path "+ newFolderPath);

			this.localFileMoveToHdfs(hdfs, filesPath, newFolderPath.toString());
			log.info("finished: moving database dump files to HDFS.");	
	}
	
	private void localFileMoveToHdfs(FileSystem hdfs, String localFilePath, String hdfsFilePath ) throws IOException{
		Path localPath = new Path(localFilePath);
		Path hdfsPath=new Path(hdfsFilePath);
		hdfs.copyFromLocalFile(localPath, hdfsPath);
		log.info("moved file from local "+localPath+" to hdfs path "+ hdfsPath);
	}

	public String getHdfsUrl() {
		return hdfsUrl;
	}
	public void setHdfsUrl(String hdfsUrl) {
		this.hdfsUrl = hdfsUrl;
	}
	public String getFilesPath() {
		return filesPath;
	}
	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}	

}
