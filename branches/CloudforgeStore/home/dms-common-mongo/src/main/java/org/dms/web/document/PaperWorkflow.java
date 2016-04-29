package org.dms.web.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "paperworkflow")
public class PaperWorkflow {

	@Id
	private String id;
	
	@DBRef
	private PaperStores paperStores;
	
	@DBRef
	private Users assignedToUser;
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Field(value="assignedontime")
	private Date assignedOnTime;

	@DBRef
	private Users completedByUser;

	@Field(value="completed")
	private boolean completed;
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Field(value="completiontime")
	private Date completionTime;

	@Field(value="comments")
	private String comments;
	
	public PaperWorkflow() {
		super();
	}

	public PaperWorkflow(PaperStores paperStores, Users assignedToUser,
			Date assignedOnTime, Users completedByUser,
			boolean completed, Date completionTime, String comments) {
		super();
		this.paperStores = paperStores;
		this.assignedToUser = assignedToUser;
		this.assignedOnTime = assignedOnTime;
		this.completedByUser = completedByUser;
		this.completed = completed;
		this.completionTime = completionTime;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PaperStores getPaperStores() {
		return paperStores;
	}

	public void setPaperStores(PaperStores paperStores) {
		this.paperStores = paperStores;
	}

	public Users getAssignedToUser() {
		return assignedToUser;
	}

	public void setAssignedToUserId(Users assignedToUser) {
		this.assignedToUser = assignedToUser;
	}

	public Date getAssignedOnTime() {
		return assignedOnTime;
	}

	public void setAssignedOnTime(Date assignedOnTime) {
		this.assignedOnTime = assignedOnTime;
	}

	public Users getCompletedByUser() {
		return completedByUser;
	}

	public void setCompletedByUserId(Users completedByUser) {
		this.completedByUser = completedByUser;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(Date completionTime) {
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
		return "PaperWorkflow [id=" + id + ", paperStores=" + paperStores
				+ ", assignedToUser=" + assignedToUser
				+ ", assignedOnTime=" + assignedOnTime + ", completedByUserId="
				+ completedByUser + ", completed=" + completed
				+ ", completionTime=" + completionTime + ", comments="
				+ comments + "]";
	}	

}
