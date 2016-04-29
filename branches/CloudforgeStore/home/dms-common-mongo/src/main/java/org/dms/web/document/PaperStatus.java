package org.dms.web.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="paperstatus")
public class PaperStatus {
	
	@Id
	private String id;
	
	@DBRef(lazy=true)
	private PaperStores paperStores;
	
	@Field(value="authorized")
	private boolean authorized;

	@DBRef
	private Users authorizedBy;

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Field(value="authorizationtime")
	private Date authorizationTime;

	@Field(value="approved")
	private boolean approved;

	@DBRef
	private Users approvedBy;

	@Field(value="approvaltime")
	private Date approvalTime;

	@Field(value="rejected")
	private boolean rejected;

	@DBRef
	private Users rejectedBy;

	@Field(value="rejectiontime")
	private Date rejectionTime;

	@Field(value="comments")
	private String comments;
	
	public PaperStatus() {
		super();
	}

	public PaperStatus(PaperStores paperStores, boolean authorized,
			String comments) {
		super();
		this.paperStores = paperStores;
		this.authorized = authorized;
		this.comments = comments;
	}

	public PaperStatus(PaperStores paperStores, boolean authorized,
			Users authorizedBy, Date authorizationTime, boolean approved,
			Users approvedBy, Date approvalTime, boolean rejected,
			Users rejectedBy, Date rejectionTime, String comments) {
		super();
		this.paperStores = paperStores;
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

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public Users getAuthorizedBy() {
		return authorizedBy;
	}

	public void setAuthorizedBy(Users authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	public Date getAuthorizationTime() {
		return authorizationTime;
	}

	public void setAuthorizationTime(Date authorizationTime) {
		this.authorizationTime = authorizationTime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Users getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Users approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

	public boolean isRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}

	public Users getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(Users rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public Date getRejectionTime() {
		return rejectionTime;
	}

	public void setRejectionTime(Date rejectionTime) {
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
		return "PaperStatus [id=" + id + ", paperStores=" + paperStores
				+ ", authorized=" + authorized + ", authorizedBy="
				+ authorizedBy + ", authorizationTime=" + authorizationTime
				+ ", approved=" + approved + ", approvedBy=" + approvedBy
				+ ", approvalTime=" + approvalTime + ", rejected=" + rejected
				+ ", rejectedBy=" + rejectedBy + ", rejectionTime="
				+ rejectionTime + ", comments=" + comments + "]";
	}

}
