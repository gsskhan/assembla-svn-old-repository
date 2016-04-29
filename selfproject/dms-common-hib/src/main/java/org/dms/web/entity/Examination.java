package org.dms.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="EXAMINATION")
public class Examination implements Serializable{

	private static final long serialVersionUID = 2201449383112018717L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EXAM_ID",nullable= false, unique= true)
	private long examId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PAPER_STORE_REF_ID", nullable=false)
	private PaperStore paperStoreRef;
	
	@Column(name="EXAM_START_TIME", nullable=false)
	private Timestamp examStartTime;
	
	@Column(name="EXAM_END_TIME", nullable=false)
	private Timestamp examEndTime;
	
	@Column(name="EXAM_OWNER", nullable=false)
	private long examOwner;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="examRef")
	private Set<Assignment> assignments;
	
	public Examination() {
		super();
	}

	public Examination(PaperStore paperStoreRef, Timestamp examStartTime,
			Timestamp examEndTime, long examOwner) {
		super();
		this.paperStoreRef = paperStoreRef;
		this.examStartTime = examStartTime;
		this.examEndTime = examEndTime;
		this.examOwner = examOwner;
	}
	
	public Examination(PaperStore paperStoreRef, Timestamp examStartTime,
			Timestamp examEndTime, long examOwner, Set<Assignment> assignments) {
		super();
		this.paperStoreRef = paperStoreRef;
		this.examStartTime = examStartTime;
		this.examEndTime = examEndTime;
		this.examOwner = examOwner;
		this.assignments = assignments;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public PaperStore getPaperStoreRef() {
		return paperStoreRef;
	}

	public void setPaperStoreRef(PaperStore paperStoreRef) {
		this.paperStoreRef = paperStoreRef;
	}

	public Timestamp getExamStartTime() {
		return examStartTime;
	}

	public void setExamStartTime(Timestamp examStartTime) {
		this.examStartTime = examStartTime;
	}

	public Timestamp getExamEndTime() {
		return examEndTime;
	}

	public void setExamEndTime(Timestamp examEndTime) {
		this.examEndTime = examEndTime;
	}

	public long getExamOwner() {
		return examOwner;
	}

	public void setExamOwner(long examOwner) {
		this.examOwner = examOwner;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	@Override
	public String toString() {
		return "Examination [examId=" + examId + ", paperStoreRef="
				+ paperStoreRef + ", examStartTime=" + examStartTime
				+ ", examEndTime=" + examEndTime + ", examOwner=" + examOwner
				+ ", assignments=" + assignments + "]";
	}
	

}
