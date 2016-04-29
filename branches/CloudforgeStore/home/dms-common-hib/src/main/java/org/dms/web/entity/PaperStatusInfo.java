package org.dms.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="PAPER_STATUS_INFO")
public class PaperStatusInfo implements Serializable{

	private static final long serialVersionUID = -7887147613782848746L;	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAPER_STATUS_ID", unique = true, nullable = false)
	private long paperStatusId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PAPER_STORE_REF_ID", nullable=false)
	private PaperStore paperStoreRef;
	
	@Column(name="AUTHORIZED")
	private boolean authorized;
	
	@Column(name="AUTHORIZED_BY")
	private long authorizedBy;
	
	@Column(name="AUTHORIZATION_TIME")
	private Timestamp authorizationTime;
	
	@Column(name="APPROVED")
	private boolean approved;
	
	@Column(name="APPROVED_BY")
	private long approvedBy;
	
	@Column(name="APPROVAL_TIME")
	private Timestamp approvalTime;
	
	@Column(name="REJECTED")
	private boolean rejected;
	
	@Column(name="REJECTED_BY")
	private long rejectedBy;
	
	@Column(name="REJECTION_TIME")
	private Timestamp rejectionTime;
	
	@Column(name="COMMENTS", length= 500)
	private String comments;
	
	public PaperStatusInfo() {
		super();
	}	
		
	public PaperStatusInfo(PaperStore paperStoreRef, boolean authorized,
			String comments) {
		super();
		this.paperStoreRef = paperStoreRef;
		this.authorized = authorized;
		this.comments = comments;
	}

	public PaperStatusInfo(PaperStore paperStoreRef, boolean authorized,
			long authorizedBy, Timestamp authorizationTime, boolean approved,
			long approvedBy, Timestamp approvalTime, boolean rejected,
			long rejectedBy, Timestamp rejectionTime, String comments) {
		super();
		this.paperStoreRef = paperStoreRef;
		this.authorized = authorized;
		this.authorizedBy = authorizedBy;
		this.authorizationTime = authorizationTime;
		this.approved = approved;
		this.approvedBy = approvedBy;
		this.approvalTime = approvalTime;
		this.rejected = rejected;
		this.rejectedBy = rejectedBy;
		this.rejectionTime = rejectionTime;
		this.comments = comments;
	}

	public long getPaperStatusId() {
		return paperStatusId;
	}

	public void setPaperStatusId(long paperStatusId) {
		this.paperStatusId = paperStatusId;
	}

	public PaperStore getPaperStoreRef() {
		return paperStoreRef;
	}

	public void setPaperStoreRef(PaperStore paperStoreRef) {
		this.paperStoreRef = paperStoreRef;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public long getAuthorizedBy() {
		return authorizedBy;
	}

	public void setAuthorizedBy(long authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	public Timestamp getAuthorizationTime() {
		return authorizationTime;
	}

	public void setAuthorizationTime(Timestamp authorizationTime) {
		this.authorizationTime = authorizationTime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public long getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Timestamp getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Timestamp approvalTime) {
		this.approvalTime = approvalTime;
	}

	public boolean isRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}

	public long getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(long rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public Timestamp getRejectionTime() {
		return rejectionTime;
	}

	public void setRejectionTime(Timestamp rejectionTime) {
		this.rejectionTime = rejectionTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "PaperStatusInfo [paperStatusId=" + paperStatusId
				+ ", paperStoreRef=" + paperStoreRef + ", authorized="
				+ authorized + ", authorizedBy=" + authorizedBy
				+ ", authorizationTime=" + authorizationTime + ", approved="
				+ approved + ", approvedBy=" + approvedBy + ", approvalTime="
				+ approvalTime + ", rejected=" + rejected + ", rejectedBy="
				+ rejectedBy + ", rejectionTime=" + rejectionTime
				+ ", comments=" + comments + "]";
	}
	
}
