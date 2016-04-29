package org.dms.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

/**
 * @author gsskhan - To hold each paper contents
 */

@Entity
@Table(name="PAPER_STORE")
public class PaperStore implements Serializable{
	
	private static final long serialVersionUID = 4298340509308384389L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAPER_STORE_ID", unique = true, nullable = false)
	private long paperStoreId;
	
	@Column(name="PAPER_NUMBER", nullable= false)
	private long paperNumber;
	
	@Column(name="PAPER_TITLE", nullable= false, length=500)
	private String paperTitle;
	
	@Column(name="ORG_FILENAME", nullable= false, length=500)
	private String originalFilename;

	@Lob
	@Column(name="PAPER_DATA", nullable= false)
	private byte[] paperData;
	
	@Column(name="CREATED_BY_USER_ID", nullable= false)
	private long createdByUserId;
	
	@Column(name="CREATION_TIME", nullable= false)
	private Timestamp creationTime;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="paperStoreRef")
	private Set<PaperStatusInfo> paperStatusInfos;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="paperStoreRef")
	private Set<PaperWorkflow> paperWorkflows;	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paperStoreRef")
	private Examination examination;
	
	public PaperStore() {
		super();
	}

	public PaperStore(long paperNumber, String paperTitle, String originalFilename ,
			byte[] paperData, long createdByUserId, Timestamp creationTime,
			Set<PaperStatusInfo> paperStatusInfos,
			Set<PaperWorkflow> paperWorkflows, Examination examination) {
		super();
		this.paperNumber = paperNumber;
		this.paperTitle = paperTitle;
		this.originalFilename = originalFilename;
		this.paperData = paperData;
		this.createdByUserId = createdByUserId;
		this.creationTime = creationTime;
		this.paperStatusInfos = paperStatusInfos;
		this.paperWorkflows = paperWorkflows;
		this.examination = examination;
	}

	public long getPaperStoreId() {
		return paperStoreId;
	}

	public void setPaperStoreId(long paperStoreId) {
		this.paperStoreId = paperStoreId;
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
	
	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public byte[] getPaperData() {
		return paperData;
	}

	public void setPaperData(byte[] paperData) {
		this.paperData = paperData;
	}

	public long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Set<PaperStatusInfo> getPaperStatusInfos() {
		return paperStatusInfos;
	}

	public void setPaperStatusInfos(Set<PaperStatusInfo> paperStatusInfos) {
		this.paperStatusInfos = paperStatusInfos;
	}

	public Set<PaperWorkflow> getPaperWorkflows() {
		return paperWorkflows;
	}

	public void setPaperWorkflows(Set<PaperWorkflow> paperWorkflows) {
		this.paperWorkflows = paperWorkflows;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	@Override
	public String toString() {
		return "PaperStore [paperStoreId=" + paperStoreId + ", paperNumber="+ paperNumber 
				+ ", paperTitle=" + paperTitle + ", Orig. Filename=" + originalFilename //+ ", paperData="	+ Arrays.toString(paperData)
				+ ", createdByUserId=" + createdByUserId + ", creationTime=" + creationTime
				+ ", paperStatusInfos=" + paperStatusInfos
				+ ", paperWorkflows=" + paperWorkflows + ", examination="
				+ examination + "]";
	}	

}
