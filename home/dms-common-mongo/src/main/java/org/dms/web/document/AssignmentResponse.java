package org.dms.web.document;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "assignmentresponse")
public class AssignmentResponse {

	@Id
	private String id;

	@DBRef
	private Assignment assignment;

	@Field(value = "responsedata")
	private byte[] responseData;

	@Field(value = "evalfirsttotal")
	private int evalFirstTotal;
	@DBRef
	private Users evalFirstExaminer;
	@Field(value = "evalfirstexaminercomment")
	private String evalFirstExaminerComment;
	@Field(value = "evalfirstexaminerfeedback")
	private String evalOneExamineeFeedback;

	@Field(value = "evalSecondtotal")
	private int evalSecondTotal;
	@DBRef
	private Users evalSecondExaminer;
	@Field(value = "evalsecondexaminercomment")
	private String evalSecondExaminerComment;
	@Field(value = "evalsecondexaminerfeedback")
	private String evalSecondExamineeFeedback;

	@Field(value = "evalthirdtotal")
	private int evalThirdTotal;
	@DBRef
	private Users evalThirdExaminer;
	@Field(value = "evalthirdexaminercomment")
	private String evalThirdExaminerComment;
	@Field(value = "evalthirdexaminerfeedback")
	private String evalThirdExamineeFeedback;

	@Field(value = "finaltotalmarks")
	private int finalTotalMarks;
	@Field(value = "finalrank")
	private int finalRank;

	public AssignmentResponse() {
		super();
	}
	
	@PersistenceConstructor
	public AssignmentResponse(Assignment assignment, byte[] responseData,
			int evalFirstTotal, Users evalFirstExaminer,
			String evalFirstExaminerComment, String evalOneExamineeFeedback,
			int evalSecondTotal, Users evalSecondExaminer,
			String evalSecondExaminerComment,
			String evalSecondExamineeFeedback, int evalThirdTotal,
			Users evalThirdExaminer, String evalThirdExaminerComment,
			String evalThirdExamineeFeedback, int finalTotalMarks, int finalRank) {
		super();
		this.assignment = assignment;
		this.responseData = responseData;
		this.evalFirstTotal = evalFirstTotal;
		this.evalFirstExaminer = evalFirstExaminer;
		this.evalFirstExaminerComment = evalFirstExaminerComment;
		this.evalOneExamineeFeedback = evalOneExamineeFeedback;
		this.evalSecondTotal = evalSecondTotal;
		this.evalSecondExaminer = evalSecondExaminer;
		this.evalSecondExaminerComment = evalSecondExaminerComment;
		this.evalSecondExamineeFeedback = evalSecondExamineeFeedback;
		this.evalThirdTotal = evalThirdTotal;
		this.evalThirdExaminer = evalThirdExaminer;
		this.evalThirdExaminerComment = evalThirdExaminerComment;
		this.evalThirdExamineeFeedback = evalThirdExamineeFeedback;
		this.finalTotalMarks = finalTotalMarks;
		this.finalRank = finalRank;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public byte[] getResponseData() {
		return responseData;
	}
	public void setResponseData(byte[] responseData) {
		this.responseData = responseData;
	}
	public int getEvalFirstTotal() {
		return evalFirstTotal;
	}
	public void setEvalFirstTotal(int evalFirstTotal) {
		this.evalFirstTotal = evalFirstTotal;
	}
	public Users getEvalFirstExaminer() {
		return evalFirstExaminer;
	}
	public void setEvalFirstExaminer(Users evalFirstExaminer) {
		this.evalFirstExaminer = evalFirstExaminer;
	}
	public String getEvalFirstExaminerComment() {
		return evalFirstExaminerComment;
	}
	public void setEvalFirstExaminerComment(String evalFirstExaminerComment) {
		this.evalFirstExaminerComment = evalFirstExaminerComment;
	}
	public String getEvalOneExamineeFeedback() {
		return evalOneExamineeFeedback;
	}
	public void setEvalOneExamineeFeedback(String evalOneExamineeFeedback) {
		this.evalOneExamineeFeedback = evalOneExamineeFeedback;
	}
	public int getEvalSecondTotal() {
		return evalSecondTotal;
	}
	public void setEvalSecondTotal(int evalSecondTotal) {
		this.evalSecondTotal = evalSecondTotal;
	}
	public Users getEvalSecondExaminer() {
		return evalSecondExaminer;
	}
	public void setEvalSecondExaminer(Users evalSecondExaminer) {
		this.evalSecondExaminer = evalSecondExaminer;
	}
	public String getEvalSecondExaminerComment() {
		return evalSecondExaminerComment;
	}
	public void setEvalSecondExaminerComment(String evalSecondExaminerComment) {
		this.evalSecondExaminerComment = evalSecondExaminerComment;
	}
	public String getEvalSecondExamineeFeedback() {
		return evalSecondExamineeFeedback;
	}
	public void setEvalSecondExamineeFeedback(String evalSecondExamineeFeedback) {
		this.evalSecondExamineeFeedback = evalSecondExamineeFeedback;
	}
	public int getEvalThirdTotal() {
		return evalThirdTotal;
	}
	public void setEvalThirdTotal(int evalThirdTotal) {
		this.evalThirdTotal = evalThirdTotal;
	}
	public Users getEvalThirdExaminer() {
		return evalThirdExaminer;
	}
	public void setEvalThirdExaminer(Users evalThirdExaminer) {
		this.evalThirdExaminer = evalThirdExaminer;
	}
	public String getEvalThirdExaminerComment() {
		return evalThirdExaminerComment;
	}
	public void setEvalThirdExaminerComment(String evalThirdExaminerComment) {
		this.evalThirdExaminerComment = evalThirdExaminerComment;
	}
	public String getEvalThirdExamineeFeedback() {
		return evalThirdExamineeFeedback;
	}
	public void setEvalThirdExamineeFeedback(String evalThirdExamineeFeedback) {
		this.evalThirdExamineeFeedback = evalThirdExamineeFeedback;
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
	
	@Override
	public String toString() {
		return "AssignmentResponse [id=" + id + ", assignment=" + assignment
				+ ", response data byte length=" + Arrays.toString(responseData).length()
				+ ", evalFirstTotal=" + evalFirstTotal + ", evalFirstExaminer="
				+ evalFirstExaminer + ", evalFirstExaminerComment="
				+ evalFirstExaminerComment + ", evalOneExamineeFeedback="
				+ evalOneExamineeFeedback + ", evalSecondTotal="
				+ evalSecondTotal + ", evalSecondExaminer="
				+ evalSecondExaminer + ", evalSecondExaminerComment="
				+ evalSecondExaminerComment + ", evalSecondExamineeFeedback="
				+ evalSecondExamineeFeedback + ", evalThirdTotal="
				+ evalThirdTotal + ", evalThirdExaminer=" + evalThirdExaminer
				+ ", evalThirdExaminerComment=" + evalThirdExaminerComment
				+ ", evalThirdExamineeFeedback=" + evalThirdExamineeFeedback
				+ ", finalTotalMarks=" + finalTotalMarks + ", finalRank="
				+ finalRank + "]";
	}
	

}
