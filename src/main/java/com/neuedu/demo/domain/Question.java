package com.neuedu.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private long id;
	private long exampaperId;
	private String introduction;
	private String options;
	private String answer;
	private List<StudentAnswer> studentAnswers;
	public Question(long id, long exampaperId, String introduction, String options,
			String answer) {
		super();
		this.id = id;
		this.exampaperId = exampaperId;
		this.introduction = introduction;
		this.options = options;
		this.answer = answer;
		this.studentAnswers=new ArrayList<StudentAnswer>();
	}
	public long getId() {
		return id;
	}
	public long getLessonId() {
		return exampaperId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public String getOptions() {
		return options;
	}
	public String getAnswer() {
		return answer;
	}
	public void changeStudentAnswer(long studentId,StudentAnswer studentAnswer){
		for (int i=0;i<this.studentAnswers.size();i++){
			StudentAnswer stdAns=this.studentAnswers.get(i);
			if (stdAns.getStudentId()==studentAnswer.getStudentId()){
				this.studentAnswers.set(i, studentAnswer);
				break;
			}
		}
	}
	public StudentAnswer getStudentAnswerById(long studentId){
		StudentAnswer studentAnswer=null;
		for (int i=0;i<this.studentAnswers.size();i++){
			if (this.studentAnswers.get(i).getStudentId()==studentId){
				studentAnswer=this.studentAnswers.get(i);
				break;
			}
		}
		return studentAnswer;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", exampaperId=" + exampaperId + ", introduction=" + introduction + ", options="
				+ options + ", answer=" + answer + "]";
	}
	
}
