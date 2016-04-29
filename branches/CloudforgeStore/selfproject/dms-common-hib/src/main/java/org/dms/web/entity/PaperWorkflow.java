package org.dms.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="PAPER_WORKFLOW")
public class PaperWorkflow implements Serializable {

	private static final long serialVersionUID = -4077099240024718017L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WORKFLOW_ID", unique = true, nullable = false)
	private long workflowId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name="PAPER_STORE_REF_ID", nullable=false)
	private PaperStore paperStoreRef;
	
	@Column(name="ASSIGNED_TO_USER_ID")
	private long assignedToUserId;
	
	@Column(name="ASSIGNED_ON_TIME")
	private Timestamp assignedOnTime;
	
	@Column(name="COMPLETED")
	private boolean completed;
	
	@Column(name="COMPLETED_BY_USER_ID")
	private long completedByUserId;
	
	@Column(name="COMPLETION_TIME")
	private Timestamp completionTime;
	
	@Column(name="COMMENTS", length= 500)
	private String comments;
	
	public PaperWorkflow() {
		super();
	}
		
	public PaperWorkflow(PaperStore paperStoreRef, long assignedToUserId,
			Timestamp assignedOnTime, boolean completed, long completedByUserId,
			Timestamp completionTime, String comments) {
		super();
		this.paperStoreRef = paperStoreRef;
		this.assignedToUserId = assignedToUserId;
		this.assignedOnTime = assignedOnTime;
		this.completed = completed;
		this.completedByUserId = completedByUserId;
		this.completionTime = completionTime;
		this.comments = comments;
	}

	public long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}

	public PaperStore getPaperStoreRef() {
		return paperStoreRef;
	}

	public void setPaperStoreRef(PaperStore paperStoreRef) {
		this.paperStoreRef = paperStoreRef;
	}

	public long getAssignedToUserId() {
		return assignedToUserId;
	}

	public void setAssignedToUserId(long assignedToUserId) {
		this.assignedToUserId = assignedToUserId;
	}

	public Timestamp getAssignedOnTime() {
		return assignedOnTime;
	}

	public void setAssignedOnTime(Timestamp assignedOnTime) {
		this.assignedOnTime = assignedOnTime;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public long getCompletedByUserId() {
		return completedByUserId;
	}

	public void setCompletedByUserId(long completedByUserId) {
		this.completedByUserId = completedByUserId;
	}

	public Timestamp getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(Timestamp completionTime) {
		this.completionTime = completionTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "PaperWorkflow [workflowId=" + workflowId + ", paperStoreRef="
				+ paperStoreRef + ", assignedToUserId=" + assignedToUserId
				+ ", assignedOnTime=" + assignedOnTime + ", completed="
				+ completed + ", completedByUserId=" + completedByUserId
				+ ", completionTime=" + completionTime + ", comments="
				+ comments + "]";
	}
	

}
