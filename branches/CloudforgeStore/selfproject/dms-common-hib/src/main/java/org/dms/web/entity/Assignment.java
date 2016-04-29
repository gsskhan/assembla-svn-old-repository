package org.dms.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="ASSIGNMENT")
public class Assignment implements Serializable{

	private static final long serialVersionUID = -5215657148611507124L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ASSIGNMENT_ID", nullable=false, unique= true)
	private long assignmentId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="EXAM_REF_ID", nullable= false )
	private Examination examRef;
	
	@Column(name="ASSIGNED_TO_USER_ID", nullable=false)
	private long assignedToUser;
	
	@Column(name="TIME_WHEN_ASSIGNED", nullable=false)
	private Timestamp timeWhenAssigned;
	
	@Column(name="COMPLETED")
	private boolean completed;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="assignmentRef")
	private AssignmentResponse assignmentResponse;

	public long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Examination getExamRef() {
		return examRef;
	}

	public void setExamRef(Examination examRef) {
		this.examRef = examRef;
	}

	public long getAssignedToUser() {
		return assignedToUser;
	}

	public void setAssignedToUser(long assignedToUser) {
		this.assignedToUser = assignedToUser;
	}

	public Timestamp getTimeWhenAssigned() {
		return timeWhenAssigned;
	}

	public void setTimeWhenAssigned(Timestamp timeWhenAssigned) {
		this.timeWhenAssigned = timeWhenAssigned;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public AssignmentResponse getAssignmentResponse() {
		return assignmentResponse;
	}

	public void setAssignmentResponse(AssignmentResponse assignmentResponse) {
		this.assignmentResponse = assignmentResponse;
	}	

	
}
