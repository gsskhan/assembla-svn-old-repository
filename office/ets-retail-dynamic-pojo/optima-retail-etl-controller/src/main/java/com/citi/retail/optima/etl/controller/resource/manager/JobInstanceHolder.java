package com.citi.retail.optima.etl.controller.resource.manager;

import java.util.ArrayList;
import java.util.List;

import com.citi.retail.optima.etl.controller.model.BatchInstance;

/**
 * @author hs73849
 *
 */
public class JobInstanceHolder {

	private  List<BatchInstance> waitingJobsList = new ArrayList<BatchInstance>();
	private  List<String> runningJobsList = new ArrayList<String>();
	private  List<Long> completedJobsList = new ArrayList<Long>();
	private int allocatedResourceCount;
	
	public List<BatchInstance> getWaitingJobsList() {
		return waitingJobsList;
	}
	public void setWaitingJobsList(List<BatchInstance> waitingJobsList) {
		this.waitingJobsList = waitingJobsList;
	}
	public List<String> getRunningJobsList() {
		return runningJobsList;
	}
	public void setRunningJobsList(List<String> runningJobsList) {
		this.runningJobsList = runningJobsList;
	}
	public List<Long> getCompletedJobsList() {
		return completedJobsList;
	}
	public void setCompletedJobsList(List<Long> completedJobsList) {
		this.completedJobsList = completedJobsList;
	}
	public int getAllocatedResourceCount() {
		return allocatedResourceCount;
	}
	public void setAllocatedResourceCount(int allocatedResourceCount) {
		this.allocatedResourceCount = allocatedResourceCount;
	}
	
}
