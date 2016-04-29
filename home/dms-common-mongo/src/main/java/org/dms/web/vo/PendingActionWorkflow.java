package org.dms.web.vo;

public class PendingActionWorkflow {
	
	private long paperNumber;
	private String paperTitle;
	private String workflowId;
	private String comments;
	private String pendingActionFromUsername;
	
	public PendingActionWorkflow() {
		super();
	}
	
	public PendingActionWorkflow(long paperNumber,
			String paperTitle, String workflowId, String comments,
			String pendingActionFromUsername) {
		super();
		this.paperNumber = paperNumber;
		this.paperTitle = paperTitle;
		this.workflowId = workflowId;
		this.comments = comments;
		this.pendingActionFromUsername = pendingActionFromUsername;
	}

	public long getPaperNumber() {
		return paperNumber;
	}
	public void setPaperNumber(long paperNumber) {
		this.paperNumber = paperNumber;
	}
	public String getPaperTitle() {
		return paperTitle;
	}
	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPendingActionFromUsername() {
		return pendingActionFromUsername;
	}
	public void setPendingActionFromUsername(String pendingActionFromUsername) {
		this.pendingActionFromUsername = pendingActionFromUsername;
	}

	@Override
	public String toString() {
		return "PendingActionWorkflow [paperNumber=" + paperNumber
				+ ", paperTitle="
				+ paperTitle + ", workflowId=" + workflowId + ", comments="
				+ comments + ", pendingActionFromUsername="
				+ pendingActionFromUsername + "]";
	}

}
