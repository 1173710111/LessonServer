package com.neuedu.demo.domain;

public class StudentAnswer {
	private long id;
	private long studentId;
	private String studentAnswer;
	//0-unfinished 1-right 2-wrong
	private int finishedState;
	//0-unstared 1-stared
	private int starState;
	private long questionId;
	public StudentAnswer(long id, long questionId,long studentId, String studentAnswer, int finishedState, int starState) {
		super();
		this.id=id;
		this.questionId = questionId;
		this.studentId = studentId;
		this.studentAnswer = studentAnswer;
		this.finishedState = finishedState;
		this.starState = starState;
		
	}
	
	public long getId() {
		return id;
	}

	public int getFinishedState() {
		return finishedState;
	}
	public void setFinishedState(int finishedState) {
		this.finishedState = finishedState;
	}
	public int getStarState() {
		return starState;
	}
	public void setStarState(int starState) {
		this.starState = starState;
	}
	public long getStudentId() {
		return studentId;
	}
	public String getStudentAnswer() {
		return studentAnswer;
	}
	public long getQuestionId() {
		return questionId;
	}

	@Override
	public String toString() {
		return "StudentAnswer [id=" + id + ", studentId=" + studentId + ", studentAnswer=" + studentAnswer
				+ ", finishedState=" + finishedState + ", starState=" + starState + ", questionId=" + questionId + "]";
	}
	
	
	
}
