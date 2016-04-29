package org.dms.web.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ASSIGNMENT_RESPONSE")
public class AssignmentResponse implements Serializable {

	private static final long serialVersionUID = 7836861023155743326L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ASSIGN_RESP_ID", nullable= false, unique= true)
	private long responseId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ASSIGNMENT_REF_ID", nullable=false)
	private Assignment assignmentRef;
	
	@Lob
	@Column(name="RESPONSE_DATA")
	private byte[] responseData;
	
	@Column(name="EVAL_ONE_TOTAL")
	private int evalOneTotal;	
	@Column(name="EVAL_ONE_EXAMINER_ID")
	private long evalOneExaminerId;	
	@Column(name="EVAL_ONE_EXAMINER_COMMENT")
	private String evalOneExaminerComment;	
	@Column(name="EVAL_ONE_EXAMINEE_FEEDBACK")
	private String evalOneExamineeFeedback;
	
	@Column(name="EVAL_TWO_TOTAL")
	private int evalTwoTotal;
	@Column(name="EVAL_TWO_EXAMINER_ID")
	private long evalTwoExaminerId;
	@Column(name="EVAL_TWO_EXAMINER_COMMENT")
	private String evalTwoExaminerComment;
	@Column(name="EVAL_TWO_EXAMINEE_FEEDBACK")
	private String evalTwoExamineeFeedback;
	
	@Column(name="EVAL_THREE_TOTAL")
	private int evalThreeTotal;
	@Column(name="EVAL_THREE_EXAMINER_ID")
	private long evalThreeExaminerId;
	@Column(name="EVAL_THREE_EXAMINER_COMMENT")
	private String evalThreeExaminerComment;
	@Column(name="EVAL_THREE_EXAMINEE_FEEDBACK")
	private String evalThreeExamineeFeedback;
	
	@Column(name="FINAL_TOTAL_MARKS")
	private int finalTotalMarks;
	@Column(name="FINAL_RANK")
	private int finalRank;
	
	
	public long getResponseId() {
		return responseId;
	}
	public void setResponseId(long responseId) {
		this.responseId = responseId;
	}
	public Assignment getAssignmentRef() {
		return assignmentRef;
	}
	public void setAssignmentRef(Assignment assignmentRef) {
		this.assignmentRef = assignmentRef;
	}
	public byte[] getResponseData() {
		return responseData;
	}
	public void setResponseData(byte[] responseData) {
		this.responseData = responseData;
	}
	public int getEvalOneTotal() {
		return evalOneTotal;
	}
	public void setEvalOneTotal(int evalOneTotal) {
		this.evalOneTotal = evalOneTotal;
	}
	public long getEvalOneExaminerId() {
		return evalOneExaminerId;
	}
	public void setEvalOneExaminerId(long evalOneExaminerId) {
		this.evalOneExaminerId = evalOneExaminerId;
	}
	public String getEvalOneExaminerComment() {
		return evalOneExaminerComment;
	}
	public void setEvalOneExaminerComment(String evalOneExaminerComment) {
		this.evalOneExaminerComment = evalOneExaminerComment;
	}
	public String getEvalOneExamineeFeedback() {
		return evalOneExamineeFeedback;
	}
	public void setEvalOneExamineeFeedback(String evalOneExamineeFeedback) {
		this.evalOneExamineeFeedback = evalOneExamineeFeedback;
	}
	public int getEvalTwoTotal() {
		return evalTwoTotal;
	}
	public void setEvalTwoTotal(int evalTwoTotal) {
		this.evalTwoTotal = evalTwoTotal;
	}
	public long getEvalTwoExaminerId() {
		return evalTwoExaminerId;
	}
	public void setEvalTwoExaminerId(long evalTwoExaminerId) {
		this.evalTwoExaminerId = evalTwoExaminerId;
	}
	public String getEvalTwoExaminerComment() {
		return evalTwoExaminerComment;
	}
	public void setEvalTwoExaminerComment(String evalTwoExaminerComment) {
		this.evalTwoExaminerComment = evalTwoExaminerComment;
	}
	public String getEvalTwoExamineeFeedback() {
		return evalTwoExamineeFeedback;
	}
	public void setEvalTwoExamineeFeedback(String evalTwoExamineeFeedback) {
		this.evalTwoExamineeFeedback = evalTwoExamineeFeedback;
	}
	public int getEvalThreeTotal() {
		return evalThreeTotal;
	}
	public void setEvalThreeTotal(int evalThreeTotal) {
		this.evalThreeTotal = evalThreeTotal;
	}
	public long getEvalThreeExaminerId() {
		return evalThreeExaminerId;
	}
	public void setEvalThreeExaminerId(long evalThreeExaminerId) {
		this.evalThreeExaminerId = evalThreeExaminerId;
	}
	public String getEvalThreeExaminerComment() {
		return evalThreeExaminerComment;
	}
	public void setEvalThreeExaminerComment(String evalThreeExaminerComment) {
		this.evalThreeExaminerComment = evalThreeExaminerComment;
	}
	public String getEvalThreeExamineeFeedback() {
		return evalThreeExamineeFeedback;
	}
	public void setEvalThreeExamineeFeedback(String evalThreeExamineeFeedback) {
		this.evalThreeExamineeFeedback = evalThreeExamineeFeedback;
	}
	public int getFinalTotalMarks() {
		return finalTotalMarks;
	}
	public void setFinalTotalMarks(int finalTotalMarks) {
		this.finalTotalMarks = finalTotalMarks;
	}
	public int getFinalRank() {
		return finalRank;
	}
	public void setFinalRank(int finalRank) {
		this.finalRank = finalRank;
	}
	
	
}
